 
function cajas(){
    $("[required]").before("<span class='required' style='color:red'>*</span>");

    $("input[type=text]").on("change", function(){
        this.value = this.value.toUpperCase();
        replaceChars(this.value,this);
    });    
}

function appBlock(){
    $.blockUI({
        message: '<button class="btn btn-light btn-lg" type="button" disabled><span class="spinner-border spinner-border-sm" role="status" aria-hidden="true"></span>Procesando solicitud...</button>', 
        theme: false,
        baseZ: 2000,
        css: {
            border: 'none',
            padding: '20px',
            '-webkit-border-radius': '10px',
            '-moz-border-radius': '10px',
            opacity: .6,
            color: '#000',
            'font-size': '12pt',
            'font-weight': 'bold'
        }
    });
}

function unBlock() {
  $.unblockUI();
}
function alertUser() {  
  alert('Alert User'); 
}

function message(mensaje, ancho, alto){
    ancho = (ancho == undefined) ? 400 : ancho;
    alto = (alto == undefined) ? 180 : alto;
    
    $("<div id='mensaje'><p>" + mensaje + "</p></div>").dialog({
        autoOpen: true,
        modal:true,
        resizable:false,
        title:'SIC - PBI',
        width: ancho,
        height:alto,
        buttons: [
            {
                text: "Aceptar",
                click: function() {
                    $( this ).dialog( "close" );
                }
            }
        ]
    });
}

/*function confirma(titulo){
    $("<div id='pregunta'><p>" + titulo + "</p></div>").dialog({
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
                    //appBlock();
                    form1.submit();
                }
            },
            {
                text: "Cancelar", click: function() {
                    $( this ).dialog( "close" );
                }
            }
        ]
    });
}*/

/*function domicilio(){        
    $('#codpost').select2({  
        placeholder: 'C\u00f3digo Postal',
        minimumInputLength: 4,
        quietMillis: 100,
        multiple: false,
        ajax: {
            url: base_url + "constancia/getcombos",
            type : 'post',
            dataType: 'json',
            data: function (term, page) {
                return { pam : '3', cod: term, page: page };                
            },
            results: function (data, page) {
                return { results: data }; 
            }
        }
    });
    
    $('#codpost').on("change", function(e) {
        var cp = e.added;   
        var url = base_url + "constancia/getcombos";

        if(typeof cp !== 'undefined') {
            $("#colonia").val(cp.dsCol);
            
            $.post(url,{
                pam : '2', ent : cp.idEdo, md: cp.idDeloMun
            },
            function (answer) {
                $("#mundeldom").html(answer);

                $.post(url,{
                    pam : '1', ent : cp.idEdo
                },
                function (answer) {
                    $("#entidom").html(answer);
                });             
            });
        }
    });  
}*/

/******************* :) SweetAlert2  ******************/

const swalWithBootstrapButtons = Swal.mixin({
  customClass: {
    confirmButton: 'btn btn-primary',
    cancelButton: 'btn btn-secondary'
  },
  buttonsStyling: false
});

function message(msg){
	swalWithBootstrapButtons.fire(msg);
}

function messageSuc(msg){
	swalWithBootstrapButtons.fire(
	  'Exito!', msg, 'success'
	);	
}

function messageWar(msg){
	swalWithBootstrapButtons.fire(
	  'Atención!', msg, 'warning'
	);	
}

function messageErr(msg){
	swalWithBootstrapButtons.fire(
		'Error!', msg, 'error'
	);
}

function messageExcel(msg){
    Swal.fire({
        title: 'Exito!',
		text: msg,
        icon: 'success',
        showCancelButton: false,
        confirmButtonText: 'Reporte',
        cancelButtonText: 'Cancelar',
        reverseButtons: true
    }).then((result) => {
		if (result.isConfirmed) {
		form2.submit();
		}
	});
}

function confirmDialog(msg, ico, url){ 
    elimina = (typeof url === 'undefined') ? false : true;
    reversa = (typeof url === 'undefined') ? true : false;

    swalWithBootstrapButtons.fire({
        title: "SIC-PBI",
        text: msg,
        icon: ico,
        showCancelButton: true,
        confirmButtonText: "Enviar",
        cancelButtonText: "Cancelar",
        reverseButtons: reversa
    }).then((result) => {
        if (result.isConfirmed) {
            if(elimina)
                $(location).attr('href',url);
            else{
                form1.submit();
                //form1.onsubmit(appBlock());
            }
        }
    });
}
