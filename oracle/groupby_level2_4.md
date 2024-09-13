# 가격대 별 상품 개수 구하기

## 문제 설명
다음은 어느 의류 쇼핑몰에서 판매중인 상품들의 정보를 담은 PRODUCT 테이블입니다. PRODUCT 테이블은 아래와 같은 구조로 되어있으며, PRODUCT_ID, PRODUCT_CODE, PRICE는 각각 상품 ID, 상품코드, 판매가를 나타냅니다.

| Column name   | Type       | Nullable |
|---------------|------------|----------|
| PRODUCT_ID    | INTEGER    | FALSE    |
| PRODUCT_CODE  | VARCHAR(8) | FALSE    |
| PRICE         | INTEGER    | FALSE    |


상품 별로 중복되지 않는 8자리 상품코드 값을 가지며 앞 2자리는 카테고리 코드를 나타냅니다.

## 문제
PRODUCT 테이블에서 만원 단위의 가격대 별로 상품 개수를 출력하는 SQL 문을 작성해주세요. 
이때 컬럼명은 각각 컬럼명은 PRICE_GROUP, PRODUCTS로 지정해주시고 가격대 정보는 각 구간의 최소금액(10,000원 이상 ~ 20,000 미만인 구간인 경우 10,000)으로 표시해주세요. 
결과는 가격대를 기준으로 오름차순 정렬해주세요.
```oracle
SELECT CASE
           WHEN price >= 0 AND price < 10000 THEN '0'
           WHEN price >= 10000 AND price < 20000 THEN '10000'
           WHEN price >= 20000 AND price < 30000 THEN '20000'
           WHEN price >= 30000 AND price < 40000 THEN '30000'
           WHEN price >= 40000 AND price < 50000 THEN '40000'
           WHEN price >= 50000 AND price < 60000 THEN '50000'
           WHEN price >= 60000 AND price < 70000 THEN '60000'
           WHEN price >= 70000 AND price < 80000 THEN '70000'
           WHEN price >= 80000 AND price < 90000 THEN '80000'
           WHEN price >= 90000 AND price < 100000 THEN '90000'
           ELSE '100000+'
           END AS price_group, COUNT(*) as products
FROM product
GROUP BY
    CASE
        WHEN price >= 0 AND price < 10000 THEN '0'
        WHEN price >= 10000 AND price < 20000 THEN '10000'
        WHEN price >= 20000 AND price < 30000 THEN '20000'
        WHEN price >= 30000 AND price < 40000 THEN '30000'
        WHEN price >= 40000 AND price < 50000 THEN '40000'
        WHEN price >= 50000 AND price < 60000 THEN '50000'
        WHEN price >= 60000 AND price < 70000 THEN '60000'
        WHEN price >= 70000 AND price < 80000 THEN '70000'
        WHEN price >= 80000 AND price < 90000 THEN '80000'
        WHEN price >= 90000 AND price < 100000 THEN '90000'
        ELSE '100000+'
        END
ORDER BY TO_NUMBER(price_group)
```