package com.mbridge.msdk.reward.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.hisavana.common.tracking.TrackingKey;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.c.i;
import com.mbridge.msdk.f.e;
import com.mbridge.msdk.foundation.db.f;
import com.mbridge.msdk.foundation.db.j;
import com.mbridge.msdk.foundation.db.k;
import com.mbridge.msdk.foundation.download.download.H5DownLoadManager;
import com.mbridge.msdk.foundation.download.download.ResDownloadCheckManager;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.CampaignUnit;
import com.mbridge.msdk.foundation.entity.g;
import com.mbridge.msdk.foundation.same.report.m;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.foundation.tools.ai;
import com.mbridge.msdk.foundation.tools.an;
import com.mbridge.msdk.reward.player.MBRewardVideoActivity;
import com.mbridge.msdk.video.bt.module.b.h;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;
import org.mvel2.ast.ASTNode;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class c {
    private boolean A;
    private String C;
    private int D;
    private int E;
    private int F;
    private CampaignUnit G;
    private CopyOnWriteArrayList<CampaignEx> H;
    private String K;
    private a L;
    private List<CampaignEx> S;
    private CopyOnWriteArrayList<CampaignEx> T;
    private List<CampaignEx> U;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private Context f46709k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private String f46710l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private String f46711m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f46712n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f46713o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f46714p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f46715q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private String f46716r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private h f46717s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private volatile com.mbridge.msdk.reward.adapter.a f46718t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private com.mbridge.msdk.videocommon.d.c f46719u;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private boolean f46724z;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private boolean f46720v = false;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private boolean f46721w = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object f46699a = new Object();

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private CopyOnWriteArrayList<CampaignEx> f46722x = new CopyOnWriteArrayList<>();

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private int f46723y = 2;
    private String B = "";
    private boolean I = false;
    private long J = 0;
    private boolean M = false;
    private boolean N = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f46700b = "";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f46701c = "";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f46702d = "";
    private Handler O = new Handler(Looper.getMainLooper()) { // from class: com.mbridge.msdk.reward.adapter.c.1
        /* JADX WARN: Code duplicated, block: B:93:0x025b  */
        /* JADX WARN: Code duplicated, block: B:94:0x025d  */
        /* JADX WARN: Code duplicated, block: B:98:0x028d  */
        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            boolean z11;
            CampaignEx campaignEx;
            com.mbridge.msdk.foundation.same.report.d.b bVarA = c.this.a(message);
            try {
                try {
                    switch (message.what) {
                        case 1:
                        case 2:
                            c.this.a((String) message.obj, bVarA);
                            break;
                        case 3:
                            if (c.this.f46718t != null) {
                                c.this.f46718t.a("campaign is ok", bVarA);
                            }
                            Message message2 = new Message();
                            message2.what = 5;
                            if (bVarA != null) {
                                Bundle bundle = new Bundle();
                                bundle.putString("metrics_data_lrid", bVarA.f());
                                message2.setData(bundle);
                            }
                            sendMessageDelayed(message2, com.mbridge.msdk.foundation.same.a.K);
                            break;
                        case 4:
                            if (c.this.f46718t != null) {
                                c cVar = c.this;
                                c.a(cVar, cVar.f46710l, c.this.S, c.this.A, "");
                                try {
                                    com.mbridge.msdk.foundation.c.b bVarB = com.mbridge.msdk.foundation.c.a.b(880002, "unknow error in load failed");
                                    Object obj = message.obj;
                                    if (obj == null) {
                                        if (c.this.O != null) {
                                            c.this.O.removeMessages(5);
                                        }
                                        removeMessages(6);
                                        ad.a("RewardMVVideoAdapter", "=====================onVideoLoadFail=====================00000");
                                        if (!c.this.f46707i) {
                                            c.this.f46707i = true;
                                            bVarB = com.mbridge.msdk.foundation.c.a.b(880002, "errorCode: 3506 errorMessage: data load failed");
                                        }
                                    } else {
                                        String str = (String) obj;
                                        int i11 = message.arg1;
                                        if (TextUtils.isEmpty(str)) {
                                            if (c.this.O != null) {
                                                c.this.O.removeMessages(5);
                                            }
                                            removeMessages(6);
                                            ad.a("RewardMVVideoAdapter", "=====================onVideoLoadFail=====================11111");
                                            if (!c.this.f46707i) {
                                                c.this.f46707i = true;
                                                bVarB = com.mbridge.msdk.foundation.c.a.b(880002, "errorCode: 3507 errorMessage: data load failed, errorMsg null");
                                            }
                                        } else {
                                            if (c.this.O != null) {
                                                c.this.O.removeMessages(5);
                                            }
                                            removeMessages(6);
                                            if (i11 == 880021) {
                                                bVarB = com.mbridge.msdk.foundation.c.a.b(880021, "errorCode: 3507 errorMessage: data load failed, errorMsg is APP ALREADY INSTALLED");
                                            } else if (i11 == 880003 || i11 == 6 || i11 == 7) {
                                                bVarB = com.mbridge.msdk.foundation.c.a.b(880003, "errorCode: 3507 errorMessage: data load failed, errorMsg is " + str);
                                            } else {
                                                bVarB = com.mbridge.msdk.foundation.c.a.b(880002, "errorCode: 3507 errorMessage: data load failed, errorMsg is " + str);
                                            }
                                            bVarB.a(i11);
                                        }
                                    }
                                    c.this.f46707i = true;
                                    if (bVarA != null) {
                                        bVarA.b(c.this.S);
                                        if (bVarA.o() == null) {
                                            bVarA.a(bVarB);
                                        } else {
                                            bVarB = bVarA.o();
                                        }
                                    }
                                    c.this.f46718t.a(c.this.S, bVarB, bVarA);
                                } catch (Exception e11) {
                                    if (c.this.O != null) {
                                        c.this.O.removeMessages(5);
                                    }
                                    removeMessages(6);
                                    c cVar2 = c.this;
                                    c.a(cVar2, cVar2.f46710l, c.this.S, c.this.A, "");
                                    com.mbridge.msdk.foundation.c.b bVarB2 = com.mbridge.msdk.foundation.c.a.b(880002, "errorCode: 3508 errorMessage: data load failed, exception is: " + e11.getMessage());
                                    if (bVarA != null) {
                                        bVarA.b(c.this.S);
                                        bVarA.a(bVarB2);
                                    }
                                    c.this.f46718t.a(c.this.S, bVarB2, bVarA);
                                    return;
                                }
                            }
                            break;
                        case 5:
                            if (c.this.f46718t != null) {
                                if (c.this.S != null && c.this.S.size() > 0) {
                                    CampaignEx campaignEx2 = (CampaignEx) c.this.S.get(0);
                                    boolean z12 = !TextUtils.isEmpty(campaignEx2.getCMPTEntryUrl());
                                    int nscpt = campaignEx2.getNscpt();
                                    c cVar3 = c.this;
                                    if (cVar3.a((List<CampaignEx>) cVar3.H, z12, nscpt, true, false)) {
                                        c cVar4 = c.this;
                                        c.a(cVar4, cVar4.f46710l, c.this.S, c.this.U, c.this.A);
                                        sendEmptyMessage(6);
                                        removeMessages(5);
                                        if (!c.this.f46706h) {
                                            c.this.f46706h = true;
                                            c.this.f46718t.a(c.this.H, bVarA);
                                        }
                                    }
                                }
                                c cVar5 = c.this;
                                c.a(cVar5, cVar5.f46710l, c.this.S, c.this.A, "");
                                if (c.this.O != null) {
                                    c.this.O.removeMessages(5);
                                    c.this.O.removeMessages(6);
                                }
                                CampaignEx campaignEx3 = (c.this.S == null || c.this.S.size() <= 0) ? null : (CampaignEx) c.this.S.get(0);
                                if (campaignEx3 == null && c.this.T != null && c.this.T.size() > 0) {
                                    campaignEx3 = (CampaignEx) c.this.T.get(0);
                                }
                                if (!c.this.f46707i || (c.this.f46708j && campaignEx3 != null && !TextUtils.isEmpty(campaignEx3.getNLRid()))) {
                                    com.mbridge.msdk.foundation.c.b bVarB3 = com.mbridge.msdk.foundation.c.a.b(880010, "errorCode: 3401 errorMessage: resource load timeout");
                                    c.this.f46707i = true;
                                    if (bVarA != null) {
                                        bVarA.a(bVarB3);
                                    }
                                    c.this.f46718t.a(c.this.S, bVarB3, bVarA);
                                    if (c.this.H != null && c.this.H.size() > 0) {
                                        boolean z13 = false;
                                        for (CampaignEx campaignEx4 : c.this.H) {
                                            if (campaignEx4 != null) {
                                                try {
                                                    if (!TextUtils.isEmpty(campaignEx4.getVideoUrlEncode()) && !ResDownloadCheckManager.getInstance().containsVideoKey(campaignEx4.getVideoUrlEncode())) {
                                                        z11 = true;
                                                    }
                                                    if (campaignEx4 != null && !TextUtils.isEmpty(campaignEx4.getendcard_url()) && !ResDownloadCheckManager.getInstance().containsZipKey(campaignEx4.getendcard_url())) {
                                                        z11 = true;
                                                    }
                                                    if (campaignEx4 != null && !TextUtils.isEmpty(campaignEx4.getCMPTEntryUrl())) {
                                                        if (!ResDownloadCheckManager.getInstance().containsZipKey(campaignEx4.getCMPTEntryUrl())) {
                                                            z11 = true;
                                                        } else if (!z13 && !z11) {
                                                            if (com.mbridge.msdk.videocommon.a.a(c.this.f46710l + "_" + campaignEx4.getRequestId() + "_" + campaignEx4.getCMPTEntryUrl()) == null) {
                                                                z13 = true;
                                                            }
                                                        }
                                                    }
                                                    if (campaignEx4 != null && campaignEx4.getRewardTemplateMode() != null && !TextUtils.isEmpty(campaignEx4.getRewardTemplateMode().e()) && !campaignEx4.getRewardTemplateMode().e().contains(CampaignEx.KEY_IS_CMPT_ENTRY) && ResDownloadCheckManager.getInstance().containsZipKey(campaignEx4.getRewardTemplateMode().e()) && TextUtils.isEmpty(campaignEx4.getCMPTEntryUrl()) && !z11) {
                                                        com.mbridge.msdk.videocommon.a.a(campaignEx4.getAdType(), campaignEx4);
                                                    }
                                                } catch (Exception e12) {
                                                    if (MBridgeConstans.DEBUG) {
                                                        ad.b("RewardMVVideoAdapter", e12.getMessage());
                                                    }
                                                }
                                            }
                                            z11 = false;
                                            if (campaignEx4 != null) {
                                                z11 = true;
                                            }
                                            if (campaignEx4 != null) {
                                                if (!ResDownloadCheckManager.getInstance().containsZipKey(campaignEx4.getCMPTEntryUrl())) {
                                                    z11 = true;
                                                } else if (!z13) {
                                                    if (com.mbridge.msdk.videocommon.a.a(c.this.f46710l + "_" + campaignEx4.getRequestId() + "_" + campaignEx4.getCMPTEntryUrl()) == null) {
                                                        z13 = true;
                                                    }
                                                }
                                            }
                                            if (campaignEx4 != null) {
                                                com.mbridge.msdk.videocommon.a.a(campaignEx4.getAdType(), campaignEx4);
                                            }
                                        }
                                        break;
                                    }
                                }
                            }
                            break;
                        case 6:
                            c cVar6 = c.this;
                            c.a(cVar6, cVar6.f46710l, c.this.S, c.this.U, c.this.A);
                            if (c.this.f46718t != null) {
                                removeMessages(6);
                                if (c.this.O != null) {
                                    c.this.O.removeMessages(5);
                                }
                                if (c.this.f46718t != null && !c.this.f46706h) {
                                    c.this.f46706h = true;
                                    c.this.f46718t.a(c.this.H, bVarA);
                                    break;
                                }
                            }
                            break;
                        case 8:
                            if (c.this.f46718t != null && (campaignEx = (CampaignEx) message.obj) != null && !TextUtils.isEmpty(c.this.f46710l)) {
                                com.mbridge.msdk.reward.c.a.a(c.this.f46709k, campaignEx, c.this.f46710l);
                                c.this.b();
                                break;
                            }
                            break;
                    }
                } catch (Exception e13) {
                    e13.printStackTrace();
                }
            } catch (Throwable th2) {
                ad.a("RewardMVVideoAdapter", th2.getMessage());
            }
        }
    };
    private boolean P = false;
    private long Q = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    volatile boolean f46703e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    volatile boolean f46704f = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    volatile boolean f46705g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    volatile boolean f46706h = false;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    volatile boolean f46707i = false;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public volatile boolean f46708j = false;
    private String R = "";

    /* JADX INFO: renamed from: com.mbridge.msdk.reward.adapter.c$3, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    public class AnonymousClass3 implements com.mbridge.msdk.reward.adapter.b.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        com.mbridge.msdk.foundation.same.report.d.b f46728a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ CampaignEx f46729b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f46730c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f46731d;

        public AnonymousClass3(CampaignEx campaignEx, boolean z11, int i11) {
            this.f46729b = campaignEx;
            this.f46730c = z11;
            this.f46731d = i11;
            this.f46728a = com.mbridge.msdk.foundation.same.report.d.c.a().b().get(campaignEx.getLocalRequestId());
        }

        @Override // com.mbridge.msdk.reward.adapter.b.c
        public final void a(final String str, final String str2, final String str3, final CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList) {
            c.this.f46703e = true;
            if (this.f46730c) {
                if (!c.this.f46704f || c.this.f46705g || c.this.O == null) {
                    return;
                }
                synchronized (c.this.f46699a) {
                    try {
                        if (c.this.f46705g) {
                            return;
                        }
                        c.this.f46705g = true;
                        c.this.O.post(new Runnable() { // from class: com.mbridge.msdk.reward.adapter.c.3.2
                            @Override // java.lang.Runnable
                            public final void run() {
                                com.mbridge.msdk.reward.adapter.b bVar = com.mbridge.msdk.reward.adapter.b.m.f46698a;
                                boolean z11 = c.this.I;
                                Handler handler = c.this.O;
                                boolean z12 = c.this.f46724z;
                                boolean z13 = c.this.A;
                                String str4 = str3;
                                String requestIdNotice = AnonymousClass3.this.f46729b.getRequestIdNotice();
                                String str5 = c.this.f46711m;
                                String str6 = str2;
                                String cMPTEntryUrl = AnonymousClass3.this.f46729b.getCMPTEntryUrl();
                                int i11 = c.this.f46723y;
                                AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                                bVar.a(z11, handler, z12, z13, str4, requestIdNotice, str5, str6, cMPTEntryUrl, i11, anonymousClass3.f46729b, c.this.H, H5DownLoadManager.getInstance().getH5ResAddress(AnonymousClass3.this.f46729b.getCMPTEntryUrl()), str2, c.this.f46719u, new com.mbridge.msdk.reward.adapter.b.j() { // from class: com.mbridge.msdk.reward.adapter.c.3.2.1
                                    @Override // com.mbridge.msdk.reward.adapter.b.j
                                    public final void a(String str7, String str8, String str9, com.mbridge.msdk.videocommon.a.C0532a c0532a, com.mbridge.msdk.foundation.c.b bVar2) {
                                        if (bVar2 != null) {
                                            bVar2.a("his_reason", "errorCode: 3303 errorMessage: tpl temp preload failed");
                                        }
                                        if (AnonymousClass3.this.f46729b.getRsIgnoreCheckRule() != null && AnonymousClass3.this.f46729b.getRsIgnoreCheckRule().size() > 0 && AnonymousClass3.this.f46729b.getRsIgnoreCheckRule().contains(3)) {
                                            ad.c("RewardMVVideoAdapter", "template download fail but hit ignoreCheckRule");
                                            return;
                                        }
                                        AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                                        c cVar = c.this;
                                        c.a(cVar, str2, cVar.S, c.this.A, str8);
                                        if (c.this.O != null) {
                                            c.this.O.removeMessages(5);
                                        }
                                        if (c.this.f46718t == null || c.this.f46707i) {
                                            return;
                                        }
                                        c.this.f46707i = true;
                                        AnonymousClass3 anonymousClass4 = AnonymousClass3.this;
                                        if (anonymousClass4.f46728a == null) {
                                            anonymousClass4.f46728a = new com.mbridge.msdk.foundation.same.report.d.b();
                                        }
                                        AnonymousClass3 anonymousClass5 = AnonymousClass3.this;
                                        anonymousClass5.f46728a.b(c.this.H);
                                        AnonymousClass3.this.f46728a.a(bVar2);
                                        c.this.f46718t.a(c.this.S, bVar2, AnonymousClass3.this.f46728a);
                                        ad.a("RewardMVVideoAdapter", "Campaign 下载成功： 大模板预加载失败 onVideoLoadFail");
                                    }

                                    @Override // com.mbridge.msdk.reward.adapter.b.j
                                    public final void a(String str7, String str8, String str9, String str10, String str11, com.mbridge.msdk.videocommon.a.C0532a c0532a) {
                                        c cVar = c.this;
                                        CopyOnWriteArrayList copyOnWriteArrayList2 = cVar.H;
                                        AnonymousClass3 anonymousClass4 = AnonymousClass3.this;
                                        if (cVar.a(copyOnWriteArrayList2, anonymousClass4.f46730c, anonymousClass4.f46731d)) {
                                            c cVar2 = c.this;
                                            String str12 = cVar2.f46710l;
                                            AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                                            c.a(cVar2, str12, copyOnWriteArrayList, c.this.U, c.this.A);
                                            if (c.this.O != null) {
                                                c.this.O.removeMessages(5);
                                            }
                                            if (c.this.f46718t == null || c.this.f46706h) {
                                                return;
                                            }
                                            c.this.f46706h = true;
                                            AnonymousClass3 anonymousClass5 = AnonymousClass3.this;
                                            com.mbridge.msdk.foundation.same.report.d.b bVar2 = anonymousClass5.f46728a;
                                            if (bVar2 != null) {
                                                bVar2.b(c.this.H);
                                            }
                                            c.this.f46718t.a(c.this.H, AnonymousClass3.this.f46728a);
                                            return;
                                        }
                                        c cVar3 = c.this;
                                        c.a(cVar3, str9, cVar3.S, c.this.A, str10);
                                        if (c.this.O != null) {
                                            c.this.O.removeMessages(5);
                                        }
                                        if (c.this.f46718t == null || c.this.f46707i) {
                                            return;
                                        }
                                        c.this.f46707i = true;
                                        com.mbridge.msdk.foundation.c.b bVarB = com.mbridge.msdk.foundation.c.a.b(880015, "errorCode: 3505 errorMessage: tpl temp preload success but isReady false");
                                        AnonymousClass3 anonymousClass6 = AnonymousClass3.this;
                                        if (anonymousClass6.f46728a == null) {
                                            anonymousClass6.f46728a = new com.mbridge.msdk.foundation.same.report.d.b();
                                        }
                                        AnonymousClass3 anonymousClass7 = AnonymousClass3.this;
                                        anonymousClass7.f46728a.b(c.this.H);
                                        AnonymousClass3.this.f46728a.a(bVarB);
                                        c.this.f46718t.a(c.this.S, bVarB, AnonymousClass3.this.f46728a);
                                        ad.a("RewardMVVideoAdapter", "Campaign 下载成功： 大模板预加载成功,isReady false onVideoLoadFail");
                                    }
                                }, false);
                            }
                        });
                        return;
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
            }
            for (final CampaignEx campaignEx : copyOnWriteArrayList) {
                if (campaignEx == null || campaignEx.getRewardTemplateMode() == null || TextUtils.isEmpty(campaignEx.getRewardTemplateMode().e()) || campaignEx.getRewardTemplateMode().e().contains(CampaignEx.KEY_IS_CMPT_ENTRY) || c.this.O == null) {
                    c cVar = c.this;
                    if (cVar.a(cVar.H, this.f46730c, this.f46731d)) {
                        c cVar2 = c.this;
                        c.a(cVar2, cVar2.f46710l, copyOnWriteArrayList, c.this.U, c.this.A);
                        if (c.this.O != null) {
                            c.this.O.removeMessages(5);
                        }
                        if (c.this.f46718t != null && !c.this.f46706h) {
                            c.this.f46706h = true;
                            com.mbridge.msdk.foundation.same.report.d.b bVar = this.f46728a;
                            if (bVar != null) {
                                bVar.b(c.this.H);
                            }
                            c.this.f46718t.a(c.this.H, this.f46728a);
                        }
                    } else {
                        c cVar3 = c.this;
                        c.a(cVar3, str2, cVar3.S, c.this.A, str3);
                        if (c.this.O != null) {
                            c.this.O.removeMessages(5);
                        }
                        if (c.this.f46718t != null && !c.this.f46707i) {
                            c.this.f46707i = true;
                            com.mbridge.msdk.foundation.c.b bVarB = com.mbridge.msdk.foundation.c.a.b(880015, "errorCode: 3503 errorMessage: have no temp but isReady false");
                            if (this.f46728a == null) {
                                this.f46728a = new com.mbridge.msdk.foundation.same.report.d.b();
                            }
                            this.f46728a.b(c.this.H);
                            this.f46728a.a(bVarB);
                            c.this.f46718t.a(c.this.H, bVarB, this.f46728a);
                            ad.a("RewardMVVideoAdapter", "Campaign 下载成功： 非大模板，不存在播放模板,isReay false onVideoLoadFail");
                        }
                    }
                } else {
                    c.this.O.post(new Runnable() { // from class: com.mbridge.msdk.reward.adapter.c.3.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            com.mbridge.msdk.reward.adapter.b bVar2 = com.mbridge.msdk.reward.adapter.b.m.f46698a;
                            boolean z11 = c.this.I;
                            Handler handler = c.this.O;
                            boolean z12 = c.this.f46724z;
                            boolean z13 = c.this.A;
                            String strE = campaignEx.getRewardTemplateMode().e();
                            int i11 = c.this.f46723y;
                            AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                            bVar2.a(z11, handler, z12, z13, null, strE, i11, anonymousClass3.f46729b, c.this.H, H5DownLoadManager.getInstance().getH5ResAddress(campaignEx.getRewardTemplateMode().e()), str, str2, str3, campaignEx.getRequestIdNotice(), c.this.f46719u, new com.mbridge.msdk.reward.adapter.b.j() { // from class: com.mbridge.msdk.reward.adapter.c.3.1.1
                                @Override // com.mbridge.msdk.reward.adapter.b.j
                                public final void a(String str4, String str5, String str6, com.mbridge.msdk.videocommon.a.C0532a c0532a, com.mbridge.msdk.foundation.c.b bVar3) {
                                    if (bVar3 != null) {
                                        bVar3.a("his_reason", "preload template failed is tpl :" + AnonymousClass3.this.f46730c);
                                    }
                                    if (AnonymousClass3.this.f46729b.getRsIgnoreCheckRule() != null && AnonymousClass3.this.f46729b.getRsIgnoreCheckRule().size() > 0 && AnonymousClass3.this.f46729b.getRsIgnoreCheckRule().contains(1)) {
                                        ad.c("RewardMVVideoAdapter", "template download fail but hit ignoreCheckRule");
                                        return;
                                    }
                                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                    c cVar4 = c.this;
                                    c.a(cVar4, str2, cVar4.S, c.this.A, str5);
                                    if (c.this.O != null) {
                                        c.this.O.removeMessages(5);
                                    }
                                    if (c.this.f46718t == null || c.this.f46707i) {
                                        return;
                                    }
                                    c.this.f46707i = true;
                                    AnonymousClass3 anonymousClass4 = AnonymousClass3.this;
                                    if (anonymousClass4.f46728a == null) {
                                        anonymousClass4.f46728a = new com.mbridge.msdk.foundation.same.report.d.b();
                                    }
                                    AnonymousClass3 anonymousClass5 = AnonymousClass3.this;
                                    anonymousClass5.f46728a.b(c.this.H);
                                    AnonymousClass3.this.f46728a.a(bVar3);
                                    c.this.f46718t.a(c.this.S, bVar3, AnonymousClass3.this.f46728a);
                                    ad.a("RewardMVVideoAdapter", "Campaign 下载失败： 非大模板，播放模板预加载失败 onVideoLoadFail");
                                }

                                @Override // com.mbridge.msdk.reward.adapter.b.j
                                public final void a(String str4, String str5, String str6, String str7, String str8, com.mbridge.msdk.videocommon.a.C0532a c0532a) {
                                    c cVar4 = c.this;
                                    CopyOnWriteArrayList copyOnWriteArrayList2 = cVar4.H;
                                    AnonymousClass3 anonymousClass4 = AnonymousClass3.this;
                                    if (cVar4.a(copyOnWriteArrayList2, anonymousClass4.f46730c, anonymousClass4.f46731d)) {
                                        c cVar5 = c.this;
                                        String str9 = cVar5.f46710l;
                                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                        c.a(cVar5, str9, copyOnWriteArrayList, c.this.U, c.this.A);
                                        if (c.this.O != null) {
                                            c.this.O.removeMessages(5);
                                        }
                                        if (c.this.f46718t == null || c.this.f46706h) {
                                            return;
                                        }
                                        c.this.f46706h = true;
                                        AnonymousClass3 anonymousClass5 = AnonymousClass3.this;
                                        com.mbridge.msdk.foundation.same.report.d.b bVar3 = anonymousClass5.f46728a;
                                        if (bVar3 != null) {
                                            bVar3.b(c.this.H);
                                        }
                                        c.this.f46718t.a(c.this.H, AnonymousClass3.this.f46728a);
                                        return;
                                    }
                                    c cVar6 = c.this;
                                    c.a(cVar6, str6, cVar6.S, c.this.A, str7);
                                    if (c.this.O != null) {
                                        c.this.O.removeMessages(5);
                                    }
                                    if (c.this.f46718t == null || c.this.f46707i) {
                                        return;
                                    }
                                    c.this.f46707i = true;
                                    com.mbridge.msdk.foundation.c.b bVarB2 = com.mbridge.msdk.foundation.c.a.b(880015, "errorCode: 3502 errorMessage: temp preload success but isReady false");
                                    AnonymousClass3 anonymousClass6 = AnonymousClass3.this;
                                    if (anonymousClass6.f46728a == null) {
                                        anonymousClass6.f46728a = new com.mbridge.msdk.foundation.same.report.d.b();
                                    }
                                    AnonymousClass3 anonymousClass7 = AnonymousClass3.this;
                                    anonymousClass7.f46728a.b(c.this.H);
                                    AnonymousClass3.this.f46728a.a(bVarB2);
                                    c.this.f46718t.a(c.this.H, bVarB2, AnonymousClass3.this.f46728a);
                                    ad.a("RewardMVVideoAdapter", "Campaign 下载成功： 非大模板，播放模板预加载成功,isReay false onVideoLoadFail");
                                }
                            });
                        }
                    });
                }
            }
        }

        @Override // com.mbridge.msdk.reward.adapter.b.c
        public final void a(final CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList, final com.mbridge.msdk.foundation.c.b bVar) {
            c.this.f46703e = false;
            if (c.this.f46718t == null || c.this.O == null) {
                return;
            }
            c.this.O.post(new Runnable() { // from class: com.mbridge.msdk.reward.adapter.c.3.3
                @Override // java.lang.Runnable
                public final void run() {
                    c cVar = c.this;
                    c.a(cVar, cVar.f46710l, copyOnWriteArrayList, c.this.A, "");
                    if (c.this.O != null) {
                        c.this.O.removeMessages(5);
                    }
                    if (c.this.f46707i || c.this.f46718t == null) {
                        return;
                    }
                    c.this.f46707i = true;
                    AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                    if (anonymousClass3.f46728a == null) {
                        anonymousClass3.f46728a = new com.mbridge.msdk.foundation.same.report.d.b();
                    }
                    AnonymousClass3 anonymousClass4 = AnonymousClass3.this;
                    anonymousClass4.f46728a.b(c.this.H);
                    com.mbridge.msdk.foundation.c.b bVar2 = bVar;
                    if (bVar2 != null) {
                        bVar2.a("errorCode: 3201 errorMessage: campaign resource download failed");
                    }
                    AnonymousClass3.this.f46728a.a(bVar);
                    c.this.f46718t.a(copyOnWriteArrayList, bVar, AnonymousClass3.this.f46728a);
                    ad.a("RewardMVVideoAdapter", "Campaign 下载失败：onVideoLoadFail");
                }
            });
        }
    }

    /* JADX INFO: renamed from: com.mbridge.msdk.reward.adapter.c$4, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    public class AnonymousClass4 implements com.mbridge.msdk.reward.adapter.b.i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        com.mbridge.msdk.foundation.same.report.d.b f46748a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ CampaignEx f46749b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f46750c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f46751d;

        public AnonymousClass4(CampaignEx campaignEx, boolean z11, int i11) {
            this.f46749b = campaignEx;
            this.f46750c = z11;
            this.f46751d = i11;
            this.f46748a = com.mbridge.msdk.foundation.same.report.d.c.a().b().get(campaignEx.getLocalRequestId());
        }

        @Override // com.mbridge.msdk.reward.adapter.b.i
        public final void a(String str, final String str2, final com.mbridge.msdk.foundation.c.b bVar) {
            ad.a("RewardMVVideoAdapter", "template 下载失败： ");
            if (bVar != null) {
                bVar.a("errorCode: 3202 errorMessage: temp resource download failed");
            }
            if (!this.f46750c && c.this.f46718t != null && c.this.O != null) {
                ad.a("RewardMVVideoAdapter", "播放模板下载失败，非大模板");
                if (this.f46749b.getRsIgnoreCheckRule() == null || this.f46749b.getRsIgnoreCheckRule().size() <= 0 || !this.f46749b.getRsIgnoreCheckRule().contains(1)) {
                    c.this.O.post(new Runnable() { // from class: com.mbridge.msdk.reward.adapter.c.4.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            c cVar = c.this;
                            c.a(cVar, cVar.f46710l, c.this.S, c.this.A, str2);
                            if (c.this.O != null) {
                                c.this.O.removeMessages(5);
                            }
                            if (c.this.f46707i || c.this.f46718t == null) {
                                return;
                            }
                            c.this.f46707i = true;
                            com.mbridge.msdk.foundation.c.b bVar2 = bVar;
                            if (bVar2 != null) {
                                bVar2.a("errorCode: 3202 errorMessage: temp resource download failed");
                            }
                            AnonymousClass4 anonymousClass4 = AnonymousClass4.this;
                            if (anonymousClass4.f46748a == null) {
                                anonymousClass4.f46748a = new com.mbridge.msdk.foundation.same.report.d.b();
                            }
                            AnonymousClass4 anonymousClass5 = AnonymousClass4.this;
                            anonymousClass5.f46748a.b(c.this.H);
                            AnonymousClass4.this.f46748a.a(bVar);
                            c.this.f46718t.a(c.this.S, bVar, AnonymousClass4.this.f46748a);
                            ad.a("RewardMVVideoAdapter", "播放模板下载失败，非大模板 onVideoLoadFail");
                        }
                    });
                    return;
                } else {
                    ad.c("RewardMVVideoAdapter", "template download fail but hit ignoreCheckRule");
                    return;
                }
            }
            if (this.f46751d == 1) {
                if (this.f46749b.getRsIgnoreCheckRule() != null && this.f46749b.getRsIgnoreCheckRule().size() > 0) {
                    if (this.f46749b.getRsIgnoreCheckRule().contains(3)) {
                        ad.c("RewardMVVideoAdapter", "tpl download fail but hit ignoreCheckRule");
                        return;
                    } else if (this.f46749b.getCMPTEntryUrl().equals(this.f46749b.getendcard_url()) && this.f46749b.getRsIgnoreCheckRule().contains(2)) {
                        ad.c("RewardMVVideoAdapter", "endcard download fail but hit ignoreCheckRule at 3203");
                        return;
                    }
                }
                if (c.this.f46718t == null || c.this.O == null) {
                    return;
                }
                c.this.O.post(new Runnable() { // from class: com.mbridge.msdk.reward.adapter.c.4.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        c cVar = c.this;
                        c.a(cVar, cVar.f46710l, c.this.S, c.this.A, str2);
                        if (c.this.O != null) {
                            c.this.O.removeMessages(5);
                        }
                        if (c.this.f46707i || c.this.f46718t == null) {
                            return;
                        }
                        c.this.f46707i = true;
                        com.mbridge.msdk.foundation.c.b bVar2 = bVar;
                        if (bVar2 != null) {
                            bVar2.a("errorCode: 3203 errorMessage: tpl temp resource download failed");
                        }
                        AnonymousClass4 anonymousClass4 = AnonymousClass4.this;
                        if (anonymousClass4.f46748a == null) {
                            anonymousClass4.f46748a = new com.mbridge.msdk.foundation.same.report.d.b();
                        }
                        AnonymousClass4 anonymousClass5 = AnonymousClass4.this;
                        anonymousClass5.f46748a.b(c.this.H);
                        AnonymousClass4.this.f46748a.a(bVar);
                        c.this.f46718t.a(c.this.S, bVar, AnonymousClass4.this.f46748a);
                        ad.a("RewardMVVideoAdapter", "播放模板下载失败，大模板，nscpt 1 onVideoLoadFail");
                    }
                });
            }
        }

        @Override // com.mbridge.msdk.reward.adapter.b.i
        public final void a(String str, String str2, String str3, String str4) {
        }
    }

    /* JADX INFO: renamed from: com.mbridge.msdk.reward.adapter.c$5, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    public class AnonymousClass5 implements com.mbridge.msdk.reward.adapter.b.i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        com.mbridge.msdk.foundation.same.report.d.b f46759a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ CampaignEx f46760b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f46761c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f46762d;

        public AnonymousClass5(CampaignEx campaignEx, boolean z11, int i11) {
            this.f46760b = campaignEx;
            this.f46761c = z11;
            this.f46762d = i11;
            this.f46759a = com.mbridge.msdk.foundation.same.report.d.c.a().b().get(campaignEx.getLocalRequestId());
        }

        @Override // com.mbridge.msdk.reward.adapter.b.i
        public final void a(String str, String str2, com.mbridge.msdk.foundation.c.b bVar) {
            ad.a("RewardMVVideoAdapter", "大模板业务，大模板下载失败");
            if (this.f46760b.getRsIgnoreCheckRule() != null && this.f46760b.getRsIgnoreCheckRule().size() > 0) {
                if (this.f46760b.getRsIgnoreCheckRule().contains(3)) {
                    ad.c("RewardMVVideoAdapter", "tpl download fail but hit ignoreCheckRule");
                    return;
                } else if (this.f46760b.getCMPTEntryUrl().equals(this.f46760b.getendcard_url()) && this.f46760b.getRsIgnoreCheckRule().contains(2)) {
                    ad.c("RewardMVVideoAdapter", "endcard download fail but hit ignoreCheckRule at 3203");
                    return;
                }
            }
            c cVar = c.this;
            c.a(cVar, cVar.f46710l, c.this.S, c.this.A, str2);
            c.this.f46704f = false;
            if (c.this.O != null) {
                c.this.O.removeMessages(5);
            }
            if (c.this.f46718t == null || c.this.f46707i) {
                return;
            }
            c.this.f46707i = true;
            if (bVar != null) {
                bVar.a("errorCode: 3203 errorMessage: tpl temp resource download failed");
            }
            if (this.f46759a == null) {
                this.f46759a = new com.mbridge.msdk.foundation.same.report.d.b();
            }
            this.f46759a.b(c.this.H);
            this.f46759a.a(bVar);
            c.this.f46718t.a(c.this.S, bVar, this.f46759a);
            ad.a("RewardMVVideoAdapter", "大模板业务，大模板下载失败 onVideoLoadFail");
        }

        @Override // com.mbridge.msdk.reward.adapter.b.i
        public final void a(final String str, final String str2, final String str3, String str4) {
            ad.a("RewardMVVideoAdapter", "大模板业务，大模板下载成功");
            c.this.f46704f = true;
            if (!c.this.f46703e || c.this.f46705g || c.this.O == null) {
                return;
            }
            synchronized (c.this.f46699a) {
                try {
                    if (c.this.f46705g) {
                        return;
                    }
                    c.this.f46705g = true;
                    c.this.O.post(new Runnable() { // from class: com.mbridge.msdk.reward.adapter.c.5.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            com.mbridge.msdk.reward.adapter.b bVar = com.mbridge.msdk.reward.adapter.b.m.f46698a;
                            boolean z11 = c.this.I;
                            Handler handler = c.this.O;
                            boolean z12 = c.this.f46724z;
                            boolean z13 = c.this.A;
                            String str5 = str3;
                            String requestIdNotice = AnonymousClass5.this.f46760b.getRequestIdNotice();
                            String str6 = str;
                            String str7 = str2;
                            String cMPTEntryUrl = AnonymousClass5.this.f46760b.getCMPTEntryUrl();
                            int i11 = c.this.f46723y;
                            AnonymousClass5 anonymousClass5 = AnonymousClass5.this;
                            bVar.a(z11, handler, z12, z13, str5, requestIdNotice, str6, str7, cMPTEntryUrl, i11, anonymousClass5.f46760b, c.this.H, H5DownLoadManager.getInstance().getH5ResAddress(AnonymousClass5.this.f46760b.getCMPTEntryUrl()), str2, c.this.f46719u, new com.mbridge.msdk.reward.adapter.b.j() { // from class: com.mbridge.msdk.reward.adapter.c.5.1.1
                                @Override // com.mbridge.msdk.reward.adapter.b.j
                                public final void a(String str8, String str9, String str10, com.mbridge.msdk.videocommon.a.C0532a c0532a, com.mbridge.msdk.foundation.c.b bVar2) {
                                    ad.a("RewardMVVideoAdapter", "大模板业务，大模板预加载失败");
                                    ad.b("HBOPTIMIZE", "模板加载失败 requestId " + str9);
                                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                    c cVar = c.this;
                                    c.a(cVar, str2, cVar.S, c.this.A, str9);
                                    if (c.this.O != null) {
                                        c.this.O.removeMessages(5);
                                    }
                                    if (c.this.f46718t == null || c.this.f46707i) {
                                        return;
                                    }
                                    c.this.f46707i = true;
                                    AnonymousClass5 anonymousClass6 = AnonymousClass5.this;
                                    if (anonymousClass6.f46759a == null) {
                                        anonymousClass6.f46759a = new com.mbridge.msdk.foundation.same.report.d.b();
                                    }
                                    AnonymousClass5 anonymousClass7 = AnonymousClass5.this;
                                    anonymousClass7.f46759a.b(c.this.H);
                                    AnonymousClass5.this.f46759a.a(bVar2);
                                    c.this.f46718t.a(c.this.S, bVar2, AnonymousClass5.this.f46759a);
                                    ad.a("RewardMVVideoAdapter", "大模板业务，大模板预加载失败 onVideoLoadFail");
                                }

                                @Override // com.mbridge.msdk.reward.adapter.b.j
                                public final void a(String str8, String str9, String str10, String str11, String str12, com.mbridge.msdk.videocommon.a.C0532a c0532a) {
                                    ad.a("HBOPTIMIZE", "模板加载成功 requestId " + str11);
                                    c cVar = c.this;
                                    CopyOnWriteArrayList copyOnWriteArrayList = cVar.H;
                                    AnonymousClass5 anonymousClass6 = AnonymousClass5.this;
                                    if (cVar.a(copyOnWriteArrayList, anonymousClass6.f46761c, anonymousClass6.f46762d)) {
                                        c cVar2 = c.this;
                                        c.a(cVar2, cVar2.f46710l, c.this.S, c.this.U, c.this.A);
                                        if (c.this.O != null) {
                                            c.this.O.removeMessages(5);
                                        }
                                        if (c.this.f46718t == null || c.this.f46706h) {
                                            return;
                                        }
                                        c.this.f46706h = true;
                                        AnonymousClass5 anonymousClass7 = AnonymousClass5.this;
                                        com.mbridge.msdk.foundation.same.report.d.b bVar2 = anonymousClass7.f46759a;
                                        if (bVar2 != null) {
                                            bVar2.b(c.this.H);
                                        }
                                        c.this.f46718t.a(c.this.H, AnonymousClass5.this.f46759a);
                                        return;
                                    }
                                    c cVar3 = c.this;
                                    c.a(cVar3, str10, cVar3.S, c.this.A, str3);
                                    if (c.this.O != null) {
                                        c.this.O.removeMessages(5);
                                    }
                                    if (c.this.f46718t == null || c.this.f46707i) {
                                        return;
                                    }
                                    c.this.f46707i = true;
                                    com.mbridge.msdk.foundation.c.b bVarB = com.mbridge.msdk.foundation.c.a.b(880008, "errorCode: 3505 errorMessage: tpl temp preload success but isReady false");
                                    AnonymousClass5 anonymousClass8 = AnonymousClass5.this;
                                    if (anonymousClass8.f46759a == null) {
                                        anonymousClass8.f46759a = new com.mbridge.msdk.foundation.same.report.d.b();
                                    }
                                    AnonymousClass5 anonymousClass9 = AnonymousClass5.this;
                                    anonymousClass9.f46759a.b(c.this.H);
                                    AnonymousClass5.this.f46759a.a(bVarB);
                                    c.this.f46718t.a(c.this.S, bVarB, AnonymousClass5.this.f46759a);
                                    ad.a("RewardMVVideoAdapter", "大模板业务，大模板预加载成功 isReady false  onVideoLoadFail");
                                }
                            }, false);
                        }
                    });
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class a implements Runnable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f46773b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private com.mbridge.msdk.foundation.same.report.d.b f46774c;

        public a(String str, com.mbridge.msdk.foundation.same.report.d.b bVar) {
            this.f46773b = str;
            this.f46774c = bVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                if (c.this.M) {
                    return;
                }
                c.this.N = true;
                if (c.this.O != null) {
                    Message messageObtainMessage = c.this.O.obtainMessage();
                    messageObtainMessage.obj = this.f46773b;
                    messageObtainMessage.what = 2;
                    if (this.f46774c != null) {
                        Bundle bundle = new Bundle();
                        bundle.putString("metrics_data_lrid", this.f46774c.f());
                        messageObtainMessage.setData(bundle);
                    }
                    c.this.O.sendMessage(messageObtainMessage);
                }
            } catch (Exception e11) {
                ad.b("RewardMVVideoAdapter", e11.getMessage());
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b implements Runnable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f46776b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private com.mbridge.msdk.foundation.same.report.d.b f46777c;

        public b(String str, com.mbridge.msdk.foundation.same.report.d.b bVar) {
            this.f46776b = str;
            this.f46777c = bVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                if (com.mbridge.msdk.f.b.a()) {
                    c cVar = c.this;
                    String unused = cVar.f46710l;
                    Context unused2 = c.this.f46709k;
                    cVar.C = "";
                }
                c cVar2 = c.this;
                cVar2.f46716r = ai.a(cVar2.f46709k, c.this.f46710l);
                if (c.this.N) {
                    return;
                }
                if (c.this.L != null && c.this.O != null) {
                    c.this.O.removeCallbacks(c.this.L);
                }
                c.this.M = true;
                if (c.this.O != null) {
                    Message messageObtainMessage = c.this.O.obtainMessage();
                    messageObtainMessage.obj = this.f46776b;
                    messageObtainMessage.what = 1;
                    if (this.f46777c != null) {
                        Bundle bundle = new Bundle();
                        bundle.putString("metrics_data_lrid", this.f46777c.f());
                        messageObtainMessage.setData(bundle);
                    }
                    c.this.O.sendMessage(messageObtainMessage);
                }
                if (TextUtils.isEmpty(c.this.f46716r)) {
                    return;
                }
                ad.b("RewardMVVideoAdapter", "excludeId : " + c.this.f46716r);
            } catch (Exception e11) {
                ad.b("RewardMVVideoAdapter", e11.getMessage());
            }
        }
    }

    public c(Context context, String str, String str2) {
        try {
            this.f46709k = context.getApplicationContext();
            this.f46710l = str2;
            this.f46711m = str;
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.mbridge.msdk.foundation.same.report.d.b a(Message message) {
        com.mbridge.msdk.foundation.same.report.d.b bVar = new com.mbridge.msdk.foundation.same.report.d.b();
        if (message == null) {
            return bVar;
        }
        try {
            Bundle data = message.getData();
            return data != null ? com.mbridge.msdk.foundation.same.report.d.c.a().b(data.getString("metrics_data_lrid")) : bVar;
        } catch (Exception e11) {
            if (!MBridgeConstans.DEBUG) {
                return bVar;
            }
            e11.printStackTrace();
            return bVar;
        }
    }

    /* JADX WARN: Code duplicated, block: B:103:0x01c7  */
    /* JADX WARN: Code duplicated, block: B:104:0x01c9  */
    /* JADX WARN: Code duplicated, block: B:108:0x01d5 A[Catch: all -> 0x0019, Exception -> 0x001c, TryCatch #5 {Exception -> 0x001c, blocks: (B:8:0x0011, B:10:0x0015, B:16:0x0021, B:18:0x0027, B:20:0x0031, B:22:0x003e, B:24:0x0048, B:25:0x004d, B:27:0x0053, B:28:0x0064, B:30:0x006a, B:31:0x0072, B:33:0x0077, B:37:0x0082, B:39:0x008e, B:41:0x009c, B:75:0x0155, B:77:0x0164, B:79:0x016a, B:81:0x0170, B:83:0x0179, B:84:0x017c, B:74:0x0152, B:45:0x00a9, B:48:0x00b4, B:85:0x017d, B:87:0x0185, B:89:0x018b, B:91:0x0195, B:96:0x01aa, B:97:0x01af, B:99:0x01b5, B:101:0x01bb, B:105:0x01ca, B:106:0x01cd, B:108:0x01d5, B:113:0x01f0, B:115:0x01f4, B:109:0x01d9, B:94:0x01a0), top: B:147:0x0011 }] */
    /* JADX WARN: Code duplicated, block: B:109:0x01d9 A[Catch: all -> 0x0019, Exception -> 0x001c, TRY_LEAVE, TryCatch #5 {Exception -> 0x001c, blocks: (B:8:0x0011, B:10:0x0015, B:16:0x0021, B:18:0x0027, B:20:0x0031, B:22:0x003e, B:24:0x0048, B:25:0x004d, B:27:0x0053, B:28:0x0064, B:30:0x006a, B:31:0x0072, B:33:0x0077, B:37:0x0082, B:39:0x008e, B:41:0x009c, B:75:0x0155, B:77:0x0164, B:79:0x016a, B:81:0x0170, B:83:0x0179, B:84:0x017c, B:74:0x0152, B:45:0x00a9, B:48:0x00b4, B:85:0x017d, B:87:0x0185, B:89:0x018b, B:91:0x0195, B:96:0x01aa, B:97:0x01af, B:99:0x01b5, B:101:0x01bb, B:105:0x01ca, B:106:0x01cd, B:108:0x01d5, B:113:0x01f0, B:115:0x01f4, B:109:0x01d9, B:94:0x01a0), top: B:147:0x0011 }] */
    /* JADX WARN: Code duplicated, block: B:123:0x0206 A[PHI: r13
  0x0206: PHI (r13v4 'e' java.io.IOException) = (r13v7 'e' java.io.IOException), (r13v8 'e' java.io.IOException) binds: [B:130:0x021a, B:122:0x0204] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:164:0x01f7 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:85:0x017d A[Catch: all -> 0x0019, Exception -> 0x001c, PHI: r2
  0x017d: PHI (r2v10 java.io.FileOutputStream) = (r2v9 java.io.FileOutputStream), (r2v14 java.io.FileOutputStream) binds: [B:38:0x008c, B:80:0x016e] A[DONT_GENERATE, DONT_INLINE], TryCatch #5 {Exception -> 0x001c, blocks: (B:8:0x0011, B:10:0x0015, B:16:0x0021, B:18:0x0027, B:20:0x0031, B:22:0x003e, B:24:0x0048, B:25:0x004d, B:27:0x0053, B:28:0x0064, B:30:0x006a, B:31:0x0072, B:33:0x0077, B:37:0x0082, B:39:0x008e, B:41:0x009c, B:75:0x0155, B:77:0x0164, B:79:0x016a, B:81:0x0170, B:83:0x0179, B:84:0x017c, B:74:0x0152, B:45:0x00a9, B:48:0x00b4, B:85:0x017d, B:87:0x0185, B:89:0x018b, B:91:0x0195, B:96:0x01aa, B:97:0x01af, B:99:0x01b5, B:101:0x01bb, B:105:0x01ca, B:106:0x01cd, B:108:0x01d5, B:113:0x01f0, B:115:0x01f4, B:109:0x01d9, B:94:0x01a0), top: B:147:0x0011 }] */
    /* JADX WARN: Code duplicated, block: B:87:0x0185 A[Catch: all -> 0x0019, Exception -> 0x001c, TryCatch #5 {Exception -> 0x001c, blocks: (B:8:0x0011, B:10:0x0015, B:16:0x0021, B:18:0x0027, B:20:0x0031, B:22:0x003e, B:24:0x0048, B:25:0x004d, B:27:0x0053, B:28:0x0064, B:30:0x006a, B:31:0x0072, B:33:0x0077, B:37:0x0082, B:39:0x008e, B:41:0x009c, B:75:0x0155, B:77:0x0164, B:79:0x016a, B:81:0x0170, B:83:0x0179, B:84:0x017c, B:74:0x0152, B:45:0x00a9, B:48:0x00b4, B:85:0x017d, B:87:0x0185, B:89:0x018b, B:91:0x0195, B:96:0x01aa, B:97:0x01af, B:99:0x01b5, B:101:0x01bb, B:105:0x01ca, B:106:0x01cd, B:108:0x01d5, B:113:0x01f0, B:115:0x01f4, B:109:0x01d9, B:94:0x01a0), top: B:147:0x0011 }] */
    /* JADX WARN: Code duplicated, block: B:89:0x018b A[Catch: all -> 0x0019, Exception -> 0x001c, TryCatch #5 {Exception -> 0x001c, blocks: (B:8:0x0011, B:10:0x0015, B:16:0x0021, B:18:0x0027, B:20:0x0031, B:22:0x003e, B:24:0x0048, B:25:0x004d, B:27:0x0053, B:28:0x0064, B:30:0x006a, B:31:0x0072, B:33:0x0077, B:37:0x0082, B:39:0x008e, B:41:0x009c, B:75:0x0155, B:77:0x0164, B:79:0x016a, B:81:0x0170, B:83:0x0179, B:84:0x017c, B:74:0x0152, B:45:0x00a9, B:48:0x00b4, B:85:0x017d, B:87:0x0185, B:89:0x018b, B:91:0x0195, B:96:0x01aa, B:97:0x01af, B:99:0x01b5, B:101:0x01bb, B:105:0x01ca, B:106:0x01cd, B:108:0x01d5, B:113:0x01f0, B:115:0x01f4, B:109:0x01d9, B:94:0x01a0), top: B:147:0x0011 }] */
    /* JADX WARN: Code duplicated, block: B:94:0x01a0 A[Catch: all -> 0x0019, Exception -> 0x001c, TryCatch #5 {Exception -> 0x001c, blocks: (B:8:0x0011, B:10:0x0015, B:16:0x0021, B:18:0x0027, B:20:0x0031, B:22:0x003e, B:24:0x0048, B:25:0x004d, B:27:0x0053, B:28:0x0064, B:30:0x006a, B:31:0x0072, B:33:0x0077, B:37:0x0082, B:39:0x008e, B:41:0x009c, B:75:0x0155, B:77:0x0164, B:79:0x016a, B:81:0x0170, B:83:0x0179, B:84:0x017c, B:74:0x0152, B:45:0x00a9, B:48:0x00b4, B:85:0x017d, B:87:0x0185, B:89:0x018b, B:91:0x0195, B:96:0x01aa, B:97:0x01af, B:99:0x01b5, B:101:0x01bb, B:105:0x01ca, B:106:0x01cd, B:108:0x01d5, B:113:0x01f0, B:115:0x01f4, B:109:0x01d9, B:94:0x01a0), top: B:147:0x0011 }] */
    /* JADX WARN: Code duplicated, block: B:96:0x01aa A[Catch: all -> 0x0019, Exception -> 0x001c, TryCatch #5 {Exception -> 0x001c, blocks: (B:8:0x0011, B:10:0x0015, B:16:0x0021, B:18:0x0027, B:20:0x0031, B:22:0x003e, B:24:0x0048, B:25:0x004d, B:27:0x0053, B:28:0x0064, B:30:0x006a, B:31:0x0072, B:33:0x0077, B:37:0x0082, B:39:0x008e, B:41:0x009c, B:75:0x0155, B:77:0x0164, B:79:0x016a, B:81:0x0170, B:83:0x0179, B:84:0x017c, B:74:0x0152, B:45:0x00a9, B:48:0x00b4, B:85:0x017d, B:87:0x0185, B:89:0x018b, B:91:0x0195, B:96:0x01aa, B:97:0x01af, B:99:0x01b5, B:101:0x01bb, B:105:0x01ca, B:106:0x01cd, B:108:0x01d5, B:113:0x01f0, B:115:0x01f4, B:109:0x01d9, B:94:0x01a0), top: B:147:0x0011 }] */
    /* JADX WARN: Code duplicated, block: B:97:0x01af A[Catch: all -> 0x0019, Exception -> 0x001c, TryCatch #5 {Exception -> 0x001c, blocks: (B:8:0x0011, B:10:0x0015, B:16:0x0021, B:18:0x0027, B:20:0x0031, B:22:0x003e, B:24:0x0048, B:25:0x004d, B:27:0x0053, B:28:0x0064, B:30:0x006a, B:31:0x0072, B:33:0x0077, B:37:0x0082, B:39:0x008e, B:41:0x009c, B:75:0x0155, B:77:0x0164, B:79:0x016a, B:81:0x0170, B:83:0x0179, B:84:0x017c, B:74:0x0152, B:45:0x00a9, B:48:0x00b4, B:85:0x017d, B:87:0x0185, B:89:0x018b, B:91:0x0195, B:96:0x01aa, B:97:0x01af, B:99:0x01b5, B:101:0x01bb, B:105:0x01ca, B:106:0x01cd, B:108:0x01d5, B:113:0x01f0, B:115:0x01f4, B:109:0x01d9, B:94:0x01a0), top: B:147:0x0011 }] */
    /* JADX WARN: Code duplicated, block: B:99:0x01b5 A[Catch: all -> 0x0019, Exception -> 0x001c, TryCatch #5 {Exception -> 0x001c, blocks: (B:8:0x0011, B:10:0x0015, B:16:0x0021, B:18:0x0027, B:20:0x0031, B:22:0x003e, B:24:0x0048, B:25:0x004d, B:27:0x0053, B:28:0x0064, B:30:0x006a, B:31:0x0072, B:33:0x0077, B:37:0x0082, B:39:0x008e, B:41:0x009c, B:75:0x0155, B:77:0x0164, B:79:0x016a, B:81:0x0170, B:83:0x0179, B:84:0x017c, B:74:0x0152, B:45:0x00a9, B:48:0x00b4, B:85:0x017d, B:87:0x0185, B:89:0x018b, B:91:0x0195, B:96:0x01aa, B:97:0x01af, B:99:0x01b5, B:101:0x01bb, B:105:0x01ca, B:106:0x01cd, B:108:0x01d5, B:113:0x01f0, B:115:0x01f4, B:109:0x01d9, B:94:0x01a0), top: B:147:0x0011 }] */
    private CopyOnWriteArrayList<CampaignEx> a(CampaignUnit campaignUnit) throws Throwable {
        IOException e11;
        com.mbridge.msdk.foundation.same.report.d.b metricsData;
        int i11;
        String str;
        CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        if (MBridgeConstans.DEBUG && e.f43983a) {
            return copyOnWriteArrayList;
        }
        FileOutputStream fileOutputStream = null;
        try {
            try {
                com.mbridge.msdk.videocommon.d.c cVar = this.f46719u;
                if (cVar != null) {
                    cVar.u();
                }
                if (campaignUnit != null && campaignUnit.getAds() != null && campaignUnit.getAds().size() > 0) {
                    ArrayList<CampaignEx> ads = campaignUnit.getAds();
                    this.S = ads;
                    if (campaignUnit.getAds() == null || campaignUnit.getAds().size() <= 0) {
                        metricsData = null;
                    } else {
                        ArrayList<CampaignEx> ads2 = campaignUnit.getAds();
                        for (int i12 = 0; i12 < ads2.size(); i12++) {
                            CampaignEx campaignEx = ads2.get(i12);
                            campaignEx.setCampaignUnitId(this.f46710l);
                            ads2.set(i12, campaignEx);
                        }
                        metricsData = campaignUnit.getMetricsData();
                        if (metricsData == null) {
                            metricsData = new com.mbridge.msdk.foundation.same.report.d.b();
                            campaignUnit.setMetricsData(metricsData);
                        }
                        metricsData.b(ads2);
                    }
                    for (int i13 = 0; i13 < ads.size() && i13 < Integer.MAX_VALUE; i13++) {
                        CampaignEx campaignEx2 = ads.get(i13);
                        if (campaignEx2.isMraid()) {
                            if (TextUtils.isEmpty(campaignEx2.getMraid().trim())) {
                                continue;
                            } else {
                                if (campaignEx2.getAdType() == 287) {
                                    str = "3";
                                } else if (campaignEx2.getAdType() == 94) {
                                    str = "1";
                                } else {
                                    str = campaignEx2.getAdType() == 42 ? "2" : "";
                                }
                                try {
                                    try {
                                        String strA = com.mbridge.msdk.foundation.same.b.e.a(com.mbridge.msdk.foundation.same.b.c.MBRIDGE_700_HTML);
                                        String md5 = SameMD5.getMD5(campaignEx2.getMraid());
                                        if (TextUtils.isEmpty(md5)) {
                                            md5 = String.valueOf(System.currentTimeMillis());
                                        }
                                        File file = new File(strA, md5.concat(".html"));
                                        FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                                        try {
                                            fileOutputStream2.write(("<script>" + com.mbridge.msdk.c.b.a.a().b() + "</script>" + campaignEx2.getMraid()).getBytes());
                                            fileOutputStream2.flush();
                                            campaignEx2.setMraid(file.getAbsolutePath());
                                            m.a(campaignEx2, "", this.f46710l, str);
                                            try {
                                                fileOutputStream2.close();
                                                fileOutputStream = fileOutputStream2;
                                            } catch (Exception e12) {
                                                e = e12;
                                                fileOutputStream = fileOutputStream2;
                                                e.printStackTrace();
                                                if (fileOutputStream != null) {
                                                    try {
                                                        fileOutputStream.close();
                                                    } catch (IOException e13) {
                                                        e11 = e13;
                                                        if (MBridgeConstans.DEBUG) {
                                                            ad.b("RewardMVVideoAdapter", e11.getMessage());
                                                        }
                                                    }
                                                }
                                                return copyOnWriteArrayList;
                                            } catch (Throwable th2) {
                                                th = th2;
                                                fileOutputStream = fileOutputStream2;
                                                if (fileOutputStream != null) {
                                                    try {
                                                        fileOutputStream.close();
                                                    } catch (IOException e14) {
                                                        if (MBridgeConstans.DEBUG) {
                                                            ad.b("RewardMVVideoAdapter", e14.getMessage());
                                                        }
                                                    }
                                                }
                                                throw th;
                                            }
                                        } catch (Exception e15) {
                                            e = e15;
                                            fileOutputStream = fileOutputStream2;
                                            e.printStackTrace();
                                            campaignEx2.setMraid("");
                                            m.a(campaignEx2, e.getMessage(), this.f46710l, str);
                                            if (fileOutputStream != null) {
                                                fileOutputStream.close();
                                            }
                                        } catch (Throwable th3) {
                                            th = th3;
                                            fileOutputStream = fileOutputStream2;
                                            if (fileOutputStream != null) {
                                                fileOutputStream.close();
                                            }
                                            throw th;
                                        }
                                    } catch (Exception e16) {
                                        e = e16;
                                    }
                                    File file2 = new File(campaignEx2.getMraid());
                                    if (!file2.exists() || !file2.isFile() || !file2.canRead()) {
                                        b("mraid resource write fail", metricsData);
                                    } else if (campaignEx2.getOfferType() == 99) {
                                        if (b(campaignEx2)) {
                                            if (an.a(campaignEx2.getendcard_url())) {
                                            }
                                            if (com.mbridge.msdk.f.b.a()) {
                                                if (ai.c(this.f46709k, campaignEx2.getPackageName())) {
                                                    i11 = 1;
                                                } else {
                                                    i11 = 2;
                                                }
                                                campaignEx2.setRtinsType(i11);
                                            }
                                            if (com.mbridge.msdk.foundation.same.b.a(this.f46709k, campaignEx2)) {
                                                copyOnWriteArrayList.add(campaignEx2);
                                            } else {
                                                ai.a(this.f46710l, campaignEx2, com.mbridge.msdk.foundation.same.a.f44388x);
                                                this.R = "APP ALREADY INSTALLED";
                                            }
                                            com.mbridge.msdk.foundation.same.b.a(campaignEx2, this.f46709k, metricsData, new com.mbridge.msdk.foundation.same.b.a() { // from class: com.mbridge.msdk.reward.adapter.c.6
                                                @Override // com.mbridge.msdk.foundation.same.b.a
                                                public final void a(String str2, com.mbridge.msdk.foundation.same.report.d.b bVar) {
                                                    com.mbridge.msdk.reward.c.a.a.a().a(str2, bVar);
                                                }
                                            });
                                        } else if (an.a(campaignEx2.getVideoUrlEncode())) {
                                            this.R = "No video campaign";
                                        } else {
                                            if (com.mbridge.msdk.f.b.a()) {
                                                if (ai.c(this.f46709k, campaignEx2.getPackageName())) {
                                                    i11 = 1;
                                                } else {
                                                    i11 = 2;
                                                }
                                                campaignEx2.setRtinsType(i11);
                                            }
                                            if (com.mbridge.msdk.foundation.same.b.a(this.f46709k, campaignEx2)) {
                                                copyOnWriteArrayList.add(campaignEx2);
                                            } else {
                                                ai.a(this.f46710l, campaignEx2, com.mbridge.msdk.foundation.same.a.f44388x);
                                                this.R = "APP ALREADY INSTALLED";
                                            }
                                            com.mbridge.msdk.foundation.same.b.a(campaignEx2, this.f46709k, metricsData, new com.mbridge.msdk.foundation.same.b.a() { // from class: com.mbridge.msdk.reward.adapter.c.6
                                                @Override // com.mbridge.msdk.foundation.same.b.a
                                                public final void a(String str2, com.mbridge.msdk.foundation.same.report.d.b bVar) {
                                                    com.mbridge.msdk.reward.c.a.a.a().a(str2, bVar);
                                                }
                                            });
                                        }
                                    }
                                } catch (Throwable th4) {
                                    th = th4;
                                }
                            }
                        } else if (campaignEx2.getOfferType() == 99) {
                            if (b(campaignEx2)) {
                                if (an.a(campaignEx2.getendcard_url()) || !TextUtils.isEmpty(campaignEx2.getMraid())) {
                                    if (com.mbridge.msdk.f.b.a() && ai.c(campaignEx2)) {
                                        if (ai.c(this.f46709k, campaignEx2.getPackageName())) {
                                            i11 = 1;
                                        } else {
                                            i11 = 2;
                                        }
                                        campaignEx2.setRtinsType(i11);
                                    }
                                    if (com.mbridge.msdk.foundation.same.b.a(this.f46709k, campaignEx2)) {
                                        copyOnWriteArrayList.add(campaignEx2);
                                    } else {
                                        ai.a(this.f46710l, campaignEx2, com.mbridge.msdk.foundation.same.a.f44388x);
                                        this.R = "APP ALREADY INSTALLED";
                                    }
                                    try {
                                        com.mbridge.msdk.foundation.same.b.a(campaignEx2, this.f46709k, metricsData, new com.mbridge.msdk.foundation.same.b.a() { // from class: com.mbridge.msdk.reward.adapter.c.6
                                            @Override // com.mbridge.msdk.foundation.same.b.a
                                            public final void a(String str2, com.mbridge.msdk.foundation.same.report.d.b bVar) {
                                                com.mbridge.msdk.reward.c.a.a.a().a(str2, bVar);
                                            }
                                        });
                                    } catch (Exception e17) {
                                        if (MBridgeConstans.DEBUG) {
                                            e17.printStackTrace();
                                        }
                                    }
                                } else {
                                    this.R = "No video campaign";
                                }
                            } else if (an.a(campaignEx2.getVideoUrlEncode())) {
                                this.R = "No video campaign";
                            } else {
                                if (com.mbridge.msdk.f.b.a()) {
                                    if (ai.c(this.f46709k, campaignEx2.getPackageName())) {
                                        i11 = 1;
                                    } else {
                                        i11 = 2;
                                    }
                                    campaignEx2.setRtinsType(i11);
                                }
                                if (com.mbridge.msdk.foundation.same.b.a(this.f46709k, campaignEx2)) {
                                    copyOnWriteArrayList.add(campaignEx2);
                                } else {
                                    ai.a(this.f46710l, campaignEx2, com.mbridge.msdk.foundation.same.a.f44388x);
                                    this.R = "APP ALREADY INSTALLED";
                                }
                                com.mbridge.msdk.foundation.same.b.a(campaignEx2, this.f46709k, metricsData, new com.mbridge.msdk.foundation.same.b.a() { // from class: com.mbridge.msdk.reward.adapter.c.6
                                    @Override // com.mbridge.msdk.foundation.same.b.a
                                    public final void a(String str2, com.mbridge.msdk.foundation.same.report.d.b bVar) {
                                        com.mbridge.msdk.reward.c.a.a.a().a(str2, bVar);
                                    }
                                });
                            }
                        }
                    }
                }
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e18) {
                        e11 = e18;
                        if (MBridgeConstans.DEBUG) {
                            ad.b("RewardMVVideoAdapter", e11.getMessage());
                        }
                    }
                }
            } catch (Exception e19) {
                e = e19;
            }
            return copyOnWriteArrayList;
        } catch (Throwable th5) {
            th = th5;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i11, String str, com.mbridge.msdk.foundation.same.report.d.b bVar) {
        if (this.O != null) {
            if (TextUtils.isEmpty(str)) {
                str = "load fail exception";
            }
            Message messageObtain = Message.obtain();
            messageObtain.what = 4;
            messageObtain.obj = str;
            messageObtain.arg1 = i11;
            if (bVar != null) {
                bVar.c(true);
                Bundle bundle = new Bundle();
                bundle.putString("metrics_data_lrid", bVar.f());
                messageObtain.setData(bundle);
            }
            if (str.contains("exception")) {
                this.O.sendMessageAtFrontOfQueue(messageObtain);
            } else {
                this.O.sendMessage(messageObtain);
            }
        }
    }

    private void a(k kVar, CampaignEx campaignEx) {
        if (kVar == null || kVar.b(campaignEx.getId())) {
            return;
        }
        g gVar = new g();
        gVar.a(campaignEx.getId());
        gVar.b(campaignEx.getFca());
        gVar.c(campaignEx.getFcb());
        gVar.a(0);
        gVar.d(0);
        gVar.a(System.currentTimeMillis());
        kVar.a(gVar);
    }

    private void a(CampaignEx campaignEx) {
        boolean z11 = !TextUtils.isEmpty(campaignEx.getCMPTEntryUrl());
        int nscpt = campaignEx.getNscpt();
        this.f46703e = false;
        this.f46704f = false;
        synchronized (this.f46699a) {
            try {
                if (this.f46705g) {
                    this.f46705g = false;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        this.f46707i = false;
        this.f46706h = false;
        if (this.A) {
            com.mbridge.msdk.foundation.db.b.a(com.mbridge.msdk.foundation.controller.c.m().c()).a(campaignEx.getBidToken(), campaignEx.getCampaignUnitId(), campaignEx.getEncryptPrice());
        }
        com.mbridge.msdk.reward.adapter.b.m.f46698a.a(this.f46709k, z11, nscpt, this.A, this.f46724z ? 287 : 94, this.f46711m, this.f46710l, campaignEx.getRequestId(), this.H, new AnonymousClass3(campaignEx, z11, nscpt), new AnonymousClass4(campaignEx, z11, nscpt));
        if (z11) {
            com.mbridge.msdk.reward.adapter.b.m.f46698a.a(this.f46709k, campaignEx, this.f46711m, this.f46710l, campaignEx.getRequestId(), new AnonymousClass5(campaignEx, z11, nscpt));
        }
    }

    private void a(final CampaignUnit campaignUnit, List<CampaignEx> list) {
        com.mbridge.msdk.foundation.same.f.b.b().execute(new Runnable() { // from class: com.mbridge.msdk.reward.adapter.c.7
            @Override // java.lang.Runnable
            public final void run() {
                k.a(com.mbridge.msdk.foundation.db.h.a(c.this.f46709k)).a();
                CampaignUnit campaignUnit2 = campaignUnit;
                if (campaignUnit2 == null || campaignUnit2.getAds() == null || campaignUnit.getAds().size() <= 0) {
                    return;
                }
                c.a(c.this, campaignUnit.getAds());
            }
        });
    }

    private void a(com.mbridge.msdk.foundation.same.report.d.b bVar) {
        if (this.O != null) {
            Message messageObtain = Message.obtain();
            messageObtain.what = 3;
            if (bVar != null) {
                Bundle bundle = new Bundle();
                bundle.putString("metrics_data_lrid", bVar.f());
                messageObtain.setData(bundle);
            }
            this.O.sendMessage(messageObtain);
        }
    }

    private void a(com.mbridge.msdk.foundation.same.report.d.b bVar, com.mbridge.msdk.foundation.same.report.d.d dVar, List<CampaignEx> list) {
        if (bVar != null) {
            if (list != null) {
                try {
                    if (list.size() > 0) {
                        bVar.b(list);
                        CampaignEx campaignEx = list.get(0);
                        if (campaignEx != null) {
                            bVar.c(campaignEx.getLocalRequestId());
                        }
                    }
                } catch (Exception e11) {
                    if (MBridgeConstans.DEBUG) {
                        e11.printStackTrace();
                        return;
                    }
                    return;
                }
            }
            bVar.d(this.f46710l);
            bVar.b(this.f46724z ? 287 : 94);
            if (dVar != null) {
                bVar.a("m_temp_is_ready_check", dVar);
            }
            com.mbridge.msdk.reward.c.a.a.a().a("m_temp_is_ready_check", bVar);
        }
    }

    public static /* synthetic */ void a(c cVar, CampaignUnit campaignUnit) {
        if (campaignUnit == null || campaignUnit.getAds() == null || campaignUnit.getAds().size() <= 0) {
            return;
        }
        try {
            com.mbridge.msdk.foundation.same.report.d.b metricsData = campaignUnit.getMetricsData();
            if (metricsData != null) {
                com.mbridge.msdk.foundation.same.report.d.d dVar = new com.mbridge.msdk.foundation.same.report.d.d();
                dVar.a("result", 1);
                dVar.a("timeout", Integer.valueOf(cVar.f46714p));
                dVar.a("hst", cVar.h());
                metricsData.b(campaignUnit.getAds());
                metricsData.a("2000126", dVar);
                campaignUnit.setLocalRequestId(metricsData.f());
                com.mbridge.msdk.reward.c.a.a.a().a("2000126", metricsData);
            }
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                ad.b("RewardMVVideoAdapter", e11.getMessage());
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:17:0x002a A[Catch: Exception -> 0x0027, TryCatch #0 {Exception -> 0x0027, blocks: (B:4:0x0004, B:6:0x000a, B:14:0x0021, B:18:0x002f, B:20:0x004d, B:22:0x0055, B:24:0x0059, B:27:0x0062, B:29:0x007b, B:28:0x0070, B:30:0x0091, B:17:0x002a), top: B:36:0x0004 }] */
    public static /* synthetic */ void a(c cVar, com.mbridge.msdk.foundation.same.report.d.b bVar, int i11) {
        Object objA;
        if (bVar != null) {
            try {
                if (bVar.r()) {
                    return;
                }
                com.mbridge.msdk.foundation.same.report.d.d dVar = new com.mbridge.msdk.foundation.same.report.d.d();
                if (i11 != 3 && i11 != 880023 && i11 != 880041) {
                    switch (i11) {
                        case 10:
                        case 11:
                        case 12:
                            dVar.a("result", "2");
                            break;
                        default:
                            dVar.a("result", "1");
                            break;
                    }
                } else {
                    dVar.a("result", "2");
                }
                dVar.a("timeout", cVar.f46714p + "");
                com.mbridge.msdk.foundation.c.b bVarO = bVar.o();
                if (bVarO != null && (objA = bVarO.a("campaign_request_error")) != null && (objA instanceof com.mbridge.msdk.foundation.same.net.b.a)) {
                    if (((com.mbridge.msdk.foundation.same.net.b.a) objA).f44553c != null) {
                        dVar.a(TrackingKey.CODE, Integer.valueOf(((com.mbridge.msdk.foundation.same.net.b.a) objA).f44553c.f44608d));
                    } else {
                        dVar.a(TrackingKey.CODE, Integer.valueOf(bVarO.a()));
                    }
                    dVar.a("reason", bVarO.b());
                    dVar.a("err_desc", bVarO.l());
                    bVar.a((com.mbridge.msdk.foundation.c.b) null);
                }
                dVar.a("hst", cVar.h());
                bVar.a("2000126", dVar);
                com.mbridge.msdk.reward.c.a.a.a().a("2000126", bVar);
            } catch (Exception e11) {
                if (MBridgeConstans.DEBUG) {
                    e11.printStackTrace();
                }
            }
        }
    }

    public static /* synthetic */ void a(c cVar, String str, List list, List list2, boolean z11) {
        f.a(com.mbridge.msdk.foundation.db.h.a(com.mbridge.msdk.foundation.controller.c.m().c())).a(str, (List<CampaignEx>) list, (List<CampaignEx>) list2, z11);
        if (list2 != null && list2.size() > 0) {
            Iterator it = list2.iterator();
            while (it.hasNext()) {
                CampaignEx campaignEx = (CampaignEx) it.next();
                if (campaignEx.getRewardTemplateMode() != null && !TextUtils.isEmpty(campaignEx.getRewardTemplateMode().e())) {
                    com.mbridge.msdk.videocommon.a.b(str + "_" + campaignEx.getId() + "_" + campaignEx.getRequestId() + "_" + campaignEx.getRewardTemplateMode().e());
                    com.mbridge.msdk.videocommon.a.b(campaignEx.getAdType(), campaignEx);
                }
            }
        }
        if (z11) {
            cVar.a(str, (List<CampaignEx>) list, (List<CampaignEx>) list2);
        }
        if (list == null || list.size() <= 0) {
            return;
        }
        try {
            CampaignEx campaignEx2 = (CampaignEx) list.get(0);
            com.mbridge.msdk.reward.a.a aVar = new com.mbridge.msdk.reward.a.a(str, cVar.f46724z);
            if (campaignEx2 == null || !TextUtils.isEmpty(campaignEx2.getNLRid())) {
                return;
            }
            aVar.a(campaignEx2.getLocalRequestId(), campaignEx2.getRequestId(), 1, campaignEx2.getEcppv());
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public static /* synthetic */ void a(c cVar, String str, List list, boolean z11, String str2) {
        CampaignEx campaignEx;
        if (TextUtils.isEmpty(str) || list == null || list.size() <= 0 || !((campaignEx = (CampaignEx) list.get(0)) == null || TextUtils.isEmpty(campaignEx.getEcppv()) || TextUtils.isEmpty(str2))) {
            f.a(com.mbridge.msdk.foundation.db.h.a(com.mbridge.msdk.foundation.controller.c.m().c())).a(str, (CampaignEx) null, z11, str2);
        } else {
            f.a(com.mbridge.msdk.foundation.db.h.a(com.mbridge.msdk.foundation.controller.c.m().c())).a(str, (List<CampaignEx>) list, z11);
        }
    }

    public static /* synthetic */ void a(c cVar, List list) {
        if (cVar.f46709k == null || list == null || list.size() == 0) {
            return;
        }
        k kVarA = k.a(com.mbridge.msdk.foundation.db.h.a(cVar.f46709k));
        for (int i11 = 0; i11 < list.size(); i11++) {
            CampaignEx campaignEx = (CampaignEx) list.get(i11);
            if (campaignEx != null) {
                if (!com.mbridge.msdk.f.b.a()) {
                    cVar.a(kVarA, campaignEx);
                } else if (!ai.c(cVar.f46709k, campaignEx.getPackageName())) {
                    cVar.a(kVarA, campaignEx);
                }
            }
        }
    }

    private void a(String str, String str2, List<CampaignEx> list) {
        if (com.mbridge.msdk.videocommon.a.a.a() != null) {
            com.mbridge.msdk.videocommon.a.a.a().a(str, str2, list);
        }
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0031  */
    private void a(String str, List<CampaignEx> list, List<CampaignEx> list2) {
        CampaignEx campaignEx;
        String requestId;
        int vcn;
        String bidToken;
        String localRequestId = "";
        if (list != null) {
            try {
                if (list.size() <= 0 || (campaignEx = list.get(0)) == null) {
                    vcn = 1;
                    requestId = "";
                    bidToken = requestId;
                } else {
                    requestId = campaignEx.getRequestId();
                    vcn = campaignEx.getVcn();
                    bidToken = campaignEx.getBidToken();
                    if (TextUtils.isEmpty(campaignEx.getNLRid())) {
                        localRequestId = campaignEx.getLocalRequestId();
                    }
                }
            } catch (Exception e11) {
                if (MBridgeConstans.DEBUG) {
                    e11.printStackTrace();
                    return;
                }
                return;
            }
        } else {
            vcn = 1;
            requestId = "";
            bidToken = requestId;
        }
        if (com.mbridge.msdk.videocommon.a.a.a() != null) {
            com.mbridge.msdk.videocommon.a.a.a().b(str, localRequestId);
            com.mbridge.msdk.videocommon.a.a.a().b(str);
        }
        if (com.mbridge.msdk.videocommon.a.a.a() != null) {
            com.mbridge.msdk.videocommon.a.a.a().b(str, vcn);
        }
        if (list != null && list.size() > 0) {
            com.mbridge.msdk.reward.b.a.a(requestId, bidToken);
            for (CampaignEx campaignEx2 : list) {
                if (campaignEx2 != null) {
                    com.mbridge.msdk.foundation.same.a.d.a(campaignEx2.getCampaignUnitId(), campaignEx2.getRequestId(), campaignEx2.getId(), campaignEx2.getPlct(), campaignEx2.getPlctb(), campaignEx2.getTimestamp());
                }
            }
        }
        if (list2 != null && list2.size() > 0) {
            for (CampaignEx campaignEx3 : list2) {
                if (campaignEx3 != null) {
                    com.mbridge.msdk.foundation.same.a.d.c(campaignEx3.getCampaignUnitId(), campaignEx3.getRequestId());
                }
            }
        }
        com.mbridge.msdk.foundation.same.a.d.c(str);
        com.mbridge.msdk.foundation.db.b.a(com.mbridge.msdk.foundation.controller.c.m().c()).a();
    }

    private void a(String str, boolean z11, final com.mbridge.msdk.foundation.same.report.d.b bVar) {
        boolean zB;
        try {
            if (this.f46709k == null) {
                com.mbridge.msdk.foundation.c.b bVarB = com.mbridge.msdk.foundation.c.a.b(880001, "errorCode: 3507 errorMessage: data load failed, errorMsg is Context is null");
                if (bVar != null) {
                    bVar.a(bVarB);
                }
                b("errorCode: 3507 errorMessage: data load failed, errorMsg is Context is null", bVar);
                return;
            }
            if (an.a(this.f46710l)) {
                com.mbridge.msdk.foundation.c.b bVarB2 = com.mbridge.msdk.foundation.c.a.b(880001, "errorCode: 3507 errorMessage: data load failed, errorMsg is UnitId is null");
                if (bVar != null) {
                    bVar.a(bVarB2);
                }
                b("errorCode: 3507 errorMessage: data load failed, errorMsg is UnitId is null", bVar);
                return;
            }
            if (this.f46719u == null) {
                com.mbridge.msdk.foundation.c.b bVarB3 = com.mbridge.msdk.foundation.c.a.b(880001, "errorCode: 3507 errorMessage: data load failed, errorMsg is RewardUnitSetting is null");
                if (bVar != null) {
                    bVar.a(bVarB3);
                }
                b("errorCode: 3507 errorMessage: data load failed, errorMsg is RewardUnitSetting is null", bVar);
                return;
            }
            if (TextUtils.isEmpty(str)) {
                if (System.currentTimeMillis() - this.J < this.f46719u.a() * 1000) {
                    com.mbridge.msdk.foundation.c.b bVarB4 = com.mbridge.msdk.foundation.c.a.b(880018, "errorCode: 3507 errorMessage: data load failed, errorMsg is EXCEPTION_RETURN_EMPTY");
                    if (bVar != null) {
                        bVar.a(bVarB4);
                        bVar.c(true);
                    }
                    b("errorCode: 3507 errorMessage: data load failed, errorMsg is EXCEPTION_RETURN_EMPTY", bVar);
                    return;
                }
            }
            com.mbridge.msdk.foundation.same.net.h.e eVarA = new d(this.f46711m, this.f46710l, this.f46724z, this.f46719u, bVar != null ? bVar.f() : "").a(this.f46715q, this.f46716r, this.f46712n, k(), "", this.C, str, z11, this.D);
            if (eVarA == null) {
                com.mbridge.msdk.foundation.c.b bVarB5 = com.mbridge.msdk.foundation.c.a.b(880001, "errorCode: 3507 errorMessage: data load failed, errorMsg is Load param is null");
                if (bVar != null) {
                    bVar.a(bVarB5);
                }
                b("errorCode: 3507 errorMessage: data load failed, errorMsg is Load param is null", bVar);
                return;
            }
            this.Q = System.currentTimeMillis();
            com.mbridge.msdk.reward.d.b bVar2 = new com.mbridge.msdk.reward.d.b(this.f46709k);
            com.mbridge.msdk.reward.d.a aVar = new com.mbridge.msdk.reward.d.a() { // from class: com.mbridge.msdk.reward.adapter.c.2
                @Override // com.mbridge.msdk.reward.d.a
                public final void a(int i11, String str2, com.mbridge.msdk.foundation.same.report.d.b bVar3) {
                    CampaignEx campaignEx;
                    if (i11 == -1) {
                        c.this.J = System.currentTimeMillis();
                    }
                    if (c.this.H != null && c.this.H.size() > 0 && (campaignEx = (CampaignEx) c.this.H.get(0)) != null && TextUtils.isEmpty(campaignEx.getNLRid())) {
                        c.this.H.clear();
                    }
                    if (c.this.S != null) {
                        c.this.S.clear();
                    }
                    c.this.f46703e = false;
                    c.this.f46704f = false;
                    synchronized (c.this.f46699a) {
                        try {
                            if (c.this.f46705g) {
                                c.this.f46705g = false;
                            }
                        } catch (Throwable th2) {
                            throw th2;
                        }
                    }
                    c.a(c.this, bVar3, i11);
                    c.this.f46707i = false;
                    c.this.f46706h = false;
                    if (!c.this.P) {
                        c.this.a(i11, str2, bVar3);
                    }
                    c.this.j();
                }

                @Override // com.mbridge.msdk.reward.d.a
                public final void a(CampaignUnit campaignUnit) throws Throwable {
                    CampaignEx campaignEx;
                    try {
                        c.a(c.this, campaignUnit);
                        c.b(c.this, campaignUnit);
                        if (campaignUnit != null) {
                            c.this.f46700b = campaignUnit.getRequestId();
                        }
                    } catch (Exception e11) {
                        if (MBridgeConstans.DEBUG) {
                            e11.printStackTrace();
                        }
                        if (c.this.H != null && c.this.H.size() > 0 && (campaignEx = (CampaignEx) c.this.H.get(0)) != null && TextUtils.isEmpty(campaignEx.getNLRid())) {
                            c.this.H.clear();
                        }
                        if (c.this.S != null) {
                            c.this.S.clear();
                        }
                        c.this.f46703e = false;
                        c.this.f46704f = false;
                        synchronized (c.this.f46699a) {
                            try {
                                if (c.this.f46705g) {
                                    c.this.f46705g = false;
                                }
                                c.this.f46707i = false;
                                c.this.f46706h = false;
                                c.this.b("exception after load success", bVar);
                                c.this.j();
                            } catch (Throwable th2) {
                                throw th2;
                            }
                        }
                    }
                }
            };
            aVar.a(str);
            aVar.setUnitId(this.f46710l);
            aVar.setPlacementId(this.f46711m);
            aVar.setAdType(this.f46724z ? 287 : 94);
            aVar.a(bVar);
            try {
                zB = com.mbridge.msdk.videocommon.download.h.a().b(this.f46724z ? 287 : 94);
            } catch (Exception e11) {
                if (MBridgeConstans.DEBUG) {
                    ad.b("RewardMVVideoAdapter", "isRewardVideoRefactorForCampaignRequest exception " + e11.getMessage());
                }
                zB = false;
            }
            try {
                if (com.mbridge.msdk.foundation.same.net.g.c.a().a(eVarA) == null) {
                    com.mbridge.msdk.foundation.same.report.d.d dVar = new com.mbridge.msdk.foundation.same.report.d.d();
                    dVar.a("hst", h());
                    bVar.a("2000125", dVar);
                    com.mbridge.msdk.reward.c.a.a.a().a("2000125", bVar);
                }
            } catch (Exception e12) {
                if (MBridgeConstans.DEBUG) {
                    e12.printStackTrace();
                }
            }
            if (zB) {
                bVar2.getCampaign(1, str, eVarA, new com.mbridge.msdk.foundation.same.net.b(com.mbridge.msdk.videocommon.download.h.a().a("r_v_c_r_t_c", com.mbridge.msdk.foundation.same.a.f44380p), com.mbridge.msdk.videocommon.download.h.a().a("r_v_c_r_t_r", com.mbridge.msdk.foundation.same.a.f44381q), com.mbridge.msdk.videocommon.download.h.a().a("r_v_c_r_t_w", com.mbridge.msdk.foundation.same.a.f44381q), this.f46714p * 1000, com.mbridge.msdk.videocommon.download.h.a().a("r_v_c_r_r_c", com.mbridge.msdk.foundation.same.a.f44382r), 4), aVar);
                return;
            }
            int iC = com.mbridge.msdk.foundation.same.a.f44381q;
            int iE = com.mbridge.msdk.foundation.same.a.f44383s;
            int iB = com.mbridge.msdk.foundation.same.a.f44379o;
            int iD = com.mbridge.msdk.foundation.same.a.f44382r;
            try {
                com.mbridge.msdk.c.g gVarA = com.mbridge.msdk.c.h.a().a(com.mbridge.msdk.foundation.controller.c.m().k());
                if (gVarA != null) {
                    iC = gVarA.c();
                    iE = gVarA.e();
                    iB = gVarA.b();
                    iD = gVarA.d();
                }
            } catch (Exception e13) {
                if (MBridgeConstans.DEBUG) {
                    ad.b("RewardMVVideoAdapter", e13.getMessage());
                }
            }
            bVar2.choiceV3OrV5BySetting(1, eVarA, aVar, str, new com.mbridge.msdk.foundation.same.net.b(iB, iC, iE, this.f46714p * 1000, iD, 4));
        } catch (Exception e14) {
            e14.printStackTrace();
            b("Load exception", bVar);
            j();
        }
    }

    private boolean a(List<CampaignEx> list, boolean z11, int i11, boolean z12) {
        return a(list, z11, i11, false, z12);
    }

    public static /* synthetic */ void b(c cVar, CampaignUnit campaignUnit) throws Throwable {
        cVar.G = campaignUnit;
        CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayListA = cVar.a(campaignUnit);
        new com.mbridge.msdk.reward.a.a(cVar.f46710l, cVar.f46724z).a(copyOnWriteArrayListA, cVar.K, cVar, cVar.f46710l);
        cVar.a(copyOnWriteArrayListA, true, false);
    }

    private void b(String str) {
        if (an.b(str)) {
            com.mbridge.msdk.reward.b.a.f46784d = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, com.mbridge.msdk.foundation.same.report.d.b bVar) {
        if (this.O != null) {
            if (TextUtils.isEmpty(str)) {
                str = "load fail exception";
            }
            Message messageObtain = Message.obtain();
            messageObtain.what = 4;
            messageObtain.obj = str;
            if (bVar != null) {
                bVar.c(true);
                Bundle bundle = new Bundle();
                bundle.putString("metrics_data_lrid", bVar.f());
                messageObtain.setData(bundle);
            }
            if (str.contains("exception")) {
                this.O.sendMessageAtFrontOfQueue(messageObtain);
            } else {
                this.O.sendMessage(messageObtain);
            }
        }
    }

    private void b(String str, boolean z11, com.mbridge.msdk.foundation.same.report.d.b bVar) {
        com.mbridge.msdk.foundation.same.f.b.h().execute(new b(str, bVar));
        if (this.O == null) {
            a(str, z11, bVar);
            return;
        }
        a aVar = new a(str, bVar);
        this.L = aVar;
        this.O.postDelayed(aVar, 90000L);
    }

    private void b(List<CampaignEx> list) {
        if (list != null) {
            try {
                if (list.size() > 0) {
                    this.f46712n += list.size();
                }
            } catch (Exception e11) {
                e11.printStackTrace();
                return;
            }
        }
        com.mbridge.msdk.videocommon.d.c cVar = this.f46719u;
        if (cVar == null || this.f46712n > cVar.v()) {
            this.f46712n = 0;
        }
        if (an.b(this.f46710l)) {
            com.mbridge.msdk.reward.b.a.a(this.f46710l, this.f46712n);
        }
    }

    private boolean b(CampaignEx campaignEx) {
        if (campaignEx == null) {
            return false;
        }
        try {
            return campaignEx.getPlayable_ads_without_video() == 2;
        } catch (Throwable th2) {
            if (!MBridgeConstans.DEBUG) {
                return false;
            }
            th2.printStackTrace();
            return false;
        }
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0059  */
    /* JADX WARN: Code duplicated, block: B:16:0x005c  */
    private com.mbridge.msdk.foundation.same.report.d.b c(List<CampaignEx> list) {
        int i11;
        com.mbridge.msdk.foundation.same.report.d.b bVar = new com.mbridge.msdk.foundation.same.report.d.b();
        String localRequestId = "";
        if (list != null) {
            try {
                if (list.size() > 0) {
                    localRequestId = list.get(0) != null ? list.get(0).getLocalRequestId() : "";
                    bVar.c(localRequestId);
                    bVar.b(list);
                }
                com.mbridge.msdk.foundation.same.report.d.d dVar = new com.mbridge.msdk.foundation.same.report.d.d();
                dVar.a("cache", 1);
                dVar.a(CampaignEx.JSON_KEY_HB, 1);
                dVar.a("auto_load", 2);
                bVar.a("2000127", dVar);
                bVar.a("2000048", dVar);
                if (this.f46724z) {
                    i11 = 287;
                } else {
                    i11 = 94;
                }
                bVar.b(i11);
                bVar.i("1");
                bVar.b("2");
                if (!TextUtils.isEmpty(localRequestId) && !com.mbridge.msdk.foundation.same.report.d.c.a().b().containsKey(localRequestId)) {
                    com.mbridge.msdk.foundation.same.report.d.c.a().b().put(localRequestId, bVar);
                }
            } catch (Exception e11) {
                if (MBridgeConstans.DEBUG) {
                    e11.printStackTrace();
                }
            }
        } else {
            com.mbridge.msdk.foundation.same.report.d.d dVar2 = new com.mbridge.msdk.foundation.same.report.d.d();
            dVar2.a("cache", 1);
            dVar2.a(CampaignEx.JSON_KEY_HB, 1);
            dVar2.a("auto_load", 2);
            bVar.a("2000127", dVar2);
            bVar.a("2000048", dVar2);
            if (this.f46724z) {
                i11 = 287;
            } else {
                i11 = 94;
            }
            bVar.b(i11);
            bVar.i("1");
            bVar.b("2");
            if (!TextUtils.isEmpty(localRequestId)) {
                com.mbridge.msdk.foundation.same.report.d.c.a().b().put(localRequestId, bVar);
            }
        }
        return bVar;
    }

    /* JADX WARN: Code duplicated, block: B:26:0x006f A[EDGE_INSN: B:26:0x006f->B:27:0x0072 BREAK  A[LOOP:0: B:18:0x004e->B:40:0x004e]] */
    private void g() {
        String strD;
        String strB;
        List<com.mbridge.msdk.foundation.entity.d> listA = com.mbridge.msdk.foundation.db.b.a(com.mbridge.msdk.foundation.controller.c.m().c()).a(this.f46710l, this.f46701c);
        if (listA != null) {
            int size = listA.size();
            String strB2 = com.mbridge.msdk.foundation.same.a.d.b(this.f46710l);
            if (size == 0) {
                return;
            }
            try {
                if (size != 1) {
                    if (!TextUtils.isEmpty(strB2)) {
                        Iterator<com.mbridge.msdk.foundation.entity.d> it = listA.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                strD = "";
                                strB = "";
                                break;
                            }
                            com.mbridge.msdk.foundation.entity.d next = it.next();
                            if (next != null && strB2.equals(next.a())) {
                                strD = next.d();
                                strB = next.b();
                                break;
                            }
                        }
                    } else {
                        strD = "";
                        strB = "";
                        break;
                    }
                } else if (listA.get(0) == null) {
                    strD = "";
                    strB = "";
                    break;
                } else {
                    strD = listA.get(0).d();
                    strB = listA.get(0).b();
                }
                if (TextUtils.isEmpty(strD) || !strD.equals(this.f46701c)) {
                    return;
                }
                com.mbridge.msdk.foundation.db.b.a(com.mbridge.msdk.foundation.controller.c.m().c()).b(strB2, this.f46710l);
                com.mbridge.msdk.foundation.same.a.d.a(this.f46710l, this.f46701c, strB);
                com.mbridge.msdk.foundation.same.a.d.c(this.f46710l);
            } catch (Exception e11) {
                ad.a("RewardMVVideoAdapter", e11.getMessage());
            }
        }
    }

    private String h() {
        com.mbridge.msdk.c.g gVarA = com.mbridge.msdk.c.h.a().a(com.mbridge.msdk.foundation.controller.c.m().k());
        return com.mbridge.msdk.foundation.same.net.g.d.f().a(this.K, TextUtils.isEmpty(this.K) ? gVarA.ar() : gVarA.F());
    }

    private void i() {
        if (com.mbridge.msdk.videocommon.a.a.a() != null) {
            try {
                com.mbridge.msdk.c.g gVarB = com.mbridge.msdk.c.h.a().b(com.mbridge.msdk.foundation.controller.c.m().k());
                if (gVarB == null) {
                    com.mbridge.msdk.c.h.a();
                    gVarB = i.a();
                }
                com.mbridge.msdk.videocommon.a.a.a().a(gVarB.ac() * 1000, this.f46710l);
            } catch (Exception e11) {
                if (MBridgeConstans.DEBUG) {
                    e11.printStackTrace();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        try {
            if (an.b(this.f46710l)) {
                com.mbridge.msdk.reward.b.a.a(this.f46710l, 0);
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    private String k() {
        try {
            return an.b(com.mbridge.msdk.reward.b.a.f46784d) ? com.mbridge.msdk.reward.b.a.f46784d : "";
        } catch (Exception e11) {
            e11.printStackTrace();
            return "";
        }
    }

    private void l() {
        try {
            Map<String, Long> map = com.mbridge.msdk.foundation.same.a.d.f44407k;
            if (map == null || map.size() <= 0) {
                return;
            }
            com.mbridge.msdk.foundation.same.a.d.f44407k.clear();
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                e11.printStackTrace();
            }
        }
    }

    private void m() {
        try {
            j.a(com.mbridge.msdk.foundation.db.h.a(this.f46709k)).a(this.f46710l);
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                e11.printStackTrace();
            }
        }
    }

    public final String a() {
        return this.f46710l;
    }

    public final String a(boolean z11) {
        CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayListA;
        CampaignEx campaignEx;
        if (!z11) {
            return this.f46700b;
        }
        if (TextUtils.isEmpty(this.f46701c) && (copyOnWriteArrayListA = com.mbridge.msdk.videocommon.download.b.getInstance().a(this.f46710l)) != null && copyOnWriteArrayListA.size() > 0 && (campaignEx = copyOnWriteArrayListA.get(0)) != null) {
            this.f46701c = campaignEx.getRequestId();
        }
        return this.f46701c;
    }

    public final void a(int i11) {
        this.f46723y = i11;
    }

    public final void a(int i11, int i12, int i13) {
        this.D = i11;
        this.E = i12;
        this.F = i13;
    }

    public final void a(int i11, int i12, boolean z11, com.mbridge.msdk.foundation.same.report.d.b bVar) {
        a(i11, i12, z11, "", this.I, bVar);
    }

    public final void a(int i11, int i12, boolean z11, String str, boolean z12, com.mbridge.msdk.foundation.same.report.d.b bVar) {
        CampaignEx campaignEx;
        this.f46713o = i11;
        this.f46714p = i12;
        this.f46715q = z11;
        this.K = str;
        this.I = z12;
        boolean zA = false;
        this.f46708j = false;
        CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList = this.H;
        if (copyOnWriteArrayList != null && copyOnWriteArrayList.size() > 0 && (campaignEx = this.H.get(0)) != null && TextUtils.isEmpty(campaignEx.getNLRid())) {
            this.H.clear();
        }
        List<CampaignEx> list = this.S;
        if (list != null) {
            list.clear();
        }
        CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList2 = this.T;
        if (copyOnWriteArrayList2 != null) {
            copyOnWriteArrayList2.clear();
        }
        this.f46703e = false;
        this.f46704f = false;
        synchronized (this.f46699a) {
            try {
                if (this.f46705g) {
                    this.f46705g = false;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        this.f46707i = false;
        this.f46706h = false;
        try {
            zA = com.mbridge.msdk.mbsignalcommon.webEnvCheck.a.a(this.f46709k);
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                ad.b("RewardMVVideoAdapter", e11.getMessage());
            }
        }
        if (!zA) {
            com.mbridge.msdk.foundation.c.b bVarB = com.mbridge.msdk.foundation.c.a.b(880001, "errorCode: 3507 errorMessage: data load failed, errorMsg is WebView is not available");
            if (bVar != null) {
                bVar.a(bVarB);
            }
            b("errorCode: 3507 errorMessage: data load failed, errorMsg is WebView is not available", bVar);
            return;
        }
        if (this.f46709k == null) {
            com.mbridge.msdk.foundation.c.b bVarB2 = com.mbridge.msdk.foundation.c.a.b(880001, "errorCode: 3507 errorMessage: data load failed, errorMsg is Context is null");
            if (bVar != null) {
                bVar.a(bVarB2);
            }
            b("errorCode: 3507 errorMessage: data load failed, errorMsg is Context is null", bVar);
            return;
        }
        if (an.a(this.f46710l)) {
            com.mbridge.msdk.foundation.c.b bVarB3 = com.mbridge.msdk.foundation.c.a.b(880001, "errorCode: 3507 errorMessage: data load failed, errorMsg is UnitId is null");
            if (bVar != null) {
                bVar.a(bVarB3);
            }
            b("errorCode: 3507 errorMessage: data load failed, errorMsg is UnitId is null", bVar);
            return;
        }
        if (this.f46719u != null) {
            l();
            m();
            ad.c("RewardMVVideoAdapter", "load 开始清除过期数据");
            i();
            b(str, z12, bVar);
            return;
        }
        com.mbridge.msdk.foundation.c.b bVarB4 = com.mbridge.msdk.foundation.c.a.b(880001, "errorCode: 3507 errorMessage: data load failed, errorMsg is RewardUnitSetting is null");
        if (bVar != null) {
            bVar.a(bVarB4);
        }
        b("RewardUnitSetting is null", bVar);
    }

    public final void a(com.mbridge.msdk.reward.adapter.a aVar) {
        this.f46718t = aVar;
    }

    public final void a(h hVar, String str, String str2, int i11, String str3, com.mbridge.msdk.foundation.same.report.d.b bVar) {
        try {
            this.f46717s = hVar;
            if (this.f46709k != null && !an.a(this.f46710l)) {
                Intent intent = new Intent(this.f46709k, (Class<?>) MBRewardVideoActivity.class);
                intent.putExtra(MBRewardVideoActivity.INTENT_UNITID, this.f46710l);
                intent.putExtra(MBridgeConstans.PLACEMENT_ID, this.f46711m);
                intent.putExtra(MBRewardVideoActivity.INTENT_REWARD, str);
                intent.putExtra(MBRewardVideoActivity.INTENT_MUTE, i11);
                intent.putExtra(MBRewardVideoActivity.INTENT_ISIV, this.f46724z);
                intent.putExtra(MBRewardVideoActivity.INTENT_ISBID, this.A);
                intent.putExtra(MBRewardVideoActivity.INTENT_EXTRADATA, str3);
                CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayListA = com.mbridge.msdk.videocommon.download.b.getInstance().a(this.f46710l);
                boolean z11 = false;
                if (copyOnWriteArrayListA == null || copyOnWriteArrayListA.size() <= 0) {
                    h hVar2 = this.f46717s;
                    if (hVar2 != null) {
                        hVar2.a(bVar, "load failed");
                        return;
                    }
                } else {
                    CampaignEx campaignEx = copyOnWriteArrayListA.get(0);
                    if (campaignEx != null) {
                        this.f46701c = campaignEx.getRequestId();
                    }
                    if (campaignEx != null && !TextUtils.isEmpty(campaignEx.getCMPTEntryUrl())) {
                        z11 = true;
                    }
                    g();
                }
                intent.putExtra(MBRewardVideoActivity.INTENT_ISBIG_OFFER, z11);
                if (this.f46724z) {
                    intent.putExtra(MBRewardVideoActivity.INTENT_IVREWARD_MODETYPE, this.D);
                    intent.putExtra(MBRewardVideoActivity.INTENT_IVREWARD_VALUETYPE, this.E);
                    intent.putExtra(MBRewardVideoActivity.INTENT_IVREWARD_VALUE, this.F);
                }
                if (!TextUtils.isEmpty(str2)) {
                    intent.putExtra(MBRewardVideoActivity.INTENT_USERID, str2);
                }
                RewardUnitCacheManager.getInstance().add(this.f46711m, this.f46710l, this.f46719u);
                try {
                    if (com.mbridge.msdk.foundation.controller.c.m() != null && com.mbridge.msdk.foundation.controller.c.m().e() != null) {
                        ((Activity) com.mbridge.msdk.foundation.controller.c.m().e()).startActivity(intent);
                        return;
                    }
                } catch (Throwable th2) {
                    ad.b("RewardMVVideoAdapter", th2.getMessage());
                }
                intent.addFlags(ASTNode.DEOP);
                this.f46709k.startActivity(intent);
                return;
            }
            h hVar3 = this.f46717s;
            if (hVar3 != null) {
                hVar3.a(bVar, "context or unitid is null");
            }
        } catch (Exception e11) {
            e11.printStackTrace();
            h hVar4 = this.f46717s;
            if (hVar4 != null) {
                hVar4.a(bVar, "show failed, exception is " + e11.getMessage());
            }
        }
    }

    public final void a(com.mbridge.msdk.videocommon.d.c cVar) {
        try {
            this.f46719u = cVar;
            if (cVar == null || cVar.D() * 1000 == com.mbridge.msdk.foundation.same.a.K) {
                return;
            }
            com.mbridge.msdk.foundation.same.a.K = this.f46719u.D() * 1000;
        } catch (Throwable th2) {
            ad.a("RewardMVVideoAdapter", th2.getMessage(), th2);
        }
    }

    public final void a(String str) {
        this.B = str;
    }

    public final void a(String str, com.mbridge.msdk.foundation.same.report.d.b bVar) {
        if (this.f46719u != null && TextUtils.isEmpty(str)) {
            int iB = this.f46719u.b() * 1000;
            List<CampaignEx> list = this.U;
            if (list != null && list.size() > 0) {
                if (System.currentTimeMillis() - this.U.get(0).getTimestamp() < iB) {
                    b("hit ltorwc", bVar);
                    return;
                }
            }
        }
        a(str, this.I, bVar);
    }

    public final void a(List<CampaignEx> list) {
        this.U = list;
    }

    public final void a(CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList, boolean z11, boolean z12) {
        com.mbridge.msdk.foundation.same.report.d.b metricsData;
        try {
            if (z12) {
                this.S = copyOnWriteArrayList;
                CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList2 = new CopyOnWriteArrayList<>(copyOnWriteArrayList);
                this.T = copyOnWriteArrayList2;
                metricsData = c(copyOnWriteArrayList2);
            } else {
                metricsData = this.G.getMetricsData();
            }
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                ad.b("RewardMVVideoAdapter", e11.getMessage());
            }
            metricsData = null;
        }
        a(this.G, copyOnWriteArrayList);
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.size() <= 0) {
            ad.c("RewardMVVideoAdapter", "onload load fail, callback campaign have not video");
            if (TextUtils.isEmpty(this.R)) {
                this.R = "APP ALREADY INSTALLED";
            }
            a(this.R.contains("INSTALL") ? 880021 : 880003, this.R, metricsData);
            return;
        }
        ad.c("RewardMVVideoAdapter", "onload load success size:" + copyOnWriteArrayList.size());
        if (z11) {
            com.mbridge.msdk.foundation.same.report.d.d dVar = new com.mbridge.msdk.foundation.same.report.d.d();
            if (z12) {
                dVar.a("cache", 1);
            } else {
                dVar.a("cache", 2);
            }
            if (metricsData != null) {
                metricsData.a("2000127", dVar);
                metricsData.a("2000048", dVar);
            }
            a(metricsData);
        }
        CampaignUnit campaignUnit = this.G;
        if (campaignUnit != null) {
            b(campaignUnit.getSessionId());
        }
        b(copyOnWriteArrayList);
        if (copyOnWriteArrayList.size() > 0) {
            ad.c("RewardMVVideoAdapter", "#######onload 把广告存在本地 size:" + copyOnWriteArrayList.size());
            a(this.f46711m, this.f46710l, copyOnWriteArrayList);
        }
        CampaignEx campaignEx = copyOnWriteArrayList.get(0);
        this.H = copyOnWriteArrayList;
        a(campaignEx);
    }

    public final boolean a(CampaignEx campaignEx, boolean z11, com.mbridge.msdk.foundation.c.b bVar, int i11, com.mbridge.msdk.foundation.same.report.d.b bVar2) {
        com.mbridge.msdk.foundation.b.c cVar;
        com.mbridge.msdk.foundation.b.c cVar2 = new com.mbridge.msdk.foundation.b.c();
        com.mbridge.msdk.reward.a.a aVar = new com.mbridge.msdk.reward.a.a(this.f46710l, this.f46724z);
        boolean z12 = false;
        if (aVar.a(this.K)) {
            return false;
        }
        if (!this.f46708j) {
            this.f46708j = true;
            cVar2 = aVar.a(this.K, bVar2, campaignEx, bVar, i11, this);
            if (cVar2 != null && cVar2.g() > com.mbridge.msdk.foundation.b.c.f44009a) {
                if (cVar2.a() != null && cVar2.a().size() > 0) {
                    a(cVar2.a(), true, true);
                } else if (cVar2.g() == com.mbridge.msdk.foundation.b.c.f44011c && bVar != null) {
                    bVar.b(com.mbridge.msdk.foundation.c.a.b(880038));
                    bVar.b(cVar2.b());
                }
            }
            cVar = cVar2;
            aVar.a(bVar2, this.K, cVar, (List<com.mbridge.msdk.foundation.b.a.C0483a>) null, (JSONObject) null, 3);
            return z12;
        }
        cVar2.d("isCandidate:false");
        cVar2.a(com.mbridge.msdk.foundation.b.c.f44011c);
        cVar = cVar2;
        z12 = true;
        aVar.a(bVar2, this.K, cVar, (List<com.mbridge.msdk.foundation.b.a.C0483a>) null, (JSONObject) null, 3);
        return z12;
    }

    public final boolean a(List<CampaignEx> list, boolean z11) {
        if (list == null || list.size() <= 0) {
            ad.a("RewardVideoController", "数据为空");
        } else {
            CampaignEx campaignEx = list.get(0);
            if (campaignEx == null) {
                return false;
            }
            com.mbridge.msdk.videocommon.download.b bVar = com.mbridge.msdk.videocommon.download.b.getInstance();
            String str = this.f46710l;
            com.mbridge.msdk.videocommon.download.j jVarC = bVar.c(str);
            if (jVarC == null) {
                jVarC = bVar.createUnitCache(com.mbridge.msdk.foundation.controller.c.m().c(), str, (CopyOnWriteArrayList<CampaignEx>) list, 94, (com.mbridge.msdk.videocommon.listener.a) null);
            }
            if (jVarC != null && jVarC.a(list, str)) {
                if (z11) {
                    if (campaignEx.isDynamicView()) {
                        return true;
                    }
                    if (campaignEx.getRsIgnoreCheckRule() != null && campaignEx.getRsIgnoreCheckRule().size() > 0) {
                        if (campaignEx.getRsIgnoreCheckRule().contains(3)) {
                            ad.c("RewardMVVideoAdapter", "Is not check big template download status");
                            return true;
                        }
                        if (campaignEx.getCMPTEntryUrl().equals(campaignEx.getendcard_url()) && campaignEx.getRsIgnoreCheckRule().contains(2)) {
                            ad.c("RewardMVVideoAdapter", "Is not check big template ENDCARD download status");
                            return true;
                        }
                    }
                    if (ResDownloadCheckManager.getInstance().checkPreLoadState(this.f46710l + "_" + campaignEx.getRequestId() + "_" + campaignEx.getCMPTEntryUrl())) {
                        ad.a("RewardVideoController", "大模板业务，开始检查大模板预加载情况，大模板预加载成功");
                        return true;
                    }
                } else {
                    if (campaignEx.isDynamicView()) {
                        return true;
                    }
                    if (campaignEx.getRsIgnoreCheckRule() != null && campaignEx.getRsIgnoreCheckRule().size() > 0 && campaignEx.getRsIgnoreCheckRule().contains(1)) {
                        ad.c("RewardMVVideoAdapter", "Is not check template download status");
                        return true;
                    }
                    if (campaignEx.getRewardTemplateMode() == null || TextUtils.isEmpty(campaignEx.getRewardTemplateMode().e())) {
                        ad.a("RewardVideoController", "非大模板 没有 template");
                        return true;
                    }
                    if (ResDownloadCheckManager.getInstance().checkPreLoadState(this.f46710l + "_" + campaignEx.getRequestId() + "_" + campaignEx.getRewardTemplateMode().e())) {
                        ad.a("RewardVideoController", "非大模板业务，存在播放模板，播放模板预加载成功");
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final boolean a(List<CampaignEx> list, boolean z11, int i11) {
        return a(list, z11, i11, false, false);
    }

    public final boolean a(List<CampaignEx> list, boolean z11, int i11, boolean z12, boolean z13) {
        com.mbridge.msdk.foundation.same.report.d.b bVar = new com.mbridge.msdk.foundation.same.report.d.b();
        com.mbridge.msdk.foundation.same.report.d.d dVar = new com.mbridge.msdk.foundation.same.report.d.d();
        if (list == null || list.size() <= 0) {
            dVar.a("event_name", "is_ready_crwtpl_empty");
            dVar.a("reason", "campaign list is empty error");
        } else {
            CampaignEx campaignEx = list.get(0);
            boolean zA = com.mbridge.msdk.videocommon.download.b.getInstance().a(94, this.f46710l, this.A, list.size(), z11, i11, list, z12, dVar);
            dVar.a("event_name", "is_ready_crwtpl_" + zA);
            if (z13) {
                a(bVar, dVar, list);
            }
            if (zA) {
                if (z11) {
                    if (campaignEx.isDynamicView()) {
                        return true;
                    }
                    if (campaignEx.getRsIgnoreCheckRule() != null && campaignEx.getRsIgnoreCheckRule().size() > 0) {
                        if (campaignEx.getRsIgnoreCheckRule().contains(3)) {
                            ad.c("RewardMVVideoAdapter", "Is not check big template download status");
                            return true;
                        }
                        if (campaignEx.getCMPTEntryUrl().equals(campaignEx.getendcard_url()) && campaignEx.getRsIgnoreCheckRule().contains(2)) {
                            ad.c("RewardMVVideoAdapter", "Is not check big template of ENDCARD download status");
                            return true;
                        }
                    }
                    if (ResDownloadCheckManager.getInstance().checkPreLoadState(this.f46710l + "_" + campaignEx.getRequestId() + "_" + campaignEx.getCMPTEntryUrl())) {
                        return true;
                    }
                    if (z13) {
                        dVar.a("event_name", "is_ready_crwtpl_" + zA);
                        dVar.a("reason", "h5 big template checkPreLoadState error");
                        a(bVar, dVar, list);
                    }
                } else {
                    if (campaignEx != null && campaignEx.isDynamicView()) {
                        return true;
                    }
                    if (campaignEx != null && campaignEx.getRsIgnoreCheckRule() != null && campaignEx.getRsIgnoreCheckRule().size() > 0 && campaignEx.getRsIgnoreCheckRule().contains(1)) {
                        ad.c("RewardMVVideoAdapter", "Is not check template download status");
                        return true;
                    }
                    if (campaignEx == null || campaignEx.getRewardTemplateMode() == null || TextUtils.isEmpty(campaignEx.getRewardTemplateMode().e())) {
                        return true;
                    }
                    String str = this.f46710l + "_" + campaignEx.getRequestId() + "_" + campaignEx.getRewardTemplateMode().e();
                    if (z13) {
                        ResDownloadCheckManager.getInstance().setTemplatePreLoadDone(str, true);
                    }
                    if (ResDownloadCheckManager.getInstance().checkPreLoadState(str)) {
                        return true;
                    }
                    if (z13) {
                        dVar.a("event_name", "is_ready_crwtpl_" + zA);
                        dVar.a("reason", "h5 template checkPreLoadState error");
                        a(bVar, dVar, list);
                    }
                }
            }
        }
        a(bVar, dVar, list);
        return false;
    }

    public final void b(boolean z11) {
        this.f46724z = z11;
    }

    public final boolean b() {
        return d(false);
    }

    public final void c(boolean z11) {
        this.A = z11;
    }

    public final boolean c() {
        List<CampaignEx> listC = com.mbridge.msdk.videocommon.a.a.a().c(this.f46710l, 1, this.A, this.B);
        if (listC == null || listC.size() <= 0) {
            ad.a("test_isReay_db", "database has not can use data");
            return false;
        }
        CampaignEx campaignEx = listC.get(0);
        int iB = com.mbridge.msdk.videocommon.a.a.a().b(this.f46710l, 1, this.A, this.B);
        if (TextUtils.isEmpty(campaignEx.getCMPTEntryUrl()) || campaignEx.getNscpt() != 1 || listC.size() >= iB) {
            return a(listC, !TextUtils.isEmpty(campaignEx.getCMPTEntryUrl()), campaignEx.getNscpt());
        }
        return false;
    }

    public final CopyOnWriteArrayList<CampaignEx> d() {
        return this.H;
    }

    public final boolean d(boolean z11) {
        com.mbridge.msdk.foundation.same.report.d.b bVar = new com.mbridge.msdk.foundation.same.report.d.b();
        CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayListA = com.mbridge.msdk.videocommon.a.a.a().a(this.f46710l, 1, this.A, this.B);
        if (copyOnWriteArrayListA == null || copyOnWriteArrayListA.size() <= 0) {
            ad.a("RewardVideoController", "database has not can use data");
            if (z11) {
                com.mbridge.msdk.foundation.same.report.d.d dVar = new com.mbridge.msdk.foundation.same.report.d.d();
                dVar.a("event_name", "is_ready_cse");
                dVar.a("reason", "no effective campaign list");
            }
            return false;
        }
        CampaignEx campaignEx = copyOnWriteArrayListA.get(0);
        int iB = com.mbridge.msdk.videocommon.a.a.a().b(this.f46710l, 1, this.A, this.B);
        if (TextUtils.isEmpty(campaignEx.getCMPTEntryUrl()) || campaignEx.getNscpt() != 1 || copyOnWriteArrayListA.size() >= iB) {
            return a(copyOnWriteArrayListA, !TextUtils.isEmpty(campaignEx.getCMPTEntryUrl()), campaignEx.getNscpt(), z11);
        }
        if (z11) {
            com.mbridge.msdk.foundation.same.report.d.d dVar2 = new com.mbridge.msdk.foundation.same.report.d.d();
            dVar2.a("event_name", "is_ready_cltr");
            dVar2.a("reason", "nscpt error");
            a(bVar, dVar2, copyOnWriteArrayListA);
        }
        return false;
    }

    public final CopyOnWriteArrayList<CampaignEx> e() {
        return this.T;
    }

    public final void e(boolean z11) {
        this.P = z11;
    }

    public final String f() {
        CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList = this.H;
        return (copyOnWriteArrayList == null || copyOnWriteArrayList.isEmpty()) ? com.mbridge.msdk.foundation.same.b.a(this.U) : com.mbridge.msdk.foundation.same.b.a(this.H);
    }

    public final void f(boolean z11) {
        CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList;
        if (z11 || (copyOnWriteArrayList = this.H) == null || copyOnWriteArrayList.size() <= 0) {
            return;
        }
        com.mbridge.msdk.videocommon.a.a.a().a(this.f46710l, this.H);
    }

    public final void g(boolean z11) {
        if (z11) {
            List<CampaignEx> list = this.U;
            if (list == null || list.size() <= 0) {
                return;
            }
            for (CampaignEx campaignEx : this.U) {
                if (campaignEx != null) {
                    campaignEx.setLoadTimeoutState(0);
                    if (campaignEx.getRewardTemplateMode() != null && !TextUtils.isEmpty(campaignEx.getRewardTemplateMode().e())) {
                        ResDownloadCheckManager.getInstance().setTemplatePreLoadDone(this.f46710l + "_" + campaignEx.getRequestId() + "_" + campaignEx.getRewardTemplateMode().e(), false);
                    }
                }
            }
            com.mbridge.msdk.videocommon.a.a.a().a(this.f46710l, this.U, "load_timeout", 0);
            return;
        }
        CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList = this.H;
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.size() <= 0) {
            return;
        }
        for (CampaignEx campaignEx2 : this.H) {
            if (campaignEx2 != null) {
                campaignEx2.setLoadTimeoutState(0);
                if (campaignEx2.getRewardTemplateMode() != null && !TextUtils.isEmpty(campaignEx2.getRewardTemplateMode().e())) {
                    ResDownloadCheckManager.getInstance().setTemplatePreLoadDone(this.f46710l + "_" + campaignEx2.getRequestId() + "_" + campaignEx2.getRewardTemplateMode().e(), false);
                }
            }
        }
        com.mbridge.msdk.videocommon.a.a.a().a(this.f46710l, this.H, "load_timeout", 0);
    }

    public final boolean h(boolean z11) {
        if (z11) {
            List<CampaignEx> list = this.U;
            if (list == null || list.size() <= 0) {
                return false;
            }
            for (CampaignEx campaignEx : this.U) {
                if (campaignEx != null) {
                    campaignEx.setLoadTimeoutState(1);
                    if (campaignEx.getRewardTemplateMode() != null && !TextUtils.isEmpty(campaignEx.getRewardTemplateMode().e())) {
                        ResDownloadCheckManager.getInstance().setTemplatePreLoadDone(this.f46710l + "_" + campaignEx.getRequestId() + "_" + campaignEx.getRewardTemplateMode().e(), true);
                    }
                }
            }
            com.mbridge.msdk.videocommon.a.a.a().a(this.f46710l, this.U, "load_timeout", 1);
            return true;
        }
        CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList = this.H;
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.size() <= 0) {
            return false;
        }
        for (CampaignEx campaignEx2 : this.H) {
            if (campaignEx2 != null) {
                campaignEx2.setLoadTimeoutState(1);
                if (campaignEx2.getRewardTemplateMode() != null && !TextUtils.isEmpty(campaignEx2.getRewardTemplateMode().e())) {
                    ResDownloadCheckManager.getInstance().setTemplatePreLoadDone(this.f46710l + "_" + campaignEx2.getRequestId() + "_" + campaignEx2.getRewardTemplateMode().e(), true);
                }
            }
        }
        com.mbridge.msdk.videocommon.a.a.a().a(this.f46710l, this.H, "load_timeout", 1);
        return true;
    }
}
