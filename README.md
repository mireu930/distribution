# 대규모 트래픽 처리에 대한 성능개선을 위한 프로젝트
- 조건: 100만건의 대규모 트래픽

<br>

##  ⚙️개발환경
- Frontend: React, Axios, React Router, Bootstrap
- Backend: Spring Boot, Spring MVC, Spring Security, Spring Data JPA
- API 설계: RESTful API, JSON 기반 통신
- DB: MySQL
- ORM: JPA
- 인증/인가: Spring Security, JWT 기반 인증
- 빌드 도구: Gradle

<br>

## 🔧성능개선
#### 1. MySQL 성능 최적화
 - 인덱스생성하여 성능향상된것 확인
<img width="1232" height="167" alt="image" src="https://github.com/user-attachments/assets/320eb36b-ca7a-4bf8-acda-c789f58b37aa" />

#### 2.Redis 데이터 처리 개선
- 캐싱처리를 Redis를 활용해 데이터를 Redis에서 조회하고 없으면 DB에서 가져와 Redis에 데이터를 저장, 재조회시 Redis에서 데이터를 조회하여 데이터 처리 개선
  <img width="1503" height="545" alt="image" src="https://github.com/user-attachments/assets/6b9c91fc-f52d-41c9-b8b1-a19bc5a3cc86" />
  
- Redis에 key-value 저장,
  단, redis데이터와 db의 업데이트 데이터가 일관성을 보장할 수 없어 ttl을 기능활용
  <img width="1380" height="309" alt="image" src="https://github.com/user-attachments/assets/d06491e2-744a-4eed-b585-4f0a69e8f5b4" />

#### 3.부하테스트
- 병목지점을 확인하고 쓰루풋을 올리고 레이턴시를 줄이기 위해 부하테스트를 진행한다(feat, k6)
부하테스트를 진행한 결과, 병목지점이 3TPS정도인걸 알수 있다. 그래서 시스템이중화를 통해 스루풋을 높여보기로 함
<img width="2840" height="1506" alt="image" src="https://github.com/user-attachments/assets/d3957e51-e415-4d09-90a8-863f2952304d" />

<br>
<br>
<br>

그러나 서버2개를 elb를 통해 이중화했지만 큰차이가 없는 것을 확인할수 있다. 그 이유를 cloudwatch를 통해 ec2,rds의 cpu와 메모리 사용량을 확인해보니 메모리 cpu사용량이 100퍼센트 가까이나는 것을 확인해보니 이 부분을 해결하면 쓰루풋을 높일수 있다고 생각
<img width="2830" height="1496" alt="image" src="https://github.com/user-attachments/assets/1f1bdb8f-b341-44cb-81bf-5ec4278cfaae" />
<img width="2862" height="814" alt="image" src="https://github.com/user-attachments/assets/0a1cb44e-8fd0-4b6a-a305-8c0b4fdf1980" />

<br>

그래서 db에 조회하려는 칼럼의 인덱스를 적용해주니 rds cpu사용량이 줄어들고, 쓰루풋도 10TPS가 되어 3배이상 가량 상승한것으로 확인된다.
<img width="2800" height="1384" alt="image" src="https://github.com/user-attachments/assets/ab9c322b-9f60-4b13-a38f-b98e230fc348" />
<img width="2850" height="602" alt="image" src="https://github.com/user-attachments/assets/22339a9c-0398-4de1-a5c1-6187b45fce9c" />
