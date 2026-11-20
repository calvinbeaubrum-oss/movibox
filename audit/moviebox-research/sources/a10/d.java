package a10;

import android.webkit.JavascriptInterface;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f363a;

    /* JADX INFO: compiled from: source.java */
    public interface a {
        void u(String str);
    }

    public d(a aVar) {
        this.f363a = aVar;
    }

    @JavascriptInterface
    public void performAction(String str) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("actionClicked(");
        sb2.append(str);
        sb2.append(")");
        this.f363a.u(str);
    }
}
