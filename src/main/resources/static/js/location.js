
$('document').ready(function() {

    $('.table #editButton').on('click', function(event) {
        event.preventDefault();

        var href = $(this).attr('href');

        $.get(href, function(location, status) {
            $('#idEdit').val(location.id);
            $('#descriptionEdit').val(location.description);
            $('#ddLCountryEdit').val(location.countryid);
            $('#ddLStateEdit').val(location.stateid);
            $('#cityEdit').val(location.city);
            $('#addressEdit').val(location.address);
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