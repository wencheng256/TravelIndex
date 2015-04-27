package mo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.logging.Logger;

import db.Mysql;

public class Order implements Sqlable{
	
	private Mysql mysql;
	private int id;
	private String name;
	private int price;
	private int state;
	private int seller;
	private int travel;
	private int user;
	private String sellername;
	private String travelname;
	private String username;
	
	public Order()
	{
		mysql=Mysql.getInstance();
	}
	public Order(int id)
	{
		this();
		this.id=id;
	}
	public Order(String name,int price,int state,int seller,int travel,int user)
	{
		this();
		this.name=name;
		this.price=price;
		this.state=state;
		this.seller=seller;
		this.travel=travel;
		this.user=user;
	}
	public Order(int id,String name,int price,int state,int seller,int travel,int user)
	{
		this();
		this.id=id;
		this.name=name;
		this.price=price;
		this.state=state;
		this.seller=seller;
		this.travel=travel;
		this.user=user;
	}
	

	@Override
	public boolean insert() {
		// TODO Auto-generated method stub
		if(name==null||price==0||state==0||seller==0||travel==0||user==0)
			return false;
		String sql="INSERT INTO orderb(name,price,state,seller,travel,user) values('"+name+"',"+price+","+state+","+seller+","+travel+","+user+")";
		return mysql.execute(sql);
	}

	@Override
	public int update() {
		// TODO Auto-generated method stub
		if(id==0)
			return -1;
		  String sql="UPDATE orderb SET name='"+name+"',price="+price+",state="+state+",seller="+seller+",travel="+travel+",user="+user+" where id="+id;
		  return mysql.update(sql);
	}

	@Override
	public boolean delete() {
		// TODO Auto-generated method stub
		if(id==0)
			return false;
		return mysql.delete("orderb", id);
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		if(id==0)
			return false;
		return mysql.delete("orderb", id);
	}

	@Override
	public boolean truncate() {
		// TODO Auto-generated method stub
		String sql="TRUNCATE table orderb";
		return mysql.equals(sql);
	}

	@Override
	public Iterator<Order> selectAll() {
		
		// TODO Auto-generated method stub
		String sql="select a.id,a.name,a.price,a.state,a.seller,a.travel,a.user,b.name,c.name,d.name from orderb as a,seller as b,travel as c,user as d where a.seller=b.id and a.travel=c.id and a.user=d.id";
		ResultSet rs=mysql.query(sql);
		LinkedList<Order> list=new LinkedList<Order>();	
		try {
			while(rs.next())
			{
				Order order=new Order();
				order.setId(rs.getInt(1));
				order.setName(rs.getString(2));
				order.setPrice(rs.getInt(3));
				order.setState(rs.getInt(4));
				order.setSeller(rs.getInt(5));
				order.setTravel(rs.getInt(6));
				order.setUser(rs.getInt(7));
				order.setSellername(rs.getString(8));
				order.setTravelname(rs.getString(9));
				order.setUsername(rs.getString(10));
				
				list.add(order);
			}
			return list.iterator();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			Logger.getLogger("travel").warning(e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
	public Iterator<Order> selectAll(int start,int size) {
		// TODO Auto-generated method stub
		String sql="select a.id,a.name,a.price,a.state,a.seller,a.travel,a.user,b.name,c.name,d.name from orderb as a,seller as b,travel as c,user as d where a.seller=b.id and a.travel=c.id and a.user=d.id limit "+start+","+size;
		ResultSet rs=mysql.query(sql);
		LinkedList<Order> list=new LinkedList<Order>();	
		try {
			while(rs.next())
			{
				Order order=new Order();
				order.setId(rs.getInt(1));
				order.setName(rs.getString(2));
				order.setPrice(rs.getInt(3));
				order.setState(rs.getInt(4));
				order.setSeller(rs.getInt(5));
				order.setTravel(rs.getInt(6));
				order.setUser(rs.getInt(7));
				order.setSellername(rs.getString(8));
				order.setTravelname(rs.getString(9));
				order.setUsername(rs.getString(10));
				
				list.add(order);
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
	public Order selectedId(int id) {
		// TODO Auto-generated method stub
		String sql="select a.id,a.name,a.price,a.state,a.seller,a.travel,a.user,b.name,c.name,d.name from orderb as a,seller as b,travel as c,user as d where a.seller=b.id and a.travel=c.id and a.user=d.id and a.id="+id;
		ResultSet rs=mysql.query(sql);
		try {
			if(rs.next())
			{
				Order order=new Order();
				order.setId(rs.getInt(1));
				order.setName(rs.getString(2));
				order.setPrice(rs.getInt(3));
				order.setState(rs.getInt(4));
				order.setSeller(rs.getInt(5));
				order.setTravel(rs.getInt(6));
				order.setUser(rs.getInt(7));
				order.setSellername(rs.getString(8));
				order.setTravelname(rs.getString(9));
				order.setUsername(rs.getString(10));
				
				return order;
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
	public Iterator<Order> selectSql(String where) {
		// TODO Auto-generated method stub
		String sql="select a.id,a.name,a.price,a.state,a.seller,a.travel,a.user,b.name,c.name,d.name from orderb as a,seller as b,travel as c,user as d where a.seller=b.id and a.travel=c.id and a.user=d.id and "+where;
		ResultSet rs=mysql.query(sql);
		LinkedList<Order> list=new LinkedList<Order>();	
		try {
			while(rs.next())
			{
				Order order=new Order();
				order.setId(rs.getInt(1));
				order.setName(rs.getString(2));
				order.setPrice(rs.getInt(3));
				order.setState(rs.getInt(4));
				order.setSeller(rs.getInt(5));
				order.setTravel(rs.getInt(6));
				order.setUser(rs.getInt(7));
				order.setSellername(rs.getString(8));
				order.setTravelname(rs.getString(9));
				order.setUsername(rs.getString(10));
				
				list.add(order);
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
		String sql="select count(id)from orderb";
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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public int getSeller() {
		return seller;
	}

	public void setSeller(int seller) {
		this.seller = seller;
	}

	public int getTravel() {
		return travel;
	}

	public void setTravel(int travel) {
		this.travel = travel;
	}

	public int getUser() {
		return user;
	}

	public void setUser(int user) {
		this.user = user;
	}
	public String getSellername() {
		return sellername;
	}
	public void setSellername(String sellername) {
		this.sellername = sellername;
	}
	public String getTravelname() {
		return travelname;
	}
	public void setTravelname(String travelname) {
		this.travelname = travelname;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

}
