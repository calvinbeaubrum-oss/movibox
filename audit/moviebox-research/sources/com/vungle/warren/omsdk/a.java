package com.vungle.warren.omsdk;

import android.webkit.WebView;
import androidx.annotation.NonNull;
import com.iab.omid.library.vungle.adsession.CreativeType;
import com.iab.omid.library.vungle.adsession.ImpressionType;
import com.iab.omid.library.vungle.adsession.Owner;
import java.util.concurrent.TimeUnit;
import sn.c;
import sn.d;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class a implements com.vungle.warren.omsdk.b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final long f62239d = TimeUnit.SECONDS.toMillis(1);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f62240a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f62241b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public sn.a f62242c;

    /* JADX INFO: compiled from: source.java */
    public static class b {
        public a a(boolean z11) {
            return new a(z11);
        }
    }

    public a(boolean z11) {
        this.f62240a = z11;
    }

    @Override // com.vungle.warren.omsdk.b
    public void a(@NonNull WebView webView) {
        if (this.f62241b && this.f62242c == null) {
            CreativeType creativeType = CreativeType.DEFINED_BY_JAVASCRIPT;
            ImpressionType impressionType = ImpressionType.DEFINED_BY_JAVASCRIPT;
            Owner owner = Owner.JAVASCRIPT;
            sn.a aVarA = sn.a.a(sn.b.a(creativeType, impressionType, owner, owner, false), c.a(d.a("Vungle", "6.12.1"), webView, null, null));
            this.f62242c = aVarA;
            aVarA.c(webView);
            this.f62242c.d();
        }
    }

    public void b() {
        if (this.f62240a && qn.a.b()) {
            this.f62241b = true;
        }
    }

    public long c() {
        long j11;
        sn.a aVar;
        if (!this.f62241b || (aVar = this.f62242c) == null) {
            j11 = 0;
        } else {
            aVar.b();
            j11 = f62239d;
        }
        this.f62241b = false;
        this.f62242c = null;
        return j11;
    }
}
