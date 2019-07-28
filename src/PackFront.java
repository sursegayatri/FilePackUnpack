import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.JFileChooser;
public class PackFront extends Template implements ActionListener {

	
	JButton SUBMIT,PREVIOUS;
	JLabel label1,label2,title ;
	final JTextField text1,text2;
	public PackFront()
	{
		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		
		title = new JLabel ("Packing Portal ");
		Dimension size = title.getPreferredSize();
		title.setBounds(40, 50, size.width+60, size.height);
		title.setForeground(Color.blue);
		title.setFont(new Font("Century",Font.BOLD,17));
		
		label1 = new JLabel ();
		label1.setText("Directory name ");
		label1.setBounds(350, 50, size.width, size.height);
		label1.setForeground(Color.white);
		
        
		text1 = new JTextField(15);
		Dimension tsize = text1.getPreferredSize();
		text1.setBounds(500, 50, tsize.width, tsize.height);
		text1.setToolTipText("Enter the name of the directory");
		
		
		label2 = new JLabel ();
		label2.setText("destination file name ");
		label2.setBounds(350, 100, size.width+60, size.height);
		label2.setForeground(Color.white);
		
		text2 = new JTextField(15);
		text2.setBounds(500, 100, tsize.width, tsize.height);
		text2.setToolTipText("Enter destination file name");
		
		
		SUBMIT = new JButton("SUBMIT");
		Dimension ssize = SUBMIT.getPreferredSize();
		SUBMIT.setBounds(350, 200, ssize.width, ssize.height);
		SUBMIT.addActionListener(this);
		
		PREVIOUS = new JButton("PREVIOUS");
		Dimension bsize = PREVIOUS.getPreferredSize();
		PREVIOUS.setBounds(500, 200, bsize.width, bsize.height);
		PREVIOUS.addActionListener(this);
		
		_header.add(title);
		_content.add(label1);
		_content.add(label2);
		_content.add(text1);
		_content.add(text2);
		_content.add(SUBMIT);
		_content.add(PREVIOUS);
		
		setVisible(true);
		this.setSize(1000,400);
		this.setResizable(false);
		text1.requestFocusInWindow();
		
	}
	
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		if(ae.getSource() == exit)
		{
			this.setVisible(false);
			System.exit(0);
		}
		
		if(ae.getSource() == minimize)
		{
			
			setState(JFrame.ICONIFIED);
		}
		
		if(ae.getSource()==SUBMIT)
		{
			this.setVisible(false);
			try {
				Packer obj = new Packer(text1.getText(),text2.getText());
				this.dispose();
				NextPage t = new NextPage("Admin");
				
			}
			catch(Exception e) {}
		}
		
		if(ae.getSource()==PREVIOUS)
		{
			this.setVisible(false);
			this.dispose();
			NextPage t = new NextPage("Admin");
			}
	}

	
}

