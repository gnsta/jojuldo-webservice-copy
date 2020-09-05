/*
 *여러개의 js로딩시 함수 이름 중복이 되지 않게 방지
 * 브라우저의 scope는 공용으로 쓰이기 때문에 나중에 불려진 js의 init, save가 먼저 불려진 js의 function을 덮어쓰게 됨
 */
var main = {
    init : function () {
        var _this = this;
        $('#btn-save').on('click', function () {
            _this.save();
        });
    },
    save : function () {
        var data = {
            title: $('#title').val(),
            author: $('#author').val(),
            content: $('#content').val()
        };

        $.ajax({
            type: 'POST',
            url: '/posts',
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
            alert('글이 등록되었습니다.');
            location.reload();
        }).fail(function (error) {
            alert(error);
        });
    }

};

main.init();