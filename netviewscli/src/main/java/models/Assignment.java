package models;

public class Assignment {
	
	private String source;
	
	private String target;
	
	private String[] operations;
	
	public Assignment(String source, String target) {
		setSource(source);
		setTarget(target);
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		if (source == null || source.length() == 0) {
			throw new IllegalArgumentException("Source cannot be empty.");
		}
		this.source = source;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		if (target == null || target.length() == 0) {
			throw new IllegalArgumentException("Target cannot be empty.");
		}
		this.target = target;
	}

	public String[] getOperations() {
		return operations;
	}

	public void setOperations(String[] operations) {
		this.operations = operations;
	}
}
