package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import androidx.annotation.Nullable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzgp extends zzgq {
    private final AssetManager zza;

    @Nullable
    private Uri zzb;

    @Nullable
    private InputStream zzc;
    private long zzd;
    private boolean zze;

    public zzgp(Context context) {
        super(false);
        this.zza = context.getAssets();
    }

    @Override // com.google.android.gms.internal.ads.zzu
    public final int zza(byte[] bArr, int i11, int i12) throws zzgo {
        if (i12 == 0) {
            return 0;
        }
        long j11 = this.zzd;
        if (j11 == 0) {
            return -1;
        }
        if (j11 != -1) {
            try {
                i12 = (int) Math.min(j11, i12);
            } catch (IOException e11) {
                throw new zzgo(e11, 2000);
            }
        }
        InputStream inputStream = this.zzc;
        int i13 = zzfy.zza;
        int i14 = inputStream.read(bArr, i11, i12);
        if (i14 == -1) {
            return -1;
        }
        long j12 = this.zzd;
        if (j12 != -1) {
            this.zzd = j12 - ((long) i14);
        }
        zzg(i14);
        return i14;
    }

    @Override // com.google.android.gms.internal.ads.zzgw
    public final long zzb(zzhb zzhbVar) throws zzgo {
        try {
            Uri uri = zzhbVar.zza;
            this.zzb = uri;
            String path = uri.getPath();
            path.getClass();
            if (path.startsWith("/android_asset/")) {
                path = path.substring(15);
            } else if (path.startsWith("/")) {
                path = path.substring(1);
            }
            zzi(zzhbVar);
            InputStream inputStreamOpen = this.zza.open(path, 1);
            this.zzc = inputStreamOpen;
            if (inputStreamOpen.skip(zzhbVar.zzf) < zzhbVar.zzf) {
                throw new zzgo(null, 2008);
            }
            long j11 = zzhbVar.zzg;
            if (j11 != -1) {
                this.zzd = j11;
            } else {
                long jAvailable = this.zzc.available();
                this.zzd = jAvailable;
                if (jAvailable == 2147483647L) {
                    this.zzd = -1L;
                }
            }
            this.zze = true;
            zzj(zzhbVar);
            return this.zzd;
        } catch (zzgo e11) {
            throw e11;
        } catch (IOException e12) {
            throw new zzgo(e12, true != (e12 instanceof FileNotFoundException) ? 2000 : 2005);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgw
    @Nullable
    public final Uri zzc() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzgw
    public final void zzd() throws zzgo {
        this.zzb = null;
        try {
            try {
                InputStream inputStream = this.zzc;
                if (inputStream != null) {
                    inputStream.close();
                }
                this.zzc = null;
                if (this.zze) {
                    this.zze = false;
                    zzh();
                }
            } catch (IOException e11) {
                throw new zzgo(e11, 2000);
            }
        } catch (Throwable th2) {
            this.zzc = null;
            if (this.zze) {
                this.zze = false;
                zzh();
            }
            throw th2;
        }
    }
}
