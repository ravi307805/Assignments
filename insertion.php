<?php
$title=$_POST['title'];
$price=$_POST['price'];
$author=$_POST['author'];
$con=mysqli_connect('localhost','root');
mysqli_select_db($con,'BRM_DB');
$q="INSERT INTO book(title,price,author)values('$title',$price,'$author')";
$status=mysqli_query($con,$q);
mysqli_close($con);
?>
<!DOCTYPE html>
<html>
<head>
<title> insertion </title>
</head>
<body>
<h1>book record management </h1>
<p><?php
  if($status==1)
	  echo "record inserted";
  else
	  echo "insertion failed";
  ?>
  </p>
  Do you want to insert more record ? <a href="insertform.php">click Here </a>
</body>
</html>