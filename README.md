# 모바일 프로그래밍 개인 과제
2022년 2학기 모바일 프로그래밍 수업 개인 과제 <br />
국민대학교 소프트웨어학부 20213091 최지원

## 애플리케이션 설명 (Introduction)
로그인, 회원가입, 상점 총 3개의 화면으로 구성된 안드로이드 애플리케이션입니다.<br/>
애플리케이션은 `Preferences`를 이용하여 데이터를 회원 정보를 저장합니다.<br/>
데이터 저장 경로는 `data/data/com.example.a2022_mop/shared_prefs`입니다.
1. 로그인 화면
    - 로그인 화면은 Relative Layout로 구성 되어있습니다.
    - 화면 초기화 시, `getSharedPreferences()`을 이용하여 기존 정보를 가져옵니다.
    - 아이디, 비밀번호를 모두 기입하지 않은 경우 경고 메시지를 담은 `Toast`가 화면에 출력됩니다.
    - 로그인 과정에서 내부 저장소에 저장된 아이디, 비밀번호와 일치하지 않은 경우 `Toast`가 화면에 출력됩니다.
    - '회원가입' 텍스트 클릭 시, 회원가입 화면으로 이동됩니다.
    - '비회원으로 로그인' 텍스트 클릭 시, 상점 페이지로 이동됩니다.

2. 회원가입 화면
    - 회원가입 시 아래 규칙을 모두 만족해야 합니다.
        1. 비밀번호: 최소 8자, 하나 이상의 문자, 하나의 숫자 및 하나의 특수 문자를 포함해야 합니다.<br>
        사용 정규식 - `"^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$"`
        2. 휴대전화: 010XXXXXXXX 의 형식으로 숫자만 기입해야 합니다.<br>
        사용 정규식 - `"01(?:0|1|[6-9])(?:\\d{3}|\\d{4})\\d{4}$"`
        3. 이름: 사용자의 이름에는 한글만 기입해야 합니다.<br>
        사용 정규식 - `"^[가-힣]+\$"`
    - 아이디 중복체크가 완료된 경우에만 회원 가입이 가능됩니다.
    - 개인 정보 수집에 동의한 경우만 회원 가입이 가능합니다.
    - 회원 가입이 정상적으로 동작된 경우, 로그인 화면으로 이동됩니다.

3. 상점 화면
    - 회원으로 로그인한 경우, 물품 등록하기 버튼이 활성화됩니다.
    - 비회원으로 로그인한 경우, 물품 등록하기 버튼이 비활성화됩니다.
    - '회원 정보 확인' 버튼 클릭 시, 회원이 경우에는 이름, 휴대전화 번호, 주소 정보를 보여주며 비회원의 경우, 회원가입을 유도하는 안내창이 출력됩니다.
    - '물품 등록하기' 버튼 클릭 시, '고양이의 선물'이라는 이름을 가진 아이템이 `View`에 추가됩니다.

## 개발 환경 (Development Environment)
- Android Studio: Dolphin | 2021.3.1 Patch 1
- VM: OpenJDK 64-Bit Server VM by JetBrains s.r.o.
- macOS: 12.6
- Visual Stuio Code: 1.67.0 (Universal)

## 애플리케이션 버전 (Application Version)
- `minSdkVersion` : 21
- `targetSdkVersion` : 32 

애플리케이션 실행에 필요한 최소 API level은 21 입니다.

## 설치 방법 & Gradle (Installation & Gradle)
### 설치 (Installation)
- Github Repository를 Clone한 뒤, Android Studio IDE에서 Run 'app' 버튼 클릭하여 실행이 가능합니다.

### 빌드 시 유의사항 (Gradle)

1. 뷰 결합(View Binding) 설정
    - 코드 작성에 `findViewById`를 대체하기 위하여 뷰 결합(View Binding)이 사용되었습니다.
    - 뷰 결합을 사용 설정하려면 아래와 같이 `viewBinding` 요소를 `build.gradle` 파일에 추가합니다.
    ```kotlin
    android {
            ...
            viewBinding {
                enabled = true
            }
        }
        
    ```
2. RecyclerView 라이브러리 추가
    - 코드 작성에 동적 목록 구현을 위해 RecyclerView 가 사용되었습니다.
    - 애플리케이션이나 모듈의 `build.gradle` 파일에 필요한 아티팩트의 종속 항목을 추가합니다.
    ```kotlin
    dependencies {
        implementation("androidx.recyclerview:recyclerview:1.2.1")
        // For control over item selection of both touch and mouse driven selection
        implementation("androidx.recyclerview:recyclerview-selection:1.1.0")
    }
    ```

## 스크린샷 (Screenshot)


