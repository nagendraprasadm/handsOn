#!/usr/bin/python3
import os
import sys
import re

oauth_default = "https://svcscdev1mobile.sc1-lab1.ariba.com"
dev_default = "https://svcscdev3ss.sc1-lab1.ariba.com"
oauth_properties = ["mds.hana.oauth2.token.url", "security.oauth2.resource.userInfoUri",
                    "mds.test.oauth2.clientTokenUrl", "oauth2.forntDoorURL"]
to_be_commented_prpoperties = ["server.tomcat.accesslog.directory", "datadog.host", "datadog.ddallocid", "datadog.ddpodid",
                               "oauth2.clientId", "oauth2.privateSecret", "oauth2.publicSecret", "management.metrics.export.statsd.host"]
buyer_s4_url_propeties = ["buyer.base.url",
                          "s4.base.url", "mds.hana.buyer.url", "mds.hana.s4.url"]
mds_seach_url_property = "mds.hana.search.url"
mds_publish_url_property = "mds.hana.publish.url"
is_async_properties = ["spring.flyway.enabled",
                       "spring.flyway.baselineOnMigrate", "is.async.node"]
node_index = "node.alloc.index"
node_instance_count = "node.instance.count"
bulk_file_path = "batch.root.path"
deployment_id_property="mds.deployment.id"
is_dev_property="mds.is.dev"
db_pwd_property="datasource.password"
dev_services = {"scdev3" : "https://svcscdev3ss.sc1-lab1.ariba.com",
                "dev6" : "https://svcdev6ss.ariba.com",
                "dev8" : "https://svcdev8ss.ariba.com",
                "dev9" : "https://svcdev9ss.ariba.com",
                "dev10" : "https://svcdev10ss.ariba.com"}
hana_search_instances = {"gcpdev" : "https://ariba-mdsdev(pod)-mdsodatamdsdev(pod).mdsdev.lab-us.gcpint.ariba.com:443",
                         "lab1" : "https://ariba-mds(pod)-mdsodata(pod).mds.lab1.ariba.com:443",
                         "gcpperf" : "https://ariba-mdsperf(pod)-mdsodatamdsperf(pod).mdsperf.lab-us.gcpint.ariba.com:443",
                         "gcprel" : "https://ariba-mdsrel(pod)-mdsodatamdsrel(pod).mdsdev.lab-us.gcpint.ariba.com:443"}
hana_publish_instances = {"gcpdev" : "https://ariba-mdsdev(pod)-mdspublishmdsdev(pod).mdsdev.lab-us.gcpint.ariba.com:443",
                          "lab1" : "https://ariba-mds(pod)-mdspublish(pod).mds.lab1.ariba.com:443",
                          "gcpperf" : "https://ariba-mdsperf(pod)-mdspublishmdsperf(pod).mdsperf.lab-us.gcpint.ariba.com:443",
                          "gcprel" : "https://ariba-mdsrel(pod)-mdspublishmdsrel(pod).mdsdev.lab-us.gcpint.ariba.com:443"}

def validate_boolean(isAsync):
    if(isAsync.lower() in ['true', '1', 't', 'y', 'yes', 'yeah', 'yup', 'certainly', 'uh-huh']):
        print(isAsync + " is evaluated to true.")
        return True
    else:
        print(isAsync + " is evaluated to false.")
        return False


def validate_root(repoRoot):
    if(os.path.isdir(repoRoot)):
        print(repoRoot + ", directory exists.")
        return repoRoot
    else:
        print(repoRoot + ", directory doesn't exist. Check the path.")
        sys.exit(1)


def validate_dev(url):
    pattern = re.compile("((http|https)://)[a-zA-Z0-9@:%._\\+~#?&//=]{2,256}")
    if(pattern.match(url)):
        print("URL Pattern Matched.")
        return url
    else:
        print("URL Pattern didn't match.")
        return dev_default


def validate_search_url(url):
    pattern = re.compile("((http|https)://)[a-zA-Z0-9@:%._\\+~#?&//=]{2,256}")
    if(pattern.match(url)):
        print("URL Pattern Matched.")
        return url
    else:
        print("URL Pattern didn't match.")
        return "https://ariba-mds(pod)-mdsodata(pod).mds.lab1.ariba.com:443"


def validate_publish_url(url):
    pattern = re.compile("((http|https)://)[a-zA-Z0-9@:%._\\+~#?&//=]{2,256}")
    if(pattern.match(url)):
        print("URL Pattern Matched.")
        return url
    else:
        print("URL Pattern didn't match.")
        return "https://ariba-mds(pod)-mdspublish(pod).mds.lab1.ariba.com:443"


def validate_oauth(url):
    pattern = re.compile("((http|https)://)[a-zA-Z0-9@:%._\\+~#?&//=]{2,256}")
    if(pattern.match(url)):
        print("URL Pattern matched.")
        return url
    else:
        print("URL Pattern didn't match.")
        return oauth_default

def correct_properties(lines, mds_publish_url, mds_search_url, bulk_path, buyer_s4_base_url, oauth_url, isAsync, isDev, deploymentId):
    global mds_publish_url_property
    global mds_seach_url_property
    global bulk_file_path
    global buyer_s4_url_propeties
    global oauth_properties
    global node_index
    global node_instance_count
    global is_async_properties
    global to_be_commented_prpoperties
    global is_dev_property
    global deployment_id_property

    result = []
    for line in lines:
        splitItems = line.split("=")
        splitItems[0] = splitItems[0].strip()
        if(splitItems[0] == mds_publish_url_property):
            curLine = mds_publish_url_property + "=" + mds_publish_url + "\n"
            result.append(curLine)
        elif (splitItems[0] == mds_publish_url_property):
            curLine = mds_seach_url_property + "=" + mds_search_url + "\n"
            result.append(curLine)
        elif (splitItems[0] == bulk_file_path):
            curLine = bulk_file_path + "=" + bulk_path + "\n"
            result.append(curLine)
        elif(splitItems[0] == node_index):
            curLine = node_index + "=0\n"
            result.append(curLine)
        elif (splitItems[0] == node_instance_count):
            curLine = node_instance_count + "=1\n"
            result.append(curLine)
        elif(splitItems[0] in buyer_s4_url_propeties):
            curLine = re.sub(
                "((http|https)://)[a-zA-Z0-9@:%._\\+~#?&=\-]{2,256}(/)", buyer_s4_base_url + "/", line)
            result.append(curLine)
        elif(splitItems[0] in oauth_properties):
            curLine = re.sub(
                "((http|https)://)[a-zA-Z0-9@:%._\\+~#?&=\-]{2,256}(/)", oauth_url + "/", line)
            result.append(curLine)
        elif(splitItems[0] in is_async_properties):
            result.append(splitItems[0] + "=" +
                          ("true" if isAsync else "false") + "\n")
        elif(splitItems[0] in to_be_commented_prpoperties):
            result.append("#" + line)
        elif(splitItems[0] == is_dev_property):
            curLine = is_dev_property + "=" + ("true" if isDev else "false") + "\n"
            result.append(curLine)
        elif(splitItems[0] == deployment_id_property):
            curLine = deployment_id_property + "=" + deploymentId + "\n"
            result.append(curLine)
        else:
            if(not isAsync):
                if(splitItems[0] == db_pwd_property):
                    result.append("#" + line)
                else:
                    result.append(line)
            else:
                result.append(line)
    return result


def main():
    isAsync = validate_boolean(input("Is Async Node? "))
    repoRoot = validate_root(
        input("What is the Repository Root?  without ending /. "))
    print("\n\n")
    print("Is Dev Service to be used among the following : ")
    for k in dev_services:
        print(k)
    is_dev_service_in_list = validate_boolean(input("Is Dev Service to be used among the listed?"))
    devEnv = ""
    if(is_dev_service_in_list) :
        dev_env_input = input("Which Dev Environment in the list should be used?")
        if(dev_env_input not in dev_services):
            print("Given input is not in the dev services list.")
            devEnv = validate_dev(input(
                "Which Dev environment should be used? Give scheme://host, without ending /. "))
        else:
            devEnv = dev_services.get(dev_env_input)
    else:
        devEnv = validate_dev(input(
            "Which Dev environment should be used? Give scheme://host, without ending /. "))

    print("\n\n")
    oAuthEnv = validate_oauth(input(
        "Which OAuth environemnt to point to? Give scheme://host, without ending /. "))

    print("\n\n")
    print("Is MDS Search URL to be used among the following : ")
    for k in hana_search_instances:
        print(k)
    is_dev_service_in_list = validate_boolean(input("Is MDS Search URL to be used among the listed?"))
    mds_search_url = ""
    if(is_dev_service_in_list) :
        dev_env_input = input("Which MDS Search URL in the list should be used?")
        if(dev_env_input not in hana_search_instances):
            print("Given input is not in the MDS Search URLs list.")
            mds_search_url = validate_dev(input(
                "Which MDS Search URL should be used? Give scheme://host, without ending /. "))
        else:
            mds_search_url = hana_search_instances.get(dev_env_input)
    else:
        mds_search_url = validate_search_url(
            input("Which MDS Search URL should be used? without ending /. "))


    print("\n\n")
    print("Is MDS Publish URL to be used among the following : ")
    for k in hana_publish_instances:
        print(k)
    is_dev_service_in_list = validate_boolean(input("Is MDS Publish URL to be used among the listed?"))
    mds_publish_url = ""
    if(is_dev_service_in_list) :
        dev_env_input = input("Which MDS Publish URL in the list should be used?")
        if(dev_env_input not in hana_publish_instances):
            print("Given input is not in the MDS Publish URLs list.")
            mds_publish_url = validate_dev(input(
                "Which MDS Publish URL should be used? Give scheme://host, without ending /. "))
        else:
            mds_publish_url = hana_publish_instances.get(dev_env_input)
    else:
        mds_publish_url = validate_publish_url(
            input("Which MDS Publish URL should be used? without ending /. "))


    is_dev = validate_boolean(
        input("Is the deployment in Dev Mode? else will be considered production."))

    deploy_id=input("What is the deployment ID to be used?")
    bulk_path = ""
    if(isAsync):
        bulk_path = validate_root(
            input("Which directory should bulk put files to? without ending /. "))

    print("\n\n")
    print("***************************")
    print("Is Async Node - " + str(isAsync))
    print("Repoistory Root - " + str(repoRoot))
    print("Buyer and S4 URL prefix - " + str(devEnv))
    print("Oauth URL Prefix - " + str(oAuthEnv))
    print("MDS Publish URL - " + mds_publish_url)
    print("MDS Search URL - " + mds_search_url)
    print("Deployment ID - " + deploy_id)
    print("Is Dev Environment - " + str(is_dev))
    if(isAsync):
        print("Bulk Export Path - " + bulk_path)
    print("***************************")
    print("\n\n")


    shouldContinue = validate_boolean(
        input("Above values will be used for properties. Should Continue? "))
    if(shouldContinue == False):
        sys.exit(1)

    propertiesFile = repoRoot + \
                     "/masterdata-service/src/main/resources/application.properties"

    if(os.path.isfile(propertiesFile)):
        print("Properties file - " + propertiesFile + " exists.")
    else:
        print("Properties file - " + propertiesFile + " doesn't exist. exiting")
        sys.exit(1)

    print("\n\n")
    propFileopened = open(propertiesFile, 'r+')
    readLines = propFileopened.readlines()
    correct_props = correct_properties(
        readLines, mds_publish_url, mds_search_url, bulk_path, devEnv, oAuthEnv, isAsync, is_dev, deploy_id)
    propFileopened.close()
    newFile = open(propertiesFile + ".new", "w")
    newFile.writelines(correct_props)
    newFile.close()


if __name__ == "__main__":
    main()
