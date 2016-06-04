package com.ezneuron.pezman.components;

import com.badlogic.ashley.core.Component;

/**
 * Created by batty on 6/1/2016.
 */
public class GommeComponent implements Component {
    public boolean eaten;
    public boolean special;

    public GommeComponent(boolean isSpecial) {
        special = isSpecial;
        eaten = false;
    }
}

