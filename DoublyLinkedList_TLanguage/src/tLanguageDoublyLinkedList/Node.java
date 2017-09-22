package tLanguageDoublyLinkedList;


public class Node {
	private String cmd;
	private Node lLink, rLink;

	public Node() {
		lLink = null;
		rLink = null;
	}
	
	public Node (String cmd) {
		this.cmd = cmd;
	}
	
	public boolean isNumeric(String cmd) {
		for(int i = 0; i < cmd.length(); i++) {
			if(!Character.isDigit(cmd.charAt(i)))
				return false;
		}
		return true;
	}
	
	public void setLLink(Node left) {
		this.lLink = left;
	}
	
	public void setRLink(Node right) {
		this.rLink = right;
	}
	
	public Node getLLink() {
		return this.lLink;
	}
	
	public Node getRLink() {
		return this.rLink;
	}
	
	public String getCmd() {
		return this.cmd;
	}
	
	@Override
	public String toString() {
		return this.cmd;
	}

}
