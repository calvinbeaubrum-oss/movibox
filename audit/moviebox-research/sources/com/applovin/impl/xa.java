package com.applovin.impl;

import com.applovin.exoplayer2.common.base.Ascii;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class xa extends dk {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f24270b = new a() { // from class: com.applovin.impl.f90
        @Override // com.applovin.impl.xa.a
        public final boolean a(int i11, int i12, int i13, int i14, int i15) {
            return xa.b(i11, i12, i13, i14, i15);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a f24271a;

    /* JADX INFO: compiled from: source.java */
    public interface a {
        boolean a(int i11, int i12, int i13, int i14, int i15);
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f24272a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f24273b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f24274c;

        public b(int i11, boolean z11, int i12) {
            this.f24272a = i11;
            this.f24273b = z11;
            this.f24274c = i12;
        }
    }

    public xa() {
        this(null);
    }

    public xa(a aVar) {
        this.f24271a = aVar;
    }

    private static int a(int i11) {
        return (i11 == 0 || i11 == 3) ? 1 : 2;
    }

    private static e3 a(bh bhVar, int i11, int i12, boolean z11, int i13, a aVar) {
        int iD = bhVar.d();
        int iB = b(bhVar.c(), iD);
        String str = new String(bhVar.c(), iD, iB - iD, "ISO-8859-1");
        bhVar.f(iB + 1);
        int iJ = bhVar.j();
        int iJ2 = bhVar.j();
        long jY = bhVar.y();
        long j11 = jY == 4294967295L ? -1L : jY;
        long jY2 = bhVar.y();
        long j12 = jY2 == 4294967295L ? -1L : jY2;
        ArrayList arrayList = new ArrayList();
        int i14 = iD + i11;
        while (bhVar.d() < i14) {
            ya yaVarA = a(i12, bhVar, z11, i13, aVar);
            if (yaVarA != null) {
                arrayList.add(yaVarA);
            }
        }
        return new e3(str, iJ, iJ2, j11, j12, (ya[]) arrayList.toArray(new ya[0]));
    }

    private static h2 a(bh bhVar, int i11, String str) {
        byte[] bArr = new byte[i11];
        bhVar.a(bArr, 0, i11);
        return new h2(str, bArr);
    }

    private static u3 a(bh bhVar, int i11) {
        if (i11 < 4) {
            return null;
        }
        int iW = bhVar.w();
        String strB = b(iW);
        byte[] bArr = new byte[3];
        bhVar.a(bArr, 0, 3);
        String str = new String(bArr, 0, 3);
        int i12 = i11 - 4;
        byte[] bArr2 = new byte[i12];
        bhVar.a(bArr2, 0, i12);
        int iB = b(bArr2, 0, iW);
        String str2 = new String(bArr2, 0, iB, strB);
        int iA = iB + a(iW);
        return new u3(str, str2, a(bArr2, iA, b(bArr2, iA, iW), strB));
    }

    private static v0 a(bh bhVar, int i11, int i12) {
        int iB;
        String lowerCase;
        int iW = bhVar.w();
        String strB = b(iW);
        int i13 = i11 - 1;
        byte[] bArr = new byte[i13];
        bhVar.a(bArr, 0, i13);
        if (i12 == 2) {
            lowerCase = "image/" + Ascii.toLowerCase(new String(bArr, 0, 3, "ISO-8859-1"));
            if ("image/jpg".equals(lowerCase)) {
                lowerCase = "image/jpeg";
            }
            iB = 2;
        } else {
            iB = b(bArr, 0);
            lowerCase = Ascii.toLowerCase(new String(bArr, 0, iB, "ISO-8859-1"));
            if (lowerCase.indexOf(47) == -1) {
                lowerCase = "image/" + lowerCase;
            }
        }
        int i14 = bArr[iB + 1] & 255;
        int i15 = iB + 2;
        int iB2 = b(bArr, i15, iW);
        return new v0(lowerCase, new String(bArr, i15, iB2 - i15, strB), i14, a(bArr, iB2 + a(iW), i13));
    }

    private static b a(bh bhVar) {
        if (bhVar.a() < 10) {
            pc.d("Id3Decoder", "Data too short to be an ID3 tag");
            return null;
        }
        int iZ = bhVar.z();
        boolean z11 = false;
        if (iZ != 4801587) {
            pc.d("Id3Decoder", "Unexpected first three bytes of ID3 tag header: 0x" + String.format("%06X", Integer.valueOf(iZ)));
            return null;
        }
        int iW = bhVar.w();
        bhVar.g(1);
        int iW2 = bhVar.w();
        int iV = bhVar.v();
        if (iW == 2) {
            if ((iW2 & 64) != 0) {
                pc.d("Id3Decoder", "Skipped ID3 tag with majorVersion=2 and undefined compression scheme");
                return null;
            }
        } else if (iW == 3) {
            if ((iW2 & 64) != 0) {
                int iJ = bhVar.j();
                bhVar.g(iJ);
                iV -= iJ + 4;
            }
        } else {
            if (iW != 4) {
                pc.d("Id3Decoder", "Skipped ID3 tag with unsupported majorVersion=" + iW);
                return null;
            }
            if ((iW2 & 64) != 0) {
                int iV2 = bhVar.v();
                bhVar.g(iV2 - 4);
                iV -= iV2;
            }
            if ((iW2 & 16) != 0) {
                iV -= 10;
            }
        }
        if (iW < 4 && (iW2 & 128) != 0) {
            z11 = true;
        }
        return new b(iW, z11, iV);
    }

    /* JADX WARN: Code duplicated, block: B:132:0x0195  */
    /* JADX WARN: Code duplicated, block: B:139:0x01a6 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:140:0x01a8  */
    /* JADX WARN: Code duplicated, block: B:145:0x01c0 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:146:0x01c2 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:150:0x01d8 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:151:0x01da  */
    /* JADX WARN: Code duplicated, block: B:156:0x01e7 A[Catch: all -> 0x011f, UnsupportedEncodingException -> 0x0215, Merged into TryCatch #1 {all -> 0x011f, UnsupportedEncodingException -> 0x0215, blocks: (B:90:0x0119, B:158:0x01f1, B:161:0x0215, B:94:0x0124, B:101:0x013a, B:103:0x0142, B:111:0x015c, B:120:0x0174, B:131:0x018f, B:138:0x01a1, B:144:0x01b0, B:149:0x01c8, B:155:0x01e2, B:156:0x01e7), top: B:168:0x010f }] */
    private static ya a(int i11, bh bhVar, boolean z11, int i12, a aVar) {
        int iA;
        int i13;
        boolean z12;
        boolean z13;
        boolean z14;
        boolean z15;
        boolean z16;
        ya yaVarA;
        int iW = bhVar.w();
        int iW2 = bhVar.w();
        int iW3 = bhVar.w();
        int iW4 = i11 >= 3 ? bhVar.w() : 0;
        if (i11 == 4) {
            iA = bhVar.A();
            if (!z11) {
                iA = (((iA >> 24) & 255) << 21) | (iA & 255) | (((iA >> 8) & 255) << 7) | (((iA >> 16) & 255) << 14);
            }
        } else {
            iA = i11 == 3 ? bhVar.A() : bhVar.z();
        }
        int iG = iA;
        int iC = i11 >= 3 ? bhVar.C() : 0;
        if (iW == 0 && iW2 == 0 && iW3 == 0 && iW4 == 0 && iG == 0 && iC == 0) {
            bhVar.f(bhVar.e());
            return null;
        }
        int iD = bhVar.d() + iG;
        if (iD > bhVar.e()) {
            pc.d("Id3Decoder", "Frame size exceeds remaining tag data");
            bhVar.f(bhVar.e());
            return null;
        }
        if (aVar != null) {
            i13 = iD;
            if (!aVar.a(i11, iW, iW2, iW3, iW4)) {
                bhVar.f(i13);
                return null;
            }
        } else {
            i13 = iD;
        }
        if (i11 == 3) {
            int i14 = iC;
            z16 = (i14 & 128) != 0;
            z14 = (i14 & 64) != 0;
            z15 = false;
            z12 = (i14 & 32) != 0;
            z13 = z16;
        } else {
            int i15 = iC;
            if (i11 == 4) {
                z12 = (i15 & 64) != 0;
                z13 = (i15 & 8) != 0;
                z14 = (i15 & 4) != 0;
                z15 = (i15 & 2) != 0;
                if ((i15 & 1) != 0) {
                    z16 = true;
                }
            } else {
                z12 = false;
                z13 = false;
                z14 = false;
                z15 = false;
            }
            z16 = false;
        }
        if (z13 || z14) {
            pc.d(r4, "Skipping unsupported compressed or encrypted frame");
            bhVar.f(i13);
            return null;
        }
        if (z12) {
            iG--;
            bhVar.g(1);
        }
        if (z16) {
            iG -= 4;
            bhVar.g(4);
        }
        if (z15) {
            iG = g(bhVar, iG);
        }
        try {
            if (iW == 84 && iW2 == 88 && iW3 == 88 && (i11 == 2 || iW4 == 88)) {
                yaVarA = e(bhVar, iG);
            } else if (iW == 84) {
                yaVarA = b(bhVar, iG, a(i11, iW, iW2, iW3, iW4));
            } else if (iW == 87 && iW2 == 88 && iW3 == 88 && (i11 == 2 || iW4 == 88)) {
                yaVarA = f(bhVar, iG);
            } else if (iW == 87) {
                yaVarA = c(bhVar, iG, a(i11, iW, iW2, iW3, iW4));
            } else if (iW == 80 && iW2 == 82 && iW3 == 73 && iW4 == 86) {
                yaVarA = d(bhVar, iG);
            } else if (iW == 71 && iW2 == 69 && iW3 == 79 && (iW4 == 66 || i11 == 2)) {
                yaVarA = b(bhVar, iG);
            } else if (i11 == 2) {
                if (iW == 80 && iW2 == 73 && iW3 == 67) {
                    yaVarA = a(bhVar, iG, i11);
                } else if (iW != 67 && iW2 == 79 && iW3 == 77 && (iW4 == 77 || i11 == 2)) {
                    yaVarA = a(bhVar, iG);
                } else if (iW != 67 && iW2 == 72 && iW3 == 65 && iW4 == 80) {
                    yaVarA = a(bhVar, iG, i11, z11, i12, aVar);
                } else if (iW != 67 && iW2 == 84 && iW3 == 79 && iW4 == 67) {
                    yaVarA = b(bhVar, iG, i11, z11, i12, aVar);
                } else if (iW != 77 && iW2 == 76 && iW3 == 76 && iW4 == 84) {
                    yaVarA = c(bhVar, iG);
                } else {
                    yaVarA = a(bhVar, iG, a(i11, iW, iW2, iW3, iW4));
                }
            } else if (iW == 65 && iW2 == 80 && iW3 == 73 && iW4 == 67) {
                yaVarA = a(bhVar, iG, i11);
            } else if (iW != 67) {
                if (iW != 67) {
                    if (iW != 67) {
                        if (iW != 77) {
                            yaVarA = a(bhVar, iG, a(i11, iW, iW2, iW3, iW4));
                        } else {
                            yaVarA = a(bhVar, iG, a(i11, iW, iW2, iW3, iW4));
                        }
                    } else if (iW != 77) {
                        yaVarA = a(bhVar, iG, a(i11, iW, iW2, iW3, iW4));
                    } else {
                        yaVarA = a(bhVar, iG, a(i11, iW, iW2, iW3, iW4));
                    }
                } else if (iW != 67) {
                    if (iW != 77) {
                        yaVarA = a(bhVar, iG, a(i11, iW, iW2, iW3, iW4));
                    } else {
                        yaVarA = a(bhVar, iG, a(i11, iW, iW2, iW3, iW4));
                    }
                } else if (iW != 77) {
                    yaVarA = a(bhVar, iG, a(i11, iW, iW2, iW3, iW4));
                } else {
                    yaVarA = a(bhVar, iG, a(i11, iW, iW2, iW3, iW4));
                }
            } else if (iW != 67) {
                if (iW != 67) {
                    if (iW != 77) {
                        yaVarA = a(bhVar, iG, a(i11, iW, iW2, iW3, iW4));
                    } else {
                        yaVarA = a(bhVar, iG, a(i11, iW, iW2, iW3, iW4));
                    }
                } else if (iW != 77) {
                    yaVarA = a(bhVar, iG, a(i11, iW, iW2, iW3, iW4));
                } else {
                    yaVarA = a(bhVar, iG, a(i11, iW, iW2, iW3, iW4));
                }
            } else if (iW != 67) {
                if (iW != 77) {
                    yaVarA = a(bhVar, iG, a(i11, iW, iW2, iW3, iW4));
                } else {
                    yaVarA = a(bhVar, iG, a(i11, iW, iW2, iW3, iW4));
                }
            } else if (iW != 77) {
                yaVarA = a(bhVar, iG, a(i11, iW, iW2, iW3, iW4));
            } else {
                yaVarA = a(bhVar, iG, a(i11, iW, iW2, iW3, iW4));
            }
            if (yaVarA == null) {
                pc.d("Id3Decoder", "Failed to decode frame: id=" + a(i11, iW, iW2, iW3, iW4) + ", frameSize=" + iG);
            }
            bhVar.f(i13);
            return yaVarA;
        } catch (UnsupportedEncodingException unused) {
            pc.d(r4, "Unsupported character encoding");
            return null;
        } finally {
            bhVar.f(i13);
        }
    }

    private static String a(int i11, int i12, int i13, int i14, int i15) {
        return i11 == 2 ? String.format(Locale.US, "%c%c%c", Integer.valueOf(i12), Integer.valueOf(i13), Integer.valueOf(i14)) : String.format(Locale.US, "%c%c%c%c", Integer.valueOf(i12), Integer.valueOf(i13), Integer.valueOf(i14), Integer.valueOf(i15));
    }

    private static String a(byte[] bArr, int i11, int i12, String str) {
        return (i12 <= i11 || i12 > bArr.length) ? "" : new String(bArr, i11, i12 - i11, str);
    }

    private static boolean a(bh bhVar, int i11, int i12, boolean z11) {
        int iZ;
        long jZ;
        int iC;
        int i13;
        int iD = bhVar.d();
        while (true) {
            try {
                boolean z12 = true;
                if (bhVar.a() < i12) {
                    bhVar.f(iD);
                    return true;
                }
                if (i11 >= 3) {
                    iZ = bhVar.j();
                    jZ = bhVar.y();
                    iC = bhVar.C();
                } else {
                    iZ = bhVar.z();
                    jZ = bhVar.z();
                    iC = 0;
                }
                if (iZ == 0 && jZ == 0 && iC == 0) {
                    bhVar.f(iD);
                    return true;
                }
                if (i11 == 4 && !z11) {
                    if ((8421504 & jZ) != 0) {
                        bhVar.f(iD);
                        return false;
                    }
                    jZ = (((jZ >> 24) & 255) << 21) | (jZ & 255) | (((jZ >> 8) & 255) << 7) | (((jZ >> 16) & 255) << 14);
                }
                if (i11 == 4) {
                    i13 = (iC & 64) != 0 ? 1 : 0;
                    if ((iC & 1) == 0) {
                        z12 = false;
                    }
                } else {
                    if (i11 == 3) {
                        i13 = (iC & 32) != 0 ? 1 : 0;
                        if ((iC & 128) == 0) {
                        }
                    } else {
                        i13 = 0;
                    }
                    z12 = false;
                }
                if (z12) {
                    i13 += 4;
                }
                if (jZ < i13) {
                    bhVar.f(iD);
                    return false;
                }
                if (bhVar.a() < jZ) {
                    bhVar.f(iD);
                    return false;
                }
                bhVar.g((int) jZ);
            } catch (Throwable th2) {
                bhVar.f(iD);
                throw th2;
            }
        }
    }

    private static byte[] a(byte[] bArr, int i11, int i12) {
        return i12 <= i11 ? xp.f24377f : Arrays.copyOfRange(bArr, i11, i12);
    }

    private static int b(byte[] bArr, int i11) {
        while (i11 < bArr.length) {
            if (bArr[i11] == 0) {
                return i11;
            }
            i11++;
        }
        return bArr.length;
    }

    private static int b(byte[] bArr, int i11, int i12) {
        int iB = b(bArr, i11);
        if (i12 == 0 || i12 == 3) {
            return iB;
        }
        while (iB < bArr.length - 1) {
            if ((iB - i11) % 2 == 0 && bArr[iB + 1] == 0) {
                return iB;
            }
            iB = b(bArr, iB + 1);
        }
        return bArr.length;
    }

    private static aa b(bh bhVar, int i11) {
        int iW = bhVar.w();
        String strB = b(iW);
        int i12 = i11 - 1;
        byte[] bArr = new byte[i12];
        bhVar.a(bArr, 0, i12);
        int iB = b(bArr, 0);
        String str = new String(bArr, 0, iB, "ISO-8859-1");
        int i13 = iB + 1;
        int iB2 = b(bArr, i13, iW);
        String strA = a(bArr, i13, iB2, strB);
        int iA = iB2 + a(iW);
        int iB3 = b(bArr, iA, iW);
        return new aa(str, strA, a(bArr, iA, iB3, strB), a(bArr, iB3 + a(iW), i12));
    }

    private static f3 b(bh bhVar, int i11, int i12, boolean z11, int i13, a aVar) {
        int iD = bhVar.d();
        int iB = b(bhVar.c(), iD);
        String str = new String(bhVar.c(), iD, iB - iD, "ISO-8859-1");
        bhVar.f(iB + 1);
        int iW = bhVar.w();
        boolean z12 = (iW & 2) != 0;
        boolean z13 = (iW & 1) != 0;
        int iW2 = bhVar.w();
        String[] strArr = new String[iW2];
        for (int i14 = 0; i14 < iW2; i14++) {
            int iD2 = bhVar.d();
            int iB2 = b(bhVar.c(), iD2);
            strArr[i14] = new String(bhVar.c(), iD2, iB2 - iD2, "ISO-8859-1");
            bhVar.f(iB2 + 1);
        }
        ArrayList arrayList = new ArrayList();
        int i15 = iD + i11;
        while (bhVar.d() < i15) {
            ya yaVarA = a(i12, bhVar, z11, i13, aVar);
            if (yaVarA != null) {
                arrayList.add(yaVarA);
            }
        }
        return new f3(str, z12, z13, strArr, (ya[]) arrayList.toArray(new ya[0]));
    }

    private static zn b(bh bhVar, int i11, String str) {
        if (i11 < 1) {
            return null;
        }
        int iW = bhVar.w();
        String strB = b(iW);
        int i12 = i11 - 1;
        byte[] bArr = new byte[i12];
        bhVar.a(bArr, 0, i12);
        return new zn(str, null, new String(bArr, 0, b(bArr, 0, iW), strB));
    }

    private static String b(int i11) {
        if (i11 == 1) {
            return C.UTF16_NAME;
        }
        if (i11 != 2) {
            return i11 != 3 ? "ISO-8859-1" : "UTF-8";
        }
        return "UTF-16BE";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean b(int i11, int i12, int i13, int i14, int i15) {
        return false;
    }

    private static jf c(bh bhVar, int i11) {
        int iC = bhVar.C();
        int iZ = bhVar.z();
        int iZ2 = bhVar.z();
        int iW = bhVar.w();
        int iW2 = bhVar.w();
        ah ahVar = new ah();
        ahVar.a(bhVar);
        int i12 = ((i11 - 10) * 8) / (iW + iW2);
        int[] iArr = new int[i12];
        int[] iArr2 = new int[i12];
        for (int i13 = 0; i13 < i12; i13++) {
            int iA = ahVar.a(iW);
            int iA2 = ahVar.a(iW2);
            iArr[i13] = iA;
            iArr2[i13] = iA2;
        }
        return new jf(iC, iZ, iZ2, iArr, iArr2);
    }

    private static up c(bh bhVar, int i11, String str) {
        byte[] bArr = new byte[i11];
        bhVar.a(bArr, 0, i11);
        return new up(str, null, new String(bArr, 0, b(bArr, 0), "ISO-8859-1"));
    }

    private static vh d(bh bhVar, int i11) {
        byte[] bArr = new byte[i11];
        bhVar.a(bArr, 0, i11);
        int iB = b(bArr, 0);
        return new vh(new String(bArr, 0, iB, "ISO-8859-1"), a(bArr, iB + 1, i11));
    }

    private static zn e(bh bhVar, int i11) {
        if (i11 < 1) {
            return null;
        }
        int iW = bhVar.w();
        String strB = b(iW);
        int i12 = i11 - 1;
        byte[] bArr = new byte[i12];
        bhVar.a(bArr, 0, i12);
        int iB = b(bArr, 0, iW);
        String str = new String(bArr, 0, iB, strB);
        int iA = iB + a(iW);
        return new zn("TXXX", str, a(bArr, iA, b(bArr, iA, iW), strB));
    }

    private static up f(bh bhVar, int i11) {
        if (i11 < 1) {
            return null;
        }
        int iW = bhVar.w();
        String strB = b(iW);
        int i12 = i11 - 1;
        byte[] bArr = new byte[i12];
        bhVar.a(bArr, 0, i12);
        int iB = b(bArr, 0, iW);
        String str = new String(bArr, 0, iB, strB);
        int iA = iB + a(iW);
        return new up("WXXX", str, a(bArr, iA, b(bArr, iA), "ISO-8859-1"));
    }

    private static int g(bh bhVar, int i11) {
        byte[] bArrC = bhVar.c();
        int iD = bhVar.d();
        int i12 = iD;
        while (true) {
            int i13 = i12 + 1;
            if (i13 >= iD + i11) {
                return i11;
            }
            if ((bArrC[i12] & 255) == 255 && bArrC[i13] == 0) {
                System.arraycopy(bArrC, i12 + 2, bArrC, i13, (i11 - (i12 - iD)) - 2);
                i11--;
            }
            i12 = i13;
        }
    }

    @Override // com.applovin.impl.dk
    public bf a(ef efVar, ByteBuffer byteBuffer) {
        return a(byteBuffer.array(), byteBuffer.limit());
    }

    public bf a(byte[] bArr, int i11) {
        ArrayList arrayList = new ArrayList();
        bh bhVar = new bh(bArr, i11);
        b bVarA = a(bhVar);
        if (bVarA == null) {
            return null;
        }
        int iD = bhVar.d();
        int i12 = bVarA.f24272a == 2 ? 6 : 10;
        int iG = bVarA.f24274c;
        if (bVarA.f24273b) {
            iG = g(bhVar, bVarA.f24274c);
        }
        bhVar.e(iD + iG);
        boolean z11 = false;
        if (!a(bhVar, bVarA.f24272a, i12, false)) {
            if (bVarA.f24272a != 4 || !a(bhVar, 4, i12, true)) {
                pc.d("Id3Decoder", "Failed to validate ID3 tag with majorVersion=" + bVarA.f24272a);
                return null;
            }
            z11 = true;
        }
        while (bhVar.a() >= i12) {
            ya yaVarA = a(bVarA.f24272a, bhVar, z11, i12, this.f24271a);
            if (yaVarA != null) {
                arrayList.add(yaVarA);
            }
        }
        return new bf(arrayList);
    }
}
