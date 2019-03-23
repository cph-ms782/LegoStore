/**
 * javascript that makes the login and registration go up and down
 * 
 * @type type
 */

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

}); // end ready
