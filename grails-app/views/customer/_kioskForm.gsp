<div class="container">
    <div class="row">
        <div class="col-sm-12" align="center">
            <asset:image src="banner2.png" alt="Grails Logo" />
        </div>
    </div>
    <div class="row">
            <div class="col-sm-5 offset-1">
            <h4>${welcomeMessage}</h4>
            <p><h4>You have 3 points</h4></p>
        </div>
        <div class="col-sm-6">
            <g:textField name="phone" class="form-control" placeholder="Enter your cell number to check in" value="${customer?.phone}"/>
            <div class="row">
                <h4></h4>
            </div>
            <div class="row">
                <div class="col-sm-4">
                    <input class="btn btn-primary btn-lg btn-block" type="button" name="pad" value="1" onclick="padkey(this.value)">
                </div>
                <div class="col-sm-4">
                    <input class="btn btn-primary btn-lg btn-block" type="button" name="pad" value="2" onclick="padkey(this.value)">
                </div>
                <div class="col-sm-4">
                    <input class="btn btn-primary btn-lg btn-block" type="button" name="pad" value="3" onclick="padkey(this.value)">
                </div>
            </div>
            <div class="row">
                <h4></h4>
            </div>
            <div class="row">
                <div class="col-sm-4">
                    <input class="btn btn-primary btn-lg btn-block" type="button" name="pad" value="4" onclick="padkey(this.value)">
                </div>
                <div class="col-sm-4">
                    <input class="btn btn-primary btn-lg btn-block" type="button" name="pad" value="5" onclick="padkey(this.value)">
                </div>
                <div class="col-sm-4">
                    <input class="btn btn-primary btn-lg btn-block" type="button" name="pad" value="6" onclick="padkey(this.value)">
                </div>
            </div>
            <div class="row">
                <h4></h4>
            </div>
            <div class="row">
                <div class="col-sm-4">
                    <input class="btn btn-primary btn-lg btn-block" type="button" name="pad" value="7" onclick="padkey(this.value)">
                </div>
                <div class="col-sm-4">
                    <input class="btn btn-primary btn-lg btn-block" type="button" name="pad" value="8" onclick="padkey(this.value)">
                </div>
                <div class="col-sm-4">
                    <input class="btn btn-primary btn-lg btn-block" type="button" name="pad" value="9" onclick="padkey(this.value)">
                </div>
            </div>
            <div class="row">
                <h4></h4>
            </div>
            <div class="row">
                <div class="col-sm-4">
                    <!--<input class="btn btn-danger btn-lg btn-block" type="button" name="pad" value="Del" onclick="deletekey()">-->
                    <g:link class="btn btn-danger btn-lg btn-block" action="checkin">Del</g:link>
                </div>
                <div class="col-sm-4">
                    <input class="btn btn-primary btn-lg btn-block" type="button" name="pad" value="0" onclick="padkey(this.value)">
                </div>
                <div class="col-sm-4">
                    <!--<input class="btn btn-success btn-lg btn-block" type="button" name="pad" value="Go">-->
                    <g:submitButton class="btn btn-success btn-lg btn-block" name="submit">Go</g:submitButton>
                </div>
            </div>
        </div>
    </div>
</div>
<script>
function padkey(num) {
    var txt = document.getElementById("phone").value;
    txt = txt + num;
    document.getElementById("phone").value= txt;
}
function deletekey() {
    var txt = document.getElementById("phone").value;
    txt = txt.substring(0, txt.length-1);
    document.getElementById("phone").value= txt;
}
</script>