package com.bytedance.sdk.openadsdk.dE;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import com.bytedance.sdk.openadsdk.BusMonitorDependWrapper;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class sc {
    private static final long ExN = System.currentTimeMillis();
    private static Context We;
    private com.bytedance.sdk.openadsdk.dE.zY.sc pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private pFF f28605sc;
    private Boolean zY;
    private int TRI = 0;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private final ArrayList<We> f28604qr = new ArrayList<>();
    private Runnable Qj = new Runnable() { // from class: com.bytedance.sdk.openadsdk.dE.sc.2
        @Override // java.lang.Runnable
        public void run() {
            sc scVar = sc.this;
            scVar.zY = Boolean.valueOf(scVar.f28605sc.isMonitorOpen());
            if (sc.this.zY.booleanValue()) {
                sc scVar2 = sc.this;
                scVar2.sc(scVar2.f28604qr);
                sc.this.f28604qr.clear();
            }
        }
    };
    private Runnable Ol = new Runnable() { // from class: com.bytedance.sdk.openadsdk.dE.sc.4
        @Override // java.lang.Runnable
        public void run() {
            String str = "_id";
            try {
                SQLiteDatabase sQLiteDatabasePFF = com.bytedance.sdk.openadsdk.dE.sc.sc.pFF();
                if (sQLiteDatabasePFF == null) {
                    return;
                }
                String[] strArr = {"_id", "sdk_version", "scene", "start_count", "success_count", "fail_count", "rit", "tag", "label", CampaignEx.JSON_KEY_TIMESTAMP, "mediation", "is_init", "extra"};
                String str2 = "extra";
                String[] strArr2 = {String.valueOf(sc.ExN)};
                try {
                    int iMax = Math.max(10, sc.this.f28605sc.getOnceLogCount());
                    int i11 = iMax > 100 ? 10 : iMax;
                    int i12 = i11;
                    Cursor cursorQuery = sQLiteDatabasePFF.query("monitor_table", strArr, "timestamp <= ?", strArr2, null, null, null, String.valueOf(i11));
                    if (cursorQuery != null) {
                        ArrayList arrayList = new ArrayList();
                        ArrayList arrayList2 = new ArrayList();
                        while (cursorQuery.moveToNext()) {
                            com.bytedance.sdk.openadsdk.dE.pFF.sc scVar = new com.bytedance.sdk.openadsdk.dE.pFF.sc();
                            if (cursorQuery.getColumnIndex(str) >= 0) {
                                long j11 = cursorQuery.getLong(cursorQuery.getColumnIndex(str));
                                scVar.sc(j11);
                                arrayList2.add(String.valueOf(j11));
                            }
                            if (cursorQuery.getColumnIndex("sdk_version") >= 0) {
                                scVar.sc(cursorQuery.getString(cursorQuery.getColumnIndex("sdk_version")));
                            }
                            if (cursorQuery.getColumnIndex("scene") >= 0) {
                                scVar.pFF(cursorQuery.getString(cursorQuery.getColumnIndex("scene")));
                            }
                            if (cursorQuery.getColumnIndex("start_count") >= 0) {
                                scVar.sc(cursorQuery.getInt(cursorQuery.getColumnIndex("start_count")));
                            }
                            if (cursorQuery.getColumnIndex("success_count") >= 0) {
                                scVar.pFF(cursorQuery.getInt(cursorQuery.getColumnIndex("success_count")));
                            }
                            if (cursorQuery.getColumnIndex("fail_count") >= 0) {
                                scVar.zY(cursorQuery.getInt(cursorQuery.getColumnIndex("fail_count")));
                            }
                            if (cursorQuery.getColumnIndex("rit") >= 0) {
                                scVar.zY(cursorQuery.getString(cursorQuery.getColumnIndex("rit")));
                            }
                            if (cursorQuery.getColumnIndex("tag") >= 0) {
                                scVar.We(cursorQuery.getString(cursorQuery.getColumnIndex("tag")));
                            }
                            if (cursorQuery.getColumnIndex("label") >= 0) {
                                scVar.ExN(cursorQuery.getString(cursorQuery.getColumnIndex("label")));
                            }
                            if (cursorQuery.getColumnIndex("mediation") >= 0) {
                                scVar.TRI(cursorQuery.getString(cursorQuery.getColumnIndex("mediation")));
                            }
                            if (cursorQuery.getColumnIndex("is_init") >= 0) {
                                scVar.We(cursorQuery.getInt(cursorQuery.getColumnIndex("is_init")));
                            }
                            String str3 = str2;
                            if (cursorQuery.getColumnIndex(str3) >= 0) {
                                scVar.qr(cursorQuery.getString(cursorQuery.getColumnIndex(str3)));
                            }
                            ArrayList arrayList3 = arrayList;
                            arrayList3.add(scVar);
                            str2 = str3;
                            arrayList = arrayList3;
                            str = str;
                        }
                        ArrayList arrayList4 = arrayList;
                        cursorQuery.close();
                        if (!arrayList4.isEmpty()) {
                            sc.this.f28605sc.onMonitorUpload(arrayList4);
                            SQLiteDatabase sQLiteDatabaseSc = com.bytedance.sdk.openadsdk.dE.sc.sc.sc();
                            if (sQLiteDatabaseSc != null && sQLiteDatabaseSc.isOpen()) {
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append("_id IN (");
                                for (int i13 = 0; i13 < arrayList2.size(); i13++) {
                                    sb2.append("?");
                                    if (i13 < arrayList2.size() - 1) {
                                        sb2.append(",");
                                    }
                                }
                                sb2.append(")");
                                sQLiteDatabaseSc.delete("monitor_table", sb2.toString(), (String[]) arrayList2.toArray(new String[0]));
                                if (sc.this.pFF != null) {
                                    sc.this.pFF.sc(sc.ExN);
                                }
                            }
                            if (arrayList4.size() < i12 || sc.this.TRI > 1000) {
                                return;
                            }
                            sc.this.sc(false);
                            return;
                        }
                    }
                    return;
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
            }
            Log.e("BusMonitorCenter", th.getMessage());
        }
    };

    private sc(pFF pff) {
        try {
            this.f28605sc = new BusMonitorDependWrapper(pff);
            this.pFF = new com.bytedance.sdk.openadsdk.dE.zY.sc(pff.getContext());
            We = pff.getContext();
        } catch (Throwable th2) {
            Log.e("BusMonitorCenter", th2.getMessage());
        }
    }

    public static /* synthetic */ int We(sc scVar) {
        int i11 = scVar.TRI;
        scVar.TRI = i11 + 1;
        return i11;
    }

    public static Context sc() {
        Context context = We;
        return context != null ? context : BusMonitorDependWrapper.getReflectContext();
    }

    public static sc sc(pFF pff) {
        return new sc(pff);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:40:0x015c  */
    /* JADX WARN: Code duplicated, block: B:79:0x0257 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Code duplicated, block: B:91:0x024c A[DONT_GENERATE, EXC_TOP_SPLITTER, SYNTHETIC] */
    public void sc(List<We> list) {
        String str;
        SQLiteDatabase sQLiteDatabase;
        String message;
        String str2;
        SQLiteDatabase sQLiteDatabase2;
        int i11;
        com.bytedance.sdk.openadsdk.dE.pFF.sc scVarGeneratorModel;
        List<We> list2 = list;
        String str3 = "BusMonitorCenter";
        String str4 = CampaignEx.JSON_KEY_TIMESTAMP;
        if (list2 == null || list.isEmpty()) {
            return;
        }
        try {
            SQLiteDatabase sQLiteDatabaseSc = com.bytedance.sdk.openadsdk.dE.sc.sc.sc();
            if (sQLiteDatabaseSc != null) {
                try {
                    sQLiteDatabaseSc.beginTransaction();
                    int i12 = 0;
                    while (i12 < list.size()) {
                        We we2 = list2.get(i12);
                        if (we2 == null || (scVarGeneratorModel = we2.generatorModel()) == null) {
                            str2 = str3;
                            i11 = i12;
                            sQLiteDatabase2 = sQLiteDatabaseSc;
                        } else {
                            String[] strArr = new String[13];
                            strArr[0] = "_id";
                            strArr[1] = "sdk_version";
                            strArr[2] = "scene";
                            strArr[3] = "start_count";
                            strArr[4] = "success_count";
                            str2 = str3;
                            try {
                                strArr[5] = "fail_count";
                                strArr[6] = "rit";
                                strArr[7] = "tag";
                                strArr[8] = "label";
                                strArr[9] = str4;
                                strArr[10] = "mediation";
                                strArr[11] = "is_init";
                                strArr[12] = "extra";
                                i11 = i12;
                                SQLiteDatabase sQLiteDatabase3 = sQLiteDatabaseSc;
                                try {
                                    Cursor cursorQuery = sQLiteDatabaseSc.query("monitor_table", strArr, new StringBuilder("sdk_version = ? AND scene = ? AND rit = ? AND tag = ? AND label = ? AND mediation = ? AND is_init = ? AND extra = ?").toString(), new String[]{scVarGeneratorModel.pFF(), scVarGeneratorModel.zY(), scVarGeneratorModel.qr(), scVarGeneratorModel.Qj(), scVarGeneratorModel.Ol(), scVarGeneratorModel.UFX(), String.valueOf(scVarGeneratorModel.Tf()), scVarGeneratorModel.Ql()}, null, null, null);
                                    if (cursorQuery != null) {
                                        try {
                                            if (cursorQuery.moveToNext()) {
                                                if (cursorQuery.getColumnIndex("_id") >= 0) {
                                                    scVarGeneratorModel.sc(cursorQuery.getLong(cursorQuery.getColumnIndex("_id")));
                                                }
                                                if (cursorQuery.getColumnIndex("start_count") >= 0) {
                                                    scVarGeneratorModel.sc(cursorQuery.getInt(cursorQuery.getColumnIndex("start_count")) + scVarGeneratorModel.We());
                                                }
                                                if (cursorQuery.getColumnIndex("success_count") >= 0) {
                                                    scVarGeneratorModel.pFF(cursorQuery.getInt(cursorQuery.getColumnIndex("success_count")) + scVarGeneratorModel.ExN());
                                                }
                                                if (cursorQuery.getColumnIndex("fail_count") >= 0) {
                                                    scVarGeneratorModel.zY(cursorQuery.getInt(cursorQuery.getColumnIndex("fail_count")) + scVarGeneratorModel.TRI());
                                                }
                                                if (cursorQuery.getColumnIndex(str4) >= 0) {
                                                    scVarGeneratorModel.pFF(Math.min(cursorQuery.getLong(cursorQuery.getColumnIndex(str4)), scVarGeneratorModel.WH()));
                                                }
                                            }
                                            cursorQuery.close();
                                        } catch (Throwable th2) {
                                            th = th2;
                                            str = str2;
                                            sQLiteDatabase = sQLiteDatabase3;
                                            try {
                                                Log.e(str, th.getMessage());
                                                if (sQLiteDatabase != null) {
                                                    try {
                                                        return;
                                                    } catch (Throwable th3) {
                                                        message = th3.getMessage();
                                                        Log.e(str, message);
                                                    }
                                                }
                                                return;
                                            } finally {
                                                if (sQLiteDatabase != null) {
                                                    try {
                                                        sQLiteDatabase.endTransaction();
                                                    } catch (Throwable th4) {
                                                        Log.e(str, th4.getMessage());
                                                    }
                                                }
                                            }
                                        }
                                    } else {
                                        str4 = str4;
                                    }
                                    ContentValues contentValues = new ContentValues();
                                    if (scVarGeneratorModel.sc() > 0) {
                                        contentValues.put("_id", Long.valueOf(scVarGeneratorModel.sc()));
                                    }
                                    contentValues.put("sdk_version", scVarGeneratorModel.pFF());
                                    contentValues.put("scene", scVarGeneratorModel.zY());
                                    contentValues.put("start_count", Integer.valueOf(scVarGeneratorModel.We()));
                                    contentValues.put("success_count", Integer.valueOf(scVarGeneratorModel.ExN()));
                                    contentValues.put("fail_count", Integer.valueOf(scVarGeneratorModel.TRI()));
                                    contentValues.put("rit", scVarGeneratorModel.qr());
                                    contentValues.put("tag", scVarGeneratorModel.Qj());
                                    contentValues.put("label", scVarGeneratorModel.Ol());
                                    str4 = str4;
                                    contentValues.put(str4, Long.valueOf(scVarGeneratorModel.WH()));
                                    contentValues.put("mediation", scVarGeneratorModel.UFX());
                                    contentValues.put("is_init", Integer.valueOf(scVarGeneratorModel.Tf()));
                                    contentValues.put("extra", scVarGeneratorModel.Ql());
                                    sQLiteDatabase2 = sQLiteDatabase3;
                                    try {
                                        sQLiteDatabase2.insertWithOnConflict("monitor_table", null, contentValues, 5);
                                    } catch (Throwable th5) {
                                        th = th5;
                                        sQLiteDatabase = sQLiteDatabase2;
                                        str = str2;
                                        Log.e(str, th.getMessage());
                                        if (sQLiteDatabase != null) {
                                            return;
                                        } else {
                                            return;
                                        }
                                    }
                                } catch (Throwable th6) {
                                    th = th6;
                                    sQLiteDatabase2 = sQLiteDatabase3;
                                    sQLiteDatabase = sQLiteDatabase2;
                                    str = str2;
                                    Log.e(str, th.getMessage());
                                    if (sQLiteDatabase != null) {
                                        return;
                                    } else {
                                        return;
                                    }
                                }
                            } catch (Throwable th7) {
                                th = th7;
                                sQLiteDatabase2 = sQLiteDatabaseSc;
                                sQLiteDatabase = sQLiteDatabase2;
                                str = str2;
                                Log.e(str, th.getMessage());
                                if (sQLiteDatabase != null) {
                                    return;
                                } else {
                                    return;
                                }
                            }
                        }
                        sQLiteDatabaseSc = sQLiteDatabase2;
                        str3 = str2;
                        i12 = i11 + 1;
                        list2 = list;
                    }
                    str2 = str3;
                    sQLiteDatabase2 = sQLiteDatabaseSc;
                    new StringBuilder("exec save size = ").append(list.size());
                    sQLiteDatabase2.setTransactionSuccessful();
                } catch (Throwable th8) {
                    th = th8;
                    str2 = str3;
                }
            } else {
                str2 = "BusMonitorCenter";
                sQLiteDatabase2 = sQLiteDatabaseSc;
            }
            if (sQLiteDatabase2 != null) {
                try {
                    sQLiteDatabase2.endTransaction();
                } catch (Throwable th9) {
                    message = th9.getMessage();
                    str = str2;
                    Log.e(str, message);
                }
            }
        } catch (Throwable th10) {
            th = th10;
            str = "BusMonitorCenter";
            sQLiteDatabase = null;
        }
    }

    private boolean zY() {
        if (this.zY == null) {
            pFF pff = this.f28605sc;
            if (pff == null || pff.getContext() == null || this.f28605sc.getHandler() == null) {
                return false;
            }
        } else {
            pFF pff2 = this.f28605sc;
            if (pff2 == null || pff2.getContext() == null || !this.f28605sc.isMonitorOpen() || this.f28605sc.getHandler() == null) {
                return false;
            }
        }
        return true;
    }

    public void sc(final We we2) {
        if (we2 == null || !zY()) {
            return;
        }
        this.f28605sc.getHandler().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.dE.sc.1
            @Override // java.lang.Runnable
            public void run() {
                sc scVar = sc.this;
                scVar.zY = Boolean.valueOf(scVar.f28605sc.isMonitorOpen());
                if (sc.this.zY.booleanValue()) {
                    sc.this.f28604qr.add(we2);
                    if (sc.this.f28604qr.size() >= 10) {
                        sc scVar2 = sc.this;
                        scVar2.sc(scVar2.f28604qr);
                        sc.this.f28604qr.clear();
                    }
                }
            }
        });
        this.f28605sc.getHandler().removeCallbacks(this.Qj);
        this.f28605sc.getHandler().postDelayed(this.Qj, 5000L);
    }

    public void sc(final boolean z11) {
        pFF pff = this.f28605sc;
        if (pff == null || pff.getHandler() == null || this.f28605sc.getContext() == null || this.pFF == null || !this.f28605sc.isMonitorOpen()) {
            return;
        }
        this.f28605sc.getHandler().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.dE.sc.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    sc.We(sc.this);
                    if (z11) {
                        long jSc = sc.this.pFF.sc();
                        if (jSc == 0) {
                            sc.this.pFF.sc(System.currentTimeMillis());
                            return;
                        } else if (sc.ExN - jSc < sc.this.f28605sc.getUploadIntervalTime()) {
                            return;
                        }
                    }
                    if (sc.this.f28605sc.getHandler() != null) {
                        sc.this.f28605sc.getHandler().post(sc.this.Ol);
                    }
                } catch (Throwable th2) {
                    Log.e("BusMonitorCenter", th2.getMessage());
                }
            }
        }, Math.max(this.f28605sc.getOnceLogInterval(), 10000));
    }
}
