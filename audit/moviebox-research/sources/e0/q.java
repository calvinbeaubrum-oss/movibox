package e0;

import android.os.Bundle;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PerformanceAnalyseProxy;
import com.cloud.tmc.miniapp.ui.OooO0OO;
import com.cloud.tmc.miniapp.widget.StatusLayout;
import kotlin.Unit;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class q implements StatusLayout.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OooO0OO f63610a;

    public q(OooO0OO oooO0OO) {
        this.f63610a = oooO0OO;
    }

    @Override // com.cloud.tmc.miniapp.widget.StatusLayout.b
    public void a(StatusLayout statusLayout) {
        PerformanceAnalyseProxy performanceAnalyseProxy = (PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class);
        String str = this.f63610a.H;
        Bundle bundle = new Bundle();
        bundle.putInt("type", 2);
        Unit unit = Unit.f68710a;
        performanceAnalyseProxy.recordForCommon(str, "uncon_retry_click", bundle);
        OooO0OO.h0(this.f63610a, false, null, 3, null);
    }
}
