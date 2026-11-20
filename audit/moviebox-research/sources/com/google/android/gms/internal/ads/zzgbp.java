package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzgbp extends zzgad {
    static final zzgad zza = new zzgbp(null, new Object[0], 0);
    final transient Object[] zzb;
    private final transient Object zzc;
    private final transient int zzd;

    private zzgbp(Object obj, Object[] objArr, int i11) {
        this.zzc = obj;
        this.zzb = objArr;
        this.zzd = i11;
    }

    /* JADX WARN: Code duplicated, block: B:73:0x0194  */
    /* JADX WARN: Code duplicated, block: B:75:0x019c  */
    /* JADX WARN: Code duplicated, block: B:76:0x01b1  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v0 */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v16 */
    /* JADX WARN: Type inference failed for: r3v17, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v20 */
    /* JADX WARN: Type inference failed for: r3v21 */
    /* JADX WARN: Type inference failed for: r3v24 */
    /* JADX WARN: Type inference failed for: r3v31 */
    /* JADX WARN: Type inference failed for: r3v32 */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r5v11, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r5v2, types: [int[]] */
    /* JADX WARN: Type inference failed for: r5v9 */
    /* JADX WARN: Type inference failed for: r6v17 */
    /* JADX WARN: Type inference failed for: r6v18 */
    /* JADX WARN: Type inference failed for: r6v5, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r6v7 */
    public static zzgbp zzj(int i11, Object[] objArr, zzgac zzgacVar) {
        short[] sArr;
        char c11;
        char c12;
        ?? r11;
        ?? r12;
        boolean z11;
        ?? r13;
        Object[] objArr2;
        zzgab zzgabVar;
        int i12 = i11;
        Object[] objArrCopyOf = objArr;
        if (i12 == 0) {
            return (zzgbp) zza;
        }
        zzgab zzgabVar2 = null;
        ?? r14 = 0;
        zzgab zzgabVar3 = null;
        zzgab zzgabVar4 = null;
        int i13 = 1;
        if (i12 == 1) {
            Object obj = objArrCopyOf[0];
            Objects.requireNonNull(obj);
            Object obj2 = objArrCopyOf[1];
            Objects.requireNonNull(obj2);
            zzfyx.zzb(obj, obj2);
            return new zzgbp(null, objArrCopyOf, 1);
        }
        zzfxe.zzb(i12, objArrCopyOf.length >> 1, "index");
        int iZzh = zzgaf.zzh(i11);
        if (i12 == 1) {
            Object obj3 = objArrCopyOf[0];
            Objects.requireNonNull(obj3);
            Object obj4 = objArrCopyOf[1];
            Objects.requireNonNull(obj4);
            zzfyx.zzb(obj3, obj4);
            i12 = 1;
        } else {
            int i14 = iZzh - 1;
            byte b11 = -1;
            if (iZzh > 128) {
                if (iZzh <= 32768) {
                    sArr = new short[iZzh];
                    Arrays.fill(sArr, (short) -1);
                    int i15 = 0;
                    for (int i16 = 0; i16 < i12; i16++) {
                        int i17 = i15 + i15;
                        int i18 = i16 + i16;
                        Object obj5 = objArrCopyOf[i18];
                        Objects.requireNonNull(obj5);
                        Object obj6 = objArrCopyOf[i18 ^ 1];
                        Objects.requireNonNull(obj6);
                        zzfyx.zzb(obj5, obj6);
                        int iZza = zzfzs.zza(obj5.hashCode());
                        while (true) {
                            int i19 = iZza & i14;
                            char c13 = (char) sArr[i19];
                            if (c13 == 65535) {
                                sArr[i19] = (short) i17;
                                if (i15 < i16) {
                                    objArrCopyOf[i17] = obj5;
                                    objArrCopyOf[i17 ^ 1] = obj6;
                                }
                                i15++;
                                break;
                            }
                            if (obj5.equals(objArrCopyOf[c13])) {
                                int i21 = c13 ^ 1;
                                Object obj7 = objArrCopyOf[i21 == true ? 1 : 0];
                                Objects.requireNonNull(obj7);
                                zzgab zzgabVar5 = new zzgab(obj5, obj6, obj7);
                                objArrCopyOf[i21 == true ? 1 : 0] = obj6;
                                zzgabVar4 = zzgabVar5;
                                break;
                            }
                            iZza = i19 + 1;
                        }
                    }
                    if (i15 != i12) {
                        Integer numValueOf = Integer.valueOf(i15);
                        c11 = 1;
                        c12 = 2;
                        r11 = new Object[]{sArr, numValueOf, zzgabVar4};
                        r12 = r11;
                    }
                } else {
                    int i22 = 1;
                    sArr = new int[iZzh];
                    Arrays.fill((int[]) sArr, -1);
                    int i23 = 0;
                    int i24 = 0;
                    while (i23 < i12) {
                        int i25 = i24 + i24;
                        int i26 = i23 + i23;
                        Object obj8 = objArrCopyOf[i26];
                        Objects.requireNonNull(obj8);
                        Object obj9 = objArrCopyOf[i26 ^ i22];
                        Objects.requireNonNull(obj9);
                        zzfyx.zzb(obj8, obj9);
                        int iZza2 = zzfzs.zza(obj8.hashCode());
                        while (true) {
                            int i27 = iZza2 & i14;
                            ?? r15 = sArr[i27];
                            if (r15 == b11) {
                                sArr[i27] = i25;
                                if (i24 < i23) {
                                    objArrCopyOf[i25] = obj8;
                                    objArrCopyOf[i25 ^ 1] = obj9;
                                }
                                i24++;
                                break;
                            }
                            if (obj8.equals(objArrCopyOf[r15])) {
                                int i28 = r15 ^ 1;
                                Object obj10 = objArrCopyOf[i28 == true ? 1 : 0];
                                Objects.requireNonNull(obj10);
                                zzgab zzgabVar6 = new zzgab(obj8, obj9, obj10);
                                objArrCopyOf[i28 == true ? 1 : 0] = obj9;
                                zzgabVar2 = zzgabVar6;
                                break;
                            }
                            iZza2 = i27 + 1;
                            b11 = -1;
                        }
                        i23++;
                        i22 = 1;
                        b11 = -1;
                    }
                    if (i24 != i12) {
                        c11 = 1;
                        c12 = 2;
                        r11 = new Object[]{sArr, Integer.valueOf(i24), zzgabVar2};
                        r12 = r11;
                    }
                }
                z11 = r12 instanceof Object[];
                r13 = r12;
                if (z11) {
                    objArr2 = (Object[]) r12;
                    zzgabVar = (zzgab) objArr2[c12];
                    if (zzgacVar != null) {
                        throw zzgabVar.zza();
                    }
                    zzgacVar.zzc = zzgabVar;
                    Object obj11 = objArr2[0];
                    int iIntValue = ((Integer) objArr2[c11]).intValue();
                    objArrCopyOf = Arrays.copyOf(objArrCopyOf, iIntValue + iIntValue);
                    r13 = obj11;
                    i12 = iIntValue;
                }
                return new zzgbp(r13, objArrCopyOf, i12);
            }
            byte[] bArr = new byte[iZzh];
            Arrays.fill(bArr, (byte) -1);
            int i29 = 0;
            int i31 = 0;
            while (i29 < i12) {
                int i32 = i31 + i31;
                int i33 = i29 + i29;
                Object obj12 = objArrCopyOf[i33];
                Objects.requireNonNull(obj12);
                Object obj13 = objArrCopyOf[i33 ^ i13];
                Objects.requireNonNull(obj13);
                zzfyx.zzb(obj12, obj13);
                int iZza3 = zzfzs.zza(obj12.hashCode());
                while (true) {
                    int i34 = iZza3 & i14;
                    int i35 = bArr[i34] & 255;
                    if (i35 == 255) {
                        bArr[i34] = (byte) i32;
                        if (i31 < i29) {
                            objArrCopyOf[i32] = obj12;
                            objArrCopyOf[i32 ^ 1] = obj13;
                        }
                        i31++;
                        break;
                    }
                    if (obj12.equals(objArrCopyOf[i35 == true ? 1 : 0])) {
                        int i36 = ~i35;
                        Object obj14 = objArrCopyOf[i36 == true ? 1 : 0];
                        Objects.requireNonNull(obj14);
                        zzgab zzgabVar7 = new zzgab(obj12, obj13, obj14);
                        objArrCopyOf[i36 == true ? 1 : 0] = obj13;
                        zzgabVar3 = zzgabVar7;
                        break;
                    }
                    iZza3 = i34 + 1;
                }
                i29++;
                i13 = 1;
            }
            if (i31 == i12) {
                r14 = bArr;
            } else {
                sArr = new Object[]{bArr, Integer.valueOf(i31), zzgabVar3};
            }
            r14 = sArr;
        }
        c12 = 2;
        c11 = 1;
        r12 = r14;
        z11 = r12 instanceof Object[];
        r13 = r12;
        if (z11) {
            objArr2 = (Object[]) r12;
            zzgabVar = (zzgab) objArr2[c12];
            if (zzgacVar != null) {
                throw zzgabVar.zza();
            }
            zzgacVar.zzc = zzgabVar;
            Object obj15 = objArr2[0];
            int iIntValue2 = ((Integer) objArr2[c11]).intValue();
            objArrCopyOf = Arrays.copyOf(objArrCopyOf, iIntValue2 + iIntValue2);
            r13 = obj15;
            i12 = iIntValue2;
        }
        return new zzgbp(r13, objArrCopyOf, i12);
    }

    /* JADX WARN: Code duplicated, block: B:4:0x0003  */
    @Override // com.google.android.gms.internal.ads.zzgad, java.util.Map
    public final Object get(Object obj) {
        Object obj2;
        if (obj == null) {
            obj2 = null;
        } else {
            int i11 = this.zzd;
            Object[] objArr = this.zzb;
            if (i11 == 1) {
                Object obj3 = objArr[0];
                Objects.requireNonNull(obj3);
                if (obj3.equals(obj)) {
                    obj2 = objArr[1];
                    Objects.requireNonNull(obj2);
                } else {
                    obj2 = null;
                }
            } else {
                Object obj4 = this.zzc;
                if (obj4 == null) {
                    obj2 = null;
                } else if (obj4 instanceof byte[]) {
                    byte[] bArr = (byte[]) obj4;
                    int length = bArr.length - 1;
                    int iZza = zzfzs.zza(obj.hashCode());
                    while (true) {
                        int i12 = iZza & length;
                        int i13 = bArr[i12] & 255;
                        if (i13 == 255) {
                            break;
                        }
                        if (obj.equals(objArr[i13])) {
                            obj2 = objArr[i13 ^ 1];
                        } else {
                            iZza = i12 + 1;
                        }
                    }
                    obj2 = null;
                } else if (obj4 instanceof short[]) {
                    short[] sArr = (short[]) obj4;
                    int length2 = sArr.length - 1;
                    int iZza2 = zzfzs.zza(obj.hashCode());
                    while (true) {
                        int i14 = iZza2 & length2;
                        char c11 = (char) sArr[i14];
                        if (c11 == 65535) {
                            break;
                        }
                        if (obj.equals(objArr[c11])) {
                            obj2 = objArr[c11 ^ 1];
                        } else {
                            iZza2 = i14 + 1;
                        }
                    }
                    obj2 = null;
                } else {
                    int[] iArr = (int[]) obj4;
                    int length3 = iArr.length - 1;
                    int iZza3 = zzfzs.zza(obj.hashCode());
                    while (true) {
                        int i15 = iZza3 & length3;
                        int i16 = iArr[i15];
                        if (i16 == -1) {
                            break;
                        }
                        if (obj.equals(objArr[i16])) {
                            obj2 = objArr[i16 ^ 1];
                        } else {
                            iZza3 = i15 + 1;
                        }
                    }
                    obj2 = null;
                }
            }
        }
        if (obj2 == null) {
            return null;
        }
        return obj2;
    }

    @Override // java.util.Map
    public final int size() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzgad
    public final zzfzv zza() {
        return new zzgbo(this.zzb, 1, this.zzd);
    }

    @Override // com.google.android.gms.internal.ads.zzgad
    public final zzgaf zzf() {
        return new zzgbm(this, this.zzb, 0, this.zzd);
    }

    @Override // com.google.android.gms.internal.ads.zzgad
    public final zzgaf zzg() {
        return new zzgbn(this, new zzgbo(this.zzb, 0, this.zzd));
    }
}
