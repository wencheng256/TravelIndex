package mo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.logging.Logger;

import db.Mysql;

public class role implements Sqlable{
	
	private Mysql mysql;
	private int id;
	private String name;
	
	
	//构造函数
		public role()
		{
			mysql=Mysql.getInstance();
		}
		
		public role(String name,int judement)
		{
			this();
			this.name=name;
			
		}
		
		public role(int id,String name,int judement)
		{
			this();
			this.name=name;
			this.id=id;
			
		}
	
	@Override
	public boolean insert() {
		// TODO Auto-generated method stub
		if(name==null)
			return false;
		String sql="INSERT INTO role(name) values('"+name+"')";
		return mysql.execute(sql);
	}

	@Override
	public int update() {
		// TODO Auto-generated method stub
		if(id==0)
			return -1;
		String sql="UPDATE role SET name='"+name+"' where id="+id;
		return mysql.update(sql);
	}

	@Override
	public boolean delete() {
		// TODO Auto-generated method stub
		if(id==0)
			return false;
		return mysql.delete("role", id);
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		if(id<=0)
			return false;
		return mysql.delete("role", id);
	}

	@Override
	public boolean truncate() {
		// TODO Auto-generated method stub
		String sql="TRUNCATE table role";
		return mysql.equals(sql);
	}

	@Override
	public Iterator<role> selectAll() {
		// TODO Auto-generated method stub
		String sql="select id,name from role";
		ResultSet rs=mysql.query(sql);
		LinkedList<role> list=new LinkedList<role>();	
		try {
			while(rs.next())
			{
				role role = new role();
				role.setId(rs.getInt(1));
				role.setName(rs.getString(2));
				
				
				list.add(role);
			}
			return list.iterator();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			Logger.getLogger("travel").warning(e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
	public Iterator<role> selectAll(int start ,int size) {
		// TODO Auto-generated method stub
		String sql="select id,name from role limit "+start+","+size;
		ResultSet rs=mysql.query(sql);
		LinkedList<role> list=new LinkedList<role>();	
		try {
			while(rs.next())
			{
				role role = new role();
				role.setId(rs.getInt(1));
				role.setName(rs.getString(2));
				
				list.add(role);
			}
			return list.iterator();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			Logger.getLogger("travel").warning(e.getMessage());
			e.printStackTrace();
			return null;
		}
	}

	
	public void setName(String name) {
		// TODO Auto-generated method stub
		this.name=name;
	}
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	public void setId(int id) {
		// TODO Auto-generated method stub
		this.id=id;
		
	}
	public int getId() {
		// TODO Auto-generated method stub
		return id;
	}

	@Override
	public role selectedId(int id) {
		// TODO Auto-generated method stub
		String sql="select id,name from role where id="+id;
		ResultSet rs=mysql.query(sql);
		try {
			if(rs.next())
			{
				role role = new role();
				role.setId(rs.getInt(1));
				role.setName(rs.getString(2));
				
				
				return role;
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
	public Iterator<role> selectSql(String where) {
		// TODO Auto-generated method stub
		String sql="select id,name from role where "+where;
		ResultSet rs=mysql.query(sql);
		LinkedList<role> list=new LinkedList<role>();	
		try {
			while(rs.next())
			{
				role role = new role();
				role.setId(rs.getInt(1));
				role.setName(rs.getString(2));
				
				list.add(role);
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
		String sql="select count(id)from role";
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
			role test=new role(9,"卖家1",1);
			System.out.println(test.insert());
		}

	

}
