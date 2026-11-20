package com.google.android.gms.internal.ads;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.applovin.sdk.AppLovinEventTypes;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.channels.FileChannel;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzgt extends zzgq {
    private final ContentResolver zza;

    @Nullable
    private Uri zzb;

    @Nullable
    private AssetFileDescriptor zzc;

    @Nullable
    private FileInputStream zzd;
    private long zze;
    private boolean zzf;

    public zzgt(Context context) {
        super(false);
        this.zza = context.getContentResolver();
    }

    @Override // com.google.android.gms.internal.ads.zzu
    public final int zza(byte[] bArr, int i11, int i12) throws zzgs {
        if (i12 == 0) {
            return 0;
        }
        long j11 = this.zze;
        if (j11 == 0) {
            return -1;
        }
        if (j11 != -1) {
            try {
                i12 = (int) Math.min(j11, i12);
            } catch (IOException e11) {
                throw new zzgs(e11, 2000);
            }
        }
        FileInputStream fileInputStream = this.zzd;
        int i13 = zzfy.zza;
        int i14 = fileInputStream.read(bArr, i11, i12);
        if (i14 == -1) {
            return -1;
        }
        long j12 = this.zze;
        if (j12 != -1) {
            this.zze = j12 - ((long) i14);
        }
        zzg(i14);
        return i14;
    }

    @Override // com.google.android.gms.internal.ads.zzgw
    public final long zzb(zzhb zzhbVar) throws zzgs {
        int i11;
        AssetFileDescriptor assetFileDescriptorOpenAssetFileDescriptor;
        long jPosition;
        try {
            try {
                Uri uriNormalizeScheme = zzhbVar.zza.normalizeScheme();
                this.zzb = uriNormalizeScheme;
                zzi(zzhbVar);
                if (AppLovinEventTypes.USER_VIEWED_CONTENT.equals(uriNormalizeScheme.getScheme())) {
                    Bundle bundle = new Bundle();
                    bundle.putBoolean("android.provider.extra.ACCEPT_ORIGINAL_MEDIA_FORMAT", true);
                    assetFileDescriptorOpenAssetFileDescriptor = this.zza.openTypedAssetFileDescriptor(uriNormalizeScheme, "*/*", bundle);
                } else {
                    assetFileDescriptorOpenAssetFileDescriptor = this.zza.openAssetFileDescriptor(uriNormalizeScheme, CampaignEx.JSON_KEY_AD_R);
                }
                this.zzc = assetFileDescriptorOpenAssetFileDescriptor;
                if (assetFileDescriptorOpenAssetFileDescriptor == null) {
                    i11 = 2000;
                    try {
                        throw new zzgs(new IOException("Could not open file descriptor for: " + String.valueOf(uriNormalizeScheme)), 2000);
                    } catch (IOException e11) {
                        e = e11;
                        if (true == (e instanceof FileNotFoundException)) {
                            i11 = 2005;
                        }
                        throw new zzgs(e, i11);
                    }
                }
                long length = assetFileDescriptorOpenAssetFileDescriptor.getLength();
                FileInputStream fileInputStream = new FileInputStream(assetFileDescriptorOpenAssetFileDescriptor.getFileDescriptor());
                this.zzd = fileInputStream;
                if (length != -1 && zzhbVar.zzf > length) {
                    throw new zzgs(null, 2008);
                }
                long startOffset = assetFileDescriptorOpenAssetFileDescriptor.getStartOffset();
                long jSkip = fileInputStream.skip(zzhbVar.zzf + startOffset) - startOffset;
                if (jSkip != zzhbVar.zzf) {
                    throw new zzgs(null, 2008);
                }
                if (length == -1) {
                    FileChannel channel = fileInputStream.getChannel();
                    long size = channel.size();
                    if (size == 0) {
                        this.zze = -1L;
                        jPosition = -1;
                    } else {
                        jPosition = size - channel.position();
                        this.zze = jPosition;
                        if (jPosition < 0) {
                            throw new zzgs(null, 2008);
                        }
                    }
                } else {
                    jPosition = length - jSkip;
                    this.zze = jPosition;
                    if (jPosition < 0) {
                        throw new zzgs(null, 2008);
                    }
                }
                long jMin = zzhbVar.zzg;
                if (jMin != -1) {
                    if (jPosition != -1) {
                        jMin = Math.min(jPosition, jMin);
                    }
                    this.zze = jMin;
                }
                this.zzf = true;
                zzj(zzhbVar);
                long j11 = zzhbVar.zzg;
                return j11 != -1 ? j11 : this.zze;
            } catch (zzgs e12) {
                throw e12;
            }
        } catch (IOException e13) {
            e = e13;
            i11 = 2000;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgw
    @Nullable
    public final Uri zzc() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzgw
    public final void zzd() throws zzgs {
        this.zzb = null;
        try {
            try {
                try {
                    FileInputStream fileInputStream = this.zzd;
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    this.zzd = null;
                    try {
                        AssetFileDescriptor assetFileDescriptor = this.zzc;
                        if (assetFileDescriptor != null) {
                            assetFileDescriptor.close();
                        }
                        this.zzc = null;
                        if (this.zzf) {
                            this.zzf = false;
                            zzh();
                        }
                    } catch (IOException e11) {
                        throw new zzgs(e11, 2000);
                    }
                } catch (IOException e12) {
                    throw new zzgs(e12, 2000);
                }
            } catch (Throwable th2) {
                this.zzd = null;
                try {
                    AssetFileDescriptor assetFileDescriptor2 = this.zzc;
                    if (assetFileDescriptor2 != null) {
                        assetFileDescriptor2.close();
                    }
                    this.zzc = null;
                    if (this.zzf) {
                        this.zzf = false;
                        zzh();
                    }
                    throw th2;
                } catch (IOException e13) {
                    throw new zzgs(e13, 2000);
                }
            }
        } catch (Throwable th3) {
            this.zzc = null;
            if (this.zzf) {
                this.zzf = false;
                zzh();
            }
            throw th3;
        }
    }
}
