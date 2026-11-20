package com.bytedance.sdk.openadsdk.core.widget.sc;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ViewTreeObserver;
import android.webkit.WebBackForwardList;
import android.webkit.WebView;
import com.bytedance.sdk.component.utils.FI;
import com.bytedance.sdk.component.utils.Tf;
import com.bytedance.sdk.openadsdk.core.SR;
import com.bytedance.sdk.openadsdk.core.Xc;
import com.bytedance.sdk.openadsdk.core.model.Sfl;
import com.bytedance.sdk.openadsdk.utils.kX;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class TRI implements FI.sc {
    float BT;
    private long Gb;
    private final boolean II;
    String Ol;
    boolean Qj;
    float Ql;
    float SR;
    long Sfl;
    float Tf;
    float UFX;
    int WH;
    WebView We;
    boolean Xc;
    private boolean cD;
    long dE;
    Sfl pFF;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    boolean f28556qr;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    Context f28557sc;
    boolean wjp;
    private final Handler cvk = new FI(SR.pFF().getLooper(), this);
    String zY = "landingpage";
    int TRI = 0;
    private final String McK = ".*\\/serp\\?sc=.*&clkt=\\d+$";
    private final String HJN = ".*\\/\\?caf_results=.*&clkt=\\d+$";
    sc FI = new sc() { // from class: com.bytedance.sdk.openadsdk.core.widget.sc.TRI.1
        @Override // com.bytedance.sdk.openadsdk.core.widget.sc.TRI.sc
        public void sc() {
            TRI tri = TRI.this;
            tri.Qj = true;
            tri.TRI();
            TRI tri2 = TRI.this;
            tri2.sc(2, tri2.Ol, tri2.WH);
        }
    };
    GestureDetector WP = new GestureDetector(Xc.sc(), new GestureDetector.SimpleOnGestureListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.sc.TRI.2
        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f11, float f12) {
            TRI.this.Xc = true;
            return false;
        }
    });
    int ExN = Xc.We().gsl();
    Map<Integer, Long> YIK = new HashMap();
    Map<Integer, Float> Dl = new HashMap();
    Map<Integer, Long> uEA = new HashMap();
    List<Integer> JPJ = new ArrayList();

    /* JADX INFO: compiled from: source.java */
    public interface sc {
        void sc();
    }

    public TRI(WebView webView, Sfl sfl, Context context, boolean z11) {
        this.pFF = sfl;
        this.We = webView;
        this.f28557sc = context;
        this.II = z11;
    }

    private boolean ExN() {
        try {
            int i11 = this.WH;
            if (i11 == 2 || i11 == 3) {
                return Pattern.matches(".*\\/serp\\?sc=.*&clkt=\\d+$", this.Ol) || Pattern.matches(".*\\/\\?caf_results=.*&clkt=\\d+$", this.Ol);
            }
            return false;
        } catch (Throwable th2) {
            Tf.sc("WebArbitrageBehavior", th2.toString());
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Qj() {
        WebBackForwardList webBackForwardListCopyBackForwardList = this.We.copyBackForwardList();
        if (webBackForwardListCopyBackForwardList != null) {
            int currentIndex = webBackForwardListCopyBackForwardList.getCurrentIndex();
            this.WH = currentIndex + 1;
            if (this.II) {
                this.WH = currentIndex + 2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void TRI() {
        if (this.Dl.get(Integer.valueOf(this.WH)) != null) {
            return;
        }
        float height = this.We.getHeight() / kX.zY(this.f28557sc, this.We.getContentHeight());
        if (height < 0.0f || height > 1.0f) {
            height = 0.0f;
        }
        this.Dl.put(Integer.valueOf(this.WH), Float.valueOf(height));
    }

    private void We() {
        if (qr()) {
            return;
        }
        com.bytedance.sdk.openadsdk.SR.sc.sc scVarSc = new com.bytedance.sdk.openadsdk.SR.sc.sc.C0269sc().sc(this.Ol).sc(this.WH).We(this.UFX).ExN(this.Tf).TRI(this.BT).qr(this.Sfl).sc();
        Message messageObtain = Message.obtain();
        messageObtain.what = 100;
        messageObtain.obj = scVarSc;
        this.cvk.sendMessageDelayed(messageObtain, 20L);
    }

    private void We(String str) {
        if (qr()) {
            return;
        }
        com.bytedance.sdk.openadsdk.We.zY.sc(this.pFF, new com.bytedance.sdk.openadsdk.SR.sc.sc.C0269sc().sc(this.Ol).pFF(Uri.decode(str)).sc(), this.zY);
    }

    private void pFF(int i11) {
        if (qr() || this.JPJ.contains(Integer.valueOf(i11))) {
            return;
        }
        this.JPJ.add(Integer.valueOf(i11));
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        Long l11 = this.uEA.get(Integer.valueOf(i11));
        com.bytedance.sdk.openadsdk.We.zY.pFF(this.pFF, new com.bytedance.sdk.openadsdk.SR.sc.sc.C0269sc().sc(this.Ol).sc(this.WH).WH(jElapsedRealtime - (l11 != null ? l11.longValue() : jElapsedRealtime)).sc(), this.zY);
    }

    private boolean pFF(MotionEvent motionEvent) {
        this.Ql = motionEvent.getX();
        float y11 = motionEvent.getY();
        this.SR = y11;
        float f11 = this.Tf;
        if (y11 - f11 == 0.0f) {
            return false;
        }
        this.BT = y11 - f11;
        return true;
    }

    private boolean qr() {
        int i11 = this.TRI + 1;
        this.TRI = i11;
        if (i11 > this.ExN) {
            return true;
        }
        return ("landingpage".equals(this.zY) || "landingpage_endcard".equals(this.zY) || "landingpage_split_screen".equals(this.zY) || "landingpage_direct".equals(this.zY) || "landingpage_split_ceiling".equals(this.zY)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sc(int i11, String str, int i12) {
        if (qr()) {
            return;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        Long l11 = this.YIK.get(Integer.valueOf(i12));
        long jLongValue = l11 != null ? l11.longValue() : jElapsedRealtime;
        Float f11 = this.Dl.get(Integer.valueOf(i12));
        com.bytedance.sdk.openadsdk.We.zY.zY(this.pFF, new com.bytedance.sdk.openadsdk.SR.sc.sc.C0269sc().sc(str).sc(i12).Qj(jElapsedRealtime - jLongValue).Ol(f11 == null ? 0.0f : f11.floatValue()).pFF(i11).sc(), this.zY);
    }

    private void zY(int i11) {
        if (qr()) {
            return;
        }
        TRI();
        this.f28556qr = true;
        com.bytedance.sdk.openadsdk.SR.sc.sc scVarSc = new com.bytedance.sdk.openadsdk.SR.sc.sc.C0269sc().sc(this.Ol).sc(this.WH).sc(this.UFX).pFF(this.Tf).zY(this.Sfl).zY(i11).sc();
        try {
            if (this.cD) {
                WebView.HitTestResult hitTestResult = this.We.getHitTestResult();
                scVarSc.sc(hitTestResult.getExtra());
                scVarSc.sc(hitTestResult.getType());
            }
        } catch (Throwable unused) {
        }
        Message messageObtain = Message.obtain();
        messageObtain.what = 200;
        messageObtain.obj = scVarSc;
        this.cvk.sendMessageDelayed(messageObtain, 100L);
    }

    public void pFF() {
        this.We.getViewTreeObserver().addOnWindowFocusChangeListener(new ViewTreeObserver.OnWindowFocusChangeListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.sc.TRI.3
            @Override // android.view.ViewTreeObserver.OnWindowFocusChangeListener
            public void onWindowFocusChanged(boolean z11) {
                if (!z11) {
                    TRI tri = TRI.this;
                    if (!tri.Qj) {
                        tri.TRI();
                        long jElapsedRealtime = SystemClock.elapsedRealtime();
                        if (jElapsedRealtime - TRI.this.Gb >= 50) {
                            TRI tri2 = TRI.this;
                            tri2.sc(3, tri2.Ol, tri2.WH);
                            TRI.this.Gb = jElapsedRealtime;
                            return;
                        }
                        return;
                    }
                    tri.Qj = false;
                }
                if (z11) {
                    TRI.this.Qj();
                    TRI tri3 = TRI.this;
                    tri3.YIK.put(Integer.valueOf(tri3.WH), Long.valueOf(SystemClock.elapsedRealtime()));
                }
            }
        });
    }

    public void pFF(String str) {
        this.Ol = str;
        Qj();
        this.YIK.put(Integer.valueOf(this.WH), Long.valueOf(SystemClock.elapsedRealtime()));
        this.uEA.put(Integer.valueOf(this.WH), Long.valueOf(SystemClock.elapsedRealtime()));
        this.cD = ExN();
    }

    public void sc() {
        pFF(this.WH);
    }

    public void sc(int i11) {
        float height = (i11 + this.We.getHeight()) / kX.zY(this.f28557sc, this.We.getContentHeight());
        Float f11 = this.Dl.get(Integer.valueOf(this.WH));
        if (height > (f11 == null ? 0.0f : f11.floatValue())) {
            this.Dl.put(Integer.valueOf(this.WH), Float.valueOf(height));
        }
    }

    @Override // com.bytedance.sdk.component.utils.FI.sc
    public void sc(Message message) {
        int i11 = message.what;
        com.bytedance.sdk.openadsdk.SR.sc.sc scVar = (com.bytedance.sdk.openadsdk.SR.sc.sc) message.obj;
        if (i11 == 100) {
            scVar.We(this.Xc ? 2 : 1);
            com.bytedance.sdk.openadsdk.We.zY.We(this.pFF, scVar, this.zY);
            this.Xc = false;
        } else if (i11 == 200) {
            if (this.wjp) {
                sc(1, scVar.zY(), scVar.We());
            }
            scVar.zY(this.wjp ? 1 : 0);
            com.bytedance.sdk.openadsdk.We.zY.ExN(this.pFF, scVar, this.zY);
            this.f28556qr = false;
            this.wjp = false;
        }
    }

    public void sc(MotionEvent motionEvent) {
        this.WP.onTouchEvent(motionEvent);
        int action = motionEvent.getAction();
        if (action == 0) {
            this.UFX = motionEvent.getX();
            this.Tf = motionEvent.getY();
            this.dE = SystemClock.elapsedRealtime();
        } else if (action != 1) {
            if (action != 3) {
                return;
            }
            zY(2);
        } else {
            this.Sfl = SystemClock.elapsedRealtime() - this.dE;
            if (pFF(motionEvent)) {
                We();
            } else {
                zY(1);
            }
        }
    }

    public void sc(String str) {
        this.zY = str;
    }

    public sc zY() {
        return this.FI;
    }

    public void zY(String str) {
        if (this.f28556qr) {
            this.wjp = true;
        }
        if (this.WH == 1 && !TextUtils.isEmpty(str) && str.contains("query=")) {
            int iIndexOf = str.indexOf("query=") + 6;
            int iIndexOf2 = str.indexOf("&", iIndexOf);
            if (iIndexOf < 0 || iIndexOf2 >= str.length() || iIndexOf2 <= iIndexOf) {
                return;
            }
            We(str.substring(iIndexOf, iIndexOf2));
        }
    }
}
