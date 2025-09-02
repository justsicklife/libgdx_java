package com.example.mystictutorialyt.asset;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.utils.Disposable;


// 에셋을 불러오거나
public class AssetService implements Disposable {

    // Libgdx 리소스 관리의 핵심 객체
    private final AssetManager assetManager;

    // FileHandlerResolver 파일을 찾을 때 경로를 어떻게 해석할지 결정하는 전략
    public AssetService(FileHandleResolver fileHandleResolver) {
        this.assetManager = new AssetManager(fileHandleResolver);
        this.assetManager.setLoader(TiledMap.class,new TmxMapLoader());
    }

    // 즉시 로드
    public <T> T load(Asset<T> asset) {
        this.assetManager.load(asset.getDescriptor());
        this.assetManager.finishLoading();
        return this.assetManager.get(asset.getDescriptor());
    }

    // 큐에 요청만 등록 로딩은 나중에 업데이트에서
    public <T> void queue(Asset<T> asset) {
        this.assetManager.load(asset.getDescriptor());
    }

    public <T> T get(Asset<T> asset) {
        return this.assetManager.get(asset.getDescriptor());
    }

    // 로드를 진행
    // 모든 리소스가 로드되면 true 남으면 false
    public boolean update() {
        return this.assetManager.update();
    }

    // 리소스 상태 로그 출력
    public void debugDiagnostics() {
        Gdx.app.debug("AssetService",this.assetManager.getDiagnostics());
    }

    @Override
    public void dispose() {
        this.assetManager.dispose();
    }
}
