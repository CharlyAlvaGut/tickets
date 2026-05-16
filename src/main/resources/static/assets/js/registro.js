/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function limpiar(){
    $("#grado").val("");
    $("#escola").val("");
    $("#correo").val("");
    $("#telefono").val("");
	
    if($("#fechaasc").val().length > 0){
        $("#fechaasc").val("");
    }
}

function checaReg(){
	var valida = true;
    
	$.post(base_url + "registro/existereg",
        {placa: $("#numemp").val()},
        function(answer){
            if(answer != '0'){
                message(answer);
                valida = false;
            }
    });

    return valida;
}

$(function(){  
    limpiar();

    //Evento guardar
    $("#registrar").click(function(e){
        e.preventDefault();

        if(valida_cajas() && checaReg()){
            $("<div id='pregunta'><p>Los datos son correctos ???</p></div>").dialog({
                autoOpen: true,
                modal:true,
                resizable:false,
                title:'SIC - PBI',
                width: 400,
                height:180,
                open:function(){
                    $(this).parent().find('button:nth-child(2)').focus();
                },
                buttons: [
                    {
                        text: "Aceptar", click: function() {
                            $( this ).dialog( "close" );
                            $("#form1").submit();
                            $("#form1").onsubmit(appBlock());
                        }
                    },
                    {
                        text: "Cancelar", click: function() {
                            $( this ).dialog( "close" );
                        }
                    }
                ]
            });
        }
    });

    $("#limpiar").click(function(){
        limpiar();
    });  

    $("#telefono").keyup(function (){
        this.value = (this.value + '').replace(/[^0-9]/g, '');
    });

    $('#correo').keyup(function() {
        $(this).val($(this).val().toLowerCase());
    });
});

