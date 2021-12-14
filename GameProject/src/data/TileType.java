package data;

public enum TileType {
	
	Grass("grasstex", true), Dirt("dirttex", false), Water("watertex", false), Lava("lavatex", false), Ice("icetex", true), NULL("watertex", false);
	
	String textureName;
	boolean buildable;
	
	TileType(String textureName, boolean buildable) {
		this.textureName = textureName;
		this.buildable = buildable;
	}

}
