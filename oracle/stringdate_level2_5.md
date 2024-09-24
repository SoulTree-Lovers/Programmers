# 중성화 여부 파악하기

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
보호소의 동물이 중성화되었는지 아닌지 파악하려 합니다. 
중성화된 동물은 SEX_UPON_INTAKE 컬럼에 'Neutered' 또는 'Spayed'라는 단어가 들어있습니다. 
동물의 아이디와 이름, 중성화 여부를 아이디 순으로 조회하는 SQL문을 작성해주세요.
이때 중성화가 되어있다면 'O', 아니라면 'X'라고 표시해주세요.



```oracle
SELECT animal_id, name,
       CASE WHEN instr(sex_upon_intake, 'Neutered') > 0 THEN 'O'
            WHEN instr(sex_upon_intake, 'Spayed') > 0 THEN 'O'
            ELSE 'X'
           END as 중성화
FROM animal_ins
ORDER BY animal_id
```
