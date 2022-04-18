$(function(){
    $('.make').click(function(){            //게시물 등록
        var num=0;
        for (i=0; i<localStorage.length; i++){
            let key=localStorage.key(i);
            if (Number.isInteger(parseInt(key))){
                num=Math.max(num, key);
                console.log("있는 키"+num);
            }
              
        }
       var t=$("input[name=title]").val();
       var w=$("input[name=writer]").val();
       var c=$("textarea[name=content]").val();
       const dict={title:t, writer:w, content:c}; 
       localStorage.setItem(parseInt(num+1),JSON.stringify(dict));
       num++;
       alert("글이 등록되었습니다.");
       window.open("notice.html");
       self.close();
    });
});
