package com.bytedance.sdk.component.adexpress.dynamic.zY;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.applovin.exoplayer2.common.base.Ascii;
import com.bytedance.sdk.component.adexpress.TRI.cvk;
import com.cloud.tmc.miniapp.prepare.steps.PrepareException;
import com.transsion.baselib.db.download.DownloadBean;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class Ol extends FrameLayout implements Qj {
    private qr ExN;
    private int Ol;
    private View.OnTouchListener Qj;
    private String TRI;
    private com.bytedance.sdk.component.adexpress.pFF.Ql Tf;
    private com.bytedance.sdk.component.adexpress.dynamic.We.WH UFX;
    private boolean WH;
    private View We;
    private com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ExN pFF;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private com.bytedance.sdk.component.adexpress.TRI.wjp f26846qr;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private Context f26847sc;
    private com.bytedance.sdk.component.adexpress.dynamic.We.qr zY;

    public Ol(Context context, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ExN exN, com.bytedance.sdk.component.adexpress.dynamic.We.qr qrVar) {
        super(context);
        this.f26847sc = context;
        this.pFF = exN;
        this.zY = qrVar;
        qr();
    }

    public Ol(Context context, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ExN exN, com.bytedance.sdk.component.adexpress.dynamic.We.qr qrVar, com.bytedance.sdk.component.adexpress.dynamic.We.WH wh2, com.bytedance.sdk.component.adexpress.pFF.Ql ql2) {
        super(context);
        this.f26847sc = context;
        this.pFF = exN;
        this.zY = qrVar;
        this.UFX = wh2;
        this.Tf = ql2;
        qr();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ol() {
        if (this.Qj != null) {
            setOnClickListener((View.OnClickListener) this.pFF.getDynamicClickListener());
            performClick();
            if (this.zY.PPh()) {
                return;
            }
            setVisibility(8);
        }
    }

    private boolean Qj() {
        return (this.zY.ZM() || TextUtils.equals(PrepareException.ERROR_MINI_APP_CLOSE, this.TRI) || TextUtils.equals("16", this.TRI) || TextUtils.equals("17", this.TRI) || TextUtils.equals("18", this.TRI) || TextUtils.equals("20", this.TRI) || TextUtils.equals("29", this.TRI) || TextUtils.equals(PrepareException.ERROR_MINI_APPID, this.TRI)) ? false : true;
    }

    private void qr() {
        setBackgroundColor(0);
        setClipChildren(false);
        setClipToPadding(false);
        this.TRI = this.zY.pc();
        this.Ol = this.zY.QLv();
        this.WH = this.zY.ZM();
        qr qrVarSc = WH.sc(this.f26847sc, this.pFF, this.zY, this.UFX, this.Tf);
        this.ExN = qrVarSc;
        if (qrVarSc != null) {
            this.We = qrVarSc.zY();
            if (this.zY.GI()) {
                setBackgroundColor(Color.parseColor("#50000000"));
            }
            if (TextUtils.equals(this.TRI, PrepareException.ERROR_NO_URL)) {
                if (!this.zY.idT() || TextUtils.isEmpty(this.zY.fT())) {
                    this.f26846qr = new com.bytedance.sdk.component.adexpress.TRI.wjp(this.f26847sc, Color.parseColor("#99000000"));
                } else {
                    this.f26846qr = new com.bytedance.sdk.component.adexpress.TRI.wjp(this.f26847sc, com.bytedance.sdk.component.adexpress.dynamic.We.qr.sc(this.zY.fT()));
                }
                FrameLayout frameLayout = new FrameLayout(this.f26847sc);
                frameLayout.addView(this.f26846qr, new FrameLayout.LayoutParams(-1, -1));
                frameLayout.setClipChildren(true);
                addView(frameLayout, new FrameLayout.LayoutParams(-1, -1));
                post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.zY.Ol.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Ol.this.f26846qr.pFF();
                    }
                });
            }
            if (sc(this.TRI) && com.bytedance.sdk.component.adexpress.We.pFF()) {
                int color = Color.parseColor("#99000000");
                if (this.zY.idT() && !TextUtils.isEmpty(this.zY.fT())) {
                    try {
                        color = com.bytedance.sdk.component.adexpress.dynamic.We.qr.sc(this.zY.fT());
                    } catch (Exception unused) {
                    }
                }
                View view = new View(this.f26847sc);
                view.setBackgroundColor(color);
                addView(view, new FrameLayout.LayoutParams(-1, -1));
            }
            addView(this.ExN.zY());
            sc(this.ExN.zY());
            setVisibility(0);
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private void sc(ViewGroup viewGroup) {
        if (this.We == null) {
            return;
        }
        String str = this.TRI;
        str.hashCode();
        byte b11 = -1;
        switch (str.hashCode()) {
            case 48:
                if (str.equals("0")) {
                    b11 = 0;
                }
                break;
            case 49:
                if (str.equals("1")) {
                    b11 = 1;
                }
                break;
            case 50:
                if (str.equals("2")) {
                    b11 = 2;
                }
                break;
            case 53:
                if (str.equals("5")) {
                    b11 = 3;
                }
                break;
            case 54:
                if (str.equals(PrepareException.ERROR_NO_URL)) {
                    b11 = 4;
                }
                break;
            case 55:
                if (str.equals("7")) {
                    b11 = 5;
                }
                break;
            case 56:
                if (str.equals(PrepareException.ERROR_MANIFEST_INFO)) {
                    b11 = 6;
                }
                break;
            case DownloadBean.STATUS_COMPLETED_REMOVED /* 57 */:
                if (str.equals(PrepareException.ERROR_MINI_APP_CLOSE)) {
                    b11 = 7;
                }
                break;
            case 1567:
                if (str.equals(PrepareException.ERROR_MINI_APPID)) {
                    b11 = 8;
                }
                break;
            case 1568:
                if (str.equals(PrepareException.ERROR_DOWNLOAD_PACKAGE_URL_EMPTY)) {
                    b11 = 9;
                }
                break;
            case 1569:
                if (str.equals(PrepareException.ERROR_LOCAL_DATA_FILE_SCAN)) {
                    b11 = 10;
                }
                break;
            case 1570:
                if (str.equals(PrepareException.ERROR_WARMUP_DOWNLOAD_EXCEPTION)) {
                    b11 = Ascii.VT;
                }
                break;
            case 1571:
                if (str.equals(PrepareException.ERROR_FILE2VURL_FRAMEWORK_FILE_EXCEPTION)) {
                    b11 = Ascii.FF;
                }
                break;
            case 1573:
                if (str.equals("16")) {
                    b11 = Ascii.CR;
                }
                break;
            case 1574:
                if (str.equals("17")) {
                    b11 = Ascii.SO;
                }
                break;
            case 1575:
                if (str.equals("18")) {
                    b11 = Ascii.SI;
                }
                break;
            case 1598:
                if (str.equals("20")) {
                    b11 = Ascii.DLE;
                }
                break;
            case 1600:
                if (str.equals("22")) {
                    b11 = 17;
                }
                break;
            case 1601:
                if (str.equals("23")) {
                    b11 = Ascii.DC2;
                }
                break;
            case 1602:
                if (str.equals("24")) {
                    b11 = 19;
                }
                break;
            case 1603:
                if (str.equals("25")) {
                    b11 = Ascii.DC4;
                }
                break;
            case 1607:
                if (str.equals("29")) {
                    b11 = Ascii.NAK;
                }
                break;
        }
        switch (b11) {
            case 0:
                this.Qj = new com.bytedance.sdk.component.adexpress.dynamic.zY.sc.ExN(this, this.Ol);
                setBackgroundColor(Color.parseColor("#80000000"));
                break;
            case 1:
            case 4:
                if (!this.zY.idT() || TextUtils.isEmpty(this.zY.fT())) {
                    setBackgroundColor(Color.parseColor("#80000000"));
                }
                this.Qj = new com.bytedance.sdk.component.adexpress.dynamic.zY.sc.TRI(this);
                break;
            case 2:
            case 5:
                setBackgroundColor(Color.parseColor("#80000000"));
                this.Qj = new com.bytedance.sdk.component.adexpress.dynamic.zY.sc.pFF(this, this);
                break;
            case 3:
                if (!this.zY.idT() || TextUtils.isEmpty(this.zY.fT())) {
                    setBackgroundColor(Color.parseColor("#80000000"));
                } else {
                    setBackgroundColor(com.bytedance.sdk.component.adexpress.dynamic.We.qr.sc(this.zY.fT()));
                }
                this.Qj = new com.bytedance.sdk.component.adexpress.dynamic.zY.sc.zY(this);
                this.We.setTag(2);
                break;
            case 6:
            case 9:
                this.pFF.setClipChildren(false);
                this.pFF.setClipChildren(false);
                ViewGroup viewGroup2 = (ViewGroup) this.pFF.getParent();
                if (viewGroup2 != null) {
                    viewGroup2.setClipChildren(false);
                    viewGroup2.setClipToPadding(false);
                }
                this.Qj = new com.bytedance.sdk.component.adexpress.dynamic.zY.sc.TRI(this);
                break;
            case 7:
            case 14:
                this.We.setTag(2);
                break;
            case 8:
                this.Qj = new com.bytedance.sdk.component.adexpress.dynamic.zY.sc.We(this, this.Ol, this.WH);
                break;
            case 10:
                this.Qj = new com.bytedance.sdk.component.adexpress.dynamic.zY.sc.zY(this);
                this.We.setTag(2);
                break;
            case 11:
            case 19:
                if (this.TRI.equals("24") && com.bytedance.sdk.component.adexpress.We.pFF()) {
                    this.pFF.setClipChildren(false);
                    this.Qj = new com.bytedance.sdk.component.adexpress.dynamic.zY.sc.TRI(this);
                } else {
                    this.Qj = new com.bytedance.sdk.component.adexpress.dynamic.zY.sc.ExN(this, this.Ol);
                }
                break;
            case 12:
                this.Qj = new com.bytedance.sdk.component.adexpress.dynamic.zY.sc.pFF(this, this);
                break;
            case 13:
                View view = this.We;
                if (view != null && (view instanceof com.bytedance.sdk.component.adexpress.TRI.Sfl) && ((com.bytedance.sdk.component.adexpress.TRI.Sfl) view).getShakeLayout() != null) {
                    ((com.bytedance.sdk.component.adexpress.TRI.Sfl) this.We).getShakeLayout().setTag(2);
                }
                this.We.setTag(2);
                break;
            case 15:
                View view2 = this.We;
                if (view2 != null && (view2 instanceof cvk) && ((cvk) view2).getWriggleLayout() != null) {
                    ((cvk) this.We).getWriggleLayout().setTag(2);
                }
                this.We.setTag(2);
                break;
            case 16:
                this.Qj = new com.bytedance.sdk.component.adexpress.dynamic.zY.sc.sc(this, this.Ol, viewGroup);
                break;
            case 17:
                if (!com.bytedance.sdk.component.adexpress.We.pFF()) {
                    this.Qj = new com.bytedance.sdk.component.adexpress.dynamic.zY.sc.qr(this, this.Ol, viewGroup);
                } else {
                    this.Qj = new com.bytedance.sdk.component.adexpress.dynamic.zY.sc.Qj(this, this.WH);
                }
                break;
            case 18:
                if (com.bytedance.sdk.component.adexpress.We.pFF()) {
                    this.Qj = new com.bytedance.sdk.component.adexpress.dynamic.zY.sc.TRI(this);
                }
                break;
            case 20:
                if (com.bytedance.sdk.component.adexpress.We.pFF()) {
                    this.Qj = new com.bytedance.sdk.component.adexpress.dynamic.zY.sc.Qj(this, this.WH);
                }
                break;
            case 21:
                View view3 = this.We;
                if (view3 != null && (view3 instanceof com.bytedance.sdk.component.adexpress.TRI.TRI) && ((com.bytedance.sdk.component.adexpress.TRI.TRI) view3).getShakeView() != null) {
                    ((com.bytedance.sdk.component.adexpress.TRI.TRI) this.We).getShakeView().setTag(2);
                }
                this.Qj = new com.bytedance.sdk.component.adexpress.dynamic.zY.sc.ExN(this, this.Ol);
                break;
        }
        View.OnTouchListener onTouchListener = this.Qj;
        if (onTouchListener != null) {
            setOnTouchListener(onTouchListener);
        }
        if (Qj()) {
            this.We.setTag(2);
            setOnClickListener((View.OnClickListener) this.pFF.getDynamicClickListener());
        }
    }

    private boolean sc(String str) {
        return TextUtils.equals(str, "24") || TextUtils.equals(str, "23") || TextUtils.equals(str, "25") || TextUtils.equals(str, "22") || TextUtils.equals(str, "1");
    }

    public void ExN() {
        if (this.We != null && TextUtils.equals(this.TRI, "2")) {
            View view = this.We;
            if (view instanceof com.bytedance.sdk.component.adexpress.TRI.zY) {
                ((com.bytedance.sdk.component.adexpress.TRI.zY) view).zY();
            }
        }
    }

    public void TRI() {
        if (this.We != null && TextUtils.equals(this.TRI, "2")) {
            View view = this.We;
            if (view instanceof com.bytedance.sdk.component.adexpress.TRI.zY) {
                ((com.bytedance.sdk.component.adexpress.TRI.zY) view).We();
            }
        }
    }

    public void We() {
        qr qrVar = this.ExN;
        if (qrVar != null) {
            qrVar.pFF();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            qr qrVar = this.ExN;
            if (qrVar != null) {
                qrVar.pFF();
            }
        } catch (Exception e11) {
            com.bytedance.sdk.component.utils.Tf.pFF(e11.getMessage());
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.Qj instanceof com.bytedance.sdk.component.adexpress.dynamic.zY.sc.zY) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.zY.Qj
    public void pFF() {
        if (Qj()) {
            setOnClickListener((View.OnClickListener) this.pFF.getDynamicClickListener());
            performClick();
            if (this.zY.PPh()) {
                return;
            }
            setVisibility(8);
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.zY.Qj
    public void sc() {
        if (!TextUtils.equals(this.TRI, PrepareException.ERROR_NO_URL)) {
            if (TextUtils.equals(this.TRI, "20")) {
                postDelayed(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.zY.Ol.3
                    @Override // java.lang.Runnable
                    public void run() {
                        Ol.this.Ol();
                    }
                }, 400L);
                return;
            } else {
                Ol();
                return;
            }
        }
        com.bytedance.sdk.component.adexpress.TRI.wjp wjpVar = this.f26846qr;
        if (wjpVar != null) {
            wjpVar.zY();
            postDelayed(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.zY.Ol.2
                @Override // java.lang.Runnable
                public void run() {
                    Ol.this.Ol();
                }
            }, 300L);
        }
    }

    public void zY() {
        qr qrVar = this.ExN;
        if (qrVar != null) {
            qrVar.sc();
        }
    }
}
