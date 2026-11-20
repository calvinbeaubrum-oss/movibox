package com.bykv.vk.openvk.sc.sc.pFF.pFF.pFF;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import android.text.TextUtils;
import android.util.SparseArray;
import com.bykv.vk.openvk.sc.sc.pFF.pFF.pFF;
import com.bytedance.sdk.component.Qj.Ol;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class zY {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile zY f26009e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SparseArray<Map<String, pFF.e>> f26010a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final pFF.c f26011b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Executor f26012c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile SQLiteStatement f26013d;

    public zY(Context context) {
        SparseArray<Map<String, pFF.e>> sparseArray = new SparseArray<>(2);
        this.f26010a = sparseArray;
        this.f26012c = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingDeque(), new Ol(5, "video_proxy_db"));
        this.f26011b = new pFF.c(context.getApplicationContext());
        sparseArray.put(0, new ConcurrentHashMap());
        sparseArray.put(1, new ConcurrentHashMap());
    }

    public static zY f(Context context) {
        if (f26009e == null) {
            synchronized (zY.class) {
                try {
                    if (f26009e == null) {
                        f26009e = new zY(context);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return f26009e;
    }

    public final String b(int i11) {
        if (i11 <= 0) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder(i11 << 1);
        sb2.append("?");
        for (int i12 = 1; i12 < i11; i12++) {
            sb2.append(",?");
        }
        return sb2.toString();
    }

    public pFF.e e(String str, int i11) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Map<String, pFF.e> map = this.f26010a.get(i11);
        pFF.e eVar = map == null ? null : map.get(str);
        if (eVar != null) {
            return eVar;
        }
        try {
            Cursor cursorQuery = this.f26011b.getReadableDatabase().query("video_http_header_t", null, "key=? AND flag=?", new String[]{str, String.valueOf(i11)}, null, null, null, "1");
            if (cursorQuery != null) {
                if (cursorQuery.getCount() > 0 && cursorQuery.moveToNext()) {
                    eVar = new pFF.e(cursorQuery.getString(cursorQuery.getColumnIndex("key")), cursorQuery.getString(cursorQuery.getColumnIndex("mime")), cursorQuery.getInt(cursorQuery.getColumnIndex("contentLength")), i11, cursorQuery.getString(cursorQuery.getColumnIndex("extra")));
                }
                cursorQuery.close();
            }
            if (eVar != null && map != null) {
                map.put(str, eVar);
            }
            return eVar;
        } catch (Throwable unused) {
            return null;
        }
    }

    public void g(final int i11) {
        Map<String, pFF.e> map = this.f26010a.get(i11);
        if (map != null) {
            map.clear();
        }
        this.f26012c.execute(new Runnable() { // from class: com.bykv.vk.openvk.sc.sc.pFF.pFF.pFF.zY.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    zY.this.f26011b.getWritableDatabase().delete("video_http_header_t", "flag=?", new String[]{String.valueOf(i11)});
                } catch (Throwable unused) {
                }
            }
        });
    }

    public void h(final pFF.e eVar) {
        if (eVar != null) {
            Map<String, pFF.e> map = this.f26010a.get(eVar.f26007d);
            if (map != null) {
                map.put(eVar.f26004a, eVar);
            }
            this.f26012c.execute(new Runnable() { // from class: com.bykv.vk.openvk.sc.sc.pFF.pFF.pFF.zY.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (zY.this.f26013d == null) {
                            zY zYVar = zY.this;
                            zYVar.f26013d = zYVar.f26011b.getWritableDatabase().compileStatement("INSERT INTO video_http_header_t (key,mime,contentLength,flag,extra) VALUES(?,?,?,?,?)");
                        } else {
                            zY.this.f26013d.clearBindings();
                        }
                        zY.this.f26013d.bindString(1, eVar.f26004a);
                        zY.this.f26013d.bindString(2, eVar.f26005b);
                        zY.this.f26013d.bindLong(3, eVar.f26006c);
                        zY.this.f26013d.bindLong(4, eVar.f26007d);
                        zY.this.f26013d.bindString(5, eVar.f26008e);
                        zY.this.f26013d.executeInsert();
                    } catch (Throwable unused) {
                    }
                }
            });
        }
    }

    public void i(Collection<String> collection, int i11) {
        if (collection == null || collection.isEmpty()) {
            return;
        }
        int size = collection.size() + 1;
        String[] strArr = new String[size];
        Map<String, pFF.e> map = this.f26010a.get(i11);
        int i12 = -1;
        for (String str : collection) {
            if (map != null) {
                map.remove(str);
            }
            i12++;
            strArr[i12] = str;
        }
        strArr[i12 + 1] = String.valueOf(i11);
        try {
            this.f26011b.getWritableDatabase().delete("video_http_header_t", "key IN(" + b(size) + ") AND flag=?", strArr);
        } catch (Throwable unused) {
        }
    }
}
