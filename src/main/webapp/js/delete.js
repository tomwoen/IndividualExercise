function deleteAccount () {

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
        
        type: 'DELETE',
        url: '/accountapp/api/accounts/json/' + $accId.val(),
        data: JSON.stringify(order),
        
        success: function() {
        alert('Account Successfully Deleted');
        location.reload();
        
        },
        
        error: function() {
            
            alert('Deleting account failed');
        }
        });
          
    
}