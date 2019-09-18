# 웹 애플리케이션 서버
## 진행 방법
* 웹 애플리케이션 서버 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 우아한테크코스 코드리뷰
* [온라인 코드 리뷰 과정](https://github.com/woowacourse/woowacourse-docs/blob/master/maincourse/README.md)

## 1단계 - HTTP 웹 서버 구현
1. http://localhost:8080/index.html 로 접속했을 때 webapp 디렉토리의 index.html 파일을 읽어 클라이언트에 응답한다.
    - [x] Request Header 출력하기
    - [x] Header의 첫번째 라인에서 요청 URL 추출하기
    - [x] path에 해당하는 파일 읽어서 응답하기
2. "회원가입" 메뉴를 클릭하면 http://localhost:8080/user/form.html 으로 이동하면서 회원가입할 수 있다.
    - [ ] 요청 URL에서 접근 경로와 이름=값을 추출해 User 클래스에 담는다.
3. http://localhost:8080/user/form.html 파일의 form 태그 method를 get에서 post로 수정한 후 회원가입 기능이 정상적으로 동작하도록 구현한다.
    - [ ] Request Body에서 회원가입시 입력한 모든 데이터를 추출해 User 객체를 생성한다.
4. "회원가입"을 완료하면 /index.html 페이지로 이동한다.
    - [ ] HTTP 응답 헤더의 status code를 200이 아니라 302 code를 사용한다.
5. 지금까지 구현한 소스 코드는 stylesheet 파일을 지원하지 못하고 있다. Stylesheet 파일을 지원하도록 구현하도록 한다.
    - [ ] Stylesheet인 경우 응답 헤더의 Content-Type을 text/css로 전송한다.