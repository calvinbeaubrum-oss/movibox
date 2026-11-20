package com.facebook.ads.redexgen.uinode;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import java.lang.ref.WeakReference;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Tq, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class AsyncTaskC1672Tq extends AsyncTask<String, Void, Bitmap[]> implements InterfaceC11197b {
    public static byte[] A0A;
    public static String[] A0B = {"Y", "r8ye64eLoQHeOJVpmB1uxWw1zCCHhuzX", "pvZIfONmKv3cVbimQPa9", "RLgA2SApOIsDDawooMs2KL5D8ZiCWoW1", "kM6akDIqkvY", "0vJdyNO9qrz2JF8Kt31GcmRDql8haFQB", "b8N1ZLVb0I2QrMIKflin5UtA7D7V4D", "X"};
    public int A00;
    public int A01;
    public InterfaceC1507Nh A02;
    public boolean A03;
    public final int A04;
    public final int A05;
    public final WeakReference<C1505Nf> A06;
    public final WeakReference<C1795Yn> A07;
    public final WeakReference<ImageView> A08;
    public final WeakReference<ViewGroup> A09;

    static {
        A01();
    }

    public AsyncTaskC1672Tq(ViewGroup viewGroup, int i11, int i12, C1795Yn c1795Yn) {
        this.A03 = false;
        this.A00 = -1;
        this.A01 = -1;
        this.A07 = new WeakReference<>(c1795Yn);
        this.A06 = null;
        this.A08 = null;
        this.A09 = new WeakReference<>(viewGroup);
        this.A04 = i11;
        this.A05 = i12;
    }

    public AsyncTaskC1672Tq(ViewGroup viewGroup, C1795Yn c1795Yn) {
        this(viewGroup, 12, 16, c1795Yn);
    }

    public AsyncTaskC1672Tq(ImageView imageView, C1795Yn c1795Yn) {
        this.A03 = false;
        this.A00 = -1;
        this.A01 = -1;
        this.A07 = new WeakReference<>(c1795Yn);
        this.A06 = null;
        this.A08 = new WeakReference<>(imageView);
        this.A09 = null;
        this.A04 = 0;
        this.A05 = 1;
    }

    public AsyncTaskC1672Tq(C1505Nf c1505Nf, C1795Yn c1795Yn) {
        this.A03 = false;
        this.A00 = -1;
        this.A01 = -1;
        this.A07 = new WeakReference<>(c1795Yn);
        this.A06 = new WeakReference<>(c1505Nf);
        this.A08 = null;
        this.A09 = null;
        this.A04 = 12;
        this.A05 = 16;
    }

    public static String A00(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0A, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] - i13) - 48);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A0A = new byte[]{-89, -91, -82, -91, -78, -87, -93};
    }

    private final void A02(Bitmap[] bitmapArr) throws Throwable {
        C1505Nf c1505Nf;
        if (KL.A02(this)) {
            return;
        }
        try {
            WeakReference<ImageView> weakReference = this.A08;
            if (weakReference != null) {
                ImageView imageView = weakReference.get();
                if (bitmapArr[1] != null && !this.A03 && this.A04 != 0 && imageView != null) {
                    imageView.setImageBitmap(bitmapArr[1]);
                    return;
                } else if (imageView != null) {
                    imageView.setImageBitmap(bitmapArr[0]);
                }
            }
            WeakReference<C1505Nf> weakReference2 = this.A06;
            if (weakReference2 != null && (c1505Nf = weakReference2.get()) != null) {
                c1505Nf.setImage(bitmapArr[0], bitmapArr[1]);
            }
            WeakReference<ViewGroup> weakReference3 = this.A09;
            if (weakReference3 != null && weakReference3.get() != null && bitmapArr[1] != null) {
                AbstractC1462Lo.A0S(this.A09.get(), new BitmapDrawable(this.A07.get().getResources(), bitmapArr[1]));
            }
            InterfaceC1507Nh interfaceC1507Nh = this.A02;
            if (interfaceC1507Nh != null) {
                interfaceC1507Nh.ABh(bitmapArr[0] != null);
            }
        } catch (Throwable th2) {
            KL.A00(th2, this);
        }
    }

    private final Bitmap[] A03(String... strArr) throws Throwable {
        if (KL.A02(this)) {
            return null;
        }
        try {
            String str = strArr[0];
            Bitmap bitmapA0N = null;
            Bitmap bitmapA01 = null;
            C1795Yn c1795Yn = this.A07.get();
            if (c1795Yn == null) {
                return new Bitmap[]{null, null};
            }
            try {
                bitmapA0N = new C11006c(c1795Yn).A0N(str, this.A00, this.A01);
                if (bitmapA0N != null && !this.A03) {
                    bitmapA01 = AbstractC1469Lv.A01(c1795Yn, bitmapA0N, this.A04, this.A05);
                }
            } catch (Throwable th2) {
                c1795Yn.A07().A9a(A00(0, 7, 16), C8A.A1V, new C8B(th2));
            }
            return new Bitmap[]{bitmapA0N, bitmapA01};
        } catch (Throwable th3) {
            KL.A00(th3, this);
            return null;
        }
    }

    public final AsyncTaskC1672Tq A04() {
        this.A00 = -1;
        this.A01 = -1;
        return this;
    }

    public final AsyncTaskC1672Tq A05(int i11, int i12) {
        this.A00 = i11;
        this.A01 = i12;
        return this;
    }

    public final AsyncTaskC1672Tq A06(InterfaceC1507Nh interfaceC1507Nh) {
        this.A02 = interfaceC1507Nh;
        return this;
    }

    public final void A07(String str) {
        if (!TextUtils.isEmpty(str)) {
            executeOnExecutor(ExecutorC1467Lt.A06, str);
            return;
        }
        InterfaceC1507Nh interfaceC1507Nh = this.A02;
        if (interfaceC1507Nh != null) {
            interfaceC1507Nh.ABh(false);
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC11197b
    public final C1795Yn A5t() {
        return this.A07.get();
    }

    @Override // android.os.AsyncTask
    public final /* bridge */ /* synthetic */ Bitmap[] doInBackground(String[] strArr) throws Throwable {
        if (KL.A02(this)) {
            return null;
        }
        try {
            return A03(strArr);
        } catch (Throwable th2) {
            KL.A00(th2, this);
            return null;
        }
    }

    @Override // android.os.AsyncTask
    public final /* bridge */ /* synthetic */ void onPostExecute(Bitmap[] bitmapArr) throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            A02(bitmapArr);
        } catch (Throwable th2) {
            KL.A00(th2, this);
            String[] strArr = A0B;
            if (strArr[0].length() != strArr[7].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0B;
            strArr2[0] = "X";
            strArr2[7] = "y";
        }
    }
}
