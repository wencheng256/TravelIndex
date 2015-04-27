package mo;

import java.util.Iterator;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.logging.Logger;

import db.Mysql;

public class Comment implements Sqlable{
	
	private Mysql mysql;
	
	private int id;
	private String name;
	private String content;
	private int user;
	private int travel;
	private String username;
	private String travelname;

	public Comment()
	{
		mysql=Mysql.getInstance();
	}
	public Comment(int id)
	{
		this();
		this.id=id;
	}
	public Comment(String name,String content,int user,int travel)
	{
		this();
		this.name=name;
		this.content=content;
		this.user=user;
		this.travel=travel;
	}
	public Comment(int id,String name,String content,int user,int travel)
	{
		this();
		this.id=id;
		this.name=name;
		this.content=content;
		this.user=user;
		this.travel=travel;
	}
	@Override
	public boolean insert() {
		// TODO Auto-generated method stub
		if(name==null||content==null||user==0||travel==0)
			return false;
		String sql="INSERT INTO comment(name,content,user,travel) values('"+name+"','"+content+"',"+user+","+travel+")";
		return mysql.execute(sql);
	
	}

	@Override
	public int update() {
		// TODO Auto-generated method stub
		if(id==0)
			return -1;
		  String sql="UPDATE comment SET name='"+name+"',content='"+content+"',user="+user+",travel="+travel+" where id="+id;
		  return mysql.update(sql);
	}

	@Override
	public boolean delete() {
		// TODO Auto-generated method stub
		if(id==0)
			return false;
		return mysql.delete("comment", id);
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		if(id<=0)
			return false;
		return mysql.delete("comment", id);
	}

	@Override
	public boolean truncate() {
		// TODO Auto-generated method stub
		String sql="TRUNCATE table comment";
		return mysql.equals(sql);
	}

	@Override
	public Iterator<Comment> selectAll() {
		// TODO Auto-generated method stub
		String sql="select a.id,a.name,a.content,a.user,a.travel,b.name,c.name from comment as a,user as b,travel as c where a.user=b.id and a.travel=c.id";
		ResultSet rs=mysql.query(sql);
		LinkedList<Comment> list=new LinkedList<Comment>();	
		try {
			while(rs.next())
			{
				Comment comment = new Comment();
				comment.setId(rs.getInt(1));
				comment.setName(rs.getString(2));
				comment.setContent(rs.getString(3));
				comment.setUser(rs.getInt(4));
				comment.setTravel(rs.getInt(5));
				comment.setUsername(rs.getString(6));
				comment.setTravelname(rs.getString(7));
				
				list.add(comment);
				
				
			}
			return list.iterator();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			Logger.getLogger("comment").warning(e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
	public Iterator<Comment> selectAll(int start,int size) {
		// TODO Auto-generated method stub
		String sql="select a.id,a.name,a.content,a.user,a.travel,b.name,c.name from comment as a,user as b,travel as c where a.user=b.id and a.travel=c.id limit "+start+","+size;
		ResultSet rs=mysql.query(sql);
		LinkedList<Comment> list=new LinkedList<Comment>();	
		try {
			while(rs.next())
			{
				Comment comment = new Comment();
				comment.setId(rs.getInt(1));
				comment.setName(rs.getString(2));
				comment.setContent(rs.getString(3));
				comment.setUser(rs.getInt(4));
				comment.setTravel(rs.getInt(5));
				comment.setUsername(rs.getString(6));
				comment.setTravelname(rs.getString(7));
				
				list.add(comment);
				
				
			}
			return list.iterator();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			Logger.getLogger("comment").warning(e.getMessage());
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Comment selectedId(int id) {
		// TODO Auto-generated method stub
		String sql="select a.id,a.name,a.content,a.user,a.travel,b.name,c.name from comment as a,user as b,travel as c where a.user=b.id and a.travel=c.id and a.id="+id;
		ResultSet rs=mysql.query(sql);
		try {
			if(rs.next())
			{
				Comment comment = new Comment();
				comment.setId(rs.getInt(1));
				comment.setName(rs.getString(2));
				comment.setContent(rs.getString(3));
				comment.setUser(rs.getInt(4));
				comment.setTravel(rs.getInt(5));
				comment.setUsername(rs.getString(6));
				comment.setTravelname(rs.getString(7));
				return comment;
			}
			return null;
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			Logger.getLogger("comment").warning(e.getMessage());
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Iterator<Comment> selectSql(String where) {
		// TODO Auto-generated method stub
		String sql="select a.id,a.name,a.content,a.user,a.travel,b.name,c.name from comment as a,user as b,travel as c where a.user=b.id and a.travel=c.id and "+where;
		ResultSet rs=mysql.query(sql);
		LinkedList<Comment> list=new LinkedList<Comment>();	
		try {
			while(rs.next())
			{
				Comment comment = new Comment();
				comment.setId(rs.getInt(1));
				comment.setName(rs.getString(2));
				comment.setContent(rs.getString(3));
				comment.setUser(rs.getInt(4));
				comment.setTravel(rs.getInt(5));
				comment.setUsername(rs.getString(6));
				comment.setTravelname(rs.getString(7));
				
				list.add(comment);
			}
			return list.iterator();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			Logger.getLogger("comment").warning(e.getMessage());
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getUser() {
		return user;
	}

	public void setUser(int user) {
		this.user = user;
	}

	public int getTravel() {
		return travel;
	}

	public void setTravel(int travel) {
		this.travel = travel;
	}
	public int getCount()
	{
		String sql="select count(id)from comment";
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
			Comment test=new Comment(1,"主页轮播图3","1122", 1, 6);
			//System.out.println(test.selectAll().next().getName());
			System.out.println(test.insert());
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
