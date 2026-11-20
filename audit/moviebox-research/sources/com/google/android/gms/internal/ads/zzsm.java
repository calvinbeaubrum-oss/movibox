package com.google.android.gms.internal.ads;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.HandlerThread;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.util.ArrayDeque;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
@RequiresApi(23)
final class zzsm extends MediaCodec.Callback {
    private final HandlerThread zzb;
    private Handler zzc;

    @Nullable
    private MediaFormat zzh;

    @Nullable
    private MediaFormat zzi;

    @Nullable
    private MediaCodec.CodecException zzj;

    @Nullable
    private MediaCodec.CryptoException zzk;
    private long zzl;
    private boolean zzm;

    @Nullable
    private IllegalStateException zzn;
    private final Object zza = new Object();
    private final androidx.collection.e zzd = new androidx.collection.e();
    private final androidx.collection.e zze = new androidx.collection.e();
    private final ArrayDeque zzf = new ArrayDeque();
    private final ArrayDeque zzg = new ArrayDeque();

    public zzsm(HandlerThread handlerThread) {
        this.zzb = handlerThread;
    }

    public static /* synthetic */ void zzd(zzsm zzsmVar) {
        synchronized (zzsmVar.zza) {
            try {
                if (zzsmVar.zzm) {
                    return;
                }
                long j11 = zzsmVar.zzl - 1;
                zzsmVar.zzl = j11;
                if (j11 > 0) {
                    return;
                }
                if (j11 >= 0) {
                    zzsmVar.zzi();
                    return;
                }
                IllegalStateException illegalStateException = new IllegalStateException();
                synchronized (zzsmVar.zza) {
                    zzsmVar.zzn = illegalStateException;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    private final void zzh(MediaFormat mediaFormat) {
        this.zze.a(-2);
        this.zzg.add(mediaFormat);
    }

    private final void zzi() {
        if (!this.zzg.isEmpty()) {
            this.zzi = (MediaFormat) this.zzg.getLast();
        }
        this.zzd.b();
        this.zze.b();
        this.zzf.clear();
        this.zzg.clear();
    }

    private final void zzj() {
        IllegalStateException illegalStateException = this.zzn;
        if (illegalStateException != null) {
            this.zzn = null;
            throw illegalStateException;
        }
        MediaCodec.CodecException codecException = this.zzj;
        if (codecException != null) {
            this.zzj = null;
            throw codecException;
        }
        MediaCodec.CryptoException cryptoException = this.zzk;
        if (cryptoException == null) {
            return;
        }
        this.zzk = null;
        throw cryptoException;
    }

    private final boolean zzk() {
        return this.zzl > 0 || this.zzm;
    }

    @Override // android.media.MediaCodec.Callback
    public final void onCryptoError(MediaCodec mediaCodec, MediaCodec.CryptoException cryptoException) {
        synchronized (this.zza) {
            this.zzk = cryptoException;
        }
    }

    @Override // android.media.MediaCodec.Callback
    public final void onError(MediaCodec mediaCodec, MediaCodec.CodecException codecException) {
        synchronized (this.zza) {
            this.zzj = codecException;
        }
    }

    @Override // android.media.MediaCodec.Callback
    public final void onInputBufferAvailable(MediaCodec mediaCodec, int i11) {
        synchronized (this.zza) {
            this.zzd.a(i11);
        }
    }

    @Override // android.media.MediaCodec.Callback
    public final void onOutputBufferAvailable(MediaCodec mediaCodec, int i11, MediaCodec.BufferInfo bufferInfo) {
        synchronized (this.zza) {
            try {
                MediaFormat mediaFormat = this.zzi;
                if (mediaFormat != null) {
                    zzh(mediaFormat);
                    this.zzi = null;
                }
                this.zze.a(i11);
                this.zzf.add(bufferInfo);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // android.media.MediaCodec.Callback
    public final void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) {
        synchronized (this.zza) {
            zzh(mediaFormat);
            this.zzi = null;
        }
    }

    public final int zza() {
        synchronized (this.zza) {
            try {
                zzj();
                int iE = -1;
                if (zzk()) {
                    return -1;
                }
                if (!this.zzd.d()) {
                    iE = this.zzd.e();
                }
                return iE;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final int zzb(MediaCodec.BufferInfo bufferInfo) {
        synchronized (this.zza) {
            try {
                zzj();
                if (zzk()) {
                    return -1;
                }
                if (this.zze.d()) {
                    return -1;
                }
                int iE = this.zze.e();
                if (iE >= 0) {
                    zzek.zzb(this.zzh);
                    MediaCodec.BufferInfo bufferInfo2 = (MediaCodec.BufferInfo) this.zzf.remove();
                    bufferInfo.set(bufferInfo2.offset, bufferInfo2.size, bufferInfo2.presentationTimeUs, bufferInfo2.flags);
                } else if (iE == -2) {
                    this.zzh = (MediaFormat) this.zzg.remove();
                    iE = -2;
                }
                return iE;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final MediaFormat zzc() {
        MediaFormat mediaFormat;
        synchronized (this.zza) {
            try {
                mediaFormat = this.zzh;
                if (mediaFormat == null) {
                    throw new IllegalStateException();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return mediaFormat;
    }

    public final void zze() {
        synchronized (this.zza) {
            this.zzl++;
            Handler handler = this.zzc;
            int i11 = zzfy.zza;
            handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzsl
                @Override // java.lang.Runnable
                public final void run() {
                    zzsm.zzd(this.zza);
                }
            });
        }
    }

    public final void zzf(MediaCodec mediaCodec) {
        zzek.zzf(this.zzc == null);
        this.zzb.start();
        Handler handler = new Handler(this.zzb.getLooper());
        mediaCodec.setCallback(this, handler);
        this.zzc = handler;
    }

    public final void zzg() {
        synchronized (this.zza) {
            this.zzm = true;
            this.zzb.quit();
            zzi();
        }
    }
}
