package com.google.protobuf;

import androidx.core.view.MotionEventCompat;
import androidx.media3.container.MdtaMetadataEntry;
import com.google.android.gms.fido.u2f.api.common.RegisterRequest;
import com.transsion.baselib.db.download.DownloadBean;
import com.vungle.warren.error.VungleException;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.mvel2.ast.ASTNode;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class q0<T> implements b1<T> {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int[] f41390r = new int[0];

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final Unsafe f41391s = l1.H();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int[] f41392a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object[] f41393b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f41394c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f41395d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final n0 f41396e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f41397f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f41398g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f41399h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f41400i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int[] f41401j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f41402k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f41403l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final s0 f41404m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final e0 f41405n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final h1<?, ?> f41406o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final q<?> f41407p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final i0 f41408q;

    /* JADX INFO: compiled from: source.java */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f41409a;

        static {
            int[] iArr = new int[WireFormat.FieldType.values().length];
            f41409a = iArr;
            try {
                iArr[WireFormat.FieldType.BOOL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f41409a[WireFormat.FieldType.BYTES.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f41409a[WireFormat.FieldType.DOUBLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f41409a[WireFormat.FieldType.FIXED32.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f41409a[WireFormat.FieldType.SFIXED32.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f41409a[WireFormat.FieldType.FIXED64.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f41409a[WireFormat.FieldType.SFIXED64.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f41409a[WireFormat.FieldType.FLOAT.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f41409a[WireFormat.FieldType.ENUM.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f41409a[WireFormat.FieldType.INT32.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f41409a[WireFormat.FieldType.UINT32.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f41409a[WireFormat.FieldType.INT64.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f41409a[WireFormat.FieldType.UINT64.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f41409a[WireFormat.FieldType.MESSAGE.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f41409a[WireFormat.FieldType.SINT32.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f41409a[WireFormat.FieldType.SINT64.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f41409a[WireFormat.FieldType.STRING.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
        }
    }

    public q0(int[] iArr, Object[] objArr, int i11, int i12, n0 n0Var, boolean z11, boolean z12, int[] iArr2, int i13, int i14, s0 s0Var, e0 e0Var, h1<?, ?> h1Var, q<?> qVar, i0 i0Var) {
        this.f41392a = iArr;
        this.f41393b = objArr;
        this.f41394c = i11;
        this.f41395d = i12;
        this.f41398g = n0Var instanceof GeneratedMessageLite;
        this.f41399h = z11;
        this.f41397f = qVar != null && qVar.e(n0Var);
        this.f41400i = z12;
        this.f41401j = iArr2;
        this.f41402k = i13;
        this.f41403l = i14;
        this.f41404m = s0Var;
        this.f41405n = e0Var;
        this.f41406o = h1Var;
        this.f41407p = qVar;
        this.f41396e = n0Var;
        this.f41408q = i0Var;
    }

    public static <T> int A(T t11, long j11) {
        return l1.C(t11, j11);
    }

    public static boolean B(int i11) {
        return (i11 & ASTNode.DISCARD) != 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean E(Object obj, int i11, b1 b1Var) {
        return b1Var.d(l1.G(obj, V(i11)));
    }

    public static boolean J(int i11) {
        return (i11 & ASTNode.DEOP) != 0;
    }

    public static List<?> K(Object obj, long j11) {
        return (List) l1.G(obj, j11);
    }

    public static <T> long L(T t11, long j11) {
        return l1.E(t11, j11);
    }

    public static <T> q0<T> R(Class<T> cls, l0 l0Var, s0 s0Var, e0 e0Var, h1<?, ?> h1Var, q<?> qVar, i0 i0Var) {
        return l0Var instanceof z0 ? T((z0) l0Var, s0Var, e0Var, h1Var, qVar, i0Var) : S((f1) l0Var, s0Var, e0Var, h1Var, qVar, i0Var);
    }

    public static <T> q0<T> S(f1 f1Var, s0 s0Var, e0 e0Var, h1<?, ?> h1Var, q<?> qVar, i0 i0Var) {
        boolean z11 = f1Var.c() == ProtoSyntax.PROTO3;
        t[] tVarArrE = f1Var.e();
        if (tVarArrE.length != 0) {
            t tVar = tVarArrE[0];
            throw null;
        }
        int length = tVarArrE.length;
        int[] iArr = new int[length * 3];
        Object[] objArr = new Object[length * 2];
        if (tVarArrE.length > 0) {
            t tVar2 = tVarArrE[0];
            throw null;
        }
        int[] iArrD = f1Var.d();
        if (iArrD == null) {
            iArrD = f41390r;
        }
        if (tVarArrE.length > 0) {
            t tVar3 = tVarArrE[0];
            throw null;
        }
        int[] iArr2 = f41390r;
        int[] iArr3 = f41390r;
        int[] iArr4 = new int[iArrD.length + iArr2.length + iArr3.length];
        System.arraycopy(iArrD, 0, iArr4, 0, iArrD.length);
        System.arraycopy(iArr2, 0, iArr4, iArrD.length, iArr2.length);
        System.arraycopy(iArr3, 0, iArr4, iArrD.length + iArr2.length, iArr3.length);
        return new q0<>(iArr, objArr, 0, 0, f1Var.b(), z11, true, iArr4, iArrD.length, iArrD.length + iArr2.length, s0Var, e0Var, h1Var, qVar, i0Var);
    }

    /* JADX WARN: Code duplicated, block: B:122:0x024e  */
    /* JADX WARN: Code duplicated, block: B:124:0x0254  */
    /* JADX WARN: Code duplicated, block: B:127:0x026a  */
    /* JADX WARN: Code duplicated, block: B:129:0x026e  */
    /* JADX WARN: Code duplicated, block: B:163:0x031f  */
    /* JADX WARN: Code duplicated, block: B:179:0x036f  */
    /* JADX WARN: Code duplicated, block: B:182:0x037d  */
    public static <T> q0<T> T(z0 z0Var, s0 s0Var, e0 e0Var, h1<?, ?> h1Var, q<?> qVar, i0 i0Var) {
        int i11;
        int iCharAt;
        int iCharAt2;
        int iCharAt3;
        int iCharAt4;
        int iCharAt5;
        int[] iArr;
        int i12;
        int i13;
        int i14;
        char cCharAt;
        int i15;
        char cCharAt2;
        int i16;
        char cCharAt3;
        int i17;
        char cCharAt4;
        int i18;
        char cCharAt5;
        int i19;
        char cCharAt6;
        int i21;
        char cCharAt7;
        int i22;
        char cCharAt8;
        int i23;
        int i24;
        int i25;
        int i26;
        int i27;
        int i28;
        int iObjectFieldOffset;
        int iObjectFieldOffset2;
        int i29;
        int i31;
        Field fieldN0;
        char cCharAt9;
        int i32;
        int i33;
        int i34;
        Object obj;
        Field fieldN1;
        int i35;
        Object obj2;
        Field fieldN2;
        int i36;
        char cCharAt10;
        int i37;
        char cCharAt11;
        int i38;
        char cCharAt12;
        int i39;
        char cCharAt13;
        boolean z11 = z0Var.c() == ProtoSyntax.PROTO3;
        String strE = z0Var.e();
        int length = strE.length();
        char c11 = 55296;
        if (strE.charAt(0) >= 55296) {
            int i40 = 1;
            while (true) {
                i11 = i40 + 1;
                if (strE.charAt(i40) < 55296) {
                    break;
                }
                i40 = i11;
            }
        } else {
            i11 = 1;
        }
        int i41 = i11 + 1;
        int iCharAt6 = strE.charAt(i11);
        if (iCharAt6 >= 55296) {
            int i42 = iCharAt6 & 8191;
            int i43 = 13;
            while (true) {
                i39 = i41 + 1;
                cCharAt13 = strE.charAt(i41);
                if (cCharAt13 < 55296) {
                    break;
                }
                i42 |= (cCharAt13 & 8191) << i43;
                i43 += 13;
                i41 = i39;
            }
            iCharAt6 = i42 | (cCharAt13 << i43);
            i41 = i39;
        }
        if (iCharAt6 == 0) {
            iArr = f41390r;
            i13 = 0;
            iCharAt = 0;
            iCharAt2 = 0;
            iCharAt3 = 0;
            iCharAt4 = 0;
            iCharAt5 = 0;
            i12 = 0;
        } else {
            int i44 = i41 + 1;
            int iCharAt7 = strE.charAt(i41);
            if (iCharAt7 >= 55296) {
                int i45 = iCharAt7 & 8191;
                int i46 = 13;
                while (true) {
                    i22 = i44 + 1;
                    cCharAt8 = strE.charAt(i44);
                    if (cCharAt8 < 55296) {
                        break;
                    }
                    i45 |= (cCharAt8 & 8191) << i46;
                    i46 += 13;
                    i44 = i22;
                }
                iCharAt7 = i45 | (cCharAt8 << i46);
                i44 = i22;
            }
            int i47 = i44 + 1;
            int iCharAt8 = strE.charAt(i44);
            if (iCharAt8 >= 55296) {
                int i48 = iCharAt8 & 8191;
                int i49 = 13;
                while (true) {
                    i21 = i47 + 1;
                    cCharAt7 = strE.charAt(i47);
                    if (cCharAt7 < 55296) {
                        break;
                    }
                    i48 |= (cCharAt7 & 8191) << i49;
                    i49 += 13;
                    i47 = i21;
                }
                iCharAt8 = i48 | (cCharAt7 << i49);
                i47 = i21;
            }
            int i50 = i47 + 1;
            iCharAt = strE.charAt(i47);
            if (iCharAt >= 55296) {
                int i51 = iCharAt & 8191;
                int i52 = 13;
                while (true) {
                    i19 = i50 + 1;
                    cCharAt6 = strE.charAt(i50);
                    if (cCharAt6 < 55296) {
                        break;
                    }
                    i51 |= (cCharAt6 & 8191) << i52;
                    i52 += 13;
                    i50 = i19;
                }
                iCharAt = i51 | (cCharAt6 << i52);
                i50 = i19;
            }
            int i53 = i50 + 1;
            iCharAt2 = strE.charAt(i50);
            if (iCharAt2 >= 55296) {
                int i54 = iCharAt2 & 8191;
                int i55 = 13;
                while (true) {
                    i18 = i53 + 1;
                    cCharAt5 = strE.charAt(i53);
                    if (cCharAt5 < 55296) {
                        break;
                    }
                    i54 |= (cCharAt5 & 8191) << i55;
                    i55 += 13;
                    i53 = i18;
                }
                iCharAt2 = i54 | (cCharAt5 << i55);
                i53 = i18;
            }
            int i56 = i53 + 1;
            iCharAt3 = strE.charAt(i53);
            if (iCharAt3 >= 55296) {
                int i57 = iCharAt3 & 8191;
                int i58 = 13;
                while (true) {
                    i17 = i56 + 1;
                    cCharAt4 = strE.charAt(i56);
                    if (cCharAt4 < 55296) {
                        break;
                    }
                    i57 |= (cCharAt4 & 8191) << i58;
                    i58 += 13;
                    i56 = i17;
                }
                iCharAt3 = i57 | (cCharAt4 << i58);
                i56 = i17;
            }
            int i59 = i56 + 1;
            iCharAt4 = strE.charAt(i56);
            if (iCharAt4 >= 55296) {
                int i60 = iCharAt4 & 8191;
                int i61 = 13;
                while (true) {
                    i16 = i59 + 1;
                    cCharAt3 = strE.charAt(i59);
                    if (cCharAt3 < 55296) {
                        break;
                    }
                    i60 |= (cCharAt3 & 8191) << i61;
                    i61 += 13;
                    i59 = i16;
                }
                iCharAt4 = i60 | (cCharAt3 << i61);
                i59 = i16;
            }
            int i62 = i59 + 1;
            int iCharAt9 = strE.charAt(i59);
            if (iCharAt9 >= 55296) {
                int i63 = iCharAt9 & 8191;
                int i64 = 13;
                while (true) {
                    i15 = i62 + 1;
                    cCharAt2 = strE.charAt(i62);
                    if (cCharAt2 < 55296) {
                        break;
                    }
                    i63 |= (cCharAt2 & 8191) << i64;
                    i64 += 13;
                    i62 = i15;
                }
                iCharAt9 = i63 | (cCharAt2 << i64);
                i62 = i15;
            }
            int i65 = i62 + 1;
            iCharAt5 = strE.charAt(i62);
            if (iCharAt5 >= 55296) {
                int i66 = iCharAt5 & 8191;
                int i67 = 13;
                while (true) {
                    i14 = i65 + 1;
                    cCharAt = strE.charAt(i65);
                    if (cCharAt < 55296) {
                        break;
                    }
                    i66 |= (cCharAt & 8191) << i67;
                    i67 += 13;
                    i65 = i14;
                }
                iCharAt5 = i66 | (cCharAt << i67);
                i65 = i14;
            }
            iArr = new int[iCharAt5 + iCharAt4 + iCharAt9];
            i12 = (iCharAt7 * 2) + iCharAt8;
            i13 = iCharAt7;
            i41 = i65;
        }
        Unsafe unsafe = f41391s;
        Object[] objArrD = z0Var.d();
        Class<?> cls = z0Var.b().getClass();
        int[] iArr2 = new int[iCharAt3 * 3];
        Object[] objArr = new Object[iCharAt3 * 2];
        int i68 = iCharAt5 + iCharAt4;
        int i69 = iCharAt5;
        int i70 = i68;
        int i71 = 0;
        int i72 = 0;
        while (i41 < length) {
            int i73 = i41 + 1;
            int iCharAt10 = strE.charAt(i41);
            if (iCharAt10 >= c11) {
                int i74 = iCharAt10 & 8191;
                int i75 = i73;
                int i76 = 13;
                while (true) {
                    i38 = i75 + 1;
                    cCharAt12 = strE.charAt(i75);
                    if (cCharAt12 < c11) {
                        break;
                    }
                    i74 |= (cCharAt12 & 8191) << i76;
                    i76 += 13;
                    i75 = i38;
                }
                iCharAt10 = i74 | (cCharAt12 << i76);
                i23 = i38;
            } else {
                i23 = i73;
            }
            int i77 = i23 + 1;
            int iCharAt11 = strE.charAt(i23);
            if (iCharAt11 >= c11) {
                int i78 = iCharAt11 & 8191;
                int i79 = i77;
                int i80 = 13;
                while (true) {
                    i37 = i79 + 1;
                    cCharAt11 = strE.charAt(i79);
                    i24 = length;
                    if (cCharAt11 < 55296) {
                        break;
                    }
                    i78 |= (cCharAt11 & 8191) << i80;
                    i80 += 13;
                    i79 = i37;
                    length = i24;
                }
                iCharAt11 = i78 | (cCharAt11 << i80);
                i25 = i37;
            } else {
                i24 = length;
                i25 = i77;
            }
            int i81 = iCharAt11 & 255;
            int i82 = iCharAt5;
            if ((iCharAt11 & 1024) != 0) {
                iArr[i71] = i72;
                i71++;
            }
            int i83 = i71;
            if (i81 >= 51) {
                int i84 = i25 + 1;
                int iCharAt12 = strE.charAt(i25);
                char c12 = 55296;
                if (iCharAt12 >= 55296) {
                    int i85 = iCharAt12 & 8191;
                    int i86 = 13;
                    while (true) {
                        i36 = i84 + 1;
                        cCharAt10 = strE.charAt(i84);
                        if (cCharAt10 < c12) {
                            break;
                        }
                        i85 |= (cCharAt10 & 8191) << i86;
                        i86 += 13;
                        i84 = i36;
                        c12 = 55296;
                    }
                    iCharAt12 = i85 | (cCharAt10 << i86);
                    i84 = i36;
                }
                int i87 = i81 - 51;
                int i88 = i84;
                if (i87 == 9 || i87 == 17) {
                    i33 = i12 + 1;
                    objArr[((i72 / 3) * 2) + 1] = objArrD[i12];
                } else {
                    if (i87 == 12 && !z11) {
                        i33 = i12 + 1;
                        objArr[((i72 / 3) * 2) + 1] = objArrD[i12];
                    }
                    i34 = iCharAt12 * 2;
                    obj = objArrD[i34];
                    if (obj instanceof Field) {
                        fieldN1 = (Field) obj;
                    } else {
                        fieldN1 = n0(cls, (String) obj);
                        objArrD[i34] = fieldN1;
                    }
                    i26 = iCharAt;
                    i27 = iCharAt2;
                    int iObjectFieldOffset3 = (int) unsafe.objectFieldOffset(fieldN1);
                    i35 = i34 + 1;
                    obj2 = objArrD[i35];
                    if (obj2 instanceof Field) {
                        fieldN2 = (Field) obj2;
                    } else {
                        fieldN2 = n0(cls, (String) obj2);
                        objArrD[i35] = fieldN2;
                    }
                    int iObjectFieldOffset4 = (int) unsafe.objectFieldOffset(fieldN2);
                    strE = strE;
                    z11 = z11;
                    objArr = objArr;
                    i29 = i88;
                    iObjectFieldOffset2 = iObjectFieldOffset4;
                    iObjectFieldOffset = iObjectFieldOffset3;
                    i31 = 0;
                }
                i12 = i33;
                i34 = iCharAt12 * 2;
                obj = objArrD[i34];
                if (obj instanceof Field) {
                    fieldN1 = (Field) obj;
                } else {
                    fieldN1 = n0(cls, (String) obj);
                    objArrD[i34] = fieldN1;
                }
                i26 = iCharAt;
                i27 = iCharAt2;
                int iObjectFieldOffset5 = (int) unsafe.objectFieldOffset(fieldN1);
                i35 = i34 + 1;
                obj2 = objArrD[i35];
                if (obj2 instanceof Field) {
                    fieldN2 = (Field) obj2;
                } else {
                    fieldN2 = n0(cls, (String) obj2);
                    objArrD[i35] = fieldN2;
                }
                int iObjectFieldOffset6 = (int) unsafe.objectFieldOffset(fieldN2);
                strE = strE;
                z11 = z11;
                objArr = objArr;
                i29 = i88;
                iObjectFieldOffset2 = iObjectFieldOffset6;
                iObjectFieldOffset = iObjectFieldOffset5;
                i31 = 0;
            } else {
                i26 = iCharAt;
                i27 = iCharAt2;
                int i89 = i12 + 1;
                Field fieldN3 = n0(cls, (String) objArrD[i12]);
                if (i81 == 9 || i81 == 17) {
                    objArr[((i72 / 3) * 2) + 1] = fieldN3.getType();
                } else {
                    if (i81 == 27 || i81 == 49) {
                        i32 = i12 + 2;
                        objArr[((i72 / 3) * 2) + 1] = objArrD[i89];
                    } else if (i81 == 12 || i81 == 30 || i81 == 44) {
                        if (!z11) {
                            i32 = i12 + 2;
                            objArr[((i72 / 3) * 2) + 1] = objArrD[i89];
                        }
                    } else if (i81 == 50) {
                        int i90 = i69 + 1;
                        iArr[i69] = i72;
                        int i91 = (i72 / 3) * 2;
                        int i92 = i12 + 2;
                        objArr[i91] = objArrD[i89];
                        if ((iCharAt11 & 2048) != 0) {
                            i89 = i12 + 3;
                            objArr[i91 + 1] = objArrD[i92];
                            i69 = i90;
                        } else {
                            i69 = i90;
                            i28 = i92;
                        }
                        iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldN3);
                        i12 = i28;
                        if ((iCharAt11 & 4096) == 4096 || i81 > 17) {
                            iObjectFieldOffset2 = 1048575;
                            i29 = i25;
                            i31 = 0;
                        } else {
                            int i93 = i25 + 1;
                            int iCharAt13 = strE.charAt(i25);
                            if (iCharAt13 >= 55296) {
                                int i94 = iCharAt13 & 8191;
                                int i95 = 13;
                                while (true) {
                                    i29 = i93 + 1;
                                    cCharAt9 = strE.charAt(i93);
                                    if (cCharAt9 < 55296) {
                                        break;
                                    }
                                    i94 |= (cCharAt9 & 8191) << i95;
                                    i95 += 13;
                                    i93 = i29;
                                }
                                iCharAt13 = i94 | (cCharAt9 << i95);
                            } else {
                                i29 = i93;
                            }
                            int i96 = (i13 * 2) + (iCharAt13 / 32);
                            Object obj3 = objArrD[i96];
                            if (obj3 instanceof Field) {
                                fieldN0 = (Field) obj3;
                            } else {
                                fieldN0 = n0(cls, (String) obj3);
                                objArrD[i96] = fieldN0;
                            }
                            i31 = iCharAt13 % 32;
                            iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldN0);
                        }
                        if (i81 >= 18 && i81 <= 49) {
                            iArr[i70] = iObjectFieldOffset;
                            i70++;
                        }
                    }
                    i28 = i32;
                    iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldN3);
                    i12 = i28;
                    if ((iCharAt11 & 4096) == 4096) {
                        iObjectFieldOffset2 = 1048575;
                        i29 = i25;
                        i31 = 0;
                    } else {
                        iObjectFieldOffset2 = 1048575;
                        i29 = i25;
                        i31 = 0;
                    }
                    if (i81 >= 18) {
                        iArr[i70] = iObjectFieldOffset;
                        i70++;
                    }
                }
                i28 = i89;
                iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldN3);
                i12 = i28;
                if ((iCharAt11 & 4096) == 4096) {
                    iObjectFieldOffset2 = 1048575;
                    i29 = i25;
                    i31 = 0;
                } else {
                    iObjectFieldOffset2 = 1048575;
                    i29 = i25;
                    i31 = 0;
                }
                if (i81 >= 18) {
                    iArr[i70] = iObjectFieldOffset;
                    i70++;
                }
            }
            int i97 = i72 + 1;
            iArr2[i72] = iCharAt10;
            int i98 = i72 + 2;
            iArr2[i97] = ((iCharAt11 & 256) != 0 ? ASTNode.DEOP : 0) | ((iCharAt11 & 512) != 0 ? ASTNode.DISCARD : 0) | (i81 << 20) | iObjectFieldOffset;
            i72 += 3;
            iArr2[i98] = (i31 << 20) | iObjectFieldOffset2;
            z11 = z11;
            objArr = objArr;
            iCharAt = i26;
            iCharAt5 = i82;
            i41 = i29;
            length = i24;
            strE = strE;
            i71 = i83;
            iCharAt2 = i27;
            c11 = 55296;
        }
        return new q0<>(iArr2, objArr, iCharAt, iCharAt2, z0Var.b(), z11, false, iArr, iCharAt5, i68, s0Var, e0Var, h1Var, qVar, i0Var);
    }

    public static long V(int i11) {
        return i11 & 1048575;
    }

    public static <T> boolean W(T t11, long j11) {
        return ((Boolean) l1.G(t11, j11)).booleanValue();
    }

    public static <T> double X(T t11, long j11) {
        return ((Double) l1.G(t11, j11)).doubleValue();
    }

    public static <T> float Y(T t11, long j11) {
        return ((Float) l1.G(t11, j11)).floatValue();
    }

    public static <T> int Z(T t11, long j11) {
        return ((Integer) l1.G(t11, j11)).intValue();
    }

    public static <T> long a0(T t11, long j11) {
        return ((Long) l1.G(t11, j11)).longValue();
    }

    public static <T> boolean l(T t11, long j11) {
        return l1.t(t11, j11);
    }

    public static Field n0(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            throw new RuntimeException("Field " + str + " for " + cls.getName() + " not found. Known fields are " + Arrays.toString(declaredFields));
        }
    }

    public static <T> double o(T t11, long j11) {
        return l1.A(t11, j11);
    }

    public static int r0(int i11) {
        return (i11 & 267386880) >>> 20;
    }

    public static <T> float s(T t11, long j11) {
        return l1.B(t11, j11);
    }

    public static i1 w(Object obj) {
        GeneratedMessageLite generatedMessageLite = (GeneratedMessageLite) obj;
        i1 i1Var = generatedMessageLite.unknownFields;
        if (i1Var != i1.c()) {
            return i1Var;
        }
        i1 i1VarJ = i1.j();
        generatedMessageLite.unknownFields = i1VarJ;
        return i1VarJ;
    }

    public final boolean C(T t11, int i11) {
        int iI0 = i0(i11);
        long j11 = 1048575 & iI0;
        if (j11 != 1048575) {
            return (l1.C(t11, j11) & (1 << (iI0 >>> 20))) != 0;
        }
        int iS0 = s0(i11);
        long jV = V(iS0);
        switch (r0(iS0)) {
            case 0:
                return l1.A(t11, jV) != 0.0d;
            case 1:
                return l1.B(t11, jV) != 0.0f;
            case 2:
                return l1.E(t11, jV) != 0;
            case 3:
                return l1.E(t11, jV) != 0;
            case 4:
                return l1.C(t11, jV) != 0;
            case 5:
                return l1.E(t11, jV) != 0;
            case 6:
                return l1.C(t11, jV) != 0;
            case 7:
                return l1.t(t11, jV);
            case 8:
                Object objG = l1.G(t11, jV);
                if (objG instanceof String) {
                    return !((String) objG).isEmpty();
                }
                if (objG instanceof ByteString) {
                    return !ByteString.EMPTY.equals(objG);
                }
                throw new IllegalArgumentException();
            case 9:
                return l1.G(t11, jV) != null;
            case 10:
                return !ByteString.EMPTY.equals(l1.G(t11, jV));
            case 11:
                return l1.C(t11, jV) != 0;
            case 12:
                return l1.C(t11, jV) != 0;
            case 13:
                return l1.C(t11, jV) != 0;
            case 14:
                return l1.E(t11, jV) != 0;
            case 15:
                return l1.C(t11, jV) != 0;
            case 16:
                return l1.E(t11, jV) != 0;
            case 17:
                return l1.G(t11, jV) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    public final boolean D(T t11, int i11, int i12, int i13, int i14) {
        if (i12 == 1048575) {
            return C(t11, i11);
        }
        return (i13 & i14) != 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <N> boolean F(Object obj, int i11, int i12) {
        List list = (List) l1.G(obj, V(i11));
        if (list.isEmpty()) {
            return true;
        }
        b1 b1VarV = v(i12);
        for (int i13 = 0; i13 < list.size(); i13++) {
            if (!b1VarV.d(list.get(i13))) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v8, types: [com.google.protobuf.b1] */
    public final boolean G(T t11, int i11, int i12) {
        Map<?, ?> mapE = this.f41408q.e(l1.G(t11, V(i11)));
        if (mapE.isEmpty()) {
            return true;
        }
        if (this.f41408q.b(u(i12)).f41286c.getJavaType() != WireFormat.JavaType.MESSAGE) {
            return true;
        }
        ?? D = 0;
        for (Object obj : mapE.values()) {
            if (D == 0) {
                D = D;
                D = x0.a().d(obj.getClass());
            }
            D = D;
            if (!D.d(obj)) {
                return false;
            }
        }
        return true;
    }

    public final boolean H(T t11, T t12, int i11) {
        long jI0 = i0(i11) & 1048575;
        return l1.C(t11, jI0) == l1.C(t12, jI0);
    }

    public final boolean I(T t11, int i11, int i12) {
        return l1.C(t11, (long) (i0(i12) & 1048575)) == i11;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <UT, UB, ET extends u.b<ET>> void M(h1<UT, UB> h1Var, q<ET> qVar, T t11, a1 a1Var, p pVar) throws IOException {
        Object objQ = null;
        Object objD = null;
        while (true) {
            try {
                int iF = a1Var.F();
                int iG0 = g0(iF);
                if (iG0 >= 0) {
                    int iS0 = s0(iG0);
                    try {
                        switch (r0(iS0)) {
                            case 0:
                                l1.S(t11, V(iS0), a1Var.readDouble());
                                o0(t11, iG0);
                                break;
                            case 1:
                                l1.T(t11, V(iS0), a1Var.readFloat());
                                o0(t11, iG0);
                                break;
                            case 2:
                                l1.V(t11, V(iS0), a1Var.N());
                                o0(t11, iG0);
                                break;
                            case 3:
                                l1.V(t11, V(iS0), a1Var.v());
                                o0(t11, iG0);
                                break;
                            case 4:
                                l1.U(t11, V(iS0), a1Var.s());
                                o0(t11, iG0);
                                break;
                            case 5:
                                l1.V(t11, V(iS0), a1Var.a());
                                o0(t11, iG0);
                                break;
                            case 6:
                                l1.U(t11, V(iS0), a1Var.y());
                                o0(t11, iG0);
                                break;
                            case 7:
                                l1.M(t11, V(iS0), a1Var.e());
                                o0(t11, iG0);
                                break;
                            case 8:
                                l0(t11, iS0, a1Var);
                                o0(t11, iG0);
                                break;
                            case 9:
                                if (C(t11, iG0)) {
                                    l1.W(t11, V(iS0), y.h(l1.G(t11, V(iS0)), a1Var.H(v(iG0), pVar)));
                                } else {
                                    l1.W(t11, V(iS0), a1Var.H(v(iG0), pVar));
                                    o0(t11, iG0);
                                }
                                break;
                            case 10:
                                l1.W(t11, V(iS0), a1Var.r());
                                o0(t11, iG0);
                                break;
                            case 11:
                                l1.U(t11, V(iS0), a1Var.i());
                                o0(t11, iG0);
                                break;
                            case 12:
                                int iL = a1Var.l();
                                y.e eVarT = t(iG0);
                                if (eVarT == null || eVarT.a(iL)) {
                                    l1.U(t11, V(iS0), iL);
                                    o0(t11, iG0);
                                } else {
                                    objQ = d1.L(iF, iL, objQ, h1Var);
                                }
                                break;
                            case 13:
                                l1.U(t11, V(iS0), a1Var.K());
                                o0(t11, iG0);
                                break;
                            case 14:
                                l1.V(t11, V(iS0), a1Var.g());
                                o0(t11, iG0);
                                break;
                            case 15:
                                l1.U(t11, V(iS0), a1Var.m());
                                o0(t11, iG0);
                                break;
                            case 16:
                                l1.V(t11, V(iS0), a1Var.D());
                                o0(t11, iG0);
                                break;
                            case 17:
                                if (C(t11, iG0)) {
                                    l1.W(t11, V(iS0), y.h(l1.G(t11, V(iS0)), a1Var.z(v(iG0), pVar)));
                                } else {
                                    l1.W(t11, V(iS0), a1Var.z(v(iG0), pVar));
                                    o0(t11, iG0);
                                }
                                break;
                            case 18:
                                a1Var.M(this.f41405n.e(t11, V(iS0)));
                                break;
                            case 19:
                                a1Var.I(this.f41405n.e(t11, V(iS0)));
                                break;
                            case 20:
                                a1Var.j(this.f41405n.e(t11, V(iS0)));
                                break;
                            case 21:
                                a1Var.h(this.f41405n.e(t11, V(iS0)));
                                break;
                            case 22:
                                a1Var.B(this.f41405n.e(t11, V(iS0)));
                                break;
                            case 23:
                                a1Var.t(this.f41405n.e(t11, V(iS0)));
                                break;
                            case 24:
                                a1Var.C(this.f41405n.e(t11, V(iS0)));
                                break;
                            case 25:
                                a1Var.n(this.f41405n.e(t11, V(iS0)));
                                break;
                            case 26:
                                m0(t11, iS0, a1Var);
                                break;
                            case 27:
                                k0(t11, iS0, a1Var, v(iG0), pVar);
                                break;
                            case 28:
                                a1Var.L(this.f41405n.e(t11, V(iS0)));
                                break;
                            case VungleException.INCORRECT_DEFAULT_API_USAGE /* 29 */:
                                a1Var.w(this.f41405n.e(t11, V(iS0)));
                                break;
                            case 30:
                                List<Integer> listE = this.f41405n.e(t11, V(iS0));
                                a1Var.k(listE);
                                objQ = d1.A(iF, listE, t(iG0), objQ, h1Var);
                                break;
                            case VungleException.WEB_CRASH /* 31 */:
                                a1Var.b(this.f41405n.e(t11, V(iS0)));
                                break;
                            case 32:
                                a1Var.A(this.f41405n.e(t11, V(iS0)));
                                break;
                            case 33:
                                a1Var.u(this.f41405n.e(t11, V(iS0)));
                                break;
                            case 34:
                                a1Var.c(this.f41405n.e(t11, V(iS0)));
                                break;
                            case 35:
                                a1Var.M(this.f41405n.e(t11, V(iS0)));
                                break;
                            case 36:
                                a1Var.I(this.f41405n.e(t11, V(iS0)));
                                break;
                            case 37:
                                a1Var.j(this.f41405n.e(t11, V(iS0)));
                                break;
                            case 38:
                                a1Var.h(this.f41405n.e(t11, V(iS0)));
                                break;
                            case 39:
                                a1Var.B(this.f41405n.e(t11, V(iS0)));
                                break;
                            case 40:
                                a1Var.t(this.f41405n.e(t11, V(iS0)));
                                break;
                            case 41:
                                a1Var.C(this.f41405n.e(t11, V(iS0)));
                                break;
                            case MotionEventCompat.AXIS_GENERIC_11 /* 42 */:
                                a1Var.n(this.f41405n.e(t11, V(iS0)));
                                break;
                            case MotionEventCompat.AXIS_GENERIC_12 /* 43 */:
                                a1Var.w(this.f41405n.e(t11, V(iS0)));
                                break;
                            case MotionEventCompat.AXIS_GENERIC_13 /* 44 */:
                                List<Integer> listE2 = this.f41405n.e(t11, V(iS0));
                                a1Var.k(listE2);
                                objQ = d1.A(iF, listE2, t(iG0), objQ, h1Var);
                                break;
                            case MotionEventCompat.AXIS_GENERIC_14 /* 45 */:
                                a1Var.b(this.f41405n.e(t11, V(iS0)));
                                break;
                            case MotionEventCompat.AXIS_GENERIC_15 /* 46 */:
                                a1Var.A(this.f41405n.e(t11, V(iS0)));
                                break;
                            case MotionEventCompat.AXIS_GENERIC_16 /* 47 */:
                                a1Var.u(this.f41405n.e(t11, V(iS0)));
                                break;
                            case 48:
                                a1Var.c(this.f41405n.e(t11, V(iS0)));
                                break;
                            case 49:
                                j0(t11, V(iS0), a1Var, v(iG0), pVar);
                                break;
                            case 50:
                                N(t11, iG0, u(iG0), pVar, a1Var);
                                break;
                            case 51:
                                l1.W(t11, V(iS0), Double.valueOf(a1Var.readDouble()));
                                p0(t11, iF, iG0);
                                break;
                            case 52:
                                l1.W(t11, V(iS0), Float.valueOf(a1Var.readFloat()));
                                p0(t11, iF, iG0);
                                break;
                            case 53:
                                l1.W(t11, V(iS0), Long.valueOf(a1Var.N()));
                                p0(t11, iF, iG0);
                                break;
                            case 54:
                                l1.W(t11, V(iS0), Long.valueOf(a1Var.v()));
                                p0(t11, iF, iG0);
                                break;
                            case 55:
                                l1.W(t11, V(iS0), Integer.valueOf(a1Var.s()));
                                p0(t11, iF, iG0);
                                break;
                            case 56:
                                l1.W(t11, V(iS0), Long.valueOf(a1Var.a()));
                                p0(t11, iF, iG0);
                                break;
                            case DownloadBean.STATUS_COMPLETED_REMOVED /* 57 */:
                                l1.W(t11, V(iS0), Integer.valueOf(a1Var.y()));
                                p0(t11, iF, iG0);
                                break;
                            case 58:
                                l1.W(t11, V(iS0), Boolean.valueOf(a1Var.e()));
                                p0(t11, iF, iG0);
                                break;
                            case 59:
                                l0(t11, iS0, a1Var);
                                p0(t11, iF, iG0);
                                break;
                            case 60:
                                if (I(t11, iF, iG0)) {
                                    l1.W(t11, V(iS0), y.h(l1.G(t11, V(iS0)), a1Var.H(v(iG0), pVar)));
                                } else {
                                    l1.W(t11, V(iS0), a1Var.H(v(iG0), pVar));
                                    o0(t11, iG0);
                                }
                                p0(t11, iF, iG0);
                                break;
                            case 61:
                                l1.W(t11, V(iS0), a1Var.r());
                                p0(t11, iF, iG0);
                                break;
                            case 62:
                                l1.W(t11, V(iS0), Integer.valueOf(a1Var.i()));
                                p0(t11, iF, iG0);
                                break;
                            case 63:
                                int iL2 = a1Var.l();
                                y.e eVarT2 = t(iG0);
                                if (eVarT2 == null || eVarT2.a(iL2)) {
                                    l1.W(t11, V(iS0), Integer.valueOf(iL2));
                                    p0(t11, iF, iG0);
                                } else {
                                    objQ = d1.L(iF, iL2, objQ, h1Var);
                                }
                                break;
                            case 64:
                                l1.W(t11, V(iS0), Integer.valueOf(a1Var.K()));
                                p0(t11, iF, iG0);
                                break;
                            case RegisterRequest.U2F_V1_CHALLENGE_BYTE_LENGTH /* 65 */:
                                l1.W(t11, V(iS0), Long.valueOf(a1Var.g()));
                                p0(t11, iF, iG0);
                                break;
                            case 66:
                                l1.W(t11, V(iS0), Integer.valueOf(a1Var.m()));
                                p0(t11, iF, iG0);
                                break;
                            case MdtaMetadataEntry.TYPE_INDICATOR_INT32 /* 67 */:
                                l1.W(t11, V(iS0), Long.valueOf(a1Var.D()));
                                p0(t11, iF, iG0);
                                break;
                            case 68:
                                l1.W(t11, V(iS0), a1Var.z(v(iG0), pVar));
                                p0(t11, iF, iG0);
                                break;
                            default:
                                if (objQ == null) {
                                    objQ = h1Var.n();
                                }
                                if (!h1Var.m(objQ, a1Var)) {
                                    for (int i11 = this.f41402k; i11 < this.f41403l; i11++) {
                                        objQ = q(t11, this.f41401j[i11], objQ, h1Var);
                                    }
                                    if (objQ != null) {
                                        h1Var.o(t11, objQ);
                                        return;
                                    }
                                    return;
                                }
                                break;
                                break;
                        }
                    } catch (InvalidProtocolBufferException.InvalidWireTypeException unused) {
                        if (!h1Var.q(a1Var)) {
                            if (objQ == null) {
                                objQ = h1Var.f(t11);
                            }
                            if (!h1Var.m(objQ, a1Var)) {
                                for (int i12 = this.f41402k; i12 < this.f41403l; i12++) {
                                    objQ = q(t11, this.f41401j[i12], objQ, h1Var);
                                }
                                if (objQ != null) {
                                    h1Var.o(t11, objQ);
                                    return;
                                }
                                return;
                            }
                        } else if (!a1Var.J()) {
                            for (int i13 = this.f41402k; i13 < this.f41403l; i13++) {
                                objQ = q(t11, this.f41401j[i13], objQ, h1Var);
                            }
                            if (objQ != null) {
                                h1Var.o(t11, objQ);
                                return;
                            }
                            return;
                        }
                    }
                } else {
                    if (iF == Integer.MAX_VALUE) {
                        for (int i14 = this.f41402k; i14 < this.f41403l; i14++) {
                            objQ = q(t11, this.f41401j[i14], objQ, h1Var);
                        }
                        if (objQ != null) {
                            h1Var.o(t11, objQ);
                            return;
                        }
                        return;
                    }
                    Object objB = !this.f41397f ? null : qVar.b(pVar, this.f41396e, iF);
                    if (objB != null) {
                        if (objD == null) {
                            objD = qVar.d(t11);
                        }
                        objQ = qVar.g(a1Var, objB, pVar, objD, objQ, h1Var);
                    } else if (!h1Var.q(a1Var)) {
                        if (objQ == null) {
                            objQ = h1Var.f(t11);
                        }
                        if (h1Var.m(objQ, a1Var)) {
                        }
                    } else if (a1Var.J()) {
                    }
                }
            } catch (Throwable th2) {
                for (int i15 = this.f41402k; i15 < this.f41403l; i15++) {
                    objQ = q(t11, this.f41401j[i15], objQ, h1Var);
                }
                if (objQ != null) {
                    h1Var.o(t11, objQ);
                }
                throw th2;
            }
        }
        for (int i16 = this.f41402k; i16 < this.f41403l; i16++) {
            objQ = q(t11, this.f41401j[i16], objQ, h1Var);
        }
        if (objQ != null) {
            h1Var.o(t11, objQ);
        }
    }

    public final <K, V> void N(Object obj, int i11, Object obj2, p pVar, a1 a1Var) throws IOException {
        long jV = V(s0(i11));
        Object objG = l1.G(obj, jV);
        if (objG == null) {
            objG = this.f41408q.d(obj2);
            l1.W(obj, jV, objG);
        } else if (this.f41408q.h(objG)) {
            Object objD = this.f41408q.d(obj2);
            this.f41408q.a(objD, objG);
            l1.W(obj, jV, objD);
            objG = objD;
        }
        a1Var.p(this.f41408q.c(objG), this.f41408q.b(obj2), pVar);
    }

    public final void O(T t11, T t12, int i11) {
        long jV = V(s0(i11));
        if (C(t12, i11)) {
            Object objG = l1.G(t11, jV);
            Object objG2 = l1.G(t12, jV);
            if (objG != null && objG2 != null) {
                l1.W(t11, jV, y.h(objG, objG2));
                o0(t11, i11);
            } else if (objG2 != null) {
                l1.W(t11, jV, objG2);
                o0(t11, i11);
            }
        }
    }

    public final void P(T t11, T t12, int i11) {
        int iS0 = s0(i11);
        int iU = U(i11);
        long jV = V(iS0);
        if (I(t12, iU, i11)) {
            Object objG = I(t11, iU, i11) ? l1.G(t11, jV) : null;
            Object objG2 = l1.G(t12, jV);
            if (objG != null && objG2 != null) {
                l1.W(t11, jV, y.h(objG, objG2));
                p0(t11, iU, i11);
            } else if (objG2 != null) {
                l1.W(t11, jV, objG2);
                p0(t11, iU, i11);
            }
        }
    }

    public final void Q(T t11, T t12, int i11) {
        int iS0 = s0(i11);
        long jV = V(iS0);
        int iU = U(i11);
        switch (r0(iS0)) {
            case 0:
                if (C(t12, i11)) {
                    l1.S(t11, jV, l1.A(t12, jV));
                    o0(t11, i11);
                }
                break;
            case 1:
                if (C(t12, i11)) {
                    l1.T(t11, jV, l1.B(t12, jV));
                    o0(t11, i11);
                }
                break;
            case 2:
                if (C(t12, i11)) {
                    l1.V(t11, jV, l1.E(t12, jV));
                    o0(t11, i11);
                }
                break;
            case 3:
                if (C(t12, i11)) {
                    l1.V(t11, jV, l1.E(t12, jV));
                    o0(t11, i11);
                }
                break;
            case 4:
                if (C(t12, i11)) {
                    l1.U(t11, jV, l1.C(t12, jV));
                    o0(t11, i11);
                }
                break;
            case 5:
                if (C(t12, i11)) {
                    l1.V(t11, jV, l1.E(t12, jV));
                    o0(t11, i11);
                }
                break;
            case 6:
                if (C(t12, i11)) {
                    l1.U(t11, jV, l1.C(t12, jV));
                    o0(t11, i11);
                }
                break;
            case 7:
                if (C(t12, i11)) {
                    l1.M(t11, jV, l1.t(t12, jV));
                    o0(t11, i11);
                }
                break;
            case 8:
                if (C(t12, i11)) {
                    l1.W(t11, jV, l1.G(t12, jV));
                    o0(t11, i11);
                }
                break;
            case 9:
                O(t11, t12, i11);
                break;
            case 10:
                if (C(t12, i11)) {
                    l1.W(t11, jV, l1.G(t12, jV));
                    o0(t11, i11);
                }
                break;
            case 11:
                if (C(t12, i11)) {
                    l1.U(t11, jV, l1.C(t12, jV));
                    o0(t11, i11);
                }
                break;
            case 12:
                if (C(t12, i11)) {
                    l1.U(t11, jV, l1.C(t12, jV));
                    o0(t11, i11);
                }
                break;
            case 13:
                if (C(t12, i11)) {
                    l1.U(t11, jV, l1.C(t12, jV));
                    o0(t11, i11);
                }
                break;
            case 14:
                if (C(t12, i11)) {
                    l1.V(t11, jV, l1.E(t12, jV));
                    o0(t11, i11);
                }
                break;
            case 15:
                if (C(t12, i11)) {
                    l1.U(t11, jV, l1.C(t12, jV));
                    o0(t11, i11);
                }
                break;
            case 16:
                if (C(t12, i11)) {
                    l1.V(t11, jV, l1.E(t12, jV));
                    o0(t11, i11);
                }
                break;
            case 17:
                O(t11, t12, i11);
                break;
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case VungleException.INCORRECT_DEFAULT_API_USAGE /* 29 */:
            case 30:
            case VungleException.WEB_CRASH /* 31 */:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case MotionEventCompat.AXIS_GENERIC_11 /* 42 */:
            case MotionEventCompat.AXIS_GENERIC_12 /* 43 */:
            case MotionEventCompat.AXIS_GENERIC_13 /* 44 */:
            case MotionEventCompat.AXIS_GENERIC_14 /* 45 */:
            case MotionEventCompat.AXIS_GENERIC_15 /* 46 */:
            case MotionEventCompat.AXIS_GENERIC_16 /* 47 */:
            case 48:
            case 49:
                this.f41405n.d(t11, t12, jV);
                break;
            case 50:
                d1.F(this.f41408q, t11, t12, jV);
                break;
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
            case 56:
            case DownloadBean.STATUS_COMPLETED_REMOVED /* 57 */:
            case 58:
            case 59:
                if (I(t12, iU, i11)) {
                    l1.W(t11, jV, l1.G(t12, jV));
                    p0(t11, iU, i11);
                }
                break;
            case 60:
                P(t11, t12, i11);
                break;
            case 61:
            case 62:
            case 63:
            case 64:
            case RegisterRequest.U2F_V1_CHALLENGE_BYTE_LENGTH /* 65 */:
            case 66:
            case MdtaMetadataEntry.TYPE_INDICATOR_INT32 /* 67 */:
                if (I(t12, iU, i11)) {
                    l1.W(t11, jV, l1.G(t12, jV));
                    p0(t11, iU, i11);
                }
                break;
            case 68:
                P(t11, t12, i11);
                break;
        }
    }

    public final int U(int i11) {
        return this.f41392a[i11];
    }

    @Override // com.google.protobuf.b1
    public void a(T t11, T t12) {
        t12.getClass();
        for (int i11 = 0; i11 < this.f41392a.length; i11 += 3) {
            Q(t11, t12, i11);
        }
        d1.G(this.f41406o, t11, t12);
        if (this.f41397f) {
            d1.E(this.f41407p, t11, t12);
        }
    }

    @Override // com.google.protobuf.b1
    public void b(T t11, Writer writer) throws IOException {
        if (writer.y() == Writer.FieldOrder.DESCENDING) {
            v0(t11, writer);
        } else if (this.f41399h) {
            u0(t11, writer);
        } else {
            t0(t11, writer);
        }
    }

    public final <K, V> int b0(T t11, byte[] bArr, int i11, int i12, int i13, long j11, e.b bVar) throws IOException {
        Unsafe unsafe = f41391s;
        Object objU = u(i13);
        Object object = unsafe.getObject(t11, j11);
        if (this.f41408q.h(object)) {
            Object objD = this.f41408q.d(objU);
            this.f41408q.a(objD, object);
            unsafe.putObject(t11, j11, objD);
            object = objD;
        }
        return m(bArr, i11, i12, this.f41408q.b(objU), this.f41408q.c(object), bVar);
    }

    @Override // com.google.protobuf.b1
    public void c(T t11) {
        int i11;
        int i12 = this.f41402k;
        while (true) {
            i11 = this.f41403l;
            if (i12 >= i11) {
                break;
            }
            long jV = V(s0(this.f41401j[i12]));
            Object objG = l1.G(t11, jV);
            if (objG != null) {
                l1.W(t11, jV, this.f41408q.f(objG));
            }
            i12++;
        }
        int length = this.f41401j.length;
        while (i11 < length) {
            this.f41405n.c(t11, this.f41401j[i11]);
            i11++;
        }
        this.f41406o.j(t11);
        if (this.f41397f) {
            this.f41407p.f(t11);
        }
    }

    public final int c0(T t11, byte[] bArr, int i11, int i12, int i13, int i14, int i15, int i16, int i17, long j11, int i18, e.b bVar) throws IOException {
        Unsafe unsafe = f41391s;
        long j12 = this.f41392a[i18 + 2] & 1048575;
        switch (i17) {
            case 51:
                if (i15 != 1) {
                    return i11;
                }
                unsafe.putObject(t11, j11, Double.valueOf(e.d(bArr, i11)));
                int i19 = i11 + 8;
                unsafe.putInt(t11, j12, i14);
                return i19;
            case 52:
                if (i15 != 5) {
                    return i11;
                }
                unsafe.putObject(t11, j11, Float.valueOf(e.l(bArr, i11)));
                int i21 = i11 + 4;
                unsafe.putInt(t11, j12, i14);
                return i21;
            case 53:
            case 54:
                if (i15 != 0) {
                    return i11;
                }
                int iL = e.L(bArr, i11, bVar);
                unsafe.putObject(t11, j11, Long.valueOf(bVar.f41228b));
                unsafe.putInt(t11, j12, i14);
                return iL;
            case 55:
            case 62:
                if (i15 != 0) {
                    return i11;
                }
                int I = e.I(bArr, i11, bVar);
                unsafe.putObject(t11, j11, Integer.valueOf(bVar.f41227a));
                unsafe.putInt(t11, j12, i14);
                return I;
            case 56:
            case RegisterRequest.U2F_V1_CHALLENGE_BYTE_LENGTH /* 65 */:
                if (i15 != 1) {
                    return i11;
                }
                unsafe.putObject(t11, j11, Long.valueOf(e.j(bArr, i11)));
                int i22 = i11 + 8;
                unsafe.putInt(t11, j12, i14);
                return i22;
            case DownloadBean.STATUS_COMPLETED_REMOVED /* 57 */:
            case 64:
                if (i15 != 5) {
                    return i11;
                }
                unsafe.putObject(t11, j11, Integer.valueOf(e.h(bArr, i11)));
                int i23 = i11 + 4;
                unsafe.putInt(t11, j12, i14);
                return i23;
            case 58:
                if (i15 != 0) {
                    return i11;
                }
                int iL2 = e.L(bArr, i11, bVar);
                unsafe.putObject(t11, j11, Boolean.valueOf(bVar.f41228b != 0));
                unsafe.putInt(t11, j12, i14);
                return iL2;
            case 59:
                if (i15 != 2) {
                    return i11;
                }
                int I2 = e.I(bArr, i11, bVar);
                int i24 = bVar.f41227a;
                if (i24 == 0) {
                    unsafe.putObject(t11, j11, "");
                } else {
                    if ((i16 & ASTNode.DISCARD) != 0 && !Utf8.t(bArr, I2, I2 + i24)) {
                        throw InvalidProtocolBufferException.invalidUtf8();
                    }
                    unsafe.putObject(t11, j11, new String(bArr, I2, i24, y.f41435a));
                    I2 += i24;
                }
                unsafe.putInt(t11, j12, i14);
                return I2;
            case 60:
                if (i15 != 2) {
                    return i11;
                }
                int iP = e.p(v(i18), bArr, i11, i12, bVar);
                Object object = unsafe.getInt(t11, j12) == i14 ? unsafe.getObject(t11, j11) : null;
                if (object == null) {
                    unsafe.putObject(t11, j11, bVar.f41229c);
                } else {
                    unsafe.putObject(t11, j11, y.h(object, bVar.f41229c));
                }
                unsafe.putInt(t11, j12, i14);
                return iP;
            case 61:
                if (i15 != 2) {
                    return i11;
                }
                int iB = e.b(bArr, i11, bVar);
                unsafe.putObject(t11, j11, bVar.f41229c);
                unsafe.putInt(t11, j12, i14);
                return iB;
            case 63:
                if (i15 != 0) {
                    return i11;
                }
                int I3 = e.I(bArr, i11, bVar);
                int i25 = bVar.f41227a;
                y.e eVarT = t(i18);
                if (eVarT == null || eVarT.a(i25)) {
                    unsafe.putObject(t11, j11, Integer.valueOf(i25));
                    unsafe.putInt(t11, j12, i14);
                } else {
                    w(t11).m(i13, Long.valueOf(i25));
                }
                return I3;
            case 66:
                if (i15 != 0) {
                    return i11;
                }
                int I4 = e.I(bArr, i11, bVar);
                unsafe.putObject(t11, j11, Integer.valueOf(j.b(bVar.f41227a)));
                unsafe.putInt(t11, j12, i14);
                return I4;
            case MdtaMetadataEntry.TYPE_INDICATOR_INT32 /* 67 */:
                if (i15 != 0) {
                    return i11;
                }
                int iL3 = e.L(bArr, i11, bVar);
                unsafe.putObject(t11, j11, Long.valueOf(j.c(bVar.f41228b)));
                unsafe.putInt(t11, j12, i14);
                return iL3;
            case 68:
                if (i15 != 3) {
                    return i11;
                }
                int iN = e.n(v(i18), bArr, i11, i12, (i13 & (-8)) | 4, bVar);
                Object object2 = unsafe.getInt(t11, j12) == i14 ? unsafe.getObject(t11, j11) : null;
                if (object2 == null) {
                    unsafe.putObject(t11, j11, bVar.f41229c);
                } else {
                    unsafe.putObject(t11, j11, y.h(object2, bVar.f41229c));
                }
                unsafe.putInt(t11, j12, i14);
                return iN;
            default:
                return i11;
        }
    }

    /* JADX WARN: Code duplicated, block: B:39:0x008b  */
    /* JADX WARN: Code duplicated, block: B:58:0x0091 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:63:0x00ac A[SYNTHETIC] */
    @Override // com.google.protobuf.b1
    public final boolean d(T t11) {
        int i11;
        int i12;
        int i13 = 1048575;
        int i14 = 0;
        int i15 = 0;
        while (i15 < this.f41402k) {
            int i16 = this.f41401j[i15];
            int iU = U(i16);
            int iS0 = s0(i16);
            int i17 = this.f41392a[i16 + 2];
            int i18 = i17 & 1048575;
            int i19 = 1 << (i17 >>> 20);
            if (i18 != i13) {
                if (i18 != 1048575) {
                    i14 = f41391s.getInt(t11, i18);
                }
                i12 = i14;
                i11 = i18;
            } else {
                i11 = i13;
                i12 = i14;
            }
            if (J(iS0) && !D(t11, i16, i11, i12, i19)) {
                return false;
            }
            int iR0 = r0(iS0);
            if (iR0 == 9 || iR0 == 17) {
                if (D(t11, i16, i11, i12, i19) && !E(t11, iS0, v(i16))) {
                    return false;
                }
            } else if (iR0 == 27) {
                if (!F(t11, iS0, i16)) {
                    return false;
                }
            } else if (iR0 == 60 || iR0 == 68) {
                if (I(t11, iU, i16) && !E(t11, iS0, v(i16))) {
                    return false;
                }
            } else if (iR0 != 49) {
                if (iR0 == 50 && !G(t11, iS0, i16)) {
                    return false;
                }
            } else if (!F(t11, iS0, i16)) {
                return false;
            }
            i15++;
            i13 = i11;
            i14 = i12;
        }
        return !this.f41397f || this.f41407p.c(t11).p();
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:24:0x008e. Please report as an issue. */
    public int d0(T t11, byte[] bArr, int i11, int i12, int i13, e.b bVar) throws IOException {
        Unsafe unsafe;
        q0<T> q0Var;
        int i14;
        T t12;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i21;
        int i22;
        int i23;
        int i24;
        int i25;
        T t13;
        T t14;
        int i26;
        T t15;
        int i27;
        int i28;
        q0<T> q0Var2 = this;
        T t16 = t11;
        byte[] bArr2 = bArr;
        i12 = i12;
        int i29 = i13;
        e.b bVar2 = bVar;
        Unsafe unsafe2 = f41391s;
        int iG = i11;
        int i31 = -1;
        int i32 = 0;
        int i33 = 0;
        int i34 = 0;
        int i35 = 1048575;
        while (true) {
            if (iG < i12) {
                int i36 = iG + 1;
                byte b11 = bArr2[iG];
                if (b11 < 0) {
                    int iH = e.H(b11, bArr2, i36, bVar2);
                    i15 = bVar2.f41227a;
                    i36 = iH;
                } else {
                    i15 = b11;
                }
                int i37 = i15 >>> 3;
                int i38 = i15 & 7;
                int iH0 = i37 > i31 ? q0Var2.h0(i37, i32 / 3) : q0Var2.g0(i37);
                if (iH0 == -1) {
                    i16 = i37;
                    i17 = i36;
                    i18 = i15;
                    i19 = i34;
                    i21 = i35;
                    unsafe = unsafe2;
                    i13 = i29;
                    i22 = 0;
                } else {
                    int i39 = q0Var2.f41392a[iH0 + 1];
                    int iR0 = r0(i39);
                    long jV = V(i39);
                    int i40 = i15;
                    if (iR0 <= 17) {
                        int i41 = q0Var2.f41392a[iH0 + 2];
                        int i42 = 1 << (i41 >>> 20);
                        int i43 = i41 & 1048575;
                        if (i43 != i35) {
                            if (i35 != 1048575) {
                                unsafe2.putInt(t16, i35, i34);
                            }
                            i23 = unsafe2.getInt(t16, i43);
                            i21 = i43;
                        } else {
                            i21 = i35;
                            i23 = i34;
                        }
                        switch (iR0) {
                            case 0:
                                t13 = t16;
                                i24 = iH0;
                                i16 = i37;
                                i25 = i40;
                                bArr2 = bArr;
                                if (i38 == 1) {
                                    l1.S(t13, jV, e.d(bArr2, i36));
                                    iG = i36 + 8;
                                    i34 = i23 | i42;
                                    t16 = t13;
                                    i32 = i24;
                                    i33 = i25;
                                    i31 = i16;
                                    i35 = i21;
                                    i29 = i13;
                                } else {
                                    i13 = i13;
                                    i17 = i36;
                                    i19 = i23;
                                    i22 = i24;
                                    unsafe = unsafe2;
                                    i18 = i25;
                                }
                                break;
                            case 1:
                                t13 = t16;
                                i24 = iH0;
                                i16 = i37;
                                i25 = i40;
                                bArr2 = bArr;
                                if (i38 == 5) {
                                    l1.T(t13, jV, e.l(bArr2, i36));
                                    iG = i36 + 4;
                                    i34 = i23 | i42;
                                    t16 = t13;
                                    i32 = i24;
                                    i33 = i25;
                                    i31 = i16;
                                    i35 = i21;
                                    i29 = i13;
                                } else {
                                    i13 = i13;
                                    i17 = i36;
                                    i19 = i23;
                                    i22 = i24;
                                    unsafe = unsafe2;
                                    i18 = i25;
                                }
                                break;
                            case 2:
                            case 3:
                                T t17 = t16;
                                i24 = iH0;
                                i16 = i37;
                                i25 = i40;
                                bArr2 = bArr;
                                if (i38 == 0) {
                                    int iL = e.L(bArr2, i36, bVar2);
                                    t14 = t17;
                                    unsafe2.putLong(t11, jV, bVar2.f41228b);
                                    i34 = i23 | i42;
                                    i32 = i24;
                                    iG = iL;
                                    i33 = i25;
                                    t16 = t14;
                                    i31 = i16;
                                    i35 = i21;
                                    i12 = i12;
                                    i29 = i13;
                                } else {
                                    i13 = i13;
                                    i17 = i36;
                                    i19 = i23;
                                    i22 = i24;
                                    unsafe = unsafe2;
                                    i18 = i25;
                                }
                                break;
                            case 4:
                            case 11:
                                t13 = t16;
                                i24 = iH0;
                                i16 = i37;
                                i25 = i40;
                                bArr2 = bArr;
                                if (i38 == 0) {
                                    iG = e.I(bArr2, i36, bVar2);
                                    unsafe2.putInt(t13, jV, bVar2.f41227a);
                                    i34 = i23 | i42;
                                    t16 = t13;
                                    i32 = i24;
                                    i33 = i25;
                                    i31 = i16;
                                    i35 = i21;
                                    i29 = i13;
                                } else {
                                    i13 = i13;
                                    i17 = i36;
                                    i19 = i23;
                                    i22 = i24;
                                    unsafe = unsafe2;
                                    i18 = i25;
                                }
                                break;
                            case 5:
                            case 14:
                                T t18 = t16;
                                i24 = iH0;
                                i16 = i37;
                                i25 = i40;
                                bArr2 = bArr;
                                if (i38 == 1) {
                                    t14 = t18;
                                    unsafe2.putLong(t11, jV, e.j(bArr2, i36));
                                    iG = i36 + 8;
                                    i34 = i23 | i42;
                                    i32 = i24;
                                    i33 = i25;
                                    t16 = t14;
                                    i31 = i16;
                                    i35 = i21;
                                    i12 = i12;
                                    i29 = i13;
                                } else {
                                    i13 = i13;
                                    i17 = i36;
                                    i19 = i23;
                                    i22 = i24;
                                    unsafe = unsafe2;
                                    i18 = i25;
                                }
                                break;
                            case 6:
                            case 13:
                                i26 = i12;
                                t15 = t16;
                                i24 = iH0;
                                i16 = i37;
                                i25 = i40;
                                bArr2 = bArr;
                                if (i38 == 5) {
                                    unsafe2.putInt(t15, jV, e.h(bArr2, i36));
                                    iG = i36 + 4;
                                    int i44 = i23 | i42;
                                    t16 = t15;
                                    i12 = i26;
                                    i32 = i24;
                                    i33 = i25;
                                    i35 = i21;
                                    i29 = i13;
                                    i34 = i44;
                                    i31 = i16;
                                } else {
                                    i13 = i13;
                                    i17 = i36;
                                    i19 = i23;
                                    i22 = i24;
                                    unsafe = unsafe2;
                                    i18 = i25;
                                }
                                break;
                            case 7:
                                i26 = i12;
                                t15 = t16;
                                i24 = iH0;
                                i16 = i37;
                                i25 = i40;
                                bArr2 = bArr;
                                if (i38 == 0) {
                                    iG = e.L(bArr2, i36, bVar2);
                                    l1.M(t15, jV, bVar2.f41228b != 0);
                                    int i45 = i23 | i42;
                                    t16 = t15;
                                    i12 = i26;
                                    i32 = i24;
                                    i33 = i25;
                                    i35 = i21;
                                    i29 = i13;
                                    i34 = i45;
                                    i31 = i16;
                                } else {
                                    i13 = i13;
                                    i17 = i36;
                                    i19 = i23;
                                    i22 = i24;
                                    unsafe = unsafe2;
                                    i18 = i25;
                                }
                                break;
                            case 8:
                                i26 = i12;
                                t15 = t16;
                                i24 = iH0;
                                i16 = i37;
                                i25 = i40;
                                bArr2 = bArr;
                                if (i38 == 2) {
                                    iG = (i39 & ASTNode.DISCARD) == 0 ? e.C(bArr2, i36, bVar2) : e.F(bArr2, i36, bVar2);
                                    unsafe2.putObject(t15, jV, bVar2.f41229c);
                                    int i46 = i23 | i42;
                                    t16 = t15;
                                    i12 = i26;
                                    i32 = i24;
                                    i33 = i25;
                                    i35 = i21;
                                    i29 = i13;
                                    i34 = i46;
                                    i31 = i16;
                                } else {
                                    i13 = i13;
                                    i17 = i36;
                                    i19 = i23;
                                    i22 = i24;
                                    unsafe = unsafe2;
                                    i18 = i25;
                                }
                                break;
                            case 9:
                                t15 = t16;
                                i24 = iH0;
                                i16 = i37;
                                i25 = i40;
                                bArr2 = bArr;
                                if (i38 == 2) {
                                    i26 = i12;
                                    iG = e.p(q0Var2.v(i24), bArr2, i36, i26, bVar2);
                                    if ((i23 & i42) == 0) {
                                        unsafe2.putObject(t15, jV, bVar2.f41229c);
                                    } else {
                                        unsafe2.putObject(t15, jV, y.h(unsafe2.getObject(t15, jV), bVar2.f41229c));
                                    }
                                    int i47 = i23 | i42;
                                    t16 = t15;
                                    i12 = i26;
                                    i32 = i24;
                                    i33 = i25;
                                    i35 = i21;
                                    i29 = i13;
                                    i34 = i47;
                                    i31 = i16;
                                } else {
                                    i13 = i13;
                                    i17 = i36;
                                    i19 = i23;
                                    i22 = i24;
                                    unsafe = unsafe2;
                                    i18 = i25;
                                }
                                break;
                            case 10:
                                t13 = t16;
                                i24 = iH0;
                                i16 = i37;
                                i25 = i40;
                                bArr2 = bArr;
                                if (i38 == 2) {
                                    iG = e.b(bArr2, i36, bVar2);
                                    unsafe2.putObject(t13, jV, bVar2.f41229c);
                                    i34 = i23 | i42;
                                    t16 = t13;
                                    i32 = i24;
                                    i33 = i25;
                                    i31 = i16;
                                    i35 = i21;
                                    i29 = i13;
                                } else {
                                    i13 = i13;
                                    i17 = i36;
                                    i19 = i23;
                                    i22 = i24;
                                    unsafe = unsafe2;
                                    i18 = i25;
                                }
                                break;
                            case 12:
                                t13 = t16;
                                i24 = iH0;
                                i16 = i37;
                                i25 = i40;
                                bArr2 = bArr;
                                if (i38 == 0) {
                                    iG = e.I(bArr2, i36, bVar2);
                                    int i48 = bVar2.f41227a;
                                    y.e eVarT = q0Var2.t(i24);
                                    if (eVarT == null || eVarT.a(i48)) {
                                        unsafe2.putInt(t13, jV, i48);
                                        i34 = i23 | i42;
                                        t16 = t13;
                                    } else {
                                        w(t11).m(i25, Long.valueOf(i48));
                                        t16 = t13;
                                        i34 = i23;
                                    }
                                    i32 = i24;
                                    i33 = i25;
                                    i31 = i16;
                                    i35 = i21;
                                    i29 = i13;
                                } else {
                                    i13 = i13;
                                    i17 = i36;
                                    i19 = i23;
                                    i22 = i24;
                                    unsafe = unsafe2;
                                    i18 = i25;
                                }
                                break;
                            case 15:
                                i24 = iH0;
                                i25 = i40;
                                bArr2 = bArr;
                                i16 = i37;
                                if (i38 == 0) {
                                    iG = e.I(bArr2, i36, bVar2);
                                    t13 = t11;
                                    unsafe2.putInt(t13, jV, j.b(bVar2.f41227a));
                                    i34 = i23 | i42;
                                    t16 = t13;
                                    i32 = i24;
                                    i33 = i25;
                                    i31 = i16;
                                    i35 = i21;
                                    i29 = i13;
                                } else {
                                    i13 = i13;
                                    i17 = i36;
                                    i19 = i23;
                                    i22 = i24;
                                    unsafe = unsafe2;
                                    i18 = i25;
                                }
                                break;
                            case 16:
                                i24 = iH0;
                                i16 = i37;
                                if (i38 == 0) {
                                    bArr2 = bArr;
                                    int iL2 = e.L(bArr2, i36, bVar2);
                                    i25 = i40;
                                    unsafe2.putLong(t11, jV, j.c(bVar2.f41228b));
                                    i34 = i23 | i42;
                                    t16 = t11;
                                    i12 = i12;
                                    i32 = i24;
                                    iG = iL2;
                                    i33 = i25;
                                    i31 = i16;
                                    i35 = i21;
                                    i29 = i13;
                                } else {
                                    i25 = i40;
                                    i13 = i13;
                                    i17 = i36;
                                    i19 = i23;
                                    i22 = i24;
                                    unsafe = unsafe2;
                                    i18 = i25;
                                }
                                break;
                            case 17:
                                if (i38 == 3) {
                                    iG = e.n(q0Var2.v(iH0), bArr, i36, i12, (i37 << 3) | 4, bVar);
                                    if ((i23 & i42) == 0) {
                                        unsafe2.putObject(t16, jV, bVar2.f41229c);
                                    } else {
                                        unsafe2.putObject(t16, jV, y.h(unsafe2.getObject(t16, jV), bVar2.f41229c));
                                    }
                                    i34 = i23 | i42;
                                    bArr2 = bArr;
                                    i12 = i12;
                                    i29 = i13;
                                    i32 = iH0;
                                    i33 = i40;
                                    i31 = i37;
                                    i35 = i21;
                                } else {
                                    i24 = iH0;
                                    i16 = i37;
                                    i25 = i40;
                                    i13 = i13;
                                    i17 = i36;
                                    i19 = i23;
                                    i22 = i24;
                                    unsafe = unsafe2;
                                    i18 = i25;
                                }
                                break;
                            default:
                                i24 = iH0;
                                i25 = i40;
                                i16 = i37;
                                i13 = i13;
                                i17 = i36;
                                i19 = i23;
                                i22 = i24;
                                unsafe = unsafe2;
                                i18 = i25;
                                break;
                        }
                    } else {
                        i16 = i37;
                        T t19 = t16;
                        bArr2 = bArr;
                        if (iR0 != 27) {
                            i22 = iH0;
                            i19 = i34;
                            i21 = i35;
                            if (iR0 <= 49) {
                                int i49 = i36;
                                unsafe = unsafe2;
                                iG = f0(t11, bArr, i36, i12, i40, i16, i38, i22, i39, iR0, jV, bVar);
                                if (iG != i49) {
                                    i28 = i40;
                                    q0Var2 = this;
                                    t16 = t11;
                                    bArr2 = bArr;
                                    i12 = i12;
                                    i29 = i13;
                                    bVar2 = bVar;
                                    i31 = i16;
                                    i33 = i28;
                                    i32 = i22;
                                    i34 = i19;
                                    i35 = i21;
                                    unsafe2 = unsafe;
                                } else {
                                    i28 = i40;
                                    i17 = iG;
                                    i18 = i28;
                                }
                            } else {
                                i27 = i36;
                                unsafe = unsafe2;
                                if (iR0 != 50) {
                                    iG = c0(t11, bArr, i27, i12, i28, i16, i38, i39, iR0, jV, i22, bVar);
                                    if (iG != i27) {
                                        i28 = i40;
                                        q0Var2 = this;
                                        t16 = t11;
                                        bArr2 = bArr;
                                        i12 = i12;
                                        i29 = i13;
                                        bVar2 = bVar;
                                        i31 = i16;
                                        i33 = i28;
                                        i32 = i22;
                                        i34 = i19;
                                        i35 = i21;
                                        unsafe2 = unsafe;
                                    } else {
                                        i28 = i40;
                                        i17 = iG;
                                        i18 = i28;
                                    }
                                } else if (i38 == 2) {
                                    iG = b0(t11, bArr, i27, i12, i22, jV, bVar);
                                    if (iG != i27) {
                                        i28 = i40;
                                        q0Var2 = this;
                                        t16 = t11;
                                        bArr2 = bArr;
                                        i12 = i12;
                                        i29 = i13;
                                        bVar2 = bVar;
                                        i31 = i16;
                                        i33 = i28;
                                        i32 = i22;
                                        i34 = i19;
                                        i35 = i21;
                                        unsafe2 = unsafe;
                                    } else {
                                        i28 = i40;
                                        i17 = iG;
                                        i18 = i28;
                                    }
                                } else {
                                    i28 = i40;
                                }
                            }
                        } else if (i38 == 2) {
                            y.j jVarC2 = (y.j) unsafe2.getObject(t19, jV);
                            if (!jVarC2.m()) {
                                int size = jVarC2.size();
                                jVarC2 = jVarC2.c2(size == 0 ? 10 : size * 2);
                                unsafe2.putObject(t19, jV, jVarC2);
                            }
                            i21 = i35;
                            iG = e.q(q0Var2.v(iH0), i40, bArr, i36, i12, jVarC2, bVar);
                            t16 = t11;
                            i12 = i12;
                            i33 = i40;
                            i31 = i16;
                            i32 = iH0;
                            i34 = i34;
                            i35 = i21;
                            i29 = i13;
                        } else {
                            i22 = iH0;
                            i19 = i34;
                            i21 = i35;
                            i27 = i36;
                            unsafe = unsafe2;
                            i28 = i40;
                        }
                        i17 = i27;
                        i18 = i28;
                    }
                }
                if (i18 != i13 || i13 == 0) {
                    iG = (!this.f41397f || bVar.f41230d == p.b()) ? e.G(i18, bArr, i17, i12, w(t11), bVar) : e.g(i18, bArr, i17, i12, t11, this.f41396e, this.f41406o, bVar);
                    t16 = t11;
                    bArr2 = bArr;
                    i12 = i12;
                    i33 = i18;
                    q0Var2 = this;
                    bVar2 = bVar;
                    i31 = i16;
                    i32 = i22;
                    i34 = i19;
                    i35 = i21;
                    unsafe2 = unsafe;
                    i29 = i13;
                } else {
                    i14 = 1048575;
                    q0Var = this;
                    iG = i17;
                    i33 = i18;
                    i34 = i19;
                    i35 = i21;
                }
            } else {
                unsafe = unsafe2;
                i13 = i29;
                q0Var = q0Var2;
                i14 = 1048575;
            }
        }
        if (i35 != i14) {
            t12 = t11;
            unsafe.putInt(t12, i35, i34);
        } else {
            t12 = t11;
        }
        i1 i1Var = null;
        for (int i50 = q0Var.f41402k; i50 < q0Var.f41403l; i50++) {
            i1Var = (i1) q0Var.q(t12, q0Var.f41401j[i50], i1Var, q0Var.f41406o);
        }
        if (i1Var != null) {
            q0Var.f41406o.o(t12, i1Var);
        }
        if (i13 == 0) {
            if (iG != i12) {
                throw InvalidProtocolBufferException.parseFailure();
            }
        } else if (iG > i12 || i33 != i13) {
            throw InvalidProtocolBufferException.parseFailure();
        }
        return iG;
    }

    @Override // com.google.protobuf.b1
    public int e(T t11) {
        return this.f41399h ? y(t11) : x(t11);
    }

    /* JADX WARN: Code duplicated, block: B:102:0x0297 A[PHI: r0 r23 r26 r27 r28
  0x0297: PHI (r0v54 int) = (r0v49 int), (r0v52 int), (r0v56 int) binds: [B:115:0x0302, B:111:0x02e3, B:101:0x0295] A[DONT_GENERATE, DONT_INLINE]
  0x0297: PHI (r23v3 int) = (r23v1 int), (r23v1 int), (r23v4 int) binds: [B:115:0x0302, B:111:0x02e3, B:101:0x0295] A[DONT_GENERATE, DONT_INLINE]
  0x0297: PHI (r26v2 int) = (r26v0 int), (r26v0 int), (r26v3 int) binds: [B:115:0x0302, B:111:0x02e3, B:101:0x0295] A[DONT_GENERATE, DONT_INLINE]
  0x0297: PHI (r27v6 int) = (r27v4 int), (r27v4 int), (r27v7 int) binds: [B:115:0x0302, B:111:0x02e3, B:101:0x0295] A[DONT_GENERATE, DONT_INLINE]
  0x0297: PHI (r28v7 sun.misc.Unsafe) = (r28v5 sun.misc.Unsafe), (r28v5 sun.misc.Unsafe), (r28v8 sun.misc.Unsafe) binds: [B:115:0x0302, B:111:0x02e3, B:101:0x0295] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:104:0x02ad A[PHI: r0 r23 r26 r27 r28
  0x02ad: PHI (r0v53 int) = (r0v49 int), (r0v52 int), (r0v56 int) binds: [B:115:0x0302, B:111:0x02e3, B:101:0x0295] A[DONT_GENERATE, DONT_INLINE]
  0x02ad: PHI (r23v2 int) = (r23v1 int), (r23v1 int), (r23v4 int) binds: [B:115:0x0302, B:111:0x02e3, B:101:0x0295] A[DONT_GENERATE, DONT_INLINE]
  0x02ad: PHI (r26v1 int) = (r26v0 int), (r26v0 int), (r26v3 int) binds: [B:115:0x0302, B:111:0x02e3, B:101:0x0295] A[DONT_GENERATE, DONT_INLINE]
  0x02ad: PHI (r27v5 int) = (r27v4 int), (r27v4 int), (r27v7 int) binds: [B:115:0x0302, B:111:0x02e3, B:101:0x0295] A[DONT_GENERATE, DONT_INLINE]
  0x02ad: PHI (r28v6 sun.misc.Unsafe) = (r28v5 sun.misc.Unsafe), (r28v5 sun.misc.Unsafe), (r28v8 sun.misc.Unsafe) binds: [B:115:0x0302, B:111:0x02e3, B:101:0x0295] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Failed to find 'out' block for switch in B:25:0x0085. Please report as an issue. */
    public final int e0(T t11, byte[] bArr, int i11, int i12, e.b bVar) throws IOException {
        int i13;
        int iH;
        int i14;
        int i15;
        Unsafe unsafe;
        int i16;
        int i17;
        int i18;
        int iL;
        int iP;
        int i19;
        int i21;
        int i22;
        this = this;
        t11 = t11;
        bArr = bArr;
        i12 = i12;
        bVar = bVar;
        Unsafe unsafe2 = f41391s;
        int i23 = -1;
        int iG = i11;
        int i24 = -1;
        int i25 = 0;
        int i26 = 0;
        int i27 = 1048575;
        while (iG < i12) {
            int i28 = iG + 1;
            byte b11 = bArr[iG];
            if (b11 < 0) {
                iH = e.H(b11, bArr, i28, bVar);
                i13 = bVar.f41227a;
            } else {
                i13 = b11;
                iH = i28;
            }
            int i29 = i13 >>> 3;
            int i31 = i13 & 7;
            int iH0 = i29 > i24 ? this.h0(i29, i25 / 3) : this.g0(i29);
            if (iH0 == i23) {
                i14 = iH;
                i15 = i29;
                unsafe = unsafe2;
                i16 = 0;
            } else {
                int i32 = this.f41392a[iH0 + 1];
                int iR0 = r0(i32);
                long jV = V(i32);
                if (iR0 <= 17) {
                    int i33 = this.f41392a[iH0 + 2];
                    int i34 = 1 << (i33 >>> 20);
                    int i35 = 1048575;
                    int i36 = i33 & 1048575;
                    if (i36 != i27) {
                        if (i27 != 1048575) {
                            unsafe2.putInt(t11, i27, i26);
                            i35 = 1048575;
                        }
                        if (i36 != i35) {
                            i26 = unsafe2.getInt(t11, i36);
                        }
                        i27 = i36;
                    }
                    switch (iR0) {
                        case 0:
                            i15 = i29;
                            bVar = bVar;
                            i17 = iH0;
                            i18 = i26;
                            if (i31 == 1) {
                                l1.S(t11, jV, e.d(bArr, iH));
                                iG = iH + 8;
                                i26 = i18 | i34;
                                i25 = i17;
                                i24 = i15;
                            }
                            i26 = i18;
                            i14 = iH;
                            i16 = i17;
                            unsafe = unsafe2;
                            break;
                        case 1:
                            i15 = i29;
                            i17 = iH0;
                            i18 = i26;
                            if (i31 == 5) {
                                l1.T(t11, jV, e.l(bArr, iH));
                                iG = iH + 4;
                                i26 = i18 | i34;
                                i25 = i17;
                                i24 = i15;
                            }
                            i26 = i18;
                            i14 = iH;
                            i16 = i17;
                            unsafe = unsafe2;
                            break;
                        case 2:
                        case 3:
                            i15 = i29;
                            bVar = bVar;
                            i17 = iH0;
                            i18 = i26;
                            if (i31 == 0) {
                                iL = e.L(bArr, iH, bVar);
                                unsafe2.putLong(t11, jV, bVar.f41228b);
                                i26 = i18 | i34;
                                i25 = i17;
                                iG = iL;
                                i24 = i15;
                            }
                            i26 = i18;
                            i14 = iH;
                            i16 = i17;
                            unsafe = unsafe2;
                            break;
                        case 4:
                        case 11:
                            i15 = i29;
                            bVar = bVar;
                            i17 = iH0;
                            i18 = i26;
                            if (i31 == 0) {
                                iG = e.I(bArr, iH, bVar);
                                unsafe2.putInt(t11, jV, bVar.f41227a);
                                i26 = i18 | i34;
                                i25 = i17;
                                i24 = i15;
                            }
                            i26 = i18;
                            i14 = iH;
                            i16 = i17;
                            unsafe = unsafe2;
                            break;
                        case 5:
                        case 14:
                            i15 = i29;
                            bVar = bVar;
                            i17 = iH0;
                            i18 = i26;
                            if (i31 == 1) {
                                unsafe2.putLong(t11, jV, e.j(bArr, iH));
                                iG = iH + 8;
                                i26 = i18 | i34;
                                i25 = i17;
                                i24 = i15;
                            }
                            i26 = i18;
                            i14 = iH;
                            i16 = i17;
                            unsafe = unsafe2;
                            break;
                        case 6:
                        case 13:
                            i15 = i29;
                            i17 = iH0;
                            i18 = i26;
                            if (i31 == 5) {
                                unsafe2.putInt(t11, jV, e.h(bArr, iH));
                                iG = iH + 4;
                                i26 = i18 | i34;
                                i25 = i17;
                                i24 = i15;
                            }
                            i26 = i18;
                            i14 = iH;
                            i16 = i17;
                            unsafe = unsafe2;
                            break;
                        case 7:
                            i15 = i29;
                            bVar = bVar;
                            i17 = iH0;
                            i18 = i26;
                            if (i31 == 0) {
                                int iL2 = e.L(bArr, iH, bVar);
                                l1.M(t11, jV, bVar.f41228b != 0);
                                i26 = i18 | i34;
                                iG = iL2;
                                i25 = i17;
                                i24 = i15;
                            }
                            i26 = i18;
                            i14 = iH;
                            i16 = i17;
                            unsafe = unsafe2;
                            break;
                        case 8:
                            i15 = i29;
                            bVar = bVar;
                            i17 = iH0;
                            i18 = i26;
                            if (i31 == 2) {
                                iG = (536870912 & i32) == 0 ? e.C(bArr, iH, bVar) : e.F(bArr, iH, bVar);
                                unsafe2.putObject(t11, jV, bVar.f41229c);
                                i26 = i18 | i34;
                                i25 = i17;
                                i24 = i15;
                            }
                            i26 = i18;
                            i14 = iH;
                            i16 = i17;
                            unsafe = unsafe2;
                            break;
                        case 9:
                            i15 = i29;
                            bVar = bVar;
                            i17 = iH0;
                            if (i31 == 2) {
                                iP = e.p(this.v(i17), bArr, iH, i12, bVar);
                                Object object = unsafe2.getObject(t11, jV);
                                if (object == null) {
                                    unsafe2.putObject(t11, jV, bVar.f41229c);
                                } else {
                                    unsafe2.putObject(t11, jV, y.h(object, bVar.f41229c));
                                }
                                i26 |= i34;
                                iG = iP;
                                i25 = i17;
                                i24 = i15;
                            }
                            i18 = i26;
                            i26 = i18;
                            i14 = iH;
                            i16 = i17;
                            unsafe = unsafe2;
                            break;
                        case 10:
                            i15 = i29;
                            bVar = bVar;
                            i17 = iH0;
                            if (i31 == 2) {
                                iP = e.b(bArr, iH, bVar);
                                unsafe2.putObject(t11, jV, bVar.f41229c);
                                i26 |= i34;
                                iG = iP;
                                i25 = i17;
                                i24 = i15;
                            }
                            i18 = i26;
                            i26 = i18;
                            i14 = iH;
                            i16 = i17;
                            unsafe = unsafe2;
                            break;
                        case 12:
                            i15 = i29;
                            bVar = bVar;
                            i17 = iH0;
                            if (i31 == 0) {
                                iP = e.I(bArr, iH, bVar);
                                unsafe2.putInt(t11, jV, bVar.f41227a);
                                i26 |= i34;
                                iG = iP;
                                i25 = i17;
                                i24 = i15;
                            }
                            i18 = i26;
                            i26 = i18;
                            i14 = iH;
                            i16 = i17;
                            unsafe = unsafe2;
                            break;
                        case 15:
                            i15 = i29;
                            bVar = bVar;
                            i17 = iH0;
                            if (i31 == 0) {
                                iG = e.I(bArr, iH, bVar);
                                unsafe2.putInt(t11, jV, j.b(bVar.f41227a));
                                i26 |= i34;
                                i25 = i17;
                                i24 = i15;
                            }
                            i18 = i26;
                            i26 = i18;
                            i14 = iH;
                            i16 = i17;
                            unsafe = unsafe2;
                            break;
                        case 16:
                            if (i31 == 0) {
                                bVar = bVar;
                                iL = e.L(bArr, iH, bVar);
                                i17 = iH0;
                                i15 = i29;
                                unsafe2.putLong(t11, jV, j.c(bVar.f41228b));
                                i26 |= i34;
                                i25 = i17;
                                iG = iL;
                                i24 = i15;
                                break;
                            }
                        default:
                            i15 = i29;
                            i17 = iH0;
                            i18 = i26;
                            i26 = i18;
                            i14 = iH;
                            i16 = i17;
                            unsafe = unsafe2;
                            break;
                    }
                    i23 = -1;
                } else {
                    i15 = i29;
                    int i37 = i26;
                    bVar = bVar;
                    if (iR0 != 27) {
                        if (iR0 <= 49) {
                            i21 = i37;
                            int i38 = iH;
                            i19 = i27;
                            i16 = iH0;
                            unsafe = unsafe2;
                            iG = f0(t11, bArr, iH, i12, i13, i15, i31, iH0, i32, iR0, jV, bVar);
                            if (iG != i38) {
                                i24 = i15;
                                i26 = i21;
                                i27 = i19;
                            } else {
                                i14 = iG;
                                i26 = i21;
                                i27 = i19;
                            }
                            i25 = i16;
                            unsafe2 = unsafe;
                        } else {
                            i19 = i27;
                            i16 = iH0;
                            unsafe = unsafe2;
                            i21 = i37;
                            i22 = iH;
                            if (iR0 == 50) {
                                if (i31 == 2) {
                                    iG = b0(t11, bArr, i22, i12, i16, jV, bVar);
                                    if (iG != i22) {
                                        i24 = i15;
                                        i26 = i21;
                                        i27 = i19;
                                    } else {
                                        i14 = iG;
                                    }
                                    i25 = i16;
                                    unsafe2 = unsafe;
                                }
                                i26 = i21;
                                i27 = i19;
                            } else {
                                iG = c0(t11, bArr, i22, i12, i13, i15, i31, i32, iR0, jV, i16, bVar);
                                if (iG != i22) {
                                    i24 = i15;
                                    i26 = i21;
                                    i27 = i19;
                                } else {
                                    i14 = iG;
                                    i26 = i21;
                                    i27 = i19;
                                }
                                i25 = i16;
                                unsafe2 = unsafe;
                            }
                        }
                        i23 = -1;
                    } else if (i31 == 2) {
                        y.j jVarC2 = (y.j) unsafe2.getObject(t11, jV);
                        if (!jVarC2.m()) {
                            int size = jVarC2.size();
                            jVarC2 = jVarC2.c2(size == 0 ? 10 : size * 2);
                            unsafe2.putObject(t11, jV, jVarC2);
                        }
                        iG = e.q(this.v(iH0), i13, bArr, iH, i12, jVarC2, bVar);
                        i25 = iH0;
                        i26 = i37;
                        i24 = i15;
                        i23 = -1;
                        this = this;
                    } else {
                        i22 = iH;
                        i19 = i27;
                        i16 = iH0;
                        unsafe = unsafe2;
                        i21 = i37;
                    }
                    i14 = i22;
                    i26 = i21;
                    i27 = i19;
                }
            }
            iG = e.G(i13, bArr, i14, i12, w(t11), bVar);
            i24 = i15;
            i25 = i16;
            unsafe2 = unsafe;
            i23 = -1;
        }
        int i39 = i26;
        Unsafe unsafe3 = unsafe2;
        if (i27 != 1048575) {
            unsafe3.putInt(t11, i27, i39);
        }
        if (iG == i12) {
            return iG;
        }
        throw InvalidProtocolBufferException.parseFailure();
    }

    @Override // com.google.protobuf.b1
    public T f() {
        return (T) this.f41404m.a(this.f41396e);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int f0(T t11, byte[] bArr, int i11, int i12, int i13, int i14, int i15, int i16, long j11, int i17, long j12, e.b bVar) throws IOException {
        int iJ;
        Unsafe unsafe = f41391s;
        y.j jVarC2 = (y.j) unsafe.getObject(t11, j12);
        if (!jVarC2.m()) {
            int size = jVarC2.size();
            jVarC2 = jVarC2.c2(size == 0 ? 10 : size * 2);
            unsafe.putObject(t11, j12, jVarC2);
        }
        switch (i17) {
            case 18:
            case 35:
                if (i15 == 2) {
                    return e.s(bArr, i11, jVarC2, bVar);
                }
                return i15 == 1 ? e.e(i13, bArr, i11, i12, jVarC2, bVar) : i11;
            case 19:
            case 36:
                if (i15 == 2) {
                    return e.v(bArr, i11, jVarC2, bVar);
                }
                return i15 == 5 ? e.m(i13, bArr, i11, i12, jVarC2, bVar) : i11;
            case 20:
            case 21:
            case 37:
            case 38:
                if (i15 == 2) {
                    return e.z(bArr, i11, jVarC2, bVar);
                }
                return i15 == 0 ? e.M(i13, bArr, i11, i12, jVarC2, bVar) : i11;
            case 22:
            case VungleException.INCORRECT_DEFAULT_API_USAGE /* 29 */:
            case 39:
            case MotionEventCompat.AXIS_GENERIC_12 /* 43 */:
                if (i15 == 2) {
                    return e.y(bArr, i11, jVarC2, bVar);
                }
                return i15 == 0 ? e.J(i13, bArr, i11, i12, jVarC2, bVar) : i11;
            case 23:
            case 32:
            case 40:
            case MotionEventCompat.AXIS_GENERIC_15 /* 46 */:
                if (i15 == 2) {
                    return e.u(bArr, i11, jVarC2, bVar);
                }
                return i15 == 1 ? e.k(i13, bArr, i11, i12, jVarC2, bVar) : i11;
            case 24:
            case VungleException.WEB_CRASH /* 31 */:
            case 41:
            case MotionEventCompat.AXIS_GENERIC_14 /* 45 */:
                if (i15 == 2) {
                    return e.t(bArr, i11, jVarC2, bVar);
                }
                return i15 == 5 ? e.i(i13, bArr, i11, i12, jVarC2, bVar) : i11;
            case 25:
            case MotionEventCompat.AXIS_GENERIC_11 /* 42 */:
                if (i15 == 2) {
                    return e.r(bArr, i11, jVarC2, bVar);
                }
                return i15 == 0 ? e.a(i13, bArr, i11, i12, jVarC2, bVar) : i11;
            case 26:
                if (i15 == 2) {
                    return (j11 & 536870912) == 0 ? e.D(i13, bArr, i11, i12, jVarC2, bVar) : e.E(i13, bArr, i11, i12, jVarC2, bVar);
                }
                return i11;
            case 27:
                return i15 == 2 ? e.q(v(i16), i13, bArr, i11, i12, jVarC2, bVar) : i11;
            case 28:
                return i15 == 2 ? e.c(i13, bArr, i11, i12, jVarC2, bVar) : i11;
            case 30:
            case MotionEventCompat.AXIS_GENERIC_13 /* 44 */:
                if (i15 == 2) {
                    iJ = e.y(bArr, i11, jVarC2, bVar);
                } else {
                    if (i15 != 0) {
                        return i11;
                    }
                    iJ = e.J(i13, bArr, i11, i12, jVarC2, bVar);
                }
                GeneratedMessageLite generatedMessageLite = (GeneratedMessageLite) t11;
                i1 i1Var = generatedMessageLite.unknownFields;
                if (i1Var == i1.c()) {
                    i1Var = null;
                }
                i1 i1Var2 = (i1) d1.A(i14, jVarC2, t(i16), i1Var, this.f41406o);
                if (i1Var2 != null) {
                    generatedMessageLite.unknownFields = i1Var2;
                }
                return iJ;
            case 33:
            case MotionEventCompat.AXIS_GENERIC_16 /* 47 */:
                if (i15 == 2) {
                    return e.w(bArr, i11, jVarC2, bVar);
                }
                return i15 == 0 ? e.A(i13, bArr, i11, i12, jVarC2, bVar) : i11;
            case 34:
            case 48:
                if (i15 == 2) {
                    return e.x(bArr, i11, jVarC2, bVar);
                }
                return i15 == 0 ? e.B(i13, bArr, i11, i12, jVarC2, bVar) : i11;
            case 49:
                return i15 == 3 ? e.o(v(i16), i13, bArr, i11, i12, jVarC2, bVar) : i11;
            default:
                return i11;
        }
    }

    @Override // com.google.protobuf.b1
    public int g(T t11) {
        int i11;
        int iF;
        int length = this.f41392a.length;
        int i12 = 0;
        for (int i13 = 0; i13 < length; i13 += 3) {
            int iS0 = s0(i13);
            int iU = U(i13);
            long jV = V(iS0);
            int iHashCode = 37;
            switch (r0(iS0)) {
                case 0:
                    i11 = i12 * 53;
                    iF = y.f(Double.doubleToLongBits(l1.A(t11, jV)));
                    i12 = i11 + iF;
                    break;
                case 1:
                    i11 = i12 * 53;
                    iF = Float.floatToIntBits(l1.B(t11, jV));
                    i12 = i11 + iF;
                    break;
                case 2:
                    i11 = i12 * 53;
                    iF = y.f(l1.E(t11, jV));
                    i12 = i11 + iF;
                    break;
                case 3:
                    i11 = i12 * 53;
                    iF = y.f(l1.E(t11, jV));
                    i12 = i11 + iF;
                    break;
                case 4:
                    i11 = i12 * 53;
                    iF = l1.C(t11, jV);
                    i12 = i11 + iF;
                    break;
                case 5:
                    i11 = i12 * 53;
                    iF = y.f(l1.E(t11, jV));
                    i12 = i11 + iF;
                    break;
                case 6:
                    i11 = i12 * 53;
                    iF = l1.C(t11, jV);
                    i12 = i11 + iF;
                    break;
                case 7:
                    i11 = i12 * 53;
                    iF = y.c(l1.t(t11, jV));
                    i12 = i11 + iF;
                    break;
                case 8:
                    i11 = i12 * 53;
                    iF = ((String) l1.G(t11, jV)).hashCode();
                    i12 = i11 + iF;
                    break;
                case 9:
                    Object objG = l1.G(t11, jV);
                    if (objG != null) {
                        iHashCode = objG.hashCode();
                    }
                    i12 = (i12 * 53) + iHashCode;
                    break;
                case 10:
                    i11 = i12 * 53;
                    iF = l1.G(t11, jV).hashCode();
                    i12 = i11 + iF;
                    break;
                case 11:
                    i11 = i12 * 53;
                    iF = l1.C(t11, jV);
                    i12 = i11 + iF;
                    break;
                case 12:
                    i11 = i12 * 53;
                    iF = l1.C(t11, jV);
                    i12 = i11 + iF;
                    break;
                case 13:
                    i11 = i12 * 53;
                    iF = l1.C(t11, jV);
                    i12 = i11 + iF;
                    break;
                case 14:
                    i11 = i12 * 53;
                    iF = y.f(l1.E(t11, jV));
                    i12 = i11 + iF;
                    break;
                case 15:
                    i11 = i12 * 53;
                    iF = l1.C(t11, jV);
                    i12 = i11 + iF;
                    break;
                case 16:
                    i11 = i12 * 53;
                    iF = y.f(l1.E(t11, jV));
                    i12 = i11 + iF;
                    break;
                case 17:
                    Object objG2 = l1.G(t11, jV);
                    if (objG2 != null) {
                        iHashCode = objG2.hashCode();
                    }
                    i12 = (i12 * 53) + iHashCode;
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case VungleException.INCORRECT_DEFAULT_API_USAGE /* 29 */:
                case 30:
                case VungleException.WEB_CRASH /* 31 */:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case MotionEventCompat.AXIS_GENERIC_11 /* 42 */:
                case MotionEventCompat.AXIS_GENERIC_12 /* 43 */:
                case MotionEventCompat.AXIS_GENERIC_13 /* 44 */:
                case MotionEventCompat.AXIS_GENERIC_14 /* 45 */:
                case MotionEventCompat.AXIS_GENERIC_15 /* 46 */:
                case MotionEventCompat.AXIS_GENERIC_16 /* 47 */:
                case 48:
                case 49:
                    i11 = i12 * 53;
                    iF = l1.G(t11, jV).hashCode();
                    i12 = i11 + iF;
                    break;
                case 50:
                    i11 = i12 * 53;
                    iF = l1.G(t11, jV).hashCode();
                    i12 = i11 + iF;
                    break;
                case 51:
                    if (I(t11, iU, i13)) {
                        i11 = i12 * 53;
                        iF = y.f(Double.doubleToLongBits(X(t11, jV)));
                        i12 = i11 + iF;
                    }
                    break;
                case 52:
                    if (I(t11, iU, i13)) {
                        i11 = i12 * 53;
                        iF = Float.floatToIntBits(Y(t11, jV));
                        i12 = i11 + iF;
                    }
                    break;
                case 53:
                    if (I(t11, iU, i13)) {
                        i11 = i12 * 53;
                        iF = y.f(a0(t11, jV));
                        i12 = i11 + iF;
                    }
                    break;
                case 54:
                    if (I(t11, iU, i13)) {
                        i11 = i12 * 53;
                        iF = y.f(a0(t11, jV));
                        i12 = i11 + iF;
                    }
                    break;
                case 55:
                    if (I(t11, iU, i13)) {
                        i11 = i12 * 53;
                        iF = Z(t11, jV);
                        i12 = i11 + iF;
                    }
                    break;
                case 56:
                    if (I(t11, iU, i13)) {
                        i11 = i12 * 53;
                        iF = y.f(a0(t11, jV));
                        i12 = i11 + iF;
                    }
                    break;
                case DownloadBean.STATUS_COMPLETED_REMOVED /* 57 */:
                    if (I(t11, iU, i13)) {
                        i11 = i12 * 53;
                        iF = Z(t11, jV);
                        i12 = i11 + iF;
                    }
                    break;
                case 58:
                    if (I(t11, iU, i13)) {
                        i11 = i12 * 53;
                        iF = y.c(W(t11, jV));
                        i12 = i11 + iF;
                    }
                    break;
                case 59:
                    if (I(t11, iU, i13)) {
                        i11 = i12 * 53;
                        iF = ((String) l1.G(t11, jV)).hashCode();
                        i12 = i11 + iF;
                    }
                    break;
                case 60:
                    if (I(t11, iU, i13)) {
                        i11 = i12 * 53;
                        iF = l1.G(t11, jV).hashCode();
                        i12 = i11 + iF;
                    }
                    break;
                case 61:
                    if (I(t11, iU, i13)) {
                        i11 = i12 * 53;
                        iF = l1.G(t11, jV).hashCode();
                        i12 = i11 + iF;
                    }
                    break;
                case 62:
                    if (I(t11, iU, i13)) {
                        i11 = i12 * 53;
                        iF = Z(t11, jV);
                        i12 = i11 + iF;
                    }
                    break;
                case 63:
                    if (I(t11, iU, i13)) {
                        i11 = i12 * 53;
                        iF = Z(t11, jV);
                        i12 = i11 + iF;
                    }
                    break;
                case 64:
                    if (I(t11, iU, i13)) {
                        i11 = i12 * 53;
                        iF = Z(t11, jV);
                        i12 = i11 + iF;
                    }
                    break;
                case RegisterRequest.U2F_V1_CHALLENGE_BYTE_LENGTH /* 65 */:
                    if (I(t11, iU, i13)) {
                        i11 = i12 * 53;
                        iF = y.f(a0(t11, jV));
                        i12 = i11 + iF;
                    }
                    break;
                case 66:
                    if (I(t11, iU, i13)) {
                        i11 = i12 * 53;
                        iF = Z(t11, jV);
                        i12 = i11 + iF;
                    }
                    break;
                case MdtaMetadataEntry.TYPE_INDICATOR_INT32 /* 67 */:
                    if (I(t11, iU, i13)) {
                        i11 = i12 * 53;
                        iF = y.f(a0(t11, jV));
                        i12 = i11 + iF;
                    }
                    break;
                case 68:
                    if (I(t11, iU, i13)) {
                        i11 = i12 * 53;
                        iF = l1.G(t11, jV).hashCode();
                        i12 = i11 + iF;
                    }
                    break;
            }
        }
        int iHashCode2 = (i12 * 53) + this.f41406o.g(t11).hashCode();
        return this.f41397f ? (iHashCode2 * 53) + this.f41407p.c(t11).hashCode() : iHashCode2;
    }

    public final int g0(int i11) {
        if (i11 < this.f41394c || i11 > this.f41395d) {
            return -1;
        }
        return q0(i11, 0);
    }

    @Override // com.google.protobuf.b1
    public void h(T t11, a1 a1Var, p pVar) throws IOException {
        pVar.getClass();
        M(this.f41406o, this.f41407p, t11, a1Var, pVar);
    }

    public final int h0(int i11, int i12) {
        if (i11 < this.f41394c || i11 > this.f41395d) {
            return -1;
        }
        return q0(i11, i12);
    }

    @Override // com.google.protobuf.b1
    public void i(T t11, byte[] bArr, int i11, int i12, e.b bVar) throws IOException {
        if (this.f41399h) {
            e0(t11, bArr, i11, i12, bVar);
        } else {
            d0(t11, bArr, i11, i12, 0, bVar);
        }
    }

    public final int i0(int i11) {
        return this.f41392a[i11 + 2];
    }

    @Override // com.google.protobuf.b1
    public boolean j(T t11, T t12) {
        int length = this.f41392a.length;
        for (int i11 = 0; i11 < length; i11 += 3) {
            if (!p(t11, t12, i11)) {
                return false;
            }
        }
        if (!this.f41406o.g(t11).equals(this.f41406o.g(t12))) {
            return false;
        }
        if (this.f41397f) {
            return this.f41407p.c(t11).equals(this.f41407p.c(t12));
        }
        return true;
    }

    public final <E> void j0(Object obj, long j11, a1 a1Var, b1<E> b1Var, p pVar) throws IOException {
        a1Var.d(this.f41405n.e(obj, j11), b1Var, pVar);
    }

    public final boolean k(T t11, T t12, int i11) {
        return C(t11, i11) == C(t12, i11);
    }

    public final <E> void k0(Object obj, int i11, a1 a1Var, b1<E> b1Var, p pVar) throws IOException {
        a1Var.f(this.f41405n.e(obj, V(i11)), b1Var, pVar);
    }

    public final void l0(Object obj, int i11, a1 a1Var) throws IOException {
        if (B(i11)) {
            l1.W(obj, V(i11), a1Var.O());
        } else if (this.f41398g) {
            l1.W(obj, V(i11), a1Var.E());
        } else {
            l1.W(obj, V(i11), a1Var.r());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <K, V> int m(byte[] bArr, int i11, int i12, h0.a<K, V> aVar, Map<K, V> map, e.b bVar) throws IOException {
        int iH;
        int I = e.I(bArr, i11, bVar);
        int i13 = bVar.f41227a;
        if (i13 < 0 || i13 > i12 - I) {
            throw InvalidProtocolBufferException.truncatedMessage();
        }
        int i14 = I + i13;
        Object obj = aVar.f41285b;
        Object obj2 = aVar.f41287d;
        while (I < i14) {
            int i15 = I + 1;
            int i16 = bArr[I];
            if (i16 < 0) {
                iH = e.H(i16, bArr, i15, bVar);
                i16 = bVar.f41227a;
            } else {
                iH = i15;
            }
            int i17 = i16 >>> 3;
            int i18 = i16 & 7;
            if (i17 != 1) {
                if (i17 == 2 && i18 == aVar.f41286c.getWireType()) {
                    I = n(bArr, iH, i12, aVar.f41286c, aVar.f41287d.getClass(), bVar);
                    obj2 = bVar.f41229c;
                } else {
                    I = e.N(i16, bArr, iH, i12, bVar);
                }
            } else if (i18 == aVar.f41284a.getWireType()) {
                I = n(bArr, iH, i12, aVar.f41284a, null, bVar);
                obj = bVar.f41229c;
            } else {
                I = e.N(i16, bArr, iH, i12, bVar);
            }
        }
        if (I != i14) {
            throw InvalidProtocolBufferException.parseFailure();
        }
        map.put(obj, obj2);
        return i14;
    }

    public final void m0(Object obj, int i11, a1 a1Var) throws IOException {
        if (B(i11)) {
            a1Var.q(this.f41405n.e(obj, V(i11)));
        } else {
            a1Var.G(this.f41405n.e(obj, V(i11)));
        }
    }

    public final int n(byte[] bArr, int i11, int i12, WireFormat.FieldType fieldType, Class<?> cls, e.b bVar) throws IOException {
        switch (a.f41409a[fieldType.ordinal()]) {
            case 1:
                int iL = e.L(bArr, i11, bVar);
                bVar.f41229c = Boolean.valueOf(bVar.f41228b != 0);
                return iL;
            case 2:
                return e.b(bArr, i11, bVar);
            case 3:
                bVar.f41229c = Double.valueOf(e.d(bArr, i11));
                return i11 + 8;
            case 4:
            case 5:
                bVar.f41229c = Integer.valueOf(e.h(bArr, i11));
                return i11 + 4;
            case 6:
            case 7:
                bVar.f41229c = Long.valueOf(e.j(bArr, i11));
                return i11 + 8;
            case 8:
                bVar.f41229c = Float.valueOf(e.l(bArr, i11));
                return i11 + 4;
            case 9:
            case 10:
            case 11:
                int I = e.I(bArr, i11, bVar);
                bVar.f41229c = Integer.valueOf(bVar.f41227a);
                return I;
            case 12:
            case 13:
                int iL2 = e.L(bArr, i11, bVar);
                bVar.f41229c = Long.valueOf(bVar.f41228b);
                return iL2;
            case 14:
                return e.p(x0.a().d(cls), bArr, i11, i12, bVar);
            case 15:
                int I2 = e.I(bArr, i11, bVar);
                bVar.f41229c = Integer.valueOf(j.b(bVar.f41227a));
                return I2;
            case 16:
                int iL3 = e.L(bArr, i11, bVar);
                bVar.f41229c = Long.valueOf(j.c(bVar.f41228b));
                return iL3;
            case 17:
                return e.F(bArr, i11, bVar);
            default:
                throw new RuntimeException("unsupported field type.");
        }
    }

    public final void o0(T t11, int i11) {
        int iI0 = i0(i11);
        long j11 = 1048575 & iI0;
        if (j11 == 1048575) {
            return;
        }
        l1.U(t11, j11, (1 << (iI0 >>> 20)) | l1.C(t11, j11));
    }

    public final boolean p(T t11, T t12, int i11) {
        int iS0 = s0(i11);
        long jV = V(iS0);
        switch (r0(iS0)) {
            case 0:
                return k(t11, t12, i11) && Double.doubleToLongBits(l1.A(t11, jV)) == Double.doubleToLongBits(l1.A(t12, jV));
            case 1:
                return k(t11, t12, i11) && Float.floatToIntBits(l1.B(t11, jV)) == Float.floatToIntBits(l1.B(t12, jV));
            case 2:
                return k(t11, t12, i11) && l1.E(t11, jV) == l1.E(t12, jV);
            case 3:
                return k(t11, t12, i11) && l1.E(t11, jV) == l1.E(t12, jV);
            case 4:
                return k(t11, t12, i11) && l1.C(t11, jV) == l1.C(t12, jV);
            case 5:
                return k(t11, t12, i11) && l1.E(t11, jV) == l1.E(t12, jV);
            case 6:
                return k(t11, t12, i11) && l1.C(t11, jV) == l1.C(t12, jV);
            case 7:
                return k(t11, t12, i11) && l1.t(t11, jV) == l1.t(t12, jV);
            case 8:
                return k(t11, t12, i11) && d1.K(l1.G(t11, jV), l1.G(t12, jV));
            case 9:
                return k(t11, t12, i11) && d1.K(l1.G(t11, jV), l1.G(t12, jV));
            case 10:
                return k(t11, t12, i11) && d1.K(l1.G(t11, jV), l1.G(t12, jV));
            case 11:
                return k(t11, t12, i11) && l1.C(t11, jV) == l1.C(t12, jV);
            case 12:
                return k(t11, t12, i11) && l1.C(t11, jV) == l1.C(t12, jV);
            case 13:
                return k(t11, t12, i11) && l1.C(t11, jV) == l1.C(t12, jV);
            case 14:
                return k(t11, t12, i11) && l1.E(t11, jV) == l1.E(t12, jV);
            case 15:
                return k(t11, t12, i11) && l1.C(t11, jV) == l1.C(t12, jV);
            case 16:
                return k(t11, t12, i11) && l1.E(t11, jV) == l1.E(t12, jV);
            case 17:
                return k(t11, t12, i11) && d1.K(l1.G(t11, jV), l1.G(t12, jV));
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case VungleException.INCORRECT_DEFAULT_API_USAGE /* 29 */:
            case 30:
            case VungleException.WEB_CRASH /* 31 */:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case MotionEventCompat.AXIS_GENERIC_11 /* 42 */:
            case MotionEventCompat.AXIS_GENERIC_12 /* 43 */:
            case MotionEventCompat.AXIS_GENERIC_13 /* 44 */:
            case MotionEventCompat.AXIS_GENERIC_14 /* 45 */:
            case MotionEventCompat.AXIS_GENERIC_15 /* 46 */:
            case MotionEventCompat.AXIS_GENERIC_16 /* 47 */:
            case 48:
            case 49:
                return d1.K(l1.G(t11, jV), l1.G(t12, jV));
            case 50:
                return d1.K(l1.G(t11, jV), l1.G(t12, jV));
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
            case 56:
            case DownloadBean.STATUS_COMPLETED_REMOVED /* 57 */:
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case RegisterRequest.U2F_V1_CHALLENGE_BYTE_LENGTH /* 65 */:
            case 66:
            case MdtaMetadataEntry.TYPE_INDICATOR_INT32 /* 67 */:
            case 68:
                return H(t11, t12, i11) && d1.K(l1.G(t11, jV), l1.G(t12, jV));
            default:
                return true;
        }
    }

    public final void p0(T t11, int i11, int i12) {
        l1.U(t11, i0(i12) & 1048575, i11);
    }

    public final <UT, UB> UB q(Object obj, int i11, UB ub2, h1<UT, UB> h1Var) {
        y.e eVarT;
        int iU = U(i11);
        Object objG = l1.G(obj, V(s0(i11)));
        return (objG == null || (eVarT = t(i11)) == null) ? ub2 : (UB) r(i11, iU, this.f41408q.c(objG), eVarT, ub2, h1Var);
    }

    public final int q0(int i11, int i12) {
        int length = (this.f41392a.length / 3) - 1;
        while (i12 <= length) {
            int i13 = (length + i12) >>> 1;
            int i14 = i13 * 3;
            int iU = U(i14);
            if (i11 == iU) {
                return i14;
            }
            if (i11 < iU) {
                length = i13 - 1;
            } else {
                i12 = i13 + 1;
            }
        }
        return -1;
    }

    public final <K, V, UT, UB> UB r(int i11, int i12, Map<K, V> map, y.e eVar, UB ub2, h1<UT, UB> h1Var) {
        h0.a<?, ?> aVarB = this.f41408q.b(u(i11));
        Iterator<Map.Entry<K, V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<K, V> next = it.next();
            if (!eVar.a(((Integer) next.getValue()).intValue())) {
                if (ub2 == null) {
                    ub2 = h1Var.n();
                }
                ByteString.f fVarNewCodedBuilder = ByteString.newCodedBuilder(h0.b(aVarB, next.getKey(), next.getValue()));
                try {
                    h0.e(fVarNewCodedBuilder.b(), aVarB, next.getKey(), next.getValue());
                    h1Var.d(ub2, i12, fVarNewCodedBuilder.a());
                    it.remove();
                } catch (IOException e11) {
                    throw new RuntimeException(e11);
                }
            }
        }
        return ub2;
    }

    public final int s0(int i11) {
        return this.f41392a[i11 + 1];
    }

    public final y.e t(int i11) {
        return (y.e) this.f41393b[((i11 / 3) * 2) + 1];
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0021  */
    public final void t0(T t11, Writer writer) throws IOException {
        Iterator itS;
        Map.Entry<?, ?> entry;
        int i11;
        if (this.f41397f) {
            u<T> uVarC = this.f41407p.c(t11);
            if (uVarC.n()) {
                itS = null;
                entry = null;
            } else {
                itS = uVarC.s();
                entry = (Map.Entry) itS.next();
            }
        } else {
            itS = null;
            entry = null;
        }
        int length = this.f41392a.length;
        Unsafe unsafe = f41391s;
        int i12 = 1048575;
        int i13 = 0;
        int i14 = 1048575;
        int i15 = 0;
        while (i13 < length) {
            int iS0 = s0(i13);
            int iU = U(i13);
            int iR0 = r0(iS0);
            if (iR0 <= 17) {
                int i16 = this.f41392a[i13 + 2];
                int i17 = i16 & i12;
                if (i17 != i14) {
                    i15 = unsafe.getInt(t11, i17);
                    i14 = i17;
                }
                i11 = 1 << (i16 >>> 20);
            } else {
                i11 = 0;
            }
            while (entry != null && this.f41407p.a(entry) <= iU) {
                this.f41407p.j(writer, entry);
                entry = itS.hasNext() ? (Map.Entry) itS.next() : null;
            }
            long jV = V(iS0);
            switch (iR0) {
                case 0:
                    if ((i11 & i15) != 0) {
                        writer.t(iU, o(t11, jV));
                        continue;
                    }
                    i13 += 3;
                    i12 = 1048575;
                    break;
                case 1:
                    if ((i11 & i15) != 0) {
                        writer.H(iU, s(t11, jV));
                    } else {
                        continue;
                    }
                    i13 += 3;
                    i12 = 1048575;
                    break;
                case 2:
                    if ((i11 & i15) != 0) {
                        writer.z(iU, unsafe.getLong(t11, jV));
                    } else {
                        continue;
                    }
                    i13 += 3;
                    i12 = 1048575;
                    break;
                case 3:
                    if ((i11 & i15) != 0) {
                        writer.g(iU, unsafe.getLong(t11, jV));
                    } else {
                        continue;
                    }
                    i13 += 3;
                    i12 = 1048575;
                    break;
                case 4:
                    if ((i11 & i15) != 0) {
                        writer.k(iU, unsafe.getInt(t11, jV));
                    } else {
                        continue;
                    }
                    i13 += 3;
                    i12 = 1048575;
                    break;
                case 5:
                    if ((i11 & i15) != 0) {
                        writer.x(iU, unsafe.getLong(t11, jV));
                    } else {
                        continue;
                    }
                    i13 += 3;
                    i12 = 1048575;
                    break;
                case 6:
                    if ((i11 & i15) != 0) {
                        writer.d(iU, unsafe.getInt(t11, jV));
                    } else {
                        continue;
                    }
                    i13 += 3;
                    i12 = 1048575;
                    break;
                case 7:
                    if ((i11 & i15) != 0) {
                        writer.A(iU, l(t11, jV));
                    } else {
                        continue;
                    }
                    i13 += 3;
                    i12 = 1048575;
                    break;
                case 8:
                    if ((i11 & i15) != 0) {
                        x0(iU, unsafe.getObject(t11, jV), writer);
                    } else {
                        continue;
                    }
                    i13 += 3;
                    i12 = 1048575;
                    break;
                case 9:
                    if ((i11 & i15) != 0) {
                        writer.w(iU, unsafe.getObject(t11, jV), v(i13));
                    } else {
                        continue;
                    }
                    i13 += 3;
                    i12 = 1048575;
                    break;
                case 10:
                    if ((i11 & i15) != 0) {
                        writer.j(iU, (ByteString) unsafe.getObject(t11, jV));
                    } else {
                        continue;
                    }
                    i13 += 3;
                    i12 = 1048575;
                    break;
                case 11:
                    if ((i11 & i15) != 0) {
                        writer.s(iU, unsafe.getInt(t11, jV));
                    } else {
                        continue;
                    }
                    i13 += 3;
                    i12 = 1048575;
                    break;
                case 12:
                    if ((i11 & i15) != 0) {
                        writer.K(iU, unsafe.getInt(t11, jV));
                    } else {
                        continue;
                    }
                    i13 += 3;
                    i12 = 1048575;
                    break;
                case 13:
                    if ((i11 & i15) != 0) {
                        writer.B(iU, unsafe.getInt(t11, jV));
                    } else {
                        continue;
                    }
                    i13 += 3;
                    i12 = 1048575;
                    break;
                case 14:
                    if ((i11 & i15) != 0) {
                        writer.l(iU, unsafe.getLong(t11, jV));
                    } else {
                        continue;
                    }
                    i13 += 3;
                    i12 = 1048575;
                    break;
                case 15:
                    if ((i11 & i15) != 0) {
                        writer.N(iU, unsafe.getInt(t11, jV));
                    } else {
                        continue;
                    }
                    i13 += 3;
                    i12 = 1048575;
                    break;
                case 16:
                    if ((i11 & i15) != 0) {
                        writer.p(iU, unsafe.getLong(t11, jV));
                    } else {
                        continue;
                    }
                    i13 += 3;
                    i12 = 1048575;
                    break;
                case 17:
                    if ((i11 & i15) != 0) {
                        writer.i(iU, unsafe.getObject(t11, jV), v(i13));
                    } else {
                        continue;
                    }
                    i13 += 3;
                    i12 = 1048575;
                    break;
                case 18:
                    d1.P(U(i13), (List) unsafe.getObject(t11, jV), writer, false);
                    continue;
                    i13 += 3;
                    i12 = 1048575;
                    break;
                case 19:
                    d1.T(U(i13), (List) unsafe.getObject(t11, jV), writer, false);
                    continue;
                    i13 += 3;
                    i12 = 1048575;
                    break;
                case 20:
                    d1.W(U(i13), (List) unsafe.getObject(t11, jV), writer, false);
                    continue;
                    i13 += 3;
                    i12 = 1048575;
                    break;
                case 21:
                    d1.e0(U(i13), (List) unsafe.getObject(t11, jV), writer, false);
                    continue;
                    i13 += 3;
                    i12 = 1048575;
                    break;
                case 22:
                    d1.V(U(i13), (List) unsafe.getObject(t11, jV), writer, false);
                    continue;
                    i13 += 3;
                    i12 = 1048575;
                    break;
                case 23:
                    d1.S(U(i13), (List) unsafe.getObject(t11, jV), writer, false);
                    continue;
                    i13 += 3;
                    i12 = 1048575;
                    break;
                case 24:
                    d1.R(U(i13), (List) unsafe.getObject(t11, jV), writer, false);
                    continue;
                    i13 += 3;
                    i12 = 1048575;
                    break;
                case 25:
                    d1.N(U(i13), (List) unsafe.getObject(t11, jV), writer, false);
                    continue;
                    i13 += 3;
                    i12 = 1048575;
                    break;
                case 26:
                    d1.c0(U(i13), (List) unsafe.getObject(t11, jV), writer);
                    break;
                case 27:
                    d1.X(U(i13), (List) unsafe.getObject(t11, jV), writer, v(i13));
                    break;
                case 28:
                    d1.O(U(i13), (List) unsafe.getObject(t11, jV), writer);
                    break;
                case VungleException.INCORRECT_DEFAULT_API_USAGE /* 29 */:
                    d1.d0(U(i13), (List) unsafe.getObject(t11, jV), writer, false);
                    continue;
                    i13 += 3;
                    i12 = 1048575;
                    break;
                case 30:
                    d1.Q(U(i13), (List) unsafe.getObject(t11, jV), writer, false);
                    continue;
                    i13 += 3;
                    i12 = 1048575;
                    break;
                case VungleException.WEB_CRASH /* 31 */:
                    d1.Y(U(i13), (List) unsafe.getObject(t11, jV), writer, false);
                    continue;
                    i13 += 3;
                    i12 = 1048575;
                    break;
                case 32:
                    d1.Z(U(i13), (List) unsafe.getObject(t11, jV), writer, false);
                    continue;
                    i13 += 3;
                    i12 = 1048575;
                    break;
                case 33:
                    d1.a0(U(i13), (List) unsafe.getObject(t11, jV), writer, false);
                    continue;
                    i13 += 3;
                    i12 = 1048575;
                    break;
                case 34:
                    d1.b0(U(i13), (List) unsafe.getObject(t11, jV), writer, false);
                    continue;
                    i13 += 3;
                    i12 = 1048575;
                    break;
                case 35:
                    d1.P(U(i13), (List) unsafe.getObject(t11, jV), writer, true);
                    break;
                case 36:
                    d1.T(U(i13), (List) unsafe.getObject(t11, jV), writer, true);
                    break;
                case 37:
                    d1.W(U(i13), (List) unsafe.getObject(t11, jV), writer, true);
                    break;
                case 38:
                    d1.e0(U(i13), (List) unsafe.getObject(t11, jV), writer, true);
                    break;
                case 39:
                    d1.V(U(i13), (List) unsafe.getObject(t11, jV), writer, true);
                    break;
                case 40:
                    d1.S(U(i13), (List) unsafe.getObject(t11, jV), writer, true);
                    break;
                case 41:
                    d1.R(U(i13), (List) unsafe.getObject(t11, jV), writer, true);
                    break;
                case MotionEventCompat.AXIS_GENERIC_11 /* 42 */:
                    d1.N(U(i13), (List) unsafe.getObject(t11, jV), writer, true);
                    break;
                case MotionEventCompat.AXIS_GENERIC_12 /* 43 */:
                    d1.d0(U(i13), (List) unsafe.getObject(t11, jV), writer, true);
                    break;
                case MotionEventCompat.AXIS_GENERIC_13 /* 44 */:
                    d1.Q(U(i13), (List) unsafe.getObject(t11, jV), writer, true);
                    break;
                case MotionEventCompat.AXIS_GENERIC_14 /* 45 */:
                    d1.Y(U(i13), (List) unsafe.getObject(t11, jV), writer, true);
                    break;
                case MotionEventCompat.AXIS_GENERIC_15 /* 46 */:
                    d1.Z(U(i13), (List) unsafe.getObject(t11, jV), writer, true);
                    break;
                case MotionEventCompat.AXIS_GENERIC_16 /* 47 */:
                    d1.a0(U(i13), (List) unsafe.getObject(t11, jV), writer, true);
                    break;
                case 48:
                    d1.b0(U(i13), (List) unsafe.getObject(t11, jV), writer, true);
                    break;
                case 49:
                    d1.U(U(i13), (List) unsafe.getObject(t11, jV), writer, v(i13));
                    break;
                case 50:
                    w0(writer, iU, unsafe.getObject(t11, jV), i13);
                    break;
                case 51:
                    if (I(t11, iU, i13)) {
                        writer.t(iU, X(t11, jV));
                    }
                    break;
                case 52:
                    if (I(t11, iU, i13)) {
                        writer.H(iU, Y(t11, jV));
                    }
                    break;
                case 53:
                    if (I(t11, iU, i13)) {
                        writer.z(iU, a0(t11, jV));
                    }
                    break;
                case 54:
                    if (I(t11, iU, i13)) {
                        writer.g(iU, a0(t11, jV));
                    }
                    break;
                case 55:
                    if (I(t11, iU, i13)) {
                        writer.k(iU, Z(t11, jV));
                    }
                    break;
                case 56:
                    if (I(t11, iU, i13)) {
                        writer.x(iU, a0(t11, jV));
                    }
                    break;
                case DownloadBean.STATUS_COMPLETED_REMOVED /* 57 */:
                    if (I(t11, iU, i13)) {
                        writer.d(iU, Z(t11, jV));
                    }
                    break;
                case 58:
                    if (I(t11, iU, i13)) {
                        writer.A(iU, W(t11, jV));
                    }
                    break;
                case 59:
                    if (I(t11, iU, i13)) {
                        x0(iU, unsafe.getObject(t11, jV), writer);
                    }
                    break;
                case 60:
                    if (I(t11, iU, i13)) {
                        writer.w(iU, unsafe.getObject(t11, jV), v(i13));
                    }
                    break;
                case 61:
                    if (I(t11, iU, i13)) {
                        writer.j(iU, (ByteString) unsafe.getObject(t11, jV));
                    }
                    break;
                case 62:
                    if (I(t11, iU, i13)) {
                        writer.s(iU, Z(t11, jV));
                    }
                    break;
                case 63:
                    if (I(t11, iU, i13)) {
                        writer.K(iU, Z(t11, jV));
                    }
                    break;
                case 64:
                    if (I(t11, iU, i13)) {
                        writer.B(iU, Z(t11, jV));
                    }
                    break;
                case RegisterRequest.U2F_V1_CHALLENGE_BYTE_LENGTH /* 65 */:
                    if (I(t11, iU, i13)) {
                        writer.l(iU, a0(t11, jV));
                    }
                    break;
                case 66:
                    if (I(t11, iU, i13)) {
                        writer.N(iU, Z(t11, jV));
                    }
                    break;
                case MdtaMetadataEntry.TYPE_INDICATOR_INT32 /* 67 */:
                    if (I(t11, iU, i13)) {
                        writer.p(iU, a0(t11, jV));
                    }
                    break;
                case 68:
                    if (I(t11, iU, i13)) {
                        writer.i(iU, unsafe.getObject(t11, jV), v(i13));
                    }
                    break;
            }
            i13 += 3;
            i12 = 1048575;
        }
        while (entry != null) {
            this.f41407p.j(writer, entry);
            entry = itS.hasNext() ? (Map.Entry) itS.next() : null;
        }
        y0(this.f41406o, t11, writer);
    }

    public final Object u(int i11) {
        return this.f41393b[(i11 / 3) * 2];
    }

    /* JADX WARN: Code duplicated, block: B:7:0x001c  */
    public final void u0(T t11, Writer writer) throws IOException {
        Iterator itS;
        Map.Entry<?, ?> entry;
        if (this.f41397f) {
            u<T> uVarC = this.f41407p.c(t11);
            if (uVarC.n()) {
                itS = null;
                entry = null;
            } else {
                itS = uVarC.s();
                entry = (Map.Entry) itS.next();
            }
        } else {
            itS = null;
            entry = null;
        }
        int length = this.f41392a.length;
        for (int i11 = 0; i11 < length; i11 += 3) {
            int iS0 = s0(i11);
            int iU = U(i11);
            while (entry != null && this.f41407p.a(entry) <= iU) {
                this.f41407p.j(writer, entry);
                entry = itS.hasNext() ? (Map.Entry) itS.next() : null;
            }
            switch (r0(iS0)) {
                case 0:
                    if (C(t11, i11)) {
                        writer.t(iU, o(t11, V(iS0)));
                    }
                    break;
                case 1:
                    if (C(t11, i11)) {
                        writer.H(iU, s(t11, V(iS0)));
                    }
                    break;
                case 2:
                    if (C(t11, i11)) {
                        writer.z(iU, L(t11, V(iS0)));
                    }
                    break;
                case 3:
                    if (C(t11, i11)) {
                        writer.g(iU, L(t11, V(iS0)));
                    }
                    break;
                case 4:
                    if (C(t11, i11)) {
                        writer.k(iU, A(t11, V(iS0)));
                    }
                    break;
                case 5:
                    if (C(t11, i11)) {
                        writer.x(iU, L(t11, V(iS0)));
                    }
                    break;
                case 6:
                    if (C(t11, i11)) {
                        writer.d(iU, A(t11, V(iS0)));
                    }
                    break;
                case 7:
                    if (C(t11, i11)) {
                        writer.A(iU, l(t11, V(iS0)));
                    }
                    break;
                case 8:
                    if (C(t11, i11)) {
                        x0(iU, l1.G(t11, V(iS0)), writer);
                    }
                    break;
                case 9:
                    if (C(t11, i11)) {
                        writer.w(iU, l1.G(t11, V(iS0)), v(i11));
                    }
                    break;
                case 10:
                    if (C(t11, i11)) {
                        writer.j(iU, (ByteString) l1.G(t11, V(iS0)));
                    }
                    break;
                case 11:
                    if (C(t11, i11)) {
                        writer.s(iU, A(t11, V(iS0)));
                    }
                    break;
                case 12:
                    if (C(t11, i11)) {
                        writer.K(iU, A(t11, V(iS0)));
                    }
                    break;
                case 13:
                    if (C(t11, i11)) {
                        writer.B(iU, A(t11, V(iS0)));
                    }
                    break;
                case 14:
                    if (C(t11, i11)) {
                        writer.l(iU, L(t11, V(iS0)));
                    }
                    break;
                case 15:
                    if (C(t11, i11)) {
                        writer.N(iU, A(t11, V(iS0)));
                    }
                    break;
                case 16:
                    if (C(t11, i11)) {
                        writer.p(iU, L(t11, V(iS0)));
                    }
                    break;
                case 17:
                    if (C(t11, i11)) {
                        writer.i(iU, l1.G(t11, V(iS0)), v(i11));
                    }
                    break;
                case 18:
                    d1.P(U(i11), (List) l1.G(t11, V(iS0)), writer, false);
                    break;
                case 19:
                    d1.T(U(i11), (List) l1.G(t11, V(iS0)), writer, false);
                    break;
                case 20:
                    d1.W(U(i11), (List) l1.G(t11, V(iS0)), writer, false);
                    break;
                case 21:
                    d1.e0(U(i11), (List) l1.G(t11, V(iS0)), writer, false);
                    break;
                case 22:
                    d1.V(U(i11), (List) l1.G(t11, V(iS0)), writer, false);
                    break;
                case 23:
                    d1.S(U(i11), (List) l1.G(t11, V(iS0)), writer, false);
                    break;
                case 24:
                    d1.R(U(i11), (List) l1.G(t11, V(iS0)), writer, false);
                    break;
                case 25:
                    d1.N(U(i11), (List) l1.G(t11, V(iS0)), writer, false);
                    break;
                case 26:
                    d1.c0(U(i11), (List) l1.G(t11, V(iS0)), writer);
                    break;
                case 27:
                    d1.X(U(i11), (List) l1.G(t11, V(iS0)), writer, v(i11));
                    break;
                case 28:
                    d1.O(U(i11), (List) l1.G(t11, V(iS0)), writer);
                    break;
                case VungleException.INCORRECT_DEFAULT_API_USAGE /* 29 */:
                    d1.d0(U(i11), (List) l1.G(t11, V(iS0)), writer, false);
                    break;
                case 30:
                    d1.Q(U(i11), (List) l1.G(t11, V(iS0)), writer, false);
                    break;
                case VungleException.WEB_CRASH /* 31 */:
                    d1.Y(U(i11), (List) l1.G(t11, V(iS0)), writer, false);
                    break;
                case 32:
                    d1.Z(U(i11), (List) l1.G(t11, V(iS0)), writer, false);
                    break;
                case 33:
                    d1.a0(U(i11), (List) l1.G(t11, V(iS0)), writer, false);
                    break;
                case 34:
                    d1.b0(U(i11), (List) l1.G(t11, V(iS0)), writer, false);
                    break;
                case 35:
                    d1.P(U(i11), (List) l1.G(t11, V(iS0)), writer, true);
                    break;
                case 36:
                    d1.T(U(i11), (List) l1.G(t11, V(iS0)), writer, true);
                    break;
                case 37:
                    d1.W(U(i11), (List) l1.G(t11, V(iS0)), writer, true);
                    break;
                case 38:
                    d1.e0(U(i11), (List) l1.G(t11, V(iS0)), writer, true);
                    break;
                case 39:
                    d1.V(U(i11), (List) l1.G(t11, V(iS0)), writer, true);
                    break;
                case 40:
                    d1.S(U(i11), (List) l1.G(t11, V(iS0)), writer, true);
                    break;
                case 41:
                    d1.R(U(i11), (List) l1.G(t11, V(iS0)), writer, true);
                    break;
                case MotionEventCompat.AXIS_GENERIC_11 /* 42 */:
                    d1.N(U(i11), (List) l1.G(t11, V(iS0)), writer, true);
                    break;
                case MotionEventCompat.AXIS_GENERIC_12 /* 43 */:
                    d1.d0(U(i11), (List) l1.G(t11, V(iS0)), writer, true);
                    break;
                case MotionEventCompat.AXIS_GENERIC_13 /* 44 */:
                    d1.Q(U(i11), (List) l1.G(t11, V(iS0)), writer, true);
                    break;
                case MotionEventCompat.AXIS_GENERIC_14 /* 45 */:
                    d1.Y(U(i11), (List) l1.G(t11, V(iS0)), writer, true);
                    break;
                case MotionEventCompat.AXIS_GENERIC_15 /* 46 */:
                    d1.Z(U(i11), (List) l1.G(t11, V(iS0)), writer, true);
                    break;
                case MotionEventCompat.AXIS_GENERIC_16 /* 47 */:
                    d1.a0(U(i11), (List) l1.G(t11, V(iS0)), writer, true);
                    break;
                case 48:
                    d1.b0(U(i11), (List) l1.G(t11, V(iS0)), writer, true);
                    break;
                case 49:
                    d1.U(U(i11), (List) l1.G(t11, V(iS0)), writer, v(i11));
                    break;
                case 50:
                    w0(writer, iU, l1.G(t11, V(iS0)), i11);
                    break;
                case 51:
                    if (I(t11, iU, i11)) {
                        writer.t(iU, X(t11, V(iS0)));
                    }
                    break;
                case 52:
                    if (I(t11, iU, i11)) {
                        writer.H(iU, Y(t11, V(iS0)));
                    }
                    break;
                case 53:
                    if (I(t11, iU, i11)) {
                        writer.z(iU, a0(t11, V(iS0)));
                    }
                    break;
                case 54:
                    if (I(t11, iU, i11)) {
                        writer.g(iU, a0(t11, V(iS0)));
                    }
                    break;
                case 55:
                    if (I(t11, iU, i11)) {
                        writer.k(iU, Z(t11, V(iS0)));
                    }
                    break;
                case 56:
                    if (I(t11, iU, i11)) {
                        writer.x(iU, a0(t11, V(iS0)));
                    }
                    break;
                case DownloadBean.STATUS_COMPLETED_REMOVED /* 57 */:
                    if (I(t11, iU, i11)) {
                        writer.d(iU, Z(t11, V(iS0)));
                    }
                    break;
                case 58:
                    if (I(t11, iU, i11)) {
                        writer.A(iU, W(t11, V(iS0)));
                    }
                    break;
                case 59:
                    if (I(t11, iU, i11)) {
                        x0(iU, l1.G(t11, V(iS0)), writer);
                    }
                    break;
                case 60:
                    if (I(t11, iU, i11)) {
                        writer.w(iU, l1.G(t11, V(iS0)), v(i11));
                    }
                    break;
                case 61:
                    if (I(t11, iU, i11)) {
                        writer.j(iU, (ByteString) l1.G(t11, V(iS0)));
                    }
                    break;
                case 62:
                    if (I(t11, iU, i11)) {
                        writer.s(iU, Z(t11, V(iS0)));
                    }
                    break;
                case 63:
                    if (I(t11, iU, i11)) {
                        writer.K(iU, Z(t11, V(iS0)));
                    }
                    break;
                case 64:
                    if (I(t11, iU, i11)) {
                        writer.B(iU, Z(t11, V(iS0)));
                    }
                    break;
                case RegisterRequest.U2F_V1_CHALLENGE_BYTE_LENGTH /* 65 */:
                    if (I(t11, iU, i11)) {
                        writer.l(iU, a0(t11, V(iS0)));
                    }
                    break;
                case 66:
                    if (I(t11, iU, i11)) {
                        writer.N(iU, Z(t11, V(iS0)));
                    }
                    break;
                case MdtaMetadataEntry.TYPE_INDICATOR_INT32 /* 67 */:
                    if (I(t11, iU, i11)) {
                        writer.p(iU, a0(t11, V(iS0)));
                    }
                    break;
                case 68:
                    if (I(t11, iU, i11)) {
                        writer.i(iU, l1.G(t11, V(iS0)), v(i11));
                    }
                    break;
            }
        }
        while (entry != null) {
            this.f41407p.j(writer, entry);
            entry = itS.hasNext() ? (Map.Entry) itS.next() : null;
        }
        y0(this.f41406o, t11, writer);
    }

    public final b1 v(int i11) {
        int i12 = (i11 / 3) * 2;
        b1 b1Var = (b1) this.f41393b[i12];
        if (b1Var != null) {
            return b1Var;
        }
        b1<T> b1VarD = x0.a().d((Class) this.f41393b[i12 + 1]);
        this.f41393b[i12] = b1VarD;
        return b1VarD;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0021  */
    public final void v0(T t11, Writer writer) throws IOException {
        Iterator itG;
        Map.Entry<?, ?> entry;
        y0(this.f41406o, t11, writer);
        if (this.f41397f) {
            u<T> uVarC = this.f41407p.c(t11);
            if (uVarC.n()) {
                itG = null;
                entry = null;
            } else {
                itG = uVarC.g();
                entry = (Map.Entry) itG.next();
            }
        } else {
            itG = null;
            entry = null;
        }
        for (int length = this.f41392a.length - 3; length >= 0; length -= 3) {
            int iS0 = s0(length);
            int iU = U(length);
            while (entry != null && this.f41407p.a(entry) > iU) {
                this.f41407p.j(writer, entry);
                entry = itG.hasNext() ? (Map.Entry) itG.next() : null;
            }
            switch (r0(iS0)) {
                case 0:
                    if (C(t11, length)) {
                        writer.t(iU, o(t11, V(iS0)));
                    }
                    break;
                case 1:
                    if (C(t11, length)) {
                        writer.H(iU, s(t11, V(iS0)));
                    }
                    break;
                case 2:
                    if (C(t11, length)) {
                        writer.z(iU, L(t11, V(iS0)));
                    }
                    break;
                case 3:
                    if (C(t11, length)) {
                        writer.g(iU, L(t11, V(iS0)));
                    }
                    break;
                case 4:
                    if (C(t11, length)) {
                        writer.k(iU, A(t11, V(iS0)));
                    }
                    break;
                case 5:
                    if (C(t11, length)) {
                        writer.x(iU, L(t11, V(iS0)));
                    }
                    break;
                case 6:
                    if (C(t11, length)) {
                        writer.d(iU, A(t11, V(iS0)));
                    }
                    break;
                case 7:
                    if (C(t11, length)) {
                        writer.A(iU, l(t11, V(iS0)));
                    }
                    break;
                case 8:
                    if (C(t11, length)) {
                        x0(iU, l1.G(t11, V(iS0)), writer);
                    }
                    break;
                case 9:
                    if (C(t11, length)) {
                        writer.w(iU, l1.G(t11, V(iS0)), v(length));
                    }
                    break;
                case 10:
                    if (C(t11, length)) {
                        writer.j(iU, (ByteString) l1.G(t11, V(iS0)));
                    }
                    break;
                case 11:
                    if (C(t11, length)) {
                        writer.s(iU, A(t11, V(iS0)));
                    }
                    break;
                case 12:
                    if (C(t11, length)) {
                        writer.K(iU, A(t11, V(iS0)));
                    }
                    break;
                case 13:
                    if (C(t11, length)) {
                        writer.B(iU, A(t11, V(iS0)));
                    }
                    break;
                case 14:
                    if (C(t11, length)) {
                        writer.l(iU, L(t11, V(iS0)));
                    }
                    break;
                case 15:
                    if (C(t11, length)) {
                        writer.N(iU, A(t11, V(iS0)));
                    }
                    break;
                case 16:
                    if (C(t11, length)) {
                        writer.p(iU, L(t11, V(iS0)));
                    }
                    break;
                case 17:
                    if (C(t11, length)) {
                        writer.i(iU, l1.G(t11, V(iS0)), v(length));
                    }
                    break;
                case 18:
                    d1.P(U(length), (List) l1.G(t11, V(iS0)), writer, false);
                    break;
                case 19:
                    d1.T(U(length), (List) l1.G(t11, V(iS0)), writer, false);
                    break;
                case 20:
                    d1.W(U(length), (List) l1.G(t11, V(iS0)), writer, false);
                    break;
                case 21:
                    d1.e0(U(length), (List) l1.G(t11, V(iS0)), writer, false);
                    break;
                case 22:
                    d1.V(U(length), (List) l1.G(t11, V(iS0)), writer, false);
                    break;
                case 23:
                    d1.S(U(length), (List) l1.G(t11, V(iS0)), writer, false);
                    break;
                case 24:
                    d1.R(U(length), (List) l1.G(t11, V(iS0)), writer, false);
                    break;
                case 25:
                    d1.N(U(length), (List) l1.G(t11, V(iS0)), writer, false);
                    break;
                case 26:
                    d1.c0(U(length), (List) l1.G(t11, V(iS0)), writer);
                    break;
                case 27:
                    d1.X(U(length), (List) l1.G(t11, V(iS0)), writer, v(length));
                    break;
                case 28:
                    d1.O(U(length), (List) l1.G(t11, V(iS0)), writer);
                    break;
                case VungleException.INCORRECT_DEFAULT_API_USAGE /* 29 */:
                    d1.d0(U(length), (List) l1.G(t11, V(iS0)), writer, false);
                    break;
                case 30:
                    d1.Q(U(length), (List) l1.G(t11, V(iS0)), writer, false);
                    break;
                case VungleException.WEB_CRASH /* 31 */:
                    d1.Y(U(length), (List) l1.G(t11, V(iS0)), writer, false);
                    break;
                case 32:
                    d1.Z(U(length), (List) l1.G(t11, V(iS0)), writer, false);
                    break;
                case 33:
                    d1.a0(U(length), (List) l1.G(t11, V(iS0)), writer, false);
                    break;
                case 34:
                    d1.b0(U(length), (List) l1.G(t11, V(iS0)), writer, false);
                    break;
                case 35:
                    d1.P(U(length), (List) l1.G(t11, V(iS0)), writer, true);
                    break;
                case 36:
                    d1.T(U(length), (List) l1.G(t11, V(iS0)), writer, true);
                    break;
                case 37:
                    d1.W(U(length), (List) l1.G(t11, V(iS0)), writer, true);
                    break;
                case 38:
                    d1.e0(U(length), (List) l1.G(t11, V(iS0)), writer, true);
                    break;
                case 39:
                    d1.V(U(length), (List) l1.G(t11, V(iS0)), writer, true);
                    break;
                case 40:
                    d1.S(U(length), (List) l1.G(t11, V(iS0)), writer, true);
                    break;
                case 41:
                    d1.R(U(length), (List) l1.G(t11, V(iS0)), writer, true);
                    break;
                case MotionEventCompat.AXIS_GENERIC_11 /* 42 */:
                    d1.N(U(length), (List) l1.G(t11, V(iS0)), writer, true);
                    break;
                case MotionEventCompat.AXIS_GENERIC_12 /* 43 */:
                    d1.d0(U(length), (List) l1.G(t11, V(iS0)), writer, true);
                    break;
                case MotionEventCompat.AXIS_GENERIC_13 /* 44 */:
                    d1.Q(U(length), (List) l1.G(t11, V(iS0)), writer, true);
                    break;
                case MotionEventCompat.AXIS_GENERIC_14 /* 45 */:
                    d1.Y(U(length), (List) l1.G(t11, V(iS0)), writer, true);
                    break;
                case MotionEventCompat.AXIS_GENERIC_15 /* 46 */:
                    d1.Z(U(length), (List) l1.G(t11, V(iS0)), writer, true);
                    break;
                case MotionEventCompat.AXIS_GENERIC_16 /* 47 */:
                    d1.a0(U(length), (List) l1.G(t11, V(iS0)), writer, true);
                    break;
                case 48:
                    d1.b0(U(length), (List) l1.G(t11, V(iS0)), writer, true);
                    break;
                case 49:
                    d1.U(U(length), (List) l1.G(t11, V(iS0)), writer, v(length));
                    break;
                case 50:
                    w0(writer, iU, l1.G(t11, V(iS0)), length);
                    break;
                case 51:
                    if (I(t11, iU, length)) {
                        writer.t(iU, X(t11, V(iS0)));
                    }
                    break;
                case 52:
                    if (I(t11, iU, length)) {
                        writer.H(iU, Y(t11, V(iS0)));
                    }
                    break;
                case 53:
                    if (I(t11, iU, length)) {
                        writer.z(iU, a0(t11, V(iS0)));
                    }
                    break;
                case 54:
                    if (I(t11, iU, length)) {
                        writer.g(iU, a0(t11, V(iS0)));
                    }
                    break;
                case 55:
                    if (I(t11, iU, length)) {
                        writer.k(iU, Z(t11, V(iS0)));
                    }
                    break;
                case 56:
                    if (I(t11, iU, length)) {
                        writer.x(iU, a0(t11, V(iS0)));
                    }
                    break;
                case DownloadBean.STATUS_COMPLETED_REMOVED /* 57 */:
                    if (I(t11, iU, length)) {
                        writer.d(iU, Z(t11, V(iS0)));
                    }
                    break;
                case 58:
                    if (I(t11, iU, length)) {
                        writer.A(iU, W(t11, V(iS0)));
                    }
                    break;
                case 59:
                    if (I(t11, iU, length)) {
                        x0(iU, l1.G(t11, V(iS0)), writer);
                    }
                    break;
                case 60:
                    if (I(t11, iU, length)) {
                        writer.w(iU, l1.G(t11, V(iS0)), v(length));
                    }
                    break;
                case 61:
                    if (I(t11, iU, length)) {
                        writer.j(iU, (ByteString) l1.G(t11, V(iS0)));
                    }
                    break;
                case 62:
                    if (I(t11, iU, length)) {
                        writer.s(iU, Z(t11, V(iS0)));
                    }
                    break;
                case 63:
                    if (I(t11, iU, length)) {
                        writer.K(iU, Z(t11, V(iS0)));
                    }
                    break;
                case 64:
                    if (I(t11, iU, length)) {
                        writer.B(iU, Z(t11, V(iS0)));
                    }
                    break;
                case RegisterRequest.U2F_V1_CHALLENGE_BYTE_LENGTH /* 65 */:
                    if (I(t11, iU, length)) {
                        writer.l(iU, a0(t11, V(iS0)));
                    }
                    break;
                case 66:
                    if (I(t11, iU, length)) {
                        writer.N(iU, Z(t11, V(iS0)));
                    }
                    break;
                case MdtaMetadataEntry.TYPE_INDICATOR_INT32 /* 67 */:
                    if (I(t11, iU, length)) {
                        writer.p(iU, a0(t11, V(iS0)));
                    }
                    break;
                case 68:
                    if (I(t11, iU, length)) {
                        writer.i(iU, l1.G(t11, V(iS0)), v(length));
                    }
                    break;
            }
        }
        while (entry != null) {
            this.f41407p.j(writer, entry);
            entry = itG.hasNext() ? (Map.Entry) itG.next() : null;
        }
    }

    public final <K, V> void w0(Writer writer, int i11, Object obj, int i12) throws IOException {
        if (obj != null) {
            writer.G(i11, this.f41408q.b(u(i12)), this.f41408q.e(obj));
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:26:0x0079 A[PHI: r6
  0x0079: PHI (r6v4 int) = 
  (r6v1 int)
  (r6v1 int)
  (r6v1 int)
  (r6v1 int)
  (r6v1 int)
  (r6v1 int)
  (r6v1 int)
  (r6v1 int)
  (r6v1 int)
  (r6v1 int)
  (r6v1 int)
  (r6v1 int)
  (r6v1 int)
  (r6v1 int)
  (r6v1 int)
  (r6v1 int)
  (r6v1 int)
  (r6v1 int)
  (r6v1 int)
  (r6v1 int)
  (r6v1 int)
  (r6v1 int)
  (r6v1 int)
  (r6v1 int)
  (r6v1 int)
  (r6v1 int)
  (r6v1 int)
  (r6v1 int)
  (r6v1 int)
  (r6v1 int)
  (r6v1 int)
  (r6v1 int)
  (r6v1 int)
  (r6v1 int)
  (r6v1 int)
  (r6v1 int)
  (r6v1 int)
  (r6v1 int)
  (r6v1 int)
  (r6v1 int)
  (r6v7 int)
  (r6v1 int)
  (r6v1 int)
  (r6v1 int)
  (r6v1 int)
  (r6v8 int)
  (r6v1 int)
 binds: [B:20:0x0060, B:223:0x04cd, B:220:0x04c2, B:214:0x04a6, B:211:0x0494, B:208:0x0484, B:205:0x0476, B:202:0x0468, B:199:0x045d, B:196:0x0453, B:193:0x0445, B:190:0x0437, B:187:0x0423, B:164:0x032f, B:158:0x0311, B:152:0x02f3, B:146:0x02d5, B:140:0x02b7, B:134:0x0299, B:128:0x027b, B:122:0x025d, B:116:0x023f, B:110:0x0222, B:104:0x0205, B:98:0x01e8, B:92:0x01cb, B:85:0x01ab, B:80:0x0177, B:77:0x016b, B:74:0x015b, B:71:0x014b, B:68:0x013b, B:65:0x012f, B:62:0x0123, B:59:0x0116, B:53:0x00f8, B:50:0x00e5, B:47:0x00d4, B:44:0x00c5, B:41:0x00b6, B:39:0x00b0, B:37:0x00a9, B:34:0x009e, B:31:0x008f, B:28:0x0080, B:25:0x0078, B:23:0x0068] A[DONT_GENERATE, DONT_INLINE]] */
    public final int x(T t11) {
        int i11;
        int i12;
        int iJ;
        int iE;
        int iL;
        int i13;
        int iV;
        int iX;
        Unsafe unsafe = f41391s;
        int i14 = 1048575;
        int i15 = 0;
        int i16 = 0;
        int i17 = 1048575;
        int i18 = 0;
        while (i15 < this.f41392a.length) {
            int iS0 = s0(i15);
            int iU = U(i15);
            int iR0 = r0(iS0);
            if (iR0 <= 17) {
                i11 = this.f41392a[i15 + 2];
                int i19 = i11 & i14;
                i12 = 1 << (i11 >>> 20);
                if (i19 != i17) {
                    i18 = unsafe.getInt(t11, i19);
                    i17 = i19;
                }
            } else {
                i11 = (!this.f41400i || iR0 < FieldType.DOUBLE_LIST_PACKED.id() || iR0 > FieldType.SINT64_LIST_PACKED.id()) ? 0 : this.f41392a[i15 + 2] & i14;
                i12 = 0;
            }
            long jV = V(iS0);
            switch (iR0) {
                case 0:
                    if ((i18 & i12) != 0) {
                        iJ = CodedOutputStream.j(iU, 0.0d);
                        i16 += iJ;
                    }
                    break;
                case 1:
                    if ((i18 & i12) != 0) {
                        iJ = CodedOutputStream.r(iU, 0.0f);
                        i16 += iJ;
                    }
                    break;
                case 2:
                    if ((i18 & i12) != 0) {
                        iJ = CodedOutputStream.y(iU, unsafe.getLong(t11, jV));
                        i16 += iJ;
                    }
                    break;
                case 3:
                    if ((i18 & i12) != 0) {
                        iJ = CodedOutputStream.Y(iU, unsafe.getLong(t11, jV));
                        i16 += iJ;
                    }
                    break;
                case 4:
                    if ((i18 & i12) != 0) {
                        iJ = CodedOutputStream.w(iU, unsafe.getInt(t11, jV));
                        i16 += iJ;
                    }
                    break;
                case 5:
                    if ((i18 & i12) != 0) {
                        iJ = CodedOutputStream.p(iU, 0L);
                        i16 += iJ;
                    }
                    break;
                case 6:
                    if ((i18 & i12) != 0) {
                        iJ = CodedOutputStream.n(iU, 0);
                        i16 += iJ;
                    }
                    break;
                case 7:
                    if ((i18 & i12) != 0) {
                        iE = CodedOutputStream.e(iU, true);
                        i16 += iE;
                    }
                    break;
                case 8:
                    if ((i18 & i12) != 0) {
                        Object object = unsafe.getObject(t11, jV);
                        iE = object instanceof ByteString ? CodedOutputStream.h(iU, (ByteString) object) : CodedOutputStream.T(iU, (String) object);
                        i16 += iE;
                    }
                    break;
                case 9:
                    if ((i18 & i12) != 0) {
                        iE = d1.o(iU, unsafe.getObject(t11, jV), v(i15));
                        i16 += iE;
                    }
                    break;
                case 10:
                    if ((i18 & i12) != 0) {
                        iE = CodedOutputStream.h(iU, (ByteString) unsafe.getObject(t11, jV));
                        i16 += iE;
                    }
                    break;
                case 11:
                    if ((i18 & i12) != 0) {
                        iE = CodedOutputStream.W(iU, unsafe.getInt(t11, jV));
                        i16 += iE;
                    }
                    break;
                case 12:
                    if ((i18 & i12) != 0) {
                        iE = CodedOutputStream.l(iU, unsafe.getInt(t11, jV));
                        i16 += iE;
                    }
                    break;
                case 13:
                    if ((i18 & i12) != 0) {
                        iL = CodedOutputStream.L(iU, 0);
                        i16 += iL;
                    }
                    break;
                case 14:
                    if ((i18 & i12) != 0) {
                        iE = CodedOutputStream.N(iU, 0L);
                        i16 += iE;
                    }
                    break;
                case 15:
                    if ((i18 & i12) != 0) {
                        iE = CodedOutputStream.P(iU, unsafe.getInt(t11, jV));
                        i16 += iE;
                    }
                    break;
                case 16:
                    if ((i18 & i12) != 0) {
                        iE = CodedOutputStream.R(iU, unsafe.getLong(t11, jV));
                        i16 += iE;
                    }
                    break;
                case 17:
                    if ((i18 & i12) != 0) {
                        iE = CodedOutputStream.t(iU, (n0) unsafe.getObject(t11, jV), v(i15));
                        i16 += iE;
                    }
                    break;
                case 18:
                    iE = d1.h(iU, (List) unsafe.getObject(t11, jV), false);
                    i16 += iE;
                    break;
                case 19:
                    iE = d1.f(iU, (List) unsafe.getObject(t11, jV), false);
                    i16 += iE;
                    break;
                case 20:
                    iE = d1.m(iU, (List) unsafe.getObject(t11, jV), false);
                    i16 += iE;
                    break;
                case 21:
                    iE = d1.x(iU, (List) unsafe.getObject(t11, jV), false);
                    i16 += iE;
                    break;
                case 22:
                    iE = d1.k(iU, (List) unsafe.getObject(t11, jV), false);
                    i16 += iE;
                    break;
                case 23:
                    iE = d1.h(iU, (List) unsafe.getObject(t11, jV), false);
                    i16 += iE;
                    break;
                case 24:
                    iE = d1.f(iU, (List) unsafe.getObject(t11, jV), false);
                    i16 += iE;
                    break;
                case 25:
                    iE = d1.a(iU, (List) unsafe.getObject(t11, jV), false);
                    i16 += iE;
                    break;
                case 26:
                    iE = d1.u(iU, (List) unsafe.getObject(t11, jV));
                    i16 += iE;
                    break;
                case 27:
                    iE = d1.p(iU, (List) unsafe.getObject(t11, jV), v(i15));
                    i16 += iE;
                    break;
                case 28:
                    iE = d1.c(iU, (List) unsafe.getObject(t11, jV));
                    i16 += iE;
                    break;
                case VungleException.INCORRECT_DEFAULT_API_USAGE /* 29 */:
                    iE = d1.v(iU, (List) unsafe.getObject(t11, jV), false);
                    i16 += iE;
                    break;
                case 30:
                    iE = d1.d(iU, (List) unsafe.getObject(t11, jV), false);
                    i16 += iE;
                    break;
                case VungleException.WEB_CRASH /* 31 */:
                    iE = d1.f(iU, (List) unsafe.getObject(t11, jV), false);
                    i16 += iE;
                    break;
                case 32:
                    iE = d1.h(iU, (List) unsafe.getObject(t11, jV), false);
                    i16 += iE;
                    break;
                case 33:
                    iE = d1.q(iU, (List) unsafe.getObject(t11, jV), false);
                    i16 += iE;
                    break;
                case 34:
                    iE = d1.s(iU, (List) unsafe.getObject(t11, jV), false);
                    i16 += iE;
                    break;
                case 35:
                    i13 = d1.i((List) unsafe.getObject(t11, jV));
                    if (i13 > 0) {
                        if (this.f41400i) {
                            unsafe.putInt(t11, i11, i13);
                        }
                        iV = CodedOutputStream.V(iU);
                        iX = CodedOutputStream.X(i13);
                        iL = iV + iX + i13;
                        i16 += iL;
                    }
                    break;
                case 36:
                    i13 = d1.g((List) unsafe.getObject(t11, jV));
                    if (i13 > 0) {
                        if (this.f41400i) {
                            unsafe.putInt(t11, i11, i13);
                        }
                        iV = CodedOutputStream.V(iU);
                        iX = CodedOutputStream.X(i13);
                        iL = iV + iX + i13;
                        i16 += iL;
                    }
                    break;
                case 37:
                    i13 = d1.n((List) unsafe.getObject(t11, jV));
                    if (i13 > 0) {
                        if (this.f41400i) {
                            unsafe.putInt(t11, i11, i13);
                        }
                        iV = CodedOutputStream.V(iU);
                        iX = CodedOutputStream.X(i13);
                        iL = iV + iX + i13;
                        i16 += iL;
                    }
                    break;
                case 38:
                    i13 = d1.y((List) unsafe.getObject(t11, jV));
                    if (i13 > 0) {
                        if (this.f41400i) {
                            unsafe.putInt(t11, i11, i13);
                        }
                        iV = CodedOutputStream.V(iU);
                        iX = CodedOutputStream.X(i13);
                        iL = iV + iX + i13;
                        i16 += iL;
                    }
                    break;
                case 39:
                    i13 = d1.l((List) unsafe.getObject(t11, jV));
                    if (i13 > 0) {
                        if (this.f41400i) {
                            unsafe.putInt(t11, i11, i13);
                        }
                        iV = CodedOutputStream.V(iU);
                        iX = CodedOutputStream.X(i13);
                        iL = iV + iX + i13;
                        i16 += iL;
                    }
                    break;
                case 40:
                    i13 = d1.i((List) unsafe.getObject(t11, jV));
                    if (i13 > 0) {
                        if (this.f41400i) {
                            unsafe.putInt(t11, i11, i13);
                        }
                        iV = CodedOutputStream.V(iU);
                        iX = CodedOutputStream.X(i13);
                        iL = iV + iX + i13;
                        i16 += iL;
                    }
                    break;
                case 41:
                    i13 = d1.g((List) unsafe.getObject(t11, jV));
                    if (i13 > 0) {
                        if (this.f41400i) {
                            unsafe.putInt(t11, i11, i13);
                        }
                        iV = CodedOutputStream.V(iU);
                        iX = CodedOutputStream.X(i13);
                        iL = iV + iX + i13;
                        i16 += iL;
                    }
                    break;
                case MotionEventCompat.AXIS_GENERIC_11 /* 42 */:
                    i13 = d1.b((List) unsafe.getObject(t11, jV));
                    if (i13 > 0) {
                        if (this.f41400i) {
                            unsafe.putInt(t11, i11, i13);
                        }
                        iV = CodedOutputStream.V(iU);
                        iX = CodedOutputStream.X(i13);
                        iL = iV + iX + i13;
                        i16 += iL;
                    }
                    break;
                case MotionEventCompat.AXIS_GENERIC_12 /* 43 */:
                    i13 = d1.w((List) unsafe.getObject(t11, jV));
                    if (i13 > 0) {
                        if (this.f41400i) {
                            unsafe.putInt(t11, i11, i13);
                        }
                        iV = CodedOutputStream.V(iU);
                        iX = CodedOutputStream.X(i13);
                        iL = iV + iX + i13;
                        i16 += iL;
                    }
                    break;
                case MotionEventCompat.AXIS_GENERIC_13 /* 44 */:
                    i13 = d1.e((List) unsafe.getObject(t11, jV));
                    if (i13 > 0) {
                        if (this.f41400i) {
                            unsafe.putInt(t11, i11, i13);
                        }
                        iV = CodedOutputStream.V(iU);
                        iX = CodedOutputStream.X(i13);
                        iL = iV + iX + i13;
                        i16 += iL;
                    }
                    break;
                case MotionEventCompat.AXIS_GENERIC_14 /* 45 */:
                    i13 = d1.g((List) unsafe.getObject(t11, jV));
                    if (i13 > 0) {
                        if (this.f41400i) {
                            unsafe.putInt(t11, i11, i13);
                        }
                        iV = CodedOutputStream.V(iU);
                        iX = CodedOutputStream.X(i13);
                        iL = iV + iX + i13;
                        i16 += iL;
                    }
                    break;
                case MotionEventCompat.AXIS_GENERIC_15 /* 46 */:
                    i13 = d1.i((List) unsafe.getObject(t11, jV));
                    if (i13 > 0) {
                        if (this.f41400i) {
                            unsafe.putInt(t11, i11, i13);
                        }
                        iV = CodedOutputStream.V(iU);
                        iX = CodedOutputStream.X(i13);
                        iL = iV + iX + i13;
                        i16 += iL;
                    }
                    break;
                case MotionEventCompat.AXIS_GENERIC_16 /* 47 */:
                    i13 = d1.r((List) unsafe.getObject(t11, jV));
                    if (i13 > 0) {
                        if (this.f41400i) {
                            unsafe.putInt(t11, i11, i13);
                        }
                        iV = CodedOutputStream.V(iU);
                        iX = CodedOutputStream.X(i13);
                        iL = iV + iX + i13;
                        i16 += iL;
                    }
                    break;
                case 48:
                    i13 = d1.t((List) unsafe.getObject(t11, jV));
                    if (i13 > 0) {
                        if (this.f41400i) {
                            unsafe.putInt(t11, i11, i13);
                        }
                        iV = CodedOutputStream.V(iU);
                        iX = CodedOutputStream.X(i13);
                        iL = iV + iX + i13;
                        i16 += iL;
                    }
                    break;
                case 49:
                    iE = d1.j(iU, (List) unsafe.getObject(t11, jV), v(i15));
                    i16 += iE;
                    break;
                case 50:
                    iE = this.f41408q.g(iU, unsafe.getObject(t11, jV), u(i15));
                    i16 += iE;
                    break;
                case 51:
                    if (I(t11, iU, i15)) {
                        iE = CodedOutputStream.j(iU, 0.0d);
                        i16 += iE;
                    }
                    break;
                case 52:
                    if (I(t11, iU, i15)) {
                        iE = CodedOutputStream.r(iU, 0.0f);
                        i16 += iE;
                    }
                    break;
                case 53:
                    if (I(t11, iU, i15)) {
                        iE = CodedOutputStream.y(iU, a0(t11, jV));
                        i16 += iE;
                    }
                    break;
                case 54:
                    if (I(t11, iU, i15)) {
                        iE = CodedOutputStream.Y(iU, a0(t11, jV));
                        i16 += iE;
                    }
                    break;
                case 55:
                    if (I(t11, iU, i15)) {
                        iE = CodedOutputStream.w(iU, Z(t11, jV));
                        i16 += iE;
                    }
                    break;
                case 56:
                    if (I(t11, iU, i15)) {
                        iE = CodedOutputStream.p(iU, 0L);
                        i16 += iE;
                    }
                    break;
                case DownloadBean.STATUS_COMPLETED_REMOVED /* 57 */:
                    if (I(t11, iU, i15)) {
                        iL = CodedOutputStream.n(iU, 0);
                        i16 += iL;
                    }
                    break;
                case 58:
                    if (I(t11, iU, i15)) {
                        iE = CodedOutputStream.e(iU, true);
                        i16 += iE;
                    }
                    break;
                case 59:
                    if (I(t11, iU, i15)) {
                        Object object2 = unsafe.getObject(t11, jV);
                        iE = object2 instanceof ByteString ? CodedOutputStream.h(iU, (ByteString) object2) : CodedOutputStream.T(iU, (String) object2);
                        i16 += iE;
                    }
                    break;
                case 60:
                    if (I(t11, iU, i15)) {
                        iE = d1.o(iU, unsafe.getObject(t11, jV), v(i15));
                        i16 += iE;
                    }
                    break;
                case 61:
                    if (I(t11, iU, i15)) {
                        iE = CodedOutputStream.h(iU, (ByteString) unsafe.getObject(t11, jV));
                        i16 += iE;
                    }
                    break;
                case 62:
                    if (I(t11, iU, i15)) {
                        iE = CodedOutputStream.W(iU, Z(t11, jV));
                        i16 += iE;
                    }
                    break;
                case 63:
                    if (I(t11, iU, i15)) {
                        iE = CodedOutputStream.l(iU, Z(t11, jV));
                        i16 += iE;
                    }
                    break;
                case 64:
                    if (I(t11, iU, i15)) {
                        iL = CodedOutputStream.L(iU, 0);
                        i16 += iL;
                    }
                    break;
                case RegisterRequest.U2F_V1_CHALLENGE_BYTE_LENGTH /* 65 */:
                    if (I(t11, iU, i15)) {
                        iE = CodedOutputStream.N(iU, 0L);
                        i16 += iE;
                    }
                    break;
                case 66:
                    if (I(t11, iU, i15)) {
                        iE = CodedOutputStream.P(iU, Z(t11, jV));
                        i16 += iE;
                    }
                    break;
                case MdtaMetadataEntry.TYPE_INDICATOR_INT32 /* 67 */:
                    if (I(t11, iU, i15)) {
                        iE = CodedOutputStream.R(iU, a0(t11, jV));
                        i16 += iE;
                    }
                    break;
                case 68:
                    if (I(t11, iU, i15)) {
                        iE = CodedOutputStream.t(iU, (n0) unsafe.getObject(t11, jV), v(i15));
                        i16 += iE;
                    }
                    break;
                default:
                    break;
            }
            i15 += 3;
            i14 = 1048575;
        }
        int iZ = i16 + z(this.f41406o, t11);
        return this.f41397f ? iZ + this.f41407p.c(t11).l() : iZ;
    }

    public final void x0(int i11, Object obj, Writer writer) throws IOException {
        if (obj instanceof String) {
            writer.f(i11, (String) obj);
        } else {
            writer.j(i11, (ByteString) obj);
        }
    }

    public final int y(T t11) {
        int iJ;
        int i11;
        int iV;
        int iX;
        Unsafe unsafe = f41391s;
        int i12 = 0;
        for (int i13 = 0; i13 < this.f41392a.length; i13 += 3) {
            int iS0 = s0(i13);
            int iR0 = r0(iS0);
            int iU = U(i13);
            long jV = V(iS0);
            int i14 = (iR0 < FieldType.DOUBLE_LIST_PACKED.id() || iR0 > FieldType.SINT64_LIST_PACKED.id()) ? 0 : this.f41392a[i13 + 2] & 1048575;
            switch (iR0) {
                case 0:
                    if (C(t11, i13)) {
                        iJ = CodedOutputStream.j(iU, 0.0d);
                        i12 += iJ;
                    }
                    break;
                case 1:
                    if (C(t11, i13)) {
                        iJ = CodedOutputStream.r(iU, 0.0f);
                        i12 += iJ;
                    }
                    break;
                case 2:
                    if (C(t11, i13)) {
                        iJ = CodedOutputStream.y(iU, l1.E(t11, jV));
                        i12 += iJ;
                    }
                    break;
                case 3:
                    if (C(t11, i13)) {
                        iJ = CodedOutputStream.Y(iU, l1.E(t11, jV));
                        i12 += iJ;
                    }
                    break;
                case 4:
                    if (C(t11, i13)) {
                        iJ = CodedOutputStream.w(iU, l1.C(t11, jV));
                        i12 += iJ;
                    }
                    break;
                case 5:
                    if (C(t11, i13)) {
                        iJ = CodedOutputStream.p(iU, 0L);
                        i12 += iJ;
                    }
                    break;
                case 6:
                    if (C(t11, i13)) {
                        iJ = CodedOutputStream.n(iU, 0);
                        i12 += iJ;
                    }
                    break;
                case 7:
                    if (C(t11, i13)) {
                        iJ = CodedOutputStream.e(iU, true);
                        i12 += iJ;
                    }
                    break;
                case 8:
                    if (C(t11, i13)) {
                        Object objG = l1.G(t11, jV);
                        iJ = objG instanceof ByteString ? CodedOutputStream.h(iU, (ByteString) objG) : CodedOutputStream.T(iU, (String) objG);
                        i12 += iJ;
                    }
                    break;
                case 9:
                    if (C(t11, i13)) {
                        iJ = d1.o(iU, l1.G(t11, jV), v(i13));
                        i12 += iJ;
                    }
                    break;
                case 10:
                    if (C(t11, i13)) {
                        iJ = CodedOutputStream.h(iU, (ByteString) l1.G(t11, jV));
                        i12 += iJ;
                    }
                    break;
                case 11:
                    if (C(t11, i13)) {
                        iJ = CodedOutputStream.W(iU, l1.C(t11, jV));
                        i12 += iJ;
                    }
                    break;
                case 12:
                    if (C(t11, i13)) {
                        iJ = CodedOutputStream.l(iU, l1.C(t11, jV));
                        i12 += iJ;
                    }
                    break;
                case 13:
                    if (C(t11, i13)) {
                        iJ = CodedOutputStream.L(iU, 0);
                        i12 += iJ;
                    }
                    break;
                case 14:
                    if (C(t11, i13)) {
                        iJ = CodedOutputStream.N(iU, 0L);
                        i12 += iJ;
                    }
                    break;
                case 15:
                    if (C(t11, i13)) {
                        iJ = CodedOutputStream.P(iU, l1.C(t11, jV));
                        i12 += iJ;
                    }
                    break;
                case 16:
                    if (C(t11, i13)) {
                        iJ = CodedOutputStream.R(iU, l1.E(t11, jV));
                        i12 += iJ;
                    }
                    break;
                case 17:
                    if (C(t11, i13)) {
                        iJ = CodedOutputStream.t(iU, (n0) l1.G(t11, jV), v(i13));
                        i12 += iJ;
                    }
                    break;
                case 18:
                    iJ = d1.h(iU, K(t11, jV), false);
                    i12 += iJ;
                    break;
                case 19:
                    iJ = d1.f(iU, K(t11, jV), false);
                    i12 += iJ;
                    break;
                case 20:
                    iJ = d1.m(iU, K(t11, jV), false);
                    i12 += iJ;
                    break;
                case 21:
                    iJ = d1.x(iU, K(t11, jV), false);
                    i12 += iJ;
                    break;
                case 22:
                    iJ = d1.k(iU, K(t11, jV), false);
                    i12 += iJ;
                    break;
                case 23:
                    iJ = d1.h(iU, K(t11, jV), false);
                    i12 += iJ;
                    break;
                case 24:
                    iJ = d1.f(iU, K(t11, jV), false);
                    i12 += iJ;
                    break;
                case 25:
                    iJ = d1.a(iU, K(t11, jV), false);
                    i12 += iJ;
                    break;
                case 26:
                    iJ = d1.u(iU, K(t11, jV));
                    i12 += iJ;
                    break;
                case 27:
                    iJ = d1.p(iU, K(t11, jV), v(i13));
                    i12 += iJ;
                    break;
                case 28:
                    iJ = d1.c(iU, K(t11, jV));
                    i12 += iJ;
                    break;
                case VungleException.INCORRECT_DEFAULT_API_USAGE /* 29 */:
                    iJ = d1.v(iU, K(t11, jV), false);
                    i12 += iJ;
                    break;
                case 30:
                    iJ = d1.d(iU, K(t11, jV), false);
                    i12 += iJ;
                    break;
                case VungleException.WEB_CRASH /* 31 */:
                    iJ = d1.f(iU, K(t11, jV), false);
                    i12 += iJ;
                    break;
                case 32:
                    iJ = d1.h(iU, K(t11, jV), false);
                    i12 += iJ;
                    break;
                case 33:
                    iJ = d1.q(iU, K(t11, jV), false);
                    i12 += iJ;
                    break;
                case 34:
                    iJ = d1.s(iU, K(t11, jV), false);
                    i12 += iJ;
                    break;
                case 35:
                    i11 = d1.i((List) unsafe.getObject(t11, jV));
                    if (i11 > 0) {
                        if (this.f41400i) {
                            unsafe.putInt(t11, i14, i11);
                        }
                        iV = CodedOutputStream.V(iU);
                        iX = CodedOutputStream.X(i11);
                        iJ = iV + iX + i11;
                        i12 += iJ;
                    }
                    break;
                case 36:
                    i11 = d1.g((List) unsafe.getObject(t11, jV));
                    if (i11 > 0) {
                        if (this.f41400i) {
                            unsafe.putInt(t11, i14, i11);
                        }
                        iV = CodedOutputStream.V(iU);
                        iX = CodedOutputStream.X(i11);
                        iJ = iV + iX + i11;
                        i12 += iJ;
                    }
                    break;
                case 37:
                    i11 = d1.n((List) unsafe.getObject(t11, jV));
                    if (i11 > 0) {
                        if (this.f41400i) {
                            unsafe.putInt(t11, i14, i11);
                        }
                        iV = CodedOutputStream.V(iU);
                        iX = CodedOutputStream.X(i11);
                        iJ = iV + iX + i11;
                        i12 += iJ;
                    }
                    break;
                case 38:
                    i11 = d1.y((List) unsafe.getObject(t11, jV));
                    if (i11 > 0) {
                        if (this.f41400i) {
                            unsafe.putInt(t11, i14, i11);
                        }
                        iV = CodedOutputStream.V(iU);
                        iX = CodedOutputStream.X(i11);
                        iJ = iV + iX + i11;
                        i12 += iJ;
                    }
                    break;
                case 39:
                    i11 = d1.l((List) unsafe.getObject(t11, jV));
                    if (i11 > 0) {
                        if (this.f41400i) {
                            unsafe.putInt(t11, i14, i11);
                        }
                        iV = CodedOutputStream.V(iU);
                        iX = CodedOutputStream.X(i11);
                        iJ = iV + iX + i11;
                        i12 += iJ;
                    }
                    break;
                case 40:
                    i11 = d1.i((List) unsafe.getObject(t11, jV));
                    if (i11 > 0) {
                        if (this.f41400i) {
                            unsafe.putInt(t11, i14, i11);
                        }
                        iV = CodedOutputStream.V(iU);
                        iX = CodedOutputStream.X(i11);
                        iJ = iV + iX + i11;
                        i12 += iJ;
                    }
                    break;
                case 41:
                    i11 = d1.g((List) unsafe.getObject(t11, jV));
                    if (i11 > 0) {
                        if (this.f41400i) {
                            unsafe.putInt(t11, i14, i11);
                        }
                        iV = CodedOutputStream.V(iU);
                        iX = CodedOutputStream.X(i11);
                        iJ = iV + iX + i11;
                        i12 += iJ;
                    }
                    break;
                case MotionEventCompat.AXIS_GENERIC_11 /* 42 */:
                    i11 = d1.b((List) unsafe.getObject(t11, jV));
                    if (i11 > 0) {
                        if (this.f41400i) {
                            unsafe.putInt(t11, i14, i11);
                        }
                        iV = CodedOutputStream.V(iU);
                        iX = CodedOutputStream.X(i11);
                        iJ = iV + iX + i11;
                        i12 += iJ;
                    }
                    break;
                case MotionEventCompat.AXIS_GENERIC_12 /* 43 */:
                    i11 = d1.w((List) unsafe.getObject(t11, jV));
                    if (i11 > 0) {
                        if (this.f41400i) {
                            unsafe.putInt(t11, i14, i11);
                        }
                        iV = CodedOutputStream.V(iU);
                        iX = CodedOutputStream.X(i11);
                        iJ = iV + iX + i11;
                        i12 += iJ;
                    }
                    break;
                case MotionEventCompat.AXIS_GENERIC_13 /* 44 */:
                    i11 = d1.e((List) unsafe.getObject(t11, jV));
                    if (i11 > 0) {
                        if (this.f41400i) {
                            unsafe.putInt(t11, i14, i11);
                        }
                        iV = CodedOutputStream.V(iU);
                        iX = CodedOutputStream.X(i11);
                        iJ = iV + iX + i11;
                        i12 += iJ;
                    }
                    break;
                case MotionEventCompat.AXIS_GENERIC_14 /* 45 */:
                    i11 = d1.g((List) unsafe.getObject(t11, jV));
                    if (i11 > 0) {
                        if (this.f41400i) {
                            unsafe.putInt(t11, i14, i11);
                        }
                        iV = CodedOutputStream.V(iU);
                        iX = CodedOutputStream.X(i11);
                        iJ = iV + iX + i11;
                        i12 += iJ;
                    }
                    break;
                case MotionEventCompat.AXIS_GENERIC_15 /* 46 */:
                    i11 = d1.i((List) unsafe.getObject(t11, jV));
                    if (i11 > 0) {
                        if (this.f41400i) {
                            unsafe.putInt(t11, i14, i11);
                        }
                        iV = CodedOutputStream.V(iU);
                        iX = CodedOutputStream.X(i11);
                        iJ = iV + iX + i11;
                        i12 += iJ;
                    }
                    break;
                case MotionEventCompat.AXIS_GENERIC_16 /* 47 */:
                    i11 = d1.r((List) unsafe.getObject(t11, jV));
                    if (i11 > 0) {
                        if (this.f41400i) {
                            unsafe.putInt(t11, i14, i11);
                        }
                        iV = CodedOutputStream.V(iU);
                        iX = CodedOutputStream.X(i11);
                        iJ = iV + iX + i11;
                        i12 += iJ;
                    }
                    break;
                case 48:
                    i11 = d1.t((List) unsafe.getObject(t11, jV));
                    if (i11 > 0) {
                        if (this.f41400i) {
                            unsafe.putInt(t11, i14, i11);
                        }
                        iV = CodedOutputStream.V(iU);
                        iX = CodedOutputStream.X(i11);
                        iJ = iV + iX + i11;
                        i12 += iJ;
                    }
                    break;
                case 49:
                    iJ = d1.j(iU, K(t11, jV), v(i13));
                    i12 += iJ;
                    break;
                case 50:
                    iJ = this.f41408q.g(iU, l1.G(t11, jV), u(i13));
                    i12 += iJ;
                    break;
                case 51:
                    if (I(t11, iU, i13)) {
                        iJ = CodedOutputStream.j(iU, 0.0d);
                        i12 += iJ;
                    }
                    break;
                case 52:
                    if (I(t11, iU, i13)) {
                        iJ = CodedOutputStream.r(iU, 0.0f);
                        i12 += iJ;
                    }
                    break;
                case 53:
                    if (I(t11, iU, i13)) {
                        iJ = CodedOutputStream.y(iU, a0(t11, jV));
                        i12 += iJ;
                    }
                    break;
                case 54:
                    if (I(t11, iU, i13)) {
                        iJ = CodedOutputStream.Y(iU, a0(t11, jV));
                        i12 += iJ;
                    }
                    break;
                case 55:
                    if (I(t11, iU, i13)) {
                        iJ = CodedOutputStream.w(iU, Z(t11, jV));
                        i12 += iJ;
                    }
                    break;
                case 56:
                    if (I(t11, iU, i13)) {
                        iJ = CodedOutputStream.p(iU, 0L);
                        i12 += iJ;
                    }
                    break;
                case DownloadBean.STATUS_COMPLETED_REMOVED /* 57 */:
                    if (I(t11, iU, i13)) {
                        iJ = CodedOutputStream.n(iU, 0);
                        i12 += iJ;
                    }
                    break;
                case 58:
                    if (I(t11, iU, i13)) {
                        iJ = CodedOutputStream.e(iU, true);
                        i12 += iJ;
                    }
                    break;
                case 59:
                    if (I(t11, iU, i13)) {
                        Object objG2 = l1.G(t11, jV);
                        iJ = objG2 instanceof ByteString ? CodedOutputStream.h(iU, (ByteString) objG2) : CodedOutputStream.T(iU, (String) objG2);
                        i12 += iJ;
                    }
                    break;
                case 60:
                    if (I(t11, iU, i13)) {
                        iJ = d1.o(iU, l1.G(t11, jV), v(i13));
                        i12 += iJ;
                    }
                    break;
                case 61:
                    if (I(t11, iU, i13)) {
                        iJ = CodedOutputStream.h(iU, (ByteString) l1.G(t11, jV));
                        i12 += iJ;
                    }
                    break;
                case 62:
                    if (I(t11, iU, i13)) {
                        iJ = CodedOutputStream.W(iU, Z(t11, jV));
                        i12 += iJ;
                    }
                    break;
                case 63:
                    if (I(t11, iU, i13)) {
                        iJ = CodedOutputStream.l(iU, Z(t11, jV));
                        i12 += iJ;
                    }
                    break;
                case 64:
                    if (I(t11, iU, i13)) {
                        iJ = CodedOutputStream.L(iU, 0);
                        i12 += iJ;
                    }
                    break;
                case RegisterRequest.U2F_V1_CHALLENGE_BYTE_LENGTH /* 65 */:
                    if (I(t11, iU, i13)) {
                        iJ = CodedOutputStream.N(iU, 0L);
                        i12 += iJ;
                    }
                    break;
                case 66:
                    if (I(t11, iU, i13)) {
                        iJ = CodedOutputStream.P(iU, Z(t11, jV));
                        i12 += iJ;
                    }
                    break;
                case MdtaMetadataEntry.TYPE_INDICATOR_INT32 /* 67 */:
                    if (I(t11, iU, i13)) {
                        iJ = CodedOutputStream.R(iU, a0(t11, jV));
                        i12 += iJ;
                    }
                    break;
                case 68:
                    if (I(t11, iU, i13)) {
                        iJ = CodedOutputStream.t(iU, (n0) l1.G(t11, jV), v(i13));
                        i12 += iJ;
                    }
                    break;
            }
        }
        return i12 + z(this.f41406o, t11);
    }

    public final <UT, UB> void y0(h1<UT, UB> h1Var, T t11, Writer writer) throws IOException {
        h1Var.t(h1Var.g(t11), writer);
    }

    public final <UT, UB> int z(h1<UT, UB> h1Var, T t11) {
        return h1Var.h(h1Var.g(t11));
    }
}
