moji = """
明日は何しようか。
pythonの勉強をしよう"""
print(moji)


# 文字列の長さを取得
moji = "python面白いね"
print(len(moji))


# ３つだけ文字列を入れ替える
b = "aaaaaaaaaaaaaaaa"
c = b.replace("a", "love", 3)
print(c)


# .formatの便利な使い方{0} に 変数1の値 、{1} に変数２の値 が割り当てられます。
sokudo = 30  # [km/h]
kyori = 120  # [km]
zikan = kyori / sokudo
ans = "{0}[km/h]で、{1}[km]を走るとすると、{2}[h]かかります。".format(sokudo, kyori, zikan)
print(ans)
