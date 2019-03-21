function createTable(headerNames, tableContent, tableID, boolMakeClickable)
{
//    creting fixpoint for table
    var table = document.getElementById(tableID);

    console.log("tableID: " + tableID);
    console.log("table: " + table);
    console.log("HeaderNames: " + headerNames);
    console.log("tableContent: " + tableContent);

//    creating header
    var thead = document.createElement('thead');
    var row = thead.insertRow(0);
    var cell;
    for (var i = 0; i < headerNames.length; i++)
    {
        cell = row.insertCell(i);
        cell.innerHTML = headerNames[i];
    }

    console.log(thead);

//    appending header to table
    table.appendChild(thead);

//    creating body of table
    var tbody = document.createElement('tbody');

//    rows
    for (var i = 0; i < tableContent.length; i++)
    {
        var tr = tbody.insertRow();
//        column
        for (var j = 0; j < tableContent[0].length; j++)
        {
            var indexCellValue = tableContent[i][0];
            var td = tr.insertCell(j);

//            if boolMakeClickable is true make cells clickable. Click will
//            send invoice_id value back to admin.jsp page
            if (boolMakeClickable)
            {
                if (j == 0)
                {
                    td.onclick = function ()
                    {
//                        var url = "FrontController?origin=admin&invoice_id=" + this.innerHTML;
//                        window.location.href = url;
                    };
                } else
                {
                    td.onclick = function ()
                    {
//                        var url = "control?origin=admin&invoice_id=" + this.previousElementSibling.innerHTML;
//                        window.location.href = url;
                    };
                }
            }
            td.appendChild(document.createTextNode(tableContent[i][j]));
            console.log(indexCellValue);
        }
    }

//    appending body to tables
    table.appendChild(tbody);

//    fixing styles
//    table
    table.classList.add('table', 'table-hover', 'table-condensed', 'table-striped', 'text-center');

//    head
    thead.classList.add('table');
    thead.style.color = 'white';
    thead.style.background = 'grey';

//    body
    tbody.classList.add('table-bordered');

    console.log(tbody);
}
