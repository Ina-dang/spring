/**
 * 
 */

//모듈패턴은 자스 즉시실행함수와 {}를 이용해서 객체구성

console.log("Reply Module");
var replyService = (function() {
    var add = function(reply, callback, error) {
        console.log("add()....");
        $.ajax({
            url:"/replies/new",
            type:"post",
            data:JSON.stringify(reply),
            dataType:"json",
            contentType:"application/json; charset=utf-8",
            success : function(result, satatus, xhr) {
                if(callback) callback(result);
            },
            error : function(xhr, status, er) {
                if(error) error(er);
            }
        })
    }
    
    var getList = function(param, callback, error){
        var bno = param.bno;
        var lastRno = param.lastRno || 0;
        var amount = param.amount || 10;

        console.log("getList()....");
        var url = "/replies/pages/" + bno + "/" + lastRno + "/" + amount;
        $.ajax({
            url: url,
            type: "get",
            dataType: "json",
            success: function(result, satatus, xhr) {
                if(callback) callback(result);
            },
            error: function(xhr, status, er) {
                if(error) error(er);
            }
        })
    }
    
    var remove = function(rno, callback, error) {
        console.log("remove()....")
        $.ajax({
            url: "/replies/" + rno,
            type: "delete",
            success: function(result, satatus, xhr) {
                if(callback) callback(result);
            },
            error: function(xhr, status, er) {
                if(error) error(er);
            }
        })
    }
    
    function update(reply, callback, error) {
        console.log("update()....")
        $.ajax({
            url:"/replies/" + reply.rno,
            type:"put",
            data:JSON.stringify(reply),
            contentType:"application/json; charset=utf-8",
            success : function(result, satatus, xhr) {
                if(callback) callback(result);
            },
            error : function(xhr, status, er) {
                if(error) error(er);
            }
        })
    }
    
    function get(rno, callback, error) {
        console.log("get()...")
        $.ajax({
            url: "/replies/" + rno,
            type: "get",
            dataType: "json",
            success: function(result, satatus, xhr) {
                if(callback) callback(result);
            },
            error: function(xhr, status, er) {
                if(error) error(er);
            }
        })
    }

    function displayTime(timeValue) {
        console.log("displayTime()...")
        moment.locale('ko'); //사실 외부에 한번만 하는게 좋음
        return moment(timeValue).fromNow();
    }

    return {
        add: add, 
        getList: getList, 
        remove: remove,
        update: update,
        get: get,
        displayTime: displayTime
    };
})();
//
//console.log(replyService);
//replyService.add();
//replyService.getList();
//replyService.remove();
//replyService.get();
//replyService.update();
//replyService.displayTime();