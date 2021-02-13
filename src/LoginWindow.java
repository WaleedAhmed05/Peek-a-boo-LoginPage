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

public class LoginWindow {

	private JFrame frmWelcome;
	private JTextField tFEmail;
	private JLabel jLTemp;
	private JPasswordField jpasswordField;
	private JLabel jLBG;
	private JLabel jl1 = new JLabel("");
	private JButton btnLogIn;
	private JLabel jlResult = new JLabel("");

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
	

public void changephoto(String pos) {
		
//	String pos_string=Integer.toString(pos);
//	String iconlink="C:\\GitHub\\Peek-a-boo-LoginPage\\src\\Images\\Moveable\\"+pos+".png";
	ImageIcon imageIcon = new ImageIcon(new ImageIcon(LoginWindow.class.getResource("/Images/Moveable/"+pos+".png")).getImage().getScaledInstance(190, 190, Image.SCALE_DEFAULT));
	jl1.setIcon(imageIcon);
	
}

public void validation(String email, String pass) {
		
	
	if(email.equals("waleedahmed2021@gmail.com")) {
		
		
		if(pass.equals("12345")) {
			
			jlResult.setText("Login Success");
			changephoto("default");
			
			
		}
		else
		{
			jlResult.setText("Incorrect Password");
		    changephoto("confuse");}
		
		    
	}
	else
	{		
		jlResult.setText("Incorrect Email.");
		changephoto("confuse");}
		
		
}//Validation()
	


public void char_counter() {
	int[] myIntArray = new int[30];
	System.out.println("Total Chars right now is: ");
}
	
	
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmWelcome = new JFrame();
		frmWelcome.setTitle("Welcome");
		//	frame.setBounds(0, 0, 650, 600);
			frmWelcome.setSize(450, 650);
			frmWelcome.setLocationRelativeTo(null); 
			frmWelcome.setResizable(false);
			frmWelcome.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
			
			
			
			frmWelcome.getContentPane().setLayout(null);
			jl1.addPropertyChangeListener(new PropertyChangeListener() {
				public void propertyChange(PropertyChangeEvent evt) {
				}
			});
			jl1.setBounds(122, 107, 243, 204);
			
			changephoto("default");
			
			btnLogIn = new JButton("Log In..");
			btnLogIn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//log In button here
					String email0=tFEmail.getText();
					String pass0=jpasswordField.getText();
				//	jlResult.setText(jpasswordField.getText());
					validation(email0,pass0);
					
					
				}
			});
			jlResult.setHorizontalAlignment(SwingConstants.CENTER);
			jlResult.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
			
			
			jlResult.setBounds(122, 472, 184, 22);
			frmWelcome.getContentPane().add(jlResult);
			btnLogIn.setFont(new Font("Trebuchet MS", Font.BOLD, 19));
			btnLogIn.setBounds(158, 436, 119, 34);
			frmWelcome.getContentPane().add(btnLogIn);
			
						
			
			frmWelcome.getContentPane().add(jl1);
			
			tFEmail = new JTextField();
			tFEmail.setBackground(UIManager.getColor("InternalFrame.inactiveTitleGradient"));
			tFEmail.setFont(new Font("Tahoma", Font.PLAIN, 17));
			tFEmail.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					//key pressing prog here
					
					
					
					int txtfieldlen=tFEmail.getText().length();
					jLTemp.setText(Integer.toString(txtfieldlen+1));
					
					if(txtfieldlen<=2 && txtfieldlen>=0)  {
						
						changephoto("1");
						
					}
					
					
					else if(txtfieldlen<=6 && txtfieldlen>=3)  {
						
						
						changephoto("3");
						
					}
					
					
                    else if(txtfieldlen<=10 && txtfieldlen>=7)  {
						
						
                    	changephoto("5");
						
					}
					else if(txtfieldlen<=15 && txtfieldlen>=11)  {
						
						
                    	changephoto("7");
						
					}
					else if(txtfieldlen<=20 && txtfieldlen>=16)  {
						
						
                    	changephoto("9");
						
					}
					
                    else  {
						
						
                    	changephoto("10");
						
					}
					
															
				}
				@Override
				public void keyReleased(KeyEvent e) {
					
					//key release prog here
					String iconlink="C:\\GitHub\\Peek-a-boo-LoginPage\\src\\Images\\Moveable\\11.png";
					ImageIcon imageIcon = new ImageIcon(new ImageIcon(iconlink).getImage().getScaledInstance(190, 190, Image.SCALE_DEFAULT));
			//		jl1.setIcon(imageIcon);
				}
				
				
			});
			tFEmail.setBounds(88, 345, 259, 34);
			frmWelcome.getContentPane().add(tFEmail);
			tFEmail.setColumns(10);
			
			jLTemp = new JLabel("0");
			jLTemp.setBounds(327, 571, 49, 14);
			frmWelcome.getContentPane().add(jLTemp);
			
			jpasswordField = new JPasswordField();
			jpasswordField.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					
					//Password key pressed here
					String iconlink="C:\\GitHub\\Peek-a-boo-LoginPage\\src\\Images\\Moveable\\11.png";
					//ImageIcon imageIcon = new ImageIcon(new ImageIcon(iconlink).getImage().getScaledInstance(190, 190, Image.SCALE_DEFAULT));
					ImageIcon imageIcon = new ImageIcon(new ImageIcon(LoginWindow.class.getResource("/Images/Moveable/11.png")).getImage().getScaledInstance(190, 190, Image.SCALE_DEFAULT));
					jl1.setIcon(imageIcon);
					
				}
			});
			jpasswordField.setBackground(UIManager.getColor("InternalFrame.inactiveTitleGradient"));
			jpasswordField.setFont(new Font("Tahoma", Font.PLAIN, 15));
			jpasswordField.setBounds(88, 390, 259, 34);
			frmWelcome.getContentPane().add(jpasswordField);
			
			jLBG = new JLabel("New label");
			jLBG.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					
					//String iconlink="C:\\GitHub\\Peek-a-boo-LoginPage\\src\\Images\\Moveable\\default.png";
					//String iconlink=getClass().getResource("Peek-a-boo-LoginPage/Images/Image1.png");
					//ImageIcon icon = new ImageIcon(LoginWindoww.class.getResource("/Images/Image1.png"));
					ImageIcon imageIcon = new ImageIcon(new ImageIcon(LoginWindow.class.getResource("/Images/Moveable/default.png")).getImage().getScaledInstance(190, 190, Image.SCALE_DEFAULT));
					jl1.setIcon(imageIcon);
					
				}
			});
			
			jLBG.setBounds(0, 0, 436, 623);
			//String bgImage="C:\\GitHub\\Peek-a-boo-LoginPage\\src\\Images\\PanelBg5.jpg";
			ImageIcon imageIcon2 = new ImageIcon(new ImageIcon(LoginWindow.class.getResource("/Images/PanelBg5.jpg")).getImage().getScaledInstance(436, 623, Image.SCALE_DEFAULT));
			jLBG.setIcon(imageIcon2);
			
//			final BufferedImage img=new ImgUtils().scaleImage(436,623,bgImage);
			//create label with image as background
//			jLBG label=new jLBG(new ImageIcon((Image)img));
			
			
			
			
     		frmWelcome.getContentPane().add(jLBG);
	}//initialize()
}//LoginWindow()



