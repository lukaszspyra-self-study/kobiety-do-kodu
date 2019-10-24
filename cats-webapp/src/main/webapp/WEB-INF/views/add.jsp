<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Add Cat</title>
	</head>
	<body>
		<a href="list">Return to list of cats</a><br />
		<form method="POST">
			<table border="1">
				<tbody>
					<tr>
						<th>Imię</th>
						<td><input type="text" name="imie" /></td>
					</tr>
					<tr>
						<th>Data urodzenia</th>
						<td><input type="text" name="dataUrodzenia" /></td>
					</tr>
					<tr>
						<th>Waga</th>
						<td><input type="text" name="waga" /></td>
					</tr>
					<tr>
						<th>Imię opiekuna</th>
						<td><input type="text" name="imieOpiekuna" /></td>
					</tr>
					<tr>
						<td colspan="2" align="right"><input type="submit" value="Dodaj!" /></td>
					</tr>
				</tbody>
			</table>
		</form>
		<br />
		<hr />
		Uwaga! W kontekście użycia HTML oraz sposobu budowania stron, te rozwiązania są bardziej antyprzykładem niż materiałem do nauki!<br />
		Jeśli chciałabyś także tworzyć same widoki i pisac poprawny, dobrze skonstruowany kod HTML, zachęcamy do zapoznania się np. z frameworkiem <a href="http://getbootstrap.com" target="_blank">Bootstrap</a>.
	</body>
</html>