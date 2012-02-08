
/*
 * Master-Level project:                                                           
 *       Demonstrator of composition of heteregenous services                      
 *       with SCA                                                                 
 *                                                                                 
 *  Copyright (C) 2012                                                            
 *  Authors: Mohamed Habib ESSOUSSI                                                
 *           Mohamed Said MOSLI BOUSKIAA                                           
 *                                                                                 
 * Permission is hereby granted, free of charge, to any person obtaining a copy of 
 * this software and associated documentation files (the "Software"), to deal in    
 * the Software without restriction, including without limitation the rights to     
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies    
 * of the Software, and to permit persons to whom the Software is furnished to do   
 * so, subject to the following conditions:                                         
 *                                                                                  
 * The above copyright notice and this permission notice shall be included in all   
 * copies or substantial portions of the Software.                                  
 *                                                                                  
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR       
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,         
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE      
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER           
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,    
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE    
 * SOFTWARE.                                                                        
 *                                                                                  
 *  TELECOM SudParis | Oct 2011-Jan 2012                                            
 */   
 
 package sca.client;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

import moderation.ModerationStar;
import moderation.ModerationSubs;

import org.osoa.sca.annotations.Reference;
import org.osoa.sca.annotations.Service;

import chatserver.UsersManager;
import chatserver.message.MessagesManager;

/**
 * This IHM of the chat Client uses SCA components as references.
 * 
 * @author Mohamed Said MOSLI BOUKSIAA
 * @author Mohamed Habib ESSOUSSI
 * 
 */
@Service(Runnable.class)
public class ChatClient extends JFrame implements Runnable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4621605420777034080L;
	private JPanel contentPane;
	private final JTextArea messageField = new JTextArea();
	JButton submitButton = new JButton("Send");

	private int receivedMessagesNb;
	private String pseudo;
	private String password;
	private Thread reception;

	private boolean connected;

	@Reference
	protected UsersManager hp;

	@Reference
	protected ModerationStar moderationStar;

	@Reference
	protected ModerationSubs moderationSubs;

	@Reference
	protected MessagesManager messagesManager;

	private final JPanel connexionPanel = new JPanel();
	private JTextField userNameField;
	private final JTextArea conversationField = new JTextArea();
	private final JLabel lblUsername = new JLabel("Username");
	private final JPasswordField passwordField = new JPasswordField();
	private final JLabel lblPassword = new JLabel("Password");
	private JButton connectButton = new JButton("Connect");
	private final JLabel lblConsign = new JLabel(
			"A minimum of editorial rigor is required !");

	public void run() {

		ChatClient frame = new ChatClient(hp, moderationStar, moderationSubs,
				messagesManager);
		frame.setVisible(true);
	}

	/**
	 * Create the frame.
	 */
	public ChatClient(UsersManager myhp, ModerationStar myModerationStar,
			ModerationSubs myModerationSubs, MessagesManager myMessagesManager) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				"resources/tuscany.png"));
		setFont(new Font("Dialog", Font.PLAIN, 12));
		this.hp = myhp;
		this.moderationStar = myModerationStar;
		this.moderationSubs = myModerationSubs;
		this.messagesManager = myMessagesManager;
		receivedMessagesNb = 0;
		pseudo = "";
		connected = false;

		setTitle("SCA Chat");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 200, 640, 480);

		contentPane = new JPanel();
		setContentPane(contentPane);

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel sendPanel = new JPanel();
		sendPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null,
				null, null));
		contentPane.add(sendPanel, BorderLayout.SOUTH);
		sendPanel.setLayout(new BoxLayout(sendPanel, BoxLayout.X_AXIS));

		messageField.setForeground(new Color(0, 102, 255));
		messageField.setFont(new Font("Dialog", Font.BOLD, 13));
		messageField.addKeyListener(new MessageFieldListener());
		sendPanel.add(messageField);
		messageField.setEditable(false);
		messageField.setText("You are not yet connected !");
		submitButton.setBackground(new Color(153, 204, 255));

		submitButton.addActionListener(new SubmitListener());
		submitButton.setEnabled(false);

		sendPanel.add(submitButton);
		connexionPanel.setBackground(new Color(255, 250, 205));
		connexionPanel.setBorder(new BevelBorder(BevelBorder.RAISED, null,
				null, null, null));
		contentPane.add(connexionPanel, BorderLayout.NORTH);
		connexionPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		lblUsername.setFont(new Font("L M Roman Slant8", Font.BOLD, 12));

		connexionPanel.add(lblUsername);

		userNameField = new JTextField();
		userNameField.setColumns(10);
		userNameField.setSize(10, 10);
		connexionPanel.add(userNameField);

		connectButton.setBackground(new Color(153, 204, 255));
		connectButton.setForeground(new Color(47, 79, 79));
		connectButton.addActionListener(new ConnectionButtonListener());
		lblPassword.setFont(new Font("L M Roman Slant8", Font.BOLD, 12));

		connexionPanel.add(lblPassword);
		passwordField.setColumns(10);

		connexionPanel.add(passwordField);

		connexionPanel.add(connectButton);
		conversationField.setForeground(new Color(0, 0, 0));
		conversationField.setBackground(new Color(255, 250, 250));
		conversationField.setFont(new Font("DejaVu Sans Mono", Font.PLAIN, 14));

		JScrollPane scrollpane = new JScrollPane(conversationField);
		contentPane.add(scrollpane, BorderLayout.CENTER);

		conversationField.setEditable(false);

		scrollpane.setColumnHeaderView(lblConsign);

	}

	/**
	 * Listener for the Button Submit click.
	 * 
	 * @author Mohamed Said MOSLI BOUKSIAA
	 * @author Mohamed Habib ESSOUSSI
	 */
	class SubmitListener implements ActionListener {

		/**
		 * Handeling the event.
		 */
		public void actionPerformed(final ActionEvent event) {
			String messageToSend = messageField.getText();
			messageToSend = moderationStar.messageModerate(messageToSend);
			messageToSend = moderationSubs.messageModerate(messageToSend);

			messagesManager.sendMessage(pseudo, messageToSend);
			messageField.setText("");

		}

	}

	/**
	 * Listener for the Press Enter Submit click.
	 * 
	 * @author Mohamed Said MOSLI BOUKSIAA
	 * @author Mohamed Habib ESSOUSSI
	 */
	class MessageFieldListener implements KeyListener {

		public void keyPressed(KeyEvent arg0) {
		}

		public void keyReleased(KeyEvent arg0) {
		}

		public void keyTyped(KeyEvent event) {
			if (event.getKeyChar() == '\n') {
				messagesManager
						.sendMessage(pseudo, moderationStar
								.messageModerate(moderationSubs
										.messageModerate(((JTextArea) event
												.getSource()).getText())));
				messageField.setText("");
			}

		}
	}

	class ConnectionButtonListener implements ActionListener {

		@SuppressWarnings("deprecation")
		public void actionPerformed(ActionEvent event) {
			pseudo = userNameField.getText();
			password = passwordField.getText();

			if (connected == false) {
				if (hp.connect(pseudo, password) == 1) {
					messageField.setEditable(true);
					messageField.setText("");
					connected = true;
					reception = new Thread(new ReceptionThread());
					reception.start();
					submitButton.setEnabled(true);
					connectButton.setText("Disconnect");
					userNameField.setEnabled(false);
					passwordField.setEnabled(false);

				} else {
					messageField
							.setText("Wrong username or password or already connected user !");

				}
			} else {
				hp.disconnect(pseudo);
				messageField.setEditable(false);
				submitButton.setEnabled(false);
				userNameField.setEnabled(true);
				passwordField.setEnabled(true);
				connectButton.setText("Connect");
				connected = false;

			}

		}

	}

	/**
	 * Reception thread for the incoming messages.
	 * 
	 * @author Mohamed Said MOSLI BOUKSIAA
	 * @author Mohamed Habib ESSOUSSI
	 */
	class ReceptionThread implements Runnable {

		/**
		 * Running the thread.
		 */
		public void run() {

			ArrayList<String> newMessages;
			while (connected) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				newMessages = (ArrayList<String>) messagesManager
						.checkMessages(receivedMessagesNb).getMessageList();
				receivedMessagesNb += newMessages.size();

				for (String stg : newMessages) {
					conversationField.append(stg + "\n");
				}
			}
		}
	}

}
