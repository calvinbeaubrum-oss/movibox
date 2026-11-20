package com.mbridge.msdk.advanced.a;

import android.content.Context;
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
import androidx.core.app.NotificationCompat;
import com.mbridge.msdk.advanced.view.MBNativeAdvancedView;
import com.mbridge.msdk.advanced.view.MBNativeAdvancedWebview;
import com.mbridge.msdk.foundation.db.h;
import com.mbridge.msdk.foundation.db.k;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.n;
import com.mbridge.msdk.foundation.same.report.j;
import com.mbridge.msdk.foundation.same.report.m;
import com.mbridge.msdk.foundation.same.report.o;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.foundation.tools.ai;
import com.mbridge.msdk.foundation.tools.aq;
import com.mbridge.msdk.foundation.tools.z;
import com.mbridge.msdk.mbsignalcommon.windvane.g;
import com.mbridge.msdk.out.MBridgeIds;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected CampaignEx f42645a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected MBNativeAdvancedView f42646b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected com.mbridge.msdk.advanced.b.d f42647c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected com.mbridge.msdk.click.a f42648d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected String f42649e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected MBridgeIds f42650f;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private com.mbridge.msdk.advanced.b.c f42653i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f42654j;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private ImageView f42656l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private String f42657m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f42658n;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f42652h = "NativeAdvancedShowManager";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f42655k = -1;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private View.OnClickListener f42659o = new View.OnClickListener() { // from class: com.mbridge.msdk.advanced.a.a.1
        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (a.this.f42654j) {
                a.a(a.this, 1);
            }
        }
    };

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Handler f42651g = new Handler(Looper.getMainLooper()) { // from class: com.mbridge.msdk.advanced.a.a.2
        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            CampaignEx campaignEx;
            MBNativeAdvancedView mBNativeAdvancedView;
            MBNativeAdvancedWebview advancedNativeWebview;
            super.handleMessage(message);
            if (message.what != 2 || (campaignEx = a.this.f42645a) == null || !campaignEx.isActiveOm() || (mBNativeAdvancedView = a.this.f42646b) == null || (advancedNativeWebview = mBNativeAdvancedView.getAdvancedNativeWebview()) == null) {
                return;
            }
            try {
                kn.b adSession = advancedNativeWebview.getAdSession();
                if (adSession != null) {
                    kn.a.a(adSession).b();
                    ad.a("OMSDK", "adSession.impressionOccurred()");
                }
            } catch (Throwable th2) {
                ad.a("OMSDK", th2.getMessage());
                CampaignEx campaignEx2 = a.this.f42645a;
                if (campaignEx2 != null) {
                    String requestId = campaignEx2.getRequestId();
                    String requestIdNotice = a.this.f42645a.getRequestIdNotice();
                    String id2 = a.this.f42645a.getId();
                    new o(advancedNativeWebview.getContext()).a(requestId, requestIdNotice, id2, a.this.f42649e, "fetch OM failed, exception" + th2.getMessage());
                }
            }
        }
    };

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private com.mbridge.msdk.advanced.b.a f42660p = new com.mbridge.msdk.advanced.b.a() { // from class: com.mbridge.msdk.advanced.a.a.3
        @Override // com.mbridge.msdk.advanced.b.a
        public final void a() {
            a.a(a.this, 1);
        }

        @Override // com.mbridge.msdk.advanced.b.a
        public final void a(int i11) {
            a.this.f42655k = i11;
            MBNativeAdvancedView mBNativeAdvancedView = a.this.f42646b;
            if (mBNativeAdvancedView != null) {
                mBNativeAdvancedView.changeCloseBtnState(i11);
            }
        }

        @Override // com.mbridge.msdk.advanced.b.a
        public final void a(CampaignEx campaignEx) {
            a.this.a(campaignEx, false, "");
        }

        @Override // com.mbridge.msdk.advanced.b.a
        public final void a(Object obj, String str) {
            MBNativeAdvancedView mBNativeAdvancedView = a.this.f42646b;
            if (mBNativeAdvancedView != null) {
                mBNativeAdvancedView.setVisibility(8);
            }
            a.a(a.this, 1);
        }

        @Override // com.mbridge.msdk.advanced.b.a
        public final void a(boolean z11) {
            a aVar = a.this;
            if (aVar.f42647c != null) {
                aVar.f42658n = z11;
                if (z11) {
                    a aVar2 = a.this;
                    aVar2.f42647c.e(aVar2.f42650f);
                } else {
                    a aVar3 = a.this;
                    aVar3.f42647c.f(aVar3.f42650f);
                }
            }
        }

        @Override // com.mbridge.msdk.advanced.b.a
        public final void a(boolean z11, String str) {
            try {
                if (a.this.f42647c != null) {
                    if (TextUtils.isEmpty(str)) {
                        a aVar = a.this;
                        aVar.f42647c.b(aVar.f42650f);
                        a aVar2 = a.this;
                        aVar2.f42647c.d(aVar2.f42650f);
                    } else {
                        CampaignEx campaignWithBackData = CampaignEx.parseCampaignWithBackData(CampaignEx.campaignToJsonObject(a.this.f42645a));
                        campaignWithBackData.setClickURL(str);
                        a.this.a(campaignWithBackData, z11, str);
                    }
                }
            } catch (Exception e11) {
                ad.b(a.this.f42652h, e11.getMessage());
            }
        }

        @Override // com.mbridge.msdk.advanced.b.a
        public final void b(int i11) {
            ad.b(a.this.f42652h, "resetCountdown" + i11);
        }
    };

    public a(Context context, String str, String str2) {
        this.f42649e = str2;
        this.f42657m = str;
        this.f42650f = new MBridgeIds(str, str2);
        if (this.f42656l == null) {
            ImageView imageView = new ImageView(context);
            this.f42656l = imageView;
            imageView.setPadding(ai.a(context, 2.0f), ai.a(context, 2.0f), ai.a(context, 2.0f), ai.a(context, 2.0f));
            Context contextC = com.mbridge.msdk.foundation.controller.c.m().c();
            this.f42656l.setScaleType(ImageView.ScaleType.FIT_XY);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f42656l.getLayoutParams();
            this.f42656l.setLayoutParams(layoutParams == null ? new RelativeLayout.LayoutParams(ai.a(contextC, 29.0f), ai.a(contextC, 16.0f)) : layoutParams);
            this.f42656l.setImageResource(contextC.getResources().getIdentifier("mbridge_native_advanced_close_icon", "drawable", com.mbridge.msdk.foundation.controller.c.m().g()));
        }
    }

    public static /* synthetic */ void a(a aVar, int i11) {
        com.mbridge.msdk.advanced.common.d dVarA;
        com.mbridge.msdk.advanced.b.d dVar = aVar.f42647c;
        if (dVar != null) {
            dVar.c(aVar.f42650f);
            aVar.f42647c = null;
            String str = aVar.f42649e;
            CampaignEx campaignEx = aVar.f42645a;
            if (campaignEx != null && campaignEx.isMraid()) {
                n nVar = new n("2000061", campaignEx.getId(), campaignEx.getRequestId(), campaignEx.getRequestIdNotice(), str, z.l(com.mbridge.msdk.foundation.controller.c.m().c()));
                nVar.d(n.f44338a);
                m.b(nVar, com.mbridge.msdk.foundation.controller.c.m().c(), str);
            }
        }
        if (aVar.f42645a != null) {
            dVarA = com.mbridge.msdk.advanced.common.d.a().b(aVar.f42649e).d(aVar.f42645a.getRequestId()).g(aVar.f42645a.getRequestIdNotice()).c(aVar.f42645a.getId()).e(aVar.f42645a.getCreativeId() + "").a(aVar.f42645a.isBidCampaign());
        } else {
            dVarA = null;
        }
        String str2 = aVar.f42649e;
        if (dVarA != null) {
            dVarA.a("2000069");
            dVarA.a(i11);
            if (j.a().b()) {
                j.a().a(dVarA.b());
            } else {
                m.a(dVarA.b(), com.mbridge.msdk.foundation.controller.c.m().c(), str2);
            }
        }
        MBNativeAdvancedView mBNativeAdvancedView = aVar.f42646b;
        if (mBNativeAdvancedView != null) {
            mBNativeAdvancedView.setVisibility(8);
            aVar.f();
            MBNativeAdvancedWebview advancedNativeWebview = aVar.f42646b.getAdvancedNativeWebview();
            if (advancedNativeWebview != null) {
                advancedNativeWebview.finishAdSession();
            }
        }
        Handler handler = aVar.f42651g;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
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
                ad.b(this.f42652h, th2.getMessage());
            }
        }
    }

    public final String a() {
        CampaignEx campaignEx = this.f42645a;
        return (campaignEx == null || campaignEx.getRequestId() == null) ? "" : this.f42645a.getRequestId();
    }

    public final void a(com.mbridge.msdk.advanced.b.c cVar) {
        this.f42653i = cVar;
    }

    public final void a(com.mbridge.msdk.advanced.b.d dVar) {
        this.f42647c = dVar;
    }

    public final void a(final CampaignEx campaignEx, final MBNativeAdvancedView mBNativeAdvancedView, boolean z11) {
        MBNativeAdvancedWebview advancedNativeWebview;
        View viewB;
        RelativeLayout.LayoutParams layoutParams;
        if (mBNativeAdvancedView == null) {
            return;
        }
        com.mbridge.msdk.foundation.d.b.a().a(this.f42649e, new com.mbridge.msdk.foundation.d.a() { // from class: com.mbridge.msdk.advanced.a.a.4
            @Override // com.mbridge.msdk.foundation.d.a
            public final void a() {
                String string;
                a.this.f();
                try {
                    JSONObject jSONObject = new JSONObject();
                    if (com.mbridge.msdk.foundation.controller.c.m().c() != null) {
                        jSONObject.put(NotificationCompat.CATEGORY_STATUS, 1);
                    }
                    string = jSONObject.toString();
                } catch (Throwable th2) {
                    ad.a(a.this.f42652h, th2.getMessage(), th2);
                    string = "";
                }
                g.a().a((WebView) mBNativeAdvancedView.getAdvancedNativeWebview(), "onFeedbackAlertStatusNotify", Base64.encodeToString(string.getBytes(), 2));
            }

            @Override // com.mbridge.msdk.foundation.d.a
            public final void a(String str) {
                String string;
                a.this.e();
                try {
                    JSONObject jSONObject = new JSONObject();
                    if (com.mbridge.msdk.foundation.controller.c.m().c() != null) {
                        jSONObject.put(NotificationCompat.CATEGORY_STATUS, 2);
                    }
                    string = jSONObject.toString();
                } catch (Throwable th2) {
                    ad.a(a.this.f42652h, th2.getMessage(), th2);
                    string = "";
                }
                g.a().a((WebView) mBNativeAdvancedView.getAdvancedNativeWebview(), "onFeedbackAlertStatusNotify", Base64.encodeToString(string.getBytes(), 2));
            }

            @Override // com.mbridge.msdk.foundation.d.a
            public final void b() {
                String string;
                a.this.e();
                try {
                    JSONObject jSONObject = new JSONObject();
                    if (com.mbridge.msdk.foundation.controller.c.m().c() != null) {
                        jSONObject.put(NotificationCompat.CATEGORY_STATUS, 2);
                    }
                    string = jSONObject.toString();
                } catch (Throwable th2) {
                    ad.a(a.this.f42652h, th2.getMessage(), th2);
                    string = "";
                }
                g.a().a((WebView) mBNativeAdvancedView.getAdvancedNativeWebview(), "onFeedbackAlertStatusNotify", Base64.encodeToString(string.getBytes(), 2));
            }
        });
        if (campaignEx.isMraid() && com.mbridge.msdk.foundation.d.b.a().b() && (viewB = com.mbridge.msdk.foundation.d.b.a().b(this.f42649e)) != null) {
            try {
                layoutParams = (RelativeLayout.LayoutParams) viewB.getLayoutParams();
            } catch (Exception e11) {
                e11.printStackTrace();
                layoutParams = null;
            }
            if (layoutParams == null) {
                layoutParams = new RelativeLayout.LayoutParams(com.mbridge.msdk.foundation.d.b.f44149b, com.mbridge.msdk.foundation.d.b.f44148a);
            }
            layoutParams.addRule(12);
            ViewGroup viewGroup = (ViewGroup) viewB.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(viewB);
            }
            mBNativeAdvancedView.addView(viewB, layoutParams);
        }
        this.f42654j = this.f42654j;
        this.f42645a = campaignEx;
        this.f42646b = mBNativeAdvancedView;
        com.mbridge.msdk.advanced.signal.b advancedNativeSignalCommunicationImpl = mBNativeAdvancedView.getAdvancedNativeSignalCommunicationImpl();
        if (advancedNativeSignalCommunicationImpl == null) {
            advancedNativeSignalCommunicationImpl = new com.mbridge.msdk.advanced.signal.b(mBNativeAdvancedView.getContext(), this.f42657m, this.f42649e);
            List<CampaignEx> arrayList = new ArrayList<>();
            arrayList.add(campaignEx);
            advancedNativeSignalCommunicationImpl.a(arrayList);
        }
        advancedNativeSignalCommunicationImpl.a(this.f42654j ? 1 : 0);
        advancedNativeSignalCommunicationImpl.a(this.f42660p);
        mBNativeAdvancedView.setAdvancedNativeSignalCommunicationImpl(advancedNativeSignalCommunicationImpl);
        if (campaignEx.isHasMBTplMark() || !this.f42654j) {
            this.f42656l.setVisibility(8);
        }
        ImageView imageView = this.f42656l;
        if (imageView != null) {
            imageView.setOnClickListener(this.f42659o);
        }
        mBNativeAdvancedView.setCloseView(this.f42656l);
        if (mBNativeAdvancedView.getVisibility() != 0) {
            mBNativeAdvancedView.setVisibility(0);
        }
        boolean zA = aq.a(mBNativeAdvancedView.getAdvancedNativeWebview(), 0);
        com.mbridge.msdk.advanced.b.c cVar = this.f42653i;
        if (cVar == null || zA || cVar.b() == null || this.f42653i.b().getAlpha() < 0.5f || this.f42653i.b().getVisibility() != 0 || this.f42658n) {
            if (z11) {
                mBNativeAdvancedView.postDelayed(new Runnable() { // from class: com.mbridge.msdk.advanced.a.a.5
                    @Override // java.lang.Runnable
                    public final void run() {
                        a.this.a(campaignEx, mBNativeAdvancedView, false);
                    }
                }, 200L);
                return;
            }
            return;
        }
        mBNativeAdvancedView.show();
        com.mbridge.msdk.foundation.controller.c.m().a(mBNativeAdvancedView.getContext());
        campaignEx.setCampaignUnitId(this.f42649e);
        com.mbridge.msdk.foundation.d.b.a().a(this.f42649e, campaignEx);
        CampaignEx campaignEx2 = this.f42645a;
        if (campaignEx2 != null && campaignEx2.isActiveOm() && (advancedNativeWebview = mBNativeAdvancedView.getAdvancedNativeWebview()) != null) {
            try {
                kn.b bVarA = com.mbridge.msdk.a.b.a(com.mbridge.msdk.foundation.controller.c.m().c(), advancedNativeWebview, advancedNativeWebview.getUrl(), this.f42645a);
                if (bVarA != null) {
                    advancedNativeWebview.setAdSession(bVarA);
                    bVarA.d(advancedNativeWebview);
                    bVarA.g();
                    ad.a("OMSDK", "adSession.start()");
                }
            } catch (Throwable th2) {
                ad.a("OMSDK", th2.getMessage());
                CampaignEx campaignEx3 = this.f42645a;
                if (campaignEx3 != null) {
                    String requestId = campaignEx3.getRequestId();
                    String requestIdNotice = this.f42645a.getRequestIdNotice();
                    String id2 = this.f42645a.getId();
                    new o(com.mbridge.msdk.foundation.controller.c.m().c()).a(requestId, requestIdNotice, id2, this.f42649e, "fetch OM failed, exception" + th2.getMessage());
                }
            }
        }
        if (!this.f42645a.isReport()) {
            final CampaignEx campaignEx4 = this.f42645a;
            if (!campaignEx4.isHasMBTplMark()) {
                final Context contextC = com.mbridge.msdk.foundation.controller.c.m().c();
                String str = this.f42649e;
                com.mbridge.msdk.foundation.controller.c.m().a(contextC);
                if (!TextUtils.isEmpty(campaignEx4.getImpressionURL())) {
                    new Thread(new Runnable() { // from class: com.mbridge.msdk.advanced.a.a.6
                        @Override // java.lang.Runnable
                        public final void run() {
                            try {
                                k.a(h.a(contextC)).a(campaignEx4.getId());
                            } catch (Exception unused) {
                                ad.b(a.this.f42652h, "campain can't insert db");
                            }
                        }
                    }).start();
                    com.mbridge.msdk.click.a.a(contextC, campaignEx4, str, campaignEx4.getImpressionURL(), false, true, com.mbridge.msdk.click.a.a.f43072g);
                }
                if (!TextUtils.isEmpty(str) && campaignEx4.getNativeVideoTracking() != null && campaignEx4.getNativeVideoTracking().p() != null) {
                    com.mbridge.msdk.click.a.a(contextC, campaignEx4, str, campaignEx4.getNativeVideoTracking().p(), false, false);
                }
                campaignEx4.setReport(true);
                com.mbridge.msdk.foundation.same.a.d.a(this.f42649e, campaignEx4, "h5_native");
                Context contextC2 = com.mbridge.msdk.foundation.controller.c.m().c();
                String str2 = this.f42649e;
                try {
                    if (!TextUtils.isEmpty(campaignEx4.getOnlyImpressionURL())) {
                        com.mbridge.msdk.click.a.a(contextC2, campaignEx4, str2, campaignEx4.getOnlyImpressionURL(), false, true, com.mbridge.msdk.click.a.a.f43073h);
                    }
                } catch (Throwable th3) {
                    ad.b(this.f42652h, th3.getMessage());
                }
                a(campaignEx4, com.mbridge.msdk.foundation.controller.c.m().c(), this.f42649e);
            }
            Context contextC3 = com.mbridge.msdk.foundation.controller.c.m().c();
            CampaignEx campaignEx5 = this.f42645a;
            String str3 = this.f42649e;
            if (campaignEx5 != null) {
                try {
                    if (campaignEx5.isMraid()) {
                        n nVar = new n();
                        nVar.f(campaignEx5.getRequestId());
                        nVar.g(campaignEx5.getRequestIdNotice());
                        nVar.e(campaignEx5.getId());
                        nVar.d(campaignEx5.isMraid() ? n.f44338a : n.f44339b);
                        m.d(nVar, contextC3.getApplicationContext(), str3);
                    }
                } catch (Exception e12) {
                    ad.b("NativeAdvancedReport", e12.getMessage());
                }
            }
            com.mbridge.msdk.advanced.b.d dVar = this.f42647c;
            if (dVar != null) {
                dVar.a(this.f42650f);
            }
        }
        int i11 = this.f42655k;
        if (i11 != -1) {
            mBNativeAdvancedView.changeCloseBtnState(i11);
        }
        d.a(this.f42649e);
        com.mbridge.msdk.advanced.common.c.b(this.f42657m + this.f42649e + campaignEx.getRequestId());
        this.f42651g.sendEmptyMessageDelayed(2, 1000L);
        com.mbridge.msdk.click.c.a(com.mbridge.msdk.foundation.controller.c.m().c(), this.f42645a.getMaitve(), this.f42645a.getMaitve_src());
    }

    public void a(CampaignEx campaignEx, boolean z11, String str) {
    }

    public final void a(boolean z11) {
        this.f42654j = z11;
    }

    public final String b() {
        ArrayList arrayList = new ArrayList();
        CampaignEx campaignEx = this.f42645a;
        if (campaignEx != null) {
            arrayList.add(campaignEx);
        }
        return com.mbridge.msdk.foundation.same.b.a(arrayList);
    }

    public final com.mbridge.msdk.advanced.b.a c() {
        return this.f42660p;
    }

    public final void d() {
        if (this.f42647c != null) {
            this.f42647c = null;
        }
        if (this.f42660p != null) {
            this.f42660p = null;
        }
        if (this.f42659o != null) {
            this.f42659o = null;
        }
        MBNativeAdvancedView mBNativeAdvancedView = this.f42646b;
        if (mBNativeAdvancedView != null) {
            mBNativeAdvancedView.destroy();
        }
        if (this.f42653i != null) {
            this.f42653i = null;
        }
        com.mbridge.msdk.foundation.d.b.a().c(this.f42649e);
    }

    public final void e() {
        MBNativeAdvancedWebview advancedNativeWebview;
        if (this.f42646b == null || com.mbridge.msdk.foundation.d.b.f44150c || (advancedNativeWebview = this.f42646b.getAdvancedNativeWebview()) == null || advancedNativeWebview.isDestoryed()) {
            return;
        }
        com.mbridge.msdk.advanced.signal.a.a(advancedNativeWebview, "onViewAppeared", "");
    }

    public final void f() {
        MBNativeAdvancedWebview advancedNativeWebview;
        MBNativeAdvancedView mBNativeAdvancedView = this.f42646b;
        if (mBNativeAdvancedView == null || (advancedNativeWebview = mBNativeAdvancedView.getAdvancedNativeWebview()) == null || advancedNativeWebview.isDestoryed()) {
            return;
        }
        g.a().a((WebView) advancedNativeWebview, "onViewDisappeared", "");
    }
}
