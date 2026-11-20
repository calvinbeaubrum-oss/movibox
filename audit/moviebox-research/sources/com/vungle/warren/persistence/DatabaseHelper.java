package com.vungle.warren.persistence;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.content.ContextWrapper;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.NonNull;
import com.mbridge.msdk.foundation.download.database.IDatabaseHelper;
import com.vungle.warren.VungleLogger;
import com.vungle.warren.utility.i;
import java.io.File;
import java.io.IOException;
import org.mvel2.ast.ASTNode;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class DatabaseHelper extends SQLiteOpenHelper {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f62243b = "DatabaseHelper";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f62244a;

    /* JADX INFO: compiled from: source.java */
    public static class DBException extends Exception {
        public DBException(String str) {
            super(str);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface a {
        void a(SQLiteDatabase sQLiteDatabase);

        void b(SQLiteDatabase sQLiteDatabase, int i11, int i12);

        void c(SQLiteDatabase sQLiteDatabase);

        void d(SQLiteDatabase sQLiteDatabase, int i11, int i12);
    }

    /* JADX INFO: compiled from: source.java */
    public static class b extends ContextWrapper {
        public b(Context context) {
            super(context);
        }

        @SuppressLint({"NewApi"})
        public final int a(int i11) {
            return ((i11 & 8) != 0 ? ASTNode.DISCARD : 0) | ASTNode.DEOP | ((i11 & 16) != 0 ? 16 : 0);
        }

        @Override // android.content.ContextWrapper, android.content.Context
        public File getDatabasePath(String str) {
            File databasePath = super.getDatabasePath(str);
            File file = new File(getApplicationContext().getNoBackupFilesDir(), str);
            try {
                i.b(new File(databasePath.getPath()));
                i.b(new File(databasePath.getPath() + "-journal"));
            } catch (IOException unused) {
                VungleLogger.d(true, DatabaseHelper.f62243b, IDatabaseHelper.TAG, "Failed to delete old db/-journal");
            }
            return file;
        }

        @Override // android.content.ContextWrapper, android.content.Context
        public SQLiteDatabase openOrCreateDatabase(String str, int i11, SQLiteDatabase.CursorFactory cursorFactory) {
            return SQLiteDatabase.openDatabase(getDatabasePath(str).getPath(), cursorFactory, a(i11));
        }

        @Override // android.content.ContextWrapper, android.content.Context
        public SQLiteDatabase openOrCreateDatabase(String str, int i11, SQLiteDatabase.CursorFactory cursorFactory, DatabaseErrorHandler databaseErrorHandler) {
            return SQLiteDatabase.openDatabase(getDatabasePath(str).getPath(), cursorFactory, a(i11), databaseErrorHandler);
        }
    }

    public DatabaseHelper(@NonNull Context context, int i11, @NonNull a aVar) {
        super(new b(context.getApplicationContext()), "vungle_db", (SQLiteDatabase.CursorFactory) null, i11);
        this.f62244a = aVar;
    }

    public void a(g gVar) throws DBException {
        try {
            e().delete(gVar.f62327a, gVar.f62329c, gVar.f62330d);
        } catch (SQLException e11) {
            throw new DBException(e11.getMessage());
        }
    }

    public synchronized void b() {
        this.f62244a.a(e());
        close();
        onCreate(e());
    }

    public void c() {
        e();
    }

    public long d(String str, ContentValues contentValues, int i11) throws DBException {
        try {
            return e().insertWithOnConflict(str, null, contentValues, i11);
        } catch (SQLException e11) {
            throw new DBException(e11.getMessage());
        }
    }

    public final synchronized SQLiteDatabase e() {
        return getWritableDatabase();
    }

    public Cursor g(g gVar) {
        return e().query(gVar.f62327a, gVar.f62328b, gVar.f62329c, gVar.f62330d, gVar.f62331e, gVar.f62332f, gVar.f62333g, gVar.f62334h);
    }

    public long h(g gVar, ContentValues contentValues) throws DBException {
        try {
            return e().update(gVar.f62327a, contentValues, gVar.f62329c, gVar.f62330d);
        } catch (SQLException e11) {
            throw new DBException(e11.getMessage());
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public synchronized void onCreate(SQLiteDatabase sQLiteDatabase) {
        this.f62244a.c(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i11, int i12) {
        this.f62244a.d(sQLiteDatabase, i11, i12);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i11, int i12) {
        this.f62244a.b(sQLiteDatabase, i11, i12);
    }
}
