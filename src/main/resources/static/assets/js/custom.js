function appBlock(){
    $.blockUI({
        message: '<img src="../img/spinner.gif" style="vertical-align: middle;" /> Procesando solicitud...',
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

/******************* :) SweetAlert2  ******************/

function message(msg){
    Swal.fire(msg);
}

function messageSuc(msg){
    Swal.fire('Exito!', msg, 'success');    
}

function messageWar(msg){
    Swal.fire('Atencion!', msg, 'warning'); 
}

function messageErr(msg){
    Swal.fire('Error!', msg, 'error');
}

function confirmDialog(msg, ico, url){ 
    elimina = (typeof url === 'undefined') ? false : true;
    reversa = (typeof url === 'undefined') ? true : false;

    Swal.fire({
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
            else
                form1.submit();
        }
    });
}

// Quita acentos y tildes **********************************************
function replaceChars(x, y) {
    acento = "á";
    acento1 = "é";
    acento2 = "í";
    acento3 = "ó";
    acento4 = "ú";
    acento5 = "Á";
    acento6 = "É";
    acento7 = "Í";
    acento8 = "Ó";
    acento9 = "Ú";

    acento10 = "à";
    acento11 = "è";
    acento12 = "ì";
    acento13 = "ò";
    acento14 = "ù";
    acento15 = "À";
    acento16 = "È";
    acento17 = "Ì";
    acento18 = "Ò";
    acento19 = "Ù";

    acento20 = "â";
    acento21 = "ê";
    acento22 = "î";
    acento23 = "ô";
    acento24 = "û";
    acento25 = "Â";
    acento26 = "Ê";
    acento27 = "Î";
    acento28 = "Ô";
    acento29 = "Û";

    acento30 = "ä";
    acento31 = "ë";
    acento32 = "ï";
    acento33 = "ö";
    acento34 = "ü";
    acento35 = "Ä";
    acento36 = "Ë";
    acento37 = "Ï";
    acento38 = "Ö";
    acento39 = "Ü";

    sn = "a";
    sn1 = "e";
    sn2 = "i";
    sn3 = "o";
    sn4 = "u";
    sn5 = "A";
    sn6 = "E";
    sn7 = "I";
    sn8 = "O";
    sn9 = "U";

    var temp = "" + x;

    while (temp.indexOf(acento) >  - 1) {
        pos = temp.indexOf(acento);
        temp = "" + (temp.substring(0, pos) + sn + temp.substring((pos + acento.length), temp.length));
    }
    y.value = temp;

    while (temp.indexOf(acento1) >  - 1) {
        pos = temp.indexOf(acento1);

        temp = "" + (temp.substring(0, pos) + sn1 + temp.substring((pos + acento1.length), temp.length));
    }
    y.value = temp;

    while (temp.indexOf(acento2) >  - 1) {
        pos = temp.indexOf(acento2);

        temp = "" + (temp.substring(0, pos) + sn2 + temp.substring((pos + acento2.length), temp.length));
    }
    y.value = temp;

    while (temp.indexOf(acento3) >  - 1) {
        pos = temp.indexOf(acento3);

        temp = "" + (temp.substring(0, pos) + sn3 + temp.substring((pos + acento3.length), temp.length));
    }
    y.value = temp;

    while (temp.indexOf(acento4) >  - 1) {
        pos = temp.indexOf(acento4);

        temp = "" + (temp.substring(0, pos) + sn4 + temp.substring((pos + acento4.length), temp.length));
    }
    y.value = temp;

    while (temp.indexOf(acento5) >  - 1) {
        pos = temp.indexOf(acento5);

        temp = "" + (temp.substring(0, pos) + sn5 + temp.substring((pos + acento5.length), temp.length));
    }
    y.value = temp;

    while (temp.indexOf(acento6) >  - 1) {
        pos = temp.indexOf(acento6);

        temp = "" + (temp.substring(0, pos) + sn6 + temp.substring((pos + acento6.length), temp.length));
    }
    y.value = temp;

    while (temp.indexOf(acento7) >  - 1) {
        pos = temp.indexOf(acento7);

        temp = "" + (temp.substring(0, pos) + sn7 + temp.substring((pos + acento7.length), temp.length));
    }
    y.value = temp;

    while (temp.indexOf(acento8) >  - 1) {
        pos = temp.indexOf(acento8);

        temp = "" + (temp.substring(0, pos) + sn8 + temp.substring((pos + acento8.length), temp.length));
    }
    y.value = temp;

    while (temp.indexOf(acento9) >  - 1) {
        pos = temp.indexOf(acento9);

        temp = "" + (temp.substring(0, pos) + sn9 + temp.substring((pos + acento9.length), temp.length));
    }
    y.value = temp;

    while (temp.indexOf(acento10) >  - 1) {
        pos = temp.indexOf(acento10);
        temp = "" + (temp.substring(0, pos) + sn + temp.substring((pos + acento10.length), temp.length));
    }
    y.value = temp;

    while (temp.indexOf(acento11) >  - 1) {
        pos = temp.indexOf(acento11);

        temp = "" + (temp.substring(0, pos) + sn1 + temp.substring((pos + acento11.length), temp.length));
    }
    y.value = temp;

    while (temp.indexOf(acento12) >  - 1) {
        pos = temp.indexOf(acento12);

        temp = "" + (temp.substring(0, pos) + sn2 + temp.substring((pos + acento12.length), temp.length));
    }
    y.value = temp;

    while (temp.indexOf(acento13) >  - 1) {
        pos = temp.indexOf(acento13);

        temp = "" + (temp.substring(0, pos) + sn3 + temp.substring((pos + acento13.length), temp.length));
    }
    y.value = temp;

    while (temp.indexOf(acento14) >  - 1) {
        pos = temp.indexOf(acento14);

        temp = "" + (temp.substring(0, pos) + sn4 + temp.substring((pos + acento14.length), temp.length));
    }
    y.value = temp;

    while (temp.indexOf(acento15) >  - 1) {
        pos = temp.indexOf(acento15);

        temp = "" + (temp.substring(0, pos) + sn5 + temp.substring((pos + acento15.length), temp.length));
    }
    y.value = temp;

    while (temp.indexOf(acento16) >  - 1) {
        pos = temp.indexOf(acento16);

        temp = "" + (temp.substring(0, pos) + sn6 + temp.substring((pos + acento16.length), temp.length));
    }
    y.value = temp;

    while (temp.indexOf(acento17) >  - 1) {
        pos = temp.indexOf(acento17);

        temp = "" + (temp.substring(0, pos) + sn7 + temp.substring((pos + acento17.length), temp.length));
    }
    y.value = temp;

    while (temp.indexOf(acento18) >  - 1) {
        pos = temp.indexOf(acento18);

        temp = "" + (temp.substring(0, pos) + sn8 + temp.substring((pos + acento18.length), temp.length));
    }
    y.value = temp;

    while (temp.indexOf(acento19) >  - 1) {
        pos = temp.indexOf(acento19);

        temp = "" + (temp.substring(0, pos) + sn9 + temp.substring((pos + acento19.length), temp.length));
    }
    y.value = temp;

    while (temp.indexOf(acento20) >  - 1) {
        pos = temp.indexOf(acento20);
        temp = "" + (temp.substring(0, pos) + sn + temp.substring((pos + acento20.length), temp.length));
    }
    y.value = temp;

    while (temp.indexOf(acento21) >  - 1) {
        pos = temp.indexOf(acento21);

        temp = "" + (temp.substring(0, pos) + sn1 + temp.substring((pos + acento21.length), temp.length));
    }
    y.value = temp;

    while (temp.indexOf(acento22) >  - 1) {
        pos = temp.indexOf(acento22);

        temp = "" + (temp.substring(0, pos) + sn2 + temp.substring((pos + acento22.length), temp.length));
    }
    y.value = temp;

    while (temp.indexOf(acento23) >  - 1) {
        pos = temp.indexOf(acento23);

        temp = "" + (temp.substring(0, pos) + sn3 + temp.substring((pos + acento23.length), temp.length));
    }
    y.value = temp;

    while (temp.indexOf(acento24) >  - 1) {
        pos = temp.indexOf(acento24);

        temp = "" + (temp.substring(0, pos) + sn4 + temp.substring((pos + acento24.length), temp.length));
    }
    y.value = temp;

    while (temp.indexOf(acento25) >  - 1) {
        pos = temp.indexOf(acento25);

        temp = "" + (temp.substring(0, pos) + sn5 + temp.substring((pos + acento25.length), temp.length));
    }
    y.value = temp;

    while (temp.indexOf(acento26) >  - 1) {
        pos = temp.indexOf(acento26);

        temp = "" + (temp.substring(0, pos) + sn6 + temp.substring((pos + acento26.length), temp.length));
    }
    y.value = temp;

    while (temp.indexOf(acento27) >  - 1) {
        pos = temp.indexOf(acento27);

        temp = "" + (temp.substring(0, pos) + sn7 + temp.substring((pos + acento27.length), temp.length));
    }
    y.value = temp;

    while (temp.indexOf(acento28) >  - 1) {
        pos = temp.indexOf(acento28);

        temp = "" + (temp.substring(0, pos) + sn8 + temp.substring((pos + acento28.length), temp.length));
    }
    y.value = temp;

    while (temp.indexOf(acento29) >  - 1) {
        pos = temp.indexOf(acento29);

        temp = "" + (temp.substring(0, pos) + sn9 + temp.substring((pos + acento29.length), temp.length));
    }
    y.value = temp;

    while (temp.indexOf(acento30) >  - 1) {
        pos = temp.indexOf(acento30);
        temp = "" + (temp.substring(0, pos) + sn + temp.substring((pos + acento30.length), temp.length));
    }
    y.value = temp;

    while (temp.indexOf(acento31) >  - 1) {
        pos = temp.indexOf(acento31);

        temp = "" + (temp.substring(0, pos) + sn1 + temp.substring((pos + acento31.length), temp.length));
    }
    y.value = temp;

    while (temp.indexOf(acento32) >  - 1) {
        pos = temp.indexOf(acento32);

        temp = "" + (temp.substring(0, pos) + sn2 + temp.substring((pos + acento32.length), temp.length));
    }
    y.value = temp;

    while (temp.indexOf(acento33) >  - 1) {
        pos = temp.indexOf(acento33);

        temp = "" + (temp.substring(0, pos) + sn3 + temp.substring((pos + acento33.length), temp.length));
    }
    y.value = temp;

    while (temp.indexOf(acento34) >  - 1) {
        pos = temp.indexOf(acento34);

        temp = "" + (temp.substring(0, pos) + sn4 + temp.substring((pos + acento34.length), temp.length));
    }
    y.value = temp;

    while (temp.indexOf(acento35) >  - 1) {
        pos = temp.indexOf(acento35);

        temp = "" + (temp.substring(0, pos) + sn5 + temp.substring((pos + acento35.length), temp.length));
    }
    y.value = temp;

    while (temp.indexOf(acento36) >  - 1) {
        pos = temp.indexOf(acento36);

        temp = "" + (temp.substring(0, pos) + sn6 + temp.substring((pos + acento36.length), temp.length));
    }
    y.value = temp;

    while (temp.indexOf(acento37) >  - 1) {
        pos = temp.indexOf(acento37);

        temp = "" + (temp.substring(0, pos) + sn7 + temp.substring((pos + acento37.length), temp.length));
    }
    y.value = temp;

    while (temp.indexOf(acento38) >  - 1) {
        pos = temp.indexOf(acento38);

        temp = "" + (temp.substring(0, pos) + sn8 + temp.substring((pos + acento38.length), temp.length));
    }
    y.value = temp;

    while (temp.indexOf(acento39) >  - 1) {
        pos = temp.indexOf(acento39);

        temp = "" + (temp.substring(0, pos) + sn9 + temp.substring((pos + acento39.length), temp.length));
    }
    y.value = temp;

}
