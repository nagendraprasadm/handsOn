import Properties
import PropertiesFileHandler
import Validator
import Input


def main():
    input_properties = Input.PropertiesInput('input.properties')
    properties = Properties.Properties(input_properties.isAsync)
    properties.setRepoRoot(input_properties.repoRoot)
    properties.setEnviroment(input_properties.devEnv)
    properties.setOAuthURL(input_properties.oauthURL)
    properties.setMDSEnvironment(input_properties.mdsEnv)
    properties.setDeploymentID(input_properties.deploymentID)
    if properties.isAsync:
        properties.setBulkPath(input_properties.bulkPath)
        properties.setJDBCURL(input_properties.jdbcURL)
        properties.setDBPassword(input_properties.dbPassword)

    print(f"Properties which are going to be set - {properties}")
    Validator.validatePropertiesFile(properties.repoRoot + "/masterdata-service")
    PropertiesFileHandler.reset_properties(
        properties.repoRoot + "/masterdata-service/src/main/resources/application.properties",
        properties)


if __name__ == "__main__":
    main()
