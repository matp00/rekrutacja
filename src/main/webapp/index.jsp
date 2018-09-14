<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>zadanie2</title>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <style>

        .first{width:300px; height:150px;background-color: dodgerblue; text-align: center;margin-right: auto;
            margin-left: auto; line-height: 150px;}
        .hidden{ display: none;}
        .first:hover{
            opacity: 0.9;
            cursor: pointer;
        }

    </style>
</head>
<body>
<body>
<div class="first">
    <h3>Dodaj liczbę</h3>
</div>
<br>
<form id="put">
    <select class="hidden">
        <option value="ASC">ASC</option>
        <option value="DESC">DESC</option>
    </select>
    <input type="button" class="hidden" id = "btn2" value="Sortuj"/>
</form>
<div id="result">

</div>




<script>
    $(function(){
        $('.first').on("click", function () {
            $('#btn2').removeClass("hidden");
            $('select').removeClass("hidden");
            var inputs = $("<input type = 'text' class='number' placeholder='Wpisz liczbe'/>");
            $('#put').prepend(inputs);
        })



        $('#btn2').on('click',function () {
            var lista = $('.number');
            var list=[];
            for(var i=0; i<lista.length;i++){
                if(lista[i].value!=""){
                    if(parseInt(lista[i].value)){
                        list.push(lista[i].value);
                    }else{
                        alert('Mozesz wpisac tylko liczby!!!');
                        break;
                    }
                }
            }
            var order = $('select').val();
            var sorter = {list,order};
            console.log(sorter);


            $.ajax({
                headers: {
                    'Content-Type': 'application/json'
                },
                url: "/numbers/sort-command",
                data: JSON.stringify(sorter),
                type: "POST",
                dataType: "json",
                success: function (data) {
                    for(var elem of data){
                        $('#result').append("<span>"+elem+" "+"</span>");
                        }
                    $('#result').append("<br>");
                },
                error: function (xhr, status,
                                 errorThrown) {
                },
                complete: function (xhr, status) {

                }

            });
        })
    })
</script>
</body>
</html>
