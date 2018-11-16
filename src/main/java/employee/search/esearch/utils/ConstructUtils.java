package employee.search.esearch.utils;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import employee.search.esearch.ESearchRepoistory;

@Service
public class ConstructUtils {

	@Autowired
	private ESearchRepoistory esearchRepo;
	@Autowired
	private ESearchService esearchService;
	
	@PostConstruct
	public void updateDBForTheFirstTime() {
		if (esearchRepo.existsIf() == 0) {
			System.out.println("Initializing map : ");
			esearchService.constructMapFromFile();
			//esearchService.saveContentsToDB();
		} else {
			esearchService.constructMapFromTable();
		}
	}
	
	@PreDestroy
	public void updateDBAndPersist() {
		esearchRepo.deleteAll();
		esearchService.saveContentsToDB();
	}
}
