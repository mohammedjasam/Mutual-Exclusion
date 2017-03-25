import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JSlider;
import java.awt.GridLayout;
import javax.swing.JButton;

public class GUI {

	private JFrame frame;

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
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(0, 0, 1366, 718);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel Drawing = new JPanel();
		Drawing.setBackground(Color.WHITE);
		Drawing.setBounds(0, 0, 1342, 464);
		frame.getContentPane().add(Drawing);
		
		JPanel Control = new JPanel();
		Control.setBounds(0, 465, 1342, 189);
		frame.getContentPane().add(Control);
		Control.setLayout(new GridLayout(0, 3, 0, 0));
		
		JLabel Pink_L = new JLabel("Pink");
		Pink_L.setHorizontalAlignment(SwingConstants.CENTER);
		Control.add(Pink_L);
		
		JSlider Pink_slider = new JSlider();
		Control.add(Pink_slider);
		
		JButton ChangeMode_btn = new JButton("Change Mode");
		Control.add(ChangeMode_btn);
		
		JLabel Black_L = new JLabel("Black");
		Black_L.setHorizontalAlignment(SwingConstants.CENTER);
		Control.add(Black_L);
		
		JSlider Black_slider = new JSlider();
		Control.add(Black_slider);
		
		JLabel lblNewLabel = new JLabel("");
		Control.add(lblNewLabel);
		
		JLabel Purple_L = new JLabel("Purple");
		Purple_L.setHorizontalAlignment(SwingConstants.CENTER);
		Control.add(Purple_L);
		
		JSlider Purple_slider = new JSlider();
		Control.add(Purple_slider);
		
		JLabel lblNewLabel_1 = new JLabel("");
		Control.add(lblNewLabel_1);
		
		JLabel Orange_L = new JLabel("Orange");
		Orange_L.setHorizontalAlignment(SwingConstants.CENTER);
		Control.add(Orange_L);
		
		JSlider Orange_slider = new JSlider();
		Control.add(Orange_slider);
		
		JLabel lblNewLabel_2 = new JLabel("");
		Control.add(lblNewLabel_2);
	}
}
