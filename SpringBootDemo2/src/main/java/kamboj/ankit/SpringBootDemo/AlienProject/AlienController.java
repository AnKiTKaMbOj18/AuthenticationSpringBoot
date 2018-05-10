package kamboj.ankit.SpringBootDemo.AlienProject;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/aliens")
public class AlienController {

	@Autowired
	private  AlienService alienService;
	
	@GetMapping("/")
	public List<Alien> getAllAliens(){
		return alienService.getAllAliens();
	}
	
	@GetMapping("/{id}")
	public Alien getAlien(@PathVariable int id) {
		return alienService.getAlien(id);
	}
	
	@PostMapping
	public int addAlien(@RequestBody Alien alien) {
		return alienService.addAlien(alien);
	}
	@PutMapping("/{id}")
	public String updateAlien(@RequestBody Alien alien,@PathVariable int id) {
		return alienService.updateAlien(alien,id);
	}
	@DeleteMapping("/{id}")
	public String deleteAlien(@PathVariable int id) {
		return alienService.deleteAlien(id);
	}
}
