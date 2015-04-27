package mo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.logging.Logger;

import db.Mysql;

public class role_action implements Sqlable{
	
	private Mysql mysql;
	private int id;
	private int role;
	private int action;
	private int enable;
	private String rolename;
	private String actionname;
	
	public role_action()
	{
		mysql=Mysql.getInstance();
	}
	public role_action(int role,int action,int enable)
	{
		this();
		this.role=role;
		this.action=action;
		this.enable=enable;
		
	}
	public role_action(int id,int role,int action,int enable)
	{
		this();
		this.id=id;
		this.role=role;
		this.action=action;
		this.enable=enable;
		
	}
	

	@Override
	public boolean insert() {
		// TODO Auto-generated method stub
		if(role==0||action==0||enable==0)
			return false;
		String sql="INSERT INTO role_action (role,action,enable) values("+role+","+action+","+enable+")";
		return mysql.execute(sql);
	}

	@Override
	public int update() {
		// TODO Auto-generated method stub
		if(id==0)
			return -1;
		  String sql="UPDATE role_action SET role="+role+",action="+action+",enable="+enable+" where id="+id;
		  return mysql.update(sql);
	}

	@Override
	public boolean delete() {
		// TODO Auto-generated method stub
		if(id==0)
			return false;
		return mysql.delete("role_action", id);
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		if(id==0)
			return false;
		return mysql.delete("role_action", id);
	}

	@Override
	public boolean truncate() {
		// TODO Auto-generated method stub
		String sql="TRUNCATE table role_action";
		return mysql.equals(sql);
	}

	@Override
	public Iterator<role_action> selectAll() {
		// TODO Auto-generated method stub
		String sql="select a.id,a.role,a.action,a.enable,b.name,c.action_name from role_action as a,role as b,action as c where a.role=b.id and a.action=c.id";
		ResultSet rs=mysql.query(sql);
		LinkedList<role_action> list=new LinkedList<role_action>();	
		try {
			while(rs.next())
			{
				role_action ra = new role_action();
				ra.setId(rs.getInt(1));
				ra.setRole(rs.getInt(2));
				ra.setAction(rs.getInt(3));
				ra.setEnable(rs.getInt(4));
				ra.setRolename(rs.getString(5));
				ra.setActionname(rs.getString(6));
				
				list.add(ra);
			}
			return list.iterator();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			Logger.getLogger("travel").warning(e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
	public Iterator<role_action> selectAll(int start,int size) {
		// TODO Auto-generated method stub
		String sql="select a.id,a.role,a.action,a.enable,b.name,c.action_name from role_action as a,role as b,action as c where a.role=b.id and a.action=c.id limit "+start+","+size;
		ResultSet rs=mysql.query(sql);
		LinkedList<role_action> list=new LinkedList<role_action>();	
		try {
			while(rs.next())
			{
				role_action ra = new role_action();
				ra.setId(rs.getInt(1));
				ra.setRole(rs.getInt(2));
				ra.setAction(rs.getInt(3));
				ra.setEnable(rs.getInt(4));
				ra.setRolename(rs.getString(5));
				ra.setActionname(rs.getString(6));
				
				list.add(ra);
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
	public role_action selectedId(int id) {
		// TODO Auto-generated method stub
		String sql="select a.id,a.role,a.action,a.enable,b.name,c.action_name from role_action as a,role as b,action as c where a.role=b.id and a.action=c.id and a.id="+id;
		ResultSet rs=mysql.query(sql);
		try {
			if(rs.next())
			{
				role_action ra = new role_action();
				ra.setId(rs.getInt(1));
				ra.setRole(rs.getInt(2));
				ra.setAction(rs.getInt(3));
				ra.setEnable(rs.getInt(4));
				ra.setRolename(rs.getString(5));
				ra.setActionname(rs.getString(6));
				
				return ra;
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
	public Iterator<role_action > selectSql(String where) {
		// TODO Auto-generated method stub
		String sql="select a.id,a.role,a.action,a.enable,b.name,c.action_name from role_action as a,role as b,action as c where a.role=b.id and a.action=c.id and "+where;
		ResultSet rs=mysql.query(sql);
		LinkedList<role_action> list=new LinkedList<role_action>();	
		try {
			while(rs.next())
			{
				role_action ra = new role_action();
				ra.setId(rs.getInt(1));
				ra.setRole(rs.getInt(2));
				ra.setAction(rs.getInt(3));
				ra.setEnable(rs.getInt(4));
				ra.setRolename(rs.getString(5));
				ra.setActionname(rs.getString(6));
				
				list.add(ra);
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

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public int getAction() {
		return action;
	}

	public void setAction(int action) {
		this.action = action;
	}

	public int getEnable() {
		return enable;
	}

	public void setEnable(int enable) {
		this.enable = enable;
	}
	
	public int getCount()
	{
		String sql="select count(id)from role_action";
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
	public String getRolename() {
		return rolename;
	}
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
	public String getActionname() {
		return actionname;
	}
	public void setActionname(String actionname) {
		this.actionname = actionname;
	}

}
