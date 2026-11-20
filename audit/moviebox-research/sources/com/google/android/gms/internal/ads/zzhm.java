package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzhm extends zzgq {

    @Nullable
    private RandomAccessFile zza;

    @Nullable
    private Uri zzb;
    private long zzc;
    private boolean zzd;

    public zzhm() {
        super(false);
    }

    @Override // com.google.android.gms.internal.ads.zzu
    public final int zza(byte[] bArr, int i11, int i12) throws zzhl {
        if (i12 == 0) {
            return 0;
        }
        long j11 = this.zzc;
        if (j11 == 0) {
            return -1;
        }
        try {
            RandomAccessFile randomAccessFile = this.zza;
            int i13 = zzfy.zza;
            int i14 = randomAccessFile.read(bArr, i11, (int) Math.min(j11, i12));
            if (i14 > 0) {
                this.zzc -= (long) i14;
                zzg(i14);
            }
            return i14;
        } catch (IOException e11) {
            throw new zzhl(e11, 2000);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgw
    public final long zzb(zzhb zzhbVar) throws zzhl {
        Uri uri = zzhbVar.zza;
        this.zzb = uri;
        zzi(zzhbVar);
        try {
            String path = uri.getPath();
            path.getClass();
            RandomAccessFile randomAccessFile = new RandomAccessFile(path, CampaignEx.JSON_KEY_AD_R);
            this.zza = randomAccessFile;
            try {
                randomAccessFile.seek(zzhbVar.zzf);
                long length = zzhbVar.zzg;
                if (length == -1) {
                    length = this.zza.length() - zzhbVar.zzf;
                }
                this.zzc = length;
                if (length < 0) {
                    throw new zzhl(null, null, 2008);
                }
                this.zzd = true;
                zzj(zzhbVar);
                return this.zzc;
            } catch (IOException e11) {
                throw new zzhl(e11, 2000);
            }
        } catch (FileNotFoundException e12) {
            if (!TextUtils.isEmpty(uri.getQuery()) || !TextUtils.isEmpty(uri.getFragment())) {
                throw new zzhl(String.format("uri has query and/or fragment, which are not supported. Did you call Uri.parse() on a string containing '?' or '#'? Use Uri.fromFile(new File(path)) to avoid this. path=%s,query=%s,fragment=%s", uri.getPath(), uri.getQuery(), uri.getFragment()), e12, 1004);
            }
            int i11 = zzfy.zza;
            throw new zzhl(e12, true != zzhk.zzb(e12.getCause()) ? 2005 : 2006);
        } catch (SecurityException e13) {
            throw new zzhl(e13, 2006);
        } catch (RuntimeException e14) {
            throw new zzhl(e14, 2000);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgw
    @Nullable
    public final Uri zzc() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzgw
    public final void zzd() throws zzhl {
        this.zzb = null;
        try {
            try {
                RandomAccessFile randomAccessFile = this.zza;
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
                this.zza = null;
                if (this.zzd) {
                    this.zzd = false;
                    zzh();
                }
            } catch (IOException e11) {
                throw new zzhl(e11, 2000);
            }
        } catch (Throwable th2) {
            this.zza = null;
            if (this.zzd) {
                this.zzd = false;
                zzh();
            }
            throw th2;
        }
    }
}
