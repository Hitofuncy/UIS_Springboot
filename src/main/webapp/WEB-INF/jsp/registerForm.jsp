<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<body>
<form action="/upload" method="POST" enctype="multipart/form-data">
    <input type="file" name="file"/>
    <input type="submit" value="Upload"/>
</form>
</body>
</html>