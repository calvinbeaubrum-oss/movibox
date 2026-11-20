package com.mbridge.msdk.foundation.download.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Handler;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.download.core.GlobalComponent;
import com.mbridge.msdk.foundation.download.utils.Objects;
import com.mbridge.msdk.foundation.tools.ad;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class DatabaseHelper implements IDatabaseHelper {
    private volatile SQLiteDatabase database;
    private final IDatabaseOpenHelper databaseOpenHelper;
    private final Handler handler;
    private final String tableName = GlobalComponent.getInstance().getDatabaseTableName();

    public DatabaseHelper(Context context, Handler handler, IDatabaseOpenHelper iDatabaseOpenHelper) {
        this.handler = handler;
        this.databaseOpenHelper = iDatabaseOpenHelper;
    }

    @Override // com.mbridge.msdk.foundation.download.database.IDatabaseHelper
    public void clear() {
        this.handler.post(new Runnable() { // from class: com.mbridge.msdk.foundation.download.database.DatabaseHelper.9
            @Override // java.lang.Runnable
            public void run() {
                if (Objects.isNull(DatabaseHelper.this.database)) {
                    DatabaseHelper databaseHelper = DatabaseHelper.this;
                    databaseHelper.database = databaseHelper.databaseOpenHelper.getWritableDatabase();
                }
                if (Objects.isNull(DatabaseHelper.this.database)) {
                    return;
                }
                try {
                    try {
                        if (DatabaseHelper.this.database.isOpen()) {
                            try {
                                DatabaseHelper.this.database.beginTransaction();
                                DatabaseHelper.this.database.delete(DatabaseHelper.this.tableName, null, null);
                                DatabaseHelper.this.database.setTransactionSuccessful();
                                if (DatabaseHelper.this.database.inTransaction()) {
                                    DatabaseHelper.this.database.endTransaction();
                                }
                            } catch (Exception e11) {
                                if (MBridgeConstans.DEBUG) {
                                    e11.printStackTrace();
                                }
                                if (DatabaseHelper.this.database.inTransaction()) {
                                    DatabaseHelper.this.database.endTransaction();
                                }
                            }
                        }
                    } catch (Throwable th2) {
                        try {
                            if (DatabaseHelper.this.database.inTransaction()) {
                                DatabaseHelper.this.database.endTransaction();
                            }
                        } catch (Throwable th3) {
                            ad.b(IDatabaseHelper.TAG, th3.getMessage());
                        }
                        throw th2;
                    }
                } catch (Throwable th4) {
                    ad.b(IDatabaseHelper.TAG, th4.getMessage());
                }
            }
        });
    }

    @Override // com.mbridge.msdk.foundation.download.database.IDatabaseHelper
    public void find(final String str, final String str2, final IDatabaseHelper.IDatabaseListener iDatabaseListener) {
        this.handler.post(new Runnable() { // from class: com.mbridge.msdk.foundation.download.database.DatabaseHelper.1
            /* JADX WARN: Code duplicated, block: B:39:0x00b7  */
            /* JADX WARN: Code duplicated, block: B:42:0x00be  */
            @Override // java.lang.Runnable
            public void run() throws Throwable {
                Cursor cursorRawQuery;
                IDatabaseHelper.IDatabaseListener iDatabaseListener2;
                IDatabaseHelper.IDatabaseListener iDatabaseListener3;
                if (Objects.isNull(DatabaseHelper.this.database)) {
                    DatabaseHelper databaseHelper = DatabaseHelper.this;
                    databaseHelper.database = databaseHelper.databaseOpenHelper.getWritableDatabase();
                }
                DownloadModel downloadModelCreate = null;
                if (Objects.isNull(DatabaseHelper.this.database) || !DatabaseHelper.this.database.isOpen()) {
                    if (Objects.isNotNull(iDatabaseListener)) {
                        iDatabaseListener.onDatabase(null);
                        return;
                    }
                    return;
                }
                try {
                    cursorRawQuery = DatabaseHelper.this.database.rawQuery("SELECT * FROM " + DatabaseHelper.this.tableName + " WHERE " + DownloadModel.DOWNLOAD_ID + " = '" + str + "' AND " + DownloadModel.DIRECTORY_PATH + " = '" + str2 + "'", null);
                    if (cursorRawQuery != null) {
                        try {
                            try {
                                if (cursorRawQuery.moveToFirst()) {
                                    downloadModelCreate = DownloadModel.create(cursorRawQuery);
                                }
                            } catch (Exception e11) {
                                e = e11;
                                if (MBridgeConstans.DEBUG) {
                                    e.printStackTrace();
                                }
                                if (cursorRawQuery != null) {
                                    cursorRawQuery.close();
                                }
                                iDatabaseListener3 = iDatabaseListener;
                                if (iDatabaseListener3 == null) {
                                    return;
                                }
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            if (cursorRawQuery != null) {
                                cursorRawQuery.close();
                            }
                            iDatabaseListener2 = iDatabaseListener;
                            if (iDatabaseListener2 != null) {
                                iDatabaseListener2.onDatabase(null);
                            }
                            throw th;
                        }
                    }
                    if (cursorRawQuery != null) {
                        cursorRawQuery.close();
                    }
                    iDatabaseListener3 = iDatabaseListener;
                    if (iDatabaseListener3 == null) {
                        return;
                    }
                } catch (Exception e12) {
                    e = e12;
                    cursorRawQuery = null;
                } catch (Throwable th3) {
                    th = th3;
                    cursorRawQuery = null;
                    if (cursorRawQuery != null) {
                        cursorRawQuery.close();
                    }
                    iDatabaseListener2 = iDatabaseListener;
                    if (iDatabaseListener2 != null) {
                        iDatabaseListener2.onDatabase(null);
                    }
                    throw th;
                }
                iDatabaseListener3.onDatabase(downloadModelCreate);
            }
        });
    }

    @Override // com.mbridge.msdk.foundation.download.database.IDatabaseHelper
    public List<DownloadModel> findAll() {
        ArrayList arrayList = new ArrayList();
        Cursor cursorRawQuery = null;
        try {
            try {
                if (Objects.isNull(this.database)) {
                    this.database = this.databaseOpenHelper.getWritableDatabase();
                }
                if (!Objects.isNull(this.database) && this.database.isOpen()) {
                    cursorRawQuery = rawQuery("SELECT * FROM " + this.tableName, null);
                    if (cursorRawQuery != null) {
                        while (cursorRawQuery.moveToNext()) {
                            arrayList.add(DownloadModel.create(cursorRawQuery));
                        }
                    }
                    if (cursorRawQuery != null) {
                        cursorRawQuery.close();
                    }
                }
                return arrayList;
            } catch (Exception e11) {
                if (MBridgeConstans.DEBUG) {
                    e11.printStackTrace();
                }
                return arrayList;
            }
        } catch (Throwable unused) {
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
            return arrayList;
        }
    }

    @Override // com.mbridge.msdk.foundation.download.database.IDatabaseHelper
    public void findByDownloadUrl(final String str, final IDatabaseHelper.IDatabaseListener iDatabaseListener) {
        this.handler.post(new Runnable() { // from class: com.mbridge.msdk.foundation.download.database.DatabaseHelper.2
            /* JADX WARN: Code duplicated, block: B:39:0x00a5  */
            /* JADX WARN: Code duplicated, block: B:42:0x00ac  */
            @Override // java.lang.Runnable
            public void run() throws Throwable {
                Cursor cursorRawQuery;
                IDatabaseHelper.IDatabaseListener iDatabaseListener2;
                IDatabaseHelper.IDatabaseListener iDatabaseListener3;
                if (Objects.isNull(DatabaseHelper.this.database)) {
                    DatabaseHelper databaseHelper = DatabaseHelper.this;
                    databaseHelper.database = databaseHelper.databaseOpenHelper.getWritableDatabase();
                }
                DownloadModel downloadModelCreate = null;
                if (Objects.isNull(DatabaseHelper.this.database) || !DatabaseHelper.this.database.isOpen()) {
                    if (Objects.isNotNull(iDatabaseListener)) {
                        iDatabaseListener.onDatabase(null);
                        return;
                    }
                    return;
                }
                try {
                    cursorRawQuery = DatabaseHelper.this.database.rawQuery("SELECT * FROM " + DatabaseHelper.this.tableName + " WHERE download_url = '" + str + "'", null);
                    if (cursorRawQuery != null) {
                        try {
                            try {
                                if (cursorRawQuery.moveToFirst()) {
                                    downloadModelCreate = DownloadModel.create(cursorRawQuery);
                                }
                            } catch (Exception e11) {
                                e = e11;
                                if (MBridgeConstans.DEBUG) {
                                    e.printStackTrace();
                                }
                                if (cursorRawQuery != null) {
                                    cursorRawQuery.close();
                                }
                                iDatabaseListener3 = iDatabaseListener;
                                if (iDatabaseListener3 == null) {
                                    return;
                                }
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            if (cursorRawQuery != null) {
                                cursorRawQuery.close();
                            }
                            iDatabaseListener2 = iDatabaseListener;
                            if (iDatabaseListener2 != null) {
                                iDatabaseListener2.onDatabase(null);
                            }
                            throw th;
                        }
                    }
                    if (cursorRawQuery != null) {
                        cursorRawQuery.close();
                    }
                    iDatabaseListener3 = iDatabaseListener;
                    if (iDatabaseListener3 == null) {
                        return;
                    }
                } catch (Exception e12) {
                    e = e12;
                    cursorRawQuery = null;
                } catch (Throwable th3) {
                    th = th3;
                    cursorRawQuery = null;
                    if (cursorRawQuery != null) {
                        cursorRawQuery.close();
                    }
                    iDatabaseListener2 = iDatabaseListener;
                    if (iDatabaseListener2 != null) {
                        iDatabaseListener2.onDatabase(null);
                    }
                    throw th;
                }
                iDatabaseListener3.onDatabase(downloadModelCreate);
            }
        });
    }

    @Override // com.mbridge.msdk.foundation.download.database.IDatabaseHelper
    public List<DownloadModel> getUnwantedModels(long j11) {
        ArrayList arrayList = new ArrayList();
        Cursor cursorRawQuery = null;
        try {
            try {
                if (Objects.isNull(this.database)) {
                    this.database = this.databaseOpenHelper.getWritableDatabase();
                }
                if (!Objects.isNull(this.database) && this.database.isOpen()) {
                    long jCurrentTimeMillis = System.currentTimeMillis() - j11;
                    cursorRawQuery = this.database.rawQuery("SELECT * FROM " + this.tableName + " WHERE " + DownloadModel.LAST_MODIFIED_TIME + " <= " + jCurrentTimeMillis, null);
                    if (cursorRawQuery != null && cursorRawQuery.moveToFirst()) {
                        do {
                            arrayList.add(DownloadModel.create(cursorRawQuery));
                        } while (cursorRawQuery.moveToNext());
                    }
                    if (cursorRawQuery != null) {
                        cursorRawQuery.close();
                    }
                    return arrayList;
                }
                return arrayList;
            } catch (Exception e11) {
                if (MBridgeConstans.DEBUG) {
                    e11.printStackTrace();
                }
                if (cursorRawQuery != null) {
                }
            }
        } catch (Throwable th2) {
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
            throw th2;
        }
    }

    @Override // com.mbridge.msdk.foundation.download.database.IDatabaseHelper
    public void insert(final DownloadModel downloadModel) {
        this.handler.postAtFrontOfQueue(new Runnable() { // from class: com.mbridge.msdk.foundation.download.database.DatabaseHelper.3
            @Override // java.lang.Runnable
            public void run() {
                if (Objects.isNull(DatabaseHelper.this.database)) {
                    DatabaseHelper databaseHelper = DatabaseHelper.this;
                    databaseHelper.database = databaseHelper.databaseOpenHelper.getWritableDatabase();
                }
                if (Objects.isNull(DatabaseHelper.this.database) || !DatabaseHelper.this.database.isOpen()) {
                    return;
                }
                try {
                    try {
                        try {
                            DatabaseHelper.this.database.beginTransaction();
                            DatabaseHelper.this.database.insert(DatabaseHelper.this.tableName, null, DownloadModel.create(downloadModel));
                            DatabaseHelper.this.database.setTransactionSuccessful();
                            if (DatabaseHelper.this.database.inTransaction()) {
                                DatabaseHelper.this.database.endTransaction();
                            }
                        } catch (Exception e11) {
                            if (MBridgeConstans.DEBUG) {
                                e11.printStackTrace();
                            }
                            if (DatabaseHelper.this.database.inTransaction()) {
                                DatabaseHelper.this.database.endTransaction();
                            }
                        }
                    } catch (Throwable th2) {
                        ad.b(IDatabaseHelper.TAG, th2.getMessage());
                    }
                } catch (Throwable th3) {
                    try {
                        if (DatabaseHelper.this.database.inTransaction()) {
                            DatabaseHelper.this.database.endTransaction();
                        }
                    } catch (Throwable th4) {
                        ad.b(IDatabaseHelper.TAG, th4.getMessage());
                    }
                    throw th3;
                }
            }
        });
    }

    @Override // com.mbridge.msdk.foundation.download.database.IDatabaseHelper
    public Cursor rawQuery(String str, String[] strArr) {
        try {
            try {
                if (Objects.isNull(this.database)) {
                    this.database = this.databaseOpenHelper.getWritableDatabase();
                }
                if (!Objects.isNull(this.database) && this.database.isOpen()) {
                    this.database.beginTransaction();
                    Cursor cursorRawQuery = this.database.rawQuery(str, strArr);
                    this.database.setTransactionSuccessful();
                    return cursorRawQuery;
                }
                return null;
            } finally {
                try {
                    if (this.database.inTransaction()) {
                        this.database.endTransaction();
                    }
                } catch (Throwable th2) {
                    if (MBridgeConstans.DEBUG) {
                        th2.printStackTrace();
                    }
                }
            }
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                e11.printStackTrace();
            }
            return null;
        }
    }

    @Override // com.mbridge.msdk.foundation.download.database.IDatabaseHelper
    public void remove(final String str) {
        this.handler.post(new Runnable() { // from class: com.mbridge.msdk.foundation.download.database.DatabaseHelper.7
            @Override // java.lang.Runnable
            public void run() {
                if (Objects.isNull(DatabaseHelper.this.database)) {
                    DatabaseHelper databaseHelper = DatabaseHelper.this;
                    databaseHelper.database = databaseHelper.databaseOpenHelper.getWritableDatabase();
                }
                if (Objects.isNull(DatabaseHelper.this.database) || !DatabaseHelper.this.database.isOpen()) {
                    return;
                }
                try {
                    DatabaseHelper.this.database.execSQL("DELETE FROM " + DatabaseHelper.this.tableName + " WHERE " + DownloadModel.DOWNLOAD_ID + " = '" + str + "'");
                } catch (Exception e11) {
                    if (MBridgeConstans.DEBUG) {
                        e11.printStackTrace();
                    }
                }
            }
        });
    }

    @Override // com.mbridge.msdk.foundation.download.database.IDatabaseHelper
    public void remove(final String str, final String str2) {
        this.handler.post(new Runnable() { // from class: com.mbridge.msdk.foundation.download.database.DatabaseHelper.6
            @Override // java.lang.Runnable
            public void run() {
                if (Objects.isNull(DatabaseHelper.this.database)) {
                    DatabaseHelper databaseHelper = DatabaseHelper.this;
                    databaseHelper.database = databaseHelper.databaseOpenHelper.getWritableDatabase();
                }
                if (Objects.isNull(DatabaseHelper.this.database) || !DatabaseHelper.this.database.isOpen()) {
                    return;
                }
                try {
                    DatabaseHelper.this.database.execSQL("DELETE FROM " + DatabaseHelper.this.tableName + " WHERE " + DownloadModel.DOWNLOAD_ID + " = '" + str + "' AND " + DownloadModel.DIRECTORY_PATH + " = '" + str2 + "'");
                } catch (Exception e11) {
                    if (MBridgeConstans.DEBUG) {
                        e11.printStackTrace();
                    }
                }
            }
        });
    }

    @Override // com.mbridge.msdk.foundation.download.database.IDatabaseHelper
    public void update(final DownloadModel downloadModel, final String str) {
        this.handler.post(new Runnable() { // from class: com.mbridge.msdk.foundation.download.database.DatabaseHelper.4
            @Override // java.lang.Runnable
            public void run() {
                if (Objects.isNull(DatabaseHelper.this.database)) {
                    DatabaseHelper databaseHelper = DatabaseHelper.this;
                    databaseHelper.database = databaseHelper.databaseOpenHelper.getWritableDatabase();
                }
                if (Objects.isNull(DatabaseHelper.this.database) || !DatabaseHelper.this.database.isOpen()) {
                    return;
                }
                try {
                    DatabaseHelper.this.database.update(DatabaseHelper.this.tableName, DownloadModel.create(downloadModel), "download_id = ? AND director_path = ?", new String[]{downloadModel.getDownloadId(), str});
                } catch (Exception e11) {
                    if (MBridgeConstans.DEBUG) {
                        e11.printStackTrace();
                    }
                }
            }
        });
    }

    @Override // com.mbridge.msdk.foundation.download.database.IDatabaseHelper
    public void updateProgress(final String str, final String str2, final DownloadModel downloadModel) {
        this.handler.post(new Runnable() { // from class: com.mbridge.msdk.foundation.download.database.DatabaseHelper.5
            @Override // java.lang.Runnable
            public void run() {
                if (Objects.isNull(DatabaseHelper.this.database)) {
                    DatabaseHelper databaseHelper = DatabaseHelper.this;
                    databaseHelper.database = databaseHelper.databaseOpenHelper.getWritableDatabase();
                }
                if (Objects.isNull(DatabaseHelper.this.database) || !DatabaseHelper.this.database.isOpen()) {
                    return;
                }
                try {
                    DatabaseHelper.this.database.update(DatabaseHelper.this.tableName, DownloadModel.create(downloadModel), "download_id = ? AND director_path = ?", new String[]{str, str2});
                } catch (Exception e11) {
                    if (MBridgeConstans.DEBUG) {
                        e11.printStackTrace();
                    }
                }
            }
        });
    }

    @Override // com.mbridge.msdk.foundation.download.database.IDatabaseHelper
    public void updateUnzipResource(final String str, String str2, long j11) {
        this.handler.post(new Runnable() { // from class: com.mbridge.msdk.foundation.download.database.DatabaseHelper.8
            @Override // java.lang.Runnable
            public void run() {
                if (Objects.isNull(DatabaseHelper.this.database)) {
                    DatabaseHelper databaseHelper = DatabaseHelper.this;
                    databaseHelper.database = databaseHelper.databaseOpenHelper.getWritableDatabase();
                }
                if (Objects.isNull(DatabaseHelper.this.database) || !DatabaseHelper.this.database.isOpen()) {
                    return;
                }
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(DownloadModel.DOWNLOAD_ID, str);
                    DatabaseHelper.this.database.update(DatabaseHelper.this.tableName, contentValues, "download_id = '" + str + "'", null);
                } catch (Exception e11) {
                    if (MBridgeConstans.DEBUG) {
                        e11.printStackTrace();
                    }
                }
            }
        });
    }
}
