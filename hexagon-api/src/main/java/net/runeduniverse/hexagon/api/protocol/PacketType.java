package net.runeduniverse.hexagon.api.protocol;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

public interface PacketType {
	int getPacketID();

	@RequiredArgsConstructor
	public enum Handshake implements PacketType {
		CLIENT_INITIATOR(0x00);

		@Getter
		final int packetID;
	}
}
