package com.mbridge.msdk.video.module.a.a;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.db.q;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.foundation.tools.z;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class e implements com.mbridge.msdk.foundation.same.c.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private CampaignEx f48016a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected ImageView f48017b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f48018c;

    public e(ImageView imageView) {
        this.f48017b = imageView;
    }

    public e(ImageView imageView, CampaignEx campaignEx, String str) {
        this.f48017b = imageView;
        this.f48016a = campaignEx;
        this.f48018c = str;
    }

    @Override // com.mbridge.msdk.foundation.same.c.c
    public void onFailedLoad(final String str, String str2) {
        Runnable runnable = new Runnable() { // from class: com.mbridge.msdk.video.module.a.a.e.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    q qVarA = q.a(com.mbridge.msdk.foundation.db.h.a(com.mbridge.msdk.foundation.controller.c.m().c()));
                    if (e.this.f48016a == null) {
                        ad.a("ImageLoaderListener", "campaign is null");
                        return;
                    }
                    com.mbridge.msdk.foundation.entity.n nVar = new com.mbridge.msdk.foundation.entity.n();
                    nVar.a("2000044");
                    nVar.a(z.l(com.mbridge.msdk.foundation.controller.c.m().c()));
                    nVar.e(e.this.f48016a.getId());
                    nVar.p(e.this.f48016a.getImageUrl());
                    nVar.f(e.this.f48016a.getRequestId());
                    nVar.g(e.this.f48016a.getRequestIdNotice());
                    nVar.c(e.this.f48018c);
                    nVar.h(str);
                    qVarA.a(nVar);
                } catch (Exception e11) {
                    e11.printStackTrace();
                }
            }
        };
        com.mbridge.msdk.foundation.controller.d.a();
        com.mbridge.msdk.foundation.same.f.b.b().execute(runnable);
        ad.b("ImageLoaderListener", "desc:" + str);
    }

    @Override // com.mbridge.msdk.foundation.same.c.c
    public void onSuccessLoad(Bitmap bitmap, String str) {
        try {
            if (bitmap == null) {
                ad.b("ImageLoaderListener", "bitmap=null");
            } else {
                if (this.f48017b == null || bitmap.isRecycled()) {
                    return;
                }
                this.f48017b.setImageBitmap(bitmap);
                this.f48017b.setVisibility(0);
            }
        } catch (Throwable th2) {
            if (MBridgeConstans.DEBUG) {
                th2.printStackTrace();
            }
        }
    }
}
