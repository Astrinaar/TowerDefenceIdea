package build;

import level.Tile;
import level.TileMap;

/**
 *
 * @author Patrick
 */
public class BuildTool {

    private Tile hoveredOverTile;
    private TileMap tileMap;

    public BuildTool(TileMap tileMap) {
        this.tileMap = tileMap;
    }

    public void setHoveredOverTile(float x, float y) {
        hoveredOverTile = tileMap.getTileAtPoint(x, y);
    }

    public void testTileBlock() {
        if (hoveredOverTile != null) {
            hoveredOverTile.setBlocked(true);
            tileMap.updatePath();
        }
    }

}
