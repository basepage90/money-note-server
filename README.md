# money-note-server
Expense Notes Web Server

## CONCEPT
심플한 지출관리를 위한 웹 앱!
- 재정타입(FinanceType) enum
  - 지출(EXPENSE)
  - 수입(INCOME)
  - 고정지출(FIXED_EXPENSE)
  - 고정수입(FIEXED_INCOME)
  - 고정지출과 고정수입은 월별 특정일자로 설정가능하며, 기간타입으로 나누어짐
- 기간타입(PeriodType)
  - 월(DAY) ex) 매월 마지막 금요일
  - 날짜(DATE) ex) 매월 10일
- 기간지정 및 기간별 비교기능
  - 기간지정 -> 여행 특별한날 등 기간지정으로 그루핑하여 관리
  - 기간지정을 하더라도 월별 지출 수입 으로 조회가능
  - 기간지정의 목적은 특정 기간 동안의 예산 관리임  
  ex) 후쿠오카 여행기간동안의 실시간 예산 관리  
  여행기간(2월 1일 ~ 2월 10일) 동안의 예산은 80 만원  
  총 지출은 90 만원 / 총 수입은 5만원 이었으므로 남은 예산은 -5만원 입니다!  

---

## Project Stack
- Kotlin
- REST
- JPA
- PostgreSQL

---
## Branch History
<details> 
    <summary> 👉 Click Me </summary>

#### initial commit

</details>
