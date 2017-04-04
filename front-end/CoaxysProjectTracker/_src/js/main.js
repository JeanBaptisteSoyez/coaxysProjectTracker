
$(document).ready(function () {

    // Open forms in modal
    $('.modal-form').click(function (event) {

        event.preventDefault();
        let $modal = $('#main-modal');

        // Empty modal before showing
        $modal.find('.modal-header h4').text('Chargement');
        $modal.find('.modal-body').text('Veuilez patienter...');
        $modal.find('.modal-footer').text('');

        // Show and load modal content
        $modal.modal('show');
        $modal
            .find('.modal-content')
            .load($(event.currentTarget).attr('href'), function () {

                // Add client side validation
                $.validator.unobtrusive.parse($modal.find('form.async'));

                // Handle form submitting
                $modal.find('form.async :submit').click(function (event) {
                    event.preventDefault();

                    if ($modal.find('form.async').valid()) {
                        $modal.find('form.async').submit();
                    }
                })
            });

    });

});
