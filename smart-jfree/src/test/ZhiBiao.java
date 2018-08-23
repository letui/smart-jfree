package test;

import org.jfreehelper.annotation.IdentityField;
import org.jfreehelper.annotation.ValueField;

public class ZhiBiao {
	@IdentityField
	private String name;
	@ValueField(description = "年龄",pageValue="age")
	private double age;
	@ValueField(description = "财富",pageValue="money")
	private double money;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getAge() {
		return age;
	}
	public void setAge(double age) {
		this.age = age;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	public ZhiBiao(String name, double age, double money) {
		super();
		this.name = name;
		this.age = age;
		this.money = money;
	}
	@Override
	public String toString() {
		return "ZhiBiao [name=" + name + ", age=" + age + ", money=" + money
				+ "]";
	}
	
	
}
