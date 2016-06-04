package com.ezneuron.pezman.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.physics.box2d.Body;

/**
 * Created by batty on 6/1/2016.
 */
public class MovementComponent implements Component {
    public float speed = 3.6f;
    public Body body; // Create a rigid body via World Class ( Create an entity )

    public MovementComponent(Body body) {
        this.body = body;
    }
}
