<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title></title>
        <link href="<c:url value="/css/base.css" />" rel="stylesheet">
    </head>
<body>

	<h1>Spring Boot - File Upload</h1>

	<form method="POST" action="/upload" enctype="multipart/form-data">
		<input type="file" name="filex" /><br />
		<br /> <input type="submit" value="Submit" />
	</form>

</body>
</html>