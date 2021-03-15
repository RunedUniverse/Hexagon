package net.runeduniverse.hexagon.data;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Dimension {
	@Getter
	private DimensionSettings settings;
	private GridMap<Region> regions = new GridHashMap<>();

	public Dimension(DimensionSettings settings) {
		this.settings = settings;
	}

	public Region getRegion(int regionX, int regionY) {
		return this.regions.get(regionX, regionY);
	}
}
