$('document').ready(function() {

    $('.table #editButton').on('click', function(event) {
        event.preventDefault();

        var href = $(this).attr('href');

        $.get(href, function(vehicle, status) {
            $('#ddlVehicleTypeEdit').val(vehicle.vehicletypeid);
            $('#txtNameEdit').val(vehicle.name);
            $('#txtVehicleNumberEdit').val(vehicle.vehicleNumber);

            var registrationDate = vehicle.registrationDate.substr(0,10);
            $('#txtRegistrationDateEdit').val(registrationDate);

            $('#txtDescriptionEdit').val(vehicle.description);

            var AD = vehicle.acquisitionDate.substr(0,10);
            $('#txtADEdit').val(AD);

            $('#ddlVehicleMakeEdit').val(vehicle.vehiclemakeid);
            $('#ddlVehicleModelEdit').val(vehicle.vehiclemodelid);
            $('#ddlLocationEdit').val(vehicle.locationid);
            $('#txtPowerEdit').val(vehicle.power);
            $('#txtFuelCapacityEdit').val(vehicle.fuelCapacity);
            $('#txtNetWeightEdit').val(vehicle.netWeight);
            $('#txtRemarksEdit').val(vehicle.remarks);
            $('#ddlInChargeEdit').val(vehicle.employeeid);
            $('#ddlCurrentStatusEdit').val(vehicle.vehiclestatusid);
        });
        $('#editModal').modal();
    });

    $('.table #detailsButton').on('click', function(event) {
        event.preventDefault();

        var href = $(this).attr('href');

        $.get(href, function(vehicle, status) {
             $('#ddlVehicleTypeEdit').val(vehicle.vehicletypeid);
             $('#txtNameEdit').val(vehicle.name);
             $('#txtVehicleNumberEdit').val(vehicle.vehicleNumber);

             var registrationDate = vehicle.registrationDate.substr(0,10);
             $('#txtRegistrationDateEdit').val(registrationDate);

             $('#txtDescriptionEdit').val(vehicle.description);

             var AD = vehicle.acquisitionDate.substr(0,10);
             $('#txtADEdit').val(AD);

             $('#ddlVehicleMakeEdit').val(vehicle.vehiclemakeid);
             $('#ddlVehicleModelEdit').val(vehicle.vehiclemodelid);
             $('#ddlLocationEdit').val(vehicle.locationid);
             $('#txtPowerEdit').val(vehicle.power);
             $('#txtFuelCapacityEdit').val(vehicle.fuelCapacity);
             $('#txtNetWeightEdit').val(vehicle.netWeight);
             $('#txtRemarksEdit').val(vehicle.remarks);
             $('#ddlInChargeEdit').val(vehicle.employeeid);
             $('#ddlCurrentStatusEdit').val(vehicle.vehiclestatusid)
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