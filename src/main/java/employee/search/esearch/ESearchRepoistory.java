package employee.search.esearch;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ESearchRepoistory extends CrudRepository<ESearchEntity, Long> {

	Page<ESearchEntity> findAll(Pageable pageable);

	@Query("select count(e) from ESearchEntity e")
	public long existsIf();


}