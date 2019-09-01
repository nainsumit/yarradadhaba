<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>Spring MVC Form Handling</title>
</head>
<body>
	<h2>Submitted Student Information</h2>
	${student}
	${person1}
	<br/>${test}
	<table>
		<tr>
			<td>Name</td>
			<td>${name1}</td>
		</tr>
		<tr>
			<td>Age</td>
			<td>${person.age}</td>
		</tr>
		<tr>
			<td>ID</td>
			<td>${person.id}</td>
		</tr>
	</table>
	
	<a href="session">link</a>
</body>