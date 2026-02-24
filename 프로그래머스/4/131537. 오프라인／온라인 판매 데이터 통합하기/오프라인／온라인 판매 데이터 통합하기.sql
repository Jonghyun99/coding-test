-- [1] 온라인 판매 데이터 조회
SELECT 
    DATE_FORMAT(SALES_DATE, '%Y-%m-%d') AS SALES_DATE, 
    PRODUCT_ID, 
    USER_ID, 
    SALES_AMOUNT
FROM ONLINE_SALE
WHERE SALES_DATE LIKE '2022-03%' -- (문제 조건: 3월 데이터만)

UNION ALL -- [2] 두 결과 집합을 합침 (중복 제거 없음, 속도 빠름)

-- [3] 오프라인 판매 데이터 조회
SELECT 
    DATE_FORMAT(SALES_DATE, '%Y-%m-%d') AS SALES_DATE, 
    PRODUCT_ID, 
    NULL AS USER_ID, -- [핵심] 오프라인은 USER_ID 컬럼이 없으므로 NULL로 채움
    SALES_AMOUNT
FROM OFFLINE_SALE
WHERE SALES_DATE LIKE '2022-03%' -- (문제 조건 확인 필요)

-- [4] 통합된 결과 정렬
ORDER BY SALES_DATE, PRODUCT_ID, USER_ID;