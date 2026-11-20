package com.google.android.gms.internal.ads;

import java.util.HashSet;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public abstract class zzfqe extends zzfqf {
    protected final HashSet zza;
    protected final JSONObject zzb;
    protected final long zzc;

    public zzfqe(zzfpx zzfpxVar, HashSet hashSet, JSONObject jSONObject, long j11) {
        super(zzfpxVar);
        this.zza = new HashSet(hashSet);
        this.zzb = jSONObject;
        this.zzc = j11;
    }
}
