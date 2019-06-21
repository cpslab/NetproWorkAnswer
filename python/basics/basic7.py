# Listのスライス
nums = range(5)                # rangeは整数範囲を作成する組み込み型関数です
print(nums)

nums = range(5, 10)            # 5, 6, 7, 8, 9
print(nums)

nums = range(0, 10, 3)         # 0, 3, 6, 9
print(nums)

nums = range(-10, -100, -30)   # -10, -40, -70
print(nums)

nums = range(1, 5, 1)
print(nums)

nums = range(5)
print(nums)


# 整数配列
nums = [0, 1, 2, 3, 4]

print(nums)         # => "[0, 1, 2, 3, 4]"
print(nums[2:4])    # インデックス2以上4未満;=> "[2, 3]"
print(nums[2:])     # インデックス2以上最後まで;=> "[2, 3, 4]"
print(nums[:2])     # 最初から2未満;=> "[0, 1]"
print(nums[:])      # 全要素;=> ["0, 1, 2, 3, 4]"
print(nums[:-1])    # 負のインデックスも可能;=> ["0, 1, 2, 3]"

moji = "ABCDEF"
print(moji[::2])    # 2 刻みで全て抽出


# indexを使おう
a = ["a", "b", "c", "d"]
print(a.index("b"))  # 1
print(a.index("d"))  # 3


# リストに値が存在するかどうか
a = ["a", "b", "c", "d"]
print("b" in a)  # True
print("f" in a)  # False


# 個数をカウント使用
a = ["a", "b", "c", "c", "b"]
print(a.count("c"))  # 2
print(a.count("g"))  # 0


# ソートする
a = [5, 2, 4, 3, 0, 1]
s = sorted(a)
print(s)  # [0, 1, 2, 3, 4, 5]
a = ["b", "g", "a", "d"]
s = sorted(a)
print(s)  # ['a', 'b', 'd', 'g']


# 降順ソート
a = [5, 2, 4, 3, 0, 1]
a.sort(reverse=True)
print(a)  # [5, 4, 3, 2, 1, 0]


# タプルをリストへ変換
a = ("takasi", "jun", "tomoki")
print(list(a))                  # ['takasi', 'jun', 'tomoki']
print(list((1, 2, 3, 4, 5)))    # [1, 2, 3, 4, 5]


# タプルアンパック
d = ("python", "Java", "c")
a, b, c = d
print(a)  # python
print(b)  # Java
print(c)  # c
