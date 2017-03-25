import java.awt.Color;
import java.awt.Graphics;


public class Primary {
	
	GUI gui;
	
	public Primary(GUI gui) {
		this.gui = gui;
	}
	
	Thread t=new Thread();
	
	public void start()
	{
		t.start();
	}
	
	public void run()
	{
		while(true)
		{
			update();
			try
			{
				Thread.sleep(50);
				paint(gui.g.getGraphics());
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}
	}
   
	public void paint(Graphics g)
	{		
		//Drawing circles 1 through 4
		g.setColor(Color.PINK);
		drawCircle(g,gui.cx[0],gui.cy[0],gui.r);
		g.setColor(Color.BLACK);
		drawCircle(g,gui.cx[1],gui.cy[1],gui.r);
		g.setColor(Color.MAGENTA);
		drawCircle(g,gui.cx[2],gui.cy[2],gui.r);
		g.setColor(Color.ORANGE);
		drawCircle(g,gui.cx[3],gui.cy[3],gui.r);
		
		//Drawing lines 1 through 7  
		g.setColor(Color.BLACK);
		g.drawLine(gui.line1x1,gui.line1y1,gui.line1x2,gui.line1y2);
		g.drawLine(gui.line2x1,gui.line2y1,gui.line2x2,gui.line2y2);
		g.drawLine(gui.line3x1,gui.line3y1,gui.line3x2,gui.line3y2);
		g.drawLine(gui.line4x1,gui.line4y1,gui.line4x2,gui.line4y2);
		g.drawLine(gui.line5x1,gui.line5y1,gui.line5x2,gui.line5y2);
		g.drawLine(gui.line6x1,gui.line6y1,gui.line6x2,gui.line6y2);
		g.drawLine(gui.line7x1,gui.line7y1,gui.line7x2,gui.line7y2);
    }
   
	public void drawCircle(Graphics g, int x, int y, int r) {
	   x = x-(r/2);
	   y = y-(r/2);
	   g.fillOval(x,y,r,r);
   }
	
   public void update()
   {
	   for(int i=0; i<4; i++) {
		   
		   int pixelMovement=gui.pixelMovement[i];
		   int flag = gui.flag[i];
		   int cx = gui.cx[i];
		   int cy = gui.cy[i];
		   int circleOnBridge = gui.circleOnBridge[i];
		   
		   ///Transition on line 1
		   if((flag==1)&&(cx==250)&& (cy>=150 && cy<=450))
		   {
			   cy-=pixelMovement;
			   if(cy<=150) cy=150;
			   if(cy==150) flag+=1;
			  
		   }
		   ///Transition on line 2
		   if((flag==2)&&(cx>=250&&cx<=400)&&(cy>=150 && cy<=300 ))
		   {
			   cx+=pixelMovement;
			   cy=cx-100;
			   
			   if(cx>400)
			   {
				   cx=400;
				   cy=300;
			   }
			   
			   if(cx==400 && cy==300)
			   {
				   flag+=1;
				   if(onQueue(i+1)==0) System.out.println("Put inside the queue!!!!!!");
				   enqueue(i+1);
			   }
		   }
		   
		   //Transition on line 3
		   if((flag==3)&&(cx>=400&&cx<=600)&&(cy==300))
		   {
			   if(circleOnBridge==0)
			   {
				   if(gui.channelBusy==0)
				   {
					   System.out.println("Point 1 and queue[0]:"+gui.queue[i]);
					   
					   if(gui.queue[i]!=1)
					   {
						   System.out.println("Point 2");
						   return;
					   }
					   else
					   {
						   System.out.println("Point 3");
						   circleOnBridge=1;
						   gui.channelBusy=1;
						   
					   }
				   }
				   else
				   {
					   return;
				   }
			   }
			   
			   cx+=pixelMovement;
			   if(cx>600)
			   {
				   cx=600;
				   cy=300;
			   }
			   
			   if(cx==600)
			   {
				   flag+=1;
				   gui.channelBusy=0;
				   circleOnBridge=0;
				   if(gui.queue[i]==1)
				   dequeue();
			   }
		   }
		   
		   //Transition on line 4
		   if((flag==4)&&(cx>=600&&cx<=750)&&(cy>=150 && cy<=300))
		   {
			   cx+=pixelMovement;
			   cy=-cx+900;
			   if(cx>750) cx=750;
			   if(cy<150) cy=150;
			   if(cx==750) flag+=1;
		   }
		   
		   //Transition on line 5
		   if((flag==5)&&(cx==750)&&(cy>=150&&cy<450))
		   {
			   cy+=pixelMovement;
			   if(cy>450) cy=450;
			   if(cy==450) flag+=1;
		   }
		   if((flag==6)&&(cx>=600&&cx<=750)&&(cy>=300&&cy<=450))
		   {
			   cx-=pixelMovement;
			   cy=cx-300;
			   if(cy<300)
			   {
				   cy=300;
			   }
			   if(cx<600)
			   {
				   cx=600;
			   }
			   if(cx==600)
			   {
				   flag+=1;
				   if(onQueue(i+1)==0)
				   enqueue(i+1);
			   }
		   }
		   
		   //Transition on line 6
		   if((flag==7)&&(cx>=400&&cx<=600)&&(cy==300))
		   {
			   if(circleOnBridge==0)
			   {
				   if(gui.channelBusy==0 )
				   {
					   if(gui.queue[i]!=1)
					   return;
				   }
				   else
				   {
					   return;
				   }
			   }
			   gui.channelBusy=1;
			   circleOnBridge=1;
			   cx-=pixelMovement;
			   if(cx<400)
			   {
				   cx=400;
				   cy=300;
			   }
			   if(cx==400)
			   {
				   flag+=1;
				   gui.channelBusy=0;
				   circleOnBridge=0;
				   if(gui.queue[i]==1)
				   dequeue();
				   
				   
			   }
		   }
		   //Transition on line 7
		   if(flag==8&&(cx>=250&&cx<=400)&&(cy>=300&&cy<=450))
		   {
			   cx-=pixelMovement;
			   cy=-cx+700;
			   if(cx<250)
				   cx=250;
			   if(cy>450)
				   cy=450;
			   if(cx==250&&flag==8)
				   flag=1;
			   
		   }
		   
		   gui.pixelMovement[i] = pixelMovement;
		   gui.flag[i] = flag;
		   gui.cx[i] = cx;
		   gui.cy[i] = cy;
		   gui.circleOnBridge[i] = circleOnBridge;
	   }
   }

   public  void enqueue(int personNumber)
   {
	   int i=0;
	   for(;i<4;i++)
	   {
		   if(gui.queue[i]!=0)
			   continue;
		   else
			   break;
	   }
	   gui.queue[i]=personNumber;
   }
   
   public void dequeue()
   {
	   int j=0;
	   for( j=0;j<4 && gui.queue[j]!=0;j++)
	   gui.queue[j]=gui.queue[j+1];
	   
	   if(j<3) gui.queue[j+1]=0;
   }
   
   public int onQueue(int personNumber)
   {
	   int i=0;
	   for(;i<4;i++)
	   {
		  if(gui.queue[i]==personNumber)
			  return 1;
	   }
	   return 0;
   }
}
