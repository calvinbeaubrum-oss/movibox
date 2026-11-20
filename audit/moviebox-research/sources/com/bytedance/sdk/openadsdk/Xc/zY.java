package com.bytedance.sdk.openadsdk.Xc;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.bytedance.sdk.component.ExN.Qj;
import com.bytedance.sdk.component.ExN.UFX;
import com.bytedance.sdk.component.pFF.sc.We;
import com.bytedance.sdk.component.pFF.sc.sc.sc.Ol;
import com.bytedance.sdk.openadsdk.core.Xc;
import com.bytedance.sdk.openadsdk.core.model.BT;
import com.bytedance.sdk.openadsdk.core.model.Sfl;
import com.bytedance.sdk.openadsdk.core.settings.dE;
import com.bytedance.sdk.openadsdk.utils.Cb;
import com.bytedance.sdk.openadsdk.utils.kX;
import java.lang.ref.WeakReference;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class zY {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    @SuppressLint({"StaticFieldLeak"})
    private static volatile zY f27481sc;
    private final com.bytedance.sdk.component.qr.sc pFF;
    private com.bytedance.sdk.openadsdk.Xc.sc.zY zY;

    private zY(Context context) {
        com.bytedance.sdk.component.qr.sc.C0264sc c0264sc = new com.bytedance.sdk.component.qr.sc.C0264sc();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        com.bytedance.sdk.component.qr.sc scVarSc = c0264sc.sc(10000L, timeUnit).pFF(10000L, timeUnit).zY(10000L, timeUnit).sc(true).sc();
        this.pFF = scVarSc;
        com.bytedance.sdk.component.pFF.sc.sc.sc.sc.sc(new Ol() { // from class: com.bytedance.sdk.openadsdk.Xc.zY.1
            @Override // com.bytedance.sdk.component.pFF.sc.sc.sc.Ol
            public boolean pFF() {
                return dE.ef().HC();
            }

            @Override // com.bytedance.sdk.component.pFF.sc.sc.sc.Ol
            public ExecutorService sc() {
                if (dE.ef().HC()) {
                    return Cb.WH();
                }
                return null;
            }
        });
        We weSc = scVarSc.ExN().sc();
        if (weSc != null) {
            weSc.sc(32);
        }
    }

    private void We() {
        if (this.zY == null) {
            this.zY = new com.bytedance.sdk.openadsdk.Xc.sc.zY();
        }
    }

    public static zY sc() {
        if (f27481sc == null) {
            synchronized (zY.class) {
                try {
                    if (f27481sc == null) {
                        f27481sc = new zY(Xc.sc());
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return f27481sc;
    }

    public com.bytedance.sdk.component.qr.sc pFF() {
        return this.pFF;
    }

    public void sc(int i11, final ImageView imageView, final Sfl sfl) {
        com.bytedance.sdk.openadsdk.Ol.We.sc(sfl.TRI()).sc(i11).pFF(i11).ExN(kX.We(Xc.sc())).We(kX.zY(Xc.sc())).zY(2).sc(com.bytedance.sdk.openadsdk.Ol.zY.sc(sfl, sfl.TRI(), imageView));
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.Xc.zY.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (imageView.getDrawable() != null) {
                        Intent intent = new Intent();
                        String strQr = sfl.qr();
                        intent.setAction("android.intent.action.VIEW");
                        intent.setData(Uri.parse(strQr));
                        try {
                            com.bytedance.sdk.component.utils.pFF.sc(Xc.sc(), intent, null);
                        } catch (Exception unused) {
                        }
                    }
                }
            });
        }
    }

    public void sc(BT bt2, ImageView imageView, Sfl sfl) {
        if (bt2 == null || TextUtils.isEmpty(bt2.sc()) || imageView == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.Ol.We.sc(bt2).zY(2).sc(com.bytedance.sdk.openadsdk.Ol.zY.sc(sfl, bt2.sc(), imageView));
    }

    public void sc(String str, int i11, int i12, ImageView imageView, Sfl sfl) {
        com.bytedance.sdk.openadsdk.Ol.We.sc(str).sc(i11).pFF(i12).ExN(kX.We(Xc.sc())).We(kX.zY(Xc.sc())).zY(2).sc(com.bytedance.sdk.openadsdk.Ol.zY.sc(sfl, str, imageView));
    }

    public void sc(String str, View view) {
        if (view == null || TextUtils.isEmpty(str)) {
            return;
        }
        final WeakReference weakReference = new WeakReference(view);
        com.bytedance.sdk.openadsdk.Ol.We.sc(str).zY(2).sc(new Qj() { // from class: com.bytedance.sdk.openadsdk.Xc.zY.4
            @Override // com.bytedance.sdk.component.ExN.Qj
            public Bitmap sc(Bitmap bitmap) {
                View view2 = (View) weakReference.get();
                if (view2 == null) {
                    return null;
                }
                return com.bytedance.sdk.component.adexpress.We.sc.sc(view2.getContext(), bitmap, 10);
            }
        }).sc(new com.bytedance.sdk.component.ExN.dE<Bitmap>() { // from class: com.bytedance.sdk.openadsdk.Xc.zY.3
            @Override // com.bytedance.sdk.component.ExN.dE
            public void sc(int i11, String str2, Throwable th2) {
            }

            @Override // com.bytedance.sdk.component.ExN.dE
            public void sc(UFX<Bitmap> ufx) {
                final View view2;
                if (ufx == null) {
                    return;
                }
                final Bitmap bitmapPFF = ufx.pFF();
                if (!(bitmapPFF instanceof Bitmap) || (view2 = (View) weakReference.get()) == null) {
                    return;
                }
                if (!Cb.ExN()) {
                    view2.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.Xc.zY.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            View view3 = view2;
                            if (view3 instanceof ImageView) {
                                ((ImageView) view3).setImageDrawable(new BitmapDrawable(view2.getResources(), (Bitmap) bitmapPFF));
                            } else {
                                view3.setBackground(new BitmapDrawable(view2.getResources(), (Bitmap) bitmapPFF));
                            }
                        }
                    });
                } else if (view2 instanceof ImageView) {
                    ((ImageView) view2).setImageDrawable(new BitmapDrawable(view2.getResources(), bitmapPFF));
                } else {
                    view2.setBackground(new BitmapDrawable(view2.getResources(), bitmapPFF));
                }
            }
        });
    }

    public com.bytedance.sdk.openadsdk.Xc.sc.zY zY() {
        We();
        return this.zY;
    }
}
