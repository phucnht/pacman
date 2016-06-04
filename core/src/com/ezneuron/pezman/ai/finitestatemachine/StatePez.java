package com.ezneuron.pezman.ai.finitestatemachine;


import com.badlogic.gdx.ai.fsm.State;
import com.badlogic.gdx.ai.msg.Telegram;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by batty on 6/3/2016.
 */
public class StatePez implements State<ObjectPez> {

    private static final float SPEED_THRESHOLD = 0.5f;

    private static void changeState(ObjectPez entity){
        Vector2 velocity = entity.pezComponent.getBody().getLinearVelocity();
    }

    @Override
    public void enter(ObjectPez entity) {
        entity.timer = 0;
    }

    @Override
    public void exit(ObjectPez entity) {
    }

    @Override
    public boolean onMessage(ObjectPez entity, Telegram telegram) {
        return false;
    }
}
