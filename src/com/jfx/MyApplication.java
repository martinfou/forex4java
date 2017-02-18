package com.jfx;

import com.jfx.net.JFXServer;

public class MyApplication {

	public static void main(String[] args) throws InterruptedException {
		JFXServer.getInstance();
		System.out.println("Waiting for incomming connection" + JFXServer.getInstance().getBindHost() + " " + JFXServer.getInstance().getBindPort());
		Thread.sleep(Integer.MAX_VALUE);
	}

}
