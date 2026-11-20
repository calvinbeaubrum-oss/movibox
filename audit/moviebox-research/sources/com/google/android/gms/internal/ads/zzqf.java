package com.google.android.gms.internal.ads;

import android.media.AudioTrack;
import android.os.SystemClock;
import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzqf {
    private long zzA;
    private long zzB;
    private long zzC;
    private boolean zzD;
    private long zzE;
    private long zzF;
    private boolean zzG;
    private long zzH;
    private zzel zzI;
    private final zzqe zza;
    private final long[] zzb;

    @Nullable
    private AudioTrack zzc;
    private int zzd;

    @Nullable
    private zzqd zze;
    private int zzf;
    private boolean zzg;
    private long zzh;
    private float zzi;
    private boolean zzj;
    private long zzk;
    private long zzl;

    @Nullable
    private Method zzm;
    private long zzn;
    private boolean zzo;
    private boolean zzp;
    private long zzq;
    private long zzr;
    private long zzs;
    private long zzt;
    private long zzu;
    private int zzv;
    private int zzw;
    private long zzx;
    private long zzy;
    private long zzz;

    public zzqf(zzqe zzqeVar) {
        this.zza = zzqeVar;
        int i11 = zzfy.zza;
        try {
            this.zzm = AudioTrack.class.getMethod("getLatency", null);
        } catch (NoSuchMethodException unused) {
        }
        this.zzb = new long[10];
        this.zzI = zzel.zza;
    }

    /* JADX WARN: Code duplicated, block: B:38:0x0099  */
    private final long zzl() {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        int i11 = 2;
        if (this.zzx != C.TIME_UNSET) {
            AudioTrack audioTrack = this.zzc;
            audioTrack.getClass();
            if (audioTrack.getPlayState() == 2) {
                return this.zzz;
            }
            return Math.min(this.zzA, this.zzz + zzfy.zzn(zzfy.zzo(zzfy.zzq(jElapsedRealtime) - this.zzx, this.zzi), this.zzf));
        }
        if (jElapsedRealtime - this.zzr >= 5) {
            AudioTrack audioTrack2 = this.zzc;
            audioTrack2.getClass();
            int playState = audioTrack2.getPlayState();
            if (playState != 1) {
                long playbackHeadPosition = ((long) audioTrack2.getPlaybackHeadPosition()) & 4294967295L;
                long j11 = 0;
                if (this.zzg) {
                    if (playState != 2) {
                        i11 = playState;
                    } else if (playbackHeadPosition == 0) {
                        this.zzu = this.zzs;
                    }
                    playbackHeadPosition += this.zzu;
                    playState = i11;
                }
                if (zzfy.zza > 29) {
                    if (this.zzs > playbackHeadPosition) {
                        this.zzt++;
                    }
                    this.zzs = playbackHeadPosition;
                } else {
                    if (playbackHeadPosition != 0) {
                        j11 = playbackHeadPosition;
                    } else if (this.zzs > 0 && playState == 3) {
                        if (this.zzy == C.TIME_UNSET) {
                            this.zzy = jElapsedRealtime;
                        }
                    }
                    this.zzy = C.TIME_UNSET;
                    playbackHeadPosition = j11;
                    if (this.zzs > playbackHeadPosition) {
                        this.zzt++;
                    }
                    this.zzs = playbackHeadPosition;
                }
            }
            this.zzr = jElapsedRealtime;
        }
        return this.zzs + this.zzH + (this.zzt << 32);
    }

    private final long zzm() {
        return zzfy.zzr(zzl(), this.zzf);
    }

    private final void zzn() {
        this.zzk = 0L;
        this.zzw = 0;
        this.zzv = 0;
        this.zzl = 0L;
        this.zzC = 0L;
        this.zzF = 0L;
        this.zzj = false;
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0065  */
    /* JADX WARN: Code duplicated, block: B:20:0x0075  */
    /* JADX WARN: Code duplicated, block: B:21:0x0078  */
    /* JADX WARN: Code duplicated, block: B:23:0x0091  */
    /* JADX WARN: Code duplicated, block: B:25:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:27:0x00ed  */
    /* JADX WARN: Code duplicated, block: B:28:0x0131  */
    /* JADX WARN: Code duplicated, block: B:39:0x0175 A[Catch: Exception -> 0x018e, TRY_LEAVE, TryCatch #0 {Exception -> 0x018e, blocks: (B:35:0x0148, B:37:0x014e, B:39:0x0175), top: B:67:0x0148 }] */
    /* JADX WARN: Instruction removed from duplicated block: B:23:0x0091, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:27:0x00ed, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:39:0x0175, please report this as an issue */
    public final long zza(boolean z11) {
        long jZzm;
        zzqd zzqdVar;
        long jZzb;
        long jZza;
        String str;
        long jZzm2;
        Method method;
        long jMax;
        zzqf zzqfVar = this;
        AudioTrack audioTrack = zzqfVar.zzc;
        audioTrack.getClass();
        if (audioTrack.getPlayState() == 3) {
            long jNanoTime = System.nanoTime() / 1000;
            if (jNanoTime - zzqfVar.zzl >= 30000) {
                long jZzm3 = zzm();
                if (jZzm3 != 0) {
                    zzqfVar.zzb[zzqfVar.zzv] = zzfy.zzp(jZzm3, zzqfVar.zzi) - jNanoTime;
                    zzqfVar.zzv = (zzqfVar.zzv + 1) % 10;
                    int i11 = zzqfVar.zzw;
                    if (i11 < 10) {
                        zzqfVar.zzw = i11 + 1;
                    }
                    zzqfVar.zzl = jNanoTime;
                    zzqfVar.zzk = 0L;
                    int i12 = 0;
                    while (true) {
                        int i13 = zzqfVar.zzw;
                        if (i12 >= i13) {
                            break;
                        }
                        zzqfVar.zzk += zzqfVar.zzb[i12] / ((long) i13);
                        i12++;
                    }
                    if (!zzqfVar.zzg) {
                        zzqdVar = zzqfVar.zze;
                        zzqdVar.getClass();
                        if (zzqdVar.zzg(jNanoTime)) {
                            jZzb = zzqdVar.zzb();
                            jZza = zzqdVar.zza();
                            str = "DefaultAudioSink";
                            jZzm2 = zzm();
                            if (Math.abs(jZzb - jNanoTime) > 5000000) {
                                zzrd zzrdVar = ((zzqy) zzqfVar.zza).zza;
                                zzff.zzf(str, "Spurious audio timestamp (system clock mismatch): " + jZza + ", " + jZzb + ", " + jNanoTime + ", " + jZzm2 + ", " + zzrdVar.zzI() + ", " + zzrdVar.zzJ());
                                zzqdVar.zzd();
                            } else if (Math.abs(zzfy.zzr(jZza, zzqfVar.zzf) - jZzm2) > 5000000) {
                                zzrd zzrdVar2 = ((zzqy) zzqfVar.zza).zza;
                                zzff.zzf(str, "Spurious audio timestamp (frame position mismatch): " + jZza + ", " + jZzb + ", " + jNanoTime + ", " + jZzm2 + ", " + zzrdVar2.zzI() + ", " + zzrdVar2.zzJ());
                                zzqdVar.zzd();
                            } else {
                                zzqdVar.zzc();
                            }
                            zzqfVar = this;
                        } else {
                            str = "DefaultAudioSink";
                        }
                        if (zzqfVar.zzp && (method = zzqfVar.zzm) != null && jNanoTime - zzqfVar.zzq >= 500000) {
                            try {
                                AudioTrack audioTrack2 = zzqfVar.zzc;
                                audioTrack2.getClass();
                                Integer num = (Integer) method.invoke(audioTrack2, new Object[0]);
                                int i14 = zzfy.zza;
                                long jIntValue = (((long) num.intValue()) * 1000) - zzqfVar.zzh;
                                zzqfVar.zzn = jIntValue;
                                jMax = Math.max(jIntValue, 0L);
                                zzqfVar.zzn = jMax;
                                if (jMax > 5000000) {
                                    zzff.zzf(str, "Ignoring impossibly large audio latency: " + jMax);
                                    zzqfVar.zzn = 0L;
                                }
                            } catch (Exception unused) {
                                zzqfVar.zzm = null;
                            }
                            zzqfVar.zzq = jNanoTime;
                        }
                    }
                }
            } else if (!zzqfVar.zzg) {
                zzqdVar = zzqfVar.zze;
                zzqdVar.getClass();
                if (zzqdVar.zzg(jNanoTime)) {
                    str = "DefaultAudioSink";
                } else {
                    jZzb = zzqdVar.zzb();
                    jZza = zzqdVar.zza();
                    str = "DefaultAudioSink";
                    jZzm2 = zzm();
                    if (Math.abs(jZzb - jNanoTime) > 5000000) {
                        zzrd zzrdVar3 = ((zzqy) zzqfVar.zza).zza;
                        zzff.zzf(str, "Spurious audio timestamp (system clock mismatch): " + jZza + ", " + jZzb + ", " + jNanoTime + ", " + jZzm2 + ", " + zzrdVar3.zzI() + ", " + zzrdVar3.zzJ());
                        zzqdVar.zzd();
                    } else if (Math.abs(zzfy.zzr(jZza, zzqfVar.zzf) - jZzm2) > 5000000) {
                        zzrd zzrdVar4 = ((zzqy) zzqfVar.zza).zza;
                        zzff.zzf(str, "Spurious audio timestamp (frame position mismatch): " + jZza + ", " + jZzb + ", " + jNanoTime + ", " + jZzm2 + ", " + zzrdVar4.zzI() + ", " + zzrdVar4.zzJ());
                        zzqdVar.zzd();
                    } else {
                        zzqdVar.zzc();
                    }
                    zzqfVar = this;
                }
                if (zzqfVar.zzp) {
                    AudioTrack audioTrack3 = zzqfVar.zzc;
                    audioTrack3.getClass();
                    Integer num2 = (Integer) method.invoke(audioTrack3, new Object[0]);
                    int i15 = zzfy.zza;
                    long jIntValue2 = (((long) num2.intValue()) * 1000) - zzqfVar.zzh;
                    zzqfVar.zzn = jIntValue2;
                    jMax = Math.max(jIntValue2, 0L);
                    zzqfVar.zzn = jMax;
                    if (jMax > 5000000) {
                        zzff.zzf(str, "Ignoring impossibly large audio latency: " + jMax);
                        zzqfVar.zzn = 0L;
                    }
                    zzqfVar.zzq = jNanoTime;
                }
            }
        }
        long jNanoTime2 = System.nanoTime() / 1000;
        zzqd zzqdVar2 = zzqfVar.zze;
        zzqdVar2.getClass();
        boolean zZzf = zzqdVar2.zzf();
        if (zZzf) {
            jZzm = zzfy.zzr(zzqdVar2.zza(), zzqfVar.zzf) + zzfy.zzo(jNanoTime2 - zzqdVar2.zzb(), zzqfVar.zzi);
        } else {
            jZzm = zzqfVar.zzw == 0 ? zzm() : zzfy.zzo(zzqfVar.zzk + jNanoTime2, zzqfVar.zzi);
            if (!z11) {
                jZzm = Math.max(0L, jZzm - zzqfVar.zzn);
            }
        }
        if (zzqfVar.zzD != zZzf) {
            zzqfVar.zzF = zzqfVar.zzC;
            zzqfVar.zzE = zzqfVar.zzB;
        }
        long j11 = jNanoTime2 - zzqfVar.zzF;
        if (j11 < 1000000) {
            long jZzo = zzqfVar.zzE + zzfy.zzo(j11, zzqfVar.zzi);
            long j12 = (j11 * 1000) / 1000000;
            jZzm = ((jZzm * j12) + ((1000 - j12) * jZzo)) / 1000;
        }
        if (!zzqfVar.zzj) {
            long j13 = zzqfVar.zzB;
            if (jZzm > j13) {
                zzqfVar.zzj = true;
                int i16 = zzfy.zza;
                long jCurrentTimeMillis = System.currentTimeMillis() - zzfy.zzt(zzfy.zzp(zzfy.zzt(jZzm - j13), zzqfVar.zzi));
                zzrd zzrdVar5 = ((zzqy) zzqfVar.zza).zza;
                if (zzrdVar5.zzp != null) {
                    ((zzri) zzrdVar5.zzp).zza.zzc.zzv(jCurrentTimeMillis);
                }
            }
        }
        zzqfVar.zzC = jNanoTime2;
        zzqfVar.zzB = jZzm;
        zzqfVar.zzD = zZzf;
        return jZzm;
    }

    public final void zzb(long j11) {
        this.zzz = zzl();
        this.zzx = zzfy.zzq(SystemClock.elapsedRealtime());
        this.zzA = j11;
    }

    public final void zzc() {
        zzn();
        this.zzc = null;
        this.zze = null;
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0023  */
    public final void zzd(AudioTrack audioTrack, boolean z11, int i11, int i12, int i13) {
        boolean z12;
        this.zzc = audioTrack;
        this.zzd = i13;
        this.zze = new zzqd(audioTrack);
        this.zzf = audioTrack.getSampleRate();
        if (!z11 || zzfy.zza >= 23) {
            z12 = false;
        } else {
            z12 = true;
            if (i11 != 5) {
                if (i11 == 6) {
                    i11 = 6;
                } else {
                    z12 = false;
                }
            }
        }
        this.zzg = z12;
        boolean zZzH = zzfy.zzH(i11);
        this.zzp = zZzH;
        this.zzh = zZzH ? zzfy.zzr(i13 / i12, this.zzf) : -9223372036854775807L;
        this.zzs = 0L;
        this.zzt = 0L;
        this.zzG = false;
        this.zzH = 0L;
        this.zzu = 0L;
        this.zzo = false;
        this.zzx = C.TIME_UNSET;
        this.zzy = C.TIME_UNSET;
        this.zzq = 0L;
        this.zzn = 0L;
        this.zzi = 1.0f;
    }

    public final void zze(zzel zzelVar) {
        this.zzI = zzelVar;
    }

    public final void zzf() {
        if (this.zzx != C.TIME_UNSET) {
            this.zzx = zzfy.zzq(SystemClock.elapsedRealtime());
        }
        zzqd zzqdVar = this.zze;
        zzqdVar.getClass();
        zzqdVar.zze();
    }

    public final boolean zzg(long j11) {
        if (j11 > zzfy.zzn(zza(false), this.zzf)) {
            return true;
        }
        if (this.zzg) {
            AudioTrack audioTrack = this.zzc;
            audioTrack.getClass();
            if (audioTrack.getPlayState() == 2 && zzl() == 0) {
                return true;
            }
        }
        return false;
    }

    public final boolean zzh() {
        AudioTrack audioTrack = this.zzc;
        audioTrack.getClass();
        return audioTrack.getPlayState() == 3;
    }

    public final boolean zzi(long j11) {
        return this.zzy != C.TIME_UNSET && j11 > 0 && SystemClock.elapsedRealtime() - this.zzy >= 200;
    }

    public final boolean zzj(long j11) {
        AudioTrack audioTrack = this.zzc;
        audioTrack.getClass();
        int playState = audioTrack.getPlayState();
        if (this.zzg) {
            if (playState == 2) {
                this.zzo = false;
                return false;
            }
            if (playState == 1) {
                if (zzl() == 0) {
                    return false;
                }
                playState = 1;
            }
        }
        boolean z11 = this.zzo;
        boolean zZzg = zzg(j11);
        this.zzo = zZzg;
        if (z11 && !zZzg && playState != 1) {
            zzqe zzqeVar = this.zza;
            int i11 = this.zzd;
            long jZzt = zzfy.zzt(this.zzh);
            zzqy zzqyVar = (zzqy) zzqeVar;
            zzrd zzrdVar = zzqyVar.zza;
            if (zzrdVar.zzp != null) {
                ((zzri) zzqyVar.zza.zzp).zza.zzc.zzx(i11, jZzt, SystemClock.elapsedRealtime() - zzrdVar.zzS);
            }
        }
        return true;
    }

    public final boolean zzk() {
        zzn();
        if (this.zzx != C.TIME_UNSET) {
            this.zzz = zzl();
            return false;
        }
        zzqd zzqdVar = this.zze;
        zzqdVar.getClass();
        zzqdVar.zze();
        return true;
    }
}
