## Add the Game Scene

Now that we have a TitleScene, lets add a Game Level. Since a level is typically a Scene that contains animated
Entities, we are going to extend a `DynamicScene`.

:computer: Add a scene called `GameLevel`, which extends a `DynamicScene`, to the `com.github.hanyaeger.tutorial.scenes`
package. Use the method `setupScene()` to set the background to the asset `background2.jpg` and the audio
to `waterworld.mp3`.

At this moment the level has not yet been added to the game. You have only created a new class, that needs to be
instantiated and added to the `YaegerGame`.

:computer: Use the `setupScenes()` from the `Waterworld`-class to add `GameLevel` to the game. Choose a wise `id`.

### Add a button to switch to the Game Scene

Although `GameLevel` has now been added to the Yaeger Game, there is no way to reach it yet. As said before, the first
added Scene is set as the active scene and that should be the `TitleScene`. To switch to `GameLevel`
you will need to call the method `setActiveScene(id)` on the `Waterworld` class.

To enable this, we are going to add a button to the `TitleScene`. Clicking the button will result in switching to
`GameLevel`. As said before, everything that should appear on a Scene is an Entity. For the button we are going to use
a `TextEntity` that will need to listen to mouse-clicks. Because of the latter, we can no longer use an inline
`TextEntity` as we did for the title. We are going to create a new Class, called `StartButton` that extends `TextEntity`
, and add all the required behaviour to this Class.

### Create and add the button

:computer: Create a new Class `StartButton` that extends `TextEntity` and place it in the package
`com.github.hanyaeger.tutorial.entities.buttons`. Use the following constructor:

```java
public StartButton(Coordinate2D initialLocation){
    super(initialLocation,"Play game");
    setFill(Color.PURPLE);
    setFont(HanFont.createDefaultCondensedFont(30));
}
```

As you will notice we use the text *Play Game*, set the color to *Purple* and use the condensed version of the HAN font.

:computer: Now use the `setupEntities()` from the `TitleScene` to add the `StartButton`. Place it at the center of the
screen, just below the title.

### Add behaviour to handle mouse clicks

In general, to expand the behaviour of an `Entity`, you should add the appropriate Interface to the `Entity`. To let
an `Entity` listen to mouse button clicks, the `Entity` should implement the Interface `MouseButtonPressedListener`.

:computer: Let `StartButton` implement the interface `MouseButtonPressedListener`.

When the user clicks on the `StartButton` the handler (`onMouseButtonPressed()`) is called. this handler should call
`setActiveScene()` on the `Waterworld` class, but this method is not available from the `TitleScene`. So lets pass the
instance of `Waterworld` to the `StartButton` and then call `setActiveScene()` from the mouse pressed handler.

:computer: Change the constructor of `TitleScene` to

```java
private Waterworld waterworld;

public TitleScene(Waterworld waterworld){
    this.waterworld=waterworld;
}
```

and supply an instance of `Waterworld` (notice the `this`) to the `TitleScene` in the `setupScenes` method:

```java
@Override
protected void setupScenes(){
    addScene(0, new TitleScene(this));
    addScene(1, new GameLevel());
}
```

:computer: Now do the same for the constructor of the `StartButton`. This constructor already has the location as a
parameter, so after this change it will have two parameters.

As the last step wel would like to add the following to the mouse button handler:

```java
@Override
public void onMouseButtonPressed(MouseButton button, double x, double y){
    waterworld.setActiveScene(1);
}
```

:arrow_forward: Run the game again. The TitleScene should now contain the title, and a start button. Clicking this start
button should switch the game to Game Level.

### Add more behaviour to make the button into a real button

The Button should work now, but it gives little visual feedback on its behaviour. We are going to add two more
interfaces to the `StartButton`, being the `MouseEnterListener` and `MouseExitListener`.

:computer: Add the interface `MouseEnterListener` and `MouseExitListener` and implement their handlers in the following
way:

```java
@Override
public void onMouseEntered(){
    setFill(Color.VIOLET);
    setCursor(Cursor.HAND);
}

@Override
public void onMouseExited(){
    setFill(Color.PURPLE);
    setCursor(Cursor.DEFAULT);
}
```

Notice how we change both the color of the `Entity` as the mouse cursor.