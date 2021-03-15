package net.runeduniverse.hexagon.data;

import java.util.Map;
import java.util.UUID;

public interface GridMap<DATA> extends Map<UUID, DATA> {

	default DATA get(long x, long y) {
		return this.get(new UUID(x, y));
	}

	default void put(long x, long y, DATA data) {
		this.put(new UUID(x, y), data);
	}

}
