package kamboj.ankit.SpringBootDemo.AlienProject;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlienService {

	@Autowired
	private AlienRepository alienRepository;

	public List<Alien> getAllAliens() {
		List<Alien> aliens = new ArrayList<>();
		alienRepository.findAll().forEach(aliens::add);
		return aliens;
	}

	public Alien getAlien(int id) {
		return alienRepository.findOne(id);
	}

	public int addAlien(Alien alien) {
		alienRepository.save(alien);
		return alien.getId();
	}
	public String updateAlien(Alien alien,int id) {
		Alien currentAlien=alienRepository.findOne(id);
		
		currentAlien.setName(alien.getName());
		currentAlien.setMarks(alien.getMarks());
		
		alienRepository.save(currentAlien);
		return "updated";
	}

	public String deleteAlien(int id) {
		alienRepository.delete(id);
		return "deleted";
	}

	
}
