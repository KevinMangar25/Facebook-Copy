package proj5sp24;

/**
 * <p>Title: FriendList Class</p>
 *
 * <p>Description: Manages a list of friends using a linked list structure. 
 * Provides methods to add, remove, search for friends, and retrieve a list 
 * of friends as a string.</p>
 */
public class FriendList {
	private Node header;
	private int count;

	/**
	 * default constructor - initializes header to a new Node object and count to 0
	 */
	public FriendList() {
		header = new Node();
		count = 0;
	}

	/**
	 * Returns the number of users in the friend list.
	 * @return the count of users in the list
	 */
	public int size() {
		return count;
	}

	/**
	 * Checks if the friend list is empty.
	 * @return true if the list is empty, otherwise false
	 */
	public boolean isEmpty() {
		if (count == 0)
			return true;
		return false;
	}

	/**
	 * Adds a new user to the front of the friend list.
	 * @param username the user to be added to the list
	 */
	public void addToFront(User username) {
		if (isEmpty()) {
			header.setNext(new Node(username));
		} else {
			Node newNode = new Node(username);
			newNode.setNext(header.getNext());
			header.setNext(newNode);
		}
		count++;
	}

	/**
	 * Removes the specified user from the friend list.
	 * @param username the user to be removed from the list
	 * @return the removed user if found, otherwise null
	 */
	public User remove(User username) {
	    Node current = header.getNext();
	    Node previous = header;
	    while (current != null) {
	        if (current.getItem() != null && current.getItem().getName().equals(username.getName())) {
	            previous.setNext(current.getNext());
	            count--; 
	            return current.getItem();
	        }
	        previous = current;
	        current = current.getNext();
	    }
	    return null;
	}

	/**
	 * Searches for a specified user in the friend list.
	 * @param username the user to search for in the list
	 * @return true if the user is found in the list, otherwise false
	 */
	public boolean search(User username) {
		Node current = header.getNext();

		while (current != null) {
			if (current.getItem().equals(username)) {
				return true;
			}
			current = current.getNext();
		}
		return false;
	}

	/**
	 * @return a string containing the names of all users in the list, separated by spaces
	 */
	public String listOfFriends() {
		String result = "";
		Node current = header.getNext();

		while (current != null) {
			result += current.getItem().getName() + " ";
			current = current.getNext();
		}

		return result;
	}
}
