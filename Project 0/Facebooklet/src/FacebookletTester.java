/**
 * An JUnit testing class, with test cases for all FacebookletProfile implemented methods
 * @author Ben Johnson
 * @version 1.0
 */

import junit.framework.TestCase;

public class FacebookletTester extends TestCase {
	
	/**
	 * Three Facebooklet profiles to be tested
	 */
	FacebookletProfile profile1;
	FacebookletProfile profile2;
	FacebookletProfile profile3;
	FacebookletDatabase database;
	
		
	/**
	 * A set up method for the three Facebooklet profiles
	 */
	@Override
	protected void setUp() {
		profile1 = new FacebookletProfile("Person 1");
		profile2 = new FacebookletProfile("Person 2");
		profile3 = new FacebookletProfile("Person 3");
		database = new FacebookletDatabase();
	}

	
	/**
	 * A tear down method for the three Facebooklet profiles
	 */
	@Override
	protected void tearDown() {
		profile1 = null;
		profile2 = null;
		profile3 = null;
		}
	
	/**
	 * Test for getNodeID()
	 */
	public void testGetNodeID() {
		assertEquals(profile1.getNodeID(), 0);
		assertEquals(profile2.getNodeID(), 0);
		assertEquals(profile3.getNodeID(), 0);
		
	}
	
	/**
	 * Test for getUserStatus() and setUserStatus()
	 */
	public void testGetAndSetUserStatus() {
		profile1.setUserStatus("status1");
		profile2.setUserStatus("status2");
		profile3.setUserStatus("status3");
		
		assertEquals(profile1.getUserStatus(), "status1");
		assertEquals(profile2.getUserStatus(), "status2");
		assertEquals(profile3.getUserStatus(), "status3");
		
	}
	
	
	/**
	 * Test for getProfileImage() and setProfileImage()
	 */
	public void testGetandSetProfileImage() {
		profile1.setProfileImage("image1");
		profile2.setProfileImage("image2");
		profile3.setProfileImage("image3");
		
		assertEquals(profile1.getProfileImage(), "image1");
		assertEquals(profile2.getProfileImage(), "image2");
		assertEquals(profile3.getProfileImage(), "image3");
		
	}
	

	/**
	 * Test for addFriend(), checking if the profile1 user and the profile2 user are
	 * in eachother's respective friends lists. Also tests getUserFriends()
	 */
	public void testAddFriend() {
		profile1.addFriend(profile2);
		assertEquals(profile2.getUserName() + "\n",profile1.getUserFriends());
		assertEquals(profile1.getUserName() + "\n",profile2.getUserFriends());	
	}
	
	
	/**
	 * Test for removeFriend(), checking if the profile1 user and the profile2 user are
	 * not in eachother's respective friends lists after removal. Also tests getUserFriends()
	 */
	public void testRemoveFriend() {
		profile1.addFriend(profile2);
		profile1.removeFriend(profile2);
		assertEquals(profile1.getUserFriends(),profile2.getUserFriends());
	}
	
}
