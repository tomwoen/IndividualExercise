$(function () {

    var $accounts = $('#accounts');

    $.ajax({
        url: '/accountapp/api/accounts/json',
        type: 'GET',
        success: function (accounts) {
            console.log('success');
            $.each(accounts, function (i, account) {

                $accounts.append('<li> ID: ' + account.ID + ' firstname: ' + account.firstName + ' lastname: ' + account.lastName + ' accountnumber: ' + account.accountNumber + '</li>');

            });

        },
        error: function () {

            alert("Cannot load data")
        }

    });
});