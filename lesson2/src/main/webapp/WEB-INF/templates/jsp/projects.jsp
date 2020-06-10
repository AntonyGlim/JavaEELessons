<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>projects</title>
</head>
<body>
    <h1>projects</h1>
    <c:forEach var="project" items="${requestScope.projects}">
        <p><c:out value="${project.title}"/></p>
        <p><c:out value="${project.description}"/></p>
        <p><c:out value="${project.timeStart}"/></p>
    </c:forEach>

<%--    <% List<Project> projects = (ArrayList) request.getAttribute("projects"); %>--%>
<%--    --%>
<%--    <%for (Project project : projects) {%>--%>
<%--            <p><%= project.getTitle() %></p>--%>
<%--            <p><%= project.getDescription() %></p>--%>
<%--            <p><%= project.getTimeStart() %></p>--%>
<%--    <%}%>--%>
</body>
</html>
