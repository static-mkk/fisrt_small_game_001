package Tank99;
import java.awt.Transparency;
import java.io.*;
import java.util.Vector;



//����һ�������͵����꼯�ϣ��ͷ������ڻָ��ϼ���Ϸ
class  tankzuoBiao
{
	int x;
	int y;
	int direct;
	
	public tankzuoBiao(int x,int y,int direct)//ע�����ﲻ��public void tankzuoBiao����������Ϊ�з���ֵ������û��void
	{
		this.x=x;
		this.y=y;
		this.direct=direct;
	}
}


//���ڼ�¼���࣬��·�Լ������˵�����������
class jiLu
{
			//����Ҵ򵽵�̹���������棬Ȼ���ٱ��浽�ļ���
			private static  FileWriter fw=null;
			private static BufferedWriter bw=null;
			static Vector<Diren>direns=new Vector<>();
			static		Vector<tankzuoBiao> tankzuobiaos=new Vector<>();
			
			
			public Vector<tankzuoBiao> getTankzuobiaos() {
			return tankzuobiaos;
		}


		@SuppressWarnings("static-access")
		public void setTankzuobiaos(Vector<tankzuoBiao> tankzuobiaos) {
			this.tankzuobiaos = tankzuobiaos;
		}


			public static Vector<Diren> getDirens() {
				return direns;
			}


			public static void setDirens(Vector<Diren> direns) {
				jiLu.direns = direns;
			}

			//�ָ�tank������ ������
			public static Vector<tankzuoBiao> getzuoBiao()
			{
				try {
					fr=new FileReader("D:/k.txt");
					br=new BufferedReader(fr);
					String s=br.readLine();
					direnSize=Integer.parseInt(s);//���˵�һ�У�ɱ�����˵�����������
					System.out.println(s);
					while((s=br.readLine())!=null)
					{
						//���ļ��ж�ȡÿһ�е����ݣ���x,Y,direct
						String []xyz=s.split(" ");//�ÿո�����ģ�ȥ���ո�
						//���ݱ����3��
						tankzuoBiao tankzuobiao=new tankzuoBiao(Integer.parseInt(xyz[0]),Integer.parseInt(xyz[1]),Integer.parseInt(xyz[2]));//�����ַ��ͻ�û��ת��������
						tankzuobiaos.add(tankzuobiao);
						System.out.println("̹������daxiao"+tankzuobiaos.size());
					}
					
					
					
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				finally
				{
					try {
						br.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					try {
						fr.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				return tankzuobiaos;
			}
			
			
			

			//��¼���˺��Լ���̹�˵�����ͷ���
			public static void jiLutank()
			{
				
				try 
				{
					fw=new FileWriter("D:/k.txt");//ע��ð���������Ļ���Ӣ�ĵ�״̬��д��
											//��Ҫע����һ�㣡����
					bw= new BufferedWriter(fw);
					bw.write(direnSize+""+"\r\n");//����Ӧ��ת��һ�£�
								//��Ϊд��ȥ��Ӧ����string�ͣ�����ʱΪint��
								//���Ե�תһ����
					//��forѭ����������̹�ˣ�����¼���꣬
					for(int i=0;i<direns.size();i++)
					{
						//ȡ��ÿһ������̹��
						Diren diren=direns.get(i);
						if(diren.isLive==true)
						{
							//������˴��ڣ��Ͱѵ��˵�����д�����ļ���
							String s=diren.x+" "+diren.y+" "+diren.direct+"\r\n";
							//�������¼ÿ�����˵�X��Y���ͷ���
							bw.write(s);
						}
								
					}
					
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally
				{
					try {
						bw.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					try {
						fw.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				
			}
			
			
			
			
			public static void Tankwenjian()
			{
				try 
				{
					fw=new FileWriter("D:/k.txt");//ע��ð���������Ļ���Ӣ�ĵ�״̬��д��
											//��Ҫע����һ�㣡����
					bw= new BufferedWriter(fw);
					bw.write(direnSize+"");//����Ӧ��ת��һ�£�
								//��Ϊд��ȥ��Ӧ����string�ͣ�����ʱΪint��
								//���Ե�תһ����
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally
				{
					try {
						bw.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					try {
						fw.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			//�������涨��һ�¶���
				private static FileReader fr=null;
				private static BufferedReader  br=null;
				//дһ�����ȡ��������ݣ�
				public static void  Duquwenjian() throws IOException
				{
					try {
						fr=new FileReader("D:/k.txt");
						br=new BufferedReader(fr);
						String s=br.readLine();
						direnSize=Integer.parseInt(s);
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					finally
					{
						try {
							br.close();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						try {
							fr.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					
				}
			@SuppressWarnings("unused")
			private static int xiaomeiderenSize=0;
			private static int direnSize=5;
			public static int getDirenSize() {
				return direnSize;
			}
			public static void setDirenSize(int direnSize) {
				jiLu.direnSize = direnSize;
			}
			public static int getZijiSize() {
				return zijiSize;
			}
			public static void setZijiSize(int zijiSize) {
				jiLu.zijiSize = zijiSize;
			}
			private static int zijiSize=3;
			
			public static  void direnjianShao()
			{
				direnSize--;
			}
			public static  void zijijianShao()
			{
				zijiSize--;
			}
			public static void xiaomeiderenSize()
			{
				xiaomeiderenSize++;
			}
			
			
			
			
	
	
}


//���е�̹�˾��еĹ��ԣ�
class Tank
{
	int direct=0;
	int speed=1;
	int color=0;
	boolean isLive=true;
	
	public int getColor() {
		return color;
	}
	public void setColor(int color) {
		this.color = color;
	}
	public int getDirect() {
		return direct;
	}
	public void setDirect(int direct) {
		this.direct = direct;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}

	int y=0;
	int x=0;
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	public Tank(int x,int y)
	{
		this.x=x;
		this.y=y;
	}
}
//���˵�̹��
class Diren extends Tank implements Runnable
{  //  int i==1;
	//���ڴ洢���˵��ӵ�
	Vector<Zidan> direnzidans=new Vector<Zidan>();
	//����һ�����˵������飬��Mypanel�ϵĵ��������鴫������������Ȼ���жϵ��˲��໥����ײ
	Vector<Diren> direns=new Vector<Diren>();
	
	Diren diren1=null;
//	int speed=3;
	int timesb=10;
	public Diren(int x,int y)
	{
		super(x,y);
	}
	
	//дһ��������Mypanel�ϵ�direns������
	public void setdirens(Vector<Diren> vv)
	{
		this.direns=vv;
	}
	
	//дһ�����жϵ���֮�䲻����ײ�ķ���
	public boolean isTouchdiren()
	{
		boolean b=false;
		
		//ȡ�����еĵ���̹�ˣ�����Ҫȥ���������̹�ˣ����Ǳ����������̹��
		for(int i=0;i<direns.size();i++)
		{
			Diren diren1=direns.get(i);
			if(diren1!=this)
			{
				switch(this.direct)
				{//���˵ķ���Ȼ�����������˵ķ���
					case 0://������˵�̹�˵ķ�������
						switch(diren1.direct)
						{
						case 0://����ĵ��˵��˶��ķ������Ϻ�����
						case 3:
							 if(this.x+40>diren1.x&&this.x+40<diren1.x+40&&this.y>diren1.y&&this.y<diren1.y+30)
							 {
								  return b=true;
							 }
							 if(this.x+40>diren1.x&&this.x+40<diren1.x+40&&this.y+30>diren1.y&&this.y+30<diren1.y+30)
							 {
								 return b=true;
							 }
							break;
						case 1://���������
						case 2:
							 if(this.x+40>diren1.x&&this.x+40<diren1.x+30&&this.y>diren1.y&&this.y<diren1.y+40)
							 {
								 return b=true;
							 }
							 if(this.x+40>diren1.x&&this.x+40<diren1.x+30&&this.y+30>diren1.y&&this.y+30<diren1.y+40)
							 {
								 return b=true;
							 }
							
							break;
						}
						break;
					case 1:
						switch(diren1.direct)
						{
						case 0://����ĵ��˵��˶��ķ������Ϻ�����
						case 3:
							 if(this.x+30>diren1.x&&this.x+30<diren1.x+40&&this.y>diren1.y&&this.y<diren1.y+30)
							 {
								 return b=true;
							 }
							 if(this.x+30>diren1.x&&this.x+30<diren1.x+40&&this.y+40>diren1.y&&this.y+40<diren1.y+30)
							 {
								 return b=true;
							 }
							break;
						case 1://���������
						case 2:
							 if(this.x+30>diren1.x&&this.x+30<diren1.x+30&&this.y>diren1.y&&this.y<diren1.y+40)
							 {
								 return b=true;
							 }
							 if(this.x+30>diren1.x&&this.x+30<diren1.x+30&&this.y+40>diren1.y&&this.y+40<diren1.y+40)
							 {
								 return b=true;
							 }
							
							break;
						}
						break;
					case 2:
						switch(diren1.direct)
						{
						case 0://����ĵ��˵��˶��ķ������Ϻ�����
						case 3:
							 if(this.x>diren1.x&&this.x<diren1.x+40&&this.y>diren1.y&&this.y<diren1.y+30)
							 {
								 return b=true;
							 }
							 if(this.x+40>diren1.x&&this.x+40<diren1.x+30&&this.y+40>diren1.y&&this.y+40<diren1.y+30)
							 {
								 return b=true;
							 }
							break;
						case 1://���������
						case 2:
							 if(this.x>diren1.x&&this.x<diren1.x+30&&this.y>diren1.y&&this.y<diren1.y+40)
							 {
								 return b=true;
							 }
							 if(this.x>diren1.x&&this.x<diren1.x+30&&this.y+40>diren1.y&&this.y+40<diren1.y+40)
							 {
								 return b=true;
							 }
							
							break;
						}
						
						break;
					case 3:
						switch(diren1.direct)
						{
						case 0://����ĵ��˵��˶��ķ������Ϻ�����
						case 3:
							 if(this.x>diren1.x&&this.x<diren1.x+40&&this.y+30>diren1.y&&this.y+30<diren1.y+30)
							 {
								 return b=true;
							 }
							 if(this.x+40>diren1.x&&this.x+40<diren1.x+40&&this.y+30>diren1.y&&this.y+30<diren1.y+30)
							 {
								 return b=true;
							 }
							break;
						case 1://���������
						case 2:
							 if(this.x>diren1.x&&this.x<diren1.x+30&&this.y+30>diren1.y&&this.y+30<diren1.y+40)
							 {
								 return b=true;
							 }
							 if(this.x+40>diren1.x&&this.x+40<diren1.x+30&&this.y+30>diren1.y&&this.y+30<diren1.y+40)
							 {
								 return b=true; 
							 }
							
							break;
						}
						
						break;
				
				
				}
			}
		}
		
		return b;
	}
	
	
	@Override
	public void run() {
		//���˻��Զ��߶����������б仯������Ӧ�����߳�
		while(true)
		{
			
			
			switch(this.direct)//Ϊʲô���ﲻ�� д��(diren1.direct)?????
			{
			case 0://����
				for(int i=0;i<timesb;i++)
				{
					if(y>=0&&!this.isTouchdiren())
					{y-=speed;}
					
					try {//Ӧ������Ϣһ�²�Ȼ���ں̵ܶ�ʱ������Ȼ��ߺܶ�ط�
						Thread.sleep(50);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				break;
			case 1://����
				for(int i=0;i<timesb;i++)
				{
					if(x<=370&&!this.isTouchdiren())
					{x+=speed;}
					
					try {//Ӧ������Ϣһ�²�Ȼ���ں̵ܶ�ʱ������Ȼ��ߺܶ�ط�
						Thread.sleep(50);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				break;
			case 2://����
				for(int i=0;i<timesb;i++)
				{
					if(x>=0&&!this.isTouchdiren())
					{
					x-=speed;
					}
					try {//Ӧ������Ϣһ�²�Ȼ���ں̵ܶ�ʱ������Ȼ��ߺܶ�ط�
						Thread.sleep(50);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				break;
			case 3://����
				for(int i=0;i<timesb;i++)
				{
					if(y<=270&&!this.isTouchdiren())
					{y+=speed;}
					
					try {//Ӧ������Ϣһ�²�Ȼ���ں̵ܶ�ʱ������Ȼ��ߺܶ�ط�
						Thread.sleep(50);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				break;
			
			}
			//�������һ����ֵ��������
			this.direct=(int)(Math.random()*4);
			//��Ϊȡ����������4������0,1,2,3
			
			//������˵�̹������
			if(this.isLive==false)
			{	//��̹���������˳��߳�
				break;
			}
					
			
			
		}
		
		
		
	}
}
//ը���࣬�������ƶ������Բ��������߳�
class Zhadan 
{
	int x;
	int y;
	boolean isLive=false;
	int life=3;
	public Zhadan(int x,int y)
	{	
		this.x=x;
		this.y=y;
		
	}
	public void lifeDown()
	{
		life=life-3;
	}

	
}

//�ҵ�̹��
class Mytank extends Tank
{
	

	//����һ������������һ�����ӵ�
	
	//��ʼ��һ���ӵ�
//	Zidan zidan2=null;
	Zidan zidan=null;
	Vector<Zidan> zidans=new Vector<Zidan>();
//	boolean isLive=true;
	public Mytank(int x,int y)
	{
		super(x,y);

	}
	//�����ӵ�
	public void Seji()
	{
				try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		switch(this.direct)
		{//����
		case 0:
			//������һ���ӵ�
			zidan=new Zidan(x+20, y-5,0);
			//���ӵ����뵽�ӵ�����,
			zidans.add(zidan);
			break;
		//����
		case 1:
			//����һ���ӵ�
			zidan=new Zidan(x+40, y+15,1);
			zidans.add(zidan);
			break;
		//����
		case 2:
			zidan=new Zidan(x, y+15,2);
			zidans.add(zidan);
			break;
		//����
		case 3:
			zidan=new Zidan(x+20, y+35,3);
			zidans.add(zidan);
			break;
			
		}
		//�ӵ�������û�б仯         //����ʵ����̹�˱����λ�ã��������ӵ���ԭ����λ��!//���Ͻ�
//		System.out.println("�ӵ���x��"+x+"   y��"+y);
		
		//�����ӵ��߳�
		Thread Q=new Thread(zidan);
		Q.start();	
	}
	
	public void MoveUp()
	{
		y-=speed;
	}
	public void MoveDown()
	{
		y+=speed;
	}
	public void MoveLeft()
	{
		x-=speed;
	}
	
	public void MoveRight()
	{
		x+=speed;
	}
}
//̹�˵��ӵ�
class Zidan implements Runnable  
{	
	int speed=2;
	Zidan zidan=null;
	int direct;
	
	//�ж��ӵ��Ƿ�����
	boolean isLive=true;
	
	public int getDirect() {
		return direct;
	}
	public void setDirect(int direct) {
		this.direct = direct;
	}
	int x;
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	int y;
	public Zidan(int x,int y,int direct)
	{
		
		this.x=x;
		this.y=y;
		this.direct=direct;
	}
	public void  run()
	{
		
		while(true)
		{
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			switch(direct)
			{	//����
				case 0:
					y=y-speed;
					break;
				case 1:
					x+=speed;
					break;
				case 2:
					x-=speed;
					break;
				case 3:
					y+=speed;
					break;
			}
	//		System.out.println("��ʱ��������x"+x+"|y="+y);
			
			//�ӵ���ʱ������Ҫд������
			if(x<=0||y<=0||x>=400||y>=300)
			{
				this.isLive=false;
				
				break;     
			}
			//��Ҫ�����ӵ��࣬��ô���е��ӵ��Ͷ������ӵ��Ĺ��ԣ������ӵ���ʱ����
			//�������ҵ�̹�˷������ӵ������ǵ��˵�tank�������ӵ���������һ������
			
			
			
		
		
		}
		
		
		
	}
}


