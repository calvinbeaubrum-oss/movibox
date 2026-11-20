package xn;

import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.google.zxing.client.android.R$id;
import com.journeyapps.barcodescanner.camera.CameraInstance;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class m {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f80617k = "m";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public CameraInstance f80618a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public HandlerThread f80619b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Handler f80620c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public j f80621d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Handler f80622e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Rect f80623f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f80624g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Object f80625h = new Object();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Handler.Callback f80626i = new a();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final com.journeyapps.barcodescanner.camera.q f80627j = new b();

    /* JADX INFO: compiled from: source.java */
    public class a implements Handler.Callback {
        public a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i11 = message.what;
            if (i11 == R$id.zxing_decode) {
                m.this.g((u) message.obj);
                return true;
            }
            if (i11 != R$id.zxing_preview_failed) {
                return true;
            }
            m.this.h();
            return true;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b implements com.journeyapps.barcodescanner.camera.q {
        public b() {
        }

        @Override // com.journeyapps.barcodescanner.camera.q
        public void a(u uVar) {
            synchronized (m.this.f80625h) {
                try {
                    if (m.this.f80624g) {
                        m.this.f80620c.obtainMessage(R$id.zxing_decode, uVar).sendToTarget();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        @Override // com.journeyapps.barcodescanner.camera.q
        public void b(Exception exc) {
            synchronized (m.this.f80625h) {
                try {
                    if (m.this.f80624g) {
                        m.this.f80620c.obtainMessage(R$id.zxing_preview_failed).sendToTarget();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    public m(CameraInstance cameraInstance, j jVar, Handler handler) {
        v.a();
        this.f80618a = cameraInstance;
        this.f80621d = jVar;
        this.f80622e = handler;
    }

    public com.google.zxing.e f(u uVar) {
        if (this.f80623f == null) {
            return null;
        }
        return uVar.a();
    }

    public final void g(u uVar) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        uVar.d(this.f80623f);
        com.google.zxing.e eVarF = f(uVar);
        com.google.zxing.j jVarC = eVarF != null ? this.f80621d.c(eVarF) : null;
        if (jVarC != null) {
            long jCurrentTimeMillis2 = System.currentTimeMillis();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Found barcode in ");
            sb2.append(jCurrentTimeMillis2 - jCurrentTimeMillis);
            sb2.append(" ms");
            if (this.f80622e != null) {
                Message messageObtain = Message.obtain(this.f80622e, R$id.zxing_decode_succeeded, new c(jVarC, uVar));
                messageObtain.setData(new Bundle());
                messageObtain.sendToTarget();
            }
        } else {
            Handler handler = this.f80622e;
            if (handler != null) {
                Message.obtain(handler, R$id.zxing_decode_failed).sendToTarget();
            }
        }
        if (this.f80622e != null) {
            Message.obtain(this.f80622e, R$id.zxing_possible_result_points, c.f(this.f80621d.d(), uVar)).sendToTarget();
        }
        h();
    }

    public final void h() {
        this.f80618a.y(this.f80627j);
    }

    public void i(Rect rect) {
        this.f80623f = rect;
    }

    public void j(j jVar) {
        this.f80621d = jVar;
    }

    public void k() {
        v.a();
        HandlerThread handlerThread = new HandlerThread(f80617k);
        this.f80619b = handlerThread;
        handlerThread.start();
        this.f80620c = new Handler(this.f80619b.getLooper(), this.f80626i);
        this.f80624g = true;
        h();
    }

    public void l() {
        v.a();
        synchronized (this.f80625h) {
            this.f80624g = false;
            this.f80620c.removeCallbacksAndMessages(null);
            this.f80619b.quit();
        }
    }
}
