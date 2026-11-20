package com.mbridge.msdk.splash.c;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import com.mbridge.msdk.click.i;
import com.mbridge.msdk.foundation.db.h;
import com.mbridge.msdk.foundation.db.k;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.n;
import com.mbridge.msdk.foundation.same.report.m;
import com.mbridge.msdk.foundation.same.report.o;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.foundation.tools.ah;
import com.mbridge.msdk.foundation.tools.ai;
import com.mbridge.msdk.foundation.tools.v;
import com.mbridge.msdk.out.Campaign;
import com.mbridge.msdk.out.MBridgeIds;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import com.mbridge.msdk.splash.view.MBSplashView;
import com.mbridge.msdk.splash.view.MBSplashWebview;
import com.mbridge.msdk.widget.FeedBackButton;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected MBSplashView f46998b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected com.mbridge.msdk.splash.d.d f46999c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected com.mbridge.msdk.click.a f47000d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected String f47001e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected MBridgeIds f47002f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    protected String f47004h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    protected String f47005i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    protected String f47006j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    protected String f47007k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    protected boolean f47008l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    protected Context f47009m;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private CampaignEx f47013q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private boolean f47014r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private TextView f47015s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private View f47016t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private String f47017u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private boolean f47018v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private ImageView f47019w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private a f47020x;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final String f46997a = "SplashShowManager";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected int f47003g = 5;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    protected boolean f47010n = true;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private View.OnClickListener f47021y = new View.OnClickListener() { // from class: com.mbridge.msdk.splash.c.b.1
        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (b.this.f47014r) {
                b.this.b(1);
                b.a(b.this, -1);
            }
        }
    };

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Handler f47011o = new Handler(Looper.getMainLooper()) { // from class: com.mbridge.msdk.splash.c.b.2
        /* JADX WARN: Code duplicated, block: B:36:0x00c8  */
        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            MBSplashView mBSplashView;
            MBSplashWebview splashWebview;
            super.handleMessage(message);
            int i11 = message.what;
            if (i11 == 1) {
                if (!b.this.f47018v) {
                    b.this.f();
                }
                b bVar = b.this;
                if (bVar.f47003g <= 0) {
                    bVar.b(2);
                    return;
                }
                if (com.mbridge.msdk.foundation.d.b.f44150c) {
                    b.this.d();
                } else {
                    b bVar2 = b.this;
                    if (bVar2.f47008l) {
                        b.this.d();
                    } else {
                        int i12 = bVar2.f47003g - 1;
                        bVar2.f47003g = i12;
                        b.a(bVar2, i12);
                        b bVar3 = b.this;
                        if (!bVar3.f47010n) {
                            bVar3.c();
                        }
                    }
                }
                b.this.f47011o.removeMessages(1);
                sendEmptyMessageDelayed(1, 1000L);
                return;
            }
            if (i11 != 2 || b.this.f47013q == null || !b.this.f47013q.isActiveOm() || (mBSplashView = b.this.f46998b) == null || (splashWebview = mBSplashView.getSplashWebview()) == null) {
                return;
            }
            try {
                kn.b adSession = splashWebview.getAdSession();
                if (adSession != null) {
                    kn.a.a(adSession).b();
                }
                ad.a("OMSDK", "adSession.impressionOccurred()");
            } catch (Throwable th2) {
                ad.a("OMSDK", th2.getMessage());
                if (b.this.f47013q != null) {
                    String requestId = b.this.f47013q.getRequestId();
                    String requestIdNotice = b.this.f47013q.getRequestIdNotice();
                    String id2 = b.this.f47013q.getId();
                    new o(splashWebview.getContext()).a(requestId, requestIdNotice, id2, b.this.f47001e, "fetch OM failed, exception" + th2.getMessage());
                }
            }
        }
    };

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    protected i f47012p = new i() { // from class: com.mbridge.msdk.splash.c.b.4
        @Override // com.mbridge.msdk.out.BaseTrackingListener
        public final void onFinishRedirection(Campaign campaign, String str) {
            if (campaign == null) {
                return;
            }
            ah.a(campaign, b.this.f46998b);
        }

        @Override // com.mbridge.msdk.out.BaseTrackingListener
        public final void onRedirectionFailed(Campaign campaign, String str) {
            if (campaign == null) {
                return;
            }
            ah.a(campaign, b.this.f46998b);
        }

        @Override // com.mbridge.msdk.out.BaseTrackingListener
        public final void onStartRedirection(Campaign campaign, String str) {
            ah.b(campaign, b.this.f46998b);
        }
    };

    /* JADX INFO: compiled from: source.java */
    public class a implements com.mbridge.msdk.splash.d.a {
        private a() {
        }

        @Override // com.mbridge.msdk.splash.d.a
        public final void a() {
            b.this.b(1);
        }

        @Override // com.mbridge.msdk.splash.d.a
        public final void a(int i11) {
            MBSplashView mBSplashView = b.this.f46998b;
            if (mBSplashView != null) {
                mBSplashView.changeCloseBtnState(i11);
            }
        }

        @Override // com.mbridge.msdk.splash.d.a
        public final void a(int i11, int i12) {
            if (i11 == 1) {
                b.this.f47011o.removeMessages(1);
            }
            if (i11 == 2) {
                b bVar = b.this;
                bVar.f47003g = i12;
                bVar.f47011o.removeMessages(1);
                b.this.f47011o.sendEmptyMessageDelayed(1, 1000L);
            }
        }

        @Override // com.mbridge.msdk.splash.d.a
        public final void a(CampaignEx campaignEx) {
            b.this.a(campaignEx, false, "");
        }

        @Override // com.mbridge.msdk.splash.d.a
        public final void a(Object obj, String str) {
            b.this.b(1);
        }

        @Override // com.mbridge.msdk.splash.d.a
        public final void a(boolean z11) {
            if (z11) {
                b.this.f47011o.removeMessages(1);
            }
        }

        @Override // com.mbridge.msdk.splash.d.a
        public final void a(boolean z11, String str) {
            try {
                if (b.this.f46999c != null) {
                    if (TextUtils.isEmpty(str)) {
                        b bVar = b.this;
                        bVar.f46999c.b(bVar.f47002f);
                    } else {
                        CampaignEx campaignWithBackData = CampaignEx.parseCampaignWithBackData(CampaignEx.campaignToJsonObject(b.this.f47013q));
                        campaignWithBackData.setClickURL(str);
                        b.this.a(campaignWithBackData, true, str);
                    }
                }
            } catch (Exception e11) {
                ad.b("SplashShowManager", e11.getMessage());
            }
        }

        @Override // com.mbridge.msdk.splash.d.a
        public final void b(int i11) {
            ad.b("SplashShowManager", "resetCountdown" + i11);
            b bVar = b.this;
            bVar.f47003g = i11;
            bVar.f47011o.removeMessages(1);
            b.this.f47011o.sendEmptyMessageDelayed(1, 1000L);
        }
    }

    public b(Context context, String str, String str2) {
        this.f47004h = "点击跳过|";
        this.f47005i = "点击跳过|";
        this.f47006j = "秒";
        this.f47007k = "秒后自动关闭";
        this.f47001e = str2;
        this.f47017u = str;
        this.f47002f = new MBridgeIds(str, str2);
        this.f47009m = context;
        if (this.f47015s == null) {
            TextView textView = new TextView(context);
            this.f47015s = textView;
            textView.setGravity(1);
            this.f47015s.setTextIsSelectable(false);
            this.f47015s.setPadding(ai.a(context, 5.0f), ai.a(context, 5.0f), ai.a(context, 5.0f), ai.a(context, 5.0f));
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f47015s.getLayoutParams();
            this.f47015s.setLayoutParams(layoutParams == null ? new RelativeLayout.LayoutParams(ai.a(context, 100.0f), ai.a(context, 50.0f)) : layoutParams);
            Context contextC = com.mbridge.msdk.foundation.controller.c.m().c();
            if (contextC != null) {
                String strG = com.mbridge.msdk.foundation.controller.c.m().g();
                int identifier = contextC.getResources().getIdentifier("mbridge_splash_count_time_can_skip", "string", strG);
                int identifier2 = contextC.getResources().getIdentifier("mbridge_splash_count_time_can_skip_not", "string", strG);
                int identifier3 = contextC.getResources().getIdentifier("mbridge_splash_count_time_can_skip_s", "string", strG);
                this.f47005i = contextC.getResources().getString(identifier);
                String string = contextC.getResources().getString(identifier2);
                this.f47007k = string;
                this.f47004h = string;
                this.f47006j = contextC.getResources().getString(identifier3);
                this.f47015s.setBackgroundResource(contextC.getResources().getIdentifier("mbridge_splash_close_bg", "drawable", com.mbridge.msdk.foundation.controller.c.m().g()));
                this.f47015s.setTextColor(contextC.getResources().getColor(contextC.getResources().getIdentifier("mbridge_splash_count_time_skip_text_color", TtmlNode.ATTR_TTS_COLOR, strG)));
            }
        }
    }

    private void a(View view) {
        if (view != null) {
            view.setOnClickListener(this.f47021y);
        }
    }

    private void a(CampaignEx campaignEx, Context context, String str) {
        if (campaignEx != null) {
            try {
                List<String> pv_urls = campaignEx.getPv_urls();
                if (pv_urls == null || pv_urls.size() <= 0) {
                    return;
                }
                Iterator<String> it = pv_urls.iterator();
                while (it.hasNext()) {
                    com.mbridge.msdk.click.a.a(context, campaignEx, str, it.next(), false, true);
                }
            } catch (Throwable th2) {
                ad.b("SplashShowManager", th2.getMessage());
            }
        }
    }

    public static /* synthetic */ void a(b bVar, int i11) {
        MBSplashView mBSplashView = bVar.f46998b;
        if (mBSplashView != null) {
            mBSplashView.updateCountdown(i11);
            if (bVar.f46998b.getSplashSignalCommunicationImpl() != null) {
                bVar.f46998b.getSplashSignalCommunicationImpl().c(i11);
            }
        }
        if (i11 < 0) {
            bVar.f47003g = i11;
            return;
        }
        com.mbridge.msdk.splash.d.d dVar = bVar.f46999c;
        if (dVar != null) {
            dVar.a(bVar.f47002f, i11 * 1000);
        }
        if (bVar.f47016t == null) {
            bVar.g();
        }
    }

    private void b(CampaignEx campaignEx, Context context, String str) {
        if (campaignEx != null) {
            try {
                if (TextUtils.isEmpty(campaignEx.getOnlyImpressionURL())) {
                    return;
                }
                com.mbridge.msdk.click.a.a(context, campaignEx, str, campaignEx.getOnlyImpressionURL(), false, true, com.mbridge.msdk.click.a.a.f43073h);
            } catch (Throwable th2) {
                ad.b("SplashShowManager", th2.getMessage());
            }
        }
    }

    private void c(final CampaignEx campaignEx, final Context context, String str) {
        com.mbridge.msdk.foundation.controller.c.m().a(context);
        if (!TextUtils.isEmpty(campaignEx.getImpressionURL())) {
            new Thread(new Runnable() { // from class: com.mbridge.msdk.splash.c.b.5
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        k.a(h.a(context)).a(campaignEx.getId());
                    } catch (Exception unused) {
                        ad.b("SplashShowManager", "campain can't insert db");
                    }
                }
            }).start();
            com.mbridge.msdk.click.a.a(context, campaignEx, str, campaignEx.getImpressionURL(), false, true, com.mbridge.msdk.click.a.a.f43072g);
        }
        if (TextUtils.isEmpty(str) || campaignEx.getNativeVideoTracking() == null || campaignEx.getNativeVideoTracking().p() == null) {
            return;
        }
        com.mbridge.msdk.click.a.a(context, campaignEx, str, campaignEx.getNativeVideoTracking().p(), false, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void f() {
        MBSplashView mBSplashView;
        if (this.f47013q == null) {
            return;
        }
        this.f47018v = true;
        if (this.f46999c != null && (mBSplashView = this.f46998b) != null) {
            if (mBSplashView.getContext() != null && (this.f46998b.getContext() instanceof Activity) && ((Activity) this.f46998b.getContext()).isFinishing()) {
                this.f46999c.a(this.f47002f, "Activity is finishing");
                return;
            } else if (this.f46998b.isShown()) {
                this.f46999c.a(this.f47002f);
            } else {
                this.f46999c.a(this.f47002f, "SplashView or container is not visibility");
            }
        }
        if (!this.f47013q.isReport()) {
            MBSplashView mBSplashView2 = this.f46998b;
            if (mBSplashView2 == null || mBSplashView2.isDynamicView()) {
                CampaignEx campaignEx = this.f47013q;
                b(campaignEx, com.mbridge.msdk.foundation.controller.c.m().c(), this.f47001e);
                c(campaignEx, com.mbridge.msdk.foundation.controller.c.m().c(), this.f47001e);
                a(campaignEx, com.mbridge.msdk.foundation.controller.c.m().c(), this.f47001e);
                campaignEx.setReport(true);
                com.mbridge.msdk.foundation.same.a.d.a(this.f47001e, campaignEx, "splash");
            } else {
                CampaignEx campaignEx2 = this.f47013q;
                if (!campaignEx2.isHasMBTplMark()) {
                    c(campaignEx2, com.mbridge.msdk.foundation.controller.c.m().c(), this.f47001e);
                    campaignEx2.setReport(true);
                    com.mbridge.msdk.foundation.same.a.d.a(this.f47001e, campaignEx2, "splash");
                    b(campaignEx2, com.mbridge.msdk.foundation.controller.c.m().c(), this.f47001e);
                    a(campaignEx2, com.mbridge.msdk.foundation.controller.c.m().c(), this.f47001e);
                }
            }
            Context contextC = com.mbridge.msdk.foundation.controller.c.m().c();
            CampaignEx campaignEx3 = this.f47013q;
            String str = this.f47001e;
            if (campaignEx3 != null) {
                try {
                    if (campaignEx3.isMraid()) {
                        n nVar = new n();
                        nVar.f(campaignEx3.getRequestId());
                        nVar.g(campaignEx3.getRequestIdNotice());
                        nVar.e(campaignEx3.getId());
                        nVar.d(campaignEx3.isMraid() ? n.f44338a : n.f44339b);
                        m.d(nVar, contextC.getApplicationContext(), str);
                    }
                } catch (Exception e11) {
                    e11.printStackTrace();
                }
            }
        }
    }

    private void g() {
        String str;
        if (this.f47014r) {
            str = this.f47005i + this.f47003g + this.f47006j;
        } else {
            str = this.f47003g + this.f47007k;
        }
        this.f47015s.setText(str);
    }

    public final String a() {
        CampaignEx campaignEx = this.f47013q;
        return (campaignEx == null || campaignEx.getRequestId() == null) ? "" : this.f47013q.getRequestId();
    }

    public final void a(int i11) {
        this.f47003g = i11;
    }

    public final void a(ViewGroup viewGroup) {
        if (viewGroup != null) {
            viewGroup.setOnClickListener(this.f47021y);
        }
        this.f47016t = viewGroup;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void a(CampaignEx campaignEx, MBSplashView mBSplashView) {
        MBSplashView mBSplashView2;
        MBSplashView mBSplashView3;
        Context context;
        MBSplashWebview splashWebview;
        a(this.f47014r);
        this.f47013q = campaignEx;
        this.f46998b = mBSplashView;
        com.mbridge.msdk.splash.signal.c splashSignalCommunicationImpl = mBSplashView.getSplashSignalCommunicationImpl();
        if (splashSignalCommunicationImpl == null) {
            splashSignalCommunicationImpl = new com.mbridge.msdk.splash.signal.c(mBSplashView.getContext(), this.f47017u, this.f47001e);
            ArrayList arrayList = new ArrayList();
            arrayList.add(campaignEx);
            splashSignalCommunicationImpl.a(arrayList);
        }
        splashSignalCommunicationImpl.b(this.f47003g);
        splashSignalCommunicationImpl.a(this.f47014r ? 1 : 0);
        RelativeLayout.LayoutParams layoutParams = null;
        Object[] objArr = 0;
        if (this.f47020x == null) {
            this.f47020x = new a();
        }
        splashSignalCommunicationImpl.a(this.f47020x);
        mBSplashView.setSplashSignalCommunicationImpl(splashSignalCommunicationImpl);
        boolean zIsHasMBTplMark = campaignEx.isHasMBTplMark();
        View view = this.f47016t;
        if (view == null) {
            if (zIsHasMBTplMark) {
                this.f47015s.setVisibility(8);
            }
            g();
            a(this.f47015s);
            mBSplashView.setCloseView(this.f47015s);
        } else {
            if (zIsHasMBTplMark) {
                view.setVisibility(8);
            }
            a(this.f47016t);
            mBSplashView.setCloseView(this.f47016t);
        }
        mBSplashView.show();
        CampaignEx campaignEx2 = this.f47013q;
        if (campaignEx2 != null && campaignEx2.isActiveOm() && (splashWebview = mBSplashView.getSplashWebview()) != null) {
            try {
                kn.b bVarA = com.mbridge.msdk.a.b.a(com.mbridge.msdk.foundation.controller.c.m().c(), splashWebview, splashWebview.getUrl(), this.f47013q);
                if (bVarA != null) {
                    splashWebview.setAdSession(bVarA);
                    bVarA.d(splashWebview);
                    bVarA.g();
                }
                ad.a("OMSDK", "adSession.start()");
            } catch (Throwable th2) {
                ad.a("OMSDK", th2.getMessage());
                CampaignEx campaignEx3 = this.f47013q;
                if (campaignEx3 != null) {
                    String requestId = campaignEx3.getRequestId();
                    String requestIdNotice = this.f47013q.getRequestIdNotice();
                    String id2 = this.f47013q.getId();
                    new o(splashWebview.getContext()).a(requestId, requestIdNotice, id2, this.f47001e, "fetch OM failed, exception" + th2.getMessage());
                }
            }
        }
        d.a(this.f47001e);
        this.f47011o.removeMessages(1);
        this.f47011o.sendEmptyMessageDelayed(1, 1000L);
        this.f47011o.sendEmptyMessageDelayed(2, 1000L);
        CampaignEx campaignEx4 = this.f47013q;
        if (campaignEx4 != null && campaignEx4.getPrivacyButtonTemplateVisibility() == 1 && (mBSplashView3 = this.f46998b) != null && mBSplashView3.getSplashWebview() != null && !this.f46998b.isDynamicView() && this.f47013q.isMraid() && (context = this.f46998b.getContext()) != null) {
            try {
                int iA = v.a(context, "mbridge_splash_notice", "drawable");
                int iA2 = ai.a(context, 35.0f);
                int iA3 = ai.a(context, 9.0f);
                ImageView imageView = new ImageView(context);
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(iA2, iA2);
                layoutParams2.addRule(9);
                layoutParams2.addRule(10);
                layoutParams2.setMargins(iA3, iA3, iA3, iA3);
                imageView.setScaleType(ImageView.ScaleType.CENTER);
                imageView.setBackgroundResource(iA);
                ai.a(3, imageView, this.f47013q, context, true, new com.mbridge.msdk.foundation.d.a() { // from class: com.mbridge.msdk.splash.c.b.6
                    @Override // com.mbridge.msdk.foundation.d.a
                    public final void a() {
                        b.this.d();
                    }

                    @Override // com.mbridge.msdk.foundation.d.a
                    public final void a(String str) {
                        b.this.c();
                    }

                    @Override // com.mbridge.msdk.foundation.d.a
                    public final void b() {
                        b.this.c();
                    }
                });
                this.f46998b.addView(imageView);
            } catch (Throwable th3) {
                ad.b("SplashShowManager", th3.getMessage());
            }
        }
        if (!this.f47013q.isMraid()) {
            CampaignEx campaignEx5 = this.f47013q;
            if (campaignEx5 != null) {
                campaignEx5.setCampaignUnitId(this.f47001e);
                com.mbridge.msdk.foundation.d.b.a().a(this.f47001e, 3);
                com.mbridge.msdk.foundation.d.b.a().a(this.f47001e, this.f47013q);
            }
            if (com.mbridge.msdk.foundation.d.b.a().b() && ((mBSplashView2 = this.f46998b) == null || !mBSplashView2.isDynamicView())) {
                com.mbridge.msdk.foundation.d.b.a().a(this.f47001e, new com.mbridge.msdk.foundation.d.a() { // from class: com.mbridge.msdk.splash.c.b.3
                    @Override // com.mbridge.msdk.foundation.d.a
                    public final void a() {
                        String string;
                        b.this.d();
                        try {
                            JSONObject jSONObject = new JSONObject();
                            if (com.mbridge.msdk.foundation.controller.c.m().c() != null) {
                                jSONObject.put(NotificationCompat.CATEGORY_STATUS, 1);
                            }
                            string = jSONObject.toString();
                        } catch (Throwable th4) {
                            ad.a("SplashShowManager", th4.getMessage(), th4);
                            string = "";
                        }
                        com.mbridge.msdk.mbsignalcommon.windvane.g.a().a((WebView) b.this.f46998b.getSplashWebview(), "onFeedbackAlertStatusNotify", Base64.encodeToString(string.getBytes(), 2));
                    }

                    @Override // com.mbridge.msdk.foundation.d.a
                    public final void a(String str) {
                        String string;
                        b.this.c();
                        try {
                            JSONObject jSONObject = new JSONObject();
                            if (com.mbridge.msdk.foundation.controller.c.m().c() != null) {
                                jSONObject.put(NotificationCompat.CATEGORY_STATUS, 2);
                            }
                            string = jSONObject.toString();
                        } catch (Throwable th4) {
                            ad.a("SplashShowManager", th4.getMessage(), th4);
                            string = "";
                        }
                        com.mbridge.msdk.mbsignalcommon.windvane.g.a().a((WebView) b.this.f46998b.getSplashWebview(), "onFeedbackAlertStatusNotify", Base64.encodeToString(string.getBytes(), 2));
                    }

                    @Override // com.mbridge.msdk.foundation.d.a
                    public final void b() {
                        String string;
                        b.this.c();
                        try {
                            JSONObject jSONObject = new JSONObject();
                            if (com.mbridge.msdk.foundation.controller.c.m().c() != null) {
                                jSONObject.put(NotificationCompat.CATEGORY_STATUS, 2);
                            }
                            string = jSONObject.toString();
                        } catch (Throwable th4) {
                            ad.a("SplashShowManager", th4.getMessage(), th4);
                            string = "";
                        }
                        com.mbridge.msdk.mbsignalcommon.windvane.g.a().a((WebView) b.this.f46998b.getSplashWebview(), "onFeedbackAlertStatusNotify", Base64.encodeToString(string.getBytes(), 2));
                    }
                });
                FeedBackButton feedBackButtonB = com.mbridge.msdk.foundation.d.b.a().b(this.f47001e);
                if (feedBackButtonB != null) {
                    try {
                        layoutParams = (RelativeLayout.LayoutParams) feedBackButtonB.getLayoutParams();
                    } catch (Exception e11) {
                        e11.printStackTrace();
                    }
                    if (layoutParams == null) {
                        layoutParams = new RelativeLayout.LayoutParams(com.mbridge.msdk.foundation.d.b.f44149b, com.mbridge.msdk.foundation.d.b.f44148a);
                    }
                    layoutParams.topMargin = ai.a(com.mbridge.msdk.foundation.controller.c.m().c(), 10.0f);
                    layoutParams.leftMargin = ai.a(com.mbridge.msdk.foundation.controller.c.m().c(), 10.0f);
                    ViewGroup viewGroup = (ViewGroup) feedBackButtonB.getParent();
                    if (viewGroup != null) {
                        viewGroup.removeView(feedBackButtonB);
                    }
                    MBSplashView mBSplashView4 = this.f46998b;
                    if (mBSplashView4 != null) {
                        mBSplashView4.addView(feedBackButtonB, layoutParams);
                    }
                }
            }
        }
        com.mbridge.msdk.click.c.a(com.mbridge.msdk.foundation.controller.c.m().c(), this.f47013q.getMaitve(), this.f47013q.getMaitve_src());
        try {
            BitmapDrawable bitmapDrawableA = com.mbridge.msdk.foundation.controller.c.m().a(this.f47001e, this.f47013q.getAdType());
            if (bitmapDrawableA != null) {
                if (this.f47019w == null) {
                    this.f47019w = new ImageView(com.mbridge.msdk.foundation.controller.c.m().c());
                }
                if (this.f47019w.getVisibility() != 0) {
                    this.f47019w.setVisibility(0);
                }
                ai.a(this.f47019w, bitmapDrawableA, mBSplashView.getResources().getDisplayMetrics());
                if (this.f47019w.getParent() == null) {
                    mBSplashView.addView(this.f47019w, new ViewGroup.LayoutParams(-1, -1));
                }
            }
        } catch (Exception e12) {
            e12.printStackTrace();
        }
    }

    public void a(CampaignEx campaignEx, boolean z11, String str) {
    }

    public final void a(com.mbridge.msdk.splash.d.d dVar) {
        this.f46999c = dVar;
    }

    public final void a(boolean z11) {
        this.f47014r = z11;
        if (z11) {
            this.f47004h = this.f47005i;
        } else {
            this.f47004h = this.f47007k;
        }
    }

    public final String b() {
        ArrayList arrayList = new ArrayList();
        CampaignEx campaignEx = this.f47013q;
        if (campaignEx != null) {
            arrayList.add(campaignEx);
        }
        return com.mbridge.msdk.foundation.same.b.a(arrayList);
    }

    public final void b(int i11) {
        com.mbridge.msdk.splash.a.c cVarA;
        MBSplashWebview splashWebview;
        MBSplashView mBSplashView;
        com.mbridge.msdk.splash.d.d dVar = this.f46999c;
        if (dVar != null) {
            dVar.a(this.f47002f, i11);
            this.f46999c = null;
            com.mbridge.msdk.splash.e.a.a(this.f47001e, this.f47013q);
        }
        ImageView imageView = this.f47019w;
        if (imageView != null && imageView.getParent() != null && (mBSplashView = this.f46998b) != null) {
            mBSplashView.removeView(this.f47019w);
            this.f47019w.setVisibility(8);
        }
        this.f47018v = false;
        if (this.f47013q != null) {
            cVarA = com.mbridge.msdk.splash.a.c.a().b(this.f47001e).d(this.f47013q.getRequestId()).g(this.f47013q.getRequestIdNotice()).c(this.f47013q.getId()).e(this.f47013q.getCreativeId() + "").a(this.f47013q.isBidCampaign());
        } else {
            cVarA = null;
        }
        com.mbridge.msdk.splash.e.a.a(cVarA, this.f47001e, i11);
        MBSplashView mBSplashView2 = this.f46998b;
        if (mBSplashView2 != null && (splashWebview = mBSplashView2.getSplashWebview()) != null) {
            splashWebview.finishAdSession();
        }
        Handler handler = this.f47011o;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    public final void b(CampaignEx campaignEx, boolean z11, String str) {
        if (this.f47000d == null) {
            com.mbridge.msdk.click.a aVar = new com.mbridge.msdk.click.a(com.mbridge.msdk.foundation.controller.c.m().c(), this.f47001e);
            this.f47000d = aVar;
            aVar.a(this.f47012p);
        }
        campaignEx.setCampaignUnitId(this.f47001e);
        this.f47000d.a(campaignEx);
        if (!this.f47013q.isReportClick()) {
            this.f47013q.setReportClick(true);
            com.mbridge.msdk.splash.e.a.a(com.mbridge.msdk.foundation.controller.c.m().c(), campaignEx);
        }
        com.mbridge.msdk.splash.d.d dVar = this.f46999c;
        if (dVar != null) {
            dVar.b(this.f47002f);
            b(3);
        }
        if (!z11 || TextUtils.isEmpty(str)) {
            return;
        }
        String str2 = this.f47001e;
        try {
            if (TextUtils.isEmpty(str) || !campaignEx.isMraid()) {
                return;
            }
            new o(com.mbridge.msdk.foundation.controller.c.m().c()).a(campaignEx.getRequestId(), campaignEx.getRequestIdNotice(), campaignEx.getId(), str2, str, campaignEx.isBidCampaign());
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public final void c() {
        MBSplashView mBSplashView;
        Handler handler;
        this.f47010n = true;
        if (this.f46998b != null && this.f47003g > 0 && (handler = this.f47011o) != null) {
            handler.removeMessages(1);
            this.f47011o.sendEmptyMessageDelayed(1, 1000L);
        }
        if (com.mbridge.msdk.foundation.d.b.f44150c || (mBSplashView = this.f46998b) == null) {
            return;
        }
        mBSplashView.onResume();
        MBSplashWebview splashWebview = this.f46998b.getSplashWebview();
        if (splashWebview == null || splashWebview.isDestoryed()) {
            return;
        }
        com.mbridge.msdk.splash.signal.d.a(splashWebview, "onSystemPause", "");
    }

    public final void d() {
        Handler handler;
        this.f47010n = false;
        if (this.f46998b != null && this.f47003g > 0 && (handler = this.f47011o) != null) {
            handler.removeMessages(1);
        }
        MBSplashView mBSplashView = this.f46998b;
        if (mBSplashView != null) {
            mBSplashView.onPause();
            MBSplashWebview splashWebview = this.f46998b.getSplashWebview();
            if (splashWebview == null || splashWebview.isDestoryed()) {
                return;
            }
            com.mbridge.msdk.splash.signal.d.a(splashWebview, "onSystemPause", "");
        }
    }

    public final void e() {
        if (this.f46999c != null) {
            this.f46999c = null;
        }
        if (this.f47020x != null) {
            this.f47020x = null;
        }
        if (this.f47021y != null) {
            this.f47021y = null;
        }
        MBSplashView mBSplashView = this.f46998b;
        if (mBSplashView != null) {
            mBSplashView.destroy();
        }
        com.mbridge.msdk.foundation.d.b.a().c(this.f47001e);
    }
}
