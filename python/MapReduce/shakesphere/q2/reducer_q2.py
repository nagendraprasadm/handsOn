import sys
finalCnt = 0
for line in sys.stdin:
    line = line.strip()
    finalCnt += int(line)
print(f'{finalCnt}')