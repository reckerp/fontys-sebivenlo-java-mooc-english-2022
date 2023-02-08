/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asteroids;

import javafx.geometry.Point2D;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;
/**
 *
 * @author Paul Recker - 518962 - {@code p.recker@student.fontys.nl}
 */

public abstract class Character {

    private Polygon character;
    private Point2D movement;
    

    public Character(Polygon polygon, int x, int y) {
        character = polygon;
        character.setTranslateX(x);
        character.setTranslateY(y);

        movement = new Point2D(0, 0);
    }

    public Polygon getCharacter() {
        return character;
    }

    public void turnLeft() {
        character.setRotate(this.character.getRotate() - 5);
    }

    public void turnRight() {
        character.setRotate(this.character.getRotate() + 5);
    }

 public void move() {
    character.setTranslateX(this.character.getTranslateX() + this.movement.getX());
    character.setTranslateY(this.character.getTranslateY() + this.movement.getY());

    if (character.getTranslateX() < 0) {
        character.setTranslateX(this.character.getTranslateX() + AsteroidsApplication.WIDTH);
    }

    if (character.getTranslateX() > AsteroidsApplication.WIDTH) {
        character.setTranslateX(this.character.getTranslateX() % AsteroidsApplication.WIDTH);
    }

    if (character.getTranslateY() < 0) {
        character.setTranslateY(this.character.getTranslateY() + AsteroidsApplication.HEIGHT);
    }

    if (character.getTranslateY() > AsteroidsApplication.HEIGHT) {
        character.setTranslateY(this.character.getTranslateY() % AsteroidsApplication.HEIGHT);
    }
}

    public Point2D getMovement() {
        return movement;
    }

    public void setMovement(Point2D movement) {
        movement = movement;
    }
 
 

    public void accelerate() {
        double changeX = Math.cos(Math.toRadians(character.getRotate()));
        double changeY = Math.sin(Math.toRadians(character.getRotate()));

        changeX *= 0.01;
        changeY *= 0.01;

        movement = movement.add(changeX, changeY);
    }
    
    public boolean collide(Character other) {
    Shape collisionArea = Shape.intersect(character, other.getCharacter());
    return collisionArea.getBoundsInLocal().getWidth() != -1;
}
}