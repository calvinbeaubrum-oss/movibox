package com.facebook.ads.redexgen.uinode;

import android.os.ConditionVariable;
import android.util.Log;
import com.applovin.exoplayer2.common.base.Ascii;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.TreeSet;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Vg, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1713Vg implements HK {
    public static boolean A06;
    public static byte[] A07;
    public static String[] A08 = {"PZs3vIZtp1syVhF", "iN5G7Jyo65HiG11v5U3JAI3rcjEJu9Fh", "jWadhCo9gqYR1xuZ5eOebDdRLwIuwzoe", "5aVgPmkb9WO9SFxkSTOlcah0CKuDVehn", "Qok3N", "7mg38N8lomez8u4EtBpwlNJo", "Crj8XVI7aaG6XCZYe", "vguL8XPuWTEOQDWRTomV5"};
    public static final HashSet<File> A09;
    public long A00;
    public boolean A01;
    public final InterfaceC1715Vi A02;
    public final HS A03;
    public final File A04;
    public final HashMap<String, ArrayList<HJ>> A05;

    static {
        A06();
        A09 = new HashSet<>();
    }

    public C1713Vg(File file, InterfaceC1715Vi interfaceC1715Vi) {
        this(file, interfaceC1715Vi, null, false);
    }

    public C1713Vg(File file, InterfaceC1715Vi interfaceC1715Vi, HS hs2) {
        if (!A0D(file)) {
            throw new IllegalStateException(A03(0, 46, 88) + file);
        }
        this.A04 = file;
        this.A02 = interfaceC1715Vi;
        this.A03 = hs2;
        this.A05 = new HashMap<>();
        ConditionVariable conditionVariable = new ConditionVariable();
        new HX(this, A03(57, 24, 112), conditionVariable).start();
        conditionVariable.block();
    }

    public C1713Vg(File file, InterfaceC1715Vi interfaceC1715Vi, byte[] bArr, boolean z11) {
        this(file, interfaceC1715Vi, new HS(file, bArr, z11));
    }

    private C1712Vf A00(String str, long j11) throws HI {
        C1712Vf c1712VfA06;
        HR hrA09 = this.A03.A09(str);
        if (hrA09 == null) {
            C1712Vf c1712VfA02 = C1712Vf.A02(str, j11);
            if (A08[7].length() == 15) {
                throw new RuntimeException();
            }
            A08[3] = "R7TEvDOiyk4OKBf9PsOT39P5pIR22NMD";
            return c1712VfA02;
        }
        while (true) {
            c1712VfA06 = hrA09.A06(j11);
            if (!c1712VfA06.A05 || c1712VfA06.A03.exists()) {
                break;
            }
            A05();
        }
        return c1712VfA06;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.uinode.HK
    /* JADX INFO: renamed from: A01, reason: merged with bridge method [inline-methods] */
    public final synchronized C1712Vf AGV(String str, long j11) throws HI, InterruptedException {
        C1712Vf c1712VfAGW;
        while (true) {
            c1712VfAGW = AGW(str, j11);
            if (c1712VfAGW == null) {
                wait();
            }
        }
        return c1712VfAGW;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.uinode.HK
    /* JADX INFO: renamed from: A02, reason: merged with bridge method [inline-methods] */
    public final synchronized C1712Vf AGW(String str, long j11) throws HI {
        AbstractC1351Ha.A04(!this.A01);
        C1712Vf c1712VfA00 = A00(str, j11);
        if (c1712VfA00.A05) {
            C1712Vf c1712VfA07 = this.A03.A09(str).A07(c1712VfA00);
            A0C(c1712VfA00, c1712VfA07);
            return c1712VfA07;
        }
        HR hrA0A = this.A03.A0A(str);
        if (hrA0A.A0D()) {
            return null;
        }
        hrA0A.A0B(true);
        return c1712VfA00;
    }

    public static String A03(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A07, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] ^ i13) ^ 90);
        }
        return new String(bArrCopyOfRange);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A04() {
        if (!this.A04.exists()) {
            this.A04.mkdirs();
            return;
        }
        this.A03.A0E();
        File[] fileArrListFiles = this.A04.listFiles();
        if (fileArrListFiles == null) {
            return;
        }
        for (File file : fileArrListFiles) {
            if (!file.getName().equals(A03(106, 24, 45))) {
                C1712Vf c1712VfA00 = file.length() > 0 ? C1712Vf.A00(file, this.A03) : null;
                if (c1712VfA00 != null) {
                    A0A(c1712VfA00);
                } else {
                    file.delete();
                }
            }
        }
        this.A03.A0F();
        try {
            this.A03.A0G();
        } catch (HI e11) {
            Log.e(A03(46, 11, 57), A03(81, 25, 105), e11);
        }
    }

    private void A05() throws HI {
        ArrayList arrayList = new ArrayList();
        Iterator<HR> it = this.A03.A0D().iterator();
        while (it.hasNext()) {
            for (C1712Vf c1712Vf : it.next().A08()) {
                if (!c1712Vf.A03.exists()) {
                    arrayList.add(c1712Vf);
                }
            }
        }
        for (int i11 = 0; i11 < arrayList.size(); i11++) {
            A08((HO) arrayList.get(i11), false);
        }
        this.A03.A0F();
        this.A03.A0G();
    }

    public static void A06() {
        String[] strArr = A08;
        if (strArr[1].charAt(16) != strArr[2].charAt(16)) {
            throw new RuntimeException();
        }
        A08[3] = "N0vjWbyGqBS98Run3kOI6tTmnpu8bGoB";
        A07 = new byte[]{67, 108, 109, 118, 106, 103, 112, 34, 81, 107, 111, 114, 110, 103, 65, 99, 97, 106, 103, 34, 107, 108, 113, 118, 99, 108, 97, 103, 34, 119, 113, 103, 113, 34, 118, 106, 103, 34, 100, 109, 110, 102, 103, 112, 56, 34, 48, 10, Ascii.SO, 19, Ascii.SI, 6, 32, 2, 0, Ascii.VT, 6, 121, 67, 71, 90, 70, 79, 105, 75, 73, 66, 79, 4, 67, 68, 67, 94, 67, 75, 70, 67, 80, 79, 2, 3, 96, 71, 92, 65, 90, 93, 84, 19, 90, 93, 87, 86, 75, 19, 85, 90, 95, 86, 19, 85, 82, 90, 95, 86, 87, Ascii.DC4, Ascii.SYN, Ascii.DC4, Ascii.US, Ascii.DC2, 19, 40, Ascii.DC4, Ascii.CAN, Ascii.EM, 3, Ascii.DC2, Ascii.EM, 3, 40, Ascii.RS, Ascii.EM, 19, Ascii.DC2, Ascii.SI, 89, Ascii.DC2, Ascii.SI, Ascii.RS};
    }

    private void A07(HO ho2) {
        ArrayList<HJ> arrayList = this.A05.get(ho2.A04);
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                arrayList.get(size).ADC(this, ho2);
            }
        }
        this.A02.ADC(this, ho2);
    }

    private void A08(HO ho2, boolean z11) throws HI {
        HR hrA09 = this.A03.A09(ho2.A04);
        if (hrA09 == null || !hrA09.A0E(ho2)) {
            return;
        }
        this.A00 -= ho2.A01;
        if (z11) {
            try {
                this.A03.A0H(hrA09.A03);
                this.A03.A0G();
            } finally {
                A07(ho2);
            }
        }
    }

    private void A0A(C1712Vf c1712Vf) {
        this.A03.A0A(c1712Vf.A04).A09(c1712Vf);
        this.A00 += c1712Vf.A01;
        A0B(c1712Vf);
    }

    private void A0B(C1712Vf c1712Vf) {
        ArrayList<HJ> arrayList = this.A05.get(c1712Vf.A04);
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                arrayList.get(size).ADB(this, c1712Vf);
            }
        }
        this.A02.ADB(this, c1712Vf);
    }

    private void A0C(C1712Vf c1712Vf, HO ho2) {
        ArrayList<HJ> arrayList = this.A05.get(c1712Vf.A04);
        if (arrayList != null) {
            int size = arrayList.size();
            String[] strArr = A08;
            if (strArr[1].charAt(16) != strArr[2].charAt(16)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A08;
            strArr2[0] = "YjLi8Ea68WiaTq3";
            strArr2[4] = "ACi8R";
            for (int i11 = size - 1; i11 >= 0; i11--) {
                arrayList.get(i11).ADD(this, c1712Vf, ho2);
            }
        }
        this.A02.ADD(this, c1712Vf, ho2);
    }

    public static synchronized boolean A0D(File file) {
        if (A06) {
            return true;
        }
        return A09.add(file.getAbsoluteFile());
    }

    @Override // com.facebook.ads.redexgen.uinode.HK
    public final synchronized void A3a(String str, HW hw2) throws HI {
        AbstractC1351Ha.A04(!this.A01);
        this.A03.A0I(str, hw2);
        this.A03.A0G();
    }

    @Override // com.facebook.ads.redexgen.uinode.HK
    public final synchronized void A4N(File file) throws HI {
        AbstractC1351Ha.A04(!this.A01);
        C1712Vf c1712VfA00 = C1712Vf.A00(file, this.A03);
        AbstractC1351Ha.A04(c1712VfA00 != null);
        HR hrA09 = this.A03.A09(c1712VfA00.A04);
        AbstractC1351Ha.A01(hrA09);
        AbstractC1351Ha.A04(hrA09.A0D());
        if (file.exists()) {
            if (file.length() == 0) {
                file.delete();
                return;
            }
            long jA00 = HV.A00(hrA09.A05());
            if (jA00 != -1) {
                AbstractC1351Ha.A04(c1712VfA00.A02 + c1712VfA00.A01 <= jA00);
            }
            A0A(c1712VfA00);
            this.A03.A0G();
            notifyAll();
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.HK
    public final synchronized long A6F() {
        AbstractC1351Ha.A04(!this.A01);
        return this.A00;
    }

    @Override // com.facebook.ads.redexgen.uinode.HK
    public final synchronized long A6G(String str, long j11, long j12) {
        HR hrA09;
        AbstractC1351Ha.A04(!this.A01);
        hrA09 = this.A03.A09(str);
        return hrA09 != null ? hrA09.A04(j11, j12) : -j12;
    }

    @Override // com.facebook.ads.redexgen.uinode.HK
    public final synchronized NavigableSet<HO> A6H(String str) {
        HR hrA09;
        AbstractC1351Ha.A04(!this.A01);
        hrA09 = this.A03.A09(str);
        return (hrA09 == null || hrA09.A0C()) ? new TreeSet() : new TreeSet((Collection) hrA09.A08());
    }

    @Override // com.facebook.ads.redexgen.uinode.HK
    public final synchronized long A6W(String str) {
        return HV.A00(A6X(str));
    }

    @Override // com.facebook.ads.redexgen.uinode.HK
    public final synchronized HU A6X(String str) {
        AbstractC1351Ha.A04(!this.A01);
        return this.A03.A0B(str);
    }

    @Override // com.facebook.ads.redexgen.uinode.HK
    public final synchronized void AEZ(HO ho2) {
        AbstractC1351Ha.A04(!this.A01);
        HR hrA09 = this.A03.A09(ho2.A04);
        AbstractC1351Ha.A01(hrA09);
        AbstractC1351Ha.A04(hrA09.A0D());
        hrA09.A0B(false);
        this.A03.A0H(hrA09.A03);
        notifyAll();
    }

    @Override // com.facebook.ads.redexgen.uinode.HK
    public final synchronized void AF9(HO ho2) throws HI {
        AbstractC1351Ha.A04(!this.A01);
        A08(ho2, true);
    }

    @Override // com.facebook.ads.redexgen.uinode.HK
    public final synchronized void AFx(String str, long j11) throws HI {
        HW hw2 = new HW();
        HV.A05(hw2, j11);
        A3a(str, hw2);
    }

    @Override // com.facebook.ads.redexgen.uinode.HK
    public final synchronized File AGT(String str, long j11, long j12) throws HI {
        HR hrA09;
        AbstractC1351Ha.A04(!this.A01);
        hrA09 = this.A03.A09(str);
        AbstractC1351Ha.A01(hrA09);
        AbstractC1351Ha.A04(hrA09.A0D());
        if (!this.A04.exists()) {
            this.A04.mkdirs();
            A05();
        }
        this.A02.ADE(this, str, j11, j12);
        return C1712Vf.A04(this.A04, hrA09.A02, j11, System.currentTimeMillis());
    }
}
