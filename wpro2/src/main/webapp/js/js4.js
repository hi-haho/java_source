/** 서버에서 node를 설치해서 사용하는 것이 아닌이상 홀로 사용하지 않는다.
 *  웹 브라우저에 '소스보기'에서 볼 수 있다.
 */

let i = 0, tot = 0;
do {
	i++;
	tot += i;
}while(i < 10);

document.write(`<br> 합은 ${tot} `)