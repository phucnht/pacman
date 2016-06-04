package com.ezneuron.pezman;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.ezneuron.pezman.gameplay.GameController;
import com.ezneuron.pezman.gameplay.GameRenderer;

// Game Class implemente de ApplicationListener ( deleguer a une scene ) pour aiser a avoir plusieurs de scenes
public class PezmanMain extends Game {
    public SpriteBatch batch; // Combination de dessins, pour optimizer des methodes de dessiner

    @Override
    public void create() {
        batch = new SpriteBatch();
        setScreen(new GameRenderer(this)); // metter la scene actuelle
    }

    // Boucles d'evenement
    @Override
    public void render() {
        super.render();
    }

    // Quitter le jeu
    @Override
    public void dispose() {
        batch.dispose();
        GameController.instance.dispose();
    }
}
