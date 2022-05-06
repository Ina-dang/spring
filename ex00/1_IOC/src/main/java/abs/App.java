package abs;

public class App {
	public static void main(String[] args) {
		Emp emp = new Programmer();
		emp.work();
		
		emp = new Designer();
		emp.work();
		
		Developer developer = new Developer();
		developer.setEmp(new Programmer());
		developer.coding();
	}
}
