package com.ezneuron.pezman.gameplay;


import com.badlogic.ashley.core.Engine;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.StringBuilder;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.ezneuron.pezman.PezmanMain;
import com.ezneuron.pezman.iteratingsystems.AnimationRendering;
import com.ezneuron.pezman.iteratingsystems.GhostRendering;
import com.ezneuron.pezman.iteratingsystems.GommeRendering;
import com.ezneuron.pezman.iteratingsystems.MovementRendering;
import com.ezneuron.pezman.iteratingsystems.PezRendering;
import com.ezneuron.pezman.iteratingsystems.StateRendering;
import com.ezneuron.pezman.iteratingsystems.TextTransRendering;
import com.ezneuron.pezman.utils.Constants;

import box2dLight.RayHandler;

/**
 * Created by batty on 6/1/2016.
 */
// Interface pour liberer ( detruire ) des ressources
public class GameRenderer implements Screen {
    // Instance de jeu
    private final PezmanMain game;

    // Libgdx instances
    private SpriteBatch batch;
    private OrthographicCamera camera; // Camera de la scene
    private Sprite pezSprite; // Un objet 2D avec des details.
    private BitmapFont font; // Bitmap de charactere
    private FitViewport viewport; // Garder l'aspect ratio en ajustant la scene du jeu a celle de l'appareil et en ajoutant les barres noires a l'espace de reste
    private FitViewport stageViewport;
    private Stage stage; // Un graphe 2D contient l'hierarchies des acteurs. Cette classe traite le viewport et la distribution des evenement d'entree.
    private Engine engine; // La coeur de Entity framework qui geste des objetss de systeme d'entites et garde une trace des entites
    private World world; // Classe qui geste tous les entites physiques, simulation dynamique, queries asynchronous.
    private Box2DDebugRenderer box2DDebugRenderer;

    // Informations
    private Label scoreLabel;
    private Label highScoreLabel;
    private Label gameOverLabel;
    private StringBuilder stringBuilder;

    // Effets des lumieres
    private RayHandler rayHandler;
    private float ambientLight = 0.5f;

    // Statuts de la scene
    private boolean changeScreen;
    private float changeScreenCountDown = 2.0f;

    // Create map
    private TiledMap tiledMap;
    private OrthogonalTiledMapRenderer orthogonalTiledMapRenderer;

    // Instances des classes
    private AnimationRendering animationRendering;
    private GhostRendering ghostRendering;
    private PezRendering pezRendering;
    private StateRendering stateRendering;
    private MovementRendering movementRendering;
    private TextTransRendering textTransRendering;
    private GommeRendering gommeRendering;

    public GameRenderer(PezmanMain game) {
        this.game = game;
        this.batch = game.batch;
    }

    @Override
    public void show() {
        // mettre la camera
        camera = new OrthographicCamera();
        viewport = new FitViewport(Constants.VIEWPORT_WIDTH, Constants.VIEWPORT_HEIGHT);
        camera.translate(Constants.VIEWPORT_WIDTH/2, Constants.VIEWPORT_HEIGHT/2);
        camera.update();

        // mettre l'environnement
        batch = new SpriteBatch();

        // init des instances
        animationRendering = new AnimationRendering();
        ghostRendering = new GhostRendering();
        pezRendering = new PezRendering();
        stateRendering = new StateRendering();
        movementRendering = new MovementRendering();
        textTransRendering = new TextTransRendering();
        gommeRendering = new GommeRendering();

        // Init les engines
        engine = new Engine();

        // charger la carte general
        tiledMap = new TmxMapLoader().load("map/map.tmx");
        orthogonalTiledMapRenderer = new OrthogonalTiledMapRenderer(tiledMap, 1/16f, batch);

        // init le viewport de la stage
        stageViewport = new FitViewport(Constants.VIEWPORT_WIDTH * 20, Constants.VIEWPORT_HEIGHT * 20);
        stage = new Stage(stageViewport, batch);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.2f,0.2f,0.2f,1.0f); // Colorer la scene
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT); // Clarifier la scene et Synchroniser

        orthogonalTiledMapRenderer.setView(camera);
        orthogonalTiledMapRenderer.render();

        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        batch.end();
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width,height);
        stageViewport.update(width, height);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {
        dispose();
    }

    @Override
    public void dispose() {
        font.dispose();
        stage.dispose();
        rayHandler.dispose();
        tiledMap.dispose();
        orthogonalTiledMapRenderer.dispose();
        world.dispose();
        box2DDebugRenderer.dispose();
    }
}
