$(document).ready(function(){
    //delete one book
    $('.delete-book').on('click', function () {

        /*<![CDATA[*/
        var path = /*[[@{/}]]*/'deleteBook';
        /*]]>*/

        var id = $(this).attr('id');

        $.post(path,{'id':id},function (res) {
            location.reload();
        })
    });

    $('#deleteManyButton').click( function () {
        var idList = $('.checkboxBook');
        //list of books
        var bookIdList = [];
        for (var i = 0; i<idList.length; i++){
            if (idList[i].checked === true){
                bookIdList.push(idList[i]['id']);
            }
        }

        if (bookIdList.length <= 0){
            $('#nberBookSelected').html(bookIdList.length).css({
                'color':'red',
                'font-weight':'bolder'
            });
            $('#deleteSelected').prop("hidden",true);
        }else{
            $('#nberBookSelected').html(bookIdList.length).css({
                'color':'green',
                'font-weight':'bolder'
            });
            $('#deleteSelected').prop("hidden",false);
        }
    });

    //delete all books selected
    $('#deleteSelected').click(function () {

        var idList = $('.checkboxBook');
        //list of books
        var bookIdList = [];

        for (var i = 0; i<idList.length; i++){
            if (idList[i].checked === true){
                bookIdList.push(idList[i]['id']);
            }
        }

       /*<![CDATA[*/
        var path = /*[[@{/}]]*/'deleteBookList';
        /*]]>*/

        $.ajax({
            type:'post',
            url: path,
            data: JSON.stringify(bookIdList),
            contentType:"application/json",
            success:function (res) {
                console.log(res);
                location.reload();
            },
            error:function (res) {
                console.log(res);
               location.reload();
            }
        });
    });

    $("#selectedAllBooks").click(function () {
        console.log("ok sab");
        if ($(this).prop("checked") === true){
            $(".checkboxBook").prop("checked",true);
        }else if($(this).prop("checked") === false){
            $(".checkboxBook").prop("checked", false);
        }
    })
});