# 入力

# 入力すべき行数を取得
print("何行か入力してください。")
num_lines = int(input())
print("入力を開始してください。")

# 1行ずつ取り出し
for i in range(num_lines):
    line = input()
    print(i + 1, "行目:" + line)


# 別解 6行をいっぺんに入力させる
# input_line = input()
# s = [input() for i in range(6)]
# print(s)
