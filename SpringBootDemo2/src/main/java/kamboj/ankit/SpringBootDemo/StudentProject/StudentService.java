package kamboj.ankit.SpringBootDemo.StudentProject;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository studentRepository;

	//public List<Student> students=new ArrayList<>();

	public List<Student> getAllStudents() {
		//return students;
		List<Student> students=new ArrayList<>();
		studentRepository.findAll()
		.forEach(students::add);
		return students;
	}

	public Student getStudent(int id) {
		//return students.get(id);
		return studentRepository.findOne(id);
	}
	 
	public int createStudent(Student student) {
		//students.add(student);
		studentRepository.save(student);
		return student.getId();
	}

	public String updateStudent(Student student) {
		//students.add(student);
		studentRepository.save(student);
		return "updated";
	}
	
	public String deleteStudent(int id) {
		//students.remove(id);
		studentRepository.delete(id);
		return "deleted";
	}
	
}
