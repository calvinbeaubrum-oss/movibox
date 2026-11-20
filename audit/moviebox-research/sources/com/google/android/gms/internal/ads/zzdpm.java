package com.google.android.gms.internal.ads;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Looper;
import com.google.android.gms.common.util.Clock;
import com.google.common.util.concurrent.s;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzdpm {
    private final com.google.android.gms.ads.internal.util.zzbq zza;
    private final Clock zzb;
    private final Executor zzc;

    public zzdpm(com.google.android.gms.ads.internal.util.zzbq zzbqVar, Clock clock, Executor executor) {
        this.zza = zzbqVar;
        this.zzb = clock;
        this.zzc = executor;
    }

    private final Bitmap zzc(byte[] bArr, BitmapFactory.Options options) {
        long jElapsedRealtime = this.zzb.elapsedRealtime();
        Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        long jElapsedRealtime2 = this.zzb.elapsedRealtime();
        if (bitmapDecodeByteArray != null) {
            long j11 = jElapsedRealtime2 - jElapsedRealtime;
            com.google.android.gms.ads.internal.util.zze.zza("Decoded image w: " + bitmapDecodeByteArray.getWidth() + " h:" + bitmapDecodeByteArray.getHeight() + " bytes: " + bitmapDecodeByteArray.getAllocationByteCount() + " time: " + j11 + " on ui thread: " + (Looper.getMainLooper().getThread() == Thread.currentThread()));
        }
        return bitmapDecodeByteArray;
    }

    public final /* synthetic */ Bitmap zza(double d11, boolean z11, zzapw zzapwVar) {
        byte[] bArr = zzapwVar.zzb;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inDensity = (int) (d11 * 160.0d);
        if (!z11) {
            options.inPreferredConfig = Bitmap.Config.RGB_565;
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzgg)).booleanValue()) {
            options.inJustDecodeBounds = true;
            zzc(bArr, options);
            options.inJustDecodeBounds = false;
            int i11 = options.outWidth * options.outHeight;
            if (i11 > 0) {
                options.inSampleSize = 1 << ((33 - Integer.numberOfLeadingZeros((i11 - 1) / ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzgh)).intValue())) / 2);
            }
        }
        return zzc(bArr, options);
    }

    public final s zzb(String str, final double d11, final boolean z11) {
        return zzgen.zzm(this.zza.zza(str), new zzfws() { // from class: com.google.android.gms.internal.ads.zzdpl
            @Override // com.google.android.gms.internal.ads.zzfws
            public final Object apply(Object obj) {
                return this.zza.zza(d11, z11, (zzapw) obj);
            }
        }, this.zzc);
    }
}
