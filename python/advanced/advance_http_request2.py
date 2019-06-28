import requests

url = 'https://httpbin.org'


# このPCから送られたhttpヘッダを確認してみよう

def get_http_header():
    path = 'headers'

    r = requests.get(url + '/' + path)

    print(r.status_code)  # 200

    # レスポンスがjson形式で返ってくるので、dict型として受け取れる。

    print(type(r.json()))  # dict

    print(r.text)


# 名前とパスワードを送ってみよう

def post_data():
    path = 'post'

    data = {  # リクエストボディ

        'username': 'netpro tarou',

        'password': 'netpro1234'

    }

    r = requests.post(url + '/' + path, data=data)

    print(r.status_code)  # 200

    print(type(r.json()))  # dict

    print(r.text)


if __name__ == '__main__':
    get_http_header()

    # post_data()  # コメントを外して実行してみよう
