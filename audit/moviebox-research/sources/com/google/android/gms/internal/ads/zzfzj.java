package com.google.android.gms.internal.ads;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzfzj extends AbstractMap implements Serializable {
    private static final Object zzd = new Object();
    transient int[] zza;
    transient Object[] zzb;
    transient Object[] zzc;
    private transient Object zze;
    private transient int zzf;
    private transient int zzg;
    private transient Set zzh;
    private transient Set zzi;
    private transient Collection zzj;

    public zzfzj() {
        zzp(3);
    }

    public zzfzj(int i11) {
        zzp(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int[] zzA() {
        int[] iArr = this.zza;
        Objects.requireNonNull(iArr);
        return iArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object[] zzB() {
        Object[] objArr = this.zzb;
        Objects.requireNonNull(objArr);
        return objArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object[] zzC() {
        Object[] objArr = this.zzc;
        Objects.requireNonNull(objArr);
        return objArr;
    }

    public static /* synthetic */ Object zzg(zzfzj zzfzjVar, int i11) {
        return zzfzjVar.zzB()[i11];
    }

    public static /* synthetic */ Object zzi(zzfzj zzfzjVar) {
        Object obj = zzfzjVar.zze;
        Objects.requireNonNull(obj);
        return obj;
    }

    public static /* synthetic */ Object zzj(zzfzj zzfzjVar, int i11) {
        return zzfzjVar.zzC()[i11];
    }

    public static /* synthetic */ void zzn(zzfzj zzfzjVar, int i11, Object obj) {
        zzfzjVar.zzC()[i11] = obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int zzv() {
        return (1 << (this.zzf & 31)) - 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int zzw(Object obj) {
        if (zzr()) {
            return -1;
        }
        int iZzb = zzfzs.zzb(obj);
        int iZzv = zzv();
        Object obj2 = this.zze;
        Objects.requireNonNull(obj2);
        int iZzc = zzfzk.zzc(obj2, iZzb & iZzv);
        if (iZzc != 0) {
            int i11 = ~iZzv;
            int i12 = iZzb & i11;
            do {
                int i13 = iZzc - 1;
                int i14 = zzA()[i13];
                if ((i14 & i11) == i12 && zzfwy.zza(obj, zzB()[i13])) {
                    return i13;
                }
                iZzc = i14 & iZzv;
            } while (iZzc != 0);
        }
        return -1;
    }

    private final int zzx(int i11, int i12, int i13, int i14) {
        int i15 = i12 - 1;
        Object objZzd = zzfzk.zzd(i12);
        if (i14 != 0) {
            zzfzk.zze(objZzd, i13 & i15, i14 + 1);
        }
        Object obj = this.zze;
        Objects.requireNonNull(obj);
        int[] iArrZzA = zzA();
        for (int i16 = 0; i16 <= i11; i16++) {
            int iZzc = zzfzk.zzc(obj, i16);
            while (iZzc != 0) {
                int i17 = iZzc - 1;
                int i18 = iArrZzA[i17];
                int i19 = ((~i11) & i18) | i16;
                int i21 = i19 & i15;
                int iZzc2 = zzfzk.zzc(objZzd, i21);
                zzfzk.zze(objZzd, i21, iZzc);
                iArrZzA[i17] = ((~i15) & i19) | (iZzc2 & i15);
                iZzc = i18 & i11;
            }
        }
        this.zze = objZzd;
        zzz(i15);
        return i15;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object zzy(Object obj) {
        if (!zzr()) {
            int iZzv = zzv();
            Object obj2 = this.zze;
            Objects.requireNonNull(obj2);
            int iZzb = zzfzk.zzb(obj, null, iZzv, obj2, zzA(), zzB(), null);
            if (iZzb != -1) {
                Object obj3 = zzC()[iZzb];
                zzq(iZzb, iZzv);
                this.zzg--;
                zzo();
                return obj3;
            }
        }
        return zzd;
    }

    private final void zzz(int i11) {
        this.zzf = ((32 - Integer.numberOfLeadingZeros(i11)) & 31) | (this.zzf & (-32));
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        if (zzr()) {
            return;
        }
        zzo();
        Map mapZzl = zzl();
        if (mapZzl != null) {
            this.zzf = zzgcu.zzb(size(), 3, 1073741823);
            mapZzl.clear();
            this.zze = null;
            this.zzg = 0;
            return;
        }
        Arrays.fill(zzB(), 0, this.zzg, (Object) null);
        Arrays.fill(zzC(), 0, this.zzg, (Object) null);
        Object obj = this.zze;
        Objects.requireNonNull(obj);
        if (obj instanceof byte[]) {
            Arrays.fill((byte[]) obj, (byte) 0);
        } else if (obj instanceof short[]) {
            Arrays.fill((short[]) obj, (short) 0);
        } else {
            Arrays.fill((int[]) obj, 0);
        }
        Arrays.fill(zzA(), 0, this.zzg, 0);
        this.zzg = 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        Map mapZzl = zzl();
        if (mapZzl != null) {
            return mapZzl.containsKey(obj);
        }
        return zzw(obj) != -1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsValue(Object obj) {
        Map mapZzl = zzl();
        if (mapZzl != null) {
            return mapZzl.containsValue(obj);
        }
        for (int i11 = 0; i11 < this.zzg; i11++) {
            if (zzfwy.zza(obj, zzC()[i11])) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set entrySet() {
        Set set = this.zzi;
        if (set != null) {
            return set;
        }
        zzfzd zzfzdVar = new zzfzd(this);
        this.zzi = zzfzdVar;
        return zzfzdVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object get(Object obj) {
        Map mapZzl = zzl();
        if (mapZzl != null) {
            return mapZzl.get(obj);
        }
        int iZzw = zzw(obj);
        if (iZzw == -1) {
            return null;
        }
        return zzC()[iZzw];
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set keySet() {
        Set set = this.zzh;
        if (set != null) {
            return set;
        }
        zzfzg zzfzgVar = new zzfzg(this);
        this.zzh = zzfzgVar;
        return zzfzgVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object put(Object obj, Object obj2) {
        int iMin;
        if (zzr()) {
            zzfxe.zzj(zzr(), "Arrays already allocated");
            int i11 = this.zzf;
            int iMax = Math.max(i11 + 1, 2);
            int iHighestOneBit = Integer.highestOneBit(iMax);
            if (iMax > iHighestOneBit && (iHighestOneBit = iHighestOneBit + iHighestOneBit) <= 0) {
                iHighestOneBit = 1073741824;
            }
            int iMax2 = Math.max(4, iHighestOneBit);
            this.zze = zzfzk.zzd(iMax2);
            zzz(iMax2 - 1);
            this.zza = new int[i11];
            this.zzb = new Object[i11];
            this.zzc = new Object[i11];
        }
        Map mapZzl = zzl();
        if (mapZzl != null) {
            return mapZzl.put(obj, obj2);
        }
        int[] iArrZzA = zzA();
        Object[] objArrZzB = zzB();
        Object[] objArrZzC = zzC();
        int i12 = this.zzg;
        int i13 = i12 + 1;
        int iZzb = zzfzs.zzb(obj);
        int iZzv = zzv();
        int i14 = iZzb & iZzv;
        Object obj3 = this.zze;
        Objects.requireNonNull(obj3);
        int iZzc = zzfzk.zzc(obj3, i14);
        if (iZzc != 0) {
            int i15 = ~iZzv;
            int i16 = iZzb & i15;
            int i17 = 0;
            while (true) {
                int i18 = iZzc - 1;
                int i19 = iArrZzA[i18];
                int i21 = i19 & i15;
                if (i21 == i16 && zzfwy.zza(obj, objArrZzB[i18])) {
                    Object obj4 = objArrZzC[i18];
                    objArrZzC[i18] = obj2;
                    return obj4;
                }
                int i22 = i19 & iZzv;
                i17++;
                if (i22 == 0) {
                    if (i17 < 9) {
                        if (i13 <= iZzv) {
                            iArrZzA[i18] = (i13 & iZzv) | i21;
                            break;
                        }
                        iZzv = zzx(iZzv, zzfzk.zza(iZzv), iZzb, i12);
                        break;
                    }
                    LinkedHashMap linkedHashMap = new LinkedHashMap(zzv() + 1, 1.0f);
                    int iZze = zze();
                    while (iZze >= 0) {
                        linkedHashMap.put(zzB()[iZze], zzC()[iZze]);
                        iZze = zzf(iZze);
                    }
                    this.zze = linkedHashMap;
                    this.zza = null;
                    this.zzb = null;
                    this.zzc = null;
                    zzo();
                    return linkedHashMap.put(obj, obj2);
                }
                iZzc = i22;
            }
        } else if (i13 > iZzv) {
            iZzv = zzx(iZzv, zzfzk.zza(iZzv), iZzb, i12);
        } else {
            Object obj5 = this.zze;
            Objects.requireNonNull(obj5);
            zzfzk.zze(obj5, i14, i13);
        }
        int length = zzA().length;
        if (i13 > length && (iMin = Math.min(1073741823, (Math.max(1, length >>> 1) + length) | 1)) != length) {
            this.zza = Arrays.copyOf(zzA(), iMin);
            this.zzb = Arrays.copyOf(zzB(), iMin);
            this.zzc = Arrays.copyOf(zzC(), iMin);
        }
        zzA()[i12] = (~iZzv) & iZzb;
        zzB()[i12] = obj;
        zzC()[i12] = obj2;
        this.zzg = i13;
        zzo();
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object remove(Object obj) {
        Map mapZzl = zzl();
        if (mapZzl != null) {
            return mapZzl.remove(obj);
        }
        Object objZzy = zzy(obj);
        if (objZzy == zzd) {
            return null;
        }
        return objZzy;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        Map mapZzl = zzl();
        return mapZzl != null ? mapZzl.size() : this.zzg;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Collection values() {
        Collection collection = this.zzj;
        if (collection != null) {
            return collection;
        }
        zzfzi zzfziVar = new zzfzi(this);
        this.zzj = zzfziVar;
        return zzfziVar;
    }

    public final int zze() {
        return isEmpty() ? -1 : 0;
    }

    public final int zzf(int i11) {
        int i12 = i11 + 1;
        if (i12 < this.zzg) {
            return i12;
        }
        return -1;
    }

    public final Map zzl() {
        Object obj = this.zze;
        if (obj instanceof Map) {
            return (Map) obj;
        }
        return null;
    }

    public final void zzo() {
        this.zzf += 32;
    }

    public final void zzp(int i11) {
        this.zzf = zzgcu.zzb(8, 1, 1073741823);
    }

    public final void zzq(int i11, int i12) {
        Object obj = this.zze;
        Objects.requireNonNull(obj);
        int[] iArrZzA = zzA();
        Object[] objArrZzB = zzB();
        Object[] objArrZzC = zzC();
        int size = size();
        int i13 = size - 1;
        if (i11 >= i13) {
            objArrZzB[i11] = null;
            objArrZzC[i11] = null;
            iArrZzA[i11] = 0;
            return;
        }
        int i14 = i11 + 1;
        Object obj2 = objArrZzB[i13];
        objArrZzB[i11] = obj2;
        objArrZzC[i11] = objArrZzC[i13];
        objArrZzB[i13] = null;
        objArrZzC[i13] = null;
        iArrZzA[i11] = iArrZzA[i13];
        iArrZzA[i13] = 0;
        int iZzb = zzfzs.zzb(obj2) & i12;
        int iZzc = zzfzk.zzc(obj, iZzb);
        if (iZzc == size) {
            zzfzk.zze(obj, iZzb, i14);
            return;
        }
        while (true) {
            int i15 = iZzc - 1;
            int i16 = iArrZzA[i15];
            int i17 = i16 & i12;
            if (i17 == size) {
                iArrZzA[i15] = (i16 & (~i12)) | (i12 & i14);
                return;
            }
            iZzc = i17;
        }
    }

    public final boolean zzr() {
        return this.zze == null;
    }
}
