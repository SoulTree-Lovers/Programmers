# 대여 횟수가 많은 자동차들의 월별 대여 횟수 구하기

## 문제 설명
다음은 어느 자동차 대여 회사의 자동차 대여 기록 정보를 담은 CAR_RENTAL_COMPANY_RENTAL_HISTORY 테이블입니다. CAR_RENTAL_COMPANY_RENTAL_HISTORY 테이블은 아래와 같은 구조로 되어있으며, HISTORY_ID, CAR_ID, START_DATE, END_DATE 는 각각 자동차 대여 기록 ID, 자동차 ID, 대여 시작일, 대여 종료일을 나타냅니다.

Column name	| Type	     | Nullable
--|-----------| --
HISTORY_ID | 	INTEGER	 | FALSE
CAR_ID| 	INTEGER  |	FALSE
START_DATE| 	DATE     |	FALSE
END_DATE| 	DATE     |	FALSE

상품 별로 중복되지 않는 8자리 상품코드 값을 가지며, 앞 2자리는 카테고리 코드를 의미합니다.

## 문제
CAR_RENTAL_COMPANY_RENTAL_HISTORY 테이블에서 대여 시작일을 기준으로 2022년 8월부터 2022년 10월까지 총 대여 횟수가 5회 이상인 자동차들에 대해서 해당 기간 동안의 월별 자동차 ID 별 총 대여 횟수(컬럼명: RECORDS) 리스트를 출력하는 SQL문을 작성해주세요. 결과는 월을 기준으로 오름차순 정렬하고, 월이 같다면 자동차 ID를 기준으로 내림차순 정렬해주세요. 특정 월의 총 대여 횟수가 0인 경우에는 결과에서 제외해주세요.



```oracle
WITH car_rental_counts AS (
    SELECT
        car_id,
        COUNT(*) AS total_rentals
    FROM
        CAR_RENTAL_COMPANY_RENTAL_HISTORY
    WHERE
        start_date BETWEEN DATE '2022-08-01' AND DATE '2022-10-31'
    GROUP BY
        car_id
    HAVING
        COUNT(*) >= 5
)
SELECT
    TO_NUMBER(TO_CHAR(a.start_date, 'MM')) AS month,
    a.car_id,
    COUNT(*) AS records
FROM
    CAR_RENTAL_COMPANY_RENTAL_HISTORY a
        JOIN
    car_rental_counts b ON a.car_id = b.car_id
WHERE
    start_date BETWEEN DATE '2022-08-01' AND DATE '2022-10-31'
GROUP BY
    TO_CHAR(a.start_date, 'MM'), a.car_id
ORDER BY
    month, a.car_id DESC
```