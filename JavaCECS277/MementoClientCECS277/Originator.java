
public class Originator {
	
	//this String is just for example
	//in real world application this 
	//will be a java class - the object
	//for which the state to be stored
	private String state;
	private int age;

	public void setState(String state) {
		this.state = state;
	}

	public String getState() {
		return state;
	}
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Memento createMemento() {
		return new Memento(state, age);
	}

	public void setMemento(Memento memento) {
		state = memento.getState();
		age = memento.getAge();
	}
}
