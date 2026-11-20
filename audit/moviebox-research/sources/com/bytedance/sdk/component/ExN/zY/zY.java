package com.bytedance.sdk.component.ExN.zY;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.widget.ImageView;
import com.bytedance.sdk.component.ExN.Ol;
import com.bytedance.sdk.component.ExN.SR;
import com.bytedance.sdk.component.ExN.UFX;
import com.bytedance.sdk.component.ExN.WH;
import com.bytedance.sdk.component.ExN.YIK;
import com.bytedance.sdk.component.ExN.dE;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class zY implements Ol {
    private boolean BT;
    private com.bytedance.sdk.component.ExN.qr Dl;
    private dE ExN;
    private com.bytedance.sdk.component.ExN.zY.sc FI;
    private boolean Gb;
    private ExecutorService HJN;
    private int II;
    private TRI JPJ;
    private boolean McK;
    private int Ol;
    private int Qj;
    private volatile boolean Ql;
    private boolean SR;
    private final Handler Sfl;
    private ImageView.ScaleType TRI;
    private WeakReference<ImageView> Tf;
    private int UFX;
    private com.bytedance.sdk.component.ExN.Qj WH;
    private com.bytedance.sdk.component.ExN.pFF WP;
    private String We;
    private int Xc;
    private boolean YIK;
    private SR cD;
    private int cvk;
    private YIK dE;
    private String pFF;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private Bitmap.Config f26532qr;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    Future<?> f26533sc;
    private int uEA;
    private Queue<com.bytedance.sdk.component.ExN.We.Ol> wjp;
    private String zY;

    /* JADX INFO: compiled from: source.java */
    public static class pFF implements WH {
        private com.bytedance.sdk.component.ExN.pFF BT;
        private ExecutorService Dl;
        private ImageView.ScaleType ExN;
        private SR JPJ;
        private int Qj;
        private boolean Ql;
        private String SR;
        private int Sfl;
        private Bitmap.Config TRI;
        private boolean Tf;
        private YIK UFX;
        private String We;
        private com.bytedance.sdk.component.ExN.Qj Xc;
        private boolean YIK;
        private TRI dE;
        private ImageView pFF;

        /* JADX INFO: renamed from: qr, reason: collision with root package name */
        private int f26535qr;

        /* JADX INFO: renamed from: sc, reason: collision with root package name */
        private dE f26536sc;
        private boolean uEA;
        private int wjp;
        private String zY;
        private int Ol = 1;
        private int WH = 5;

        public pFF(TRI tri) {
            this.dE = tri;
        }

        @Override // com.bytedance.sdk.component.ExN.WH
        public WH ExN(int i11) {
            this.Sfl = i11;
            return this;
        }

        @Override // com.bytedance.sdk.component.ExN.WH
        public WH We(int i11) {
            this.wjp = i11;
            return this;
        }

        @Override // com.bytedance.sdk.component.ExN.WH
        public WH pFF(int i11) {
            this.Qj = i11;
            return this;
        }

        @Override // com.bytedance.sdk.component.ExN.WH
        public WH pFF(String str) {
            this.SR = str;
            return this;
        }

        @Override // com.bytedance.sdk.component.ExN.WH
        public Ol sc(ImageView imageView) {
            this.pFF = imageView;
            return new zY(this).FI();
        }

        @Override // com.bytedance.sdk.component.ExN.WH
        public Ol sc(dE dEVar) {
            this.f26536sc = dEVar;
            return new zY(this).FI();
        }

        @Override // com.bytedance.sdk.component.ExN.WH
        public Ol sc(dE dEVar, int i11) {
            this.WH = i11;
            return sc(dEVar);
        }

        @Override // com.bytedance.sdk.component.ExN.WH
        public WH sc(int i11) {
            this.f26535qr = i11;
            return this;
        }

        @Override // com.bytedance.sdk.component.ExN.WH
        public WH sc(Bitmap.Config config) {
            this.TRI = config;
            return this;
        }

        @Override // com.bytedance.sdk.component.ExN.WH
        public WH sc(ImageView.ScaleType scaleType) {
            this.ExN = scaleType;
            return this;
        }

        @Override // com.bytedance.sdk.component.ExN.WH
        public WH sc(com.bytedance.sdk.component.ExN.Qj qj2) {
            this.Xc = qj2;
            return this;
        }

        @Override // com.bytedance.sdk.component.ExN.WH
        public WH sc(YIK yik) {
            this.UFX = yik;
            return this;
        }

        @Override // com.bytedance.sdk.component.ExN.WH
        public WH sc(String str) {
            this.zY = str;
            return this;
        }

        @Override // com.bytedance.sdk.component.ExN.WH
        public WH sc(boolean z11) {
            this.Ql = z11;
            return this;
        }

        @Override // com.bytedance.sdk.component.ExN.WH
        public WH zY(int i11) {
            this.Ol = i11;
            return this;
        }

        public WH zY(String str) {
            this.We = str;
            return this;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class sc implements dE {
        private dE pFF;

        public sc(dE dEVar) {
            this.pFF = dEVar;
        }

        private boolean sc(ImageView imageView) {
            Object tag;
            return (imageView == null || (tag = imageView.getTag(1094453505)) == null || !tag.equals(zY.this.zY)) ? false : true;
        }

        @Override // com.bytedance.sdk.component.ExN.dE
        public void sc(final int i11, final String str, final Throwable th2) {
            if (zY.this.Xc == 5) {
                zY.this.Sfl.post(new Runnable() { // from class: com.bytedance.sdk.component.ExN.zY.zY.sc.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (sc.this.pFF != null) {
                            sc.this.pFF.sc(i11, str, th2);
                        }
                    }
                });
                return;
            }
            dE dEVar = this.pFF;
            if (dEVar != null) {
                dEVar.sc(i11, str, th2);
            }
        }

        @Override // com.bytedance.sdk.component.ExN.dE
        public void sc(final UFX ufx) {
            Bitmap bitmapSc;
            final ImageView imageView = (ImageView) zY.this.Tf.get();
            if (imageView != null && zY.this.UFX != 3 && sc(imageView) && (ufx.pFF() instanceof Bitmap)) {
                final Bitmap bitmap = (Bitmap) ufx.pFF();
                zY.this.Sfl.post(new Runnable() { // from class: com.bytedance.sdk.component.ExN.zY.zY.sc.1
                    @Override // java.lang.Runnable
                    public void run() {
                        imageView.setImageBitmap(bitmap);
                    }
                });
            }
            try {
                if (zY.this.WH != null && (ufx.pFF() instanceof Bitmap) && (bitmapSc = zY.this.WH.sc((Bitmap) ufx.pFF())) != null) {
                    ufx.sc(bitmapSc);
                }
            } catch (Throwable unused) {
            }
            if (zY.this.Xc == 5) {
                zY.this.Sfl.postAtFrontOfQueue(new Runnable() { // from class: com.bytedance.sdk.component.ExN.zY.zY.sc.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (sc.this.pFF != null) {
                            sc.this.pFF.sc(ufx);
                        }
                    }
                });
                return;
            }
            dE dEVar = this.pFF;
            if (dEVar != null) {
                dEVar.sc(ufx);
            }
        }
    }

    private zY(pFF pff) {
        this.wjp = new LinkedBlockingQueue();
        this.Sfl = new Handler(Looper.getMainLooper());
        this.YIK = true;
        this.pFF = pff.We;
        this.ExN = new sc(pff.f26536sc);
        this.Tf = new WeakReference<>(pff.pFF);
        this.TRI = pff.ExN;
        this.f26532qr = pff.TRI;
        this.Qj = pff.f26535qr;
        this.Ol = pff.Qj;
        this.UFX = pff.Ol;
        this.Xc = pff.WH;
        this.dE = pff.UFX;
        this.WP = sc(pff);
        if (!TextUtils.isEmpty(pff.zY)) {
            pFF(pff.zY);
            sc(pff.zY);
        }
        this.SR = pff.Tf;
        this.BT = pff.Ql;
        this.JPJ = pff.dE;
        this.WH = pff.Xc;
        this.II = pff.Sfl;
        this.cvk = pff.wjp;
        this.HJN = pff.Dl;
        this.McK = pff.YIK;
        this.Gb = pff.uEA;
        this.cD = pff.JPJ;
        this.wjp.add(new com.bytedance.sdk.component.ExN.We.zY());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Ol FI() {
        try {
            TRI tri = this.JPJ;
            if (tri == null) {
                dE dEVar = this.ExN;
                if (dEVar != null) {
                    dEVar.sc(1005, "not init !", null);
                }
                return this;
            }
            ExecutorService executorServiceTRI = this.HJN == null ? tri.TRI() : null;
            Runnable runnable = new Runnable() { // from class: com.bytedance.sdk.component.ExN.zY.zY.1
                @Override // java.lang.Runnable
                public void run() {
                    com.bytedance.sdk.component.ExN.We.Ol ol2;
                    while (!zY.this.Ql && (ol2 = (com.bytedance.sdk.component.ExN.We.Ol) zY.this.wjp.poll()) != null) {
                        try {
                            if (zY.this.dE != null) {
                                zY.this.dE.sc(ol2.sc(), zY.this);
                            }
                            ol2.sc(zY.this);
                            if (zY.this.dE != null) {
                                zY.this.dE.pFF(ol2.sc(), zY.this);
                            }
                        } catch (Throwable th2) {
                            zY.this.sc(2000, th2.getMessage(), th2);
                            if (zY.this.dE != null) {
                                zY.this.dE.pFF("exception", zY.this);
                                return;
                            }
                            return;
                        }
                    }
                    if (zY.this.Ql) {
                        zY.this.sc(1003, "canceled", null);
                    }
                }
            };
            if (this.Gb) {
                runnable.run();
            } else {
                ExecutorService executorService = this.HJN;
                if (executorService != null) {
                    this.f26533sc = executorService.submit(runnable);
                } else if (executorServiceTRI != null) {
                    this.f26533sc = executorServiceTRI.submit(runnable);
                }
            }
            return this;
        } catch (Exception e11) {
            Log.e("ImageRequest", e11.getMessage());
        }
    }

    private com.bytedance.sdk.component.ExN.pFF sc(pFF pff) {
        if (pff.BT != null) {
            return pff.BT;
        }
        return !TextUtils.isEmpty(pff.SR) ? com.bytedance.sdk.component.ExN.zY.sc.sc.sc(new File(pff.SR)) : com.bytedance.sdk.component.ExN.zY.sc.sc.qr();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sc(int i11, String str, Throwable th2) {
        new com.bytedance.sdk.component.ExN.We.Qj(i11, str, th2).sc(this);
        this.wjp.clear();
    }

    public boolean BT() {
        return this.YIK;
    }

    public boolean Dl() {
        return this.McK;
    }

    @Override // com.bytedance.sdk.component.ExN.Ol
    public String ExN() {
        return this.zY;
    }

    public String JPJ() {
        return ExN() + Tf();
    }

    public dE Ol() {
        return this.ExN;
    }

    public int Qj() {
        return this.II;
    }

    public boolean Ql() {
        return this.SR;
    }

    public boolean SR() {
        return this.BT;
    }

    public TRI Sfl() {
        return this.JPJ;
    }

    @Override // com.bytedance.sdk.component.ExN.Ol
    public Bitmap.Config TRI() {
        return this.f26532qr;
    }

    public int Tf() {
        return this.UFX;
    }

    public Bitmap.Config UFX() {
        return this.f26532qr;
    }

    public String WH() {
        return this.We;
    }

    @Override // com.bytedance.sdk.component.ExN.Ol
    public ImageView.ScaleType We() {
        return this.TRI;
    }

    public int Xc() {
        return this.uEA;
    }

    public com.bytedance.sdk.component.ExN.pFF YIK() {
        return this.WP;
    }

    public com.bytedance.sdk.component.ExN.qr dE() {
        return this.Dl;
    }

    @Override // com.bytedance.sdk.component.ExN.Ol
    public int pFF() {
        return this.Qj;
    }

    public void pFF(String str) {
        WeakReference<ImageView> weakReference = this.Tf;
        if (weakReference != null && weakReference.get() != null) {
            this.Tf.get().setTag(1094453505, str);
        }
        this.zY = str;
    }

    public int qr() {
        return this.cvk;
    }

    @Override // com.bytedance.sdk.component.ExN.Ol
    public String sc() {
        return this.pFF;
    }

    public void sc(int i11) {
        this.uEA = i11;
    }

    public void sc(com.bytedance.sdk.component.ExN.qr qrVar) {
        this.Dl = qrVar;
    }

    public void sc(com.bytedance.sdk.component.ExN.zY.sc scVar) {
        this.FI = scVar;
    }

    public void sc(String str) {
        this.We = str;
    }

    public void sc(boolean z11) {
        this.YIK = z11;
    }

    public boolean sc(com.bytedance.sdk.component.ExN.We.Ol ol2) {
        if (this.Ql) {
            return false;
        }
        return this.wjp.add(ol2);
    }

    public SR uEA() {
        return this.cD;
    }

    public com.bytedance.sdk.component.ExN.zY.sc wjp() {
        return this.FI;
    }

    @Override // com.bytedance.sdk.component.ExN.Ol
    public int zY() {
        return this.Ol;
    }
}
