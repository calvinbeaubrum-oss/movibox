package com.google.android.gms.ads.internal;

import android.os.AsyncTask;
import com.google.android.gms.internal.ads.zzavi;
import com.google.android.gms.internal.ads.zzcec;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
final class zzq extends AsyncTask {
    final /* synthetic */ zzs zza;

    public /* synthetic */ zzq(zzs zzsVar, zzp zzpVar) {
        this.zza = zzsVar;
    }

    @Override // android.os.AsyncTask
    public final /* bridge */ /* synthetic */ void onPostExecute(Object obj) {
        zzs zzsVar = this.zza;
        String str = (String) obj;
        if (zzsVar.zzf == null || str == null) {
            return;
        }
        zzsVar.zzf.loadUrl(str);
    }

    @Override // android.os.AsyncTask
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final String doInBackground(Void... voidArr) {
        try {
            zzs zzsVar = this.zza;
            zzsVar.zzh = (zzavi) zzsVar.zzc.get(1000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e11) {
            e = e11;
            zzcec.zzk("", e);
        } catch (ExecutionException e12) {
            e = e12;
            zzcec.zzk("", e);
        } catch (TimeoutException e13) {
            zzcec.zzk("", e13);
        }
        return this.zza.zzp();
    }
}
