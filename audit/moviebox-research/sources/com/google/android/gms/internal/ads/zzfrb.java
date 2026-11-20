package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.mbridge.msdk.playercommon.exoplayer2.DefaultLoadControl;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
@ShowFirstParty
public final class zzfrb {
    public static zzfsk zza(Context context, int i11, int i12, String str, String str2, String str3, zzfqr zzfqrVar) {
        return new zzfra(context, 1, i12, str, str2, "1", zzfqrVar).zzb(DefaultLoadControl.DEFAULT_MAX_BUFFER_MS);
    }
}
