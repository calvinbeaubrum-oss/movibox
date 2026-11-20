package com.cloud.tmc.integration.bridge;

import android.content.ClipData;
import android.content.ClipboardManager;
import androidx.core.app.NotificationCompat;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.kernel.executor.ExecutorType;
import com.cloud.tmc.kernel.extension.BridgeExtension;
import com.google.gson.JsonObject;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class GetClipboardBridge implements BridgeExtension {
    @Override // com.cloud.tmc.kernel.extension.BridgeExtension
    public /* synthetic */ void callbackFail(bc.a aVar, String str, Boolean bool) {
        com.cloud.tmc.kernel.extension.a.a(this, aVar, str, bool);
    }

    @zb.a
    @zb.e(ExecutorType.UI)
    public void getClipboard(@cc.g(name = {NotificationCompat.CATEGORY_MESSAGE}) String str, @cc.f(App.class) App app, @cc.c bc.a aVar) {
        if (app == null || app.getAppContext() == null || app.getAppContext().getContext() == null) {
            if (aVar != null) {
                aVar.b();
                return;
            }
            return;
        }
        ClipData primaryClip = ((ClipboardManager) app.getAppContext().getContext().getSystemService("clipboard")).getPrimaryClip();
        if (primaryClip != null && primaryClip.getItemCount() > 0) {
            CharSequence text = primaryClip.getItemAt(0).getText();
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty(MimeTypes.BASE_TYPE_TEXT, String.valueOf(text));
            if (aVar != null) {
                aVar.d(jsonObject);
                return;
            }
        }
        if (aVar != null) {
            aVar.b();
        }
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
}
