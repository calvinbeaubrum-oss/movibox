package k0;

import com.cloud.tmc.integration.utils.f0;
import com.cloud.tmc.kernel.log.TmcLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b implements e {
    @Override // k0.e
    public j0.a a(e.a chain) {
        Intrinsics.g(chain, "chain");
        j0.b bVar = (j0.b) chain;
        boolean zG = bVar.f67803a != null ? f0.f31050a.g(bVar.f67804b) : false;
        TmcLogger.c("AthenaUtil", bVar.f67804b + ": -> report AthenaMfahStep -> AthenaMfahStep:" + zG);
        j0.a aVar = bVar.f67807e;
        aVar.f67800a = zG;
        aVar.f67801b = true;
        aVar.f67802c = true;
        bVar.a(zG);
        return bVar.f67807e;
    }
}
