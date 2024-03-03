package com.hieptv.hexam;

import com.hieptv.hexam.models.UserRole;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hieptv.hexam.models.Person;
import com.hieptv.hexam.utils.HibernateUtil;

public class TestPerson {
	public static void main(String[] args) {
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			if (sessionFactory != null) {
				Session session = sessionFactory.openSession();
				try {
					Transaction transaction = session.beginTransaction();
					UserRole userRole = UserRole.builder()
							.roleCode("STU")
							.roleName("Học sinh")
							.build();
					Person person = Person.builder()
							.userRole(new UserRole("STU", "Học sinh"))
							.userName("hieptvan2")
							.emailAddress("vanhiep2@gmail.com")
							.fullName("Tran Van Hiep")
							.build();
					System.out.println(person);
					session.save(userRole);
					transaction.commit();
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
