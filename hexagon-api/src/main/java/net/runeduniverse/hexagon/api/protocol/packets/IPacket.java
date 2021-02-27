package net.runeduniverse.hexagon.api.protocol.packets;

public interface IPacket {
	void fromByteData(byte[] data);

	byte[] toByteData();
}
