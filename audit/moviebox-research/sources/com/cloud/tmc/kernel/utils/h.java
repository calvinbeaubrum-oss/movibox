package com.cloud.tmc.kernel.utils;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class h {

    /* JADX INFO: compiled from: source.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final JsonObject f31286a;

        public a(@NonNull JsonObject jsonObject) {
            this.f31286a = jsonObject;
        }

        @NonNull
        public a a(@NonNull String str, @Nullable JsonElement jsonElement) {
            this.f31286a.add(str, jsonElement);
            return this;
        }

        @NonNull
        public a b(@NonNull String str, @Nullable Boolean bool) {
            this.f31286a.addProperty(str, bool);
            return this;
        }

        @NonNull
        public a c(@NonNull String str, @Nullable Number number) {
            this.f31286a.addProperty(str, number);
            return this;
        }

        @NonNull
        public a d(@NonNull String str, @Nullable String str2) {
            this.f31286a.addProperty(str, str2);
            return this;
        }

        @NonNull
        public JsonObject e() {
            return this.f31286a;
        }
    }

    @NonNull
    public static a a() {
        return b(new JsonObject());
    }

    @NonNull
    public static a b(@Nullable JsonObject jsonObject) {
        if (jsonObject == null) {
            jsonObject = new JsonObject();
        }
        return new a(jsonObject);
    }
}
