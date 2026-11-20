package com.iab.omid.library.mmadbridge.adsession.media;

import com.iab.omid.library.mmadbridge.internal.h;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import kn.g;
import nn.c;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g f42343a;

    public a(g gVar) {
        this.f42343a = gVar;
    }

    public static a g(kn.b bVar) {
        g gVar = (g) bVar;
        nn.g.c(bVar, "AdSession is null");
        nn.g.k(gVar);
        nn.g.h(gVar);
        nn.g.g(gVar);
        nn.g.m(gVar);
        a aVar = new a(gVar);
        gVar.w().d(aVar);
        return aVar;
    }

    public void a(InteractionType interactionType) {
        nn.g.c(interactionType, "InteractionType is null");
        nn.g.f(this.f42343a);
        JSONObject jSONObject = new JSONObject();
        c.i(jSONObject, "interactionType", interactionType);
        this.f42343a.w().g("adUserInteraction", jSONObject);
    }

    public void b() {
        nn.g.f(this.f42343a);
        this.f42343a.w().e("bufferFinish");
    }

    public void c() {
        nn.g.f(this.f42343a);
        this.f42343a.w().e("bufferStart");
    }

    public void d() {
        nn.g.f(this.f42343a);
        this.f42343a.w().e(CampaignEx.JSON_NATIVE_VIDEO_COMPLETE);
    }

    public final void e(float f11) {
        if (f11 <= 0.0f) {
            throw new IllegalArgumentException("Invalid Media duration");
        }
    }

    public final void f(float f11) {
        if (f11 < 0.0f || f11 > 1.0f) {
            throw new IllegalArgumentException("Invalid Media volume");
        }
    }

    public void h() {
        nn.g.f(this.f42343a);
        this.f42343a.w().e("firstQuartile");
    }

    public void i() {
        nn.g.f(this.f42343a);
        this.f42343a.w().e(CampaignEx.JSON_NATIVE_VIDEO_MIDPOINT);
    }

    public void j() {
        nn.g.f(this.f42343a);
        this.f42343a.w().e("pause");
    }

    public void k(PlayerState playerState) {
        nn.g.c(playerState, "PlayerState is null");
        nn.g.f(this.f42343a);
        JSONObject jSONObject = new JSONObject();
        c.i(jSONObject, "state", playerState);
        this.f42343a.w().g("playerStateChange", jSONObject);
    }

    public void l() {
        nn.g.f(this.f42343a);
        this.f42343a.w().e(CampaignEx.JSON_NATIVE_VIDEO_RESUME);
    }

    public void m() {
        nn.g.f(this.f42343a);
        this.f42343a.w().e("skipped");
    }

    public void n(float f11, float f12) {
        e(f11);
        f(f12);
        nn.g.f(this.f42343a);
        JSONObject jSONObject = new JSONObject();
        c.i(jSONObject, "duration", Float.valueOf(f11));
        c.i(jSONObject, "mediaPlayerVolume", Float.valueOf(f12));
        c.i(jSONObject, "deviceVolume", Float.valueOf(h.d().c()));
        this.f42343a.w().g("start", jSONObject);
    }

    public void o() {
        nn.g.f(this.f42343a);
        this.f42343a.w().e("thirdQuartile");
    }

    public void p(float f11) {
        f(f11);
        nn.g.f(this.f42343a);
        JSONObject jSONObject = new JSONObject();
        c.i(jSONObject, "mediaPlayerVolume", Float.valueOf(f11));
        c.i(jSONObject, "deviceVolume", Float.valueOf(h.d().c()));
        this.f42343a.w().g("volumeChange", jSONObject);
    }
}
