/**
 * The FacebookletDatabase class keeps track of all the profiles 
 * in the FaceBooklet social network, and is responsible for managing profiles
 * 
 * Facebooklet is a simple java program in which a user can create a profile, add personal information
 * add and remove friends, and other various social media tasks all on a Java GUI.
 * 
 * @author Ben Johnson
 * @version 1.0
 */

import java.util.*;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;


public class FacebookletDatabase extends FacebookletNode {
	
	//INSTANCE VARIABLES
	
	/**
	 * Create an array list of profiles called currentNodes 
	 */
	public ArrayList<FacebookletProfile> currentNodes;
	
	//CONSTRUCTOR
	
	/**
	 * Constructor for a database, initializing the currentNodes variable
	 */
	public FacebookletDatabase() {
		currentNodes = new ArrayList<FacebookletProfile>();
	}
	
	
	//METHODS
	
	/**
	 * Add a profile to the FacebookletDatabase
	 * @param profile
	 */
	public void addToCurrentNodes(FacebookletProfile profile) {
		currentNodes.add(profile);
		nodeID++;
	}
	
	
	/**
	 * Remove a profile from the FacebookletDatabase
	 * @param profile
	 */
	public void removeFromCurrentNodes(FacebookletProfile profile) {
		for (int i = 0; i < currentNodes.size(); i++) {
			if (currentNodes.get(i).equals(profile)) {
				currentNodes.remove(i);
				nodeID--;
			}
		}
	}
	
	
	/**
	 * Return a  string of IDs of the profiles in the FacebookletDatabse
	 * @return String of IDs
	 */
	public String getCurrentNodes() {
		String IDList = "";
		for (int i = 0; i < currentNodes.size(); i++) {
			IDList += currentNodes.get(i).getUserName() + "\n";
		}
		return IDList;
	}

	/**
	 * The writeFile method takes a text file as a parameter, and writes in a readable format,
	 * the data from every profile in the database onto that text file, with each profile taking up one line
	 * @param file
	 * @throws IOException
	 */
	public void writeFile(File file) throws IOException {
		FileWriter fileWriter = new FileWriter(file.getName(), true);
		
		FileWriter clearFile = new FileWriter(file);
		clearFile.write("");
		clearFile.close();
		
		String profileIDData;
		String profileNameData;
		String profileStatusData;
		String profileImageData;
		String profileData;
		
		for (int i = 0; i < currentNodes.size(); i++) {
			
			profileIDData = Integer.toString(currentNodes.get(i).getNodeID());
			profileNameData = currentNodes.get(i).getUserName();
			profileStatusData = currentNodes.get(i).getUserStatus();
			profileImageData = currentNodes.get(i).getProfileImage();
			profileData = profileIDData + "-" + profileNameData + "-" + profileStatusData + "-" + profileImageData + "-" + "\r\n";
			fileWriter.write(profileData);	
			
		}
			
		fileWriter.close();
			
	}
	
	
	/**
	 * The readFile method takes a text file as a parameter, and reads the profile data on each line,
	 * constructs a new FacebookletProfile object from that data, and adds that profile to the database
	 * @param file
	 * @throws IOException
	 */
	public void readFile(File file) throws IOException {
		FileReader fileReader = new FileReader(file);
		BufferedReader bufferedFileReader = new BufferedReader(fileReader);
		
		String[] lineData;
		String line = "";
		
		while ((line = bufferedFileReader.readLine()) != null) {
			lineData = line.split("\\-", -1);
			FacebookletProfile profile = new FacebookletProfile(lineData);
    			this.addToCurrentNodes(profile);
		}
	    
	    bufferedFileReader.close();
	    fileReader.close();
	
	}
	
}
