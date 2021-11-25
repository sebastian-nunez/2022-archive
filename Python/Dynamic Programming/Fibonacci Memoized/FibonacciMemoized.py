def fib(n, memo=dict()):
    if n in memo:
        return memo[n]

    if n == 1 or n == 2:
        return 1

    memo[n] = fib(n - 1) + fib(n - 2)

    return memo[n]


print(fib(50))
