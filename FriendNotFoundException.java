package proj5sp24;

/**
 * <p>Title: FriendNotFoundException Class</p>
 *
 * <p>Description: Custom exception thrown when a specified friend is not found 
 * in the friend list.</p>
 */
public class FriendNotFoundException extends RuntimeException{
	public FriendNotFoundException(String message) {
		super(message);
	}
}
