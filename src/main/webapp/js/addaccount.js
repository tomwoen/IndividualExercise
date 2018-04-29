function add() {
    
    var firstname = document.getElementById("fname").value;
    var lastname = document.getElementById("lname").value;
    var accountname = document.getElementById("accNo").value;
    
    var xhttp = new XMLHttpRequest();
    
        if (this.readyState == 4 && this.status == 200) {
      xmlDoc = this.responseXML;
      txt = "";
      x = xmlDoc.getElementsByTagName("ARTIST");
      for (i = 0; i < x.length; i++) {
        txt = txt + x[i].childNodes[0].nodeValue + "<br>";
      }
        document.getElementById("receivedjson").innerHTML = txt;
    
      }

    xhttp.open("POST", "localhost:8080/accountapp/api/accounts/json", true);
    xhttp.send("{\"firstName\":\"" + firstname +"\",\"lastName\":\"" + lastname + "\",\"accountNumber\":\"" + accountname + "\"}");

    
}