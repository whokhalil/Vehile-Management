
$('document').ready(function() {

    $('.table #editButton').on('click', function(event) {
        event.preventDefault();
        var href = $(this).attr('href');

        $.get(href, function(supplier, status) {
            $('#txtIdEdit').val(supplier.id);
            $('#txtNameEdit').val(supplier.name);
            $('#ddLCountryEdit').val(supplier.countryid);
            $('#ddLStateEdit').val(supplier.stateid);
            $('#txtAddressEdit').val(supplier.address);
            $('#txtCityEdit').val(supplier.city);
            $('#txtPhoneEdit').val(supplier.phone);
            $('#txtMobileDetails').val(supplier.mobile);
            $('#txtEmailEdit').val(supplier.email);
            $('#txtWebsiteEdit').val(supplier.website);
            $('#txtDetailsEdit').val(supplier.details);
        });
        $('#editModal').modal();
    });

    $('.table #detailsButton').on('click', function(event) {
            event.preventDefault();

            var href = $(this).attr('href');

            $.get(href, function(supplier, status) {
                $('#txtIdDetails').val(supplier.id);
                $('#txtNameDetails').val(supplier.name);
                $('#ddLCountryDetails').val(supplier.countryid);
                $('#ddLStateDetails').val(supplier.stateid);
                $('#txtAddressDetails').val(supplier.address);
                $('#txtCityDetails').val(supplier.city);
                $('#txtPhoneDetails').val(supplier.phone);
                $('#txtMobileDetails').val(supplier.mobile);
                $('#txtEmailDetails').val(supplier.email);
                $('#txtWebsiteDetails').val(supplier.website);
                $('#txtDetailsDetails').val(supplier.details);
            });
            $('#detailsModal').modal();
         });

         $('table #deleteButton').on('click', function(event){
                 event.preventDefault();

                 var href = $(this).attr('href');

                 $('#confirmDeleteButton').attr('href', href);

                 $('#deleteModal').modal();

             });

});