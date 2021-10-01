import hashlib
import os
import re

import Exceptions


def checkDirectory(directory):
    return os.path.isdir(directory)


def validateBoolean(inputValue):
    if type(inputValue) is bool:
        return inputValue
    else:
        return inputValue.lower() in ['true', '1', 't', 'y', 'yes', 'yeah', 'yup',
                                  'certainly', 'uh-huh']

def validateURL(url):
    pattern = re.compile("((http|https)://)[a-zA-Z0-9@:%._\\+~#?&//=]{2,256}")
    return pattern.match(url)


def hasFileChanged(propertiesFile):
    newDigest = hashlib.md5(open(propertiesFile,'rb').read()).hexdigest()
    oldDigest = hashlib.md5(open(os.getcwd() + '/' + "application.properties", 'rb').read()).hexdigest()
    return newDigest == oldDigest


def validatePropertiesFile(rootPath):
    propertyFilePath = rootPath + "/src/main/resources/application.properties"
    if(os.path.isfile(propertyFilePath)):
        if(hasFileChanged(propertyFilePath)):
            print(f"{propertyFilePath} looks to have changed. Check once if all properties are being covered.")
    else:
        print(f"{propertyFilePath} doesn't seem to be valid. Recheck Root path.")
        raise Exceptions.InvalidInput(f"{propertyFilePath} doesn't seem to be valid. Recheck Root path.")