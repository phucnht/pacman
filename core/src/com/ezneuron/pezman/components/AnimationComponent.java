package com.ezneuron.pezman.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.utils.IntMap;

/**
 * Created by batty on 6/1/2016.
 */
public class AnimationComponent implements Component {
    public IntMap<Animation> animations = new IntMap<Animation>();
}
