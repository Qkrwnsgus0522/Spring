package day59;

public class LgTV implements TV {

	private Remote remote;
	
	@Override
	public void funcA() {
		remote.funcA();
		System.out.println("LgTV 전원 ON/OFF");
	}

	@Override
	public void funcB() {
		remote.funcB();
		System.out.println("LgTV 채널변경");
	}

}
