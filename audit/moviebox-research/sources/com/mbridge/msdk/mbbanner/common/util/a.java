package com.mbridge.msdk.mbbanner.common.util;

import android.os.Handler;
import android.os.Looper;
import com.mbridge.msdk.foundation.entity.CampaignUnit;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.mbbanner.common.b.b;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f45398a = "a";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Handler f45399b = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f45400c;

    public final void a(final b bVar, final com.mbridge.msdk.foundation.c.b bVar2) {
        this.f45399b.post(new Runnable() { // from class: com.mbridge.msdk.mbbanner.common.util.a.2
            @Override // java.lang.Runnable
            public final void run() {
                if (bVar != null) {
                    bVar2.a(a.this.f45400c);
                    bVar.a(bVar2);
                }
            }
        });
    }

    public final void a(final b bVar, final CampaignUnit campaignUnit, final String str) {
        ad.b(f45398a, "postCampaignSuccess unitId=" + str);
        this.f45399b.post(new Runnable() { // from class: com.mbridge.msdk.mbbanner.common.util.a.1
            @Override // java.lang.Runnable
            public final void run() {
                b bVar2 = bVar;
                if (bVar2 != null) {
                    bVar2.a(str, campaignUnit, a.this.f45400c);
                }
            }
        });
    }

    public final void a(final b bVar, final String str) {
        ad.b(f45398a, "postResourceSuccess unitId=" + str);
        this.f45399b.post(new Runnable() { // from class: com.mbridge.msdk.mbbanner.common.util.a.3
            @Override // java.lang.Runnable
            public final void run() {
                b bVar2 = bVar;
                if (bVar2 != null) {
                    bVar2.a(str, a.this.f45400c);
                }
            }
        });
    }

    public final void a(boolean z11) {
        this.f45400c = z11;
    }

    public final void b(final b bVar, final com.mbridge.msdk.foundation.c.b bVar2) {
        ad.b(f45398a, "postResourceFail unitId=" + bVar2);
        this.f45399b.post(new Runnable() { // from class: com.mbridge.msdk.mbbanner.common.util.a.4
            @Override // java.lang.Runnable
            public final void run() {
                if (bVar != null) {
                    bVar2.a(a.this.f45400c);
                    bVar.b(bVar2);
                }
            }
        });
    }
}
