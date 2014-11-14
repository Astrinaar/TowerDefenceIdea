/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package input;

import build.BuildTool;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;

/**
 *
 * @author PK
 */
public class InputReceiver {

    private Input input;
    private BuildTool buildTool;

    public InputReceiver(BuildTool buildTool) {
        this.buildTool = buildTool;
    }

    public void reactToInput(GameContainer container, int delta) {
        input = container.getInput();
        universalInput(container);
        buildToolInput(container);
    }

    private void universalInput(GameContainer container) {
        if (input.isKeyPressed(Input.KEY_ESCAPE)) {
            container.exit();
        }
    }

    private void buildToolInput(GameContainer container) {
        buildTool.setHoveredOverTile(input.getMouseX(), input.getAbsoluteMouseY());
        if (input.isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
            buildTool.testTileBlock();
        }
    }
}
