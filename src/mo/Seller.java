package mo;

import java.util.Iterator;
import java.util.Vector;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.logging.Logger;

import db.Mysql;

public class Seller implements Sqlable{
	
	private Mysql mysql;
	private int id;
	private String name;
	private String realname;
	private String password;
	private String phonenum;
	private String postbox;
	private String productinf;
	private int role;
	private String rolename;
	private Vector<Action> action;

	public Seller()
	{
		mysql=Mysql.getInstance();
	}
	public Seller(int id)
	{
		this();
		this.id=id;
	}
	public Seller(String name,String realname,String password,String phonenum,String postbox,String productinf)
	{
		this();
		this.name=name;
		this.realname=realname;
		this.password=password;
		this.phonenum=phonenum;
		this.postbox=postbox;
		this.productinf=productinf;
	}
	public Seller(int id,String name,String realname,String password,String phonenum,String postbox,String productinf)
	{
		this();
		this.id=id;
		this.name=name;
		this.realname=realname;
		this.password=password;
		this.phonenum=phonenum;
		this.postbox=postbox;
		this.productinf=productinf;
	}
	public Seller(String name,String pass)
	{
		this();
		this.name=name;
		this.password=pass;
	}
	
	public boolean verify()
	{
		String sql="SELECT id,realname,phonenum,postbox,productinf,role from seller where name='"+name+"' and password='"+password+"'";
		ResultSet rs=mysql.query(sql);
		try {
			if(rs.next())
			{
				this.id=rs.getInt(1);
				this.realname=rs.getString(2);
				this.phonenum=rs.getString(3);
				this.postbox=rs.getString(4);
				this.productinf=rs.getString(5);
				this.role=rs.getInt(6);
				return true;
			}
			else
				return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Logger.getLogger("travel").warning(e.getMessage());
			return false;
		}
	}
	public Iterator<Action> getAction()
	{
		String sql= "SELECT a.action_name,a.link,a.parent,a.is_dir,a.id from action as a,role_action  as b where b.role="+role+" and b.action=a.id and b.`enable`=1";
		//System.out.println(sql);
		ResultSet rs=mysql.query(sql);
		action=new Vector<Action>();
		try {
			while(rs.next())
			{
				Action act=new Action();
				act.setAction_name(rs.getString(1));
				act.setIs_dir(rs.getInt(4));
				act.setLink(rs.getString(2));
				act.setParent(rs.getInt(3));
				act.setId(rs.getInt(5));
				action.add(act);
			}
			return action.iterator();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	@Override
	public boolean insert() {
		// TODO Auto-generated method stub
		if(name==null||realname==null||password==null||phonenum==null||postbox==null||productinf==null)
			return false;
		String sql="INSERT INTO seller(name,realname,password,phonenum,postbox,productinf,role) values('"+name+"','"+realname+"','"+password+"','"+phonenum+"','"+postbox+"','"+productinf+"',"+role+")";
		System.out.println(sql);
		return mysql.execute(sql);
	}

	@Override
	public int update() {
		// TODO Auto-generated method stub
		if(id==0)
			return -1;
		  String sql="UPDATE seller SET name='"+name+"',realname='"+realname+"',password='"+password+"',phonenum='"+phonenum+"',postbox='"+postbox+"',productinf='"+productinf+"',role="+role+" where id="+id;
		  return mysql.update(sql);
	}

	@Override
	public boolean delete() {
		// TODO Auto-generated method stub
		if(id==0)
			return false;
		return mysql.delete("seller", id);
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		if(id<=0)
			return false;
		return mysql.delete("seller", id);
	}

	@Override
	public boolean truncate() {
		// TODO Auto-generated method stub
		String sql="TRUNCATE table seller";
		return mysql.equals(sql);
	}

	@Override
	public Iterator<Seller> selectAll() {
		// TODO Auto-generated method stub
		String sql="select a.id,a.name,a.realname,a.password,a.phonenum,a.postbox,a.productinf,a.role,b.name from seller as a,role as b where a.role=b.id";
		ResultSet rs=mysql.query(sql);
		LinkedList<Seller> list=new LinkedList<Seller>();	
		try {
			while(rs.next())
			{
				Seller seller=new Seller();
				seller.setId(rs.getInt(1));
				seller.setName(rs.getString(2));
				seller.setRealname(rs.getString(3));
				seller.setPassword(rs.getString(4));
				seller.setPhonenum(rs.getString(5));
				seller.setPostbox(rs.getString(6));
				seller.setProductinf(rs.getString(7));
				seller.setRole(rs.getInt(8));
				seller.setRolename(rs.getString(9));
				list.add(seller);
			}
			return list.iterator();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			Logger.getLogger("travel").warning(e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
	public Iterator<Seller> selectAll(int start,int size) {
		// TODO Auto-generated method stub
		String sql="select a.id,a.name,a.realname,a.password,a.phonenum,a.postbox,a.productinf,a.role,b.name from seller as a,role as b where a.role=b.id limit "+start+","+size;
		ResultSet rs=mysql.query(sql);
		LinkedList<Seller> list=new LinkedList<Seller>();	
		try {
			while(rs.next())
			{
				Seller seller=new Seller();
				seller.setId(rs.getInt(1));
				seller.setName(rs.getString(2));
				seller.setRealname(rs.getString(3));
				seller.setPassword(rs.getString(4));
				seller.setPhonenum(rs.getString(5));
				seller.setPostbox(rs.getString(6));
				seller.setProductinf(rs.getString(7));
				seller.setRole(rs.getInt(8));
				seller.setRolename(rs.getString(9));
				list.add(seller);
			}
			return list.iterator();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			Logger.getLogger("travel").warning(e.getMessage());
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Seller selectedId(int id) {
		// TODO Auto-generated method stub
		String sql="select a.id,a.name,a.realname,a.password,a.phonenum,a.postbox,a.productinf,a.role,b.name from seller as a,role as b where a.role=b.id and a.id="+id;
		ResultSet rs=mysql.query(sql);
		try {
			if(rs.next())
			{
				Seller seller=new Seller();
				seller.setId(rs.getInt(1));
				seller.setName(rs.getString(2));
				seller.setRealname(rs.getString(3));
				seller.setPassword(rs.getString(4));
				seller.setPhonenum(rs.getString(5));
				seller.setPostbox(rs.getString(6));
				seller.setProductinf(rs.getString(7));
				seller.setRole(rs.getInt(8));
				seller.setRolename(rs.getString(9));
				return seller;
			}
			return null;
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			Logger.getLogger("travel").warning(e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
	

	@Override
	public Iterator<Seller> selectSql(String where) {
		// TODO Auto-generated method stub
		String sql="select a.id,a.name,a.realname,a.password,a.phonenum,a.postbox,a.productinf,a.role,b.name from seller as a,role as b where a.role=b.id and "+where;
		ResultSet rs=mysql.query(sql);
		LinkedList<Seller> list=new LinkedList<Seller>();	
		try {
			while(rs.next())
			{
				Seller seller=new Seller();
				seller.setId(rs.getInt(1));
				seller.setName(rs.getString(2));
				seller.setRealname(rs.getString(3));
				seller.setPassword(rs.getString(4));
				seller.setPhonenum(rs.getString(5));
				seller.setPostbox(rs.getString(6));
				seller.setProductinf(rs.getString(7));
				seller.setRole(rs.getInt(8));
				seller.setRolename(rs.getString(9));
				
				list.add(seller);
			}
			return list.iterator();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			Logger.getLogger("travel").warning(e.getMessage());
			e.printStackTrace();
			return null;
		}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhonenum() {
		return phonenum;
	}

	public void setPhonenum(String phonenum) {
		this.phonenum = phonenum;
	}

	public String getPostbox() {
		return postbox;
	}

	public void setPostbox(String postbox) {
		this.postbox = postbox;
	}

	public String getProductinf() {
		return productinf;
	}

	public void setProductinf(String productinf) {
		this.productinf = productinf;
	}
	
	public int getCount()
	{
		String sql="select count(id)from seller";
		ResultSet rs=mysql.query(sql);
		try {
			if(rs.next())
			{			
				return rs.getInt(1);
			}
			return 0;
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			Logger.getLogger("travel").warning(e.getMessage());
			e.printStackTrace();
			return 0;
		}
	}
	
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
			Seller test=new Seller("电脑1","111");
			if(test.verify())
				System.out.println(test.getRealname());
		}
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	public String getRolename() {
		return rolename;
	}
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

}
