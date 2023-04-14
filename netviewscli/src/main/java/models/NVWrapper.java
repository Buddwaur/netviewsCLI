package models;

import java.util.ArrayList;
import java.util.Arrays;

public class NVWrapper {
	private ArrayList<Node> nodes;

	private ArrayList<Association> associations;

	private ArrayList<Assignment> assignments;

	public ArrayList<Node> getNodes() {
		return nodes;
	}

	public void setNodes(ArrayList<Node> nodes) {
		this.nodes = nodes;
	}

	public ArrayList<Association> getAssociations() {
		return associations;
	}

	public void setAssociations(ArrayList<Association> associations) {
		this.associations = associations;
	}

	public ArrayList<Assignment> getAssignments() {
		return assignments;
	}

	public void setAssignments(ArrayList<Assignment> assignments) {
		this.assignments = assignments;
	}

	public void addNode(String name, String type, Properties prop) {

		Node newNode = new Node(name, type, prop);

		// Check if the node name exists already
		if (findNode(name) == null) {
			nodes.add(newNode);
			return;
		}

		System.out.println("Error: duplicate node");
	}

	public void removeNode(String name) {
		// Delete by node name
		Node deleteMe = findNode(name);

		if (deleteMe != null) {
			nodes.remove(deleteMe);
			return;
		}

		System.out.println("Error: Node not found");

	}

	public void addAssociation(String source, String target, String operations[]) {
		Association newAssoc = new Association(source, target, operations);

		if (findAssociation(source, target) == null) {
			associations.add(newAssoc);
			return;
		}

		System.out.println("Error: duplicate association");
	}

	public void removeAssociation(String source, String target) {
		// Delete by node name
		Association deleteMe = findAssociation(source, target);

		if (deleteMe != null) {
			associations.remove(deleteMe);
		}

		System.out.println("Error: Association not found");
	}

	public void addAssignment(String source, String target) {
		Assignment newAssign = new Assignment(source, target);

		if (findAssignment(source, target) == null) {
			assignments.add(newAssign);
			return;
		}

		System.out.println("Error: duplicate assignment");
	}

	public void removeAssignment(String source, String target) {
		// Delete by node name
		Assignment deleteMe = findAssignment(source, target);

		if (deleteMe != null) {
			assignments.remove(deleteMe);
			return;
		}

		System.out.println("Error: Association not found");
	}

	public void addOperations(String source, String target, String[] operations) {
		Association association = findAssociation(source, target);

		String currentOperations[] = association.getOperations();
		int length = currentOperations.length;
		currentOperations = Arrays.copyOf(currentOperations, length + operations.length);
		for (int i = length; i < currentOperations.length; i++) {
			currentOperations[i] = operations[i - length];
		}

		association.setOperations(currentOperations);
	}

	public void removeOperations(String source, String target, String operations[]) {
		Association association = findAssociation(source, target);

		String currentOpperation[] = association.getOperations();

		int swapped = 0;
		for (int i = 0; i < operations.length; i++) {
			for (int j = 0; j <= currentOpperation.length - swapped; j++) {
				if (operations[i].equals(currentOpperation[j])) {
					currentOpperation[j] = currentOpperation[currentOpperation.length - 1 - swapped];
					currentOpperation[currentOpperation.length - 1 - swapped] = operations[i];
					swapped++;
					break;
				}
			}

		}
		association.setOperations(Arrays.copyOf(currentOpperation, currentOpperation.length - operations.length));

	}

	private Node findNode(String node) {
		for (Node inNodes : nodes) {
			if (inNodes.getName().equals(node)) {
				// System.out.println("Node name is a duplicate");
				return inNodes;
			}
		}

		return null;
	}

	private Association findAssociation(String source, String target) {
		for (Association inAssoc : associations) {
			if (inAssoc.getSource().equals(source) && inAssoc.getTarget().equals(target)) {
				// System.out.println("Node name is a duplicate");
				return inAssoc;
			}
		}

		return null;
	}

	private Assignment findAssignment(String source, String target) {
		for (Assignment inAssign : assignments) {
			if (inAssign.getSource().equals(source) && inAssign.getTarget().equals(target)) {
				// System.out.println("Node name is a duplicate");
				return inAssign;
			}
		}

		return null;
	}
}
