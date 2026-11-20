package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.privacysandbox.ads.adservices.java.topics.TopicsManagerFutures;
import com.google.android.gms.ads.MobileAds;
import com.google.common.util.concurrent.s;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzeil {
    private final Context zza;

    public zzeil(Context context) {
        this.zza = context;
    }

    public final s zza(boolean z11) {
        androidx.privacysandbox.ads.adservices.topics.a aVarA = new androidx.privacysandbox.ads.adservices.topics.a.C0112a().b(MobileAds.ERROR_DOMAIN).c(z11).a();
        TopicsManagerFutures topicsManagerFuturesA = TopicsManagerFutures.a(this.zza);
        return topicsManagerFuturesA != null ? topicsManagerFuturesA.b(aVarA) : zzgen.zzg(new IllegalStateException());
    }
}
