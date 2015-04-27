package mo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.logging.Logger;

import db.Mysql;

public class Province implements Sqlable {
	
	private Mysql mysql;
	private int id;
	private String name;
	private int location;
	private String locname;

	
	public Province()
	{
		mysql=Mysql.getInstance();
	}
	public Province(int id)
	{
		this();
		this.setId(id);
	}
	public Province(String name,int location)
	{
		this();
		this.name=name;
		this.location=location;
	}
	public Province(int id,String name,int location)
	{
		this(name,location);
		this.setId(id);
	}
	
	
	@Override
	public boolean insert() {
		// TODO 自动生成的方法存根
		if(name==null||location==0)
			return false;
		String sql="INSERT INTO province(name,location) values('"+name+"',"+location+")";
		return mysql.execute(sql);
	}

	@Override
	public int update() {
		// TODO 自动生成的方法存根
		if(id==0)
			return -1;
		  String sql="UPDATE province SET name='"+name+"',location="+location+" where id="+id;
		  return mysql.update(sql);
	}

	@Override
	public boolean delete() {
		// TODO 自动生成的方法存根
		if(id==0)
			return false;
		return mysql.delete("province", id);
	}

	@Override
	public boolean delete(int id) {
		// TODO 自动生成的方法存根
		if(id==0)
			return false;
		return mysql.delete("province", id);
	}

	@Override
	public boolean truncate() {
		// TODO 自动生成的方法存根
		return false;
	}

	
	//Getter and Setter
	public int getLocation() {
		return location;
	}

	public void setLocation(int location) {
		this.location = location;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public Iterator<Province> selectAll() {
		// TODO 自动生成的方法存根
		String sql="select a.id,a.name,a.location,b.name from province as a,location as b where b.id=a.location";
		ResultSet rs=mysql.query(sql);
		LinkedList<Province> list=new LinkedList<Province>();	
		try {
			while(rs.next())
			{
				Province province=new Province();
				province.setId(rs.getInt(1));
				province.setName(rs.getString(2));
				province.setLocation(rs.getInt(3));
				province.setLocname(rs.getString(4));
				
				list.add(province);
			}
			return list.iterator();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			Logger.getLogger("travel").warning(e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
	public Iterator<Province> selectAll(int start,int end) {
		// TODO 自动生成的方法存根
		String sql="select a.id,a.name,a.location,b.name from province as a,location as b where b.id=a.location limit "+start+","+end;
		ResultSet rs=mysql.query(sql);
		LinkedList<Province> list=new LinkedList<Province>();	
		try {
			while(rs.next())
			{
				Province province=new Province();
				province.setId(rs.getInt(1));
				province.setName(rs.getString(2));
				province.setLocation(rs.getInt(3));
				province.setLocname(rs.getString(4));
				
				list.add(province);
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
	public Province selectedId(int id) {
		// TODO 自动生成的方法存根
		String sql="select a.id,a.name,a.location,b.name from province as a,location as b where b.id=a.location and a.id="+id;
		//System.out.println(sql);
		ResultSet rs=mysql.query(sql);
		try {
			if(rs.next())
			{
				Province province=new Province();
				province.setId(rs.getInt(1));
				province.setName(rs.getString(2));
				province.setLocation(rs.getInt(3));
				province.setLocname(rs.getString(4));
				
				return province;
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
	public Iterator<Province> selectSql(String where) {
		// TODO 自动生成的方法存根
		String sql="select a.id,a.name,a.location,b.name from province as a,location as b where b.id=a.location and "+where;
		ResultSet rs=mysql.query(sql);
		LinkedList<Province> list=new LinkedList<Province>();	
		try {
			while(rs.next())
			{
				Province province=new Province();
				province.setId(rs.getInt(1));
				province.setName(rs.getString(2));
				province.setLocation(rs.getInt(3));
				province.setLocname(rs.getString(4));
				
				list.add(province);
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
		String sql="select count(id)from province";
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
	
	//单元测试
	public static void main(String[] args) {
	// TODO 自动生成的方法存根
		Province test1=new Province(3,"河北",1);
		//System.out.println(test1.selectSql("id=2").next().getName());
		System.out.println(test1.insert());
	}
	public String getLocname() {
		return locname;
	}
	public void setLocname(String locname) {
		this.locname = locname;
	}
}
