package p007do;

import android.webkit.ConsoleMessage;
import android.webkit.GeolocationPermissions;
import android.webkit.WebView;
import io.a;
import io.h;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class h0 extends h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f63458a;

    public h0(c cVar) {
        this.f63458a = cVar;
    }

    @Override // android.webkit.WebChromeClient
    public final void onCloseWindow(WebView webView) {
        c cVar = this.f63458a;
        cVar.f63435c.accept(cVar);
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        int i11 = c.f63432g;
        consoleMessage.message();
        return true;
    }

    @Override // android.webkit.WebChromeClient
    public final void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback) {
        boolean zB;
        try {
            zB = a.b(this.f63458a.f63433a.q(), "android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION");
        } catch (Throwable unused) {
            int i11 = c.f63432g;
            zB = false;
        }
        callback.invoke(str, zB, false);
    }
}
