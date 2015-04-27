// JavaScript Document
function  secBoardstarC(m1,m2,n)
{
for(i=1;i<7;i++){
 if(n==i){
   document.getElementById(m1+n).className="buttononc";
   <!--document.getElementById("sty"+n).className="clboldblack"-->
   document.getElementById(m2+n).style.display="block";
 }
 else{
    document.getElementById(m1+i).className="buttonoffc";
	<!--document.getElementById("sty"+i).className="clwhite"-->
    document.getElementById(m2+i).style.display="none";
 }
}
}