package com.mbridge.msdk.video.module.a.a;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.db.p;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.video.module.MBridgeVideoView;
import java.io.File;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class o extends k {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    protected int f48061k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f48062l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f48063m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f48064n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f48065o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f48066p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f48067q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private Map<Integer, String> f48068r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private MBridgeVideoView.a f48069s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f48070t;

    public o(CampaignEx campaignEx, com.mbridge.msdk.videocommon.b.c cVar, com.mbridge.msdk.videocommon.download.a aVar, String str, String str2, com.mbridge.msdk.video.module.a.a aVar2, int i11, boolean z11) {
        super(campaignEx, aVar, cVar, str, str2, aVar2, i11, z11);
        this.f48067q = false;
        this.f48061k = 0;
        this.f48070t = -1;
        if (this.f48024a) {
            this.f48068r = campaignEx.getAdvImpList();
        }
        this.f48061k = campaignEx.getVideoCompleteTime();
    }

    /* JADX WARN: Code duplicated, block: B:73:0x0156 A[Catch: all -> 0x002c, TryCatch #0 {all -> 0x002c, blocks: (B:18:0x0024, B:21:0x002f, B:22:0x005f, B:78:0x0170, B:23:0x006b, B:25:0x007e, B:27:0x0082, B:29:0x0088, B:31:0x008d, B:33:0x0091, B:36:0x00a2, B:38:0x00a6, B:39:0x00aa, B:41:0x00c6, B:42:0x00cf, B:44:0x00d3, B:49:0x00db, B:50:0x00df, B:51:0x00f7, B:54:0x00fd, B:56:0x0101, B:58:0x010a, B:60:0x010e, B:62:0x0120, B:64:0x0124, B:65:0x0134, B:67:0x0138, B:68:0x0142, B:70:0x014c, B:72:0x0150, B:73:0x0156, B:75:0x015a, B:77:0x015e), top: B:82:0x0004 }] */
    /* JADX WARN: Code duplicated, block: B:75:0x015a A[Catch: all -> 0x002c, TryCatch #0 {all -> 0x002c, blocks: (B:18:0x0024, B:21:0x002f, B:22:0x005f, B:78:0x0170, B:23:0x006b, B:25:0x007e, B:27:0x0082, B:29:0x0088, B:31:0x008d, B:33:0x0091, B:36:0x00a2, B:38:0x00a6, B:39:0x00aa, B:41:0x00c6, B:42:0x00cf, B:44:0x00d3, B:49:0x00db, B:50:0x00df, B:51:0x00f7, B:54:0x00fd, B:56:0x0101, B:58:0x010a, B:60:0x010e, B:62:0x0120, B:64:0x0124, B:65:0x0134, B:67:0x0138, B:68:0x0142, B:70:0x014c, B:72:0x0150, B:73:0x0156, B:75:0x015a, B:77:0x015e), top: B:82:0x0004 }] */
    @Override // com.mbridge.msdk.video.module.a.a.k, com.mbridge.msdk.video.module.a.a.f, com.mbridge.msdk.video.module.a.a
    public void a(int i11, final Object obj) {
        int i12;
        CampaignEx campaignEx;
        try {
            if (i11 != 2) {
                int videoLength = 0;
                if (i11 != 20) {
                    if (i11 != 130) {
                        if (i11 == 6) {
                            if (this.f48024a && !this.f48064n) {
                                this.f48064n = true;
                                d();
                                com.mbridge.msdk.video.module.b.b.e(com.mbridge.msdk.foundation.controller.c.m().c(), this.f48025b);
                            }
                        } else if (i11 != 7) {
                            if (i11 == 15) {
                                g();
                                f();
                                e();
                                if (af.a().a("i_l_s_t_r_i", false) && !this.f48065o) {
                                    this.f48065o = true;
                                    MBridgeVideoView.a aVar = this.f48069s;
                                    if (aVar != null) {
                                        aVar.a();
                                    }
                                }
                                if (obj == null || !(obj instanceof MBridgeVideoView.b)) {
                                    i12 = 0;
                                } else {
                                    int i13 = ((MBridgeVideoView.b) obj).f47992a;
                                    videoLength = ((MBridgeVideoView.b) obj).f47993b;
                                    i12 = i13;
                                }
                                if (videoLength == 0 && (campaignEx = this.f48025b) != null) {
                                    videoLength = campaignEx.getVideoLength();
                                }
                                com.mbridge.msdk.video.module.b.b.a(com.mbridge.msdk.foundation.controller.c.m().c(), this.f48025b, i12, videoLength, this.f48033j);
                                com.mbridge.msdk.video.module.b.b.a(this.f48025b, this.f48068r, this.f48030g, i12);
                                if (!this.f48066p) {
                                    this.f48066p = true;
                                    com.mbridge.msdk.video.module.b.b.a(this.f48025b, this.f48030g);
                                }
                                if (!this.f48067q) {
                                    int i14 = this.f48061k;
                                    if (i14 != 0) {
                                        videoLength = i14;
                                    }
                                    if (i12 >= videoLength) {
                                        this.f48067q = true;
                                        i11 = 17;
                                    }
                                }
                                ad.b("NotifyListener", "onPlayProgress:" + i12);
                                this.f48070t = i12;
                            } else if (i11 != 16) {
                                switch (i11) {
                                    case 11:
                                        com.mbridge.msdk.videocommon.download.b.getInstance().b(false);
                                        d();
                                        break;
                                    case 12:
                                        Runnable runnable = new Runnable() { // from class: com.mbridge.msdk.video.module.a.a.o.1
                                            @Override // java.lang.Runnable
                                            public final void run() {
                                                Object obj2 = obj;
                                                if (obj2 == null || !(obj2 instanceof String)) {
                                                    return;
                                                }
                                                o.this.a((String) obj2);
                                            }
                                        };
                                        com.mbridge.msdk.foundation.controller.d.a();
                                        com.mbridge.msdk.foundation.same.f.b.b().execute(runnable);
                                        d();
                                        b();
                                        c();
                                        k.AnonymousClass4 anonymousClass4 = new Runnable() { // from class: com.mbridge.msdk.video.module.a.a.k.4
                                            public AnonymousClass4() {
                                            }

                                            @Override // java.lang.Runnable
                                            public final void run() {
                                                com.mbridge.msdk.videocommon.download.a aVar2;
                                                try {
                                                    if (af.a().a("c_r_v_f_w_s_e", false)) {
                                                        return;
                                                    }
                                                    k kVar = k.this;
                                                    if (!kVar.f48024a || (aVar2 = kVar.f48028e) == null) {
                                                        return;
                                                    }
                                                    if (aVar2.l() != null && !TextUtils.isEmpty(k.this.f48028e.l().getVideoUrlEncode())) {
                                                        p.a(com.mbridge.msdk.foundation.db.h.a(com.mbridge.msdk.foundation.controller.c.m().c())).b(k.this.f48028e.l().getVideoUrlEncode());
                                                    }
                                                    if (TextUtils.isEmpty(k.this.f48028e.h())) {
                                                        return;
                                                    }
                                                    File file = new File(k.this.f48028e.h());
                                                    if (file.exists() && file.isFile() && file.delete()) {
                                                        ad.a("NotifyListener", "DEL File :" + file.getAbsolutePath());
                                                    }
                                                } catch (Exception e11) {
                                                    e11.printStackTrace();
                                                }
                                            }
                                        };
                                        com.mbridge.msdk.foundation.controller.d.a();
                                        com.mbridge.msdk.foundation.same.f.b.b().execute(anonymousClass4);
                                        com.mbridge.msdk.videocommon.download.b.getInstance().b(false);
                                        break;
                                    case 13:
                                        b();
                                        c();
                                        break;
                                }
                            } else if (this.f48024a) {
                                this.f48064n = true;
                                d();
                                com.mbridge.msdk.video.module.b.b.e(com.mbridge.msdk.foundation.controller.c.m().c(), this.f48025b);
                            }
                        } else if (this.f48024a && obj != null && (obj instanceof Integer)) {
                            int iIntValue = ((Integer) obj).intValue();
                            if (iIntValue == 2) {
                                if (!this.f48063m) {
                                    this.f48063m = true;
                                    com.mbridge.msdk.video.module.b.b.b(com.mbridge.msdk.foundation.controller.c.m().c(), this.f48025b);
                                }
                            } else if (iIntValue == 1 && !this.f48062l) {
                                this.f48062l = true;
                                com.mbridge.msdk.video.module.b.b.c(com.mbridge.msdk.foundation.controller.c.m().c(), this.f48025b);
                            }
                        }
                    } else if (obj instanceof Integer) {
                        this.f48061k = ((Integer) obj).intValue();
                    }
                } else if (af.a().a("i_l_s_t_r_i", false) && (obj instanceof MBridgeVideoView.a)) {
                    this.f48069s = (MBridgeVideoView.a) obj;
                }
            } else if (this.f48024a) {
                this.f48064n = true;
                d();
                com.mbridge.msdk.video.module.b.b.e(com.mbridge.msdk.foundation.controller.c.m().c(), this.f48025b);
            }
            this.f48032i.a(i11, obj);
        } catch (Throwable th2) {
            ad.a("NotifyListener", th2.getMessage(), th2);
        }
    }
}
