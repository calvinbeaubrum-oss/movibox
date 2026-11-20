package v00;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.cloud.config.utils.XLogUtil;
import com.google.gson.JsonObject;
import com.vungle.warren.network.VungleApi;
import java.util.Map;
import okhttp3.Call;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class f implements VungleApi {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final w00.a<ResponseBody, JsonObject> f78691d = new w00.c();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final w00.a<ResponseBody, Void> f78692e = new w00.b();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public HttpUrl f78693a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Call.Factory f78694b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f78695c;

    public f(@NonNull HttpUrl httpUrl, @NonNull Call.Factory factory) {
        this.f78693a = httpUrl;
        this.f78694b = factory;
    }

    public final <T> b<T> a(String str, @NonNull String str2, @Nullable Map<String, String> map, w00.a<ResponseBody, T> aVar) {
        HttpUrl.Builder builderNewBuilder = HttpUrl.get(str2).newBuilder();
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                builderNewBuilder.addQueryParameter(entry.getKey(), entry.getValue());
            }
        }
        return new d(this.f78694b.newCall(c(str, builderNewBuilder.build().toString()).get().build()), aVar);
    }

    @Override // com.vungle.warren.network.VungleApi
    public b<JsonObject> ads(String str, String str2, JsonObject jsonObject) {
        return b(str, str2, jsonObject);
    }

    public final b<JsonObject> b(String str, @NonNull String str2, JsonObject jsonObject) {
        return new d(this.f78694b.newCall(c(str, str2).post(RequestBody.create((MediaType) null, jsonObject != null ? jsonObject.toString() : "")).build()), f78691d);
    }

    @NonNull
    public final Request.Builder c(@NonNull String str, @NonNull String str2) {
        Request.Builder builderAddHeader = new Request.Builder().url(str2).addHeader("User-Agent", str).addHeader("Vungle-Version", "5.10.0").addHeader(HttpHeaders.CONTENT_TYPE, "application/json");
        if (!TextUtils.isEmpty(this.f78695c)) {
            builderAddHeader.addHeader("X-Vungle-App-Id", this.f78695c);
        }
        return builderAddHeader;
    }

    @Override // com.vungle.warren.network.VungleApi
    public b<JsonObject> cacheBust(String str, String str2, JsonObject jsonObject) {
        return b(str, str2, jsonObject);
    }

    @Override // com.vungle.warren.network.VungleApi
    public b<JsonObject> config(String str, JsonObject jsonObject) {
        return b(str, this.f78693a.toString() + XLogUtil.TAG, jsonObject);
    }

    public void d(String str) {
        this.f78695c = str;
    }

    @Override // com.vungle.warren.network.VungleApi
    public b<Void> pingTPAT(String str, String str2) {
        return a(str, str2, null, f78692e);
    }

    @Override // com.vungle.warren.network.VungleApi
    public b<JsonObject> reportAd(String str, String str2, JsonObject jsonObject) {
        return b(str, str2, jsonObject);
    }

    @Override // com.vungle.warren.network.VungleApi
    public b<JsonObject> reportNew(String str, String str2, Map<String, String> map) {
        return a(str, str2, map, f78691d);
    }

    @Override // com.vungle.warren.network.VungleApi
    public b<JsonObject> ri(String str, String str2, JsonObject jsonObject) {
        return b(str, str2, jsonObject);
    }

    @Override // com.vungle.warren.network.VungleApi
    public b<JsonObject> sendBiAnalytics(String str, String str2, JsonObject jsonObject) {
        return b(str, str2, jsonObject);
    }

    @Override // com.vungle.warren.network.VungleApi
    public b<JsonObject> sendLog(String str, String str2, JsonObject jsonObject) {
        return b(str, str2, jsonObject);
    }

    @Override // com.vungle.warren.network.VungleApi
    public b<JsonObject> willPlayAd(String str, String str2, JsonObject jsonObject) {
        return b(str, str2, jsonObject);
    }
}
