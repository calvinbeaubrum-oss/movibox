package com.cloud.tmc.miniapp.bridge;

import bc.a;
import com.cloud.tmc.integration.structure.App;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class OooO0O0 extends Lambda implements Function0<Unit> {
    public final /* synthetic */ App OooO00o;
    public final /* synthetic */ a OooO0O0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OooO0O0(App app, a aVar) {
        super(0);
        this.OooO00o = app;
        this.OooO0O0 = aVar;
    }

    @Override // kotlin.jvm.functions.Function0
    public Unit invoke() {
        this.OooO00o.putBooleanValue("miniAppHasUpdateRequesting", false);
        f.a.a("errMsg", "AppInfo request failed, please try again later: MAU10004", this.OooO0O0);
        return Unit.f68710a;
    }
}
