package com.journeyapps.barcodescanner.camera;

import android.content.Context;
import android.hardware.Camera;
import android.os.Build;
import android.util.Log;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import xn.t;
import xn.u;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class h {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String f42601n = "h";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Camera f42602a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Camera.CameraInfo f42603b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.journeyapps.barcodescanner.camera.a f42604c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public fm.b f42605d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f42606e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f42607f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public m f42609h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public t f42610i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public t f42611j;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Context f42613l;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public CameraSettings f42608g = new CameraSettings();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f42612k = -1;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final a f42614m = new a();

    /* JADX INFO: compiled from: source.java */
    public final class a implements Camera.PreviewCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public q f42615a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public t f42616b;

        public a() {
        }

        public void a(q qVar) {
            this.f42615a = qVar;
        }

        public void b(t tVar) {
            this.f42616b = tVar;
        }

        @Override // android.hardware.Camera.PreviewCallback
        public void onPreviewFrame(byte[] bArr, Camera camera) {
            t tVar = this.f42616b;
            q qVar = this.f42615a;
            if (tVar == null || qVar == null) {
                String unused = h.f42601n;
                if (qVar != null) {
                    qVar.b(new Exception("No resolution available"));
                    return;
                }
                return;
            }
            try {
                if (bArr == null) {
                    throw new NullPointerException("No preview data received");
                }
                u uVar = new u(bArr, tVar.f80643a, tVar.f80644b, camera.getParameters().getPreviewFormat(), h.this.g());
                if (h.this.f42603b.facing == 1) {
                    uVar.e(true);
                }
                qVar.a(uVar);
            } catch (RuntimeException e11) {
                Log.e(h.f42601n, "Camera preview failed", e11);
                qVar.b(e11);
            }
        }
    }

    public h(Context context) {
        this.f42613l = context;
    }

    public static List<t> j(Camera.Parameters parameters) {
        List<Camera.Size> supportedPreviewSizes = parameters.getSupportedPreviewSizes();
        ArrayList arrayList = new ArrayList();
        if (supportedPreviewSizes == null) {
            Camera.Size previewSize = parameters.getPreviewSize();
            if (previewSize != null) {
                new t(previewSize.width, previewSize.height);
                arrayList.add(new t(previewSize.width, previewSize.height));
            }
            return arrayList;
        }
        for (Camera.Size size : supportedPreviewSizes) {
            arrayList.add(new t(size.width, size.height));
        }
        return arrayList;
    }

    public final int c() {
        int iC = this.f42609h.c();
        int i11 = 0;
        if (iC != 0) {
            if (iC == 1) {
                i11 = 90;
            } else if (iC == 2) {
                i11 = 180;
            } else if (iC == 3) {
                i11 = 270;
            }
        }
        Camera.CameraInfo cameraInfo = this.f42603b;
        int i12 = cameraInfo.facing == 1 ? (360 - ((cameraInfo.orientation + i11) % 360)) % 360 : ((cameraInfo.orientation - i11) + 360) % 360;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Camera Display Orientation: ");
        sb2.append(i12);
        return i12;
    }

    public void d(i iVar) {
        Camera camera = this.f42602a;
        if (camera != null) {
            try {
                camera.setParameters(iVar.a(camera.getParameters()));
            } catch (RuntimeException e11) {
                Log.e(f42601n, "Failed to change camera parameters", e11);
            }
        }
    }

    public void e() {
        Camera camera = this.f42602a;
        if (camera != null) {
            camera.release();
            this.f42602a = null;
        }
    }

    public void f() {
        if (this.f42602a == null) {
            throw new RuntimeException("Camera not open");
        }
        s();
    }

    public int g() {
        return this.f42612k;
    }

    public final Camera.Parameters h() {
        Camera.Parameters parameters = this.f42602a.getParameters();
        String str = this.f42607f;
        if (str == null) {
            this.f42607f = parameters.flatten();
        } else {
            parameters.unflatten(str);
        }
        return parameters;
    }

    public t i() {
        if (this.f42611j == null) {
            return null;
        }
        return k() ? this.f42611j.c() : this.f42611j;
    }

    public boolean k() {
        int i11 = this.f42612k;
        if (i11 != -1) {
            return i11 % 180 != 0;
        }
        throw new IllegalStateException("Rotation not calculated yet. Call configure() first.");
    }

    public boolean l() {
        String flashMode;
        Camera.Parameters parameters = this.f42602a.getParameters();
        if (parameters == null || (flashMode = parameters.getFlashMode()) == null) {
            return false;
        }
        return "on".equals(flashMode) || "torch".equals(flashMode);
    }

    public void m() {
        Camera cameraB = gm.a.b(this.f42608g.b());
        this.f42602a = cameraB;
        if (cameraB == null) {
            throw new RuntimeException("Failed to open camera");
        }
        int iA = gm.a.a(this.f42608g.b());
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        this.f42603b = cameraInfo;
        Camera.getCameraInfo(iA, cameraInfo);
    }

    public void n(q qVar) {
        Camera camera = this.f42602a;
        if (camera == null || !this.f42606e) {
            return;
        }
        this.f42614m.a(qVar);
        camera.setOneShotPreviewCallback(this.f42614m);
    }

    public final void o(int i11) {
        this.f42602a.setDisplayOrientation(i11);
    }

    public void p(CameraSettings cameraSettings) {
        this.f42608g = cameraSettings;
    }

    public final void q(boolean z11) {
        Camera.Parameters parametersH = h();
        if (parametersH == null) {
            Log.w(f42601n, "Device error: no camera parameters are available. Proceeding without configuration.");
            return;
        }
        String str = f42601n;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Initial camera parameters: ");
        sb2.append(parametersH.flatten());
        if (z11) {
            Log.w(str, "In camera config safe mode -- most settings will not be honored");
        }
        c.g(parametersH, this.f42608g.a(), z11);
        if (!z11) {
            c.k(parametersH, false);
            if (this.f42608g.h()) {
                c.i(parametersH);
            }
            if (this.f42608g.e()) {
                c.c(parametersH);
            }
            if (this.f42608g.g()) {
                c.l(parametersH);
                c.h(parametersH);
                c.j(parametersH);
            }
        }
        List<t> listJ = j(parametersH);
        if (listJ.size() == 0) {
            this.f42610i = null;
        } else {
            t tVarA = this.f42609h.a(listJ, k());
            this.f42610i = tVarA;
            parametersH.setPreviewSize(tVarA.f80643a, tVarA.f80644b);
        }
        if (Build.DEVICE.equals("glass-1")) {
            c.e(parametersH);
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append("Final camera parameters: ");
        sb3.append(parametersH.flatten());
        this.f42602a.setParameters(parametersH);
    }

    public void r(m mVar) {
        this.f42609h = mVar;
    }

    public final void s() {
        try {
            int iC = c();
            this.f42612k = iC;
            o(iC);
        } catch (Exception unused) {
            Log.w(f42601n, "Failed to set rotation.");
        }
        try {
            q(false);
        } catch (Exception unused2) {
            try {
                q(true);
            } catch (Exception unused3) {
                Log.w(f42601n, "Camera rejected even safe-mode parameters! No configuration");
            }
        }
        Camera.Size previewSize = this.f42602a.getParameters().getPreviewSize();
        if (previewSize == null) {
            this.f42611j = this.f42610i;
        } else {
            this.f42611j = new t(previewSize.width, previewSize.height);
        }
        this.f42614m.b(this.f42611j);
    }

    public void t(j jVar) throws IOException {
        jVar.a(this.f42602a);
    }

    public void u(boolean z11) {
        if (this.f42602a != null) {
            try {
                if (z11 != l()) {
                    com.journeyapps.barcodescanner.camera.a aVar = this.f42604c;
                    if (aVar != null) {
                        aVar.j();
                    }
                    Camera.Parameters parameters = this.f42602a.getParameters();
                    c.k(parameters, z11);
                    if (this.f42608g.f()) {
                        c.d(parameters, z11);
                    }
                    this.f42602a.setParameters(parameters);
                    com.journeyapps.barcodescanner.camera.a aVar2 = this.f42604c;
                    if (aVar2 != null) {
                        aVar2.i();
                    }
                }
            } catch (RuntimeException e11) {
                Log.e(f42601n, "Failed to set torch", e11);
            }
        }
    }

    public void v() {
        Camera camera = this.f42602a;
        if (camera == null || this.f42606e) {
            return;
        }
        camera.startPreview();
        this.f42606e = true;
        this.f42604c = new com.journeyapps.barcodescanner.camera.a(this.f42602a, this.f42608g);
        fm.b bVar = new fm.b(this.f42613l, this, this.f42608g);
        this.f42605d = bVar;
        bVar.d();
    }

    public void w() {
        com.journeyapps.barcodescanner.camera.a aVar = this.f42604c;
        if (aVar != null) {
            aVar.j();
            this.f42604c = null;
        }
        fm.b bVar = this.f42605d;
        if (bVar != null) {
            bVar.e();
            this.f42605d = null;
        }
        Camera camera = this.f42602a;
        if (camera == null || !this.f42606e) {
            return;
        }
        camera.stopPreview();
        this.f42614m.a(null);
        this.f42606e = false;
    }
}
