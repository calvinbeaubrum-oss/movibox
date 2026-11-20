package com.cloud.tmc.integration.bridge;

import android.content.ClipData;
import android.content.ClipboardManager;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.kernel.executor.ExecutorType;
import com.cloud.tmc.kernel.extension.BridgeExtension;
import com.google.gson.JsonObject;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class SetClipboardBridge implements BridgeExtension {
    @Override // com.cloud.tmc.kernel.extension.BridgeExtension
    public /* synthetic */ void callbackFail(bc.a aVar, String str, Boolean bool) {
        com.cloud.tmc.kernel.extension.a.a(this, aVar, str, bool);
    }

    @Override // com.cloud.tmc.kernel.extension.BridgeExtension, com.cloud.tmc.kernel.extension.c
    public void onFinalized() {
    }

    @Override // com.cloud.tmc.kernel.extension.BridgeExtension, com.cloud.tmc.kernel.extension.c
    public void onInitialized() {
    }

    @Override // com.cloud.tmc.kernel.extension.BridgeExtension, dd.e
    public dd.f permit() {
        return null;
    }

    @zb.a
    @zb.e(ExecutorType.UI)
    public void setClipboard(@cc.g(name = {MimeTypes.BASE_TYPE_TEXT}) String str, @cc.f(App.class) App app, @cc.c bc.a aVar) {
        if (app == null || app.getAppContext() == null || app.getAppContext().getContext() == null) {
            if (aVar != null) {
                aVar.b();
            }
        } else {
            ((ClipboardManager) app.getAppContext().getContext().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(null, str));
            if (aVar != null) {
                aVar.d(new JsonObject());
            }
        }
    }
}
