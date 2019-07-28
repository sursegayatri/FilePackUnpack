import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import javax.swing.*;
import javax.swing.plaf.basic.BasicBorders;
import javax.swing.JFrame;
import java.util.Date;;
class ClockLabel extends JLabel implements ActionListener{

	
	
	String type;
	SimpleDateFormat sdf;
	public ClockLabel(String type)
	{
		this.type=type;
		setForeground(Color.green);
		switch(type)
		{
		case "date" : sdf = new SimpleDateFormat(" MMMM dd yyyy");
						setFont(new Font("sans-serif",Font.PLAIN,12));
						setHorizontalAlignment(SwingConstants.LEFT);
						break;
						
		case "time" : sdf = new SimpleDateFormat("hh:mm:ss a");
		setFont(new Font("sans-serif",Font.PLAIN,40));
		setHorizontalAlignment(SwingConstants.CENTER);
		break;
		
		
		case "day" : sdf = new SimpleDateFormat(" EEEE");
		setFont(new Font("sans-serif",Font.PLAIN,16));
		setHorizontalAlignment(SwingConstants.RIGHT);
		break;
		
		
		default : sdf =new SimpleDateFormat();
					break;
		}
		Timer t =new Timer(1000,this);
		t.start();
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Date d = new Date();
		setText(sdf.format(d));
	}
	
}

class Template extends JFrame implements ActionListener {

	
	JPanel _header;
	JPanel _content;
	JPanel _top;
	
	ClockLabel daylabel;
	ClockLabel timelabel;
	ClockLabel datelabel;
	JButton minimize,exit;
	
	public Template()
	{
		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		GridBagLayout grid = new GridBagLayout();
		setLayout(grid);
		
		_top = new JPanel();
		_top.setBackground(Color.LIGHT_GRAY);
		_top.setLayout(null);
		
		getContentPane().add(_top,new GridBagConstraints(0,0,1,1,1,5,GridBagConstraints.BASELINE,GridBagConstraints.BOTH,new Insets(0,0,0,0),0,0));
		
		_header = new JPanel();
		_header.setBackground(Color.WHITE);
		_header.setLayout(null);
		
		getContentPane().add(_header,new GridBagConstraints(0,1,1,1,1,20,GridBagConstraints.BASELINE,GridBagConstraints.BOTH,new Insets(0,0,0,0),0,0));
		
		_content = new JPanel();
		_content.setBackground( new Color(0,50,120));
		_content.setLayout(null);
		
		getContentPane().add(_content,new GridBagConstraints(0,2,1,1,1,75,GridBagConstraints.BASELINE,GridBagConstraints.BOTH,new Insets(0,0,0,0),0,0));
		setTitle("Packer Unpacker ");
		
		Clock();
		CloseAndMin();
		
	}
	void CloseAndMin()
	{
		minimize = new JButton("-");
		minimize.setBackground(Color.LIGHT_GRAY);
		minimize.setBounds(MAXIMIZED_HORIZ,0,45,20);
		
		exit = new JButton("x");
		exit.setBackground(Color.LIGHT_GRAY);
		exit.setHorizontalAlignment(SwingConstants.CENTER);
		exit.setHorizontalTextPosition(0);
		exit.setBounds(MAXIMIZED_HORIZ+45,0,45,20);

		_top.add(minimize);
		_top.add(exit);
		
		exit.addActionListener(this);
		minimize.addActionListener(this);
		
		
	}
	
	
	@Override
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
	}
	
	void Clock()
	{
		datelabel =new ClockLabel("date");
		timelabel =new ClockLabel("time");
		daylabel =new ClockLabel("day");
		
		datelabel.setForeground(Color.blue);
		timelabel.setForeground(Color.blue);
		daylabel.setForeground(Color.blue);
		
		daylabel.setFont(new Font("Century",Font.BOLD,15));
		daylabel.setBounds(700,10,200,100);
		
		datelabel.setFont(new Font("Century",Font.BOLD,15));
		datelabel.setBounds(800, -40, 200, 100);
		
		timelabel.setFont(new Font("Century",Font.BOLD,15));
		timelabel.setBounds(760, -15, 200, 100);
		
		_header.add(datelabel);
		_header.add(timelabel);
		_header.add(daylabel);
		
		
	}
	
	void ClockHome()
	{
		datelabel =new ClockLabel("date");
		timelabel =new ClockLabel("time");
		daylabel =new ClockLabel("day");
		
		datelabel.setForeground(Color.blue);
		timelabel.setForeground(Color.blue);
		daylabel.setForeground(Color.blue);
		
		daylabel.setFont(new Font("Century",Font.BOLD,15));
		daylabel.setBounds(200,20,200,100);
		
		datelabel.setFont(new Font("Century",Font.BOLD,15));
		datelabel.setBounds(300, -40, 200, 100);
		
		timelabel.setFont(new Font("Century",Font.BOLD,15));
		timelabel.setBounds(260, -10, 200, 100);
		
		_header.add(datelabel);
		_header.add(timelabel);
		_header.add(daylabel);
			
	}
}
