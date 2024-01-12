<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>sns회원가입</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>
</head>
<body>
	<div id="wrap" class="container">
		<header>
			<h2 class="bg-dark">Marondalgram</h2>
		</header>
		<section>
			<h1>회원 가입</h1>
			<div class="">
			<form action="" method="get">
				<span>ID</span>
				<div class="d-flex">
				<input type="text" name="id" class="form-control col-4" placeholder="ID를 입력해주세요">
				<button type="button" id="duplicationBtn" class="btn btn-info">중복확인</button>
				</div>
				<span>password</span>
				<input type="password" name="password" class="form-control col-4">
				<span>contirm password</span>
				<input type="password" name="contirmPassword" class="form-control col-4">
				<span>이름</span>
				<input type="text" name="name" class="form-control col-4" placeholder="이름을 입력해주세요">
				<span>이메일</span>
				<input type="text" name="email" class="form-control col-4" placeholder="이메일을 입력해주세요">
				<button type="submit" class="btn btn-info">가입하기</button>
			</form>	
			</div>
		</section>
	</div>
</body>
</html>