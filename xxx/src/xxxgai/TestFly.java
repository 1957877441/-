package xxxgai;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class TestFly {

	static Connection con = null;//����
	static PreparedStatement ps = null;//ģ��
	static ResultSet rs = null;//�����

	public static void main(String[] args) throws Exception {
		
		System.out.println("******************************************������Ϣ����ϵͳ********************************************\n");
		//show();
		boolean bool = Dome();
		while(bool){
			bool = Dome();
		}
		if(!bool){
			System.out.println("**************************************�ѳɹ��˳�������Ϣ����ϵͳ**************************************\n");
			System.exit(0);
		}
	}
	
	//����
	public static boolean Dome() throws Exception{
		Scanner scan = new Scanner(System.in);
		show();
		int key = scan.nextInt();
		switch (key) {
		case 1:
			showMessage(listMessage());
			break;
			
		case 2:{
			System.out.println("����ʱ�䣺");
			String date = scan.next();
			showMessage(selectDate(date));
			System.out.println("��"+date+"����ͳ�Ƶ�����\n");
			showNum(selectDate(date));
		}break;
		
		case 3:{
			System.out.println("�������ѯ�ķ�����Ϣ��\"��ѡ�������(1.���޷��ȣ�2.�Ƿ�Ϊ��Уѧ����3.�Ƿ�Ϊ��������4.�Ƿ����人������Ա�Ӵ���5.�Ƿ������������Ա�Ӵ���6.�Ƿ����人��7.�Ƿ��ں�����8.�������ط�У)");
			int key1 = scan.nextInt();
			switch (key1) {
			case 1:{
				System.out.println("���޷��ȣ�");
				String Situation = scan.next();
				showMessage(selectSituation(Situation));
				if(Situation.equals("�з���")) {
					System.out.println("��������Ϊ��");
				}
				else if(Situation.equals("�޷���")) {
					System.out.println("δ��������Ϊ��");
				}
				showNum(selectSituation(Situation));
			}break;
			case 2:{
				System.out.println("�Ƿ�Ϊ��Уѧ����");
				String Situation1 = scan.next();
				showMessage(selectSituation1(Situation1));
				if(Situation1.equals("��")) {
					System.out.println("����Уѧ��������Ϊ��");
				}
				else if(Situation1.equals("��")) {
					System.out.println("������Уѧ������Ϊ��");
				}
				showNum(selectSituation1(Situation1));
			}break;
			case 3:{
				System.out.println("�Ƿ�Ϊ��������");
				String Situation2 = scan.next();
				showMessage(selectSituation2(Situation2));
				if(Situation2.equals("��")) {
					System.out.println("����������Ϊ��");
				}
				else if(Situation2.equals("��")) {
					System.out.println("����������Ϊ��");
				}
				showNum(selectSituation2(Situation2));
			}break;
			case 4:{
				System.out.println("�Ƿ����人������Ա�Ӵ��� ");
				String Situation3 = scan.next();
				showMessage(selectSituation3(Situation3));
				if(Situation3.equals("��")) {
					System.out.println("�Ѿ����人������Ա�Ӵ�������Ϊ��");
				}
				else if(Situation3.equals("��")) {
					System.out.println("δ���人������Ա�Ӵ�������Ϊ��");
				}
				showNum(selectSituation3(Situation3));
			}break;
			case 5:{
				System.out.println("�Ƿ������������Ա�Ӵ���");
				String Situation4 = scan.next();
				showMessage(selectSituation4(Situation4));
				if(Situation4.equals("��")) {
					System.out.println("�Ѿ������������Ա�Ӵ�������Ϊ��");
				}
				else if(Situation4.equals("��")) {
					System.out.println("δ�����������Ա�Ӵ�������Ϊ��");
				}
				showNum(selectSituation4(Situation4));
			}break;
			case 6:{
				System.out.println("�Ƿ����人��");
				String Situation5 = scan.next();
				showMessage(selectSituation5(Situation5));
				if(Situation5.equals("��")) {
					System.out.println("���人������Ϊ��");
				}
				else if(Situation5.equals("��")) {
					System.out.println("δ���人������Ϊ��");
				}
				showNum(selectSituation5(Situation5));
			}break;
			case 7:{
				System.out.println("�Ƿ��ں�����");
				String Situation6 = scan.next();
				showMessage(selectSituation6(Situation6));
				if(Situation6.equals("��")) {
					System.out.println("�ں���������Ϊ��");
				}
				else if(Situation6.equals("��")) {
					System.out.println("δ�ں���������Ϊ��");
				}
				showNum(selectSituation6(Situation6));
			}break;
			case 8:{
				System.out.println("�Ƿ�������ط�У��");
				String Situation7 = scan.next();
				showMessage(selectSituation7(Situation7));
				if(Situation7.equals("��")) {
					System.out.println("��У����Ϊ��");
				}
				else if(Situation7.equals("��")) {
					System.out.println("δ��У����Ϊ��");
				}
				showNum(selectSituation7(Situation7));
			}break;
		}			
		}break;
		
		case 4:{
			System.out.println("����������ѧ�ţ���");
			String name = scan.next();
			selectAntiNum(name);
		}break;
		
		case 5:{
			System.out.println("����������ѧ�ţ������ڣ�����׼ȷ��ѯ��");
			String name = scan.next();
			String date = scan.next();
			selectAntiNum1(name,date);
		}break;
		
		case 6:{
			System.out.println("����������ѧ�ţ�:");
			String name = scan.next();
			deleteFly(name);
		}break;
						
		case 7:{
			System.out.println("����������ѧ�ţ�������������Ǽ�ʱ�䡢���������");
			String name = scan.next();
			String Situation = scan.next();
			String Situation1 = scan.next();
			String Situation2 = scan.next();
			String Situation3 = scan.next();
			String Situation4 = scan.next();
			String Situation5 = scan.next();
			String Situation6 = scan.next();
			String Situation7 = scan.next();
			String date = scan.next();
			creatAnti(name,Situation,Situation1,Situation2,Situation3,Situation4,Situation5,Situation6,Situation7,date);
		}break;
						
		default:
			//scan.close();
			return false;
		}
		//scan.close();
		return true;
	}

	//ע����������ȡ����
	public static Connection getCon() throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fly", "root", "19981228");
		return con;
	}
	
	//������ʼ��Ϣ��������Ϣ
	public static void creatAnti(String name,String situation, String situation1, String situation2, String situation3, String situation4, String situation5, String situation6, String situation7,String date) throws Exception{
		getCon();
		String sql = "insert into anti values (null,?,?,?,?,?,?,?,?,?,?)";
		ps = con.prepareStatement(sql);
		ps.setString(1, name);
		ps.setString(2, situation);
		ps.setString(3, situation1);
		ps.setString(4, situation2);
		ps.setString(5, situation3);
		ps.setString(6, situation4);
		ps.setString(7, situation5);
		ps.setString(8, situation6);
		ps.setString(9, situation7);
		ps.setString(10, date);
		ps.executeUpdate();
		ps.close();
		con.close();
		selectAntiNum(name);
	}
	
	//ϵͳ���˵�
	public static void show(){
		System.out.println("��ѡ�������(1.�г�������Ϣ��2.��ʱ���ѯ��3.��������Ϣ��ѯ��4.��������ѧ�ţ���ѯ��5.��������ѧ�ţ���ѯ�����ڣ�����׼ȷ��ѯ��6.ɾ����Ա��Ϣ��7.�����Ա��Ϣ�� 8.�˳�ϵ�y)");
	}
	
	//��ȡ����������
	public static void showMessage(Set<Anti> set){
		System.out.println("\n********************************��Ȩ���У�wyq***********************************\n");
		if(set.size() == 0){
			System.out.println("δƥ�䵽�κ����ݣ�");
			System.out.println("\n********************************��Ȩ���У�wyq***********************************\n");
			return;
		}
		System.out.println("Anti\t\t����\t\t���޷���\t\t�Ƿ�Ϊ��Уѧ��/�Ƿ�Ϊ������/�Ƿ����人������Ա�Ӵ�/�Ƿ������������Ա�Ӵ�/�Ƿ����人\t�Ƿ��ں���\t�Ƿ�������ط�У ʱ��");
		for( Anti value : set){
			System.out.println(value);
		}
		System.out.println("\n********************************��Ȩ���У�wyq***********************************\n");
	}
	//��ȡ�����ݵ�����
	public static void showNum(Set<Anti> set){
		int x=0;
		for( Anti value : set){
			x++;
			System.out.println(value);
		}
		System.out.println("\n***����ͳ��***\n");
		System.out.println("����"+x+"��");
		System.out.println("\n***����ͳ��***\n");
	}	
	//�г�������Ϣ
	public static Set<Anti> listMessage() throws Exception{
		getCon();
		String sql = "select * from anti";
		ps = con.prepareStatement(sql);
		rs = ps.executeQuery();
		
		Set<Anti> set = new HashSet<>();
		
		while(rs.next()){
			int id = rs.getInt("id");
			String name = rs.getString("name");
			String situation = rs.getString("situation");
			String situation1 = rs.getString("situation1");
			String situation2 = rs.getString("situation2");
			String situation3 = rs.getString("situation3");
			String situation4 = rs.getString("situation4");
			String situation5 = rs.getString("situation5");
			String situation6 = rs.getString("situation6");
			String situation7 = rs.getString("situation7");
			String dateTime = rs.getString("date");
			Anti anti = new Anti(id, name, situation, situation1, situation2, situation3, situation4, situation5, situation6, situation7,dateTime);
			set.add(anti);
		}
		ps.close();
		con.close();
		return set;
	}
	
	//��ʱ��
	public static Set<Anti> selectDate(String date) throws Exception{
		getCon();
		String sql = "select * from anti where date = ? ";
		ps = con.prepareStatement(sql);
		ps.setString(1, date);
		rs = ps.executeQuery();
		
		Set<Anti> set = new HashSet<>();

		while(rs.next()){
			int id = rs.getInt("id");
			String name = rs.getString("name");
			String situation = rs.getString("situation");
			String situation1 = rs.getString("situation1");
			String situation2 = rs.getString("situation2");
			String situation3 = rs.getString("situation3");
			String situation4 = rs.getString("situation4");
			String situation5 = rs.getString("situation5");
			String situation6 = rs.getString("situation6");
			String situation7 = rs.getString("situation7");
			String dateTime = rs.getString("date");
			Anti anti = new Anti(id, name, situation, situation1, situation2, situation3, situation4, situation5, situation6, situation7,dateTime);
			set.add(anti);
		}
		ps.close();
		con.close();
		return set;
	}
	
	//���������
	public static Set<Anti> selectSituation(String Situation) throws Exception{
		getCon();
		String sql = "select * from anti where situation = ? ";
		ps = con.prepareStatement(sql);
		ps.setString(1, Situation);
		rs = ps.executeQuery();
		
		Set<Anti> set = new HashSet<>();
		
		while(rs.next()){
			int id = rs.getInt("id");
			String name = rs.getString("name");
			String situation = rs.getString("situation");
			String situation1 = rs.getString("situation1");
			String situation2 = rs.getString("situation2");
			String situation3 = rs.getString("situation3");
			String situation4 = rs.getString("situation4");
			String situation5 = rs.getString("situation5");
			String situation6 = rs.getString("situation6");
			String situation7 = rs.getString("situation7");
			String dateTime = rs.getString("date");
			Anti anti = new Anti(id, name, situation, situation1, situation2, situation3, situation4, situation5, situation6, situation7,dateTime);
			set.add(anti);
		}
		ps.close();
		con.close();
		return set;
	}
	    //���������1
		public static Set<Anti> selectSituation1(String Situation1) throws Exception{
			getCon();
			String sql = "select * from anti where situation1 = ? ";
			ps = con.prepareStatement(sql);
			ps.setString(1, Situation1);
			rs = ps.executeQuery();
			
			Set<Anti> set = new HashSet<>();
			
			while(rs.next()){
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String situation = rs.getString("situation");
				String situation1 = rs.getString("situation1");
				String situation2 = rs.getString("situation2");
				String situation3 = rs.getString("situation3");
				String situation4 = rs.getString("situation4");
				String situation5 = rs.getString("situation5");
				String situation6 = rs.getString("situation6");
				String situation7 = rs.getString("situation7");
				String dateTime = rs.getString("date");
				Anti anti = new Anti(id, name, situation, situation1, situation2, situation3, situation4, situation5, situation6, situation7,dateTime);
				set.add(anti);
			}
			ps.close();
			con.close();
			return set;
		}
		//���������2
		public static Set<Anti> selectSituation2(String Situation2) throws Exception{
			getCon();
			String sql = "select * from anti where situation2 = ? ";
			ps = con.prepareStatement(sql);
			ps.setString(1, Situation2);
			rs = ps.executeQuery();
			
			Set<Anti> set = new HashSet<>();
			
			while(rs.next()){
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String situation = rs.getString("situation");
				String situation1 = rs.getString("situation1");
				String situation2 = rs.getString("situation2");
				String situation3 = rs.getString("situation3");
				String situation4 = rs.getString("situation4");
				String situation5 = rs.getString("situation5");
				String situation6 = rs.getString("situation6");
				String situation7 = rs.getString("situation7");
				String dateTime = rs.getString("date");
				Anti anti = new Anti(id, name, situation, situation1, situation2, situation3, situation4, situation5, situation6, situation7,dateTime);
				set.add(anti);
			}
			ps.close();
			con.close();
			return set;
		}
		//���������3
		public static Set<Anti> selectSituation3(String Situation3) throws Exception{
			getCon();
			String sql = "select * from anti where situation3 = ? ";
			ps = con.prepareStatement(sql);
			ps.setString(4, Situation3);
			rs = ps.executeQuery();
			
			Set<Anti> set = new HashSet<>();
			
			while(rs.next()){
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String situation = rs.getString("situation");
				String situation1 = rs.getString("situation1");
				String situation2 = rs.getString("situation2");
				String situation3 = rs.getString("situation3");
				String situation4 = rs.getString("situation4");
				String situation5 = rs.getString("situation5");
				String situation6 = rs.getString("situation6");
				String situation7 = rs.getString("situation7");
				String dateTime = rs.getString("date");
				Anti anti = new Anti(id, name, situation, situation1, situation2, situation3, situation4, situation5, situation6, situation7,dateTime);
				set.add(anti);
			}
			ps.close();
			con.close();
			return set;
		}
		//���������4
		public static Set<Anti> selectSituation4(String Situation4) throws Exception{
			getCon();
			String sql = "select * from anti where situation4 = ? ";
			ps = con.prepareStatement(sql);
			ps.setString(1, Situation4);
			rs = ps.executeQuery();
			
			Set<Anti> set = new HashSet<>();
			
			while(rs.next()){
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String situation = rs.getString("situation");
				String situation1 = rs.getString("situation1");
				String situation2 = rs.getString("situation2");
				String situation3 = rs.getString("situation3");
				String situation4 = rs.getString("situation4");
				String situation5 = rs.getString("situation5");
				String situation6 = rs.getString("situation6");
				String situation7 = rs.getString("situation7");
				String dateTime = rs.getString("date");
				Anti anti = new Anti(id, name, situation, situation1, situation2, situation3, situation4, situation5, situation6, situation7,dateTime);
				set.add(anti);
			}
			ps.close();
			con.close();
			return set;
		}
		//���������
		public static Set<Anti> selectSituation5(String Situation5) throws Exception{
			getCon();
			String sql = "select * from anti where situation5 = ? ";
			ps = con.prepareStatement(sql);
			ps.setString(1, Situation5);
			rs = ps.executeQuery();
			
			Set<Anti> set = new HashSet<>();
			
			while(rs.next()){
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String situation = rs.getString("situation");
				String situation1 = rs.getString("situation1");
				String situation2 = rs.getString("situation2");
				String situation3 = rs.getString("situation3");
				String situation4 = rs.getString("situation4");
				String situation5 = rs.getString("situation5");
				String situation6 = rs.getString("situation6");
				String situation7 = rs.getString("situation7");
				String dateTime = rs.getString("date");
				Anti anti = new Anti(id, name, situation, situation1, situation2, situation3, situation4, situation5, situation6, situation7,dateTime);
				set.add(anti);
			}
			ps.close();
			con.close();
			return set;
		}
		//���������6
		public static Set<Anti> selectSituation6(String Situation6) throws Exception{
			getCon();
			String sql = "select * from anti where situation6 = ? ";
			ps = con.prepareStatement(sql);
			ps.setString(1, Situation6);
			rs = ps.executeQuery();
			
			Set<Anti> set = new HashSet<>();
			
			while(rs.next()){
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String situation = rs.getString("situation");
				String situation1 = rs.getString("situation1");
				String situation2 = rs.getString("situation2");
				String situation3 = rs.getString("situation3");
				String situation4 = rs.getString("situation4");
				String situation5 = rs.getString("situation5");
				String situation6 = rs.getString("situation6");
				String situation7 = rs.getString("situation7");
				String dateTime = rs.getString("date");
				Anti anti = new Anti(id, name, situation, situation1, situation2, situation3, situation4, situation5, situation6, situation7,dateTime);
				set.add(anti);
			}
			ps.close();
			con.close();
			return set;
		}
		//���������7
		public static Set<Anti> selectSituation7(String Situation7) throws Exception{
			getCon();
			String sql = "select * from anti where situation7 = ? ";
			ps = con.prepareStatement(sql);
			ps.setString(1, Situation7);
			rs = ps.executeQuery();
			
			Set<Anti> set = new HashSet<>();
			
			while(rs.next()){
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String situation = rs.getString("situation");
				String situation1 = rs.getString("situation1");
				String situation2 = rs.getString("situation2");
				String situation3 = rs.getString("situation3");
				String situation4 = rs.getString("situation4");
				String situation5 = rs.getString("situation5");
				String situation6 = rs.getString("situation6");
				String situation7 = rs.getString("situation7");
				String dateTime = rs.getString("date");
				Anti anti = new Anti(id, name, situation, situation1, situation2, situation3, situation4, situation5, situation6, situation7,dateTime);
				set.add(anti);
			}
			ps.close();
			con.close();
			return set;
		}	
	//������
	public static void selectAntiNum(String name) throws Exception{
		getCon();
		String sql = "select * from anti where name = ? ";
		ps = con.prepareStatement(sql);
		ps.setString(1, name);
		rs = ps.executeQuery();
		boolean x = true;
		while(rs.next()){
			if(x){
				System.out.println("\n********************************��Ȩ���У�wyq***********************************\n");
			}
			int id = rs.getInt("id");
			String antinum = rs.getString("name");
			String situation = rs.getString("situation");
			String situation1 = rs.getString("situation1");
			String situation2 = rs.getString("situation2");
			String situation3 = rs.getString("situation3");
			String situation4 = rs.getString("situation4");
			String situation5 = rs.getString("situation5");
			String situation6 = rs.getString("situation6");
			String situation7 = rs.getString("situation7");
			String date = rs.getString("date");
			System.out.println("Anti" + id + "\t\t" + antinum + "\t\t" + situation + "\t\t" + situation1 + "\t\t" + situation2 + "\t\t" + situation3 + "\t\t" + situation4 +  "\t\t" + situation5 + "\t\t" + situation6 + "\t\t" + situation7 + "\t\t" + date);
			x = false;
		}
		System.out.println("\n********************************��Ȩ���У�wyq***********************************\n");
	}
	
	public static void selectAntiNum1(String name,String date) throws Exception{
		getCon();
		String sql = "select * from anti where name = ? and date = ? ";
		ps = con.prepareStatement(sql);
		ps.setString(1, name);
		ps.setString(2, date);
		rs = ps.executeQuery();
		boolean x = true;
		while(rs.next()){
			if(x){
				System.out.println("\n********************************��Ȩ���У�wyq***********************************\n");
			}
			int id = rs.getInt("id");
			String antinum = rs.getString("name");
			String situation = rs.getString("situation");
			String situation1 = rs.getString("situation1");
			String situation2 = rs.getString("situation2");
			String situation3 = rs.getString("situation3");
			String situation4 = rs.getString("situation4");
			String situation5 = rs.getString("situation5");
			String situation6 = rs.getString("situation6");
			String situation7 = rs.getString("situation7");
			String date1 = rs.getString("date");
			System.out.println("Anti" + id + "\t\t" + antinum + "\t\t" + situation + "\t\t" + situation1 + "\t\t" + situation2 + "\t\t" + situation3 + "\t\t" + situation4 +  "\t\t" + situation5 + "\t\t" + situation6 + "\t\t" + situation7 + "\t\t" + date);
			x = false;
		}
		System.out.println("\n********************************��Ȩ���У�wyq***********************************\n");
	}
	
	//������ɾ��������Ϣ
	public static void deleteFly(String name) throws Exception{
		getCon();
		String sql = "delete from anti where name = ? ";
		ps = con.prepareStatement(sql);
		ps.setString(1, name);
		ps.executeUpdate();
		ps.close();
		con.close();
		System.out.println("\n********************************��Ȩ���У�wyq***********************************\n");
		System.out.println("��ɾ����");
		System.out.println("\n********************************��Ȩ���У�wyq***********************************\n");
	}
}
