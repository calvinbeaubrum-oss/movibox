package com.journeyapps.barcodescanner.camera;

import android.hardware.Camera;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.AdaptiveTrackSelection;
import java.util.ArrayList;
import java.util.Collection;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class a {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f42580i = "a";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Collection<String> f42581j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f42582a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f42583b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f42584c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Camera f42585d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Handler f42586e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f42587f = 1;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Handler.Callback f42588g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Camera.AutoFocusCallback f42589h;

    /* JADX INFO: renamed from: com.journeyapps.barcodescanner.camera.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public class C0474a implements Handler.Callback {
        public C0474a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what != a.this.f42587f) {
                return false;
            }
            a.this.h();
            return true;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b implements Camera.AutoFocusCallback {
        public b() {
        }

        public final /* synthetic */ void b() {
            a.this.f42583b = false;
            a.this.f();
        }

        @Override // android.hardware.Camera.AutoFocusCallback
        public void onAutoFocus(boolean z11, Camera camera) {
            a.this.f42586e.post(new Runnable() { // from class: com.journeyapps.barcodescanner.camera.b
                @Override // java.lang.Runnable
                public final void run() {
                    this.f42592a.b();
                }
            });
        }
    }

    static {
        ArrayList arrayList = new ArrayList(2);
        f42581j = arrayList;
        arrayList.add("auto");
        arrayList.add("macro");
    }

    public a(Camera camera, CameraSettings cameraSettings) {
        C0474a c0474a = new C0474a();
        this.f42588g = c0474a;
        this.f42589h = new b();
        this.f42586e = new Handler(c0474a);
        this.f42585d = camera;
        String focusMode = camera.getParameters().getFocusMode();
        boolean z11 = cameraSettings.c() && f42581j.contains(focusMode);
        this.f42584c = z11;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Current focus mode '");
        sb2.append(focusMode);
        sb2.append("'; use auto focus? ");
        sb2.append(z11);
        i();
    }

    public final synchronized void f() {
        if (!this.f42582a && !this.f42586e.hasMessages(this.f42587f)) {
            Handler handler = this.f42586e;
            handler.sendMessageDelayed(handler.obtainMessage(this.f42587f), AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS);
        }
    }

    public final void g() {
        this.f42586e.removeMessages(this.f42587f);
    }

    public final void h() {
        if (!this.f42584c || this.f42582a || this.f42583b) {
            return;
        }
        try {
            this.f42585d.autoFocus(this.f42589h);
            this.f42583b = true;
        } catch (RuntimeException e11) {
            Log.w(f42580i, "Unexpected exception while focusing", e11);
            f();
        }
    }

    public void i() {
        this.f42582a = false;
        h();
    }

    public void j() {
        this.f42582a = true;
        this.f42583b = false;
        g();
        if (this.f42584c) {
            try {
                this.f42585d.cancelAutoFocus();
            } catch (RuntimeException e11) {
                Log.w(f42580i, "Unexpected exception while cancelling focusing", e11);
            }
        }
    }
}
