package proj5sp24;

/**
 * <p>Title: SFacebook Class</p>
 *
 * <p>Description: A simple Facebook-like social network that manages users 
 * and their friendships. Provides methods to add users, create and break 
 * friendships, check friendship status, and retrieve a list of friends.</p>
 */
public class SFacebook {
	private User[] theMembers;
	private int count;

	/**
	 * Default constructor - initializes theMembers array to a size of 100 and count to 0.
	 */
	public SFacebook() {
		theMembers = new User[100];
		count = 0;
	}

	/**
	 * Adds a new user to the Facebook-like network.
	 * @param username the name of the user to be added
	 */
	public void addToFacebook(String username) {
		if (count >= theMembers.length)
			extendCapacity();

		if (count == 0)
			theMembers[0] = new User(username);
			count++;

		theMembers[count] = new User(username);
		count++;

	}

	/**
	 * Creates a friendship between two users.
	 * @param user the name of the first user
	 * @param otherUser the name of the second user
	 */
	public void makeFriends(String user, String otherUser) {
		User temp = findFriend(user);
		User otherTemp = findFriend(otherUser);
		
		if(temp != null && otherTemp != null && (!temp.getName().equals(otherTemp.getName()))) {
			temp.addFriends(otherTemp);
			otherTemp.addFriends(temp);
		}
		else
			throw new FriendNotFoundException("Friend not found");
		
	}

	/**
	 * Breaks the friendship between two users.
	 * @param user the name of the first user
	 * @param otherUser the name of the second user
	 * @throws FriendNotFoundException if one of the users is not found
	 */
	public void breakFriendShip(String user, String otherUser) {
		User temp = findFriend(user);
		User otherTemp = findFriend(otherUser);
		
		if(temp != null && otherTemp != null) {
			temp.unfriend(otherTemp);
			otherTemp.unfriend(otherTemp);
		}
		else
			throw new FriendNotFoundException("Friend not found");
	}

	/**
	 * Gets the list of friends for a specified user.
	 * @param username the name of the user
	 * @return a string representation of the user's friends
	 */
	public String getFriends(String username) {
		int index = -1;
		for (int i = 0; i < count - 1; i++) {
			if (theMembers[i] != null && theMembers[i].getName().equals(username) && index == -1) {
				index = i;
			}
		}
		return theMembers[index].getFriends();
	}

	/**
	 * Checks the friendship status between two users.
	 * @param user the name of the first user
	 * @param otherUser the name of the second user
	 * @return true if the users are friends, otherwise false
	 * @throws FriendNotFoundException if one of the users is not found
	 */
	public boolean getFriendsStatus(String user, String otherUser) {
		User temp = findFriend(user);
		User otherTemp = findFriend(otherUser);
		if(temp != null && otherTemp != null) {
			if(temp.friendsWith(otherTemp))
				return true;
		}
		else
			throw new FriendNotFoundException("Friend not Found");
		
		return false;
		
	}

	/**
	 * @return a string listing each user and their friends
	 */
	public String toString() {
		String temp = "";
		for(int i = 1; i < count; i++) {
			if(theMembers[i] != null)
				temp += theMembers[i].getName() + " is friends with: " + theMembers[i].getFriends() + "\n";
		}
		return temp;
	}

	/**
	 * @param username the name of the user to find
	 * @return the User object if found, otherwise null
	 */
	private User findFriend(String username) {
	    for (int i = 1; i < count; i++) {
	        User currentUser = theMembers[i];
	        if (currentUser != null && username.equals(currentUser.getName())) {
	            return currentUser;
	        }
	    }
	    return null;
	}
	
	/**
	 * Extends the capacity of theMembers array when it is full.
	 */
	private void extendCapacity() {
		User[] larger = new User[theMembers.length * 2];
		for (int i = 0; i < theMembers.length; i++) {
			larger[i] = theMembers[i];
		}
		theMembers = larger;
	}
}
