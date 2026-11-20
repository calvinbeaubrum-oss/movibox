package com.facebook.ads.redexgen.uinode;

import com.google.android.gms.common.api.Api;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.TreeSet;
import okio.Utf8;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class HR {
    public static byte[] A05;
    public static String[] A06 = {"j9EfDvchdu1KqySqOAnBSG3JWHZdS12U", "q23SQ5AypNqS8oaKOX4z", "zGl30nZzPzoLIdVG6oXXe73jwI6SvYzS", "XO0PMOb8qpQh9emdWW7Vnqfuo5cp8yJy", "hg0Ynef21ksm7drJYvbGXc6C6VdsLqYq", "sq8Z8cDX36Rb5yN4ZHuInHWL1DTNPmF7", "lpBmIRRiri9NKyd9o68rlNPCbyzvIw2I", "eicGPlwUgu"};
    public boolean A01;
    public final int A02;
    public final String A03;
    public C1714Vh A00 = C1714Vh.A04;
    public final TreeSet<C1712Vf> A04 = new TreeSet<>();

    static {
        A02();
    }

    public HR(int i11, String str) {
        this.A02 = i11;
        this.A03 = str;
    }

    public static HR A00(int i11, DataInputStream dataInputStream) throws IOException {
        HR hr2 = new HR(dataInputStream.readInt(), dataInputStream.readUTF());
        if (i11 < 2) {
            long j11 = dataInputStream.readLong();
            HW hw2 = new HW();
            HV.A05(hw2, j11);
            hr2.A0F(hw2);
        } else {
            hr2.A00 = C1714Vh.A00(dataInputStream);
        }
        return hr2;
    }

    public static String A01(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A05, i11, i11 + i12);
        int i14 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            if (A06[6].charAt(21) != 'N') {
                throw new RuntimeException();
            }
            A06[6] = "ipIPz5SC6v0GmkIAozZhwN70MrudeMSU";
            if (i14 >= length) {
                return new String(bArrCopyOfRange);
            }
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] - i13) - 100);
            i14++;
        }
    }

    public static void A02() {
        byte[] bArr = {-79, -9, -14, -6, -3, -10, -11, -65, -77, 7, 2, -77, 42, 61, 70, 57, 69, 65, 70, Utf8.REPLACEMENT_BYTE, -8, 71, 62, -8};
        String[] strArr = A06;
        if (strArr[4].charAt(2) != strArr[3].charAt(2)) {
            throw new RuntimeException();
        }
        A06[5] = "8leR2nWms8A7PmFgrtQ6nLfJYqb68GHr";
        A05 = bArr;
    }

    public final int A03(int i11) {
        int iHashCode = (this.A02 * 31) + this.A03.hashCode();
        if (i11 >= 2) {
            return (iHashCode * 31) + this.A00.hashCode();
        }
        long jA00 = HV.A00(this.A00);
        return (iHashCode * 31) + ((int) ((jA00 >>> 32) ^ jA00));
    }

    public final long A04(long j11, long j12) {
        C1712Vf c1712VfA06 = A06(j11);
        if (c1712VfA06.A01()) {
            return -Math.min(c1712VfA06.A02() ? Long.MAX_VALUE : c1712VfA06.A01, j12);
        }
        long j13 = j11 + j12;
        long jMax = c1712VfA06.A02 + c1712VfA06.A01;
        if (jMax < j13) {
            TreeSet<C1712Vf> treeSet = this.A04;
            if (A06[1].length() != 20) {
                throw new RuntimeException();
            }
            A06[1] = "RgZ5bXDLk5KqdLdfFSHI";
            for (C1712Vf c1712Vf : treeSet.tailSet(c1712VfA06, false)) {
                if (c1712Vf.A02 > jMax) {
                    break;
                }
                jMax = Math.max(jMax, c1712Vf.A02 + c1712Vf.A01);
                if (jMax >= j13) {
                    break;
                }
            }
        }
        return Math.min(jMax - j11, j12);
    }

    public final C1714Vh A05() {
        return this.A00;
    }

    public final C1712Vf A06(long j11) {
        C1712Vf c1712VfA01 = C1712Vf.A01(this.A03, j11);
        C1712Vf c1712VfFloor = this.A04.floor(c1712VfA01);
        if (c1712VfFloor != null && c1712VfFloor.A02 + c1712VfFloor.A01 > j11) {
            return c1712VfFloor;
        }
        TreeSet<C1712Vf> treeSet = this.A04;
        String[] strArr = A06;
        if (strArr[2].charAt(22) != strArr[0].charAt(22)) {
            throw new RuntimeException();
        }
        A06[6] = "nd2bgBSeUAsM9albd5et6NmdTACtd3AP";
        C1712Vf c1712VfCeiling = treeSet.ceiling(c1712VfA01);
        return c1712VfCeiling == null ? C1712Vf.A02(this.A03, j11) : C1712Vf.A03(this.A03, j11, c1712VfCeiling.A02 - j11);
    }

    public final C1712Vf A07(C1712Vf c1712Vf) throws HI {
        AbstractC1351Ha.A04(this.A04.remove(c1712Vf));
        C1712Vf c1712VfA08 = c1712Vf.A08(this.A02);
        if (!c1712Vf.A03.renameTo(c1712VfA08.A03)) {
            throw new HI(A01(12, 12, 116) + c1712Vf.A03 + A01(8, 4, 47) + c1712VfA08.A03 + A01(0, 8, 45));
        }
        this.A04.add(c1712VfA08);
        return c1712VfA08;
    }

    public final TreeSet<C1712Vf> A08() {
        return this.A04;
    }

    public final void A09(C1712Vf c1712Vf) {
        this.A04.add(c1712Vf);
    }

    public final void A0A(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeInt(this.A02);
        dataOutputStream.writeUTF(this.A03);
        this.A00.A09(dataOutputStream);
    }

    public final void A0B(boolean z11) {
        this.A01 = z11;
    }

    public final boolean A0C() {
        return this.A04.isEmpty();
    }

    public final boolean A0D() {
        return this.A01;
    }

    public final boolean A0E(HO ho2) {
        if (!this.A04.remove(ho2)) {
            return false;
        }
        ho2.A03.delete();
        return true;
    }

    public final boolean A0F(HW hw2) {
        C1714Vh c1714Vh = this.A00;
        C1714Vh c1714VhA08 = this.A00.A08(hw2);
        this.A00 = c1714VhA08;
        return !c1714VhA08.equals(c1714Vh);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        HR hr2 = (HR) obj;
        return this.A02 == hr2.A02 && this.A03.equals(hr2.A03) && this.A04.equals(hr2.A04) && this.A00.equals(hr2.A00);
    }

    public final int hashCode() {
        return (A03(Api.BaseClientBuilder.API_PRIORITY_OTHER) * 31) + this.A04.hashCode();
    }
}
