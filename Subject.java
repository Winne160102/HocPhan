package API;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.text.AbstractDocument.BranchElement;
import javax.xml.transform.Templates;

public class Subject {
	//attributes
	private String id;
	private String name;
	private int credit;
	private String studentLimit;
	private String studentMinimum;
	
	//constructor 
	public Subject() {
		
	}
	
	//constructor all attributes
	public Subject(String id, String name, int credit, String studentLimit, String studentMinimum) {
		this.id = id;
		this.name = name;
		this.credit = credit;
		this.studentLimit = studentLimit;
		this.studentMinimum = studentMinimum;  

	}
	
	//get & set attributes
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}

	public String getStudentLimit() {
		return studentLimit;
	}

	public void setStudentLimit(String studentLimit) {
		this.studentLimit = studentLimit;
	}

	public String getStudentMinimum() {
		return studentMinimum;
	}

	public void setStudentMinimum(String studentMinimum) {
		this.studentMinimum = studentMinimum;
	}
	
	//set all attributes
	public void setall(String id, String name, int credit, String studentLimit, String studentMinimum) {
		this.id = id;
		this.name = name;
		this.credit = credit;
		this.studentLimit = studentLimit;
		this.studentMinimum = studentMinimum;
	}
	
	//input
	public void input() {
		Scanner sc = new Scanner(System.in);
		id = sc.nextLine();
		name = sc.nextLine();
		credit = new Scanner(System.in).nextInt();
		while (this.credit == 0 & this.credit < 0) {
			credit = new Scanner(System.in).nextInt();
		}
		studentLimit = sc.nextLine();
		studentMinimum = sc.nextLine();
	}
	
	//output
	public void output() {
		System.out.println("ID: " + getId());
		System.out.println("Name: " + getName());
		System.out.println("Credit: " + getCredit());
		System.out.println("Student Limit: " + getStudentLimit());
		System.out.println("Sutdent Minimun: " + getStudentMinimum());
	}
	
	//input file
	public static void inputFile(ArrayList<Subject> list) {
		try {
			FileReader fReader = new FileReader("C:\\Users\\Admin\\Desktop\\lib java\\Java\\Subject.txt");
			BufferedReader bReader = new BufferedReader(fReader);
			while(true) {
				String st = bReader.readLine();
				if(st == "" || st == null) break;
				String temp[] = st.split("[;]");
				Subject data = new Subject(temp[0], temp[1], Integer.parseInt(temp[2]), temp[3], temp[4]);
				list.add(data);
			} 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
