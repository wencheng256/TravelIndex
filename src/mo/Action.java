package mo;

import java.util.Iterator;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.logging.Logger;

import db.Mysql;

public class Action implements Sqlable{
	
	private Mysql mysql;
	
	private int id;
	private String action_name;
	private String link;
	private int enable;
	private int parent;
	private int is_dir;
	
	public Action()
	{
		mysql=Mysql.getInstance();
	}
	
	public Action(String name,String link,int enable,int parent,int is_dir)
	{
		this();
		this.action_name=name;
		this.link=link;
		this.enable=enable;
		this.parent=parent;
		this.is_dir=is_dir;
	}
	
	public Action(int id,String name,String link,int enable,int parent,int is_dir)
	{
		this();
		this.action_name=name;
		this.link=link;
		this.enable=enable;
		this.id=id;
		this.parent=parent;
		this.is_dir=is_dir;
	}

	@Override
	public boolean insert() {
		// TODO Auto-generated method stub
		if(action_name==null||link==null||enable==0)
			return false;
		String sql="INSERT INTO action (action_name,link,enable,parent,is_dir) values('"+action_name+"','"+link+"',"+enable+","+parent+","+is_dir+")";
		return mysql.execute(sql);
	}

	@Override
	public int update() {
		// TODO Auto-generated method stub
		if(id==0)
			return -1;
		String sql="UPDATE action SET action_name='"+action_name+"',link='"+link+"',enable="+enable+",parent="+parent+",is_dir="+is_dir+" where id="+id;
		return mysql.update(sql);
	}

	@Override
	public boolean delete() {
		// TODO Auto-generated method stub
		if(id<=0)
			return false;
		return mysql.delete("action", id);
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		if(id<=0)
			return false;
		return mysql.delete("action", id);
	}

	@Override
	public boolean truncate() {
		// TODO Auto-generated method stub
		String sql="TRUNCATE table action";
		return mysql.equals(sql);
	}

	@Override
	public Iterator<Action> selectAll() {
		// TODO Auto-generated method stub
		String sql="select id,action_name,link,enable,parent,is_dir from action";
		ResultSet rs=mysql.query(sql);
		LinkedList<Action> list=new LinkedList<Action>();	
		try {
			while(rs.next())
			{
				Action action=new Action();
				action.setId(rs.getInt(1));
				action.setAction_name(rs.getString(2));
				action.setLink(rs.getString(3));
				action.setEnable(rs.getInt(4));
				action.setParent(rs.getInt(5));
				action.setIs_dir(rs.getInt(6));
				
				list.add(action);
			}
			return list.iterator();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			Logger.getLogger("travel").warning(e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
	
	public Iterator<Action> selectAll(int start ,int size) {
		// TODO Auto-generated method stub
		String sql="select id,action_name,link,enable,parent,is_dir from action limit "+start+","+size;
		ResultSet rs=mysql.query(sql);
		LinkedList<Action> list=new LinkedList<Action>();	
		try {
			while(rs.next())
			{
				Action action=new Action();
				action.setId(rs.getInt(1));
				action.setAction_name(rs.getString(2));
				action.setLink(rs.getString(3));
				action.setEnable(rs.getInt(4));
				action.setParent(rs.getInt(5));
				action.setIs_dir(rs.getInt(6));
				
				list.add(action);
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
	public Action selectedId(int id) {
		// TODO Auto-generated method stub
		String sql="select id,action_name,link,enable,parent,is_dir from action where id="+id;
		ResultSet rs=mysql.query(sql);
		try {
			if(rs.next())
			{
				Action action=new Action();
				action.setId(rs.getInt(1));
				action.setAction_name(rs.getString(2));
				action.setLink(rs.getString(3));
				action.setEnable(rs.getInt(4));
				action.setParent(rs.getInt(5));
				action.setIs_dir(rs.getInt(6));
				
				return action;
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
	public Iterator<Action> selectSql(String where) {
		// TODO Auto-generated method stub
		String sql="select id,action_name,link,enable,parent,is_dir from action where "+where;
		ResultSet rs=mysql.query(sql);
		LinkedList<Action> list=new LinkedList<Action>();	
		try {
			while(rs.next())
			{
				Action action=new Action();
				action.setId(rs.getInt(1));
				action.setAction_name(rs.getString(2));
				action.setLink(rs.getString(3));
				action.setEnable(rs.getInt(4));
				action.setParent(rs.getInt(5));
				action.setIs_dir(rs.getInt(6));
				
				list.add(action);
			}
			return list.iterator();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			Logger.getLogger("travel").warning(e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
	
	
	public Iterator<Action> select_dir() {
		// TODO Auto-generated method stub
		String sql="select id,action_name,link,enable,parent,is_dir from action where is_dir=1";
		ResultSet rs=mysql.query(sql);
		LinkedList<Action> list=new LinkedList<Action>();	
		try {
			while(rs.next())
			{
				Action action=new Action();
				action.setId(rs.getInt(1));
				action.setAction_name(rs.getString(2));
				action.setLink(rs.getString(3));
				action.setEnable(rs.getInt(4));
				action.setParent(rs.getInt(5));
				action.setIs_dir(rs.getInt(6));
				
				list.add(action);
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

	public String getAction_name() {
		return action_name;
	}

	public void setAction_name(String action_name) {
		this.action_name = action_name;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public int getEnable() {
		return enable;
	}

	public void setEnable(int enable) {
		this.enable = enable;
	}

	public Mysql getMysql() {
		return mysql;
	}

	public void setMysql(Mysql mysql) {
		this.mysql = mysql;
	}
	
	public int getCount()
	{
		String sql="select count(id) from action";
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
			Action test1=new Action(3,"11","11",2,1,1);
			//System.out.println(test1.selectAll().next().getName());
			System.out.println(test1.insert());
		}

	public int getParent() {
		return parent;
	}

	public void setParent(int parent) {
		this.parent = parent;
	}

	public int getIs_dir() {
		return is_dir;
	}

	public void setIs_dir(int is_dir) {
		this.is_dir = is_dir;
	}
	

}

