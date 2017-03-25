import java.awt.Color;
import java.awt.Graphics;


public class Primary implements Runnable {
	
	GUI gui;
	Thread t;
	int[] queue;
	
	public Primary(GUI gui) {
		this.gui = gui;
		queue=new int[5];
		t=new Thread(this);
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
			try
			{
				Thread.sleep(50);
				gui.drawingPanel.repaint();
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}
	}

/*	
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
					   System.out.println("Point 1 and queue[0]:"+gui.queue[0]);
					   
					   if(gui.queue[0]!=1)
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
				   if(gui.queue[0]==1)
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
					   if(gui.queue[0]!=1)
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
				   if(gui.queue[0]==1)
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
*/

	public void update1()
	   {
		// VARIABLE CHANGES!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
			int flag1=gui.flag1;
			int cx1 = gui.cx1;
			int cy1 = gui.cy1;
			
			int circle1OnBridge = gui.circle1OnBridge;
			int channelBusy = gui.channelBusy;
			int pixelMovement=gui.pixelMovement1;
			
		// VARIABLE CHANGES!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		  
		   
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
		   gui.flag1 = flag1;
		   gui.cx1= cx1 ;
		   gui.cy1=cy1  ;
			
			gui.circle1OnBridge= circle1OnBridge;
			gui.channelBusy= channelBusy;
			
		   gui.pixelMovement1=pixelMovement;
	   }
	   public void update2()
	   {
		   int flag2=gui.flag2;
			int cx2 = gui.cx2;
			int cy2 = gui.cy2;
			
			int circle2OnBridge = gui.circle2OnBridge;
			int channelBusy = gui.channelBusy;
			
		   int pixelMovement=gui.pixelMovement2;
		   
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
		   gui.flag2 = flag2;
		   gui.cx2= cx2 ;
		   gui.cy2=cy2  ;
			
			gui.circle2OnBridge= circle2OnBridge;
			gui.channelBusy= channelBusy;
			
		   gui.pixelMovement2=pixelMovement;
	   }
	   public void update3()
	   {
			int flag3=gui.flag3;
			int cx3 = gui.cx3;
			int cy3 = gui.cy3;
			
			int circle3OnBridge = gui.circle3OnBridge;
			int channelBusy = gui.channelBusy;
			int pixelMovement=gui.pixelMovement3;
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
		   gui.flag3 = flag3;
		   gui.cx3= cx3 ;
		   gui.cy3=cy3  ;
			
			gui.circle3OnBridge= circle3OnBridge;
			gui.channelBusy= channelBusy;
			
		   gui.pixelMovement3=pixelMovement;
	   }
	   public void update4()
	   {

			int flag4=gui.flag4;
			int cx4 = gui.cx4;
			int cy4 = gui.cy4;
			
			int circle4OnBridge = gui.circle4OnBridge;
			int channelBusy = gui.channelBusy;
			int pixelMovement=gui.pixelMovement4;
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
		   gui.flag4 = flag4;
		   gui.cx4= cx4 ;
		   gui.cy4=cy4  ;
			
			gui.circle4OnBridge= circle4OnBridge;
			gui.channelBusy= channelBusy;
			
		   gui.pixelMovement4=pixelMovement;
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
