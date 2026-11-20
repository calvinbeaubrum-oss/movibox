package com.mbridge.msdk.newreward.function.f;

import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.hisavana.common.constant.ComConstants;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.newreward.function.common.MBridgeCommon;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f46451a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f46452b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f46453c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f46454d;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Handler f46457g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private com.mbridge.msdk.newreward.function.c.c f46459i;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private com.mbridge.msdk.newreward.a.d f46462l;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private volatile boolean f46460j = false;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private volatile boolean f46461k = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f46455e = af.a().a(MBridgeCommon.SettingConfig.KEY_SETTING_CONFIG_LOAD_CHECK_INTERVAL, 120000);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f46458h = af.a().a(MBridgeCommon.SettingConfig.KEY_SETTING_CONFIG_LOAD_TOKEN_VALIDITY_PERIOD, 1800000);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f46456f = af.a().a(MBridgeCommon.SettingConfig.KEY_SETTING_CONFIG_LOAD_CHECK_OPTIMIZED, false);

    public b(int i11, String str, String str2, boolean z11) {
        this.f46451a = i11;
        this.f46452b = str;
        this.f46453c = str2;
        this.f46454d = z11;
    }

    private com.mbridge.msdk.newreward.a.e a(com.mbridge.msdk.newreward.function.d.a.b bVar) {
        com.mbridge.msdk.newreward.a.e eVar = new com.mbridge.msdk.newreward.a.e(false, this.f46451a, bVar.f(), this.f46453c, bVar.g());
        eVar.d(bVar.e());
        eVar.e(ComConstants.AD_TIMEOUT_MILLIS);
        eVar.f(60000);
        eVar.c(this.f46452b);
        eVar.d(true);
        eVar.e(false);
        eVar.f(false);
        return eVar;
    }

    private void a() {
        com.mbridge.msdk.newreward.function.e.c.a().b().b(this.f46451a, this.f46452b, this.f46453c);
    }

    private void a(com.mbridge.msdk.newreward.a.e eVar, com.mbridge.msdk.newreward.function.d.a.b bVar, com.mbridge.msdk.newreward.a.b.b bVar2) {
        eVar.w().a(bVar, bVar2);
    }

    public static /* synthetic */ void a(b bVar) {
        if (bVar.f46462l.a() != null) {
            Iterator<com.mbridge.msdk.newreward.a.e> it = bVar.f46462l.a().iterator();
            while (it.hasNext()) {
                if (it.next().q() == 1) {
                    return;
                }
            }
        }
        if (bVar.f46460j) {
            return;
        }
        bVar.f46460j = true;
        com.mbridge.msdk.newreward.function.e.c.a().b().a(bVar.f46451a, bVar.f46452b, bVar.f46453c, bVar.f46454d, new com.mbridge.msdk.newreward.function.e.b() { // from class: com.mbridge.msdk.newreward.function.f.b.2
            @Override // com.mbridge.msdk.newreward.function.e.b
            public final void a() {
                b.a(b.this, (com.mbridge.msdk.newreward.a.e) null, (com.mbridge.msdk.newreward.function.d.a.b) null);
            }

            @Override // com.mbridge.msdk.newreward.function.e.b
            public final void a(List<com.mbridge.msdk.newreward.function.d.a.b> list) {
                b.a(b.this, list);
            }
        });
    }

    public static /* synthetic */ void a(b bVar, com.mbridge.msdk.newreward.a.e eVar, com.mbridge.msdk.newreward.function.d.a.b bVar2) {
        bVar.f46460j = false;
        if (eVar == null) {
            return;
        }
        try {
            bVar.f46459i.a(eVar, com.mbridge.msdk.newreward.function.c.e.REPORT_LOAD_CHECK, bVar2 == null ? bVar.f46459i.a("check_type", "check_failed") : bVar.f46459i.a("check_type", "check_failed", "campaign", bVar2));
        } catch (Exception e11) {
            ad.b("LoadCheckController", "reportLoadCheckFailed error: " + e11.getMessage());
        }
    }

    public static /* synthetic */ void a(b bVar, com.mbridge.msdk.newreward.function.d.a.b bVar2, com.mbridge.msdk.newreward.a.e eVar) {
        bVar.f46460j = false;
        if (eVar == null) {
            return;
        }
        com.mbridge.msdk.newreward.function.c.c cVar = bVar.f46459i;
        cVar.a(eVar, com.mbridge.msdk.newreward.function.c.e.REPORT_LOAD_CHECK, cVar.a("check_type", "check_success", "campaign", bVar2));
        eVar.c(true);
        if (!bVar2.g() || bVar2.q() <= 0.0d) {
            bVar.f46462l.a(eVar);
        }
    }

    public static /* synthetic */ void a(b bVar, List list) {
        Iterator it = list.iterator();
        final com.mbridge.msdk.newreward.function.d.a.b bVar2 = null;
        final com.mbridge.msdk.newreward.function.d.a.b bVar3 = null;
        while (it.hasNext()) {
            com.mbridge.msdk.newreward.function.d.a.b bVar4 = (com.mbridge.msdk.newreward.function.d.a.b) it.next();
            if (bVar4.g()) {
                long jG = bVar4.G();
                if (jG == 0) {
                    com.mbridge.msdk.newreward.function.e.c.a().b().b(bVar4.a(), bVar4.b(), bVar4.c(), bVar4.e(), 8);
                } else if (TextUtils.isEmpty(bVar4.f())) {
                    com.mbridge.msdk.newreward.function.e.c.a().b().b(bVar4.a(), bVar4.b(), bVar4.c(), bVar4.e(), 8);
                } else if (System.currentTimeMillis() - jG > bVar.f46458h && bVar4.s() == null) {
                    com.mbridge.msdk.newreward.function.e.c.a().b().b(bVar4.a(), bVar4.b(), bVar4.c(), bVar4.e(), 8);
                } else if (bVar4.q() <= 0.0d && bVar4.E() != 1) {
                    com.mbridge.msdk.newreward.function.e.c.a().b().b(bVar4.a(), bVar4.b(), bVar4.c(), bVar4.e(), 8);
                } else if (bVar3 == null || bVar4.q() > bVar3.q()) {
                    bVar3 = bVar4;
                }
            } else if (bVar4.G() == 0) {
                com.mbridge.msdk.newreward.function.e.c.a().b().b(bVar4.a(), bVar4.b(), bVar4.c(), bVar4.e(), 8);
            } else if (bVar4.C() == null || bVar4.C().size() == 0) {
                com.mbridge.msdk.newreward.function.e.c.a().b().b(bVar4.a(), bVar4.b(), bVar4.c(), bVar4.e(), 8);
            } else if (bVar3 == null || bVar4.G() > bVar3.G()) {
                bVar3 = bVar4;
            }
        }
        if (list.size() != 0 && !bVar.f46461k) {
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                com.mbridge.msdk.newreward.function.d.a.b bVar5 = (com.mbridge.msdk.newreward.function.d.a.b) it2.next();
                if (bVar5 != bVar3 && bVar5.s() != null && (bVar2 == null || bVar5.G() > bVar2.G())) {
                    bVar2 = bVar5;
                }
            }
        }
        if (!bVar.f46461k && bVar2 != null) {
            bVar.f46461k = true;
            final com.mbridge.msdk.newreward.a.e eVarA = bVar.a(bVar2);
            try {
                com.mbridge.msdk.newreward.function.c.c cVar = bVar.f46459i;
                cVar.a(eVarA, com.mbridge.msdk.newreward.function.c.e.REPORT_LOAD_CHECK, cVar.a("check_type", "download_start_resource", "campaign", bVar2));
            } catch (Exception e11) {
                ad.b("LoadCheckController", "handlerAnthonyNeedDownloadCampaign error: " + e11.getMessage());
            }
            bVar.a(eVarA, bVar2, new com.mbridge.msdk.newreward.a.b.b() { // from class: com.mbridge.msdk.newreward.function.f.b.4
                @Override // com.mbridge.msdk.newreward.a.b.b
                public final void a(com.mbridge.msdk.foundation.c.b bVar6) {
                    b.this.f46461k = false;
                    try {
                        b.this.f46459i.a(eVarA, com.mbridge.msdk.newreward.function.c.e.REPORT_LOAD_CHECK, b.this.f46459i.a("check_type", "download_failed", "campaign", bVar2));
                    } catch (Exception e12) {
                        ad.b("LoadCheckController", "handlerAnthonyNeedDownloadCampaign error: " + e12.getMessage());
                    }
                }

                @Override // com.mbridge.msdk.newreward.a.b.b
                public final void a(Object obj) {
                    b.this.f46461k = false;
                    try {
                        b.this.f46459i.a(eVarA, com.mbridge.msdk.newreward.function.c.e.REPORT_LOAD_CHECK, b.this.f46459i.a("check_type", "download_success", "campaign", bVar2));
                    } catch (Exception e12) {
                        ad.b("LoadCheckController", "handlerAnthonyNeedDownloadCampaign error: " + e12.getMessage());
                    }
                }
            });
        }
        if (bVar3 == null) {
            bVar.f46460j = false;
            return;
        }
        List<CampaignEx> listC = bVar3.C();
        final com.mbridge.msdk.newreward.a.e eVarA2 = bVar.a(bVar3);
        if (listC != null) {
            try {
                com.mbridge.msdk.newreward.function.c.c cVar2 = bVar.f46459i;
                cVar2.a(eVarA2, com.mbridge.msdk.newreward.function.c.e.REPORT_LOAD_CHECK, cVar2.a("check_type", "check_start_resource"));
            } catch (Exception e12) {
                ad.b("LoadCheckController", "handlerLoadFailedCampaigns error: " + e12.getMessage());
            }
            bVar.a(eVarA2, bVar3, new com.mbridge.msdk.newreward.a.b.b() { // from class: com.mbridge.msdk.newreward.function.f.b.3
                @Override // com.mbridge.msdk.newreward.a.b.b
                public final void a(com.mbridge.msdk.foundation.c.b bVar6) {
                    b.a(b.this, eVarA2, bVar3);
                }

                @Override // com.mbridge.msdk.newreward.a.b.b
                public final void a(Object obj) {
                    b.a(b.this, bVar3, eVarA2);
                }
            });
            return;
        }
        try {
            com.mbridge.msdk.newreward.function.c.c cVar3 = bVar.f46459i;
            cVar3.a(eVarA2, com.mbridge.msdk.newreward.function.c.e.REPORT_LOAD_CHECK, cVar3.a("check_type", "check_start_campaign"));
        } catch (Exception e13) {
            ad.b("LoadCheckController", "handlerLoadFailedCampaigns error: " + e13.getMessage());
        }
        com.mbridge.msdk.newreward.function.c.c cVar4 = bVar.f46459i;
        cVar4.a(cVar4.a("command_manager", cVar4, "adapter_model", eVarA2), new com.mbridge.msdk.newreward.a.b.b() { // from class: com.mbridge.msdk.newreward.function.f.b.5
            @Override // com.mbridge.msdk.newreward.a.b.b
            public final void a(com.mbridge.msdk.foundation.c.b bVar6) {
                b.a(b.this, eVarA2, bVar3);
            }

            @Override // com.mbridge.msdk.newreward.a.b.b
            public final void a(Object obj) {
                b.a(b.this, bVar3, eVarA2);
            }
        });
    }

    public final void a(com.mbridge.msdk.newreward.function.c.c cVar, com.mbridge.msdk.newreward.a.d dVar) {
        if (cVar == null || dVar == null) {
            a();
            return;
        }
        if (!this.f46456f) {
            a();
            return;
        }
        this.f46462l = dVar;
        this.f46459i = cVar;
        HandlerThread handlerThread = new HandlerThread("load_check_controller");
        handlerThread.start();
        Handler handler = new Handler(handlerThread.getLooper());
        this.f46457g = handler;
        handler.postDelayed(new Runnable() { // from class: com.mbridge.msdk.newreward.function.f.b.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    b.a(b.this);
                } catch (Exception e11) {
                    ad.a("LoadCheckController", "startCheckTask error: " + e11.getMessage());
                }
                b.this.f46457g.postDelayed(this, b.this.f46455e);
            }
        }, this.f46455e);
    }
}
