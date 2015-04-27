<%@page language="java"  import="mo.*" contentType="text/html; charset=utf-8" %>
<%User user=(User)session.getAttribute("user"); %>
<%if(user==null) {%>
<div class="top_dl fl">欢迎进入游天下！&nbsp;&nbsp;&nbsp;&nbsp;<a href="login.html">登陆</a>&nbsp;|&nbsp;<a href="sign.html">注册</a></div>
 <%}else {%>
 <div class="top_dl fl"><%=user.getRealname() %>欢迎回来！</div>
 <%} %>
    <div class="top_right fr"><a href="">VIP会员</a>&nbsp;&nbsp;<a href="">我的订单</a>&nbsp;&nbsp;<div class="top_wx fr"><a href=""><span onmouseover="player(&#39;any&#39;);" onmouseout="clocer(&#39;any&#39;);" style="cursor:hand;"><img src="image/dot2.jpg"/>&nbsp;</span>关注我们</a>&nbsp;&nbsp;<a href="">我要发布</a>&nbsp;&nbsp;<a href="">我是商家</a><div class="divbox_t">
    <div id="any" class="more_dx" onmouseover="player(&#39;any&#39;);" onmouseout="clocer(&#39;any&#39;); " style="display: none; "><img src="image/ewm.jpg"></div>
    </div></div>
    </div>
    <div class="clear"></div>
      <div class="ad fl"><img src="image/ad.jpg" width="1203" height="72" /></div>
    <div class="clear"></div>
      <div class="logo fl"><img src="image/logo.jpg" width="172" height="110" /></div>
      <!--搜索-->
<div class="ss fl"><form id="form1" name="form1" action=""  method="get" style=" float:left;width:410px; height:36px;" onsubmit="return check_value()"><input name="keyword"  id="hkeyword" type="text" onblur="if(this.value==''){this.value='温泉'}" onfocus="if(this.value=='温泉'){this.value=''}" value="温泉" class="cebottom"><button type="submit" class="bott"></button></form></div>
<!--搜索-->
       <div class="gonglue fl"><a href=""><span class="juse">攻略</span></a></div>
       <div class="gonglue fl"><a href=""><span class="juse">地域物产</span></a></div>
       <div class="gonglue fl"><a href=""><span class="juse">品牌</span></a></div>
       <div class="tel fr"><img src="image/tel.jpg" width="280" height="37" /></div>
    <div class="clear"></div>
       <div class="main">
       <div class="menu_left fl">威海&nbsp;<span class="font14"><a href="city.html"><span class="white">[切换城市]</span></a></span></div>
       <!--menu开始-->
        <div class="menu_right fl">
          <DIV class="nav">
<DIV class="menu_h">
<UL id="menu_h_ul">                                        
  <LI id="m_1" class="m_li_a menu_hover" onMouseOver="liMouseOver(1);" onMouseOut="liMouseOut()"><A 
  href="index.html">首页</A></LI>
  <LI id="m_2" class="m_li" onMouseOver="liMouseOver(2);" onMouseOut="liMouseOut()"><A 
  href="zby.html">周边游</A></LI>
  <LI id="m_3" class="m_li" onMouseOver="liMouseOver(3);" onMouseOut="liMouseOut()"><A 
  href="cjy.html">休闲汇</A> </LI>
  <LI id="m_4" class="m_li" onMouseOver="liMouseOver(4);" onMouseOut="liMouseOut()"><A 
  href="list.html">门  票</A></LI>
  <LI id="m_5" class="m_li" onMouseOver="liMouseOver(5);" onMouseOut="liMouseOut()"><A 
  href="hot.html">当季热门</A> </LI>
  <LI id="m_6" class="m_li" onMouseOver="liMouseOver(6);" onMouseOut="liMouseOut()"><A 
  href="hdzj.html">活动召集</A></LI>
  <LI id="m_7" class="m_li" onMouseOver="liMouseOver(7);" onMouseOut="liMouseOut()"><A 
  href="text.html">租 车</A> </LI>
  <LI id="m_8" class="m_li" onMouseOver="liMouseOver(8);" onMouseOut="liMouseOut()"><A 
  href="jifen.html">积分商城</A> </LI>
  <LI id="m_9" class="m_li" onMouseOver="liMouseOver(9);" onMouseOut="liMouseOut()"><A 
  href="dz.html">定制中心</A> </LI>
  <LI id="m_10" class="m_li" onMouseOver="liMouseOver(10);" onMouseOut="liMouseOut()"><A 
  href="brand.html">品牌商家</A> </LI>
  </UL></DIV>
<DIV class="menu_c">
<UL>
  <LI id="c_1" class="c_li" onMouseOver="setLiMouseOver()" onMouseOut="liMouseOut()">
   <UL class="menu_list">
    <LI><A href="">攻略</A></LI>
    <LI><A href="">地域物产</A></LI> 
    <LI><A href="">品牌</A></LI></UL>
  </LI>
  <LI id="c_2" class="c_li" onMouseOver="setLiMouseOver()" onMouseOut="liMouseOut()">
  <UL class="menu_list">
    <LI><A href=""><span class="juse">特卖</span></A></LI>
    <LI><A href="">跟团</A></LI>
    <LI><A href="">热门地</A></LI>
    <LI><A href="">时间</A> </LI>
    <LI><A href="">交通工具</A> </LI>
    <LI><A href=""><span class="juse">定制</span></A> </LI>
    <LI><A href="">喜好</A></LI></UL></LI>
  <LI id="c_3" class="c_li" onMouseOver="setLiMouseOver()" onMouseOut="liMouseOut()">
  <UL class="menu_list">
    <LI><A href="">周末</A></LI>
    <LI><A href="">平日</A></LI>
    <LI><A href="">节日小假</A></LI>
    <LI><A href="">节日长假</A> </LI>
    <LI><A href="">年假</A> </LI>
    <LI><A href="">婚假</A> </LI></UL></LI>
  <LI id="c_4" class="c_li" onMouseOver="setLiMouseOver()" onMouseOut="liMouseOut()">
  <UL class="menu_list">
    <LI><A href="">A级景区</A></LI>
    <LI><A href="">游乐场</A></LI>
    <LI><A href="">演出票</A></LI>
    <LI><A href="">节日party</A> </LI>
    <LI><A href="">农业园</A> </LI>
    <LI><A href="">工业园</A> </LI>
    <LI><A href="">会展票</A> </LI></UL></LI>
  <LI id="c_5" class="c_li" onMouseOver="setLiMouseOver()" onmouseout="liMouseOut()">
  <UL class="menu_list">
    <LI><A href="">温泉</A></LI>
    <LI><A href="">滑雪</A></LI>
    <LI><A href="">登山</A></LI>
    <LI><A href="">采摘</A> </LI>
    <LI><A href="">游览</A> </LI>
    <LI><A href="">度假</A> </LI>
    <LI><A href="">当季物产</A> </LI></UL></LI>
  <LI id="c_6" class="c_li" onMouseOver="setLiMouseOver()" onMouseOut="liMouseOut()">
  <UL class="menu_list">
    <LI><A href="">周边游</A></LI>
    <LI><A href="">拼团出行</A></LI>
    <LI><A href="">自驾游</A></LI>
    <LI><A href="">国内游</A> </LI>
    <LI><A href="">出境游</A> </LI>
    <LI><A href="">AA制party</A> </LI>
    <LI><A href="">团购会</A> </LI></UL></LI>
  <LI id="c_7" class="c_li" onMouseOver="setLiMouseOver()" onMouseOut="liMouseOut()">
  <UL class="menu_list">
    <LI><A href="">轿车</A></LI>
    <LI><A href="">商务车</A></LI>
    <LI><A href="">11座-22座中巴</A></LI>
    <LI><A href="">27座-53座大巴</A> </LI>
    <LI><A href="">自行车</A> </LI>
    <LI><A href="">拼车</A> </LI></UL></LI>
   <LI id="c_8" class="c_li" onMouseOver="setLiMouseOver()" onMouseOut="liMouseOut()">
  <UL class="menu_list">
    <LI><A href="">公司旅游</A></LI>
    <LI><A href="">双人行</A></LI>
    <LI><A href="">私家旅游</A> </LI></UL></LI> 
   <LI id="c_9" class="c_li" onMouseOver="setLiMouseOver()" onMouseOut="liMouseOut()">
  <UL class="menu_list">
    <LI><A href="">门票</A></LI>
    <LI><A href="">土特产</A></LI>
    <LI><A href="">购物券</A></LI>
    <LI><A href="">生活用品</A> </LI>
    <LI><A href="">积分抵团费</A> </LI>
    <LI><A href="">积分抽奖</A> </LI></UL></LI> 
    <LI id="c_10" class="c_li" onMouseOver="setLiMouseOver()" onMouseOut="liMouseOut()">
  <UL class="menu_list">
    <LI><A href="">旅游</A></LI>
    <LI><A href="">酒店</A></LI>
    <LI><A href="">租车公司</A></LI></UL></LI>
    
    </UL></DIV></DIV>
        </div> 