package com.github.hanyaeger.tutorial.entities.buttons;

import com.github.hanyaeger.api.engine.entities.entity.Location;
import com.github.hanyaeger.api.engine.entities.entity.events.userinput.MouseButtonPressedListener;
import com.github.hanyaeger.api.engine.entities.entity.events.userinput.MouseEnterListener;
import com.github.hanyaeger.api.engine.entities.entity.events.userinput.MouseExitListener;
import com.github.hanyaeger.api.engine.entities.entity.shape.text.TextEntity;
import com.github.hanyaeger.tutorial.Waterworld;
import javafx.scene.Cursor;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class QuitButtonPressed extends TextEntity implements MouseButtonPressedListener, MouseEnterListener, MouseExitListener {

    private static final Color TEXT_COLOR = Color.YELLOWGREEN;
    private static final Color TEXT_COLOR_HIGHLIGHT = Color.GREENYELLOW;

    public static final String EXIT_GAME = "Exit game";
    private Waterworld waterworld;

    public QuitButtonPressed(Waterworld waterworld) {
        super(new Location(680, 400), EXIT_GAME);
        this.waterworld = waterworld;
        setFill(TEXT_COLOR);
        setFont(Font.font(Waterworld.FONT, FontWeight.BOLD, 30));
    }

    @Override
    public void onMouseButtonPressed(MouseButton button, double x, double y) {
        if (button.equals(MouseButton.PRIMARY)) {
            waterworld.quitGame();
        }
    }

    @Override
    public void onMouseEntered() {
        setFill(TEXT_COLOR_HIGHLIGHT);
        setCursor(Cursor.HAND);
    }

    @Override
    public void onMouseExited() {
        setFill(TEXT_COLOR);
        setCursor(Cursor.DEFAULT);
    }
}
