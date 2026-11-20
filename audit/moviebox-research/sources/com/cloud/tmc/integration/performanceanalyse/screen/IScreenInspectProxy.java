package com.cloud.tmc.integration.performanceanalyse.screen;

import com.cloud.tmc.integration.structure.App;
import gd.b;
import zc.i;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public interface IScreenInspectProxy {
    void appDestroy(App app);

    void checkNow(App app, String str);

    void destroy(App app, String str);

    void initConfig(float f11, Long l11, int[] iArr);

    void registerRender(i iVar);

    void registerWorker(App app, b bVar);

    void start(App app, String str);
}
