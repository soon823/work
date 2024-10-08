package chap07;

public class KunhoTire extends Tire {
	//필드
	
	//생성자
	public KunhoTire(String location, int maxRotation) {
		super(location, maxRotation);
	}
	
	//메소드
	@Override
	public boolean roll() {
		accRotation++;
		if(accRotation < maxRotation) {
			System.out.println(location + "KumhoTire 수명" + (maxRotation-accRotation) + "회");
			return true;
		}else {
			System.out.println("***" + location + "KumhoTire 펑크***");
			return false;
		}
	}
}
