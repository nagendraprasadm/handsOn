import Validator
import os

class PropertiesInput:
    def __init__(self, inputFile):
            cwd = os.getcwd()
            inputOpened = open(cwd + '/' + inputFile, "r+")
            readLines = inputOpened.readlines()

            for line in readLines:
                lineSplit = line.split('=')
                key = lineSplit[0].strip()
                value = lineSplit[1].strip()
                if key == 'is.async':
                    self.isAsync = Validator.validateBoolean(value)
                elif key == 'dev.environment':
                    self.devEnv = value
                elif key == 'mds.environment':
                    self.mdsEnv = value
                elif key == 'is.dev':
                    self.isDev = Validator.validateBoolean(value)
                elif key == 'deployment.id':
                    self.deploymentID = value
                elif key == 'db.password':
                    self.dbPassword = value
                elif key == 'bulk.path':
                    self.bulkPath = value
                elif key == 'repo.root':
                    self.repoRoot = value
                elif key == 'oauth.url':
                    self.oauthURL = value
                elif key == 'jdbc.url':
                    self.jdbcURL = value



