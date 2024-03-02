package com.hieptv.heducation;

import java.time.LocalDateTime;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hieptv.heducation.models.Person;
import com.hieptv.heducation.utils.HibernateUtil;

import lombok.Builder;

public class TestPerson {
	public static void main(String[] args) {
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			if (sessionFactory != null) {
				Session session = sessionFactory.openSession();
				try {
					Transaction transaction = session.beginTransaction();
					Person person = Person.builder()
							.userType("STU")
							.userName("hieptvan")
							.emailAddress("vanhiep@gmail.com")
							.fullName("Tran Van Hiep")
							.build();
					System.out.println(person);
					session.save(person);
					transaction.commit();
				} catch (Exception e) {
					// TODO: handle exception
				} finally {
					session.close();
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
