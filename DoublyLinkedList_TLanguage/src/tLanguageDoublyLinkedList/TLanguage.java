package tLanguageDoublyLinkedList;
import java.io.*;
import java.lang.*;
import java.util.Arrays;

public class TLanguage {
	private TCommand c;
	private int num;
	private String inputName;
	private DoublyLinkedList list;

	public TLanguage() {
		c = new TCommand();
		num = 0;
		list = new DoublyLinkedList();
	}
	
	//Decide if String s is a legal command.
	public boolean readCommand(String s) {
		String[] sArray = s.split("\\s+");
		if (sArray[0].equalsIgnoreCase("T")) {
			if (sArray.length == 2) {
				if (sArray[1].endsWith(".t")) {
					inputName = sArray[1] + ".txt";
					return true;
				}
			}
		}
		System.out.println("Command error!");
		return false;
	}
	
	//Exact commands in Tfile.
	public void exactTFile() throws IOException, FileNotFoundException {
		BufferedReader br = new BufferedReader(new FileReader(inputName));
		String str;
		while ((str = br.readLine()) != null) {
			list.add(str);
			exactCommand(list.getNode().getCmd());
		}
		br.close();
		System.out.println("Result: " + this.num);
	}
	
	public void lastStep() {
		if (list.getNode().getLLink() == list.getHeader()) {
			System.out.println("No last!");
		}
		else {
			if (list.getNode().getCmd().contains("ADD")) {
				int[] number = new int[1];
				c.parser(list.getNode().getCmd(), number);
				this.num -= number[0];
			}
			else if (list.getNode().getCmd().equalsIgnoreCase("load")) {
				Node tmp = list.getNode().getLLink();
				while(tmp.getCmd().equalsIgnoreCase("load")) {
					tmp = tmp.getLLink();
				}
				
				while(tmp.getRLink() == list.getNode()) {
					exactCommand(tmp.getCmd());
					tmp = tmp.getRLink();
				}
			}
				
			System.out.println("Before: " + list.getNode() + "\nResult: " + this.num);
			list.previousNode();
		}

	}
	
	public void nextStep() {
		if (list.getNode().getRLink() == list.getHeader())
			System.out.println("End of Code.\nResult: " + this.num);
		else {
			exactCommand(list.getNode().getCmd());
			System.out.println(list.getNode().getCmd() + "\nResult: " + this.num);
			list.nextNode();
		}
	}
	
	//Exact T language command.
	public void exactCommand(String s) {
		if (c.isTLang(s) == 0)
			System.out.println(s + " Syntax error!");
		else {
			int[] number = new int[1];
			int t = c.parser(s, number);
			if (t == 0) 
				num = number[0];
			else if (t == 1)
				num += number[0];
			else if (t == 2)
				System.out.println("Value: " + this.num);
		}
	}
	
}
