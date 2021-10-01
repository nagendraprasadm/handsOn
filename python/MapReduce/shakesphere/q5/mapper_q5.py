import sys
origcnt = {}
cnt = 0
for line in sys.stdin:
    if cnt == 0:
        cnt += 1
        continue
    else:
        line = line.strip()
        words = line.split(',')
        yr = words[1]
        if yr == '2004':
            origin = words[17]
            if origin in origcnt:
                origcnt[origin] = origcnt[origin] + 1
            else:
                origcnt[origin] = 1
for key,value in origcnt.items():
    print('%s\t%s' % (key,value))