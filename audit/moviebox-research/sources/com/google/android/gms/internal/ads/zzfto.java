package com.google.android.gms.internal.ads;

import android.net.Network;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzfto extends zzftc {
    private zzfxu<Integer> zza;
    private zzfxu<Integer> zzb;

    @Nullable
    private zzftn zzc;

    @Nullable
    private HttpURLConnection zzd;

    public zzfto() {
        this(new zzfxu() { // from class: com.google.android.gms.internal.ads.zzfte
            @Override // com.google.android.gms.internal.ads.zzfxu
            public final Object zza() {
                return zzfto.zzf();
            }
        }, new zzfxu() { // from class: com.google.android.gms.internal.ads.zzftf
            @Override // com.google.android.gms.internal.ads.zzfxu
            public final Object zza() {
                return zzfto.zzg();
            }
        }, null);
    }

    public zzfto(zzfxu<Integer> zzfxuVar, zzfxu<Integer> zzfxuVar2, @Nullable zzftn zzftnVar) {
        this.zza = zzfxuVar;
        this.zzb = zzfxuVar2;
        this.zzc = zzftnVar;
    }

    public static /* synthetic */ Integer zzf() {
        return -1;
    }

    public static /* synthetic */ Integer zzg() {
        return -1;
    }

    public static void zzs(@Nullable HttpURLConnection httpURLConnection) {
        zzftd.zza();
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        zzs(this.zzd);
    }

    public HttpURLConnection zzm() throws IOException {
        zzftd.zzb(((Integer) this.zza.zza()).intValue(), ((Integer) this.zzb.zza()).intValue());
        zzftn zzftnVar = this.zzc;
        zzftnVar.getClass();
        HttpURLConnection httpURLConnection = (HttpURLConnection) zzftnVar.zza();
        this.zzd = httpURLConnection;
        return httpURLConnection;
    }

    public HttpURLConnection zzn(zzftn zzftnVar, final int i11, final int i12) throws IOException {
        this.zza = new zzfxu() { // from class: com.google.android.gms.internal.ads.zzftg
            @Override // com.google.android.gms.internal.ads.zzfxu
            public final Object zza() {
                return Integer.valueOf(i11);
            }
        };
        this.zzb = new zzfxu() { // from class: com.google.android.gms.internal.ads.zzfth
            @Override // com.google.android.gms.internal.ads.zzfxu
            public final Object zza() {
                return Integer.valueOf(i12);
            }
        };
        this.zzc = zzftnVar;
        return zzm();
    }

    @RequiresApi(21)
    public HttpURLConnection zzo(@NonNull final Network network, @NonNull final URL url, final int i11, final int i12) throws IOException {
        this.zza = new zzfxu() { // from class: com.google.android.gms.internal.ads.zzfti
            @Override // com.google.android.gms.internal.ads.zzfxu
            public final Object zza() {
                return Integer.valueOf(i11);
            }
        };
        this.zzb = new zzfxu() { // from class: com.google.android.gms.internal.ads.zzftj
            @Override // com.google.android.gms.internal.ads.zzfxu
            public final Object zza() {
                return Integer.valueOf(i12);
            }
        };
        this.zzc = new zzftn() { // from class: com.google.android.gms.internal.ads.zzftk
            @Override // com.google.android.gms.internal.ads.zzftn
            public final URLConnection zza() {
                return network.openConnection(url);
            }
        };
        return zzm();
    }

    public URLConnection zzr(@NonNull final URL url, final int i11) throws IOException {
        this.zza = new zzfxu() { // from class: com.google.android.gms.internal.ads.zzftl
            @Override // com.google.android.gms.internal.ads.zzfxu
            public final Object zza() {
                return Integer.valueOf(i11);
            }
        };
        this.zzc = new zzftn() { // from class: com.google.android.gms.internal.ads.zzftm
            @Override // com.google.android.gms.internal.ads.zzftn
            public final URLConnection zza() {
                return url.openConnection();
            }
        };
        return zzm();
    }
}
