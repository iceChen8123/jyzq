package com.ice.server.test.server;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.mina.core.future.CloseFuture;
import org.apache.mina.core.future.IoFuture;
import org.apache.mina.core.future.IoFutureListener;
import org.apache.mina.core.service.IoHandler;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ServerMessageHandler implements IoHandler {

	private final static Logger log = LoggerFactory.getLogger(ServerMessageHandler.class);

	static AtomicInteger atomicInteger = new AtomicInteger(10000);

	@Override
	public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
		log.error("服务器发生异常： {}", cause);
	}

	@Override
	public void messageReceived(IoSession session, Object message) throws Exception {
		String content = message.toString();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String datetime = sdf.format(new Date());

		if (content.startsWith("name:")) {
			session.setAttribute("name", content.substring(content.indexOf("name:")));
			content = session.getAttribute("name") + "上线了。。。";
			log.info(content);
		}
		// 拿到所有的客户端Session
		Collection<IoSession> sessions = session.getService().getManagedSessions().values();
		// 向所有客户端发送数据
		for (IoSession sess : sessions) {
			if (!session.getAttribute("name").equals(sess.getAttribute("name"))) {
				log.info("分发消息： {}  --> {}", message, sess.getAttribute("name"));
				// sess.write(datetime + "\t" + content);
				sess.write(content);
			} else {
				log.debug("发送者 {}，不用分发该消息....", sess.getAttribute("name"));
			}
		}
	}

	@Override
	public void messageSent(IoSession session, Object message) throws Exception {
		log.debug("服务器发送消息： {}", message);
	}

	@Override
	public void sessionClosed(final IoSession session) throws Exception {
		log.debug("关闭当前session：{}#{}", session.getId(), session.getRemoteAddress());

		CloseFuture closeFuture = session.close(true);
		closeFuture.addListener(new IoFutureListener<IoFuture>() {
			public void operationComplete(IoFuture future) {
				if (future instanceof CloseFuture) {
					((CloseFuture) future).setClosed();
					log.info("{} 下线了....", session.getAttribute("name"));
				}
			}
		});
	}

	@Override
	public void sessionCreated(IoSession session) throws Exception {
		log.debug("创建一个新连接：{}", session.getRemoteAddress());
		session.write("welcome to the chat room !");
	}

	@Override
	public void sessionIdle(IoSession session, IdleStatus status) throws Exception {
		log.debug("当前连接{}处于空闲状态：{}", session.getRemoteAddress(), status);
	}

	@Override
	public void sessionOpened(IoSession session) throws Exception {
		log.debug("打开一个session：{}#{}", session.getId(), session.getBothIdleCount());
	}

}
