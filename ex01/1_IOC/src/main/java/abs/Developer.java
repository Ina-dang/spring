package abs;

public class Developer {
	private Emp emp;
	
	public Emp getEmp() {
		return emp;
	}

	public void setEmp(Emp emp) {
		this.emp = emp;
	}

	public void coding(){
		System.out.println("출근합니다");
		emp.work();
		System.out.println("퇴근합니다");
	}
}