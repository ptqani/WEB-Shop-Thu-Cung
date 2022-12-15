<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:setLocale value="${sessionScope.lang}" />
<fmt:setBundle basename="i18n.messages" />
<!DOCTYPE html>
<html lang="vi_VN">
<head>
<meta charset="utf-8">
<title><fmt:message key="mess.login"></fmt:message></title>
</head>
<body>
<jsp:include page="login.jsp"></jsp:include>
</body>
</html>