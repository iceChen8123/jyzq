package com.ice.server.test.server;

import java.io.IOException;
import java.net.InetSocketAddress;

import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.transport.socket.SocketAcceptor;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;

import com.ice.server.test.CharsetCodecFactory;

public class MinaServer {
	private SocketAcceptor acceptor;

	public MinaServer() {
		// 创建非阻塞的server端的Socket连接
		acceptor = new NioSocketAcceptor();
	}

	public boolean start() {
		DefaultIoFilterChainBuilder filterChain = acceptor.getFilterChain();
		// 添加编码过滤器 处理乱码、编码问题
		filterChain.addLast("codec", new ProtocolCodecFilter(new CharsetCodecFactory()));
		// filterChain.addLast("ThreadPool", new
		// ExecutorFilter(Executors.newCachedThreadPool()));
		// http://www.docin.com/p-669329549.html

		// 设置核心消息业务处理器
		acceptor.setHandler(new ServerMessageHandler());
		// 设置session配置，30秒内无操作进入空闲状态
		acceptor.getSessionConfig().setIdleTime(IdleStatus.BOTH_IDLE, 15);

		try {
			// 绑定端口3456
			acceptor.bind(new InetSocketAddress(3456));
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

}
