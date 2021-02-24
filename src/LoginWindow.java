import java.awt.EventQueue;
import java.awt.Image;
import java.awt.RenderingHints;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.SystemColor;
import javax.swing.UIManager;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.Cursor;
import java.awt.Insets;
import javax.swing.border.TitledBorder;

public class LoginWindow {

	private JFrame frmWelcome;
	public JTextField tFEmail;
	private JLabel jLTemp;
	private JPasswordField tFPass;
	private JLabel jLBG;
	private JLabel jl1 = new JLabel("");
	private JButton btnLogIn;
	private JLabel jlResult = new JLabel("");
	private JTextField tEmailHint;
	private JTextField tFPassHint;
	private JLabel jLMinimize;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginWindow window = new LoginWindow();
					window.frmWelcome.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginWindow() {
		initialize();
	}

	public void hintText(String text) {
		if (tFEmail.getText().isEmpty()) {
			tFEmail.setForeground(Color.GRAY);
			tFEmail.setFont(new Font("Tahoma", Font.ITALIC, 14));

			tFEmail.setText(text);
		}

	}// hintText Ends here

	public void defaultText() {

		tFEmail.setForeground(Color.BLACK);
		// tFEmail.setToolTipText("Please enter your email address here");
		tFEmail.setFont(new Font("Tahoma", Font.PLAIN, 17));

	}// defaultText Ends here

	public void changephoto(String pos) {

//	String pos_string=Integer.toString(pos);
//	String iconlink="C:\\GitHub\\Peek-a-boo-LoginPage\\src\\Images\\Moveable\\"+pos+".png";
		ImageIcon imageIcon = new ImageIcon(
				new ImageIcon(LoginWindow.class.getResource("/Images/Moveable/" + pos + ".png")).getImage()
						.getScaledInstance(190, 190, Image.SCALE_DEFAULT));
		jl1.setIcon(imageIcon);

	}

	public void validation(String email, String pass) {

		if (email.equals("waleedahmed2021@gmail.com")) {

			if (pass.equals("12345")) {

				jlResult.setText("Login Success");
				changephoto("default");

			} else {
				jlResult.setText("Incorrect Password");
				changephoto("confuse");
			}

		} else {
			jlResult.setText("Incorrect Email.");
			changephoto("confuse");
		}

	}// Validation()

	public void char_counter() {
		int[] myIntArray = new int[30];
		System.out.println("Total Chars right now is: ");
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmWelcome = new JFrame();
		frmWelcome.setUndecorated(true);
		frmWelcome.setTitle("Welcome");
		// frame.setBounds(0, 0, 650, 600);
		frmWelcome.setSize(450, 650);
		frmWelcome.setLocationRelativeTo(null);
		frmWelcome.setResizable(false);
		frmWelcome.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frmWelcome.getContentPane().setLayout(null);
		jl1.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
			}
		});
		jl1.setBounds(105, 125, 243, 204);

		changephoto("default");

		btnLogIn = new JButton("Log In..");
		btnLogIn.setBorder(null);
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// log In button here
				String email0 = tFEmail.getText();
				String pass0 = tFPass.getText();
				// jlResult.setText(jpasswordField.getText());
				validation(email0, pass0);
				
				

			}
		});
		
		tEmailHint = new JTextField();
		tEmailHint.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				if(tFEmail.getText().isEmpty()) {
					tFEmail.setEnabled(true);
					tFEmail.setVisible(true);
					tEmailHint.setEnabled(false);
					tEmailHint.setVisible(true);}
			}
		});
		tEmailHint.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(tFEmail.getText().isEmpty()) {
				tFEmail.setEnabled(true);
				tFEmail.setVisible(true);
				tEmailHint.setEnabled(false);
				tEmailHint.setVisible(true);}
			}
		});
		
		tFPassHint = new JTextField();
		tFPassHint.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				
                    
					
					
					tFPass.setEnabled(true);
					tFPass.setVisible(true);
					tFPassHint.setEnabled(false);
					tFPassHint.setVisible(false);
					
				//	tFEmailHint.setEnabled(false);
				
				
			}
		});
		tFPassHint.setEditable(false);
		tFPassHint.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			//	if(tFPass.getText().isEmpty()) {
					tFPass.setEnabled(true);
					tFPass.setVisible(true);
					tFPassHint.setEnabled(false);
					tFPassHint.setVisible(false);}
		//	}
		});
		
		JLabel jLCross = new JLabel("");
		jLCross.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		jLCross.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				//frmWelcome.dispose();
				System.exit(0);
			}
		});
		
		jLMinimize = new JLabel("");
		jLMinimize.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		jLMinimize.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				frmWelcome.setState(JFrame.ICONIFIED);
			}
		});
		jLMinimize.setBounds(410, 0, 15, 22);
		frmWelcome.getContentPane().add(jLMinimize);
		jLCross.setBounds(428, 0, 17, 22);
		frmWelcome.getContentPane().add(jLCross);
		tFPassHint.setToolTipText("Please enter your email address here");
		tFPassHint.setText("Password");
		tFPassHint.setForeground(Color.GRAY);
		tFPassHint.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tFPassHint.setDisabledTextColor(Color.WHITE);
		tFPassHint.setColumns(10);
		tFPassHint.setBackground(UIManager.getColor("InternalFrame.inactiveTitleGradient"));
		tFPassHint.setBounds(88, 390, 259, 34);
		frmWelcome.getContentPane().add(tFPassHint);
		tEmailHint.setText("Username");
		tEmailHint.setToolTipText("Please enter your email address here");
		tEmailHint.setForeground(Color.GRAY);
		tEmailHint.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tEmailHint.setDisabledTextColor(Color.WHITE);
		tEmailHint.setColumns(10);
		tEmailHint.setBackground(UIManager.getColor("InternalFrame.inactiveTitleGradient"));
		tEmailHint.setBounds(88, 345, 259, 34);
		frmWelcome.getContentPane().add(tEmailHint);
		jlResult.setHorizontalAlignment(SwingConstants.CENTER);
		jlResult.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));

		jlResult.setBounds(122, 472, 184, 22);
		frmWelcome.getContentPane().add(jlResult);
		btnLogIn.setFont(new Font("Trebuchet MS", Font.BOLD, 19));
		btnLogIn.setBounds(158, 436, 119, 34);
		frmWelcome.getContentPane().add(btnLogIn);

		frmWelcome.getContentPane().add(jl1);

		tFEmail = new JTextField();
		tFEmail.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				
				if(tFEmail.getText().isEmpty()) {
					
					tEmailHint.setEnabled(true);
					tEmailHint.setVisible(true);
					tFEmail.setEnabled(false);
					tFEmail.setVisible(false);
					
				//	tFEmailHint.setEnabled(false);
				}
				else
				{
					tEmailHint.setEnabled(false);
					tEmailHint.setVisible(false);
					//tFEmail.setEnabled(false);
					//tFEmail.setVisible(false);
				}

			}
		});
		tFEmail.setEnabled(false);
		tFEmail.setVisible(false);
		

		

		tFEmail.setDisabledTextColor(Color.BLACK);
		tFEmail.setForeground(Color.BLACK);
		tFEmail.setToolTipText("Please enter your email address here");

		tFEmail.setBackground(UIManager.getColor("InternalFrame.inactiveTitleGradient"));
		tFEmail.setFont(new Font("Tahoma", Font.PLAIN, 17));
		// hintText();
		tFEmail.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				// key pressing prog here

				int txtfieldlen = tFEmail.getText().length();
				jLTemp.setText(Integer.toString(txtfieldlen + 1));

				if (txtfieldlen <= 2 && txtfieldlen >= 0) {

					changephoto("1");

				}

				else if (txtfieldlen <= 6 && txtfieldlen >= 3) {

					changephoto("3");

				}

				else if (txtfieldlen <= 10 && txtfieldlen >= 7) {

					changephoto("5");

				} else if (txtfieldlen <= 15 && txtfieldlen >= 11) {

					changephoto("7");

				} else if (txtfieldlen <= 20 && txtfieldlen >= 16) {

					changephoto("9");

				}

				else {

					changephoto("10");

				}

			}

			

			
			
			
		});

		tFEmail.setBounds(88, 345, 259, 34);
		frmWelcome.getContentPane().add(tFEmail);
		tFEmail.setColumns(10);

		jLTemp = new JLabel("0");
		jLTemp.setBounds(327, 571, 49, 14);
		frmWelcome.getContentPane().add(jLTemp);

		tFPass = new JPasswordField();
		tFPass.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				
                    if(tFPass.getText().isEmpty()) {
					
					tFPassHint.setEnabled(true);
					tFPassHint.setVisible(true);
					tFPass.setEnabled(false);
					tFPass.setVisible(false);
					
				//	tFEmailHint.setEnabled(false);
				}
			}
		});
		tFPass.setVisible(false);
		tFPass.setEnabled(false);
		tFPass.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {

				// Password key pressed here
				String iconlink = "C:\\GitHub\\Peek-a-boo-LoginPage\\src\\Images\\Moveable\\11.png";
				// ImageIcon imageIcon = new ImageIcon(new
				// ImageIcon(iconlink).getImage().getScaledInstance(190, 190,
				// Image.SCALE_DEFAULT));
				ImageIcon imageIcon = new ImageIcon(
						new ImageIcon(LoginWindow.class.getResource("/Images/Moveable/11.png")).getImage()
								.getScaledInstance(190, 190, Image.SCALE_DEFAULT));
				jl1.setIcon(imageIcon);

			}
		});
		tFPass.setBackground(UIManager.getColor("InternalFrame.inactiveTitleGradient"));
		tFPass.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tFPass.setBounds(88, 390, 259, 34);
		frmWelcome.getContentPane().add(tFPass);

		jLBG = new JLabel("");
		
		jLBG.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				// String
				// iconlink="C:\\GitHub\\Peek-a-boo-LoginPage\\src\\Images\\Moveable\\default.png";
				// String
				// iconlink=getClass().getResource("Peek-a-boo-LoginPage/Images/Image1.png");
				// ImageIcon icon = new
				// ImageIcon(LoginWindoww.class.getResource("/Images/Image1.png"));
				ImageIcon imageIcon = new ImageIcon(
						new ImageIcon(LoginWindow.class.getResource("/Images/Moveable/default.png")).getImage()
								.getScaledInstance(190, 190, Image.SCALE_DEFAULT));
				jl1.setIcon(imageIcon);
				

			}
		});

		jLBG.setBounds(0, 0, 450, 650);
		ImageIcon imageIcon2 = new ImageIcon(new ImageIcon(LoginWindow.class.getResource("/Images/PanelBg5.png"))
				.getImage().getScaledInstance(450, 650, Image.SCALE_DEFAULT));
		//436, 623
		//jLBG.setIcon("C:\\GitHub\\Peek-a-boo-LoginPage\\src\\Images\\PanelBg5.png");
		// jLBG.setIcon(imageIcon2);
		jLBG.setIcon(new ImageIcon(LoginWindow.class.getResource("/Images/PanelBg9.png")));

//			final BufferedImage img=new ImgUtils().scaleImage(436,623,bgImage);
		// create label with image as background
//			jLBG label=new jLBG(new ImageIcon((Image)img));

		frmWelcome.getContentPane().add(jLBG);
	}// initialize()
}// LoginWindow()
