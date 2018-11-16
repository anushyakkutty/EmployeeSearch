package employee.search.esearch.domain;

public class Node { 
	private String data; 
	private int height;
	private Node parent; 
	private Node rootNode;
	
	public Node getRootNode() {
		return rootNode;
	}

	public void setRootNode(Node rootNode) {
		this.rootNode = rootNode;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public Node getParent() {
		return parent;
	}

	public void setParent(Node parent) {
		this.parent = parent;
	}


	public Node(int height, String data, Node parent, Node rootNode) 
	{ 
		this.data = data;
		this.height = height;
		this.parent = parent;
		this.rootNode = rootNode;
	} 
	
	
} 
