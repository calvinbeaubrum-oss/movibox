package com.facebook.ads.redexgen.uinode;

import android.support.v4.media.session.PlaybackStateCompat;
import com.applovin.exoplayer2.common.base.Ascii;
import java.io.IOException;
import java.util.Arrays;
import okio.Utf8;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Cc, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AbstractC1241Cc {
    public static byte[] A00;
    public static String[] A01 = {"bdaFL9zMZ", "I63pCoSBBbO7fDlHhIa7BrZ6Ava1cIF3", "x5nJfB3W8HSDeHix", "yyLZDQNtNFC811gZWNvs8tiPSoT", "kE4kWLsRx96QKHczqOKboI9lp", "rJUZcTDeN", "z735Hr0viTdtcy9jRTmcNapxWooAX9zU", "rl5X7GmnpjWHRCYLou0FtooQfFV"};
    public static final int[] A02;

    static {
        A01();
        A02 = new int[]{IF.A08(A00(79, 4, 69)), IF.A08(A00(59, 4, 52)), IF.A08(A00(63, 4, 84)), IF.A08(A00(67, 4, 91)), IF.A08(A00(71, 4, 20)), IF.A08(A00(75, 4, 38)), IF.A08(A00(43, 4, 41)), IF.A08(A00(55, 4, 42)), IF.A08(A00(51, 4, 57)), IF.A08(A00(87, 4, 49)), IF.A08(A00(91, 4, 122)), IF.A08(A00(0, 4, 39)), IF.A08(A00(4, 4, 108)), IF.A08(A00(19, 4, 63)), IF.A08(A00(23, 4, 97)), IF.A08(A00(8, 4, 75)), IF.A08(A00(12, 4, 105)), IF.A08(A00(31, 4, 120)), IF.A08(A00(27, 4, 15)), IF.A08(A00(47, 4, 51)), IF.A08(A00(83, 4, 41)), IF.A08(A00(35, 4, 120)), IF.A08(A00(95, 4, 11)), IF.A08(A00(39, 4, 16))};
    }

    public static String A00(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i11, i11 + i12);
        int i14 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            String[] strArr = A01;
            if (strArr[0].length() != strArr[5].length()) {
                throw new RuntimeException();
            }
            A01[3] = "MWn";
            if (i14 >= length) {
                return new String(bArrCopyOfRange);
            }
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] - i13) - 122);
            if (A01[7].length() == 12) {
                throw new RuntimeException();
            }
            A01[7] = "KMAr4";
            i14++;
        }
    }

    public static void A01() {
        A00 = new byte[]{-44, 8, -45, 2, Ascii.EM, 77, Ascii.CAN, 72, -8, 44, 42, -5, Ascii.SYN, 74, 74, Ascii.EM, -49, 3, Ascii.FF, -20, 32, 43, -17, Ascii.SO, 66, 78, 17, -42, -67, -54, -87, Utf8.REPLACEMENT_BYTE, 38, 72, Ascii.DC2, Utf8.REPLACEMENT_BYTE, 38, 72, 66, -41, -35, -40, -32, 4, Ascii.EM, 6, -44, 19, -31, 35, -51, Ascii.ESC, Ascii.CAN, 41, -28, Ascii.FF, Ascii.SUB, 7, -43, Ascii.ETB, 33, Ascii.GS, -32, 55, 65, 61, 1, 62, 72, 68, 9, -9, 1, -3, -61, 9, 19, Ascii.SI, -42, 40, 50, 46, 44, Ascii.SO, 7, 7, Ascii.FF, Ascii.CAN, Ascii.ESC, -33, -36, 97, 100, 40, 38, -10, -7, -91, -91};
    }

    public static boolean A02(int i11) {
        if ((i11 >>> 8) == IF.A08(A00(16, 3, 34))) {
            return true;
        }
        for (int i12 : A02) {
            if (i12 == i11) {
                return true;
            }
        }
        return false;
    }

    public static boolean A03(InterfaceC1234Bt interfaceC1234Bt) throws InterruptedException, IOException {
        return A05(interfaceC1234Bt, true);
    }

    public static boolean A04(InterfaceC1234Bt interfaceC1234Bt) throws InterruptedException, IOException {
        return A05(interfaceC1234Bt, false);
    }

    /* JADX WARN: Code duplicated, block: B:45:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:47:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:51:0x00f1  */
    /* JADX WARN: Code duplicated, block: B:87:0x012c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:92:0x00fb A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:95:0x00eb A[SYNTHETIC] */
    public static boolean A05(InterfaceC1234Bt interfaceC1234Bt, boolean z11) throws InterruptedException, IOException {
        boolean z12;
        long jA7I = interfaceC1234Bt.A7I();
        long j11 = PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
        long j12 = -1;
        if (jA7I != -1 && jA7I <= PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM) {
            j11 = jA7I;
        }
        int i11 = (int) j11;
        C1376Hz c1376Hz = new C1376Hz(64);
        int i12 = 0;
        boolean z13 = false;
        boolean z14 = false;
        while (true) {
            if (i12 >= i11) {
                z12 = false;
                break;
            }
            int i13 = 8;
            c1376Hz.A0W(8);
            interfaceC1234Bt.ADv(c1376Hz.A00, 0, 8);
            long jA0M = c1376Hz.A0M();
            int iA08 = c1376Hz.A08();
            if (jA0M == 1) {
                i13 = 16;
                interfaceC1234Bt.ADv(c1376Hz.A00, 8, 8);
                if (A01[3].length() == 21) {
                    throw new RuntimeException();
                }
                A01[3] = "x";
                c1376Hz.A0X(16);
                jA0M = c1376Hz.A0N();
            } else if (jA0M == 0) {
                long jA7I2 = interfaceC1234Bt.A7I();
                if (jA7I2 != j12) {
                    jA0M = (jA7I2 - interfaceC1234Bt.A7i()) + ((long) 8);
                }
            }
            if (jA0M < i13) {
                if (A01[6].length() != 14) {
                    A01[6] = "xNdZT7PF3cfE5U51qI7qEUy5Bn2I1n4";
                    return false;
                }
                A01[6] = "uC";
                return false;
            }
            i12 += i13;
            if (iA08 != CJ.A0k) {
                if (iA08 == CJ.A0j) {
                    z12 = false;
                } else if (iA08 == CJ.A0n) {
                    z12 = false;
                } else {
                    if ((((long) i12) + jA0M) - ((long) i13) >= i11) {
                        z12 = false;
                        break;
                    }
                    int i14 = (int) (jA0M - ((long) i13));
                    i12 += i14;
                    if (iA08 == CJ.A0V) {
                        if (i14 < 8) {
                            return false;
                        }
                        c1376Hz.A0W(i14);
                        interfaceC1234Bt.ADv(c1376Hz.A00, 0, i14);
                        int i15 = i14 / 4;
                        for (int i16 = 0; i16 < i15; i16++) {
                            if (A01[3].length() != 21) {
                                String[] strArr = A01;
                                strArr[2] = "gohG7oAKJXd788dq";
                                strArr[4] = "s0tItg43zYN2kAKL8Ko7hXkhv";
                                if (i16 != 1) {
                                    if (A02(c1376Hz.A08())) {
                                        z13 = true;
                                        break;
                                    }
                                } else {
                                    if (A01[7].length() != 12) {
                                        throw new RuntimeException();
                                    }
                                    A01[7] = "X5YHVW4uSpKOduvkf9RISQBbBxib";
                                    c1376Hz.A0Z(4);
                                }
                            } else {
                                if (i16 != 1) {
                                    if (A02(c1376Hz.A08())) {
                                        z13 = true;
                                        break;
                                    }
                                } else {
                                    if (A01[7].length() != 12) {
                                        throw new RuntimeException();
                                    }
                                    A01[7] = "X5YHVW4uSpKOduvkf9RISQBbBxib";
                                    c1376Hz.A0Z(4);
                                }
                            }
                        }
                        if (!z13) {
                            return false;
                        }
                    } else if (i14 != 0) {
                        interfaceC1234Bt.A3W(i14);
                    }
                    j12 = -1;
                }
                z14 = true;
                break;
            }
            j12 = -1;
        }
        if (z13 && z11 == z14) {
            return true;
        }
        return z12;
    }
}
