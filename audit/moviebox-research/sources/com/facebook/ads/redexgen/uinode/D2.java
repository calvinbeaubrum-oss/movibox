package com.facebook.ads.redexgen.uinode;

import android.util.SparseArray;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class D2 {
    public static String[] A0I = {"F0jWKjQTCy62z5RMZ8LXaJxAHVXVw03", "jefijzmMiLSAGWVfBYlCHQnNu7WiK65", "5NKy3uod9nHosUme2DvPYxtYVEy", "OBCuuRHFU9olC8zTnYpCIYDmocSOdWsL", "GchpYIdYbHeAJ5Ou", "h9yGOulo4c92iX", "0WO8HWLEfGPVrZyS", "YTVxkuYMC8IrkJuZM8HCcFhUbHlAsN8p"};
    public int A00;
    public int A01;
    public long A02;
    public long A03;
    public long A04;
    public long A05;
    public boolean A08;
    public boolean A09;
    public boolean A0A;
    public byte[] A0B;
    public final C4 A0E;
    public final I0 A0F;
    public final boolean A0G;
    public final boolean A0H;
    public final SparseArray<C1371Hu> A0D = new SparseArray<>();
    public final SparseArray<C1370Ht> A0C = new SparseArray<>();
    public D1 A06 = new D1();
    public D1 A07 = new D1();

    public D2(C4 c11, boolean z11, boolean z12) {
        this.A0E = c11;
        this.A0G = z11;
        this.A0H = z12;
        byte[] bArr = new byte[128];
        this.A0B = bArr;
        this.A0F = new I0(bArr, 0, 0);
        A01();
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private void A00(int i11) {
        boolean z11 = this.A0A;
        this.A0E.AFS(this.A05, z11 ? 1 : 0, (int) (this.A02 - this.A04), i11, null);
    }

    public final void A01() {
        this.A08 = false;
        this.A09 = false;
        this.A07.A02();
    }

    public final void A02(long j11, int i11) {
        boolean z11 = false;
        if (this.A01 == 9 || (this.A0H && this.A07.A00(this.A06))) {
            boolean z12 = this.A09;
            String[] strArr = A0I;
            if (strArr[0].length() != strArr[1].length()) {
                throw new RuntimeException();
            }
            A0I[2] = "rg9RD6QhDdRr";
            if (z12) {
                A00(i11 + ((int) (j11 - this.A02)));
            }
            this.A04 = this.A02;
            this.A05 = this.A03;
            this.A0A = false;
            this.A09 = true;
        }
        boolean z13 = this.A0A;
        int i12 = this.A01;
        if (i12 == 5 || (this.A0G && i12 == 1 && this.A07.A05())) {
            z11 = true;
        }
        this.A0A = z13 | z11;
    }

    public final void A03(long j11, int i11, long j12) {
        this.A01 = i11;
        this.A03 = j12;
        this.A02 = j11;
        if (!this.A0G || i11 != 1) {
            if (!this.A0H) {
                return;
            }
            if (i11 != 5 && i11 != 1 && i11 != 2) {
                return;
            }
        }
        D1 d11 = this.A06;
        this.A06 = this.A07;
        this.A07 = d11;
        d11.A02();
        this.A00 = 0;
        this.A08 = true;
    }

    public final void A04(C1370Ht c1370Ht) {
        this.A0C.append(c1370Ht.A00, c1370Ht);
    }

    public final void A05(C1371Hu c1371Hu) {
        this.A0D.append(c1371Hu.A05, c1371Hu);
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0063 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:15:0x0064  */
    /* JADX WARN: Code duplicated, block: B:17:0x007d A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:18:0x007e  */
    /* JADX WARN: Code duplicated, block: B:20:0x008b A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:21:0x008c  */
    /* JADX WARN: Code duplicated, block: B:23:0x0096  */
    /* JADX WARN: Code duplicated, block: B:25:0x009e  */
    /* JADX WARN: Code duplicated, block: B:27:0x00a6 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:28:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:30:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:32:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:34:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:36:0x00d6 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:37:0x00d7  */
    /* JADX WARN: Code duplicated, block: B:39:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:42:0x00fa A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:43:0x00fb  */
    /* JADX WARN: Code duplicated, block: B:45:0x010b  */
    /* JADX WARN: Code duplicated, block: B:47:0x0113 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:48:0x0114  */
    /* JADX WARN: Code duplicated, block: B:50:0x011c  */
    /* JADX WARN: Code duplicated, block: B:52:0x0124 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:53:0x0125  */
    /* JADX WARN: Code duplicated, block: B:54:0x012d  */
    /* JADX WARN: Code duplicated, block: B:56:0x0139  */
    /* JADX WARN: Code duplicated, block: B:59:0x0149  */
    /* JADX WARN: Code duplicated, block: B:62:0x014f  */
    /* JADX WARN: Code duplicated, block: B:64:0x0157 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:65:0x0158  */
    /* JADX WARN: Code duplicated, block: B:66:0x015b  */
    /* JADX WARN: Code duplicated, block: B:67:0x0163  */
    /* JADX WARN: Code duplicated, block: B:70:0x0175  */
    /* JADX WARN: Code duplicated, block: B:72:0x017f A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:73:0x0180  */
    /* JADX WARN: Code duplicated, block: B:78:0x0196 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:79:0x0197  */
    /* JADX WARN: Code duplicated, block: B:80:0x019e  */
    /* JADX WARN: Code duplicated, block: B:86:0x01ae A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:87:0x01af  */
    /* JADX WARN: Code duplicated, block: B:92:0x01c3 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:93:0x01c4  */
    public final void A06(byte[] bArr, int i11, int i12) {
        int iA05;
        int iA04;
        int iA06;
        C1370Ht c1370Ht;
        C1371Hu c1371Hu;
        boolean zA0A;
        boolean z11;
        boolean zA0A2;
        boolean z12;
        int iA07;
        int iA08;
        int iA03;
        int iA09;
        int iA010;
        I0 i13;
        if (this.A08) {
            int i14 = i12 - i11;
            byte[] bArr2 = this.A0B;
            int length = bArr2.length;
            int i15 = this.A00;
            if (length >= i15 + i14) {
                System.arraycopy(bArr, i11, this.A0B, this.A00, i14);
                int i16 = this.A00 + i14;
                this.A00 = i16;
                this.A0F.A08(this.A0B, 0, i16);
                if (this.A0F.A0B(8)) {
                    this.A0F.A06();
                    iA05 = this.A0F.A05(2);
                    this.A0F.A07(5);
                    if (this.A0F.A09()) {
                        this.A0F.A04();
                        if (this.A0F.A09()) {
                            iA04 = this.A0F.A04();
                            if (!this.A0H) {
                                this.A08 = false;
                                this.A07.A03(iA04);
                                return;
                            }
                            if (this.A0F.A09()) {
                                iA06 = this.A0F.A04();
                                if (this.A0C.indexOfKey(iA06) < 0) {
                                    this.A08 = false;
                                    return;
                                }
                                c1370Ht = this.A0C.get(iA06);
                                c1371Hu = this.A0D.get(c1370Ht.A01);
                                if (c1371Hu.A09) {
                                    if (!this.A0F.A0B(2)) {
                                        return;
                                    }
                                    i13 = this.A0F;
                                    if (A0I[2].length() != 18) {
                                        A0I[2] = "BDS58Myee4yHYxTG8mu";
                                        i13.A07(2);
                                    }
                                }
                                if (this.A0F.A0B(c1371Hu.A01)) {
                                    zA0A = false;
                                    z11 = false;
                                    zA0A2 = false;
                                    int iA011 = this.A0F.A05(c1371Hu.A01);
                                    if (c1371Hu.A08) {
                                        if (A0I[5].length() != 7) {
                                            String[] strArr = A0I;
                                            strArr[6] = "E8pM94a91AlwBow9";
                                            strArr[4] = "HP5p1w370WRNIPZM";
                                        } else {
                                            A0I[5] = "F8tLSSZzAzz";
                                        }
                                    } else {
                                        if (!this.A0F.A0B(1)) {
                                            return;
                                        }
                                        zA0A = this.A0F.A0A();
                                        if (zA0A) {
                                            if (!this.A0F.A0B(1)) {
                                                return;
                                            }
                                            zA0A2 = this.A0F.A0A();
                                            z11 = true;
                                        }
                                    }
                                    if (this.A01 == 5) {
                                        z12 = true;
                                    } else {
                                        z12 = false;
                                    }
                                    iA07 = 0;
                                    if (z12) {
                                        if (!this.A0F.A09()) {
                                            return;
                                        } else {
                                            iA07 = this.A0F.A04();
                                        }
                                    }
                                    iA08 = 0;
                                    iA03 = 0;
                                    iA09 = 0;
                                    iA010 = 0;
                                    if (c1371Hu.A04 == 0) {
                                        if (!this.A0F.A0B(c1371Hu.A03)) {
                                            return;
                                        }
                                        iA08 = this.A0F.A05(c1371Hu.A03);
                                        if (c1370Ht.A02) {
                                            if (!this.A0F.A09()) {
                                                return;
                                            } else {
                                                iA03 = this.A0F.A03();
                                            }
                                        }
                                    } else if (c1371Hu.A04 == 1) {
                                        if (!this.A0F.A09()) {
                                            return;
                                        }
                                        iA09 = this.A0F.A03();
                                        if (c1370Ht.A02) {
                                            if (!this.A0F.A09()) {
                                                return;
                                            } else {
                                                iA010 = this.A0F.A03();
                                            }
                                        }
                                    }
                                    this.A07.A04(c1371Hu, iA05, iA04, iA011, iA06, zA0A, z11, zA0A2, z12, iA07, iA08, iA03, iA09, iA010);
                                    this.A08 = false;
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            int i17 = (i15 + i14) * 2;
            String[] strArr2 = A0I;
            if (strArr2[0].length() == strArr2[1].length()) {
                String[] strArr3 = A0I;
                strArr3[0] = "I85ez55UKF4vR6ktlfwpENhqyCssmG4";
                strArr3[1] = "5okjmZY1XRxLGurOWaApunPnJUdAZAM";
                this.A0B = Arrays.copyOf(bArr2, i17);
                System.arraycopy(bArr, i11, this.A0B, this.A00, i14);
                int i18 = this.A00 + i14;
                this.A00 = i18;
                this.A0F.A08(this.A0B, 0, i18);
                if (this.A0F.A0B(8)) {
                    return;
                }
                this.A0F.A06();
                iA05 = this.A0F.A05(2);
                this.A0F.A07(5);
                if (this.A0F.A09()) {
                    return;
                }
                this.A0F.A04();
                if (this.A0F.A09()) {
                    return;
                }
                iA04 = this.A0F.A04();
                if (!this.A0H) {
                    this.A08 = false;
                    this.A07.A03(iA04);
                    return;
                }
                if (this.A0F.A09()) {
                    return;
                }
                iA06 = this.A0F.A04();
                if (this.A0C.indexOfKey(iA06) < 0) {
                    this.A08 = false;
                    return;
                }
                c1370Ht = this.A0C.get(iA06);
                c1371Hu = this.A0D.get(c1370Ht.A01);
                if (c1371Hu.A09) {
                    if (!this.A0F.A0B(2)) {
                        return;
                    }
                    i13 = this.A0F;
                    if (A0I[2].length() != 18) {
                        A0I[2] = "BDS58Myee4yHYxTG8mu";
                        i13.A07(2);
                    }
                }
                if (this.A0F.A0B(c1371Hu.A01)) {
                    return;
                }
                zA0A = false;
                z11 = false;
                zA0A2 = false;
                int iA012 = this.A0F.A05(c1371Hu.A01);
                if (c1371Hu.A08) {
                    if (!this.A0F.A0B(1)) {
                        return;
                    }
                    zA0A = this.A0F.A0A();
                    if (zA0A) {
                        if (!this.A0F.A0B(1)) {
                            return;
                        }
                        zA0A2 = this.A0F.A0A();
                        z11 = true;
                    }
                } else if (A0I[5].length() != 7) {
                    String[] strArr4 = A0I;
                    strArr4[6] = "E8pM94a91AlwBow9";
                    strArr4[4] = "HP5p1w370WRNIPZM";
                } else {
                    A0I[5] = "F8tLSSZzAzz";
                }
                if (this.A01 == 5) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                iA07 = 0;
                if (z12) {
                    if (!this.A0F.A09()) {
                        return;
                    } else {
                        iA07 = this.A0F.A04();
                    }
                }
                iA08 = 0;
                iA03 = 0;
                iA09 = 0;
                iA010 = 0;
                if (c1371Hu.A04 == 0) {
                    if (!this.A0F.A0B(c1371Hu.A03)) {
                        return;
                    }
                    iA08 = this.A0F.A05(c1371Hu.A03);
                    if (c1370Ht.A02 && !zA0A) {
                        if (!this.A0F.A09()) {
                            return;
                        } else {
                            iA03 = this.A0F.A03();
                        }
                    }
                } else if (c1371Hu.A04 == 1 && !c1371Hu.A07) {
                    if (!this.A0F.A09()) {
                        return;
                    }
                    iA09 = this.A0F.A03();
                    if (c1370Ht.A02 && !zA0A) {
                        if (!this.A0F.A09()) {
                            return;
                        } else {
                            iA010 = this.A0F.A03();
                        }
                    }
                }
                this.A07.A04(c1371Hu, iA05, iA04, iA012, iA06, zA0A, z11, zA0A2, z12, iA07, iA08, iA03, iA09, iA010);
                this.A08 = false;
                return;
            }
            throw new RuntimeException();
        }
    }

    public final boolean A07() {
        return this.A0H;
    }
}
