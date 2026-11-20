package com.cloud.tmc.integration.bridge;

import android.provider.Settings;
import android.view.Window;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.integration.structure.Page;
import com.cloud.tmc.kernel.executor.ExecutorType;
import com.cloud.tmc.kernel.extension.BridgeExtension;
import com.google.gson.JsonObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class ScreenBridge implements BridgeExtension {
    public final JsonObject a(@NonNull float f11) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("screenBrightness", Float.valueOf(f11));
        return jsonObject;
    }

    @Override // com.cloud.tmc.kernel.extension.BridgeExtension
    public /* synthetic */ void callbackFail(bc.a aVar, String str, Boolean bool) {
        com.cloud.tmc.kernel.extension.a.a(this, aVar, str, bool);
    }

    @zb.a
    @zb.e(ExecutorType.NORMAL)
    public void getScreenBrightness(@cc.f(App.class) App app, @cc.f(Page.class) Page page, @cc.c bc.a aVar) {
        if (app == null || app.getAppContext() == null || app.getAppContext().getContext() == null) {
            if (aVar != null) {
                aVar.b();
                return;
            }
            return;
        }
        if (page == null || page.getPageContext() == null || page.getPageContext().getActivity() == null) {
            if (aVar != null) {
                aVar.b();
                return;
            }
            return;
        }
        float f11 = page.getPageContext().getActivity().getWindow().getAttributes().screenBrightness;
        if (f11 != -1.0f) {
            if (aVar != null) {
                aVar.d(a(f11));
                return;
            }
            return;
        }
        try {
            float f12 = Settings.System.getInt(app.getAppContext().getContext().getContentResolver(), "screen_brightness") / 255.0f;
            if (aVar != null) {
                aVar.d(a(f12));
            }
        } catch (Exception unused) {
            if (aVar != null) {
                aVar.b();
            }
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

    @zb.a
    @zb.e(ExecutorType.UI)
    public void setScreenBrightness(@cc.g(name = {"screenBrightness"}) float f11, @cc.f(App.class) App app, @cc.f(Page.class) Page page, @cc.c bc.a aVar) {
        if (app == null || app.getAppContext() == null || app.getAppContext().getContext() == null) {
            if (aVar != null) {
                aVar.b();
                return;
            }
            return;
        }
        if (page == null || page.getPageContext() == null || page.getPageContext().getActivity() == null) {
            if (aVar != null) {
                aVar.b();
                return;
            }
            return;
        }
        if (f11 != -1.0f && (Math.min(0.0f, f11) != 0.0f || Math.max(1.0f, f11) != 1.0f)) {
            if (aVar != null) {
                aVar.b();
                return;
            }
            return;
        }
        try {
            Window window = page.getPageContext().getActivity().getWindow();
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.screenBrightness = f11;
            window.setAttributes(attributes);
            if (aVar != null) {
                aVar.g();
            }
        } catch (Exception unused) {
            if (aVar != null) {
                aVar.b();
            }
        }
    }
}
