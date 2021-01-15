import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

public class LoginWindoww {

	private JFrame frmWelcome;
	private JTextField tFEmail;
	private JLabel jLTemp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginWindoww window = new LoginWindoww();
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
	public LoginWindoww() {
		initialize();
	}
	
	
	
public void photochanger(String loc) {
		
		String iconlink="C:\\GitHub\\Peek-a-boo-LoginPage\\src\\Images\\Image5.jpg";
		ImageIcon imageIcon = new ImageIcon(new ImageIcon(iconlink).getImage().getScaledInstance(190, 190, Image.SCALE_DEFAULT));
//		jl1.setIcon(imageIcon);
		
	}

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
			
			JLabel jl1 = new JLabel("");
			jl1.addPropertyChangeListener(new PropertyChangeListener() {
				public void propertyChange(PropertyChangeEvent evt) {
				}
			});
			jl1.setBounds(122, 107, 243, 204);
			
			//temp code here
			String iconlink="C:\\GitHub\\Peek-a-boo-LoginPage\\src\\Images\\Image1.png";
			ImageIcon imageIcon = new ImageIcon(new ImageIcon(iconlink).getImage().getScaledInstance(190, 190, Image.SCALE_DEFAULT));
			jl1.setIcon(imageIcon);
			
			
			
			
			
			
			
			//temp code here
			
		//	ImageIcon imgThisImg = new ImageIcon("Image1.png");
			//jl1.setIcon(new ImageIcon("Images/Image1.png"));
	//real		jl1.setIcon(new ImageIcon("C:\\GitHub\\Peek-a-boo-LoginPage\\src\\Images\\Image3.png"));
			frmWelcome.getContentPane().add(jl1);
			
			tFEmail = new JTextField();
			tFEmail.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					//key pressing prog here
					String iconlink="C:\\GitHub\\Peek-a-boo-LoginPage\\src\\Images\\Image4.png";
					ImageIcon imageIcon = new ImageIcon(new ImageIcon(iconlink).getImage().getScaledInstance(190, 190, Image.SCALE_DEFAULT));
					jl1.setIcon(imageIcon);
					
					int txtfieldlen=tFEmail.getText().length();
					jLTemp.setText(Integer.toString(txtfieldlen));
					
				}
				@Override
				public void keyReleased(KeyEvent e) {
					
					//key release prog here
					String iconlink="C:\\GitHub\\Peek-a-boo-LoginPage\\src\\Images\\Image5.jpg";
					ImageIcon imageIcon = new ImageIcon(new ImageIcon(iconlink).getImage().getScaledInstance(190, 190, Image.SCALE_DEFAULT));
					jl1.setIcon(imageIcon);
				}
				
				
			});
			tFEmail.setBounds(88, 395, 259, 34);
			frmWelcome.getContentPane().add(tFEmail);
			tFEmail.setColumns(10);
			
			jLTemp = new JLabel("0");
			jLTemp.setBounds(327, 571, 49, 14);
			frmWelcome.getContentPane().add(jLTemp);
	}
	
}
