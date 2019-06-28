def hello():
    print('hello, world')


hello()  # hello, world


# 引数付き

def greet(to):
    print('hello, ' + to)


greet('Alice')  # hello, Alice


# 足し算 (戻り値を返す)

def sum(num1, num2):
    return num1 + num2


print(sum(3, 4))  # 7

# 型が指定されていないので文字列連結にも使えてしまう！なんだが変な感じだが便利！

print(sum('hoge', 'fuga'))  # hogefuga


# 再帰を使ったフィボナッチ数列

def fib(n):
    if n <= 2:
        return 1

    return fib(n - 1) + fib(n - 2)


print(fib(4))  # 3


# yield を使ったフィボナッチ数列

# 難しいのでこんなのもあるよ程度に

def yield_fib(n):
    a = 1

    b = 1

    while a < n:
        yield a

        a, b = b, a + b


for i in yield_fib(4):
    print(i, end=", ")  # 1, 1, 2, 3
