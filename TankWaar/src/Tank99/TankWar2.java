//Ϊʲô���ǲ��ܰ�̹�˴���ʧ�������ӵ�Ҳû����ʧ������������������




//���������ܴ��5���ӵ����ҵ����е��˺���˻���ʧ�����ǾͲ��ܶ��ˣ����һ�һֱ����
//ԭ������Ϊ����if(diren1.isLive==false){direns.remove(diren1);}
//Ϊʲ ô���ܴ�direns�г�ȥdiren1.���������Ǹ�����̹�ˣ�������������

//��Ϊ����û�п��ƺã��������ǵ�isLive=falseӦ�øĳ�isLive==false
//                      ǰ��Ӧ�¸�����ֵ�������߲����жϵ���Ϊfalseʱ��ִ������Ĵ��룡������
//���Է����ӵ����ӵ�����ʧ������Ҳ����ʧ�����ӵ����5�ţ�

//����Ҫ�ӵĹ����ǣ��ӵ���̹��ʱ �ı�ըЧ����������������

//�����Ѿ�����ʵ�ֵ�������߶������ҿ���������ӵ�������ֻ��һ���ӵ���Ӧ�ö�һ���ӵ���size��ã��������
//int direnzidanSize=3;
//
package Tank99;
//�����ϼ�ûд


//���������й��ܶ��Ѿ�����ˣ�����һ���ո����ͣ�Ϳ�ʼ�Ĺ���û�мӣ�
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;


public class TankWar2 extends JFrame implements ActionListener,KeyListener
{
	static MyPanel2 mp;
	Mystate msp;
	//��һЩ�˵����
	JMenuBar jmb;
	JMenu jm1;
	JMenuItem jmi1;
	JMenuItem jmi2;
	JMenuItem jmi3;
	JMenuItem jmi4;
	
	public TankWar2() 
	{
		jmb=new JMenuBar();
		jm1=new JMenu("��Ϸ��G��");
		jmi1=new JMenuItem("��ʼ��Ϸ��");
		jmi1.addActionListener(this);
		jmi1.setMnemonic('G');
		jmi1.setActionCommand("game");
		jmi2=new JMenuItem("�˳���Ϸ��E��");
		jmi2.setMnemonic('E');
		jmi2.setActionCommand("exit");
		jmi2.addActionListener(this);
		jmi3=new JMenuItem("�����˳���");
		jmi3.addActionListener(this);
		jmi3.setMnemonic('S');
		jmi3.setActionCommand("save");
		jmi4=new JMenuItem("�����ϼ�");
		jmi4.addActionListener(this);
		jmi4.setMnemonic('A');
		jmi4.setActionCommand("again");
		
		
		this.setJMenuBar(jmb);//����һ���˵���
		jmb.add(jm1);
		jm1.add(jmi1);
		jm1.add(jmi2);
		jm1.add(jmi3);
		jm1.add(jmi4);
//		mp=new MyPanel2();
//								//ע����������˳�򣬲��ܻ�û����Ӿ����ü���
//								//ע�������ӵ�˳�򣡣�������ע�⣡
//		this.add(mp);
//		this.addKeyListener(mp);
//		
//		///����mp�߳�
//		Thread t=new Thread(mp);
//		t.start();
		msp=new Mystate();
		Thread t1=new Thread(msp);
		t1.start();
		this.add(msp);
		
		this.setTitle("̹�˴�ս��");
		this.setVisible(true);
		this.setSize(600, 450);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		this.setResizable(false);
		
	}
	
	public static void main (String [] args)
	{
		TankWar2 TankWar2=new TankWar2();
//		///����mp�߳�							//������Ҫ�����������̣߳��Ժ����ﴴ���������������߳�
////		Thread t=new Thread(TankWar2.mp);
//		Thread t=new Thread(TankWar2.msp);
//		t.start();
	
	}

	@SuppressWarnings("static-access")
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
			if(e.getActionCommand().equals("game"))
			{
				this.remove(msp);
				mp=new MyPanel2("newgame");
				//ע����������˳�򣬲��ܻ�û����Ӿ����ü���
				//ע�������ӵ�˳�򣡣�������ע�⣡
				this.add(mp);
				this.addKeyListener(mp);
				
				/////����mp�߳�
				Thread t=new Thread(mp);
				t.start();
				this.setVisible(true);//��仰һ��Ҫд�����������ʾ����Ȼ��岻����ʾ��
				try {
					jiLu.Duquwenjian();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			
			}
			//д�˳� ����Ϣ
			else if(e.getActionCommand().equals("exit"))
			{
				//Ҫ���˳�ǰ������Ϣ
				jiLu.Tankwenjian();
			
				//�ﵽ�˳���Ŀ��
				System.exit(0);
			}
			//�����˳�
			else if(e.getActionCommand().equals("save"))
			{
				//����һ��������ˣ��ҵ�̹�˵����꣬�ӵ��ȣ������
				
//				baocunjiLu b1=new baocunjiLu();
//				b1.baocunjiLu().
//				new baocunjiLu().setDirens(mp.direns);
				jiLu j1=null;//�ȶ���һ������
				j1.setDirens(mp.direns);//�ö����setDirens�ķ�������������direns���Ϳ���ʹjiLu���
										//direns���ʵ�����
				j1.jiLutank();//����jiLu���jiLutank����
				
				//�˳��Ĺ��� д��0�������˳�����д��1���쳣�˳�
				System.exit(0);
			}
			else if(e.getActionCommand().equals("again"))
			{   
				//�����˳�֮��ģ��ָ��Ͼ���Ϸ
				
				System.out.println("��һ��λ�ӣ�");
				//���Ƴ�֮ǰ�����
				this.remove(msp);
				jiLu.getzuoBiao();//���ﲻ�����ǵ���һ��������������ڻ�õ������꣬��������
				//1.�������
				mp=new MyPanel2("again");
				//ע����������˳�򣬲��ܻ�û����Ӿ����ü���
				//ע�������ӵ�˳�򣡣�������ע�⣡
				this.add(mp);
				this.addKeyListener(mp);
				
				/////����mp�߳�
				Thread t=new Thread(mp);
				t.start();
				this.setVisible(true);//��仰һ��Ҫд�����������ʾ����Ȼ��岻����ʾ��
				try {
					jiLu.Duquwenjian();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				 
			}
	}
	
//	class Zanting  extends Tank
//	{
//		public Zanting(int x, int y) {
//			super(x, y);
//			// TODO Auto-generated constructor stub
//		}
//		Zanting zanting;
//		
//		
//	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		//������д�洢̹�˵���Ϣ�Ĵ���
		
		
		
	}
	

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
class Mystate extends JPanel implements Runnable
{
	int time=0;
	public void paint(Graphics g)
	{
		super.paint(g);
		g.drawRect(0, 0, 400, 300);
		if(time%3==0)
		{
		g.setColor(Color.blue);
		Font font=new Font("���Ĳ���",Font.BOLD,30);
		this.setFont(font);
		g.drawString("�ؿ�   1", 150, 150);
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
//		while(true)
//		{
//				try {
//				Thread.sleep(100);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//				time++;
//				
//				this.repaint();
//		}
	}
}

class MyPanel2 extends JPanel implements KeyListener,Runnable
{
	
	Mytank mytank;//�����ҵ�̹��
	//������˵�̹��
	Vector<Diren> direns=new  Vector<Diren>();
	
	
	
	//�����������ʼ���ڹ��캯����
		Image img1=null;
//		//�����ҵ�̹��һ���飬���ڵ��ӵ�����ʱɾ���ҵĵ�̹��
//		Vector<Mytank> myatanks=new Vector<Mytank>();
//		������������⣬������Ӧ��ֻ��һ��if����жϾ����ˣ����������
	
		//����ը���飬��ը�����м���ը��
		Vector<Zhadan> zhadans=new Vector<Zhadan>();
		//����̹��λ�ӣ�����ļ���
//		Vector<tankzuoBiao> tankzuobiaos=new Vector<>();
		
		int direnSize=5;
		String note;
	public MyPanel2(String note)
	{
		//�ҵ�̹��
		mytank=new Mytank(200,200);//�ҵ�̹�˸ճ�����λ�ã�200,200��
		//�ж��Ǵ��¿�ʼ��������Ϸ    Ҫ��ǰ�涨�壬this�����ҵ�
//		String note="newgame";
		this.note=note;
		
		if(this.note.equals("newgame"))
		{
			//�����Ǵ��¿�ʼ����Ϸ
			//���˵�̹��
			for(int i=0;i<direnSize;i++)
			{
				
				Diren diren1=new Diren((i+1)*50,0);
				diren1.setDirect(3);
				
				//�ѵ��˴���Diren���棬���ڵ��˵Ĺ���
				diren1.setdirens(direns);
	//			direns.add(diren1);
				Thread t=new Thread(diren1);
				t.start();//�����߳�
				//�����˵�̹�����һ���ӵ�
				Zidan direnzidan=new Zidan(diren1.x+20,diren1.y+30,3);
				//�ɵ��˵��ӵ����뵽�����ӵ�����
				diren1.direnzidans.add(direnzidan);
				
				
				//��Ϊ�ӵ���һ���̣߳���������Ҫ����һ������߳�
				Thread t2=new Thread(direnzidan);
				t2.start();
				
				direns.add(diren1);
				diren1.isTouchdiren();
				
				}
		}else if(this.note.equals("again"))
		{
//			jiLu.tankzuobiaos =new jiLu().getTankzuobiaos();
			//���˵�̹��
			for(int i=0;i<jiLu.tankzuobiaos.size();i++)
			{//�������������еĻ��ŵĵ���tank���ѵ��˵�����ͷ��򴫸�diren���ʹﵽ�˻ָ���Ч��
				System.out.println("�ڶ���λ�ã�");
				tankzuoBiao tankzuobiao=jiLu.tankzuobiaos.get(i);
				Diren diren1=new Diren(tankzuobiao.x,tankzuobiao.y);
				diren1.setDirect(tankzuobiao.direct);
				
				//�ѵ��˴���Diren���棬���ڵ��˵Ĺ���
				diren1.setdirens(direns);
	//			direns.add(diren1);
				Thread t=new Thread(diren1);
				t.start();//�����߳�
				//�����˵�̹�����һ���ӵ�
				Zidan direnzidan=new Zidan(diren1.x+20,diren1.y+30,3);
				//�ɵ��˵��ӵ����뵽�����ӵ�����
				diren1.direnzidans.add(direnzidan);
				
				
				//��Ϊ�ӵ���һ���̣߳���������Ҫ����һ������߳�
				Thread t2=new Thread(direnzidan);
				t2.start();
				
				direns.add(diren1);
				diren1.isTouchdiren();
		}
		
		
		
		//��ʼ��ը��������
		img1=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/12.gif"));
		}
				
	
	}
	@SuppressWarnings("null")
	public void paint(Graphics g)
	{
		//��ͼ�Ļ�һ��Ҫ��˳�򣬷���Ḳ�ǣ����߳��ְ������������⣡
		
		
		super.paint(g);//��仰���ܣ�
		g.setColor(Color.PINK);
		g.fillRect(0, 0, 400,300);
	
		//�����ҵ�̹��
		//������иĽ��ˣ������˵��ӵ����ҵ�ʱ���ҵ�̹�˾ͻ���������
		if(mytank.isLive==true){
		this.DrawTank(mytank.getX(), mytank.getY(), g, mytank.getDirect(), 0);
		}
//			myatanks.add(mytank);
//		if(mytank.isLive==false)     //ֻҪһ��if��䣬���������isLive==trueʱ��������Ҳ����˵��ֻ�е�mytankʱ���ŵ�
//		{							//ʱ�򣬲Ż����mytank������˵�����������ȥ�������������˾Ͳ���
//			
//			myatanks.remove(mytank);
//		}
		
		//�������˵�̹��
			//�������һ�£�����for(int i=0;i<direnSize;i++)������Ȼ
			//̹�˻�һֱΪ3��
		for(int i=0;i<this.direns.size();i++)
		{
		 Diren diren=direns.get(i);
			if(diren.isLive==true)
			{
				
			this.DrawTank(diren.getX(), diren.getY(), g, diren.getDirect(), 1);
			//�ڻ���̹�˵�ʱ��ͻ����ӵ�
			for(int j=0;j<diren.direnzidans.size();j++)
			{
				Zidan direnzidan=diren.direnzidans.get(j);
//				while(true)
//				{
				if(direnzidan.isLive)
				{
					
					//������ �������˵��ӵ�����ʾ������
					g.fill3DRect(direnzidan.getX(), direnzidan.getY(), 3, 3,false);	
					
				}
				if(direnzidan.isLive==false)
				{
					diren.direnzidans.remove(direnzidan);
				}
//				if(diren.direnzidans.size()<1)
//				{
////					g.fill3DRect(direnzidan.getX(), direnzidan.getY(), 3, 3,false);	
//				}
				}
//			}
			}
			if(diren.isLive==false)
			{
				this.direns.remove(diren);
//				
////			this.DrawTank(diren1.getX()+50, diren1.getY()+50, g, diren1.getDirect(), 1);
			}
		}
		
			//�Ҳ�֪��Ϊʲô������������ǳ���������
			//Ϊʲô���˵�̹�˲�������islive==false��ʱ��
			//��ȥ����Ϊʲô�ӵ����ԣ���������
			//������Ϊʲô��������������
			
			//���� �Ĺ�����ʹ�ô�����̹�˴��³��֣�λ���� 
		
		
		//ע������ ��˳������⣬��һ��Ҫ����mytank����ܻ��Լ����ӵ�����һ��Ҫע��˳��
		//ע������ ��˳������⣬��һ��Ҫ����mytank����ܻ��Լ����ӵ�����һ��Ҫע��˳��
		//ע������ ��˳������⣬��һ��Ҫ����mytank����ܻ��Լ����ӵ�����һ��Ҫע��˳��

		
//				�����ӵ�//���ӵ�����ȥÿһ���ӵ�
		
		
			//Ϊʲô���ﲻ����zidan��Ϊ���ƣ�������
			//ǰ���Ѿ������zidan�ˣ�
		//ע�������zidan2���´����ģ����Բ���mytank�ڣ��������������ÿһ���ӵ����󣬲����������zidan2
			//��������if��mytank.zidan2!=null�����Ǵ�ģ��������ﻭ���ӵ�������mytank�������ӵ�
			
			//�ܽ᣺�����mytank���zidan����zidans���ڣ�Ȼ���ִ�����һ��Zidan������ȡ��zidans���ڵ�ÿһ���ӵ�
			//���������ﻭ����zidan2����������zidan��
			
		for(int i=0;i<mytank.zidans.size();i++)
		{
			Zidan zidan=mytank.zidans.get(i);
			if(zidan!=null||mytank.zidan.isLive==true)
			{
				g.fill3DRect(zidan.getX(), zidan.getY(), 3, 3,false);	
			}	
			if(zidan.isLive==false)
			{
				mytank.zidans.remove(zidan);
//				System.out.println("�ж�������111111");
			}
		}
		//����ը����Ч��
				for(int i=0;i<zhadans.size();i++)
				{
					Zhadan zhadan=zhadans.get(i);
					if(zhadan.life>0)
					{
						g.drawImage(img1, zhadan.x, zhadan.y,30,30 ,this);
//						try {
//							Thread.sleep(1000);
//						} catch (InterruptedException e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}
//						zhadan.sleep(100);
//						zhadans.remove(zhadan);
					}
					zhadan.lifeDown();
					if(zhadan.life==0)
					{
						zhadans.remove(zhadan);
					}
					
				}
				//�����Ա���ʾ ��̹��
				this.DrawTank(50, 350, g, 0, 0);
				g.setColor(Color.black);
				g.drawString(jiLu.getZijiSize()+"", 100, 380);
				this.DrawTank(140, 350, g, 0, 1);
				g.setColor(Color.black);
				g.drawString(jiLu.getDirenSize()+"", 190, 380);
				g.drawString("�Ѿ�����ĵ���������\n"+(5-jiLu.getDirenSize()), 450, 80);
				this.DrawTank(450, 100, g, 0, 1);
		
	}
	public void DrawTank(int x,int y,Graphics g,int direct,int type)
	{
		switch(type)//typeʵ����ָ̹�˵���ɫ������ɫ������̹�˵�����
		{
		case 0:
			g.setColor(Color.yellow);
			break;
		case 1:
			g.setColor(Color.green);
			break;							//ע�����break����һ��������д��������
		}
		switch(direct)//0  �����ϣ�   1  �����ң�      2  ������      3    ������
		{
		case 0:
			//�ڿ�����
			g.fill3DRect(x,y, 10, 30,false);
			g.fill3DRect(x+30,y, 10, 30,false);
			g.fill3DRect(x+10,y+5, 20, 20,false);
			g.fillOval(x+10,y+5, 20, 20);
			g.drawLine(x+20,y+15, x+20, y-5);
			break;							//ע�����break����һ��������д��������
		case 1:
			//�ڿ���Y��
			g.fill3DRect(x+5, y-5, 30, 10, false);
			g.fill3DRect(x+5, y+25, 30, 10, false);
			g.fill3DRect(x+10, y+5, 20, 20, false);
			g.fillOval(x+10, y+5, 20, 20);
			g.drawLine(x+20, y+15, x+40, y+15);
			break;							//ע�����break����һ��������д��������
		case 2:
			//�ڿ�����
			g.fill3DRect(x+5, y-5, 30, 10, false);
			g.fill3DRect(x+5, y+25, 30, 10, false);
			g.fill3DRect(x+10, y+5, 20, 20, false);
			g.fillOval(x+10, y+5, 20, 20);
			g.drawLine(x+20, y+15, x, y+15);
			break;							//ע�����break����һ��������д��������
		case 3:
			//�ڿ�����
			g.fill3DRect(x,y, 10, 30,false);
			g.fill3DRect(x+30,y, 10, 30,false);
			g.fill3DRect(x+10,y+5, 20, 20,false);
			g.fillOval(x+10,y+5, 20, 20);
			g.drawLine(x+20,y+15, x+20, y+35);
			break;							//ע�����break����һ��������д��������
		}
	}
	
	public void shejidiren()
	{
	//������ʵʩ�ж�ÿһ���ӵ��Ƿ��ÿһ�����˵�̹������
			//��Ϊ���ﾭ���ػ���壬����
			for(int i=0;i<mytank.zidans.size();i++)
			{										//��ס���isLive=true�Ǹ�����ֵ��������Ӧ���ǵ���Ϊflaseʱ
													//����isLive==false�������жϵ���Ϊfalseʱ��������
				Zidan zidan=mytank.zidans.get(i);	//���ǣ����ǣ����ǣ����ǣ����ǣ����ǣ����ǣ����ǣ�
				if(zidan.isLive==true)				//���ǣ����ǣ����ǣ����ǣ����ǣ����ǣ����ǣ����ǣ�
				{
					for(int j=0;j<direns.size();j++)
					{
						Diren diren1=direns.get(j);//ǧ���ܰ������get(),����д��i��������д��get(i)!
													//�мǣ�����д��gei(i)
						if(diren1.isLive==true)
						{
							this.Sejidiren(zidan,diren1);
//							System.out.println("��ʱ���ӵ��ǣ�"+i+"��ʱ��̹����+"+j);
							
						}
					}
				}
			}
	}
	
	//���˵��ӵ�������ҵ�̹�˵�ʱ���� ��̹�˺͵��˵��ӵ�һ����ʧ		
	public void direnzidansejimytank()
	{
		
		for(int n=0;n<direns.size();n++)
			{
				Diren diren2=direns.get(n);
				if(diren2.isLive==true)
				{
					for(int k=0;k<diren2.direnzidans.size();k++)
					
					{
						Zidan direndezidan=diren2.direnzidans.get(k);
						if(direndezidan.isLive==true)
							{
							
							if(mytank.isLive==true){
							//����Sejidiren���������������Ҫ�޸�һ�£���Ϊ���������ң������ǣ������ӵ����̹��
							this.Sejidiren(direndezidan, mytank);
							
							}
//								switch(mytank.direct)
//								{
//								case 0:
//								case 3://�ҵ�̹�����Ϻ����µ�ʱ��
//									if(direndezidan.x>mytank.x||direndezidan.x<mytank.x+40||direndezidan.y>mytank.y||direndezidan.y<mytank.y+30)
//									{
//										
//										direndezidan.isLive=false;
//										mytank.isLive=false;
//										System.out.println("���������");
//									}
//								case 1:
//								case 2://�ҵ�̹������������ҵ�ʱ�򣡣���
//									if(direndezidan.x>mytank.x||direndezidan.x<mytank.x+30||direndezidan.y>mytank.y||direndezidan.y<mytank.y+40)
//									{
//										direndezidan.isLive=false;
//										mytank.isLive=false;
//										System.out.println("���������");
//									}
									
								}
							}
					}
					
//			//		Diren diren;
//					for(int k=0;k<diren.direnzidans.size();k++)
//					{										//��ס���isLive=true�Ǹ�����ֵ��������Ӧ���ǵ���Ϊflaseʱ
//						//����isLive==false�������жϵ���Ϊfalseʱ��������
//						Zidan zidan=diren.direnzidans.get(k);	//���ǣ����ǣ����ǣ����ǣ����ǣ����ǣ����ǣ����ǣ�
//						if(zidan.isLive==true)				//���ǣ����ǣ����ǣ����ǣ����ǣ����ǣ����ǣ����ǣ�
//						{
//							this.direnzidansejimytank(zidan, mytank);
//						}
//					}
				}
			}
		
		
//		if(direnzidan.isLive==true)
//			{
//				switch(mytank.direct)
//				{
//				case 0:
//				case 3://�ҵ�̹�����Ϻ����µ�ʱ��
//					if(direnzidan.x>mytank.x||direnzidan.x<mytank.x+40||direnzidan.y>mytank.y||direnzidan.y<mytank.y+30)
//					{
//						
//						direnzidan.isLive=false;
//						mytank.isLive=false;
//						System.out.println("���������");
//					}
//				case 1:
//				case 2://�ҵ�̹������������ҵ�ʱ�򣡣���
//					if(direnzidan.x>mytank.x||direnzidan.x<mytank.x+30||direnzidan.y>mytank.y||direnzidan.y<mytank.y+40)
//					{
//						direnzidan.isLive=false;
//						mytank.isLive=false;
//						System.out.println("���������");
//					}
//					
//				}
//			}
//		}

	//дһ�����ҵ��ӵ����������̹�˵���
	
			public void Sejidiren(Zidan zidan,Tank tank)
			{
				switch(tank.direct)
				{//0,3�����Ϻ��µģ������Դ򵽵�λ������
				//�ж��ӵ������̹���Ƿ�����������������ͳ�ȥ�ӵ��͵��˵�̹��
				//��isLive�϶�̹�˻����ӵ��Ƿ�����
				case 0://���������Ϻ����µ����
				case 3:
					if(zidan.x>tank.x&&zidan.x<tank.x+40&&zidan.y>tank.y&&zidan.y<tank.y+30)
					{
						//�ӵ�������̹������
						zidan.isLive=false;
						tank.isLive=false;
						jiLu.direnjianShao();
						jiLu.xiaomeiderenSize();
						//��̹������ʱ���½�ը���������뵽ը������
						Zhadan zhadan=new Zhadan(tank.x,tank.y);
						zhadan.isLive=true;
						zhadans.add(zhadan);
//						try {
//							Thread.sleep(100);
//						} catch (InterruptedException e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}
//						zhadan.isLive=false;
					}
				case 2://��������������ҵ����
				case 1:
					if(zidan.x>tank.x&&zidan.x<tank.x+30&&zidan.y>tank.y&&zidan.y<tank.y+40)
					{	
						//�ӵ�������̹������
						zidan.isLive=false;
						tank.isLive=false;
						jiLu.direnjianShao();
						jiLu.xiaomeiderenSize();
						//��̹������ʱ���½�ը���������뵽ը������
						Zhadan zhadan=new Zhadan(tank.x,tank.y);
						zhadan.isLive=true;
						zhadans.add(zhadan);
//						try {									//Ŀ��������ը����ը֮���һ��ʱȻ����ʧ
//							Thread.sleep(100);					//����û�гɹ�������������
//						} catch (InterruptedException e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}
//						zhadan.isLive=false;
					}
					
				}
			}
@Override
public void keyTyped(KeyEvent e) {
	// TODO Auto-generated method stub
	
}
@SuppressWarnings("null")
@Override
public void keyPressed(KeyEvent e) {
	if(e.getKeyCode()==KeyEvent.VK_UP)
	{	
		this.mytank.setDirect(0);
		this.mytank.setSpeed(5);
		this.mytank.MoveUp();
	}
	if(e.getKeyCode()==KeyEvent.VK_DOWN)
	{	
		this.mytank.setDirect(3);
		this.mytank.setSpeed(5);
		this.mytank.MoveDown();
	}
	if(e.getKeyCode()==KeyEvent.VK_LEFT)
	{	
		this.mytank.setDirect(2);
		this.mytank.setSpeed(5);
		this.mytank.MoveLeft();
	}
	if(e.getKeyCode()==KeyEvent.VK_RIGHT)
	{	
		this.mytank.setDirect(1);
		this.mytank.setSpeed(5);
		this.mytank.MoveRight();
	}
	if(e.getKeyCode()==KeyEvent.VK_J)
	{	
		System.out.println("���ڵ��ӵ�������Ϊ��"+this.mytank.zidans.size());
		if(mytank.zidans.size()<=4)
		{
		this.mytank.Seji();
		}
	}
	
	int time=0;
//	while(true)
//	{
		if(e.getKeyCode()==KeyEvent.VK_SPACE)
		{
			++time;
			if(time%2==0)
			{
				/////////////////////////////////////////////////��û��д������ͣ���ͼ���������
				Zidan zidan = null;
				
				zidan.speed=0;
				Tank tank=null;
				tank.speed=0;
				
			}
		}
		this.repaint();
//	}
	
//		if(zidan.isLive==false)
//		{
//			mytank.zidans.remove(zidan2);
//		}
	// TODO Auto-generated method stub
}
@Override
public void keyReleased(KeyEvent e) {
	// TODO Auto-generated method stub
	
}
@Override
public void run()
{
	while(true)
	{
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		//�жϵ��˵��ӵ��Ƿ����,,.Ӧ����ÿһ��̹�˵��ӵ��Ƿ񻹻��ţ�����Ӧ����forѭ��
		for(int i=0;i<this.direns.size();i++)
		{
			Diren diren=direns.get(i);
			if(diren.isLive==true)
			{	//����ӵ��Ѿ�����
				//��ô����һ�����˵��ӵ�����Ϊ�ӵ���������⣬��Ҫ��switch���
					Zidan direnzidan=null;
				if(diren.direnzidans.size()<4)
				{
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					switch(diren.direct)
					{
					//����
					case 0:
						//������һ���ӵ�
						direnzidan=new Zidan(diren.x+20, diren.y-5,0);
						//���ӵ����뵽�ӵ�����,
						diren.direnzidans.add(direnzidan);
						break;
					//����
					case 1:
						//����һ���ӵ�
						direnzidan=new Zidan(diren.x+40, diren.y+15,1);
						diren.direnzidans.add(direnzidan);
						break;
					//����
					case 2:
						direnzidan=new Zidan(diren.x, diren.y+15,2);
						diren.direnzidans.add(direnzidan);
						break;
					//����
					case 3:
						direnzidan=new Zidan(diren.x+20, diren.y+35,3);
						diren.direnzidans.add(direnzidan);
						break;
					
					
					}
					Thread t=new Thread(direnzidan);
					t.start();
					}
				
			}
		}
		
		//�ҵ��ӵ��Ƿ���������˵�̹��,,ǰ��д��һ�����������������һ�¾����ˣ�
		this.shejidiren();
		//ִ�е��˵��ӵ��Ƿ����ҵ�̹��
		this.direnzidansejimytank();
		  
	
		
//		Zidan direnzidan = null;
//		this.direnzidansejimytank(direnzidan, mytank);
			//�����ػ�
		this.repaint();
		}
	
	}
}

	






