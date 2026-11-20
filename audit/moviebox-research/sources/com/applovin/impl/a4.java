package com.applovin.impl;

import android.content.Context;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class a4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final a f17432a = new a("Age Restricted User", uj.f23596m);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final a f17433b = new a("Has User Consent", uj.f23595l);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final a f17434c = new a("\"Do Not Sell\"", uj.f23597n);

    /* JADX INFO: compiled from: source.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f17435a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final uj f17436b;

        public a(String str, uj ujVar) {
            this.f17435a = str;
            this.f17436b = ujVar;
        }

        public String a() {
            return this.f17435a;
        }

        public String a(Context context) {
            Boolean boolB = b(context);
            return boolB != null ? boolB.toString() : "No value set";
        }

        public Boolean b(Context context) {
            if (context != null) {
                return (Boolean) vj.a(this.f17436b, (Object) null, context);
            }
            com.applovin.impl.sdk.n.h("AppLovinSdk", "Failed to get value for key: " + this.f17436b);
            return null;
        }
    }

    public static a a() {
        return f17434c;
    }

    public static String a(Context context) {
        return a(f17432a, context) + a(f17433b, context) + a(f17434c, context);
    }

    private static String a(a aVar, Context context) {
        return "\n" + aVar.f17435a + " - " + aVar.a(context);
    }

    private static boolean a(uj ujVar, Boolean bool, Context context) {
        if (context != null) {
            Boolean bool2 = (Boolean) vj.a(ujVar, (Object) null, context);
            vj.b(ujVar, bool, context);
            return bool2 == null || bool2 != bool;
        }
        com.applovin.impl.sdk.n.h("AppLovinSdk", "Failed to update compliance value for key: " + ujVar);
        return false;
    }

    public static boolean a(boolean z11, Context context) {
        return a(uj.f23597n, Boolean.valueOf(z11), context);
    }

    public static a b() {
        return f17433b;
    }

    public static boolean b(boolean z11, Context context) {
        return a(uj.f23595l, Boolean.valueOf(z11), context);
    }

    public static a c() {
        return f17432a;
    }

    public static boolean c(boolean z11, Context context) {
        return a(uj.f23596m, Boolean.valueOf(z11), context);
    }
}
