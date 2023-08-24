package day59;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Client {

	public static void main(String[] args) {
		AbstractApplicationContext factory=new GenericXmlApplicationContext("applicationContext.xml");
		// 스프링 컨테이너 구동
		//  : 팩토리 패턴을 사용하고있어서, 객체명을 LookUp하여 객체반환이 가능!
		
		TV tv=(TV)factory.getBean("ss");
		tv.funcA();
		tv.funcB();
				
		/*
		TestBean tb=(TestBean)factory.getBean("tb");
		List<String> list=tb.getTestList();
		for(String v:list) {
			System.out.println(v);
		}
		
		TestBean2 tb2=(TestBean2)factory.getBean("tb2");
		Map<String,String> map=tb2.getTestMap();
		Set<String> set=map.keySet();
		for(String v:set) {
			System.out.print(v+" : ");
			System.out.println(map.get(v));
		}
		*/
		
		factory.close();
	}

}
