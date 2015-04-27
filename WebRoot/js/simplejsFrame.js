/**********common1.js hit 2008.10 update 2008.11.3***************/

/********************start detect Browers and OS*********************/
var sUserAgent = navigator.userAgent;
var fAppVersion = parseFloat(navigator.appVersion);
//alert(sUserAgent);
function compareVersions(sVersion1,sVersion2)
{
	var aVersion1 = sVersion1.split(".");
	var aVersion2 = sVersion2.split(".");
	
	if(aVersion1.length > aVersion2.length)
	{
		for(var i=0;i<aVersion1.length - aVersion2.length;i++)
		{
			aVersion2.push("0");	
		}	
	}
	else if(aVersion1.length < aVersion2.length)
	{
		for(var i=0;i<aVersion2.length - aVersion1.length;i++)
		{
			aVersion1.push("0");
		}
	}
	
	for(var i=0;i<aVersion1.length;i++)
	{
		if(aVersion1[i] < aVersion2[i])
		{
			return -1;	
		}
		else if(aVersion1[i] > aVersion2[i])
		{
			return 1;	
		} 	
	}
	return 0;
}

var isOpera = sUserAgent.indexOf("Opera")>-1;
var isMinOpera4 = isMinOpera5 = isMinOpera6 = isMinOpera7 = isMinOpera7_5 = false;

if(isOpera)
{
	var fOperaVersion;
	if(navigator.appName == "Opera")
	{
		fOperaVersion = fAppVersion;	
	}
	else
	{
		var reOperaVersion = new RegExp("Opera(\\d+\\.\\d+)");
		reOperaVersion.test(sUserAgent);
		fOperaVersion = parseFloat(RegExp["$1"]);
	}
	
	isMinOpera4 = fOperaVersion >= 4;
	isMinOpera5 = fOperaVersion >= 5;
	isMinOpera6 = fOperaVersion >= 6;
	isMinOpera7 = fOperaVersion >= 7;
	isMinOpera7_5 = fOperaVersion >= 7.5;
}

var isKHTML = sUserAgent.indexOf("KHTML") > -1
		   || sUserAgent.indexOf("Konqueror") > -1
		   || sUserAgent.indexOf("AppleWebKit") > -1 ;

var isMinSafari1 = isMinSafari1_2 = false;
var isMinKonq2_2 = isMinKonq3 = isMinKong3_1 = isMinKonq3_2 = false;

if(isKHTML)
{
	isSafari = sUserAgent.indexOf("AppleWebKit") > -1;
	isKonq = sUserAgent.indexOf("Konqueror") >-1;
	
	if(isSafari)
	{
		var reAppleWebKit = new RegExp("AppleWebKit\\/(\\d+(?:\\.\\d*)?)");	
		reAppleWebKit.test(sUserAgent);
		var fAppleWebKitVersion = parseFloat(RegExp["$1"]);
		
		isMinSafari1 = fAppleWebKitVersion >= 85;
		isMinSafari1_2 = fAppleWebKitVersion >= 124;
	}
	else if (isKong)
	{
		var reKong = new RegExp("Konqueror\\/(\\d+(?:\\.\\d+(?:\\.\\d)?)?)");
		reKong.test(sUserAgent);
		isMinKong2_2 = compareVersions(RegExp["$1"],"2.2") >= 0;
		isMinKong3 = compareVersions(RegExp["$1"],"3.0") >= 0;
		isMinKong3_1 = compareVersions(RegExp["$1"],"3.1") >= 0;
		isMinKong3_2 = compareVersions(RegExp["$1"],"3.2") >= 0;
	}
}

var isIE = sUserAgent.indexOf("compatible")>-1
			&& sUserAgent.indexOf("MSIE")>-1
			&& !isOpera;
			
var isMinIE4 = isMinIE5 = isMinIE5_5 = isMinIE6 = isMinIE7 = false;

if(isIE)
{
	var reIE = new RegExp("MSIE (\\d+\\.\\d+)");	
	reIE.test(sUserAgent);
	var fIEVersion = parseFloat(RegExp["$1"]);
	//alert(fIEVersion);
	isMinIE4 = fIEVersion >= 4;
	isMinIE5 = fIEVersion >= 5;
	isMinIE5_5 = fIEVersion >= 5.5;
	isMinIE6 = fIEVersion >= 6.0;
	isMinIE7 = fIEVersion >= 7.0;
}

var isMoz = sUserAgent.indexOf("Gecko") > -1
           && !isKHTML;
		   
var isMinMoz1 = sMinMoz1_4 = isMinMoz1_5 = isFirefox = false;

if(isMoz)
{
	var reMoz = new RegExp("rv:(\\d+\\.\\d+(?:\\.\\d+)?)");	
	reMoz.test(sUserAgent);
	isMinMoz1 = compareVersions(RegExp["$1"],"1.0") >= 0;
	isMinMoz1_4 = compareVersions(RegExp["$1"],"1.4") >= 0;
	isMinMoz1_5 = compareVersions(RegExp["$1"],"1.5") >= 0;
	isFirefox = sUserAgent.indexOf("Firefox") > -1;
}

var isNS4 = !isIE && !isOpera && !isMoz && !isKHTML 
			&& (sUserAgent.indexOf("Mozilla") == 0) 
			&& (navigator.appName == "Netscape") 
			&& (fAppVersion >= 4.0 && fAppVersion <5.0);
			
var isMinNS4 = isMinNS4_5 = isMinNS4_7 = isMinNS4_8 = false;

if(isNS4)
{
	isMinNS4 = true;
	isMinNS4_5 = fAppVersion >= 4.5;
	isMinNS4_7 = fAppVersion >= 4.7;
	isMinNS4_8 = fAppVersion >= 4.8;
}

var isWin = (navigator.platform == "Win32") || (navigator.platform == "Windows");
var isMac = (navigator.platform == "Mac68K") || (navigator.platform == "MacPPC") || (navigator.platform == "Macintosh");
var isUnix = (navigator.platform == "X11") && !isWin && !isMac;

var isWin95 = isWin98 = isWinNT4 = isWin2K = isWinME = isWinXP = isWin2003 = isWinVista = false;
var isMac68K = isMacPPC = false;
var isSunOS = isMinSunOS4 = isMinSunOS5 = isMinSunOS5_5 = false;
if(isWin)
{
	isWin95 = sUserAgent.indexOf("Win95") > -1 || sUserAgent.indexOf("Windows 95")> -1;
	isWin98 = sUserAgent.indexOf("Win98") > -1 || sUserAgent.indexOf("Windows 98")> -1;
	isWinME = sUserAgent.indexOf("Win 9x 4.90") > -1 || sUserAgent.indexOf("Windows ME")> -1;
	isWin2K = sUserAgent.indexOf("Windows NT 5.0") > -1 || sUserAgent.indexOf("Windows 2000")> -1;
	isWinXP = sUserAgent.indexOf("Windows NT 5.1") > -1 || sUserAgent.indexOf("Windows XP")> -1;
	isWin2003 = sUserAgent.indexOf("Windows NT 5.2") > -1 ;
	isWinVista = sUserAgent.indexOf("Windows NT 6.0") > -1 ;
	isWinNT4 = sUserAgent.indexOf("WinNT") > -1 || sUserAgent.indexOf("Windows NT")> -1 || sUserAgent.indexOf("WinNT4.0")>-1 || sUserAgent.indexOf("Windows NT 4.0")>-1 && (!isWinME && !isWin2K && !isWinXP && !isWin2003) ;	
}

if(isMac)
{
	isMac68K = sUserAgent.indexOf("Mac_68000") > -1 || sUserAgent.indexOf("68K") > -1;
	isMacPPC = sUserAgent.indexOf("Mac_PowerPC") > -1 || sUserAgent.indexOf("PPC") > -1;
}

if(isUnix)
{
	isSunOS = sUserAgent.indexOf("SunOS") > -1;
	
	if(isSunOS)
	{
		var reSunOS = new RegExp("SunOS(\\d+\\.\\d+(?:\\.\\d+)?)");
		reSunOS.test(sUserAgent);
		isMinSunOS4 = compareVersion(RegExp["$1"],"4.0") >= 0 ;
		isMinSunOS5 = compareVersion(RegExp["$1"],"5.0") >= 0 ;
		isMinSunOS5_5 = compareVersion(RegExp["$1"],"5.5") >= 0 ;
		
	}
}
/********************end detect Browers and OS*********************/

/********************start EventUtility*********************/
var EventUtil = new Object;
EventUtil.addEventListener = function(oTarget,sEventType,fnHandler)
{
	if(oTarget.addEventListener)
	{
		//for DOM
		oTarget.addEventListener(sEventType,fnHandler,false);
	}
	else if(oTarget.attachEvent)
	{
		//for IE
		oTarget.attachEvent("on"+sEventType,fnHandler);
	}
	else
	{
		//for all others
		oTarget["on"+sEventType] = fnHandler;
	}
}
EventUtil.removeEventListener = function(oTarget,sEventType,fnHandler)
{
	if(oTarget.removeEventListener)
	{
		//for DOM
		oTarget.removeEventListener(sEventType,fnHandler,false);
	}
	else if(oTarget.detachEvent)
	{
		//for IE
		oTarget.detachEvent("on"+sEventType,fnHandler);
	}
	else
	{
		//for all others
		oTarget["on"+sEventType] = null;
	}
}


EventUtil.formatEvent = function (oEvent)
{
	if(isIE && isWin)
	{
		oEvent.charCode = (oEvent.type == "keypress") ? oEvent.keyCode : 0 ;
		oEvent.eventPhase = 2;
		oEvent.isChar = (oEvent.charCode > 0);
		oEvent.pageX = oEvent.clientX + document.body.scrollLeft;
		oEvent.pageY = oEvent.clientY + document.body.scrollTop;
		oEvent.preventDefault = function ()
		{
			this.returnValue = false;	
		};
		
		if(oEvent.type == "mouseout")
		{
			oEvent.relatedTarget = oEvent.toElement;	
		}
		else if(oEvent.type == "mouseover")
		{
			oEvent.relatedTarget = oEvent.fromElement;	
		};
		
		oEvent.stopPropagation = function()
		{
			this.cancelBubble = true;	
		};
		
		oEvent.target = oEvent.srcElement;
		oEvent.time = (new Date()).getTime();
		
	}	
	return oEvent;
}
/*
the same property
altKey / ctrlKey / shiftKey
clientX / clientY
screenX / screenY
type
button
keyCode
*/

EventUtil.getEvent = function ()
{
	if(window.event)
	{
		return this.formatEvent(window.event);	
	}
	else
	{
		return EventUtil.getEvent.caller.arguments[0];	
	}
}

/*addDOMLoadEvent*/
EventUtil.addDOMLoadEvent = (function(){
    // create event function stack
    var load_events = [],
        load_timer,
        script,
        done,
        exec,
        old_onload,
        init = function () {
            done = true;

            // kill the timer
            clearInterval(load_timer);

            // execute each function in the stack in the order they were added
            while (exec = load_events.shift())
                exec();

            if (script) script.onreadystatechange = '';
        };

    return function (func) {
        // if the init function was already ran, just run this function now and stop
        if (done) return func();

        if (!load_events[0]) {
            // for Mozilla/Opera9
            if (document.addEventListener)
                document.addEventListener("DOMContentLoaded", init, false);

            // for Internet Explorer
            /*@cc_on @*/
            /*@if (@_win32)
                document.write("<script id=__ie_onload defer src=//0><\/scr"+"ipt>");
                script = document.getElementById("__ie_onload");
                script.onreadystatechange = function() {
                    if (this.readyState == "complete")
                        init(); // call the onload handler
                };
            /*@end @*/

            // for Safari
            if (/WebKit/i.test(navigator.userAgent)) { // sniff
                load_timer = setInterval(function() {
                    if (/loaded|complete/.test(document.readyState))
                        init(); // call the onload handler
                }, 10);
            }

            // for other browsers set the window.onload, but also execute the old window.onload
            old_onload = window.onload;
            window.onload = function() {
                init();
                if (old_onload) old_onload();
            };
        }

        load_events.push(func);
    }
})();
//how to user:
//EventUtil.addEventListener($("txt1"),"mousedown",fnHandler);
//function fnHandler(){var oEvent = EventUtil.getEvent();...here to user oEvent's other properties}
//
/********************end EventUtility*********************/

/********************start Drager*********************/
function Drager(oDragTarget,oDropTarget)
{
	this.iDiffX = 0;
	this.iDiffY = 0;
	this.oDiv = oDragTarget;
	this.oTarget = oDropTarget;
	var DragerObj = this;
	this.dragging = function()
	{
		var oEvent = EventUtil.getEvent();
		DragerObj.oDiv.style.left = (oEvent.clientX - DragerObj.iDiffX)+"px";
		DragerObj.oDiv.style.top = (oEvent.clientY -DragerObj.iDiffY)+"px";
	}
	this.startDrag = function ()
	{
		var oEvent = EventUtil.getEvent();
		this.iDiffX = oEvent.clientX - this.oDiv.offsetLeft;
		this.iDiffY = oEvent.clientY - this.oDiv.offsetTop;
		EventUtil.addEventListener(document,"mousemove",this.dragging);
		EventUtil.addEventListener(document,"mouseup",this.stopDrag);
	}
	this.stopDrag = function ()
	{
		var oEvent = EventUtil.getEvent();
		EventUtil.removeEventListener(document,"mousemove",DragerObj.dragging);
		EventUtil.removeEventListener(document,"mouseup",DragerObj.stopDrag);
		if(DragerObj.isOverDropTarget(oEvent.clientX,oEvent.clientY))
		{
			DragerObj.oDiv.style.left = DragerObj.oTarget.offsetLeft+"px";
			DragerObj.oDiv.style.top = DragerObj.oTarget.offsetTop+"px";
		}		
	}
	this.isOverDropTarget = function(iX,iY)
	{
		var iX1 = this.oTarget.offsetLeft;
		var iX2 = iX1 + this.oTarget.offsetWidth;
		var iY1 = this.oTarget.offsetTop;
		var iY2 = iY1 + this.oTarget.offsetHeight;
		return(iX >= iX1 && iX <= iX2 && iY >= iY1 && iY <= iY2);
	}
}
//how to user:
//var myDrager = new Drager($("div1"),document);
//onmousedown="myDrager.startDrag(event)";
/********************end Drager*********************/

/*website search*/
function searchnews()
{
    

  if( document.getElementById("q").value== "")
   {
        alert("请填上您要搜索的内容");
   }
   else
   {
        if(arguments.length == 0)
        {
            document.forms[0].target="_blank";
            document.forms[0].method="POST";
            document.forms[0].action="/searchrs.aspx?q="+document.forms[0].q.value;
            document.forms[0].submit();
        }
        else
        {
            window.location.href="/searchrs.aspx?q="+document.forms[0].q.value;
        }
   
        
   }
          

}

/*get Element*/
function $() {
  var elements = new Array();

  for (var i = 0; i < arguments.length; i++) {
    var element = arguments[i];
    if (typeof element == 'string')
      element = document.getElementById(element);

    if (arguments.length == 1) 
      return element;

    elements.push(element);
  }

  return elements;
}


/*StringBuilder*/
var get_a_k={
	'\x6F\x62\x6A\x65\x63\x74':function(a,k){return a[1][k];},
	'\x73\x74\x72\x69\x6E\x67':function(a,k){return a[k-0+1];}
	};
	
function StringBuilder(d){
	this.s = new Array(d);
	this.append=function(d){this.s.push(d);return this;};
	this.toString=function(){return this.s.join('');};
	this.clear=function(){this.s=new Array();};
	this.appendFormat=function(){
		var n=arguments.length;
		if(n==0) return this; 
		var f=arguments[0];
		if(n==1) return this.append(f); 
		var arg=arguments[1];
		if(arg==null) arg='';
		var i,e,c,k,a_k=get_a_k[typeof(arg)];
		
		for (i=0 ; i < f.length;){
			c=f.charAt(i);
			if (c == '{'){
				e=f.indexOf('}',i);
				k=f.substring(i+1,e);
				this.s.push(a_k(arguments,k));
				i=e+1;
				continue;
			}
		    this.s.push(c);
		    i++;
	    }
		return this;
    }
}
//how to user:
//var sb = new StringBuilder();
//sb.appendFormat("1111111{0}222222{1}","xxx","yyy");


//getIndexByArrVal
function getIndexByArrVal(mDDLItemValue,Arr)
{
	for(i=0;i<Arr.length;i++)
	{
		if(mDDLItemValue == Arr[i])
		{
			return i;
		}
	}
	return -1;
}

//getURLArg(url)
function getURLArg(url)
{
	var url = url;
	var argColl ={};
	var _whPos = url.indexOf("?");
	if(_whPos>-1)
	{
		var _argsStr = url.substring(_whPos+1);
		if(_argsStr.indexOf("&")>-1)
		{
			var _argStrArr = _argsStr.split("&");
			for(i=0;i<_argStrArr.length;i++)
			{
				if(_argStrArr[i].indexOf("=")>-1)
					argColl[_argStrArr[i].split("=")[0]]=unescape(_argStrArr[i].split("=")[1]);
			}
		}
		else
		{
			if(_argsStr.indexOf("=")>-1)
				argColl[_argsStr.split("=")[0]]=_argsStr.split("=")[1];			
		}		
	}
	
	return argColl;
}

/*getSiteFullUrl && getSiteUrl*/
function getSiteFullUrl(url)
{

	var startTag = "";
	var siteFullUrl ="";
	var addressUrl ="";
	
	if(arguments.length==0)
	{
		//no import url ,than get location url
		addressUrl = window.location.href;
	}
	else
	{
		//get import url
		addressUrl = arguments[0];
	}
	
	
	if(addressUrl.indexOf("http://")>-1)
	{
		startTag = "http://";
	}
	else if(addressUrl.indexOf("https://")>-1)
	{
		startTag = "https://";
	}
	else if(addressUrl.indexOf("ftp://")>-1)
	{
		startTag = "ftp://";
	}
	else if(addressUrl.indexOf("file:///")>-1)
	{
		startTag ="file:///";
	}else{}
	

	if(addressUrl.indexOf(startTag) > -1)
	{
		var _tmpurl = addressUrl.substring(startTag.length);
		var _endTagPos =startTag.length+_tmpurl.indexOf("/");
		siteFullUrl =addressUrl.substring(0,_endTagPos);
	}
	//format like this:   http://www.123.com
	return siteFullUrl;
}


 
 function getSiteUrl(url)
 {
 	var startTag = "";
	var siteUrl ="";
	var addressUrl ="";
	
	if(arguments.length==0)
	{
		//no import url ,than get location url
		addressUrl = window.location.href;
	}
	else
	{
		//get import url
		addressUrl = arguments[0];
	}
	
	
	if(addressUrl.indexOf("http://")>-1)
	{
		startTag = "http://";
	}
	else if(addressUrl.indexOf("https://")>-1)
	{
		startTag = "https://";
	}
	else if(addressUrl.indexOf("ftp://")>-1)
	{
		startTag = "ftp://";
	}
	else if(addressUrl.indexOf("file:///")>-1)
	{
		startTag ="file:///";
	}else{}
	
	var _siteFullUrl = getSiteFullUrl(addressUrl);
	siteUrl = _siteFullUrl.substring(startTag.length);
	
	//format like this:  www.123.com
	return siteUrl;
 }





/*GetElementPosition*/
function GetElementPosition(element) {
    var result = new Object();
    result.x = 0;
    result.y = 0;
    result.width = 0;
    result.height = 0;
    if (element.offsetParent) {
        result.x = element.offsetLeft;
        result.y = element.offsetTop;
        var parent = element.offsetParent;
        while (parent) {
            result.x += parent.offsetLeft;
            result.y += parent.offsetTop;
            var parentTagName = parent.tagName.toLowerCase();
            if (parentTagName != "table" &&
                parentTagName != "body" && 
                parentTagName != "html" && 
                parentTagName != "div" && 
                parent.clientTop && 
                parent.clientLeft) {
                result.x += parent.clientLeft;
                result.y += parent.clientTop;
            }
            parent = parent.offsetParent;
        }
    }
    else if (element.left && element.top) {
        result.x = element.left;
        result.y = element.top;
    }
    else {
        if (element.x) {
            result.x = element.x;
        }
        if (element.y) {
            result.y = element.y;
        }
    }
    if (element.offsetWidth && element.offsetHeight) {
        result.width = element.offsetWidth;
        result.height = element.offsetHeight;
    }
    else if (element.style && element.style.pixelWidth && element.style.pixelHeight) {
        result.width = element.style.pixelWidth;
        result.height = element.style.pixelHeight;
    }
    return result;
}

/*******************************start AJAX*******************************/
function Ajax(url)
{
	var m_xmlReq=false;
	var m_OnSucceed=function(){};
	var m_OnReading=function(){};
	var m_timer=null;
	this.Url=url;

	if(window.XMLHttpRequest)
	{
		m_xmlReq = new XMLHttpRequest();
	}
	else if(window.ActiveXObject)
	{ 
	   try 
	   {
	     m_xmlReq = new ActiveXObject("Msxml2.XMLHTTP");
	   }
	   catch(e)
	   {
		  try { m_xmlReq = new ActiveXObject("Microsoft.XMLHTTP");}catch(e){}
		}
	}     
    
	this.OnReading=function( readingFunction)
	{
		m_OnReading=readingFunction;
	}

	this.OnSucceed=function( onSucceeded )
	{
	   m_OnSucceed = onSucceeded	   
	}
	this.OnTimeout=function(timeoutFunc,time)
	{
		m_timer=window.setTimeout(timeoutFunc,time);
	}

	this.invokeServer=function(send_data,method)
	{
		if(!m_xmlReq)  return;
		m_xmlReq.open(method,this.Url,true);
		if(method.toLowerCase() =="post") 
		m_xmlReq.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded;charset=utf-8');  		
		m_xmlReq.onreadystatechange=function()
		{
			if(m_xmlReq.readyState == 4 )
			{		
				m_OnSucceed(m_xmlReq.responseText);
				if(m_timer!=null) window.clearTimeout(m_timer);
			}    
		}	
		if(send_data != null)
		{
		    m_xmlReq.send(send_data.toString());
		}
		else
		{
		    m_xmlReq.send(null);
		}	
		
	}
	
	this.sendRequest=function(send_data,method,userContext)
	{
	   if(!m_xmlReq)  return;
		m_xmlReq.open(method,this.Url,true);
		if(method.toLowerCase() =="post") 
		m_xmlReq.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded;charset=utf-8');  		
		m_xmlReq.onreadystatechange=function()
		{
			if(m_xmlReq.readyState == 4 )
			{	
				m_OnSucceed(m_xmlReq.responseText,userContext);
				if(m_timer!=null) window.clearTimeout(m_timer);
			}    
		}
		
		m_xmlReq.send(send_data.toString());
	}
}
//how to user:
//var rd = Math.random();
//var upAjax = new Ajax("/ShowAsync.aspx?rqtype=getlogst&rd="+rd);
//upAjax.OnSucceed(GetLoginStatusCallBack);
//upAjax.invokeServer(null,"Get");
//function GetLoginStatusCallBack(res)
//{
//   if(res != "")...


//Ajax Start

function Ajax_GetXMLHttpRequest() 
{
	if (window.XMLHttpRequest) 
	{
		return new XMLHttpRequest();
	} 
	else 
	{
		if (window.Ajax_XMLHttpRequestProgID) 
		{
			return new ActiveXObject(window.Ajax_XMLHttpRequestProgID);
		} 
		else 
		{
			var progIDs = ["Msxml2.XMLHTTP.5.0", "Msxml2.XMLHTTP.4.0", "MSXML2.XMLHTTP.3.0", "MSXML2.XMLHTTP", "Microsoft.XMLHTTP"];
			for (var i = 0; i < progIDs.length; ++i) 
			{
				var progID = progIDs[i];
				try 
				{
					var x = new ActiveXObject(progID);
					window.Ajax_XMLHttpRequestProgID = progID;
					return x;
				} 
				catch (e) 
				{
				}
			}
		}
	}
	return null;
}

function Ajax_CallBack(type, id, method, args, clientCallBack, debugRequestText, debugResponseText, debugErrors, includeControlValuesWithCallBack, url) 
{
    debugErrors = false;
	var x = Ajax_GetXMLHttpRequest();
	var result = null;
	if (!x) 
	{
		result = { "value":null, "error": "NOXMLHTTP"};
		if (debugErrors) 
		{
			alert("error: " + result.error);
		}
		if (clientCallBack) 
		{
			clientCallBack(result);
		}
		return result;
	}

	x.open("POST", url, clientCallBack ? true : false);
	x.setRequestHeader("Content-Type", "application/x-www-form-urlencoded; charset=utf-8");
	if (clientCallBack) 
	{
		x.onreadystatechange = function() 
		{
			var result = null;
		
			if (x.readyState != 4) 
			{
				return;
			}
			
			if (debugResponseText) 
			{
			/*
				alert(x.responseText);
				*/
			}
			
			try
			{
				var result = eval("(" + x.responseText + ")");
                /*
				if (debugErrors && result.error) 
				{
					alert("error: " + result.error);
				}
				*/
			}
			catch (err)
			{
			    /*
				if (window.confirm('The following error occured while processing an AJAX request: ' + err.message + '\n\nWould you like to see the response?'))
				{
					var w = window.open();
					w.document.open('text/plain');
					w.document.write(x.responseText);
					w.document.close();
				}
				*/
				result = new Object();
				result.error = 'An AJAX error occured.  The response is invalid.';
			}
			
			clientCallBack(result);			
		}
	}
	var encodedData = "Ajax_CallBackType=" + type;
	if (id) 
	{
		encodedData += "&Ajax_CallBackID=" + id.split("$").join(":");
	}
	encodedData += "&Ajax_CallBackMethod=" + method;
	if (args) 
	{
		for (var i in args) 
		{
			encodedData += "&Ajax_CallBackArgument" + i + "=" + encodeURIComponent(args[i]);
		}
	}
	if (includeControlValuesWithCallBack && document.forms.length > 0)
	{
		var form = document.forms[0];
		for (var i = 0; i < form.length; ++i) 
		{
			var element = form.elements[i];
			if (element.name) 
			{
				var elementValue = null;
				if (element.nodeName == "INPUT") 
				{
					var inputType = element.getAttribute("TYPE").toUpperCase();
					if (inputType == "TEXT" || inputType == "PASSWORD" || inputType == "HIDDEN") 
					{
						elementValue = element.value;
					} else if (inputType == "CHECKBOX" || inputType == "RADIO") 
					{
						if (element.checked) 
						{
							elementValue = element.value;
						}
					}
				} 
				else if (element.nodeName == "SELECT") 
				{
					elementValue = element.value;
				} 
				else if (element.nodeName == "TEXTAREA") 
				{
					elementValue = element.value;
				}
				if (elementValue) 
				{
					encodedData += "&" + element.name + "=" + encodeURIComponent(elementValue);
				}
			}
		}
	}
	if (debugRequestText) 
	{
		alert(encodedData);
	}
	x.send(encodedData);
	
	if (!clientCallBack) 
	{
		if (debugResponseText) 
		{
			alert(x.responseText);
		}
		result = eval("(" + x.responseText + ")");
		/*
		if (debugErrors && result.error) 
		{
			alert("error: " + result.error);
		}
		*/
		
	}
	
	delete x;
	return result;
}

//Ajax End



/*******************************end AJAX*******************************/

/*ArrayList*/
function ArrayList() 
{ 
    if(arguments.length==0)
    {
       this.content = new Array(); 
       this.count=0;
    }
    else
    {
        this.content=arguments[0];
        this.count=this.content.length;
    }

    
    this.isValidIndex=function(index) 
    { 
        return /^\d+$/.exec(index) && index>=0 && index<this.count 
    } 
    this.add=function(data) 
    { 
        this.content[this.count++]=data; 
    } 
    this.items=function(index) 
    { 
        if(!this.isValidIndex(index))    return null; 

        return this.content[index]; 
    } 
    this.remove =function(index) 
    { 

        if(!this.isValidIndex(index))    return false; 
        
        if(this.count>1)
        {
            for(var i=index;i<this.count;i++)    
            this.content[i]=this.content[i+1]; 
        }

        delete this.content[this.count-1]; 
        
        this.count--; 
        

    } 
    this.indexOf=function(elem) 
    { 
        for (var i=0;i <this.count;i++) 
            if (this.content[i]==elem)    return i; 
             
        return -1; 
    } 
    this.lastIndexOf = function(elem)  
    { 
        for (var i = this.count-1; i >= 0; i--) 
            if (this.content[i]==elem ) return i; 

        return -1; 
    } 
    this.contains=function(elem) 
    { 
        return this.indexOf(elem) >= 0; 
    }
	
	this.toString=function()
	{
	    if(this.count==0) 
	        return "[]";
		return "['"+this.content.slice(0,this.count).join("','")+"']";
	}
}

/*HashTable*/
function Hashtable() 
{ 
var _UNDEFINED_="undefined";
	this.count=0;
	this.content= new Object(); 
	this.defined=function(p)
	{
		return typeof(p)!=_UNDEFINED_;
	}
	this.add = function(key,value)
	{ 
		if(this.contains(key))	return false; 

		this.content[key]=value;
		this.count++;
		return true; 			
    } 
	this.remove= function(key)
	{
		if(!this.contains(key))	return;

		delete this.content[key];
		this.count--;
	} 
	this.items  = function(key)
	{
		if(this.contains(key))	return this.content[key];

		return null;
	} 
	this.contains= function(key)
	{ 
		return this.defined(this.content[key]);
	} 
	this.clear= function()
	{
		for(var k in this.content)	delete this.content[k];
		this.count=0;
	}
	
	// Convert to http request parameter form
	this.toString=function()
	{
	    var sb=new StringBuilder();
	    var hasItem=false;
	    
	    for(var k in this.content)
	    {
	        if(hasItem)
	            sb.appendFormat("&{0}={1}",k,this.content[k]);
	        else
	        {
	            sb.appendFormat("{0}={1}",k,this.content[k]);
	            hasItem=true;
	        }
	    }
	    
	    return sb.toString();
	}
}

/*creatFun*/
function createFunction(obj,strFunc)
{
      var args=[];
      if(!obj)obj=window;
      for(var i=2;i<arguments.length;i++)
      args.push(arguments[i]);
      return function(){
            obj[strFunc].apply(obj,args);
      }
}

/*************** start getCssValue******************/
function getCssRule() {       
	var styleSheetLen = document.styleSheets.length;   
	if(!styleSheetLen) return;     
	var ruleName = (document.styleSheets[0].cssRules)?'cssRules':'rules'; //FireFox:cssRules || IE:rules     
  
	var result = {};      
	var totalRuleLen = 0;      
	var totalSelectorLen = 0;      
	var totalProperty = 0;     

	for(var i=0; i<styleSheetLen; i++) 
	{              
		var styleSheet = document.styleSheets[i];          
		var ruleLen = styleSheet[ruleName].length;          
		totalRuleLen += ruleLen;         
		for(var j=0; j<ruleLen; j++)
		{                         
			var selectors = styleSheet[ruleName][j].selectorText.toLowerCase().split(",");              
			var selectorLen = selectors.length;              
			totalSelectorLen += selectorLen;              
			for(var s=0; s<selectorLen; s++)
			{                                
				selector = selectors[s].replace(/(^\s*)|(\s*$)/g, "");                                
				result[selector] = {};                                   
				var styleSet = styleSheet[ruleName][j].style;                  
				for (property in styleSet)
				{                                
					if(styleSet[property] && property != 'cssText')
					{                         
						//alert(selector +'=>'+ property +':'+ styleSet[property])                         
						result[selector][property] = styleSet[property];                          
						totalProperty += 1;                     
					}                
				}             
			}         
		}    
}     
	result.totalSheet = styleSheetLen; 
	result.totalRule = totalRuleLen; 
	result.totalSelector = totalSelectorLen;  
	result.totalProperty = totalProperty;    
	return result; 
} 

var css; 
function getCssValue(selector,attribute)
{  
	css= getCssRule();    
	return (css[selector])?(css[selector][attribute])?css[selector][attribute]:false:false; 
} 
//how to use:
// 获取指定选择符下面的 CSS 属性值 
// selector:选择符（小写） 
// attribute:查询的 CSS 属性，脚本模式（如：background-color 为 backgroundColor）
/*************** start getCssValue******************/


/**
	* 根据地址栏参数获得指定值
	* @param {String} name 参数名称
	*/
var 	getParam= function(name, url) {
		var winParam = (url || window.location.href).toString().split("?");
		if (winParam.length > 1) {
			var urlParam = winParam[1].split('&');
			var urlLength = urlParam.length;
			for (var i = 0; i < urlLength; i++) {
				if (urlParam[i].toUpperCase().indexOf(name.toUpperCase() + "=") > -1) {
					return urlParam[i].split("=")[1].replace('#', '');
				};
			};
		};
		return '';
	}
	
	
/**
	Cookie操作类
	*/	
	
var Cookie= {
            write: function(cookieName, cookieValue, expires) {
                cookieName = cookieName.toLowerCase();
                if (expires) {
                document.cookie =
                this.getName(cookieName) + "=" + escape(cookieValue)
                + "; expires=" + expires.toGMTString() + ";path=/;";
                }
                else {
                document.cookie = this.getName(cookieName) + "=" + escape(cookieValue) + ";path=/;";
                }
            },
            read: function(cookieName, dfltValue) {
                var lowerCookieName = cookieName.toLowerCase();
                var cookieStr = document.cookie;
                if (cookieStr == "") {
                return dfltValue;
                }
                var cookieArr = cookieStr.split("; ");
                var pos = -1;
                for (var i = 0; i < cookieArr.length; i++) {
                pos = cookieArr[i].indexOf("=");
                if (pos > 0) {
                if (cookieArr[i].substring(0, pos).toLowerCase() == lowerCookieName) {
                return unescape(cookieArr[i].substring(pos + 1, cookieArr[i].length));
                }
                }
                }
                return dfltValue;
            },
            getName: function(cookieName) {
                var lowerCookieName = cookieName.toLowerCase();
                var cookieStr = document.cookie;
                if (cookieStr == "") {
                return cookieName;
                }
                var cookieArr = cookieStr.split("; ");
                var pos = -1;
                for (var i = 0; i < cookieArr.length; i++) {
                pos = cookieArr[i].indexOf("=");
                if (pos > 0) {
                if (cookieArr[i].substring(0, pos).toLowerCase() == lowerCookieName) {
                return cookieArr[i].substring(0, pos);
                }
                }
                }
                return cookieName;
            },
            delCookie: function(key)//删除cookie
            {
                key = key.toLowerCase();
                var exDate = new Date();
                exDate.setTime(exDate.getTime() - 1);
                var exDateString;
                exDateString = exDate.toGMTString(); //expires 的值
                document.cookie = key + "=" + " ;" + exDateString + ";path=/;"; //escape是处理转义字符的
            }
};


/**
	* 格式化字符串方法
	* @return {String}
	*/
String.format=function(){
		if (arguments.length == 0)
			return "";
		if (arguments.length == 1)
			return arguments[0];
		var reg = /{(\d+)?}/g;
		var args = arguments;
		var result = arguments[0].replace(
			reg,
			function($0, $1) {
			return args[parseInt($1) + 1];
			}
		);
		return result;
	};
	
	
/**
	* 设置图片居中
	* @param {dom} img 图片DOM元素
	*/	
function setCenter(img){
    
    //if(img.src.indexOf('201111201246698')>-1)debugger;
    
    img.style.position ='absolute';
    img.style.top ='50%';
    img.style.left ='50%';
    var ct = img.parentNode;
    ct.style.display ='block';
    ct.style.textAlign ='center';
    ct.style.position ='relative';
    ct.style.overflow ='hidden';
    var ctw = ct.offsetWidth;
    var cth = ct.offsetHeight; 
    var imgw = img.offsetWidth;
    var imgh = img.offsetHeight;
    var newimgWidth,newimgHeight;
    var scaleUseStandar = function(widthOrHeight){
        if(widthOrHeight == "width"){
            newimgWidth = ctw;
            newimgHeight =  (newimgWidth * imgh) / imgw;
        }else if(widthOrHeight == "height"){
             newimgHeight = cth;
            newimgWidth = (newimgHeight * imgw) / imgh;
        }
    };
     if(imgw <= ctw && imgh <= cth){
        newimgWidth = imgw;
        newimgHeight = imgh;
     }else{
            if(imgw > ctw  && imgh <= cth){
                 scaleUseStandar("width");
             }
            if(imgw <= ctw  && imgh > cth){
                scaleUseStandar("height");
            }
            if(imgw > ctw  && imgh > cth){
                if(imgw > imgh){
                  scaleUseStandar("width");
               }else{
                  scaleUseStandar("height");
               }
            }
     }

    img.style.width = newimgWidth + "px";
    img.style.height = newimgHeight +"px";
    img.style.marginLeft = - newimgWidth/2 +"px";
    img.style.marginTop = - newimgHeight/2 +"px";
    }





 