$(function(){
    loadData();
    var now;
    function loadData(){            //게시물 목록 조회
        var i=0;
        console.log(localStorage.length);
        for (i=0; i<localStorage.length; i++){
            let key=localStorage.key(i);
            if (!Number.isInteger(parseInt(key))){
              console.log(key);
              continue;
            }
            let data=JSON.parse(localStorage.getItem(key));
            console.log(data);
            if (data.title.length==0) continue;
            var res="<tr>";
            res+="<td id='number'>"+key+"</td>";
            res+="<td>"+data.title+"</td>";
            res+="<td id='writer'>"+data.writer+"</td>";
            res+="<td><button class='see' data-bs-toggle='modal' data-bs-target='#exampleModal'>보기</button>"+"</td>";
            res+="</tr>"
            $('tbody').append(res);
        }
    }

    $('#create').click(function(){
        location.href="./main?action=noticewrite";
    });

    $('.see').on("click", function(){
        let num=$(this).parent().parent().children().first().text();
        console.log("번호"+num);
        let article=JSON.parse(localStorage.getItem(num));
        now=num;
        let data=`<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
          <div class="modal-content">
            <div class="modal-header">
              <h5 class="modal-title" id="exampleModalLabel">${article.title}</h5>
              <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
            <h7 class="modal-writer">${article.writer}</h7>
            <textarea name="content" rows="3" col="150" class="form-control" style="min-width: 100%">${article.content}</textarea>
            </div>
            <div class="modal-footer">
              <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
              <button type="button" class="btn btn-primary" id="update">수정하기</button>
              <button type="button" class="btn btn-primary" id="delete">삭제하기</button>
            </div>
          </div>
        </div>
      </div>`;
      $('.modal_').html(data);
    });

    var changed_content;

    $(document).on("propertychange change keyup paste input", 'textarea[name="content"]', function(){
        changed_content=$(this).val();
    })

    $(document).on("click", '#update', function(){;
        var t=$(this).parent().prev().prev().children().eq(0).text();
        var w=$(this).parent().prev().children().eq(0).text();
        const dict={title: t, writer: w, content:changed_content};
        console.log(now+"번 수정");
        localStorage.setItem(now,JSON.stringify(dict));
        alert("수정 되었습니다.");
        location.href="notice.html";
    });

    $(document).on("click", '#delete', function(){
        const dict={title:"", writer:"", content:""}; 
        localStorage.setItem(now,JSON.stringify(dict));
        location.href="notice.html";
    });

    
});
