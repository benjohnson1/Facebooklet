import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;
import javax.swing.JSeparator;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.io.IOException;


public class Facebooklet extends JFrame implements ActionListener {
	
	//INSTANCE VARIABLES
	
	/**
	 * All variables for the GUI, as well as a file and database
	 */
	private File nodeFile = new File("savedNodes.txt");			// Create a file called savedNodes.txt
	private FacebookletDatabase database = new FacebookletDatabase();			// Create a FacebookletDatabase called database
	private JLabel facebookletLabel;			// Large Jlabel for Facebooklet header
	private JLabel enterProfileLabel; 		// Large Jlabel to show user where to create, remove, or search profiles
	private JLabel currentProfilesLabel;		// Large Jlabel to show where current profiles are displayed
	private JLabel editProfileLabel;			// Jlabel to show user where to update and edit existing profiles
	private JLabel updateNameLabel;			// Jlabel to show user where to update name
	private JLabel updateStatusLabel;		// Jlabel to show user where to update status
	private JLabel addAndRemoveLabel;		// Large Jlabel to show user where to add and remove friends
	private JLabel addFriendLabel;			// Jlabel to show user where to add a friend
	private JLabel removeFriendLabel;		// Jlabel to show user where to remove a friend
	private JLabel setProfileImageLabel;				// Jlabel to show user where to set and update profile image
	private JTextField enterProfileNameField;  		// JTextField to prompt user for a profile to create, remove, or search
	private JTextField editProfileNameField; 		// JTextField to prompt user for a profile to update and edit
	private JTextField friendProfileNameField;		// JTextField to prompt user for a profile to add or remove friends
	private JTextField updateNameField;				// JTextField to prompt user for a profile to update name
	private JTextField updateStatusField;			// JTextField to prompt user for a profile to update status
	private JTextField addFriendField; 				// JTextField to prompt user for a profile to be added to another profile's friend list
	private JTextField removeFriendField;			// JTextField to prompt user for a profile to be removed to another profile's friend list
	private JTextField profileImageField;			// JTextField to prompt user for a profile to update profile image
	private JButton addProfileButton;				// JButton to add profile to database
	private JButton removeProfileButton;				// JButton to remove profile from database
	private JButton searchProfileButton;				// JButton to search profile in database
	private JButton updateNameButton;				// JButton to update existing profile name
	private JButton updateStatusButton;				// JButton to update existing profile status
	private JButton addFriendButton;					// JButton to add a friend to a profile
	private JButton removeFriendButton;				// JButton to remove a friend from a profile
	private JButton setProfileImageButton;			// JButton to update existing profile's profile image
	private JSeparator verticalDivider1;				// A vertical JSeparator
	private JSeparator verticalDivider2;				// A second vertical JSeparator
	private JSeparator horizontalDivider;			// A horizontal JSeparator
	private JTextPane displayArea;					// JTextPane to display a profile's data when searched
	private JTextArea currentProfilesArea;			// JTextArea to display current profile's in database
	private JScrollPane currentProfilesScrollPane;	// JScrollPane for currentProfilesArea
	private JScrollPane displayScrollPane;			// JScrollPane for displayArea
	private ImageIcon profileImageIcon;				// ImageIcon for a profile's profile image
	private Color darkBlue;							// Color for JPane background
	private Color lightBlue;							// Color for JSeparators
	
	
	/**
	 * Constructor for Facebooklet GUI, using various swing components. The GUI created
	 * displays the name, status, friends, and node ID of the profile
	 */
	Facebooklet() {
		
		// Reading the savedNodes.txt using the FacebookletDatabase readFile method
		try {
			database.readFile(nodeFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// Set frame's title
		setTitle("Facebooklet");
		
		// Set background color
		darkBlue= new Color(59, 89, 152);
		getContentPane().setBackground(darkBlue);
		
		// Set frame size
		setSize(1000, 800);
		
		// Used to specify GUI component layout
		GridBagConstraints layoutConst; 
		
		// Set values and color to JSeperators
		lightBlue = new Color(59, 89, 152);
		
		verticalDivider1 = new JSeparator(JSeparator.VERTICAL);
		verticalDivider1.setBackground(lightBlue);
		
		verticalDivider2 = new JSeparator(JSeparator.VERTICAL);
		verticalDivider2.setBackground(lightBlue);
		
		horizontalDivider = new JSeparator(JSeparator.HORIZONTAL);
		horizontalDivider.setBackground(lightBlue);
		
		
		// Set values to all JLabels
		facebookletLabel = new JLabel("facebooklet");
		enterProfileLabel = new JLabel("Enter Profile Name:");
		currentProfilesLabel = new JLabel("Current Profiles:");
		editProfileLabel = new JLabel("Edit Existing Profile:");
		updateNameLabel = new JLabel("Update Name:");
		updateStatusLabel = new JLabel("Update Status:");
		addAndRemoveLabel = new JLabel("Add and Remove Friends:");
		addFriendLabel = new JLabel("Add Friend:");
		removeFriendLabel = new JLabel("Remove Friend:");
		setProfileImageLabel = new JLabel("Set Profile Image:");
		
		
		// Set values to all JTextFields
		enterProfileNameField = new JTextField(15);
	    enterProfileNameField.setEditable(true);
	    enterProfileNameField.setText("Enter Name");
	    
	    editProfileNameField = new JTextField(15);
	    editProfileNameField.setEditable(true);
	    editProfileNameField.setText("Enter Name");
		
	    updateNameField = new JTextField(15);
	    updateNameField.setEditable(true);
	    updateNameField.setText("Enter New Name");
	    
	    updateStatusField = new JTextField(15);
	    updateStatusField.setEditable(true);
	    updateStatusField.setText("Enter New Status");
	    
	    friendProfileNameField = new JTextField(15);
	    friendProfileNameField.setEditable(true);
	    friendProfileNameField.setText("Enter Name");
	    
	    addFriendField = new JTextField(15);
	    addFriendField.setEditable(true);
	    addFriendField.setText("Enter Friend Name");
	    
	    removeFriendField = new JTextField(15);
	    removeFriendField.setEditable(true);
	    removeFriendField.setText("Enter Friend Name");
	    
	    profileImageField = new JTextField(15);
	    profileImageField.setEditable(true);
	    profileImageField.setText("Enter Image Location:");

	    
	    // Set values for all JButtons
	    addProfileButton = new JButton("ADD PROFILE");
	    addProfileButton.addActionListener(this);
	    
	    removeProfileButton = new JButton("REMOVE PROFILE");
	    removeProfileButton.addActionListener(this);
	    
	    searchProfileButton = new JButton("SEARCH PROFILE");
	    searchProfileButton.addActionListener(this);
	    
	    updateNameButton = new JButton("UPDATE");
	    updateNameButton.addActionListener(this);
	    
	    updateStatusButton = new JButton("UPDATE");
	    updateStatusButton.addActionListener(this);
	    
	    addFriendButton = new JButton("ADD");
	    addFriendButton.addActionListener(this);
	    
	    removeFriendButton = new JButton("REMOVE");
	    removeFriendButton.addActionListener(this);
	    
	    setProfileImageButton = new JButton("SET PROFILE IMAGE");
	    setProfileImageButton.addActionListener(this);
	    
	    
	    // Setting values for JTextAreas, JTextPanes, and ScrollPanes
	    displayArea = new JTextPane();
	    displayScrollPane = new JScrollPane(displayArea); 
	 	displayArea.setEditable(false);
	 	
	 	currentProfilesArea = new JTextArea(5, 20);
	 	currentProfilesArea.setText(database.getCurrentNodes());
	 	currentProfilesScrollPane = new JScrollPane(currentProfilesArea);
	 	currentProfilesArea.setEditable(false);
	 	
	 	// Create image component
	 	profileImageIcon = new ImageIcon();
		/**profileImageLabel = new JLabel(profileImageIcon);*/
	 	
	  
		// Adjust color, font, and font size of specific swing components
		facebookletLabel.setFont(new Font("IMPACT", Font.BOLD, 40));
		facebookletLabel.setForeground(Color.WHITE);
		
		enterProfileLabel.setFont(new Font("Helvetica", Font.BOLD, 17));
		enterProfileLabel.setForeground(Color.WHITE);
		
		currentProfilesLabel.setFont(new Font("Helvetica", Font.BOLD, 17));
		currentProfilesLabel.setForeground(Color.WHITE);
		
		editProfileLabel.setFont(new Font("Helvetica", Font.BOLD, 17));
		editProfileLabel.setForeground(Color.WHITE);
		
		addAndRemoveLabel.setFont(new Font("Helvetica", Font.BOLD, 17));
		addAndRemoveLabel.setForeground(Color.WHITE);
		
		updateNameLabel.setForeground(Color.WHITE);
		updateStatusLabel.setForeground(Color.WHITE);
		addFriendLabel.setForeground(Color.WHITE);
		removeFriendLabel.setForeground(Color.WHITE);
		setProfileImageLabel.setForeground(Color.WHITE);
		
				   
		// Use a GridBagLayout to position all the labels
		setLayout(new GridBagLayout());
		
		layoutConst = new GridBagConstraints();						// Create GridBagConstraints
		layoutConst.gridx = 0;										// Specify component's grid x location
		layoutConst.gridy = 0;										// Specify component's grid Y location
		layoutConst.gridwidth = 5;
		layoutConst.insets = new Insets(10, 10, 10, 10);				// 10 pixels of padding around component
		add(facebookletLabel, layoutConst);							// Add label to frame
			
		layoutConst = new GridBagConstraints();	
		layoutConst.fill = GridBagConstraints.VERTICAL;
		layoutConst.gridx = 1;										
		layoutConst.gridy = 2;	
		layoutConst.weighty = 1;
		layoutConst.gridheight = 14;
		layoutConst.insets = new Insets(10, 10, 10, 10);				
		add(verticalDivider1, layoutConst);
		
		layoutConst = new GridBagConstraints();	
		layoutConst.fill = GridBagConstraints.VERTICAL;
		layoutConst.gridx = 3;										
		layoutConst.gridy = 2;	
		layoutConst.weighty = 1;
		layoutConst.gridheight = 14;
		layoutConst.insets = new Insets(10, 20, 10, 10);				
		add(verticalDivider2, layoutConst);
		
		layoutConst = new GridBagConstraints();						
		layoutConst.gridx = 0;										
		layoutConst.gridy = 1;										
		layoutConst.insets = new Insets(10, 10, 0, 40);				
		add(enterProfileLabel, layoutConst);							
		
		layoutConst = new GridBagConstraints();						
		layoutConst.gridx = 0;										
		layoutConst.gridy = 2;										
		layoutConst.insets = new Insets(0, 10, 0, 40);				
		add(enterProfileNameField, layoutConst);	
		
		layoutConst = new GridBagConstraints();						
		layoutConst.gridx = 0;										
		layoutConst.gridy = 3;										
		layoutConst.insets = new Insets(0, 10, 10, 40);				
		add(addProfileButton, layoutConst);			
		
		layoutConst = new GridBagConstraints();						
		layoutConst.gridx = 0;										
		layoutConst.gridy = 4;										
		layoutConst.insets = new Insets(0, 10, 10, 40);				
		add(removeProfileButton, layoutConst);	
		
		layoutConst = new GridBagConstraints();						
		layoutConst.gridx = 0;										
		layoutConst.gridy = 5;										
		layoutConst.insets = new Insets(0, 10, 10, 40);				
		add(searchProfileButton, layoutConst);
		
		layoutConst = new GridBagConstraints();	
		layoutConst.fill = GridBagConstraints.BOTH;
		layoutConst.anchor = GridBagConstraints.LINE_END;
		layoutConst.gridx = 0;										
		layoutConst.gridy = 6;		
		layoutConst.gridheight = 9;
		layoutConst.insets = new Insets(10, 40, 100, 40);				
		add(displayScrollPane, layoutConst);

		layoutConst = new GridBagConstraints();	
		layoutConst.fill = GridBagConstraints.HORIZONTAL;
		layoutConst.gridx = 0;										
		layoutConst.gridy = 12;	
		layoutConst.insets = new Insets(20, 10, 10, 10);				
		add(horizontalDivider, layoutConst);
		
		layoutConst = new GridBagConstraints();						
		layoutConst.gridx = 0;										
		layoutConst.gridy = 13;										
		layoutConst.insets = new Insets(10, 40, 0, 40);				
		add(currentProfilesLabel, layoutConst);	
		
		layoutConst = new GridBagConstraints();	
		layoutConst.fill = GridBagConstraints.VERTICAL;
		layoutConst.anchor = GridBagConstraints.LINE_END;
		layoutConst.gridx = 0;										
		layoutConst.gridy = 14;		
		layoutConst.gridheight = 18;
		layoutConst.insets = new Insets(10, 40, 100, 40);				
		add(currentProfilesScrollPane, layoutConst);
		
		layoutConst = new GridBagConstraints();						
		layoutConst.gridx = 2;										
		layoutConst.gridy = 1;										
		layoutConst.insets = new Insets(10, 40, 0, 10);				
		add(editProfileLabel, layoutConst);		
		
		layoutConst = new GridBagConstraints();						
		layoutConst.gridx = 2;										
		layoutConst.gridy = 2;										
		layoutConst.insets = new Insets(5, 40, 5, 10);				
		add(editProfileNameField, layoutConst);	
		
		layoutConst = new GridBagConstraints();						
		layoutConst.gridx = 2;										
		layoutConst.gridy = 3;										
		layoutConst.insets = new Insets(5, 40, 5, 10);				
		add(updateNameLabel, layoutConst);	
		
		layoutConst = new GridBagConstraints();						
		layoutConst.gridx = 2;										
		layoutConst.gridy = 4;										
		layoutConst.insets = new Insets(5, 40, 5, 10);				
		add(updateNameField, layoutConst);	
		
		layoutConst = new GridBagConstraints();						
		layoutConst.gridx = 2;										
		layoutConst.gridy = 5;										
		layoutConst.insets = new Insets(5, 40, 5, 10);				
		add(updateNameButton, layoutConst);
		
		layoutConst = new GridBagConstraints();						
		layoutConst.gridx = 2;										
		layoutConst.gridy = 6;										
		layoutConst.insets = new Insets(5, 40, 5, 10);				
		add(updateStatusLabel, layoutConst);	
		
		layoutConst = new GridBagConstraints();						
		layoutConst.gridx = 2;										
		layoutConst.gridy = 7;										
		layoutConst.insets = new Insets(5, 40, 5, 10);				
		add(updateStatusField, layoutConst);	
		
		layoutConst = new GridBagConstraints();						
		layoutConst.gridx = 2;										
		layoutConst.gridy = 8;										
		layoutConst.insets = new Insets(5, 40, 5, 10);				
		add(updateStatusButton, layoutConst);
		
		layoutConst = new GridBagConstraints();						
		layoutConst.gridx = 2;										
		layoutConst.gridy = 9;										
		layoutConst.insets = new Insets(5, 40, 5, 10);				
		add(setProfileImageLabel, layoutConst);	
		
		layoutConst = new GridBagConstraints();						
		layoutConst.gridx = 2;										
		layoutConst.gridy = 10;										
		layoutConst.insets = new Insets(5, 40, 5, 10);				
		add(profileImageField, layoutConst);	
		
		layoutConst = new GridBagConstraints();						
		layoutConst.gridx = 2;										
		layoutConst.gridy = 11;										
		layoutConst.insets = new Insets(5, 40, 5, 10);				
		add(setProfileImageButton, layoutConst);
		
		layoutConst = new GridBagConstraints();						
		layoutConst.gridx = 4;										
		layoutConst.gridy = 1;										
		layoutConst.insets = new Insets(10, 40, 5, 10);				
		add(addAndRemoveLabel, layoutConst);
		
		layoutConst = new GridBagConstraints();						
		layoutConst.gridx = 4;										
		layoutConst.gridy = 2;										
		layoutConst.insets = new Insets(10, 40, 5, 10);				
		add(friendProfileNameField, layoutConst);
		
		layoutConst = new GridBagConstraints();						
		layoutConst.gridx = 4;										
		layoutConst.gridy = 3;										
		layoutConst.insets = new Insets(5, 40, 5, 10);				
		add(addFriendLabel, layoutConst);	
		
		layoutConst = new GridBagConstraints();						
		layoutConst.gridx = 4;										
		layoutConst.gridy = 4;										
		layoutConst.insets = new Insets(5, 40, 5, 10);				
		add(addFriendField, layoutConst);	
		
		layoutConst = new GridBagConstraints();						
		layoutConst.gridx = 4;										
		layoutConst.gridy = 5;										
		layoutConst.insets = new Insets(5, 40, 5, 10);				
		add(addFriendButton, layoutConst);
		
		layoutConst = new GridBagConstraints();
		layoutConst.gridx = 4;										
		layoutConst.gridy = 6;										
		layoutConst.insets = new Insets(5, 40, 5, 10);				
		add(removeFriendLabel, layoutConst);	
		
		layoutConst = new GridBagConstraints();						
		layoutConst.gridx = 4;										
		layoutConst.gridy = 7;										
		layoutConst.insets = new Insets(5, 40, 5, 10);				
		add(removeFriendField, layoutConst);	
		
		layoutConst = new GridBagConstraints();						
		layoutConst.gridx = 4;										
		layoutConst.gridy = 8;										
		layoutConst.insets = new Insets(5, 40, 10, 10);				
		add(removeFriendButton, layoutConst);
		
		
		// Terminate program when window closes
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Prevent resizing
		setResizable(false);
		
		// Center frame in the display
		setLocationRelativeTo(null);
		
		// Display window
		setVisible(true);
		
	}
	
	/**
	 * Method to search if profile name is currently in the database, and return the index if found,
	 * and -1 if not
	 * @param profileName
	 * @return int
	 */
	public int inDatabase(String profileName) {
		
		for (int i = 0; i < database.currentNodes.size(); i++) {
			if (database.currentNodes.get(i).getUserName().equals(profileName)) {
				return i;
			}
		}
		
		return -1;
		
	}
	
	/**
	 * This method is automatically called when an event, like pressing any one of the buttons on the GUI, occurs 
	 * @param event
	 */
	@Override
	public void actionPerformed(ActionEvent event) {
		
		int enterField = inDatabase(enterProfileNameField.getText()); 
		int editField = inDatabase(editProfileNameField.getText());
		int friendField = inDatabase(friendProfileNameField.getText());
		
		
		// Get source of event (2 buttons in GUI)
		JButton sourceEvent = (JButton) event.getSource();
		
		
		
		if (sourceEvent == addProfileButton) {
			
			if (enterField != -1) {
				JOptionPane.showMessageDialog(this, "Profile already in database!");
			}
			
			if (enterField == -1) {
				database.addToCurrentNodes(new FacebookletProfile(enterProfileNameField.getText()));
				JOptionPane.showMessageDialog(this, "Profile Added!");
				try {
					database.writeFile(nodeFile);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			currentProfilesArea.setText(database.getCurrentNodes());
			displayArea.setText(null);
			
			
		}
		
		
		if (sourceEvent == removeProfileButton) {
			
			if (enterField == -1) {
				JOptionPane.showMessageDialog(this, "Profile not in database!");
			}
			
			if (enterField != -1) {
				database.removeFromCurrentNodes(database.currentNodes.get(inDatabase(enterProfileNameField.getText())));
				JOptionPane.showMessageDialog(this, "Profile Removed!");
				try {
					database.writeFile(nodeFile);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			currentProfilesArea.setText(database.getCurrentNodes());
			displayArea.setText(null);
	
		}


		if (sourceEvent == searchProfileButton) {
			
			if (enterField != -1) {
				displayArea.setText(database.currentNodes.get(enterField).toString());
				
				if (!database.currentNodes.get(enterField).getProfileImage().equals("")) {					
					JOptionPane.showMessageDialog(this, null, "Profile Image", 
						    JOptionPane.PLAIN_MESSAGE, new ImageIcon(database.currentNodes.get(enterField).getProfileImage()));
				}

				
			}
			
			if (inDatabase(enterProfileNameField.getText()) == -1) {
				JOptionPane.showMessageDialog(this, "Profile not in database!");
				displayArea.setText(null);
			}
				
		}
		
		
		
		if (sourceEvent == updateNameButton) {
			
			if (editField != -1) {
				database.currentNodes.get(editField).setUserName(updateNameField.getText());
				JOptionPane.showMessageDialog(this, "Name Updated!");
				try {
					database.writeFile(nodeFile);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			if (editField == -1) {
				JOptionPane.showMessageDialog(this, "Profile not in database!");
			}
			
			displayArea.setText(database.currentNodes.get(editField).toString());
			currentProfilesArea.setText(database.getCurrentNodes());
			
		}
		
		
		if (sourceEvent == updateStatusButton) {
			
			if (editField != -1) {
				database.currentNodes.get(editField).setUserStatus(updateStatusField.getText());
				JOptionPane.showMessageDialog(this, "Status Updated!");
				try {
					database.writeFile(nodeFile);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}

			}
			
			if (editField == -1) {
				JOptionPane.showMessageDialog(this, "Profile not in database!");
			}
			
			displayArea.setText(database.currentNodes.get(editField).toString());
			
		}
		
		if (sourceEvent == setProfileImageButton) {
			
			if (editField != -1) {
				database.currentNodes.get(editField).setProfileImage(profileImageField.getText());
				JOptionPane.showMessageDialog(this, null, "Profile Image", 
					    JOptionPane.PLAIN_MESSAGE, new ImageIcon(database.currentNodes.get(enterField).getProfileImage()));
				try {
					database.writeFile(nodeFile);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			if (editField == -1) {
				JOptionPane.showMessageDialog(this, "Profile not in database!");
			}
			
			//displayArea.setText(database.currentNodes.get(editField).toString());
		}
		
		
		if (sourceEvent == addFriendButton) {
			
			if (friendField != -1) {
				if (inDatabase(addFriendField.getText()) != -1) {
					database.currentNodes.get(friendField).addFriend(database.currentNodes.get(inDatabase(addFriendField.getText())));
					JOptionPane.showMessageDialog(this, "Friend Added!");
				}
				
				else {
					JOptionPane.showMessageDialog(this, "Second Profile not in database!");
				}
				
			}
			
			if (friendField == -1) {
				JOptionPane.showMessageDialog(this, "First or Second Profile not in database!");
			
			}
			
			displayArea.setText(database.currentNodes.get(friendField).toString());
			
		}
		
		
		if (sourceEvent == removeFriendButton) {
			
			if (friendField != -1) {
				if (inDatabase(removeFriendField.getText()) != -1) {
					database.currentNodes.get(friendField).removeFriend(database.currentNodes.get(inDatabase(addFriendField.getText())));
					JOptionPane.showMessageDialog(this, "Friend Remove!");
				}
				
				else {
					JOptionPane.showMessageDialog(this, "Second Profile not in database!");
				}
				
			}
			
			if (friendField == -1) {
				JOptionPane.showMessageDialog(this, "First or Second Profile not in database!");
			
			}
			
			displayArea.setText(database.currentNodes.get(friendField).toString());
	
		}
	    
	}
	
	public static void main(String[] args) {
				
		Facebooklet frame = new Facebooklet();
		
	}
					

}


