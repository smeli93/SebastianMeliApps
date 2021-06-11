
$(document).ready(function () {
    $('#rut').change(function () {

        var myuser = $('#rut').val();
        $.ajax({
            type: 'POST',
            data: {rut: myuser},
            url: 'validarUsuario',
            success: function (result) {
                var data = result;
                var txtRut = document.getElementById("rut");

                if (myuser === "") {
                    $('#error2').css("background", "url()");
                    $('#comprobar').html("");
                    txtRut.style.borderColor = "";

                } else if (data === "si") {
                    $('#error2').css("background", "url(images/check-.png)");
                    $('#comprobar').html("Usuario ya registrado");
                    $('#testeo').val("Usuario ya registrado");
                    document.getElementById("rut").focus();

                    txtRut.style.borderColor = "#e4442c";
                } else {
                    $('#error2').css("background", "url(images/check.png)");
                    $('#comprobar').html("Usuario Disponible");
                    $('#testeo').val("Usuario Disponible");
                    txtRut.style.borderColor = "#97a800";
                }



            }
        });
    });
});

//function checkRut(rut) {
//
//    // Despejar Puntos
//    var valor = rut.value.replace('.', '');
//    // Despejar Guión
//    valor = valor.replace('-', '');
//    // Aislar Cuerpo y Dígito Verificador
//    cuerpo = valor.slice(0, -1);
//    dv = valor.slice(-1).toUpperCase();
//    // Formatear RUN
//    rut.value = cuerpo + '-' + dv
//
//    // Si no cumple con el mínimo ej. (n.nnn.nnn)
//    if (cuerpo.length < 7) {
//        rut.setCustomValidity("RUT Incompleto");
//        return false;
//    }
//
//    // Calcular Dígito Verificador
//    suma = 0;
//    multiplo = 2;
//    // Para cada dígito del Cuerpo
//    for (i = 1; i <= cuerpo.length; i++) {
//
//        // Obtener su Producto con el Múltiplo Correspondiente
//        index = multiplo * valor.charAt(cuerpo.length - i);
//        // Sumar al Contador General
//        suma = suma + index;
//        // Consolidar Múltiplo dentro del rango [2,7]
//        if (multiplo < 7) {
//            multiplo = multiplo + 1;
//        } else {
//            multiplo = 2;
//        }
//
//    }
//
//    // Calcular Dígito Verificador en base al Módulo 11
//    dvEsperado = 11 - (suma % 11);
//    // Casos Especiales (0 y K)
//    dv = (dv == 'K') ? 10 : dv;
//    dv = (dv == 0) ? 11 : dv;
//    // Validar que el Cuerpo coincide con su Dígito Verificador
//    if (dvEsperado != dv) {
//        rut.setCustomValidity("RUT Inválido");
//        return false;
//    }
//
//    // Si todo sale bien, eliminar errores (decretar que es válido)
//    rut.setCustomValidity('');
//}

function soloNumeros(e) {
    var key = window.Event ? e.which : e.keyCode
    return (key >= 48 && key <= 57)
}

function validarCampos(valor) {

    re = /^([\da-z_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/

    var testeo = document.getElementById("testeo").value;
    var tyc = document.getElementById("chkTyC").checked;
    var formulario = document.getElementById("agregarCliente");
    var pass_uno = document.getElementById("passUno").value;
    var pass_dos = document.getElementById("passDos").value;

    if (!re.exec(valor)) {
        toastr.warning("Debe ingresar un correo valido", "    Turismo Real ®    ", {

            "closeButton": false,
            "debug": false,
            "newestOnTop": false,
            "positionClass": "toast-bottom-right",
            "preventDuplicates": false,
            "onclick": null,
            "showDuration": "300",
            "hideDuration": "1000",
            "timeOut": "5000",
            "extendedTimeOut": "1000",
            "showEasing": "swing",
            "hideEasing": "linear",
            "showMethod": "fadeIn",
            "hideMethod": "fadeOut"

        });
        return false;

    } else if (testeo === "Usuario ya registrado") {
        document.getElementById("rut").focus();
        return false;
    } else if (!tyc) {
        toastr.warning("Debe aceptar los terminos y condiciones", "    Turismo Real ®    ", {

            "closeButton": false,
            "debug": false,
            "newestOnTop": false,
            "positionClass": "toast-bottom-right",
            "preventDuplicates": false,
            "onclick": null,
            "showDuration": "300",
            "hideDuration": "1000",
            "timeOut": "5000",
            "extendedTimeOut": "1000",
            "showEasing": "swing",
            "hideEasing": "linear",
            "showMethod": "fadeIn",
            "hideMethod": "fadeOut"

        });
        document.getElementById("chkTyC").focus();
        return false;
    } else {
        formulario.submit();
        return true;
    }
}

$(document).on('click', 'input:checkbox', getCheckedBox);

getCheckedBox();

function getCheckedBox() {

    var valor1 = 20000;
    var valor2 = 55000;
    var valor3 = 15000;
    var cont = 0;
    var totalPrecioDias = document.getElementById("total_precio_dias").value;


    var myTable = document.getElementById("detalleServicios");
    var rowCount = myTable.rows.length;
    for (var x = rowCount - 1; x > 0; x--) {
        myTable.deleteRow(x);
    }
    
    var myTable = document.getElementById("total_pagar");
    var rowCount = myTable.rows.length;
    for (var x = rowCount - 1; x > 0; x--) {
        myTable.deleteRow(x);
    }
    //$('#detalleServicios').empty();
    //$('#total_pagar').empty();

    var checkedBox = $.map($('input[name=chkServicio]:checked'),
            function (val, i) {
                return val.value;
            });

    if (checkedBox.length == 0) {
        $('#detalleServicios').append('<tr><td style="width: 500px; text-align: left">-</td> <td style="text-align: center">$0</td> </tr>');
    } else {

        checkedBox.forEach(function (element) {
            if (element == 1) {
                $('#detalleServicios').append('<tr><td style="width: 500px; text-align: left">Transporte</td> <td style="text-align: center">$' + valor1 + '</td> </tr>');
                cont = cont + valor1;
            } else if (element == 2) {
                $('#detalleServicios').append('<tr><td style="width: 500px; text-align: left">Turismo</td> <td style="text-align: center">$' + valor2 + '</td> </tr>');
                cont = cont + valor2;
            } else if (element == 3) {
                $('#detalleServicios').append('<tr><td style="width: 500px; text-align: left">Servicio de comida</td> <td style="text-align: center">$' + valor3 + '</td> </tr>');
                cont = cont + valor3;
            }
        })

    }

    $('#total_pagar').append('<tr><td style="width: 500px; text-align: left">SubTotal</td> <td style="text-align: center">$' + (parseInt(totalPrecioDias) + parseInt(cont)) + '</td> </tr>');
    $('#total_pagar').append('<tr><td style="width: 500px; text-align: left">IVA</td> <td style="text-align: center">$' + ((parseInt(totalPrecioDias) + parseInt(cont))*0.19)  + '</td> </tr>');
    $('#total_pagar').append('<tr><td style="width: 500px; text-align: left">Total a pagar</td> <td style="text-align: center">$' + (((parseInt(totalPrecioDias) + parseInt(cont))*0.19) + (parseInt(totalPrecioDias) + parseInt(cont)))  + '</td> </tr>');
}