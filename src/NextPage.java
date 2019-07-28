import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class NextPage  extends Template implements ActionListener
{

	JButton pack,unpack;
	JLabel label;
	NextPage(String value)
	{
		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		
		label = new JLabel ("Welcome :"+value);
		Dimension size = label.getPreferredSize();
		label.setBounds(40, 50, size.width, size.height);
		label.setForeground(Color.blue);
		label.setFont(new Font("Century",Font.BOLD,17));
		
		
		pack=new JButton("pack files");
		Dimension bsize = pack.getPreferredSize();
		pack.setBounds(100, 100, bsize.width, bsize.height);
		pack.addActionListener(this);
		
		unpack=new JButton("Unpack files");
		Dimension b2size = unpack.getPreferredSize();
		unpack.setBounds(300, 100, b2size.width, b2size.height);
		unpack.addActionListener(this);
		
		_header.add(label);
		_content.add(pack);
		_content.add(unpack);
	
		ClockHome();
		setVisible(true);
		this.setSize(500,500);
		this.setResizable(false);
		
	}
	
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		if(ae.getSource()==pack)
		{
			this.setVisible(false);
			try {
				PackFront obj = new PackFront();
				
			}
			catch(Exception e) {}
		}
		
		if(ae.getSource()==unpack)
		{
			this.setVisible(false);
			UnpackFront obj = new UnpackFront();
		}
	}
}
