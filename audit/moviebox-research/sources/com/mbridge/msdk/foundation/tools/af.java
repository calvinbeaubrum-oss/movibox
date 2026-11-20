package com.mbridge.msdk.foundation.tools;

import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class af {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile JSONObject f44970a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f44971b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Object f44972c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Object f44973d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Object f44974e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f44975f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private volatile ConcurrentHashMap<String, Boolean> f44976g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private volatile ConcurrentHashMap<String, Integer> f44977h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private volatile com.mbridge.msdk.c.g f44978i;

    /* JADX INFO: compiled from: source.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final af f44979a = new af();
    }

    private af() {
        this.f44971b = new Object();
        this.f44972c = new Object();
        this.f44973d = new Object();
        this.f44974e = new Object();
    }

    public static af a() {
        return a.f44979a;
    }

    private static Integer a(String str, ConcurrentHashMap<String, Integer> concurrentHashMap) {
        try {
            return concurrentHashMap.get(str);
        } catch (Exception unused) {
            return null;
        }
    }

    private int b(String str, int i11) {
        if (d()) {
            return i11;
        }
        try {
            return this.f44970a.optInt(str, i11);
        } catch (Exception unused) {
            return i11;
        }
    }

    private int b(String str, String str2, int i11) {
        if (d()) {
            return i11;
        }
        try {
            String strOptString = this.f44970a.optString(str, "");
            if (TextUtils.isEmpty(strOptString)) {
                return i11;
            }
            String strA = x.a(strOptString);
            return TextUtils.isEmpty(strA) ? i11 : new JSONObject(strA).optInt(str2, i11);
        } catch (Exception unused) {
            return i11;
        }
    }

    private static Boolean b(String str, ConcurrentHashMap<String, Boolean> concurrentHashMap) {
        try {
            return concurrentHashMap.get(str);
        } catch (Exception unused) {
            return null;
        }
    }

    private ConcurrentHashMap<String, Integer> b() {
        synchronized (this.f44971b) {
            try {
                if (this.f44977h == null) {
                    this.f44977h = new ConcurrentHashMap<>();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return this.f44977h;
    }

    private boolean b(String str, boolean z11) {
        if (d()) {
            return z11;
        }
        try {
            return this.f44970a.optInt(str, z11 ? 1 : 0) != 0;
        } catch (Exception unused) {
            return z11;
        }
    }

    private ConcurrentHashMap<String, Boolean> c() {
        synchronized (this.f44973d) {
            try {
                if (this.f44976g == null) {
                    this.f44976g = new ConcurrentHashMap<>();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return this.f44976g;
    }

    /* JADX WARN: Code duplicated, block: B:20:0x003b A[Catch: all -> 0x0011, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x0008, B:18:0x0037, B:20:0x003b, B:21:0x0043, B:11:0x0013, B:13:0x001b, B:14:0x0027, B:17:0x0035), top: B:31:0x0003, inners: #1 }] */
    private boolean d() {
        synchronized (this.f44974e) {
            if (this.f44978i == null || this.f44978i.I() == 1) {
                try {
                    if (TextUtils.isEmpty(this.f44975f)) {
                        this.f44975f = com.mbridge.msdk.foundation.a.a.a.a().a(MBridgeConstans.SDK_APP_ID);
                    }
                    this.f44978i = com.mbridge.msdk.c.h.a().a(this.f44975f);
                } catch (Exception unused) {
                    this.f44978i = null;
                }
                if (this.f44978i != null) {
                    this.f44970a = this.f44978i.al();
                }
            } else if (this.f44978i != null) {
                this.f44970a = this.f44978i.al();
            }
            throw th;
        }
        return this.f44978i == null || this.f44970a == null;
    }

    public final int a(String str, int i11) {
        Integer numValueOf;
        try {
            if (TextUtils.isEmpty(str)) {
                return i11;
            }
            ConcurrentHashMap<String, Integer> concurrentHashMapB = b();
            Integer numA = a(str, concurrentHashMapB);
            if (numA != null) {
                return numA.intValue();
            }
            try {
                numValueOf = Integer.valueOf(b(str, i11));
            } catch (Exception unused) {
                numValueOf = Integer.valueOf(i11);
            }
            concurrentHashMapB.put(str, numValueOf);
            return numValueOf.intValue();
        } catch (Exception unused2) {
            return i11;
        }
    }

    public final int a(String str, String str2, int i11) {
        Integer numValueOf;
        try {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                String str3 = str + "_" + str2;
                ConcurrentHashMap<String, Integer> concurrentHashMapB = b();
                Integer numA = a(str3, concurrentHashMapB);
                if (numA != null) {
                    return numA.intValue();
                }
                try {
                    numValueOf = Integer.valueOf(b(str, str2, i11));
                } catch (Exception unused) {
                    numValueOf = Integer.valueOf(i11);
                }
                concurrentHashMapB.put(str3, numValueOf);
                return numValueOf.intValue();
            }
            return a(str2, i11);
        } catch (Exception unused2) {
            return i11;
        }
    }

    public final boolean a(String str, boolean z11) {
        Boolean boolValueOf;
        try {
            if (TextUtils.isEmpty(str)) {
                return z11;
            }
            ConcurrentHashMap<String, Boolean> concurrentHashMapC = c();
            Boolean boolB = b(str, concurrentHashMapC);
            if (boolB != null) {
                return boolB.booleanValue();
            }
            try {
                boolValueOf = Boolean.valueOf(b(str, z11));
            } catch (Exception unused) {
                boolValueOf = Boolean.valueOf(z11);
            }
            concurrentHashMapC.put(str, boolValueOf);
            return boolValueOf.booleanValue();
        } catch (Exception unused2) {
            return z11;
        }
    }
}
