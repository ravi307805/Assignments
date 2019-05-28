
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

//Student.java
class Student{
	private String name;
	private int token;
	private double cgpa;
	//setter and getter methods
	Student(String name, int token, double cgpa){
		this.name=name;
		this.token=token;
		this.cgpa=cgpa;
	}
	public String getName() {
		return name;
	}
	public int getToken() {
		return token;
	}
	public double getCgpa() {
		return cgpa;
	}
}//end of Student class

//MyComparator.java
class MyComparator implements Comparator<Student>{

	@Override
	public int compare(Student s1,Student s2) {
		//Step_1 :: compare cgpa
		if(s1.getCgpa()!=s2.getCgpa()) {
			if(s1.getCgpa()>s2.getCgpa()) {
				return -1;
			}else {
				return 1;
			}
		}else {
		//Step_2 :: compare name
			if(s1.getName().compareTo(s2.getName())!=0) {
				return s1.getName().compareTo(s2.getName());
			}else {
		//Step_3 :: compare token
				return s1.getToken()-s2.getToken();
			}
		}
	}//compare(-,-)
}//end of MyComparator class

//UpGrad_Assignment.java
public class UpGrad_Assignment {
	public static void main(String[] abc) {
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Total no of event ::");
		int noEvent=sc.nextInt();
		
		if(noEvent<1) {
			System.out.println("try with any higher value :)");
			System.exit(0);
			}
		
		//create MyComparator class object
		Comparator<Student> cmpr=new MyComparator();
		PriorityQueue<Student> pq=new PriorityQueue<Student>(cmpr);
		
		for(int i=0;i<noEvent; i++) {
			String event=sc.next();
			String name;
			int token;
			double cgpa;
			if(event.equals("ENTER")) {
				name=sc.next();
				cgpa=sc.nextDouble();
				token=sc.nextInt();
				Student st=new Student(name, token, cgpa);
				//add student object to priority queue
				pq.add(st);
			}
			else if(event.equals("SERVED")) {
				pq.poll(); //to remove the queue
			}else {
				System.out.println("try again with ENTER(Name CGPA Token) or SERVER");
				System.exit(0);
			}
		}
		
		//prints output
		if(pq.isEmpty()) {
			System.out.println("EMPTY");
		}else {
			while(!pq.isEmpty()) {
				Student st=pq.poll();
				System.out.println(st.getName());
			}
			
			sc.close();
		}
	}//main(-)
}//end of main class
