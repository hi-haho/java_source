

//변수 내보내기
export let user ='홍길동';

//json 형식의 자료 내보내기
const name ='사과';
const price =5000;
export let msg ={name,price};

//함수 내보내기
export function hi(user){
	return `안녕? ${user}님`;
}
export let func = function add(a, b){
	return a+b;
}

function f1(user){
	return `안녕? ${user}님`;
}
function f2(user){
	return `반가워 ${user}님`;
}
export{f1, f2} //2개 함수 내보내기

//default값 내보내기
//1회만 가능하다.
export default '졸려도 이겨내세요';


// 배열 내보내기
export let months=['5월','6월','7월'];

//상수 내보내기
export const Cur_YEAR =2024;
//클래스 내보내기
export class HelloClass{
	constructor(msg){
		this.msg = msg;
	};
	run(){
		console.log(this.msg+' run 메서드 실행');
	};
}

//동적으로 함수 내보내기 
export function haha(){
	//alert('안녕');
}
export function yoyo(){
	//alert('잘가');
}

