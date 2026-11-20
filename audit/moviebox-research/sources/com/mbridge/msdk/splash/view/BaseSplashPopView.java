package com.mbridge.msdk.splash.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.mbridge.msdk.click.i;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.c.b;
import com.mbridge.msdk.foundation.tools.ac;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.foundation.tools.ah;
import com.mbridge.msdk.foundation.tools.ai;
import com.mbridge.msdk.foundation.tools.o;
import com.mbridge.msdk.out.Campaign;
import com.mbridge.msdk.out.MBridgeIds;
import com.mbridge.msdk.splash.d.d;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class BaseSplashPopView extends RelativeLayout {
    public static final int TYPE_POP_DEFAULT = 1;
    public static final int TYPE_POP_LARGE = 4;
    public static final int TYPE_POP_MEDIUM = 3;
    public static final int TYPE_POP_SMALL = 2;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final AtomicInteger f47237h = new AtomicInteger(1);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected String f47238a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected String f47239b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected d f47240c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected Handler f47241d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected com.mbridge.msdk.click.a f47242e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    View.OnClickListener f47243f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    View.OnClickListener f47244g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f47245i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private CampaignEx f47246j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private ImageView f47247k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private ImageView f47248l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private ImageView f47249m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private ImageView f47250n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private TextView f47251o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private TextView f47252p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private TextView f47253q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f47254r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f47255s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private i f47256t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private Runnable f47257u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private Runnable f47258v;

    /* JADX INFO: compiled from: source.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f47268a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f47269b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f47270c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private CampaignEx f47271d;

        public a(String str, String str2, int i11, CampaignEx campaignEx) {
            this.f47268a = str;
            this.f47269b = str2;
            this.f47270c = i11;
            this.f47271d = campaignEx;
        }

        public final String a() {
            return this.f47268a;
        }

        public final String b() {
            return this.f47269b;
        }

        public final int c() {
            return this.f47270c;
        }

        public final CampaignEx d() {
            return this.f47271d;
        }
    }

    public BaseSplashPopView(Context context) {
        super(context);
        this.f47245i = 1;
        this.f47254r = -1;
        this.f47241d = new Handler();
        this.f47255s = false;
        this.f47256t = new i() { // from class: com.mbridge.msdk.splash.view.BaseSplashPopView.1
            @Override // com.mbridge.msdk.out.BaseTrackingListener
            public final void onFinishRedirection(Campaign campaign, String str) {
                if (campaign == null) {
                    return;
                }
                ah.a(campaign, BaseSplashPopView.this);
            }

            @Override // com.mbridge.msdk.out.BaseTrackingListener
            public final void onRedirectionFailed(Campaign campaign, String str) {
                if (campaign == null) {
                    return;
                }
                ah.a(campaign, BaseSplashPopView.this);
            }

            @Override // com.mbridge.msdk.out.BaseTrackingListener
            public final void onStartRedirection(Campaign campaign, String str) {
                int iA;
                int iA2;
                if (BaseSplashPopView.this.f47245i == 1) {
                    int iMin = Math.min(BaseSplashPopView.this.getWidth(), BaseSplashPopView.this.getHeight());
                    int iA3 = (ai.a(BaseSplashPopView.this.getContext(), 60.0f) - Math.min(Math.max(iMin / 4, 70), iMin)) / 2;
                    iA = ai.a(BaseSplashPopView.this.getContext(), 23.0f) + iA3;
                    iA2 = ai.a(BaseSplashPopView.this.getContext(), 10.0f) + iA3;
                } else {
                    iA = 0;
                    iA2 = 0;
                }
                ah.a(campaign, BaseSplashPopView.this, iA, iA2);
            }
        };
        this.f47257u = new Runnable() { // from class: com.mbridge.msdk.splash.view.BaseSplashPopView.5
            @Override // java.lang.Runnable
            public final void run() {
                if (BaseSplashPopView.this.f47253q != null) {
                    if (BaseSplashPopView.this.f47254r != 0) {
                        BaseSplashPopView.i(BaseSplashPopView.this);
                        BaseSplashPopView.this.f47253q.setText(String.valueOf(BaseSplashPopView.this.f47254r));
                        BaseSplashPopView baseSplashPopView = BaseSplashPopView.this;
                        baseSplashPopView.f47241d.postDelayed(baseSplashPopView.f47257u, 1000L);
                        return;
                    }
                    BaseSplashPopView.this.f47254r = -1;
                    BaseSplashPopView.this.g();
                    BaseSplashPopView baseSplashPopView2 = BaseSplashPopView.this;
                    baseSplashPopView2.f47241d.removeCallbacks(baseSplashPopView2.f47257u);
                    BaseSplashPopView baseSplashPopView3 = BaseSplashPopView.this;
                    d dVar = baseSplashPopView3.f47240c;
                    if (dVar != null) {
                        dVar.a(new MBridgeIds(baseSplashPopView3.f47238a, baseSplashPopView3.f47239b), 5);
                    }
                }
            }
        };
        this.f47258v = new Runnable() { // from class: com.mbridge.msdk.splash.view.BaseSplashPopView.6
            @Override // java.lang.Runnable
            public final void run() {
                BaseSplashPopView baseSplashPopView = BaseSplashPopView.this;
                d dVar = baseSplashPopView.f47240c;
                if (dVar != null) {
                    dVar.a(new MBridgeIds(baseSplashPopView.f47238a, baseSplashPopView.f47239b), BaseSplashPopView.this.getWidth(), BaseSplashPopView.this.getHeight(), BaseSplashPopView.this.f47245i);
                }
            }
        };
        this.f47243f = new View.OnClickListener() { // from class: com.mbridge.msdk.splash.view.BaseSplashPopView.7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BaseSplashPopView baseSplashPopView = BaseSplashPopView.this;
                if (baseSplashPopView.f47240c != null) {
                    baseSplashPopView.a(baseSplashPopView.f47246j);
                }
            }
        };
        this.f47244g = new View.OnClickListener() { // from class: com.mbridge.msdk.splash.view.BaseSplashPopView.8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BaseSplashPopView baseSplashPopView;
                d dVar;
                if (BaseSplashPopView.this.f47254r <= 0 && (dVar = (baseSplashPopView = BaseSplashPopView.this).f47240c) != null) {
                    dVar.a(new MBridgeIds(baseSplashPopView.f47238a, baseSplashPopView.f47239b), 4);
                }
            }
        };
        this.f47245i = 1;
        ad.c("MBSplashPopView", "Please call setPopViewType() to init.");
    }

    public BaseSplashPopView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f47245i = 1;
        this.f47254r = -1;
        this.f47241d = new Handler();
        this.f47255s = false;
        this.f47256t = new i() { // from class: com.mbridge.msdk.splash.view.BaseSplashPopView.1
            @Override // com.mbridge.msdk.out.BaseTrackingListener
            public final void onFinishRedirection(Campaign campaign, String str) {
                if (campaign == null) {
                    return;
                }
                ah.a(campaign, BaseSplashPopView.this);
            }

            @Override // com.mbridge.msdk.out.BaseTrackingListener
            public final void onRedirectionFailed(Campaign campaign, String str) {
                if (campaign == null) {
                    return;
                }
                ah.a(campaign, BaseSplashPopView.this);
            }

            @Override // com.mbridge.msdk.out.BaseTrackingListener
            public final void onStartRedirection(Campaign campaign, String str) {
                int iA;
                int iA2;
                if (BaseSplashPopView.this.f47245i == 1) {
                    int iMin = Math.min(BaseSplashPopView.this.getWidth(), BaseSplashPopView.this.getHeight());
                    int iA3 = (ai.a(BaseSplashPopView.this.getContext(), 60.0f) - Math.min(Math.max(iMin / 4, 70), iMin)) / 2;
                    iA = ai.a(BaseSplashPopView.this.getContext(), 23.0f) + iA3;
                    iA2 = ai.a(BaseSplashPopView.this.getContext(), 10.0f) + iA3;
                } else {
                    iA = 0;
                    iA2 = 0;
                }
                ah.a(campaign, BaseSplashPopView.this, iA, iA2);
            }
        };
        this.f47257u = new Runnable() { // from class: com.mbridge.msdk.splash.view.BaseSplashPopView.5
            @Override // java.lang.Runnable
            public final void run() {
                if (BaseSplashPopView.this.f47253q != null) {
                    if (BaseSplashPopView.this.f47254r != 0) {
                        BaseSplashPopView.i(BaseSplashPopView.this);
                        BaseSplashPopView.this.f47253q.setText(String.valueOf(BaseSplashPopView.this.f47254r));
                        BaseSplashPopView baseSplashPopView = BaseSplashPopView.this;
                        baseSplashPopView.f47241d.postDelayed(baseSplashPopView.f47257u, 1000L);
                        return;
                    }
                    BaseSplashPopView.this.f47254r = -1;
                    BaseSplashPopView.this.g();
                    BaseSplashPopView baseSplashPopView2 = BaseSplashPopView.this;
                    baseSplashPopView2.f47241d.removeCallbacks(baseSplashPopView2.f47257u);
                    BaseSplashPopView baseSplashPopView3 = BaseSplashPopView.this;
                    d dVar = baseSplashPopView3.f47240c;
                    if (dVar != null) {
                        dVar.a(new MBridgeIds(baseSplashPopView3.f47238a, baseSplashPopView3.f47239b), 5);
                    }
                }
            }
        };
        this.f47258v = new Runnable() { // from class: com.mbridge.msdk.splash.view.BaseSplashPopView.6
            @Override // java.lang.Runnable
            public final void run() {
                BaseSplashPopView baseSplashPopView = BaseSplashPopView.this;
                d dVar = baseSplashPopView.f47240c;
                if (dVar != null) {
                    dVar.a(new MBridgeIds(baseSplashPopView.f47238a, baseSplashPopView.f47239b), BaseSplashPopView.this.getWidth(), BaseSplashPopView.this.getHeight(), BaseSplashPopView.this.f47245i);
                }
            }
        };
        this.f47243f = new View.OnClickListener() { // from class: com.mbridge.msdk.splash.view.BaseSplashPopView.7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BaseSplashPopView baseSplashPopView = BaseSplashPopView.this;
                if (baseSplashPopView.f47240c != null) {
                    baseSplashPopView.a(baseSplashPopView.f47246j);
                }
            }
        };
        this.f47244g = new View.OnClickListener() { // from class: com.mbridge.msdk.splash.view.BaseSplashPopView.8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BaseSplashPopView baseSplashPopView;
                d dVar;
                if (BaseSplashPopView.this.f47254r <= 0 && (dVar = (baseSplashPopView = BaseSplashPopView.this).f47240c) != null) {
                    dVar.a(new MBridgeIds(baseSplashPopView.f47238a, baseSplashPopView.f47239b), 4);
                }
            }
        };
        this.f47245i = 1;
        ad.c("MBSplashPopView", "Please call setPopViewType() to init.");
    }

    public BaseSplashPopView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f47245i = 1;
        this.f47254r = -1;
        this.f47241d = new Handler();
        this.f47255s = false;
        this.f47256t = new i() { // from class: com.mbridge.msdk.splash.view.BaseSplashPopView.1
            @Override // com.mbridge.msdk.out.BaseTrackingListener
            public final void onFinishRedirection(Campaign campaign, String str) {
                if (campaign == null) {
                    return;
                }
                ah.a(campaign, BaseSplashPopView.this);
            }

            @Override // com.mbridge.msdk.out.BaseTrackingListener
            public final void onRedirectionFailed(Campaign campaign, String str) {
                if (campaign == null) {
                    return;
                }
                ah.a(campaign, BaseSplashPopView.this);
            }

            @Override // com.mbridge.msdk.out.BaseTrackingListener
            public final void onStartRedirection(Campaign campaign, String str) {
                int iA;
                int iA2;
                if (BaseSplashPopView.this.f47245i == 1) {
                    int iMin = Math.min(BaseSplashPopView.this.getWidth(), BaseSplashPopView.this.getHeight());
                    int iA3 = (ai.a(BaseSplashPopView.this.getContext(), 60.0f) - Math.min(Math.max(iMin / 4, 70), iMin)) / 2;
                    iA = ai.a(BaseSplashPopView.this.getContext(), 23.0f) + iA3;
                    iA2 = ai.a(BaseSplashPopView.this.getContext(), 10.0f) + iA3;
                } else {
                    iA = 0;
                    iA2 = 0;
                }
                ah.a(campaign, BaseSplashPopView.this, iA, iA2);
            }
        };
        this.f47257u = new Runnable() { // from class: com.mbridge.msdk.splash.view.BaseSplashPopView.5
            @Override // java.lang.Runnable
            public final void run() {
                if (BaseSplashPopView.this.f47253q != null) {
                    if (BaseSplashPopView.this.f47254r != 0) {
                        BaseSplashPopView.i(BaseSplashPopView.this);
                        BaseSplashPopView.this.f47253q.setText(String.valueOf(BaseSplashPopView.this.f47254r));
                        BaseSplashPopView baseSplashPopView = BaseSplashPopView.this;
                        baseSplashPopView.f47241d.postDelayed(baseSplashPopView.f47257u, 1000L);
                        return;
                    }
                    BaseSplashPopView.this.f47254r = -1;
                    BaseSplashPopView.this.g();
                    BaseSplashPopView baseSplashPopView2 = BaseSplashPopView.this;
                    baseSplashPopView2.f47241d.removeCallbacks(baseSplashPopView2.f47257u);
                    BaseSplashPopView baseSplashPopView3 = BaseSplashPopView.this;
                    d dVar = baseSplashPopView3.f47240c;
                    if (dVar != null) {
                        dVar.a(new MBridgeIds(baseSplashPopView3.f47238a, baseSplashPopView3.f47239b), 5);
                    }
                }
            }
        };
        this.f47258v = new Runnable() { // from class: com.mbridge.msdk.splash.view.BaseSplashPopView.6
            @Override // java.lang.Runnable
            public final void run() {
                BaseSplashPopView baseSplashPopView = BaseSplashPopView.this;
                d dVar = baseSplashPopView.f47240c;
                if (dVar != null) {
                    dVar.a(new MBridgeIds(baseSplashPopView.f47238a, baseSplashPopView.f47239b), BaseSplashPopView.this.getWidth(), BaseSplashPopView.this.getHeight(), BaseSplashPopView.this.f47245i);
                }
            }
        };
        this.f47243f = new View.OnClickListener() { // from class: com.mbridge.msdk.splash.view.BaseSplashPopView.7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BaseSplashPopView baseSplashPopView = BaseSplashPopView.this;
                if (baseSplashPopView.f47240c != null) {
                    baseSplashPopView.a(baseSplashPopView.f47246j);
                }
            }
        };
        this.f47244g = new View.OnClickListener() { // from class: com.mbridge.msdk.splash.view.BaseSplashPopView.8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BaseSplashPopView baseSplashPopView;
                d dVar;
                if (BaseSplashPopView.this.f47254r <= 0 && (dVar = (baseSplashPopView = BaseSplashPopView.this).f47240c) != null) {
                    dVar.a(new MBridgeIds(baseSplashPopView.f47238a, baseSplashPopView.f47239b), 4);
                }
            }
        };
        this.f47245i = 1;
        ad.c("MBSplashPopView", "Please call setPopViewType() to init.");
    }

    public BaseSplashPopView(Context context, AttributeSet attributeSet, int i11, int i12) {
        super(context, attributeSet, i11, i12);
        this.f47245i = 1;
        this.f47254r = -1;
        this.f47241d = new Handler();
        this.f47255s = false;
        this.f47256t = new i() { // from class: com.mbridge.msdk.splash.view.BaseSplashPopView.1
            @Override // com.mbridge.msdk.out.BaseTrackingListener
            public final void onFinishRedirection(Campaign campaign, String str) {
                if (campaign == null) {
                    return;
                }
                ah.a(campaign, BaseSplashPopView.this);
            }

            @Override // com.mbridge.msdk.out.BaseTrackingListener
            public final void onRedirectionFailed(Campaign campaign, String str) {
                if (campaign == null) {
                    return;
                }
                ah.a(campaign, BaseSplashPopView.this);
            }

            @Override // com.mbridge.msdk.out.BaseTrackingListener
            public final void onStartRedirection(Campaign campaign, String str) {
                int iA;
                int iA2;
                if (BaseSplashPopView.this.f47245i == 1) {
                    int iMin = Math.min(BaseSplashPopView.this.getWidth(), BaseSplashPopView.this.getHeight());
                    int iA3 = (ai.a(BaseSplashPopView.this.getContext(), 60.0f) - Math.min(Math.max(iMin / 4, 70), iMin)) / 2;
                    iA = ai.a(BaseSplashPopView.this.getContext(), 23.0f) + iA3;
                    iA2 = ai.a(BaseSplashPopView.this.getContext(), 10.0f) + iA3;
                } else {
                    iA = 0;
                    iA2 = 0;
                }
                ah.a(campaign, BaseSplashPopView.this, iA, iA2);
            }
        };
        this.f47257u = new Runnable() { // from class: com.mbridge.msdk.splash.view.BaseSplashPopView.5
            @Override // java.lang.Runnable
            public final void run() {
                if (BaseSplashPopView.this.f47253q != null) {
                    if (BaseSplashPopView.this.f47254r != 0) {
                        BaseSplashPopView.i(BaseSplashPopView.this);
                        BaseSplashPopView.this.f47253q.setText(String.valueOf(BaseSplashPopView.this.f47254r));
                        BaseSplashPopView baseSplashPopView = BaseSplashPopView.this;
                        baseSplashPopView.f47241d.postDelayed(baseSplashPopView.f47257u, 1000L);
                        return;
                    }
                    BaseSplashPopView.this.f47254r = -1;
                    BaseSplashPopView.this.g();
                    BaseSplashPopView baseSplashPopView2 = BaseSplashPopView.this;
                    baseSplashPopView2.f47241d.removeCallbacks(baseSplashPopView2.f47257u);
                    BaseSplashPopView baseSplashPopView3 = BaseSplashPopView.this;
                    d dVar = baseSplashPopView3.f47240c;
                    if (dVar != null) {
                        dVar.a(new MBridgeIds(baseSplashPopView3.f47238a, baseSplashPopView3.f47239b), 5);
                    }
                }
            }
        };
        this.f47258v = new Runnable() { // from class: com.mbridge.msdk.splash.view.BaseSplashPopView.6
            @Override // java.lang.Runnable
            public final void run() {
                BaseSplashPopView baseSplashPopView = BaseSplashPopView.this;
                d dVar = baseSplashPopView.f47240c;
                if (dVar != null) {
                    dVar.a(new MBridgeIds(baseSplashPopView.f47238a, baseSplashPopView.f47239b), BaseSplashPopView.this.getWidth(), BaseSplashPopView.this.getHeight(), BaseSplashPopView.this.f47245i);
                }
            }
        };
        this.f47243f = new View.OnClickListener() { // from class: com.mbridge.msdk.splash.view.BaseSplashPopView.7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BaseSplashPopView baseSplashPopView = BaseSplashPopView.this;
                if (baseSplashPopView.f47240c != null) {
                    baseSplashPopView.a(baseSplashPopView.f47246j);
                }
            }
        };
        this.f47244g = new View.OnClickListener() { // from class: com.mbridge.msdk.splash.view.BaseSplashPopView.8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BaseSplashPopView baseSplashPopView;
                d dVar;
                if (BaseSplashPopView.this.f47254r <= 0 && (dVar = (baseSplashPopView = BaseSplashPopView.this).f47240c) != null) {
                    dVar.a(new MBridgeIds(baseSplashPopView.f47238a, baseSplashPopView.f47239b), 4);
                }
            }
        };
        this.f47245i = 1;
        ad.c("MBSplashPopView", "Please call setPopViewType() to init.");
    }

    public BaseSplashPopView(Context context, a aVar, d dVar) {
        super(context);
        this.f47245i = 1;
        this.f47254r = -1;
        this.f47241d = new Handler();
        this.f47255s = false;
        this.f47256t = new i() { // from class: com.mbridge.msdk.splash.view.BaseSplashPopView.1
            @Override // com.mbridge.msdk.out.BaseTrackingListener
            public final void onFinishRedirection(Campaign campaign, String str) {
                if (campaign == null) {
                    return;
                }
                ah.a(campaign, BaseSplashPopView.this);
            }

            @Override // com.mbridge.msdk.out.BaseTrackingListener
            public final void onRedirectionFailed(Campaign campaign, String str) {
                if (campaign == null) {
                    return;
                }
                ah.a(campaign, BaseSplashPopView.this);
            }

            @Override // com.mbridge.msdk.out.BaseTrackingListener
            public final void onStartRedirection(Campaign campaign, String str) {
                int iA;
                int iA2;
                if (BaseSplashPopView.this.f47245i == 1) {
                    int iMin = Math.min(BaseSplashPopView.this.getWidth(), BaseSplashPopView.this.getHeight());
                    int iA3 = (ai.a(BaseSplashPopView.this.getContext(), 60.0f) - Math.min(Math.max(iMin / 4, 70), iMin)) / 2;
                    iA = ai.a(BaseSplashPopView.this.getContext(), 23.0f) + iA3;
                    iA2 = ai.a(BaseSplashPopView.this.getContext(), 10.0f) + iA3;
                } else {
                    iA = 0;
                    iA2 = 0;
                }
                ah.a(campaign, BaseSplashPopView.this, iA, iA2);
            }
        };
        this.f47257u = new Runnable() { // from class: com.mbridge.msdk.splash.view.BaseSplashPopView.5
            @Override // java.lang.Runnable
            public final void run() {
                if (BaseSplashPopView.this.f47253q != null) {
                    if (BaseSplashPopView.this.f47254r != 0) {
                        BaseSplashPopView.i(BaseSplashPopView.this);
                        BaseSplashPopView.this.f47253q.setText(String.valueOf(BaseSplashPopView.this.f47254r));
                        BaseSplashPopView baseSplashPopView = BaseSplashPopView.this;
                        baseSplashPopView.f47241d.postDelayed(baseSplashPopView.f47257u, 1000L);
                        return;
                    }
                    BaseSplashPopView.this.f47254r = -1;
                    BaseSplashPopView.this.g();
                    BaseSplashPopView baseSplashPopView2 = BaseSplashPopView.this;
                    baseSplashPopView2.f47241d.removeCallbacks(baseSplashPopView2.f47257u);
                    BaseSplashPopView baseSplashPopView3 = BaseSplashPopView.this;
                    d dVar2 = baseSplashPopView3.f47240c;
                    if (dVar2 != null) {
                        dVar2.a(new MBridgeIds(baseSplashPopView3.f47238a, baseSplashPopView3.f47239b), 5);
                    }
                }
            }
        };
        this.f47258v = new Runnable() { // from class: com.mbridge.msdk.splash.view.BaseSplashPopView.6
            @Override // java.lang.Runnable
            public final void run() {
                BaseSplashPopView baseSplashPopView = BaseSplashPopView.this;
                d dVar2 = baseSplashPopView.f47240c;
                if (dVar2 != null) {
                    dVar2.a(new MBridgeIds(baseSplashPopView.f47238a, baseSplashPopView.f47239b), BaseSplashPopView.this.getWidth(), BaseSplashPopView.this.getHeight(), BaseSplashPopView.this.f47245i);
                }
            }
        };
        this.f47243f = new View.OnClickListener() { // from class: com.mbridge.msdk.splash.view.BaseSplashPopView.7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BaseSplashPopView baseSplashPopView = BaseSplashPopView.this;
                if (baseSplashPopView.f47240c != null) {
                    baseSplashPopView.a(baseSplashPopView.f47246j);
                }
            }
        };
        this.f47244g = new View.OnClickListener() { // from class: com.mbridge.msdk.splash.view.BaseSplashPopView.8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BaseSplashPopView baseSplashPopView;
                d dVar2;
                if (BaseSplashPopView.this.f47254r <= 0 && (dVar2 = (baseSplashPopView = BaseSplashPopView.this).f47240c) != null) {
                    dVar2.a(new MBridgeIds(baseSplashPopView.f47238a, baseSplashPopView.f47239b), 4);
                }
            }
        };
        if (aVar == null) {
            throw new IllegalArgumentException("Parameters is NULL, can't gen view.");
        }
        this.f47239b = aVar.b();
        this.f47238a = aVar.a();
        this.f47245i = aVar.c();
        this.f47246j = aVar.d();
        this.f47240c = dVar;
        a();
    }

    private void a() {
        if (this.f47246j == null) {
            return;
        }
        setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        int i11 = this.f47245i;
        if (i11 == 1) {
            b();
            return;
        }
        if (i11 == 2) {
            c();
        } else if (i11 == 3) {
            d();
        } else {
            if (i11 != 4) {
                return;
            }
            e();
        }
    }

    private void a(String str) {
        b.a(c.m().c()).a(str, new com.mbridge.msdk.foundation.same.c.c() { // from class: com.mbridge.msdk.splash.view.BaseSplashPopView.3
            @Override // com.mbridge.msdk.foundation.same.c.c
            public final void onFailedLoad(String str2, String str3) {
                ad.b("MBSplashPopView", str2);
            }

            @Override // com.mbridge.msdk.foundation.same.c.c
            public final void onSuccessLoad(Bitmap bitmap, String str2) {
                try {
                    if (bitmap.isRecycled()) {
                        return;
                    }
                    BaseSplashPopView.this.f47249m.setImageBitmap(o.a(bitmap, 10));
                } catch (Throwable th2) {
                    ad.b("MBSplashPopView", th2.getMessage());
                }
            }
        });
    }

    private void a(String str, final boolean z11) {
        b.a(c.m().c()).a(str, new com.mbridge.msdk.foundation.same.c.c() { // from class: com.mbridge.msdk.splash.view.BaseSplashPopView.2
            @Override // com.mbridge.msdk.foundation.same.c.c
            public final void onFailedLoad(String str2, String str3) {
                ad.b("MBSplashPopView", str2);
            }

            @Override // com.mbridge.msdk.foundation.same.c.c
            public final void onSuccessLoad(Bitmap bitmap, String str2) {
                Bitmap bitmapA;
                try {
                    if (bitmap.isRecycled()) {
                        return;
                    }
                    if (!z11) {
                        bitmapA = ac.a(bitmap, 1, 16);
                    } else if (bitmap.isRecycled()) {
                        bitmapA = null;
                    } else {
                        int width = bitmap.getWidth();
                        bitmapA = Bitmap.createBitmap(width, width, Bitmap.Config.ARGB_4444);
                        Canvas canvas = new Canvas(bitmapA);
                        Paint paint = new Paint();
                        paint.setAntiAlias(true);
                        canvas.drawCircle(width / 2, width / 2, width / 2, paint);
                        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
                        canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
                    }
                    ImageView imageView = BaseSplashPopView.this.f47247k;
                    if (bitmapA != null) {
                        bitmap = bitmapA;
                    }
                    imageView.setImageBitmap(bitmap);
                } catch (Throwable th2) {
                    ad.b("MBSplashPopView", th2.getMessage());
                }
            }
        });
    }

    private void b() {
        View imageView = new ImageView(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ai.a(getContext(), 80.0f), ai.a(getContext(), 80.0f));
        layoutParams.addRule(9);
        layoutParams.topMargin = ai.a(getContext(), 16.0f);
        imageView.setId(generateViewId());
        imageView.setLayoutParams(layoutParams);
        imageView.setBackgroundResource(getResources().getIdentifier("mbridge_splash_popview_default", "drawable", c.m().g()));
        this.f47247k = new ImageView(getContext());
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(ai.a(getContext(), 60.0f), ai.a(getContext(), 60.0f));
        layoutParams2.addRule(6, imageView.getId());
        layoutParams2.topMargin = ai.a(getContext(), 7.0f);
        layoutParams2.leftMargin = ai.a(getContext(), 10.0f);
        this.f47247k.setId(generateViewId());
        this.f47247k.setLayoutParams(layoutParams2);
        this.f47247k.setScaleType(ImageView.ScaleType.FIT_CENTER);
        CampaignEx campaignEx = this.f47246j;
        if (campaignEx != null && !TextUtils.isEmpty(campaignEx.getIconUrl())) {
            a(this.f47246j.getIconUrl(), true);
        }
        this.f47253q = new TextView(getContext());
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(5, imageView.getId());
        layoutParams3.addRule(8, imageView.getId());
        layoutParams3.leftMargin = ai.a(getContext(), 62.0f);
        layoutParams3.bottomMargin = ai.a(getContext(), 70.0f);
        this.f47253q.setId(generateViewId());
        this.f47253q.setTextSize(10.0f);
        this.f47253q.setTextColor(-1);
        this.f47253q.setGravity(17);
        this.f47253q.setMinWidth(ai.a(getContext(), 16.0f));
        this.f47253q.setMaxHeight(ai.a(getContext(), 16.0f));
        this.f47253q.setLayoutParams(layoutParams3);
        this.f47253q.setBackgroundResource(getResources().getIdentifier("mbridge_cm_circle_50black", "drawable", c.m().g()));
        addView(imageView);
        addView(this.f47253q);
        addView(this.f47247k);
        CampaignEx campaignEx2 = this.f47246j;
        if (campaignEx2 != null && campaignEx2.getFlbSkipTime() <= 0) {
            g();
        }
        setOnClickListener(this.f47243f);
        this.f47253q.setOnClickListener(this.f47244g);
    }

    private void b(String str) {
        b.a(c.m().c()).a(str, new com.mbridge.msdk.foundation.same.c.c() { // from class: com.mbridge.msdk.splash.view.BaseSplashPopView.4
            @Override // com.mbridge.msdk.foundation.same.c.c
            public final void onFailedLoad(String str2, String str3) {
                ad.b("MBSplashPopView", str2);
            }

            @Override // com.mbridge.msdk.foundation.same.c.c
            public final void onSuccessLoad(Bitmap bitmap, String str2) {
                try {
                    if (bitmap.isRecycled()) {
                        return;
                    }
                    BaseSplashPopView.this.f47248l.setImageBitmap(ac.a(bitmap, 1, 16));
                } catch (Throwable th2) {
                    ad.b("MBSplashPopView", th2.getMessage());
                }
            }
        });
    }

    private void c() {
        int iA = ai.a(getContext(), 4.0f);
        this.f47247k = new ImageView(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ai.a(getContext(), 28.0f), ai.a(getContext(), 28.0f));
        layoutParams.addRule(9);
        this.f47247k.setId(generateViewId());
        this.f47247k.setLayoutParams(layoutParams);
        this.f47247k.setPadding(iA, iA, iA, iA);
        this.f47247k.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        a(this.f47246j.getIconUrl(), false);
        TextView textView = new TextView(getContext());
        this.f47251o = textView;
        textView.setId(generateViewId());
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(1, this.f47247k.getId());
        layoutParams2.addRule(6, this.f47247k.getId());
        layoutParams2.addRule(8, this.f47247k.getId());
        layoutParams2.leftMargin = ai.a(getContext(), 4.0f);
        layoutParams2.rightMargin = ai.a(getContext(), 40.0f);
        this.f47251o.setLayoutParams(layoutParams2);
        this.f47251o.setGravity(16);
        this.f47251o.setTextSize(10.0f);
        this.f47251o.setSelected(true);
        this.f47251o.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        this.f47251o.setMarqueeRepeatLimit(-1);
        this.f47251o.setSingleLine(true);
        this.f47251o.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        this.f47251o.setText(this.f47246j.getAppName());
        setBackgroundResource(getResources().getIdentifier("mbridge_shape_corners_bg", "drawable", c.m().g()));
        addView(this.f47247k);
        addView(this.f47251o);
        f();
        setOnClickListener(this.f47243f);
    }

    private void d() {
        int iA = ai.a(getContext(), 4.0f);
        this.f47247k = new ImageView(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ai.a(getContext(), 50.0f), ai.a(getContext(), 50.0f));
        layoutParams.addRule(9);
        this.f47247k.setId(generateViewId());
        this.f47247k.setLayoutParams(layoutParams);
        this.f47247k.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.f47247k.setPadding(iA, iA, iA, iA);
        a(this.f47246j.getIconUrl(), false);
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.addRule(1, this.f47247k.getId());
        layoutParams2.addRule(6, this.f47247k.getId());
        layoutParams2.addRule(8, this.f47247k.getId());
        layoutParams2.leftMargin = ai.a(getContext(), 8.0f);
        layoutParams2.rightMargin = ai.a(getContext(), 8.0f);
        relativeLayout.setLayoutParams(layoutParams2);
        relativeLayout.setGravity(16);
        TextView textView = new TextView(getContext());
        this.f47251o = textView;
        textView.setId(generateViewId());
        this.f47251o.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
        this.f47251o.setGravity(16);
        this.f47251o.setTextSize(12.0f);
        this.f47251o.setSelected(true);
        TextView textView2 = this.f47251o;
        TextUtils.TruncateAt truncateAt = TextUtils.TruncateAt.MARQUEE;
        textView2.setEllipsize(truncateAt);
        this.f47251o.setMarqueeRepeatLimit(-1);
        this.f47251o.setSingleLine(true);
        this.f47251o.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        this.f47251o.setText(this.f47246j.getAppName());
        TextView textView3 = new TextView(getContext());
        this.f47252p = textView3;
        textView3.setId(generateViewId());
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(5, this.f47251o.getId());
        layoutParams3.addRule(3, this.f47251o.getId());
        layoutParams3.topMargin = ai.a(getContext(), 4.0f);
        layoutParams3.rightMargin = ai.a(getContext(), 36.0f);
        this.f47252p.setGravity(16);
        this.f47252p.setLayoutParams(layoutParams3);
        this.f47252p.setTextSize(8.0f);
        this.f47252p.setTextColor(-10066330);
        this.f47252p.setEllipsize(truncateAt);
        this.f47252p.setMarqueeRepeatLimit(-1);
        this.f47252p.setSelected(true);
        this.f47252p.setSingleLine(true);
        this.f47252p.setText(this.f47246j.getAppDesc());
        relativeLayout.addView(this.f47251o);
        relativeLayout.addView(this.f47252p);
        setBackgroundResource(getResources().getIdentifier("mbridge_shape_corners_bg", "drawable", c.m().g()));
        addView(this.f47247k);
        addView(relativeLayout);
        f();
        setOnClickListener(this.f47243f);
    }

    private void e() {
        this.f47249m = new ImageView(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, ai.a(getContext(), 131.0f));
        layoutParams.addRule(10);
        layoutParams.addRule(14);
        this.f47249m.setScaleType(ImageView.ScaleType.FIT_XY);
        this.f47249m.setId(generateViewId());
        this.f47249m.setLayoutParams(layoutParams);
        a(this.f47246j.getImageUrl());
        this.f47248l = new ImageView(getContext());
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, ai.a(getContext(), 131.0f));
        layoutParams2.addRule(10);
        layoutParams2.addRule(14);
        this.f47248l.setScaleType(ImageView.ScaleType.FIT_CENTER);
        this.f47248l.setId(generateViewId());
        this.f47248l.setLayoutParams(layoutParams2);
        b(this.f47246j.getImageUrl());
        this.f47247k = new ImageView(getContext());
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(ai.a(getContext(), 50.0f), ai.a(getContext(), 50.0f));
        layoutParams3.addRule(9);
        layoutParams3.addRule(3, this.f47249m.getId());
        layoutParams3.topMargin = 20;
        this.f47247k.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.f47247k.setId(generateViewId());
        this.f47247k.setLayoutParams(layoutParams3);
        a(this.f47246j.getIconUrl(), false);
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams4.addRule(1, this.f47247k.getId());
        layoutParams4.addRule(6, this.f47247k.getId());
        layoutParams4.addRule(8, this.f47247k.getId());
        layoutParams4.leftMargin = ai.a(getContext(), 8.0f);
        layoutParams4.rightMargin = ai.a(getContext(), 8.0f);
        relativeLayout.setLayoutParams(layoutParams4);
        relativeLayout.setGravity(16);
        TextView textView = new TextView(getContext());
        this.f47251o = textView;
        textView.setId(generateViewId());
        this.f47251o.setGravity(16);
        this.f47251o.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
        this.f47251o.setTextSize(12.0f);
        this.f47251o.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        TextView textView2 = this.f47251o;
        TextUtils.TruncateAt truncateAt = TextUtils.TruncateAt.MARQUEE;
        textView2.setEllipsize(truncateAt);
        this.f47251o.setMarqueeRepeatLimit(-1);
        this.f47251o.setSelected(true);
        this.f47251o.setSingleLine(true);
        this.f47251o.setText(this.f47246j.getAppName());
        TextView textView3 = new TextView(getContext());
        this.f47252p = textView3;
        textView3.setId(generateViewId());
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams5.addRule(5, this.f47251o.getId());
        layoutParams5.addRule(3, this.f47251o.getId());
        layoutParams5.topMargin = ai.a(getContext(), 4.0f);
        layoutParams5.rightMargin = ai.a(getContext(), 36.0f);
        this.f47252p.setGravity(16);
        this.f47252p.setLayoutParams(layoutParams5);
        this.f47252p.setTextSize(8.0f);
        this.f47252p.setTextColor(-10066330);
        this.f47252p.setEllipsize(truncateAt);
        this.f47252p.setMarqueeRepeatLimit(-1);
        this.f47252p.setSelected(true);
        this.f47252p.setSingleLine(true);
        this.f47252p.setText(this.f47246j.getAppDesc());
        relativeLayout.addView(this.f47251o);
        relativeLayout.addView(this.f47252p);
        addView(this.f47249m);
        addView(this.f47248l);
        addView(this.f47247k);
        addView(relativeLayout);
        f();
        setOnClickListener(this.f47243f);
    }

    private void f() {
        String language;
        this.f47250n = new ImageView(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ai.a(getContext(), 32.0f), ai.a(getContext(), 13.0f));
        layoutParams.addRule(11);
        layoutParams.addRule(8, this.f47247k.getId());
        this.f47250n.setLayoutParams(layoutParams);
        try {
            language = getResources().getConfiguration().locale.getLanguage();
        } catch (Throwable th2) {
            ad.b("MBSplashPopView", th2.getMessage());
            language = "ZH";
        }
        this.f47250n.setBackgroundResource((language.toUpperCase().equals("CN") || language.toUpperCase().equals("ZH")) ? getResources().getIdentifier("mbridge_splash_pop_ad", "drawable", c.m().g()) : getResources().getIdentifier("mbridge_splash_pop_ad_en", "drawable", c.m().g()));
        addView(this.f47250n);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        TextView textView = this.f47253q;
        if (textView != null) {
            ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
            layoutParams.width = ai.a(getContext(), 16.0f);
            layoutParams.height = ai.a(getContext(), 16.0f);
            this.f47253q.setLayoutParams(layoutParams);
            this.f47253q.setText("");
            this.f47253q.setSelected(true);
            this.f47253q.setBackgroundResource(getResources().getIdentifier("mbridge_splash_popview_close", "drawable", c.m().g()));
        }
    }

    public static int generateViewId() {
        AtomicInteger atomicInteger;
        int i11;
        int i12;
        do {
            atomicInteger = f47237h;
            i11 = atomicInteger.get();
            i12 = i11 + 1;
            if (i12 > 16777215) {
                i12 = 1;
            }
        } while (!atomicInteger.compareAndSet(i11, i12));
        return i11;
    }

    public static /* synthetic */ int i(BaseSplashPopView baseSplashPopView) {
        int i11 = baseSplashPopView.f47254r;
        baseSplashPopView.f47254r = i11 - 1;
        return i11;
    }

    public void a(CampaignEx campaignEx) {
        com.mbridge.msdk.splash.e.a.b(campaignEx, this.f47239b);
    }

    public final void b(CampaignEx campaignEx) {
        if (this.f47242e == null) {
            com.mbridge.msdk.click.a aVar = new com.mbridge.msdk.click.a(c.m().c(), this.f47239b);
            this.f47242e = aVar;
            aVar.a(this.f47256t);
        }
        campaignEx.setCampaignUnitId(this.f47239b);
        this.f47242e.a(campaignEx);
        if (!campaignEx.isReportClick()) {
            campaignEx.setReportClick(true);
            com.mbridge.msdk.splash.e.a.a(c.m().c(), campaignEx);
        }
        d dVar = this.f47240c;
        if (dVar != null) {
            dVar.b(new MBridgeIds(this.f47238a, this.f47239b));
            this.f47240c.a(new MBridgeIds(this.f47238a, this.f47239b), 6);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f47240c != null) {
            postDelayed(this.f47258v, 500L);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        release();
    }

    public void pauseCountDown() {
        this.f47255s = true;
        if (this.f47253q != null) {
            this.f47241d.removeCallbacks(this.f47257u);
        }
    }

    public void reStartCountDown() {
        if (this.f47255s) {
            this.f47255s = false;
            int i11 = this.f47254r;
            if (i11 == -1 || i11 == 0) {
                g();
                return;
            }
            TextView textView = this.f47253q;
            if (textView != null) {
                textView.setText(String.valueOf(i11));
                this.f47241d.postDelayed(this.f47257u, 1000L);
            }
        }
    }

    public void release() {
        try {
            this.f47241d.removeCallbacks(this.f47258v);
            this.f47241d.removeCallbacks(this.f47257u);
            this.f47257u = null;
            detachAllViewsFromParent();
            this.f47246j = null;
            this.f47240c = null;
        } catch (Exception e11) {
            ad.b("MBSplashPopView", e11.getMessage());
        }
    }

    public void setPopViewType(a aVar, d dVar) {
        if (aVar == null) {
            throw new IllegalArgumentException("Parameters is NULL, can't gen view.");
        }
        this.f47239b = aVar.b();
        this.f47238a = aVar.a();
        this.f47245i = aVar.c();
        this.f47246j = aVar.d();
        this.f47240c = dVar;
        a();
    }

    public void startCountDown() {
        this.f47241d.removeCallbacks(this.f47257u);
        CampaignEx campaignEx = this.f47246j;
        if (campaignEx == null || this.f47245i != 1) {
            return;
        }
        int flbSkipTime = campaignEx.getFlbSkipTime();
        if (flbSkipTime <= 0) {
            g();
            return;
        }
        this.f47254r = flbSkipTime;
        TextView textView = this.f47253q;
        if (textView != null) {
            textView.setText(String.valueOf(flbSkipTime));
            this.f47241d.postDelayed(this.f47257u, 1000L);
        }
    }
}
