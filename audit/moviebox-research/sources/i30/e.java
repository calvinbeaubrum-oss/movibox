package i30;

import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import androidx.media3.container.MdtaMetadataEntry;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.applovin.exoplayer2.common.base.Ascii;
import com.google.android.gms.fido.u2f.api.common.RegisterRequest;
import com.tn.lib.view.FlowLayout;
import okio.Utf8;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f66922a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int[] f66923b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String[] f66924c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final h[] f66925d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int[] f66926e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f66927f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f66928g;

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:19:0x0061 A[PHI: r8
  0x0061: PHI (r8v3 int) = (r8v0 int), (r8v1 int), (r8v4 int) binds: [B:12:0x0050, B:23:0x006f, B:18:0x0060] A[DONT_GENERATE, DONT_INLINE]] */
    public e(byte[] bArr, int i11, boolean z11) {
        this.f66922a = bArr;
        if (z11) {
            int i12 = i11 + 6;
            if (B(i12) > 56) {
                throw new IllegalArgumentException("Unsupported class file major version " + ((int) B(i12)));
            }
        }
        int iH = H(i11 + 8);
        this.f66923b = new int[iH];
        this.f66924c = new String[iH];
        int i13 = i11 + 10;
        int i14 = 0;
        boolean z12 = false;
        boolean z13 = false;
        int i15 = 1;
        while (i15 < iH) {
            i15++;
            int i16 = i13 + 1;
            this.f66923b[i15] = i16;
            int iH2 = 3;
            switch (bArr[i13]) {
                case 1:
                    iH2 = 3 + H(i16);
                    if (iH2 > i14) {
                        i15 = i15;
                        i14 = iH2;
                    } else {
                        i15 = i15;
                    }
                    i13 += iH2;
                    break;
                case 2:
                case 13:
                case 14:
                default:
                    throw new IllegalArgumentException();
                case 3:
                case 4:
                case 9:
                case 10:
                case 11:
                case 12:
                    iH2 = 5;
                    i13 += iH2;
                    break;
                case 5:
                case 6:
                    i15 += 2;
                    iH2 = 9;
                    i13 += iH2;
                    break;
                case 7:
                case 8:
                case 16:
                case 19:
                case 20:
                    i15 = i15;
                    i13 += iH2;
                    break;
                case 15:
                    iH2 = 4;
                    i15 = i15;
                    i13 += iH2;
                    break;
                case 17:
                    z12 = true;
                    iH2 = 5;
                    i13 += iH2;
                    break;
                case 18:
                    z13 = true;
                    iH2 = 5;
                    i13 += iH2;
                    break;
            }
        }
        this.f66927f = i14;
        this.f66928g = i13;
        this.f66925d = z12 ? new h[iH] : null;
        this.f66926e = (z12 || z13) ? k(i14) : null;
    }

    public final void A(r rVar, i iVar, int i11, boolean z11) {
        int iR = i11 + 1;
        int i12 = this.f66922a[i11] & 255;
        rVar.a(i12, z11);
        char[] cArr = iVar.f66961c;
        for (int i13 = 0; i13 < i12; i13++) {
            int iH = H(iR);
            iR += 2;
            while (true) {
                int i14 = iH - 1;
                if (iH > 0) {
                    iR = r(rVar.z(i13, G(iR, cArr), z11), iR + 2, true, cArr);
                    iH = i14;
                }
            }
        }
    }

    public short B(int i11) {
        byte[] bArr = this.f66922a;
        return (short) ((bArr[i11 + 1] & 255) | ((bArr[i11] & 255) << 8));
    }

    public final int C(int i11, boolean z11, boolean z12, i iVar) {
        int iK;
        int i12;
        char[] cArr = iVar.f66961c;
        q[] qVarArr = iVar.f66965g;
        if (z11) {
            iK = i11 + 1;
            i12 = this.f66922a[i11] & 255;
        } else {
            iVar.f66971m = -1;
            iK = i11;
            i12 = 255;
        }
        iVar.f66974p = 0;
        if (i12 < 64) {
            iVar.f66972n = 3;
            iVar.f66976r = 0;
        } else if (i12 < 128) {
            i12 -= 64;
            iK = K(iK, iVar.f66977s, 0, cArr, qVarArr);
            iVar.f66972n = 4;
            iVar.f66976r = 1;
        } else {
            if (i12 < 247) {
                throw new IllegalArgumentException();
            }
            int iH = H(iK);
            int i13 = iK + 2;
            if (i12 == 247) {
                iK = K(i13, iVar.f66977s, 0, cArr, qVarArr);
                iVar.f66972n = 4;
                iVar.f66976r = 1;
            } else {
                if (i12 >= 248 && i12 < 251) {
                    iVar.f66972n = 2;
                    int i14 = 251 - i12;
                    iVar.f66974p = i14;
                    iVar.f66973o -= i14;
                    iVar.f66976r = 0;
                } else if (i12 == 251) {
                    iVar.f66972n = 3;
                    iVar.f66976r = 0;
                } else if (i12 < 255) {
                    int i15 = i12 - 251;
                    int i16 = z12 ? iVar.f66973o : 0;
                    iK = i13;
                    int i17 = i15;
                    while (i17 > 0) {
                        iK = K(iK, iVar.f66975q, i16, cArr, qVarArr);
                        i17--;
                        i16++;
                    }
                    iVar.f66972n = 1;
                    iVar.f66974p = i15;
                    iVar.f66973o += i15;
                    iVar.f66976r = 0;
                } else {
                    int iH2 = H(i13);
                    int iK2 = iK + 4;
                    iVar.f66972n = 0;
                    iVar.f66974p = iH2;
                    iVar.f66973o = iH2;
                    for (int i18 = 0; i18 < iH2; i18++) {
                        iK2 = K(iK2, iVar.f66975q, i18, cArr, qVarArr);
                    }
                    int iH3 = H(iK2);
                    iK = iK2 + 2;
                    iVar.f66976r = iH3;
                    for (int i19 = 0; i19 < iH3; i19++) {
                        iK = K(iK, iVar.f66977s, i19, cArr, qVarArr);
                    }
                }
                iK = i13;
            }
            i12 = iH;
        }
        int i21 = iVar.f66971m + i12 + 1;
        iVar.f66971m = i21;
        d(i21, qVarArr);
        return iK;
    }

    public final String D(int i11, char[] cArr) {
        return G(this.f66923b[H(i11)], cArr);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:17:0x006d  */
    /* JADX WARN: Code duplicated, block: B:18:0x0070  */
    public final int E(i iVar, int i11) {
        int i12;
        int i13;
        int iT = t(i11);
        int i14 = iT >>> 24;
        if (i14 != 0 && i14 != 1) {
            switch (i14) {
                case 16:
                case 17:
                case 18:
                case 23:
                    i12 = iT & InputDeviceCompat.SOURCE_ANY;
                    i13 = i11 + 3;
                    break;
                case 19:
                case 20:
                case 21:
                    i12 = iT & ViewCompat.MEASURED_STATE_MASK;
                    i13 = i11 + 1;
                    break;
                case 22:
                    i12 = iT & FlowLayout.SPACING_AUTO;
                    i13 = i11 + 2;
                    break;
                default:
                    switch (i14) {
                        case 64:
                        case RegisterRequest.U2F_V1_CHALLENGE_BYTE_LENGTH /* 65 */:
                            i12 = iT & ViewCompat.MEASURED_STATE_MASK;
                            int iH = H(i11 + 1);
                            i13 = i11 + 3;
                            iVar.f66968j = new q[iH];
                            iVar.f66969k = new q[iH];
                            iVar.f66970l = new int[iH];
                            for (int i15 = 0; i15 < iH; i15++) {
                                int iH2 = H(i13);
                                int iH3 = H(i13 + 2);
                                int iH4 = H(i13 + 4);
                                i13 += 6;
                                iVar.f66968j[i15] = d(iH2, iVar.f66965g);
                                iVar.f66969k[i15] = d(iH2 + iH3, iVar.f66965g);
                                iVar.f66970l[i15] = iH4;
                            }
                            break;
                        case 66:
                            i12 = iT & InputDeviceCompat.SOURCE_ANY;
                            i13 = i11 + 3;
                            break;
                        case MdtaMetadataEntry.TYPE_INDICATOR_INT32 /* 67 */:
                        case 68:
                        case 69:
                        case 70:
                            i12 = iT & ViewCompat.MEASURED_STATE_MASK;
                            i13 = i11 + 3;
                            break;
                        case 71:
                        case 72:
                        case 73:
                        case 74:
                        case 75:
                            i12 = iT & (-16776961);
                            i13 = i11 + 4;
                            break;
                        default:
                            throw new IllegalArgumentException();
                    }
                    break;
            }
        } else {
            i12 = iT & FlowLayout.SPACING_AUTO;
            i13 = i11 + 2;
        }
        iVar.f66966h = i12;
        int iL = l(i13);
        iVar.f66967i = iL == 0 ? null : new z(this.f66922a, i13);
        return i13 + 1 + (iL * 2);
    }

    /* JADX WARN: Code duplicated, block: B:15:0x004d A[FALL_THROUGH] */
    public final int[] F(r rVar, i iVar, int i11, boolean z11) {
        int i12;
        char[] cArr = iVar.f66961c;
        int iH = H(i11);
        int[] iArr = new int[iH];
        int iR = i11 + 2;
        for (int i13 = 0; i13 < iH; i13++) {
            iArr[i13] = iR;
            int iT = t(iR);
            int i14 = iT >>> 24;
            if (i14 != 23) {
                switch (i14) {
                    default:
                        switch (i14) {
                            case 64:
                            case RegisterRequest.U2F_V1_CHALLENGE_BYTE_LENGTH /* 65 */:
                                int iH2 = H(iR + 1);
                                i12 = iR + 3;
                                while (true) {
                                    int i15 = iH2 - 1;
                                    if (iH2 > 0) {
                                        int iH3 = H(i12);
                                        int iH4 = H(i12 + 2);
                                        i12 += 6;
                                        d(iH3, iVar.f66965g);
                                        d(iH3 + iH4, iVar.f66965g);
                                        iH2 = i15;
                                    }
                                    break;
                                }
                                break;
                            case 66:
                            case MdtaMetadataEntry.TYPE_INDICATOR_INT32 /* 67 */:
                            case 68:
                            case 69:
                            case 70:
                                break;
                            case 71:
                            case 72:
                            case 73:
                            case 74:
                            case 75:
                                i12 = iR + 4;
                                break;
                            default:
                                throw new IllegalArgumentException();
                        }
                    case 16:
                    case 17:
                    case 18:
                        i12 = iR + 3;
                        break;
                }
            } else {
                i12 = iR + 3;
            }
            int iL = l(i12);
            if (i14 == 66) {
                z zVar = iL != 0 ? new z(this.f66922a, i12) : null;
                int i16 = i12 + (iL * 2) + 1;
                iR = r(rVar.B(iT & InputDeviceCompat.SOURCE_ANY, zVar, G(i16, cArr), z11), i16 + 2, true, cArr);
            } else {
                iR = r(null, i12 + (iL * 2) + 3, true, cArr);
            }
        }
        return iArr;
    }

    public String G(int i11, char[] cArr) {
        int iH = H(i11);
        if (i11 == 0 || iH == 0) {
            return null;
        }
        return J(iH, cArr);
    }

    public int H(int i11) {
        byte[] bArr = this.f66922a;
        return (bArr[i11 + 1] & 255) | ((bArr[i11] & 255) << 8);
    }

    public final String I(int i11, int i12, char[] cArr) {
        int i13;
        int i14 = i12 + i11;
        byte[] bArr = this.f66922a;
        int i15 = 0;
        while (i11 < i14) {
            int i16 = i11 + 1;
            byte b11 = bArr[i11];
            if ((b11 & 128) == 0) {
                cArr[i15] = (char) (b11 & Ascii.DEL);
                i15++;
                i11 = i16;
            } else {
                if ((b11 & 224) == 192) {
                    i13 = i15 + 1;
                    i11 += 2;
                    cArr[i15] = (char) (((b11 & Ascii.US) << 6) + (bArr[i16] & Utf8.REPLACEMENT_BYTE));
                } else {
                    i13 = i15 + 1;
                    int i17 = i11 + 2;
                    i11 += 3;
                    cArr[i15] = (char) (((b11 & Ascii.SI) << 12) + ((bArr[i16] & Utf8.REPLACEMENT_BYTE) << 6) + (bArr[i17] & Utf8.REPLACEMENT_BYTE));
                }
                i15 = i13;
            }
        }
        return new String(cArr, 0, i15);
    }

    public final String J(int i11, char[] cArr) {
        String[] strArr = this.f66924c;
        String str = strArr[i11];
        if (str != null) {
            return str;
        }
        int i12 = this.f66923b[i11];
        String strI = I(i12 + 2, H(i12), cArr);
        strArr[i11] = strI;
        return strI;
    }

    public final int K(int i11, Object[] objArr, int i12, char[] cArr, q[] qVarArr) {
        int i13 = i11 + 1;
        switch (this.f66922a[i11] & 255) {
            case 0:
                objArr[i12] = v.f67076a;
                return i13;
            case 1:
                objArr[i12] = v.f67077b;
                return i13;
            case 2:
                objArr[i12] = v.f67078c;
                return i13;
            case 3:
                objArr[i12] = v.f67079d;
                return i13;
            case 4:
                objArr[i12] = v.f67080e;
                return i13;
            case 5:
                objArr[i12] = v.f67081f;
                return i13;
            case 6:
                objArr[i12] = v.f67082g;
                return i13;
            case 7:
                objArr[i12] = m(i13, cArr);
                break;
            case 8:
                objArr[i12] = d(H(i13), qVarArr);
                break;
            default:
                throw new IllegalArgumentException();
        }
        return i11 + 3;
    }

    public void a(f fVar, c[] cVarArr, int i11) {
        int i12;
        i iVar = new i();
        iVar.f66959a = cVarArr;
        iVar.f66960b = i11;
        char[] cArr = new char[this.f66927f];
        iVar.f66961c = cArr;
        int i13 = this.f66928g;
        int iH = H(i13);
        String strM = m(i13 + 2, cArr);
        String strM2 = m(i13 + 4, cArr);
        int iH2 = H(i13 + 6);
        String[] strArr = new String[iH2];
        int i14 = i13 + 8;
        for (int i15 = 0; i15 < iH2; i15++) {
            strArr[i15] = m(i14, cArr);
            i14 += 2;
        }
        int iE = e();
        int i16 = iH;
        int iH3 = H(iE - 2);
        String strI = null;
        String strG = null;
        int i17 = 0;
        String strG2 = null;
        int i18 = 0;
        String strM3 = null;
        String strM4 = null;
        int i19 = 0;
        int i21 = 0;
        int i22 = 0;
        int i23 = 0;
        int i24 = 0;
        int i25 = 0;
        c cVar = null;
        int i26 = 0;
        while (iH3 > 0) {
            String strG3 = G(iE, cArr);
            int iT = t(iE + 2);
            int i27 = iE + 6;
            String str = strI;
            if ("SourceFile".equals(strG3)) {
                i12 = i27;
                strG = G(i27, cArr);
            } else if ("InnerClasses".equals(strG3)) {
                i26 = i27;
                i12 = i26;
            } else if ("EnclosingMethod".equals(strG3)) {
                i19 = i27;
                i12 = i19;
            } else if ("NestHost".equals(strG3)) {
                i12 = i27;
                strM4 = m(i27, cArr);
            } else if ("NestMembers".equals(strG3)) {
                i25 = i27;
                i12 = i25;
            } else {
                if (RequestParameters.SIGNATURE.equals(strG3)) {
                    strG2 = G(i27, cArr);
                } else if ("RuntimeVisibleAnnotations".equals(strG3)) {
                    i21 = i27;
                    i12 = i21;
                } else if ("RuntimeVisibleTypeAnnotations".equals(strG3)) {
                    i23 = i27;
                    i12 = i23;
                } else if ("Deprecated".equals(strG3)) {
                    i16 |= 131072;
                } else if ("Synthetic".equals(strG3)) {
                    i16 |= 4096;
                } else {
                    if ("SourceDebugExtension".equals(strG3)) {
                        strI = I(i27, iT, new char[iT]);
                        i12 = i27;
                    } else if ("RuntimeInvisibleAnnotations".equals(strG3)) {
                        i22 = i27;
                        i12 = i22;
                    } else if ("RuntimeInvisibleTypeAnnotations".equals(strG3)) {
                        i24 = i27;
                        i12 = i24;
                    } else if ("Module".equals(strG3)) {
                        i17 = i27;
                        i12 = i17;
                    } else if ("ModuleMainClass".equals(strG3)) {
                        strM3 = m(i27, cArr);
                    } else if ("ModulePackages".equals(strG3)) {
                        i18 = i27;
                        i12 = i18;
                    } else if ("BootstrapMethods".equals(strG3)) {
                        i12 = i27;
                        i14 = i14;
                        iT = iT;
                        strArr = strArr;
                        strI = str;
                    } else {
                        i12 = i27;
                        i14 = i14;
                        iT = iT;
                        strArr = strArr;
                        c cVarJ = j(cVarArr, strG3, i12, iT, cArr, -1, null);
                        cVarJ.f66917c = cVar;
                        cVar = cVarJ;
                        i16 = i16;
                        strI = str;
                        strG = strG;
                    }
                    iE = i12 + iT;
                    iH3--;
                    strArr = strArr;
                    i14 = i14;
                }
                i12 = i27;
            }
            strI = str;
            iE = i12 + iT;
            iH3--;
            strArr = strArr;
            i14 = i14;
        }
        String str2 = strI;
        String str3 = strG;
        int i28 = i14;
        String[] strArr2 = strArr;
        c cVar2 = cVar;
        fVar.a(t(this.f66923b[1] - 7), i16, strM, strG2, strM2, strArr2);
        if ((i11 & 2) == 0 && (str3 != null || str2 != null)) {
            fVar.l(str3, str2);
        }
        if (i17 != 0) {
            y(fVar, iVar, i17, i18, strM3);
        }
        String str4 = strM4;
        if (str4 != null) {
            fVar.i(str4);
        }
        int i29 = i19;
        if (i29 != 0) {
            String strM5 = m(i29, cArr);
            int iH4 = H(i29 + 2);
            fVar.k(strM5, iH4 == 0 ? null : G(this.f66923b[iH4], cArr), iH4 == 0 ? null : G(this.f66923b[iH4] + 2, cArr));
        }
        int i31 = i21;
        if (i31 != 0) {
            int iH5 = H(i31);
            int iR = i31 + 2;
            while (true) {
                int i32 = iH5 - 1;
                if (iH5 <= 0) {
                    break;
                }
                iR = r(fVar.b(G(iR, cArr), true), iR + 2, true, cArr);
                iH5 = i32;
            }
        }
        int i33 = i22;
        if (i33 != 0) {
            int iH6 = H(i33);
            int iR2 = i33 + 2;
            while (true) {
                int i34 = iH6 - 1;
                if (iH6 <= 0) {
                    break;
                }
                iR2 = r(fVar.b(G(iR2, cArr), false), iR2 + 2, true, cArr);
                iH6 = i34;
            }
        }
        int i35 = i23;
        if (i35 != 0) {
            int iH7 = H(i35);
            int iR3 = i35 + 2;
            while (true) {
                int i36 = iH7 - 1;
                if (iH7 <= 0) {
                    break;
                }
                int iE2 = E(iVar, iR3);
                iR3 = r(fVar.m(iVar.f66966h, iVar.f66967i, G(iE2, cArr), true), iE2 + 2, true, cArr);
                iH7 = i36;
            }
        }
        int i37 = i24;
        if (i37 != 0) {
            int iH8 = H(i37);
            int iR4 = i37 + 2;
            while (true) {
                int i38 = iH8 - 1;
                if (iH8 <= 0) {
                    break;
                }
                int iE3 = E(iVar, iR4);
                iR4 = r(fVar.m(iVar.f66966h, iVar.f66967i, G(iE3, cArr), false), iE3 + 2, true, cArr);
                iH8 = i38;
            }
        }
        while (cVar2 != null) {
            c cVar3 = cVar2.f66917c;
            cVar2.f66917c = null;
            fVar.c(cVar2);
            cVar2 = cVar3;
        }
        int i39 = i25;
        if (i39 != 0) {
            int iH9 = H(i39);
            int i40 = i39 + 2;
            while (true) {
                int i41 = iH9 - 1;
                if (iH9 <= 0) {
                    break;
                }
                fVar.j(m(i40, cArr));
                i40 += 2;
                iH9 = i41;
            }
        }
        int i42 = i26;
        if (i42 != 0) {
            int iH10 = H(i42);
            int i43 = i42 + 2;
            while (true) {
                int i44 = iH10 - 1;
                if (iH10 <= 0) {
                    break;
                }
                fVar.f(m(i43, cArr), m(i43 + 2, cArr), G(i43 + 4, cArr), H(i43 + 6));
                i43 += 8;
                iH10 = i44;
            }
        }
        int iH11 = H(i28);
        int iS = i28 + 2;
        while (true) {
            int i45 = iH11 - 1;
            if (iH11 <= 0) {
                break;
            }
            iS = s(fVar, iVar, iS);
            iH11 = i45;
        }
        int iH12 = H(iS);
        int iW = iS + 2;
        while (true) {
            int i46 = iH12 - 1;
            if (iH12 <= 0) {
                fVar.d();
                return;
            } else {
                iW = w(fVar, iVar, iW);
                iH12 = i46;
            }
        }
    }

    public final void b(i iVar) {
        int i11;
        String str = iVar.f66964f;
        Object[] objArr = iVar.f66975q;
        int i12 = 0;
        if ((iVar.f66962d & 8) == 0) {
            if ("<init>".equals(iVar.f66963e)) {
                objArr[0] = v.f67082g;
            } else {
                objArr[0] = m(this.f66928g + 2, iVar.f66961c);
            }
            i12 = 1;
        }
        int i13 = 1;
        while (true) {
            int i14 = i13 + 1;
            char cCharAt = str.charAt(i13);
            if (cCharAt == 'F') {
                i11 = i12 + 1;
                objArr[i12] = v.f67078c;
            } else if (cCharAt != 'L') {
                if (cCharAt != 'S' && cCharAt != 'I') {
                    if (cCharAt == 'J') {
                        i11 = i12 + 1;
                        objArr[i12] = v.f67080e;
                    } else if (cCharAt != 'Z') {
                        if (cCharAt != '[') {
                            switch (cCharAt) {
                                case 'B':
                                case MdtaMetadataEntry.TYPE_INDICATOR_INT32 /* 67 */:
                                    break;
                                case 'D':
                                    i11 = i12 + 1;
                                    objArr[i12] = v.f67079d;
                                    break;
                                default:
                                    iVar.f66973o = i12;
                                    return;
                            }
                        } else {
                            while (str.charAt(i14) == '[') {
                                i14++;
                            }
                            if (str.charAt(i14) == 'L') {
                                do {
                                    i14++;
                                } while (str.charAt(i14) != ';');
                            }
                            int i15 = i14 + 1;
                            objArr[i12] = str.substring(i13, i15);
                            i13 = i15;
                            i12++;
                        }
                    }
                }
                i11 = i12 + 1;
                objArr[i12] = v.f67077b;
            } else {
                int i16 = i14;
                while (str.charAt(i16) != ';') {
                    i16++;
                }
                objArr[i12] = str.substring(i14, i16);
                i12++;
                i13 = i16 + 1;
            }
            i12 = i11;
            i13 = i14;
        }
    }

    public final void c(int i11, q[] qVarArr) {
        if (qVarArr[i11] == null) {
            q qVarU = u(i11, qVarArr);
            qVarU.f67015a = (short) (qVarU.f67015a | 1);
        }
    }

    public final q d(int i11, q[] qVarArr) {
        q qVarU = u(i11, qVarArr);
        qVarU.f67015a = (short) (qVarU.f67015a & (-2));
        return qVarU;
    }

    public final int e() {
        int i11 = this.f66928g;
        int iH = i11 + 8 + (H(i11 + 6) * 2);
        int iH2 = H(iH);
        int iT = iH + 2;
        while (true) {
            int i12 = iH2 - 1;
            if (iH2 <= 0) {
                break;
            }
            int iH3 = H(iT + 6);
            iT += 8;
            while (true) {
                int i13 = iH3 - 1;
                if (iH3 > 0) {
                    iT += t(iT + 2) + 6;
                    iH3 = i13;
                }
            }
            iH2 = i12;
        }
        int iH4 = H(iT);
        int iT2 = iT + 2;
        while (true) {
            int i14 = iH4 - 1;
            if (iH4 <= 0) {
                return iT2 + 2;
            }
            int iH5 = H(iT2 + 6);
            iT2 += 8;
            while (true) {
                int i15 = iH5 - 1;
                if (iH5 > 0) {
                    iT2 += t(iT2 + 2) + 6;
                    iH5 = i15;
                }
            }
            iH4 = i14;
        }
    }

    public int f(int i11) {
        return this.f66923b[i11];
    }

    public int g() {
        return this.f66923b.length;
    }

    public int h() {
        return this.f66927f;
    }

    public final int i(int[] iArr, int i11) {
        if (iArr == null || i11 >= iArr.length || l(iArr[i11]) < 67) {
            return -1;
        }
        return H(iArr[i11] + 1);
    }

    public final c j(c[] cVarArr, String str, int i11, int i12, char[] cArr, int i13, q[] qVarArr) {
        for (c cVar : cVarArr) {
            if (cVar.f66915a.equals(str)) {
                return cVar.g(this, i11, i12, cArr, i13, qVarArr);
            }
        }
        return new c(str).g(this, i11, i12, null, -1, null);
    }

    public final int[] k(int i11) {
        char[] cArr = new char[i11];
        int iE = e();
        for (int iH = H(iE - 2); iH > 0; iH--) {
            String strG = G(iE, cArr);
            int iT = t(iE + 2);
            int i12 = iE + 6;
            if ("BootstrapMethods".equals(strG)) {
                int iH2 = H(i12);
                int[] iArr = new int[iH2];
                int iH3 = iE + 8;
                for (int i13 = 0; i13 < iH2; i13++) {
                    iArr[i13] = iH3;
                    iH3 += (H(iH3 + 2) * 2) + 4;
                }
                return iArr;
            }
            iE = i12 + iT;
        }
        return null;
    }

    public int l(int i11) {
        return this.f66922a[i11] & 255;
    }

    public String m(int i11, char[] cArr) {
        return D(i11, cArr);
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 33521. Try increasing type updates limit count.
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:79)
        */
    public final void n(i30.r r39, i30.i r40, int r41) {
        /*
            Method dump skipped, instruction units count: 3352
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: i30.e.n(i30.r, i30.i, int):void");
    }

    public Object o(int i11, char[] cArr) {
        int i12 = this.f66923b[i11];
        byte b11 = this.f66922a[i12 - 1];
        switch (b11) {
            case 3:
                return Integer.valueOf(t(i12));
            case 4:
                return Float.valueOf(Float.intBitsToFloat(t(i12)));
            case 5:
                return Long.valueOf(v(i12));
            case 6:
                return Double.valueOf(Double.longBitsToDouble(v(i12)));
            case 7:
                return y.k(G(i12, cArr));
            case 8:
                return G(i12, cArr);
            default:
                switch (b11) {
                    case 15:
                        int iL = l(i12);
                        int i13 = this.f66923b[H(i12 + 1)];
                        int i14 = this.f66923b[H(i13 + 2)];
                        return new o(iL, m(i13, cArr), G(i14, cArr), G(i14 + 2, cArr), this.f66922a[i13 - 1] == 11);
                    case 16:
                        return y.j(G(i12, cArr));
                    case 17:
                        return p(i11, cArr);
                    default:
                        throw new IllegalArgumentException();
                }
        }
    }

    public final h p(int i11, char[] cArr) {
        h hVar = this.f66925d[i11];
        if (hVar != null) {
            return hVar;
        }
        int[] iArr = this.f66923b;
        int i12 = iArr[i11];
        int i13 = iArr[H(i12 + 2)];
        String strG = G(i13, cArr);
        String strG2 = G(i13 + 2, cArr);
        int i14 = this.f66926e[H(i12)];
        o oVar = (o) o(H(i14), cArr);
        int iH = H(i14 + 2);
        Object[] objArr = new Object[iH];
        int i15 = i14 + 4;
        for (int i16 = 0; i16 < iH; i16++) {
            objArr[i16] = o(H(i15), cArr);
            i15 += 2;
        }
        h[] hVarArr = this.f66925d;
        h hVar2 = new h(strG, strG2, oVar, objArr);
        hVarArr[i11] = hVar2;
        return hVar2;
    }

    /* JADX WARN: Code duplicated, block: B:98:0x020d  */
    public final int q(a aVar, int i11, String str, char[] cArr) {
        int i12 = 0;
        if (aVar == null) {
            int i13 = this.f66922a[i11] & 255;
            if (i13 == 64) {
                return r(null, i11 + 3, true, cArr);
            }
            if (i13 != 91) {
                return i13 != 101 ? i11 + 3 : i11 + 5;
            }
            return r(null, i11 + 1, false, cArr);
        }
        int i14 = i11 + 1;
        int i15 = this.f66922a[i11] & 255;
        if (i15 == 64) {
            return r(aVar.b(str, G(i14, cArr)), i11 + 3, true, cArr);
        }
        if (i15 == 70) {
            aVar.a(str, o(H(i14), cArr));
        } else if (i15 == 83) {
            aVar.a(str, Short.valueOf((short) t(this.f66923b[H(i14)])));
        } else if (i15 == 99) {
            aVar.a(str, y.n(G(i14, cArr)));
        } else {
            if (i15 == 101) {
                aVar.e(str, G(i14, cArr), G(i11 + 3, cArr));
                return i11 + 5;
            }
            if (i15 == 115) {
                aVar.a(str, G(i14, cArr));
            } else if (i15 == 73 || i15 == 74) {
                aVar.a(str, o(H(i14), cArr));
            } else if (i15 == 90) {
                aVar.a(str, t(this.f66923b[H(i14)]) == 0 ? Boolean.FALSE : Boolean.TRUE);
            } else {
                if (i15 == 91) {
                    int iH = H(i14);
                    int i16 = i11 + 3;
                    if (iH == 0) {
                        return r(aVar.c(str), i11 + 1, false, cArr);
                    }
                    int i17 = this.f66922a[i16] & 255;
                    if (i17 == 70) {
                        float[] fArr = new float[iH];
                        while (i12 < iH) {
                            fArr[i12] = Float.intBitsToFloat(t(this.f66923b[H(i16 + 1)]));
                            i16 += 3;
                            i12++;
                        }
                        aVar.a(str, fArr);
                    } else if (i17 == 83) {
                        short[] sArr = new short[iH];
                        while (i12 < iH) {
                            sArr[i12] = (short) t(this.f66923b[H(i16 + 1)]);
                            i16 += 3;
                            i12++;
                        }
                        aVar.a(str, sArr);
                    } else if (i17 == 90) {
                        boolean[] zArr = new boolean[iH];
                        for (int i18 = 0; i18 < iH; i18++) {
                            zArr[i18] = t(this.f66923b[H(i16 + 1)]) != 0;
                            i16 += 3;
                        }
                        aVar.a(str, zArr);
                    } else if (i17 == 73) {
                        int[] iArr = new int[iH];
                        while (i12 < iH) {
                            iArr[i12] = t(this.f66923b[H(i16 + 1)]);
                            i16 += 3;
                            i12++;
                        }
                        aVar.a(str, iArr);
                    } else if (i17 != 74) {
                        switch (i17) {
                            case 66:
                                byte[] bArr = new byte[iH];
                                while (i12 < iH) {
                                    bArr[i12] = (byte) t(this.f66923b[H(i16 + 1)]);
                                    i16 += 3;
                                    i12++;
                                }
                                aVar.a(str, bArr);
                                break;
                            case MdtaMetadataEntry.TYPE_INDICATOR_INT32 /* 67 */:
                                char[] cArr2 = new char[iH];
                                while (i12 < iH) {
                                    cArr2[i12] = (char) t(this.f66923b[H(i16 + 1)]);
                                    i16 += 3;
                                    i12++;
                                }
                                aVar.a(str, cArr2);
                                break;
                            case 68:
                                double[] dArr = new double[iH];
                                while (i12 < iH) {
                                    dArr[i12] = Double.longBitsToDouble(v(this.f66923b[H(i16 + 1)]));
                                    i16 += 3;
                                    i12++;
                                }
                                aVar.a(str, dArr);
                                break;
                            default:
                                return r(aVar.c(str), i11 + 1, false, cArr);
                        }
                    } else {
                        long[] jArr = new long[iH];
                        while (i12 < iH) {
                            jArr[i12] = v(this.f66923b[H(i16 + 1)]);
                            i16 += 3;
                            i12++;
                        }
                        aVar.a(str, jArr);
                    }
                    return i16;
                }
                switch (i15) {
                    case 66:
                        aVar.a(str, Byte.valueOf((byte) t(this.f66923b[H(i14)])));
                        break;
                    case MdtaMetadataEntry.TYPE_INDICATOR_INT32 /* 67 */:
                        aVar.a(str, Character.valueOf((char) t(this.f66923b[H(i14)])));
                        break;
                    case 68:
                        aVar.a(str, o(H(i14), cArr));
                        break;
                    default:
                        throw new IllegalArgumentException();
                }
            }
        }
        return i11 + 3;
    }

    public final int r(a aVar, int i11, boolean z11, char[] cArr) {
        int iH = H(i11);
        int iQ = i11 + 2;
        if (!z11) {
            while (true) {
                int i12 = iH - 1;
                if (iH <= 0) {
                    break;
                }
                iQ = q(aVar, iQ, null, cArr);
                iH = i12;
            }
        } else {
            while (true) {
                int i13 = iH - 1;
                if (iH <= 0) {
                    break;
                }
                iQ = q(aVar, iQ + 2, G(iQ, cArr), cArr);
                iH = i13;
            }
        }
        if (aVar != null) {
            aVar.d();
        }
        return iQ;
    }

    public final int s(f fVar, i iVar, int i11) {
        int i12;
        int i13;
        i iVar2 = iVar;
        char[] cArr = iVar2.f66961c;
        int iH = H(i11);
        String strG = G(i11 + 2, cArr);
        String strG2 = G(i11 + 4, cArr);
        int iH2 = H(i11 + 6);
        int i14 = i11 + 8;
        int i15 = iH;
        c cVarJ = null;
        String strG3 = null;
        Object objO = null;
        int i16 = 0;
        int i17 = 0;
        int i18 = 0;
        int i19 = 0;
        while (true) {
            int i21 = iH2 - 1;
            if (iH2 <= 0) {
                break;
            }
            String strG4 = G(i14, cArr);
            int iT = t(i14 + 2);
            int i22 = i14 + 6;
            if ("ConstantValue".equals(strG4)) {
                int iH3 = H(i22);
                objO = iH3 == 0 ? null : o(iH3, cArr);
            } else if (RequestParameters.SIGNATURE.equals(strG4)) {
                strG3 = G(i22, cArr);
            } else {
                if ("Deprecated".equals(strG4)) {
                    i13 = 131072 | i15;
                } else {
                    if ("Synthetic".equals(strG4)) {
                        i13 = i15 | 4096;
                    } else if ("RuntimeVisibleAnnotations".equals(strG4)) {
                        i19 = i22;
                        i12 = i19;
                    } else if ("RuntimeVisibleTypeAnnotations".equals(strG4)) {
                        i17 = i22;
                        i12 = i17;
                    } else if ("RuntimeInvisibleAnnotations".equals(strG4)) {
                        i18 = i22;
                        i12 = i18;
                    } else if ("RuntimeInvisibleTypeAnnotations".equals(strG4)) {
                        i16 = i22;
                        i12 = i16;
                    } else {
                        i12 = i22;
                        c cVar = cVarJ;
                        cVarJ = j(iVar2.f66959a, strG4, i12, iT, cArr, -1, null);
                        cVarJ.f66917c = cVar;
                        i18 = i18;
                        i19 = i19;
                        i16 = i16;
                        i17 = i17;
                    }
                    i14 = i12 + iT;
                    iVar2 = iVar;
                    iH2 = i21;
                }
                i15 = i13;
            }
            i12 = i22;
            i14 = i12 + iT;
            iVar2 = iVar;
            iH2 = i21;
        }
        c cVar2 = cVarJ;
        int i23 = i16;
        int i24 = i17;
        int i25 = i18;
        int i26 = i19;
        l lVarE = fVar.e(i15, strG, strG2, strG3, objO);
        if (lVarE == null) {
            return i14;
        }
        if (i26 != 0) {
            int iH4 = H(i26);
            int iR = i26 + 2;
            while (true) {
                int i27 = iH4 - 1;
                if (iH4 <= 0) {
                    break;
                }
                iR = r(lVarE.a(G(iR, cArr), true), iR + 2, true, cArr);
                iH4 = i27;
            }
        }
        if (i25 != 0) {
            int iH5 = H(i25);
            int iR2 = i25 + 2;
            while (true) {
                int i28 = iH5 - 1;
                if (iH5 <= 0) {
                    break;
                }
                iR2 = r(lVarE.a(G(iR2, cArr), false), iR2 + 2, true, cArr);
                iH5 = i28;
            }
        }
        if (i24 != 0) {
            int iH6 = H(i24);
            int iR3 = i24 + 2;
            while (true) {
                int i29 = iH6 - 1;
                if (iH6 <= 0) {
                    break;
                }
                int iE = E(iVar, iR3);
                iR3 = r(lVarE.d(iVar.f66966h, iVar.f66967i, G(iE, cArr), true), iE + 2, true, cArr);
                iH6 = i29;
            }
        }
        if (i23 != 0) {
            int iH7 = H(i23);
            int iR4 = i23 + 2;
            while (true) {
                int i31 = iH7 - 1;
                if (iH7 <= 0) {
                    break;
                }
                int iE2 = E(iVar, iR4);
                iR4 = r(lVarE.d(iVar.f66966h, iVar.f66967i, G(iE2, cArr), false), iE2 + 2, true, cArr);
                iH7 = i31;
            }
        }
        while (true) {
            c cVar3 = cVar2;
            if (cVar3 == null) {
                lVarE.c();
                return i14;
            }
            cVar2 = cVar3.f66917c;
            cVar3.f66917c = null;
            lVarE.b(cVar3);
        }
    }

    public int t(int i11) {
        byte[] bArr = this.f66922a;
        return (bArr[i11 + 3] & 255) | ((bArr[i11] & 255) << 24) | ((bArr[i11 + 1] & 255) << 16) | ((bArr[i11 + 2] & 255) << 8);
    }

    public q u(int i11, q[] qVarArr) {
        if (qVarArr[i11] == null) {
            qVarArr[i11] = new q();
        }
        return qVarArr[i11];
    }

    public long v(int i11) {
        return (((long) t(i11)) << 32) | (((long) t(i11 + 4)) & 4294967295L);
    }

    public final int w(f fVar, i iVar, int i11) {
        int i12;
        int i13;
        char[] cArr = iVar.f66961c;
        iVar.f66962d = H(i11);
        iVar.f66963e = G(i11 + 2, cArr);
        int i14 = i11 + 4;
        iVar.f66964f = G(i14, cArr);
        int iH = H(i11 + 6);
        int i15 = i11 + 8;
        int i16 = 0;
        int i17 = 0;
        int i18 = 0;
        int i19 = 0;
        int i21 = 0;
        int i22 = 0;
        int iH2 = 0;
        c cVar = null;
        boolean z11 = false;
        int i23 = 0;
        String[] strArr = null;
        int i24 = 0;
        int i25 = 0;
        int i26 = 0;
        while (true) {
            int i27 = iH - 1;
            if (iH <= 0) {
                break;
            }
            String strG = G(i15, cArr);
            int iT = t(i15 + 2);
            iH2 = iH2;
            int i28 = i15 + 6;
            int i29 = i16;
            if (!"Code".equals(strG)) {
                if ("Exceptions".equals(strG)) {
                    int iH3 = H(i28);
                    String[] strArr2 = new String[iH3];
                    int i31 = i15 + 8;
                    i12 = i17;
                    for (int i32 = 0; i32 < iH3; i32++) {
                        strArr2[i32] = m(i31, cArr);
                        i31 += 2;
                    }
                    strArr = strArr2;
                    i23 = i28;
                    i13 = i23;
                } else {
                    i12 = i17;
                    if (RequestParameters.SIGNATURE.equals(strG)) {
                        i13 = i28;
                        i16 = i29;
                        i17 = i12;
                        iH2 = H(i28);
                    } else if ("Deprecated".equals(strG)) {
                        iVar.f66962d |= 131072;
                        i13 = i28;
                    } else if ("RuntimeVisibleAnnotations".equals(strG)) {
                        i19 = i28;
                        i13 = i19;
                    } else if ("RuntimeVisibleTypeAnnotations".equals(strG)) {
                        i17 = i28;
                        i13 = i17;
                        iH2 = iH2;
                        i16 = i29;
                    } else if ("AnnotationDefault".equals(strG)) {
                        i22 = i28;
                        i13 = i22;
                    } else if ("Synthetic".equals(strG)) {
                        iVar.f66962d |= 4096;
                        i13 = i28;
                        iH2 = iH2;
                        i16 = i29;
                        i17 = i12;
                        z11 = true;
                    } else if ("RuntimeInvisibleAnnotations".equals(strG)) {
                        i18 = i28;
                        i13 = i18;
                    } else if ("RuntimeInvisibleTypeAnnotations".equals(strG)) {
                        i16 = i28;
                        i13 = i16;
                        i17 = i12;
                    } else if ("RuntimeVisibleParameterAnnotations".equals(strG)) {
                        i24 = i28;
                        i13 = i24;
                    } else if ("RuntimeInvisibleParameterAnnotations".equals(strG)) {
                        i25 = i28;
                        i13 = i25;
                    } else if ("MethodParameters".equals(strG)) {
                        i21 = i28;
                        i13 = i21;
                    } else {
                        i13 = i28;
                        c cVarJ = j(iVar.f66959a, strG, i28, iT, cArr, -1, null);
                        cVarJ.f66917c = cVar;
                        cVar = cVarJ;
                        iH2 = iH2;
                        i16 = i29;
                        i17 = i12;
                        i18 = i18;
                        i19 = i19;
                        i21 = i21;
                        i22 = i22;
                    }
                }
                i16 = i29;
                i17 = i12;
            } else if ((iVar.f66960b & 1) == 0) {
                i26 = i28;
                i13 = i26;
                iH2 = iH2;
                i16 = i29;
            } else {
                i12 = i17;
                i13 = i28;
                i16 = i29;
                i17 = i12;
            }
            i15 = i13 + iT;
            iH = i27;
        }
        int i33 = i16;
        int i34 = i17;
        int i35 = i18;
        int i36 = i19;
        int i37 = i21;
        int i38 = i22;
        r rVarG = fVar.g(iVar.f66962d, iVar.f66963e, iVar.f66964f, iH2 == 0 ? null : J(iH2, cArr), strArr);
        if (rVarG == null) {
            return i15;
        }
        if (rVarG instanceof s) {
            if (((s) rVarG).H(this, i11, i15 - i11, z11, (iVar.f66962d & 131072) != 0, H(i14), iH2, i23)) {
                return i15;
            }
        }
        if (i37 != 0) {
            int iL = l(i37);
            int i39 = i37 + 1;
            while (true) {
                int i40 = iL - 1;
                if (iL <= 0) {
                    break;
                }
                rVarG.y(G(i39, cArr), H(i39 + 2));
                i39 += 4;
                iL = i40;
            }
        }
        if (i38 != 0) {
            a aVarC = rVarG.c();
            q(aVarC, i38, null, cArr);
            if (aVarC != null) {
                aVarC.d();
            }
        }
        if (i36 != 0) {
            int iH4 = H(i36);
            int iR = i36 + 2;
            while (true) {
                int i41 = iH4 - 1;
                if (iH4 <= 0) {
                    break;
                }
                iR = r(rVarG.b(G(iR, cArr), true), iR + 2, true, cArr);
                iH4 = i41;
            }
        }
        if (i35 != 0) {
            int iH5 = H(i35);
            int iR2 = i35 + 2;
            while (true) {
                int i42 = iH5 - 1;
                if (iH5 <= 0) {
                    break;
                }
                iR2 = r(rVarG.b(G(iR2, cArr), false), iR2 + 2, true, cArr);
                iH5 = i42;
            }
        }
        if (i34 != 0) {
            int iH6 = H(i34);
            int iR3 = i34 + 2;
            while (true) {
                int i43 = iH6 - 1;
                if (iH6 <= 0) {
                    break;
                }
                int iE = E(iVar, iR3);
                iR3 = r(rVarG.D(iVar.f66966h, iVar.f66967i, G(iE, cArr), true), iE + 2, true, cArr);
                iH6 = i43;
            }
        }
        if (i33 != 0) {
            int iH7 = H(i33);
            int iR4 = i33 + 2;
            while (true) {
                int i44 = iH7 - 1;
                if (iH7 <= 0) {
                    break;
                }
                int iE2 = E(iVar, iR4);
                iR4 = r(rVarG.D(iVar.f66966h, iVar.f66967i, G(iE2, cArr), false), iE2 + 2, true, cArr);
                iH7 = i44;
            }
        }
        int i45 = i24;
        if (i45 != 0) {
            A(rVarG, iVar, i45, true);
        }
        int i46 = i25;
        if (i46 != 0) {
            A(rVarG, iVar, i46, false);
        }
        while (cVar != null) {
            c cVar2 = cVar.f66917c;
            cVar.f66917c = null;
            rVarG.d(cVar);
            cVar = cVar2;
        }
        int i47 = i26;
        if (i47 != 0) {
            rVarG.e();
            n(rVarG, iVar, i47);
        }
        rVarG.f();
        return i15;
    }

    public String x(int i11, char[] cArr) {
        return D(i11, cArr);
    }

    public final void y(f fVar, i iVar, int i11, int i12, String str) {
        String[] strArr;
        char[] cArr = iVar.f66961c;
        int i13 = i11 + 6;
        t tVarH = fVar.h(x(i11, cArr), H(i11 + 2), G(i11 + 4, cArr));
        if (tVarH == null) {
            return;
        }
        if (str != null) {
            tVarH.c(str);
        }
        if (i12 != 0) {
            int iH = H(i12);
            int i14 = i12 + 2;
            while (true) {
                int i15 = iH - 1;
                if (iH <= 0) {
                    break;
                }
                tVarH.e(z(i14, cArr));
                i14 += 2;
                iH = i15;
            }
        }
        int iH2 = H(i13);
        int i16 = i11 + 8;
        while (true) {
            int i17 = iH2 - 1;
            if (iH2 <= 0) {
                break;
            }
            String strX = x(i16, cArr);
            int iH3 = H(i16 + 2);
            String strG = G(i16 + 4, cArr);
            i16 += 6;
            tVarH.g(strX, iH3, strG);
            iH2 = i17;
        }
        int iH4 = H(i16);
        int i18 = i16 + 2;
        while (true) {
            int i19 = iH4 - 1;
            String[] strArr2 = null;
            if (iH4 <= 0) {
                break;
            }
            String strZ = z(i18, cArr);
            int iH5 = H(i18 + 2);
            int iH6 = H(i18 + 4);
            i18 += 6;
            if (iH6 != 0) {
                strArr2 = new String[iH6];
                for (int i21 = 0; i21 < iH6; i21++) {
                    strArr2[i21] = x(i18, cArr);
                    i18 += 2;
                }
            }
            tVarH.b(strZ, iH5, strArr2);
            iH4 = i19;
        }
        int iH7 = H(i18);
        int i22 = i18 + 2;
        while (true) {
            int i23 = iH7 - 1;
            if (iH7 <= 0) {
                break;
            }
            String strZ2 = z(i22, cArr);
            int iH8 = H(i22 + 2);
            int iH9 = H(i22 + 4);
            i22 += 6;
            if (iH9 != 0) {
                strArr = new String[iH9];
                for (int i24 = 0; i24 < iH9; i24++) {
                    strArr[i24] = x(i22, cArr);
                    i22 += 2;
                }
            } else {
                strArr = null;
            }
            tVarH.d(strZ2, iH8, strArr);
            iH7 = i23;
        }
        int iH10 = H(i22);
        int i25 = i22 + 2;
        while (true) {
            int i26 = iH10 - 1;
            if (iH10 <= 0) {
                break;
            }
            tVarH.h(m(i25, cArr));
            i25 += 2;
            iH10 = i26;
        }
        int iH11 = H(i25);
        int i27 = i25 + 2;
        while (true) {
            int i28 = iH11 - 1;
            if (iH11 <= 0) {
                tVarH.a();
                return;
            }
            String strM = m(i27, cArr);
            int iH12 = H(i27 + 2);
            i27 += 4;
            String[] strArr3 = new String[iH12];
            for (int i29 = 0; i29 < iH12; i29++) {
                strArr3[i29] = m(i27, cArr);
                i27 += 2;
            }
            tVarH.f(strM, strArr3);
            iH11 = i28;
        }
    }

    public String z(int i11, char[] cArr) {
        return D(i11, cArr);
    }
}
