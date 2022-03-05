package exception;

public class NotFoundException extends Exception{

	@Override
	public String getMessage() {
		return "Not  Found!!";
	}
}
