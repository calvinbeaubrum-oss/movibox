package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.HashSet;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzfqj extends zzfqe {
    public zzfqj(zzfpx zzfpxVar, HashSet hashSet, JSONObject jSONObject, long j11) {
        super(zzfpxVar, hashSet, jSONObject, j11);
    }

    @Override // android.os.AsyncTask
    public final /* bridge */ /* synthetic */ Object doInBackground(Object[] objArr) {
        if (zzfpo.zzg(this.zzb, this.zzd.zza())) {
            return null;
        }
        this.zzd.zze(this.zzb);
        return this.zzb.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzfqf, android.os.AsyncTask
    public final /* bridge */ /* synthetic */ void onPostExecute(Object obj) {
        onPostExecute((String) obj);
    }

    @Override // com.google.android.gms.internal.ads.zzfqf
    /* JADX INFO: renamed from: zza */
    public final void onPostExecute(String str) {
        zzfov zzfovVarZza;
        if (!TextUtils.isEmpty(str) && (zzfovVarZza = zzfov.zza()) != null) {
            for (zzfoh zzfohVar : zzfovVarZza.zzc()) {
                if (((zzfqe) this).zza.contains(zzfohVar.zzh())) {
                    zzfohVar.zzg().zzf(str, this.zzc);
                }
            }
        }
        super.onPostExecute(str);
    }
}
