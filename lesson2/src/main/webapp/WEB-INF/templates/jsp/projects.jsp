<%@ page import="glim.antony.model.Project" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>projects</title>
</head>
<body>
    <h1>projects</h1>
    <% List<Project> projects = (ArrayList) request.getAttribute("projects"); %>
    <%for (Project project : projects) {%>
            <p><%= project.getTitle() %></p>
            <p><%= project.getDescription() %></p>
            <p><%= project.getTimeStart() %></p>
    <%}%>
</body>
</html>
