# GOAL: sort by increasing year first, THEN automaker
cars = {'Ford': 2005, 'BMW': 2005, 'Volvo': 2010}

# dict(sorted(dict.items(), key=lambda item: (item[0], item[1]), reverse=False))
sorted_cars = dict(sorted(cars.items(), key=lambda car: (car[1], car[0])))

print(sorted_cars)

# GOAL: sort by decreasing place, THEN name of the winner
winners = {'Alex': 3, 'Juan': 1, 'Dominic': 1, 'John': 4, 'Will': 2}


def sortByPlaceThenName(winner):
    return (winner[1], winner[0])


sorted_winners = dict(
    sorted(winners.items(), key=sortByPlaceThenName, reverse=True))

print(sorted_winners)
