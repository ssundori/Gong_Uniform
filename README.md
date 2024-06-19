# 공유니폼 사용 가이드

## 안드로이드 앱 사용법

### 1. APK 다운로드 및 설치
- `gonguiform.apk` 파일을 다운로드하여 안드로이드 기기에 설치합니다.

### 2. 앱 로그인
- 앱을 실행하고 다음 정보를 입력하여 로그인합니다:
  - **ID:** `kim@ewhain.net`
  - **Password:** `qwer1234`

### 3. 구단 선택
- 현재 작업 완료된 구단은 '두산'뿐입니다.
- 구단 선택 시 '두산'을 선택합니다.

### 4. 유니폼 선택 및 결제
- 아래의 순서로 선택합니다:
  1. `김재환`
  2. `밀리터리`
  3. `사이즈 L`
- `결제하기` 버튼을 클릭합니다.

## 추천 알고리즘 사용법

### 1. 파일 다운로드
- `선수 선호 설문조사.xlsx` 파일과 `유니폼_선호도_조사.xlsx` 파일을 다운로드합니다.

### 2. 구글 코랩 실행
- 구글 코랩에서 다음 알고리즘들을 실행합니다:
  - `유니폼 추천`
  - `설문기반_선수_추천`
  - `기록기반_선수_추천`

### 3. 파일 업로드 및 주소 복사
- Google Drive에 각 설문조사 파일을 업로드합니다.
- `df = pd.read_excel("/content/drive/MyDrive/설문조사.xlsx")`에 있는 주소창에 본인의 드라이브에 업로드 된 설문조사 파일 주소를 붙인다.
### 4. 선수 추천 알고리즘 실행
- 원하는 유저 번호를 `타겟 유저` input 입력하면 유사한 유저들을 결과로 출력합니다.
- 유저 번호는 알고리즘 진행 중  `df = df[df['팀'] == '두산 베어스']` 이후의 `df` 결과표에 있는 row 숫자입니다.
