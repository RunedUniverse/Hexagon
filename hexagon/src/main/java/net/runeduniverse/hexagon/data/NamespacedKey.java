package net.runeduniverse.hexagon.data;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class NamespacedKey {

	private final String namespace;
	private final String key;

	@Override
	public String toString() {
		return this.namespace + ':' + this.key;
	}
}
