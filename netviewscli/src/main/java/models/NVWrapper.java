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

	public void newNode(String name, String type, Properties prop) {

		Node newNode = new Node(name, type, prop);

		// Check if the node name exists already
		if (findNode(newNode) == null) {
			nodes.add(newNode);
		}

		System.out.println("Error: duplicate node");
	}

	public void deleteNode(String name) {
		// Create empty node. Nodes are found by name.
		Node nameNode = new Node(name, null, null);

		// Delete by node name
		Node deleteMe = findNode(nameNode);

		if (deleteMe != null) {
			nodes.remove(deleteMe);
		}

		System.out.println("Error: Node not found");

	}

	public void newAssociation(String source, String target) {
		Association newAssoc = new Association(source, target);

		if (findAssoc(newAssoc) == null) {
			associations.add(newAssoc);
		}

		System.out.println("Error: duplicate association");
	}

	public void deleteAssocaition(String source, String target) {
		// Associations are found by source and target.
		Association checkAssoc = new Association(source, target);

		// Delete by node name
		Association deleteMe = findAssoc(checkAssoc);

		if (deleteMe != null) {
			associations.remove(deleteMe);
		}

		System.out.println("Error: Association not found");
	}

	public void newAssignment(String source, String target) {
		Assignment newAssign = new Assignment(source, target);

		if (findAssign(newAssign) == null) {
			assignments.add(newAssign);
		}

		System.out.println("Error: duplicate assignment");
	}

	public void deleteAssignmnet(String source, String target) {
		// Assignment are found by source and target.
		Assignment checkAssign = new Assignment(source, target);

		// Delete by node name
		Assignment deleteMe = findAssign(checkAssign);

		if (deleteMe != null) {
			assignments.remove(deleteMe);
		}

		System.out.println("Error: Association not found");
	}

	private Node findNode(Node node) {
		for (Node inNodes : nodes) {
			if (inNodes.getName().equals(node.getName())) {
				// System.out.println("Node name is a duplicate");
				return inNodes;
			}
		}

		return null;
	}

	private Association findAssoc(Association assoc) {
		for (Association inAssoc : associations) {
			if (inAssoc.getSource().equals(assoc.getSource()) && inAssoc.getTarget().equals(assoc.getTarget())) {
				// System.out.println("Node name is a duplicate");
				return inAssoc;
			}
		}

		return null;
	}

	private Assignment findAssign(Assignment assign) {
		for (Assignment inAssign : assignments) {
			if (inAssign.getSource().equals(assign.getSource()) && inAssign.getTarget().equals(assign.getTarget())) {
				// System.out.println("Node name is a duplicate");
				return inAssign;
			}
		}

		return null;
	}
}
