package com.github.hanyaeger.tutorial;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.DynamicScene;

public class GameLevel extends DynamicScene {
    @Override
    public void setupScene() {
        setBackgroundAudio("audio/waterworld.mp3");
        setBackgroundImage("backgrounds/background2.jpg");
    }

    @Override
    public void setupEntities() {
        var swordfish = new Swordfish(new Coordinate2D(getWidth() / 2, getHeight() / 2));
        var healthText = new HealthText(new Coordinate2D(0, 0));
        var hanny = new Hanny(new Coordinate2D(0, 0), healthText);

        addEntity(swordfish);
        addEntity(hanny);
        addEntity(healthText);
    }
}
