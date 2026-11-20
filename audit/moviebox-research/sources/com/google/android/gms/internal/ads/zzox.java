package com.google.android.gms.internal.ads;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.DeniedByServerException;
import android.media.MediaCodec;
import android.media.MediaDrm;
import android.media.NotProvisionedException;
import android.media.metrics.LogSessionId;
import android.media.metrics.MediaMetricsManager;
import android.media.metrics.PlaybackMetrics;
import android.media.metrics.PlaybackSession;
import android.media.metrics.TrackChangeEvent;
import android.os.SystemClock;
import android.system.ErrnoException;
import android.system.OsConstants;
import android.util.Pair;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.vungle.warren.error.VungleException;
import e4.a3;
import e4.e2;
import e4.l3;
import e4.p2;
import e4.p3;
import e4.q3;
import e4.t1;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.UUID;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
@RequiresApi(VungleException.WEB_CRASH)
public final class zzox implements zzms, zzoy {
    private final Context zza;
    private final zzoz zzb;
    private final PlaybackSession zzc;

    @Nullable
    private String zzi;

    @Nullable
    private PlaybackMetrics.Builder zzj;
    private int zzk;

    @Nullable
    private zzce zzn;

    @Nullable
    private zzow zzo;

    @Nullable
    private zzow zzp;

    @Nullable
    private zzow zzq;

    @Nullable
    private zzam zzr;

    @Nullable
    private zzam zzs;

    @Nullable
    private zzam zzt;
    private boolean zzu;
    private boolean zzv;
    private int zzw;
    private int zzx;
    private int zzy;
    private boolean zzz;
    private final zzcw zze = new zzcw();
    private final zzcu zzf = new zzcu();
    private final HashMap zzh = new HashMap();
    private final HashMap zzg = new HashMap();
    private final long zzd = SystemClock.elapsedRealtime();
    private int zzl = 0;
    private int zzm = 0;

    private zzox(Context context, PlaybackSession playbackSession) {
        this.zza = context.getApplicationContext();
        this.zzc = playbackSession;
        zzov zzovVar = new zzov(zzov.zza);
        this.zzb = zzovVar;
        zzovVar.zzh(this);
    }

    @Nullable
    public static zzox zzb(Context context) {
        MediaMetricsManager mediaMetricsManagerA = q3.a(context.getSystemService("media_metrics"));
        if (mediaMetricsManagerA == null) {
            return null;
        }
        return new zzox(context, mediaMetricsManagerA.createPlaybackSession());
    }

    @SuppressLint({"SwitchIntDef"})
    private static int zzr(int i11) {
        switch (zzfy.zzi(i11)) {
            case 6002:
                return 24;
            case 6003:
                return 28;
            case 6004:
                return 25;
            case 6005:
                return 26;
            default:
                return 27;
        }
    }

    private final void zzs() {
        PlaybackMetrics.Builder builder = this.zzj;
        if (builder != null && this.zzz) {
            builder.setAudioUnderrunCount(this.zzy);
            this.zzj.setVideoFramesDropped(this.zzw);
            this.zzj.setVideoFramesPlayed(this.zzx);
            Long l11 = (Long) this.zzg.get(this.zzi);
            this.zzj.setNetworkTransferDurationMillis(l11 == null ? 0L : l11.longValue());
            Long l12 = (Long) this.zzh.get(this.zzi);
            this.zzj.setNetworkBytesRead(l12 == null ? 0L : l12.longValue());
            this.zzj.setStreamSource((l12 == null || l12.longValue() <= 0) ? 0 : 1);
            this.zzc.reportPlaybackMetrics(this.zzj.build());
        }
        this.zzj = null;
        this.zzi = null;
        this.zzy = 0;
        this.zzw = 0;
        this.zzx = 0;
        this.zzr = null;
        this.zzs = null;
        this.zzt = null;
        this.zzz = false;
    }

    private final void zzt(long j11, @Nullable zzam zzamVar, int i11) {
        if (zzfy.zzF(this.zzs, zzamVar)) {
            return;
        }
        int i12 = this.zzs == null ? 1 : 0;
        this.zzs = zzamVar;
        zzx(0, j11, zzamVar, i12);
    }

    private final void zzu(long j11, @Nullable zzam zzamVar, int i11) {
        if (zzfy.zzF(this.zzt, zzamVar)) {
            return;
        }
        int i12 = this.zzt == null ? 1 : 0;
        this.zzt = zzamVar;
        zzx(2, j11, zzamVar, i12);
    }

    private final void zzv(zzcx zzcxVar, @Nullable zzur zzurVar) {
        int iZza;
        PlaybackMetrics.Builder builder = this.zzj;
        if (zzurVar == null || (iZza = zzcxVar.zza(zzurVar.zza)) == -1) {
            return;
        }
        int i11 = 0;
        zzcxVar.zzd(iZza, this.zzf, false);
        zzcxVar.zze(this.zzf.zzd, this.zze, 0L);
        zzbi zzbiVar = this.zze.zze.zzd;
        if (zzbiVar != null) {
            int iZzm = zzfy.zzm(zzbiVar.zzb);
            if (iZzm == 0) {
                i11 = 3;
            } else if (iZzm != 1) {
                i11 = iZzm != 2 ? 1 : 4;
            } else {
                i11 = 5;
            }
        }
        builder.setStreamType(i11);
        zzcw zzcwVar = this.zze;
        if (zzcwVar.zzo != C.TIME_UNSET && !zzcwVar.zzm && !zzcwVar.zzj && !zzcwVar.zzb()) {
            builder.setMediaDurationMillis(zzfy.zzt(this.zze.zzo));
        }
        builder.setPlaybackType(true != this.zze.zzb() ? 1 : 2);
        this.zzz = true;
    }

    private final void zzw(long j11, @Nullable zzam zzamVar, int i11) {
        if (zzfy.zzF(this.zzr, zzamVar)) {
            return;
        }
        int i12 = this.zzr == null ? 1 : 0;
        this.zzr = zzamVar;
        zzx(1, j11, zzamVar, i12);
    }

    private final void zzx(int i11, long j11, @Nullable zzam zzamVar, int i12) {
        TrackChangeEvent.Builder timeSinceCreatedMillis = e2.a(i11).setTimeSinceCreatedMillis(j11 - this.zzd);
        if (zzamVar != null) {
            timeSinceCreatedMillis.setTrackState(1);
            timeSinceCreatedMillis.setTrackChangeReason(i12 != 1 ? 1 : 2);
            String str = zzamVar.zzl;
            if (str != null) {
                timeSinceCreatedMillis.setContainerMimeType(str);
            }
            String str2 = zzamVar.zzm;
            if (str2 != null) {
                timeSinceCreatedMillis.setSampleMimeType(str2);
            }
            String str3 = zzamVar.zzj;
            if (str3 != null) {
                timeSinceCreatedMillis.setCodecName(str3);
            }
            int i13 = zzamVar.zzi;
            if (i13 != -1) {
                timeSinceCreatedMillis.setBitrate(i13);
            }
            int i14 = zzamVar.zzr;
            if (i14 != -1) {
                timeSinceCreatedMillis.setWidth(i14);
            }
            int i15 = zzamVar.zzs;
            if (i15 != -1) {
                timeSinceCreatedMillis.setHeight(i15);
            }
            int i16 = zzamVar.zzz;
            if (i16 != -1) {
                timeSinceCreatedMillis.setChannelCount(i16);
            }
            int i17 = zzamVar.zzA;
            if (i17 != -1) {
                timeSinceCreatedMillis.setAudioSampleRate(i17);
            }
            String str4 = zzamVar.zzd;
            if (str4 != null) {
                int i18 = zzfy.zza;
                String[] strArrSplit = str4.split("-", -1);
                Pair pairCreate = Pair.create(strArrSplit[0], strArrSplit.length >= 2 ? strArrSplit[1] : null);
                timeSinceCreatedMillis.setLanguage((String) pairCreate.first);
                Object obj = pairCreate.second;
                if (obj != null) {
                    timeSinceCreatedMillis.setLanguageRegion((String) obj);
                }
            }
            float f11 = zzamVar.zzt;
            if (f11 != -1.0f) {
                timeSinceCreatedMillis.setVideoFrameRate(f11);
            }
        } else {
            timeSinceCreatedMillis.setTrackState(0);
        }
        this.zzz = true;
        this.zzc.reportTrackChangeEvent(timeSinceCreatedMillis.build());
    }

    private final boolean zzy(@Nullable zzow zzowVar) {
        if (zzowVar != null) {
            return zzowVar.zzc.equals(this.zzb.zze());
        }
        return false;
    }

    public final LogSessionId zza() {
        return this.zzc.getSessionId();
    }

    @Override // com.google.android.gms.internal.ads.zzoy
    public final void zzc(zzmq zzmqVar, String str) {
        zzur zzurVar = zzmqVar.zzd;
        if (zzurVar == null || !zzurVar.zzb()) {
            zzs();
            this.zzi = str;
            this.zzj = p2.a().setPlayerName("AndroidXMedia3").setPlayerVersion("1.2.1");
            zzv(zzmqVar.zzb, zzmqVar.zzd);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzoy
    public final void zzd(zzmq zzmqVar, String str, boolean z11) {
        zzur zzurVar = zzmqVar.zzd;
        if ((zzurVar == null || !zzurVar.zzb()) && str.equals(this.zzi)) {
            zzs();
        }
        this.zzg.remove(str);
        this.zzh.remove(str);
    }

    @Override // com.google.android.gms.internal.ads.zzms
    public final /* synthetic */ void zze(zzmq zzmqVar, zzam zzamVar, zzis zzisVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzms
    public final void zzf(zzmq zzmqVar, int i11, long j11, long j12) {
        zzur zzurVar = zzmqVar.zzd;
        if (zzurVar != null) {
            zzoz zzozVar = this.zzb;
            zzcx zzcxVar = zzmqVar.zzb;
            HashMap map = this.zzh;
            String strZzf = zzozVar.zzf(zzcxVar, zzurVar);
            Long l11 = (Long) map.get(strZzf);
            Long l12 = (Long) this.zzg.get(strZzf);
            this.zzh.put(strZzf, Long.valueOf((l11 == null ? 0L : l11.longValue()) + j11));
            this.zzg.put(strZzf, Long.valueOf((l12 != null ? l12.longValue() : 0L) + ((long) i11)));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzms
    public final void zzg(zzmq zzmqVar, zzun zzunVar) {
        zzur zzurVar = zzmqVar.zzd;
        if (zzurVar == null) {
            return;
        }
        zzam zzamVar = zzunVar.zzb;
        zzamVar.getClass();
        zzow zzowVar = new zzow(zzamVar, 0, this.zzb.zzf(zzmqVar.zzb, zzurVar));
        int i11 = zzunVar.zza;
        if (i11 != 0) {
            if (i11 == 1) {
                this.zzp = zzowVar;
                return;
            } else if (i11 != 2) {
                if (i11 != 3) {
                    return;
                }
                this.zzq = zzowVar;
                return;
            }
        }
        this.zzo = zzowVar;
    }

    @Override // com.google.android.gms.internal.ads.zzms
    public final /* synthetic */ void zzh(zzmq zzmqVar, int i11, long j11) {
    }

    /* JADX WARN: Code duplicated, block: B:104:0x0172  */
    /* JADX WARN: Code duplicated, block: B:139:0x01ed  */
    /* JADX WARN: Code duplicated, block: B:142:0x01f5 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:143:0x01f7 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:147:0x01ff  */
    /* JADX WARN: Code duplicated, block: B:148:0x020b  */
    /* JADX WARN: Code duplicated, block: B:150:0x0211  */
    /* JADX WARN: Code duplicated, block: B:151:0x021d  */
    /* JADX WARN: Code duplicated, block: B:153:0x0221  */
    /* JADX WARN: Code duplicated, block: B:154:0x0225  */
    /* JADX WARN: Code duplicated, block: B:156:0x0229  */
    /* JADX WARN: Code duplicated, block: B:157:0x0233  */
    /* JADX WARN: Code duplicated, block: B:159:0x0237  */
    /* JADX WARN: Code duplicated, block: B:160:0x0241  */
    /* JADX WARN: Code duplicated, block: B:162:0x0247  */
    /* JADX WARN: Code duplicated, block: B:163:0x0253  */
    /* JADX WARN: Code duplicated, block: B:173:0x029b  */
    /* JADX WARN: Code duplicated, block: B:175:0x02a0  */
    /* JADX WARN: Code duplicated, block: B:177:0x02a5  */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.ads.zzms
    public final void zzi(zzco zzcoVar, zzmr zzmrVar) {
        int i11;
        int i12;
        int i13;
        int errorCode;
        int iZzr;
        int iZzj;
        zzae zzaeVar;
        int i14;
        int i15;
        if (zzmrVar.zzb() == 0) {
            return;
        }
        for (int i16 = 0; i16 < zzmrVar.zzb(); i16++) {
            int iZza = zzmrVar.zza(i16);
            zzmq zzmqVarZzc = zzmrVar.zzc(iZza);
            if (iZza == 0) {
                this.zzb.zzk(zzmqVarZzc);
            } else if (iZza == 11) {
                this.zzb.zzj(zzmqVarZzc, this.zzk);
            } else {
                this.zzb.zzi(zzmqVarZzc);
            }
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (zzmrVar.zzd(0)) {
            zzmq zzmqVarZzc2 = zzmrVar.zzc(0);
            if (this.zzj != null) {
                zzv(zzmqVarZzc2.zzb, zzmqVarZzc2.zzd);
            }
        }
        if (zzmrVar.zzd(2) && this.zzj != null) {
            zzgaa zzgaaVarZza = zzcoVar.zzo().zza();
            int size = zzgaaVarZza.size();
            int i17 = 0;
            loop1: while (true) {
                if (i17 >= size) {
                    zzaeVar = null;
                    break;
                }
                zzdj zzdjVar = (zzdj) zzgaaVarZza.get(i17);
                char c11 = 0;
                while (true) {
                    int i18 = zzdjVar.zzb;
                    i15 = i17 + 1;
                    if (c11 <= 0) {
                        if (zzdjVar.zzd(0) && (zzaeVar = zzdjVar.zzb(0).zzp) != null) {
                            break loop1;
                        } else {
                            c11 = 1;
                        }
                    }
                }
                i17 = i15;
            }
            if (zzaeVar != null) {
                PlaybackMetrics.Builder builder = this.zzj;
                int i19 = zzfy.zza;
                int i21 = 0;
                while (true) {
                    if (i21 >= zzaeVar.zzb) {
                        i14 = 1;
                        break;
                    }
                    UUID uuid = zzaeVar.zza(i21).zza;
                    if (uuid.equals(zzo.zzd)) {
                        i14 = 3;
                        break;
                    } else if (uuid.equals(zzo.zze)) {
                        i14 = 2;
                        break;
                    } else {
                        if (uuid.equals(zzo.zzc)) {
                            i14 = 6;
                            break;
                        }
                        i21++;
                    }
                }
                builder.setDrmType(i14);
            }
        }
        if (zzmrVar.zzd(1011)) {
            this.zzy++;
        }
        zzce zzceVar = this.zzn;
        if (zzceVar != null) {
            Context context = this.zza;
            if (zzceVar.zzb == 1001) {
                i13 = 20;
            } else {
                zziz zzizVar = (zziz) zzceVar;
                boolean z11 = zzizVar.zze == 1;
                int i22 = zzizVar.zzi;
                Throwable cause = zzceVar.getCause();
                cause.getClass();
                if (cause instanceof IOException) {
                    if (cause instanceof zzhr) {
                        iZzj = ((zzhr) cause).zzd;
                        i13 = 5;
                    } else if ((cause instanceof zzhq) || (cause instanceof zzcc)) {
                        i13 = 11;
                    } else {
                        boolean z12 = cause instanceof zzhp;
                        if (z12 || (cause instanceof zzhz)) {
                            if (zzfn.zzb(context).zza() == 1) {
                                i13 = 3;
                            } else {
                                Throwable cause2 = cause.getCause();
                                if (cause2 instanceof UnknownHostException) {
                                    i13 = 6;
                                } else if (cause2 instanceof SocketTimeoutException) {
                                    i13 = 7;
                                } else {
                                    i13 = (z12 && ((zzhp) cause).zzc == 1) ? 4 : 8;
                                }
                            }
                        } else if (zzceVar.zzb == 1002) {
                            i13 = 21;
                        } else if (cause instanceof zzrq) {
                            Throwable cause3 = cause.getCause();
                            cause3.getClass();
                            int i23 = zzfy.zza;
                            if (cause3 instanceof MediaDrm.MediaDrmStateException) {
                                errorCode = zzfy.zzj(((MediaDrm.MediaDrmStateException) cause3).getDiagnosticInfo());
                                iZzr = zzr(errorCode);
                                int i24 = iZzr;
                                iZzj = errorCode;
                                i13 = i24;
                            } else if (zzfy.zza >= 23 && p3.a(cause3)) {
                                i13 = 27;
                            } else if (cause3 instanceof NotProvisionedException) {
                                i13 = 24;
                            } else if (cause3 instanceof DeniedByServerException) {
                                i13 = 29;
                            } else if (cause3 instanceof zzsb) {
                                i13 = 23;
                            } else {
                                i13 = cause3 instanceof zzro ? 28 : 30;
                            }
                        } else if ((cause instanceof zzhl) && (cause.getCause() instanceof FileNotFoundException)) {
                            Throwable cause4 = cause.getCause();
                            cause4.getClass();
                            Throwable cause5 = cause4.getCause();
                            int i25 = zzfy.zza;
                            i13 = ((cause5 instanceof ErrnoException) && ((ErrnoException) cause5).errno == OsConstants.EACCES) ? 32 : 31;
                        } else {
                            i13 = 9;
                        }
                    }
                } else if (z11) {
                    i13 = 35;
                    if (i22 != 0 && i22 != 1) {
                        if (!z11 && i22 == 3) {
                            i13 = 15;
                        } else if (!z11 && i22 == 2) {
                            i13 = 23;
                        } else if (cause instanceof zzsx) {
                            iZzj = zzfy.zzj(((zzsx) cause).zzd);
                            i13 = 13;
                        } else if (cause instanceof zzst) {
                            iZzj = zzfy.zzj(((zzst) cause).zzb);
                            i13 = 14;
                        } else if (cause instanceof OutOfMemoryError) {
                            i13 = 14;
                        } else if (cause instanceof zzpx) {
                            iZzj = ((zzpx) cause).zza;
                            i13 = 17;
                        } else if (cause instanceof zzqa) {
                            iZzj = ((zzqa) cause).zza;
                            i13 = 18;
                        } else {
                            int i26 = zzfy.zza;
                            if (cause instanceof MediaCodec.CryptoException) {
                                errorCode = ((MediaCodec.CryptoException) cause).getErrorCode();
                                iZzr = zzr(errorCode);
                                int i27 = iZzr;
                                iZzj = errorCode;
                                i13 = i27;
                            } else {
                                i13 = 22;
                            }
                        }
                    }
                } else if (!z11) {
                    if (!z11) {
                    }
                    if (cause instanceof zzsx) {
                        iZzj = zzfy.zzj(((zzsx) cause).zzd);
                        i13 = 13;
                    } else if (cause instanceof zzst) {
                        iZzj = zzfy.zzj(((zzst) cause).zzb);
                        i13 = 14;
                    } else if (cause instanceof OutOfMemoryError) {
                        i13 = 14;
                    } else if (cause instanceof zzpx) {
                        iZzj = ((zzpx) cause).zza;
                        i13 = 17;
                    } else if (cause instanceof zzqa) {
                        iZzj = ((zzqa) cause).zza;
                        i13 = 18;
                    } else {
                        int i28 = zzfy.zza;
                        if (cause instanceof MediaCodec.CryptoException) {
                            errorCode = ((MediaCodec.CryptoException) cause).getErrorCode();
                            iZzr = zzr(errorCode);
                            int i29 = iZzr;
                            iZzj = errorCode;
                            i13 = i29;
                        } else {
                            i13 = 22;
                        }
                    }
                } else {
                    if (!z11) {
                    }
                    if (cause instanceof zzsx) {
                        iZzj = zzfy.zzj(((zzsx) cause).zzd);
                        i13 = 13;
                    } else if (cause instanceof zzst) {
                        iZzj = zzfy.zzj(((zzst) cause).zzb);
                        i13 = 14;
                    } else if (cause instanceof OutOfMemoryError) {
                        i13 = 14;
                    } else if (cause instanceof zzpx) {
                        iZzj = ((zzpx) cause).zza;
                        i13 = 17;
                    } else if (cause instanceof zzqa) {
                        iZzj = ((zzqa) cause).zza;
                        i13 = 18;
                    } else {
                        int i210 = zzfy.zza;
                        if (cause instanceof MediaCodec.CryptoException) {
                            errorCode = ((MediaCodec.CryptoException) cause).getErrorCode();
                            iZzr = zzr(errorCode);
                            int i211 = iZzr;
                            iZzj = errorCode;
                            i13 = i211;
                        } else {
                            i13 = 22;
                        }
                    }
                }
                this.zzc.reportPlaybackErrorEvent(t1.a().setTimeSinceCreatedMillis(jElapsedRealtime - this.zzd).setErrorCode(i13).setSubErrorCode(iZzj).setException(zzceVar).build());
                this.zzz = true;
                this.zzn = null;
            }
            iZzj = 0;
            this.zzc.reportPlaybackErrorEvent(t1.a().setTimeSinceCreatedMillis(jElapsedRealtime - this.zzd).setErrorCode(i13).setSubErrorCode(iZzj).setException(zzceVar).build());
            this.zzz = true;
            this.zzn = null;
        }
        if (zzmrVar.zzd(2)) {
            zzdk zzdkVarZzo = zzcoVar.zzo();
            boolean zZzb = zzdkVarZzo.zzb(2);
            boolean zZzb2 = zzdkVarZzo.zzb(1);
            boolean zZzb3 = zzdkVarZzo.zzb(3);
            if (zZzb || zZzb2) {
                if (!zZzb) {
                    zzw(jElapsedRealtime, null, 0);
                }
                if (!zZzb2) {
                    zzt(jElapsedRealtime, null, 0);
                }
                if (!zZzb3) {
                    zzu(jElapsedRealtime, null, 0);
                }
            } else if (zZzb3) {
                zZzb3 = true;
                if (!zZzb) {
                    zzw(jElapsedRealtime, null, 0);
                }
                if (!zZzb2) {
                    zzt(jElapsedRealtime, null, 0);
                }
                if (!zZzb3) {
                    zzu(jElapsedRealtime, null, 0);
                }
            }
        }
        if (zzy(this.zzo)) {
            zzam zzamVar = this.zzo.zza;
            if (zzamVar.zzs != -1) {
                zzw(jElapsedRealtime, zzamVar, 0);
                this.zzo = null;
            }
        }
        if (zzy(this.zzp)) {
            zzt(jElapsedRealtime, this.zzp.zza, 0);
            this.zzp = null;
        }
        if (zzy(this.zzq)) {
            zzu(jElapsedRealtime, this.zzq.zza, 0);
            this.zzq = null;
        }
        switch (zzfn.zzb(this.zza).zza()) {
            case 0:
                i11 = 0;
                break;
            case 1:
                i11 = 9;
                break;
            case 2:
                i11 = 2;
                break;
            case 3:
                i11 = 4;
                break;
            case 4:
                i11 = 5;
                break;
            case 5:
                i11 = 6;
                break;
            case 6:
            case 8:
            default:
                i11 = 1;
                break;
            case 7:
                i11 = 3;
                break;
            case 9:
                i11 = 8;
                break;
            case 10:
                i11 = 7;
                break;
        }
        if (i11 != this.zzm) {
            this.zzm = i11;
            this.zzc.reportNetworkEvent(l3.a().setNetworkType(i11).setTimeSinceCreatedMillis(jElapsedRealtime - this.zzd).build());
        }
        if (zzcoVar.zzf() != 2) {
            this.zzu = false;
        }
        if (((zzml) zzcoVar).zzC() == null) {
            this.zzv = false;
        } else if (zzmrVar.zzd(10)) {
            this.zzv = true;
        }
        int iZzf = zzcoVar.zzf();
        if (this.zzu) {
            i12 = 5;
        } else if (this.zzv) {
            i12 = 13;
        } else {
            i12 = 4;
            if (iZzf == 4) {
                i12 = 11;
            } else if (iZzf == 2) {
                int i31 = this.zzl;
                if (i31 == 0 || i31 == 2) {
                    i12 = 2;
                } else if (zzcoVar.zzv()) {
                    i12 = zzcoVar.zzg() != 0 ? 10 : 6;
                } else {
                    i12 = 7;
                }
            } else if (iZzf != 3) {
                i12 = (iZzf != 1 || this.zzl == 0) ? this.zzl : 12;
            } else if (zzcoVar.zzv()) {
                i12 = zzcoVar.zzg() != 0 ? 9 : 3;
            }
        }
        if (this.zzl != i12) {
            this.zzl = i12;
            this.zzz = true;
            this.zzc.reportPlaybackStateEvent(a3.a().setState(this.zzl).setTimeSinceCreatedMillis(jElapsedRealtime - this.zzd).build());
        }
        if (zzmrVar.zzd(1028)) {
            this.zzb.zzg(zzmrVar.zzc(1028));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzms
    public final void zzj(zzmq zzmqVar, zzui zzuiVar, zzun zzunVar, IOException iOException, boolean z11) {
    }

    @Override // com.google.android.gms.internal.ads.zzms
    public final /* synthetic */ void zzk(zzmq zzmqVar, int i11) {
    }

    @Override // com.google.android.gms.internal.ads.zzms
    public final void zzl(zzmq zzmqVar, zzce zzceVar) {
        this.zzn = zzceVar;
    }

    @Override // com.google.android.gms.internal.ads.zzms
    public final void zzm(zzmq zzmqVar, zzcn zzcnVar, zzcn zzcnVar2, int i11) {
        if (i11 == 1) {
            this.zzu = true;
            i11 = 1;
        }
        this.zzk = i11;
    }

    @Override // com.google.android.gms.internal.ads.zzms
    public final /* synthetic */ void zzn(zzmq zzmqVar, Object obj, long j11) {
    }

    @Override // com.google.android.gms.internal.ads.zzms
    public final void zzo(zzmq zzmqVar, zzir zzirVar) {
        this.zzw += zzirVar.zzg;
        this.zzx += zzirVar.zze;
    }

    @Override // com.google.android.gms.internal.ads.zzms
    public final /* synthetic */ void zzp(zzmq zzmqVar, zzam zzamVar, zzis zzisVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzms
    public final void zzq(zzmq zzmqVar, zzdp zzdpVar) {
        zzow zzowVar = this.zzo;
        if (zzowVar != null) {
            zzam zzamVar = zzowVar.zza;
            if (zzamVar.zzs == -1) {
                zzak zzakVarZzb = zzamVar.zzb();
                zzakVarZzb.zzab(zzdpVar.zzc);
                zzakVarZzb.zzI(zzdpVar.zzd);
                this.zzo = new zzow(zzakVarZzb.zzac(), 0, zzowVar.zzc);
            }
        }
    }
}
