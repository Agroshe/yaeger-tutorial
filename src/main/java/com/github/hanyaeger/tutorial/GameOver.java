package com.github.hanyaeger.tutorial;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.scenes.StaticScene;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class GameOver extends StaticScene  {
    private Waterworld waterworld;

    public GameOver(Waterworld waterworld){
        this.waterworld = waterworld;
    }
    @Override
    public void setupScene(){
        setBackgroundImage("backgrounds/background1.jpg");

    }

    @Override
    public void setupEntities() {
        var gameOverText = new TextEntity(
                new Coordinate2D(getWidth() / 2, getHeight() / 2),
                "Game Over"
        );
        var gameOverButton = new StartButton(
                new Coordinate2D(getWidth() / 2, getHeight() / 2 + 50),
                waterworld, "Play again"
        );
        gameOverText.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        gameOverText.setFill(Color.DARKBLUE);
        gameOverText.setFont(Font.font("Roboto", FontWeight.SEMI_BOLD, 80));
        gameOverButton.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        addEntity(gameOverText);
        addEntity(gameOverButton);
    }
}
