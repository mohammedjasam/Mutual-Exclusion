// Imports to implement GUI in Java using Swings
import java.applet.Applet;
import java.awt.Button;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;

public class Part1Final extends Applet implements Runnable,ActionListener{
	TextField input1,input2,input3,input4;
	   Label label1,label2,label3,label4;
	   Button b1;
	   JLabel lbl;
	   int num, sum = 0;
	   public void init(){
	      label1 = new Label("Speed 1 : ");
	      add(label1);
	      //label1.setBackground(Color.yellow);
	      label1.setForeground(Color.red);
	      input1 = new TextField(5);
	      add(input1);
	      label2 = new Label("Speed 2 : ");
	      add(label2);
	      //label1.setBackground(Color.yellow);
	      label2.setForeground(Color.green);
	      input2 = new TextField(5);
	      add(input2);
	      label3 = new Label("Speed 3 : ");
	      add(label3);
	      //label1.setBackground(Color.yellow);
	      label3.setForeground(Color.blue);
	      input3 = new TextField(5);
	      add(input3);
	      label4 = new Label("Speed 4 : ");
	      add(label4);
	      //label1.setBackground(Color.yellow);
	      label4.setForeground(Color.yellow);
	      input4 = new TextField(5);
	      add(input4);

	      b1 = new Button("Reset");
	      add(b1);
	      b1.addActionListener( this);
	      lbl = new JLabel("Swing Applet Example. ");
	      add(lbl);


	   }
	   public void actionPerformed(ActionEvent ae){
	      try{
	         /*num = Integer.parseInt(input.getText());
	         sum = sum+num;
	         input.setText("");
	         output.setText(Integer.toString(sum));
	         lbl.setForeground(Color.blue);
	         lbl.setText("Output of the second Text Box : "
	         + output.getText());
	         */
	    	  pixelMovement1 = Integer.parseInt(input1.getText());
	    	  pixelMovement2 = Integer.parseInt(input2.getText());
	    	  pixelMovement3 = Integer.parseInt(input3.getText());
	    	  pixelMovement4 = Integer.parseInt(input4.getText());
	      }
	      catch(NumberFormatException e){
	         /*lbl.setForeground(Color.red);
	         lbl.setText("Invalid Entry!");
	         */
	      }
	   }

	int queue[]=new int [5];
	int durationint=500;	//Duration of animation
	   int cx1=250,cy1=250;   //Circle 1 params
	   int cx2=250,cy2=350;   //Circle 2 params
	   int cx3=750,cy3=250;	       //Circle 3 params
	   int cx4=750,cy4=350;	       //Circle 4 params
	   int r=20;		//Radius of all the circles
	   int flag1=1,flag2=1,flag3=5,flag4=5;
	   int channelBusy=0;
	   int circle1OnBridge=0,circle2OnBridge=0,circle3OnBridge=0,circle4OnBridge=0;
	   //int pixelMovement1=4,pixelMovement2=6,pixelMovement3=5,pixelMovement4=3;
	   int pixelMovement1=5,pixelMovement2=7,pixelMovement3=9,pixelMovement4=10;
	   int line1x1=cx1,line1y1=150,line1x2=cx1,line1y2=450;	//Line 1

	   int line2x1=cx3,line2y1=line1y1,line2x2=cx3,line2y2=line1y2;	//Line 2

	   int line3x1=line1x1,line3y1=line1y1,line3x2=400,line3y2=300;	//Line 3

	   int line4x1=line1x2,line4y1=line1y2,line4x2=line3x2,line4y2=line3y2;	//Line 4


	   int line5x1=line4x2,line5y1=line4y2,line5x2=line4x2+200,line5y2=line4y2;	//Line 5

	   int line6x1=line5x2,line6y1=line5y2,line6x2=line2x1,line6y2=line2y1;		//Line 6

	   int line7x1=line6x1,line7y1=line6y1,line7x2=line2x2,line7y2=line2y2;		//Line 7
	Thread t=new Thread(this);
	public void start()
	{
		t.start();
	}
	public void run()
	{
		while(true)
		{
		update1();
		update2();
		update3();
		update4();
		try{
		Thread.sleep(50);
		repaint();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		}
	}
   public void paint(Graphics g){

	  // int channelBusy=0;	//Channel busy intiable
//Drawing circles 1 through 4
	   g.setColor(Color.RED);
      drawCircle(g,cx1,cy1,r);
      g.setColor(Color.GREEN);
      drawCircle(g,cx2,cy2,r);
      g.setColor(Color.BLUE);
      drawCircle(g,cx3,cy3,r);
      g.setColor(Color.YELLOW);
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
//      JTextField textField = new JTextField(20);
      //JOptionPane.showInputDialog ("Input Text Here");
      TextField nameField = new TextField("A TextField",100);
   }
   public void drawCircle(Graphics g, int x, int y, int r) {
	   x = x-(r/2);
	   y = y-(r/2);
	   g.fillOval(x,y,r,r);
	 }
   public void update1()
   {

	   //System.out.println("ChannelBusy and Circle1OnBridge for ball 1:"+channelBusy+"  "+circle1OnBridge);
	   int pixelMovement=pixelMovement1;
	 ///Transition on line 1
	   if((flag1==1)&&(cx1==250)&& (cy1>=150 && cy1<=450))
	   {

			   cy1-=pixelMovement;
			   if(cy1<=150)
				   cy1=150;
			   if(cy1==150)
			   flag1+=1;

	   }
	   ///Transition on line 2
	   if((flag1==2)&&(cx1>=250&&cx1<=400)&&(cy1>=150 && cy1<=300 ))
	   {

		   cx1+=pixelMovement;
		   cy1=cx1-100;
		   if(cx1>400)
		   {
			   cx1=400;
			   cy1=300;
		   }

		   if(cx1==400 && cy1==300)
		   {
			   flag1+=1;
			   if(onQueue(1)==0)
				   System.out.println("Put inside the queue!!!!!!");
			   enqueue(1);
		   }
	   }

	   //Transition on line 3
	   if((flag1==3)&&(cx1>=400&&cx1<=600)&&(cy1==300))
	   {
		   if(circle1OnBridge==0)
		   {
		   if(channelBusy==0)
		   {
			   System.out.println("Point 1 and queue[0]:"+queue[0]);

			   if(queue[0]!=1)
			   {
				   System.out.println("Point 2");
				   return;
			   }
			   else
			   {
				   System.out.println("Point 3");
				   circle1OnBridge=1;
				   channelBusy=1;

			   }
		   }
		   else
		   {
			   return;
		   }
		   }


		  // System.out.println("Queue front:"+queue[0]+"  channelBusy:"+channelBusy+"  circle1OnBridge:"+circle1OnBridge);

		   cx1+=pixelMovement;
		   if(cx1>600)
		   {
			   cx1=600;
			   cy1=300;
		   }
		   if(cx1==600)
		   {
			   flag1+=1;
			   channelBusy=0;
			   circle1OnBridge=0;
			   if(queue[0]==1)
			   dequeue();

		   }
	   }

	   //Transition on line 4
	   if((flag1==4)&&(cx1>=600&&cx1<=750)&&(cy1>=150 && cy1<=300))
	   {

		   cx1+=pixelMovement;
		   cy1=-cx1+900;
		   if(cx1>750)
			   cx1=750;
		   if(cy1<150)
			  cy1=150;
		   if(cx1==750)
			   flag1+=1;
	   }
	   //Transition on line 5
	   if((flag1==5)&&(cx1==750)&&(cy1>=150&&cy1<450))
	   {
		   cy1+=pixelMovement;
		   if(cy1>450)
			   cy1=450;
		   if(cy1==450)
		   {
			   flag1+=1;
		   }
	   }
	   if((flag1==6)&&(cx1>=600&&cx1<=750)&&(cy1>=300&&cy1<=450))
	   {
		   cx1-=pixelMovement;
		   cy1=cx1-300;
		   if(cy1<300)
		   {
			   cy1=300;
		   }
		   if(cx1<600)
		   {
			   cx1=600;
		   }
		   if(cx1==600)
		   {
			   flag1+=1;
			   if(onQueue(1)==0)
			   enqueue(1);
		   }
	   }
	   //Transition on line 6
	   if((flag1==7)&&(cx1>=400&&cx1<=600)&&(cy1==300))
	   {
		   if(circle1OnBridge==0)
		   {
		   if(channelBusy==0 )
		   {
			   if(queue[0]!=1)
			   return;
		   }
		   else
		   {
			   return;
		   }
		   }
		   channelBusy=1;
		   circle1OnBridge=1;
		   cx1-=pixelMovement;
		   if(cx1<400)
		   {
			   cx1=400;
			   cy1=300;
		   }
		   if(cx1==400)
		   {
			   flag1+=1;
			   channelBusy=0;
			   circle1OnBridge=0;
			   if(queue[0]==1)
			   dequeue();


		   }
	   }
	   //Transition on line 7
	   if(flag1==8&&(cx1>=250&&cx1<=400)&&(cy1>=300&&cy1<=450))
	   {

		   cx1-=pixelMovement;
		   cy1=-cx1+700;
		   if(cx1<250)
			   cx1=250;
		   if(cy1>450)
			   cy1=450;
		   if(cx1==250&&flag1==8)
			   flag1=1;

	   }

   }


   public void update2()
   {
	   int pixelMovement=pixelMovement2;
	 ///Transition on line 1
	   if((flag2==1)&&(cx2==250)&& (cy2>=150 && cy2<=450))
	   {

			   cy2-=pixelMovement;
			   if(cy2<=150)
				   cy2=150;
			   if(cy2==150)
			   flag2+=1;

	   }
	   ///Transition on line 2
	   if((flag2==2)&&(cx2>=250&&cx2<=400)&&(cy2>=150 && cy2<=300 ))
	   {

		   cx2+=pixelMovement;
		   cy2=cx2-100;
		   if(cx2>400)
		   {
			   cx2=400;
			   cy2=300;
		   }
		   /*
		   if(cy2>300)
		   {
			   cy2=300;
		   }*/
		   if(cx2==400 && cy2==300)
		   {
			   flag2+=1;
			   if(onQueue(2)==0)
			   enqueue(2);
		   }
	   }

	   //Transition on line 3
	   if((flag2==3)&&(cx2>=400&&cx2<=600)&&(cy2==300))
	   {
		   if(circle2OnBridge==0)
		   {
		   if(channelBusy==0 )
		   {
			   if(queue[0]!=2)
			   return;
		   }
		   else
		   {
			   return;
		   }
		   }
		   circle2OnBridge=1;
		   channelBusy=1;
		   cx2+=pixelMovement;
		   if(cx2>600)
		   {
			   cx2=600;
			   cy2=300;
		   }
		   if(cx2==600)
		   {
			   flag2+=1;
			   channelBusy=0;
			   circle2OnBridge=0;
			   if(queue[0]==2)
			   dequeue();
			   //if(queue[0]==2)

		   }
	   }

	   //Transition on line 4
	   if((flag2==4)&&(cx2>=600&&cx2<=750)&&(cy2>=150 && cy2<=300))
	   {

		   cx2+=pixelMovement;
		   cy2=-cx2+900;
		   if(cx2>750)
			   cx2=750;
		   if(cy2<150)
			  cy2=150;
		   if(cx2==750)
			   flag2+=1;
	   }
	   //Transition on line 5
	   if((flag2==5)&&(cx2==750)&&(cy2>=150&&cy2<450))
	   {
		   cy2+=pixelMovement;
		   if(cy2>450)
			   cy2=450;
		   if(cy2==450)
		   {
			   flag2+=1;
		   }
	   }
	   if((flag2==6)&&(cx2>=600&&cx2<=750)&&(cy2>=300&&cy2<=450))
	   {
		   cx2-=pixelMovement;
		   cy2=cx2-300;
		   if(cy2<300)
		   {
			   cy2=300;
		   }
		   if(cx2<600)
		   {
			   cx2=600;
		   }
		   if(cx2==600)
		   {
			   flag2+=1;
			   if(onQueue(2)==0)
			   enqueue(2);
		   }
	   }
	   //Transition on line 6
	   if((flag2==7)&&(cx2>=400&&cx2<=600)&&(cy2==300))
	   {
		   if(circle2OnBridge==0)
		   {
		   if(channelBusy==0 )
		   {
			   if(queue[0]!=2)
			   return;
		   }
		   else
		   {
			   return;
		   }
		   }
		   channelBusy=1;
		   circle2OnBridge=1;
		   cx2-=pixelMovement;
		   if(cx2<400)
			   cx2=400;
		   if(cx2==400)
		   {
			   flag2+=1;
			   channelBusy=0;
			   circle2OnBridge=0;
			   if(queue[0]==2)
			   dequeue();
			   //if(queue[0]==2)

		   }
	   }
	   //Transition on line 7
	   if(flag2==8&&(cx2>=250&&cx2<=400)&&(cy2>=300&&cy2<=450))
	   {

		   cx2-=pixelMovement;
		   cy2=-cx2+700;
		   if(cx2<250)
			   cx2=250;
		   if(cy2>450)
			   cy2=450;
		   if(cx2==250&&flag2==8)
			   flag2=1;

	   }

   }
   public void update3()
   {
	   int pixelMovement=pixelMovement3;
	 ///Transition on line 1
	   if((flag3==1)&&(cx3==250)&& (cy3>=150 && cy3<=450))
	   {

			   cy3-=pixelMovement;
			   if(cy3<=150)
				   cy3=150;
			   if(cy3==150)
			   flag3+=1;

	   }
	   ///Transition on line 2
	   if((flag3==2)&&(cx3>=250&&cx3<=400)&&(cy3>=150 && cy3<=300 ))
	   {

		   cx3+=pixelMovement;
		   cy3=cx3-100;
		   if(cx3>400)
		   {
			   cx3=400;
		   }
		   if(cy3>300)
		   {
			   cy3=300;
		   }
		   if(cx3==400)
		   {
			   flag3+=1;
			   if(onQueue(3)==0)
			   enqueue(3);
		   }
	   }

	   //Transition on line 3
	   if((flag3==3)&&(cx3>=400&&cx3<=600)&&(cy3==300))
	   {
		   if(circle3OnBridge==0)
		   {
		   if(channelBusy==0 )
		   {
			   if(queue[0]!=3)
			   return;
		   }
		   else
		   {
			   return;
		   }
		   }
		   circle3OnBridge=1;
		   channelBusy=1;
		   cx3+=pixelMovement;
		   if(cx3>600)
		   {
			   cx3=600;
		   }
		   if(cx3==600)
		   {

			   flag3+=1;



		   }
	   }

	   //Transition on line 4
	   if((flag3==4)&&(cx3>=600&&cx3<=750)&&(cy3>=150 && cy3<=300))
	   {
		   circle3OnBridge=0;
		   channelBusy=0;
		   if(queue[0]==3)
		   dequeue();
		   cx3+=pixelMovement;
		   cy3=-cx3+900;
		   if(cx3>750)
			   cx3=750;
		   if(cy3<150)
			  cy3=150;
		   if(cx3==750)
			   flag3+=1;
	   }
	   //Transition on line 5
	   if((flag3==5)&&(cx3==750)&&(cy3>=150&&cy3<450))
	   {
		   cy3+=pixelMovement;
		   if(cy3>450)
			   cy3=450;
		   if(cy3==450)
		   {
			   flag3+=1;
		   }
	   }
	   if((flag3==6)&&(cx3>=600&&cx3<=750)&&(cy3>=300&&cy3<=450))
	   {
		   cx3-=pixelMovement;
		   cy3=cx3-300;
		   if(cy3<300)
		   {
			   cy3=300;
		   }
		   if(cx3<600)
		   {
			   cx3=600;
		   }
		   if(cx3==600)
		   {
			   flag3+=1;
			   if(onQueue(3)==0)
			   enqueue(3);
		   }
	   }
	   //Transition on line 6
	   if((flag3==7)&&(cx3>=400&&cx3<=600)&&(cy3==300))
	   {
		   if(circle3OnBridge==0)
		   {
		   if(channelBusy==0 )
		   {
			   if(queue[0]!=3)
			   return;
		   }
		   else
		   {
			   return;
		   }
		   }

		   channelBusy=1;
		   circle3OnBridge=1;
		   cx3-=pixelMovement;
		   if(cx3<400)
			   cx3=400;
		   if(cx3==400)
		   {
			   flag3+=1;
			   channelBusy=0;
			   circle3OnBridge=0;
			   if(queue[0]==3)
			   dequeue();


		   }
	   }
	   //Transition on line 7
	   if(flag3==8&&(cx3>=250&&cx3<=400)&&(cy3>=300&&cy3<=450))
	   {

		   cx3-=pixelMovement;
		   cy3=-cx3+700;
		   if(cx3<250)
			   cx3=250;
		   if(cy3>450)
			   cy3=450;
		   if(cx3==250&&flag3==8)
			   flag3=1;

	   }

   }
   public void update4()
   {

	   //System.out.println("ChannelBusy for ball 4:"+channelBusy);
	   int pixelMovement=pixelMovement4;
	 ///Transition on line 1
	   if((flag4==1)&&(cx4==250)&& (cy4>=150 && cy4<=450))
	   {

			   cy4-=pixelMovement;
			   if(cy4<=150)
				   cy4=150;
			   if(cy4==150)
			   flag4+=1;

	   }
	   ///Transition on line 2
	   if((flag4==2)&&(cx4>=250&&cx4<=400)&&(cy4>=150 && cy4<=300 ))
	   {

		   cx4+=pixelMovement;
		   cy4=cx4-100;
		   if(cx4>400)
		   {
			   cx4=400;
		   }
		   if(cy4>300)
		   {
			   cy4=300;
		   }
		   if(cx4==400)
		   {
			   flag4+=1;
			   if(onQueue(4)==0)
			   enqueue(4);
		   }
	   }

	   //Transition on line 3
	   if((flag4==3)&&(cx4>=400&&cx4<=600)&&(cy4==300))
	   {
		   if(circle4OnBridge==0)
		   {
		   if(channelBusy==0 )
		   {
			   if(queue[0]!=4)
			   return;
		   }
		   else
		   {
			   return;
		   }
		   }
		   circle4OnBridge=1;
		   channelBusy=1;
		   cx4+=pixelMovement;
		   if(cx4>600)
		   {
			   cx4=600;
		   }
		   if(cx4==600)
		   {
			   flag4+=1;
			   circle4OnBridge=0;
			   channelBusy=0;
			   if(queue[4]==0)
			   dequeue();

		   }
	   }

	   //Transition on line 4
	   if((flag4==4)&&(cx4>=600&&cx4<=750)&&(cy4>=150 && cy4<=300))
	   {

		   cx4+=pixelMovement;
		   cy4=-cx4+900;
		   if(cx4>750)
			   cx4=750;
		   if(cy4<150)
			  cy4=150;
		   if(cx4==750)
			   flag4+=1;
	   }
	   //Transition on line 5
	   if((flag4==5)&&(cx4==750)&&(cy4>=150&&cy4<450))
	   {
		   cy4+=pixelMovement;
		   if(cy4>450)
			   cy4=450;
		   if(cy4==450)
		   {
			   flag4+=1;
		   }
	   }
	   if((flag4==6)&&(cx4>=600&&cx4<=750)&&(cy4>=300&&cy4<=450))
	   {
		   cx4-=pixelMovement;
		   cy4=cx4-300;
		   if(cy4<300)
		   {
			   cy4=300;
		   }
		   if(cx4<600)
		   {
			   cx4=600;
		   }
		   if(cx4==600)
		   {
			   flag4+=1;
			   if(onQueue(4)==0)
			   {
				   System.out.println("Enqueuing");
			   enqueue(4);
			   }
		   }
	   }
	   //Transition on line 6
	   if((flag4==7)&&(cx4>=400&&cx4<=600)&&(cy4==300))
	   {
		   if(circle4OnBridge==0)
		   {
		   if(channelBusy==0 )
		   {
			   if(queue[0]!=4)
			   return;
		   }
		   else
		   {
			   return;
		   }
		   }
		   channelBusy=1;
		   circle4OnBridge=1;
		   cx4-=pixelMovement;
		   if(cx4<400)
			   cx4=400;
		   if(cx4==400)
		   {
			   flag4+=1;
			   channelBusy=0;
			   circle4OnBridge=0;
			   if(queue[0]==4)
			   dequeue();


		   }
	   }
	   //Transition on line 7
	   if(flag4==8&&(cx4>=250&&cx4<=400)&&(cy4>=300&&cy4<=450))
	   {

		   cx4-=pixelMovement;
		   cy4=-cx4+700;
		   if(cx4<250)
			   cx4=250;
		   if(cy4>450)
			   cy4=450;
		   if(cx4==250&&flag4==8)
			   flag4=1;

	   }

   }

   public  void enqueue(int personNumber)
   {

	   int i=0;
	   for(;i<4;i++)
	   {
		   if(queue[i]!=0)
			   continue;
		   else
			   break;
	   }
	   queue[i]=personNumber;

   }
   public void dequeue()
   {

	   int j=0;
	   for( j=0;j<4 && queue[j]!=0;j++)
	   queue[j]=queue[j+1];

	   if(j<3)
	   queue[j+1]=0;
	   //System.out.println("After dequeueing:");
	   //for(int k=0;k<4;k++)
		//   System.out.println(queue[k]+"	");

   }
   public int onQueue(int personNumber)
   {
	   int i=0;
	   for(;i<4;i++)
	   {
		  if(queue[i]==personNumber)
			  return 1;
	   }
	   return 0;
   }

}
