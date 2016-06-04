package com.ezneuron.pezman.ai;

import com.badlogic.gdx.ai.utils.Location;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.ezneuron.pezman.box2d.Box2DLocation;
import com.ezneuron.pezman.box2d.Box2DSteeringUtils;


/**
 * Created by batty on 6/3/2016.
 */
public class AIPez implements Location<Vector2> {

    private final Body body;

    public AIPez(Body body) {
        this.body = body;
    }

    @Override
    public Vector2 getPosition() {
        return body.getPosition();
    }

    @Override
    public float getOrientation() {
        return body.getAngle(); // prendre la direction ( orientation ) a la quelle ce personnage est face.
    }

    @Override
    public void setOrientation(float orientation) {
        body.setTransform(getPosition(), orientation);
    }

    @Override
    public float vectorToAngle(Vector2 vector) {
        return Box2DSteeringUtils.vectorToAngle(vector); // l'angle avec elle le vecteur est pointe
    }

    @Override
    public Vector2 angleToVector(Vector2 outVector, float angle) {
        return Box2DSteeringUtils.angleToVector(outVector, angle); // le vecteur unite dans la direction creee par l'angle
    }

    @Override
    public Location<Vector2> newLocation() {
        return new Box2DLocation();
    }
}
