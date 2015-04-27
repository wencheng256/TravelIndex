package mo;

import java.util.Iterator;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.logging.Logger;

import db.Mysql;

public class Admin implements Sqlable{
	
	private Mysql mysql;
	
	private int id;
	private String name;
	private String passwords;
	
	public Admin(){
		
		mysql=Mysql.getInstance();
		
	}
	public Admin(String name ,String passwords){
		
		this();
		this.name=name;
		this.passwords=passwords;
		
	}
	public Admin(int id,String name ,String passwords){
		
		this();
		this.name=name;
		this.passwords=passwords;
		this.id=id;
		
	}

	

	@Override
	public boolean insert() {
		// TODO Auto-generated method stub
		if(name==null||passwords==null)
			return false;
		String sql="INSERT INTO admin (name,passwords) values('"+name+"','"+passwords+"')";
		return mysql.execute(sql);
	}

	@Override
	public int update() {
		// TODO Auto-generated method stub
		if(id==0)
			return -1;
		String sql="UPDATE admin SET name='"+name+"',passwords='"+passwords+"' where id="+id;
		return mysql.update(sql);
	}

	@Override
	public boolean delete() {
		// TODO Auto-generated method stub
		if(id<=0)
			return false;
		return mysql.delete("admin", id);
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		if(id<=0)
			return false;
		return mysql.delete("admin", id);
	}

	@Override
	public boolean truncate() {
		// TODO Auto-generated method stub
		String sql="TRUNCATE table admin";
		return mysql.equals(sql);
	}

	@Override
	public Iterator<Admin> selectAll() {
		// TODO Auto-generated method stub
		String sql="select id,name,passwords from admin";
		ResultSet rs=mysql.query(sql);
		LinkedList<Admin> list=new LinkedList<Admin>();	
		try {
			while(rs.next())
			{
				Admin admin=new Admin();
				admin.setId(rs.getInt(1));
				admin.setName(rs.getString(2));
				admin.setPasswords(rs.getString(3));
				
				
				list.add(admin);
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
	public Sqlable selectedId(int id) {
		// TODO Auto-generated method stub
		String sql="select id,name,passwords from admin where id="+id;
		ResultSet rs=mysql.query(sql);
		try {
			if(rs.next())
			{
				Admin admin=new Admin();
				admin.setId(rs.getInt(1));
				admin.setName(rs.getString(2));
				admin.setPasswords(rs.getString(3));
				
				return admin;
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
	public Iterator<Admin> selectSql(String where) {
		// TODO Auto-generated method stub
		String sql="select id,name,passwords from admin where "+where;
		ResultSet rs=mysql.query(sql);
		LinkedList<Admin> list=new LinkedList<Admin>();	
		try {
			while(rs.next())
			{
				Admin admin=new Admin();
				admin.setId(rs.getInt(1));
				admin.setName(rs.getString(2));
				admin.setPasswords(rs.getString(3));
				
				list.add(admin);
			}
			return list.iterator();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			Logger.getLogger("travel").warning(e.getMessage());
			e.printStackTrace();
			return null;
		}
	}

	public Mysql getMysql() {
		return mysql;
	}

	public void setMysql(Mysql mysql) {
		this.mysql = mysql;
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

	public String getPasswords() {
		return passwords;
	}

	public void setPasswords(String passwords) {
		this.passwords = passwords;
	}

}
