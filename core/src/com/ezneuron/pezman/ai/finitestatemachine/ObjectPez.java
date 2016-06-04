package com.ezneuron.pezman.ai.finitestatemachine;

import com.badlogic.gdx.ai.fsm.DefaultStateMachine;
import com.badlogic.gdx.ai.fsm.StateMachine;
import com.badlogic.gdx.ai.msg.Telegram;
import com.badlogic.gdx.ai.msg.Telegraph;
import com.ezneuron.pezman.components.PezComponent;

/**
 * Created by batty on 6/3/2016.
 */
public class ObjectPez implements Telegraph {
    // receiver ou sender des messages
    public final PezComponent pezComponent;
    public final StateMachine<ObjectPez, StatePez> stateMachine;

    public float timer;

    public ObjectPez(PezComponent pezComponent) {
        this.pezComponent = pezComponent;
        stateMachine = new DefaultStateMachine<>(this);
        timer = 0;
    }

    public void update(float deltaTime) {
        timer += deltaTime;
        stateMachine.update();
    }

    @Override
    public boolean handleMessage(Telegram msg) {
        return stateMachine.handleMessage(msg);
    }
}
