package advancedProjectComputer;

public class AlreadyInListException extends Exception{
	String found;
	public AlreadyInListException(String cat,String msg) {
		super(msg + cat);
		this.found = cat;
	}
	public String getFound() {
		System.out.println(found + " is already added!");
		return found;
	}
}
