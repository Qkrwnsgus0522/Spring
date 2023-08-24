package day59;

import org.springframework.stereotype.Component;

@Component("b")
public class RemoteB implements Remote {

	@Override
	public void funcA() {
		System.out.println("리모콘B");
	}

	@Override
	public void funcB() {
		System.out.println("리모콘B");
	}

}
