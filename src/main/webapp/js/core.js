/**
 * javascript that makes the login and registration go up and down
 * 
 * @type type
 */
function hideLogin()
{
    $(document).ready(function ()
    {
        $('#login').hide();
    }); // end ready
}

function showLogin()
{
    $(document).ready(function ()
    {
        $('#login').slideDown();
    }); // end ready
}

function loginDropdown()
{
    $(document).ready(function ()
    {
        $('#login').slideDown();
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
}