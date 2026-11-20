package k0;

import android.content.Context;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.storage.KVStorageProxy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class d implements e {
    @Override // k0.e
    public j0.a a(e.a chain) {
        Intrinsics.g(chain, "chain");
        j0.b bVar = (j0.b) chain;
        Context context = bVar.f67803a;
        boolean z11 = context != null ? ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).getBoolean(context, "100000", "privacy_agreement", false) : false;
        TmcLogger.c("AthenaUtil", "report AthenaPrivacyStep -> agree:" + z11);
        j0.a aVar = bVar.f67807e;
        aVar.f67800a = z11 ^ true;
        aVar.f67801b = true;
        aVar.f67802c = false;
        bVar.a(z11);
        return bVar.f67807e;
    }
}
