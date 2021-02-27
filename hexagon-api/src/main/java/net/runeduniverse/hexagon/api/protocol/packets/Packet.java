package net.runeduniverse.hexagon.api.protocol.packets;

import lombok.Data;

@Data
public class Packet {
	private int length;
	private int packetID;
	private byte[] data;
}
