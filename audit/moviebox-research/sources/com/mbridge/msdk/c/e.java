package com.mbridge.msdk.c;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f43010a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private HashMap<String, f> f43011b;

    /* JADX INFO: compiled from: source.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final e f43012a = new e();
    }

    private e() {
        this.f43010a = 6;
        this.f43011b = new HashMap<>();
    }

    public static e a() {
        return a.f43012a;
    }

    public final int a(String str) {
        HashMap<String, f> map;
        f fVar;
        int i11;
        if (TextUtils.isEmpty(str) || (map = this.f43011b) == null || !map.containsKey(str) || (fVar = this.f43011b.get(str)) == null) {
            return 0;
        }
        if (fVar.c()) {
            i11 = 1;
        } else {
            i11 = fVar.a() >= this.f43010a ? 2 : 0;
        }
        fVar.a(false);
        return i11;
    }

    public final String b(String str) {
        HashMap<String, f> map;
        f fVar;
        if (TextUtils.isEmpty(str) || (map = this.f43011b) == null || !map.containsKey(str) || (fVar = this.f43011b.get(str)) == null || fVar.a() >= this.f43010a) {
            return "";
        }
        String strB = fVar.b();
        if (!TextUtils.isEmpty(strB)) {
            fVar.a(true);
        }
        return strB;
    }

    public final void c(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (this.f43011b == null) {
                this.f43011b = new HashMap<>();
            }
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                String string = jSONObject.getString(next);
                f fVar = new f();
                fVar.a(next);
                fVar.b(string);
                this.f43011b.put(next, fVar);
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public final void d(String str) {
        HashMap<String, f> map;
        f fVar;
        if (TextUtils.isEmpty(str) || (map = this.f43011b) == null || !map.containsKey(str) || (fVar = this.f43011b.get(str)) == null || fVar.a() >= this.f43010a) {
            return;
        }
        fVar.a(fVar.a() + 1);
    }

    public final void e(String str) {
        HashMap<String, f> map;
        f fVar;
        if (TextUtils.isEmpty(str) || (map = this.f43011b) == null || !map.containsKey(str) || (fVar = this.f43011b.get(str)) == null || fVar.a() >= this.f43010a) {
            return;
        }
        fVar.a(0);
    }
}
