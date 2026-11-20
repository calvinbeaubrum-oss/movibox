package com.bytedance.sdk.openadsdk.core.Tf;

import android.os.Handler;
import android.util.Pair;
import android.view.View;
import android.webkit.WebView;
import androidx.annotation.Nullable;
import com.bytedance.sdk.component.utils.Tf;
import com.bytedance.sdk.openadsdk.core.Xc;
import com.iab.omid.library.bytedance2.adsession.FriendlyObstructionPurpose;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import p8.a;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class TRI {
    private qr pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    final Set<Pair<View, FriendlyObstructionPurpose>> f28204sc = new HashSet();

    private TRI() {
        ExN.sc(Xc.sc());
    }

    private Handler ExN() {
        return com.bytedance.sdk.component.utils.qr.pFF();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Qj() {
        qr qrVar = this.pFF;
        if (qrVar != null) {
            try {
                qrVar.zY();
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void TRI() {
        if (this.pFF != null) {
            try {
                sc((View) null, (FriendlyObstructionPurpose) null);
                this.pFF.pFF();
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pFF(int i11) {
        qr qrVar = this.pFF;
        if (qrVar != null) {
            try {
                qrVar.pFF(i11);
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pFF(@Nullable View view, @Nullable FriendlyObstructionPurpose friendlyObstructionPurpose) {
        qr qrVar = this.pFF;
        try {
            if (qrVar == null) {
                if (view == null || friendlyObstructionPurpose == null) {
                    return;
                }
                this.f28204sc.add(new Pair<>(view, friendlyObstructionPurpose));
                return;
            }
            if (view != null && friendlyObstructionPurpose != null) {
                qrVar.sc(view, friendlyObstructionPurpose);
            }
            if (this.f28204sc.size() > 0) {
                qrVar.sc(this.f28204sc);
                this.f28204sc.clear();
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pFF(View view, Set<WH> set) {
        try {
            if (this.pFF == null) {
                this.pFF = Qj.sc(view, set);
            }
        } catch (Throwable th2) {
            Tf.pFF("createVideoSession failed : ".concat(String.valueOf(th2)));
            HashMap map = new HashMap();
            map.put("scene", "createVideoSession");
            map.put("message", th2.getMessage());
            ExN.sc(map);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pFF(WebView webView) {
        try {
            if (this.pFF == null) {
                this.pFF = Qj.sc(webView);
            }
        } catch (Throwable th2) {
            Tf.pFF("createWebViewSession failed : ".concat(String.valueOf(th2)));
            HashMap map = new HashMap();
            map.put("scene", "createWebViewSession");
            map.put("message", th2.getMessage());
            ExN.sc(map);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pFF(boolean z11) {
        qr qrVar = this.pFF;
        if (qrVar != null) {
            try {
                qrVar.sc(z11);
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pFF(boolean z11, float f11) {
        if (this.pFF != null) {
            try {
                sc((View) null, (FriendlyObstructionPurpose) null);
                this.pFF.sc(z11, f11);
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qr() {
        qr qrVar = this.pFF;
        if (qrVar != null) {
            try {
                qrVar.We();
            } catch (Throwable unused) {
            }
        }
    }

    public static TRI sc() {
        return new TRI();
    }

    public void We() {
        if (a.e()) {
            Qj();
        } else {
            ExN().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.Tf.TRI.8
                @Override // java.lang.Runnable
                public void run() {
                    TRI.this.Qj();
                }
            });
        }
    }

    public void pFF() {
        if (a.e()) {
            TRI();
        } else {
            ExN().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.Tf.TRI.5
                @Override // java.lang.Runnable
                public void run() {
                    TRI.this.TRI();
                }
            });
        }
    }

    public void pFF(long j11, boolean z11) {
        qr qrVar = this.pFF;
        if (qrVar != null) {
            try {
                qrVar.sc(j11 / 1000.0f, z11);
            } catch (Throwable unused) {
            }
        }
    }

    public void sc(final int i11) {
        if (a.e()) {
            pFF(i11);
        } else {
            ExN().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.Tf.TRI.3
                @Override // java.lang.Runnable
                public void run() {
                    TRI.this.pFF(i11);
                }
            });
        }
    }

    public void sc(final long j11, final boolean z11) {
        if (a.e()) {
            pFF(j11, z11);
        } else {
            ExN().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.Tf.TRI.10
                @Override // java.lang.Runnable
                public void run() {
                    TRI.this.pFF(j11, z11);
                }
            });
        }
    }

    public void sc(@Nullable final View view, @Nullable final FriendlyObstructionPurpose friendlyObstructionPurpose) {
        if (a.e()) {
            pFF(view, friendlyObstructionPurpose);
        } else {
            ExN().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.Tf.TRI.9
                @Override // java.lang.Runnable
                public void run() {
                    TRI.this.pFF(view, friendlyObstructionPurpose);
                }
            });
        }
    }

    public void sc(final View view, final Set<WH> set) {
        if (this.pFF != null || view == null || set == null) {
            return;
        }
        if (a.e()) {
            pFF(view, set);
        } else {
            ExN().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.Tf.TRI.4
                @Override // java.lang.Runnable
                public void run() {
                    TRI.this.pFF(view, (Set<WH>) set);
                }
            });
        }
    }

    public void sc(final WebView webView) {
        if (webView == null || this.pFF != null) {
            return;
        }
        if (a.e()) {
            pFF(webView);
        } else {
            ExN().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.Tf.TRI.1
                @Override // java.lang.Runnable
                public void run() {
                    TRI.this.pFF(webView);
                }
            });
        }
    }

    public void sc(final boolean z11) {
        if (a.e()) {
            pFF(z11);
        } else {
            ExN().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.Tf.TRI.2
                @Override // java.lang.Runnable
                public void run() {
                    TRI.this.pFF(z11);
                }
            });
        }
    }

    public void sc(final boolean z11, final float f11) {
        if (a.e()) {
            pFF(z11, f11);
        } else {
            ExN().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.Tf.TRI.6
                @Override // java.lang.Runnable
                public void run() {
                    TRI.this.pFF(z11, f11);
                }
            });
        }
    }

    public void zY() {
        if (a.e()) {
            qr();
        } else {
            ExN().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.Tf.TRI.7
                @Override // java.lang.Runnable
                public void run() {
                    TRI.this.qr();
                }
            });
        }
    }
}
