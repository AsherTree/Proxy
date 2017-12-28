package com.asher.main;

import java.lang.reflect.Proxy;


import com.asher.asher.invocation.InvocationProxy;
import com.asher.proxy.ComputerDemo;
import com.asher.proxy.imp.KeyBoard;


public class Main {
	public static void main(String[] args) {
		
		//  创建一个中介类
		
		InvocationProxy inver =new InvocationProxy(new KeyBoard());
		
		//加上这句将会产生一个$Proxy0.class文件，这个文件即为动态生成的代理类文件 
		
		System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles","true");
		
		//获取代理类实例
		
		ComputerDemo demo = (ComputerDemo) Proxy.newProxyInstance(ComputerDemo.class.getClassLoader(), new Class[]{ComputerDemo.class}, inver);
		
		//通过代理类对象调用代理类方法，实际上会到invoke方法调用 
		demo.playPanio();
		demo.importText();
	}
}
