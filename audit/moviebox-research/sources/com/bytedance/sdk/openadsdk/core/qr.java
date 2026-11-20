package com.bytedance.sdk.openadsdk.core;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.annotation.Nullable;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class qr extends View implements com.bytedance.sdk.component.utils.FI.sc {
    private List<View> ExN;
    private final Handler Ol;
    private int Qj;
    private final Runnable Ql;

    @Nullable
    private List<View> TRI;
    private boolean Tf;
    private ViewTreeObserver.OnGlobalLayoutListener UFX;
    private final AtomicBoolean WH;
    private View We;
    private boolean pFF;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private boolean f28467qr;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private boolean f28468sc;
    private sc zY;

    /* JADX INFO: compiled from: source.java */
    public interface sc {
        void pFF();

        void sc();

        void sc(View view);

        void sc(boolean z11);
    }

    public qr(Context context, View view) {
        super(Xc.sc());
        this.Ol = new com.bytedance.sdk.component.utils.FI(SR.pFF().getLooper(), this);
        this.WH = new AtomicBoolean(true);
        this.Tf = false;
        this.Ql = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.qr.3
            @Override // java.lang.Runnable
            public void run() {
                if (qr.this.zY != null) {
                    qr.this.zY.sc(qr.this.We);
                }
            }
        };
        this.We = view;
        setLayoutParams(new ViewGroup.LayoutParams(0, 0));
        this.UFX = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.bytedance.sdk.openadsdk.core.qr.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (qr.this.Tf) {
                    return;
                }
                qr.this.ExN();
                qr.this.We();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ExN() {
        if (this.f28468sc) {
            this.Ol.removeCallbacksAndMessages(null);
            this.f28468sc = false;
        }
    }

    private boolean TRI() {
        View view = this.We;
        if (view instanceof com.bytedance.sdk.openadsdk.core.Qj.Sfl) {
            return ((com.bytedance.sdk.openadsdk.core.Qj.Sfl) view).BT();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void We() {
        if (!this.pFF || this.f28468sc) {
            return;
        }
        this.f28468sc = true;
        this.Ol.sendEmptyMessage(1);
    }

    private void pFF() {
        sc scVar;
        if (!this.WH.getAndSet(false) || (scVar = this.zY) == null) {
            return;
        }
        scVar.sc();
    }

    private void sc(final boolean z11) {
        final ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        com.bytedance.sdk.component.utils.qr.pFF().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.qr.2
            @Override // java.lang.Runnable
            public void run() {
                ViewTreeObserver viewTreeObserver2;
                if (qr.this.UFX != null && (viewTreeObserver2 = viewTreeObserver) != null) {
                    try {
                        viewTreeObserver2.removeOnGlobalLayoutListener(qr.this.UFX);
                    } catch (Exception unused) {
                    }
                }
                if (z11) {
                    qr.this.UFX = null;
                }
            }
        });
    }

    private void zY() {
        sc scVar;
        if (this.WH.getAndSet(true) || (scVar = this.zY) == null) {
            return;
        }
        scVar.pFF();
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f28467qr = false;
        pFF();
        if (this.UFX != null) {
            getViewTreeObserver().addOnGlobalLayoutListener(this.UFX);
        }
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ExN();
        this.f28467qr = true;
        zY();
        sc(false);
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        pFF();
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        zY();
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z11) {
        super.onWindowFocusChanged(z11);
        sc scVar = this.zY;
        if (scVar != null) {
            scVar.sc(z11);
        }
    }

    public void sc() {
        sc(this.ExN, (com.bytedance.sdk.openadsdk.core.pFF.zY) null);
        sc(this.TRI, (com.bytedance.sdk.openadsdk.core.pFF.zY) null);
    }

    @Override // com.bytedance.sdk.component.utils.FI.sc
    public void sc(Message message) {
        if (message.what == 1 && this.f28468sc) {
            if (!TRI() || !Gb.sc(this.We, 20, this.Qj)) {
                this.Ol.sendEmptyMessageDelayed(1, 1000L);
                return;
            }
            ExN();
            this.Tf = true;
            SR.zY().post(this.Ql);
            sc(true);
        }
    }

    public void sc(List<View> list, com.bytedance.sdk.openadsdk.core.pFF.zY zYVar) {
        if (com.bytedance.sdk.component.utils.WH.pFF(list)) {
            for (View view : list) {
                if (view != null) {
                    view.setOnClickListener(zYVar);
                    view.setOnTouchListener(zYVar);
                }
            }
        }
    }

    public void setAdType(int i11) {
        this.Qj = i11;
    }

    public void setCallback(sc scVar) {
        this.zY = scVar;
    }

    public void setNeedCheckingShow(boolean z11) {
        this.pFF = z11;
        if (!z11 && this.f28468sc) {
            ExN();
        } else {
            if (!z11 || this.f28468sc) {
                return;
            }
            We();
        }
    }

    public void setRefClickViews(List<View> list) {
        this.ExN = list;
    }

    public void setRefCreativeViews(@Nullable List<View> list) {
        this.TRI = list;
    }
}
