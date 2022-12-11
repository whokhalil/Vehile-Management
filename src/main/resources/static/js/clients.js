
$('document').ready(function() {

    $('.table #editButton').on('click', function(event) {
        event.preventDefault();

        var href = $(this).attr('href');

        $.get(href, function(clients, status) {
            $('#txtIdEdit').val(clients.id);
            $('#txtNameEdit').val(clients.name);
            $('#ddLCountryEdit').val(clients.countryid);
            $('#ddLStateEdit').val(clients.stateid);
            $('#txtAddressEdit').val(clients.address);
            $('#txtCityEdit').val(clients.city);
            $('#txtPhoneEdit').val(clients.phone);
            $('#txtMobileDetails').val(clients.mobile);
            $('#txtEmailEdit').val(clients.email);
            $('#txtWebsiteEdit').val(clients.website);
            $('#txtDetailsEdit').val(clients.details);
        });
        $('#editModal').modal();
    });

    $('.table #detailsButton').on('click', function(event) {
        event.preventDefault();

        var href = $(this).attr('href');

        $.get(href, function(clients, status) {
            $('#txtIdDetails').val(clients.id);
            $('#txtNameDetails').val(clients.name);
            $('#ddLCountryDetails').val(clients.countryid);
            $('#ddLStateDetails').val(clients.stateid);
            $('#txtAddressDetails').val(clients.address);
            $('#txtCityDetails').val(clients.city);
            $('#txtPhoneDetails').val(clients.phone);
            $('#txtMobileDetails').val(clients.mobile);
            $('#txtEmailDetails').val(clients.email);
            $('#txtWebsiteDetails').val(clients.website);
            $('#txtDetailsDetails').val(clients.details);
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