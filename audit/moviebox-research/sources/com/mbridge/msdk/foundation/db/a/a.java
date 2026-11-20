package com.mbridge.msdk.foundation.db.a;

import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.db.h;
import com.mbridge.msdk.foundation.db.m;
import com.mbridge.msdk.foundation.same.a.b;
import java.util.Collection;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private b f44155a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private m f44156b;

    /* JADX INFO: renamed from: com.mbridge.msdk.foundation.db.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static class C0486a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static a f44160a = new a();
    }

    private a() {
        this.f44155a = new b(1000);
        try {
            m mVarA = m.a(h.a(c.m().c()));
            this.f44156b = mVarA;
            a(mVarA.a(), false);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static a a() {
        return C0486a.f44160a;
    }

    public final JSONObject a(String str) {
        m mVar;
        JSONObject jSONObjectB = this.f44155a.b(str);
        if (jSONObjectB != null || (mVar = this.f44156b) == null) {
            return jSONObjectB;
        }
        JSONObject jSONObjectA = mVar.a(str);
        if (jSONObjectA != null) {
            this.f44155a.a(str, jSONObjectA);
        }
        return jSONObjectA;
    }

    public final void a(JSONObject jSONObject, final boolean z11) {
        if (jSONObject != null) {
            Iterator<String> itKeys = jSONObject.keys();
            final b bVar = new b(100);
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(next);
                this.f44155a.a(next, jSONObjectOptJSONObject);
                bVar.a(next, jSONObjectOptJSONObject);
            }
            com.mbridge.msdk.foundation.same.f.b.b().execute(new Runnable() { // from class: com.mbridge.msdk.foundation.db.a.a.1
                @Override // java.lang.Runnable
                public final void run() {
                    if (!z11 || a.this.f44156b == null) {
                        return;
                    }
                    for (String str : bVar.a()) {
                        a.this.f44156b.a(str, a.this.f44155a.b(str));
                    }
                }
            });
        }
    }

    public final JSONArray b() {
        return new JSONArray((Collection) this.f44155a.a());
    }
}
