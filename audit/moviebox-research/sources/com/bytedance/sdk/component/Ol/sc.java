package com.bytedance.sdk.component.Ol;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.webkit.WebView;
import com.bytedance.sdk.component.utils.FI;
import com.bytedance.sdk.component.utils.WP;
import com.bytedance.sdk.component.utils.qr;
import com.hisavana.common.tracking.TrackingKey;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class sc implements View.OnTouchListener, FI.sc {
    private ViewConfiguration Dl;
    private final int ExN;
    private volatile float Qj;
    private int Ql;
    private String Sfl;
    private final Context TRI;
    private long Tf;
    private long UFX;
    private final List<Integer> We;
    private float Xc;
    private View.OnTouchListener YIK;
    private boolean dE;
    private final int pFF;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private volatile float f26548qr;
    private float wjp;
    private final int zY;
    private float Ol = -1.0f;
    private float WH = -1.0f;
    private final Handler BT = new FI(qr.sc().getLooper(), this);

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    InterfaceC0245sc f26549sc = new InterfaceC0245sc() { // from class: com.bytedance.sdk.component.Ol.sc.1
        @Override // com.bytedance.sdk.component.Ol.sc.InterfaceC0245sc
        public void sc() {
            if (sc.this.Ol == -1.0f && sc.this.WH == -1.0f && sc.this.Tf == -1) {
                float unused = sc.this.Ol;
                float unused2 = sc.this.WH;
                sc scVar = sc.this;
                scVar.Ol = scVar.f26548qr;
                sc scVar2 = sc.this;
                scVar2.WH = scVar2.Qj;
                sc scVar3 = sc.this;
                scVar3.Tf = scVar3.UFX;
                sc.this.dE = true;
            }
            float unused3 = sc.this.Ol;
            float unused4 = sc.this.WH;
        }

        @Override // com.bytedance.sdk.component.Ol.sc.InterfaceC0245sc
        public void sc(int i11) {
            sc.this.Ql = i11;
            sc.this.pFF();
        }
    };
    private int uEA = -1;
    private final List<Integer> SR = new ArrayList();

    /* JADX INFO: renamed from: com.bytedance.sdk.component.Ol.sc$sc, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public interface InterfaceC0245sc {
        void sc();

        void sc(int i11);
    }

    public sc(Context context, int i11, int i12, List<Integer> list, int i13) {
        this.TRI = context;
        if (i11 == -1) {
            this.pFF = WP.sc(context);
        } else {
            this.pFF = WP.sc(context, i11);
        }
        this.zY = WP.sc(context, i12);
        this.We = list;
        this.ExN = i13;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pFF() {
        this.Ol = -1.0f;
        this.WH = -1.0f;
        this.Tf = -1L;
    }

    private int sc(float f11, float f12, long j11) {
        if (this.Ol == -1.0f && this.WH == -1.0f && this.Tf == -1) {
            return 1;
        }
        if (!this.We.contains(Integer.valueOf(this.Ql))) {
            return 2;
        }
        if (j11 - this.Tf > this.ExN) {
            pFF();
            return 3;
        }
        float fAbs = Math.abs(f11 - this.Ol);
        float fAbs2 = Math.abs(f12 - this.WH);
        if (fAbs <= this.pFF / 2.0f && fAbs2 <= this.zY / 2.0f) {
            return 0;
        }
        pFF();
        return 4;
    }

    private void sc(View view, MotionEvent motionEvent, int i11, boolean z11) {
        String url;
        JSONObject jSONObject = new JSONObject();
        WebView webView = view instanceof WebView ? (WebView) view : null;
        if (webView != null) {
            try {
                url = webView.getUrl();
            } catch (Throwable unused) {
            }
        } else {
            url = "";
        }
        jSONObject.put("arbi_current_url", url);
        jSONObject.put(TrackingKey.CLICK_X, motionEvent.getX());
        jSONObject.put(TrackingKey.CLICK_Y, motionEvent.getY());
        jSONObject.put("is_interceptor", i11 == 0 ? 1 : 0);
        jSONObject.put("is_first_click", z11 ? 1 : 0);
        jSONObject.put("click_timestamp", System.currentTimeMillis());
        jSONObject.put("arbi_interceptor_type", i11);
        jSONObject.put("current_url_index", this.Ql);
        Message messageObtain = Message.obtain();
        messageObtain.what = 100;
        messageObtain.obj = jSONObject;
        this.BT.sendMessageDelayed(messageObtain, 200L);
    }

    private boolean sc(float f11, float f12) {
        if (this.Dl == null) {
            this.Dl = ViewConfiguration.get(this.TRI);
        }
        if (this.uEA == -1) {
            this.uEA = this.Dl.getScaledTouchSlop();
        }
        return Math.abs(f11 - this.Xc) <= ((float) this.uEA) && Math.abs(f12 - this.wjp) <= ((float) this.uEA);
    }

    @Override // android.view.View.OnTouchListener
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        motionEvent.getX();
        motionEvent.getY();
        float x11 = motionEvent.getX();
        float y11 = motionEvent.getY();
        this.UFX = SystemClock.elapsedRealtime();
        this.f26548qr = x11;
        this.Qj = y11;
        if (action == 0) {
            this.Xc = x11;
            this.wjp = y11;
        } else if (action == 1 && sc(x11, y11)) {
            int iSc = sc(this.f26548qr, this.Qj, this.UFX);
            boolean z11 = !this.SR.contains(Integer.valueOf(this.Ql));
            sc(view, motionEvent, iSc, z11);
            if (z11) {
                this.SR.add(Integer.valueOf(this.Ql));
            }
            if (iSc == 0) {
                motionEvent.setAction(3);
            }
        }
        View.OnTouchListener onTouchListener = this.YIK;
        if (onTouchListener != null) {
            return onTouchListener.onTouch(view, motionEvent);
        }
        return false;
    }

    public InterfaceC0245sc sc() {
        return this.f26549sc;
    }

    @Override // com.bytedance.sdk.component.utils.FI.sc
    public void sc(Message message) {
        int i11 = message.what;
        Object obj = message.obj;
        JSONObject jSONObject = new JSONObject();
        if (i11 == 100) {
            if (obj instanceof JSONObject) {
                jSONObject = (JSONObject) obj;
                try {
                    jSONObject.put("is_trigger_jump", this.dE ? 1 : 0);
                    this.dE = false;
                } catch (Throwable unused) {
                }
            }
            if (com.bytedance.sdk.component.Ol.sc.sc.sc().pFF() != null) {
                com.bytedance.sdk.component.Ol.sc.sc.sc().pFF().sc(this.Sfl, "arbitrage_click_event", jSONObject);
            }
        }
    }

    public void sc(View.OnTouchListener onTouchListener) {
        this.YIK = onTouchListener;
    }

    public void sc(String str) {
        this.Sfl = str;
    }
}
