package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Point;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.Api;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzyg extends zzyl implements zzmg {
    public static final /* synthetic */ int zzb = 0;
    private static final zzgbj zzc = zzgbj.zzb(new Comparator() { // from class: com.google.android.gms.internal.ads.zzxc
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            Integer num = (Integer) obj;
            Integer num2 = (Integer) obj2;
            int i11 = zzyg.zzb;
            if (num.intValue() == -1) {
                return num2.intValue() == -1 ? 0 : -1;
            }
            if (num2.intValue() == -1) {
                return 1;
            }
            return num.intValue() - num2.intValue();
        }
    });
    private static final zzgbj zzd = zzgbj.zzb(new Comparator() { // from class: com.google.android.gms.internal.ads.zzxe
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            int i11 = zzyg.zzb;
            return 0;
        }
    });

    @Nullable
    public final Context zza;
    private final Object zze;
    private final boolean zzf;
    private zzxu zzg;

    @Nullable
    private zzxz zzh;
    private zzk zzi;
    private final zzwy zzj;

    public zzyg(Context context) {
        zzwy zzwyVar = new zzwy();
        zzxu zzxuVarZzd = zzxu.zzd(context);
        this.zze = new Object();
        this.zza = context != null ? context.getApplicationContext() : null;
        this.zzj = zzwyVar;
        this.zzg = zzxuVarZzd;
        this.zzi = zzk.zza;
        boolean z11 = false;
        if (context != null && zzfy.zzJ(context)) {
            z11 = true;
        }
        this.zzf = z11;
        if (!z11 && context != null && zzfy.zza >= 32) {
            this.zzh = zzxz.zza(context);
        }
        if (this.zzg.zzS && context == null) {
            zzff.zzf("DefaultTrackSelector", "Audio channel count constraints cannot be applied without reference to Context. Build the track selector instance with one of the non-deprecated constructors that take a Context argument.");
        }
    }

    public static /* bridge */ /* synthetic */ int zza(int i11, int i12) {
        return (i11 == 0 || i11 != i12) ? Integer.bitCount(i11 & i12) : Api.BaseClientBuilder.API_PRIORITY_OTHER;
    }

    public static int zzb(zzam zzamVar, @Nullable String str, boolean z11) {
        if (!TextUtils.isEmpty(str) && str.equals(zzamVar.zzd)) {
            return 4;
        }
        String strZzh = zzh(str);
        String strZzh2 = zzh(zzamVar.zzd);
        if (strZzh2 == null || strZzh == null) {
            return (z11 && strZzh2 == null) ? 1 : 0;
        }
        if (strZzh2.startsWith(strZzh) || strZzh.startsWith(strZzh2)) {
            return 3;
        }
        int i11 = zzfy.zza;
        return strZzh2.split("-", 2)[0].equals(strZzh.split("-", 2)[0]) ? 2 : 0;
    }

    @Nullable
    public static String zzh(@Nullable String str) {
        if (TextUtils.isEmpty(str) || TextUtils.equals(str, C.LANGUAGE_UNDETERMINED)) {
            return null;
        }
        return str;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:29:0x004c  */
    public static /* synthetic */ boolean zzm(zzyg zzygVar, zzam zzamVar) {
        boolean z11;
        byte b11;
        zzxz zzxzVar;
        zzxz zzxzVar2;
        synchronized (zzygVar.zze) {
            try {
                z11 = true;
                if (zzygVar.zzg.zzS && !zzygVar.zzf && zzamVar.zzz > 2) {
                    String str = zzamVar.zzm;
                    if (str != null) {
                        switch (str) {
                            case "audio/eac3-joc":
                                b11 = 2;
                                break;
                            case "audio/ac3":
                                b11 = 0;
                                break;
                            case "audio/ac4":
                                b11 = 3;
                                break;
                            case "audio/eac3":
                                b11 = 1;
                                break;
                            default:
                                b11 = -1;
                                break;
                        }
                        if ((b11 != 0 && b11 != 1 && b11 != 2 && b11 != 3) || (zzfy.zza >= 32 && (zzxzVar = zzygVar.zzh) != null && zzxzVar.zzg())) {
                        }
                    }
                    if (zzfy.zza < 32 || (zzxzVar2 = zzygVar.zzh) == null || !zzxzVar2.zzg() || !zzxzVar2.zze() || !zzygVar.zzh.zzf() || !zzygVar.zzh.zzd(zzygVar.zzi, zzamVar)) {
                        z11 = false;
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return z11;
    }

    public static boolean zzo(int i11, boolean z11) {
        int i12 = i11 & 7;
        if (i12 != 4) {
            return z11 && i12 == 3;
        }
        return true;
    }

    private static void zzu(zzws zzwsVar, zzdg zzdgVar, Map map) {
        for (int i11 = 0; i11 < zzwsVar.zzc; i11++) {
            if (((zzdb) zzdgVar.zzD.get(zzwsVar.zzb(i11))) != null) {
                throw null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzv() {
        boolean z11;
        zzxz zzxzVar;
        synchronized (this.zze) {
            try {
                z11 = false;
                if (this.zzg.zzS && !this.zzf && zzfy.zza >= 32 && (zzxzVar = this.zzh) != null && zzxzVar.zzg()) {
                    z11 = true;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        if (z11) {
            zzt();
        }
    }

    @Nullable
    private static final Pair zzw(int i11, zzyk zzykVar, int[][][] iArr, zzyb zzybVar, Comparator comparator) {
        List arrayList;
        ArrayList arrayList2 = new ArrayList();
        for (int i12 = 0; i12 < 2; i12++) {
            if (i11 == zzykVar.zzc(i12)) {
                zzws zzwsVarZzd = zzykVar.zzd(i12);
                for (int i13 = 0; i13 < zzwsVarZzd.zzc; i13++) {
                    zzcz zzczVarZzb = zzwsVarZzd.zzb(i13);
                    List listZza = zzybVar.zza(i12, zzczVarZzb, iArr[i12][i13]);
                    int i14 = zzczVarZzb.zzb;
                    int i15 = 1;
                    boolean[] zArr = new boolean[1];
                    int i16 = 0;
                    while (i16 <= 0) {
                        int i17 = i16 + 1;
                        zzyc zzycVar = (zzyc) listZza.get(i16);
                        int iZzb = zzycVar.zzb();
                        if (!zArr[i16] && iZzb != 0) {
                            if (iZzb == i15) {
                                arrayList = zzgaa.zzm(zzycVar);
                            } else {
                                arrayList = new ArrayList();
                                arrayList.add(zzycVar);
                                for (int i18 = i17; i18 <= 0; i18++) {
                                    zzyc zzycVar2 = (zzyc) listZza.get(i18);
                                    if (zzycVar2.zzb() == 2 && zzycVar.zzc(zzycVar2)) {
                                        arrayList.add(zzycVar2);
                                        zArr[i18] = true;
                                    }
                                }
                            }
                            arrayList2.add(arrayList);
                        }
                        i16 = i17;
                        i15 = 1;
                    }
                }
            }
        }
        if (arrayList2.isEmpty()) {
            return null;
        }
        List list = (List) Collections.max(arrayList2, comparator);
        int[] iArr2 = new int[list.size()];
        for (int i19 = 0; i19 < list.size(); i19++) {
            iArr2[i19] = ((zzyc) list.get(i19)).zzc;
        }
        zzyc zzycVar3 = (zzyc) list.get(0);
        return Pair.create(new zzyh(zzycVar3.zzb, iArr2, 0), Integer.valueOf(zzycVar3.zza));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.ads.zzyl
    public final Pair zzc(zzyk zzykVar, int[][][] iArr, final int[] iArr2, zzur zzurVar, zzcx zzcxVar) throws zziz {
        final zzxu zzxuVar;
        int i11;
        final boolean z11;
        final String str;
        int[] iArr3;
        int length;
        zzxz zzxzVar;
        synchronized (this.zze) {
            try {
                zzxuVar = this.zzg;
                if (zzxuVar.zzS && zzfy.zza >= 32 && (zzxzVar = this.zzh) != null) {
                    Looper looperMyLooper = Looper.myLooper();
                    zzek.zzb(looperMyLooper);
                    zzxzVar.zzb(this, looperMyLooper);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        int i12 = 2;
        zzyh[] zzyhVarArr = new zzyh[2];
        Pair pairZzw = zzw(2, zzykVar, iArr, new zzyb() { // from class: com.google.android.gms.internal.ads.zzxk
            /* JADX WARN: Code duplicated, block: B:22:0x0042  */
            @Override // com.google.android.gms.internal.ads.zzyb
            public final List zza(int i13, zzcz zzczVar, int[] iArr4) {
                int i14;
                int i15;
                int i16;
                Point point;
                int i17 = zzyg.zzb;
                zzxu zzxuVar2 = zzxuVar;
                int i18 = iArr2[i13];
                int i19 = zzxuVar2.zzl;
                int i21 = zzxuVar2.zzm;
                boolean z12 = zzxuVar2.zzn;
                int i22 = -1;
                int i23 = 0;
                int i24 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                if (i19 == Integer.MAX_VALUE) {
                    i24 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                } else if (i21 != Integer.MAX_VALUE) {
                    char c11 = 0;
                    int i25 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                    while (true) {
                        int i26 = zzczVar.zzb;
                        if (c11 > 0) {
                            break;
                        }
                        zzam zzamVarZzb = zzczVar.zzb(i23);
                        int i27 = zzamVarZzb.zzr;
                        if (i27 > 0 && (i14 = zzamVarZzb.zzs) > 0) {
                            if (z12) {
                                if ((i27 > i14) != (i19 > i21)) {
                                    i16 = i19;
                                    i15 = i21;
                                } else {
                                    i15 = i19;
                                    i16 = i21;
                                }
                            } else {
                                i15 = i19;
                                i16 = i21;
                            }
                            int i28 = i27 * i16;
                            int i29 = i14 * i15;
                            if (i28 >= i29) {
                                int i31 = zzfy.zza;
                                point = new Point(i15, ((i29 + i27) - 1) / i27);
                            } else {
                                int i32 = zzfy.zza;
                                point = new Point(((i28 + i14) - 1) / i14, i16);
                            }
                            int i33 = zzamVarZzb.zzr;
                            int i34 = zzamVarZzb.zzs;
                            int i35 = i33 * i34;
                            if (i33 >= ((int) (point.x * 0.98f)) && i34 >= ((int) (point.y * 0.98f)) && i35 < i25) {
                                i25 = i35;
                            }
                        }
                        c11 = 1;
                        i23 = 0;
                    }
                    i24 = i25;
                }
                zzfzx zzfzxVar = new zzfzx();
                char c12 = 0;
                while (true) {
                    int i36 = zzczVar.zzb;
                    if (c12 > 0) {
                        return zzfzxVar.zzi();
                    }
                    int iZza = zzczVar.zzb(0).zza();
                    zzfzxVar.zzf(new zzyf(i13, zzczVar, 0, zzxuVar2, iArr4[0], i18, i24 == Integer.MAX_VALUE || (iZza != i22 && iZza <= i24)));
                    c12 = 1;
                    i22 = -1;
                }
            }
        }, new Comparator() { // from class: com.google.android.gms.internal.ads.zzxl
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                List list = (List) obj;
                List list2 = (List) obj2;
                zzfzp zzfzpVarZzk = zzfzp.zzk();
                zzyd zzydVar = new Comparator() { // from class: com.google.android.gms.internal.ads.zzyd
                    @Override // java.util.Comparator
                    public final int compare(Object obj3, Object obj4) {
                        return zzyf.zzd((zzyf) obj3, (zzyf) obj4);
                    }
                };
                zzfzp zzfzpVarZzb = zzfzpVarZzk.zzd((zzyf) Collections.max(list, zzydVar), (zzyf) Collections.max(list2, zzydVar), zzydVar).zzb(list.size(), list2.size());
                zzye zzyeVar = new Comparator() { // from class: com.google.android.gms.internal.ads.zzye
                    @Override // java.util.Comparator
                    public final int compare(Object obj3, Object obj4) {
                        return zzyf.zza((zzyf) obj3, (zzyf) obj4);
                    }
                };
                return zzfzpVarZzb.zzd((zzyf) Collections.max(list, zzyeVar), (zzyf) Collections.max(list2, zzyeVar), zzyeVar).zza();
            }
        });
        int i13 = 4;
        Pair pairZzw2 = pairZzw == null ? zzw(4, zzykVar, iArr, new zzyb() { // from class: com.google.android.gms.internal.ads.zzxf
            @Override // com.google.android.gms.internal.ads.zzyb
            public final List zza(int i14, zzcz zzczVar, int[] iArr4) {
                int i15 = zzyg.zzb;
                zzfzx zzfzxVar = new zzfzx();
                int i16 = 0;
                while (true) {
                    int i17 = zzczVar.zzb;
                    if (i16 > 0) {
                        return zzfzxVar.zzi();
                    }
                    zzfzxVar.zzf(new zzxo(i14, zzczVar, i16, zzxuVar, iArr4[i16]));
                    i16++;
                }
            }
        }, new Comparator() { // from class: com.google.android.gms.internal.ads.zzxg
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return ((zzxo) ((List) obj).get(0)).zza((zzxo) ((List) obj2).get(0));
            }
        }) : null;
        if (pairZzw2 != null) {
            zzyhVarArr[((Integer) pairZzw2.second).intValue()] = (zzyh) pairZzw2.first;
        } else if (pairZzw != null) {
            zzyhVarArr[((Integer) pairZzw.second).intValue()] = (zzyh) pairZzw.first;
        }
        int i14 = 0;
        while (true) {
            i11 = 1;
            if (i14 >= 2) {
                z11 = false;
                break;
            }
            if (zzykVar.zzc(i14) == 2 && zzykVar.zzd(i14).zzc > 0) {
                z11 = true;
                break;
            }
            i14++;
        }
        Pair pairZzw3 = zzw(1, zzykVar, iArr, new zzyb() { // from class: com.google.android.gms.internal.ads.zzxi
            @Override // com.google.android.gms.internal.ads.zzyb
            public final List zza(int i15, zzcz zzczVar, int[] iArr4) {
                final zzyg zzygVar = this.zza;
                zzfxf zzfxfVar = new zzfxf() { // from class: com.google.android.gms.internal.ads.zzxh
                    @Override // com.google.android.gms.internal.ads.zzfxf
                    public final boolean zza(Object obj) {
                        return zzyg.zzm(zzygVar, (zzam) obj);
                    }
                };
                int i16 = iArr2[i15];
                zzfzx zzfzxVar = new zzfzx();
                int i17 = 0;
                while (true) {
                    int i18 = zzczVar.zzb;
                    if (i17 > 0) {
                        return zzfzxVar.zzi();
                    }
                    int i19 = i17;
                    zzfzxVar.zzf(new zzxn(i15, zzczVar, i19, zzxuVar, iArr4[i17], z11, zzfxfVar, i16));
                    i17++;
                }
            }
        }, new Comparator() { // from class: com.google.android.gms.internal.ads.zzxj
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return ((zzxn) Collections.max((List) obj)).zza((zzxn) Collections.max((List) obj2));
            }
        });
        if (pairZzw3 != null) {
            zzyhVarArr[((Integer) pairZzw3.second).intValue()] = (zzyh) pairZzw3.first;
        }
        if (pairZzw3 == null) {
            str = null;
        } else {
            Object obj = pairZzw3.first;
            str = ((zzyh) obj).zza.zzb(((zzyh) obj).zzb[0]).zzd;
        }
        int i15 = 3;
        Pair pairZzw4 = zzw(3, zzykVar, iArr, new zzyb() { // from class: com.google.android.gms.internal.ads.zzxm
            @Override // com.google.android.gms.internal.ads.zzyb
            public final List zza(int i16, zzcz zzczVar, int[] iArr4) {
                int i17 = zzyg.zzb;
                zzfzx zzfzxVar = new zzfzx();
                int i18 = 0;
                while (true) {
                    int i19 = zzczVar.zzb;
                    if (i18 > 0) {
                        return zzfzxVar.zzi();
                    }
                    int i21 = i18;
                    zzfzxVar.zzf(new zzya(i16, zzczVar, i21, zzxuVar, iArr4[i18], str));
                    i18++;
                }
            }
        }, new Comparator() { // from class: com.google.android.gms.internal.ads.zzxd
            @Override // java.util.Comparator
            public final int compare(Object obj2, Object obj3) {
                return ((zzya) ((List) obj2).get(0)).zza((zzya) ((List) obj3).get(0));
            }
        });
        if (pairZzw4 != null) {
            zzyhVarArr[((Integer) pairZzw4.second).intValue()] = (zzyh) pairZzw4.first;
        }
        int i16 = 0;
        while (i16 < i12) {
            int iZzc = zzykVar.zzc(i16);
            if (iZzc != i12 && iZzc != i11 && iZzc != i15 && iZzc != i13) {
                zzws zzwsVarZzd = zzykVar.zzd(i16);
                int[][] iArr4 = iArr[i16];
                int i17 = 0;
                zzcz zzczVar = null;
                zzxp zzxpVar = null;
                while (i17 < zzwsVarZzd.zzc) {
                    zzcz zzczVarZzb = zzwsVarZzd.zzb(i17);
                    int[] iArr5 = iArr4[i17];
                    zzxp zzxpVar2 = zzxpVar;
                    char c11 = 0;
                    while (true) {
                        int i18 = zzczVarZzb.zzb;
                        if (c11 <= 0) {
                            if (zzo(iArr5[0], zzxuVar.zzT)) {
                                zzxp zzxpVar3 = new zzxp(zzczVarZzb.zzb(0), iArr5[0]);
                                if (zzxpVar2 == null || zzxpVar3.compareTo(zzxpVar2) > 0) {
                                    zzczVar = zzczVarZzb;
                                    zzxpVar2 = zzxpVar3;
                                }
                            }
                            c11 = 1;
                        }
                    }
                    i17++;
                    zzxpVar = zzxpVar2;
                }
                zzyhVarArr[i16] = zzczVar == null ? null : new zzyh(zzczVar, new int[]{0}, 0);
            }
            i16++;
            i12 = 2;
            i13 = 4;
            i11 = 1;
            i15 = 3;
        }
        HashMap map = new HashMap();
        for (int i19 = 0; i19 < 2; i19++) {
            zzu(zzykVar.zzd(i19), zzxuVar, map);
        }
        zzu(zzykVar.zze(), zzxuVar, map);
        for (int i21 = 0; i21 < 2; i21++) {
            if (((zzdb) map.get(Integer.valueOf(zzykVar.zzc(i21)))) != null) {
                throw null;
            }
        }
        int i22 = 0;
        for (int i23 = 2; i22 < i23; i23 = 2) {
            zzws zzwsVarZzd2 = zzykVar.zzd(i22);
            if (zzxuVar.zzg(i22, zzwsVarZzd2)) {
                if (zzxuVar.zze(i22, zzwsVarZzd2) != null) {
                    throw null;
                }
                zzyhVarArr[i22] = null;
            }
            i22++;
        }
        int i24 = 0;
        for (int i25 = 2; i24 < i25; i25 = 2) {
            int iZzc2 = zzykVar.zzc(i24);
            if (zzxuVar.zzf(i24) || zzxuVar.zzE.contains(Integer.valueOf(iZzc2))) {
                zzyhVarArr[i24] = null;
            }
            i24++;
        }
        zzwy zzwyVar = this.zzj;
        zzyw zzywVarZzr = zzr();
        zzgaa zzgaaVarZzf = zzwz.zzf(zzyhVarArr);
        int i26 = 2;
        zzyi[] zzyiVarArr = new zzyi[2];
        int i27 = 0;
        while (i27 < i26) {
            zzyh zzyhVar = zzyhVarArr[i27];
            if (zzyhVar != null && (length = (iArr3 = zzyhVar.zzb).length) != 0) {
                zzyiVarArr[i27] = length == 1 ? new zzyj(zzyhVar.zza, iArr3[0], 0, 0, null) : zzwyVar.zza(zzyhVar.zza, iArr3, 0, zzywVarZzr, (zzgaa) zzgaaVarZzf.get(i27));
            }
            i27++;
            i26 = 2;
        }
        zzmi[] zzmiVarArr = new zzmi[i26];
        for (int i28 = 0; i28 < i26; i28++) {
            zzmiVarArr[i28] = (zzxuVar.zzf(i28) || zzxuVar.zzE.contains(Integer.valueOf(zzykVar.zzc(i28))) || (zzykVar.zzc(i28) != -2 && zzyiVarArr[i28] == null)) ? null : zzmi.zza;
        }
        return Pair.create(zzmiVarArr, zzyiVarArr);
    }

    @Override // com.google.android.gms.internal.ads.zzyo
    @Nullable
    public final zzmg zzd() {
        return this;
    }

    public final zzxu zze() {
        zzxu zzxuVar;
        synchronized (this.zze) {
            zzxuVar = this.zzg;
        }
        return zzxuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzyo
    public final void zzj() {
        zzxz zzxzVar;
        synchronized (this.zze) {
            try {
                if (zzfy.zza >= 32 && (zzxzVar = this.zzh) != null) {
                    zzxzVar.zzc();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        super.zzj();
    }

    @Override // com.google.android.gms.internal.ads.zzyo
    public final void zzk(zzk zzkVar) {
        boolean z11;
        synchronized (this.zze) {
            z11 = !this.zzi.equals(zzkVar);
            this.zzi = zzkVar;
        }
        if (z11) {
            zzv();
        }
    }

    public final void zzl(zzxs zzxsVar) {
        boolean z11;
        zzxu zzxuVar = new zzxu(zzxsVar);
        synchronized (this.zze) {
            z11 = !this.zzg.equals(zzxuVar);
            this.zzg = zzxuVar;
        }
        if (z11) {
            if (zzxuVar.zzS && this.zza == null) {
                zzff.zzf("DefaultTrackSelector", "Audio channel count constraints cannot be applied without reference to Context. Build the track selector instance with one of the non-deprecated constructors that take a Context argument.");
            }
            zzt();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzyo
    public final boolean zzn() {
        return true;
    }
}
