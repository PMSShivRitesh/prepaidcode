<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
 </head>
<body>
<div >

    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <form id="logoutForm" method="POST" action="${contextPath}/logout">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>

        <h2>Welcome ${pageContext.request.userPrincipal.name} | <a onclick="document.forms['logoutForm'].submit()">Logout</a></h2>

    </c:if>
    
    <table id="table" >
    <tr>
        <th>Name</th>
        <th>Email</th>
    </tr>
</table>
    

</div>
<!-- /container -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>

<script>


$.getJSON( "alluser", function( data ) {
	if(data){
        var len = data.length;
        var txt = "";
        if(len > 0){
            for(var i=0;i<len;i++){
                if(data[i].name && data[i].email){
                    txt += "<tr><td>"+data[i].name+"</td><td>"+data[i].email+"</td></tr>";
                }
            }
            if(txt != ""){
                $("#table").append(txt);
            }
        }
    }
	});


</script>
</body>
</html>