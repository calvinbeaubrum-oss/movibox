package com.mbridge.msdk.video.signal.a;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class l extends d {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f48111o = true;

    private com.mbridge.msdk.click.a n() {
        if (this.f48085l == null) {
            this.f48085l = new com.mbridge.msdk.click.a(com.mbridge.msdk.foundation.controller.c.m().c(), this.f48083j);
        }
        return this.f48085l;
    }

    public final void a(CampaignEx campaignEx, Context context) {
        String queryParameter;
        try {
            queryParameter = Uri.parse(campaignEx.getNoticeUrl()).getQueryParameter(com.mbridge.msdk.foundation.same.a.f44377m);
        } catch (Throwable unused) {
        }
        this.f48086m.a((!TextUtils.isEmpty(queryParameter) ? Integer.parseInt(queryParameter) : 0) == 2);
        n().a(this.f48086m);
        n().a(campaignEx);
        com.mbridge.msdk.video.module.b.b.d(com.mbridge.msdk.foundation.controller.c.m().c(), campaignEx);
    }

    public final void a(JSONObject jSONObject) {
        try {
            jSONObject.put("device", new com.mbridge.msdk.foundation.tools.h(com.mbridge.msdk.foundation.controller.c.m().c()).a());
        } catch (JSONException e11) {
            throw new RuntimeException(e11);
        }
    }
}
