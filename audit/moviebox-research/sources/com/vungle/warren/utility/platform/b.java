package com.vungle.warren.utility.platform;

import android.content.Context;
import android.util.AndroidRuntimeException;
import android.webkit.WebSettings;
import com.vungle.warren.VungleLogger;
import com.vungle.warren.model.j;
import com.vungle.warren.persistence.DatabaseHelper;
import com.vungle.warren.persistence.Repository;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f62636a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f62637b = b.class.getSimpleName();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Repository f62638c;

    public b(Context context, Repository repository) {
        this.f62636a = context;
        this.f62638c = repository;
    }

    public final void a(String str) throws DatabaseHelper.DBException {
        j jVar = new j("userAgent");
        jVar.e("userAgent", str);
        this.f62638c.h0(jVar);
    }

    public void b(androidx.core.util.a<String> aVar) {
        try {
            String defaultUserAgent = WebSettings.getDefaultUserAgent(this.f62636a);
            aVar.accept(defaultUserAgent);
            a(defaultUserAgent);
        } catch (Exception e11) {
            if (e11 instanceof DatabaseHelper.DBException) {
                VungleLogger.c(this.f62637b, "Ran into database issue");
            }
            if (e11 instanceof AndroidRuntimeException) {
                VungleLogger.c(this.f62637b, "WebView could be missing here");
            }
            aVar.accept(null);
        }
    }
}
