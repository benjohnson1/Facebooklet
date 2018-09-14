/**
 * The abstract FacebookletNode class provides the framework
 * for all nodes in the Facebooklet social network
 * @author Ben Johnson
 * @version 1.0
 */

public abstract class FacebookletNode {
	
	//INSTANCE VARIABLES:
	
	/**
	 * A unique ID to be assigned with with each new node in the network
	 */
	protected static int nodeID;
	
	
	//METHODS:
	
	/**
	 * Return the value of nodeID;
	 * @return int value of nodeID
	 */
	public int getNodeID() {
		return nodeID;
	}
	
	/**
	 * Set the value of nodeID;
	 * @param num
	 */
	public void setNodeID(int num) {
		nodeID = num;
	}
	
	 

}
