$(document).ready(function ()
{

//  ####  Login  ####
    $('#open').click(function (evt)
    {
        evt.preventDefault();
        $('#login form').slideToggle(300);
        $('#registerButton').slideToggle(300);
        $(this).toggleClass('close');
    }); // end click

//  ####  Registration  ####
    $('#registerButton').click(function (evt)
    {
        $('#registerDiv form').slideToggle(300);
        $('#open').toggleClass('close');
    }); // end click

    $('#sendRegisterButton').click(function ()
    {
        $('#open').toggleClass('close');
    });


//  ####  Menues  ####
    $('.sm').smartmenus({
        showFunction: function ($ul, complete)
        {
            $ul.slideDown(250, complete);
        },
        hideFunction: function ($ul, complete)
        {
            $ul.slideUp(250, complete);
        }
    });

//  ####  Shopping Cart  ####
    $('#dashboard').click(
            function ()
            {
                // First anon function                    
                $(this).stop().animate(
                        {
                            top: '0',
                            backgroundColor: 'rgba(27,45,94,1)'},
                        1875, 'easeOutElastic'
                        ); // end animate

                // First anon function end               
            }, function ()
    {
        // Second anon function                    
        $(this).stop().animate(
                {
                    top: '-32px',
                    backgroundColor: 'rgb(255,211,224)'
                }, 1500, 'easeOutBounce'

                ); // end animate

        // Second anon function end               
    }
    ); // end click
}); // end ready
