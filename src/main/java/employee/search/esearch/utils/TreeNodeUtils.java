package employee.search.esearch.utils;

import java.util.Map;

import employee.search.esearch.domain.Node;


public class TreeNodeUtils { 

	//Make sure mapOfNodes should be a linked hashmap and a parent node should always be initialized before it is defined as a line in the file.
	public static Map<String, Node> populateTreeMap(Map<String, Node> mapOfNodes, String child , String parent) 
	{ 
		if (child.equals(parent))
			return null; 

		if (parent == null) {
			mapOfNodes.put(child, null);
		} else {
			//a childNode will never be initialzed and a parentNode is always initialized
			Node parentNode = mapOfNodes.get(parent);
			Node childNode = new Node(parentNode.getHeight() + 1, child, parentNode, ESearchService.getRootNode());

			mapOfNodes.put(child, childNode);
		}
		return mapOfNodes;
	} 

} 

