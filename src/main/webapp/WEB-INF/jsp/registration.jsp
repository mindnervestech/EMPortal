<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="captcha" uri="/WEB-INF/tlds/captcha.tld" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
  <head>
    <title>Register Facility</title>
    <link href="${pageContext.request.contextPath}/resources/app/bower_components/bootstrap-3.1.1/css/bootstrap.min.css" rel="stylesheet">
  </head>
  <body>
    <div class="container">
      <legend>Register Facility</legend>
      <c:if test="${not empty invalidCaptcha}">
      	<div class="col-sm-offset-3">
		  <p class="error" style="color: red;">${invalidCaptcha}</p>
		</div>
	  </c:if>
      <div class="container">
        <div class="heading">
          <form class="form-horizontal" method="post" action="${pageContext.request.contextPath}/saveFacilityByUser" role="form">
            <div class="well">
              <div class="form-group">
                <label for="inputEmail3" class="col-sm-2 control-label">Facility Name  <sup>*</sup></label>
                <div class="col-sm-4">
                  <input type="text" required="required" class="form-control" name="facilityName">
                </div>
              </div>
              <div class="form-group col-md-12">
                <label for="inputEmail3" class="col-sm-2 control-label">Contact Name <sup>*</sup></label>
                <div class="col-xs-2">
                  <select class="form-control col-md-1" name="salutation">
                    <option value="Mr.">Mr</option>
                    <option value="Mrs.">Mrs</option>
                  </select>
                </div>
                <div class="col-md-2">
                  <input type="text" required="required"  class="form-control" name="contactName" >
                </div>
              </div>
              <div class="form-group">
                <label for="inputEmail3" class="col-sm-2 control-label">Address 1  <sup>*</sup></label>
                <div class="col-sm-4">
                  <input type="text" required="required" class="form-control" name="address1">
                </div>
              </div>
              <div class="form-group">
                <label for="inputEmail3" class="col-sm-2 control-label">Address 2</label>
                <div class="col-sm-4">
                  <input type="text" class="form-control" name="address2">
                </div>
              </div>
              <div class="form-group">
                <label for="inputEmail3" class="col-sm-2 control-label">City  <sup>*</sup></label>
                <div class="col-sm-4">
                  <input type="text" required="required" class="form-control" name="city">
                </div>
              </div>
              <div class="form-group">
                <label for="inputEmail3" class="col-sm-2 control-label">State <sup>*</sup> </label>
                <div class="col-sm-4">
                  <input type="text" required="required" class="form-control" name="state">
                </div>
              </div>
              <div class="form-group">
                <label for="inputEmail3" class="col-sm-2 control-label">Country  <sup>*</sup></label>
                <div class="col-sm-4">
                  <select required="required" class="form-control" name="country">
                    <option value="Austrelia">Austrelia</option>
                    <option value="India">India</option>
                  </select>
                </div>
              </div>
              <div class="form-group">
                <label for="inputEmail3" class="col-sm-2 control-label">Zip Code  <sup>*</sup></label>
                <div class="col-sm-4">
                  <input type="text" required="required" class="form-control" name="zipCode">
                </div>
              </div>
              <div class="form-group">
                <label for="inputEmail3" class="col-sm-2 control-label">www.magicemr.com/ </label>
                <div class="col-sm-4">
                  <input type="text" required="required" name="relativeUrl" class="form-control">
                </div>
              </div>
              <div class="form-group">
                <label for="inputEmail3" class="col-sm-2 control-label">Web site </label>
                <div class="col-sm-4">
                  <input type="text" required="required" class="form-control" name="website">
                </div>
              </div>
              <div class="form-group">
                <label for="inputEmail3" class="col-sm-2 control-label">Email </label>
                <div class="col-sm-4">
                  <input type="email" required="required" class="form-control" name="email" required="required">
                </div>
              </div>
              <div class="form-group">
                <label for="inputEmail3" class="col-sm-2 control-label">Security Check </label>
                <div class="col-sm-4">
                  <captcha:captcha themeName="clean" publickey="6LcZv_QSAAAAALDkWLrXRCh3-wiqtkrdtrhC4CUi" privatekey="6LcZv_QSAAAAAMt9VPCr-_CJ4qusfezix657trSo"/>
                </div>
              </div>
              <div class="form-group">
                <label for="inputEmail3" class="col-sm-2 control-label">Terms and Condition </label>
                <div class="col-sm-4">
                  <textarea class="form-control" rows="3" readonly="readonly">Terms and conditions here</textarea>
                </div>
              </div>
              <div class="col-sm-offset-1 ">
                <label>
                	<input type="checkbox"> I agree to the magicEMR terms & condition
                </label>
              </div>
              <div class="form-group">
                <button type="submit" 
                  class="btn btn-primary col-sm-offset-1"> I'm done,please process my registration request</button>
                <a href="${pageContext.request.contextPath}/login" class="btn btn-info">Back</a>
              </div>
            </div>
          </form>
        </div>
      </div>
    </div>
  </body>
</html>