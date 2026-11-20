package com.apm.insight.e.a;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import com.apm.insight.c;
import com.apm.insight.runtime.k;
import java.util.HashMap;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final String f16755a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f16756b = "_id";

    public a(String str) {
        this.f16755a = str;
    }

    public abstract ContentValues a(T t11);

    public abstract HashMap<String, String> a();

    public final void a(SQLiteDatabase sQLiteDatabase) {
        try {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("CREATE TABLE ");
            sb2.append(this.f16755a);
            sb2.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT, ");
            HashMap<String, String> mapA = a();
            for (String str : mapA.keySet()) {
                sb2.append(str);
                sb2.append(" ");
                sb2.append(mapA.get(str));
                sb2.append(",");
            }
            sb2.delete(sb2.length() - 1, sb2.length());
            sb2.append(")");
            sQLiteDatabase.execSQL(sb2.toString());
        } catch (Throwable th2) {
            c.a();
            k.a(th2, "NPTH_CATCH");
        }
    }

    public void a(SQLiteDatabase sQLiteDatabase, T t11) {
        if (sQLiteDatabase == null || t11 == null) {
            return;
        }
        try {
            sQLiteDatabase.insert(this.f16755a, null, a(t11));
        } catch (Throwable th2) {
            com.apm.insight.a.b(th2);
        }
    }
}
