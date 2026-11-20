package com.transsion.baseui.image.blurhash;

import android.graphics.Bitmap;
import android.graphics.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.g;
import kotlin.collections.h;
import kotlin.collections.s;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@SourceDebugExtension
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f51394a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final HashMap<Integer, double[]> f51395b = new HashMap<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final HashMap<Integer, double[]> f51396c = new HashMap<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Map<Character, Integer> f51397d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f51398e;

    static {
        List listO = g.o('0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '#', '$', '%', '*', '+', ',', '-', '.', ':', ';', '=', '?', '@', '[', ']', '^', '_', '{', '|', '}', '~');
        ArrayList arrayList = new ArrayList(h.v(listO, 10));
        int i11 = 0;
        for (Object obj : listO) {
            int i12 = i11 + 1;
            if (i11 < 0) {
                g.u();
            }
            arrayList.add(TuplesKt.a(Character.valueOf(((Character) obj).charValue()), Integer.valueOf(i11)));
            i11 = i12;
        }
        f51397d = s.r(arrayList);
        f51398e = 8;
    }

    public final Bitmap a(int i11, int i12, int i13, int i14, float[][] fArr, boolean z11) {
        int[] iArr = new int[i11 * i12];
        boolean z12 = (z11 && f51395b.containsKey(Integer.valueOf(i11 * i13))) ? false : true;
        double[] dArrF = f(z12, i11, i13);
        boolean z13 = (z11 && f51396c.containsKey(Integer.valueOf(i12 * i14))) ? false : true;
        double[] dArrG = g(z13, i12, i14);
        int i15 = 0;
        while (i15 < i12) {
            int i16 = 0;
            while (i16 < i11) {
                float f11 = 0.0f;
                float f12 = 0.0f;
                float f13 = 0.0f;
                int i17 = 0;
                while (i17 < i14) {
                    float f14 = f11;
                    float f15 = f12;
                    float f16 = f13;
                    int i18 = 0;
                    while (i18 < i13) {
                        int i19 = i18;
                        int i21 = i17;
                        int i22 = i16;
                        boolean z14 = z13;
                        i15 = i15;
                        float fH = (float) (h(dArrG, z14, i21, i14, i15, i12) * h(dArrF, z12, i19, i13, i22, i11));
                        float[] fArr2 = fArr[(i21 * i13) + i19];
                        f14 += fArr2[0] * fH;
                        f15 += fArr2[1] * fH;
                        f16 += fArr2[2] * fH;
                        i18 = i19 + 1;
                        i17 = i21;
                        i16 = i22;
                        z13 = z14;
                    }
                    i17++;
                    f11 = f14;
                    f12 = f15;
                    f13 = f16;
                }
                int i23 = i16;
                iArr[i23 + (i11 * i15)] = Color.rgb(i(f11), i(f12), i(f13));
                i16 = i23 + 1;
            }
            i15++;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iArr, i11, i12, Bitmap.Config.ARGB_8888);
        Intrinsics.f(bitmapCreateBitmap, "createBitmap(imageArray,… Bitmap.Config.ARGB_8888)");
        return bitmapCreateBitmap;
    }

    public final Bitmap b(String str, int i11, int i12, float f11, boolean z11) {
        float[] fArrD;
        if (str == null || str.length() < 6) {
            return null;
        }
        int iC = c(str, 0, 1);
        int i13 = (iC % 9) + 1;
        int i14 = (iC / 9) + 1;
        if (str.length() != (i13 * 2 * i14) + 4) {
            return null;
        }
        float fC = (c(str, 1, 2) + 1) / 166.0f;
        int i15 = i13 * i14;
        float[][] fArr = new float[i15][];
        for (int i16 = 0; i16 < i15; i16++) {
            if (i16 == 0) {
                a aVar = f51394a;
                fArrD = aVar.e(aVar.c(str, 2, 6));
            } else {
                int i17 = i16 * 2;
                a aVar2 = f51394a;
                fArrD = aVar2.d(aVar2.c(str, i17 + 4, i17 + 6), fC * f11);
            }
            fArr[i16] = fArrD;
        }
        return a(i11, i12, i13, i14, fArr, z11);
    }

    public final int c(String str, int i11, int i12) {
        int i13 = 0;
        while (i11 < i12) {
            Integer num = f51397d.get(Character.valueOf(str.charAt(i11)));
            int iIntValue = num != null ? num.intValue() : -1;
            if (iIntValue != -1) {
                i13 = (i13 * 83) + iIntValue;
            }
            i11++;
        }
        return i13;
    }

    public final float[] d(int i11, float f11) {
        return new float[]{j(((i11 / 361) - 9) / 9.0f) * f11, j((((i11 / 19) % 19) - 9) / 9.0f) * f11, j(((i11 % 19) - 9) / 9.0f) * f11};
    }

    public final float[] e(int i11) {
        return new float[]{k(i11 >> 16), k((i11 >> 8) & 255), k(i11 & 255)};
    }

    public final double[] f(boolean z11, int i11, int i12) {
        if (!z11) {
            double[] dArr = f51395b.get(Integer.valueOf(i11 * i12));
            Intrinsics.d(dArr);
            return dArr;
        }
        int i13 = i11 * i12;
        double[] dArr2 = new double[i13];
        f51395b.put(Integer.valueOf(i13), dArr2);
        return dArr2;
    }

    public final double[] g(boolean z11, int i11, int i12) {
        if (z11) {
            int i13 = i11 * i12;
            double[] dArr = new double[i13];
            f51396c.put(Integer.valueOf(i13), dArr);
            return dArr;
        }
        double[] dArr2 = f51396c.get(Integer.valueOf(i11 * i12));
        Intrinsics.d(dArr2);
        Intrinsics.f(dArr2, "{\n            cacheCosin…t * numCompY]!!\n        }");
        return dArr2;
    }

    public final double h(double[] dArr, boolean z11, int i11, int i12, int i13, int i14) {
        if (z11) {
            dArr[(i12 * i13) + i11] = Math.cos(((((double) i13) * 3.141592653589793d) * ((double) i11)) / ((double) i14));
        }
        return dArr[i11 + (i12 * i13)];
    }

    public final int i(float f11) {
        float fPow;
        float f12;
        float fJ = kotlin.ranges.a.j(f11, 0.0f, 1.0f);
        if (fJ <= 0.0031308f) {
            fPow = fJ * 12.92f;
            f12 = 255.0f;
        } else {
            fPow = (((float) Math.pow(fJ, 0.41666666f)) * 1.055f) - 0.055f;
            f12 = 255;
        }
        return (int) ((fPow * f12) + 0.5f);
    }

    public final float j(float f11) {
        return Math.copySign((float) Math.pow(f11, 2.0f), f11);
    }

    public final float k(int i11) {
        float f11 = i11 / 255.0f;
        return f11 <= 0.04045f ? f11 / 12.92f : (float) Math.pow((f11 + 0.055f) / 1.055f, 2.4f);
    }
}
