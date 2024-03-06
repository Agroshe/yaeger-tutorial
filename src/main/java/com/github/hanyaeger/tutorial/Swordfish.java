package com.github.hanyaeger.tutorial;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;

public class Swordfish extends DynamicSpriteEntity implements SceneBorderCrossingWatcher {
    public Swordfish(Coordinate2D initialLocation) {
        super("sprites/swordfish.png", initialLocation);
        setMotion(2, 270d);
    }

    @Override
    public void notifyBoundaryCrossing(SceneBorder border) {
        setAnchorLocationX(getSceneWidth());
    }
}
