package com.cloud.tmc.integration.bridge;

import android.content.Context;
import android.content.IntentFilter;
import android.os.BatteryManager;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.kernel.executor.ExecutorType;
import com.cloud.tmc.kernel.extension.BridgeExtension;
import com.google.gson.JsonObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class BatteryBridge implements BridgeExtension {
    public final JsonObject a(@NonNull int i11, boolean z11) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("level", Integer.valueOf(i11));
        jsonObject.addProperty("isCharging", Boolean.valueOf(z11));
        return jsonObject;
    }

    @Override // com.cloud.tmc.kernel.extension.BridgeExtension
    public /* synthetic */ void callbackFail(bc.a aVar, String str, Boolean bool) {
        com.cloud.tmc.kernel.extension.a.a(this, aVar, str, bool);
    }

    @zb.a
    @zb.e(ExecutorType.NORMAL)
    public void getBatteryInfo(@cc.f(App.class) App app, @cc.c bc.a aVar) {
        int intProperty;
        if (app == null || app.getAppContext() == null || app.getAppContext().getContext() == null) {
            if (aVar != null) {
                aVar.b();
                return;
            }
            return;
        }
        Context context = app.getAppContext().getContext();
        boolean z11 = false;
        try {
            intProperty = ((BatteryManager) context.getSystemService("batterymanager")).getIntProperty(4);
            try {
                int intExtra = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED")).getIntExtra(NotificationCompat.CATEGORY_STATUS, -1);
                if (intExtra == 2 || intExtra == 5) {
                    z11 = true;
                }
            } catch (Exception unused) {
            }
        } catch (Exception unused2) {
            intProperty = 0;
        }
        if (aVar != null) {
            aVar.d(a(intProperty, z11));
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
