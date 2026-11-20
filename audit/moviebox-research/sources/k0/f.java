package k0;

import com.cloud.tmc.integration.utils.AppUtils;
import com.cloud.tmc.kernel.log.TmcLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class f implements e {
    @Override // k0.e
    public j0.a a(e.a chain) {
        Intrinsics.g(chain, "chain");
        j0.b bVar = (j0.b) chain;
        String str = bVar.f67804b;
        boolean zD = str != null ? AppUtils.f31011a.d(str) : false;
        TmcLogger.c("AthenaUtil", "report AthenaWhiteListStep -> inWhiteList:" + zD);
        j0.a aVar = bVar.f67807e;
        aVar.f67800a = zD ^ true;
        aVar.f67801b = false;
        aVar.f67802c = false;
        bVar.a(zD);
        return bVar.f67807e;
    }
}
