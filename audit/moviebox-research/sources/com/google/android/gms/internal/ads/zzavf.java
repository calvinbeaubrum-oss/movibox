package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.core.view.PointerIconCompat;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public abstract class zzavf implements zzave {
    protected static volatile zzawj zza;
    protected MotionEvent zzb;
    protected double zzk;
    protected float zzl;
    protected float zzm;
    protected float zzn;
    protected float zzo;
    protected DisplayMetrics zzq;

    @Nullable
    protected zzawb zzr;
    private double zzs;
    private double zzt;
    protected final LinkedList zzc = new LinkedList();
    protected long zzd = 0;
    protected long zze = 0;
    protected long zzf = 0;
    protected long zzg = 0;
    protected long zzh = 0;
    protected long zzi = 0;
    protected long zzj = 0;
    private boolean zzu = false;
    protected boolean zzp = false;

    public zzavf(Context context) {
        try {
            zzatx.zzd();
            this.zzq = context.getResources().getDisplayMetrics();
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzcz)).booleanValue()) {
                this.zzr = new zzawb();
            }
        } catch (Throwable unused) {
        }
    }

    private final void zzj() {
        this.zzh = 0L;
        this.zzd = 0L;
        this.zze = 0L;
        this.zzf = 0L;
        this.zzg = 0L;
        this.zzi = 0L;
        this.zzj = 0L;
        if (this.zzc.isEmpty()) {
            MotionEvent motionEvent = this.zzb;
            if (motionEvent != null) {
                motionEvent.recycle();
            }
        } else {
            Iterator it = this.zzc.iterator();
            while (it.hasNext()) {
                ((MotionEvent) it.next()).recycle();
            }
            this.zzc.clear();
        }
        this.zzb = null;
    }

    /* JADX WARN: Code duplicated, block: B:46:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:47:0x00ba A[Catch: Exception -> 0x00f2, TryCatch #2 {Exception -> 0x00f2, blocks: (B:44:0x00ad, B:47:0x00ba, B:55:0x00e2, B:58:0x00f6), top: B:75:0x00ad }] */
    /* JADX WARN: Code duplicated, block: B:49:0x00ce A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:51:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:52:0x00d7 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:53:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:54:0x00de  */
    /* JADX WARN: Code duplicated, block: B:58:0x00f6 A[Catch: Exception -> 0x00f2, TRY_LEAVE, TryCatch #2 {Exception -> 0x00f2, blocks: (B:44:0x00ad, B:47:0x00ba, B:55:0x00e2, B:58:0x00f6), top: B:75:0x00ad }] */
    /* JADX WARN: Code duplicated, block: B:75:0x00ad A[EXC_TOP_SPLITTER, SYNTHETIC] */
    private final String zzm(Context context, String str, int i11, View view, Activity activity, byte[] bArr) {
        zzavd zzavdVarZzd;
        String str2;
        int i12;
        Exception exc;
        int i13;
        int i14;
        long jCurrentTimeMillis;
        String strZza;
        int i15;
        int i16;
        int i17;
        int i18 = i11;
        long jCurrentTimeMillis2 = System.currentTimeMillis();
        boolean zBooleanValue = ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzcr)).booleanValue();
        zzasg zzasgVarZzc = null;
        if (zBooleanValue) {
            zzavdVarZzd = zza != null ? zza.zzd() : null;
            str2 = "be";
        } else {
            zzavdVarZzd = null;
            str2 = null;
        }
        try {
            if (i18 == 3) {
                zzasgVarZzc = zzb(context, view, activity);
                try {
                    this.zzu = true;
                    i17 = 1002;
                } catch (Exception e11) {
                    exc = e11;
                    i12 = 3;
                    if (!zBooleanValue) {
                    }
                    jCurrentTimeMillis = System.currentTimeMillis();
                    if (zzasgVarZzc != null) {
                        try {
                            if (((zzatd) zzasgVarZzc.zzal()).zzaz() == 0) {
                                strZza = Integer.toString(5);
                            } else {
                                zzatd zzatdVar = (zzatd) zzasgVarZzc.zzal();
                                int i19 = zzatx.zzc;
                                strZza = zzatx.zza(zzatdVar.zzax(), str);
                                if (zBooleanValue) {
                                    if (i18 == i12) {
                                        i15 = PointerIconCompat.TYPE_CELL;
                                    } else if (i18 == i13) {
                                        i15 = 1010;
                                    } else {
                                        i15 = 1004;
                                    }
                                    zzavdVarZzd.zzc(i15, -1, System.currentTimeMillis() - jCurrentTimeMillis, str2, null);
                                }
                            }
                        } catch (Exception e12) {
                            strZza = Integer.toString(7);
                            if (zBooleanValue && zzavdVarZzd != null) {
                                if (i18 == i12) {
                                    i16 = PointerIconCompat.TYPE_CROSSHAIR;
                                } else {
                                    i16 = i18 == i13 ? 1011 : 1005;
                                }
                                zzavdVarZzd.zzc(i16, -1, System.currentTimeMillis() - jCurrentTimeMillis, str2, e12);
                            }
                        }
                    } else {
                        strZza = Integer.toString(5);
                    }
                    return strZza;
                }
            } else if (i18 == 2) {
                zzasgVarZzc = zzd(context, view, activity);
                i17 = PointerIconCompat.TYPE_TEXT;
            } else {
                zzasgVarZzc = zzc(context, null);
                i17 = 1000;
            }
            if (!zBooleanValue || zzavdVarZzd == null) {
                i12 = 3;
            } else {
                i12 = 3;
                try {
                    zzavdVarZzd.zzc(i17, -1, System.currentTimeMillis() - jCurrentTimeMillis2, str2, null);
                } catch (Exception e13) {
                    e = e13;
                    exc = e;
                    if (!zBooleanValue && zzavdVarZzd != null) {
                        if (i18 == i12) {
                            i13 = 2;
                            i14 = 1003;
                        } else {
                            i13 = 2;
                            if (i18 == 2) {
                                i14 = PointerIconCompat.TYPE_VERTICAL_TEXT;
                            } else {
                                i18 = 1;
                                i14 = 1001;
                            }
                        }
                        zzavdVarZzd.zzc(i14, -1, System.currentTimeMillis() - jCurrentTimeMillis2, str2, exc);
                    }
                    jCurrentTimeMillis = System.currentTimeMillis();
                    if (zzasgVarZzc != null) {
                        strZza = Integer.toString(5);
                    } else if (((zzatd) zzasgVarZzc.zzal()).zzaz() == 0) {
                        strZza = Integer.toString(5);
                    } else {
                        zzatd zzatdVar2 = (zzatd) zzasgVarZzc.zzal();
                        int i110 = zzatx.zzc;
                        strZza = zzatx.zza(zzatdVar2.zzax(), str);
                        if (zBooleanValue) {
                            if (i18 == i12) {
                                i15 = PointerIconCompat.TYPE_CELL;
                            } else if (i18 == i13) {
                                i15 = 1010;
                            } else {
                                i15 = 1004;
                            }
                            zzavdVarZzd.zzc(i15, -1, System.currentTimeMillis() - jCurrentTimeMillis, str2, null);
                        }
                    }
                    return strZza;
                }
            }
        } catch (Exception e14) {
            e = e14;
            i12 = 3;
        }
        i13 = 2;
        jCurrentTimeMillis = System.currentTimeMillis();
        if (zzasgVarZzc != null) {
            strZza = Integer.toString(5);
        } else if (((zzatd) zzasgVarZzc.zzal()).zzaz() == 0) {
            strZza = Integer.toString(5);
        } else {
            zzatd zzatdVar3 = (zzatd) zzasgVarZzc.zzal();
            int i111 = zzatx.zzc;
            strZza = zzatx.zza(zzatdVar3.zzax(), str);
            if (zBooleanValue && zzavdVarZzd != null) {
                if (i18 == i12) {
                    i15 = PointerIconCompat.TYPE_CELL;
                } else if (i18 == i13) {
                    i15 = 1010;
                } else {
                    i15 = 1004;
                }
                zzavdVarZzd.zzc(i15, -1, System.currentTimeMillis() - jCurrentTimeMillis, str2, null);
            }
        }
        return strZza;
    }

    public abstract long zza(StackTraceElement[] stackTraceElementArr) throws zzavz;

    public abstract zzasg zzb(Context context, View view, Activity activity);

    public abstract zzasg zzc(Context context, zzarz zzarzVar);

    public abstract zzasg zzd(Context context, View view, Activity activity);

    @Override // com.google.android.gms.internal.ads.zzave
    public final String zze(Context context, @Nullable String str, @Nullable View view) {
        return zzm(context, str, 3, view, null, null);
    }

    @Override // com.google.android.gms.internal.ads.zzave
    public final String zzf(Context context, @Nullable String str, @Nullable View view, @Nullable Activity activity) {
        return zzm(context, str, 3, view, activity, null);
    }

    @Override // com.google.android.gms.internal.ads.zzave
    public final String zzg(Context context) {
        if (zzawm.zzc()) {
            throw new IllegalStateException("The caller must not be called from the UI thread.");
        }
        return zzm(context, null, 1, null, null, null);
    }

    @Override // com.google.android.gms.internal.ads.zzave
    public final String zzh(Context context, @Nullable View view, @Nullable Activity activity) {
        return zzm(context, null, 2, view, activity, null);
    }

    public abstract zzawl zzi(MotionEvent motionEvent) throws zzavz;

    @Override // com.google.android.gms.internal.ads.zzave
    public final synchronized void zzk(@Nullable MotionEvent motionEvent) {
        Long l11;
        try {
            if (this.zzu) {
                zzj();
                this.zzu = false;
            }
            int action = motionEvent.getAction();
            if (action == 0) {
                this.zzk = 0.0d;
                this.zzs = motionEvent.getRawX();
                this.zzt = motionEvent.getRawY();
            } else if (action == 1 || action == 2) {
                double rawX = motionEvent.getRawX();
                double rawY = motionEvent.getRawY();
                double d11 = rawX - this.zzs;
                double d12 = rawY - this.zzt;
                this.zzk += Math.sqrt((d11 * d11) + (d12 * d12));
                this.zzs = rawX;
                this.zzt = rawY;
            }
            int action2 = motionEvent.getAction();
            if (action2 != 0) {
                try {
                    if (action2 == 1) {
                        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
                        this.zzb = motionEventObtain;
                        this.zzc.add(motionEventObtain);
                        if (this.zzc.size() > 6) {
                            ((MotionEvent) this.zzc.remove()).recycle();
                        }
                        this.zzf++;
                        this.zzh = zza(new Throwable().getStackTrace());
                    } else if (action2 == 2) {
                        this.zze += (long) (motionEvent.getHistorySize() + 1);
                        zzawl zzawlVarZzi = zzi(motionEvent);
                        Long l12 = zzawlVarZzi.zzd;
                        if (l12 != null && zzawlVarZzi.zzg != null) {
                            this.zzi += l12.longValue() + zzawlVarZzi.zzg.longValue();
                        }
                        if (this.zzq != null && (l11 = zzawlVarZzi.zze) != null && zzawlVarZzi.zzh != null) {
                            this.zzj += l11.longValue() + zzawlVarZzi.zzh.longValue();
                        }
                    } else if (action2 == 3) {
                        this.zzg++;
                    }
                } catch (zzavz unused) {
                }
            } else {
                this.zzl = motionEvent.getX();
                this.zzm = motionEvent.getY();
                this.zzn = motionEvent.getRawX();
                this.zzo = motionEvent.getRawY();
                this.zzd++;
            }
            this.zzp = true;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzave
    public final synchronized void zzl(int i11, int i12, int i13) {
        try {
            if (this.zzb != null) {
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzcp)).booleanValue()) {
                    zzj();
                } else {
                    this.zzb.recycle();
                }
            }
            DisplayMetrics displayMetrics = this.zzq;
            if (displayMetrics != null) {
                float f11 = displayMetrics.density;
                this.zzb = MotionEvent.obtain(0L, i13, 1, i11 * f11, i12 * f11, 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
            } else {
                this.zzb = null;
            }
            this.zzp = false;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzave
    public final void zzn(StackTraceElement[] stackTraceElementArr) {
        zzawb zzawbVar;
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzcz)).booleanValue() || (zzawbVar = this.zzr) == null) {
            return;
        }
        zzawbVar.zzb(Arrays.asList(stackTraceElementArr));
    }

    @Override // com.google.android.gms.internal.ads.zzave
    public void zzo(View view) {
    }
}
