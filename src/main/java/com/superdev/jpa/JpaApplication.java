package com.superdev.jpa;

import java.util.List;

import javax.persistence.*;

public class JpaApplication {

	public static void main(String[] args) {

		//엔티티 매니저 팩토리 생성
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabook");
		EntityManager em = emf.createEntityManager(); //엔티티 매니저 생성

		EntityTransaction tx = em.getTransaction(); //트랜잭션 기능 획득

		try {


			tx.begin(); //트랜잭션 시작

			Member member = new Member("id1", "test1", 2);
			em.persist(member);

			Member member2 = new Member("id2", "test2", 4);
			em.persist(member2);

			System.out.print("==============before=================");
			tx.commit();//트랜잭션 커밋
			System.out.print("==============after=================");

		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback(); //트랜잭션 롤백
		} finally {
			em.close(); //엔티티 매니저 종료
		}

		emf.close(); //엔티티 매니저 팩토리 종료
	}
}