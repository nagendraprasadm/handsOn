import re


def comment(line, name, value, pattern):
    return '#' + line


def replace_part_url(line, name, value, pattern):
    newURL = re.sub(
        pattern, value, line)
    return newURL


def set_new_value(line, name, value, pattern):
    return name + '=' + str(value)


def do_nothing(line, name, value, pattern):
    return line
