# 関数を作ろう

def hello():
    print('hello, world')

hello() # hello, world


# 引数付き
def greet(to):
    print('hello, ' + to)

greet('Alice')  # hello, Alice


# 足し算 (戻り値を返す)
def sum(num1, num2):
    return num1 + num2
print(sum(3, 4))  # 7

# 型が指定されていないので文字列連結にも使えてしまう！
print(sum('hoge', 'fuga'))  # hogefuga


# 再帰を使ったフィボナッチ数列
def fib(n):
    if n <= 2:
        return 1
    return fib(n - 1) + fib(n - 2)

print(fib(4))  # 3
print(fib(20)) # 6765


# yield を使ったフィボナッチ数列
# 難しいのでこんなのもあるよ程度に
def yield_fib(n):
    a = 1
    b = 1
    while a < n:
        yield a
        a, b = b, a + b


# ラムダ式
pairs = [(1, 'one'), (2, 'two'), (3, 'three'), (4, 'four')]
pairs.sort(key=lambda pair: pair[0])
print(pairs)
pairs.sort(key=lambda pair: pair[1])
print(pairs)
