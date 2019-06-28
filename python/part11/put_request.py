#
#   1.
#   putリクエストを送る put_data 関数を実装せよ。(putはリソースの更新です。)
#
#   2.
#   作成したputリクエストにbodyを付与して送信し、レスポンスに送ったデータが記載されているか確認せよ。
#   この時点での実行結果をテキストファイル(.txt)で提出すること
#
#   3.
#   putリクエストにヘッダーを付与して送信し、レスポンスに送ったデータが記載されているか確認せよ。
#   この時点での実行結果をテキストファイル(.txt)で提出すること
#       ヒント: request.put(url, headers=hoge) のようにヘッダーを指定できる。hogeはdict型。
#

import requests

url = 'https://httpbin.org'


def put_data():
    path = 'put'

    body = {  # ボディ

        'username': 'network program assistant',

        'password': 'assistant_at_cps'

    }

    head = {  # ヘッダー
        'message': 'put request test'
    }

    r = requests.put(url + '/' + path, data=body, headers=head)

    print(r.status_code)  # 200

    print(type(r.json()))  # dict

    print(r.text)


if __name__ == '__main__':
    put_data()
