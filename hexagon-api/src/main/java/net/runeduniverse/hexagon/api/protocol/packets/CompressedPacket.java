package net.runeduniverse.hexagon.api.protocol.packets;

import lombok.Data;

@Data
public class CompressedPacket {
	private int length;
	private int dataLength;
	private int packetID;
	private byte[] data;
}