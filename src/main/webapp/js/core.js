$(document).ready(function ()
{

//  ####  Login  ####
    $('#openLogin').click(function (evt)
    {
        evt.preventDefault();
        $('#login form').slideToggle(300);
        $('#registerButton').slideToggle(300);
        $(this).toggleClass('closing');
    }); // end click

//  ####  Registration  ####
    $('#registerButton').click(function (evt)
    {
        $('#registerDiv form').slideToggle(300);
        $('#openLogin').toggleClass('closing');
    }); // end click

    $('#sendRegisterButton').click(function ()
    {
        $('#openLogin').toggleClass('closing');
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

}); // end ready
