import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;


public class Entry {
public static void main(String[] args) {
	Mainframe frm=new Mainframe();
}
}
class Mainframe extends JFrame {
	public Mainframe()
{
	setLayout(null);
setTitle("Bouncing Recangle");
setVisible(true);
setBounds(0,0,500,500);
JButton btn=new JButton("add");
btn.setBounds(50,50,100,20);
add(btn);
btn.addActionListener(new ButtonHandler(this));
setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
}
}
class ButtonHandler implements ActionListener {
Mainframe frm;
public ButtonHandler(Mainframe f)
{
	frm=f;
}
	
	public void actionPerformed(ActionEvent arg0) {
	System.out.println("button clicked");
BouncingRect objThread=new BouncingRect(frm);
objThread.start();
	}
}
class BouncingRect extends Thread
{
	Mainframe x;
	public BouncingRect(Mainframe frm)
	{
		x=frm;
	}
	public void run()
	{
		Graphics grp=x.getGraphics();
		int xpos=100,ypos=100;
		grp.setXORMode(Color.white);
		while(true)
		{
		grp.drawRect(xpos,ypos,100,50);
		xpos++;
		ypos++;
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
}