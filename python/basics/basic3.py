# 文字列処理
hello = 'hello'  # シングルクォートか、
world = "world"  # ダブルクォートで文字列を表す

print(hello)  # => "hello"
print(world)


print(len(hello))  # 文字列の長さ;=> "5"
hw = hello + ' ' + world  # 文字列の結合
print(hw)  # => "hello world"


# 文字列の代入(C言語っぽく)
hw12 = '%s %s %d' % (hello, world, 12)  # 文字列の代入
print(hw12)  # => "hello world 12"

nihongo = u'日本語'  # 明示的にUnicode型を作るにはuをつける
print(nihongo)  # => '日本語'
