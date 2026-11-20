package com.cloud.tmc.kernel.bridge;

import com.cloud.tmc.kernel.engine.EngineRouter;
import com.google.gson.JsonObject;
import gd.b;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public interface IMsgDispatcher {
    boolean handleMsgFromRender(EngineRouter engineRouter, String str, String str2, String str3);

    boolean handleMsgFromWorker(b bVar, JsonObject jsonObject);
}
