import requests  # install したのに赤い表示が発生する人はinstall packegeをクリックする

r = requests.get('https://google.com')  # google.com にGET リクエストをし、結果を受け取る

print(r.status_code)  # 200

print(r.text)  # HTML データ
