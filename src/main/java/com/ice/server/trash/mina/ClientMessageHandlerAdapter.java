package com.ice.server.trash.mina;
//package com.ice.server.test.client;
//
//import org.apache.mina.core.service.IoHandlerAdapter;
//import org.apache.mina.core.session.IoSession;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//public class ClientMessageHandlerAdapter extends IoHandlerAdapter {
//	private final static Logger log = LoggerFactory.getLogger(ClientMessageHandlerAdapter.class);
//
//	private static String name;
//
//	public ClientMessageHandlerAdapter(String name) {
//		this.name = name;
//	}
//
//	public void messageReceived(IoSession session, Object message) throws Exception {
//		String content = message.toString();
//		log.info("receive : " + content);
//	}
//
//	public void messageSent(IoSession session, Object message) throws Exception {
//		log.debug("messageSent 客户端发送消息：" + message);
//	}
//
//	@Override
//	public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
//		log.debug("服务器发生异常： {}", cause.getMessage());
//	}
//
//	@Override
//	public void sessionCreated(IoSession session) throws Exception {
//		log.debug("创建一个新连接：{}", session.getRemoteAddress());
//		session.setAttribute("name", name);
//		session.write("name:" + session.getAttribute("name"));
//	}
//}
