package com.example.mystictutorialyt;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import com.badlogic.gdx.graphics.FPSLogger;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.profiling.GLProfiler;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.example.mystictutorialyt.asset.AssetService;

import java.util.HashMap;
import java.util.Map;

public class GdxGame extends Game {

    private static final float WORLD_WIDTH = 30f;
    public static final float WORLD_HEIGHT = 20f;
    public static final float UNIT_SCALE = 1f/16f;

    // 스프라이트를 그리는 객체
    private Batch batch;

    // 2D 카메라
    private OrthographicCamera camera;
    // 화면 해상도 대응
    private Viewport viewport;
    // 맵/이미지 리소스 관리
    private AssetService assetService;
    // draw call 등 GPU 디버그
    private GLProfiler glProfiler;
    // 초당 프레임 로그
    private FPSLogger fpsLogger;
    // Screen 관리
    private final Map<Class <? extends Screen>,Screen> screenCache = new HashMap<>();

    @Override
    public void create() {
        Gdx.app.setLogLevel(Application.LOG_INFO);

        this.batch = new SpriteBatch();
        this.camera = new OrthographicCamera();
        this.viewport = new FitViewport(WORLD_WIDTH, WORLD_HEIGHT, camera);
        this.assetService = new AssetService(new InternalFileHandleResolver());
        this.glProfiler = new GLProfiler(Gdx.graphics);
        this.glProfiler.enable();
        this.fpsLogger = new FPSLogger();

        addScreen(new GameScreen(this));
        setScreen(GameScreen.class);
    }

    @Override
    public void render() {
        glProfiler.reset();

        Gdx.gl.glClearColor(0f,0f,0f,1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        super.render();

        Gdx.graphics.setTitle("Mystic Tutorial - Draw calls : " + glProfiler.getDrawCalls());
        fpsLogger.log();
    }

    // 화면 크기 변경 시 호출
    @Override
    public void resize(int width, int height) {
        viewport.update(width,height,true);
        super.resize(width,height);
    }

    public void addScreen(Screen screen) {
        screenCache.put(screen.getClass(),screen);
    }

    public void setScreen(Class<? extends Screen> screenClass) {
        Screen screen = screenCache.get(screenClass);
        if(screen == null) {
            throw new GdxRuntimeException("No screen with class " + screenClass + " found");
        }
        super.setScreen(screen);
    }

    @Override
    public void dispose() {
        screenCache.values().forEach(Screen::dispose);
        screenCache.clear();

        this.batch.dispose();
        this.assetService.debugDiagnostics();
        this.assetService.dispose();

        super.dispose();
    }

    public Batch getBatch() {
        return batch;
    }

    public OrthographicCamera getCamera() {
        return camera;
    }

    public Viewport getViewport() {
        return viewport;
    }

    public AssetService getAssetService() {
        return assetService;
    }
}
