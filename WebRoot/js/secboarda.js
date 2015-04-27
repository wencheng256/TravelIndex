// JavaScript Document
function  secBoardstarB(m1,m2,n)
{
for(i=1;i<4;i++){
 if(n==i){
   document.getElementById(m1+n).className="buttononb";
   document.getElementById("sty"+n).className="clboldblack"
   document.getElementById(m2+n).style.display="block";
 }
 else{
    document.getElementById(m1+i).className="buttonoffb";
	document.getElementById("sty"+i).className="clwhite"
    document.getElementById(m2+i).style.display="none";
 }
}
}