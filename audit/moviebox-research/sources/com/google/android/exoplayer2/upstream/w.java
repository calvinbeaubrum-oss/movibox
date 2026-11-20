package com.google.android.exoplayer2.upstream;

import androidx.annotation.Nullable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, String> f35517a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public Map<String, String> f35518b;

    public synchronized Map<String, String> a() {
        try {
            if (this.f35518b == null) {
                this.f35518b = Collections.unmodifiableMap(new HashMap(this.f35517a));
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return this.f35518b;
    }
}
