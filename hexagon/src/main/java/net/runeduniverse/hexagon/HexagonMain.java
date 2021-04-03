package net.runeduniverse.hexagon;

import net.runeduniverse.hexagon.network.NettyController;

public class HexagonMain {

	private static HexagonMain instance;

	public static void main(String[] args) {
		HexagonMain.instance = new HexagonMain();
		HexagonMain.instance.startStandalone();
	}

	public void startStandalone() {
		new NettyController(25565).init().start();
	}

	public void startModule() {

	}

}
