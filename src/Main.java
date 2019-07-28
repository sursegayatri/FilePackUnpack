import java.awt.Color;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.*;
import javax.swing.JOptionPane;



class MarvellousLogin extends Template implements ActionListener
{

	JButton SUBMIT;
	JLabel label1,label2,label3,TopLabel ;
	final JTextField text1,text2;
	private static int attempt=3;
	
	MarvellousLogin()
	{
		TopLabel = new JLabel();
		TopLabel.setHorizontalAlignment(SwingConstants.CENTER);
		TopLabel.setText("Packer Unpacker:Login");
		TopLabel.setForeground(Color.BLUE);
		
		Dimension topsize = TopLabel.getPreferredSize();
		TopLabel.setBounds(50,40,topsize.width,topsize.height);
		_header.add(TopLabel);
		
		
		label1 =new JLabel();
		label1.setText("Username");
		label1.setForeground(Color.white);
		Dimension size = label1.getPreferredSize();
		label1.setBounds(50,135,size.width,size.height);
		label1.setForeground(Color.white);
		label1.setHorizontalAlignment(SwingConstants.CENTER);
		
		text1 =new JTextField(15);
		Dimension tsize = text1.getPreferredSize();
		text1.setBounds(200,135,tsize.width,tsize.height);
		text1.setToolTipText("ENTER USERNAME ");
		
		
		label2 =new JLabel();
		label2.setText("Password");
		label2.setForeground(Color.white);
		label2.setBounds(50,175,size.width,size.height);
		label2.setForeground(Color.white);
		label2.setHorizontalAlignment(SwingConstants.CENTER);
		
		text2 =new JPasswordField(15);
		text2.setBounds(200,175,tsize.width,tsize.height);
		text2.setToolTipText("ENTER PASSWORD ");
		
		text2.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				label3.setText("");
			}
			
		});
		
		SUBMIT = new JButton("SUBMIT");
		SUBMIT.setHorizontalAlignment(SwingConstants.CENTER);
		Dimension ssize = SUBMIT.getPreferredSize();
		SUBMIT.setBounds(50, 220, ssize.width, ssize.height);
		
		label3 = new JLabel();
		label3.setText("");
		Dimension l3size = label3.getPreferredSize();
		label3.setBounds(50, 220, l3size.width, l3size.height);
		
		Thread t = new Thread();
		t.start();
		_content.add(label1);
		_content.add(text1);
		_content.add(label2);
		_content.add(text2);
		
		_content.add(label3);
		_content.add(SUBMIT);
		
		pack();
		validate();
		
		ClockHome();
		setVisible(true);
		this.setSize(500,500);
		this.setResizable(false);
		setLocationRelativeTo(null);
		SUBMIT.addActionListener(this);
		
		
	}
	public boolean Validate(String username,String password)
	{
		if((username.length()<8) || (password.length()<8))
			return false;
		else
			return true;
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		String value1 = text1.getText();
		String value2 = text2.getText();
		
		if(ae.getSource() == exit)
		{
			this.setVisible(false);
			System.exit(0);
		}
		
		if(ae.getSource() == minimize)
		{
			
			setState(JFrame.ICONIFIED);
		}
		if(ae.getSource() == SUBMIT)
		{
			if(Validate(value1,value2)==false)
			{
				text1.setText("");
				text2.setText("");
				JOptionPane.showMessageDialog(this,"short username","PACKER UNPACKER ",JOptionPane.ERROR_MESSAGE);
				
				
			}
			if(value1.equals("admin1234") && value2.equals("admin1234"))
			{
				NextPage page =new NextPage(value1);
				this.setVisible(false);
				page.pack();
				page.setVisible(true);
				page.setSize(500,500);
			}
			else
			{
				attempt--;
				if(attempt==0)
				{
					JOptionPane.showMessageDialog(this,"Number of attempts finished","PACKER UNPACKER ",JOptionPane.ERROR_MESSAGE);
					this.dispose();
					System.exit(0);
				}
				JOptionPane.showMessageDialog(this,"Incorrect login or password","Error",JOptionPane.ERROR_MESSAGE);
				
			}
				
		}
			

	}
	
	public void run() {
		for(;;)
		{
			if(text2.isFocusOwner())
			{
				if(Toolkit.getDefaultToolkit().getLockingKeyState(KeyEvent.VK_CAPS_LOCK))
					text2.setToolTipText("Warning : CAPS LOCK is on");
				else
						text2.setToolTipText("");
				
				if(text2.getText().length()<8)
					label3.setText("weak password");
				else
					label3.setText("");
			}
		}
	}
	
}
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		try
		{
			MarvellousLogin frame =new MarvellousLogin();
			frame.setVisible(true);
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null,e.getMessage());
			e.printStackTrace();		}
	}

}
