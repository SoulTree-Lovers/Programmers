# DATETIME에서 DATE로 형 변환

## 문제 설명
ANIMAL_INS 테이블은 동물 보호소에 들어온 동물의 정보를 담은 테이블입니다. ANIMAL_INS 테이블 구조는 다음과 같으며, ANIMAL_ID, ANIMAL_TYPE, DATETIME, INTAKE_CONDITION, NAME, SEX_UPON_INTAKE는 각각 동물의 아이디, 생물 종, 보호 시작일, 보호 시작 시 상태, 이름, 성별 및 중성화 여부를 나타냅니다.

| NAME             | TYPE        | NULLABLE |
|------------------|-------------|----------|
| ANIMAL_ID        | VARCHAR(N)  | FALSE    |
| ANIMAL_TYPE      | VARCHAR(N)  | FALSE    |
| DATETIME         | DATETIME    | FALSE    |
| INTAKE_CONDITION | VARCHAR(N)  | FALSE    |
| NAME             | VARCHAR(N)  | TRUE     |
| SEX_UPON_INTAKE  | VARCHAR(N)  | FALSE    |


## 문제
ANIMAL_INS 테이블에 등록된 모든 레코드에 대해, 
각 동물의 아이디와 이름, 들어온 날짜1를 조회하는 SQL문을 작성해주세요. 
이때 결과는 아이디 순으로 조회해야 합니다.


```oracle
SELECT animal_id, name, TO_CHAR(datetime, 'YYYY-MM-DD')
FROM animal_ins
ORDER BY animal_id
```