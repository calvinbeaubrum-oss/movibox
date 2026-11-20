package com.mbridge.msdk.video.signal.a;

import android.app.Activity;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.out.Campaign;
import com.mbridge.msdk.out.NativeListener;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public abstract class a implements com.mbridge.msdk.video.signal.d {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    protected String f48083j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    protected com.mbridge.msdk.videocommon.d.c f48084k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    protected com.mbridge.msdk.click.a f48085l;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected boolean f48074a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected boolean f48075b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected int f48076c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected int f48077d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected int f48078e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected int f48079f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected int f48080g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    protected int f48081h = 1;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    protected int f48082i = -1;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public com.mbridge.msdk.video.signal.a.InterfaceC0530a f48086m = new C0531a();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    protected int f48087n = 2;

    /* JADX INFO: renamed from: com.mbridge.msdk.video.signal.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static class C0531a implements com.mbridge.msdk.video.signal.a.InterfaceC0530a {
        @Override // com.mbridge.msdk.video.signal.a.InterfaceC0530a
        public void a() {
            ad.a("DefaultJSCommon", "onInitSuccess");
        }

        @Override // com.mbridge.msdk.video.signal.a.InterfaceC0530a
        public void a(int i11, String str) {
            ad.a("DefaultJSCommon", "onH5Error,code:" + i11 + "，msg:" + str);
        }

        @Override // com.mbridge.msdk.video.signal.a.InterfaceC0530a
        public void a(boolean z11) {
            ad.a("DefaultJSCommon", "onStartInstall");
        }

        @Override // com.mbridge.msdk.video.signal.a.InterfaceC0530a
        public void b() {
            ad.a("DefaultJSCommon", "videoLocationReady");
        }

        @Override // com.mbridge.msdk.out.NativeListener.NativeTrackingListener
        public void onDismissLoading(Campaign campaign) {
            ad.a("DefaultJSCommon", "onDismissLoading,campaign:" + campaign);
        }

        @Override // com.mbridge.msdk.out.NativeListener.NativeTrackingListener
        public void onDownloadFinish(Campaign campaign) {
            ad.a("DefaultJSCommon", "onDownloadFinish,campaign:" + campaign);
        }

        @Override // com.mbridge.msdk.out.NativeListener.NativeTrackingListener
        public void onDownloadProgress(int i11) {
            ad.a("DefaultJSCommon", "onDownloadProgress,progress:" + i11);
        }

        @Override // com.mbridge.msdk.out.NativeListener.NativeTrackingListener
        public void onDownloadStart(Campaign campaign) {
            ad.a("DefaultJSCommon", "onDownloadStart,campaign:" + campaign);
        }

        @Override // com.mbridge.msdk.out.BaseTrackingListener
        public void onFinishRedirection(Campaign campaign, String str) {
            ad.a("DefaultJSCommon", "onFinishRedirection,campaign:" + campaign + ",url:" + str);
        }

        @Override // com.mbridge.msdk.out.NativeListener.NativeTrackingListener
        public boolean onInterceptDefaultLoadingDialog() {
            ad.a("DefaultJSCommon", "onInterceptDefaultLoadingDialog");
            return false;
        }

        @Override // com.mbridge.msdk.out.BaseTrackingListener
        public void onRedirectionFailed(Campaign campaign, String str) {
            ad.a("DefaultJSCommon", "onFinishRedirection,campaign:" + campaign + ",url:" + str);
        }

        @Override // com.mbridge.msdk.out.NativeListener.NativeTrackingListener
        public void onShowLoading(Campaign campaign) {
            ad.a("DefaultJSCommon", "onShowLoading,campaign:" + campaign);
        }

        @Override // com.mbridge.msdk.out.BaseTrackingListener
        public void onStartRedirection(Campaign campaign, String str) {
            ad.a("DefaultJSCommon", "onStartRedirection,campaign:" + campaign + ",url:" + str);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class b implements com.mbridge.msdk.video.signal.a.InterfaceC0530a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private com.mbridge.msdk.video.signal.d f48088a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private com.mbridge.msdk.video.signal.a.InterfaceC0530a f48089b;

        public b(com.mbridge.msdk.video.signal.d dVar, com.mbridge.msdk.video.signal.a.InterfaceC0530a interfaceC0530a) {
            this.f48088a = dVar;
            this.f48089b = interfaceC0530a;
        }

        @Override // com.mbridge.msdk.video.signal.a.InterfaceC0530a
        public final void a() {
            com.mbridge.msdk.video.signal.a.InterfaceC0530a interfaceC0530a = this.f48089b;
            if (interfaceC0530a != null) {
                interfaceC0530a.a();
            }
        }

        @Override // com.mbridge.msdk.video.signal.a.InterfaceC0530a
        public final void a(int i11, String str) {
            com.mbridge.msdk.video.signal.a.InterfaceC0530a interfaceC0530a = this.f48089b;
            if (interfaceC0530a != null) {
                interfaceC0530a.a(i11, str);
            }
        }

        @Override // com.mbridge.msdk.video.signal.a.InterfaceC0530a
        public final void a(boolean z11) {
            com.mbridge.msdk.video.signal.a.InterfaceC0530a interfaceC0530a = this.f48089b;
            if (interfaceC0530a != null) {
                interfaceC0530a.a(z11);
            }
        }

        @Override // com.mbridge.msdk.video.signal.a.InterfaceC0530a
        public final void b() {
            com.mbridge.msdk.video.signal.a.InterfaceC0530a interfaceC0530a = this.f48089b;
            if (interfaceC0530a != null) {
                interfaceC0530a.b();
            }
        }

        @Override // com.mbridge.msdk.out.NativeListener.NativeTrackingListener
        public final void onDismissLoading(Campaign campaign) {
            com.mbridge.msdk.video.signal.a.InterfaceC0530a interfaceC0530a = this.f48089b;
            if (interfaceC0530a != null) {
                interfaceC0530a.onDismissLoading(campaign);
            }
        }

        @Override // com.mbridge.msdk.out.NativeListener.NativeTrackingListener
        public final void onDownloadFinish(Campaign campaign) {
            com.mbridge.msdk.video.signal.a.InterfaceC0530a interfaceC0530a = this.f48089b;
            if (interfaceC0530a != null) {
                interfaceC0530a.onDownloadFinish(campaign);
            }
        }

        @Override // com.mbridge.msdk.out.NativeListener.NativeTrackingListener
        public final void onDownloadProgress(int i11) {
            com.mbridge.msdk.video.signal.a.InterfaceC0530a interfaceC0530a = this.f48089b;
            if (interfaceC0530a != null) {
                interfaceC0530a.onDownloadProgress(i11);
            }
        }

        @Override // com.mbridge.msdk.out.NativeListener.NativeTrackingListener
        public final void onDownloadStart(Campaign campaign) {
            com.mbridge.msdk.video.signal.a.InterfaceC0530a interfaceC0530a = this.f48089b;
            if (interfaceC0530a != null) {
                interfaceC0530a.onDownloadStart(campaign);
            }
        }

        @Override // com.mbridge.msdk.out.BaseTrackingListener
        public final void onFinishRedirection(Campaign campaign, String str) {
            com.mbridge.msdk.video.signal.a.InterfaceC0530a interfaceC0530a = this.f48089b;
            if (interfaceC0530a != null) {
                interfaceC0530a.onFinishRedirection(campaign, str);
            }
            com.mbridge.msdk.video.signal.d dVar = this.f48088a;
            if (dVar != null) {
                dVar.d();
            }
        }

        @Override // com.mbridge.msdk.out.NativeListener.NativeTrackingListener
        public final boolean onInterceptDefaultLoadingDialog() {
            com.mbridge.msdk.video.signal.a.InterfaceC0530a interfaceC0530a = this.f48089b;
            return interfaceC0530a != null && interfaceC0530a.onInterceptDefaultLoadingDialog();
        }

        @Override // com.mbridge.msdk.out.BaseTrackingListener
        public final void onRedirectionFailed(Campaign campaign, String str) {
            com.mbridge.msdk.video.signal.a.InterfaceC0530a interfaceC0530a = this.f48089b;
            if (interfaceC0530a != null) {
                interfaceC0530a.onRedirectionFailed(campaign, str);
            }
            com.mbridge.msdk.video.signal.d dVar = this.f48088a;
            if (dVar != null) {
                dVar.d();
            }
        }

        @Override // com.mbridge.msdk.out.NativeListener.NativeTrackingListener
        public final void onShowLoading(Campaign campaign) {
            com.mbridge.msdk.video.signal.a.InterfaceC0530a interfaceC0530a = this.f48089b;
            if (interfaceC0530a != null) {
                interfaceC0530a.onShowLoading(campaign);
            }
        }

        @Override // com.mbridge.msdk.out.BaseTrackingListener
        public final void onStartRedirection(Campaign campaign, String str) {
            com.mbridge.msdk.video.signal.a.InterfaceC0530a interfaceC0530a = this.f48089b;
            if (interfaceC0530a != null) {
                interfaceC0530a.onStartRedirection(campaign, str);
            }
        }
    }

    @Override // com.mbridge.msdk.video.signal.a
    public final int a() {
        return this.f48080g;
    }

    @Override // com.mbridge.msdk.video.signal.a
    public final void a(int i11) {
        this.f48087n = i11;
    }

    @Override // com.mbridge.msdk.video.signal.a
    public void a(int i11, String str) {
        ad.a("DefaultJSCommon", "statistics,type:" + i11 + ",json:" + str);
    }

    @Override // com.mbridge.msdk.video.signal.a
    public void a(Activity activity) {
        ad.a("DefaultJSCommon", "setActivity ");
    }

    @Override // com.mbridge.msdk.video.signal.a
    public final void a(com.mbridge.msdk.video.signal.a.InterfaceC0530a interfaceC0530a) {
        ad.a("DefaultJSCommon", "setTrackingListener:" + interfaceC0530a);
        this.f48086m = interfaceC0530a;
    }

    @Override // com.mbridge.msdk.video.signal.a
    public final void a(com.mbridge.msdk.videocommon.d.c cVar) {
        ad.a("DefaultJSCommon", "setSetting:" + cVar);
        this.f48084k = cVar;
    }

    @Override // com.mbridge.msdk.video.signal.a
    public final void a(String str) {
        ad.a("DefaultJSCommon", "setUnitId:" + str);
        this.f48083j = str;
    }

    @Override // com.mbridge.msdk.video.signal.a
    public final void a(boolean z11) {
        ad.a("DefaultJSCommon", "setIsShowingTransparent:" + z11);
        this.f48075b = z11;
    }

    @Override // com.mbridge.msdk.video.signal.a
    public final void b(int i11) {
        this.f48077d = i11;
    }

    @Override // com.mbridge.msdk.video.signal.a
    public void b(String str) {
        ad.a("DefaultJSCommon", "setNotchArea");
    }

    @Override // com.mbridge.msdk.video.signal.a
    public final void b(boolean z11) {
        this.f48074a = z11;
    }

    @Override // com.mbridge.msdk.video.signal.a
    public final boolean b() {
        return this.f48074a;
    }

    @Override // com.mbridge.msdk.video.signal.a
    public String c() {
        ad.a("DefaultJSCommon", "init");
        return "{}";
    }

    @Override // com.mbridge.msdk.video.signal.a
    public final void c(int i11) {
        this.f48076c = i11;
    }

    @Override // com.mbridge.msdk.video.signal.e
    public void click(int i11, String str) {
        ad.a("DefaultJSCommon", "click:type" + i11 + ",pt:" + str);
    }

    @Override // com.mbridge.msdk.video.signal.a
    public void d() {
        ad.a("DefaultJSCommon", "finish");
    }

    @Override // com.mbridge.msdk.video.signal.a
    public final void d(int i11) {
        this.f48078e = i11;
    }

    @Override // com.mbridge.msdk.video.signal.a
    public final void e() {
        ad.a("DefaultJSCommon", "release");
        com.mbridge.msdk.click.a aVar = this.f48085l;
        if (aVar != null) {
            aVar.a(false);
            this.f48085l.a((NativeListener.NativeTrackingListener) null);
            this.f48085l.a();
        }
    }

    @Override // com.mbridge.msdk.video.signal.a
    public final void e(int i11) {
        this.f48080g = i11;
    }

    @Override // com.mbridge.msdk.video.signal.a
    public void f() {
    }

    @Override // com.mbridge.msdk.video.signal.a
    public final void f(int i11) {
        this.f48082i = i11;
    }

    @Override // com.mbridge.msdk.video.signal.a
    public final int g() {
        return this.f48082i;
    }

    @Override // com.mbridge.msdk.video.signal.a
    public String g(int i11) {
        ad.a("DefaultJSCommon", "getSDKInfo");
        return "{}";
    }

    @Override // com.mbridge.msdk.video.signal.a
    public final int h() {
        ad.a("DefaultJSCommon", "getAlertDialogRole " + this.f48081h);
        return this.f48081h;
    }

    @Override // com.mbridge.msdk.video.signal.a
    public final void h(int i11) {
        ad.a("DefaultJSCommon", "setAlertDialogRole " + i11);
        this.f48081h = i11;
    }

    @Override // com.mbridge.msdk.video.signal.e
    public void handlerH5Exception(int i11, String str) {
        ad.a("DefaultJSCommon", "handlerH5Exception,code=" + i11 + ",msg:" + str);
    }

    @Override // com.mbridge.msdk.video.signal.a
    public String i() {
        ad.a("DefaultJSCommon", "getNotchArea");
        return null;
    }

    public final int j() {
        if (this.f48076c == 0 && this.f48075b) {
            this.f48076c = 1;
        }
        return this.f48076c;
    }

    public final int k() {
        if (this.f48077d == 0 && this.f48075b) {
            this.f48077d = 1;
        }
        return this.f48077d;
    }

    public final int l() {
        if (this.f48078e == 0 && this.f48075b) {
            this.f48078e = 1;
        }
        return this.f48078e;
    }

    public final boolean m() {
        return this.f48075b;
    }
}
