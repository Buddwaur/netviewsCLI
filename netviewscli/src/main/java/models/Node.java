package models;

public class Node {
	private String name;
	
	private String type;
	
	private Properties properties;
	
	public Node(String name, String type, Properties prop) {
		this.name = name;
		this.type = type;
		this.properties = prop;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Properties getProperties() {
		return properties;
	}

	public void setProperties(Properties properties) {
		this.properties = properties;
	}
	
	
}
