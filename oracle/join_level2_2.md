# 조건에 맞는 도서와 저자 리스트 출력하기

## 문제 설명
다음은 어느 한 서점에서 판매중인 도서들의 도서 정보(BOOK), 저자 정보(AUTHOR) 테이블입니다.

BOOK 테이블은 각 도서의 정보를 담은 테이블로 아래와 같은 구조로 되어있습니다.

| Column name    | Type         | Nullable | Description                  |
|----------------|--------------|----------|------------------------------|
| BOOK_ID        | INTEGER      | FALSE    | 도서 ID                      |
| CATEGORY       | VARCHAR(N)   | FALSE    | 카테고리 (경제, 인문, 소설, 생활, 기술) |
| AUTHOR_ID      | INTEGER      | FALSE    | 저자 ID                      |
| PRICE          | INTEGER      | FALSE    | 판매가 (원)                   |
| PUBLISHED_DATE | DATE         | FALSE    | 출판일                       |

AUTHOR 테이블은 도서의 저자의 정보를 담은 테이블로 아래와 같은 구조로 되어있습니다.

| Column name  | Type       | Nullable | Description |
|--------------|------------|----------|-------------|
| AUTHOR_ID    | INTEGER    | FALSE    | 저자 ID     |
| AUTHOR_NAME  | VARCHAR(N) | FALSE    | 저자 이름   |


## 문제
'경제' 카테고리에 속하는 도서들의 도서 ID(BOOK_ID), 저자명(AUTHOR_NAME), 출판일(PUBLISHED_DATE) 리스트를 출력하는 SQL문을 작성해주세요.
결과는 출판일을 기준으로 오름차순 정렬해주세요.



```oracle
SELECT b.book_id, a.author_name, TO_CHAR(b.published_date, 'YYYY-MM-DD')
FROM book b
         JOIN author a ON b.author_id = a.author_id
WHERE b.category = '경제'
ORDER BY b.published_date
```