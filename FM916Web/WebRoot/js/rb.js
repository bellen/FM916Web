$(function(){
	$("#rbnav1").click(function(){
		$("#rblayer1").attr("style","display:block;");
		$("#rblayer2").attr("style","display:none;");
		$("#rblayer3").attr("style","display:none;"); 
		});
	$("#rbnav2").click(function(){
		$("#rblayer1").attr("style","display:none;");
		$("#rblayer2").attr("style","display:block;");
		$("#rblayer3").attr("style","display:none;"); 
		});
	$("#rbnav3").click(function(){
		$("#rblayer1").attr("style","display:none;");
		$("#rblayer2").attr("style","display:none;");
		$("#rblayer3").attr("style","display:block;"); 
		});
});
var _hmt = _hmt || [];
(function() {
  var hm = document.createElement("script");
  hm.src = "//hm.baidu.com/hm.js?a7ec419482d81428bb1bfb8dcd8f3d4c";
  var s = document.getElementsByTagName("script")[0]; 
  s.parentNode.insertBefore(hm, s);
})();