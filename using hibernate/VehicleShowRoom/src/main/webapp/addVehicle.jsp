
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <style><%@include file="/WEB-INF/css/style.css"%></style>
    <script type="text/javascript">
function myFun() {
	var selectBox = document.getElementById("vehicle_type");
    var val = selectBox.options[selectBox.selectedIndex].value;

    if(val === "sports"){
        document.getElementById("turbo_div").style.display='block';
        document.getElementById("engine_type").style.display='none';
        document.getElementById("weight_div").style.display='none';

        document.getElementById("engine_type").required=false;
        document.getElementById("weight").required=false;
        document.getElementById("turbo").required=true;
    }
    else if(val === "heavy"){
    	document.getElementById("turbo_div").style.display='none';
    	document.getElementById("engine_type").style.display='none';
  	    document.getElementById("weight_div").style.display='block';

  	    document.getElementById("turbo").required=false;
        document.getElementById("engine_type").required=false;
        document.getElementById("weight").required=true;
    }
    else if(val === "normal"){
    	document.getElementById("engine_type").style.display='block';
    	document.getElementById("turbo_div").style.display='none';
    	document.getElementById("weight_div").style.display='none';

    	document.getElementById("turbo").required=false;
        document.getElementById("weight").required=false;
        document.getElementById("engine_type").required=true;
    }
}
</script>
</head>
<body>
<h2>Give Vehicle's Info</h2>
<form action="addVehicleServlet" method="post">
    <div id="model_div">
        <input type="text" id="model_number" name="model_number" placeholder="Model Number" required="required">
    </div>

    <div id="vehicle_type_div">
        <select id="vehicle_type" name="vehicle_type" onchange="myFun()" required="required">
            <option value="">select vehicle type---</option>
            <option value="normal">Normal</option>
            <option value="heavy">Heavy</option>
            <option value="sports">Sports</option>
        </select>
    </div>

    <div id="engine_type_div">
        <select id="engine_type" name="engine_type" required="required">
            <option value="">select engine type---</option>
            <option value="oil">Oil</option>
            <option value="gas">Gas</option>
            <option value="diesel">Diesel</option>
        </select>
    </div>

    <div id="turbo_div">
        <label>Turbo type?</label>
        <select id="turbo" name="turbo" required="required">
            <option value="">select---</option>
            <option value="true">Yes</option>
            <option value="false">No</option>
        </select>
    </div>

    <div id="weight_div">
        <input type="number" id="weight" name="weight" placeholder="weight" min="1" required="required">
    </div>

    <div id="power_div">
        <input type="number" id="engine_power" name="engine_power" placeholder="power" min="1" required="required">
    </div>

    <div id="size_div">
        <input type="number" id="tire_size" name="tire_size" placeholder="size" min="1" required="required">
    </div>

    <input type="submit">
</form>

<%@include file="logout.jsp" %>
</body>
</html>