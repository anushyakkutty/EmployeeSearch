package employee.search.esearch.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import employee.search.esearch.ESearchEntity;
import employee.search.esearch.ESearchRepoistory;
import employee.search.esearch.domain.Node;


@Service
public class ESearchService {

	private static final String fileName = "classpath:PersistenceFile";
	private static  String rootNode = "";
	private static Map<String, Node> childParentMap = new LinkedHashMap<String,Node>();

	@Autowired
	private ESearchRepoistory esearchRepo;
	@Autowired
	private ResourceLoader resourceLoader;


	public boolean constructMapFromFile() {
		if (rootNode != "") {
			return true;
		}

		BufferedReader reader = null ;
		try {
			reader = new BufferedReader(new InputStreamReader(new ClassPathResource("PersistenceFile").getInputStream()));
			//firdt will be root node 
			rootNode = reader.readLine();
			System.out.println("rootNOde is " + rootNode);

			//root node with height as 0.
			childParentMap.put(rootNode, new Node(0, rootNode, null, null));
			while (true) {
				String line = reader.readLine();
				if (line == null)
					break;

				String[] lineArray = line.split("\\s+");
				childParentMap = TreeNodeUtils.populateTreeMap(childParentMap, lineArray[0], lineArray[1]);
				System.out.println(line);
			} } 
		catch (Exception e) {
			System.out.println("Exception : " + e.getMessage());
			try {
				reader.close();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return false;
		} finally {
		}

		return true;
	}

	private void save(String rootNode2) {
		esearchRepo.save(new ESearchEntity(rootNode2, null));

	}

	public boolean constructMapFromTable() {
		for (ESearchEntity eSearchEntity : esearchRepo.findAll()) {

			if (eSearchEntity.getParent() == null) {
				rootNode = eSearchEntity.getChild(); 
				childParentMap.put(rootNode, new Node(0, rootNode, null, null));}
			else {
				TreeNodeUtils.populateTreeMap(childParentMap, eSearchEntity.getChild(), eSearchEntity.getParent());
			}
		}
		return true;
	}

	public static Node getRootNode() {
		return childParentMap.get(rootNode);
	}

	public static Node updateParent(String child, String parent) throws Exception {
		if (childParentMap.get(parent) == null) {
			throw new Exception("the specified parent doesnt exist in database");
		}
		Node returnNode =  new Node(childParentMap.get(parent).getHeight() + 1, child, childParentMap.get(parent), getRootNode());
		childParentMap.put(child, returnNode);
		return returnNode;

	}

	public static Node getNode(String child) {
		System.out.print("Fetching details of Node : " + child);
		return childParentMap.get(child);
	}

	public void saveContentsToDB() {
		childParentMap.forEach((key, value) -> {
			System.out.println(key + "-----" + value.getData() );
			esearchRepo.save(new ESearchEntity(key, value.getParent() != null ? value.getParent().getData() : null)); 

		});

	}
}
