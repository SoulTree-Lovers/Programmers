# 보호소에서 중성화한 동물

## 문제 설명
ANIMAL_INS 테이블은 동물 보호소에 들어온 동물의 정보를 담은 테이블입니다. ANIMAL_INS 테이블 구조는 다음과 같으며, ANIMAL_ID, ANIMAL_TYPE, DATETIME, INTAKE_CONDITION, NAME, SEX_UPON_INTAKE는 각각 동물의 아이디, 생물 종, 보호 시작일, 보호 시작 시 상태, 이름, 성별 및 중성화 여부를 나타냅니다.

NAME	| TYPE	| NULLABLE
-|-|-
ANIMAL_ID |	VARCHAR(N) |	FALSE
ANIMAL_TYPE |	VARCHAR(N) |	FALSE
DATETIME |	DATETIME |	FALSE
INTAKE_CONDITION |	VARCHAR(N) |	FALSE
NAME |	VARCHAR(N) |	TRUE
SEX_UPON_INTAKE |	VARCHAR(N) |	FALSE

ANIMAL_OUTS 테이블은 동물 보호소에서 입양 보낸 동물의 정보를 담은 테이블입니다. ANIMAL_OUTS 테이블 구조는 다음과 같으며, ANIMAL_ID, ANIMAL_TYPE, DATETIME, NAME, SEX_UPON_OUTCOME는 각각 동물의 아이디, 생물 종, 입양일, 이름, 성별 및 중성화 여부를 나타냅니다. ANIMAL_OUTS 테이블의 ANIMAL_ID는 ANIMAL_INS의 ANIMAL_ID의 외래 키입니다.

NAME |	TYPE|	NULLABLE
-|-|-
ANIMAL_ID|	VARCHAR(N)	|FALSE
ANIMAL_TYPE	|VARCHAR(N)|	FALSE
DATETIME	|DATETIME	|FALSE
NAME	|VARCHAR(N)	|TRUE
SEX_UPON_OUTCOME	|VARCHAR(N)|FALSE

## 문제
보호소에서 중성화 수술을 거친 동물 정보를 알아보려 합니다. 보호소에 들어올 당시에는 중성화1되지 않았지만, 보호소를 나갈 당시에는 중성화된 동물의 아이디와 생물 종, 이름을 조회하는 아이디 순으로 조회하는 SQL 문을 작성해주세요.
``` oracle
SELECT
    i.animal_id,
    i.animal_type,
    i.name
FROM 
    animal_ins i,
    animal_outs o
WHERE
    i.animal_id = o.animal_id
    AND i.sex_upon_intake LIKE 'Intact%'
    AND (o.sex_upon_outcome LIKE 'Spayed%'
        OR o.sex_upon_outcome LIKE 'Neutered%') 
ORDER BY
    i.animal_id
```
