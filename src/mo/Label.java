package mo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.logging.Logger;

import db.Mysql;

public class Label implements Sqlable{
	
	private Mysql mysql;
	private int id;
	private String name;
	private int sort;
	private String sortname;
	
	public Label()
	{
		mysql=Mysql.getInstance();
	}
	
	public Label(int id)
	{
		this();
		this.id=id;
	}
	public Label(String name,int sort)
	{
		this();
		this.name=name;
		this.sort=sort;
	}
	public Label(int id,String name,int sort)
	{
		this(name,sort);
		this.id=id;
	}

	@Override
	public boolean insert() {
		// TODO Auto-generated method stub
		if(name==null||sort==0)
			return false;
		String sql="INSERT INTO label (name,sort) values('"+name+"',"+sort+")";
		return mysql.execute(sql);
	}

	@Override
	public int update() {
		// TODO Auto-generated method stub
		if(id==0)
			return -1;
		String sql="UPDATE label SET name='"+name+"',sort="+sort+" where id="+id;
		return mysql.update(sql);
	}

	@Override
	public boolean delete() {
		// TODO Auto-generated method stub
		if(id<=0)
			return false;
		return mysql.delete("label", id);
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		if(id<=0)
			return false;
		return mysql.delete("label", id);
	}

	@Override
	public boolean truncate() {
		// TODO Auto-generated method stub
		String sql="TRUNCATE table label";
		return mysql.equals(sql);
	}

	@Override
	public Iterator<Label> selectAll() {
		// TODO Auto-generated method stub
		String sql="select a.id,a.name,a.sort,b.name from label as a,sort as b where b.id=a.sort";
		ResultSet rs=mysql.query(sql);
		LinkedList<Label> list=new LinkedList<Label>();	
		try {
			while(rs.next())
			{
				Label lab=new Label();
				lab.setId(rs.getInt(1));
				lab.setName(rs.getString(2));
				lab.setSort(rs.getInt(3));
				lab.setSortname(rs.getString(4));
				
				list.add(lab);
			}
			return list.iterator();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			Logger.getLogger("travel").warning(e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
	public Iterator<Label> selectAll(int start, int size) {
		// TODO Auto-generated method stub
		String sql="select a.id,a.name,a.sort,b.name from label as a,sort as b where b.id=a.sort limit "+start+","+size;
		ResultSet rs=mysql.query(sql);
		LinkedList<Label> list=new LinkedList<Label>();	
		try {
			while(rs.next())
			{
				Label lab=new Label();
				lab.setId(rs.getInt(1));
				lab.setName(rs.getString(2));
				lab.setSort(rs.getInt(3));
				lab.setSortname(rs.getString(4));
				
				list.add(lab);
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
	public Label selectedId(int id) {
		// TODO Auto-generated method stub
		String sql="select a.id,a.name,a.sort,b.name from label as a,sort as b where b.id=a.sort and a.id="+id;
		ResultSet rs=mysql.query(sql);
		try {
			if(rs.next())
			{
				Label lab=new Label();
				lab.setId(rs.getInt(1));
				lab.setName(rs.getString(2));
				lab.setSort(rs.getInt(3));
				lab.setSortname(rs.getString(4));
				
				return lab;
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
	public Iterator<Label> selectSql(String where) {
		// TODO Auto-generated method stub
		String sql="select a.id,a.name,a.sort,b.name from label as a,sort as b where b.id=a.sort and "+where;
		ResultSet rs=mysql.query(sql);
		LinkedList<Label> list=new LinkedList<Label>();	
		try {
			while(rs.next())
			{
				Label lab=new Label();
				lab.setId(rs.getInt(1));
				lab.setName(rs.getString(2));
				lab.setSort(rs.getInt(3));
				lab.setSortname(rs.getString(4));
				
				list.add(lab);
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

	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}

	public Mysql getMysql() {
		return mysql;
	}

	public void setMysql(Mysql mysql) {
		this.mysql = mysql;
	}

	public String getSortname() {
		return sortname;
	}

	public void setSortname(String sortname) {
		this.sortname = sortname;
	}
	
	public int getCount()
	{
		String sql="select count(id)from label";
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

}
