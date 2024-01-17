import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyPanel extends JPanel implements ActionListener{
	
	final int panelw = 500;
	final int panelh = 500;
	Image question;
	Image question2;
	Image backgroundImage;
	Timer timer;
	int xvelocity = 1;
	int yvelocity = 1;
	int x =0;
	int y = 0;
	
	
	MyPanel(){
		
		this.setPreferredSize(new Dimension(panelw,panelh));
		this.setBackground(Color.white);
		question = new ImageIcon("question-mark-icon-41638.png").getImage();
		question2 = new ImageIcon("question-mark-icon-41638.png").getImage();
		backgroundImage = new ImageIcon("turkeyview.png").getImage();
		timer = new Timer(10,this);
		timer.start();
	}
	
	public void paint(Graphics g) {
		super.paint(g); //paint backgorund
		Graphics2D g2D = (Graphics2D) g;
		g2D.drawImage(backgroundImage,0,0,null);
		g2D.drawImage(question,x,y,null);
		g2D.drawImage(question2,250,y, null);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(y>= panelw-question2.getWidth(null) || y<0) {
			yvelocity = yvelocity * -1;
		}
		y = y + yvelocity;
		repaint();
		
		if(y>= panelw-question.getWidth(null) || y<0) {
			yvelocity = yvelocity * -1;
		}
		y = y + yvelocity;
		repaint();
		
	}

}
