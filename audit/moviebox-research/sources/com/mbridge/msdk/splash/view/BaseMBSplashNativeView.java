package com.mbridge.msdk.splash.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.ac;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.foundation.tools.ai;
import com.mbridge.msdk.foundation.tools.v;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import com.mbridge.msdk.shake.MBShakeView;
import com.mbridge.msdk.shake.b;
import com.mbridge.msdk.splash.a.d;
import com.mbridge.msdk.splash.view.nativeview.MBNoRecycledCrashImageView;
import com.mbridge.msdk.splash.view.nativeview.MBSplashClickView;
import com.mbridge.msdk.widget.FeedBackButton;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class BaseMBSplashNativeView extends RelativeLayout {
    private MBNoRecycledCrashImageView A;
    private TextView B;
    private MBNoRecycledCrashImageView C;
    private TextView D;
    private TextView E;
    private int F;
    private int G;
    private int H;
    private int I;
    private int J;
    private int K;
    private float L;
    private float M;
    private boolean N;
    private boolean O;
    private String P;
    private String Q;
    private String R;
    private String S;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected TextView f47204a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected RelativeLayout f47205b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected TextView f47206c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected TextView f47207d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected TextView f47208e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected TextView f47209f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected MBSplashClickView f47210g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    protected int f47211h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    protected int f47212i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    protected int f47213j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    protected int f47214k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    protected int f47215l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    protected boolean f47216m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    protected boolean f47217n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    protected boolean f47218o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    protected String f47219p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    protected MBSplashView f47220q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    protected CampaignEx f47221r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    protected MBShakeView f47222s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    protected b f47223t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private MBNoRecycledCrashImageView f47224u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private MBNoRecycledCrashImageView f47225v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private RelativeLayout f47226w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private ImageView f47227x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private FeedBackButton f47228y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private RelativeLayout f47229z;

    public BaseMBSplashNativeView(Context context) {
        super(context);
        this.f47217n = false;
        this.f47218o = false;
    }

    public BaseMBSplashNativeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BaseMBSplashNativeView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f47217n = false;
        this.f47218o = false;
    }

    public BaseMBSplashNativeView(Context context, MBSplashView mBSplashView, d dVar) {
        Drawable drawable;
        super(context);
        this.f47217n = false;
        this.f47218o = false;
        if (dVar == null) {
            throw new IllegalArgumentException("Parameters is NULL, can't gen view.");
        }
        this.f47219p = dVar.b();
        this.P = dVar.a();
        this.f47221r = dVar.c();
        this.f47220q = mBSplashView;
        this.f47211h = dVar.e();
        this.H = dVar.f();
        this.G = dVar.g();
        this.f47212i = dVar.h();
        this.f47213j = dVar.i();
        this.f47214k = dVar.j();
        this.f47215l = dVar.k();
        this.I = dVar.l();
        this.f47216m = dVar.d();
        this.J = dVar.m();
        try {
            View viewInflate = LayoutInflater.from(getContext()).inflate(this.I == 1 ? v.a(getContext().getApplicationContext(), "mbridge_splash_portrait", TtmlNode.TAG_LAYOUT) : v.a(getContext().getApplicationContext(), "mbridge_splash_landscape", TtmlNode.TAG_LAYOUT), (ViewGroup) null);
            addView(viewInflate);
            this.f47224u = (MBNoRecycledCrashImageView) viewInflate.findViewById(v.a(getContext().getApplicationContext(), "mbridge_splash_iv_image_bg", "id"));
            this.f47225v = (MBNoRecycledCrashImageView) viewInflate.findViewById(v.a(getContext().getApplicationContext(), "mbridge_splash_iv_image", "id"));
            this.f47226w = (RelativeLayout) viewInflate.findViewById(v.a(getContext().getApplicationContext(), "mbridge_splash_topcontroller", "id"));
            this.f47227x = (ImageView) viewInflate.findViewById(v.a(getContext().getApplicationContext(), "mbridge_splash_iv_link", "id"));
            this.f47228y = (FeedBackButton) viewInflate.findViewById(v.a(getContext().getApplicationContext(), "mbridge_splash_feedback", "id"));
            this.f47204a = (TextView) viewInflate.findViewById(v.a(getContext().getApplicationContext(), "mbridge_splash_tv_skip", "id"));
            this.f47229z = (RelativeLayout) viewInflate.findViewById(v.a(getContext().getApplicationContext(), "mbridge_splash_landscape_foreground", "id"));
            this.A = (MBNoRecycledCrashImageView) viewInflate.findViewById(v.a(getContext().getApplicationContext(), "mbridge_splash_iv_icon", "id"));
            this.B = (TextView) viewInflate.findViewById(v.a(getContext().getApplicationContext(), "mbridge_splash_tv_title", "id"));
            this.C = (MBNoRecycledCrashImageView) viewInflate.findViewById(v.a(getContext().getApplicationContext(), "mbridge_splash_iv_foregroundimage", "id"));
            this.D = (TextView) viewInflate.findViewById(v.a(getContext().getApplicationContext(), "mbridge_splash_tv_adrect", "id"));
            this.f47205b = (RelativeLayout) viewInflate.findViewById(v.a(getContext().getApplicationContext(), "mbridge_splash_layout_appinfo", "id"));
            this.f47206c = (TextView) viewInflate.findViewById(v.a(getContext().getApplicationContext(), "mbridge_splash_tv_appinfo", "id"));
            this.f47207d = (TextView) viewInflate.findViewById(v.a(getContext().getApplicationContext(), "mbridge_splash_tv_privacy", "id"));
            this.f47208e = (TextView) viewInflate.findViewById(v.a(getContext().getApplicationContext(), "mbridge_splash_tv_permission", "id"));
            this.f47209f = (TextView) viewInflate.findViewById(v.a(getContext().getApplicationContext(), "mbridge_splash_tv_app_desc", "id"));
            this.f47210g = (MBSplashClickView) viewInflate.findViewById(v.a(getContext().getApplicationContext(), "mbridge_splash_tv_click", "id"));
            this.E = (TextView) viewInflate.findViewById(v.a(getContext().getApplicationContext(), "mbridge_splash_tv_adcircle", "id"));
            int iA = v.a(getContext().getApplicationContext(), "mbridge_splash_count_time_can_skip", "string");
            int iA2 = v.a(getContext().getApplicationContext(), "mbridge_splash_count_time_can_skip_not", "string");
            int iA3 = v.a(getContext().getApplicationContext(), "mbridge_splash_count_time_can_skip_s", "string");
            this.R = getContext().getResources().getString(iA);
            this.S = getContext().getResources().getString(iA2);
            this.Q = getContext().getResources().getString(iA3);
            this.K = ai.a(getContext(), 9.0f);
        } catch (Throwable th2) {
            ad.b("MBSplashNativeView", th2.getMessage());
        }
        try {
            this.N = getContext().getResources().getConfiguration().locale.getLanguage().contains("zh");
        } catch (Throwable th3) {
            ad.b("MBSplashNativeView", th3.getMessage());
        }
        CampaignEx campaignEx = this.f47221r;
        if (campaignEx != null) {
            campaignEx.setCampaignUnitId(this.f47219p);
            com.mbridge.msdk.foundation.d.b.a().a(this.f47219p, 3);
            com.mbridge.msdk.foundation.d.b.a().a(this.f47219p, this.f47221r);
        }
        if (com.mbridge.msdk.foundation.d.b.a().b()) {
            com.mbridge.msdk.foundation.d.b.a().a(this.f47219p, new com.mbridge.msdk.foundation.d.a() { // from class: com.mbridge.msdk.splash.view.BaseMBSplashNativeView.7
                @Override // com.mbridge.msdk.foundation.d.a
                public final void a() {
                    BaseMBSplashNativeView baseMBSplashNativeView = BaseMBSplashNativeView.this;
                    baseMBSplashNativeView.f47218o = true;
                    BaseMBSplashNativeView.b(baseMBSplashNativeView, false);
                }

                @Override // com.mbridge.msdk.foundation.d.a
                public final void a(String str) {
                    BaseMBSplashNativeView baseMBSplashNativeView = BaseMBSplashNativeView.this;
                    baseMBSplashNativeView.f47218o = false;
                    BaseMBSplashNativeView.b(baseMBSplashNativeView, true);
                }

                @Override // com.mbridge.msdk.foundation.d.a
                public final void b() {
                    BaseMBSplashNativeView baseMBSplashNativeView = BaseMBSplashNativeView.this;
                    baseMBSplashNativeView.f47218o = false;
                    BaseMBSplashNativeView.b(baseMBSplashNativeView, true);
                }
            });
            com.mbridge.msdk.foundation.d.b.a().a(this.f47219p, this.f47228y);
            com.mbridge.msdk.foundation.d.b.a().a(this.f47219p, 3);
            com.mbridge.msdk.foundation.d.b.a().a(this.f47219p, this.f47221r);
        } else {
            FeedBackButton feedBackButton = this.f47228y;
            if (feedBackButton != null) {
                feedBackButton.setVisibility(8);
            }
        }
        if (TextUtils.isEmpty(this.f47221r.getImageUrl())) {
            this.f47225v.setVisibility(4);
        } else {
            com.mbridge.msdk.foundation.same.c.b.a(c.m().c()).a(this.f47221r.getImageUrl(), new com.mbridge.msdk.foundation.same.c.c() { // from class: com.mbridge.msdk.splash.view.BaseMBSplashNativeView.1
                @Override // com.mbridge.msdk.foundation.same.c.c
                public final void onFailedLoad(String str, String str2) {
                }

                @Override // com.mbridge.msdk.foundation.same.c.c
                public final void onSuccessLoad(Bitmap bitmap, String str) {
                    if (bitmap != null) {
                        try {
                            if (bitmap.isRecycled()) {
                                return;
                            }
                            if (bitmap.getWidth() < bitmap.getHeight()) {
                                BaseMBSplashNativeView.this.O = true;
                                BaseMBSplashNativeView.this.f47229z.setVisibility(4);
                                BaseMBSplashNativeView.this.f47225v.setScaleType(ImageView.ScaleType.FIT_CENTER);
                                BaseMBSplashNativeView.this.f47225v.setImageBitmap(bitmap);
                            } else if (BaseMBSplashNativeView.this.I == 1) {
                                BaseMBSplashNativeView.this.f47229z.setVisibility(0);
                                try {
                                    Bitmap bitmapA = ac.a(bitmap, 1, ai.a(c.m().c(), 10.0f));
                                    if (bitmapA != null && !bitmapA.isRecycled()) {
                                        BaseMBSplashNativeView.this.C.setScaleType(ImageView.ScaleType.FIT_XY);
                                        BaseMBSplashNativeView.this.C.setImageBitmap(bitmapA);
                                    }
                                } catch (Throwable th4) {
                                    try {
                                        ad.b("MBSplashNativeView", th4.getMessage());
                                        BaseMBSplashNativeView.this.C.setImageBitmap(bitmap);
                                    } catch (Throwable th5) {
                                        ad.b("MBSplashNativeView", th5.getMessage());
                                    }
                                }
                                BaseMBSplashNativeView.this.B.setText(BaseMBSplashNativeView.this.f47221r.getAppName());
                                BaseMBSplashNativeView.f(BaseMBSplashNativeView.this);
                                try {
                                    try {
                                        Bitmap bitmapA2 = ac.a(bitmap);
                                        if (bitmapA2 != null && !bitmapA2.isRecycled()) {
                                            BaseMBSplashNativeView.this.f47225v.setScaleType(ImageView.ScaleType.CENTER_CROP);
                                            BaseMBSplashNativeView.this.f47225v.setImageBitmap(bitmapA2);
                                        }
                                    } catch (Throwable th6) {
                                        ad.b("MBSplashNativeView", th6.getMessage());
                                    }
                                } catch (Throwable unused) {
                                    BaseMBSplashNativeView.this.f47225v.setImageBitmap(bitmap);
                                }
                            } else {
                                BaseMBSplashNativeView.this.f47229z.setVisibility(4);
                                BaseMBSplashNativeView.this.f47225v.setScaleType(ImageView.ScaleType.FIT_CENTER);
                                BaseMBSplashNativeView.this.f47225v.setImageBitmap(bitmap);
                            }
                            try {
                                Bitmap bitmapA3 = ac.a(bitmap);
                                if (bitmapA3 == null || bitmapA3.isRecycled()) {
                                    return;
                                }
                                BaseMBSplashNativeView.this.f47224u.setScaleType(ImageView.ScaleType.CENTER_CROP);
                                BaseMBSplashNativeView.this.f47224u.setImageBitmap(bitmapA3);
                                return;
                            } catch (Throwable unused2) {
                                BaseMBSplashNativeView.this.f47225v.setImageBitmap(bitmap);
                                return;
                            }
                            ad.b("MBSplashNativeView", th.getMessage());
                        } catch (Throwable th7) {
                            ad.b("MBSplashNativeView", th7.getMessage());
                        }
                    }
                }
            });
        }
        ai.a(3, this.f47227x, this.f47221r, getContext(), true, new com.mbridge.msdk.foundation.d.a() { // from class: com.mbridge.msdk.splash.view.BaseMBSplashNativeView.3
            @Override // com.mbridge.msdk.foundation.d.a
            public final void a() {
                BaseMBSplashNativeView baseMBSplashNativeView = BaseMBSplashNativeView.this;
                baseMBSplashNativeView.f47218o = true;
                BaseMBSplashNativeView.b(baseMBSplashNativeView, false);
            }

            @Override // com.mbridge.msdk.foundation.d.a
            public final void a(String str) {
                BaseMBSplashNativeView baseMBSplashNativeView = BaseMBSplashNativeView.this;
                baseMBSplashNativeView.f47218o = false;
                BaseMBSplashNativeView.b(baseMBSplashNativeView, true);
            }

            @Override // com.mbridge.msdk.foundation.d.a
            public final void b() {
                BaseMBSplashNativeView baseMBSplashNativeView = BaseMBSplashNativeView.this;
                baseMBSplashNativeView.f47218o = false;
                BaseMBSplashNativeView.b(baseMBSplashNativeView, true);
            }
        });
        try {
            drawable = getResources().getDrawable(v.a(getContext().getApplicationContext(), "mbridge_splash_m_circle", "drawable"));
            try {
                drawable.setBounds(0, 0, ai.a(getContext(), 10.0f), ai.a(getContext(), 10.0f));
            } catch (Throwable th4) {
                th = th4;
                ad.b("MBSplashNativeView", th.getMessage());
            }
        } catch (Throwable th5) {
            th = th5;
            drawable = null;
        }
        if (this.I == 1 && this.O) {
            if (this.J != 0 && drawable != null) {
                this.E.setCompoundDrawables(drawable, null, null, null);
            }
            this.E.setText(this.N ? "广告" : "AD");
            this.D.setVisibility(4);
        } else {
            if (this.J != 0 && drawable != null) {
                this.D.setCompoundDrawables(drawable, null, null, null);
            }
            this.D.setText(this.N ? "广告" : "AD");
            this.E.setVisibility(4);
        }
        a();
        if (this.H == 1 || this.f47213j == 1) {
            this.f47210g.setVisibility(8);
        } else {
            this.f47210g.initView(this.f47221r.getAdCall());
        }
        if (this.G == 1) {
            setOnClickListener(new View.OnClickListener() { // from class: com.mbridge.msdk.splash.view.BaseMBSplashNativeView.4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    BaseMBSplashNativeView.this.a(1);
                }
            });
        } else {
            this.f47210g.setOnClickListener(new View.OnClickListener() { // from class: com.mbridge.msdk.splash.view.BaseMBSplashNativeView.5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    BaseMBSplashNativeView.this.a(0);
                }
            });
        }
        this.f47204a.setOnClickListener(new View.OnClickListener() { // from class: com.mbridge.msdk.splash.view.BaseMBSplashNativeView.6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BaseMBSplashNativeView baseMBSplashNativeView = BaseMBSplashNativeView.this;
                if (baseMBSplashNativeView.f47216m) {
                    if (baseMBSplashNativeView.f47220q.getSplashSignalCommunicationImpl() != null && BaseMBSplashNativeView.this.f47220q.getSplashSignalCommunicationImpl().a() != null) {
                        BaseMBSplashNativeView.this.f47220q.getSplashSignalCommunicationImpl().a().a();
                    }
                    BaseMBSplashNativeView.this.f47204a.setVisibility(4);
                    BaseMBSplashNativeView.this.f47204a.setEnabled(false);
                }
            }
        });
        b();
        updateCountDown(this.f47211h);
    }

    public static /* synthetic */ void b(BaseMBSplashNativeView baseMBSplashNativeView, boolean z11) {
        if (baseMBSplashNativeView.f47220q.getSplashSignalCommunicationImpl() == null || baseMBSplashNativeView.f47220q.getSplashSignalCommunicationImpl().a() == null) {
            return;
        }
        baseMBSplashNativeView.f47220q.getSplashSignalCommunicationImpl().a().a(z11 ? 2 : 1, baseMBSplashNativeView.F);
    }

    public static /* synthetic */ void f(BaseMBSplashNativeView baseMBSplashNativeView) {
        if (TextUtils.isEmpty(baseMBSplashNativeView.f47221r.getIconUrl())) {
            baseMBSplashNativeView.A.setVisibility(4);
        } else {
            com.mbridge.msdk.foundation.same.c.b.a(c.m().c()).a(baseMBSplashNativeView.f47221r.getIconUrl(), new com.mbridge.msdk.foundation.same.c.c() { // from class: com.mbridge.msdk.splash.view.BaseMBSplashNativeView.2
                @Override // com.mbridge.msdk.foundation.same.c.c
                public final void onFailedLoad(String str, String str2) {
                    BaseMBSplashNativeView.this.A.setVisibility(4);
                }

                @Override // com.mbridge.msdk.foundation.same.c.c
                public final void onSuccessLoad(Bitmap bitmap, String str) {
                    Bitmap bitmapA;
                    if (bitmap != null) {
                        try {
                            if (bitmap.isRecycled()) {
                                return;
                            }
                            try {
                                if (BaseMBSplashNativeView.this.A == null || (bitmapA = ac.a(bitmap, 1, ai.a(c.m().c(), 40.0f))) == null || bitmapA.isRecycled()) {
                                    return;
                                }
                                BaseMBSplashNativeView.this.A.setImageBitmap(bitmapA);
                                return;
                            } catch (Throwable th2) {
                                ad.b("MBSplashNativeView", th2.getMessage());
                                BaseMBSplashNativeView.this.A.setImageBitmap(bitmap);
                                return;
                            }
                            ad.b("MBSplashNativeView", th.getMessage());
                        } catch (Throwable th3) {
                            ad.b("MBSplashNativeView", th3.getMessage());
                        }
                    }
                }
            });
        }
    }

    public void a() {
    }

    public final void a(int i11) {
        if (this.f47220q.getSplashSignalCommunicationImpl() == null || this.f47220q.getSplashSignalCommunicationImpl().a() == null) {
            return;
        }
        try {
            this.f47220q.getSplashSignalCommunicationImpl().a().a(com.mbridge.msdk.splash.a.a.a.a(com.mbridge.msdk.splash.a.a.a.a(i11, this.L, this.M), this.f47221r));
        } catch (Throwable th2) {
            ad.b("MBSplashNativeView", th2.getMessage());
            this.f47220q.getSplashSignalCommunicationImpl().a().a(this.f47221r);
        }
    }

    public void b() {
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        try {
            if (this.f47213j != 1 || this.f47222s == null || this.f47223t == null) {
                return;
            }
            com.mbridge.msdk.shake.a.a().a(this.f47223t);
        } catch (Throwable th2) {
            ad.b("MBSplashNativeView", th2.getMessage());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        release();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        this.L = motionEvent.getRawX();
        this.M = motionEvent.getRawY();
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void release() {
        try {
            if (this.f47223t != null) {
                com.mbridge.msdk.shake.a.a().b(this.f47223t);
                this.f47223t = null;
            }
            com.mbridge.msdk.foundation.d.b.a().c(this.f47219p);
            detachAllViewsFromParent();
        } catch (Exception e11) {
            ad.b("MBSplashNativeView", e11.getMessage());
        }
    }

    public void setIsPause(boolean z11) {
        this.f47217n = z11;
    }

    public void setNotchPadding(int i11, int i12, int i13, int i14) {
        try {
            RelativeLayout relativeLayout = this.f47226w;
            if (relativeLayout == null) {
                return;
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) relativeLayout.getLayoutParams();
            int i15 = this.K;
            layoutParams.leftMargin = i11 + i15;
            layoutParams.rightMargin = i12 + i15;
            layoutParams.topMargin = i13 + i15;
            layoutParams.bottomMargin = i15 + i14;
        } catch (Throwable th2) {
            ad.b("MBSplashNativeView", th2.getMessage());
        }
    }

    public void updateCountDown(int i11) {
        String str;
        if (this.f47204a != null) {
            this.F = i11;
            if (this.f47216m) {
                str = this.R + " " + i11 + this.Q;
            } else {
                str = i11 + this.Q + " " + this.S;
            }
            this.f47204a.setText(str);
        }
    }
}
