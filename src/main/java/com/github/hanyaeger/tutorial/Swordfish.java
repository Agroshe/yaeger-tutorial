package com.github.hanyaeger.tutorial;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;

import java.util.List;
import java.util.Random;

public class Swordfish extends DynamicSpriteEntity implements SceneBorderCrossingWatcher, Collided, Collider {
    public Swordfish(Coordinate2D initialLocation) {
        super("sprites/swordfish.png", initialLocation);
        setMotion(2, 270d);
    }

    @Override
    public void notifyBoundaryCrossing(SceneBorder border) {
        setAnchorLocationX(getSceneWidth());
        setAnchorLocationY(new Random().nextInt((int) getSceneHeight()- 81));
    }

    @Override
    public void onCollision(List<Collider> collidingObjects) {
        System.out.println("Collision!");
    }
}
