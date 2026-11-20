package com.google.android.gms.ads.internal.util;

import com.google.android.gms.internal.ads.zzapi;
import com.google.android.gms.internal.ads.zzaqe;
import com.google.android.gms.internal.ads.zzaqf;
import com.google.android.gms.internal.ads.zzare;
import com.google.android.gms.internal.ads.zzceb;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
final class zzbk extends zzare {
    final /* synthetic */ byte[] zza;
    final /* synthetic */ Map zzb;
    final /* synthetic */ zzceb zzc;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzbk(zzbq zzbqVar, int i11, String str, zzaqf zzaqfVar, zzaqe zzaqeVar, byte[] bArr, Map map, zzceb zzcebVar) {
        super(i11, str, zzaqfVar, zzaqeVar);
        this.zza = bArr;
        this.zzb = map;
        this.zzc = zzcebVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaqa
    public final Map zzl() throws zzapi {
        Map map = this.zzb;
        return map == null ? Collections.emptyMap() : map;
    }

    @Override // com.google.android.gms.internal.ads.zzare, com.google.android.gms.internal.ads.zzaqa
    public final /* bridge */ /* synthetic */ void zzo(Object obj) {
        zzo((String) obj);
    }

    @Override // com.google.android.gms.internal.ads.zzaqa
    public final byte[] zzx() throws zzapi {
        byte[] bArr = this.zza;
        if (bArr == null) {
            return null;
        }
        return bArr;
    }

    @Override // com.google.android.gms.internal.ads.zzare
    /* JADX INFO: renamed from: zzz */
    public final void zzo(String str) {
        this.zzc.zzg(str);
        super.zzo(str);
    }
}
