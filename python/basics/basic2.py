# 数値計算
x = 3
y = 4.5

print(x)
print(x + 1)  # 加算
print(x - 1)  # 減算
print(x * 2)  # 乗算
print(x ** 2)  # 冪乗 x^2
print(x + y)

print((3 + 2j) - (6 + 4j))  # 虚数


# 型の変更
print(type(x))
print(type(y))

t = True
f = False

x = t

print(type(x))
print(type(t))  # => "<type 'bool'>"
print(t and f)  # 論理積; "False"
print(t or f)  # 論理和; "True"
print(not t)  # 否定; "False"
print(t != f)  # 排他的論理和; "True"
