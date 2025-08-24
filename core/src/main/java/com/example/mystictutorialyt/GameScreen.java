package com.example.mystictutorialyt;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.example.mystictutorialyt.asset.AssetService;
import com.example.mystictutorialyt.asset.MapAsset;

public class GameScreen extends ScreenAdapter {
    private final GdxGame game;
    private final Batch batch;
    private final AssetService assetService;
    private final Viewport viewport;
    private final OrthographicCamera camera;

    private final OrthogonalTiledMapRenderer mapRenderer;

    public GameScreen(GdxGame game) {
        this.game = game;
        this.assetService = game.getAssetService();
        this.viewport = game.getViewport();
        this.camera = game.getCamera();
        batch = game.getBatch();
        mapRenderer = new OrthogonalTiledMapRenderer(
            null,
            GdxGame.UNIT_SCALE,
            this.batch
        );
    }

    @Override
    public void show() {
        this.assetService.load(MapAsset.MAIN);
        this.mapRenderer.setMap(this.assetService.get(MapAsset.MAIN));
    }

    @Override
    public void render(float delta) {
        this.viewport.apply();
        this.batch.setColor(Color.WHITE);
        this.mapRenderer.setView(this.camera);
        this.mapRenderer.render();
    }

    @Override
    public void dispose() {
        this.mapRenderer.dispose();
    }
}
