# 카카오페이의 사전과제 (데이터서비스)

## 개발 프레임워크
 - IDE : STS-3.9.4.RELEASE
 - Springboot
 - mysql mysql-connector-java-8.0.20
 - Java-1.8
 
## 문제해결 전략
 - 요구사항에 부합하기 위해 API 명세 설계
 - 결제내역을 수신받는 API, 특정그룹의 통계데이터를 조회할 수 있는 API 개발
 - Spring Boot실행시 미리작성해 놓은 accounts.sql을 활용하여 계정정보를 INSERT 하여 테스트 진행.
  * 결제내역 수신 API
 	- POST방식으로 결제데이터가 BODY에 JSON형태로 전달
 	- 결제데이터는 resources/payments.csv파일을 읽어들여 ReadCsvFileUtil에서 Csvschema를 활용하여 Map형태로 컬럼을 읽어들여 PaymentsService로 전달.
 	- PaymentsService의 savePayments에서는 전달받은 Map을 파싱하여 payments Entity에 매핑하여 데이터를 적재.
	- 적재결과를 DataServiceErrorResponse 에 success(boolean)와 ErrorMassage(String)에 담아 결과리턴.
    - 결과예시 : 
	POST /payment
	{
    "success": true,
    "errorMessage": ""
	}

  * 특정그룹의 통계데이터를 조회할 수 있는 API
    - GET방식으로 결제그룹 ID를 parameter로 전달받아 해당그룹의 통계정보를 JSON으로 절달.
	- 절달받은 그룹ID (GROUP_1 ~ GROUP_4)는 requestStatisticsByGroupId 서비스에서 분기처리하여 PaymentRepository의 List<Object[]>인 List형태로 반환하여 리턴.
	- PaymentRepository에서는 각각의 그룹의 통계정보를 전달할 수 있는 쿼리문을 @Query 어노테이션을 활용하여 작성. 
    - 결과예시 : 
	GET /statistics?groupId=GROUP_3
	{
    "groupId": "GROUP_3",
    "count": 3,
    "totalAmount": 1037600,
    "avgAmount": 345867,
    "minAmount": 151700,
    "maxAmount": 542600
	}

## 빌드 및 실행 방법
 - 빌드 방법
	- STS 활용
		- STS에서 프로젝트를 Import
		- Project build
 - 실행 방법
	- STS 활용
		- Run As Spring Boot App으로 실행
			
## API 명세			
		
	POST /payment
		- 기능 : 결제내역 수신 API
		
	GET /statistics?groupId={GROUP_ID}
	    - 기능 : 그룹ID에 따른 해당하는 통계정보 리턴
		
