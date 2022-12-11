
$('document').ready(function() {

    $('.table #editButton').on('click', function(event) {
        event.preventDefault();

        var href = $(this).attr('href');

        $.get(href, function(vehicleHire, status) {
            $('#idEdit').val(vehicleHire.id);
            $('#ddlVehicleEdit').val(vehicleHire.vehicleid);
            $('#ddlClientEdit').val(vehicleHire.clientid);
            $('#ddlLocationEdit').val(vehicleHire.locationid);

            var DateIn = vehicleHire.dateIn.substr(0,10);
            var DateOut = vehicleMovement.dateOut.substr(0,10);

            $('#dateOutEdit').val(DateOut);
            $('#dateInEdit').val(DateIn);
            $('#timeOutEdit').val(vehicleHire.timeOut);
            $('#timeInEdit').val(vehicleHire.timeIn);
            $('#priceEdit').val(vehicleHire.price);
            $('#remarksEdit').val(vehicleHire.remarks);
        });
        $('#editModal').modal();
    });

    $('.table #detailsButton').on('click', function(event) {
        event.preventDefault();

        var href = $(this).attr('href');

        $.get(href, function(vehicleHire, status) {
            $('#idDetails').val(vehicleMovement.id);
            $('#ddlVehicleDetails').val(vehicleHire.vehicleid);
            $('#ddlClientDetails').val(vehicleHire.clientid);
            $('#ddlLocationDetails').val(vehicleHire.locationid);

            var DateIn = vehicleHire.dateIn.substr(0,10);
            var DateOut = vehicleMovement.dateOut.substr(0,10);

            $('#dateOutDetails').val(DateOut);
            $('#dateInDetails').val(DateIn);
            $('#timeOutDetails').val(vehicleHire.timeOut);
            $('#timeInDetails').val(vehicleHire.timeIn);
            $('#priceDetails').val(vehicleHire.price);
            $('#remarksDetails').val(vehicleHire.remarks);
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