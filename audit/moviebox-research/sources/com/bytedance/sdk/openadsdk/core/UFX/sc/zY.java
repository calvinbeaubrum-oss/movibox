package com.bytedance.sdk.openadsdk.core.UFX.sc;

import android.content.ContentValues;
import android.text.TextUtils;
import android.util.LruCache;
import com.bytedance.sdk.component.utils.Tf;
import com.bytedance.sdk.openadsdk.core.Xc;
import com.transsion.push.PushConstants;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class zY {
    private static volatile zY pFF = null;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    public static int f28307sc = 20;
    private final Object zY = new Object();
    private final LruCache<String, sc> We = new LruCache<String, sc>(f28307sc) { // from class: com.bytedance.sdk.openadsdk.core.UFX.sc.zY.1
        @Override // android.util.LruCache
        /* JADX INFO: renamed from: sc, reason: merged with bridge method [inline-methods] */
        public int sizeOf(String str, sc scVar) {
            return 1;
        }
    };

    private zY() {
    }

    public static String We() {
        return "ALTER TABLE ugen_template ADD COLUMN rit TEXT ";
    }

    private void pFF(String str) {
        if (!TextUtils.isEmpty(str) && this.We.size() > 0) {
            synchronized (this.zY) {
                this.We.remove(str);
            }
        }
    }

    public static zY sc() {
        if (pFF == null) {
            synchronized (zY.class) {
                try {
                    if (pFF == null) {
                        pFF = new zY();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return pFF;
    }

    public static String zY() {
        return new StringBuilder("CREATE TABLE IF NOT EXISTS ugen_template (_id INTEGER PRIMARY KEY AUTOINCREMENT,id TEXT UNIQUE,md5 TEXT ,url TEXT , data TEXT , rit TEXT , update_time TEXT)").toString();
    }

    public List<sc> pFF() {
        ArrayList arrayList = new ArrayList();
        com.bytedance.sdk.openadsdk.multipro.aidl.zY zYVar = new com.bytedance.sdk.openadsdk.multipro.aidl.zY(com.bytedance.sdk.openadsdk.multipro.sc.sc.sc(Xc.sc(), "ugen_template", null, null, null, null, null, null));
        try {
            if (zYVar.moveToFirst()) {
                do {
                    int columnIndex = zYVar.getColumnIndex("id");
                    int columnIndex2 = zYVar.getColumnIndex("md5");
                    int columnIndex3 = zYVar.getColumnIndex("url");
                    int columnIndex4 = zYVar.getColumnIndex("data");
                    int columnIndex5 = zYVar.getColumnIndex(PushConstants.PROVIDER_FIELD_UPDATE_TIME);
                    if (columnIndex != -1 && columnIndex2 != -1 && columnIndex3 != -1 && columnIndex5 != -1 && columnIndex4 != -1) {
                        int columnIndex6 = zYVar.getColumnIndex("rit");
                        String string = columnIndex6 != -1 ? zYVar.getString(columnIndex6) : null;
                        String string2 = zYVar.getString(columnIndex);
                        String string3 = zYVar.getString(columnIndex2);
                        String string4 = zYVar.getString(columnIndex3);
                        sc scVarSc = new sc().sc(string2).pFF(string3).zY(string4).We(zYVar.getString(columnIndex4)).ExN(string).sc(Long.valueOf(zYVar.getLong(columnIndex5)));
                        arrayList.add(scVarSc);
                        synchronized (this.zY) {
                            this.We.put(string2, scVarSc);
                        }
                    }
                } while (zYVar.moveToNext());
            }
        } catch (Throwable th2) {
            try {
                Tf.sc("UGTmplDbHelper", "getUgenTemplate error", th2);
            } finally {
                zYVar.close();
            }
        }
        return arrayList;
    }

    public sc sc(String str, String str2) {
        sc scVar;
        sc scVarSc;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        synchronized (this.zY) {
            scVar = this.We.get(str);
        }
        if (scVar != null) {
            if (TextUtils.equals(str2, scVar.pFF())) {
                return scVar;
            }
            pFF(str2);
            return null;
        }
        com.bytedance.sdk.openadsdk.multipro.aidl.zY zYVar = new com.bytedance.sdk.openadsdk.multipro.aidl.zY(com.bytedance.sdk.openadsdk.multipro.sc.sc.sc(Xc.sc(), "ugen_template", null, "id=? AND md5=?", new String[]{str, str2}, null, null, null));
        try {
            if (zYVar.moveToFirst()) {
                do {
                    int columnIndex = zYVar.getColumnIndex("id");
                    int columnIndex2 = zYVar.getColumnIndex("md5");
                    int columnIndex3 = zYVar.getColumnIndex("url");
                    int columnIndex4 = zYVar.getColumnIndex("data");
                    int columnIndex5 = zYVar.getColumnIndex(PushConstants.PROVIDER_FIELD_UPDATE_TIME);
                    if (columnIndex != -1 && columnIndex2 != -1 && columnIndex3 != -1 && columnIndex5 != -1 && columnIndex4 != -1) {
                        int columnIndex6 = zYVar.getColumnIndex("rit");
                        String string = zYVar.getString(columnIndex);
                        String string2 = zYVar.getString(columnIndex2);
                        String string3 = zYVar.getString(columnIndex3);
                        String string4 = zYVar.getString(columnIndex4);
                        if (TextUtils.isEmpty(string4)) {
                            zYVar.close();
                            return null;
                        }
                        scVarSc = new sc().sc(string).pFF(string2).We(string4).zY(string3).ExN(columnIndex6 != -1 ? zYVar.getString(columnIndex6) : null).sc(Long.valueOf(zYVar.getLong(columnIndex5)));
                        synchronized (this.zY) {
                            this.We.put(string, scVarSc);
                        }
                    }
                    zYVar.close();
                    return null;
                } while (zYVar.moveToNext());
                zYVar.close();
                return scVarSc;
            }
        } catch (Throwable th2) {
            try {
                Tf.sc("UGTmplDbHelper", "getGgenTemplate error", th2);
            } finally {
                zYVar.close();
            }
        }
        return null;
    }

    public Set<sc> sc(String str) {
        sc scVar;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        HashSet hashSet = new HashSet();
        com.bytedance.sdk.openadsdk.multipro.aidl.zY zYVar = new com.bytedance.sdk.openadsdk.multipro.aidl.zY(com.bytedance.sdk.openadsdk.multipro.sc.sc.sc(Xc.sc(), "ugen_template", null, "rit=?", new String[]{str}, null, null, null));
        try {
            if (zYVar.moveToFirst()) {
                do {
                    int columnIndex = zYVar.getColumnIndex("id");
                    if (columnIndex != -1) {
                        String string = zYVar.getString(columnIndex);
                        if (!TextUtils.isEmpty(string)) {
                            synchronized (this.zY) {
                                scVar = this.We.get(string);
                            }
                            if (scVar != null) {
                                hashSet.add(scVar);
                            } else {
                                sc scVar2 = new sc();
                                int columnIndex2 = zYVar.getColumnIndex("data");
                                if (columnIndex2 != -1) {
                                    String string2 = zYVar.getString(columnIndex2);
                                    if (!TextUtils.isEmpty(string2)) {
                                        scVar2.We(string2);
                                        scVar2.sc(string);
                                        scVar2.ExN(str);
                                        int columnIndex3 = zYVar.getColumnIndex("md5");
                                        int columnIndex4 = zYVar.getColumnIndex("url");
                                        int columnIndex5 = zYVar.getColumnIndex(PushConstants.PROVIDER_FIELD_UPDATE_TIME);
                                        if (columnIndex3 != -1) {
                                            scVar2.pFF(zYVar.getString(columnIndex3));
                                        }
                                        if (columnIndex4 != -1) {
                                            scVar2.zY(zYVar.getString(columnIndex4));
                                        }
                                        if (columnIndex5 != -1) {
                                            scVar2.sc(Long.valueOf(zYVar.getLong(columnIndex5)));
                                        }
                                        hashSet.add(scVar2);
                                        synchronized (this.zY) {
                                            this.We.put(string, scVar2);
                                        }
                                    }
                                }
                            }
                        }
                    }
                } while (zYVar.moveToNext());
            }
        } catch (Throwable th2) {
            try {
                Tf.sc("UGTmplDbHelper", "getUgenTemplateFormRit error", th2);
            } finally {
                zYVar.close();
            }
        }
        return hashSet;
    }

    public void sc(sc scVar) {
        if (scVar == null || TextUtils.isEmpty(scVar.sc())) {
            return;
        }
        com.bytedance.sdk.openadsdk.multipro.aidl.zY zYVar = new com.bytedance.sdk.openadsdk.multipro.aidl.zY(com.bytedance.sdk.openadsdk.multipro.sc.sc.sc(Xc.sc(), "ugen_template", null, "id=?", new String[]{scVar.sc()}, null, null, null));
        boolean z11 = zYVar.getCount() > 0;
        try {
            zYVar.close();
        } catch (Throwable unused) {
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", scVar.sc());
        contentValues.put("md5", scVar.pFF());
        contentValues.put("url", scVar.zY());
        contentValues.put("data", scVar.ExN());
        contentValues.put("rit", scVar.TRI());
        contentValues.put(PushConstants.PROVIDER_FIELD_UPDATE_TIME, scVar.We());
        if (z11) {
            com.bytedance.sdk.openadsdk.multipro.sc.sc.sc(Xc.sc(), "ugen_template", contentValues, "id=?", new String[]{scVar.sc()});
        } else {
            com.bytedance.sdk.openadsdk.multipro.sc.sc.sc(Xc.sc(), "ugen_template", contentValues);
        }
        synchronized (this.zY) {
            this.We.put(scVar.sc(), scVar);
        }
    }

    public void sc(Set<String> set) {
        if (set == null || set.isEmpty()) {
            return;
        }
        String[] strArr = (String[]) set.toArray(new String[set.size()]);
        if (strArr.length > 0) {
            for (String str : strArr) {
                pFF(str);
                com.bytedance.sdk.openadsdk.multipro.sc.sc.sc(Xc.sc(), "ugen_template", "id=?", new String[]{str});
            }
        }
    }
}
