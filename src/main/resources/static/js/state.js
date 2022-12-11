
$('document').ready(function() {

    //For Editing the Existing details and getting these details by id(findByID)
    $('.table #editButton').on('click', function(event) {

        event.preventDefault();
        var href = $(this).attr('href');
        $.get(href, function(state, status) {
            $('#idEdit').val(state.id);
            $('#ddLCountryEdit').val(state.countryid);
            $('#capitalEdit').val(state.capital);
            $('#nameEdit').val(state.name);
            $('#codeEdit').val(state.code);
            $('#detailsEdit').val(state.details);
        });
        $('#editModal').modal();
    });

    $('.table #detailsButton').on('click', function(event) {
        event.preventDefault();
        var href = $(this).attr('href');
        $.get(href, function(state, status) {
            $('#idDetails').val(state.id);
            $('#ddLCountryDetails').val(state.countryid);
            $('#nameDetails').val(state.name);
            $('#detailsDetails').val(state.details);
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