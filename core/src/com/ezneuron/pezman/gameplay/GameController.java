package com.ezneuron.pezman.gameplay;

import com.badlogic.gdx.ai.utils.Location;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Disposable;

/**
 * Created by batty on 6/1/2016.
 */
public class GameController implements Disposable {
    // Instance
    public static final GameController instance = new GameController();

    // La position initiale des personnages
    public Vector2 ghostInitPos;
    public Vector2 pezInitPos;

    // Nombre de gommes
    public int totalGommes = 0;

    // Les scores
    public int score = 0; // score actuel
    public int highScore = 0;
    public int displayScore = 0;
    public int displayHighscore = 0;

    // Le nombre de vie
    public int pezLives = 4;

    // Les statuts du jeu
    public boolean pezIdle = true;
    public boolean pezAlive = true;
    public boolean specGommeEaten = false;
    private boolean gameOver = false;

    // Appel de stock "asset"
    public AssetManager assetManager;

//     public AStartPathFinding pathfinder;
//
//     public Location<Vector2> playerLocation;

    // Charger le stock d'images et de sons - Constructeur
    private GameController() {
        // Charge
        assetManager = new AssetManager();
        assetManager.load("images/actors.pack", TextureAtlas.class); // images
        assetManager.load("sounds/gomme.ogg", Sound.class); // son de manger des gommes
        assetManager.load("sounds/gomme-spec.ogg", Sound.class); // son de manger des gommes spéciaux
        assetManager.load("sounds/clear.ogg", Sound.class); // son de fin
        assetManager.load("sounds/ghost-die.ogg", Sound.class); // son de deces des fantome
        assetManager.load("sounds/pezman-die.ogg", Sound.class); // son de deces du pezman

        // Fin de charge
        assetManager.finishLoading();

        // Creation des personnages
        pezInitPos = new Vector2();
        ghostInitPos = new Vector2();
    }

    public void decreasePezLives() {
        pezLives--;
    }

    public void resetPezLives() {
        pezLives = 4;
    }

    public void setGameOver() {
        gameOver = true;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    // Compter les points
    public void countScore(int score) {
        this.score += score;
        if (this.score > highScore)
            highScore = this.score;
    }

    public void resetGame(boolean restart){
        if(restart){
            score = 0;
            displayScore = 0;
            resetPezLives();
        }
        totalGommes = 0;
        pezAlive = true;
        specGommeEaten = false;
        gameOver = false;
    }

    @Override
    public void dispose() {
        assetManager.dispose();
    }
}
