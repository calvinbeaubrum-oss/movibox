package com.vungle.warren.network;

import androidx.annotation.Keep;
import com.google.gson.JsonObject;
import java.util.Map;
import v00.b;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
@Keep
public interface VungleApi {
    b<JsonObject> ads(String str, String str2, JsonObject jsonObject);

    b<JsonObject> cacheBust(String str, String str2, JsonObject jsonObject);

    b<JsonObject> config(String str, JsonObject jsonObject);

    b<Void> pingTPAT(String str, String str2);

    b<JsonObject> reportAd(String str, String str2, JsonObject jsonObject);

    b<JsonObject> reportNew(String str, String str2, Map<String, String> map);

    b<JsonObject> ri(String str, String str2, JsonObject jsonObject);

    b<JsonObject> sendBiAnalytics(String str, String str2, JsonObject jsonObject);

    b<JsonObject> sendLog(String str, String str2, JsonObject jsonObject);

    b<JsonObject> willPlayAd(String str, String str2, JsonObject jsonObject);
}
