package net.runeduniverse.hexagon.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DimensionSettings {
	private int minHeight = 0;
	private int maxHeight = 256;
	private int maxBuildHeight = this.maxHeight;
}
