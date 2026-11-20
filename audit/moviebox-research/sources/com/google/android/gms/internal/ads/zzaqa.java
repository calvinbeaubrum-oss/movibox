package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public abstract class zzaqa implements Comparable {
    private final zzaql zza;
    private final int zzb;
    private final String zzc;
    private final int zzd;
    private final Object zze;

    @Nullable
    private final zzaqe zzf;
    private Integer zzg;
    private zzaqd zzh;
    private boolean zzi;

    @Nullable
    private zzapj zzj;
    private zzapz zzk;
    private final zzapo zzl;

    public zzaqa(int i11, String str, @Nullable zzaqe zzaqeVar) {
        Uri uri;
        String host;
        this.zza = zzaql.zza ? new zzaql() : null;
        this.zze = new Object();
        int iHashCode = 0;
        this.zzi = false;
        this.zzj = null;
        this.zzb = i11;
        this.zzc = str;
        this.zzf = zzaqeVar;
        this.zzl = new zzapo();
        if (!TextUtils.isEmpty(str) && (uri = Uri.parse(str)) != null && (host = uri.getHost()) != null) {
            iHashCode = host.hashCode();
        }
        this.zzd = iHashCode;
    }

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return this.zzg.intValue() - ((zzaqa) obj).zzg.intValue();
    }

    public final String toString() {
        String strValueOf = String.valueOf(Integer.toHexString(this.zzd));
        zzw();
        return "[ ] " + this.zzc + " " + "0x".concat(strValueOf) + " NORMAL " + this.zzg;
    }

    public final int zza() {
        return this.zzb;
    }

    public final int zzb() {
        return this.zzl.zzb();
    }

    public final int zzc() {
        return this.zzd;
    }

    @Nullable
    public final zzapj zzd() {
        return this.zzj;
    }

    public final zzaqa zze(zzapj zzapjVar) {
        this.zzj = zzapjVar;
        return this;
    }

    public final zzaqa zzf(zzaqd zzaqdVar) {
        this.zzh = zzaqdVar;
        return this;
    }

    public final zzaqa zzg(int i11) {
        this.zzg = Integer.valueOf(i11);
        return this;
    }

    public abstract zzaqg zzh(zzapw zzapwVar);

    public final String zzj() {
        int i11 = this.zzb;
        String str = this.zzc;
        if (i11 == 0) {
            return str;
        }
        return Integer.toString(1) + "-" + str;
    }

    public final String zzk() {
        return this.zzc;
    }

    public Map zzl() throws zzapi {
        return Collections.emptyMap();
    }

    public final void zzm(String str) {
        if (zzaql.zza) {
            this.zza.zza(str, Thread.currentThread().getId());
        }
    }

    public final void zzn(zzaqj zzaqjVar) {
        zzaqe zzaqeVar;
        synchronized (this.zze) {
            zzaqeVar = this.zzf;
        }
        zzaqeVar.zza(zzaqjVar);
    }

    public abstract void zzo(Object obj);

    public final void zzp(String str) {
        zzaqd zzaqdVar = this.zzh;
        if (zzaqdVar != null) {
            zzaqdVar.zzb(this);
        }
        if (zzaql.zza) {
            long id2 = Thread.currentThread().getId();
            if (Looper.myLooper() != Looper.getMainLooper()) {
                new Handler(Looper.getMainLooper()).post(new zzapy(this, str, id2));
            } else {
                this.zza.zza(str, id2);
                this.zza.zzb(toString());
            }
        }
    }

    public final void zzq() {
        synchronized (this.zze) {
            this.zzi = true;
        }
    }

    public final void zzr() {
        zzapz zzapzVar;
        synchronized (this.zze) {
            zzapzVar = this.zzk;
        }
        if (zzapzVar != null) {
            zzapzVar.zza(this);
        }
    }

    public final void zzs(zzaqg zzaqgVar) {
        zzapz zzapzVar;
        synchronized (this.zze) {
            zzapzVar = this.zzk;
        }
        if (zzapzVar != null) {
            zzapzVar.zzb(this, zzaqgVar);
        }
    }

    public final void zzt(int i11) {
        zzaqd zzaqdVar = this.zzh;
        if (zzaqdVar != null) {
            zzaqdVar.zzc(this, i11);
        }
    }

    public final void zzu(zzapz zzapzVar) {
        synchronized (this.zze) {
            this.zzk = zzapzVar;
        }
    }

    public final boolean zzv() {
        boolean z11;
        synchronized (this.zze) {
            z11 = this.zzi;
        }
        return z11;
    }

    public final boolean zzw() {
        synchronized (this.zze) {
        }
        return false;
    }

    public byte[] zzx() throws zzapi {
        return null;
    }

    public final zzapo zzy() {
        return this.zzl;
    }
}
