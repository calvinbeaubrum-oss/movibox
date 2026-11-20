package com.apm.insight.a;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.apm.insight.CrashType;
import com.apm.insight.ICrashCallback;
import com.apm.insight.b.i;
import com.apm.insight.runtime.n;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class a implements ICrashCallback {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static volatile a f16595d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile String f16596a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile i.a f16597b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile i.a f16598c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private volatile boolean f16599e = false;

    private a() {
    }

    public static a a() {
        if (f16595d == null) {
            synchronized (a.class) {
                try {
                    if (f16595d == null) {
                        f16595d = new a();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return f16595d;
    }

    public final void a(String str, i.a aVar, i.a aVar2) {
        this.f16596a = str;
        this.f16597b = aVar;
        this.f16598c = aVar2;
        if (this.f16599e) {
            return;
        }
        this.f16599e = true;
        n.a().a(new Runnable() { // from class: com.apm.insight.a.a.1
            @Override // java.lang.Runnable
            public final void run() {
            }
        });
    }

    @Override // com.apm.insight.ICrashCallback
    public void onCrash(@NonNull CrashType crashType, @Nullable String str, @Nullable Thread thread) {
        crashType.equals(CrashType.NATIVE);
    }
}
