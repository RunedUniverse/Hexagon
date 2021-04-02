package net.runeduniverse.hexagon.items;

import lombok.Getter;
import net.runeduniverse.hexagon.data.NamespacedKey;

@Getter
public enum Material implements IMaterial {
	STONE("stone");
	
	private NamespacedKey key;
	
	private Material(String key) {
		this.key = new NamespacedKey("minecraft", key);
	}
}
