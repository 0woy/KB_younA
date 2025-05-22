# 여행 정보 관리 시스템

## 프로젝트 개요

이 프로젝트는 여행 정보를 관리하는 Java 기반의 애플리케이션입니다. 여행지 정보의 등록, 조회, 수정, 삭제 기능을 제공하며, CSV 파일을 통한 데이터 임포트 기능도 포함하고 있습니다.

## 프로젝트 구조

### 디렉토리 구조 및 역할

```
src/main/java/org/zowy/
├── app/          # 애플리케이션 메인 및 UI 관련
├── dao/          # 데이터 접근 객체
├── domain/       # 도메인 모델
├── service/      # 비즈니스 로직
├── DataImport/   # 데이터 임포트
└── DB/          # 데이터베이스 연결 관리
```

### 각 디렉토리 역할

1. **app 디렉토리**

   - 애플리케이션의 메인 클래스와 UI 관련 클래스들이 위치
   - 사용자 인터페이스 제공 및 사용자 입력 처리
   - 주요 클래스:
     - `TravelApp.java`: 애플리케이션의 메인 클래스
     - `MenuItem.java`: 메뉴 항목 정의

2. **dao 디렉토리**

   - 데이터베이스 접근을 담당하는 클래스들이 위치
   - 데이터베이스 CRUD 작업 수행
   - 주요 클래스:
     - `TravelDao.java`: 여행 정보 데이터 접근 인터페이스
     - `TravelDaoImpl.java`: 여행 정보 데이터 접근 구현체

3. **domain 디렉토리**

   - 비즈니스 엔티티를 표현하는 클래스들이 위치
   - 데이터베이스 테이블과 매핑되는 VO(Value Object) 클래스들 포함
   - 주요 클래스:
     - `TravelVO.java`: 여행 정보를 표현하는 VO 클래스
     - `TravelImgVO.java`: 여행 이미지 정보를 표현하는 VO 클래스

4. **service 디렉토리**

   - 비즈니스 로직을 처리하는 클래스들이 위치
   - 트랜잭션 관리 및 비즈니스 규칙 적용
   - 주요 클래스:
     - `TravelService.java`: 여행 정보 관련 서비스 인터페이스
     - `TravelServiceImpl.java`: 여행 정보 관련 서비스 구현체

5. **DataImport 디렉토리**

   - 외부 데이터(CSV 등) 임포트 관련 클래스들이 위치
   - 데이터 유효성 검증 및 변환 처리

6. **DB 디렉토리**
   - 데이터베이스 연결 및 설정 관련 클래스들이 위치
   - 데이터베이스 연결 풀 관리

## 주요 기능 흐름

### 1. 여행 정보 조회

```
1. 사용자 요청 → TravelApp
2. TravelApp → TravelService
3. TravelService → TravelDao
4. TravelDao → 데이터베이스
5. 데이터베이스 → TravelDao → TravelService → TravelApp → 사용자
```

### 2. 여행 정보 등록

```
1. 사용자 입력 → TravelApp
2. TravelApp → TravelService
3. TravelService (데이터 검증)
4. TravelService → TravelDao
5. TravelDao → 데이터베이스 저장
6. 결과 → TravelApp → 사용자
```

### 3. CSV 데이터 임포트

```
1. CSV 파일 선택 → TravelApp
2. TravelApp → DataImport
3. DataImport (데이터 파싱 및 검증)
4. DataImport → TravelService
5. TravelService → TravelDao
6. TravelDao → 데이터베이스 저장
7. 결과 → TravelApp → 사용자
```

## 기술 스택

- Java
- JDBC
- MySQL
- Gradle

## 데이터베이스

- 스키마 파일: `trevel.sql`
- 주요 테이블:
  - 여행 정보 테이블
  - 여행 이미지 테이블

## 실행 방법

1. 데이터베이스 설정

   ```sql
   source trevel.sql
   ```

2. 애플리케이션 실행
   ```bash
   ./gradlew run
   ```

## 주의사항

- 데이터베이스 연결 정보는 `DB/DBConnection.java`에서 확인 및 수정
- CSV 파일 임포트 시 데이터 형식 준수 필요
