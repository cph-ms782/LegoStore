$(document).ready(function ()
{
    $('#open').click(function (evt)
    {
        evt.preventDefault();
        $('#login form').slideToggle(300);
        $(this).toggleClass('close');
    }); // end click
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
    $('#dashboard').hover(
            function ()
            {
                // First anon function                    
                $(this).stop().animate(
                        {
                            left: '0',
                            backgroundColor: 'rgba(27,45,94,1)'},
                        1875, 'easeOutElastic'
                        ); // end animate

                // First anon function end               
            }, function ()
    {
        // Second anon function                    
        $(this).stop().animate(
                {
                    left: '-32px',
                    backgroundColor: 'rgb(255,211,224)'
                }, 1500, 'easeOutBounce'

                ); // end animate

        // Second anon function end               
    }
    ); // end hover
}); // end ready
