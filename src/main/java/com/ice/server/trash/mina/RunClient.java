package com.ice.server.trash.mina;
//package com.ice.server.test.client;
//
//import java.util.Scanner;
//
//public class RunClient {
//
//	public static void main(String[] args) {
//		MinaClient client = new MinaClient("client" + System.currentTimeMillis());
//		if (client.connect()) {
//			Scanner scanner = new Scanner(System.in);
//			while (scanner.hasNext()) {
//				String nextString = scanner.next();
//				if ("exit".equals(nextString)) {
//					client.close();
//					scanner.close();
//					return;
//				}
//				client.send(nextString);
//			}
//			scanner.close();
//		}
//	}
//}
