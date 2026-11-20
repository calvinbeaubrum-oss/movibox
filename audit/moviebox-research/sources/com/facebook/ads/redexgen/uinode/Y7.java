package com.facebook.ads.redexgen.uinode;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.ads.internal.exoplayer2.thirdparty.drm.FrameworkMediaCrypto;
import com.transsion.gslb.Worker;
import java.util.ArrayList;
import java.util.Arrays;
import okio.Utf8;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class Y7 implements AC {
    public static byte[] A04;
    public final int A00;
    public final long A01;
    public final Context A02;
    public final InterfaceC1217Bc<FrameworkMediaCrypto> A03;

    static {
        A01();
    }

    public Y7(Context context) {
        this(context, 0);
    }

    public Y7(Context context, int i11) {
        this(context, null, i11, 5000L);
    }

    @Deprecated
    public Y7(Context context, InterfaceC1217Bc<FrameworkMediaCrypto> interfaceC1217Bc, int i11, long j11) {
        this.A02 = context;
        this.A00 = i11;
        this.A01 = j11;
        this.A03 = interfaceC1217Bc;
    }

    public static String A00(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A04, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] ^ i13) ^ 84);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A04 = new byte[]{113, 80, 83, 84, 64, 89, 65, 103, 80, 91, 81, 80, 71, 80, 71, 70, 115, 84, 86, 65, 90, 71, 76, Ascii.DEL, 72, 72, 85, 72, Ascii.SUB, 83, 84, 73, 78, 91, 84, 78, 83, 91, 78, 83, 84, 93, Ascii.SUB, 124, 124, 87, 74, 95, 93, Ascii.SUB, 95, 66, 78, 95, 84, 73, 83, 85, 84, 60, Ascii.VT, Ascii.VT, Ascii.SYN, Ascii.VT, 89, Ascii.DLE, Ascii.ETB, 10, Ascii.CR, Ascii.CAN, Ascii.ETB, Ascii.CR, Ascii.DLE, Ascii.CAN, Ascii.CR, Ascii.DLE, Ascii.ETB, Ascii.RS, 89, Utf8.REPLACEMENT_BYTE, 53, 56, 58, 89, Ascii.FS, 1, Ascii.CR, Ascii.FS, Ascii.ETB, 10, Ascii.DLE, Ascii.SYN, Ascii.ETB, 59, Ascii.FF, Ascii.FF, 17, Ascii.FF, 94, Ascii.ETB, Ascii.DLE, Ascii.CR, 10, Ascii.US, Ascii.DLE, 10, Ascii.ETB, Ascii.US, 10, Ascii.ETB, Ascii.DLE, Ascii.EM, 94, 49, Ascii.SO, Ascii.VT, Ascii.CR, 94, Ascii.ESC, 6, 10, Ascii.ESC, Ascii.DLE, Ascii.CR, Ascii.ETB, 17, Ascii.DLE, Ascii.CAN, 47, 47, 50, 47, 125, 52, 51, 46, 41, 60, 51, 41, 52, 60, 41, 52, 51, 58, 125, Ascii.VT, Ascii.CR, 100, 125, 56, 37, 41, 56, 51, 46, 52, 50, 51, 93, 126, 112, 117, 116, 117, 49, 87, 119, 124, 97, 116, 118, 80, 100, 117, 120, 126, 67, 116, Ascii.DEL, 117, 116, 99, 116, 99, Utf8.REPLACEMENT_BYTE, 81, 114, 124, 121, 120, 121, 61, 81, 116, Ascii.DEL, 123, 113, 124, 126, 92, 104, 121, 116, 114, 79, 120, 115, 121, 120, 111, 120, 111, 51, 45, Ascii.SO, 0, 5, 4, 5, 65, 45, 8, 3, Ascii.SO, 17, Ascii.DC4, Ascii.DC2, 32, Ascii.DC4, 5, 8, Ascii.SO, 51, 4, Ascii.SI, 5, 4, 19, 4, 19, 79, 54, Ascii.NAK, Ascii.ESC, Ascii.RS, Ascii.US, Ascii.RS, 90, 54, 19, Ascii.CAN, Ascii.FF, 10, 2, 44, 19, Ascii.RS, Ascii.US, Ascii.NAK, 40, Ascii.US, Ascii.DC4, Ascii.RS, Ascii.US, 8, Ascii.US, 8, 84, 75, 71, 69, 6, 78, 73, 75, 77, 74, 71, 71, 67, 6, 73, 76, 91, 6, 65, 70, 92, 77, 90, 70, 73, 68, 6, 77, 80, 71, 88, 68, 73, 81, 77, 90, Ascii.SUB, 6, 77, 80, 92, 6, 78, 78, 69, 88, 77, 79, 6, 110, 78, 69, 88, 77, 79, 105, 93, 76, 65, 71, 122, 77, 70, 76, 77, 90, 77, 90, 84, 88, 90, Ascii.EM, 81, 86, 84, 82, 85, 88, 88, 92, Ascii.EM, 86, 83, 68, Ascii.EM, 94, 89, 67, 82, 69, 89, 86, 91, Ascii.EM, 82, 79, 88, 71, 91, 86, 78, 82, 69, 5, Ascii.EM, 82, 79, 67, Ascii.EM, 81, 91, 86, 84, Ascii.EM, 123, 94, 85, 81, 91, 86, 84, 118, 66, 83, 94, 88, 101, 82, 89, 83, 82, 69, 82, 69, 87, 91, 89, Ascii.SUB, 82, 85, 87, 81, 86, 91, 91, 95, Ascii.SUB, 85, 80, 71, Ascii.SUB, 93, 90, 64, 81, 70, 90, 85, 88, Ascii.SUB, 81, 76, 91, 68, 88, 85, 77, 81, 70, 6, Ascii.SUB, 81, 76, 64, Ascii.SUB, 91, 68, 65, 71, Ascii.SUB, 120, 93, 86, 91, 68, 65, 71, 117, 65, 80, 93, 91, 102, 81, 90, 80, 81, 70, 81, 70, 60, 48, 50, 113, 57, 62, 60, 58, 61, 48, 48, 52, 113, 62, 59, 44, 113, 54, 49, 43, 58, 45, 49, 62, 51, 113, 58, 39, 48, 47, 51, 62, 38, 58, 45, 109, 113, 58, 39, 43, 113, 41, 47, 102, 113, 19, 54, 61, 41, 47, 39, 9, 54, 59, 58, 48, Ascii.CR, 58, 49, 59, 58, 45, 58, 45};
    }

    private final void A02(Context context, InterfaceC1217Bc<FrameworkMediaCrypto> interfaceC1217Bc, long j11, Handler handler, InterfaceC1380Id interfaceC1380Id, int i11, ArrayList<Y5> arrayList) {
        arrayList.add(new C3F(context, DM.A00, j11, interfaceC1217Bc, false, handler, interfaceC1380Id, 50));
        if (i11 == 0) {
            return;
        }
        int size = arrayList.size();
        if (i11 == 2) {
            size--;
        }
        try {
            try {
                try {
                    arrayList.add(size, (Y5) Class.forName(A00(469, 64, 11)).getConstructor(Boolean.TYPE, Long.TYPE, Handler.class, InterfaceC1380Id.class, Integer.TYPE).newInstance(true, Long.valueOf(j11), handler, interfaceC1380Id, 50));
                    Log.i(A00(0, 23, 97), A00(243, 27, 46));
                } catch (Exception e11) {
                    e = e11;
                    throw new RuntimeException(A00(127, 33, 9), e);
                }
            } catch (Exception e12) {
                e = e12;
            }
        } catch (ClassNotFoundException unused) {
        }
    }

    private final void A03(Context context, InterfaceC1217Bc<FrameworkMediaCrypto> interfaceC1217Bc, InterfaceC1190Ab[] interfaceC1190AbArr, Handler handler, InterfaceC1198Aj interfaceC1198Aj, int i11, ArrayList<Y5> arrayList) {
        int i12;
        int i13;
        String strA00 = A00(0, 23, 97);
        arrayList.add(new C3G(context, DM.A00, interfaceC1217Bc, false, handler, interfaceC1198Aj, AU.A00(context), interfaceC1190AbArr));
        if (i11 == 0) {
            return;
        }
        int size = arrayList.size();
        if (i11 == 2) {
            size--;
        }
        try {
            i12 = size + 1;
            try {
                arrayList.add(size, (Y5) Class.forName(A00(403, 66, 96)).getConstructor(Handler.class, InterfaceC1198Aj.class, InterfaceC1190Ab[].class).newInstance(handler, interfaceC1198Aj, interfaceC1190AbArr));
                Log.i(strA00, A00(215, 28, 53));
            } catch (ClassNotFoundException unused) {
                size = i12;
                i12 = size;
            } catch (Exception e11) {
                e = e11;
                throw new RuntimeException(A00(93, 34, 42), e);
            }
        } catch (ClassNotFoundException unused2) {
        } catch (Exception e12) {
            e = e12;
        }
        try {
            i13 = i12 + 1;
            try {
                arrayList.add(i12, (Y5) Class.forName(A00(337, 66, 99)).getConstructor(Handler.class, InterfaceC1198Aj.class, InterfaceC1190Ab[].class).newInstance(handler, interfaceC1198Aj, interfaceC1190AbArr));
                Log.i(strA00, A00(187, 28, 73));
            } catch (ClassNotFoundException unused3) {
                i12 = i13;
                i13 = i12;
            } catch (Exception e13) {
                e = e13;
                throw new RuntimeException(A00(59, 34, 45), e);
            }
        } catch (ClassNotFoundException unused4) {
        } catch (Exception e14) {
            e = e14;
        }
        try {
            try {
                try {
                    arrayList.add(i13, (Y5) Class.forName(A00(270, 67, 124)).getConstructor(Handler.class, InterfaceC1198Aj.class, InterfaceC1190Ab[].class).newInstance(handler, interfaceC1198Aj, interfaceC1190AbArr));
                    Log.i(strA00, A00(160, 27, 69));
                } catch (Exception e15) {
                    e = e15;
                    throw new RuntimeException(A00(23, 36, Worker.WHAT_QUIT), e);
                }
            } catch (ClassNotFoundException unused5) {
            }
        } catch (Exception e16) {
            e = e16;
        }
    }

    private final void A04(Context context, DZ dz2, Looper looper, int i11, ArrayList<Y5> arrayList) {
        arrayList.add(new C6W(dz2, looper));
    }

    private final void A05(Context context, InterfaceC1318Fr interfaceC1318Fr, Looper looper, int i11, ArrayList<Y5> arrayList) {
        arrayList.add(new AnonymousClass63(interfaceC1318Fr, looper));
    }

    private final InterfaceC1190Ab[] A06() {
        return new InterfaceC1190Ab[0];
    }

    @Override // com.facebook.ads.redexgen.uinode.AC
    public final Y5[] A4l(Handler handler, InterfaceC1380Id interfaceC1380Id, InterfaceC1198Aj interfaceC1198Aj, InterfaceC1318Fr interfaceC1318Fr, DZ dz2, InterfaceC1217Bc<FrameworkMediaCrypto> interfaceC1217Bc) {
        InterfaceC1217Bc<FrameworkMediaCrypto> interfaceC1217Bc2 = interfaceC1217Bc;
        if (interfaceC1217Bc2 == null) {
            interfaceC1217Bc2 = null;
        }
        ArrayList<Y5> arrayList = new ArrayList<>();
        A02(this.A02, interfaceC1217Bc2, this.A01, handler, interfaceC1380Id, this.A00, arrayList);
        A03(this.A02, interfaceC1217Bc2, A06(), handler, interfaceC1198Aj, this.A00, arrayList);
        A05(this.A02, interfaceC1318Fr, handler.getLooper(), this.A00, arrayList);
        A04(this.A02, dz2, handler.getLooper(), this.A00, arrayList);
        return (Y5[]) arrayList.toArray(new Y5[arrayList.size()]);
    }
}
