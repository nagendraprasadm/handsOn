import sys
origcnt = {}
maxCnt = 0
maxOrigin = ''
for line in sys.stdin:
    line = line.strip()
    words = line.split('\t')
    origin = words[0]
    cnt = int(words[1])
    if origin in origcnt:
        origcnt[origin] += origcnt[origin] + cnt
    else:
        origcnt[origin] = cnt
    if origcnt[origin] > maxCnt:
        maxCnt = origcnt[origin]
        maxOrigin = origin

print('(%s\t%s)' % (maxOrigin, maxCnt))