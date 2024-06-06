package proj5sp24;

/**
 * <p>Title: User Class</p>
 *
 * <p>Description: Represents a user in the Facebook-like social network. 
 * Each user has a name and a list of friends. Provides methods to manage 
 * the user's friends and check friendship status.</p>
 */

public class User {
	private String name;
	private FriendList friends;

	/**
	 * Parameterized constructor - initializes the user with a specified name
	 * and an empty friend list.
	 * @param newName the name to be assigned to the user
	 */
	public User(String newName) {
		name = newName;
		friends = new FriendList();
	}

	/**
	 * Get's the name of the user.
	 * @return the name of the user
	 */
	public String getName() {
		return name;
	}

	/**
	 * Adds a specified user to the user's friend list.
	 * @param username the user to be added as a friend
	 */
	public void addFriends(User username) {
		friends.addToFront(username);
	}

	/**
	 * Removes a specified user from the user's friend list.
	 * @param username the user to be removed from the friend list
	 */
	public void unfriend(User username) {
		friends.remove(username);
	}

	/**
	 * Checks if a specified user is a friend of the user.
	 * @param username the user to check friendship status with
	 * @return true if the specified user is a friend, otherwise false
	 */
	public boolean friendsWith(User username) {
		if (friends.search(username))
			return true;

		return false;
	}

	/**
	 * @return a string containing the names of the user's friends
	 */
	public String getFriends() {
		if (friends == null)
			return "";
		return friends.listOfFriends();
	}

	/**
	 * Checks if the user is equal to another user based on their name.
	 * @param username the user to compare with
	 * @return true if the users have the same name, otherwise false
	 */
	public boolean equals(User username) {
		if (name.equals(username.getName()))
			return true;
		return false;
	}
}
