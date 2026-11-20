package k0;

import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.service.ConfigService;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a implements e {
    @Override // k0.e
    public j0.a a(e.a chain) {
        Intrinsics.g(chain, "chain");
        boolean configBoolean = ((ConfigService) tc.a.a(ConfigService.class)).getConfigBoolean("forceAthenaReportMode", false);
        TmcLogger.c("AthenaUtil", "report AthenaForceReportModeStep -> forceMode:" + configBoolean);
        j0.b bVar = (j0.b) chain;
        j0.a aVar = bVar.f67807e;
        aVar.f67800a = configBoolean ^ true;
        aVar.f67801b = true;
        aVar.f67802c = false;
        bVar.a(configBoolean);
        return bVar.f67807e;
    }
}
