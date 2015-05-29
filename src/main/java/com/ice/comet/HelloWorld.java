//package com.ice.comet;
//
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
//import javax.servlet.ServletContextEvent;
//import javax.servlet.ServletContextListener;
//
//import org.comet4j.core.CometConnection;
//import org.comet4j.core.CometContext;
//import org.comet4j.core.CometEngine;
//import org.comet4j.core.event.ConnectEvent;
//import org.comet4j.core.listener.ConnectListener;
//
//public class HelloWorld implements ServletContextListener {
//	private static final String CHANNEL = "hello";
//
//	public void contextInitialized(ServletContextEvent arg0) {
//		CometContext cc = CometContext.getInstance();
//		cc.registChannel(CHANNEL);// 注册应用的channel
//		Thread helloAppModule = new Thread(new HelloAppModule(), "Sender App Module");
//		helloAppModule.setDaemon(true);
//		helloAppModule.start();
//		CometContext.getInstance().getEngine().addConnectListener(new ConnectListener() {
//			@Override
//			public boolean handleEvent(ConnectEvent event) {
//				CometConnection conn = event.getConn();
//				CometContext.getInstance().getEngine().sendTo("hello", conn, "欢迎上线");
//				return false;
//			}
//		});
//	}
//
//	class HelloAppModule implements Runnable {
//
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//
//		public void run() {
////			while (true) {
////				try {
////					Thread.sleep(1000);
////				} catch (Exception ex) {
////					ex.printStackTrace();
////				}
////				System.out.println("连接数: "+CometContext.getInstance().getEngine().getConnections().size());
////				CometEngine engine = CometContext.getInstance().getEngine();
////				String message = sdf.format(new Date());
////				engine.sendToAll(CHANNEL, message);
////			}
//		}
//	}
//
//	public void contextDestroyed(ServletContextEvent arg0) {
//		System.out.println("HelloWorld.contextInitialized.......");
//	}
//}
