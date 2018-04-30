function updateAccount () {

    var $accId = $("#accid");
    var $fname = $("#fname");
    var $lname = $("#lname");
    var $accNo = $("#accno");

    var order = {
        
        "ID" : $accId.val(),
        "firstName": $fname.val(),
        "lastName": $lname.val(),
        "accountNumber": $accNo.val(),
        
    }

    $.ajax({
        
        type: 'POST',
        url: '/accountapp/api/accounts/json/' + $accId.val(),
        data: JSON.stringify(order),
        
        success: function() {
        alert('Account Successfully Updated');
        location.reload();
        
        },
        
        error: function() {
            
            alert('Adding account failed' + '/accountapp/api/accounts/json/' + $accId.val());
        }
        });
          
    
}