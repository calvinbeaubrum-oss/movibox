package com.vungle.warren.log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.gson.JsonObject;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f62076a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f62077b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f62078c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f62079d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f62080e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f62081f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f62082g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f62083h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f62084i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f62085j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f62086k;

    public b(@NonNull String str, @NonNull String str2, @NonNull String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7, @Nullable String str8, @Nullable String str9, @Nullable String str10, @Nullable String str11) {
        this.f62076a = str2;
        this.f62077b = str;
        this.f62078c = str3;
        this.f62079d = str4;
        this.f62080e = str5;
        this.f62081f = str6;
        this.f62082g = str7;
        this.f62083h = str8;
        this.f62084i = str9;
        this.f62085j = str10;
        this.f62086k = str11;
    }

    public final void a(@NonNull JsonObject jsonObject, @NonNull String str, @Nullable String str2) {
        if (str2 != null) {
            jsonObject.addProperty(str, str2);
        }
    }

    @NonNull
    public String b() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("raw_log", this.f62077b);
        JsonObject jsonObject2 = new JsonObject();
        jsonObject.add(TtmlNode.TAG_METADATA, jsonObject2);
        a(jsonObject2, "log_level", this.f62076a);
        a(jsonObject2, "context", this.f62078c);
        a(jsonObject2, "event_id", this.f62079d);
        a(jsonObject2, "sdk_user_agent", this.f62080e);
        a(jsonObject2, "bundle_id", this.f62081f);
        a(jsonObject2, "time_zone", this.f62082g);
        a(jsonObject2, "device_timestamp", this.f62083h);
        a(jsonObject2, "custom_data", this.f62084i);
        a(jsonObject2, "exception_class", this.f62085j);
        a(jsonObject2, "thread_id", this.f62086k);
        return jsonObject.toString();
    }
}
