
$('document').ready(function() {

    $('.table #editButton').on('click', function(event) {
        event.preventDefault();

        var href = $(this).attr('href');

        $.get(href, function(contact, status) {
            $('#idEdit').val(contact.id);
            $('#firstNameEdit').val(contact.firstname);
            $('#lastNameEdit').val(contact.lastname);
            $('#phoneEdit').val(contact.phone);
            $('#emailEdit').val(contact.email);
            $('#mobileEdit').val(contact.mobile);
            $('#remarksEdit').val(contact.remarks);
        });
        $('#editModal').modal();
    });

    $('.table #detailsButton').on('click', function(event) {
        event.preventDefault();

        var href = $(this).attr('href');

        $.get(href, function(location, status) {
            $('#idDetails').val(location.id);
            $('#descriptionDetails').val(location.description);
            $('#ddLCountryDetails').val(location.countryid);
            $('#ddLStateDetails').val(location.stateid);
            $('#cityDetails').val(location.city);
            $('#addressDetails').val(location.address);
            $('#lastModifiedByDetails').val(state.lastModifiedBy);
          //$('#lastModifiedDateDetails').val(state.lastModifiedDate.substr(0,19).replace("T", " "));
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