package qm;

import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.ReaderException;
import com.google.zxing.ResultMetadataType;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public abstract class q implements com.google.zxing.i {
    public static float e(int[] iArr, int[] iArr2, float f11) {
        int length = iArr.length;
        int i11 = 0;
        int i12 = 0;
        for (int i13 = 0; i13 < length; i13++) {
            i11 += iArr[i13];
            i12 += iArr2[i13];
        }
        if (i11 < i12) {
            return Float.POSITIVE_INFINITY;
        }
        float f12 = i11;
        float f13 = f12 / i12;
        float f14 = f11 * f13;
        float f15 = 0.0f;
        for (int i14 = 0; i14 < length; i14++) {
            int i15 = iArr[i14];
            float f16 = iArr2[i14] * f13;
            float f17 = i15;
            float f18 = f17 > f16 ? f17 - f16 : f16 - f17;
            if (f18 > f14) {
                return Float.POSITIVE_INFINITY;
            }
            f15 += f18;
        }
        return f15 / f12;
    }

    public static void f(hm.a aVar, int i11, int[] iArr) throws NotFoundException {
        int length = iArr.length;
        int i12 = 0;
        Arrays.fill(iArr, 0, length, 0);
        int iM = aVar.m();
        if (i11 >= iM) {
            throw NotFoundException.getNotFoundInstance();
        }
        boolean z11 = !aVar.h(i11);
        while (i11 < iM) {
            if (aVar.h(i11) != z11) {
                iArr[i12] = iArr[i12] + 1;
            } else {
                i12++;
                if (i12 == length) {
                    break;
                }
                iArr[i12] = 1;
                z11 = !z11;
            }
            i11++;
        }
        if (i12 != length) {
            if (i12 != length - 1 || i11 != iM) {
                throw NotFoundException.getNotFoundInstance();
            }
        }
    }

    public static void g(hm.a aVar, int i11, int[] iArr) throws NotFoundException {
        int length = iArr.length;
        boolean zH = aVar.h(i11);
        while (i11 > 0 && length >= 0) {
            i11--;
            if (aVar.h(i11) != zH) {
                length--;
                zH = !zH;
            }
        }
        if (length >= 0) {
            throw NotFoundException.getNotFoundInstance();
        }
        f(aVar, i11 + 1, iArr);
    }

    @Override // com.google.zxing.i
    public com.google.zxing.j a(com.google.zxing.b bVar, Map<DecodeHintType, ?> map) throws NotFoundException, FormatException {
        try {
            return d(bVar, map);
        } catch (NotFoundException e11) {
            if (map == null || !map.containsKey(DecodeHintType.TRY_HARDER) || !bVar.e()) {
                throw e11;
            }
            com.google.zxing.b bVarF = bVar.f();
            com.google.zxing.j jVarD = d(bVarF, map);
            Map<ResultMetadataType, Object> mapD = jVarD.d();
            int iIntValue = 270;
            if (mapD != null) {
                ResultMetadataType resultMetadataType = ResultMetadataType.ORIENTATION;
                if (mapD.containsKey(resultMetadataType)) {
                    iIntValue = (((Integer) mapD.get(resultMetadataType)).intValue() + 270) % 360;
                }
            }
            jVarD.h(ResultMetadataType.ORIENTATION, Integer.valueOf(iIntValue));
            com.google.zxing.k[] kVarArrE = jVarD.e();
            if (kVarArrE != null) {
                int iC = bVarF.c();
                for (int i11 = 0; i11 < kVarArrE.length; i11++) {
                    kVarArrE[i11] = new com.google.zxing.k((iC - kVarArrE[i11].d()) - 1.0f, kVarArrE[i11].c());
                }
            }
            return jVarD;
        }
    }

    @Override // com.google.zxing.i
    public com.google.zxing.j b(com.google.zxing.b bVar) throws NotFoundException, FormatException {
        return a(bVar, null);
    }

    public abstract com.google.zxing.j c(int i11, hm.a aVar, Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException;

    /* JADX WARN: Code duplicated, block: B:35:0x0070  */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0048, code lost:
    
        r3 = r22.b(r11, r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x004c, code lost:
    
        r12 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00e0, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final com.google.zxing.j d(com.google.zxing.b bVar, Map<DecodeHintType, ?> map) throws NotFoundException {
        int i11;
        int i12;
        int i13;
        Map<DecodeHintType, ?> map2;
        int i14;
        Map<DecodeHintType, ?> map3 = map;
        int iD = bVar.d();
        int iC = bVar.c();
        hm.a aVar = new hm.a(iD);
        char c11 = 0;
        int i15 = 1;
        boolean z11 = map3 != null && map3.containsKey(DecodeHintType.TRY_HARDER);
        int iMax = Math.max(1, iC >> (z11 ? 8 : 5));
        int i16 = z11 ? iC : 15;
        int i17 = iC / 2;
        int i18 = 0;
        while (i18 < i16) {
            i11 = i18 + 1;
            int i19 = i11 / 2;
            if ((i18 & 1) != 0) {
                i19 = -i19;
            }
            i12 = (i19 * iMax) + i17;
            if (i12 < 0 || i12 >= iC) {
                break;
            }
            i18 = i11;
            iD = iD;
            c11 = 0;
            i15 = 1;
        }
        throw NotFoundException.getNotFoundInstance();
        while (i13 < 2) {
            if (i13 == i15) {
                aVar.q();
                if (map3 != null) {
                    DecodeHintType decodeHintType = DecodeHintType.NEED_RESULT_POINT_CALLBACK;
                    if (map3.containsKey(decodeHintType)) {
                        EnumMap enumMap = new EnumMap(DecodeHintType.class);
                        enumMap.putAll(map3);
                        enumMap.remove(decodeHintType);
                        map3 = enumMap;
                    }
                }
            }
            try {
                com.google.zxing.j jVarC = c(i12, aVar, map3);
                if (i13 == i15) {
                    jVarC.h(ResultMetadataType.ORIENTATION, 180);
                    com.google.zxing.k[] kVarArrE = jVarC.e();
                    if (kVarArrE != null) {
                        map2 = map3;
                        float f11 = iD;
                        try {
                            i14 = iD;
                            try {
                                kVarArrE[0] = new com.google.zxing.k((f11 - kVarArrE[c11].c()) - 1.0f, kVarArrE[c11].d());
                                try {
                                    kVarArrE[1] = new com.google.zxing.k((f11 - kVarArrE[1].c()) - 1.0f, kVarArrE[1].d());
                                } catch (ReaderException unused) {
                                    continue;
                                    i13++;
                                    map3 = map2;
                                    iD = i14;
                                    c11 = 0;
                                    i15 = 1;
                                }
                            } catch (ReaderException unused2) {
                                i13++;
                                map3 = map2;
                                iD = i14;
                                c11 = 0;
                                i15 = 1;
                            }
                        } catch (ReaderException unused3) {
                            i14 = iD;
                            i13++;
                            map3 = map2;
                            iD = i14;
                            c11 = 0;
                            i15 = 1;
                        }
                    }
                }
                return jVarC;
            } catch (ReaderException unused4) {
                map2 = map3;
            }
        }
        continue;
        i18 = i11;
        iD = iD;
        c11 = 0;
        i15 = 1;
    }

    @Override // com.google.zxing.i
    public void reset() {
    }
}
