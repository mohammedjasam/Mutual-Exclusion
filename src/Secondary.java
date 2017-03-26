public class Secondary implements Runnable {

	GUI gui;
	Thread t;
	int[] queue;
	boolean runThread;
	
	int channelBusy;
	
	int cx1,cy1;   	//Node 1 Coordinates
	int cx2,cy2;   	//Node 2 Coordinates
	int cx3,cy3;	//Node 3 Coordinates
	int cx4,cy4;	//Node 4 Coordinates
	
	int flag1,flag2,flag3,flag4;	
	int circle1OnBridge,circle2OnBridge,circle3OnBridge,circle4OnBridge;
	

	public Secondary(GUI gui) {
		this.gui = gui;
	}

	public void start() {
		
		// Initial Positions of the nodes in the Figure
		flag1=1; 
		flag2=1;
		flag3=5;
		flag4=5;
		
		// Flags to check the presence of particular node on the Bridge
		circle1OnBridge=0;
		circle2OnBridge=0;
		circle3OnBridge=0;
		circle4OnBridge=0;
		
		// Flag to check if the channel is busy or not!
		channelBusy=0;
		queue=new int[5];
		
		runThread=true;
		t=new Thread(this);
		t.start();
	}
	
	public void stop() {
		runThread = false;
	}

	public void run()
	{
		while(runThread)
		{
			cx1=gui.cx1;cy1=gui.cy1;
			cx2=gui.cx2;cy2=gui.cy2;
			cx3=gui.cx3;cy3=gui.cy3;
			cx4=gui.cx4;cy4=gui.cy4;
			
			update1();
			update2();
			update3();
			update4();
			
			gui.cx1=cx1;gui.cy1=cy1;
			gui.cx2=cx2;gui.cy2=cy2;
			gui.cx3=cx3;gui.cy3=cy3;
			gui.cx4=cx4;gui.cy4=cy4;
			
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

   public void update1()
   {
	 ///Path 1
	   if((flag1==1)&&(cx1==250)&& (cy1>=150 && cy1<=450))
	   {

			   cy1-=gui.pixelMovement1;
			   if(cy1<=150)
				   cy1=150;
			   if(cy1==150)
			   flag1+=1;

	   }
	   ///Path 2
	   if((flag1==2)&&(cx1>=250&&cx1<=400)&&(cy1>=150 && cy1<=300 ))
	   {

		   cx1+=gui.pixelMovement1;
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
				    enqueue(1);
		   }
	   }

	   //Path 3
	   if((flag1==3)&&(cx1>=400&&cx1<=600)&&(cy1==300))
	   {
		   if(circle1OnBridge==0)
		   {

		   if(allowedOnBridge(1)==1)
		   {
			   circle1OnBridge=1;
				   channelBusy=1;
		   }
		   else
		   {
			   return;
		   }
	   }
		   cx1+=gui.pixelMovement1;
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
			   dequeue();
		   }
	   }

	   //Path 4
	   if((flag1==4)&&(cx1>=600&&cx1<=750)&&(cy1>=150 && cy1<=300))
	   {

		   cx1+=gui.pixelMovement1;
		   cy1=-cx1+900;
		   if(cx1>750)
			   cx1=750;
		   if(cy1<150)
			  cy1=150;
		   if(cx1==750)
			   flag1+=1;
	   }
	   //Path 5
	   if((flag1==5)&&(cx1==750)&&(cy1>=150&&cy1<450))
	   {
		   cy1+=gui.pixelMovement1;
		   if(cy1>450)
			   cy1=450;
		   if(cy1==450)
		   {
			   flag1+=1;
		   }
	   }
	   if((flag1==6)&&(cx1>=600&&cx1<=750)&&(cy1>=300&&cy1<=450))
	   {
		   cx1-=gui.pixelMovement1;
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
	   //Path 6
	   if((flag1==7)&&(cx1>=400&&cx1<=600)&&(cy1==300))
	   {
		   if(circle1OnBridge==0)
		   {
			   if(allowedOnBridge(1)==1)
			   {
				   circle1OnBridge=1;
					   channelBusy=1;
			   }
		   else
		   {
			   return;
		   }
		   }

		   cx1-=gui.pixelMovement1;
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
			   dequeue();
		   }
	   }
	   //Path 7
	   if(flag1==8&&(cx1>=250&&cx1<=400)&&(cy1>=300&&cy1<=450))
	   {

		   cx1-=gui.pixelMovement1;
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
	 ///Path 1
	   if((flag2==1)&&(cx2==250)&& (cy2>=150 && cy2<=450))
	   {

			   cy2-=gui.pixelMovement2;
			   if(cy2<=150)
				   cy2=150;
			   if(cy2==150)
			   flag2+=1;

	   }
	   ///Path 2
	   if((flag2==2)&&(cx2>=250&&cx2<=400)&&(cy2>=150 && cy2<=300 ))
	   {

		   cx2+=gui.pixelMovement2;
		   cy2=cx2-100;
		   if(cx2>400)
		   {
			   cx2=400;
			   cy2=300;
		   }
		   if(cx2==400 && cy2==300)
		   {
			   flag2+=1;
			   if(onQueue(2)==0)
			   enqueue(2);
		   }
	   }

	   //Path 3
	   if((flag2==3)&&(cx2>=400&&cx2<=600)&&(cy2==300))
	   {
		   System.out.println();
		   if(circle2OnBridge==0)
		   {
			   if(allowedOnBridge(2)==1)
			   {
				   circle2OnBridge=1;
					   channelBusy=1;
			   }
		   else
		   {
			   return;
		   }
		   }

		   cx2+=gui.pixelMovement2;
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
			   dequeue();
		   }
	   }

	   //Path 4
	   if((flag2==4)&&(cx2>=600&&cx2<=750)&&(cy2>=150 && cy2<=300))
	   {

		   cx2+=gui.pixelMovement2;
		   cy2=-cx2+900;
		   if(cx2>750)
			   cx2=750;
		   if(cy2<150)
			  cy2=150;
		   if(cx2==750)
			   flag2+=1;
	   }
	   //Path 5
	   if((flag2==5)&&(cx2==750)&&(cy2>=150&&cy2<450))
	   {
		   cy2+=gui.pixelMovement2;
		   if(cy2>450)
			   cy2=450;
		   if(cy2==450)
		   {
			   flag2+=1;
		   }
	   }
	   if((flag2==6)&&(cx2>=600&&cx2<=750)&&(cy2>=300&&cy2<=450))
	   {
		   cx2-=gui.pixelMovement2;
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
	   //Path 6
	   if((flag2==7)&&(cx2>=400&&cx2<=600)&&(cy2==300))
	   {
		   if(circle2OnBridge==0)
		   {
			   if(allowedOnBridge(2)==1)
			   {
				   circle2OnBridge=1;
					   channelBusy=1;
			   }
		   else
		   {
			   return;
		   }
		}

		   cx2-=gui.pixelMovement2;
		   if(cx2<400)
			   cx2=400;
		   if(cx2==400)
		   {
			   flag2+=1;
			   channelBusy=0;
			   circle2OnBridge=0;
			   dequeue();
		   }
	   }
	   //Path 7
	   if(flag2==8&&(cx2>=250&&cx2<=400)&&(cy2>=300&&cy2<=450))
	   {

		   cx2-=gui.pixelMovement2;
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
	 ///Path 1
	   if((flag3==1)&&(cx3==250)&& (cy3>=150 && cy3<=450))
	   {

			   cy3-=gui.pixelMovement3;
			   if(cy3<=150)
				   cy3=150;
			   if(cy3==150)
			   flag3+=1;

	   }
	   ///Path 2
	   if((flag3==2)&&(cx3>=250&&cx3<=400)&&(cy3>=150 && cy3<=300 ))
	   {

		   cx3+=gui.pixelMovement3;
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

	   //Path 3
	   if((flag3==3)&&(cx3>=400&&cx3<=600)&&(cy3==300))
	   {
		   if(circle3OnBridge==0)
		   {

			   System.out.println();
			   if(allowedOnBridge(3)==1)
			   {
				   circle3OnBridge=1;
					   channelBusy=1;

			   }
		   else
		   {
			   return;
		   }
	    }

		   cx3+=gui.pixelMovement3;
		   if(cx3>600)
		   {
			   cx3=600;
		   }
		   if(cx3==600)
		   {
			   flag3+=1;
			   circle3OnBridge=0;
			   channelBusy=0;
			   dequeue();
		   }
	   }

	   //Path 4
	   if((flag3==4)&&(cx3>=600&&cx3<=750)&&(cy3>=150 && cy3<=300))
	   {

		   cx3+=gui.pixelMovement3;
		   cy3=-cx3+900;
		   if(cx3>750)
			   cx3=750;
		   if(cy3<150)
			  cy3=150;
		   if(cx3==750)
			   flag3+=1;
	   }
	   //Path 5
	   if((flag3==5)&&(cx3==750)&&(cy3>=150&&cy3<450))
	   {
		   cy3+=gui.pixelMovement3;
		   if(cy3>450)
			   cy3=450;
		   if(cy3==450)
		   {
			   flag3+=1;
		   }
	   }
	   if((flag3==6)&&(cx3>=600&&cx3<=750)&&(cy3>=300&&cy3<=450))
	   {
		   cx3-=gui.pixelMovement3;
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
	   //Path 6
	   if((flag3==7)&&(cx3>=400&&cx3<=600)&&(cy3==300))
	   {
		   if(circle3OnBridge==0)
		   {
			   if(allowedOnBridge(3)==1)
			   {
				   circle3OnBridge=1;
					   channelBusy=1;
			   }
		   else
		   {
			   return;
		   }
		   }


		   cx3-=gui.pixelMovement3;
		   if(cx3<400)
			   cx3=400;
		   if(cx3==400)
		   {
			   flag3+=1;
			   channelBusy=0;
			   circle3OnBridge=0;
			   dequeue();


		   }
	   }
	   //Path 7
	   if(flag3==8&&(cx3>=250&&cx3<=400)&&(cy3>=300&&cy3<=450))
	   {

		   cx3-=gui.pixelMovement3;
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
	 ///Path 1
	   if((flag4==1)&&(cx4==250)&& (cy4>=150 && cy4<=450))
	   {

			   cy4-=gui.pixelMovement4;
			   if(cy4<=150)
				   cy4=150;
			   if(cy4==150)
			   flag4+=1;

	   }
	   ///Path 2
	   if((flag4==2)&&(cx4>=250&&cx4<=400)&&(cy4>=150 && cy4<=300 ))
	   {

		   cx4+=gui.pixelMovement4;
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

	   //Path 3
	   if((flag4==3)&&(cx4>=400&&cx4<=600)&&(cy4==300))
	   {
		   if(circle4OnBridge==0)
		   {
			   if(allowedOnBridge(4)==1)
			   {
				    circle4OnBridge=1;
					   channelBusy=1;
			   }
		   else
		   {
			   return;
		   }
		   }

		   cx4+=gui.pixelMovement4;
		   if(cx4>600)
		   {
			   cx4=600;
		   }
		   if(cx4==600)
		   {
			   flag4+=1;
			   circle4OnBridge=0;
			   channelBusy=0;
			   dequeue();

		   }
	   }

	   //Path 4
	   if((flag4==4)&&(cx4>=600&&cx4<=750)&&(cy4>=150 && cy4<=300))
	   {

		   cx4+=gui.pixelMovement4;
		   cy4=-cx4+900;
		   if(cx4>750)
			   cx4=750;
		   if(cy4<150)
			  cy4=150;
		   if(cx4==750)
			   flag4+=1;
	   }
	   //Path 5
	   if((flag4==5)&&(cx4==750)&&(cy4>=150&&cy4<450))
	   {
		   cy4+=gui.pixelMovement4;
		   if(cy4>450)
			   cy4=450;
		   if(cy4==450)
		   {
			   flag4+=1;
		   }
	   }
	   if((flag4==6)&&(cx4>=600&&cx4<=750)&&(cy4>=300&&cy4<=450))
	   {
		   cx4-=gui.pixelMovement4;
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
				   enqueue(4);
			   }
		   }
	   }
	   //Path 6
	   if((flag4==7)&&(cx4>=400&&cx4<=600)&&(cy4==300))
	   {
		   if(circle4OnBridge==0)
		   {
			   if(allowedOnBridge(4)==1)
			   {
				   circle4OnBridge=1;
					   channelBusy=1;
			   }
		   else
		   {
			   return;
		   }
		   }

		   cx4-=gui.pixelMovement4;
		   if(cx4<400)
			   cx4=400;
		   if(cx4==400)
		   {
			   flag4+=1;
			   channelBusy=0;
			   circle4OnBridge=0;
			   dequeue();


		   }
	   }
	   //Path 7
	   if(flag4==8&&(cx4>=250&&cx4<=400)&&(cy4>=300&&cy4<=450))
	   {

		   cx4-=gui.pixelMovement4;
		   cy4=-cx4+700;
		   if(cx4<250)
			   cx4=250;
		   if(cy4>450)
			   cy4=450;
		   if(cx4==250&&flag4==8)
			   flag4=1;

	   }
   }
   // Method to add the node to the Queue
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
   // Method to remove the node from the Queue
   public void dequeue()
   {

	   int j=0;
	   for( j=0;j<4 && queue[j]!=0;j++)
	   queue[j]=queue[j+1];

	   if(j<3)
	   queue[j+1]=0;

   }
   // Method to check the presence of a node on the Queue
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
   // Special method to allow multiple nodes on the bridge simultaneously
   public int allowedOnBridge(int personNumber)
   {
	   int flagForPersonOnBridge=0;
	   int flags[]={flag1,flag2,flag3,flag4};
	   int personOnBridge=queue[0];
	   if(personOnBridge!=0)
	   {
		 flagForPersonOnBridge=flags[personOnBridge-1];
	   if(personOnBridge==0 || personOnBridge==personNumber)
		   return 1;
	   else
	   {
		   for(int i=0;i<4 && queue[i]!=0;i++)
		   {
			   if(flags[queue[i]-1]==flagForPersonOnBridge)
			   {
				   if(queue[i]==personNumber)
					   return 1;
			   }
			   else break;
		   }
	   }
	   }
	   return 0;
   }
}