package com.bytedance.sdk.openadsdk.core;

import android.content.ContentValues;
import android.content.Context;
import android.database.AbstractCursor;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class TRI {
    private static final Object zY = new Object();
    private Context pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private zY f28195sc;

    /* JADX INFO: compiled from: source.java */
    public class pFF extends AbstractCursor {
        private pFF() {
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

    /* JADX INFO: compiled from: source.java */
    public class sc extends SQLiteOpenHelper {

        /* JADX INFO: renamed from: sc, reason: collision with root package name */
        final Context f28197sc;

        public sc(Context context) {
            super(context, "ttopensdk.db", (SQLiteDatabase.CursorFactory) null, 11);
            this.f28197sc = context;
        }

        private ArrayList<String> We(SQLiteDatabase sQLiteDatabase) {
            ArrayList<String> arrayList = new ArrayList<>();
            Cursor cursorRawQuery = null;
            try {
                cursorRawQuery = sQLiteDatabase.rawQuery("select name from sqlite_master where type='table' order by name", null);
                if (cursorRawQuery != null) {
                    while (cursorRawQuery.moveToNext()) {
                        String string = cursorRawQuery.getString(0);
                        if (!string.equals("android_metadata") && !string.equals("sqlite_sequence")) {
                            arrayList.add(string);
                        }
                    }
                }
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
            } catch (Exception unused) {
                if (cursorRawQuery != null) {
                }
            } catch (Throwable th2) {
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
                throw th2;
            }
            return arrayList;
        }

        private void pFF(SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.execSQL(com.bytedance.sdk.openadsdk.core.UFX.sc.zY.We());
        }

        private void sc(SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.execSQL(com.bytedance.sdk.openadsdk.We.We.pFF());
            sQLiteDatabase.execSQL(com.bytedance.sdk.openadsdk.We.Ol.We());
            sQLiteDatabase.execSQL(com.bytedance.sdk.openadsdk.We.SR.pFF());
            sQLiteDatabase.execSQL(com.bytedance.sdk.openadsdk.We.Ql.pFF());
        }

        private void sc(SQLiteDatabase sQLiteDatabase, Context context) {
            sQLiteDatabase.execSQL(com.bytedance.sdk.openadsdk.We.We.sc());
            sQLiteDatabase.execSQL(com.bytedance.sdk.openadsdk.We.Ol.zY());
            sQLiteDatabase.execSQL(com.bytedance.sdk.openadsdk.We.SR.sc());
            sQLiteDatabase.execSQL(com.bytedance.sdk.openadsdk.We.Ql.sc());
            sQLiteDatabase.execSQL(com.bytedance.sdk.openadsdk.JPJ.pFF.sc());
            sQLiteDatabase.execSQL(com.bytedance.sdk.openadsdk.We.dE.zY());
            sQLiteDatabase.execSQL(com.bytedance.sdk.component.adexpress.sc.pFF.pFF.zY());
            sQLiteDatabase.execSQL(com.bytedance.sdk.openadsdk.core.UFX.sc.zY.zY());
            sQLiteDatabase.execSQL(com.bytedance.sdk.openadsdk.We.BT.sc());
        }

        private void zY(SQLiteDatabase sQLiteDatabase) {
            ArrayList<String> arrayListWe = We(sQLiteDatabase);
            if (arrayListWe == null || arrayListWe.size() <= 0) {
                return;
            }
            Iterator<String> it = arrayListWe.iterator();
            while (it.hasNext()) {
                sQLiteDatabase.execSQL(String.format("DROP TABLE IF EXISTS %s ;", it.next()));
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            try {
                sc(sQLiteDatabase, this.f28197sc);
            } catch (Throwable th2) {
                com.bytedance.sdk.component.utils.Tf.sc("DBHelper", th2.getMessage());
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i11, int i12) {
            if (i11 > i12) {
                try {
                    zY(sQLiteDatabase);
                    sc(sQLiteDatabase, TRI.this.pFF);
                } catch (Throwable th2) {
                    com.bytedance.sdk.component.utils.Tf.pFF(th2.getMessage());
                }
            }
        }

        /* JADX WARN: Code duplicated, block: B:10:0x0024 A[Catch: all -> 0x0006, TryCatch #1 {all -> 0x0006, blocks: (B:3:0x0002, B:5:0x0008, B:6:0x0011, B:8:0x0015, B:9:0x0019, B:10:0x0024, B:11:0x002f, B:12:0x003a, B:13:0x0043), top: B:23:0x0002 }] */
        /* JADX WARN: Code duplicated, block: B:11:0x002f A[Catch: all -> 0x0006, TryCatch #1 {all -> 0x0006, blocks: (B:3:0x0002, B:5:0x0008, B:6:0x0011, B:8:0x0015, B:9:0x0019, B:10:0x0024, B:11:0x002f, B:12:0x003a, B:13:0x0043), top: B:23:0x0002 }] */
        /* JADX WARN: Code duplicated, block: B:12:0x003a A[Catch: all -> 0x0006, TryCatch #1 {all -> 0x0006, blocks: (B:3:0x0002, B:5:0x0008, B:6:0x0011, B:8:0x0015, B:9:0x0019, B:10:0x0024, B:11:0x002f, B:12:0x003a, B:13:0x0043), top: B:23:0x0002 }] */
        /* JADX WARN: Code duplicated, block: B:13:0x0043 A[Catch: all -> 0x0006, TRY_LEAVE, TryCatch #1 {all -> 0x0006, blocks: (B:3:0x0002, B:5:0x0008, B:6:0x0011, B:8:0x0015, B:9:0x0019, B:10:0x0024, B:11:0x002f, B:12:0x003a, B:13:0x0043), top: B:23:0x0002 }] */
        /* JADX WARN: Code duplicated, block: B:7:0x0014 A[DONT_GENERATE] */
        /* JADX WARN: Code duplicated, block: B:8:0x0015 A[Catch: all -> 0x0006, TryCatch #1 {all -> 0x0006, blocks: (B:3:0x0002, B:5:0x0008, B:6:0x0011, B:8:0x0015, B:9:0x0019, B:10:0x0024, B:11:0x002f, B:12:0x003a, B:13:0x0043), top: B:23:0x0002 }] */
        /* JADX WARN: Code duplicated, block: B:9:0x0019 A[Catch: all -> 0x0006, TryCatch #1 {all -> 0x0006, blocks: (B:3:0x0002, B:5:0x0008, B:6:0x0011, B:8:0x0015, B:9:0x0019, B:10:0x0024, B:11:0x002f, B:12:0x003a, B:13:0x0043), top: B:23:0x0002 }] */
        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i11, int i12) {
            if (i11 <= i12) {
                sc(sQLiteDatabase, TRI.this.pFF);
                switch (i11) {
                    case 1:
                        sc(sQLiteDatabase);
                        break;
                    case 2:
                        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS 'ad_video_info';");
                        sc(sQLiteDatabase);
                        break;
                    case 3:
                        sQLiteDatabase.execSQL(com.bytedance.sdk.openadsdk.We.SR.sc());
                        sc(sQLiteDatabase);
                        break;
                    case 4:
                        sQLiteDatabase.execSQL(com.bytedance.sdk.component.adexpress.sc.pFF.pFF.zY());
                        sc(sQLiteDatabase);
                        break;
                    case 5:
                        sQLiteDatabase.execSQL(com.bytedance.sdk.openadsdk.We.Ql.sc());
                        sc(sQLiteDatabase);
                        break;
                    case 6:
                        sc(sQLiteDatabase);
                        break;
                }
            } else {
                try {
                    zY(sQLiteDatabase);
                    sc(sQLiteDatabase, TRI.this.pFF);
                    switch (i11) {
                        case 1:
                            sc(sQLiteDatabase);
                            break;
                        case 2:
                            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS 'ad_video_info';");
                            sc(sQLiteDatabase);
                            break;
                        case 3:
                            sQLiteDatabase.execSQL(com.bytedance.sdk.openadsdk.We.SR.sc());
                            sc(sQLiteDatabase);
                            break;
                        case 4:
                            sQLiteDatabase.execSQL(com.bytedance.sdk.component.adexpress.sc.pFF.pFF.zY());
                            sc(sQLiteDatabase);
                            break;
                        case 5:
                            sQLiteDatabase.execSQL(com.bytedance.sdk.openadsdk.We.Ql.sc());
                            sc(sQLiteDatabase);
                            break;
                        case 6:
                            sc(sQLiteDatabase);
                            break;
                    }
                } catch (Throwable unused) {
                }
            }
            if (i11 < 11) {
                try {
                    pFF(sQLiteDatabase);
                    com.bytedance.sdk.openadsdk.JPJ.pFF.sc(sQLiteDatabase);
                } catch (Throwable th2) {
                    com.bytedance.sdk.component.utils.Tf.sc("DBHelper", th2.getMessage());
                }
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class zY {
        private SQLiteDatabase pFF = null;

        public zY() {
        }

        private synchronized void ExN() {
            try {
                synchronized (TRI.zY) {
                    try {
                        SQLiteDatabase sQLiteDatabase = this.pFF;
                        if (sQLiteDatabase == null || !sQLiteDatabase.isOpen()) {
                            TRI tri = TRI.this;
                            SQLiteDatabase writableDatabase = tri.new sc(tri.zY()).getWritableDatabase();
                            this.pFF = writableDatabase;
                            writableDatabase.setLockingEnabled(false);
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
            } catch (Throwable th3) {
                com.bytedance.sdk.component.utils.Tf.sc("DBHelper", th3.getMessage());
                if (TRI()) {
                    throw th3;
                }
            }
        }

        private synchronized boolean TRI() {
            SQLiteDatabase sQLiteDatabase = this.pFF;
            return sQLiteDatabase != null && sQLiteDatabase.inTransaction();
        }

        public synchronized void We() {
            ExN();
            SQLiteDatabase sQLiteDatabase = this.pFF;
            if (sQLiteDatabase == null) {
                return;
            }
            sQLiteDatabase.endTransaction();
        }

        public synchronized void pFF() {
            ExN();
            SQLiteDatabase sQLiteDatabase = this.pFF;
            if (sQLiteDatabase == null) {
                return;
            }
            sQLiteDatabase.beginTransaction();
        }

        public synchronized int sc(String str, ContentValues contentValues, String str2, String[] strArr) {
            int iUpdate;
            try {
                ExN();
                iUpdate = this.pFF.update(str, contentValues, str2, strArr);
            } catch (Exception e11) {
                com.bytedance.sdk.component.utils.Tf.sc("DBHelper", e11.getMessage());
                if (TRI()) {
                    throw e11;
                }
                iUpdate = 0;
            }
            return iUpdate;
        }

        public synchronized int sc(String str, String str2, String[] strArr) {
            int iDelete;
            try {
                ExN();
                iDelete = this.pFF.delete(str, str2, strArr);
            } catch (Exception e11) {
                com.bytedance.sdk.component.utils.Tf.sc("DBHelper", e11.getMessage());
                if (TRI()) {
                    throw e11;
                }
                iDelete = 0;
            }
            return iDelete;
        }

        public synchronized long sc(String str, String str2, ContentValues contentValues) {
            long jReplace;
            try {
                ExN();
                jReplace = this.pFF.replace(str, str2, contentValues);
            } catch (Exception e11) {
                com.bytedance.sdk.component.utils.Tf.sc("DBHelper", e11.getMessage());
                if (TRI()) {
                    throw e11;
                }
                jReplace = -1;
            }
            return jReplace;
        }

        public synchronized Cursor sc(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5) {
            Cursor cursorQuery;
            try {
                ExN();
                cursorQuery = this.pFF.query(str, strArr, str2, strArr2, str3, str4, str5);
            } catch (Throwable th2) {
                com.bytedance.sdk.component.utils.Tf.sc("DBHelper", th2.getMessage());
                pFF pff = new pFF();
                if (TRI()) {
                    throw th2;
                }
                cursorQuery = pff;
            }
            return cursorQuery;
        }

        public SQLiteDatabase sc() {
            ExN();
            return this.pFF;
        }

        public synchronized void sc(String str) throws SQLException {
            try {
                ExN();
                this.pFF.execSQL(str);
            } catch (Throwable th2) {
                if (TRI()) {
                    throw th2;
                }
            }
        }

        public synchronized void zY() {
            ExN();
            SQLiteDatabase sQLiteDatabase = this.pFF;
            if (sQLiteDatabase == null) {
                return;
            }
            sQLiteDatabase.setTransactionSuccessful();
        }
    }

    public TRI(Context context) {
        try {
            this.pFF = context == null ? Xc.sc() : context.getApplicationContext();
            if (this.f28195sc == null) {
                this.f28195sc = new zY();
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Context zY() {
        Context context = this.pFF;
        return context == null ? Xc.sc() : context;
    }

    public zY sc() {
        return this.f28195sc;
    }
}
