package mo;

import java.util.Iterator;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.logging.Logger;

import db.Mysql;

public class Ticket implements Sqlable{
	
	private Mysql mysql;
	
	private int id;
	private String name;
	private String tip;
	private int price;
	private String image;
	private String content;
	private String label;
	private int city;
	private int seller;
	private String cityname;
	private String sellername;
	
	public Ticket()
	{
		mysql=Mysql.getInstance();
	}
	public Ticket(int id)
	{
		this();
		this.setId(id);
	}
	public Ticket(String name,String tip,int price,String image,String content,String label,int city,int seller)
	{
		this();
		this.name=name;
		this.tip=tip;
		this.price=price;
		this.image=image;
		this.content=content;
		this.label=label;
		this.city=city;
		this.seller=seller;
	}
	public Ticket(int id,String name,String tip,int price,String image,String content,String label,int city,int seller)
	{
		
		this(name,tip,price,image,content,label,city,seller);
		this.setId(id);
	}
	@Override
	public boolean insert() {
		// TODO Auto-generated method stub
		if(name==null||tip==null||price==0||image==null||content==null||label==null||city==0||seller==0)
			return false;
		String sql="INSERT INTO ticket(name,tip,price,image,content,label,city,seller) values('"+name+"','"+tip+"',"+price+",'"+image+"','"+content+"','"+label+"',"+city+","+seller+")";
		return mysql.execute(sql);
	}

	@Override
	public int update() {
		// TODO Auto-generated method stub
		if(id==0)
			return -1;
		  String sql="UPDATE ticket SET name='"+name+"',tip='"+tip+"',price="+price+",image='"+image+"',content='"+content+"',label='"+label+"',city="+city+",seller="+seller+" where id="+id;
		  return mysql.update(sql);
	}

	@Override
	public boolean delete() {
		// TODO Auto-generated method stub
		if(id==0)
			return false;
		return mysql.delete("ticket", id);
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		if(id<=0)
			return false;
		return mysql.delete("ticket", id);
	}

	@Override
	public boolean truncate() {
		// TODO Auto-generated method stub
		String sql="TRUNCATE table ticket";
		return mysql.equals(sql);
	}

	@Override
	public Iterator<Ticket> selectAll() {
		// TODO Auto-generated method stub
		String sql="select a.id,a.name,a.tip,a.price,a.image,a.content,a.label,a.city,a.seller,b.name,c.name from ticket as a,city as b,seller as c where a.city=b.id and a.seller=c.id";
		ResultSet rs=mysql.query(sql);
		LinkedList<Ticket> list=new LinkedList<Ticket>();	
		try {
			while(rs.next())
			{
				Ticket ticket=new Ticket();
				ticket.setId(rs.getInt(1));
				ticket.setName(rs.getString(2));
				ticket.setTip(rs.getString(3));
				ticket.setPrice(rs.getInt(4));
				ticket.setImage(rs.getString(5));
				ticket.setContent(rs.getString(6));
				ticket.setLabel(rs.getString(7));
				ticket.setCity(rs.getInt(8));
				ticket.setSeller(rs.getInt(9));
				ticket.setCityname(rs.getString(10));
				ticket.setSellername(rs.getString(11));
				
				
				list.add(ticket);
			}
			return list.iterator();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			Logger.getLogger("ticket").warning(e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
	public Iterator<Ticket> selectAll(int start,int size) {
		// TODO Auto-generated method stub
		String sql="select a.id,a.name,a.tip,a.price,a.image,a.content,a.label,a.city,a.seller,b.name,c.name from ticket as a,city as b,seller as c where a.city=b.id and a.seller=c.id limit "+start+","+size;
		ResultSet rs=mysql.query(sql);
		LinkedList<Ticket> list=new LinkedList<Ticket>();	
		try {
			while(rs.next())
			{
				Ticket ticket=new Ticket();
				ticket.setId(rs.getInt(1));
				ticket.setName(rs.getString(2));
				ticket.setTip(rs.getString(3));
				ticket.setPrice(rs.getInt(4));
				ticket.setImage(rs.getString(5));
				ticket.setContent(rs.getString(6));
				ticket.setLabel(rs.getString(7));
				ticket.setCity(rs.getInt(8));
				ticket.setSeller(rs.getInt(9));
				ticket.setCityname(rs.getString(10));
				ticket.setSellername(rs.getString(11));
				
				list.add(ticket);
			}
			return list.iterator();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			Logger.getLogger("ticket").warning(e.getMessage());
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Ticket selectedId(int id) {
		// TODO Auto-generated method stub
		String sql="select a.id,a.name,a.tip,a.price,a.image,a.content,a.label,a.city,a.seller,b.name,c.name from ticket as a,city as b,seller as c where a.city=b.id and a.seller=c.id and a.id="+id;
		ResultSet rs=mysql.query(sql);
		try {
			if(rs.next())
			{
				Ticket ticket=new Ticket();
				ticket.setId(rs.getInt(1));
				ticket.setName(rs.getString(2));
				ticket.setTip(rs.getString(3));
				ticket.setPrice(rs.getInt(4));
				ticket.setImage(rs.getString(5));
				ticket.setContent(rs.getString(6));
				ticket.setLabel(rs.getString(7));
				ticket.setCity(rs.getInt(8));
				ticket.setSeller(rs.getInt(9));
				ticket.setCityname(rs.getString(10));
				ticket.setSellername(rs.getString(11));
				
				return ticket;
			}
			return null;
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			Logger.getLogger("ticket").warning(e.getMessage());
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Iterator<Ticket> selectSql(String where) {
		// TODO Auto-generated method stub
		String sql="select id,name,tip,price,image,content,label,city,seller from ticket where id where "+where;
		ResultSet rs=mysql.query(sql);
		LinkedList<Ticket> list=new LinkedList<Ticket>();	
		try {
			while(rs.next())
			{
				Ticket ticket=new Ticket();
				ticket.setId(rs.getInt(1));
				ticket.setName(rs.getString(2));
				ticket.setTip(rs.getString(3));
				ticket.setPrice(rs.getInt(4));
				ticket.setImage(rs.getString(5));
				ticket.setContent(rs.getString(6));
				ticket.setLabel(rs.getString(7));
				ticket.setCity(rs.getInt(8));
				ticket.setSeller(rs.getInt(9));
				ticket.setCityname(rs.getString(10));
				ticket.setSellername(rs.getString(11));
				
				list.add(ticket);
			}
			return list.iterator();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			Logger.getLogger("ticket").warning(e.getMessage());
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

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public int getCity() {
		return city;
	}

	public void setCity(int city) {
		this.city = city;
	}

	public int getSeller() {
		return seller;
	}

	public void setSeller(int seller) {
		this.seller = seller;
	}
	public int getCount()
	{
		String sql="select count(id)from ticket";
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
			Ticket test=new Ticket(1,"111","222",2,"333","444","555",8,4);
		
			System.out.println(test.insert());
		}
		public String getCityname() {
			return cityname;
		}
		public void setCityname(String cityname) {
			this.cityname = cityname;
		}
		public String getSellername() {
			return sellername;
		}
		public void setSellername(String sellername) {
			this.sellername = sellername;
		}

}
