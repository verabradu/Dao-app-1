package pixel.academy.crud_app;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pixel.academy.crud_app.dao.StudentDAO;
import pixel.academy.crud_app.entity.Student;

import java.util.List;

@SpringBootApplication
public class CrudAppApplication {

	public static void main(String[] args) {SpringApplication.run(CrudAppApplication.class, args);}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			//createStudent(studentDAO);
			//createMultipleStudents(studentDAO);
			//readSudent(studentDAO);

			//queryForStudents(studentDAO);
			queryForStudentsByLastName(studentDAO);

		};
	}

	private void createStudent(StudentDAO studentDAO) {

		// cream un obiect Student
		System.out.println("Creating new student object...");
		Student newStudent = new Student("John", "Doe", "john@pixelacademy.md");

		// salvam obiectul in baza de date folosind DAO
		System.out.println("Saving the student ...");
		studentDAO.save(newStudent);

		// afisam ID-ul studentului salvat
		System.out.println("Saved student. Generated ID: " + newStudent.getId());
	}
	private void createMultipleStudents(StudentDAO studentDAO) {
		// cream mai multi studenti
		System.out.println("Creating 3 students ...");
		Student newStudent1 = new Student("Andrei", "Munteanu", "andrei@pixelacademy.md");
		Student newStudent2 = new Student("Iulian", "Vataman", "john@pixelacademy.md");
		Student newStudent3 = new Student("Maria", "Mirabela", "maria@pixelacademy.md");

		// salvam obiectele student in baza de date
		System.out.println("Saving the students ...");
		studentDAO.save(newStudent1);
		studentDAO.save(newStudent2);
		studentDAO.save(newStudent3);
	}
	private void readSudent(StudentDAO studentDAO) {

		// creaza un obiect de tip Student
		System.out.println("Reading new student object ...");
		Student newStudent = new Student("Mircea", "Popescu", "mirceap@pixel.academy");

		// salveaza studentul in baza de date
		System.out.println("Saving the student ...");
		studentDAO.save(newStudent);

		// afiseaza id-ul studentului salvat
		int theId = newStudent.getId();
		System.out.println("Saved student. Generated id: " + theId);

		// recupereaza studentul pe baza ID-ului (PK)
		System.out.println("Retreiving student with id: " + theId);
		Student myStudent = studentDAO.findById(theId);

		// afiseaza detaliile studentului
		System.out.println("Found student: " + myStudent);
	}

	private void queryForStudents (StudentDAO studentDAO){

		// obtine lista studenti
		List<Student> theStudents = studentDAO.findAll();

		// afiseaza lista de studenti
		for (Student newStudent : theStudents) {
			System.out.println(newStudent);
		}
	}
	private void queryForStudentsByLastName(StudentDAO studentDAO){
		// returnarea lista de studenti
		List<Student> theStudent =studentDAO.findByLastName("Popescu");

		// afiseaza lista de studenti
		for (Student newStudent : theStudent) {
			System.out.println(newStudent);
		}
	}
}
