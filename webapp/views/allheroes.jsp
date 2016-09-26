<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="myApp">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Heroes</title>
	<link href="<c:url value="/resources/css/all.css" />" rel="stylesheet">
  </head>
  <body ng-controller="HeroController as ctrl">
    <hero ng-repeat="item in ctrl.heroes" h=item></hero>
	
	<script src="<c:url value='/resources/js/lib/jquery-1.12.2.min.js' />"></script>
	<script src="<c:url value='/resources/js/lib/angular.js' />"></script>
    <script src="<c:url value='/resources/js/directives/hero.js' />"></script>
    <script src="<c:url value='/resources/js/app.js' />"></script>
    <script src="<c:url value='/resources/js/controller/heroController.js' />"></script>
    <script src="<c:url value='/resources/js/service/puzzleService.js' />"></script>
  </body>
</html>