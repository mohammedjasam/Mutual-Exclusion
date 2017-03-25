import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JSlider;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

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
		
		JLabel Pink_L = new JLabel("Pink");
		Pink_L.setBounds(230, 22, 34, 23);
		Pink_L.setHorizontalAlignment(SwingConstants.CENTER);
		
		JSlider Pink_slider = new JSlider();
		Pink_slider.setPaintTicks(true);
		Pink_slider.setMajorTickSpacing(5);
		Pink_slider.setMinorTickSpacing(1);
		Pink_slider.setMinimum(5);
		Pink_slider.setMaximum(20);
		Pink_slider.setBounds(463, 19, 250, 26);
		
		JButton ChangeMode_btn = new JButton("Change Mode");
		ChangeMode_btn.setBounds(1009, 38, 206, 132);
		
		JLabel Black_L = new JLabel("Black");
		Black_L.setBounds(230, 56, 43, 23);
		Black_L.setHorizontalAlignment(SwingConstants.CENTER);
		
		JSlider Black_slider = new JSlider();
		Black_slider.setMinorTickSpacing(1);
		Black_slider.setMinimum(5);
		Black_slider.setMajorTickSpacing(5);
		Black_slider.setMaximum(20);
		Black_slider.setPaintTicks(true);
		Black_slider.setBounds(463, 56, 250, 26);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(952, 122, 0, 0);
		
		JLabel Purple_L = new JLabel("Purple");
		Purple_L.setBounds(230, 94, 53, 23);
		Purple_L.setHorizontalAlignment(SwingConstants.CENTER);
		
		JSlider Purple_slider = new JSlider();
		Purple_slider.setMinorTickSpacing(1);
		Purple_slider.setMinimum(5);
		Purple_slider.setMajorTickSpacing(5);
		Purple_slider.setMaximum(20);
		Purple_slider.setPaintTicks(true);
		Purple_slider.setBounds(463, 91, 250, 26);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(1262, 106, 0, 0);
		
		JLabel Orange_L = new JLabel("Orange");
		Orange_L.setBounds(230, 128, 62, 23);
		Orange_L.setHorizontalAlignment(SwingConstants.CENTER);
		
		JSlider Orange_slider = new JSlider();
		Orange_slider.setMinorTickSpacing(1);
		Orange_slider.setMinimum(5);
		Orange_slider.setMajorTickSpacing(5);
		Orange_slider.setMaximum(20);
		Orange_slider.setPaintTicks(true);
		Orange_slider.setBounds(463, 128, 250, 26);
		
		JLabel lblNewLabel_2 = new JLabel("");
		Control.setLayout(null);
		Control.add(Pink_L);
		Control.add(Black_L);
		Control.add(Orange_L);
		Control.add(Purple_L);
		Control.add(Pink_slider);
		Control.add(Orange_slider);
		Control.add(Purple_slider);
		Control.add(Black_slider);
		Control.add(lblNewLabel);
		Control.add(ChangeMode_btn);
		Control.add(lblNewLabel_1);
	}
}
