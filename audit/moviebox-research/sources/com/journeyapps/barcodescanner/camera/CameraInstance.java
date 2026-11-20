package com.journeyapps.barcodescanner.camera;

import android.content.Context;
import android.os.Handler;
import android.util.Log;
import com.google.zxing.client.android.R$id;
import xn.t;
import xn.v;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class CameraInstance {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String f42557n = "CameraInstance";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public k f42558a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public j f42559b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public h f42560c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Handler f42561d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public m f42562e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Handler f42565h;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f42563f = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f42564g = true;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public CameraSettings f42566i = new CameraSettings();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Runnable f42567j = new Runnable() { // from class: com.journeyapps.barcodescanner.camera.CameraInstance.1
        @Override // java.lang.Runnable
        public void run() {
            try {
                String unused = CameraInstance.f42557n;
                CameraInstance.this.f42560c.m();
            } catch (Exception e11) {
                CameraInstance.this.w(e11);
                Log.e(CameraInstance.f42557n, "Failed to open camera", e11);
            }
        }
    };

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Runnable f42568k = new Runnable() { // from class: com.journeyapps.barcodescanner.camera.CameraInstance.2
        @Override // java.lang.Runnable
        public void run() {
            try {
                String unused = CameraInstance.f42557n;
                CameraInstance.this.f42560c.f();
                if (CameraInstance.this.f42561d != null) {
                    CameraInstance.this.f42561d.obtainMessage(R$id.zxing_prewiew_size_ready, CameraInstance.this.q()).sendToTarget();
                }
            } catch (Exception e11) {
                CameraInstance.this.w(e11);
                Log.e(CameraInstance.f42557n, "Failed to configure camera", e11);
            }
        }
    };

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Runnable f42569l = new Runnable() { // from class: com.journeyapps.barcodescanner.camera.CameraInstance.3
        @Override // java.lang.Runnable
        public void run() {
            try {
                String unused = CameraInstance.f42557n;
                CameraInstance.this.f42560c.t(CameraInstance.this.f42559b);
                CameraInstance.this.f42560c.v();
            } catch (Exception e11) {
                CameraInstance.this.w(e11);
                Log.e(CameraInstance.f42557n, "Failed to start preview", e11);
            }
        }
    };

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Runnable f42570m = new Runnable() { // from class: com.journeyapps.barcodescanner.camera.CameraInstance.4
        @Override // java.lang.Runnable
        public void run() {
            try {
                String unused = CameraInstance.f42557n;
                CameraInstance.this.f42560c.w();
                CameraInstance.this.f42560c.e();
            } catch (Exception e11) {
                Log.e(CameraInstance.f42557n, "Failed to close camera", e11);
            }
            CameraInstance.this.f42564g = true;
            CameraInstance.this.f42561d.sendEmptyMessage(R$id.zxing_camera_closed);
            CameraInstance.this.f42558a.b();
        }
    };

    public CameraInstance(Context context) {
        v.a();
        this.f42558a = k.d();
        h hVar = new h(context);
        this.f42560c = hVar;
        hVar.p(this.f42566i);
        this.f42565h = new Handler();
    }

    public void A(m mVar) {
        this.f42562e = mVar;
        this.f42560c.r(mVar);
    }

    public void B(Handler handler) {
        this.f42561d = handler;
    }

    public void C(j jVar) {
        this.f42559b = jVar;
    }

    public void D(final boolean z11) {
        v.a();
        if (this.f42563f) {
            this.f42558a.c(new Runnable() { // from class: com.journeyapps.barcodescanner.camera.e
                @Override // java.lang.Runnable
                public final void run() {
                    this.f42595a.v(z11);
                }
            });
        }
    }

    public void E() {
        v.a();
        F();
        this.f42558a.c(this.f42569l);
    }

    public final void F() {
        if (!this.f42563f) {
            throw new IllegalStateException("CameraInstance is not open");
        }
    }

    public void m(final i iVar) {
        v.a();
        if (this.f42563f) {
            this.f42558a.c(new Runnable(iVar) { // from class: com.journeyapps.barcodescanner.camera.d
                @Override // java.lang.Runnable
                public final void run() {
                    this.f42594a.s(null);
                }
            });
        }
    }

    public void n() {
        v.a();
        if (this.f42563f) {
            this.f42558a.c(this.f42570m);
        } else {
            this.f42564g = true;
        }
        this.f42563f = false;
    }

    public void o() {
        v.a();
        F();
        this.f42558a.c(this.f42568k);
    }

    public m p() {
        return this.f42562e;
    }

    public final t q() {
        return this.f42560c.i();
    }

    public boolean r() {
        return this.f42564g;
    }

    public final /* synthetic */ void s(i iVar) {
        this.f42560c.d(iVar);
    }

    public final /* synthetic */ void t(q qVar) {
        this.f42560c.n(qVar);
    }

    public final /* synthetic */ void u(final q qVar) {
        if (this.f42563f) {
            this.f42558a.c(new Runnable() { // from class: com.journeyapps.barcodescanner.camera.g
                @Override // java.lang.Runnable
                public final void run() {
                    this.f42599a.t(qVar);
                }
            });
        }
    }

    public final /* synthetic */ void v(boolean z11) {
        this.f42560c.u(z11);
    }

    public final void w(Exception exc) {
        Handler handler = this.f42561d;
        if (handler != null) {
            handler.obtainMessage(R$id.zxing_camera_error, exc).sendToTarget();
        }
    }

    public void x() {
        v.a();
        this.f42563f = true;
        this.f42564g = false;
        this.f42558a.e(this.f42567j);
    }

    public void y(final q qVar) {
        this.f42565h.post(new Runnable() { // from class: com.journeyapps.barcodescanner.camera.f
            @Override // java.lang.Runnable
            public final void run() {
                this.f42597a.u(qVar);
            }
        });
    }

    public void z(CameraSettings cameraSettings) {
        if (this.f42563f) {
            return;
        }
        this.f42566i = cameraSettings;
        this.f42560c.p(cameraSettings);
    }
}
