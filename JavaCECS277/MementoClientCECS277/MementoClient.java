

public class MementoClient {
	public static void main(String[] args) {
		Originator originator = new Originator();
		originator.setState("Lion");
		originator.setAge(8);
		Memento memento = originator.createMemento();
		Caretaker caretaker = new Caretaker();
		caretaker.addMemento(memento);
		originator.setState("Tiger");
		originator.setAge(6);
		originator.setState("Horse");
		originator.setAge(14);
		memento = originator.createMemento();
		caretaker.addMemento(memento);
		originator.setState("Elephant");
		originator.setAge(43);
		System.out.println("Originator Current State: " + originator.getState() + "\nAge: " +originator.getAge());
		System.out.println("Originator restoring to previous state...");
		memento = caretaker.getMemento(1);
		originator.setMemento(memento);
		System.out.println("Originator Current State: " + originator.getState() + "\nAge: " +originator.getAge());
		System.out.println("Again restoring to previous state...");
		memento = caretaker.getMemento(0);
		originator.setMemento(memento);
		System.out.println("Originator Current State: " + originator.getState() + "\nAge: " +originator.getAge());
	}
}
