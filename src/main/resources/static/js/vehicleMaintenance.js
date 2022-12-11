
$('document').ready(function() {

    $('.table #editButton').on('click', function(event) {
        event.preventDefault();

        var href = $(this).attr('href');

        $.get(href, function(vehicleMaintenance, status) {
            $('#idEdit').val(vehicleMaintenance.id);
            $('#ddLVehicleEdit').val(vehicleMaintenance.vehicleid);

            var startDate = vehicleMaintenance.startDate.substr(0,10);
            var endDate = vehicleMaintenance.endDate.substr(0,10);

            $('#startDateEdit').val(startDate);
            $('#endDateEdit').val(endDate);

            $('#ddLSupplierEdit').val(vehicleMaintenance.supplierid);
            $('#priceEdit').val(vehicleMaintenance.price);
            $('#remarksEdit').val(vehicleMaintenance.remarks);
        });
        $('#editModal').modal();
    });

    $('.table #detailsButton').on('click', function(event) {
        event.preventDefault();

        var href = $(this).attr('href');

        $.get(href, function(vehicleMaintenance, status) {
            $('#idDetails').val(vehicleMaintenance.id);
                        $('#ddLVehicleDetails').val(vehicleMaintenance.vehicleid);

                        var startDate = vehicleMaintenance.startDate.substr(0,10);
                        var endDate = vehicleMaintenance.endDate.substr(0,10);

                        $('#startDateDetails').val(startDate);
                        $('#endDateDetails').val(endDate);

                        $('#ddLSupplierDetails').val(vehicleMaintenance.supplierid);
                        $('#priceDetails').val(vehicleMaintenance.price);
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