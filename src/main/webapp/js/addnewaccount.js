function addAccount () {

    var $fname = $("#fname");
    var $lname = $("#lname");
    var $accNo = $("#accno");

    var order = {
        
        "firstName": $fname.val(),
        "lastName": $lname.val(),
        "accountNumber": $accNo.val(),
        
    }

    $.ajax({
        
        type: 'POST',
        url: '/accountapp/api/accounts/json',
        data: JSON.stringify(order),
        
        success: function() {
        alert('Account Successfully Added');
        location.reload();
        
        },
        
        error: function() {
            
            alert('Adding account failed');
        }
        });
          
    
}