package pack3;

// 1번
//public interface Ex22InterVol {
//	String vol = "볼륨";
//	void volUp(int v);
//	void volDown(int v);
//}

//2번 인터페이스간 상속이 가능하다.
public interface Ex22InterVol extends Ex22VolEtc{
	//2개의 추상메서드를 가져왔기에 4개의 메서드를 가지고있다.
	String vol = "볼륨";
	void volUp(int v);
	void volDown(int v);
}
