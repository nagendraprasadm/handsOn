import Validator
import Exceptions
import ModifierFunctions


class Properties:

    def __init__(self, isAsync):
        self.setIsAsync(isAsync)
        self.mdsEnvironment = ""
        self.searchURL = ""
        self.publishURL = ""
        self.buyerURL = ""
        self.sourcingURL = ""
        self.bulkPath = ""
        self.isDevEnvironment = True
        self.devEnvironment = ""
        self.oauthURL = ""
        self.deploymentID = ""
        self.repoRoot = ""
        self.dbPassword = ""
        self.jdbcURL = ""
        self.nodeAllocIndex = 0
        self.nodeInstanceCount = 1
        self.urlPatternSchemaHostPort = "((http|https)://)[a-zA-Z0-9@:%._\\+~#?&=\-\(\)]{2,256}[\:0-9]{0,10}"

    dev_services = {"scdev3": "https://svcscdev3ss.sc1-lab1.ariba.com",
                    "dev6": "https://svcdev6ss.ariba.com",
                    "dev8": "https://svcdev8ss.ariba.com",
                    "dev9": "https://svcdev9ss.ariba.com",
                    "dev10": "https://svcdev10ss.ariba.com"}
    oauth_default = "https://svcscdev1mobile.sc1-lab1.ariba.com"
    hana_search_instances = {
        "gcpdev": "https://ariba-mdsdev(pod)-mdsodatamdsdev(pod).mdsdev.lab-us.gcpint.ariba.com:443",
        "lab1": "https://ariba-mds(pod)-mdsodata(pod).mds.lab1.ariba.com:443",
        "gcpperf": "https://ariba-mdsperf(pod)-mdsodatamdsperf(pod).mdsperf.lab-us.gcpint.ariba.com:443",
        "gcprel": "https://ariba-mdsrel(pod)-mdsodatamdsrel(pod).mdsdev.lab-us.gcpint.ariba.com:443"}
    hana_publish_instances = {
        "gcpdev": "https://ariba-mdsdev(pod)-mdspublishmdsdev(pod).mdsdev.lab-us.gcpint.ariba.com:443",
        "lab1": "https://ariba-mds(pod)-mdspublish(pod).mds.lab1.ariba.com:443",
        "gcpperf": "https://ariba-mdsperf(pod)-mdspublishmdsperf(pod).mdsperf.lab-us.gcpint.ariba.com:443",
        "gcprel": "https://ariba-mdsrel(pod)-mdspublishmdsrel(pod).mdsdev.lab-us.gcpint.ariba.com:443"}

    def setMDSEnvironment(self, mdsEnvironment):
        if (
                mdsEnvironment in self.hana_publish_instances.keys()
                and mdsEnvironment in self.hana_search_instances.keys()):
            self.publishURL = self.hana_publish_instances.get(mdsEnvironment)
            self.searchURL = self.hana_search_instances.get(mdsEnvironment)
        else:
            print(
                f"MDS environment provided - {mdsEnvironment}, doesn't seem to be "
                f"configured in registered instances in Properties.py. If correct add "
                f"it to existing instances. ")
            raise Exceptions.InvalidInput(
                f"MDS environment provided - {mdsEnvironment}, doesn't seem to be "
                f"configured in registered instances in Properties.py. If correct add "
                f"it to existing instances. ")

    def setEnviroment(self, devEnvironment):
        if devEnvironment in self.dev_services.keys():
            self.devEnvironment = devEnvironment
            self.buyerURL = self.dev_services.get(devEnvironment) + "/Buyer/Main"
            self.sourcingURL = self.dev_services.get(devEnvironment) + "/Sourcing/Main"
        else:
            print(
                f"Given Environment - {devEnvironment} not found in the system. Add it "
                f"to the Properties.py file if valid")
            raise Exceptions.InvalidInput(
                f"Given Environment - {devEnvironment} not found in the system. Add it "
                f"to the Properties.py file if valid")

    def setIsDev(self, isDev):
        self.isDevEnvironment = Validator.validateBoolean(isDev)

    def isProd(self):
        return self.isDevEnvironment == False

    def setBulkPath(self, bulkPath):
        if Validator.checkDirectory(bulkPath):
            self.bulkPath = bulkPath
        else:
            print(f"Bulk Path - {bulkPath}, provided doesn't exist.")
            raise Exceptions.InvalidInput(
                f"Bulk Path - {bulkPath}, provided doesn't exist.")

    def setOAuthURL(self, oauthURL):
        if not oauthURL:
            self.oauthURL = self.oauth_default
            return

        if Validator.validateURL(oauthURL):
            self.oauthURL = oauthURL
        else:
            print(f"Input OAuthURL - {oauthURL} is not valid")
            raise Exceptions.InvalidInput(f"Input OAuthURL - {oauthURL} is not valid")

    def setIsAsync(self, isAsync):
        self.isAsync = Validator.validateBoolean(isAsync)

    def setDeploymentID(self, deploymentid):
        self.deploymentID = deploymentid

    def setJDBCURL(self, jdbcURL):
        self.jdbcURL = jdbcURL

    def setDBPassword(self, dbPassword):
        self.dbPassword = dbPassword

    def setRepoRoot(self, repoRoot):
        if (Validator.checkDirectory(repoRoot)):
            self.repoRoot = repoRoot
        else:
            print(f"Give Repo Root - {repoRoot} doesn't exist.")
            raise Exceptions.InvalidInput(f"Give Repo Root - {repoRoot} doesn't exist.")

    def getPropertiesToBeSet(self):
        propertiesWithValues = {}
        propertiesWithFunctions = {}
        propetiesWithPatterns = {}

        propertiesWithValues["mds.hana.publish.url"] = self.publishURL
        propertiesWithValues["mds.hana.search.url"] = self.searchURL
        propertiesWithValues["batch.root.path"] = self.bulkPath
        propertiesWithValues["mds.deployment.id"] = self.deploymentID
        propertiesWithValues["mds.is.dev"] = (
            "true" if self.isDevEnvironment else "false")
        propertiesWithValues["spring.flyway.enabled"] = (
            "true" if self.isAsync else "false")
        propertiesWithValues["spring.flyway.baselineOnMigrate"] = (
            "true" if self.isAsync else "false")
        propertiesWithValues["is.async.node"] = ("true" if self.isAsync else "false")
        propertiesWithValues["node.alloc.index"] = str(self.nodeAllocIndex)
        propertiesWithValues["node.instance.count"] = str(self.nodeInstanceCount)
        propertiesWithValues["mds.deployment.id"] = self.deploymentID
        propertiesWithValues["buyer.base.url"] = self.dev_services.get(self.devEnvironment)
        propertiesWithValues["s4.base.url"] = self.dev_services.get(self.devEnvironment)
        propertiesWithValues["mds.hana.buyer.url"] = self.dev_services.get(self.devEnvironment)
        propertiesWithValues["mds.hana.s4.url"] = self.dev_services.get(self.devEnvironment)
        propertiesWithValues["mds.hana.oauth2.token.url"] = self.oauthURL;
        propertiesWithValues["security.oauth2.resource.userInfoUri"] = self.oauthURL;
        propertiesWithValues["mds.test.oauth2.clientTokenUrl"] = self.oauthURL;
        propertiesWithValues["oauth2.forntDoorURL"] = self.oauthURL;

        if self.isAsync:
            propertiesWithValues["datasource.jdbc.url"] = self.jdbcURL
            propertiesWithValues["datasource.password"] = self.dbPassword

        propertiesWithFunctions["inspector.datasource.password"] = ModifierFunctions.comment
        propertiesWithFunctions[
            "server.tomcat.accesslog.directory"] = ModifierFunctions.comment
        propertiesWithFunctions["datadog.host"] = ModifierFunctions.comment
        propertiesWithFunctions["datadog.ddallocid"] = ModifierFunctions.comment
        propertiesWithFunctions["datadog.ddpodid"] = ModifierFunctions.comment
        propertiesWithFunctions["oauth2.clientId"] = ModifierFunctions.comment
        propertiesWithFunctions["oauth2.privateSecret"] = ModifierFunctions.comment
        propertiesWithFunctions["oauth2.publicSecret"] = ModifierFunctions.comment
        propertiesWithFunctions[
            "management.metrics.export.statsd.host"] = ModifierFunctions.comment
        propertiesWithFunctions[
            "mds.hana.publish.url"] = ModifierFunctions.replace_part_url
        propertiesWithFunctions[
            "mds.hana.search.url"] = ModifierFunctions.replace_part_url
        propertiesWithFunctions["buyer.base.url"] = ModifierFunctions.replace_part_url
        propertiesWithFunctions["s4.base.url"] = ModifierFunctions.replace_part_url
        propertiesWithFunctions["mds.hana.buyer.url"] = ModifierFunctions.replace_part_url
        propertiesWithFunctions["mds.hana.s4.url"] = ModifierFunctions.replace_part_url
        propertiesWithFunctions[
            "mds.hana.oauth2.token.url"] = ModifierFunctions.replace_part_url
        propertiesWithFunctions[
            "security.oauth2.resource.userInfoUri"] = ModifierFunctions.replace_part_url
        propertiesWithFunctions[
            "mds.test.oauth2.clientTokenUrl"] = ModifierFunctions.replace_part_url
        propertiesWithFunctions[
            "oauth2.forntDoorURL"] = ModifierFunctions.replace_part_url

        if not self.isAsync:
            propertiesWithFunctions["datasource.password"] = ModifierFunctions.comment

        propetiesWithPatterns["mds.hana.publish.url"] = self.urlPatternSchemaHostPort
        propetiesWithPatterns["mds.hana.search.url"] = self.urlPatternSchemaHostPort
        propetiesWithPatterns["buyer.base.url"] = self.urlPatternSchemaHostPort
        propetiesWithPatterns["s4.base.url"] = self.urlPatternSchemaHostPort
        propetiesWithPatterns["mds.hana.buyer.url"] = self.urlPatternSchemaHostPort
        propetiesWithPatterns["mds.hana.s4.url"] = self.urlPatternSchemaHostPort
        propetiesWithPatterns["mds.hana.oauth2.token.url"] = self.urlPatternSchemaHostPort
        propetiesWithPatterns[
            "security.oauth2.resource.userInfoUri"] = self.urlPatternSchemaHostPort
        propetiesWithPatterns[
            "mds.test.oauth2.clientTokenUrl"] = self.urlPatternSchemaHostPort
        propetiesWithPatterns["oauth2.forntDoorURL"] = self.urlPatternSchemaHostPort

        return propertiesWithValues, propertiesWithFunctions, propetiesWithPatterns

    def __str__(self) -> str:
        return f"\n\n*****\n is Async - {self.isAsync} \n " \
               f"Buyer - {self.buyerURL} \n " \
               f"sourcing - {self.sourcingURL} \n " \
               f"Search URL - {self.searchURL} \n " \
               f"Publish URL - {self.publishURL} \n " \
               f"Dev Mode - {self.isDevEnvironment} \n " \
               f"Deployment ID - {self.deploymentID} \n " \
               f"Bulk Root Path - {self.bulkPath} \n " \
               f"OAuth URL - {self.oauthURL} \n*****\n\n"
