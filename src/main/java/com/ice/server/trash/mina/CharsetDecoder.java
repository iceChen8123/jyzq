package com.ice.server.trash.mina;
//package com.ice.server.test.util;
//
//import java.nio.charset.Charset;
//
//import org.apache.mina.core.buffer.IoBuffer;
//import org.apache.mina.core.session.IoSession;
//import org.apache.mina.filter.codec.ProtocolDecoder;
//import org.apache.mina.filter.codec.ProtocolDecoderOutput;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//public class CharsetDecoder implements ProtocolDecoder {
//
//	private final static Logger log = LoggerFactory.getLogger(CharsetDecoder.class);
//
//	private final static Charset charset = Charset.forName("UTF-8");
//	// 可变的IoBuffer数据缓冲区
//	private IoBuffer buff = IoBuffer.allocate(100).setAutoExpand(true);
//
//	@Override
//	public void decode(IoSession session, IoBuffer in, ProtocolDecoderOutput out) throws Exception {
//		log.debug("#########decode#########");
//
//		// 如果有消息
//		while (in.hasRemaining()) {
//			// 判断消息是否是结束符，不同平台的结束符也不一样；
//			byte b = in.get();
//			if (isFinalString(b)) {
//				buff.flip();
//				byte[] bytes = new byte[buff.limit()];
//				buff.get(bytes);
//				String message = new String(bytes, charset);
//
//				buff = IoBuffer.allocate(100).setAutoExpand(true);
//
//				// 如果结束了，就写入转码后的数据
//				out.write(message);
//				// log.info("message: " + message);
//			} else {
//				buff.put(b);
//			}
//		}
//	}
//
//	// windows换行符（\r\n）就认为是一个完整消息的结束符了； UNIX 是\n；MAC 是\r
//	private boolean isFinalString(byte b) {
//		// return b == '\r\n' || b == '\n' || b == '\r';
//		return b == '\r';
//	}
//
//	@Override
//	public void dispose(IoSession session) throws Exception {
//		log.debug("#########dispose#########");
//		log.info(session.getCurrentWriteMessage().toString());
//	}
//
//	@Override
//	public void finishDecode(IoSession session, ProtocolDecoderOutput out) throws Exception {
//		log.debug("#########完成解码#########");
//	}
//
//}
