package com.apm.insight.e;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.apm.insight.e;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile a f16752a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.apm.insight.e.a.b f16753b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private SQLiteDatabase f16754c;

    private a() {
    }

    public static a a() {
        if (f16752a == null) {
            synchronized (a.class) {
                try {
                    if (f16752a == null) {
                        f16752a = new a();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return f16752a;
    }

    private void b() {
        if (this.f16753b == null) {
            a(e.g());
        }
    }

    public final synchronized void a(Context context) {
        try {
            this.f16754c = new b(context).getWritableDatabase();
        } catch (Throwable th2) {
            com.apm.insight.a.b(th2);
        }
        this.f16753b = new com.apm.insight.e.a.b();
    }

    public final synchronized void a(com.apm.insight.d.a aVar) {
        b();
        com.apm.insight.e.a.b bVar = this.f16753b;
        if (bVar != null) {
            bVar.a(this.f16754c, aVar);
        }
    }

    public final synchronized boolean a(String str) {
        b();
        com.apm.insight.e.a.b bVar = this.f16753b;
        if (bVar == null) {
            return false;
        }
        return bVar.a(this.f16754c, str);
    }
}
