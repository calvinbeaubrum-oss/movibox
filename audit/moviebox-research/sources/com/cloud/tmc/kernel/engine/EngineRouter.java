package com.cloud.tmc.kernel.engine;

import androidx.annotation.Nullable;
import gd.b;
import java.util.List;
import zc.i;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public interface EngineRouter {

    /* JADX INFO: compiled from: source.java */
    public interface a {
        void a(i iVar);
    }

    void destroy();

    @Nullable
    List<i> getRegisteredRender();

    @Nullable
    i getRenderById(String str);

    i getTopRender();

    @Nullable
    b getWorkerById(@Nullable String str);

    void registerRender(String str, i iVar);

    void registerRenderInitListener(String str, a aVar);

    void registerWorker(b bVar);

    void registerWorker(String str, b bVar);

    void resetRenderToTop(i iVar);

    void unRegisterRender(String str);

    void unRegisterWorker(String str);
}
