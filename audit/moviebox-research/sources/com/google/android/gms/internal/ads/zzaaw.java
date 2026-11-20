package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.Display;
import android.view.Surface;
import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.C;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzaaw {
    private final zzaad zza = new zzaad();

    @Nullable
    private final zzaas zzb;

    @Nullable
    private final zzaav zzc;
    private boolean zzd;

    @Nullable
    private Surface zze;
    private float zzf;
    private float zzg;
    private float zzh;
    private float zzi;
    private int zzj;
    private long zzk;
    private long zzl;
    private long zzm;
    private long zzn;
    private long zzo;
    private long zzp;
    private long zzq;

    public zzaaw(@Nullable Context context) {
        zzaas zzaasVarZzc;
        if (context != null) {
            Context applicationContext = context.getApplicationContext();
            int i11 = zzfy.zza;
            zzaasVarZzc = zzaau.zzc(applicationContext);
            if (zzaasVarZzc == null) {
                zzaasVarZzc = zzaat.zzc(applicationContext);
            }
        } else {
            zzaasVarZzc = null;
        }
        this.zzb = zzaasVarZzc;
        this.zzc = zzaasVarZzc != null ? zzaav.zza() : null;
        this.zzk = C.TIME_UNSET;
        this.zzl = C.TIME_UNSET;
        this.zzf = -1.0f;
        this.zzi = 1.0f;
        this.zzj = 0;
    }

    public static /* synthetic */ void zzb(zzaaw zzaawVar, Display display) {
        if (display != null) {
            long refreshRate = (long) (1.0E9d / ((double) display.getRefreshRate()));
            zzaawVar.zzk = refreshRate;
            zzaawVar.zzl = (refreshRate * 80) / 100;
        } else {
            zzff.zzf("VideoFrameReleaseHelper", "Unable to query display refresh rate");
            zzaawVar.zzk = C.TIME_UNSET;
            zzaawVar.zzl = C.TIME_UNSET;
        }
    }

    private final void zzk() {
        Surface surface;
        if (zzfy.zza < 30 || (surface = this.zze) == null || this.zzj == Integer.MIN_VALUE || this.zzh == 0.0f) {
            return;
        }
        this.zzh = 0.0f;
        zzaar.zza(surface, 0.0f);
    }

    private final void zzl() {
        this.zzm = 0L;
        this.zzp = -1L;
        this.zzn = -1L;
    }

    private final void zzm() {
        if (zzfy.zza < 30 || this.zze == null) {
            return;
        }
        float fZza = this.zza.zzg() ? this.zza.zza() : this.zzf;
        float f11 = this.zzg;
        if (fZza != f11) {
            if (fZza != -1.0f && f11 != -1.0f) {
                float f12 = 1.0f;
                if (this.zza.zzg() && this.zza.zzd() >= 5000000000L) {
                    f12 = 0.02f;
                }
                if (Math.abs(fZza - this.zzg) < f12) {
                    return;
                }
            } else if (fZza == -1.0f && this.zza.zzb() < 30) {
                return;
            }
            this.zzg = fZza;
            zzn(false);
        }
    }

    private final void zzn(boolean z11) {
        Surface surface;
        if (zzfy.zza < 30 || (surface = this.zze) == null || this.zzj == Integer.MIN_VALUE) {
            return;
        }
        float f11 = 0.0f;
        if (this.zzd) {
            float f12 = this.zzg;
            if (f12 != -1.0f) {
                f11 = this.zzi * f12;
            }
        }
        if (z11 || this.zzh != f11) {
            this.zzh = f11;
            zzaar.zza(surface, f11);
        }
    }

    public final long zza(long j11) {
        long j12;
        if (this.zzp != -1 && this.zza.zzg()) {
            long jZzc = this.zzq + ((long) ((this.zza.zzc() * (this.zzm - this.zzp)) / this.zzi));
            if (Math.abs(j11 - jZzc) > 20000000) {
                zzl();
            } else {
                j11 = jZzc;
            }
        }
        this.zzn = this.zzm;
        this.zzo = j11;
        zzaav zzaavVar = this.zzc;
        if (zzaavVar != null && this.zzk != C.TIME_UNSET) {
            long j13 = zzaavVar.zza;
            if (j13 != C.TIME_UNSET) {
                long j14 = this.zzk;
                long j15 = j13 + (((j11 - j13) / j14) * j14);
                if (j11 <= j15) {
                    j12 = j15 - j14;
                } else {
                    j15 = j14 + j15;
                    j12 = j15;
                }
                long j16 = this.zzl;
                if (j15 - j11 >= j11 - j12) {
                    j15 = j12;
                }
                return j15 - j16;
            }
        }
        return j11;
    }

    public final void zzc(float f11) {
        this.zzf = f11;
        this.zza.zzf();
        zzm();
    }

    public final void zzd(long j11) {
        long j12 = this.zzn;
        if (j12 != -1) {
            this.zzp = j12;
            this.zzq = this.zzo;
        }
        this.zzm++;
        this.zza.zze(j11 * 1000);
        zzm();
    }

    public final void zze(float f11) {
        this.zzi = f11;
        zzl();
        zzn(false);
    }

    public final void zzf() {
        zzl();
    }

    public final void zzg() {
        this.zzd = true;
        zzl();
        if (this.zzb != null) {
            zzaav zzaavVar = this.zzc;
            zzaavVar.getClass();
            zzaavVar.zzb();
            this.zzb.zzb(new zzaap(this));
        }
        zzn(false);
    }

    public final void zzh() {
        this.zzd = false;
        zzaas zzaasVar = this.zzb;
        if (zzaasVar != null) {
            zzaasVar.zza();
            zzaav zzaavVar = this.zzc;
            zzaavVar.getClass();
            zzaavVar.zzc();
        }
        zzk();
    }

    public final void zzi(@Nullable Surface surface) {
        int i11 = zzfy.zza;
        boolean zZza = zzaaq.zza(surface);
        Surface surface2 = this.zze;
        if (true == zZza) {
            surface = null;
        }
        if (surface2 == surface) {
            return;
        }
        zzk();
        this.zze = surface;
        zzn(true);
    }

    public final void zzj(int i11) {
        if (this.zzj == i11) {
            return;
        }
        this.zzj = i11;
        zzn(true);
    }
}
