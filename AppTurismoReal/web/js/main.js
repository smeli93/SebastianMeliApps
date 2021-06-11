$(function(){

    $("#form-total").steps({
        headerTag: "h2",
        bodyTag: "section",
        transitionEffect: "fade",
        // enableAllSteps: true,
        autoFocus: true,
        transitionEffectSpeed: 500,
        titleTemplate : '<div class="title">#title#</div>',
        labels: {
            previous : 'Atras',
            next : 'Siguiente',
            finish : 'Confirmar',
            current : ''
        }
    });
    
    
    
});
