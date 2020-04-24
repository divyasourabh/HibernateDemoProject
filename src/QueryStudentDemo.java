import org.hibernate.Session;

import com.ds.entity.Student;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class QueryStudentDemo {

	public static void main(String[] args) {
		// create session factory
				SessionFactory factory = new Configuration()
										.configure("hibernate.cfg.xml")
										.addAnnotatedClass(Student.class)
										.buildSessionFactory();
				
				// create session
				Session session = factory.getCurrentSession();
				
				try {			
					
					// start a transaction
					session.beginTransaction();
					
					// query students
					List<Student> studentList = session.createQuery("from Student")
							.getResultList();
					
					// display the students
					displayStudents(studentList);
					
					// query students: lastName='Doe'
					studentList = session.createQuery("from Student s where s.lastName='Doe'")
							.getResultList();
					
					// display the students
					System.out.println("\n\nStudents who have last name of Doe");
					displayStudents(studentList);
					
					// query students: lastName='Doe' OR firstName='Daffy'
					studentList = session.createQuery("from Student s where"
									+ " s.lastName='Doe' OR s.firstName='Daffy'").getResultList();
					
					System.out.println("\n\nStudents who have last name of Doe OR first name Daffy");
					displayStudents(studentList);
					
					// query students where email LIKE '%gmail.com'
					studentList = session.createQuery("from Student s where"
							+ " s.email LIKE '%gmail.com'")
							.getResultList();

					System.out.println("\n\nStudents whose email ends with gmail.com");			
					displayStudents(studentList);
					
					
					// commit transaction
					session.getTransaction().commit();
					
					System.out.println("Done!");
				}
				finally {
					factory.close();
				}
			}

			private static void displayStudents(List<Student> theStudents) {
				for (Student tempStudent : theStudents) {
					System.out.println(tempStudent);
				}
			}

		}

