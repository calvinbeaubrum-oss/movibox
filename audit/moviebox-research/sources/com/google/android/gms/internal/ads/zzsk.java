package com.google.android.gms.internal.ads;

import android.media.MediaCodec;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
@RequiresApi(23)
final class zzsk implements zzss {
    private static final ArrayDeque zza = new ArrayDeque();
    private static final Object zzb = new Object();
    private final MediaCodec zzc;
    private final HandlerThread zzd;
    private Handler zze;
    private final AtomicReference zzf;
    private final zzeo zzg;
    private boolean zzh;

    public zzsk(MediaCodec mediaCodec, HandlerThread handlerThread) {
        zzeo zzeoVar = new zzeo(zzel.zza);
        this.zzc = mediaCodec;
        this.zzd = handlerThread;
        this.zzg = zzeoVar;
        this.zzf = new AtomicReference();
    }

    /* JADX WARN: Code duplicated, block: B:35:0x0074  */
    /* JADX WARN: Code duplicated, block: B:43:0x007f A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:45:0x0077 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public static /* bridge */ /* synthetic */ void zza(zzsk zzskVar, Message message) {
        zzsj zzsjVar;
        ArrayDeque arrayDeque;
        int i11 = message.what;
        zzsj zzsjVar2 = null;
        if (i11 != 0) {
            if (i11 == 1) {
                zzsjVar = (zzsj) message.obj;
                int i12 = zzsjVar.zza;
                MediaCodec.CryptoInfo cryptoInfo = zzsjVar.zzd;
                long j11 = zzsjVar.zze;
                int i13 = zzsjVar.zzf;
                try {
                    synchronized (zzb) {
                        zzskVar.zzc.queueSecureInputBuffer(i12, 0, cryptoInfo, j11, i13);
                    }
                } catch (RuntimeException e11) {
                    zzsh.zza(zzskVar.zzf, null, e11);
                }
            } else if (i11 == 2) {
                zzskVar.zzg.zze();
            } else if (i11 != 3) {
                zzsh.zza(zzskVar.zzf, null, new IllegalStateException(String.valueOf(message.what)));
            } else {
                try {
                    zzskVar.zzc.setParameters((Bundle) message.obj);
                } catch (RuntimeException e12) {
                    zzsh.zza(zzskVar.zzf, null, e12);
                }
            }
            if (zzsjVar2 != null) {
                arrayDeque = zza;
                synchronized (arrayDeque) {
                    arrayDeque.add(zzsjVar2);
                }
            }
        }
        zzsjVar = (zzsj) message.obj;
        try {
            zzskVar.zzc.queueInputBuffer(zzsjVar.zza, 0, zzsjVar.zzc, zzsjVar.zze, zzsjVar.zzf);
        } catch (RuntimeException e13) {
            zzsh.zza(zzskVar.zzf, null, e13);
        }
        zzsjVar2 = zzsjVar;
        if (zzsjVar2 != null) {
            arrayDeque = zza;
            synchronized (arrayDeque) {
                arrayDeque.add(zzsjVar2);
            }
        }
    }

    private static zzsj zzi() {
        ArrayDeque arrayDeque = zza;
        synchronized (arrayDeque) {
            try {
                if (arrayDeque.isEmpty()) {
                    return new zzsj();
                }
                return (zzsj) arrayDeque.removeFirst();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Nullable
    private static byte[] zzj(@Nullable byte[] bArr, @Nullable byte[] bArr2) {
        int length;
        if (bArr == null) {
            return bArr2;
        }
        if (bArr2 == null || bArr2.length < (length = bArr.length)) {
            return Arrays.copyOf(bArr, bArr.length);
        }
        System.arraycopy(bArr, 0, bArr2, 0, length);
        return bArr2;
    }

    @Nullable
    private static int[] zzk(@Nullable int[] iArr, @Nullable int[] iArr2) {
        int length;
        if (iArr == null) {
            return iArr2;
        }
        if (iArr2 == null || iArr2.length < (length = iArr.length)) {
            return Arrays.copyOf(iArr, iArr.length);
        }
        System.arraycopy(iArr, 0, iArr2, 0, length);
        return iArr2;
    }

    @Override // com.google.android.gms.internal.ads.zzss
    public final void zzb() {
        if (this.zzh) {
            try {
                Handler handler = this.zze;
                handler.getClass();
                handler.removeCallbacksAndMessages(null);
                this.zzg.zzc();
                Handler handler2 = this.zze;
                handler2.getClass();
                handler2.obtainMessage(2).sendToTarget();
                this.zzg.zza();
            } catch (InterruptedException e11) {
                Thread.currentThread().interrupt();
                throw new IllegalStateException(e11);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzss
    public final void zzc() {
        RuntimeException runtimeException = (RuntimeException) this.zzf.getAndSet(null);
        if (runtimeException != null) {
            throw runtimeException;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzss
    public final void zzd(int i11, int i12, int i13, long j11, int i14) {
        zzc();
        zzsj zzsjVarZzi = zzi();
        zzsjVarZzi.zza(i11, 0, i13, j11, i14);
        Handler handler = this.zze;
        int i15 = zzfy.zza;
        handler.obtainMessage(0, zzsjVarZzi).sendToTarget();
    }

    @Override // com.google.android.gms.internal.ads.zzss
    public final void zze(int i11, int i12, zzie zzieVar, long j11, int i13) {
        zzc();
        zzsj zzsjVarZzi = zzi();
        zzsjVarZzi.zza(i11, 0, 0, j11, 0);
        MediaCodec.CryptoInfo cryptoInfo = zzsjVarZzi.zzd;
        cryptoInfo.numSubSamples = zzieVar.zzf;
        cryptoInfo.numBytesOfClearData = zzk(zzieVar.zzd, cryptoInfo.numBytesOfClearData);
        cryptoInfo.numBytesOfEncryptedData = zzk(zzieVar.zze, cryptoInfo.numBytesOfEncryptedData);
        byte[] bArrZzj = zzj(zzieVar.zzb, cryptoInfo.key);
        bArrZzj.getClass();
        cryptoInfo.key = bArrZzj;
        byte[] bArrZzj2 = zzj(zzieVar.zza, cryptoInfo.iv);
        bArrZzj2.getClass();
        cryptoInfo.iv = bArrZzj2;
        cryptoInfo.mode = zzieVar.zzc;
        if (zzfy.zza >= 24) {
            m4.f.a();
            cryptoInfo.setPattern(androidx.media3.decoder.d.a(zzieVar.zzg, zzieVar.zzh));
        }
        this.zze.obtainMessage(1, zzsjVarZzi).sendToTarget();
    }

    @Override // com.google.android.gms.internal.ads.zzss
    public final void zzf(Bundle bundle) {
        zzc();
        Handler handler = this.zze;
        int i11 = zzfy.zza;
        handler.obtainMessage(3, bundle).sendToTarget();
    }

    @Override // com.google.android.gms.internal.ads.zzss
    public final void zzg() {
        if (this.zzh) {
            zzb();
            this.zzd.quit();
        }
        this.zzh = false;
    }

    @Override // com.google.android.gms.internal.ads.zzss
    public final void zzh() {
        if (this.zzh) {
            return;
        }
        this.zzd.start();
        this.zze = new zzsi(this, this.zzd.getLooper());
        this.zzh = true;
    }
}
