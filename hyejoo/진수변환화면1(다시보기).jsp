<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>반복문</title>
<script type="text/javascript">
function radixConvert() {
	// 공백 체크
	var sv = document.getElementsByName('sourceVal')[0].value;
	var radix = document.getElementById('selected');
	var radixTxt = radix.options[radix.selectedIndex].value;
	if(sv == "") {
		alert('값이 없습니다. 입력 필수');
		return;
	} else {
		if(typeof(sv) == "string") {
			var cv = new Number(sv);
			var ret = confirm('문자열입니다. 변환하시겠습니까?');
			if(ret == true) {
				if(radixTxt == "2") {
					document.getElementById('convertedVal').value = cv.toString(2);
				} else if(radixTxt == "16") {
					document.getElementById('convertedVal').value = cv.toString(16);
				} else {
					alert("지원하지 않는 진수를 선택하셨습니다.");
					return;
				}
			} else {
				alert('변환을 거부하셨습니다.');
				return;
			}
		} else {
			if(radixTxt == "2") {
				document.getElementByName('convertedVal')[0].value = cv.toString(2);
			} else if(radixTxt == "16") {
				document.getElementByName('convertedVal')[0].value = cv.toString(16);
			} else {
				alert("지원하지 않는 진수를 선택하셨습니다.");
				return;
			}			
		} 
	}
}
</script>

</head>
<body>

<table>
	<tr>
		<td><label>10진수</label></td>
		<td><input type="text" name="sourceVal" id="sourceVal" /></td>
	</tr>
	<tr>
		<td>
		<select name="language" id="selected">
		<option value="2">2진수</option>
		<option value="16">16진수</option>
		</select>
		</td>
		<td>
		<input type="text" name="convertedVal" id="convertedVal" />
		</td>
	</tr>	
	<tr>
	<td colspan="2"><input type="button" value="변환" onclick="radixConvert()" /></td>
	</tr>
</table>
</body>
</html>