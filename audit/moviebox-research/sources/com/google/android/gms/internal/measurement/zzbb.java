package com.google.android.gms.internal.measurement;

import com.applovin.exoplayer2.common.base.Ascii;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbb {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:65:0x00f1  */
    public static zzap zza(String str, zzae zzaeVar, zzg zzgVar, List list) {
        byte b11;
        double dZzc;
        String strZzi;
        double d11;
        switch (str) {
            case "toString":
                b11 = Ascii.DC2;
                break;
            case "concat":
                b11 = 0;
                break;
            case "filter":
                b11 = 2;
                break;
            case "reduce":
                b11 = 10;
                break;
            case "splice":
                b11 = 17;
                break;
            case "forEach":
                b11 = 3;
                break;
            case "lastIndexOf":
                b11 = 6;
                break;
            case "unshift":
                b11 = 19;
                break;
            case "map":
                b11 = 7;
                break;
            case "pop":
                b11 = 8;
                break;
            case "join":
                b11 = 5;
                break;
            case "push":
                b11 = 9;
                break;
            case "some":
                b11 = Ascii.SI;
                break;
            case "sort":
                b11 = Ascii.DLE;
                break;
            case "every":
                b11 = 1;
                break;
            case "shift":
                b11 = Ascii.CR;
                break;
            case "slice":
                b11 = Ascii.SO;
                break;
            case "reduceRight":
                b11 = Ascii.VT;
                break;
            case "reverse":
                b11 = Ascii.FF;
                break;
            case "indexOf":
                b11 = 4;
                break;
            default:
                b11 = -1;
                break;
        }
        zzai zzaiVar = null;
        switch (b11) {
            case 0:
                zzap zzapVarZzd = zzaeVar.zzd();
                if (!list.isEmpty()) {
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        zzap zzapVarZzb = zzgVar.zzb((zzap) it.next());
                        if (zzapVarZzb instanceof zzag) {
                            throw new IllegalStateException("Failed evaluation of arguments");
                        }
                        zzae zzaeVar2 = (zzae) zzapVarZzd;
                        int iZzc = zzaeVar2.zzc();
                        if (zzapVarZzb instanceof zzae) {
                            zzae zzaeVar3 = (zzae) zzapVarZzb;
                            Iterator itZzk = zzaeVar3.zzk();
                            while (itZzk.hasNext()) {
                                Integer num = (Integer) itZzk.next();
                                zzaeVar2.zzq(num.intValue() + iZzc, zzaeVar3.zze(num.intValue()));
                            }
                        } else {
                            zzaeVar2.zzq(iZzc, zzapVarZzb);
                        }
                    }
                }
                return zzapVarZzd;
            case 1:
                zzh.zzh("every", 1, list);
                zzap zzapVarZzb2 = zzgVar.zzb((zzap) list.get(0));
                if (!(zzapVarZzb2 instanceof zzao)) {
                    throw new IllegalArgumentException("Callback should be a method");
                }
                if (zzaeVar.zzc() != 0 && zzb(zzaeVar, zzgVar, (zzao) zzapVarZzb2, Boolean.FALSE, Boolean.TRUE).zzc() != zzaeVar.zzc()) {
                    return zzap.zzl;
                }
                return zzap.zzk;
            case 2:
                zzh.zzh("filter", 1, list);
                zzap zzapVarZzb3 = zzgVar.zzb((zzap) list.get(0));
                if (!(zzapVarZzb3 instanceof zzao)) {
                    throw new IllegalArgumentException("Callback should be a method");
                }
                if (zzaeVar.zzb() == 0) {
                    return new zzae();
                }
                zzap zzapVarZzd2 = zzaeVar.zzd();
                zzae zzaeVarZzb = zzb(zzaeVar, zzgVar, (zzao) zzapVarZzb3, null, Boolean.TRUE);
                zzae zzaeVar4 = new zzae();
                Iterator itZzk2 = zzaeVarZzb.zzk();
                while (itZzk2.hasNext()) {
                    zzaeVar4.zzq(zzaeVar4.zzc(), ((zzae) zzapVarZzd2).zze(((Integer) itZzk2.next()).intValue()));
                }
                return zzaeVar4;
            case 3:
                zzh.zzh("forEach", 1, list);
                zzap zzapVarZzb4 = zzgVar.zzb((zzap) list.get(0));
                if (!(zzapVarZzb4 instanceof zzao)) {
                    throw new IllegalArgumentException("Callback should be a method");
                }
                if (zzaeVar.zzb() == 0) {
                    return zzap.zzf;
                }
                zzb(zzaeVar, zzgVar, (zzao) zzapVarZzb4, null, null);
                return zzap.zzf;
            case 4:
                zzh.zzj("indexOf", 2, list);
                zzap zzapVarZzb5 = zzap.zzf;
                if (!list.isEmpty()) {
                    zzapVarZzb5 = zzgVar.zzb((zzap) list.get(0));
                }
                if (list.size() > 1) {
                    double dZza = zzh.zza(zzgVar.zzb((zzap) list.get(1)).zzh().doubleValue());
                    if (dZza >= zzaeVar.zzc()) {
                        return new zzah(Double.valueOf(-1.0d));
                    }
                    dZzc = dZza < 0.0d ? ((double) zzaeVar.zzc()) + dZza : dZza;
                } else {
                    dZzc = 0.0d;
                }
                Iterator itZzk3 = zzaeVar.zzk();
                while (itZzk3.hasNext()) {
                    int iIntValue = ((Integer) itZzk3.next()).intValue();
                    double d12 = iIntValue;
                    if (d12 >= dZzc && zzh.zzl(zzaeVar.zze(iIntValue), zzapVarZzb5)) {
                        return new zzah(Double.valueOf(d12));
                    }
                }
                return new zzah(Double.valueOf(-1.0d));
            case 5:
                zzh.zzj("join", 1, list);
                if (zzaeVar.zzc() == 0) {
                    return zzap.zzm;
                }
                if (list.isEmpty()) {
                    strZzi = ",";
                } else {
                    zzap zzapVarZzb6 = zzgVar.zzb((zzap) list.get(0));
                    strZzi = ((zzapVarZzb6 instanceof zzan) || (zzapVarZzb6 instanceof zzau)) ? "" : zzapVarZzb6.zzi();
                }
                return new zzat(zzaeVar.zzj(strZzi));
            case 6:
                zzh.zzj("lastIndexOf", 2, list);
                zzap zzapVarZzb7 = zzap.zzf;
                if (!list.isEmpty()) {
                    zzapVarZzb7 = zzgVar.zzb((zzap) list.get(0));
                }
                double dZzc2 = zzaeVar.zzc() - 1;
                if (list.size() > 1) {
                    zzap zzapVarZzb8 = zzgVar.zzb((zzap) list.get(1));
                    dZzc2 = Double.isNaN(zzapVarZzb8.zzh().doubleValue()) ? zzaeVar.zzc() - 1 : zzh.zza(zzapVarZzb8.zzh().doubleValue());
                    d11 = 0.0d;
                    if (dZzc2 < 0.0d) {
                        dZzc2 += (double) zzaeVar.zzc();
                    }
                } else {
                    d11 = 0.0d;
                }
                if (dZzc2 < d11) {
                    return new zzah(Double.valueOf(-1.0d));
                }
                for (int iMin = (int) Math.min(zzaeVar.zzc(), dZzc2); iMin >= 0; iMin--) {
                    if (zzaeVar.zzs(iMin) && zzh.zzl(zzaeVar.zze(iMin), zzapVarZzb7)) {
                        return new zzah(Double.valueOf(iMin));
                    }
                }
                return new zzah(Double.valueOf(-1.0d));
            case 7:
                zzh.zzh("map", 1, list);
                zzap zzapVarZzb9 = zzgVar.zzb((zzap) list.get(0));
                if (zzapVarZzb9 instanceof zzao) {
                    return zzaeVar.zzc() == 0 ? new zzae() : zzb(zzaeVar, zzgVar, (zzao) zzapVarZzb9, null, null);
                }
                throw new IllegalArgumentException("Callback should be a method");
            case 8:
                zzh.zzh("pop", 0, list);
                int iZzc2 = zzaeVar.zzc();
                if (iZzc2 == 0) {
                    return zzap.zzf;
                }
                int i11 = iZzc2 - 1;
                zzap zzapVarZze = zzaeVar.zze(i11);
                zzaeVar.zzp(i11);
                return zzapVarZze;
            case 9:
                if (!list.isEmpty()) {
                    Iterator it2 = list.iterator();
                    while (it2.hasNext()) {
                        zzaeVar.zzq(zzaeVar.zzc(), zzgVar.zzb((zzap) it2.next()));
                    }
                }
                return new zzah(Double.valueOf(zzaeVar.zzc()));
            case 10:
                return zzc(zzaeVar, zzgVar, list, true);
            case 11:
                return zzc(zzaeVar, zzgVar, list, false);
            case 12:
                zzh.zzh("reverse", 0, list);
                int iZzc3 = zzaeVar.zzc();
                if (iZzc3 != 0) {
                    for (int i12 = 0; i12 < iZzc3 / 2; i12++) {
                        if (zzaeVar.zzs(i12)) {
                            zzap zzapVarZze2 = zzaeVar.zze(i12);
                            zzaeVar.zzq(i12, null);
                            int i13 = (iZzc3 - 1) - i12;
                            if (zzaeVar.zzs(i13)) {
                                zzaeVar.zzq(i12, zzaeVar.zze(i13));
                            }
                            zzaeVar.zzq(i13, zzapVarZze2);
                        }
                    }
                }
                return zzaeVar;
            case 13:
                zzh.zzh("shift", 0, list);
                if (zzaeVar.zzc() == 0) {
                    return zzap.zzf;
                }
                zzap zzapVarZze3 = zzaeVar.zze(0);
                zzaeVar.zzp(0);
                return zzapVarZze3;
            case 14:
                zzh.zzj("slice", 2, list);
                if (list.isEmpty()) {
                    return zzaeVar.zzd();
                }
                double dZzc3 = zzaeVar.zzc();
                double dZza2 = zzh.zza(zzgVar.zzb((zzap) list.get(0)).zzh().doubleValue());
                double dMax = dZza2 < 0.0d ? Math.max(dZza2 + dZzc3, 0.0d) : Math.min(dZza2, dZzc3);
                if (list.size() == 2) {
                    double dZza3 = zzh.zza(zzgVar.zzb((zzap) list.get(1)).zzh().doubleValue());
                    dZzc3 = dZza3 < 0.0d ? Math.max(dZzc3 + dZza3, 0.0d) : Math.min(dZzc3, dZza3);
                }
                zzae zzaeVar5 = new zzae();
                for (int i14 = (int) dMax; i14 < dZzc3; i14++) {
                    zzaeVar5.zzq(zzaeVar5.zzc(), zzaeVar.zze(i14));
                }
                return zzaeVar5;
            case 15:
                zzh.zzh("some", 1, list);
                zzap zzapVarZzb10 = zzgVar.zzb((zzap) list.get(0));
                if (!(zzapVarZzb10 instanceof zzai)) {
                    throw new IllegalArgumentException("Callback should be a method");
                }
                if (zzaeVar.zzc() == 0) {
                    return zzap.zzl;
                }
                zzai zzaiVar2 = (zzai) zzapVarZzb10;
                Iterator itZzk4 = zzaeVar.zzk();
                while (itZzk4.hasNext()) {
                    int iIntValue2 = ((Integer) itZzk4.next()).intValue();
                    if (zzaeVar.zzs(iIntValue2) && zzaiVar2.zza(zzgVar, Arrays.asList(zzaeVar.zze(iIntValue2), new zzah(Double.valueOf(iIntValue2)), zzaeVar)).zzg().booleanValue()) {
                        return zzap.zzk;
                    }
                }
                return zzap.zzl;
            case 16:
                zzh.zzj("sort", 1, list);
                if (zzaeVar.zzc() >= 2) {
                    List listZzm = zzaeVar.zzm();
                    if (!list.isEmpty()) {
                        zzap zzapVarZzb11 = zzgVar.zzb((zzap) list.get(0));
                        if (!(zzapVarZzb11 instanceof zzai)) {
                            throw new IllegalArgumentException("Comparator should be a method");
                        }
                        zzaiVar = (zzai) zzapVarZzb11;
                    }
                    Collections.sort(listZzm, new zzba(zzaiVar, zzgVar));
                    zzaeVar.zzn();
                    Iterator it3 = listZzm.iterator();
                    int i15 = 0;
                    while (it3.hasNext()) {
                        zzaeVar.zzq(i15, (zzap) it3.next());
                        i15++;
                    }
                }
                return zzaeVar;
            case 17:
                if (list.isEmpty()) {
                    return new zzae();
                }
                int iZza = (int) zzh.zza(zzgVar.zzb((zzap) list.get(0)).zzh().doubleValue());
                if (iZza < 0) {
                    iZza = Math.max(0, iZza + zzaeVar.zzc());
                } else if (iZza > zzaeVar.zzc()) {
                    iZza = zzaeVar.zzc();
                }
                int iZzc4 = zzaeVar.zzc();
                zzae zzaeVar6 = new zzae();
                if (list.size() > 1) {
                    int iMax = Math.max(0, (int) zzh.zza(zzgVar.zzb((zzap) list.get(1)).zzh().doubleValue()));
                    if (iMax > 0) {
                        for (int i16 = iZza; i16 < Math.min(iZzc4, iZza + iMax); i16++) {
                            zzaeVar6.zzq(zzaeVar6.zzc(), zzaeVar.zze(iZza));
                            zzaeVar.zzp(iZza);
                        }
                    }
                    if (list.size() > 2) {
                        for (int i17 = 2; i17 < list.size(); i17++) {
                            zzap zzapVarZzb12 = zzgVar.zzb((zzap) list.get(i17));
                            if (zzapVarZzb12 instanceof zzag) {
                                throw new IllegalArgumentException("Failed to parse elements to add");
                            }
                            zzaeVar.zzo((iZza + i17) - 2, zzapVarZzb12);
                        }
                    }
                } else {
                    while (iZza < iZzc4) {
                        zzaeVar6.zzq(zzaeVar6.zzc(), zzaeVar.zze(iZza));
                        zzaeVar.zzq(iZza, null);
                        iZza++;
                    }
                }
                return zzaeVar6;
            case 18:
                zzh.zzh("toString", 0, list);
                return new zzat(zzaeVar.zzj(","));
            case 19:
                if (!list.isEmpty()) {
                    zzae zzaeVar7 = new zzae();
                    Iterator it4 = list.iterator();
                    while (it4.hasNext()) {
                        zzap zzapVarZzb13 = zzgVar.zzb((zzap) it4.next());
                        if (zzapVarZzb13 instanceof zzag) {
                            throw new IllegalStateException("Argument evaluation failed");
                        }
                        zzaeVar7.zzq(zzaeVar7.zzc(), zzapVarZzb13);
                    }
                    int iZzc5 = zzaeVar7.zzc();
                    Iterator itZzk5 = zzaeVar.zzk();
                    while (itZzk5.hasNext()) {
                        Integer num2 = (Integer) itZzk5.next();
                        zzaeVar7.zzq(num2.intValue() + iZzc5, zzaeVar.zze(num2.intValue()));
                    }
                    zzaeVar.zzn();
                    Iterator itZzk6 = zzaeVar7.zzk();
                    while (itZzk6.hasNext()) {
                        Integer num3 = (Integer) itZzk6.next();
                        zzaeVar.zzq(num3.intValue(), zzaeVar7.zze(num3.intValue()));
                    }
                }
                return new zzah(Double.valueOf(zzaeVar.zzc()));
            default:
                throw new IllegalArgumentException("Command not supported");
        }
    }

    private static zzae zzb(zzae zzaeVar, zzg zzgVar, zzai zzaiVar, Boolean bool, Boolean bool2) {
        zzae zzaeVar2 = new zzae();
        Iterator itZzk = zzaeVar.zzk();
        while (itZzk.hasNext()) {
            int iIntValue = ((Integer) itZzk.next()).intValue();
            if (zzaeVar.zzs(iIntValue)) {
                zzap zzapVarZza = zzaiVar.zza(zzgVar, Arrays.asList(zzaeVar.zze(iIntValue), new zzah(Double.valueOf(iIntValue)), zzaeVar));
                if (zzapVarZza.zzg().equals(bool)) {
                    return zzaeVar2;
                }
                if (bool2 == null || zzapVarZza.zzg().equals(bool2)) {
                    zzaeVar2.zzq(iIntValue, zzapVarZza);
                }
            }
        }
        return zzaeVar2;
    }

    private static zzap zzc(zzae zzaeVar, zzg zzgVar, List list, boolean z11) {
        zzap zzapVarZza;
        zzh.zzi("reduce", 1, list);
        zzh.zzj("reduce", 2, list);
        zzap zzapVarZzb = zzgVar.zzb((zzap) list.get(0));
        if (!(zzapVarZzb instanceof zzai)) {
            throw new IllegalArgumentException("Callback should be a method");
        }
        if (list.size() == 2) {
            zzapVarZza = zzgVar.zzb((zzap) list.get(1));
            if (zzapVarZza instanceof zzag) {
                throw new IllegalArgumentException("Failed to parse initial value");
            }
        } else {
            if (zzaeVar.zzc() == 0) {
                throw new IllegalStateException("Empty array with no initial value error");
            }
            zzapVarZza = null;
        }
        zzai zzaiVar = (zzai) zzapVarZzb;
        int iZzc = zzaeVar.zzc();
        int i11 = z11 ? 0 : iZzc - 1;
        int i12 = z11 ? iZzc - 1 : 0;
        int i13 = true == z11 ? 1 : -1;
        if (zzapVarZza == null) {
            zzapVarZza = zzaeVar.zze(i11);
            i11 += i13;
        }
        while ((i12 - i11) * i13 >= 0) {
            if (zzaeVar.zzs(i11)) {
                zzapVarZza = zzaiVar.zza(zzgVar, Arrays.asList(zzapVarZza, zzaeVar.zze(i11), new zzah(Double.valueOf(i11)), zzaeVar));
                if (zzapVarZza instanceof zzag) {
                    throw new IllegalStateException("Reduce operation failed");
                }
                i11 += i13;
            } else {
                i11 += i13;
            }
        }
        return zzapVarZza;
    }
}
