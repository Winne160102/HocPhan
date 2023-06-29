package API;

import java.awt.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

import org.omg.DynamicAny.DynAnyFactoryHelper;

public class Subject {
	//attributes
    private String id;
    private String name;
    private int credit;
    private int studentLimit;
    private int studentMinimum;

    //constructor
    public Subject() {

    }
    
    //constructor all attributes
    public Subject(String id, String name, int credit, int studentLimit, int studentMinimum) {
        this.id = id;
        this.name = name;
        this.credit = credit;
        this.studentLimit = studentLimit;
        this.studentMinimum = studentMinimum;
    }
    
    //get&set attributes
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

    public int getStudentLimit() {
        return studentLimit;
    }

    public void setStudentLimit(int studentLimit) {
        this.studentLimit = studentLimit;
    }

    public int getStudentMinimum() {
        return studentMinimum;
    }

    public void setStudentMinimum(int studentMinimum) {
        this.studentMinimum = studentMinimum;
    }

    //set all attributes 
    public void setall(String id, String name, int credit, int studentLimit, int studentMinimum) {
        this.id = id;
        this.name = name;
        this.credit = credit;
        this.studentLimit = studentLimit;
        this.studentMinimum = studentMinimum;
    }
    
    //input 
    public void inputSubject() { 
    	Scanner scanner = new Scanner(System.in);
        System.out.print("Enter ID: ");
        id = scanner.nextLine();

        System.out.print("Enter Name: ");
        name = scanner.nextLine();

        System.out.print("Enter Credit: ");
        credit = scanner.nextInt();
        
        while (credit <= 0) {
            System.out.println("Invalid input! Please enter a positive value for credit: ");
            credit = new Scanner(System.in).nextInt();
        }
        
        System.out.print("Enter Student Limit: ");
        studentLimit = new Scanner(System.in).nextInt();
        
        while (studentLimit <= 0) {
            System.out.println("Invalid input! Please enter a positive value for Student Limit: ");
            studentLimit = new Scanner(System.in).nextInt();
        }

        System.out.print("Enter Student Minimum: ");
        studentMinimum = new Scanner(System.in).nextInt();
        
        while (studentMinimum <= 0) {
            System.out.println("Invalid input! Please enter a positive value for Student Minimum: ");
            studentMinimum = new Scanner(System.in).nextInt();
        }

    }
    //input file
    public void inputFile(ArrayList<Subject> list) { //inputFile sẽ nhận danh sách các đối tượng Subject
        try {
            FileReader fileReader = new FileReader("C:\\Users\\Admin\\Desktop\\lib java\\Java\\Subject.txt"); // dùng câu lệnh FileReader để đọc file trong đường link và lưu vào biến fileReader 
            BufferedReader bufferedReader = new BufferedReader(fileReader); // BufferedReader để tạo bộ nhớ đệm để khi đọc dữ liệu đầu vào ở biến fileReader đã lưu và lưu vào biến bufferedReader
            while (true) { //đưa điều kiện đúng vào vòng lặp while
                String line = bufferedReader.readLine(); // tạo 1 biến line, readline là để đọc 1 dòng của file và lưu nó vào biến line
                if(line == "" || line == null) break; // nếu biến line là rỗng hoặc null thì sẽ thoát vòng lặp
                String[] temp = line.split(";");//tạo mảng String[] temp, nếu biến line không phải rỗng hoặc null thì sẽ thực hiện tiếp câu lệnh split là phân tách và sẽ lưu các phần tử sau khi tách vào biến temp
                Subject data = new Subject(temp[0], temp[1], Integer.parseInt(temp[2]), Integer.parseInt(temp[3]), Integer.parseInt(temp[4])); // tạo đối tượng Subject mới bằng một biến data và truyền vào đó là các phần tử temp sau khi phân tách vào constructor của Subject
                list.add(data);// sau đó thêm data vào list bằng câu lệnh add
            }
            bufferedReader.close(); // đóng
            fileReader.close(); // đóng
        } catch (Exception e) { 
            e.printStackTrace();//in lỗi
        }
    }

    public void outputFile(ArrayList<Subject> list) { // outputFile sẽ in danh sách các đối tượng Subject 
        try {
            FileWriter fileWriter = new FileWriter("C:\\Users\\Admin\\Desktop\\lib java\\Java\\Subject1.txt"); //ghi dữ liệu từ đường dẫn và lưu vào biến fileWriter
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);// tương tự như bufferedReader để tạo bộ nhớ đệm

            for (Subject data : list) { // dùng vòng lặp for để duyệt các đối tượng data có trong list
                bufferedWriter.write(data.getId() + ";" + data.getName() + ";" + data.getCredit() + ";" +
                        data.getStudentLimit() + ";" + data.getStudentMinimum()); // write để ghi vào bộ nhớ đệm của bufferedWriter
                bufferedWriter.newLine();// chuyển xuống dòng tiếp theo khi đã ghi hết
            }

            bufferedWriter.close();//đóng
            fileWriter.close();//đóng
        } catch (Exception e) {
            e.printStackTrace();//in lỗi
        }
    }
    
    //output Môn học
    public void outputSubject() { 
        System.out.println("ID: " + getId());
        System.out.println("Name: " + getName());
        System.out.println("Credit: " + getCredit());
        System.out.println("Student Limit: " + getStudentLimit());
        System.out.println("Student Minimum: " + getStudentMinimum());  
    }
    
    //output
    public void output() {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false; // tạo 1 biến exit có giá trị fasle
        ArrayList<Subject> list = new ArrayList<>();//khởi tạo một danh sách list có kiểu dữ liệu Subject
        while(!exit) {// exit đưa ra ở trước có giá trị false điều kiện đưa vào true để tiếp tục vòng lặp
        	System.out.println("Enter your choice: 1 - Input file, 2 - Output file, 3 - Input and output from keyboard, 4 - Exit");
            int choice = scanner.nextInt();//chọn số
            switch (choice) {
                case 1://gọi phương thức inputFile(list) để nhập dữ liệu từ tệp đưa vào danh sách list
                    inputFile(list);
                    System.out.println("Input file created successfully.");
                    break;
                case 2://gọi phương thức outputFile(list) để in dữ liệu danh sách list 
                    outputFile(list);
                    System.out.println("Output file created successfully.");
                    break;
                case 3://gọi phương thức nhập xuất chi tiết môn học
                    System.out.println("Enter the subject details:");
                    scanner.nextLine();
                    inputSubject();
                    outputSubject();
                    break;
                case 4://gán giá trị true cho exit thì điều kiện của vòng while(!exit) -> nó trả về false cho nên sẽ kết thúc vàng lặp
                	exit = true;
                	break;
                default:// chọn sai thì chọn lại
                    System.out.println("Invalid choice");
                    break;
            }
        }
        
    }
    //main
    public static void main(String[] args) {
    	   Subject sj = new Subject();
    	    sj.output();
    }
}
