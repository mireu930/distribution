# 대규모 트래픽 처리에 대한 성능개선을 위한 프로젝트
##  ⚙️개발환경
- Frontend: React, Axios, React Router, Bootstrap
- Backend: Spring Boot, Spring MVC, Spring Security, Spring Data JPA
- API 설계: RESTful API, JSON 기반 통신
- DB: MySQL
- ORM: JPA
- 인증/인가: Spring Security, JWT 기반 인증
- 빌드 도구: Gradle

<br>

## 🖥️실행화면

<br>

## 🔧성능개선
#### 1. MySQL 성능 최적화
 - 인덱스생성하여 성능향상된것 확인
<img width="1232" height="167" alt="image" src="https://github.com/user-attachments/assets/320eb36b-ca7a-4bf8-acda-c789f58b37aa" />

### 2.Redis 데이터 처리 개선
- 캐싱처리를 Redis를 활용해 데이터를 Redis에서 조회하고 없으면 DB에서 가져와 Redis에 데이터를 저장, 재조회시 Redis에서 데이터를 조회하여 데이터 처리 개선
  <img width="1503" height="545" alt="image" src="https://github.com/user-attachments/assets/6b9c91fc-f52d-41c9-b8b1-a19bc5a3cc86" />
  
- Redis에 key-value 저장,
  단, redis데이터와 db의 업데이트 데이터가 일관성을 보장할 수 없어 ttl을 기능활용
  <img width="1380" height="309" alt="image" src="https://github.com/user-attachments/assets/d06491e2-744a-4eed-b585-4f0a69e8f5b4" />


