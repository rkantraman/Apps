$(document).ready(function(){
    $("#storeDeatailBtn").click(function(){

      

        var name = $("#name").val();
        var nickName = $("#nickName").val();
        var company = $("#company").val();
        var age = $("#age").val();
        var married = $("#married").val();


        console.log(" name : "+name);
        console.log(" nickName : "+nickName);
        console.log(" company : "+company);
        console.log(" age : "+age);
        console.log(" married : "+married);



        var input = {
            "name": name,
            "nickName": nickName,
            "age": age,
            "company" : company,
            "married": married,
            "birthday" : '27-01-1991'
        }

        
        $.ajax({
            url: 'http://localhost:8080/v1/people/add',
            type: 'post',
            data: input,
            success: function (data) {
                console.dir({ "success ": data });
                $("#name").val('');
                $("#nickName").val('');
                $("#company").val('');
                $("#age").val('');
                $("#married").val('');

            }, error: function (err) {
                console.dir({ "error ": err });
            }
            
        });
        
        // @RequestParam String name, 
        // @RequestParam String age, 
        // @RequestParam String nickName , 
        // @RequestParam String company,
        // @RequestParam String birthday,
        // @RequestParam String married

        // localhost:8080/v1/people/add
        


    });
});
