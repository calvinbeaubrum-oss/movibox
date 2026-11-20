package c3;

import android.graphics.Path;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.MotionEventCompat;
import androidx.media3.container.MdtaMetadataEntry;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import com.google.android.gms.fido.u2f.api.common.RegisterRequest;
import java.util.ArrayList;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class e {

    /* JADX INFO: compiled from: source.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f14559a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f14560b;
    }

    /* JADX INFO: compiled from: source.java */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public char f14561a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final float[] f14562b;

        public b(char c11, float[] fArr) {
            this.f14561a = c11;
            this.f14562b = fArr;
        }

        public b(b bVar) {
            this.f14561a = bVar.f14561a;
            float[] fArr = bVar.f14562b;
            this.f14562b = e.c(fArr, 0, fArr.length);
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        public static void e(Path path, float[] fArr, char c11, char c12, float[] fArr2) {
            int i11;
            int i12;
            float f11;
            float f12;
            float f13;
            float f14;
            float f15;
            float f16;
            float f17;
            float f18;
            char c13 = c12;
            float f19 = fArr[0];
            float f21 = fArr[1];
            float f22 = fArr[2];
            float f23 = fArr[3];
            float f24 = fArr[4];
            float f25 = fArr[5];
            switch (c13) {
                case RegisterRequest.U2F_V1_CHALLENGE_BYTE_LENGTH /* 65 */:
                case 'a':
                    i11 = 7;
                    break;
                case MdtaMetadataEntry.TYPE_INDICATOR_INT32 /* 67 */:
                case 'c':
                    i11 = 6;
                    break;
                case 'H':
                case ModuleDescriptor.MODULE_VERSION /* 86 */:
                case 'h':
                case 'v':
                    i11 = 1;
                    break;
                case 'L':
                case 'M':
                case 'T':
                case 'l':
                case 'm':
                case 't':
                default:
                    i11 = 2;
                    break;
                case 'Q':
                case 'S':
                case 'q':
                case 's':
                    i11 = 4;
                    break;
                case 'Z':
                case 'z':
                    path.close();
                    path.moveTo(f24, f25);
                    f19 = f24;
                    f22 = f19;
                    f21 = f25;
                    f23 = f21;
                    i11 = 2;
                    break;
            }
            float f26 = f19;
            float f27 = f21;
            float f28 = f24;
            float f29 = f25;
            int i13 = 0;
            char c14 = c11;
            while (i13 < fArr2.length) {
                if (c13 != 'A') {
                    if (c13 == 'C') {
                        i12 = i13;
                        int i14 = i12 + 2;
                        int i15 = i12 + 3;
                        int i16 = i12 + 4;
                        int i17 = i12 + 5;
                        path.cubicTo(fArr2[i12], fArr2[i12 + 1], fArr2[i14], fArr2[i15], fArr2[i16], fArr2[i17]);
                        f26 = fArr2[i16];
                        float f31 = fArr2[i17];
                        float f32 = fArr2[i14];
                        float f33 = fArr2[i15];
                        f27 = f31;
                        f23 = f33;
                        f22 = f32;
                    } else if (c13 == 'H') {
                        i12 = i13;
                        path.lineTo(fArr2[i12], f27);
                        f26 = fArr2[i12];
                    } else if (c13 == 'Q') {
                        i12 = i13;
                        int i18 = i12 + 1;
                        int i19 = i12 + 2;
                        int i21 = i12 + 3;
                        path.quadTo(fArr2[i12], fArr2[i18], fArr2[i19], fArr2[i21]);
                        float f34 = fArr2[i12];
                        float f35 = fArr2[i18];
                        f26 = fArr2[i19];
                        f27 = fArr2[i21];
                        f22 = f34;
                        f23 = f35;
                    } else if (c13 == 'V') {
                        i12 = i13;
                        path.lineTo(f26, fArr2[i12]);
                        f27 = fArr2[i12];
                    } else if (c13 != 'a') {
                        if (c13 != 'c') {
                            if (c13 == 'h') {
                                path.rLineTo(fArr2[i13], 0.0f);
                                f26 += fArr2[i13];
                            } else if (c13 != 'q') {
                                if (c13 == 'v') {
                                    path.rLineTo(0.0f, fArr2[i13]);
                                    f14 = fArr2[i13];
                                } else if (c13 == 'L') {
                                    int i22 = i13 + 1;
                                    path.lineTo(fArr2[i13], fArr2[i22]);
                                    f26 = fArr2[i13];
                                    f27 = fArr2[i22];
                                } else if (c13 == 'M') {
                                    f26 = fArr2[i13];
                                    f27 = fArr2[i13 + 1];
                                    if (i13 > 0) {
                                        path.lineTo(f26, f27);
                                    } else {
                                        path.moveTo(f26, f27);
                                        i12 = i13;
                                        f29 = f27;
                                        f28 = f26;
                                    }
                                } else if (c13 == 'S') {
                                    if (c14 == 'c' || c14 == 's' || c14 == 'C' || c14 == 'S') {
                                        f26 = (f26 * 2.0f) - f22;
                                        f27 = (f27 * 2.0f) - f23;
                                    }
                                    float f36 = f27;
                                    float f37 = f26;
                                    int i23 = i13 + 1;
                                    int i24 = i13 + 2;
                                    int i25 = i13 + 3;
                                    path.cubicTo(f37, f36, fArr2[i13], fArr2[i23], fArr2[i24], fArr2[i25]);
                                    f11 = fArr2[i13];
                                    f12 = fArr2[i23];
                                    f26 = fArr2[i24];
                                    f27 = fArr2[i25];
                                    f22 = f11;
                                    f23 = f12;
                                } else if (c13 == 'T') {
                                    if (c14 == 'q' || c14 == 't' || c14 == 'Q' || c14 == 'T') {
                                        f26 = (f26 * 2.0f) - f22;
                                        f27 = (f27 * 2.0f) - f23;
                                    }
                                    int i26 = i13 + 1;
                                    path.quadTo(f26, f27, fArr2[i13], fArr2[i26]);
                                    i12 = i13;
                                    f23 = f27;
                                    f22 = f26;
                                    f26 = fArr2[i13];
                                    f27 = fArr2[i26];
                                } else if (c13 == 'l') {
                                    int i27 = i13 + 1;
                                    path.rLineTo(fArr2[i13], fArr2[i27]);
                                    f26 += fArr2[i13];
                                    f14 = fArr2[i27];
                                } else if (c13 == 'm') {
                                    float f38 = fArr2[i13];
                                    f26 += f38;
                                    float f39 = fArr2[i13 + 1];
                                    f27 += f39;
                                    if (i13 > 0) {
                                        path.rLineTo(f38, f39);
                                    } else {
                                        path.rMoveTo(f38, f39);
                                        i12 = i13;
                                        f29 = f27;
                                        f28 = f26;
                                    }
                                } else if (c13 == 's') {
                                    if (c14 == 'c' || c14 == 's' || c14 == 'C' || c14 == 'S') {
                                        float f40 = f26 - f22;
                                        f15 = f27 - f23;
                                        f16 = f40;
                                    } else {
                                        f16 = 0.0f;
                                        f15 = 0.0f;
                                    }
                                    int i28 = i13 + 1;
                                    int i29 = i13 + 2;
                                    int i31 = i13 + 3;
                                    path.rCubicTo(f16, f15, fArr2[i13], fArr2[i28], fArr2[i29], fArr2[i31]);
                                    f11 = fArr2[i13] + f26;
                                    f12 = fArr2[i28] + f27;
                                    f26 += fArr2[i29];
                                    f13 = fArr2[i31];
                                } else if (c13 == 't') {
                                    if (c14 == 'q' || c14 == 't' || c14 == 'Q' || c14 == 'T') {
                                        f17 = f26 - f22;
                                        f18 = f27 - f23;
                                    } else {
                                        f18 = 0.0f;
                                        f17 = 0.0f;
                                    }
                                    int i32 = i13 + 1;
                                    path.rQuadTo(f17, f18, fArr2[i13], fArr2[i32]);
                                    float f41 = f17 + f26;
                                    float f42 = f18 + f27;
                                    f26 += fArr2[i13];
                                    f27 += fArr2[i32];
                                    f23 = f42;
                                    f22 = f41;
                                }
                                f27 += f14;
                            } else {
                                int i33 = i13 + 1;
                                int i34 = i13 + 2;
                                int i35 = i13 + 3;
                                path.rQuadTo(fArr2[i13], fArr2[i33], fArr2[i34], fArr2[i35]);
                                f11 = fArr2[i13] + f26;
                                f12 = fArr2[i33] + f27;
                                f26 += fArr2[i34];
                                f13 = fArr2[i35];
                            }
                            i12 = i13;
                        } else {
                            int i36 = i13 + 2;
                            int i37 = i13 + 3;
                            int i38 = i13 + 4;
                            int i39 = i13 + 5;
                            path.rCubicTo(fArr2[i13], fArr2[i13 + 1], fArr2[i36], fArr2[i37], fArr2[i38], fArr2[i39]);
                            f11 = fArr2[i36] + f26;
                            f12 = fArr2[i37] + f27;
                            f26 += fArr2[i38];
                            f13 = fArr2[i39];
                        }
                        f27 += f13;
                        f22 = f11;
                        f23 = f12;
                        i12 = i13;
                    } else {
                        int i40 = i13 + 5;
                        int i41 = i13 + 6;
                        i12 = i13;
                        g(path, f26, f27, fArr2[i40] + f26, fArr2[i41] + f27, fArr2[i13], fArr2[i13 + 1], fArr2[i13 + 2], fArr2[i13 + 3] != 0.0f, fArr2[i13 + 4] != 0.0f);
                        f26 += fArr2[i40];
                        f27 += fArr2[i41];
                    }
                    i13 = i12 + i11;
                    c14 = c12;
                    c13 = c14;
                } else {
                    i12 = i13;
                    int i42 = i12 + 5;
                    int i43 = i12 + 6;
                    g(path, f26, f27, fArr2[i42], fArr2[i43], fArr2[i12], fArr2[i12 + 1], fArr2[i12 + 2], fArr2[i12 + 3] != 0.0f, fArr2[i12 + 4] != 0.0f);
                    f26 = fArr2[i42];
                    f27 = fArr2[i43];
                }
                f23 = f27;
                f22 = f26;
                i13 = i12 + i11;
                c14 = c12;
                c13 = c14;
            }
            fArr[0] = f26;
            fArr[1] = f27;
            fArr[2] = f22;
            fArr[3] = f23;
            fArr[4] = f28;
            fArr[5] = f29;
        }

        public static void f(Path path, double d11, double d12, double d13, double d14, double d15, double d16, double d17, double d18, double d19) {
            double d21 = d13;
            int iCeil = (int) Math.ceil(Math.abs((d19 * 4.0d) / 3.141592653589793d));
            double dCos = Math.cos(d17);
            double dSin = Math.sin(d17);
            double dCos2 = Math.cos(d18);
            double dSin2 = Math.sin(d18);
            double d22 = -d21;
            double d23 = d22 * dCos;
            double d24 = d14 * dSin;
            double d25 = (d23 * dSin2) - (d24 * dCos2);
            double d26 = d22 * dSin;
            double d27 = d14 * dCos;
            double d28 = (dSin2 * d26) + (dCos2 * d27);
            double d29 = d19 / ((double) iCeil);
            double d31 = d18;
            double d32 = d28;
            double d33 = d25;
            int i11 = 0;
            double d34 = d15;
            double d35 = d16;
            while (i11 < iCeil) {
                double d36 = d31 + d29;
                double dSin3 = Math.sin(d36);
                double dCos3 = Math.cos(d36);
                double d37 = (d11 + ((d21 * dCos) * dCos3)) - (d24 * dSin3);
                double d38 = d12 + (d21 * dSin * dCos3) + (d27 * dSin3);
                double d39 = (d23 * dSin3) - (d24 * dCos3);
                double d40 = (dSin3 * d26) + (dCos3 * d27);
                double d41 = d36 - d31;
                double dTan = Math.tan(d41 / 2.0d);
                double dSin4 = (Math.sin(d41) * (Math.sqrt(((dTan * 3.0d) * dTan) + 4.0d) - 1.0d)) / 3.0d;
                double d42 = d34 + (d33 * dSin4);
                double d43 = dCos;
                double d44 = dSin;
                path.rLineTo(0.0f, 0.0f);
                path.cubicTo((float) d42, (float) (d35 + (d32 * dSin4)), (float) (d37 - (dSin4 * d39)), (float) (d38 - (dSin4 * d40)), (float) d37, (float) d38);
                i11++;
                d29 = d29;
                dSin = d44;
                d34 = d37;
                d26 = d26;
                dCos = d43;
                d31 = d36;
                d32 = d40;
                d33 = d39;
                iCeil = iCeil;
                d35 = d38;
                d21 = d13;
            }
        }

        public static void g(Path path, float f11, float f12, float f13, float f14, float f15, float f16, float f17, boolean z11, boolean z12) {
            double d11;
            double d12;
            double radians = Math.toRadians(f17);
            double dCos = Math.cos(radians);
            double dSin = Math.sin(radians);
            double d13 = f11;
            double d14 = d13 * dCos;
            double d15 = f12;
            double d16 = f15;
            double d17 = (d14 + (d15 * dSin)) / d16;
            double d18 = (((double) (-f11)) * dSin) + (d15 * dCos);
            double d19 = f16;
            double d21 = d18 / d19;
            double d22 = f14;
            double d23 = ((((double) f13) * dCos) + (d22 * dSin)) / d16;
            double d24 = ((((double) (-f13)) * dSin) + (d22 * dCos)) / d19;
            double d25 = d17 - d23;
            double d26 = d21 - d24;
            double d27 = (d17 + d23) / 2.0d;
            double d28 = (d21 + d24) / 2.0d;
            double d29 = (d25 * d25) + (d26 * d26);
            if (d29 == 0.0d) {
                Log.w("PathParser", " Points are coincident");
                return;
            }
            double d31 = (1.0d / d29) - 0.25d;
            if (d31 < 0.0d) {
                Log.w("PathParser", "Points are too far apart " + d29);
                float fSqrt = (float) (Math.sqrt(d29) / 1.99999d);
                g(path, f11, f12, f13, f14, f15 * fSqrt, f16 * fSqrt, f17, z11, z12);
                return;
            }
            double dSqrt = Math.sqrt(d31);
            double d32 = d25 * dSqrt;
            double d33 = dSqrt * d26;
            if (z11 == z12) {
                d11 = d27 - d33;
                d12 = d28 + d32;
            } else {
                d11 = d27 + d33;
                d12 = d28 - d32;
            }
            double dAtan2 = Math.atan2(d21 - d12, d17 - d11);
            double dAtan3 = Math.atan2(d24 - d12, d23 - d11) - dAtan2;
            if (z12 != (dAtan3 >= 0.0d)) {
                dAtan3 = dAtan3 > 0.0d ? dAtan3 - 6.283185307179586d : dAtan3 + 6.283185307179586d;
            }
            double d34 = d11 * d16;
            double d35 = d12 * d19;
            f(path, (d34 * dCos) - (d35 * dSin), (d34 * dSin) + (d35 * dCos), d16, d19, d13, d15, radians, dAtan2, dAtan3);
        }

        @Deprecated
        public static void i(@NonNull b[] bVarArr, @NonNull Path path) {
            e.j(bVarArr, path);
        }

        public void h(@NonNull b bVar, @NonNull b bVar2, float f11) {
            this.f14561a = bVar.f14561a;
            int i11 = 0;
            while (true) {
                float[] fArr = bVar.f14562b;
                if (i11 >= fArr.length) {
                    return;
                }
                this.f14562b[i11] = (fArr[i11] * (1.0f - f11)) + (bVar2.f14562b[i11] * f11);
                i11++;
            }
        }
    }

    public static void a(ArrayList<b> arrayList, char c11, float[] fArr) {
        arrayList.add(new b(c11, fArr));
    }

    public static boolean b(@Nullable b[] bVarArr, @Nullable b[] bVarArr2) {
        if (bVarArr == null || bVarArr2 == null || bVarArr.length != bVarArr2.length) {
            return false;
        }
        for (int i11 = 0; i11 < bVarArr.length; i11++) {
            if (bVarArr[i11].f14561a != bVarArr2[i11].f14561a || bVarArr[i11].f14562b.length != bVarArr2[i11].f14562b.length) {
                return false;
            }
        }
        return true;
    }

    public static float[] c(float[] fArr, int i11, int i12) {
        if (i11 > i12) {
            throw new IllegalArgumentException();
        }
        int length = fArr.length;
        if (i11 < 0 || i11 > length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int i13 = i12 - i11;
        int iMin = Math.min(i13, length - i11);
        float[] fArr2 = new float[i13];
        System.arraycopy(fArr, i11, fArr2, 0, iMin);
        return fArr2;
    }

    @NonNull
    public static b[] d(@NonNull String str) {
        ArrayList arrayList = new ArrayList();
        int i11 = 1;
        int i12 = 0;
        while (i11 < str.length()) {
            int i13 = i(str, i11);
            String strTrim = str.substring(i12, i13).trim();
            if (!strTrim.isEmpty()) {
                a(arrayList, strTrim.charAt(0), h(strTrim));
            }
            i12 = i13;
            i11 = i13 + 1;
        }
        if (i11 - i12 == 1 && i12 < str.length()) {
            a(arrayList, str.charAt(i12), new float[0]);
        }
        return (b[]) arrayList.toArray(new b[0]);
    }

    @NonNull
    public static Path e(@NonNull String str) {
        Path path = new Path();
        try {
            b.i(d(str), path);
            return path;
        } catch (RuntimeException e11) {
            throw new RuntimeException("Error in parsing " + str, e11);
        }
    }

    @NonNull
    public static b[] f(@NonNull b[] bVarArr) {
        b[] bVarArr2 = new b[bVarArr.length];
        for (int i11 = 0; i11 < bVarArr.length; i11++) {
            bVarArr2[i11] = new b(bVarArr[i11]);
        }
        return bVarArr2;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:16:0x0029  */
    /* JADX WARN: Code duplicated, block: B:20:0x0033  */
    public static void g(String str, int i11, a aVar) {
        aVar.f14560b = false;
        boolean z11 = false;
        boolean z12 = false;
        boolean z13 = false;
        for (int i12 = i11; i12 < str.length(); i12++) {
            char cCharAt = str.charAt(i12);
            if (cCharAt == ' ') {
                z11 = false;
                z13 = true;
            } else if (cCharAt != 'E' && cCharAt != 'e') {
                switch (cCharAt) {
                    case MotionEventCompat.AXIS_GENERIC_13 /* 44 */:
                        z11 = false;
                        z13 = true;
                        break;
                    case MotionEventCompat.AXIS_GENERIC_14 /* 45 */:
                        if (i12 == i11 || z11) {
                            z11 = false;
                        } else {
                            aVar.f14560b = true;
                            z11 = false;
                            z13 = true;
                        }
                        break;
                    case MotionEventCompat.AXIS_GENERIC_15 /* 46 */:
                        if (z12) {
                            aVar.f14560b = true;
                            z11 = false;
                            z13 = true;
                        } else {
                            z11 = false;
                            z12 = true;
                        }
                        break;
                    default:
                        z11 = false;
                        break;
                }
            } else {
                z11 = true;
            }
            if (z13) {
                aVar.f14559a = i12;
            }
        }
        aVar.f14559a = i12;
    }

    public static float[] h(String str) {
        if (str.charAt(0) == 'z' || str.charAt(0) == 'Z') {
            return new float[0];
        }
        try {
            float[] fArr = new float[str.length()];
            a aVar = new a();
            int length = str.length();
            int i11 = 1;
            int i12 = 0;
            while (i11 < length) {
                g(str, i11, aVar);
                int i13 = aVar.f14559a;
                if (i11 < i13) {
                    fArr[i12] = Float.parseFloat(str.substring(i11, i13));
                    i12++;
                }
                i11 = aVar.f14560b ? i13 : i13 + 1;
            }
            return c(fArr, 0, i12);
        } catch (NumberFormatException e11) {
            throw new RuntimeException("error in parsing \"" + str + "\"", e11);
        }
    }

    public static int i(String str, int i11) {
        while (i11 < str.length()) {
            char cCharAt = str.charAt(i11);
            if (((cCharAt - 'A') * (cCharAt - 'Z') <= 0 || (cCharAt - 'a') * (cCharAt - 'z') <= 0) && cCharAt != 'e' && cCharAt != 'E') {
                return i11;
            }
            i11++;
        }
        return i11;
    }

    public static void j(@NonNull b[] bVarArr, @NonNull Path path) {
        float[] fArr = new float[6];
        char c11 = 'm';
        for (b bVar : bVarArr) {
            b.e(path, fArr, c11, bVar.f14561a, bVar.f14562b);
            c11 = bVar.f14561a;
        }
    }

    public static void k(@NonNull b[] bVarArr, @NonNull b[] bVarArr2) {
        for (int i11 = 0; i11 < bVarArr2.length; i11++) {
            bVarArr[i11].f14561a = bVarArr2[i11].f14561a;
            for (int i12 = 0; i12 < bVarArr2[i11].f14562b.length; i12++) {
                bVarArr[i11].f14562b[i12] = bVarArr2[i11].f14562b[i12];
            }
        }
    }
}
