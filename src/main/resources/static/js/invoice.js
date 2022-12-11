
$('document').ready(function() {

    $('.table #editButton').on('click', function(event) {

        event.preventDefault();
        var href = $(this).attr('href');
        $.get(href, function(invoice, status) {
            $('#idEdit').val(invoice.id);
            $('#ddLClientEdit').val(invoice.clientid);

            var invoiceDate = invoice.invoiceDate.substr(0,10);
            $('#invoiceDateEdit').val(invoiceDate);

            $('#ddLInvoiceStatusEdit').val(invoice.invoicestatusid);
            $('#remarksEdit').val(invoice.remarks);
        });
        $('#editModal').modal();
     });

     $('.table #detailsButton').on('click', function(event) {
        event.preventDefault();
        var href = $(this).attr('href');
        $.get(href, function(invoice, status) {
            $('#idDetails').val(invoice.id);
            $('#ddLClientDetails').val(invoice.clientid);

            var invoiceDate = invoice.invoiceDate.substr(0,10);
            $('#invoiceDateDetails').val(invoiceDate);
            $('#ddLInvoiceStatusDetails').val(invoice.invoicestatusid);
            $('#remarksDetails').val(invoice.remarks);
        });
        $('#detailsModal').modal();
     });

     $('.table #deleteButton').on('click', function(event) {
        event.preventDefault();
        var href = $(this).attr('href');
        $('#confirmDeleteButton').attr('href', href);

        $('#deleteModal').modal();
     });
 });