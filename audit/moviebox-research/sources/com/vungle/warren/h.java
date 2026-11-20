package com.vungle.warren;

import androidx.annotation.Nullable;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("enabled")
    private final boolean f62027a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName("clear_shared_cache_timestamp")
    private final long f62028b;

    public h(boolean z11, long j11) {
        this.f62027a = z11;
        this.f62028b = j11;
    }

    @Nullable
    public static h a(String str) {
        if (str == null) {
            return null;
        }
        try {
            return b((JsonObject) new GsonBuilder().create().fromJson(str, JsonObject.class));
        } catch (JsonSyntaxException unused) {
            return null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0042  */
    @Nullable
    public static h b(JsonObject jsonObject) {
        boolean z11;
        if (!com.vungle.warren.model.l.e(jsonObject, "clever_cache")) {
            return null;
        }
        JsonObject asJsonObject = jsonObject.getAsJsonObject("clever_cache");
        long asLong = -1;
        try {
            if (asJsonObject.has("clear_shared_cache_timestamp")) {
                asLong = asJsonObject.get("clear_shared_cache_timestamp").getAsLong();
            }
        } catch (NumberFormatException unused) {
        }
        if (asJsonObject.has("enabled")) {
            JsonElement jsonElement = asJsonObject.get("enabled");
            if (jsonElement.isJsonPrimitive() && "false".equalsIgnoreCase(jsonElement.getAsString())) {
                z11 = false;
            } else {
                z11 = true;
            }
        } else {
            z11 = true;
        }
        return new h(z11, asLong);
    }

    public long c() {
        return this.f62028b;
    }

    public boolean d() {
        return this.f62027a;
    }

    public String e() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.add("clever_cache", new GsonBuilder().create().toJsonTree(this));
        return jsonObject.toString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        h hVar = (h) obj;
        return this.f62027a == hVar.f62027a && this.f62028b == hVar.f62028b;
    }

    public int hashCode() {
        int i11 = (this.f62027a ? 1 : 0) * 31;
        long j11 = this.f62028b;
        return i11 + ((int) (j11 ^ (j11 >>> 32)));
    }
}
