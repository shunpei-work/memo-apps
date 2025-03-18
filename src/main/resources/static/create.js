/**
 * 
 */
 
// 入力チェック
function subForm() {
	// 変数の定義
	const title = document.getElementById('title').value;
	const isRight = true;
	
	// タイトルの入力チェック
	if(title === null || title === ''){
		document.getElementById('nullError').innerHTML = 'タイトルは必須入力です';
		isRight = false;
	} else {
		document.getElementById('nullError').innerHTML = '';
	}
	return isRight;
}
