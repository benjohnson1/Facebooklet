/**
 * The FacebookletProfile class encapsulate all the information 
 * for a single profile in the social network
 * @author Ben Johnson
 * @version 1.0
 */

import java.util.ArrayList;

public class FacebookletProfile extends FacebookletNode {
	
	//INSTANCE VARIABLES:
	
	/**
	 * Integer variable representing ID of node
	 */
	private int userID;
	
	/**
	 * String variable for name of the user
	 */
	private String userName;
	
	
	/**
	 * String variable for the current status of the user
	 */
	private String userStatus;
	
	/**
	 * String variable for profile image name
	 */
	private String profileImage;
	
	
	/**
	 * ArrayList of other Facebooklet profiles who are the user's friends
	 */
	public ArrayList<FacebookletProfile> userFriends = new ArrayList<FacebookletProfile>();
	
	
	//CONSTRUCTOR:
	
	/**
	 * Constructor for FacebookletProfile object, initializing userName to String name
	 * @param name
	 */
	public FacebookletProfile(String name) {
		userName = name;
		userStatus = "No Status";
		profileImage = "No Profile Image";
		userID = nodeID;
		
	}
	
	
	/**
	 * Constructor for FacebookletProfile, which uses an array of Strings to initialize an object
	 * @param profileData
	 */
	public FacebookletProfile(String[] profileData) {
		this.setNodeID(Integer.parseInt(profileData[0]));
		this.setUserName(profileData[1]);
		this.setUserStatus(profileData[2]);
		this.setProfileImage(profileData[3]);
		
	}

	
	//METHODS:
	
	/**
	 * Returns node ID
	 * @return a integer representing the ID of the user
	 */
	public int getNodeID() {
		return userID;
	}
	
	
	/**
	 * Returns user name
	 * @return a string representing the name of the user
	 */
	public String getUserName() {
		return userName;
	}
	
	
	/**
	 * Set the user name
	 * @param newName
	 */
	public void setUserName(String newName) {
		userName = newName;
	}
	
	
	/**
	 * Reset the user status
	 * @param newStatus
	 */
	public void setUserStatus(String newStatus) {
		userStatus = newStatus;
	}
	
	
	/**
	 * Returns user status
	 * @return a string representing the status of the user
	 */
	public String getUserStatus() {
		return userStatus;
	}
	
	
	/**
	 * Set the user profile image
	 * @param image
	 */
	public void setProfileImage(String image) {
		profileImage = image;
	}
	
	
	/**
	 * Returns profile image
	 * @return a string representing the profile image
	 */
	public String getProfileImage() {
		return profileImage;
	}

	
	
	/**
	 * Returns a list of with the user friends
	 * @return a String of the names of user friends
	 */
	public String getUserFriends() {
		String friendList = "";
		
		for (int i = 0; i < userFriends.size(); i++) {
			friendList += userFriends.get(i).getUserName() + "\n";
		}
		
		return friendList;	
	}
	
	
	/**
	 * Add a new friend to user friends
	 * @param newFriend
	 */
	public void addFriend(FacebookletProfile newFriend) {
		this.userFriends.add(newFriend);
		newFriend.userFriends.add(this);
	}
	
	
	/**
	 * Remove a friend from user friends
	 * @param oldFriend
	 */
	public void removeFriend(FacebookletProfile oldFriend) {
		for (int i = 0; i < this.userFriends.size(); i++) {
			if (this.userFriends.get(i).equals(oldFriend)) {
				this.userFriends.remove(i);
			}
		}
		for (int i = 0; i < oldFriend.userFriends.size(); i++) {
			if (oldFriend.userFriends.get(i).equals(this)) {
				oldFriend.userFriends.remove(i);
			}
		}
			
	}
	
	
	/**
	 * Returns a friendly string with the user name, status, and list of friend
	 * @return formatted String of user's data
	 */
	@Override
	public String toString() {
		return userName + " (" + userStatus + ") : " + "\n\n" + userName + "'s Friends:\n" + this.getUserFriends();
	}	

}
