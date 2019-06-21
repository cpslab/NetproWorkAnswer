# 文字列操作

s = "hello"

print(s.capitalize())  #=> "Hello"
print(s.upper())       #=> "HELLO"
print(s.upper().lower())       #=> "HELLO"->"hello"

print(s.rjust(7))      # 右寄せ;=> "  hello"
print(s.center(7))     # 中央寄せ;=> " hello "

print(s.replace('l', '(ell)'))  # 部分文字列の置換;=> "he(ell)(ell)o"
print('  world '.strip())  # 空白の削除;=> "world"
