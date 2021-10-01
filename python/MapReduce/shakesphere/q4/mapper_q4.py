import sys
origdest = set()
cnt = 0
for line in sys.stdin:
    if cnt == 0:
        cnt += 1
        continue
    else:
        line = line.strip()
        words = line.split(',')
        origin = words[17]
        dest = words[18]
        key = origin + '-' + dest
        origdest.add(key)
for keys in origdest:
    print('%s' % (keys))