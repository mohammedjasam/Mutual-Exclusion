import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JSlider;
import javax.swing.JButton;
import javax.swing.JComponent;

public class GUI {
	int pixelMovement1=5;
	int pixelMovement2=5;
	int pixelMovement3=5;
	int pixelMovement4=5;
	public class DrawingPanel extends JPanel {
		@Override
		public void paintComponent(Graphics g) {			
			super.paintComponent(g);
			
			g.translate(200, -100);
			//Drawing circles 1 through 4
			g.setColor(Color.BLUE);
			drawCircle(g,cx1,cy1,r);
			g.setColor(Color.BLACK);
			drawCircle(g,cx2,cy2,r);
			g.setColor(Color.MAGENTA);
			drawCircle(g,cx3,cy3,r);
			g.setColor(Color.ORANGE);
			drawCircle(g,cx4,cy4,r);
			
			//Drawing lines 1 through 7  
			g.setColor(Color.BLACK);
			g.drawLine(line1x1,line1y1,line1x2,line1y2);
			g.drawLine(line2x1,line2y1,line2x2,line2y2);
			g.drawLine(line3x1,line3y1,line3x2,line3y2);
			g.drawLine(line4x1,line4y1,line4x2,line4y2);
			g.drawLine(line5x1,line5y1,line5x2,line5y2);
			g.drawLine(line6x1,line6y1,line6x2,line6y2);
			g.drawLine(line7x1,line7y1,line7x2,line7y2);
		}
		
		
		public void drawCircle(Graphics g, int x, int y, int r) {
		   x = x-(r/2);
		   y = y-(r/2);
		   g.fillOval(x,y,r,r);
	    }
	}
	
	int durationint=500;	//Duration of animation
	int r=20;				//Radius of all the circles
	
	int cx1=250,cy1=250;   	//Circle 1 params
	int cx2=250,cy2=350;   	//Circle 2 params
	int cx3=750,cy3=250;	//Circle 3 params 
	int cx4=750,cy4=350;	//Circle 4 params

	int line1x1=cx1,line1y1=150,line1x2=cx1,line1y2=450;					//Line 1
	int line2x1=cx3,line2y1=line1y1,line2x2=cx3,line2y2=line1y2;			//Line 2
	int line3x1=line1x1,line3y1=line1y1,line3x2=400,line3y2=300;			//Line 3
	int line4x1=line1x2,line4y1=line1y2,line4x2=line3x2,line4y2=line3y2;	//Line 4
	int line5x1=line4x2,line5y1=line4y2,line5x2=line4x2+200,line5y2=line4y2;//Line 5
	int line6x1=line5x2,line6y1=line5y2,line6x2=line2x1,line6y2=line2y1;	//Line 6
	int line7x1=line6x1,line7y1=line6y1,line7x2=line2x2,line7y2=line2y2;	//Line 7
	
	JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	DrawingPanel drawingPanel;
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(0, 0, 1366, 718);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		drawingPanel = new DrawingPanel();
		drawingPanel.setBackground(Color.WHITE);
		drawingPanel.setBounds(0, 0, 1342, 464);
		frame.getContentPane().add(drawingPanel);
		
		JPanel Control = new JPanel();
		Control.setBounds(0, 465, 1342, 189);
		frame.getContentPane().add(Control);
		
		JLabel Pink_L = new JLabel("Pink");
		Pink_L.setBounds(230, 22, 34, 23);
		Pink_L.setHorizontalAlignment(SwingConstants.CENTER);
		
		JSlider Pink_slider = new JSlider();
		Pink_slider.setValue(5);
		Pink_slider.setPaintTicks(true);
		Pink_slider.setMajorTickSpacing(5);
		Pink_slider.setMinorTickSpacing(1);
		Pink_slider.setMinimum(5);
		Pink_slider.setMaximum(20);
		Pink_slider.setBounds(463, 19, 250, 26);
		
		Pink_slider.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				JSlider source = (JSlider)e.getSource();
//				System.out.println("The Value of Pink has change to "+ source.getValue());
				pixelMovement1=source.getValue();
			}
		});
		
		JButton ChangeMode_btn = new JButton("Change Mode");
		ChangeMode_btn.setBounds(1009, 38, 206, 132);
		
		JLabel Black_L = new JLabel("Black");
		Black_L.setBounds(230, 56, 43, 23);
		Black_L.setHorizontalAlignment(SwingConstants.CENTER);
		
		JSlider Black_slider = new JSlider();
		Black_slider.setValue(5);
		Black_slider.setMinorTickSpacing(1);
		Black_slider.setMinimum(5);
		Black_slider.setMajorTickSpacing(5);
		Black_slider.setMaximum(20);
		Black_slider.setPaintTicks(true);
		Black_slider.setBounds(463, 56, 250, 26);
		
		Black_slider.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				JSlider source = (JSlider)e.getSource();
//				System.out.println("The value of Black has change to "+ source.getValue());
				pixelMovement2=source.getValue();
			}
		});
		
		JLabel Purple_L = new JLabel("Purple");
		Purple_L.setBounds(230, 94, 53, 23);
		Purple_L.setHorizontalAlignment(SwingConstants.CENTER);
		
		JSlider Purple_slider = new JSlider();
		Purple_slider.setValue(5);
		Purple_slider.setMinorTickSpacing(1);
		Purple_slider.setMinimum(5);
		Purple_slider.setMajorTickSpacing(5);
		Purple_slider.setMaximum(20);
		Purple_slider.setPaintTicks(true);
		Purple_slider.setBounds(463, 91, 250, 26);
		Purple_slider.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				JSlider source = (JSlider)e.getSource();
//				System.out.println("The Value of Purple has change to "+ source.getValue());
				pixelMovement3=source.getValue();
			}
		});
		
		JLabel Orange_L = new JLabel("Orange");
		Orange_L.setBounds(230, 128, 62, 23);
		Orange_L.setHorizontalAlignment(SwingConstants.CENTER);
		
		JSlider Orange_slider = new JSlider();
		Orange_slider.setValue(5);
		Orange_slider.setMinorTickSpacing(1);
		Orange_slider.setMinimum(5);
		Orange_slider.setMajorTickSpacing(5);
		Orange_slider.setMaximum(20);
		Orange_slider.setPaintTicks(true);
		Orange_slider.setBounds(463, 128, 250, 26);
		
		Orange_slider.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				JSlider source = (JSlider)e.getSource();
//				System.out.println("The Value of Orange has change to "+ source.getValue());
				pixelMovement4=source.getValue();
			}
		});
		
		Control.setLayout(null);
		Control.add(Pink_L);
		Control.add(Black_L);
		Control.add(Orange_L);
		Control.add(Purple_L);
		Control.add(Pink_slider);
		Control.add(Orange_slider);
		Control.add(Purple_slider);
		Control.add(Black_slider);
		Control.add(ChangeMode_btn);
		
		Primary p = new Primary(this);
//		Secondary s = new Secondary(this);
	}
}
