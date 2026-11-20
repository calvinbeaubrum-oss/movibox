package p011Oooo00o;

import android.os.Bundle;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PerformanceAnalyseProxy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import tc.a;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class OooOo00 extends Lambda implements Function0<Unit> {
    public final /* synthetic */ String OooO00o;
    public final /* synthetic */ Function0<Unit> OooO0O0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OooOo00(String str, Function0<Unit> function0) {
        super(0);
        this.OooO00o = str;
        this.OooO0O0 = function0;
    }

    @Override // kotlin.jvm.functions.Function0
    public Unit invoke() {
        ((PerformanceAnalyseProxy) a.a(PerformanceAnalyseProxy.class)).recordForCommon(this.OooO00o, "add_bubble_ex", new Bundle());
        Function0<Unit> function0 = this.OooO0O0;
        if (function0 != null) {
            function0.invoke();
        }
        return Unit.f68710a;
    }
}
