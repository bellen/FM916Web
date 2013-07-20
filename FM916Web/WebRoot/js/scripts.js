$(function(){
	$("#playercontent").html("<embed id='musicbox' autostart='0' src='mms://alive.rbc.cn/fm974' type='video/x-ms-wmv' width='1' height='1' uiMode='none'></embed>");
	var $media = $("#musicbox");
	var $media1 = $("#musicplayer1");
	//播放按钮切换
	$("#play").click(function(){
		if ($("#play").is(".playing")) {
			$("#play").removeClass("playing");
			$media[0].pause();
		} else {
			//alert("提示：该功能即将上线，敬请期待！")
			$("#play").addClass("playing");
			$media[0].play();
			auto();
			if ($("#play1").is(".playing")) {//两个播放的兼容，停止下面的播放
				$("#play1").removeClass("playing");
				$media1[0].pause();
			} 
		}
	});
	function auto(){
		if ($media[0].ended == true) {
			$("#play").removeClass("playing");
		} else{
			setTimeout(auto,1000);
			}
		}
	//右侧播放按钮切换
	$("#play1").click(function(){
		if ($("#play1").is(".playing")) {
			$("#play1").removeClass("playing");
			$media1[0].pause();
		} else {
			$("#play1").addClass("playing");
			$media1[0].play();
			auto1();
			if ($("#play").is(".playing")) {//两个播放的兼容，停止上面的播放
				$("#play").removeClass("playing");
				$media[0].pause();
			} 
		}
	});
	function auto1(){
		if ($media1[0].ended == true) {
			$("#play1").removeClass("playing");
		} else{
			setTimeout(auto1,1000);
			}
		}
	auto1();
});
var _hmt = _hmt || [];
(function() {
  var hm = document.createElement("script");
  hm.src = "//hm.baidu.com/hm.js?a7ec419482d81428bb1bfb8dcd8f3d4c";
  var s = document.getElementsByTagName("script")[0]; 
  s.parentNode.insertBefore(hm, s);
})();