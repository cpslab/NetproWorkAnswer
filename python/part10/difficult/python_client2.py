import socket
# print('start client')
#
#
# # create a socket object
# s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
#
#
# # get local machine name
# # host = socket.gethostname()
#
# host = "localhost"
# port = 9999
#
#
# # connection to hostname on the port.
# s.connect((host, port))
#
#
# # Receive no more than 1024 bytes
# msg = s.recv(1024)
#
# s.close()
#
# print(msg.decode('ascii'))

with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as s:
    # サーバを指定
    s.connect(("localhost", 9999))

    while True:
        # メッセージを入力
        message = str(input("メッセージを入力してください:"))
        # サーバにメッセージを送る
        s.sendall(bytes(message, encoding='utf-8', errors='replace'))
        # ネットワークのバッファサイズは1024。サーバからの文字列を取得する
        data = s.recv(1024)
        #
        print(data.decode('ascii'))
