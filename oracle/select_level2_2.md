# 3월에 태어난 여성 회원 목록 출력하기

## 문제 설명
다음은 식당 리뷰 사이트의 회원 정보를 담은 MEMBER_PROFILE 테이블입니다. MEMBER_PROFILE 테이블은 다음과 같으며 MEMBER_ID, MEMBER_NAME, TLNO, GENDER, DATE_OF_BIRTH는 회원 ID, 회원 이름, 회원 연락처, 성별, 생년월일을 의미합니다.

| Column name   | Type         | Nullable |
|---------------|--------------|----------|
| MEMBER_ID     | VARCHAR(100) | FALSE    |
| MEMBER_NAME   | VARCHAR(50)  | FALSE    |
| TLNO          | VARCHAR(50)  | TRUE     |
| GENDER        | VARCHAR(1)   | TRUE     |
| DATE_OF_BIRTH | DATE         | TRUE     |


동일한 날짜, 회원 ID, 상품 ID 조합에 대해서는 하나의 판매 데이터만 존재합니다.

## 문제
MEMBER_PROFILE 테이블에서 생일이 3월인 여성 회원의 ID, 이름, 성별, 생년월일을 조회하는 SQL문을 작성해주세요. 
이때 전화번호가 NULL인 경우는 출력대상에서 제외시켜 주시고, 
회원ID를 기준으로 오름차순 정렬해주세요.

``` oracle
SELECT member_id, member_name, gender, TO_CHAR(date_of_birth, 'YYYY-MM-DD')
FROM member_profile
WHERE gender = 'W' AND EXTRACT(MONTH FROM date_of_birth) = 3 AND tlno is not null
ORDER BY member_id
```
