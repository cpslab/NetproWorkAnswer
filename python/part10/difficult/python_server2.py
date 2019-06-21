import socket
# print('start server')
#
#
# # create a socket object
# serversocket = socket.socket(
#     socket.AF_INET, socket.SOCK_STREAM)
#
#
# # get local machine name
# # host = socket.gethostname()
#
# host = "localhost"
# count=0
# port = 9999
#
#
# # bind to the port
# serversocket.bind((host, port))
#
#
# # queue up to 5 requests
# serversocket.listen(5)
# print('waiting connection...')
#
#
# while True:
#
#     # establish a connection
#     clientsocket, addr = serversocket.accept()
#
#     print("Got a connection from %s" % str(addr))
#
#     count+=1
#     msg = 'Thank you for connecting'+str(count) + "\r\n"
#     clientsocket.send(msg.encode('ascii'))
#
#     clientsocket.close()


# AF = IPv4 という意味
# TCP/IP の場合は、SOCK_STREAM を使う
with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as s:
    # IPアドレスとポートを指定
    s.bind(("localhost", 9999))
    # 1 接続
    s.listen(1)
    # connection するまで待つ
    while True:
        # 誰かがアクセスしてきたら、コネクションとアドレスを入れる
        conn, addr = s.accept()
        with conn:
            while True:
                # データを受け取る
                data = conn.recv(1024)
                if not data:
                    break
                print('data : {}, addr: {}'.format(data, addr))
                # クライアントにデータを返す(b -> byte でないといけない)
                conn.sendall(b'Received: ' + data.upper())
