package rbd.net;

import java.io.*;
import java.net.*;

public class Net {
	public static void main(String args[]) {
		try {
			URL url = new URL("https://www.lamborghini.com/ru-en/%D0%BC%D0%BE%D0%B4%D0%B5%D0%BB%D0%B8/aventador/aventador-lp-780-4-ultimae-roadster");
			System.out.println("Protocol: " + url.getProtocol());
			System.out.println("File name: " + url.getFile());
			System.out.println("Host: " + url.getHost());
			System.out.println("Path: " + url.getPath());
			System.out.println("Port: " + url.getPort());
			System.out.println("Default Port: " + url.getDefaultPort());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
}
