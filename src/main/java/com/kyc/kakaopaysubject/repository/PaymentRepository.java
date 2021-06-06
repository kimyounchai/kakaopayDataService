package com.kyc.kakaopaysubject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.kyc.kakaopaysubject.entity.Payments;

public interface PaymentRepository extends JpaRepository<Payments, Long>{

	
	@Query(value = "SELECT 'GROUP_1' AS groupId \n" + 
				         ", COUNT(1) AS COUNT \n" + 
			             ", NVL(SUM(amount), 0) AS totalAmount \n" + 
			             ", NVL(ROUND(AVG(amount)), 0) AS avgAmount \n" + 
			             ", NVL(MIN(amount), 0) AS minAmount \n" + 
			             ", NVL(MAX(amount), 0) AS maxAmount \n" + 
			         "FROM payments \n" + 
			        "WHERE amount < 10000 \n" + 
			          "AND method_type = '카드'"
		  , nativeQuery = true)
	List<Object[]> findByGroupId1();
	
	
	@Query(value = "SELECT 'GROUP_2' AS groupId \n" + 
			"     , COUNT(1) AS COUNT \n" + 
			"     , NVL(SUM(a.amount), 0) AS totalAmount \n" + 
			"     , NVL(ROUND(AVG(a.amount)), 0) AS avgAmount \n" + 
			"     , NVL(MIN(a.amount),0) AS minAmount \n" + 
			"     , NVL(MAX(a.amount), 0) AS maxAmount \n" + 
			"  FROM payments a \n" + 
			"  INNER JOIN accounts b \n" + 
			"     ON a.account_id = b.account_id \n" + 
			" WHERE b.residence IN ('서울', '경기') \n" + 
			"   AND b.age BETWEEN '30' AND '39'"
		, nativeQuery = true)
	List<Object[]> findByGroupId2();

	
	@Query(value = "SELECT 'GROUP_3' AS groupId \n" + 
			"     , COUNT(1) AS COUNT \n" + 
			"     , NVL(SUM(a.amount),0) AS totalAmount \n" + 
			"     , NVL(ROUND(AVG(a.amount)),0) AS avgAmount \n" + 
			"     , NVL(MIN(a.amount),0) AS minAmount \n" + 
			"     , NVL(MAX(a.amount),0) AS maxAmount \n" + 
			"  FROM payments a  \r\n" + 
			" WHERE a.item_category = '패션' \n" + 
			"   AND a.region = (SELECT residence FROM accounts b WHERE account_id = ?1)"
		, nativeQuery = true)
	List<Object[]> findByGroupId3(String accountId);
	
	
	@Query(value = "SELECT 'GROUP_4' AS groupId \n" + 
			"     , COUNT(1) AS COUNT \n" + 
			"     , NVL(SUM(a.amount), 0) AS totalAmount \n" + 
			"     , NVL(ROUND(AVG(a.amount)), 0) AS avgAmount \n" + 
			"     , NVL(MIN(a.amount), 0) AS minAmount \n" + 
			"     , NVL(MAX(a.amount), 0) AS maxAmount \n" + 
			"  FROM payments a \n" + 
			"  INNER JOIN accounts b \n" + 
			"     ON a.account_id = b.account_id    \n" + 
			" WHERE (a.amount >= 1100000 AND a.method_type = '카드') \n" + 
			"    OR (a.amount >= 1000000 AND a.method_type = '송금')"
		, nativeQuery = true)
	List<Object[]> findByGroupId4();
}
