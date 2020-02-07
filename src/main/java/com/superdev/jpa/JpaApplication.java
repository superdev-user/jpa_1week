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

			/**
			 * Transaction과 Persistence Context( 영속성 컨텍스트 )
			 */

			tx.begin(); //트랜잭션 시작

			Member findMember1 = em.find(Member.class, "id1");
			Member findMember2 = em.find(Member.class, "id2");

			System.out.println("findMember1=" + findMember1.getUsername() + ", age=" + findMember1.getAge());
			System.out.println("findMember2=" + findMember2.getUsername() + ", age=" + findMember2.getAge());

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