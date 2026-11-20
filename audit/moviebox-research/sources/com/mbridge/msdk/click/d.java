package com.mbridge.msdk.click;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.cloud.tmc.miniapp.prepare.steps.PrepareException;
import com.mbridge.msdk.click.entity.JumpLoaderResult;
import com.mbridge.msdk.foundation.entity.CampaignEx;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class d extends e {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f43114d;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private com.mbridge.msdk.foundation.same.e.b f43117g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private n f43118h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    JumpLoaderResult f43111a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f43112b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f43113c = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private f f43115e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f43116f = true;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Handler f43119i = new Handler(Looper.getMainLooper());

    public d(Context context) {
        this.f43117g = new com.mbridge.msdk.foundation.same.e.b(context);
        this.f43118h = new n(context);
    }

    @Override // com.mbridge.msdk.click.e
    public final void a() {
        this.f43116f = false;
    }

    public final void a(String str, CampaignEx campaignEx, f fVar) {
        this.f43113c = new String(campaignEx.getClickURL());
        this.f43115e = fVar;
        this.f43111a = null;
        this.f43118h.a(campaignEx.getClickURL(), fVar, "5".equals(campaignEx.getClick_mode()) || PrepareException.ERROR_NO_URL.equals(campaignEx.getClick_mode()), campaignEx.getId(), str, campaignEx, true, false, com.mbridge.msdk.click.a.a.f43075j);
    }

    public final void a(String str, CampaignEx campaignEx, f fVar, String str2, boolean z11, boolean z12, int i11) {
        String id2;
        boolean z13;
        this.f43113c = str2;
        this.f43115e = fVar;
        this.f43111a = null;
        this.f43114d = i11;
        if (campaignEx != null) {
            boolean z14 = "5".equals(campaignEx.getClick_mode()) || PrepareException.ERROR_NO_URL.equals(campaignEx.getClick_mode());
            id2 = campaignEx.getId();
            z13 = z14;
        } else {
            id2 = "";
            z13 = false;
        }
        this.f43118h.a(str2, fVar, z13, id2, str, campaignEx, z11, z12, i11);
    }
}
