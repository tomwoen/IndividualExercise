function addAccount () {

    var $fname = $('#fname');
    var $lname = $('#lname');
    var $accNo = $('#accNo');
    var order = {
        firstName: $fname.val(),
        lastName: $lname.val(),
        accountNumber: $accNo.val(),
        
    }

    $.ajax({
        
        type: 'POST',
        url: '/accounts/json',
        data: order,
          
    });
}