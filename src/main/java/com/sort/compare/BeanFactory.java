package main.java.com.sort.compare;

public class BeanFactory {

	public BeanFactory(){
		
	}
	private Sort sort=null;
	public Sort getBean(Class clazz){
		try {
			sort=(Sort)clazz.newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sort;
	}
}
