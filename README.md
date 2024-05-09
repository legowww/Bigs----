# Bigs-BackEnd

## 1️⃣ 요청/응답
<details>
<summary>단기 예보를 DB에 저장하게 하는 API</summary>

**요청**
```
GET http://localhost:8080/api/v1/weather-forecasts?nx=62&ny=130&baseDate=20240507&baseTime=0500
```

**응답**
```
HTTP/1.1 201 
Location: http://localhost:8080/api/v1/weather-forecasts?nx=62&ny=130&baseDate=20240507&baseTime=0500
Content-Type: application/json

{
  "status": 201,
  "data": {
    "nx": 62,
    "ny": 130,
    "baseDate": "20240507",
    "baseTime": "0500"
  },
  "serverDateTime": "2024-05-07T14:46:37"
}
```
</details>
<details>
<summary>단기 예보를 조회 하는 API(DB존재)</summary>

**요청**
```
GET http://localhost:8080/api/v1/weather-forecasts?nx=62&ny=130&baseDate=20240507&baseTime=0500
```
**응답**
```
HTTP/1.1 200 
Content-Type: application/json

{
  "status": 200,
  "data": {
    "weatherForecast": {
      "weatherForecastIdentifier": {
        "nx": "62",
        "ny": "130",
        "baseDate": "20240507",
        "baseTime": "0500"
      },
      "weatherForecastContents": [
        {
          "fcstDate": "20240507",
          "fcstTime": "0600",
          "category": "TMP",
          "fcstValue": "13"
        },
        {
          "fcstDate": "20240507",
          "fcstTime": "0600",
          "category": "UUU",
          "fcstValue": "-1.1"
        },
        {
          "fcstDate": "20240507",
          "fcstTime": "0600",
          "category": "VVV",
          "fcstValue": "-0.3"
        }...
      ]
    }
  },
  "serverDateTime": "2024-05-07T14:49:27"
```
</details>
<details>
<summary>단기 예보를 조회 하는 API(DB미존재)</summary>

**요청**
```
GET http://localhost:8080/api/v1/weather-forecasts?nx=62&ny=130&baseDate=20240507&baseTime=0500
```
**응답**
```
HTTP/1.1 204

<Response body is empty>
```
</details>






## 2️⃣ ERD
![image](https://github.com/legowww/Bigs-BackEnd/assets/70372188/10b00e85-c5e6-4a4e-a1d6-8b8de8e665f3)

## 3️⃣ 모듈 구성
**모듈 관계**
- 모듈간 의존 방향은 단방향으로 설정하여 모듈 간 낮은 결합도를 유지하도록 했습니다. 
- 비지니스로직이 존재하는 domain 모듈은 항상 높은 의존성을 가지도록 구성했습니다.
- 의존하는 모듈의 라이브러리에 직접적으로 접근하지 못하도록 implementaion 키워드를 사용했습니다. 
<img width="823" alt="image" src="https://github.com/legowww/Bigs-BackEnd/assets/70372188/0b9ddb44-019b-4485-a070-f629f0d8e727">


**api**
- 클라이언트 요청/응답 수행
- 실행가능한 SpringApplication 존재 
- 필요한 모듈과 설정파일(yml) 선택

**domain**
- 도메인과 비지니스 로직 코드 존재
- 다른 모듈에 의존하지 않으며, 스프링 빈 등록과 트랜잭션 적용을 위한 최소한의 라이브러리만 사용
  - 데이터 액세스 모듈(stroage)의 코드에 의존하지 않으므로, DB 기술 변경에도 domain 모듈의 코드는 영향받지 않음

**open-api-client**
- 공공데이터 open-api와 HTTP 통신을 수행하는 클라이언트 모듈

**storage**
- JPA 라이브러리를 사용하여 DB에 읽기/쓰기를 수행하는 모듈

