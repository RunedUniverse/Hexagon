package net.runeduniverse.hexagon.data;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Region {
	private GridMap<Chunk> chunks = new GridHashMap<>();

	public Chunk getChunk(int chunkX, int chunkY) {
		return this.chunks.get(chunkX, chunkY);
	}
}