def reset_properties(property_file_path, properties):
    prop_fileopen = open(property_file_path, 'r+')
    read_lines = prop_fileopen.readlines()
    values_functions = properties.getPropertiesToBeSet()
    values = values_functions[0]
    functions = values_functions[1]
    patterns = values_functions[2]
    result = []
    errors_present=False
    for line in read_lines:
        line = line.strip()
        split_items = line.split("=")
        try:
            if len(split_items) > 1:
                name = split_items[0].strip()
                if name in functions:
                    pattern = patterns[name] if name in patterns else ''
                    cur_value = values[name] if name in values else None
                    result.append(
                        functions[name](line, name, cur_value, pattern))
                elif name in values:
                    result.append(name + '=' + values[name])
                else:
                    result.append(line)
        except:
            errors_present=True
            print(f'Property being processed - {name}')
            print(f'Value being processed - {values.get(name, "Key Not Found")}')
            print(f'Function being processed - {functions.get(name, "Key Not Found")}')

    #print(f'Modified Properties -\n {result}')
    if not errors_present:
        prop_fileopen_new = open(property_file_path + ".new", 'w')
        for line in result:
            prop_fileopen_new.write(line + '\n')
        prop_fileopen_new.close()

    prop_fileopen.close()
