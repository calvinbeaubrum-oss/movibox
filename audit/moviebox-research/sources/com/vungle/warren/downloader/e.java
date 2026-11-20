package com.vungle.warren.downloader;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f61993a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f61994b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f61995c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f61996d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f61998f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f61999g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f62001i;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public AtomicReference<b> f61997e = new AtomicReference<>();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public AtomicBoolean f62000h = new AtomicBoolean(false);

    public e(int i11, b bVar, @NonNull String str, @NonNull String str2, boolean z11, String str3, String str4) {
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Url or path is empty");
        }
        this.f61993a = i11;
        this.f61997e.set(bVar);
        this.f61994b = str;
        this.f61995c = str2;
        this.f61998f = UUID.nameUUIDFromBytes((str2 + "_" + str).getBytes()).toString();
        this.f61996d = z11;
        this.f61999g = str3;
        this.f62001i = str4;
    }

    public void a() {
        this.f62000h.set(true);
    }

    public String b() {
        return this.f62001i;
    }

    public b c() {
        return this.f61997e.get();
    }

    public boolean d() {
        return this.f62000h.get();
    }

    public void e(b bVar) {
        this.f61997e.set(bVar);
    }

    public String toString() {
        return "DownloadRequest{networkType=" + this.f61993a + ", priority=" + this.f61997e + ", url='" + this.f61994b + "', path='" + this.f61995c + "', pauseOnConnectionLost=" + this.f61996d + ", id='" + this.f61998f + "', cookieString='" + this.f61999g + "', cancelled=" + this.f62000h + ", advertisementId=" + this.f62001i + '}';
    }
}
