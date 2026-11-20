package com.apm.insight.k;

import androidx.annotation.Nullable;
import com.apm.insight.CrashType;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static ConcurrentLinkedQueue<c> f16881a = new ConcurrentLinkedQueue<>();

    /* JADX INFO: renamed from: com.apm.insight.k.c$1, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    public static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f16882a;

        static {
            int[] iArr = new int[CrashType.values().length];
            f16882a = iArr;
            try {
                iArr[CrashType.JAVA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f16882a[CrashType.LAUNCH.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f16882a[CrashType.NATIVE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private JSONObject f16883a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private JSONObject f16884b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private CrashType f16885c;

        public a(JSONObject jSONObject, CrashType crashType) {
            this.f16885c = crashType;
            if (crashType == CrashType.LAUNCH) {
                this.f16883a = ((JSONArray) jSONObject.opt("data")).optJSONObject(0);
            } else {
                this.f16883a = jSONObject;
            }
            this.f16884b = jSONObject.optJSONObject("header");
        }

        @Nullable
        public final String a() {
            return this.f16883a.optString("crash_thread_name", null);
        }

        public final long b() {
            return this.f16883a.optInt("app_start_time", -1);
        }

        @Nullable
        public final String c() {
            int i11 = AnonymousClass1.f16882a[this.f16885c.ordinal()];
            if (i11 == 1) {
                return this.f16883a.optString("data", null);
            }
            if (i11 == 2) {
                return this.f16883a.optString("stack", null);
            }
            if (i11 != 3) {
                return null;
            }
            return this.f16883a.optString("data", null);
        }
    }

    public static void a(CrashType crashType, JSONObject jSONObject) {
        ConcurrentLinkedQueue<c> concurrentLinkedQueue = f16881a;
        if (concurrentLinkedQueue == null || concurrentLinkedQueue.isEmpty()) {
            return;
        }
        new a(jSONObject, crashType);
        while (!f16881a.isEmpty()) {
            f16881a.poll();
        }
        f16881a = null;
    }
}
