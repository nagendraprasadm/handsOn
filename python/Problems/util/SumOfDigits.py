words = ['ROCK', 'FIRE', 'GHOST', 'PSYCHIC', 'WATER', 'FLYING', 'ROCK', 'FLYING',
         'POISON', 'STEEL', 'GROUND', 'POISON', 'GHOST', 'FAIRY', 'ROCK', 'FLYING',
         'PSYCHIC', 'DARK', 'DARK', 'FIGHTING', 'STEEL', 'WATER', 'POISON', 'BUG',
         'NORMAL', 'GHOST', 'DARK', 'GHOST', 'GHOST', 'DARK', 'NORMAL', 'ROCK', 'DRAGON',
         'FIGHTING', 'GHOST', 'DRAGON', 'NORMAL', 'WATER', 'GRASS', 'FAIRY', 'ELECTRIC',
         'FAIRY', 'BUG', 'GRASS', 'FLYING', 'STEEL', 'NORMAL', 'FIGHTING', 'FLYING',
         'GROUND', 'ELECTRIC', 'BUG', 'GRASS', 'DRAGON', 'WATER', 'NORMAL', 'GHOST',
         'FLYING', 'STEEL', 'ROCK', 'WATER', 'WATER', 'FAIRY', 'ELECTRIC', 'GRASS',
         'DARK', 'ELECTRIC', 'GHOST', 'PSYCHIC', 'STEEL', 'GROUND', 'PSYCHIC', 'WATER',
         'STEEL', 'STEEL', 'NORMAL', 'DARK', 'ROCK', 'FLYING', 'FIGHTING', 'DRAGON',
         'DARK', 'FLYING', 'GHOST', 'DRAGON', 'GHOST', 'GRASS', 'ICE', 'FAIRY', 'GRASS',
         'FIGHTING', 'DARK', 'GROUND', 'NORMAL', 'ELECTRIC', 'FLYING', 'FLYING',
         'FIGHTING', 'STEEL', 'GHOST', 'GHOST', 'DRAGON', 'GROUND', 'NORMAL', 'GHOST',
         'WATER', 'FLYING', 'ELECTRIC', 'GROUND', 'FIRE', 'GROUND', 'FIRE', 'WATER',
         'STEEL', 'ELECTRIC', 'STEEL', 'GROUND', 'GHOST', 'DARK', 'FIRE', 'ELECTRIC',
         'BUG', 'FAIRY', 'ROCK', 'GROUND', 'PSYCHIC', 'ELECTRIC', 'BUG', 'GHOST', 'ROCK',
         'POISON', 'GROUND', 'ROCK', 'FIRE', 'POISON', 'BUG', 'DRAGON', 'NORMAL',
         'POISON', 'FAIRY', 'DARK', 'DARK', 'ROCK', 'ELECTRIC', 'WATER', 'FIGHTING',
         'ICE', 'FLYING', 'PSYCHIC', 'FLYING', 'PSYCHIC', 'GHOST', 'NORMAL', 'GHOST',
         'GROUND', 'GRASS', 'ICE', 'WATER', 'ICE', 'GRASS', 'GRASS', 'GRASS', 'FIGHTING',
         'DARK', 'ELECTRIC', 'NORMAL', 'GHOST', 'FIGHTING', 'FIGHTING', 'STEEL', 'NORMAL',
         'ELECTRIC', 'STEEL', 'FAIRY', 'WATER', 'NORMAL', 'NORMAL', 'FIRE', 'BUG',
         'GHOST', 'ELECTRIC', 'WATER', 'DRAGON', 'POISON', 'GROUND', 'WATER', 'FIGHTING',
         'FIRE', 'ICE', 'POISON', 'ELECTRIC', 'FAIRY', 'DRAGON', 'GROUND', 'ICE', 'BUG',
         'ICE', 'GROUND', 'DRAGON']

dct = {}
for word in words:
    if word in dct:
        dct[word] = dct[word] + 1
    else:
        dct[word] = 1

print(dct)