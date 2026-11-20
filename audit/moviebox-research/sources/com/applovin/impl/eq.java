package com.applovin.impl;

import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class eq {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final List f18761f = Arrays.asList(MimeTypes.VIDEO_MP4, MimeTypes.VIDEO_WEBM, MimeTypes.VIDEO_H263, "video/x-matroska");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.applovin.impl.sdk.j f18762a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final JSONObject f18764c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final JSONObject f18765d;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected List f18763b = new ArrayList();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final long f18766e = System.currentTimeMillis();

    public eq(JSONObject jSONObject, JSONObject jSONObject2, com.applovin.impl.sdk.j jVar) {
        this.f18762a = jVar;
        this.f18764c = jSONObject;
        this.f18765d = jSONObject2;
    }

    public List a() {
        return this.f18763b;
    }

    public JSONObject b() {
        return this.f18764c;
    }

    public long c() {
        return this.f18766e;
    }

    public int d() {
        return this.f18763b.size();
    }

    public JSONObject e() {
        return this.f18765d;
    }

    public List f() {
        List<String> listExplode = CollectionUtils.explode(JsonUtils.getString(this.f18764c, "vast_preferred_video_types", null));
        return !listExplode.isEmpty() ? listExplode : f18761f;
    }

    public int g() {
        return yp.a(JsonUtils.getInt(this.f18764c, "video_completion_percent", -1));
    }
}
