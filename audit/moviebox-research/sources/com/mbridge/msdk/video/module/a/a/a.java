package com.mbridge.msdk.video.module.a.a;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.ad;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class a extends f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Activity f48011a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private CampaignEx f48012b;

    public a(Activity activity, CampaignEx campaignEx) {
        this.f48011a = activity;
        this.f48012b = campaignEx;
    }

    @Override // com.mbridge.msdk.video.module.a.a.f, com.mbridge.msdk.video.module.a.a
    public void a(int i11, Object obj) {
        super.a(i11, obj);
        if (i11 != 106 || this.f48011a == null || this.f48012b == null) {
            return;
        }
        try {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            String strA = com.mbridge.msdk.click.c.a(this.f48012b.getClickURL(), "-999", "-999");
            if (!TextUtils.isEmpty(strA)) {
                intent.setData(Uri.parse(strA));
                this.f48011a.startActivity(intent);
            }
        } catch (Throwable th2) {
            ad.a("NotifyListener", th2.getMessage(), th2);
        }
        this.f48011a.finish();
    }
}
