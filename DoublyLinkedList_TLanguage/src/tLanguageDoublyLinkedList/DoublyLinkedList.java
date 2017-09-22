package tLanguageDoublyLinkedList;

public class DoublyLinkedList {
	private Node header, current;
	

	public DoublyLinkedList() {
		header = new Node();
		this.current = header;
	}
	
	public DoublyLinkedList(String cmd) {
		this();
		Node tmp =  new Node(cmd);
		header.setLLink(tmp);
		header.setRLink(tmp);
		tmp.setLLink(header);
		tmp.setRLink(header);
		current = tmp;
	}
	
	public void add(String cmd) {
		Node tmp = new Node(cmd);
		addNode(tmp);
	}
	
	private void addNode(Node n) {
		//If rLink of header is null means there is no data in list.
		if (header.getRLink() == null) {
			header.setLLink(n);
			header.setRLink(n);
			n.setLLink(header);
			n.setRLink(header);
		}
		else {
			n.setRLink(this.current.getRLink());
			this.current.getRLink().setLLink(n);
			this.current.setRLink(n);
			n.setLLink(this.current);
		}
		this.current = n;
	}
	
	public Node getNode() {
		return current;
	}
	
	public boolean nextNode() {
		current = current.getRLink();
		if (current == header) 
			return false;
		return true;
	}
	
	public boolean previousNode() {
		current = current.getLLink();
		if (current == header)
			return false;
		return true;
	}
	
	public Node getHeader() {
		return this.header;
	}
	
	
	

}
