package mo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.logging.Logger;

import db.Mysql;

public class Artical implements Sqlable{
	
	private Mysql mysql;
	
	private int id;
	private String name;
	private String content;
	private String date;
	private int users;
	private int travels;
	private String username;
	private String travelname;
	
	
	public Artical()
	{
		mysql=Mysql.getInstance();
	}
	
	public Artical(int id)
	{
		
		this();
		this.id=id;
	}
	public Artical(String name,String content,String date,int users,int travels)
	{
		this();
		this.name=name;
		this.content=content;
		this.date=date;
		this.users=users;
		this.travels=travels;
	}
	public Artical(int id,String name,String content,String date,int users,int travel)
	{
		this();
		this.id=id;
		this.name=name;
		this.content=content;
		this.date=date;
		this.users=users;
		this.travels=travel;
	}
	

	@Override
	public boolean insert() {
		// TODO 自动生成的方法存根
		if(name==null||content==null||date==null||users==0||travels==0)
			return false;
		String sql="INSERT INTO artical (name,content,date,users,travels) values('"+name+"','"+content+"',now(),"+users+","+travels+")";
		return mysql.execute(sql);
	}

	@Override
	public int update() {
		// TODO 自动生成的方法存根
		if(id==0)
			return -1;
		String sql="UPDATE artical SET name='"+name+"',content='"+content+"',date='"+date+"',users="+users+",travels="+travels+" where id="+id;
		return mysql.update(sql);
	}

	@Override
	public boolean delete() {
		// TODO 自动生成的方法存根
		if(id<=0)
			return false;
		return mysql.delete("artical", id);
	}

	@Override
	public boolean delete(int id) {
		// TODO 自动生成的方法存根
		if(id<=0)
			return false;
		return mysql.delete("artical", id);
	}

	@Override
	public boolean truncate() {
		// TODO 自动生成的方法存根
		String sql="TRUNCATE table artical";
		return mysql.equals(sql);
	}

	@Override
	public Iterator<Artical> selectAll() {
		// TODO 自动生成的方法存根
		String sql="select a.id,a.name,a.content,a.date,a.users,a.travels,b.name,c.name from artical as a,user as b,travel as c where a.users=b.id and a.travels=c.id";
		ResultSet rs=mysql.query(sql);
		LinkedList<Artical> list=new LinkedList<Artical>();	
		try {
			while(rs.next())
			{
				Artical art=new Artical();
				art.setId(rs.getInt(1));
				art.setName(rs.getString(2));
				art.setContent(rs.getString(3));
				art.setDate(rs.getString(4));
				art.setUsers(rs.getInt(5));
				art.setTravels(rs.getInt(6));
				art.setUsername(rs.getString(7));
				art.setTravelname(rs.getString(8));
				
				list.add(art);
			}
			return list.iterator();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			Logger.getLogger("travel").warning(e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
	public Iterator<Artical> selectAll(int start,int size) {
		// TODO 自动生成的方法存根
		String sql="select a.id,a.name,a.content,a.date,a.users,a.travels,b.name,c.name from artical as a,user as b,travel as c where a.users=b.id and a.travels=c.id limit "+start+","+size;
		ResultSet rs=mysql.query(sql);
		LinkedList<Artical> list=new LinkedList<Artical>();	
		try {
			while(rs.next())
			{
				Artical art=new Artical();
				art.setId(rs.getInt(1));
				art.setName(rs.getString(2));
				art.setContent(rs.getString(3));
				art.setDate(rs.getString(4));
				art.setUsers(rs.getInt(5));
				art.setTravels(rs.getInt(6));
				art.setUsername(rs.getString(7));
				art.setTravelname(rs.getString(8));
				
				list.add(art);
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
	public Artical selectedId(int id) {
		// TODO 自动生成的方法存根
		String sql="select a.id,a.name,a.content,a.date,a.users,a.travels,b.name,c.name from artical as a,user as b,travel as c where a.users=b.id and a.travels=c.id and a.id="+id;
		ResultSet rs=mysql.query(sql);
		try {
			if(rs.next())
			{
				Artical art=new Artical();
				art.setId(rs.getInt(1));
				art.setName(rs.getString(2));
				art.setContent(rs.getString(3));
				art.setDate(rs.getString(4));
				art.setUsers(rs.getInt(5));
				art.setTravels(rs.getInt(6));
				art.setUsername(rs.getString(7));
				art.setTravelname(rs.getString(8));
				
				return art;
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
	public Iterator<Artical> selectSql(String where) {
		// TODO 自动生成的方法存根
		String sql="select a.id,a.name,a.content,a.date,a.users,a.travels,b.name,c.name from artical as a,user as b,travel as c where a.users=b.id and a.travels=c.id and "+where;
		ResultSet rs=mysql.query(sql);
		LinkedList<Artical> list=new LinkedList<Artical>();	
		try {
			while(rs.next())
			{
				Artical art=new Artical();
				art.setId(rs.getInt(1));
				art.setName(rs.getString(2));
				art.setContent(rs.getString(3));
				art.setDate(rs.getString(4));
				art.setUsers(rs.getInt(5));
				art.setTravels(rs.getInt(6));
				art.setUsername(rs.getString(7));
				art.setTravelname(rs.getString(8));
				
				list.add(art);
			}
			return list.iterator();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			Logger.getLogger("travel").warning(e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
	
	public int getCount()
	{
		String sql="select count(id)from artical";
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getUsers() {
		return users;
	}

	public void setUsers(int users) {
		this.users = users;
	}

	public int getTravels() {
		return travels;
	}

	public void setTravels(int travels) {
		this.travels = travels;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getTravelname() {
		return travelname;
	}

	public void setTravelname(String travelname) {
		this.travelname = travelname;
	}

}
