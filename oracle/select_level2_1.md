# 재구매가 일어난 상품과 회원 리스트 구하기

## 문제 설명
다음은 어느 의류 쇼핑몰의 온라인 상품 판매 정보를 담은 ONLINE_SALE 테이블 입니다. ONLINE_SALE 테이블은 아래와 같은 구조로 되어있으며 ONLINE_SALE_ID, USER_ID, PRODUCT_ID, SALES_AMOUNT, SALES_DATE는 각각 온라인 상품 판매 ID, 회원 ID, 상품 ID, 판매량, 판매일을 나타냅니다.

| Column name   | Type    | Nullable |
|---------------|---------|----------|
| ONLINE_SALE_ID| INTEGER | FALSE    |
| USER_ID       | INTEGER | FALSE    |
| PRODUCT_ID    | INTEGER | FALSE    |
| SALES_AMOUNT  | INTEGER | FALSE    |
| SALES_DATE    | DATE    | FALSE    |


동일한 날짜, 회원 ID, 상품 ID 조합에 대해서는 하나의 판매 데이터만 존재합니다.

## 문제
ONLINE_SALE 테이블에서 동일한 회원이 동일한 상품을 재구매한 데이터를 구하여, 
재구매한 회원 ID와 재구매한 상품 ID를 출력하는 SQL문을 작성해주세요. 
결과는 회원 ID를 기준으로 오름차순 정렬해주시고 회원 ID가 같다면 상품 ID를 기준으로 내림차순 정렬해주세요.

``` oracle
select user_id, product_id
from online_sale
group by user_id, product_id
having count(*) >= 2
order by user_id, product_id desc
```
