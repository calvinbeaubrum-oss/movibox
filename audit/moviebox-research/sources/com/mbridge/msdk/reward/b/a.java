package com.mbridge.msdk.reward.b;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.google.android.gms.auth.api.proxy.AuthApiStatusCodes;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.db.f;
import com.mbridge.msdk.foundation.db.h;
import com.mbridge.msdk.foundation.db.i;
import com.mbridge.msdk.foundation.db.j;
import com.mbridge.msdk.foundation.download.download.H5DownLoadManager;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ai;
import com.mbridge.msdk.foundation.tools.al;
import com.mbridge.msdk.foundation.tools.an;
import com.mbridge.msdk.foundation.tools.e;
import com.mbridge.msdk.out.MBridgeIds;
import com.mbridge.msdk.out.RewardInfo;
import com.mbridge.msdk.videocommon.listener.InterVideoOutListener;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f46783b = "";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static String f46784d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static String f46785e = "";
    private int A;
    private int B;
    private int C;
    private boolean H;
    private Queue<Integer> P;
    private String Q;
    private CopyOnWriteArrayList<CampaignEx> Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    b f46787a;

    /* JADX INFO: renamed from: aa, reason: collision with root package name */
    private List<CampaignEx> f46788aa;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private Context f46795l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private com.mbridge.msdk.reward.adapter.c f46796m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private com.mbridge.msdk.videocommon.d.c f46797n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private com.mbridge.msdk.videocommon.d.a f46798o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private volatile InterVideoOutListener f46799p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private volatile c f46800q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private String f46801r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private String f46802s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private MBridgeIds f46803t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private String f46804u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private volatile String f46805v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private String f46806w;
    private static ConcurrentHashMap<String, Integer> N = new ConcurrentHashMap<>();
    private static ConcurrentHashMap<String, String> O = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static ConcurrentHashMap<String, d> f46786f = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private int f46807x = 0;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private int f46809z = 2;
    private boolean D = false;
    private boolean E = false;
    private boolean F = false;
    private boolean G = false;
    private boolean I = false;
    private ArrayList<Integer> J = new ArrayList<>(7);
    private boolean K = false;
    private final Object L = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f46789c = false;
    private List<CampaignEx> M = new ArrayList();
    private h R = null;
    private volatile boolean S = true;
    private volatile boolean T = false;
    private volatile boolean U = false;
    private volatile boolean V = false;
    private volatile boolean W = false;
    private volatile boolean X = false;
    private volatile boolean Y = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    volatile boolean f46790g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    volatile boolean f46791h = false;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    volatile boolean f46792i = false;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    volatile boolean f46793j = false;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    volatile boolean f46794k = false;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private Handler f46808y = new com.mbridge.msdk.reward.b.b(this);

    /* JADX INFO: renamed from: com.mbridge.msdk.reward.b.a$2, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    public class AnonymousClass2 implements com.mbridge.msdk.reward.adapter.b.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        com.mbridge.msdk.foundation.same.report.d.b f46811a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ CampaignEx f46812b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f46813c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.mbridge.msdk.reward.adapter.c f46814d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f46815e;

        public AnonymousClass2(CampaignEx campaignEx, boolean z11, com.mbridge.msdk.reward.adapter.c cVar, int i11) {
            this.f46812b = campaignEx;
            this.f46813c = z11;
            this.f46814d = cVar;
            this.f46815e = i11;
            this.f46811a = com.mbridge.msdk.foundation.same.report.d.c.a().b().get(campaignEx.getLocalRequestId());
        }

        @Override // com.mbridge.msdk.reward.adapter.b.c
        public final void a(final String str, final String str2, final String str3, final CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList) {
            a.this.f46790g = true;
            if (this.f46813c) {
                if (!a.this.f46791h || a.this.f46792i || a.this.f46808y == null) {
                    return;
                }
                a.this.f46792i = true;
                a.this.f46808y.post(new Runnable() { // from class: com.mbridge.msdk.reward.b.a.2.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        com.mbridge.msdk.reward.adapter.b.a().a(a.this.I, a.this.f46808y, a.this.D, a.this.E, str3, AnonymousClass2.this.f46812b.getRequestIdNotice(), str, str2, AnonymousClass2.this.f46812b.getCMPTEntryUrl(), a.this.f46809z, AnonymousClass2.this.f46812b, copyOnWriteArrayList, H5DownLoadManager.getInstance().getH5ResAddress(AnonymousClass2.this.f46812b.getCMPTEntryUrl()), str2, a.this.f46797n, new com.mbridge.msdk.reward.adapter.b.j() { // from class: com.mbridge.msdk.reward.b.a.2.2.1
                            @Override // com.mbridge.msdk.reward.adapter.b.j
                            public final void a(String str4, String str5, String str6, com.mbridge.msdk.videocommon.a.C0532a c0532a, com.mbridge.msdk.foundation.c.b bVar) {
                                RunnableC05162 runnableC05162 = RunnableC05162.this;
                                a aVar = a.this;
                                a.a(aVar, str2, aVar.f46788aa);
                                if (a.this.f46800q == null || a.this.f46793j) {
                                    return;
                                }
                                a.this.f46793j = true;
                                if (bVar != null) {
                                    bVar.a("errorCode: 3302 errorMessage: tpl preload failed");
                                }
                                AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                                if (anonymousClass2.f46811a == null) {
                                    anonymousClass2.f46811a = new com.mbridge.msdk.foundation.same.report.d.b();
                                }
                                RunnableC05162 runnableC05163 = RunnableC05162.this;
                                AnonymousClass2.this.f46811a.b(copyOnWriteArrayList);
                                AnonymousClass2.this.f46811a.a(bVar);
                                c.a(a.this.f46800q, bVar, AnonymousClass2.this.f46811a);
                            }

                            @Override // com.mbridge.msdk.reward.adapter.b.j
                            public final void a(String str4, String str5, String str6, String str7, String str8, com.mbridge.msdk.videocommon.a.C0532a c0532a) {
                                RunnableC05162 runnableC05162 = RunnableC05162.this;
                                AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                                com.mbridge.msdk.reward.adapter.c cVar = anonymousClass2.f46814d;
                                if (cVar != null && cVar.a(copyOnWriteArrayList, anonymousClass2.f46813c, anonymousClass2.f46815e)) {
                                    if (a.this.f46800q == null || a.this.f46794k) {
                                        return;
                                    }
                                    a.this.f46794k = true;
                                    ad.a("RewardVideoController", "Cache onVideoLoadSuccessForCache");
                                    RunnableC05162 runnableC05163 = RunnableC05162.this;
                                    a.this.a(copyOnWriteArrayList);
                                    RunnableC05162 runnableC05164 = RunnableC05162.this;
                                    com.mbridge.msdk.foundation.same.report.d.b bVar = AnonymousClass2.this.f46811a;
                                    if (bVar != null) {
                                        bVar.b(copyOnWriteArrayList);
                                    }
                                    a.this.f46800q.b(str5, str6, AnonymousClass2.this.f46811a);
                                    return;
                                }
                                a aVar = a.this;
                                a.a(aVar, str6, aVar.f46788aa);
                                if (a.this.f46800q == null || a.this.f46793j) {
                                    return;
                                }
                                a.this.f46793j = true;
                                com.mbridge.msdk.foundation.c.b bVarB = com.mbridge.msdk.foundation.c.a.b(880015, "errorCode: 3504 errorMessage: tpl temp preload success but isReady false");
                                AnonymousClass2 anonymousClass3 = AnonymousClass2.this;
                                if (anonymousClass3.f46811a == null) {
                                    anonymousClass3.f46811a = new com.mbridge.msdk.foundation.same.report.d.b();
                                }
                                AnonymousClass2.this.f46811a.a(bVarB);
                                RunnableC05162 runnableC05165 = RunnableC05162.this;
                                AnonymousClass2.this.f46811a.b(copyOnWriteArrayList);
                                c.a(a.this.f46800q, bVarB, AnonymousClass2.this.f46811a);
                            }
                        }, true);
                    }
                });
                return;
            }
            for (final CampaignEx campaignEx : copyOnWriteArrayList) {
                if (campaignEx == null || campaignEx.getRewardTemplateMode() == null || TextUtils.isEmpty(campaignEx.getRewardTemplateMode().e()) || campaignEx.getRewardTemplateMode().e().contains(CampaignEx.KEY_IS_CMPT_ENTRY) || a.this.f46808y == null) {
                    com.mbridge.msdk.reward.adapter.c cVar = this.f46814d;
                    if (cVar == null || !cVar.a(copyOnWriteArrayList, this.f46813c, this.f46815e)) {
                        a aVar = a.this;
                        a.a(aVar, str2, aVar.f46788aa);
                        if (a.this.f46800q != null && !a.this.f46793j) {
                            a.this.f46793j = true;
                            com.mbridge.msdk.foundation.c.b bVarB = com.mbridge.msdk.foundation.c.a.b(880015, "errorCode: 3503 errorMessage: have no temp but isReady false");
                            if (this.f46811a == null) {
                                this.f46811a = new com.mbridge.msdk.foundation.same.report.d.b();
                            }
                            this.f46811a.b(a.this.Z);
                            this.f46811a.a(bVarB);
                            c.a(a.this.f46800q, bVarB, this.f46811a);
                        }
                    } else if (a.this.f46800q != null && !a.this.f46794k) {
                        a.this.f46794k = true;
                        ad.a("RewardVideoController", "Cache onVideoLoadSuccessForCache");
                        a.this.a(copyOnWriteArrayList);
                        com.mbridge.msdk.foundation.same.report.d.b bVar = this.f46811a;
                        if (bVar != null) {
                            bVar.b(copyOnWriteArrayList);
                        }
                        a.this.f46800q.b(str, str2, this.f46811a);
                    }
                } else {
                    a.this.f46808y.post(new Runnable() { // from class: com.mbridge.msdk.reward.b.a.2.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            com.mbridge.msdk.reward.adapter.b.a().a(a.this.I, a.this.f46808y, a.this.D, a.this.E, null, campaignEx.getRewardTemplateMode().e(), a.this.f46809z, AnonymousClass2.this.f46812b, copyOnWriteArrayList, H5DownLoadManager.getInstance().getH5ResAddress(campaignEx.getRewardTemplateMode().e()), str, str2, str3, campaignEx.getRequestIdNotice(), a.this.f46797n, new com.mbridge.msdk.reward.adapter.b.j() { // from class: com.mbridge.msdk.reward.b.a.2.1.1
                                @Override // com.mbridge.msdk.reward.adapter.b.j
                                public final void a(String str4, String str5, String str6, com.mbridge.msdk.videocommon.a.C0532a c0532a, com.mbridge.msdk.foundation.c.b bVar2) {
                                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                    a aVar2 = a.this;
                                    a.a(aVar2, str2, aVar2.f46788aa);
                                    if (a.this.f46800q == null || a.this.f46793j) {
                                        return;
                                    }
                                    a.this.f46793j = true;
                                    bVar2.a("errorCode: 3301 errorMessage: temp preload failed");
                                    AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                                    if (anonymousClass2.f46811a == null) {
                                        anonymousClass2.f46811a = new com.mbridge.msdk.foundation.same.report.d.b();
                                    }
                                    AnonymousClass2 anonymousClass3 = AnonymousClass2.this;
                                    anonymousClass3.f46811a.b(a.this.Z);
                                    AnonymousClass2.this.f46811a.a(bVar2);
                                    c.a(a.this.f46800q, bVar2, AnonymousClass2.this.f46811a);
                                }

                                @Override // com.mbridge.msdk.reward.adapter.b.j
                                public final void a(String str4, String str5, String str6, String str7, String str8, com.mbridge.msdk.videocommon.a.C0532a c0532a) {
                                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                    AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                                    com.mbridge.msdk.reward.adapter.c cVar2 = anonymousClass2.f46814d;
                                    if (cVar2 != null && cVar2.a(copyOnWriteArrayList, anonymousClass2.f46813c, anonymousClass2.f46815e)) {
                                        if (a.this.f46800q == null || a.this.f46794k) {
                                            return;
                                        }
                                        a.this.f46794k = true;
                                        AnonymousClass1 anonymousClass3 = AnonymousClass1.this;
                                        a.this.a(copyOnWriteArrayList);
                                        a.this.f46800q.b(str5, str6, AnonymousClass2.this.f46811a);
                                        return;
                                    }
                                    a aVar2 = a.this;
                                    a.a(aVar2, str6, aVar2.f46788aa);
                                    if (a.this.f46800q == null || a.this.f46793j) {
                                        return;
                                    }
                                    a.this.f46793j = true;
                                    com.mbridge.msdk.foundation.c.b bVarB2 = com.mbridge.msdk.foundation.c.a.b(880015, "errorCode: 3502 errorMessage: temp preload success but isReady false");
                                    AnonymousClass2 anonymousClass4 = AnonymousClass2.this;
                                    if (anonymousClass4.f46811a == null) {
                                        anonymousClass4.f46811a = new com.mbridge.msdk.foundation.same.report.d.b();
                                    }
                                    AnonymousClass1 anonymousClass5 = AnonymousClass1.this;
                                    AnonymousClass2.this.f46811a.b(copyOnWriteArrayList);
                                    AnonymousClass2.this.f46811a.a(bVarB2);
                                    c.a(a.this.f46800q, bVarB2, AnonymousClass2.this.f46811a);
                                }
                            });
                        }
                    });
                }
            }
        }

        @Override // com.mbridge.msdk.reward.adapter.b.c
        public final void a(CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList, com.mbridge.msdk.foundation.c.b bVar) {
            a.this.f46790g = false;
            a aVar = a.this;
            a.a(aVar, aVar.f46802s, a.this.f46788aa);
            if (a.this.f46800q == null || a.this.f46793j) {
                return;
            }
            a.this.f46793j = true;
            if (this.f46811a == null) {
                this.f46811a = new com.mbridge.msdk.foundation.same.report.d.b();
            }
            this.f46811a.b(copyOnWriteArrayList);
            if (bVar != null) {
                bVar.a("errorCode: 3201 errorMessage: campaign resource download failed");
            }
            this.f46811a.a(bVar);
            c.a(a.this.f46800q, bVar, this.f46811a);
        }
    }

    /* JADX INFO: renamed from: com.mbridge.msdk.reward.b.a$4, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    public class AnonymousClass4 implements com.mbridge.msdk.reward.adapter.b.i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        com.mbridge.msdk.foundation.same.report.d.b f46836a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ CampaignEx f46837b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ CopyOnWriteArrayList f46838c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.mbridge.msdk.reward.adapter.c f46839d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ boolean f46840e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f46841f;

        public AnonymousClass4(CampaignEx campaignEx, CopyOnWriteArrayList copyOnWriteArrayList, com.mbridge.msdk.reward.adapter.c cVar, boolean z11, int i11) {
            this.f46837b = campaignEx;
            this.f46838c = copyOnWriteArrayList;
            this.f46839d = cVar;
            this.f46840e = z11;
            this.f46841f = i11;
            this.f46836a = com.mbridge.msdk.foundation.same.report.d.c.a().b().get(campaignEx.getLocalRequestId());
        }

        @Override // com.mbridge.msdk.reward.adapter.b.i
        public final void a(String str, String str2, com.mbridge.msdk.foundation.c.b bVar) {
            String unitId;
            if (bVar != null) {
                unitId = bVar.d().getUnitId();
                bVar.a("errorCode: 3203 errorMessage: tpl temp resource download failed");
            } else {
                unitId = "";
            }
            a aVar = a.this;
            a.a(aVar, unitId, aVar.f46788aa);
            if (this.f46836a == null) {
                this.f46836a = new com.mbridge.msdk.foundation.same.report.d.b();
            }
            this.f46836a.a(bVar);
            this.f46836a.b(this.f46838c);
            a.this.f46791h = false;
            if (a.this.f46800q == null || a.this.f46793j) {
                return;
            }
            a.this.f46793j = true;
            c.a(a.this.f46800q, bVar, this.f46836a);
        }

        @Override // com.mbridge.msdk.reward.adapter.b.i
        public final void a(final String str, final String str2, final String str3, String str4) {
            a.this.f46791h = true;
            if (!a.this.f46790g || a.this.f46792i || a.this.f46808y == null) {
                return;
            }
            a.this.f46792i = true;
            a.this.f46808y.post(new Runnable() { // from class: com.mbridge.msdk.reward.b.a.4.1
                @Override // java.lang.Runnable
                public final void run() {
                    com.mbridge.msdk.reward.adapter.b bVarA = com.mbridge.msdk.reward.adapter.b.a();
                    boolean z11 = a.this.I;
                    Handler handler = a.this.f46808y;
                    boolean z12 = a.this.D;
                    boolean z13 = a.this.E;
                    String str5 = str3;
                    String requestIdNotice = AnonymousClass4.this.f46837b.getRequestIdNotice();
                    String str6 = str;
                    String str7 = str2;
                    String cMPTEntryUrl = AnonymousClass4.this.f46837b.getCMPTEntryUrl();
                    int i11 = a.this.f46809z;
                    AnonymousClass4 anonymousClass4 = AnonymousClass4.this;
                    bVarA.a(z11, handler, z12, z13, str5, requestIdNotice, str6, str7, cMPTEntryUrl, i11, anonymousClass4.f46837b, anonymousClass4.f46838c, H5DownLoadManager.getInstance().getH5ResAddress(AnonymousClass4.this.f46837b.getCMPTEntryUrl()), str2, a.this.f46797n, new com.mbridge.msdk.reward.adapter.b.j() { // from class: com.mbridge.msdk.reward.b.a.4.1.1
                        @Override // com.mbridge.msdk.reward.adapter.b.j
                        public final void a(String str8, String str9, String str10, com.mbridge.msdk.videocommon.a.C0532a c0532a, com.mbridge.msdk.foundation.c.b bVar) {
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            a aVar = a.this;
                            a.a(aVar, str2, aVar.f46788aa);
                            if (a.this.f46800q == null || a.this.f46793j) {
                                return;
                            }
                            a.this.f46793j = true;
                            if (bVar != null) {
                                bVar.a("errorCode: 3303 errorMessage: tpl temp preload failed");
                            }
                            AnonymousClass4 anonymousClass5 = AnonymousClass4.this;
                            if (anonymousClass5.f46836a == null) {
                                anonymousClass5.f46836a = new com.mbridge.msdk.foundation.same.report.d.b();
                            }
                            AnonymousClass4 anonymousClass6 = AnonymousClass4.this;
                            anonymousClass6.f46836a.b(anonymousClass6.f46838c);
                            AnonymousClass4.this.f46836a.a(bVar);
                            c.a(a.this.f46800q, bVar, AnonymousClass4.this.f46836a);
                        }

                        @Override // com.mbridge.msdk.reward.adapter.b.j
                        public final void a(String str8, String str9, String str10, String str11, String str12, com.mbridge.msdk.videocommon.a.C0532a c0532a) {
                            AnonymousClass4 anonymousClass5 = AnonymousClass4.this;
                            com.mbridge.msdk.reward.adapter.c cVar = anonymousClass5.f46839d;
                            if (cVar != null && cVar.a(anonymousClass5.f46838c, anonymousClass5.f46840e, anonymousClass5.f46841f)) {
                                if (a.this.f46800q == null || a.this.f46794k) {
                                    return;
                                }
                                a.this.f46794k = true;
                                ad.a("RewardVideoController", "Cache onVideoLoadSuccess");
                                AnonymousClass4 anonymousClass6 = AnonymousClass4.this;
                                a.this.a(anonymousClass6.f46838c);
                                AnonymousClass4 anonymousClass7 = AnonymousClass4.this;
                                com.mbridge.msdk.foundation.same.report.d.b bVar = anonymousClass7.f46836a;
                                if (bVar != null) {
                                    bVar.b(anonymousClass7.f46838c);
                                }
                                a.this.f46800q.b(str9, str10, AnonymousClass4.this.f46836a);
                                return;
                            }
                            a aVar = a.this;
                            a.a(aVar, str10, aVar.f46788aa);
                            if (a.this.f46800q == null || a.this.f46793j) {
                                return;
                            }
                            a.this.f46793j = true;
                            com.mbridge.msdk.foundation.c.b bVarB = com.mbridge.msdk.foundation.c.a.b(880015, "errorCode: 3505 errorMessage: tpl temp preload success but isReady false");
                            AnonymousClass4 anonymousClass8 = AnonymousClass4.this;
                            if (anonymousClass8.f46836a == null) {
                                anonymousClass8.f46836a = new com.mbridge.msdk.foundation.same.report.d.b();
                            }
                            AnonymousClass4 anonymousClass9 = AnonymousClass4.this;
                            anonymousClass9.f46836a.b(anonymousClass9.f46838c);
                            AnonymousClass4.this.f46836a.a(bVarB);
                            c.a(a.this.f46800q, bVarB, AnonymousClass4.this.f46836a);
                        }
                    }, true);
                }
            });
        }
    }

    /* JADX INFO: renamed from: com.mbridge.msdk.reward.b.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public class RunnableC0518a implements Runnable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final com.mbridge.msdk.reward.adapter.c f46850b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f46851c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final boolean f46852d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f46853e = false;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f46854f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private String f46855g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private com.mbridge.msdk.foundation.same.report.d.b f46856h;

        public RunnableC0518a(com.mbridge.msdk.reward.adapter.c cVar, int i11, boolean z11, String str, com.mbridge.msdk.foundation.same.report.d.b bVar) {
            this.f46850b = cVar;
            this.f46851c = i11;
            this.f46852d = z11;
            if (cVar != null) {
                cVar.e(false);
            }
            this.f46855g = str;
            this.f46856h = bVar;
        }

        public final void a() {
            this.f46853e = true;
        }

        public final void a(int i11) {
            this.f46854f = i11;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (this.f46853e) {
                return;
            }
            com.mbridge.msdk.reward.adapter.c cVar = this.f46850b;
            if (cVar != null) {
                cVar.e(true);
            }
            ad.b("RewardVideoController", "adSource=" + this.f46851c + " CommonCancelTimeTask mIsDevCall：" + this.f46852d);
            a.this.a(com.mbridge.msdk.foundation.c.a.b(880023, "v3 is timeout"), this.f46856h);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b implements com.mbridge.msdk.reward.adapter.a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private com.mbridge.msdk.reward.adapter.c f46858b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f46859c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private RunnableC0518a f46860d;

        public b(com.mbridge.msdk.reward.adapter.c cVar, boolean z11) {
            this.f46858b = cVar;
            this.f46859c = z11;
        }

        public final void a(RunnableC0518a runnableC0518a) {
            this.f46860d = runnableC0518a;
        }

        @Override // com.mbridge.msdk.reward.adapter.a
        public final void a(String str, com.mbridge.msdk.foundation.same.report.d.b bVar) {
            RunnableC0518a runnableC0518a = this.f46860d;
            if (runnableC0518a != null) {
                runnableC0518a.a();
                a.this.f46808y.removeCallbacks(this.f46860d);
            }
            if (a.this.f46800q != null) {
                c.b(a.this.f46800q, a.this.f46805v, a.this.f46802s, bVar);
            }
        }

        @Override // com.mbridge.msdk.reward.adapter.a
        public final void a(List<CampaignEx> list, com.mbridge.msdk.foundation.c.b bVar, com.mbridge.msdk.foundation.same.report.d.b bVar2) {
            RunnableC0518a runnableC0518a = this.f46860d;
            if (runnableC0518a != null) {
                runnableC0518a.a();
                a.this.f46808y.removeCallbacks(this.f46860d);
            }
            com.mbridge.msdk.reward.adapter.c cVar = this.f46858b;
            if (cVar != null) {
                cVar.a((com.mbridge.msdk.reward.adapter.a) null);
                this.f46858b = null;
            }
            a.this.a(list);
            if (a.this.f46800q != null) {
                a.this.f46800q.a(bVar, bVar2);
            }
        }

        @Override // com.mbridge.msdk.reward.adapter.a
        public final void a(List<CampaignEx> list, com.mbridge.msdk.foundation.same.report.d.b bVar) {
            RunnableC0518a runnableC0518a = this.f46860d;
            if (runnableC0518a != null) {
                runnableC0518a.a();
                a.this.f46808y.removeCallbacks(this.f46860d);
            }
            a.this.a(list);
            if (a.this.f46800q != null) {
                a.this.f46800q.a(a.this.f46805v, a.this.f46802s, bVar);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public final class c {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private WeakReference<InterVideoOutListener> f46862b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private volatile AtomicInteger f46863c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private Handler f46864d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private String f46865e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f46866f;

        private c(InterVideoOutListener interVideoOutListener, Handler handler, String str) {
            this.f46862b = new WeakReference<>(interVideoOutListener);
            this.f46863c = new AtomicInteger(0);
            this.f46864d = handler;
            this.f46865e = str;
        }

        public static /* synthetic */ int a(c cVar) {
            return cVar.f46863c.get();
        }

        public static /* synthetic */ void a(c cVar, int i11) {
            cVar.f46863c.set(i11);
        }

        public static /* synthetic */ void a(c cVar, com.mbridge.msdk.foundation.c.b bVar, com.mbridge.msdk.foundation.same.report.d.b bVar2) {
            WeakReference<InterVideoOutListener> weakReference = cVar.f46862b;
            InterVideoOutListener interVideoOutListener = weakReference != null ? weakReference.get() : null;
            if (cVar.f46863c.get() == 2 || cVar.f46864d == null) {
                return;
            }
            a.this.X = true;
            String strB = bVar != null ? bVar.b() : "";
            if (strB.contains("resource load timeout")) {
                a.this.W = true;
            }
            if (a.this.X && a.this.W && !a.this.V) {
                cVar.f46863c.set(2);
                if (interVideoOutListener != null) {
                    Message messageObtain = Message.obtain();
                    messageObtain.obj = strB;
                    messageObtain.what = 16;
                    if (bVar2 != null) {
                        Bundle bundle = new Bundle();
                        bundle.putString("metrics_data_lrid", bVar2.f());
                        messageObtain.setData(bundle);
                    }
                    cVar.f46864d.sendMessage(messageObtain);
                }
                if (bVar2 == null) {
                    bVar2 = new com.mbridge.msdk.foundation.same.report.d.b();
                }
                bVar2.a(true);
                a.a(a.this, "2000047", bVar2, interVideoOutListener);
            }
        }

        public static /* synthetic */ void a(c cVar, String str, com.mbridge.msdk.foundation.same.report.d.b bVar) {
            cVar.f46863c.set(2);
            cVar.a(str, bVar);
        }

        public static /* synthetic */ void a(c cVar, String str, String str2, com.mbridge.msdk.foundation.same.report.d.b bVar) {
            WeakReference<InterVideoOutListener> weakReference = cVar.f46862b;
            InterVideoOutListener interVideoOutListener = weakReference != null ? weakReference.get() : null;
            if (cVar.f46864d == null || a.this.U) {
                return;
            }
            a.this.U = true;
            a.a(a.this, "2000127", bVar, interVideoOutListener);
            if (interVideoOutListener != null) {
                Message messageObtain = Message.obtain();
                Bundle bundle = new Bundle();
                bundle.putString(MBridgeConstans.PLACEMENT_ID, str);
                bundle.putString(MBridgeConstans.PROPERTIES_UNIT_ID, str2);
                bundle.putBoolean(MBridgeConstans.PROPERTIES_IS_CACHED_CAMPAIGN, true);
                if (bVar != null) {
                    bundle.putString("metrics_data_lrid", bVar.f());
                }
                messageObtain.setData(bundle);
                messageObtain.obj = str2;
                messageObtain.what = 17;
                cVar.f46864d.sendMessage(messageObtain);
                if (af.a().a("l_s_i_l_v_s", false)) {
                    cVar.b(str, str2, bVar);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(String str, com.mbridge.msdk.foundation.same.report.d.b bVar) {
            WeakReference<InterVideoOutListener> weakReference = this.f46862b;
            a.a(a.this, "2000047", bVar, weakReference != null ? weakReference.get() : null);
            if (this.f46864d != null) {
                Message messageObtain = Message.obtain();
                messageObtain.obj = str;
                messageObtain.what = 18;
                if (bVar != null) {
                    Bundle bundle = new Bundle();
                    bundle.putString("metrics_data_lrid", bVar.f());
                    messageObtain.setData(bundle);
                }
                this.f46864d.sendMessage(messageObtain);
            }
        }

        public static /* synthetic */ void b(c cVar, String str, String str2, com.mbridge.msdk.foundation.same.report.d.b bVar) {
            WeakReference<InterVideoOutListener> weakReference = cVar.f46862b;
            InterVideoOutListener interVideoOutListener = weakReference != null ? weakReference.get() : null;
            if ((cVar.f46863c.get() != 1 && cVar.f46863c.get() != 3) || cVar.f46864d == null || a.this.U) {
                return;
            }
            a.this.U = true;
            a.a(a.this, "2000127", bVar, interVideoOutListener);
            if (interVideoOutListener != null) {
                Message messageObtain = Message.obtain();
                Bundle bundle = new Bundle();
                bundle.putString(MBridgeConstans.PLACEMENT_ID, str);
                bundle.putString(MBridgeConstans.PROPERTIES_UNIT_ID, str2);
                bundle.putBoolean(MBridgeConstans.PROPERTIES_IS_CACHED_CAMPAIGN, false);
                if (bVar != null) {
                    bundle.putString("metrics_data_lrid", bVar.f());
                }
                messageObtain.setData(bundle);
                messageObtain.obj = str2;
                messageObtain.what = 17;
                cVar.f46864d.sendMessage(messageObtain);
                if (af.a().a("l_s_i_l_v_s", false)) {
                    cVar.a(str, str2, bVar);
                }
            }
        }

        public final void a(com.mbridge.msdk.foundation.c.b bVar, com.mbridge.msdk.foundation.same.report.d.b bVar2) {
            String strB;
            if (bVar == null || bVar2 == null) {
                strB = "";
            } else {
                strB = bVar.b();
                bVar2.a(bVar);
            }
            if (a.this.f46796m != null) {
                a.this.f46796m.a(a.this.f46787a);
                CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayListE = a.this.f46796m.e();
                CampaignEx campaignEx = (a.this.M == null || a.this.M.size() == 0) ? null : (CampaignEx) a.this.M.get(0);
                if (campaignEx == null) {
                    campaignEx = (copyOnWriteArrayListE == null || copyOnWriteArrayListE.size() == 0) ? null : copyOnWriteArrayListE.get(0);
                }
                CampaignEx campaignEx2 = campaignEx;
                if (a.this.E && ((campaignEx2 == null || TextUtils.isEmpty(campaignEx2.getNLRid())) && ((copyOnWriteArrayListE == null || copyOnWriteArrayListE.size() == 0) && a.this.f46796m.a(campaignEx2, true, bVar, 2, bVar2)))) {
                    return;
                } else {
                    a.this.f46796m.a((com.mbridge.msdk.reward.adapter.a) null);
                }
            }
            Handler handler = this.f46864d;
            if (handler != null) {
                handler.removeMessages(1001002);
            }
            WeakReference<InterVideoOutListener> weakReference = this.f46862b;
            InterVideoOutListener interVideoOutListener = weakReference != null ? weakReference.get() : null;
            if (this.f46863c.get() == 2 || this.f46864d == null) {
                return;
            }
            a.this.W = true;
            if (!a.this.Y || strB.contains("resource load timeout")) {
                a.this.X = true;
            }
            if (a.this.V) {
                this.f46863c.set(2);
            }
            if (a.this.W && a.this.X && !a.this.V) {
                this.f46863c.set(2);
                a.a(a.this, "2000047", bVar2, interVideoOutListener);
                if (interVideoOutListener != null) {
                    Message messageObtain = Message.obtain();
                    messageObtain.obj = strB;
                    messageObtain.what = 16;
                    if (bVar2 != null) {
                        Bundle bundle = new Bundle();
                        bundle.putString("metrics_data_lrid", bVar2.f());
                        messageObtain.setData(bundle);
                    }
                    this.f46864d.sendMessage(messageObtain);
                }
            }
        }

        public final void a(String str, String str2, com.mbridge.msdk.foundation.same.report.d.b bVar) {
            Handler handler = this.f46864d;
            if (handler != null) {
                handler.removeMessages(1001002);
            }
            WeakReference<InterVideoOutListener> weakReference = this.f46862b;
            InterVideoOutListener interVideoOutListener = weakReference != null ? weakReference.get() : null;
            if (this.f46863c.get() == 2 || this.f46864d == null) {
                return;
            }
            this.f46863c.set(2);
            if (a.this.V) {
                return;
            }
            a.this.V = true;
            if (bVar == null) {
                bVar = new com.mbridge.msdk.foundation.same.report.d.b();
            }
            bVar.b(a.this.M);
            a.a(a.this, "2000048", bVar, interVideoOutListener);
            if (interVideoOutListener != null) {
                Message messageObtain = Message.obtain();
                Bundle bundle = new Bundle();
                bundle.putString(MBridgeConstans.PLACEMENT_ID, str);
                bundle.putString(MBridgeConstans.PROPERTIES_UNIT_ID, str2);
                bundle.putString("metrics_data_lrid", bVar.f());
                messageObtain.setData(bundle);
                messageObtain.obj = str2;
                messageObtain.what = 9;
                this.f46864d.sendMessage(messageObtain);
            }
        }

        public final void a(boolean z11) {
            this.f46866f = z11;
        }

        public final void b(String str, String str2, com.mbridge.msdk.foundation.same.report.d.b bVar) {
            Handler handler = this.f46864d;
            if (handler != null) {
                handler.removeMessages(1001002);
            }
            WeakReference<InterVideoOutListener> weakReference = this.f46862b;
            InterVideoOutListener interVideoOutListener = weakReference != null ? weakReference.get() : null;
            if (this.f46863c.get() == 2 || this.f46864d == null) {
                return;
            }
            if (this.f46863c.get() == 1) {
                this.f46863c.set(3);
            }
            if (a.this.V) {
                return;
            }
            a.this.V = true;
            if (bVar == null) {
                bVar = new com.mbridge.msdk.foundation.same.report.d.b();
            }
            bVar.a(true);
            bVar.b(a.this.M);
            a.a(a.this, "2000048", bVar, interVideoOutListener);
            if (interVideoOutListener != null) {
                Message messageObtain = Message.obtain();
                Bundle bundle = new Bundle();
                bundle.putString(MBridgeConstans.PLACEMENT_ID, str);
                bundle.putString(MBridgeConstans.PROPERTIES_UNIT_ID, str2);
                bundle.putSerializable("metrics_data_lrid", bVar.f());
                messageObtain.setData(bundle);
                messageObtain.obj = str2;
                messageObtain.what = 9;
                this.f46864d.sendMessage(messageObtain);
            }
            if (a.this.W) {
                this.f46863c.set(2);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public final class d extends com.mbridge.msdk.video.bt.module.b.b {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private a f46868d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private Handler f46869e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f46870f;

        private d(a aVar, Handler handler) {
            this.f46870f = 0;
            this.f46868d = aVar;
            this.f46869e = handler;
        }

        @Override // com.mbridge.msdk.video.bt.module.b.b, com.mbridge.msdk.video.bt.module.b.h
        public final void a(int i11, String str, String str2) {
            this.f46870f = i11;
            a aVar = this.f46868d;
            if (aVar == null || aVar.E || this.f46868d.D || this.f46868d.f46797n == null || !this.f46868d.f46797n.s(this.f46870f) || this.f46868d.f46800q == null || c.a(this.f46868d.f46800q) == 1 || c.a(this.f46868d.f46800q) == 3 || a.this.J.contains(Integer.valueOf(this.f46870f))) {
                return;
            }
            a.this.J.add(Integer.valueOf(this.f46870f));
            int iA = this.f46868d.f46797n.A() * 1000;
            if (this.f46870f == 4) {
                iA = AuthApiStatusCodes.AUTH_API_INVALID_CREDENTIALS;
            }
            Handler handler = this.f46869e;
            if (handler == null) {
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.mbridge.msdk.reward.b.a.d.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (d.this.f46868d != null) {
                            d.this.f46868d.a(false, com.mbridge.msdk.foundation.same.report.d.c.a().a(0, a.this.D ? 287 : 94, a.this.f46802s, true, 1));
                        }
                    }
                }, iA);
            } else {
                handler.removeMessages(1001001);
                this.f46869e.sendEmptyMessageDelayed(1001001, iA);
            }
        }

        @Override // com.mbridge.msdk.video.bt.module.b.b, com.mbridge.msdk.video.bt.module.b.h
        public final void a(com.mbridge.msdk.foundation.same.report.d.b bVar) {
            a.this.f46789c = false;
            try {
                com.mbridge.msdk.reward.a.a aVar = new com.mbridge.msdk.reward.a.a(a.this.f46802s, a.this.D);
                a aVar2 = this.f46868d;
                aVar.a(bVar.f(), (aVar2 == null || aVar2.f46796m == null) ? "" : this.f46868d.f46796m.f46701c, 3, a.f46783b);
            } catch (Exception e11) {
                if (MBridgeConstans.DEBUG) {
                    ad.b("RewardVideoController", e11.getMessage());
                }
            }
            try {
                a aVar3 = this.f46868d;
                if (aVar3 != null) {
                    aVar3.K = true;
                    if (this.f46868d.f46796m != null) {
                        this.f46868d.f46796m.f46701c = "";
                    }
                    final a aVar4 = this.f46868d;
                    com.mbridge.msdk.foundation.same.f.b.b().execute(new Runnable() { // from class: com.mbridge.msdk.reward.b.a.5
                        @Override // java.lang.Runnable
                        public final void run() {
                            try {
                                if (a.this.R == null) {
                                    a.this.R = h.a(com.mbridge.msdk.foundation.controller.c.m().c());
                                }
                                i iVarA = i.a(a.this.R);
                                if (iVarA != null) {
                                    iVarA.a(a.this.f46802s);
                                }
                            } catch (Throwable unused) {
                                ad.b("RewardVideoController", "can't find DailyPlayCapDao");
                            }
                        }
                    });
                    if (a.this.E) {
                        a.this.c();
                    }
                    a aVar5 = a.this;
                    aVar5.a("2000130", bVar, aVar5.f46799p, "");
                    this.f47510b = true;
                    if (this.f46868d.f46799p != null) {
                        this.f46868d.f46799p.onAdShow(a.this.f46803t);
                        this.f46870f = 2;
                    }
                }
            } catch (Throwable th2) {
                if (MBridgeConstans.DEBUG) {
                    ad.b("RewardVideoController", th2.getMessage());
                }
            }
        }

        @Override // com.mbridge.msdk.video.bt.module.b.b, com.mbridge.msdk.video.bt.module.b.h
        public final void a(com.mbridge.msdk.foundation.same.report.d.b bVar, String str) {
            try {
                a aVar = a.this;
                aVar.f46789c = false;
                if (this.f46868d != null) {
                    if (aVar.E) {
                        a.this.c();
                    }
                    this.f46868d.K = false;
                    a.this.a("2000131", bVar, this.f46868d.f46799p, str);
                    this.f47511c = true;
                    if (this.f46868d.f46799p != null) {
                        try {
                            this.f46868d.f46799p.onShowFail(bVar, a.this.f46803t, str);
                        } catch (Exception e11) {
                            if (MBridgeConstans.DEBUG) {
                                ad.b("RewardVideoController", e11.getMessage());
                            }
                        }
                        this.f46870f = 4;
                    }
                }
            } catch (Exception e12) {
                this.f46870f = 0;
                if (MBridgeConstans.DEBUG) {
                    ad.b("RewardVideoController", e12.getMessage());
                }
            }
        }

        @Override // com.mbridge.msdk.video.bt.module.b.b, com.mbridge.msdk.video.bt.module.b.h
        public final void a(com.mbridge.msdk.foundation.same.report.d.b bVar, boolean z11, com.mbridge.msdk.videocommon.b.c cVar) {
            try {
                a aVar = this.f46868d;
                if (aVar != null && aVar.f46799p != null) {
                    if (cVar == null) {
                        cVar = com.mbridge.msdk.videocommon.b.c.b(this.f46868d.f46806w);
                    }
                    if (a.this.E) {
                        a.this.c();
                        a.this.b();
                        com.mbridge.msdk.foundation.same.a.d.d(a.this.f46802s, a.this.a());
                    }
                    this.f46868d.f46799p.onAdClose(a.this.f46803t, new RewardInfo(z11, cVar.a(), String.valueOf(cVar.b())));
                    this.f46870f = 7;
                    this.f46868d.K = false;
                    a.this.J.clear();
                    this.f46868d = null;
                }
                com.mbridge.msdk.foundation.same.report.d.c.a().a("2000152", bVar, (com.mbridge.msdk.foundation.same.report.d.a.a) null);
            } catch (Exception e11) {
                if (MBridgeConstans.DEBUG) {
                    ad.b("RewardVideoController", e11.getMessage());
                }
            }
        }

        @Override // com.mbridge.msdk.video.bt.module.b.b, com.mbridge.msdk.video.bt.module.b.h
        public final void a(String str, String str2) {
            try {
                a aVar = this.f46868d;
                if (aVar == null || aVar.f46799p == null) {
                    return;
                }
                try {
                    this.f46868d.f46799p.onVideoComplete(a.this.f46803t);
                } catch (Exception e11) {
                    if (MBridgeConstans.DEBUG) {
                        ad.b("RewardVideoController", e11.getMessage());
                    }
                }
                this.f46870f = 5;
            } catch (Exception e12) {
                if (MBridgeConstans.DEBUG) {
                    ad.b("RewardVideoController", e12.getMessage());
                }
            }
        }

        @Override // com.mbridge.msdk.video.bt.module.b.b, com.mbridge.msdk.video.bt.module.b.h
        public final void a(boolean z11, int i11) {
            try {
                a aVar = this.f46868d;
                if (aVar != null && aVar.f46799p != null) {
                    try {
                        this.f46868d.f46799p.onAdCloseWithIVReward(a.this.f46803t, new RewardInfo(z11, i11));
                    } catch (Exception e11) {
                        if (MBridgeConstans.DEBUG) {
                            ad.b("RewardVideoController", e11.getMessage());
                        }
                    }
                }
            } catch (Exception e12) {
                if (MBridgeConstans.DEBUG) {
                    ad.b("RewardVideoController", e12.getMessage());
                }
            }
        }

        @Override // com.mbridge.msdk.video.bt.module.b.b, com.mbridge.msdk.video.bt.module.b.h
        public final void a(boolean z11, String str, String str2) {
            try {
                a aVar = this.f46868d;
                if (aVar == null || aVar.f46799p == null) {
                    return;
                }
                if (a.this.E) {
                    a.this.c();
                }
                this.f46868d.K = false;
                try {
                    this.f46868d.f46799p.onVideoAdClicked(z11, a.this.f46803t);
                } catch (Exception e11) {
                    if (MBridgeConstans.DEBUG) {
                        ad.b("RewardVideoController", e11.getMessage());
                    }
                }
            } catch (Exception e12) {
                if (MBridgeConstans.DEBUG) {
                    ad.b("RewardVideoController", e12.getMessage());
                }
            }
        }

        @Override // com.mbridge.msdk.video.bt.module.b.b, com.mbridge.msdk.video.bt.module.b.h
        public final void b(String str, String str2) {
            try {
                a aVar = this.f46868d;
                if (aVar == null || aVar.f46799p == null) {
                    return;
                }
                try {
                    this.f46868d.f46799p.onEndcardShow(a.this.f46803t);
                    com.mbridge.msdk.foundation.d.b.a().a(str2 + "_2", 2);
                } catch (Exception e11) {
                    if (MBridgeConstans.DEBUG) {
                        ad.b("RewardVideoController", e11.getMessage());
                    }
                }
                this.f46870f = 6;
            } catch (Exception e12) {
                if (MBridgeConstans.DEBUG) {
                    ad.b("RewardVideoController", e12.getMessage());
                }
            }
        }
    }

    private com.mbridge.msdk.foundation.same.report.d.b a(com.mbridge.msdk.foundation.same.report.d.d dVar) {
        CampaignEx campaignEx;
        com.mbridge.msdk.foundation.same.report.d.b bVar = null;
        try {
            CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayListA = com.mbridge.msdk.videocommon.download.b.getInstance().a(this.f46802s);
            String currentLocalRid = "";
            if (copyOnWriteArrayListA != null && copyOnWriteArrayListA.size() > 0 && (campaignEx = copyOnWriteArrayListA.get(0)) != null) {
                currentLocalRid = campaignEx.getCurrentLocalRid();
            }
            bVar = TextUtils.isEmpty(currentLocalRid) ? null : com.mbridge.msdk.foundation.same.report.d.c.a().b().get(currentLocalRid);
            if (bVar != null) {
                bVar.b(copyOnWriteArrayListA);
                bVar.a("2000128", dVar);
                bVar.c(currentLocalRid);
                bVar.d(this.f46802s);
                com.mbridge.msdk.reward.c.a.a.a().a("2000128", bVar);
                return bVar;
            }
            com.mbridge.msdk.foundation.same.report.d.b bVar2 = new com.mbridge.msdk.foundation.same.report.d.b();
            try {
                bVar2.d(this.f46802s);
                dVar.a("metrics_data_reason", "未获取到待展示的campaign信息 本地new metricsData");
                bVar2.a("2000128", dVar);
                if (TextUtils.isEmpty(currentLocalRid)) {
                    bVar2.c(SameMD5.getMD5(ai.d()));
                } else {
                    bVar2.c(currentLocalRid);
                    bVar2.b(copyOnWriteArrayListA);
                    com.mbridge.msdk.foundation.same.report.d.c.a().b().put(currentLocalRid, bVar2);
                }
                com.mbridge.msdk.reward.c.a.a.a().a("2000128", bVar2);
                return bVar2;
            } catch (Exception e11) {
                e = e11;
                bVar = bVar2;
                if (MBridgeConstans.DEBUG) {
                    ad.b("RewardVideoController", e.getMessage());
                }
                return bVar;
            }
        } catch (Exception e12) {
            e = e12;
        }
    }

    private String a(String str) {
        try {
            String md5 = TextUtils.isEmpty(str) ? SameMD5.getMD5(ai.d()) : "";
            String[] strArrSplit = str.split("_");
            if (strArrSplit != null && strArrSplit.length >= 3) {
                md5 = strArrSplit[2];
            }
            return TextUtils.isEmpty(md5) ? SameMD5.getMD5(ai.d()) : md5;
        } catch (Exception e11) {
            if (!MBridgeConstans.DEBUG) {
                return "";
            }
            e11.printStackTrace();
            return "";
        }
    }

    private CopyOnWriteArrayList<CampaignEx> a(String str, List<CampaignEx> list) {
        CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        if (list != null) {
            try {
                if (list.size() > 0) {
                    int vcn = 1;
                    for (CampaignEx campaignEx : list) {
                        if (campaignEx != null) {
                            if (campaignEx.getVcn() > vcn) {
                                vcn = campaignEx.getVcn();
                            }
                            if (campaignEx.getTokenRule() == 1) {
                                String requestId = campaignEx.getRequestId();
                                if (!TextUtils.isEmpty(requestId)) {
                                    if (linkedHashMap.containsKey(requestId)) {
                                        List list2 = (List) linkedHashMap.get(requestId);
                                        if (list2 != null) {
                                            list2.add(campaignEx);
                                        }
                                    } else {
                                        ArrayList arrayList = new ArrayList();
                                        arrayList.add(campaignEx);
                                        linkedHashMap.put(requestId, arrayList);
                                    }
                                }
                            } else {
                                String requestId2 = campaignEx.getRequestId();
                                if (!TextUtils.isEmpty(requestId2)) {
                                    if (linkedHashMap2.containsKey(requestId2)) {
                                        List list3 = (List) linkedHashMap2.get(requestId2);
                                        if (list3 != null) {
                                            list3.add(campaignEx);
                                        }
                                    } else {
                                        ArrayList arrayList2 = new ArrayList();
                                        arrayList2.add(campaignEx);
                                        linkedHashMap2.put(requestId2, arrayList2);
                                    }
                                }
                            }
                        }
                    }
                    if (linkedHashMap2.size() + linkedHashMap.size() >= vcn && linkedHashMap.size() > 0 && linkedHashMap.entrySet() != null && linkedHashMap.entrySet().iterator() != null && linkedHashMap.entrySet().iterator().next() != null && ((Map.Entry) linkedHashMap.entrySet().iterator().next()).getValue() != null) {
                        copyOnWriteArrayList.addAll((Collection) ((Map.Entry) linkedHashMap.entrySet().iterator().next()).getValue());
                        com.mbridge.msdk.foundation.same.a.d.a(this.f46802s, str, vcn);
                    }
                }
            } catch (Exception e11) {
                if (MBridgeConstans.DEBUG) {
                    ad.b("RewardVideoController", e11.getMessage());
                }
            }
        }
        return copyOnWriteArrayList;
    }

    private void a(int i11, int i12, boolean z11, String str, com.mbridge.msdk.foundation.same.report.d.b bVar) {
        try {
            com.mbridge.msdk.reward.adapter.c cVar = this.f46796m;
            if (cVar == null || !this.f46802s.equals(cVar.a())) {
                com.mbridge.msdk.reward.adapter.c cVar2 = new com.mbridge.msdk.reward.adapter.c(this.f46795l, this.f46805v, this.f46802s);
                this.f46796m = cVar2;
                cVar2.b(this.D);
                this.f46796m.c(this.E);
            }
            if (this.D) {
                this.f46796m.a(this.A, this.B, this.C);
            }
            this.f46796m.a(this.f46809z);
            this.f46796m.a(this.f46797n);
            RunnableC0518a runnableC0518a = new RunnableC0518a(this.f46796m, i11, z11, str, bVar);
            runnableC0518a.a(i12);
            b bVar2 = new b(this.f46796m, z11);
            this.f46787a = bVar2;
            bVar2.a(runnableC0518a);
            this.f46796m.a(this.f46787a);
            this.f46796m.a(i11, i12, z11, str, this.I, bVar);
            this.f46808y.postDelayed(runnableC0518a, i12 * 1000);
        } catch (Exception e11) {
            com.mbridge.msdk.foundation.c.b bVarB = com.mbridge.msdk.foundation.c.a.b(880020, e11.getMessage());
            if (bVar != null) {
                bVar.a(bVarB);
                bVar.c(true);
            }
            a(bVarB, bVar);
            if (MBridgeConstans.DEBUG) {
                ad.b("RewardVideoController", e11.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.mbridge.msdk.foundation.c.b bVar, com.mbridge.msdk.foundation.same.report.d.b bVar2) {
        if (this.f46800q != null) {
            this.X = true;
            this.f46800q.a(bVar, bVar2);
        }
    }

    private void a(com.mbridge.msdk.foundation.same.report.d.b bVar) {
        if (this.f46800q != null) {
            String strA = com.mbridge.msdk.foundation.c.a.a(880001, "");
            com.mbridge.msdk.foundation.c.b bVarB = com.mbridge.msdk.foundation.c.a.b(880001, "");
            if (bVar != null) {
                bVar.a(bVarB);
                bVar.c(true);
            }
            c.a(this.f46800q, strA, bVar);
        }
    }

    public static /* synthetic */ void a(a aVar, String str, com.mbridge.msdk.foundation.same.report.d.b bVar, InterVideoOutListener interVideoOutListener) {
        if (aVar.H) {
            if (bVar == null) {
                bVar = new com.mbridge.msdk.foundation.same.report.d.b();
                bVar.b(aVar.M);
            }
            try {
                com.mbridge.msdk.foundation.same.report.d.d dVar = new com.mbridge.msdk.foundation.same.report.d.d();
                if (interVideoOutListener != null) {
                    dVar.a("listener_state", 1);
                } else {
                    dVar.a("listener_state", 2);
                }
                bVar.a(str, dVar);
                com.mbridge.msdk.reward.c.a.a.a().a(str, bVar);
            } catch (Exception e11) {
                if (MBridgeConstans.DEBUG) {
                    e11.printStackTrace();
                }
            }
        }
    }

    public static /* synthetic */ void a(a aVar, String str, List list) {
        if (list != null) {
            try {
                if (list.size() <= 0 || aVar.V) {
                    return;
                }
                f.a(h.a(com.mbridge.msdk.foundation.controller.c.m().c())).a((List<CampaignEx>) list, str);
            } catch (Throwable th2) {
                ad.b("RewardVideoController", th2.getMessage());
            }
        }
    }

    public static void a(String str, int i11) {
        try {
            if (N == null || !an.b(str)) {
                return;
            }
            N.put(str, Integer.valueOf(i11));
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                ad.b("RewardVideoController", e11.getMessage());
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x00b7, code lost:
    
        if (r16.f46796m.c() != false) goto L38;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(String str, com.mbridge.msdk.foundation.same.report.d.b bVar) {
        com.mbridge.msdk.videocommon.d.c cVar;
        com.mbridge.msdk.videocommon.d.c cVar2;
        try {
            if (this.f46796m == null) {
                r();
            }
            if (this.f46796m != null) {
                ad.b("RewardVideoController", "controller 819");
                if (this.E ? e(false) : this.f46796m.b()) {
                    ad.c("RewardVideoController", "invoke adapter show isReady");
                    d dVar = new d(this, this.f46808y);
                    f46786f.put(this.f46802s, dVar);
                    this.f46796m.a(dVar, str, this.f46801r, this.f46809z, this.f46804u, bVar);
                    this.f46789c = false;
                    return;
                }
                if (this.E) {
                    if (this.f46796m == null) {
                        r();
                    }
                    List<com.mbridge.msdk.foundation.entity.c> listA = com.mbridge.msdk.videocommon.a.a.a().a(this.f46802s);
                    if (listA != null && listA.size() > 0) {
                        for (com.mbridge.msdk.foundation.entity.c cVar3 : listA) {
                            if (cVar3 != null) {
                                this.f46796m.a(cVar3.a());
                                this.f46796m.f46702d = cVar3.d();
                                if (this.f46796m.c()) {
                                    ad.c("RewardVideoController", "invoke adapter show isSpareOfferReady");
                                    d dVar2 = new d(this, this.f46808y);
                                    f46786f.put(this.f46802s, dVar2);
                                    this.f46796m.a(dVar2, str, this.f46801r, this.f46809z, this.f46804u, bVar);
                                    this.f46789c = false;
                                    return;
                                }
                                com.mbridge.msdk.videocommon.a.a.a().c(this.f46802s, cVar3.a());
                            }
                        }
                    }
                }
            }
            this.f46789c = false;
            a("2000131", bVar, this.f46799p, "can't show because load is failed");
            if (this.f46799p != null) {
                try {
                    this.f46799p.onShowFail(bVar, this.f46803t, "can't show because load is failed");
                } catch (Exception e11) {
                    if (MBridgeConstans.DEBUG) {
                        ad.b("RewardVideoController", e11.getMessage());
                    }
                }
            }
            if (this.D || this.E || (cVar2 = this.f46797n) == null || !cVar2.s(4) || this.f46800q == null || c.a(this.f46800q) == 1 || c.a(this.f46800q) == 3) {
                return;
            }
            a(false, com.mbridge.msdk.foundation.same.report.d.c.a().a(0, 94, this.f46802s, true, 1));
        } catch (Exception e12) {
            this.f46789c = false;
            if (MBridgeConstans.DEBUG) {
                ad.b("RewardVideoController", e12.getLocalizedMessage());
            }
            a("2000131", bVar, this.f46799p, "show exception");
            if (this.f46799p != null) {
                try {
                    this.f46799p.onShowFail(bVar, this.f46803t, "show exception");
                } catch (Exception unused) {
                    if (MBridgeConstans.DEBUG) {
                        ad.b("RewardVideoController", e12.getMessage());
                    }
                }
            }
            if (this.D || this.E || (cVar = this.f46797n) == null || !cVar.s(4) || this.f46800q == null || c.a(this.f46800q) == 1 || c.a(this.f46800q) == 3) {
                return;
            }
            a(false, com.mbridge.msdk.foundation.same.report.d.c.a().a(0, 94, this.f46802s, true, 1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, com.mbridge.msdk.foundation.same.report.d.b bVar, InterVideoOutListener interVideoOutListener, String str2) {
        if (bVar == null) {
            try {
                bVar = new com.mbridge.msdk.foundation.same.report.d.b();
                bVar.b(this.M);
            } catch (Exception e11) {
                if (MBridgeConstans.DEBUG) {
                    e11.printStackTrace();
                    return;
                }
                return;
            }
        }
        com.mbridge.msdk.foundation.same.report.d.d dVar = new com.mbridge.msdk.foundation.same.report.d.d();
        if (!TextUtils.isEmpty(str2)) {
            dVar.a("reason", str2);
        }
        if (interVideoOutListener != null) {
            dVar.a("listener_state", 1);
        } else {
            dVar.a("listener_state", 2);
        }
        bVar.a(str, dVar);
        com.mbridge.msdk.reward.c.a.a.a().a(str, bVar);
    }

    public static void a(String str, String str2) {
        ConcurrentHashMap<String, String> concurrentHashMap;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || (concurrentHashMap = O) == null || concurrentHashMap.containsKey(str)) {
            return;
        }
        O.put(str, str2);
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0021  */
    private void a(Queue<Integer> queue, boolean z11, String str, com.mbridge.msdk.foundation.same.report.d.b bVar) {
        Integer numPoll;
        int iIntValue;
        if (queue != null) {
            try {
                if (queue.size() <= 0 || (numPoll = queue.poll()) == null) {
                    iIntValue = 25;
                } else {
                    iIntValue = numPoll.intValue();
                }
            } catch (Exception e11) {
                com.mbridge.msdk.foundation.c.b bVarB = com.mbridge.msdk.foundation.c.a.b(880020, "load mv api error:" + e11.getMessage());
                if (bVar != null) {
                    bVar.a(bVarB);
                    bVar.c(true);
                }
                a(bVarB, bVar);
                if (MBridgeConstans.DEBUG) {
                    ad.b("RewardVideoController", e11.getMessage());
                    return;
                }
                return;
            }
        } else {
            iIntValue = 25;
        }
        try {
            a(1, iIntValue, z11, str, bVar);
        } catch (Exception e12) {
            com.mbridge.msdk.foundation.c.b bVarB2 = com.mbridge.msdk.foundation.c.a.b(880020, "load mv api error:" + e12.getMessage());
            if (bVar != null) {
                bVar.a(bVarB2);
                bVar.c(true);
            }
            a(bVarB2, bVar);
            if (MBridgeConstans.DEBUG) {
                ad.b("RewardVideoController", e12.getMessage());
            }
        }
    }

    private void a(CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList, com.mbridge.msdk.reward.adapter.c cVar) {
        CampaignEx campaignEx = copyOnWriteArrayList.get(0);
        boolean z11 = !TextUtils.isEmpty(campaignEx.getCMPTEntryUrl());
        int nscpt = campaignEx.getNscpt();
        this.f46790g = false;
        this.f46791h = false;
        this.f46792i = false;
        this.f46793j = false;
        this.f46794k = false;
        com.mbridge.msdk.reward.adapter.b.a().a(this.f46795l, z11, nscpt, this.E, this.D ? 287 : 94, this.f46805v, this.f46802s, campaignEx.getRequestId(), copyOnWriteArrayList, new AnonymousClass2(campaignEx, z11, cVar, nscpt), new com.mbridge.msdk.reward.adapter.b.i(campaignEx, copyOnWriteArrayList, z11, nscpt) { // from class: com.mbridge.msdk.reward.b.a.3

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            com.mbridge.msdk.foundation.same.report.d.b f46830a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ CampaignEx f46831b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ CopyOnWriteArrayList f46832c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ boolean f46833d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            final /* synthetic */ int f46834e;

            {
                this.f46831b = campaignEx;
                this.f46832c = copyOnWriteArrayList;
                this.f46833d = z11;
                this.f46834e = nscpt;
                this.f46830a = com.mbridge.msdk.foundation.same.report.d.c.a().b().get(campaignEx.getLocalRequestId());
            }

            @Override // com.mbridge.msdk.reward.adapter.b.i
            public final void a(String str, String str2, com.mbridge.msdk.foundation.c.b bVar) {
                String unitId = bVar == null ? "" : bVar.d().getUnitId();
                a aVar = a.this;
                a.a(aVar, unitId, aVar.f46788aa);
                if (bVar != null) {
                    bVar.a("errorCode: 3202 errorMessage: temp resource download failed");
                }
                if (this.f46830a == null) {
                    this.f46830a = new com.mbridge.msdk.foundation.same.report.d.b();
                }
                this.f46830a.b(this.f46832c);
                this.f46830a.a(bVar);
                if (!this.f46833d && a.this.f46800q != null) {
                    if (a.this.f46793j) {
                        return;
                    }
                    a.this.f46793j = true;
                    c.a(a.this.f46800q, bVar, this.f46830a);
                    return;
                }
                if (this.f46834e != 1 || a.this.f46793j || a.this.f46800q == null) {
                    return;
                }
                a.this.f46793j = true;
                c.a(a.this.f46800q, bVar, this.f46830a);
            }

            @Override // com.mbridge.msdk.reward.adapter.b.i
            public final void a(String str, String str2, String str3, String str4) {
            }
        });
        if (z11) {
            com.mbridge.msdk.reward.adapter.b.a().a(this.f46795l, campaignEx, this.f46805v, this.f46802s, campaignEx.getRequestId(), new AnonymousClass4(campaignEx, copyOnWriteArrayList, cVar, z11, nscpt));
        }
    }

    private void a(CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList, String str, com.mbridge.msdk.foundation.same.report.d.b bVar) {
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.size() <= 0) {
            return;
        }
        try {
            com.mbridge.msdk.foundation.same.report.d.d dVar = new com.mbridge.msdk.foundation.same.report.d.d();
            dVar.a("cache", 1);
            bVar.a("2000127", dVar);
            bVar.a("2000048", dVar);
            bVar.a(copyOnWriteArrayList);
        } catch (Exception e11) {
            ad.b("RewardVideoController", e11.getMessage());
        }
        this.Y = true;
        this.f46800q.a(this.E);
        c.a(this.f46800q, this.f46805v, this.f46802s, bVar);
        CampaignEx campaignEx = copyOnWriteArrayList.get(0);
        a(campaignEx.getRequestId(), str);
        com.mbridge.msdk.reward.adapter.c cVar = this.f46796m;
        if (cVar == null || !cVar.a(copyOnWriteArrayList, true ^ TextUtils.isEmpty(campaignEx.getCMPTEntryUrl()), campaignEx.getNscpt())) {
            a(copyOnWriteArrayList, this.f46796m);
        } else {
            a(copyOnWriteArrayList);
            this.f46800q.b(this.f46805v, this.f46802s, bVar);
        }
    }

    private void a(boolean z11, com.mbridge.msdk.foundation.same.report.d.b bVar) {
        if (!this.H) {
            if (z11) {
                this.H = z11;
            }
        } else if (z11) {
            String strA = com.mbridge.msdk.foundation.c.a.a(880016, "errorCode: 3501 errorMessage: current unit is loading");
            com.mbridge.msdk.foundation.c.b bVarB = com.mbridge.msdk.foundation.c.a.b(880016, "errorCode: 3501 errorMessage: current unit is loading");
            if (bVar != null) {
                bVar.a(bVarB);
                bVar.c(true);
            }
            this.f46800q.a(strA, bVar);
        }
    }

    private void a(boolean z11, String str, com.mbridge.msdk.foundation.same.report.d.b bVar) {
        com.mbridge.msdk.reward.a.a aVar;
        com.mbridge.msdk.reward.a.a aVar2;
        if (this.f46800q != null) {
            if (!this.E) {
                this.Y = c(this.f46802s, bVar.f());
                if (!this.Y) {
                    if (!s()) {
                        this.Y = false;
                        com.mbridge.msdk.reward.adapter.c cVar = this.f46796m;
                        if (cVar != null) {
                            cVar.a(this.Z);
                        }
                        this.f46800q.a(this.E);
                        a(this.P, z11, str, bVar);
                        return;
                    }
                    if (z11) {
                        if (this.f46800q != null) {
                            String strA = com.mbridge.msdk.foundation.c.a.a(880019, "");
                            bVar.a(com.mbridge.msdk.foundation.c.a.b(880019, ""));
                            bVar.c(true);
                            c.a(this.f46800q, strA, bVar);
                            return;
                        }
                        return;
                    }
                    this.Y = false;
                    com.mbridge.msdk.reward.adapter.c cVar2 = this.f46796m;
                    if (cVar2 != null) {
                        cVar2.a(this.Z);
                    }
                    this.f46800q.a(this.E);
                    a(this.P, z11, str, bVar);
                    return;
                }
                if (s()) {
                    ad.a("RewardVideoController", "非BID，本地存在可用的缓存，超过上限");
                    CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList = this.Z;
                    if (copyOnWriteArrayList != null && copyOnWriteArrayList.size() > 0) {
                        Iterator<CampaignEx> it = this.Z.iterator();
                        while (it.hasNext()) {
                            com.mbridge.msdk.videocommon.a.a.a().a(it.next(), this.f46802s);
                        }
                    }
                    com.mbridge.msdk.reward.adapter.c cVar3 = this.f46796m;
                    if (cVar3 != null) {
                        cVar3.a(this.Z);
                    }
                    if (!z11) {
                        this.Y = false;
                        this.f46800q.a(this.E);
                        a(this.P, z11, str, bVar);
                        return;
                    } else {
                        if (this.f46800q != null) {
                            String strA2 = com.mbridge.msdk.foundation.c.a.a(880019, "");
                            bVar.a(com.mbridge.msdk.foundation.c.a.b(880019, ""));
                            bVar.c(true);
                            c.a(this.f46800q, strA2, bVar);
                            return;
                        }
                        return;
                    }
                }
                CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList2 = this.Z;
                if (copyOnWriteArrayList2 == null || copyOnWriteArrayList2.size() <= 0) {
                    return;
                }
                try {
                    com.mbridge.msdk.foundation.same.report.d.d dVar = new com.mbridge.msdk.foundation.same.report.d.d();
                    dVar.a("cache", 1);
                    bVar.a("2000127", dVar);
                    bVar.a("2000048", dVar);
                    bVar.a(copyOnWriteArrayList2);
                } catch (Exception e11) {
                    if (MBridgeConstans.DEBUG) {
                        ad.b("RewardVideoController", e11.getMessage());
                    }
                }
                c.a(this.f46800q, this.f46805v, this.f46802s, bVar);
                CampaignEx campaignEx = copyOnWriteArrayList2.get(0);
                this.f46800q.a(this.E);
                com.mbridge.msdk.reward.adapter.c cVar4 = this.f46796m;
                if (cVar4 == null || !cVar4.a(copyOnWriteArrayList2, !TextUtils.isEmpty(campaignEx.getCMPTEntryUrl()), campaignEx.getNscpt())) {
                    a(copyOnWriteArrayList2, this.f46796m);
                } else {
                    a(copyOnWriteArrayList2);
                    this.f46800q.b(this.f46805v, this.f46802s, bVar);
                }
                if (this.S) {
                    com.mbridge.msdk.reward.adapter.c cVar5 = this.f46796m;
                    if (cVar5 != null) {
                        cVar5.a(this.Z);
                    }
                    a(this.P, z11, str, bVar);
                    return;
                }
                return;
            }
            CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayListA = com.mbridge.msdk.videocommon.a.a.a().a(this.f46802s, 1, this.E, "");
            CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayListA2 = null;
            if (copyOnWriteArrayListA == null || copyOnWriteArrayListA.size() <= 0) {
                if (s()) {
                    com.mbridge.msdk.videocommon.a.a.a().a(this.f46802s, str);
                    if (!z11 || this.f46800q == null) {
                        return;
                    }
                    String strA3 = com.mbridge.msdk.foundation.c.a.a(880019, "");
                    com.mbridge.msdk.foundation.c.b bVarB = com.mbridge.msdk.foundation.c.a.b(880019, "");
                    if (bVar != null) {
                        bVar.a(bVarB);
                        bVar.c(true);
                    }
                    c.a(this.f46800q, strA3, bVar);
                    return;
                }
                try {
                    com.mbridge.msdk.reward.a.a aVar3 = new com.mbridge.msdk.reward.a.a(this.f46802s, this.D);
                    com.mbridge.msdk.foundation.b.c cVar6 = new com.mbridge.msdk.foundation.b.c();
                    if (aVar3.a(str)) {
                        if (this.f46796m == null) {
                            com.mbridge.msdk.reward.adapter.c cVar7 = new com.mbridge.msdk.reward.adapter.c(this.f46795l, this.f46805v, this.f46802s);
                            this.f46796m = cVar7;
                            cVar7.b(this.D);
                            this.f46796m.c(this.E);
                            if (this.D) {
                                this.f46796m.a(this.A, this.B, this.C);
                            }
                            this.f46796m.a(this.f46809z);
                            this.f46796m.a(this.f46797n);
                        }
                        aVar = aVar3;
                        cVar6 = aVar3.a(str, bVar, (CampaignEx) null, new com.mbridge.msdk.foundation.c.b(880038), 1, this.f46796m);
                        if (cVar6 != null && cVar6.g() == com.mbridge.msdk.foundation.b.c.f44012d && cVar6.a() != null && cVar6.a().size() > 0 && this.f46796m != null) {
                            CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayListA3 = cVar6.a();
                            if (copyOnWriteArrayListA != null) {
                                ArrayList arrayList = new ArrayList();
                                for (CampaignEx campaignEx2 : copyOnWriteArrayListA) {
                                    if (campaignEx2 != null) {
                                        String requestId = campaignEx2.getRequestId();
                                        if (!TextUtils.isEmpty(requestId)) {
                                            for (int i11 = 0; i11 < copyOnWriteArrayListA3.size(); i11++) {
                                                CampaignEx campaignEx3 = copyOnWriteArrayListA3.get(i11);
                                                if (campaignEx3 != null) {
                                                    if (requestId.equals(campaignEx3.getRequestId())) {
                                                        break;
                                                    } else if (i11 == copyOnWriteArrayListA3.size() - 1) {
                                                        arrayList.add(campaignEx2);
                                                    }
                                                }
                                            }
                                            if (copyOnWriteArrayListA3.size() != 0) {
                                                break;
                                            }
                                            arrayList.add(campaignEx2);
                                            break;
                                        }
                                    }
                                }
                                this.f46796m.a(arrayList);
                            }
                            this.f46796m.a(cVar6.a(), false, true);
                            copyOnWriteArrayListA2 = new CopyOnWriteArrayList<>(cVar6.a());
                        }
                    } else {
                        aVar = aVar3;
                        copyOnWriteArrayListA2 = a(str, copyOnWriteArrayListA);
                        if (copyOnWriteArrayListA2.size() > 0) {
                            com.mbridge.msdk.foundation.db.b.a(com.mbridge.msdk.foundation.controller.c.m().c()).a(str, copyOnWriteArrayListA2);
                        }
                        cVar6.d("cb is closed 2");
                        cVar6.a(com.mbridge.msdk.foundation.b.c.f44011c);
                    }
                    aVar.a(bVar, str, cVar6, (List<com.mbridge.msdk.foundation.b.a.C0483a>) null, (JSONObject) null, 1);
                    if (copyOnWriteArrayListA2 != null && copyOnWriteArrayListA2.size() > 0) {
                        a(copyOnWriteArrayListA2, str, bVar);
                        if (this.f46796m != null && !aVar.a(str)) {
                            this.f46796m.a(copyOnWriteArrayListA2);
                        }
                    }
                } catch (Exception e12) {
                    if (MBridgeConstans.DEBUG) {
                        ad.b("RewardVideoController", e12.getMessage());
                    }
                }
                this.Y = false;
                this.f46800q.a(this.E);
                a(this.P, z11, str, bVar);
                return;
            }
            if (s()) {
                com.mbridge.msdk.videocommon.a.a.a().a(this.f46802s, str);
                if (!z11 || this.f46800q == null) {
                    return;
                }
                String strA4 = com.mbridge.msdk.foundation.c.a.a(880019, "");
                com.mbridge.msdk.foundation.c.b bVarB2 = com.mbridge.msdk.foundation.c.a.b(880019, "");
                if (bVar != null) {
                    bVar.a(bVarB2);
                    bVar.c(true);
                }
                c.a(this.f46800q, strA4, bVar);
                return;
            }
            CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList3 = new CopyOnWriteArrayList<>();
            if (copyOnWriteArrayListA.size() > 0 && !TextUtils.isEmpty(str)) {
                for (CampaignEx campaignEx4 : copyOnWriteArrayListA) {
                    if (campaignEx4 != null && str.equals(campaignEx4.getBidToken())) {
                        copyOnWriteArrayList3.add(campaignEx4);
                    }
                }
            }
            if (copyOnWriteArrayList3.size() > 0) {
                a(copyOnWriteArrayList3, str, bVar);
                return;
            }
            try {
                com.mbridge.msdk.reward.a.a aVar4 = new com.mbridge.msdk.reward.a.a(this.f46802s, this.D);
                com.mbridge.msdk.foundation.b.c cVar8 = new com.mbridge.msdk.foundation.b.c();
                if (aVar4.a(str)) {
                    if (this.f46796m == null) {
                        com.mbridge.msdk.reward.adapter.c cVar9 = new com.mbridge.msdk.reward.adapter.c(this.f46795l, this.f46805v, this.f46802s);
                        this.f46796m = cVar9;
                        cVar9.b(this.D);
                        this.f46796m.c(this.E);
                        if (this.D) {
                            this.f46796m.a(this.A, this.B, this.C);
                        }
                        this.f46796m.a(this.f46809z);
                        this.f46796m.a(this.f46797n);
                    }
                    aVar2 = aVar4;
                    cVar8 = aVar4.a(str, bVar, (CampaignEx) null, new com.mbridge.msdk.foundation.c.b(880038), 1, this.f46796m);
                    if (cVar8 != null && cVar8.g() == com.mbridge.msdk.foundation.b.c.f44012d && cVar8.a() != null && cVar8.a().size() > 0 && this.f46796m != null) {
                        CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayListA4 = cVar8.a();
                        ArrayList arrayList2 = new ArrayList();
                        for (CampaignEx campaignEx5 : copyOnWriteArrayListA) {
                            if (campaignEx5 != null) {
                                String requestId2 = campaignEx5.getRequestId();
                                if (!TextUtils.isEmpty(requestId2)) {
                                    for (int i12 = 0; i12 < copyOnWriteArrayListA4.size(); i12++) {
                                        CampaignEx campaignEx6 = copyOnWriteArrayListA4.get(i12);
                                        if (campaignEx6 != null) {
                                            if (requestId2.equals(campaignEx6.getRequestId())) {
                                                break;
                                            } else if (i12 == copyOnWriteArrayListA4.size() - 1) {
                                                arrayList2.add(campaignEx5);
                                            }
                                        }
                                    }
                                    if (copyOnWriteArrayListA4.size() != 0) {
                                        break;
                                    }
                                    arrayList2.add(campaignEx5);
                                    break;
                                }
                            }
                        }
                        this.f46796m.a(arrayList2);
                        this.f46796m.a(cVar8.a(), false, true);
                        copyOnWriteArrayListA2 = new CopyOnWriteArrayList<>(cVar8.a());
                    }
                } else {
                    aVar2 = aVar4;
                    copyOnWriteArrayListA2 = a(str, copyOnWriteArrayListA);
                    if (copyOnWriteArrayListA2.size() > 0) {
                        com.mbridge.msdk.foundation.db.b.a(com.mbridge.msdk.foundation.controller.c.m().c()).a(str, copyOnWriteArrayListA2);
                    }
                    cVar8.d("cb is closed");
                    cVar8.a(com.mbridge.msdk.foundation.b.c.f44011c);
                }
                aVar2.a(bVar, str, cVar8, (List<com.mbridge.msdk.foundation.b.a.C0483a>) null, (JSONObject) null, 1);
                if (copyOnWriteArrayListA2 != null && copyOnWriteArrayListA2.size() > 0) {
                    a(copyOnWriteArrayListA2, str, bVar);
                    if (this.f46796m != null && !aVar2.a(str)) {
                        this.f46796m.a(copyOnWriteArrayListA2);
                    }
                }
            } catch (Exception e13) {
                if (MBridgeConstans.DEBUG) {
                    ad.b("RewardVideoController", e13.getMessage());
                }
            }
            this.Y = false;
            this.f46800q.a(this.E);
            a(this.P, z11, str, bVar);
        }
    }

    private boolean a(List<com.mbridge.msdk.foundation.entity.c> list, String str) {
        if (list == null) {
            return false;
        }
        for (com.mbridge.msdk.foundation.entity.c cVar : list) {
            if (cVar != null && str.equals(cVar.b())) {
                this.f46796m.a(cVar.a());
                this.f46796m.f46702d = cVar.d();
                if (this.f46796m.b()) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:34:0x0080 A[Catch: Exception -> 0x007d, TryCatch #0 {Exception -> 0x007d, blocks: (B:34:0x0080, B:36:0x0086, B:38:0x0093, B:40:0x009d, B:45:0x00b6, B:48:0x00c2, B:50:0x00c8, B:51:0x00d5, B:53:0x00db, B:55:0x00ea, B:58:0x00f1, B:60:0x00f6, B:37:0x008f, B:29:0x0075, B:31:0x0079, B:4:0x000b, B:6:0x0017, B:8:0x001f, B:10:0x0025, B:11:0x0029, B:13:0x002f, B:16:0x003f, B:18:0x0049, B:20:0x004f, B:21:0x0057, B:23:0x005d, B:25:0x0065, B:27:0x0071), top: B:66:0x0009, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:36:0x0086 A[Catch: Exception -> 0x007d, TryCatch #0 {Exception -> 0x007d, blocks: (B:34:0x0080, B:36:0x0086, B:38:0x0093, B:40:0x009d, B:45:0x00b6, B:48:0x00c2, B:50:0x00c8, B:51:0x00d5, B:53:0x00db, B:55:0x00ea, B:58:0x00f1, B:60:0x00f6, B:37:0x008f, B:29:0x0075, B:31:0x0079, B:4:0x000b, B:6:0x0017, B:8:0x001f, B:10:0x0025, B:11:0x0029, B:13:0x002f, B:16:0x003f, B:18:0x0049, B:20:0x004f, B:21:0x0057, B:23:0x005d, B:25:0x0065, B:27:0x0071), top: B:66:0x0009, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:37:0x008f A[Catch: Exception -> 0x007d, TryCatch #0 {Exception -> 0x007d, blocks: (B:34:0x0080, B:36:0x0086, B:38:0x0093, B:40:0x009d, B:45:0x00b6, B:48:0x00c2, B:50:0x00c8, B:51:0x00d5, B:53:0x00db, B:55:0x00ea, B:58:0x00f1, B:60:0x00f6, B:37:0x008f, B:29:0x0075, B:31:0x0079, B:4:0x000b, B:6:0x0017, B:8:0x001f, B:10:0x0025, B:11:0x0029, B:13:0x002f, B:16:0x003f, B:18:0x0049, B:20:0x004f, B:21:0x0057, B:23:0x005d, B:25:0x0065, B:27:0x0071), top: B:66:0x0009, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:40:0x009d A[Catch: Exception -> 0x007d, TRY_LEAVE, TryCatch #0 {Exception -> 0x007d, blocks: (B:34:0x0080, B:36:0x0086, B:38:0x0093, B:40:0x009d, B:45:0x00b6, B:48:0x00c2, B:50:0x00c8, B:51:0x00d5, B:53:0x00db, B:55:0x00ea, B:58:0x00f1, B:60:0x00f6, B:37:0x008f, B:29:0x0075, B:31:0x0079, B:4:0x000b, B:6:0x0017, B:8:0x001f, B:10:0x0025, B:11:0x0029, B:13:0x002f, B:16:0x003f, B:18:0x0049, B:20:0x004f, B:21:0x0057, B:23:0x005d, B:25:0x0065, B:27:0x0071), top: B:66:0x0009, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:48:0x00c2 A[Catch: Exception -> 0x007d, TRY_ENTER, TryCatch #0 {Exception -> 0x007d, blocks: (B:34:0x0080, B:36:0x0086, B:38:0x0093, B:40:0x009d, B:45:0x00b6, B:48:0x00c2, B:50:0x00c8, B:51:0x00d5, B:53:0x00db, B:55:0x00ea, B:58:0x00f1, B:60:0x00f6, B:37:0x008f, B:29:0x0075, B:31:0x0079, B:4:0x000b, B:6:0x0017, B:8:0x001f, B:10:0x0025, B:11:0x0029, B:13:0x002f, B:16:0x003f, B:18:0x0049, B:20:0x004f, B:21:0x0057, B:23:0x005d, B:25:0x0065, B:27:0x0071), top: B:66:0x0009, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:50:0x00c8 A[Catch: Exception -> 0x007d, TryCatch #0 {Exception -> 0x007d, blocks: (B:34:0x0080, B:36:0x0086, B:38:0x0093, B:40:0x009d, B:45:0x00b6, B:48:0x00c2, B:50:0x00c8, B:51:0x00d5, B:53:0x00db, B:55:0x00ea, B:58:0x00f1, B:60:0x00f6, B:37:0x008f, B:29:0x0075, B:31:0x0079, B:4:0x000b, B:6:0x0017, B:8:0x001f, B:10:0x0025, B:11:0x0029, B:13:0x002f, B:16:0x003f, B:18:0x0049, B:20:0x004f, B:21:0x0057, B:23:0x005d, B:25:0x0065, B:27:0x0071), top: B:66:0x0009, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:53:0x00db A[Catch: Exception -> 0x007d, TryCatch #0 {Exception -> 0x007d, blocks: (B:34:0x0080, B:36:0x0086, B:38:0x0093, B:40:0x009d, B:45:0x00b6, B:48:0x00c2, B:50:0x00c8, B:51:0x00d5, B:53:0x00db, B:55:0x00ea, B:58:0x00f1, B:60:0x00f6, B:37:0x008f, B:29:0x0075, B:31:0x0079, B:4:0x000b, B:6:0x0017, B:8:0x001f, B:10:0x0025, B:11:0x0029, B:13:0x002f, B:16:0x003f, B:18:0x0049, B:20:0x004f, B:21:0x0057, B:23:0x005d, B:25:0x0065, B:27:0x0071), top: B:66:0x0009, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:55:0x00ea A[Catch: Exception -> 0x007d, TryCatch #0 {Exception -> 0x007d, blocks: (B:34:0x0080, B:36:0x0086, B:38:0x0093, B:40:0x009d, B:45:0x00b6, B:48:0x00c2, B:50:0x00c8, B:51:0x00d5, B:53:0x00db, B:55:0x00ea, B:58:0x00f1, B:60:0x00f6, B:37:0x008f, B:29:0x0075, B:31:0x0079, B:4:0x000b, B:6:0x0017, B:8:0x001f, B:10:0x0025, B:11:0x0029, B:13:0x002f, B:16:0x003f, B:18:0x0049, B:20:0x004f, B:21:0x0057, B:23:0x005d, B:25:0x0065, B:27:0x0071), top: B:66:0x0009, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:57:0x00ef  */
    /* JADX WARN: Code duplicated, block: B:60:0x00f6 A[Catch: Exception -> 0x007d, TRY_LEAVE, TryCatch #0 {Exception -> 0x007d, blocks: (B:34:0x0080, B:36:0x0086, B:38:0x0093, B:40:0x009d, B:45:0x00b6, B:48:0x00c2, B:50:0x00c8, B:51:0x00d5, B:53:0x00db, B:55:0x00ea, B:58:0x00f1, B:60:0x00f6, B:37:0x008f, B:29:0x0075, B:31:0x0079, B:4:0x000b, B:6:0x0017, B:8:0x001f, B:10:0x0025, B:11:0x0029, B:13:0x002f, B:16:0x003f, B:18:0x0049, B:20:0x004f, B:21:0x0057, B:23:0x005d, B:25:0x0065, B:27:0x0071), top: B:66:0x0009, inners: #1 }] */
    private com.mbridge.msdk.foundation.same.report.d.b b(boolean z11, String str, com.mbridge.msdk.foundation.same.report.d.d dVar) {
        List<String> listE;
        String strA;
        String str2;
        com.mbridge.msdk.foundation.same.report.d.b bVar;
        com.mbridge.msdk.foundation.same.report.d.b bVar2 = new com.mbridge.msdk.foundation.same.report.d.b();
        try {
            if (z11) {
                try {
                    f fVarA = f.a(h.a(this.f46795l));
                    if (fVarA != null && (listE = fVarA.e(this.f46802s)) != null && listE.size() > 0) {
                        Iterator<String> it = listE.iterator();
                        while (it.hasNext()) {
                            com.mbridge.msdk.foundation.same.report.d.c.a().c(it.next());
                        }
                    }
                    LinkedHashMap<String, com.mbridge.msdk.foundation.same.report.d.b> linkedHashMapB = com.mbridge.msdk.foundation.same.report.d.c.a().b();
                    if (linkedHashMapB == null || linkedHashMapB.size() <= 0) {
                        if (TextUtils.isEmpty(str)) {
                            strA = SameMD5.getMD5(ai.d());
                        } else {
                            strA = a(str);
                        }
                        bVar2 = com.mbridge.msdk.foundation.same.report.d.c.a().b(strA);
                        if (bVar2 == null) {
                            bVar = new com.mbridge.msdk.foundation.same.report.d.b();
                            try {
                                com.mbridge.msdk.foundation.same.report.d.c.a().b().put(strA, bVar);
                                bVar.d(true);
                                bVar2 = bVar;
                            } catch (Exception e11) {
                                e = e11;
                                bVar2 = bVar;
                                if (MBridgeConstans.DEBUG) {
                                    ad.b("RewardVideoController", e.getMessage());
                                }
                            }
                        }
                        bVar2.c(strA);
                        bVar2.d(this.f46802s);
                        if (dVar != null) {
                            if (dVar.a("adtp")) {
                                bVar2.b(Integer.parseInt((String) dVar.b("adtp")));
                            }
                            if (dVar.a(CampaignEx.JSON_KEY_HB)) {
                                str2 = (String) dVar.b(CampaignEx.JSON_KEY_HB);
                                bVar2.i(str2);
                                if (str2.equals("1")) {
                                    bVar2.e(str);
                                }
                            }
                        }
                        bVar2.b(z11 ? "2" : "1");
                        if (z11) {
                            com.mbridge.msdk.reward.c.a.a.a().a("2000123", bVar2);
                        }
                    } else {
                        Iterator<Map.Entry<String, com.mbridge.msdk.foundation.same.report.d.b>> it2 = linkedHashMapB.entrySet().iterator();
                        while (it2.hasNext()) {
                            Map.Entry<String, com.mbridge.msdk.foundation.same.report.d.b> next = it2.next();
                            if (next != null && next.getValue().s()) {
                                it2.remove();
                            }
                        }
                        if (TextUtils.isEmpty(str)) {
                            strA = SameMD5.getMD5(ai.d());
                        } else {
                            strA = a(str);
                        }
                        bVar2 = com.mbridge.msdk.foundation.same.report.d.c.a().b(strA);
                        if (bVar2 == null) {
                            bVar = new com.mbridge.msdk.foundation.same.report.d.b();
                            com.mbridge.msdk.foundation.same.report.d.c.a().b().put(strA, bVar);
                            bVar.d(true);
                            bVar2 = bVar;
                        }
                        bVar2.c(strA);
                        bVar2.d(this.f46802s);
                        if (dVar != null) {
                            if (dVar.a("adtp")) {
                                bVar2.b(Integer.parseInt((String) dVar.b("adtp")));
                            }
                            if (dVar.a(CampaignEx.JSON_KEY_HB)) {
                                str2 = (String) dVar.b(CampaignEx.JSON_KEY_HB);
                                bVar2.i(str2);
                                if (str2.equals("1")) {
                                    bVar2.e(str);
                                }
                            }
                        }
                        bVar2.b(z11 ? "2" : "1");
                        if (z11) {
                            com.mbridge.msdk.reward.c.a.a.a().a("2000123", bVar2);
                        }
                    }
                } catch (Exception e12) {
                    if (MBridgeConstans.DEBUG) {
                        e12.printStackTrace();
                    }
                }
            } else {
                if (TextUtils.isEmpty(str)) {
                    strA = SameMD5.getMD5(ai.d());
                } else {
                    strA = a(str);
                }
                bVar2 = com.mbridge.msdk.foundation.same.report.d.c.a().b(strA);
                if (bVar2 == null) {
                    bVar = new com.mbridge.msdk.foundation.same.report.d.b();
                    com.mbridge.msdk.foundation.same.report.d.c.a().b().put(strA, bVar);
                    bVar.d(true);
                    bVar2 = bVar;
                }
                bVar2.c(strA);
                bVar2.d(this.f46802s);
                if (dVar != null) {
                    if (dVar.a("adtp")) {
                        bVar2.b(Integer.parseInt((String) dVar.b("adtp")));
                    }
                    if (dVar.a(CampaignEx.JSON_KEY_HB)) {
                        str2 = (String) dVar.b(CampaignEx.JSON_KEY_HB);
                        bVar2.i(str2);
                        if (str2.equals("1")) {
                            bVar2.e(str);
                        }
                    }
                }
                bVar2.b(z11 ? "2" : "1");
                if (z11) {
                    com.mbridge.msdk.reward.c.a.a.a().a("2000123", bVar2);
                }
            }
        } catch (Exception e13) {
            e = e13;
        }
        return bVar2;
    }

    private void b(com.mbridge.msdk.foundation.same.report.d.b bVar) {
        if (this.f46800q != null) {
            com.mbridge.msdk.foundation.c.b bVarB = com.mbridge.msdk.foundation.c.a.b(880035, "");
            if (bVar != null) {
                bVar.a(bVarB);
                bVar.c(true);
            }
            c.a(this.f46800q, "bidToken is empty", bVar);
        }
    }

    private boolean c(String str, String str2) {
        try {
            com.mbridge.msdk.reward.adapter.c cVar = this.f46796m;
            if (cVar == null || !str.equals(cVar.a())) {
                com.mbridge.msdk.reward.adapter.c cVar2 = new com.mbridge.msdk.reward.adapter.c(this.f46795l, this.f46805v, str);
                this.f46796m = cVar2;
                cVar2.b(this.D);
                this.f46796m.c(this.E);
            }
            this.f46796m.a(this.f46809z);
            this.f46796m.a(this.f46797n);
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                ad.b("RewardVideoController", e11.getMessage());
            }
        }
        List<CampaignEx> listA = com.mbridge.msdk.videocommon.a.a.a().a(str, 1, this.E);
        this.f46788aa = com.mbridge.msdk.videocommon.a.a.a().b(str, 1, this.E);
        if (listA == null || listA.size() <= 0) {
            CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList = this.Z;
            if (copyOnWriteArrayList == null) {
                return false;
            }
            copyOnWriteArrayList.clear();
            return false;
        }
        com.mbridge.msdk.videocommon.a.a.a().a(str, listA, str2);
        CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList2 = this.Z;
        if (copyOnWriteArrayList2 == null) {
            this.Z = new CopyOnWriteArrayList<>();
        } else {
            copyOnWriteArrayList2.clear();
        }
        for (CampaignEx campaignEx : listA) {
            campaignEx.setLocalRequestId(str2);
            this.Z.add(campaignEx);
        }
        a(this.Z);
        return true;
    }

    private void d(String str, String str2) {
        try {
            com.mbridge.msdk.foundation.same.report.d.b bVar = new com.mbridge.msdk.foundation.same.report.d.b();
            bVar.d(this.f46802s);
            bVar.b(this.D ? 287 : 94);
            com.mbridge.msdk.foundation.same.report.d.d dVar = new com.mbridge.msdk.foundation.same.report.d.d();
            dVar.a("event_name", str);
            dVar.a("reason", str2);
            bVar.a("m_temp_is_ready_check", dVar);
            com.mbridge.msdk.reward.c.a.a.a().a("m_temp_is_ready_check", bVar);
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                e11.printStackTrace();
            }
        }
    }

    private boolean e(boolean z11) {
        if (z11) {
            d("is_ready_start", "");
        }
        if (this.f46796m == null) {
            r();
        }
        List<com.mbridge.msdk.foundation.entity.c> listA = com.mbridge.msdk.videocommon.a.a.a().a(this.f46802s);
        if (listA == null || listA.size() <= 0) {
            if (!z11) {
                return false;
            }
            d("is_ready_ctir_false", "no effective campaign list");
            return false;
        }
        String strB = com.mbridge.msdk.foundation.same.a.d.b(this.f46802s);
        boolean zA = TextUtils.isEmpty(strB) ? false : a(listA, strB);
        if (z11) {
            d("is_ready_ctir_" + zA, "");
        }
        if (zA) {
            return zA;
        }
        for (com.mbridge.msdk.foundation.entity.c cVar : listA) {
            if (cVar != null) {
                this.f46796m.a(cVar.a());
                this.f46796m.f46702d = cVar.d();
                if (this.f46796m.d(z11)) {
                    return true;
                }
            }
        }
        return zA;
    }

    public static void insertExcludeId(String str, CampaignEx campaignEx) {
        if (TextUtils.isEmpty(str) || campaignEx == null || com.mbridge.msdk.foundation.controller.c.m().c() == null) {
            return;
        }
        j jVarA = j.a(h.a(com.mbridge.msdk.foundation.controller.c.m().c()));
        com.mbridge.msdk.foundation.entity.f fVar = new com.mbridge.msdk.foundation.entity.f();
        fVar.a(System.currentTimeMillis());
        fVar.b(str);
        fVar.a(campaignEx.getId());
        jVarA.a(fVar);
    }

    private void p() {
        f.a(h.a(this.f46795l)).a(this.f46802s);
    }

    private void q() {
        try {
            List<CampaignEx> listB = f.a(h.a(this.f46795l)).b(this.f46802s);
            if (listB == null || listB.size() <= 0) {
                return;
            }
            for (CampaignEx campaignEx : listB) {
                if (TextUtils.isEmpty(campaignEx.getCMPTEntryUrl())) {
                    com.mbridge.msdk.videocommon.a.b(campaignEx.getAdType(), campaignEx);
                } else {
                    com.mbridge.msdk.videocommon.a.b(this.f46802s + "_" + campaignEx.getRequestId() + "_" + campaignEx.getCMPTEntryUrl());
                    if (campaignEx.getRewardTemplateMode() != null && !TextUtils.isEmpty(campaignEx.getRewardTemplateMode().e())) {
                        com.mbridge.msdk.videocommon.a.b(this.f46802s + "_" + campaignEx.getId() + "_" + campaignEx.getRequestId() + "_" + campaignEx.getRewardTemplateMode().e());
                    }
                }
            }
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                ad.b("RewardVideoController", e11.getMessage());
            }
        }
    }

    private void r() {
        com.mbridge.msdk.reward.adapter.c cVar = new com.mbridge.msdk.reward.adapter.c(this.f46795l, this.f46805v, this.f46802s);
        this.f46796m = cVar;
        cVar.b(this.D);
        this.f46796m.c(this.E);
        if (this.D) {
            this.f46796m.a(this.A, this.B, this.C);
        }
        this.f46796m.a(this.f46797n);
    }

    private boolean s() {
        try {
            if (this.R == null) {
                this.R = h.a(com.mbridge.msdk.foundation.controller.c.m().c());
            }
            i iVarA = i.a(this.R);
            if (this.f46797n == null) {
                this.f46797n = com.mbridge.msdk.videocommon.d.b.a().a(com.mbridge.msdk.foundation.controller.c.m().k(), this.f46802s, this.D);
            }
            return iVarA != null && iVarA.a(this.f46802s, this.f46797n.d());
        } catch (Throwable unused) {
            ad.b("RewardVideoController", "cap check error");
            return false;
        }
    }

    public final com.mbridge.msdk.foundation.same.report.d.b a(Message message) {
        com.mbridge.msdk.foundation.same.report.d.b bVarB = null;
        if (message != null) {
            try {
                Bundle data = message.getData();
                if (data != null) {
                    bVarB = com.mbridge.msdk.foundation.same.report.d.c.a().b(data.getString("metrics_data_lrid"));
                }
            } catch (Exception e11) {
                if (MBridgeConstans.DEBUG) {
                    e11.printStackTrace();
                }
            }
        }
        return bVarB == null ? new com.mbridge.msdk.foundation.same.report.d.b() : bVarB;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0038  */
    /* JADX WARN: Code duplicated, block: B:16:0x003f A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:17:0x0040 A[Catch: Exception -> 0x002b, TryCatch #0 {Exception -> 0x002b, blocks: (B:4:0x0009, B:6:0x000f, B:8:0x0016, B:12:0x002f, B:14:0x0039, B:17:0x0040, B:21:0x0075, B:23:0x0088, B:25:0x0096), top: B:31:0x0009 }] */
    /* JADX WARN: Code duplicated, block: B:19:0x0070  */
    /* JADX WARN: Code duplicated, block: B:20:0x0073  */
    public final com.mbridge.msdk.foundation.same.report.d.b a(List<CampaignEx> list, com.mbridge.msdk.foundation.same.report.d.b bVar) {
        String nLRid;
        String str;
        int i11;
        com.mbridge.msdk.foundation.same.report.d.b bVar2 = new com.mbridge.msdk.foundation.same.report.d.b();
        String localRequestId = "";
        if (list != null) {
            try {
                if (list.size() > 0) {
                    if (list.get(0) != null) {
                        localRequestId = list.get(0).getLocalRequestId();
                        nLRid = list.get(0).getNLRid();
                    } else {
                        nLRid = "";
                    }
                    bVar2.c(localRequestId);
                    bVar2.b(list);
                    str = localRequestId;
                    localRequestId = nLRid;
                } else {
                    str = "";
                }
                if (TextUtils.isEmpty(localRequestId)) {
                    return bVar;
                }
                com.mbridge.msdk.foundation.same.report.d.d dVar = new com.mbridge.msdk.foundation.same.report.d.d();
                dVar.a("cache", 1);
                dVar.a(CampaignEx.JSON_KEY_HB, 1);
                dVar.a("auto_load", 2);
                bVar2.a("2000127", dVar);
                bVar2.a("2000048", dVar);
                if (this.D) {
                    i11 = 287;
                } else {
                    i11 = 94;
                }
                bVar2.b(i11);
                bVar2.i("1");
                bVar2.b("2");
                if (!TextUtils.isEmpty(str) && !com.mbridge.msdk.foundation.same.report.d.c.a().b().containsKey(str)) {
                    com.mbridge.msdk.foundation.same.report.d.c.a().b().put(str, bVar2);
                }
            } catch (Exception e11) {
                if (MBridgeConstans.DEBUG) {
                    e11.printStackTrace();
                }
            }
        } else {
            str = "";
            if (TextUtils.isEmpty(localRequestId)) {
                return bVar;
            }
            com.mbridge.msdk.foundation.same.report.d.d dVar2 = new com.mbridge.msdk.foundation.same.report.d.d();
            dVar2.a("cache", 1);
            dVar2.a(CampaignEx.JSON_KEY_HB, 1);
            dVar2.a("auto_load", 2);
            bVar2.a("2000127", dVar2);
            bVar2.a("2000048", dVar2);
            if (this.D) {
                i11 = 287;
            } else {
                i11 = 94;
            }
            bVar2.b(i11);
            bVar2.i("1");
            bVar2.b("2");
            if (!TextUtils.isEmpty(str)) {
                com.mbridge.msdk.foundation.same.report.d.c.a().b().put(str, bVar2);
            }
        }
        return bVar2;
    }

    public final String a() {
        com.mbridge.msdk.reward.adapter.c cVar = this.f46796m;
        return cVar != null ? cVar.a(this.K) : "";
    }

    public final void a(int i11) {
        this.f46809z = i11;
    }

    public final void a(int i11, int i12, int i13) {
        this.A = i11;
        this.B = i12;
        if (i12 == com.mbridge.msdk.foundation.same.a.J) {
            this.C = i13 < 0 ? 5 : i13;
        }
        if (i12 == com.mbridge.msdk.foundation.same.a.I) {
            this.C = i13 < 0 ? 80 : i13;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ivRewardEnable", 1);
            jSONObject.put("ivRewardMode", i11 == com.mbridge.msdk.foundation.same.a.G ? 0 : 1);
            jSONObject.put("ivRewardPlayValueMode", i12 == com.mbridge.msdk.foundation.same.a.I ? 0 : 1);
            jSONObject.put("ivRewardPlayValue", i13);
            com.mbridge.msdk.c.h.a().f(this.f46802s, jSONObject.toString());
        } catch (Exception unused) {
            ad.b("RewardVideoController", "setIVRewardEnable to SP was ERROR");
        }
    }

    public final void a(InterVideoOutListener interVideoOutListener) {
        this.f46799p = interVideoOutListener;
        this.f46800q = new c(interVideoOutListener, this.f46808y, this.f46802s);
    }

    /* JADX WARN: Code duplicated, block: B:127:0x01d8  */
    /* JADX WARN: Code duplicated, block: B:160:0x01ee A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public final void a(String str, String str2, String str3, com.mbridge.msdk.foundation.same.report.d.d dVar) {
        com.mbridge.msdk.videocommon.d.c cVar;
        com.mbridge.msdk.videocommon.d.c cVar2;
        com.mbridge.msdk.videocommon.d.c cVar3;
        com.mbridge.msdk.videocommon.d.c cVar4;
        com.mbridge.msdk.foundation.same.report.d.b bVarA = a(dVar);
        try {
            this.f46806w = str;
            this.f46801r = str2;
            this.f46804u = str3;
            synchronized (this.L) {
                if (this.f46789c) {
                    a("2000131", bVarA, this.f46799p, "campaing is show progressing ");
                    if (this.f46799p != null) {
                        try {
                            this.f46799p.onShowFail(bVarA, this.f46803t, "campaing is show progressing ");
                        } catch (Exception e11) {
                            if (MBridgeConstans.DEBUG) {
                                ad.b("RewardVideoController", e11.getMessage());
                            }
                        }
                    }
                    return;
                }
                this.f46789c = true;
                Context context = this.f46795l;
                if (context == null) {
                    a("2000131", bVarA, this.f46799p, "context is null");
                    if (this.f46799p != null) {
                        try {
                            this.f46799p.onShowFail(bVarA, this.f46803t, "context is null");
                        } catch (Exception e12) {
                            if (MBridgeConstans.DEBUG) {
                                ad.b("RewardVideoController", e12.getMessage());
                            }
                        }
                    }
                    if (!this.D && !this.E && (cVar4 = this.f46797n) != null && cVar4.s(4) && this.f46800q != null && c.a(this.f46800q) != 1 && c.a(this.f46800q) != 3) {
                        a(false, com.mbridge.msdk.foundation.same.report.d.c.a().a(0, 94, this.f46802s, true, 1));
                    }
                    this.f46789c = false;
                    return;
                }
                if (this.D && !ai.k(context)) {
                    a("2000131", bVarA, this.f46799p, "network exception");
                    if (this.f46799p != null) {
                        try {
                            this.f46799p.onShowFail(bVarA, this.f46803t, "network exception");
                        } catch (Exception e13) {
                            if (MBridgeConstans.DEBUG) {
                                ad.b("RewardVideoController", e13.getMessage());
                            }
                        }
                    }
                    if (!this.D && !this.E && (cVar3 = this.f46797n) != null && cVar3.s(4) && this.f46800q != null && c.a(this.f46800q) != 1 && c.a(this.f46800q) != 3) {
                        a(false, com.mbridge.msdk.foundation.same.report.d.c.a().a(0, 94, this.f46802s, true, 1));
                    }
                    this.f46789c = false;
                    return;
                }
                if (!s()) {
                    if (TextUtils.isEmpty(this.f46801r)) {
                        this.f46801r = e.c();
                    }
                    try {
                        String str4 = new SimpleDateFormat("dd").format(new Date());
                        String str5 = (String) al.a(this.f46795l, "reward_date", "0");
                        if (!TextUtils.isEmpty(str5) && !TextUtils.isEmpty(str4) && !str5.equals(str4)) {
                            al.b(this.f46795l, "reward_date", str4);
                        }
                    } catch (Exception e14) {
                        if (MBridgeConstans.DEBUG) {
                            ad.b("RewardVideoController", e14.getMessage());
                        }
                    }
                    a(str, bVarA);
                    return;
                }
                a("2000131", bVarA, this.f46799p, "Play more than limit");
                if (this.f46799p != null) {
                    try {
                        this.f46799p.onShowFail(bVarA, this.f46803t, "Play more than limit");
                    } catch (Exception e15) {
                        if (MBridgeConstans.DEBUG) {
                            ad.b("RewardVideoController", e15.getMessage());
                        }
                    }
                }
                if (!this.D && !this.E && (cVar2 = this.f46797n) != null && cVar2.s(4) && this.f46800q != null && c.a(this.f46800q) != 1 && c.a(this.f46800q) != 3) {
                    a(false, com.mbridge.msdk.foundation.same.report.d.c.a().a(0, 94, this.f46802s, true, 1));
                }
                this.f46789c = false;
                return;
                this.f46789c = false;
                if (MBridgeConstans.DEBUG) {
                    ad.b("RewardVideoController", e.getLocalizedMessage());
                }
                a("2000131", bVarA, this.f46799p, "show exception");
                if (this.f46799p != null) {
                    try {
                        this.f46799p.onShowFail(bVarA, this.f46803t, "show exception");
                    } catch (Exception unused) {
                        if (MBridgeConstans.DEBUG) {
                            ad.b("RewardVideoController", e.getMessage());
                        }
                    }
                }
                if (!this.D || this.E || (cVar = this.f46797n) == null || !cVar.s(4) || this.f46800q == null || c.a(this.f46800q) == 1 || c.a(this.f46800q) == 3) {
                    return;
                }
                a(false, com.mbridge.msdk.foundation.same.report.d.c.a().a(0, 94, this.f46802s, true, 1));
            }
        } catch (Exception e16) {
            this.f46789c = false;
            if (MBridgeConstans.DEBUG) {
                ad.b("RewardVideoController", e16.getLocalizedMessage());
            }
            a("2000131", bVarA, this.f46799p, "show exception");
            if (this.f46799p != null) {
                this.f46799p.onShowFail(bVarA, this.f46803t, "show exception");
            }
            if (this.D) {
            }
        }
    }

    public final void a(String str, String str2, String str3, String str4) {
        if (!TextUtils.isEmpty(str)) {
            al.b(this.f46795l, "MBridge_ConfirmTitle" + this.f46802s, str.trim());
        }
        if (!TextUtils.isEmpty(str2)) {
            al.b(this.f46795l, "MBridge_ConfirmContent" + this.f46802s, str2.trim());
        }
        if (!TextUtils.isEmpty(str4)) {
            al.b(this.f46795l, "MBridge_CancelText" + this.f46802s, str4.trim());
        }
        if (TextUtils.isEmpty(str3)) {
            return;
        }
        al.b(this.f46795l, "MBridge_ConfirmText" + this.f46802s, str3.trim());
    }

    public final void a(List<CampaignEx> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        this.M = list;
    }

    public final void a(boolean z11) {
        this.D = z11;
        if (z11) {
            this.f46809z = com.mbridge.msdk.foundation.same.a.W;
        } else {
            this.f46809z = com.mbridge.msdk.foundation.same.a.V;
        }
    }

    public final void a(boolean z11, com.mbridge.msdk.foundation.same.report.d.d dVar) {
        a(z11, "", dVar);
    }

    public final void a(boolean z11, String str, com.mbridge.msdk.foundation.same.report.d.d dVar) {
        com.mbridge.msdk.foundation.same.report.d.b bVarB = b(z11, str, dVar);
        if (this.f46800q == null) {
            this.f46800q = new c(null, this.f46808y, this.f46802s);
        }
        if (this.f46800q != null && c.a(this.f46800q) == 1) {
            a(z11, bVarB);
            return;
        }
        if (this.f46800q == null || c.a(this.f46800q) != 3) {
            this.S = true;
            if (this.f46800q != null) {
                c.a(this.f46800q, 1);
            }
        } else {
            this.S = false;
        }
        this.H = z11;
        this.f46808y.removeMessages(1001001);
        this.V = false;
        this.U = false;
        this.W = false;
        this.X = false;
        q();
        p();
        com.mbridge.msdk.reward.adapter.b.a();
        try {
            if (TextUtils.isEmpty(str)) {
                if (this.D) {
                    com.mbridge.msdk.d.b.getInstance().addInterstitialList(this.f46805v, this.f46802s);
                } else {
                    com.mbridge.msdk.d.b.getInstance().addRewardList(this.f46805v, this.f46802s);
                }
            }
            if (this.E && TextUtils.isEmpty(str)) {
                b(bVarB);
                return;
            }
            if (com.mbridge.msdk.system.a.map == null) {
                a(bVarB);
                return;
            }
            com.mbridge.msdk.videocommon.d.c cVarA = com.mbridge.msdk.videocommon.d.b.a().a(com.mbridge.msdk.foundation.controller.c.m().k(), this.f46802s);
            this.f46797n = cVarA;
            if (cVarA == null) {
                this.Q = com.mbridge.msdk.foundation.controller.c.m().k();
                com.mbridge.msdk.videocommon.d.b.a().a(this.Q, com.mbridge.msdk.foundation.controller.c.m().b(), this.f46802s, new com.mbridge.msdk.videocommon.c.c() { // from class: com.mbridge.msdk.reward.b.a.1
                    @Override // com.mbridge.msdk.videocommon.c.c
                    public final void a(String str2) {
                    }

                    @Override // com.mbridge.msdk.videocommon.c.c
                    public final void b(String str2) {
                    }
                });
                this.f46797n = com.mbridge.msdk.videocommon.d.b.a().a(com.mbridge.msdk.foundation.controller.c.m().k(), this.f46802s, this.D);
            }
            if (!TextUtils.isEmpty(this.f46805v)) {
                this.f46797n.b(this.f46805v);
            }
            int iF = this.f46797n.F() * 1000;
            if (this.f46808y != null) {
                Message messageObtain = Message.obtain();
                messageObtain.what = 1001002;
                if (bVarB != null) {
                    Bundle bundle = new Bundle();
                    bundle.putString("metrics_data_lrid", bVarB.f());
                    messageObtain.setData(bundle);
                }
                this.f46808y.sendMessageDelayed(messageObtain, iF);
            }
            this.P = this.f46797n.B();
            try {
                a(z11, str, bVarB);
            } catch (Exception e11) {
                if (this.f46800q != null) {
                    com.mbridge.msdk.foundation.c.b bVarB2 = com.mbridge.msdk.foundation.c.a.b(880020, "load exception");
                    if (bVarB != null) {
                        bVarB.a(bVarB2);
                        bVarB.c(true);
                    }
                    this.f46800q.a(bVarB2, bVarB);
                }
                if (MBridgeConstans.DEBUG) {
                    ad.b("RewardVideoController", e11.getMessage());
                }
            }
        } catch (Exception e12) {
            if (this.f46800q != null) {
                com.mbridge.msdk.foundation.c.b bVarB3 = com.mbridge.msdk.foundation.c.a.b(880001, "");
                if (bVarB != null) {
                    bVarB.a(bVarB3);
                    bVarB.c(true);
                }
                this.f46800q.a(bVarB3, bVarB);
            }
            if (MBridgeConstans.DEBUG) {
                ad.b("RewardVideoController", e12.getMessage());
            }
        }
    }

    public final void b() {
        ConcurrentHashMap<String, String> concurrentHashMap;
        if (!this.K || (concurrentHashMap = O) == null || concurrentHashMap.containsKey(a())) {
            return;
        }
        O.remove(a());
    }

    public final void b(String str, String str2) {
        try {
            this.f46795l = com.mbridge.msdk.foundation.controller.c.m().c();
            this.f46802s = str2;
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            this.f46805v = str;
            this.f46803t = new MBridgeIds(this.f46805v, this.f46802s);
            this.f46798o = com.mbridge.msdk.videocommon.d.b.a().b();
            com.mbridge.msdk.foundation.same.f.b.b().execute(new com.mbridge.msdk.reward.b.c(this.f46795l, this.f46802s));
            if (this.R == null) {
                this.R = h.a(com.mbridge.msdk.foundation.controller.c.m().c());
            }
        } catch (Throwable th2) {
            ad.a("RewardVideoController", th2.getMessage(), th2);
        }
    }

    public final void b(boolean z11) {
        this.E = z11;
    }

    public final void c() {
        try {
            String str = "";
            MBridgeIds mBridgeIds = this.f46803t;
            if (mBridgeIds != null) {
                if (!this.K) {
                    mBridgeIds.setBidToken("");
                    return;
                }
                String strA = a();
                if (TextUtils.isEmpty(strA)) {
                    return;
                }
                ConcurrentHashMap<String, String> concurrentHashMap = O;
                if (concurrentHashMap != null && concurrentHashMap.containsKey(strA) && !TextUtils.isEmpty(O.get(strA))) {
                    str = O.get(strA);
                }
                this.f46803t.setBidToken(str);
            }
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                e11.printStackTrace();
            }
        }
    }

    public final void c(boolean z11) {
        this.I = z11;
    }

    public final String d() {
        com.mbridge.msdk.reward.adapter.c cVar = this.f46796m;
        return cVar != null ? cVar.f() : "";
    }

    public final boolean d(boolean z11) {
        try {
            if (s()) {
                if (!z11) {
                    return false;
                }
                d("is_ready_start", "over cap check error");
                return false;
            }
            if (this.E) {
                try {
                    return e(z11);
                } catch (Exception e11) {
                    if (!MBridgeConstans.DEBUG) {
                        return false;
                    }
                    ad.b("RewardVideoController", e11.getMessage());
                    return false;
                }
            }
            if (this.f46796m == null) {
                r();
            }
            com.mbridge.msdk.reward.adapter.c cVar = this.f46796m;
            if (cVar != null) {
                return cVar.b();
            }
            return false;
        } catch (Throwable th2) {
            if (!MBridgeConstans.DEBUG) {
                return false;
            }
            ad.b("RewardVideoController", th2.getMessage());
            return false;
        }
    }

    public final CopyOnWriteArrayList<CampaignEx> e() {
        return this.Z;
    }

    public final List<CampaignEx> f() {
        return this.f46788aa;
    }

    public final com.mbridge.msdk.reward.adapter.c g() {
        return this.f46796m;
    }

    public final boolean h() {
        return this.H;
    }

    public final String i() {
        return this.f46802s;
    }

    public final String j() {
        return this.f46805v;
    }

    public final c k() {
        return this.f46800q;
    }

    public final InterVideoOutListener l() {
        return this.f46799p;
    }

    public final boolean m() {
        return this.E;
    }

    public final MBridgeIds n() {
        return this.f46803t;
    }

    public final boolean o() {
        return this.D;
    }
}
