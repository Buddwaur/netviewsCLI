package models;

public class Association {
	private String source;

	private String target;

	private String operations[];

	public Association(String source, String target, String operations[]) {
		this.source = source;
		this.target = target;
		this.operations = operations;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public String[] getOperations() {
		return operations;
	}

	public void setOperations(String operations[]) {
		this.operations = operations;
	}
}
