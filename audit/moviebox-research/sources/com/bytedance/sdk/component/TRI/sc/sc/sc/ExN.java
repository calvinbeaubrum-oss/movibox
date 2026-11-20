package com.bytedance.sdk.component.TRI.sc.sc.sc;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class ExN implements com.bytedance.sdk.component.TRI.sc.sc.ExN {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    public static final ExN f26636sc = new ExN();
    private volatile SQLiteDatabase pFF;

    @Override // com.bytedance.sdk.component.TRI.sc.sc.ExN
    public String ExN() {
        return "logstatsbatch";
    }

    @Override // com.bytedance.sdk.component.TRI.sc.sc.ExN
    public String TRI() {
        return null;
    }

    @Override // com.bytedance.sdk.component.TRI.sc.sc.ExN
    public String We() {
        return "logstats";
    }

    @Override // com.bytedance.sdk.component.TRI.sc.sc.ExN
    public String pFF() {
        return "adevent";
    }

    @Override // com.bytedance.sdk.component.TRI.sc.sc.ExN
    public SQLiteDatabase sc(Context context) {
        if (this.pFF == null) {
            synchronized (this) {
                try {
                    if (this.pFF == null) {
                        this.pFF = new We(context).getWritableDatabase();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return this.pFF;
    }

    @Override // com.bytedance.sdk.component.TRI.sc.sc.ExN
    public String sc() {
        return "loghighpriority";
    }

    @Override // com.bytedance.sdk.component.TRI.sc.sc.ExN
    public String zY() {
        return null;
    }
}
