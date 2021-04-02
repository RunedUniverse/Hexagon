package net.runeduniverse.hexagon.data;

import java.util.HashMap;
import java.util.Map;

public class Chunk {
	private Map<Integer, SubChunk> subchunks = new HashMap<>();

	public SubChunk getSubChunk(int subchunkY) {
		return this.subchunks.get(subchunkY);
	}
}
