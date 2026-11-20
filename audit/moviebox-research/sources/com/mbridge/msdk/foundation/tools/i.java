package com.mbridge.msdk.foundation.tools;

import android.content.Context;
import com.mbridge.msdk.MBridgeConstans;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class i extends c {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f45069w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f45070x;

    public i(Context context) {
        super(context);
        this.f45070x = z.o();
        this.f45069w = z.f();
    }

    @Override // com.mbridge.msdk.foundation.tools.c
    public JSONObject a() {
        JSONObject jSONObjectA = super.a();
        try {
            if (com.mbridge.msdk.foundation.controller.authoritycontroller.c.j().c(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("dmt", this.f45070x + "");
                jSONObject.put("dmf", this.f45069w);
            }
        } catch (JSONException e11) {
            if (MBridgeConstans.DEBUG) {
                ad.b("DomainDeviceInfo", e11.getMessage());
            }
        }
        return jSONObjectA;
    }
}
