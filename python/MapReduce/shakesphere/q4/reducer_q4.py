import sys
origdest = set()
cnt = 0
for line in sys.stdin:
    line = line.strip()
    origdest.add(line)
print(len(origdest))