package com.example.emploidutemps.service;
import com.example.emploidutemps.model.Etudiant;
import com.example.emploidutemps.repository.EtudiantRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EtudiantService {
	private final EtudiantRepository repo;

	public EtudiantService (EtudiantRepository repo) {
		this.repo = repo;
	}
	
	public List<Etudiant> getAll() {
		return repo.findAll();
	}
	public Etudiant getById(long id) {
		return repo.findById(id).orElse(null);
	}
	public Etudiant save(Etudiant etudiant) {
		return repo.save(etudiant);
	}
	public void delete(Long id) {
		repo.deleteById(id);
	}
	
}
