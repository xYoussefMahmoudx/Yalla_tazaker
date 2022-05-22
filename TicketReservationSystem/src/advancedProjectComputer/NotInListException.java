package advancedProjectComputer;

public class NotInListException extends Exception {
	private String notfound;
	
	public NotInListException(String cat,String msg) {
		super(msg + cat);
		this.notfound = cat;
	}
	public String getNotFound() {
		System.out.println(notfound + " does not exist!");
		return notfound;
		
	}
}
