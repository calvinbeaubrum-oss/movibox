package com.cloud.tmc.kernel.engine;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.cloud.tmc.kernel.bridge.NativeBridge;
import com.cloud.tmc.kernel.model.CreateParams;
import com.cloud.tmc.kernel.node.Node;
import gd.b;
import ic.a;
import rc.c;
import zc.i;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public interface IEngine {
    i createRender(Activity activity, Node node, CreateParams createParams);

    b createWorker(Context context, Node node, String str) throws Throwable;

    void destroy();

    String getAppId();

    Context getApplication();

    NativeBridge getBridge();

    EngineRouter getEngineRouter();

    String getEngineType();

    String getInstanceId();

    Node getNode();

    Bundle getStartParams();

    i getTopRender();

    String getWorkerId();

    void init(c cVar, a aVar);

    boolean isDestroyed();

    boolean isReady();

    void setup(Bundle bundle, Bundle bundle2, ic.b bVar);

    void updateWorker(b bVar);
}
