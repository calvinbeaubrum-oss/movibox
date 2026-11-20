package com.vungle.warren.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.vungle.warren.session.SessionAttribute;
import com.vungle.warren.session.SessionEvent;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class p {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Gson f62227d = new Gson();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SessionEvent f62228a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f62229b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public JsonObject f62230c;

    /* JADX INFO: compiled from: source.java */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public JsonObject f62231a = new JsonObject();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public SessionEvent f62232b;

        public b a(SessionAttribute sessionAttribute, String str) {
            this.f62231a.addProperty(sessionAttribute.toString(), str);
            return this;
        }

        public b b(SessionAttribute sessionAttribute, boolean z11) {
            this.f62231a.addProperty(sessionAttribute.toString(), Boolean.valueOf(z11));
            return this;
        }

        public p c() {
            if (this.f62232b != null) {
                return new p(this.f62232b, this.f62231a);
            }
            throw new IllegalArgumentException("SessionData must have event");
        }

        public b d(SessionEvent sessionEvent) {
            this.f62232b = sessionEvent;
            this.f62231a.addProperty(NotificationCompat.CATEGORY_EVENT, sessionEvent.toString());
            return this;
        }
    }

    public p(SessionEvent sessionEvent, JsonObject jsonObject) {
        this.f62228a = sessionEvent;
        this.f62230c = jsonObject;
        jsonObject.addProperty(SessionAttribute.TIMESTAMP.toString(), Long.valueOf(System.currentTimeMillis()));
    }

    public p(String str, int i11) {
        this.f62230c = (JsonObject) f62227d.fromJson(str, JsonObject.class);
        this.f62229b = i11;
    }

    public void a(SessionAttribute sessionAttribute, String str) {
        this.f62230c.addProperty(sessionAttribute.toString(), str);
    }

    public String b() {
        return f62227d.toJson((JsonElement) this.f62230c);
    }

    @NonNull
    public String c() {
        String strB = com.vungle.warren.utility.k.b(b());
        return strB == null ? String.valueOf(b().hashCode()) : strB;
    }

    public int d() {
        return this.f62229b;
    }

    public String e(SessionAttribute sessionAttribute) {
        JsonElement jsonElement = this.f62230c.get(sessionAttribute.toString());
        if (jsonElement != null) {
            return jsonElement.getAsString();
        }
        return null;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == null || !(obj instanceof p)) {
            return false;
        }
        p pVar = (p) obj;
        return this.f62228a.equals(pVar.f62228a) && this.f62230c.equals(pVar.f62230c);
    }

    public int f() {
        int i11 = this.f62229b;
        this.f62229b = i11 + 1;
        return i11;
    }

    public void g(SessionAttribute sessionAttribute) {
        this.f62230c.remove(sessionAttribute.toString());
    }
}
