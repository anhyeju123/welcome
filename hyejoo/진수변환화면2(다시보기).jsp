<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>반복문</title>
<script type="text/javascript">
// 공백체크하는 함수
function checkNull(firstParam) {
	return true/false;
}
// 문자열 확인 및 변환함수
function radixConvert(firstParam){
	return ret;
}
// 변환출력함수
function printResult(result:파라메터) {
	document.getElementById('convertedVal').value = result;	
}

//전체 메인
function main() {
	// 입력처리 부분: 입력값을 변수에 저장
	var chkFlag = checkNull(첫번째값:아규먼트);
	if(chkFlag == true) {
		var ret = radixConvert(첫번째값:아규먼트);
		printResult(ret:아규먼트);
	} else {
		alert();
		return;
	}
}
</script>
</head>
<body>
<table>
	<tr><td><label>10진수</label></td>
		<td><input type="text" name="sourceVal" id="sourceVal" /></td></tr>
	<tr><td>
	<select name="language" id="selected">
	<option value="2">2진수</option>
	<option value="16">16진수</option></select>
	</td>
	<td><input type="text" name="convertedVal" id="convertedVal" /></td></tr>	
	<tr><td colspan="2"><input type="button" value="변환" onclick="radixConvert()" /></td></tr>
</table>
</body>
</html>