package com.facebook.ads.redexgen.uinode;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import java.util.Arrays;
import okio.Utf8;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.5n, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class AsyncTaskC10855n extends AsyncTask<C10875p, Void, Drawable> {
    public static byte[] A03;
    public static String[] A04 = {"1BJo9noXfKND6AuvSNdcB1V3GCwIAiOG", "Zj7TA2K", "dGMOiNue98uIHvh7voSV0LAZFWXYzfEv", "CcnxrNYo5kyWzKS3XGCDqe4PQiCtH", "knheqnusZFI0swerek9wKwEDBcdWqhKt", "XjDOSOe9Ixcmw73z7hfuGI1aFjWKj", "M2ugdIZCKbhB2vBaVocVLhBvD0BsDTY5", "metH7Y2aXkNKgtpuuGKiPWqQd6SU"};
    public final InterfaceC10865o A00;
    public final C1795Yn A01;
    public final boolean A02;

    static {
        A02();
    }

    public AsyncTaskC10855n(C1795Yn c1795Yn, InterfaceC10865o interfaceC10865o, boolean z11) {
        this.A01 = c1795Yn;
        this.A00 = interfaceC10865o;
        this.A02 = z11;
    }

    public /* synthetic */ AsyncTaskC10855n(C1795Yn c1795Yn, InterfaceC10865o interfaceC10865o, boolean z11, Z9 z12) {
        this(c1795Yn, interfaceC10865o, z11);
    }

    private final Drawable A00(C10875p... c10875pArr) throws Throwable {
        if (!KL.A02(this) && c10875pArr != null) {
            try {
                if (c10875pArr.length >= 1) {
                    String str = c10875pArr[0].A01;
                    String str2 = c10875pArr[0].A00;
                    Bitmap bitmapA0N = null;
                    try {
                        bitmapA0N = new C11006c(this.A01).A0N(str, -1, -1);
                    } catch (Throwable th2) {
                        this.A01.A07().A9a(A01(0, 7, 42), C8A.A1V, new C8B(th2));
                    }
                    if (bitmapA0N != null) {
                        return V2.A05(this.A01, bitmapA0N, this.A02, str2);
                    }
                    return null;
                }
            } catch (Throwable th3) {
                KL.A00(th3, this);
                return null;
            }
        }
        return null;
    }

    public static String A01(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A03, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] ^ i13) ^ 118);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A03 = new byte[]{59, 57, 50, 57, 46, 53, Utf8.REPLACEMENT_BYTE};
    }

    private final void A03(Drawable drawable) throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            this.A00.ABi(drawable);
        } catch (Throwable th2) {
            KL.A00(th2, this);
        }
    }

    @Override // android.os.AsyncTask
    public final /* bridge */ /* synthetic */ Drawable doInBackground(C10875p[] c10875pArr) throws Throwable {
        if (KL.A02(this)) {
            return null;
        }
        try {
            return A00(c10875pArr);
        } catch (Throwable th2) {
            KL.A00(th2, this);
            return null;
        }
    }

    @Override // android.os.AsyncTask
    public final /* bridge */ /* synthetic */ void onPostExecute(Drawable drawable) throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            A03(drawable);
        } catch (Throwable th2) {
            KL.A00(th2, this);
            String[] strArr = A04;
            if (strArr[0].charAt(5) != strArr[4].charAt(5)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A04;
            strArr2[1] = "H4qVqfS";
            strArr2[7] = "3NPSPTmKkS9byZNXvPXu57LevjUG";
        }
    }
}
