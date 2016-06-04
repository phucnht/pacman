package com.ezneuron.pezman.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Created by batty on 6/1/2016.
 */
public class TextureComponent implements Component {
    public TextureRegion textureRegion;

    public TextureComponent(TextureRegion textureRegion){
        this.textureRegion = new TextureRegion(textureRegion);
    }
}
