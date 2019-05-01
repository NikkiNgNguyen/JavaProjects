
public class Memento {
	private String state;
	private int age;
	public Memento(String state, int age){
		this.state = state;
		this.age = age;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
