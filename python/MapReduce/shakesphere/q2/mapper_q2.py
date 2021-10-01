import sys
cnt = 0
for line in sys.stdin:
    line = line.strip()
    words = line.split()
    for word in words:
        if word.lower() == 'Romeo'.lower():
            cnt += 1
print(f'{cnt}')