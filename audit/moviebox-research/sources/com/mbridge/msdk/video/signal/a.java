package com.mbridge.msdk.video.signal;

import android.app.Activity;
import com.mbridge.msdk.out.NativeListener;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public interface a extends e {

    /* JADX INFO: renamed from: com.mbridge.msdk.video.signal.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public interface InterfaceC0530a extends NativeListener.NativeTrackingListener {
        void a();

        void a(int i11, String str);

        void a(boolean z11);

        void b();
    }

    int a();

    void a(int i11);

    void a(int i11, String str);

    void a(Activity activity);

    void a(InterfaceC0530a interfaceC0530a);

    void a(com.mbridge.msdk.videocommon.d.c cVar);

    void a(String str);

    void a(boolean z11);

    void b(int i11);

    void b(String str);

    void b(boolean z11);

    boolean b();

    String c();

    void c(int i11);

    void d();

    void d(int i11);

    void e();

    void e(int i11);

    void f();

    void f(int i11);

    int g();

    String g(int i11);

    int h();

    void h(int i11);

    String i();
}
