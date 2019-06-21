# Loop と if
#
# for 変数 in データの集まり:
#     処理
#
# if 条件:
#     処理A
#     処理B
#     処理C


animals = ['cat', 'dog', 'monkey']
for animal in animals:
    print(animal)

# ↑改行が最後にいります。
#  => "cat", "dog", "monkey"


# ----
for char in 'Hello':
    print(char)


# ----
# 0以上5未満
for i in range(5):
    print(i)


# ----
# 6未満
for i in range(1, 6):
    print(i)


# ----
for i in range(1, 11):
    if i % 3 == 0:
        print(i)


# ----
strings = ['ruby', 'python', 'perl', 'java', 'c']

for string in strings:
    if string == 'python':
        print('OK')
        break  # 一致したので、breakで抜ける
    print(string)


# ----
scores = [100, 71, 80, 99, 75]  # 70点以下はないので、すべて合格

for score in scores:
    if score <= 70:
        break
    else:
        print('合格')


# --- while
index = 1
while index <= 5:
    print(index)
    index += 1
print("終了")


# --- while b
cnt = 0
while cnt < 10:
    print("繰り返しております！")
    print(cnt+1)
    cnt = cnt + 1
