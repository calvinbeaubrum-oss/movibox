package com.bytedance.sdk.component.TRI.sc.sc.sc;

import android.content.ContentValues;
import android.content.Context;
import android.database.AbstractCursor;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.bytedance.sdk.component.TRI.sc.Qj;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
class pFF {
    private Context pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private C0250pFF f26638sc;

    /* JADX INFO: renamed from: com.bytedance.sdk.component.TRI.sc.sc.sc.pFF$pFF, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public class C0250pFF {
        private volatile SQLiteDatabase pFF = null;

        public C0250pFF() {
        }

        private boolean pFF() {
            SQLiteDatabase sQLiteDatabase = this.pFF;
            return sQLiteDatabase != null && sQLiteDatabase.inTransaction();
        }

        private void sc() {
            try {
                if (this.pFF != null && this.pFF.isOpen()) {
                    return;
                }
                synchronized (this) {
                    try {
                        if (this.pFF == null || !this.pFF.isOpen()) {
                            this.pFF = Qj.qr().We().sc(Qj.qr().TRI());
                            this.pFF.setLockingEnabled(false);
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
            } catch (Throwable th3) {
                if (pFF()) {
                    throw th3;
                }
            }
        }

        public int sc(String str, ContentValues contentValues, String str2, String[] strArr) throws Exception {
            try {
                sc();
                return this.pFF.update(str, contentValues, str2, strArr);
            } catch (Exception e11) {
                if (pFF()) {
                    throw e11;
                }
                return 0;
            }
        }

        public int sc(String str, String str2, String[] strArr) throws Exception {
            try {
                sc();
                return this.pFF.delete(str, str2, strArr);
            } catch (Exception e11) {
                if (pFF()) {
                    throw e11;
                }
                return 0;
            }
        }

        public long sc(String str, String str2, ContentValues contentValues) throws Exception {
            try {
                sc();
                return this.pFF.insert(str, str2, contentValues);
            } catch (Exception e11) {
                if (pFF()) {
                    throw e11;
                }
                return -1L;
            }
        }

        public Cursor sc(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5) {
            try {
                sc();
                return this.pFF.query(str, strArr, str2, strArr2, str3, str4, str5);
            } catch (Throwable th2) {
                sc scVar = new sc();
                if (pFF()) {
                    throw th2;
                }
                return scVar;
            }
        }

        public void sc(String str) throws SQLException {
            try {
                sc();
                this.pFF.execSQL(str);
            } catch (Throwable th2) {
                if (pFF()) {
                    throw th2;
                }
            }
        }

        public synchronized void sc(String str, String str2, List<com.bytedance.sdk.component.TRI.sc.We.sc> list) {
            JSONObject jSONObjectQr;
            try {
                try {
                    sc();
                    this.pFF.beginTransaction();
                    ContentValues contentValues = new ContentValues();
                    for (int i11 = 0; i11 < list.size(); i11++) {
                        com.bytedance.sdk.component.TRI.sc.We.sc scVar = list.get(i11);
                        if (scVar != null && (jSONObjectQr = scVar.qr()) != null) {
                            contentValues.put("id", scVar.zY());
                            String strPFF = Qj.qr().dE().pFF(jSONObjectQr.toString());
                            if (!TextUtils.isEmpty(strPFF)) {
                                contentValues.put(AppMeasurementSdk.ConditionalUserProperty.VALUE, strPFF);
                                contentValues.put("gen_time", Long.valueOf(System.currentTimeMillis()));
                                contentValues.put("retry", (Integer) 0);
                                contentValues.put("encrypt", (Integer) 1);
                                if (com.bytedance.sdk.component.TRI.sc.zY.sc.We() && scVar.WH() > 0 && (scVar.We() == 0 || scVar.We() == 3)) {
                                    contentValues.put("channel", Integer.valueOf(scVar.WH()));
                                }
                                this.pFF.insert(str, str2, contentValues);
                            }
                            contentValues.clear();
                        }
                    }
                    this.pFF.setTransactionSuccessful();
                    list.size();
                    if (this.pFF != null) {
                        this.pFF.endTransaction();
                    }
                } catch (Exception e11) {
                    list.size();
                    if (pFF()) {
                        throw e11;
                    }
                    if (this.pFF != null) {
                        this.pFF.endTransaction();
                    }
                }
            } catch (Throwable th2) {
                if (this.pFF != null) {
                    this.pFF.endTransaction();
                }
                throw th2;
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class sc extends AbstractCursor {
        private sc() {
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public String[] getColumnNames() {
            return new String[0];
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public int getCount() {
            return 0;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public double getDouble(int i11) {
            return 0.0d;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public float getFloat(int i11) {
            return 0.0f;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public int getInt(int i11) {
            return 0;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public long getLong(int i11) {
            return 0L;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public short getShort(int i11) {
            return (short) 0;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public String getString(int i11) {
            return null;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public boolean isNull(int i11) {
            return true;
        }
    }

    public pFF(Context context) {
        try {
            this.pFF = context.getApplicationContext();
            if (this.f26638sc == null) {
                this.f26638sc = new C0250pFF();
            }
        } catch (Throwable unused) {
        }
    }

    public C0250pFF sc() {
        return this.f26638sc;
    }
}
