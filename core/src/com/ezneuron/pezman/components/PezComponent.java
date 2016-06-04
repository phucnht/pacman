package com.ezneuron.pezman.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.physics.box2d.Body;
import com.ezneuron.pezman.ai.AIPez;
import com.ezneuron.pezman.ai.finitestatemachine.ObjectPez;
import com.ezneuron.pezman.ai.finitestatemachine.StatePez;

/**
 * Created by batty on 6/1/2016.
 */
public class PezComponent implements Component {
    public AIPez ai;
    public ObjectPez objectPez;

    private final Body body;

    public int currentState;
    public int hitpoints;
    public float idleTimer;

    public PezComponent(Body body) {
        this.body = body;
        ai = new AIPez(body);
        objectPez = new ObjectPez(this);
        objectPez.stateMachine.setInitialState(StatePez.IDLE_RIGHT);
        currentState = IDLE_RIGHT;
        hitpoints = 1;
        idleTimer = 0;
    }

    public Body getBody() {
        return body;
    }
}
