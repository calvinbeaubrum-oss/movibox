package com.cloud.tmc.miniapp.bridge;

import android.content.Context;
import bc.a;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.miniapp.utils.MiniAppLaunch;
import com.google.gson.JsonObject;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class OooO00o extends Lambda implements Function0<Unit> {
    public final /* synthetic */ App OooO00o;
    public final /* synthetic */ Context OooO0O0;
    public final /* synthetic */ a OooO0OO;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OooO00o(App app, Context context, a aVar) {
        super(0);
        this.OooO00o = app;
        this.OooO0O0 = context;
        this.OooO0OO = aVar;
    }

    @Override // kotlin.jvm.functions.Function0
    public Unit invoke() {
        this.OooO00o.putBooleanValue("miniAppHasUpdateRequesting", false);
        MiniAppLaunch miniAppLaunch = MiniAppLaunch.f31784a;
        Context context = this.OooO0O0;
        String appId = this.OooO00o.getAppId();
        if (appId == null) {
            appId = "";
        }
        boolean zU = miniAppLaunch.U(context, appId);
        this.OooO00o.putBooleanValue("miniAppHasUpdate", zU);
        a aVar = this.OooO0OO;
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("hasUpdate", Boolean.valueOf(zU));
        aVar.d(jsonObject);
        return Unit.f68710a;
    }
}
