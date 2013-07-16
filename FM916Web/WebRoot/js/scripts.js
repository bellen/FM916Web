$(function(){
	var $media = $("#musicbox");
	var $media1 = $("#musicplayer1");
	//播放按钮切换
	$("#play").click(function(){
		if ($("#play").is(".playing")) {
			$("#play").removeClass("playing");
			$media[0].pause();
		} else {
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
			setTimeout(auto,1000);
			}
		}
});