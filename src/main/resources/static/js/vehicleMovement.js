
$('document').ready(function() {

    $('.table #editButton').on('click', function(event) {
        event.preventDefault();

        var href = $(this).attr('href');

        $.get(href, function(vehicleMovement, status) {
            $('#idEdit').val(vehicleMovement.id);
            $('#ddLVehicleEdit').val(vehicleMovement.vehicleid);
            $('#ddLLocation1Edit').val(vehicleMovement.locationid1);
            $('#ddLLocation2Edit').val(vehicleMovement.locationid2);

            var Date1 = vehicleMovement.date1.substr(0,10);
            var Date2 = vehicleMovement.date2.substr(0,10);

            $('#Date1Edit').val(Date1);
            $('#Date2Edit').val(Date2);
            $('#remarksEdit').val(vehicleMaintenance.remarks);
        });
        $('#editModal').modal();
    });

    $('.table #detailsButton').on('click', function(event) {
        event.preventDefault();

        var href = $(this).attr('href');

        $.get(href, function(vehicleMovement, status) {
            $('#idDetails').val(vehicleMovement.id);
                        $('#ddLVehicleDetails').val(vehicleMovement.vehicleid);
                        $('#ddLLocation1Details').val(vehicleMovement.locationid1);
                        $('#ddLLocation2Details').val(vehicleMovement.locationid2);

                        var Date1 = vehicleMovement.date1.substr(0,10);
                        var Date2 = vehicleMovement.date2.substr(0,10);

                        $('#Date1Details').val(Date1);
                        $('#Date2Details').val(Date2);
                        $('#remarksDetails').val(vehicleMaintenance.remarks);
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