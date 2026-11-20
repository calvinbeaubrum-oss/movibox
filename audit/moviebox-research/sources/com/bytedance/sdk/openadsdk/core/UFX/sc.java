package com.bytedance.sdk.openadsdk.core.UFX;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ImageDecoder;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.resource.drawable.b;
import com.bumptech.glide.load.resource.drawable.c;
import com.bytedance.sdk.component.ExN.UFX;
import com.bytedance.sdk.component.ExN.WH;
import com.bytedance.sdk.component.ExN.dE;
import com.bytedance.sdk.component.Qj.Qj;
import com.bytedance.sdk.component.utils.TRI;
import com.bytedance.sdk.component.utils.Tf;
import com.bytedance.sdk.openadsdk.Ol.We;
import com.bytedance.sdk.openadsdk.core.Xc;
import com.bytedance.sdk.openadsdk.core.widget.ExN;
import com.bytedance.sdk.openadsdk.utils.BT;
import com.bytedance.sdk.openadsdk.utils.Cb;
import com.cloud.hisavana.sdk.internal.agentpage.AgentPageJsBridge;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class sc implements com.bytedance.adsdk.ugeno.sc {

    /* JADX INFO: compiled from: source.java */
    public static class pFF implements dE {

        /* JADX INFO: renamed from: sc, reason: collision with root package name */
        private WeakReference<ExN> f28297sc;

        public pFF(ExN exN) {
            this.f28297sc = new WeakReference<>(exN);
        }

        @Override // com.bytedance.sdk.component.ExN.dE
        public void sc(int i11, String str, Throwable th2) {
        }

        @Override // com.bytedance.sdk.component.ExN.dE
        public void sc(UFX ufx) {
            try {
                ExN exN = this.f28297sc.get();
                if (exN == null) {
                    return;
                }
                Object objPFF = ufx.pFF();
                if (!(objPFF instanceof byte[])) {
                    if (objPFF instanceof Bitmap) {
                        exN.setImageBitmap((Bitmap) objPFF);
                    }
                } else {
                    if (!ufx.ExN()) {
                        exN.setImageDrawable(BT.sc((byte[]) objPFF, 0));
                        return;
                    }
                    exN.sc((byte[]) objPFF, false);
                    exN.setRepeatConfig(true);
                    exN.pFF();
                }
            } catch (Throwable th2) {
                sc(1002, "", th2);
            }
        }
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.UFX.sc$sc, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public interface InterfaceC0297sc {
        void sc(Drawable drawable);
    }

    /* JADX INFO: compiled from: source.java */
    public static class zY implements dE {
        private final int We;
        private final sc pFF;

        /* JADX INFO: renamed from: sc, reason: collision with root package name */
        private final WeakReference<ImageView> f28298sc;
        private final int zY;

        public zY(ImageView imageView, sc scVar, int i11, int i12) {
            this.f28298sc = new WeakReference<>(imageView);
            this.pFF = scVar;
            this.zY = i11;
            this.We = i12;
        }

        @Override // com.bytedance.sdk.component.ExN.dE
        public void sc(int i11, String str, Throwable th2) {
        }

        @Override // com.bytedance.sdk.component.ExN.dE
        public void sc(UFX ufx) {
            try {
                final ImageView imageView = this.f28298sc.get();
                if (imageView == null) {
                    return;
                }
                final Object objPFF = ufx.pFF();
                if (!(objPFF instanceof byte[])) {
                    if (objPFF instanceof Bitmap) {
                        Cb.sc((Runnable) new Qj("ug_load_bitmap") { // from class: com.bytedance.sdk.openadsdk.core.UFX.sc.zY.2
                            @Override // java.lang.Runnable
                            public void run() {
                                imageView.setImageBitmap((Bitmap) objPFF);
                            }
                        });
                    }
                } else {
                    if (ufx.ExN()) {
                        if (Build.VERSION.SDK_INT <= 30) {
                            this.pFF.sc((byte[]) objPFF, imageView);
                            return;
                        } else {
                            this.pFF.sc(imageView, (byte[]) objPFF, this.zY, this.We);
                            return;
                        }
                    }
                    if (this.pFF.sc((byte[]) objPFF)) {
                        this.pFF.sc(imageView, (byte[]) objPFF, this.zY, this.We);
                        return;
                    }
                    final Bitmap bitmapSc = new com.bytedance.sdk.component.ExN.zY.pFF.sc(this.zY, this.We, imageView.getScaleType(), Bitmap.Config.RGB_565, this.zY, this.We).sc((byte[]) objPFF);
                    if (bitmapSc != null) {
                        Cb.sc((Runnable) new Qj("load_static_img") { // from class: com.bytedance.sdk.openadsdk.core.UFX.sc.zY.1
                            @Override // java.lang.Runnable
                            public void run() {
                                imageView.setImageBitmap(bitmapSc);
                            }
                        });
                    }
                }
            } catch (Throwable th2) {
                Tf.sc("ImageLoaderProvider", th2.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Drawable pFF(byte[] bArr) {
        FileOutputStream fileOutputStream;
        try {
            boolean zZY = com.bytedance.sdk.openadsdk.multipro.pFF.zY();
            File fileSc = TRI.sc(Xc.sc(), zZY, zZY ? "UGEN_GIF_AD_CACHE/" : "/UGEN_GIF_CACHE/", "TT_UGEN_GIF_FILE");
            fileOutputStream = new FileOutputStream(fileSc);
            try {
                fileOutputStream.write(bArr, 0, bArr.length);
                if (Build.VERSION.SDK_INT >= 28) {
                    Drawable drawableDecodeDrawable = ImageDecoder.decodeDrawable(ImageDecoder.createSource(fileSc));
                    try {
                        fileOutputStream.close();
                    } catch (Throwable unused) {
                    }
                    return drawableDecodeDrawable;
                }
                BitmapDrawable bitmapDrawable = new BitmapDrawable(Xc.sc().getResources(), BitmapFactory.decodeByteArray(bArr, 0, bArr.length));
                try {
                    fileOutputStream.close();
                } catch (Throwable unused2) {
                }
                return bitmapDrawable;
            } catch (Throwable th2) {
                th = th2;
                try {
                    Tf.sc("ImageLoaderProvider", "GifView  getSourceByFile fail : ", th);
                    return null;
                } finally {
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Throwable unused3) {
                        }
                    }
                }
            }
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
        }
    }

    private void pFF(final ImageView imageView, byte[] bArr, int i11, int i12) {
        final Bitmap bitmapSc = new com.bytedance.sdk.component.ExN.zY.pFF.sc(i11, i12, imageView.getScaleType(), Bitmap.Config.ARGB_4444, i11, i12).sc(bArr);
        if (bitmapSc != null) {
            Cb.sc((Runnable) new Qj("loadStaticImage") { // from class: com.bytedance.sdk.openadsdk.core.UFX.sc.2
                @Override // java.lang.Runnable
                public void run() {
                    imageView.setImageBitmap(bitmapSc);
                }
            });
        }
    }

    private String sc(String str) {
        if (TextUtils.isEmpty(str) || str.startsWith("http://") || str.startsWith(AgentPageJsBridge.HTTPS)) {
            return str;
        }
        if (str.indexOf(46) < 0) {
            str = str + ".png";
        }
        return com.bytedance.sdk.openadsdk.core.settings.dE.ef().PPh() + "static/" + str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sc(final ImageView imageView, byte[] bArr, int i11, int i12) {
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
        if (Build.VERSION.SDK_INT < 28) {
            pFF(imageView, bArr, i11, i12);
            return;
        }
        try {
            final Drawable drawableDecodeDrawable = ImageDecoder.decodeDrawable(ImageDecoder.createSource(byteBufferWrap));
            if (drawableDecodeDrawable != null) {
                Cb.sc((Runnable) new Qj("loadAnimatedDrawable") { // from class: com.bytedance.sdk.openadsdk.core.UFX.sc.1
                    @Override // java.lang.Runnable
                    public void run() {
                        imageView.setImageDrawable(drawableDecodeDrawable);
                    }
                });
            }
        } catch (IOException e11) {
            Tf.sc("ImageLoaderProvider", e11.getMessage());
        }
    }

    private void sc(com.bytedance.adsdk.ugeno.core.Qj qj2, @NonNull WH wh2, String str) {
        Map<String, Object> mapPFF;
        if (qj2 == null || (mapPFF = qj2.pFF()) == null) {
            return;
        }
        Object obj = mapPFF.get("image_info");
        if (obj instanceof Map) {
            wh2.sc((String) ((Map) obj).get(str));
        }
        String str2 = (String) mapPFF.get("cache_dir");
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        wh2.pFF(str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sc(byte[] bArr, final ImageView imageView) {
        try {
            Tf.sc("ImageLoaderProvider", "load animation image");
            sc(bArr, new InterfaceC0297sc() { // from class: com.bytedance.sdk.openadsdk.core.UFX.sc.3
                @Override // com.bytedance.sdk.openadsdk.core.UFX.sc.InterfaceC0297sc
                public void sc(final Drawable drawable) {
                    Cb.sc(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.UFX.sc.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (Build.VERSION.SDK_INT >= 28 && b.a(drawable)) {
                                c.a(drawable).start();
                            }
                            imageView.setImageDrawable(drawable);
                        }
                    });
                }
            });
        } catch (Exception e11) {
            Tf.sc("ImageLoaderProvider", e11.getMessage());
        }
    }

    private void sc(final byte[] bArr, final InterfaceC0297sc interfaceC0297sc) {
        Cb.pFF(new Qj("pag_animation_drawable") { // from class: com.bytedance.sdk.openadsdk.core.UFX.sc.4
            @Override // java.lang.Runnable
            public void run() {
                Drawable drawablePFF = sc.this.pFF(bArr);
                InterfaceC0297sc interfaceC0297sc2 = interfaceC0297sc;
                if (interfaceC0297sc2 != null) {
                    interfaceC0297sc2.sc(drawablePFF);
                }
            }
        });
    }

    public void pFF(com.bytedance.adsdk.ugeno.core.Qj qj2, String str, final com.bytedance.adsdk.ugeno.sc.InterfaceC0235sc interfaceC0235sc) {
        WH whZY = We.sc(str).zY(1);
        sc(qj2, whZY, str);
        whZY.sc(new dE() { // from class: com.bytedance.sdk.openadsdk.core.UFX.sc.5
            @Override // com.bytedance.sdk.component.ExN.dE
            public void sc(int i11, String str2, Throwable th2) {
                com.bytedance.adsdk.ugeno.sc.InterfaceC0235sc interfaceC0235sc2 = interfaceC0235sc;
                if (interfaceC0235sc2 != null) {
                    interfaceC0235sc2.sc(null);
                }
            }

            @Override // com.bytedance.sdk.component.ExN.dE
            public void sc(UFX ufx) {
                if (ufx == null) {
                    interfaceC0235sc.sc(null);
                    return;
                }
                if (interfaceC0235sc != null) {
                    Object objPFF = ufx.pFF();
                    if (objPFF instanceof Bitmap) {
                        interfaceC0235sc.sc((Bitmap) objPFF);
                        return;
                    }
                    if (ufx.pFF() instanceof byte[]) {
                        try {
                            interfaceC0235sc.sc(BitmapFactory.decodeByteArray((byte[]) ufx.pFF(), 0, ((byte[]) ufx.pFF()).length));
                            return;
                        } catch (Throwable unused) {
                        }
                    }
                    interfaceC0235sc.sc(null);
                }
            }
        }, 4);
    }

    @Override // com.bytedance.adsdk.ugeno.sc
    public void sc(com.bytedance.adsdk.ugeno.core.Qj qj2, String str, ImageView imageView) {
        String strSc = sc(str);
        if (!(imageView instanceof ExN)) {
            WH whSc = We.sc(strSc);
            sc(qj2, whSc, strSc);
            whSc.sc(imageView);
        } else {
            ExN exN = (ExN) imageView;
            exN.setAdjustViewBounds(true);
            exN.setBackgroundColor(0);
            We.sc(strSc).zY(3).sc(Bitmap.Config.RGB_565).sc(new pFF(exN));
        }
    }

    @Override // com.bytedance.adsdk.ugeno.sc
    public void sc(com.bytedance.adsdk.ugeno.core.Qj qj2, String str, ImageView imageView, int i11, int i12) {
        String strSc = sc(str);
        WH whZY = We.sc(strSc).zY(3);
        sc(qj2, whZY, strSc);
        whZY.sc(new zY(imageView, this, i11, i12), 4);
    }

    @Override // com.bytedance.adsdk.ugeno.sc
    public void sc(com.bytedance.adsdk.ugeno.core.Qj qj2, String str, com.bytedance.adsdk.ugeno.sc.InterfaceC0235sc interfaceC0235sc) {
        pFF(qj2, sc(str), interfaceC0235sc);
    }

    public boolean sc(byte[] bArr) {
        return com.bytedance.sdk.component.adexpress.We.TRI.sc(bArr, 0);
    }
}
