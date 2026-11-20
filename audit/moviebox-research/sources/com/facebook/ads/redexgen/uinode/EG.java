package com.facebook.ads.redexgen.uinode;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.ads.internal.exoplayer2.thirdparty.offline.DownloadAction;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class EG {
    public static byte[] A0F;
    public static String[] A0G = {"68X6mTnOwXdfZzYVO84LiBNlITu89iQX", "mcCM", "SB1U", "GkXNtRrGsWIfNkCQn88aLdXmD8Z6vhvm", "Qey5CsRmzWj382X", "n9", "Qz1jsOzCfP5BXHleCyslZPCOD1Jlt2Hf", "OEfF4KTHhKUz1ci9ksApPyeCZN0rEDYT"};
    public int A00;
    public boolean A01;
    public boolean A02;
    public boolean A03;
    public final int A04;
    public final int A05;
    public final Handler A06;
    public final Handler A07;
    public final HandlerThread A08;
    public final C1275Dw A09;
    public final EL A0A;
    public final ArrayList<ED> A0B;
    public final ArrayList<ED> A0C;
    public final CopyOnWriteArraySet<E9> A0D;
    public final DownloadAction.Deserializer[] A0E;

    static {
        A0C();
    }

    public EG(EL el2, int i11, int i12, File file, DownloadAction.Deserializer... deserializerArr) {
        AbstractC1351Ha.A05(deserializerArr.length > 0, A05(16, 38, 36));
        this.A0A = el2;
        this.A04 = i11;
        this.A05 = i12;
        this.A09 = new C1275Dw(file);
        this.A0E = deserializerArr;
        this.A01 = true;
        this.A0C = new ArrayList<>();
        this.A0B = new ArrayList<>();
        Looper looperMyLooper = Looper.myLooper();
        this.A07 = new Handler(looperMyLooper == null ? Looper.getMainLooper() : looperMyLooper);
        HandlerThread handlerThread = new HandlerThread(A05(54, 24, 51));
        this.A08 = handlerThread;
        handlerThread.start();
        this.A06 = new Handler(handlerThread.getLooper());
        this.A0D = new CopyOnWriteArraySet<>();
        A08();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ED A02(DownloadAction downloadAction) {
        int i11 = this.A00;
        this.A00 = i11 + 1;
        ED ed2 = new ED(i11, this, downloadAction, this.A05, null);
        this.A0C.add(ed2);
        A0J(A05(78, 13, 91), ed2);
        return ed2;
    }

    public static String A05(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0F, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] ^ i13) ^ 37);
        }
        return new String(bArrCopyOfRange);
    }

    private void A08() {
        this.A06.post(new E7(this));
    }

    private void A09() {
        if (!A0R()) {
            return;
        }
        Iterator<E9> it = this.A0D.iterator();
        while (true) {
            boolean zHasNext = it.hasNext();
            if (A0G[3].charAt(7) == 'd') {
                throw new RuntimeException();
            }
            String[] strArr = A0G;
            strArr[5] = "Uj";
            strArr[4] = "M47RheKcpZxFkBs";
            if (!zHasNext) {
                return;
            } else {
                it.next().ABg(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0A() {
        DownloadAction downloadAction;
        boolean z11;
        if (!this.A02 || this.A03) {
            return;
        }
        boolean z12 = this.A01 || this.A0B.size() == this.A04;
        for (int i11 = 0; i11 < this.A0C.size(); i11++) {
            ED ed2 = this.A0C.get(i11);
            boolean zA0E = ed2.A0E();
            if (A0G[0].charAt(7) == 'Z') {
                throw new RuntimeException();
            }
            String[] strArr = A0G;
            strArr[5] = "ZZ";
            strArr[4] = "k3SOhcJE6F5rWIN";
            if (zA0E && ((z11 = (downloadAction = ed2.A04).A03) || !z12)) {
                boolean z13 = true;
                for (int i12 = 0; i12 < i11; i12++) {
                    ED ed3 = this.A0C.get(i12);
                    if (ed3.A04.A09(downloadAction)) {
                        if (!z11) {
                            if (ed3.A04.A03) {
                                z13 = false;
                                z12 = true;
                                break;
                            }
                        } else {
                            z13 = false;
                            String str = ed2 + A05(0, 14, 3) + ed3;
                            ed3.A08();
                        }
                    }
                }
                if (z13) {
                    ed2.A0A();
                    if (!z11) {
                        this.A0B.add(ed2);
                        z12 = this.A0B.size() == this.A04;
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0B() {
        if (this.A03) {
            return;
        }
        DownloadAction[] downloadActionArr = new DownloadAction[this.A0C.size()];
        for (int i11 = 0; i11 < this.A0C.size(); i11++) {
            downloadActionArr[i11] = this.A0C.get(i11).A04;
        }
        this.A06.post(new E8(this, downloadActionArr));
    }

    public static void A0C() {
        A0F = new byte[]{6, 69, 74, 71, 85, 78, 67, 85, 6, 81, 79, 82, 78, 6, 62, 36, 64, 117, 33, 109, 100, 96, 114, 117, 33, 110, 111, 100, 33, 69, 100, 114, 100, 115, 104, 96, 109, 104, 123, 100, 115, 33, 104, 114, 33, 115, 100, 112, 116, 104, 115, 100, 101, 47, 82, 121, 97, 120, 122, 121, 119, 114, 91, 119, 120, 119, 113, 115, 100, 54, 112, Ascii.DEL, 122, 115, 54, Ascii.DEL, 57, 121, 42, Ascii.US, Ascii.CR, Ascii.NAK, 94, Ascii.ETB, Ascii.CR, 94, Ascii.US, Ascii.SUB, Ascii.SUB, Ascii.ESC, Ascii.SUB, 9, 60, 46, 54, 125, 46, 41, 60, 41, 56, 125, 52, 46, 125, 62, 53, 60, 51, 58, 56, 57};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0D(ED ed2) {
        A0J(A05(91, 21, 120), ed2);
        EF efA0K = ed2.A0K();
        Iterator<E9> it = this.A0D.iterator();
        while (true) {
            boolean zHasNext = it.hasNext();
            if (A0G[0].charAt(7) == 'Z') {
                throw new RuntimeException();
            }
            A0G[0] = "TUrgn6We5nsrVkZlQG2KUeV0nEHaGaai";
            if (!zHasNext) {
                return;
            } else {
                it.next().ADI(this, efA0K);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0E(ED ed2) {
        if (this.A03) {
            return;
        }
        boolean z11 = !ed2.A0L();
        if (z11) {
            this.A0B.remove(ed2);
        }
        A0D(ed2);
        if (A0G[3].charAt(7) == 'd') {
            throw new RuntimeException();
        }
        A0G[6] = "xCRZPuTuqF5VhljpIGNZbvIN3H6gjFvE";
        if (ed2.A0M()) {
            this.A0C.remove(ed2);
            A0B();
        }
        if (z11) {
            A0A();
            A09();
        }
    }

    public static void A0J(String str, ED ed2) {
        String str2 = str + A05(14, 2, 33) + ed2;
    }

    public final int A0O(DownloadAction downloadAction) {
        AbstractC1351Ha.A04(!this.A03);
        ED edA02 = A02(downloadAction);
        if (this.A02) {
            A0B();
            A0A();
            if (edA02.A06 == 0) {
                A0D(edA02);
            }
        }
        return edA02.A02;
    }

    public final void A0P() {
        AbstractC1351Ha.A04(!this.A03);
        if (this.A01) {
            this.A01 = false;
            A0A();
        }
    }

    public final void A0Q(E9 e11) {
        this.A0D.add(e11);
    }

    public final boolean A0R() {
        AbstractC1351Ha.A04(!this.A03);
        if (!this.A02) {
            return false;
        }
        for (int i11 = 0; i11 < this.A0C.size(); i11++) {
            if (this.A0C.get(i11).A0L()) {
                return false;
            }
        }
        return true;
    }

    public final EF[] A0S() {
        AbstractC1351Ha.A04(!this.A03);
        EF[] efArr = new EF[this.A0C.size()];
        for (int i11 = 0; i11 < efArr.length; i11++) {
            efArr[i11] = this.A0C.get(i11).A0K();
        }
        return efArr;
    }
}
