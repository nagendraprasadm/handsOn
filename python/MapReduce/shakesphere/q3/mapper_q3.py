import sys
maxLen = 0
maxLenWord = ''
for line in sys.stdin:
    line = line.strip()
    words = line.split()
    for word in words:
        if len(word) > maxLen:
            maxLen = len(word)
            maxLenWord = word

print('%s' % (maxLenWord))
