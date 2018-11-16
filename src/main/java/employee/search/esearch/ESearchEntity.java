package employee.search.esearch;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ESearchEntity implements Serializable {

	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false)
	private String child;

	@Column(nullable = true)
	private String parent;

	// ... additional members, often include @OneToMany mappings

	protected ESearchEntity() {
		// no-args constructor required by JPA spec
		// this one is protected since it shouldn't be used directly
	}

	public ESearchEntity(String name, String state) {
		this.child = name;
		this.parent = state;
	}

	public String getChild() {
		return this.child;
	}

	public String getParent() {
		return this.parent;
	}

	// ... etc

}
