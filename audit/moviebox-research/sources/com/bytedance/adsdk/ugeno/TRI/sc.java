package com.bytedance.adsdk.ugeno.TRI;

import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.gms.common.api.Api;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class sc<T> extends FrameLayout implements com.bytedance.adsdk.ugeno.Qj.zY.We {
    private int BT;
    private final Runnable Dl;
    private int ExN;
    private float Ol;
    private String Qj;
    private boolean Ql;
    private int SR;
    private zY Sfl;
    private int TRI;
    private boolean Tf;
    private boolean UFX;
    private boolean WH;
    private int We;
    private com.bytedance.adsdk.ugeno.TRI.sc.sc Xc;
    private final Runnable YIK;
    private int dE;
    protected com.bytedance.adsdk.ugeno.Qj.zY pFF;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private int f26362qr;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    protected List<T> f26363sc;
    private C0228sc wjp;
    private int zY;

    /* JADX INFO: compiled from: source.java */
    public class pFF extends com.bytedance.adsdk.ugeno.Qj.zY {
        public pFF(Context context) {
            super(context);
        }

        @Override // com.bytedance.adsdk.ugeno.Qj.zY, android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            if (!sc.this.Ql) {
                return false;
            }
            try {
                return super.onInterceptTouchEvent(motionEvent);
            } catch (IllegalArgumentException unused) {
                return false;
            }
        }

        @Override // com.bytedance.adsdk.ugeno.Qj.zY, android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            if (!sc.this.Ql) {
                return false;
            }
            try {
                return super.onTouchEvent(motionEvent);
            } catch (IllegalArgumentException unused) {
                return false;
            }
        }
    }

    /* JADX INFO: renamed from: com.bytedance.adsdk.ugeno.TRI.sc$sc, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public class C0228sc extends com.bytedance.adsdk.ugeno.Qj.pFF {
        public C0228sc() {
        }

        @Override // com.bytedance.adsdk.ugeno.Qj.pFF
        public float sc(int i11) {
            if (sc.this.Ol <= 0.0f) {
                return 1.0f;
            }
            return 1.0f / sc.this.Ol;
        }

        @Override // com.bytedance.adsdk.ugeno.Qj.pFF
        public int sc() {
            return sc.this.Tf ? Api.BaseClientBuilder.API_PRIORITY_OTHER : sc.this.f26363sc.size();
        }

        @Override // com.bytedance.adsdk.ugeno.Qj.pFF
        public int sc(Object obj) {
            return -2;
        }

        @Override // com.bytedance.adsdk.ugeno.Qj.pFF
        public Object sc(ViewGroup viewGroup, int i11) {
            View viewSc = sc.this.sc(i11, We.sc(sc.this.Tf, i11, sc.this.f26363sc.size()));
            viewGroup.addView(viewSc);
            return viewSc;
        }

        @Override // com.bytedance.adsdk.ugeno.Qj.pFF
        public void sc(ViewGroup viewGroup, int i11, Object obj) {
            viewGroup.removeView((View) obj);
        }

        @Override // com.bytedance.adsdk.ugeno.Qj.pFF
        public boolean sc(View view, Object obj) {
            return view == obj;
        }
    }

    public sc(Context context) {
        super(context);
        this.f26363sc = new CopyOnWriteArrayList();
        this.zY = 2000;
        this.We = 500;
        this.ExN = 10;
        this.TRI = -1;
        this.f26362qr = -1;
        this.Qj = "normal";
        this.Ol = 1.0f;
        this.WH = true;
        this.UFX = true;
        this.Tf = true;
        this.Ql = true;
        this.SR = 0;
        this.BT = 0;
        this.dE = 0;
        this.YIK = new Runnable() { // from class: com.bytedance.adsdk.ugeno.TRI.sc.1
            @Override // java.lang.Runnable
            public void run() {
                int currentItem = sc.this.pFF.getCurrentItem() + 1;
                if (sc.this.Tf) {
                    if (currentItem >= Integer.MAX_VALUE) {
                        sc.this.pFF.sc(1073741823, false);
                        return;
                    } else {
                        sc.this.pFF.sc(currentItem, true);
                        return;
                    }
                }
                if (currentItem >= sc.this.pFF.getAdapter().sc()) {
                    sc.this.pFF.sc(0, false);
                } else {
                    sc.this.pFF.sc(currentItem, true);
                }
            }
        };
        this.Dl = new Runnable() { // from class: com.bytedance.adsdk.ugeno.TRI.sc.2
            @Override // java.lang.Runnable
            public void run() {
                if (sc.this.UFX) {
                    int currentItem = sc.this.pFF.getCurrentItem() + 1;
                    if (sc.this.Tf) {
                        if (currentItem >= Integer.MAX_VALUE) {
                            sc.this.pFF.sc(1073741823, false);
                        } else {
                            sc.this.pFF.sc(currentItem, true);
                        }
                        sc scVar = sc.this;
                        scVar.postDelayed(scVar.Dl, sc.this.zY);
                        return;
                    }
                    if (currentItem >= sc.this.pFF.getAdapter().sc()) {
                        sc.this.pFF.sc(0, false);
                        sc scVar2 = sc.this;
                        scVar2.postDelayed(scVar2.Dl, sc.this.zY);
                    } else {
                        sc.this.pFF.sc(currentItem, true);
                        sc scVar3 = sc.this;
                        scVar3.postDelayed(scVar3.Dl, sc.this.zY);
                    }
                }
            }
        };
        this.pFF = new pFF(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        addView(this.pFF, layoutParams);
        com.bytedance.adsdk.ugeno.TRI.sc.sc scVar = new com.bytedance.adsdk.ugeno.TRI.sc.sc(context);
        this.Xc = scVar;
        addView(scVar);
    }

    public sc ExN(int i11) {
        this.TRI = i11;
        sc(this.Qj, this.ExN, i11, this.f26362qr, true);
        return this;
    }

    public void Ol(int i11) {
        sc(this.Qj, this.ExN, this.TRI, this.f26362qr, true);
        if (this.wjp == null) {
            this.wjp = new C0228sc();
            this.pFF.sc((com.bytedance.adsdk.ugeno.Qj.zY.We) this);
            this.pFF.setAdapter(this.wjp);
        }
        if (this.Tf) {
            if (i11 >= Integer.MAX_VALUE) {
                this.pFF.sc(1073741823, false);
                return;
            } else {
                this.pFF.sc(i11, true);
                return;
            }
        }
        if (i11 < 0 || i11 >= this.f26363sc.size()) {
            return;
        }
        this.pFF.sc(i11, true);
    }

    @Override // com.bytedance.adsdk.ugeno.Qj.zY.We
    public void Qj(int i11) {
        if (this.Sfl != null) {
            int iSc = We.sc(this.Tf, i11, this.f26363sc.size());
            this.Sfl.sc(this.Tf, iSc, i11, iSc == 0, iSc == this.f26363sc.size() - 1);
        }
        if (this.WH) {
            this.Xc.sc(i11);
        }
    }

    public sc TRI(int i11) {
        this.f26362qr = i11;
        sc(this.Qj, this.ExN, this.TRI, i11, true);
        return this;
    }

    public sc We(int i11) {
        this.ExN = i11;
        sc(this.Qj, i11, this.TRI, this.f26362qr, true);
        return this;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.UFX) {
            int action = motionEvent.getAction();
            if (action == 1 || action == 3 || action == 4) {
                pFF();
            } else if (action == 0) {
                zY();
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public com.bytedance.adsdk.ugeno.Qj.pFF getAdapter() {
        return this.pFF.getAdapter();
    }

    public int getCurrentItem() {
        return this.pFF.getCurrentItem();
    }

    public com.bytedance.adsdk.ugeno.Qj.zY getViewPager() {
        return this.pFF;
    }

    public sc pFF(int i11) {
        this.Xc.setSelectedColor(i11);
        return this;
    }

    public sc pFF(boolean z11) {
        this.WH = z11;
        return this;
    }

    public void pFF() {
        removeCallbacks(this.Dl);
        postDelayed(this.Dl, this.zY);
    }

    public abstract View qr(int i11);

    public View sc(int i11, int i12) {
        if (this.f26363sc.size() == 0) {
            return new View(getContext());
        }
        View viewQr = qr(i12);
        FrameLayout frameLayout = new FrameLayout(getContext());
        if (viewQr instanceof ViewGroup) {
            frameLayout.setClipChildren(true);
        }
        if (viewQr.getParent() instanceof ViewGroup) {
            ((ViewGroup) viewQr.getParent()).removeView(viewQr);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        frameLayout.addView(viewQr, layoutParams);
        frameLayout.addView(new View(getContext()), new FrameLayout.LayoutParams(-1, -1));
        return frameLayout;
    }

    public sc sc(float f11) {
        this.Ol = f11;
        return this;
    }

    public sc sc(int i11) {
        this.zY = i11;
        pFF();
        return this;
    }

    public sc<T> sc(T t11) {
        if (t11 != null) {
            this.f26363sc.add(t11);
            if (this.WH) {
                this.Xc.pFF();
            }
        }
        C0228sc c0228sc = this.wjp;
        if (c0228sc != null) {
            c0228sc.zY();
            this.Xc.sc(this.SR, this.pFF.getCurrentItem());
        }
        return this;
    }

    public sc sc(String str) {
        this.Qj = str;
        sc(str, this.ExN, this.TRI, this.f26362qr, true);
        return this;
    }

    public sc sc(boolean z11) {
        this.UFX = z11;
        pFF();
        return this;
    }

    public void sc() {
        sc(this.Qj, this.ExN, this.TRI, this.f26362qr, true);
        if (this.wjp == null) {
            this.wjp = new C0228sc();
            this.pFF.sc((com.bytedance.adsdk.ugeno.Qj.zY.We) this);
            this.pFF.setAdapter(this.wjp);
        }
        int i11 = this.SR;
        if (i11 < 0 || i11 >= this.f26363sc.size()) {
            this.SR = 0;
        }
        int i12 = this.Tf ? this.SR + 1073741823 : this.SR;
        this.pFF.sc(i12, true);
        if (!this.Tf) {
            Qj(i12);
        }
        if (this.UFX) {
            pFF();
        }
    }

    @Override // com.bytedance.adsdk.ugeno.Qj.zY.We
    public void sc(int i11, float f11, int i12) {
        if (this.Sfl != null) {
            We.sc(this.Tf, i11, this.f26363sc.size());
        }
    }

    public void sc(String str, int i11, int i12, int i13, boolean z11) {
        C0228sc c0228sc = this.wjp;
        if (c0228sc != null) {
            c0228sc.zY();
        }
        setClipChildren(false);
        this.pFF.setClipChildren(false);
        this.pFF.setPageMargin(i11);
        ViewGroup.LayoutParams layoutParams = this.pFF.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.leftMargin = i12 + i11;
            marginLayoutParams.rightMargin = i13 + i11;
            this.pFF.setLayoutParams(layoutParams);
        }
        if (TextUtils.equals(str, "linear")) {
            this.pFF.sc(false, (com.bytedance.adsdk.ugeno.Qj.zY.ExN) new com.bytedance.adsdk.ugeno.TRI.pFF.sc());
        } else {
            this.pFF.sc(false, (com.bytedance.adsdk.ugeno.Qj.zY.ExN) null);
        }
        this.pFF.setOffscreenPageLimit((int) this.Ol);
    }

    public void setOnPageChangeListener(zY zYVar) {
        this.Sfl = zYVar;
    }

    public sc zY(int i11) {
        this.Xc.setUnSelectedColor(i11);
        return this;
    }

    public sc zY(boolean z11) {
        this.Xc.setLoop(z11);
        if (this.Tf != z11) {
            int iSc = We.sc(z11, this.pFF.getCurrentItem(), this.f26363sc.size());
            this.Tf = z11;
            C0228sc c0228sc = this.wjp;
            if (c0228sc != null) {
                c0228sc.zY();
                this.pFF.setCurrentItem(iSc);
            }
        }
        return this;
    }

    public void zY() {
        removeCallbacks(this.Dl);
    }
}
