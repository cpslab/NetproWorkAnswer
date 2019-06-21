import socket

with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as s:
    # サーバを指定
    s.connect(("localhost", 9999))
    # サーバにメッセージを送る
    s.sendall(b'hello')
    print('send')
