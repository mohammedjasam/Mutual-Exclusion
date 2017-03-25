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
		Pink_L.setHorizontalAlignment(SwingConstants.CENTER);
		
		JSlider Pink_slider = new JSlider();
		
		JButton ChangeMode_btn = new JButton("Change Mode");
		
		JLabel Black_L = new JLabel("Black");
		Black_L.setHorizontalAlignment(SwingConstants.CENTER);
		
		JSlider Black_slider = new JSlider();
		
		JLabel lblNewLabel = new JLabel("");
		
		JLabel Purple_L = new JLabel("Purple");
		Purple_L.setHorizontalAlignment(SwingConstants.CENTER);
		
		JSlider Purple_slider = new JSlider();
		
		JLabel lblNewLabel_1 = new JLabel("");
		
		JLabel Orange_L = new JLabel("Orange");
		Orange_L.setHorizontalAlignment(SwingConstants.CENTER);
		
		JSlider Orange_slider = new JSlider();
		
		JLabel lblNewLabel_2 = new JLabel("");
		GroupLayout gl_Control = new GroupLayout(Control);
		gl_Control.setHorizontalGroup(
			gl_Control.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Control.createSequentialGroup()
					.addGap(230)
					.addGroup(gl_Control.createParallelGroup(Alignment.LEADING)
						.addComponent(Pink_L)
						.addComponent(Black_L)
						.addComponent(Orange_L)
						.addComponent(Purple_L))
					.addGap(171)
					.addGroup(gl_Control.createParallelGroup(Alignment.LEADING)
						.addComponent(Pink_slider, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_Control.createSequentialGroup()
							.addGroup(gl_Control.createParallelGroup(Alignment.LEADING)
								.addComponent(Orange_slider, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
								.addComponent(Purple_slider, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
								.addComponent(Black_slider, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE))
							.addGap(239)
							.addComponent(lblNewLabel)
							.addGap(59)
							.addComponent(ChangeMode_btn, GroupLayout.PREFERRED_SIZE, 204, GroupLayout.PREFERRED_SIZE)
							.addGap(47)
							.addComponent(lblNewLabel_1)))
					.addContainerGap(229, Short.MAX_VALUE))
		);
		gl_Control.setVerticalGroup(
			gl_Control.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Control.createSequentialGroup()
					.addGroup(gl_Control.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_Control.createSequentialGroup()
							.addGap(56)
							.addGroup(gl_Control.createParallelGroup(Alignment.LEADING)
								.addComponent(ChangeMode_btn, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_Control.createSequentialGroup()
									.addGap(35)
									.addGroup(gl_Control.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_Control.createSequentialGroup()
											.addGap(15)
											.addComponent(lblNewLabel_1))
										.addGroup(gl_Control.createSequentialGroup()
											.addGap(31)
											.addComponent(lblNewLabel))))))
						.addGroup(gl_Control.createSequentialGroup()
							.addGap(22)
							.addComponent(Pink_L)
							.addGap(14)
							.addComponent(Black_L)
							.addGap(12)
							.addComponent(Purple_L)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(Orange_L))
						.addGroup(gl_Control.createSequentialGroup()
							.addContainerGap()
							.addComponent(Pink_slider, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(Black_slider, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(9)
							.addComponent(Purple_slider, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(Orange_slider, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(35, Short.MAX_VALUE))
		);
		Control.setLayout(gl_Control);
	}
}
