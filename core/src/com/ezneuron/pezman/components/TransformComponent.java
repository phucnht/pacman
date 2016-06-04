package com.ezneuron.pezman.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by batty on 6/1/2016.
 */
public class TransformComponent implements Component {
    public Vector2 pos = new Vector2(); // vector 2D (0,0)
    public Vector2 scl = new Vector2(1,1); // vector scale x = 1, y = 1;
    public int layer;
    public float rotation = 0;

    public TransformComponent(float x, float y) {
        this(x, y, 0); // always uses
    }

    public TransformComponent(float x, float y, int layer){
        this(x , y, layer, 1.0f, 1.0f, 0);
    }

    public TransformComponent(float x, float y, int layer, float sclX, float sclY, float rotation){
        pos.set(x,y);
        this.layer = layer;
        scl.set(sclX,sclY);
        this.rotation = rotation;
    }

    public TransformComponent(Vector2 pos, Vector2 scl, float rotation) {
        this.pos = pos;
        this.scl = scl;
        this.rotation = rotation;
    }
}
