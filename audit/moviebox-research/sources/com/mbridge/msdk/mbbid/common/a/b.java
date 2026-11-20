package com.mbridge.msdk.mbbid.common.a;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.a.d;
import com.mbridge.msdk.foundation.same.net.h.e;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.mbridge.msdk.foundation.tools.ai;
import com.mbridge.msdk.foundation.tools.z;
import com.mbridge.msdk.mbbanner.common.util.BannerUtils;
import com.mbridge.msdk.mbbid.common.BidResponsedEx;
import com.mbridge.msdk.mbbid.out.BidListennning;
import com.mbridge.msdk.mbbid.out.BidResponsed;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f45419a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f45420b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f45421c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private BidListennning f45423e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private BidResponsedEx f45424f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f45425g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private long f45427i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private long f45428j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f45429k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f45430l;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f45426h = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Context f45422d = c.m().c();

    public b(String str, String str2, String str3) {
        this.f45419a = str;
        this.f45420b = str2;
        this.f45421c = str3;
    }

    public static /* synthetic */ void a(b bVar, BidResponsed bidResponsed) {
        BidListennning bidListennning = bVar.f45423e;
        if (bidListennning != null) {
            bidListennning.onSuccessed(bidResponsed);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        BidListennning bidListennning = this.f45423e;
        if (bidListennning != null) {
            bidListennning.onFailed(str);
        }
    }

    public final void a(int i11) {
        this.f45430l = i11;
    }

    public final void a(long j11) {
        this.f45427i = j11;
    }

    public final void a(BidListennning bidListennning) {
        this.f45423e = bidListennning;
    }

    public final void a(boolean z11) {
        this.f45429k = z11;
    }

    public final void b(int i11) {
        this.f45425g = i11;
    }

    public final void b(long j11) {
        this.f45428j = j11;
    }

    public final void b(boolean z11) {
        try {
            if (this.f45426h) {
                a("current unit is biding");
                return;
            }
            this.f45426h = true;
            if (this.f45422d == null) {
                a("context is null");
            }
            com.mbridge.msdk.mbbid.common.b.a aVar = new com.mbridge.msdk.mbbid.common.b.a(this.f45422d);
            e eVar = new e();
            String strK = c.m().k();
            eVar.a("app_id", strK);
            eVar.a("sign", SameMD5.getMD5(strK + c.m().b()));
            eVar.a(MBridgeConstans.PROPERTIES_UNIT_ID, this.f45420b);
            if (TextUtils.isEmpty(this.f45419a)) {
                this.f45419a = "";
            }
            eVar.a("placement_id", this.f45419a);
            if (com.mbridge.msdk.f.b.a()) {
                eVar.a("install_ids", "");
            }
            eVar.a("bid_floor", this.f45421c);
            eVar.a(e.f44660e, ai.a(this.f45422d, this.f45420b));
            eVar.a(e.f44659d, d.a(this.f45420b, ""));
            String str = "1";
            eVar.a("req_type", this.f45429k ? "1" : "2");
            eVar.a("orientation", z.r(this.f45422d) + "");
            int i11 = this.f45425g;
            if (i11 == 296) {
                if (this.f45427i <= 0 || this.f45428j <= 0) {
                    a("bid required param is missing or error");
                    return;
                }
                eVar.a(com.mbridge.msdk.foundation.entity.b.JSON_KEY_UNIT_SIZE, this.f45428j + "x" + this.f45427i);
                try {
                    int i12 = BannerUtils.f45397a;
                    Method method = BannerUtils.class.getMethod("getCloseIds", String.class);
                    if (method.invoke(null, this.f45420b) instanceof String) {
                        eVar.a("close_id", method.invoke(null, this.f45420b).toString());
                    }
                } catch (Exception unused) {
                    a("banner module is miss");
                    return;
                }
            } else if (i11 == 297) {
                if (this.f45427i <= 0 || this.f45428j <= 0) {
                    a("ad display area is too small");
                    return;
                }
                eVar.a(com.mbridge.msdk.foundation.entity.b.JSON_KEY_UNIT_SIZE, this.f45428j + "x" + this.f45427i);
                StringBuilder sb2 = new StringBuilder();
                sb2.append(this.f45430l);
                sb2.append("");
                eVar.a("orientation", sb2.toString());
            } else if (i11 != 298) {
                if (!z11) {
                    str = "0";
                }
                eVar.a("rw_plus", str);
            } else {
                if (this.f45427i <= 0 || this.f45428j <= 0) {
                    a("bid required param is missing or error");
                    return;
                }
                eVar.a(com.mbridge.msdk.foundation.entity.b.JSON_KEY_UNIT_SIZE, this.f45428j + "x" + this.f45427i);
            }
            final String md5 = SameMD5.getMD5(ai.d());
            eVar.a(CampaignEx.JSON_KEY_LOCAL_REQUEST_ID, md5);
            a aVar2 = new a(this.f45419a, this.f45420b) { // from class: com.mbridge.msdk.mbbid.common.a.b.1
                @Override // com.mbridge.msdk.mbbid.common.b.b
                public final void a(int i13, String str2) {
                    b.this.f45426h = false;
                    com.mbridge.msdk.mbbid.common.c.a.a(b.this.f45422d, b.this.f45420b, str2, md5);
                    b.this.a(str2);
                }

                @Override // com.mbridge.msdk.mbbid.common.b.b
                public final void a(BidResponsedEx bidResponsedEx) {
                    b.this.f45426h = false;
                    b.this.f45424f = bidResponsedEx;
                    com.mbridge.msdk.mbbid.common.c.a.a(b.this.f45422d, b.this.f45420b, bidResponsedEx.getBidId(), md5, bidResponsedEx.getBidToken());
                    b.a(b.this, (BidResponsed) bidResponsedEx);
                }
            };
            aVar2.setUnitId(this.f45420b);
            aVar2.setPlacementId(this.f45419a);
            aVar.get(1, com.mbridge.msdk.foundation.same.net.g.d.f().a(false, ""), eVar, aVar2);
        } catch (Throwable th2) {
            a(th2.getMessage());
        }
    }
}
