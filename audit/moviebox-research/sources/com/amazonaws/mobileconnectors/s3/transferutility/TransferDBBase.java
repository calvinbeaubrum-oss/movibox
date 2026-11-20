package com.amazonaws.mobileconnectors.s3.transferutility;

import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.text.TextUtils;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
class TransferDBBase {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Log f15787f = LogFactory.b(TransferDBBase.class);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Object f15788g = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f15789a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Uri f15790b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final UriMatcher f15791c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TransferDatabaseHelper f15792d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public SQLiteDatabase f15793e;

    public TransferDBBase(Context context) {
        this.f15789a = context;
        String packageName = context.getApplicationContext().getPackageName();
        TransferDatabaseHelper transferDatabaseHelper = new TransferDatabaseHelper(context);
        this.f15792d = transferDatabaseHelper;
        this.f15793e = transferDatabaseHelper.getWritableDatabase();
        this.f15790b = Uri.parse("content://" + packageName + "/transfers");
        UriMatcher uriMatcher = new UriMatcher(-1);
        this.f15791c = uriMatcher;
        uriMatcher.addURI(packageName, "transfers", 10);
        uriMatcher.addURI(packageName, "transfers/#", 20);
        uriMatcher.addURI(packageName, "transfers/part/#", 30);
        uriMatcher.addURI(packageName, "transfers/state/*", 40);
    }

    public int a(Uri uri, ContentValues[] contentValuesArr) {
        int iMatch = this.f15791c.match(uri);
        c();
        if (iMatch != 10) {
            throw new IllegalArgumentException("Unknown URI: " + uri);
        }
        int iInsertOrThrow = 0;
        try {
            try {
                this.f15793e.beginTransaction();
                iInsertOrThrow = (int) this.f15793e.insertOrThrow("awstransfer", null, contentValuesArr[0]);
                for (int i11 = 1; i11 < contentValuesArr.length; i11++) {
                    contentValuesArr[i11].put("main_upload_id", Integer.valueOf(iInsertOrThrow));
                    this.f15793e.insertOrThrow("awstransfer", null, contentValuesArr[i11]);
                }
                this.f15793e.setTransactionSuccessful();
            } catch (Exception e11) {
                f15787f.e("bulkInsert error : ", e11);
            }
            return iInsertOrThrow;
        } finally {
            this.f15793e.endTransaction();
        }
    }

    public int b(Uri uri, String str, String[] strArr) {
        int iMatch = this.f15791c.match(uri);
        c();
        if (iMatch == 10) {
            return this.f15793e.delete("awstransfer", str, strArr);
        }
        if (iMatch != 20) {
            throw new IllegalArgumentException("Unknown URI: " + uri);
        }
        String lastPathSegment = uri.getLastPathSegment();
        if (TextUtils.isEmpty(str)) {
            return this.f15793e.delete("awstransfer", "_id=" + lastPathSegment, null);
        }
        return this.f15793e.delete("awstransfer", "_id=" + lastPathSegment + " and " + str, strArr);
    }

    public final void c() {
        synchronized (f15788g) {
            try {
                if (!this.f15793e.isOpen()) {
                    this.f15793e = this.f15792d.getWritableDatabase();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public Uri d() {
        return this.f15790b;
    }

    public Uri e(Uri uri, ContentValues contentValues) {
        int iMatch = this.f15791c.match(uri);
        c();
        if (iMatch != 10) {
            throw new IllegalArgumentException("Unknown URI: " + uri);
        }
        return Uri.parse("transfers/" + this.f15793e.insertOrThrow("awstransfer", null, contentValues));
    }

    public Cursor f(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        SQLiteQueryBuilder sQLiteQueryBuilder = new SQLiteQueryBuilder();
        sQLiteQueryBuilder.setTables("awstransfer");
        int iMatch = this.f15791c.match(uri);
        if (iMatch == 10) {
            sQLiteQueryBuilder.appendWhere("part_num=0");
        } else if (iMatch == 20) {
            sQLiteQueryBuilder.appendWhere("_id=" + uri.getLastPathSegment());
        } else if (iMatch == 30) {
            sQLiteQueryBuilder.appendWhere("main_upload_id=" + uri.getLastPathSegment());
        } else {
            if (iMatch != 40) {
                throw new IllegalArgumentException("Unknown URI: " + uri);
            }
            sQLiteQueryBuilder.appendWhere("state=");
            sQLiteQueryBuilder.appendWhereEscapeString(uri.getLastPathSegment());
        }
        c();
        return sQLiteQueryBuilder.query(this.f15793e, strArr, str, strArr2, null, null, str2);
    }

    public synchronized int g(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        int iUpdate;
        try {
            int iMatch = this.f15791c.match(uri);
            c();
            if (iMatch == 10) {
                iUpdate = this.f15793e.update("awstransfer", contentValues, str, strArr);
            } else {
                if (iMatch != 20) {
                    throw new IllegalArgumentException("Unknown URI: " + uri);
                }
                String lastPathSegment = uri.getLastPathSegment();
                if (TextUtils.isEmpty(str)) {
                    iUpdate = this.f15793e.update("awstransfer", contentValues, "_id=" + lastPathSegment, null);
                } else {
                    iUpdate = this.f15793e.update("awstransfer", contentValues, "_id=" + lastPathSegment + " and " + str, strArr);
                }
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return iUpdate;
    }
}
