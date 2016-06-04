package com.ezneuron.pezman.box2d;

import com.badlogic.gdx.math.Vector2;

/**
 * Created by batty on 6/2/2016.
 */
public class Box2DSteeringUtils {

    public static float vectorToAngle(Vector2 vector) {
        return (float) Math.atan2(-vector.x, vector.y);
    }

    public static Vector2 angleToVector(Vector2 outVector, float angle) {
        outVector.x = -(float) Math.sin(angle);
        outVector.y = (float) Math.cos(angle);

        return outVector;
    }
}
