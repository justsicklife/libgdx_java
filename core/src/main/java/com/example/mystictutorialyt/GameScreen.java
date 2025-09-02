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
    // 메인 게임 클래스 (Screen 전환 관리)
    private final GdxGame game;
    // AssetService 맵 리소스 로드 / 관리
    private final AssetService assetService;
    // 해상도 맞추는 도우미
    private final Viewport viewport;
    // 카메라
    private final OrthographicCamera camera;

    private final Batch batch;

    // 타일맵을 화면에 그리는 렌더러
    private final OrthogonalTiledMapRenderer mapRenderer;

    public GameScreen(GdxGame game) {
        this.game = game;
        this.assetService = game.getAssetService();
        this.viewport = game.getViewport();
        this.camera = game.getCamera();
        this.batch = game.getBatch();
        this.mapRenderer = new OrthogonalTiledMapRenderer(
            // this.assetService.get(MapAsset.MAIN),
            null,
            // 맵 타일 크기를 월드 좌표계 단위로 변환
            GdxGame.UNIT_SCALE,
            // SpriteBatch 를 공유해서 사용
            this.game.getBatch());
    }

    // 처음 한번 호출됨
    @Override
    public void show() {
        this.assetService.load(MapAsset.MAIN);
        this.mapRenderer.setMap(this.assetService.get(MapAsset.MAIN));
    }

    // 매 프레임마다 호출
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
