package com.bytedance.sdk.component.adexpress.sc.pFF;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import android.util.Log;
import android.util.LruCache;
import com.bytedance.sdk.component.utils.Tf;
import com.transsion.push.PushConstants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class TRI {
    private static volatile TRI pFF = null;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    public static int f26900sc = 20;
    private volatile ConcurrentHashMap<String, com.bytedance.sdk.component.adexpress.sc.zY.zY> ExN;
    private final Object We = new Object();
    private AtomicBoolean TRI = new AtomicBoolean(false);

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private LruCache<String, com.bytedance.sdk.component.adexpress.sc.zY.pFF> f26901qr = new LruCache<String, com.bytedance.sdk.component.adexpress.sc.zY.pFF>(f26900sc) { // from class: com.bytedance.sdk.component.adexpress.sc.pFF.TRI.1
        @Override // android.util.LruCache
        /* JADX INFO: renamed from: sc, reason: merged with bridge method [inline-methods] */
        public int sizeOf(String str, com.bytedance.sdk.component.adexpress.sc.zY.pFF pff) {
            return 1;
        }
    };
    private Set<String> zY = Collections.synchronizedSet(new HashSet());

    private TRI() {
    }

    private void We(String str) {
        LruCache<String, com.bytedance.sdk.component.adexpress.sc.zY.pFF> lruCache;
        if (TextUtils.isEmpty(str) || (lruCache = this.f26901qr) == null || lruCache.size() <= 0) {
            return;
        }
        synchronized (this.We) {
            this.f26901qr.remove(str);
        }
    }

    public static TRI sc() {
        if (pFF == null) {
            synchronized (TRI.class) {
                try {
                    if (pFF == null) {
                        pFF = new TRI();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return pFF;
    }

    public static void sc(int i11) {
        f26900sc = i11;
    }

    public static String zY() {
        return new StringBuilder("CREATE TABLE IF NOT EXISTS template_diff_new (_id INTEGER PRIMARY KEY AUTOINCREMENT,rit TEXT ,id TEXT UNIQUE,md5 TEXT ,url TEXT , data TEXT , version TEXT , update_time TEXT)").toString();
    }

    public List<com.bytedance.sdk.component.adexpress.sc.zY.pFF> pFF() {
        if (com.bytedance.sdk.component.adexpress.sc.sc.sc.sc().pFF() == null) {
            return null;
        }
        boolean z11 = this.TRI.get();
        this.TRI.set(true);
        ArrayList arrayList = new ArrayList();
        Cursor cursorSc = com.bytedance.sdk.component.adexpress.sc.sc.sc.sc().pFF().sc("template_diff_new", null, null, null, null, null, null);
        if (cursorSc != null) {
            while (cursorSc.moveToNext()) {
                try {
                    String string = cursorSc.getString(cursorSc.getColumnIndex("rit"));
                    String string2 = cursorSc.getString(cursorSc.getColumnIndex("id"));
                    String string3 = cursorSc.getString(cursorSc.getColumnIndex("md5"));
                    String string4 = cursorSc.getString(cursorSc.getColumnIndex("url"));
                    String string5 = cursorSc.getString(cursorSc.getColumnIndex("data"));
                    String string6 = cursorSc.getString(cursorSc.getColumnIndex("version"));
                    arrayList.add(new com.bytedance.sdk.component.adexpress.sc.zY.pFF().sc(string).pFF(string2).zY(string3).We(string4).ExN(string5).TRI(string6).sc(Long.valueOf(cursorSc.getLong(cursorSc.getColumnIndex(PushConstants.PROVIDER_FIELD_UPDATE_TIME)))));
                    synchronized (this.We) {
                        this.f26901qr.put(string2, (com.bytedance.sdk.component.adexpress.sc.zY.pFF) arrayList.get(arrayList.size() - 1));
                    }
                    this.zY.add(string2);
                    if (!z11 && com.bytedance.sdk.component.adexpress.sc.sc.sc.sc().TRI() != null) {
                        if (this.ExN == null) {
                            this.ExN = new ConcurrentHashMap<>();
                        }
                        if (string2 != null && !this.ExN.contains(string2)) {
                            this.ExN.put(string2, new com.bytedance.sdk.component.adexpress.sc.zY.zY(string, string2, string3));
                        }
                    }
                } catch (Throwable th2) {
                    try {
                        Tf.sc("TmplDbHelper", "getTemplate error", th2);
                    } finally {
                        cursorSc.close();
                    }
                }
            }
        }
        return arrayList;
    }

    public Set<String> pFF(String str) {
        if (!TextUtils.isEmpty(str) && com.bytedance.sdk.component.adexpress.sc.sc.sc.sc().pFF() != null) {
            HashSet hashSet = new HashSet();
            Cursor cursorSc = com.bytedance.sdk.component.adexpress.sc.sc.sc.sc().pFF().sc("template_diff_new", null, "rit=?", new String[]{str}, null, null, null);
            if (cursorSc != null) {
                try {
                    try {
                        if (cursorSc.moveToFirst()) {
                            do {
                                hashSet.add(cursorSc.getString(cursorSc.getColumnIndex("id")));
                            } while (cursorSc.moveToNext());
                            return hashSet;
                        }
                    } catch (Exception e11) {
                        Log.e("TmplDbHelper", "", e11);
                    }
                } finally {
                    cursorSc.close();
                }
            }
        }
        return null;
    }

    public com.bytedance.sdk.component.adexpress.sc.zY.pFF sc(String str) {
        com.bytedance.sdk.component.adexpress.sc.zY.pFF pff;
        com.bytedance.sdk.component.adexpress.sc.zY.pFF pffSc;
        if (TextUtils.isEmpty(str) || com.bytedance.sdk.component.adexpress.sc.sc.sc.sc().pFF() == null) {
            return null;
        }
        synchronized (this.We) {
            pff = this.f26901qr.get(String.valueOf(str));
        }
        if (pff != null) {
            return pff;
        }
        Cursor cursorSc = com.bytedance.sdk.component.adexpress.sc.sc.sc.sc().pFF().sc("template_diff_new", null, "id=?", new String[]{str}, null, null, null);
        if (cursorSc != null) {
            try {
                if (cursorSc.moveToFirst()) {
                    do {
                        String string = cursorSc.getString(cursorSc.getColumnIndex("rit"));
                        String string2 = cursorSc.getString(cursorSc.getColumnIndex("id"));
                        String string3 = cursorSc.getString(cursorSc.getColumnIndex("md5"));
                        String string4 = cursorSc.getString(cursorSc.getColumnIndex("url"));
                        String string5 = cursorSc.getString(cursorSc.getColumnIndex("data"));
                        String string6 = cursorSc.getString(cursorSc.getColumnIndex("version"));
                        pffSc = new com.bytedance.sdk.component.adexpress.sc.zY.pFF().sc(string).pFF(string2).zY(string3).We(string4).ExN(string5).TRI(string6).sc(Long.valueOf(cursorSc.getLong(cursorSc.getColumnIndex(PushConstants.PROVIDER_FIELD_UPDATE_TIME))));
                        synchronized (this.We) {
                            this.f26901qr.put(string2, pffSc);
                        }
                        this.zY.add(string2);
                    } while (cursorSc.moveToNext());
                    cursorSc.close();
                    return pffSc;
                }
            } catch (Throwable th2) {
                try {
                    Tf.sc("TmplDbHelper", "getTemplate error", th2);
                } finally {
                    cursorSc.close();
                }
            }
        }
        return null;
    }

    public void sc(com.bytedance.sdk.component.adexpress.sc.zY.pFF pff, boolean z11) {
        if (pff == null || com.bytedance.sdk.component.adexpress.sc.sc.sc.sc().pFF() == null || TextUtils.isEmpty(pff.pFF())) {
            return;
        }
        Cursor cursorSc = com.bytedance.sdk.component.adexpress.sc.sc.sc.sc().pFF().sc("template_diff_new", null, "id=?", new String[]{pff.pFF()}, null, null, null);
        boolean z12 = cursorSc != null && cursorSc.getCount() > 0;
        String string = null;
        if (cursorSc != null) {
            try {
                string = cursorSc.moveToFirst() ? cursorSc.getString(cursorSc.getColumnIndex("rit")) : null;
                cursorSc.close();
            } catch (Throwable unused) {
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("rit", pff.sc());
        contentValues.put("id", pff.pFF());
        contentValues.put("md5", pff.zY());
        contentValues.put("url", pff.We());
        contentValues.put("data", pff.ExN());
        contentValues.put("version", pff.TRI());
        contentValues.put(PushConstants.PROVIDER_FIELD_UPDATE_TIME, pff.qr());
        if (z12) {
            com.bytedance.sdk.component.adexpress.sc.sc.sc.sc().pFF().sc("template_diff_new", contentValues, "id=?", new String[]{pff.pFF()});
        } else {
            com.bytedance.sdk.component.adexpress.sc.sc.sc.sc().pFF().sc("template_diff_new", contentValues);
        }
        synchronized (this.We) {
            this.f26901qr.put(pff.pFF(), pff);
        }
        this.zY.add(pff.pFF());
        if (z11) {
            return;
        }
        try {
            if (com.bytedance.sdk.component.adexpress.sc.sc.sc.sc().TRI() == null) {
                return;
            }
            if (this.ExN == null) {
                this.ExN = new ConcurrentHashMap<>();
            }
            com.bytedance.sdk.component.adexpress.sc.zY.zY zYVar = new com.bytedance.sdk.component.adexpress.sc.zY.zY(pff.sc(), pff.pFF(), pff.zY());
            this.ExN.put(pff.pFF(), zYVar);
            if (string != null) {
                com.bytedance.sdk.component.adexpress.sc.sc.sc.sc().TRI();
                zYVar.pFF();
            }
            com.bytedance.sdk.component.adexpress.sc.sc.sc.sc().TRI();
            pff.sc();
        } catch (Throwable unused2) {
        }
    }

    public void sc(Set<String> set) {
        if (set == null || set.isEmpty() || com.bytedance.sdk.component.adexpress.sc.sc.sc.sc().pFF() == null) {
            return;
        }
        String[] strArr = (String[]) set.toArray(new String[set.size()]);
        if (strArr.length > 0) {
            for (int i11 = 0; i11 < strArr.length; i11++) {
                We(strArr[i11]);
                com.bytedance.sdk.component.adexpress.sc.sc.sc.sc().pFF().sc("template_diff_new", "id=?", new String[]{strArr[i11]});
                zY(strArr[i11]);
            }
        }
    }

    public void zY(String str) {
        com.bytedance.sdk.component.adexpress.sc.zY.zY zYVar;
        try {
            if (this.ExN == null || this.ExN.isEmpty() || (zYVar = this.ExN.get(str)) == null) {
                return;
            }
            if (!TextUtils.isEmpty(zYVar.sc()) && com.bytedance.sdk.component.adexpress.sc.sc.sc.sc().TRI() != null) {
                com.bytedance.sdk.component.adexpress.sc.sc.sc.sc().TRI();
            }
            this.ExN.remove(str);
        } catch (Throwable unused) {
        }
    }
}
