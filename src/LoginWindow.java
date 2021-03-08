import java.awt.EventQueue;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import javax.swing.JPasswordField;
import java.awt.Font;
import javax.swing.UIManager;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.Cursor;
import java.awt.event.MouseMotionAdapter;
import javax.swing.border.LineBorder;


public class LoginWindow {
    
	//Declaring all components here
	private JFrame frmWelcome;
	public JTextField tFEmail;
	private JPasswordField tFPass;
	private JLabel jLBG;
	private JLabel jl1 = new JLabel("");
	private JButton btnLogIn;
	private JLabel jlResult = new JLabel("");
	private JTextField tEmailHint;
	private JTextField tFPassHint;
	private JLabel jLMinimize;
	

	/**
	 * main method
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
	}//main() method

	/**
	 * Create the GUI application.
	 */
	public LoginWindow() {
		initialize();
	}
	

	public void changephoto(String pos) {		
		//This method is responsible for changing Character photos.
		jl1.setIcon(new ImageIcon(LoginWindow.class.getResource("/Images/Moveable/"+pos+".png")));
		
	}//changephoto()
		

	public void validation(String email, String pass) {
		//Email & Password validation & verification.

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


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmWelcome = new JFrame();
		frmWelcome.setUndecorated(true);
		frmWelcome.setTitle("Welcome");
		frmWelcome.setSize(450, 650);
		frmWelcome.setLocationRelativeTo(null);
		frmWelcome.setResizable(false);
		frmWelcome.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frmWelcome.getContentPane().setLayout(null);
		jl1.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
			}
		});
		jl1.setBounds(105, 115, 220, 220);
		changephoto("default");

		btnLogIn = new JButton("Log In..");
		btnLogIn.setForeground(new Color(0, 0, 0));
		btnLogIn.setBackground(new Color(72, 61, 139));
		btnLogIn.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		btnLogIn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				//LogIn Btn
				//This btn take email & pass and throw them to validation method.
				String email0 = tFEmail.getText();
				String pass0 = tFPass.getText();
				validation(email0, pass0);
				
			}
		});
		
		tEmailHint = new JTextField();
		tEmailHint.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				//Using textfield for "username" hint.
				
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
			
			//Using textfield for "password" hint.
			public void focusGained(FocusEvent e) {
					
					tFPass.setEnabled(true);
					tFPass.setVisible(true);
					tFPassHint.setEnabled(false);
					tFPassHint.setVisible(false);				
				
			}
		});
		tFPassHint.setEditable(false);
		tFPassHint.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
					tFPass.setEnabled(true);
					tFPass.setVisible(true);
					tFPassHint.setEnabled(false);
					tFPassHint.setVisible(false);}
		
		});
		
		JLabel jLCross = new JLabel("");
		jLCross.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		jLCross.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//Custom window closing btn
				System.exit(0);
			}
		});
		
		jLMinimize = new JLabel("");
		jLMinimize.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		jLMinimize.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//Custom window minimizing btn
				frmWelcome.setState(JFrame.ICONIFIED);
			}
		});
		
		JLabel jLWindowBar = new JLabel("");
		jLWindowBar.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				//Window dragging using X,Y cordinates.
				int cordinatesX=e.getXOnScreen();
				int cordinatesY=e.getYOnScreen();
				
				frmWelcome.setLocation(cordinatesX,cordinatesY);
				
			}
		});
		//All components visual details
		jLWindowBar.setBounds(0, 0, 405, 22);
		frmWelcome.getContentPane().add(jLWindowBar);
		jLMinimize.setBounds(410, 0, 15, 22);
		frmWelcome.getContentPane().add(jLMinimize);
		jLCross.setBounds(428, 0, 17, 22);
		frmWelcome.getContentPane().add(jLCross);
		tFPassHint.setToolTipText("Please enter your Password here");
		tFPassHint.setText("Password");
		tFPassHint.setForeground(Color.GRAY);
		tFPassHint.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tFPassHint.setDisabledTextColor(Color.WHITE);
		tFPassHint.setColumns(10);
		tFPassHint.setBackground(UIManager.getColor("InternalFrame.inactiveTitleGradient"));
		tFPassHint.setBounds(88, 390, 259, 34);
		frmWelcome.getContentPane().add(tFPassHint);
		tEmailHint.setText("Username");
		tEmailHint.setToolTipText("Please enter your Email Address/Username here");
		tEmailHint.setForeground(Color.GRAY);
		tEmailHint.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tEmailHint.setDisabledTextColor(Color.WHITE);
		tEmailHint.setColumns(10);
		tEmailHint.setBackground(UIManager.getColor("InternalFrame.inactiveTitleGradient"));
		tEmailHint.setBounds(88, 345, 259, 34);
		frmWelcome.getContentPane().add(tEmailHint);
		jlResult.setForeground(Color.BLACK);
		jlResult.setHorizontalAlignment(SwingConstants.CENTER);
		jlResult.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));

		jlResult.setBounds(122, 472, 184, 22);
		frmWelcome.getContentPane().add(jlResult);
		btnLogIn.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
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
				}
				else
				{
					tEmailHint.setEnabled(false);
					tEmailHint.setVisible(false);
				}

			}
		});
		tFEmail.setEnabled(false);
		tFEmail.setVisible(false);
		

		

		tFEmail.setDisabledTextColor(Color.BLACK);
		tFEmail.setForeground(Color.BLACK);
		tFEmail.setToolTipText("Please enter your email address here");

		tFEmail.setBackground(UIManager.getColor("InternalFrame.inactiveTitleGradient"));
		tFEmail.setFont(new Font("Bahnschrift", Font.BOLD, 17));
		tFEmail.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				//Main logics behind character reactions.

				int txtfieldlen = tFEmail.getText().length();

				if (txtfieldlen <= 2 && txtfieldlen >= 0) {

					changephoto("1"); }

				else if (txtfieldlen <= 6 && txtfieldlen >= 3) {

					changephoto("3"); }

				else if (txtfieldlen <= 10 && txtfieldlen >= 7) {

					changephoto("5"); }
				
				else if (txtfieldlen <= 15 && txtfieldlen >= 11) {

					changephoto("7"); }

				else if (txtfieldlen <= 20 && txtfieldlen >= 16) {

					changephoto("9"); }

				else {

					changephoto("10"); }

			}//keypressed

		});

		tFEmail.setBounds(88, 345, 259, 34);
		frmWelcome.getContentPane().add(tFEmail);
		tFEmail.setColumns(10);

		tFPass = new JPasswordField();
		tFPass.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				
                    if(tFPass.getText().isEmpty()) {
					
					tFPassHint.setEnabled(true);
					tFPassHint.setVisible(true);
					tFPass.setEnabled(false);
					tFPass.setVisible(false);
				}
			}
		});
		tFPass.setVisible(false);
		tFPass.setEnabled(false);
		tFPass.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {

				// Password key
				
				changephoto("11");

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
				
				changephoto("default"); 
				}//mouseclicked
		});

		jLBG.setBounds(0, 0, 450, 650);
		jLBG.setIcon(new ImageIcon(LoginWindow.class.getResource("/Images/PanelBg.png")));
		frmWelcome.getContentPane().add(jLBG);
	}// initialize()
}// LoginWindow()
