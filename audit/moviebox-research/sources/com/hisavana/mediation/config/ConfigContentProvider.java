package com.hisavana.mediation.config;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.cloud.config.utils.XLogUtil;
import com.cloud.sdk.commonutil.gsonutil.GsonUtil;
import com.cloud.sdk.commonutil.util.f;
import com.hisavana.common.utils.AdLogUtil;
import com.hisavana.mediation.bean.CloudControlConfig;
import hn.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class ConfigContentProvider extends ContentProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public UriMatcher f41907a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f41908b = "";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public SQLiteDatabase f41909c;

    public final UriMatcher a() {
        if (this.f41907a == null) {
            if (f.a() != null) {
                this.f41908b = f.a().getPackageName() + ".HisavanaConfigContentProvider";
                UriMatcher uriMatcher = new UriMatcher(-1);
                this.f41907a = uriMatcher;
                uriMatcher.addURI(this.f41908b, XLogUtil.TAG, 200);
            } else {
                AdLogUtil.Log().e("ssp", "HSCoreUtil is not init now");
            }
        }
        return this.f41907a;
    }

    public final Cursor b(String[] strArr) {
        String str;
        if (strArr != null) {
            try {
                if (strArr.length == 0) {
                    str = "select * from cloudList";
                } else {
                    StringBuilder sb2 = new StringBuilder("(");
                    for (int i11 = 0; i11 < strArr.length; i11++) {
                        AdLogUtil.Log().d("ConfigContentProvider", "getCursorForProvider ***** " + strArr[i11]);
                        if (i11 == strArr.length - 1) {
                            sb2.append("'");
                            sb2.append(strArr[i11]);
                            sb2.append("'");
                        } else {
                            sb2.append("'");
                            sb2.append(strArr[i11]);
                            sb2.append("',");
                        }
                    }
                    sb2.append(")");
                    str = "select * from cloudList where codeSeatId IN " + sb2.toString();
                }
            } catch (Exception e11) {
                AdLogUtil.Log().e("ConfigContentProvider", "getCursorForProvider e " + Log.getStackTraceString(e11));
                return null;
            }
        } else {
            str = "select * from cloudList";
        }
        c();
        AdLogUtil.Log().d("ConfigContentProvider", "getCursorForProvider sql " + str);
        return this.f41909c.rawQuery(str, null);
    }

    public final synchronized SQLiteDatabase c() {
        SQLiteDatabase sQLiteDatabase = this.f41909c;
        if (sQLiteDatabase == null || !sQLiteDatabase.isOpen()) {
            try {
                this.f41909c = new d(f.a()).getWritableDatabase();
            } catch (Exception e11) {
                AdLogUtil.Log().e("ConfigContentProvider", "openDB ex " + Log.getStackTraceString(e11));
            }
        }
        return this.f41909c;
    }

    @Override // android.content.ContentProvider
    public int delete(@NonNull Uri uri, @Nullable String str, @Nullable String[] strArr) {
        if (a() == null || this.f41907a.match(uri) != 200) {
            return 0;
        }
        c();
        AdLogUtil.Log().d("ConfigContentProvider", "delete ");
        try {
            return this.f41909c.delete("cloudList", str, strArr);
        } catch (Exception e11) {
            AdLogUtil.Log().e("ConfigContentProvider", "delete Exception:" + Log.getStackTraceString(e11));
            return 0;
        }
    }

    @Override // android.content.ContentProvider
    @Nullable
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        SQLiteDatabase sQLiteDatabase;
        if (a() == null) {
            return null;
        }
        boolean z11 = false;
        if (this.f41907a.match(uri) == 200) {
            if (contentValues != null && contentValues.keySet() != null) {
                try {
                    if (!contentValues.keySet().isEmpty()) {
                        try {
                            SQLiteDatabase sQLiteDatabaseC = c();
                            this.f41909c = sQLiteDatabaseC;
                            if (sQLiteDatabaseC == null) {
                                Uri uri2 = Uri.parse("content://" + this.f41908b + "/" + XLogUtil.TAG + "/false");
                                SQLiteDatabase sQLiteDatabase2 = this.f41909c;
                                if (sQLiteDatabase2 != null) {
                                    sQLiteDatabase2.endTransaction();
                                }
                                return uri2;
                            }
                            Set<String> setKeySet = contentValues.keySet();
                            AdLogUtil.Log().d("ConfigContentProvider", "insert ids " + setKeySet);
                            ArrayList<CloudControlConfig.CodeSeat> arrayList = new ArrayList();
                            Iterator<String> it = setKeySet.iterator();
                            while (it.hasNext()) {
                                arrayList.add((CloudControlConfig.CodeSeat) GsonUtil.a((String) contentValues.get(it.next()), CloudControlConfig.CodeSeat.class));
                            }
                            this.f41909c.beginTransaction();
                            this.f41909c.delete("cloudList", null, null);
                            for (CloudControlConfig.CodeSeat codeSeat : arrayList) {
                                String strD = GsonUtil.d(codeSeat);
                                ContentValues contentValues2 = new ContentValues();
                                contentValues2.put("codeSeatId", codeSeat.getCodeSeatId());
                                contentValues2.put("json", strD);
                                this.f41909c.insert("cloudList", null, contentValues2);
                            }
                            z11 = true;
                            this.f41909c.setTransactionSuccessful();
                            sQLiteDatabase = this.f41909c;
                            if (sQLiteDatabase != null) {
                                sQLiteDatabase.endTransaction();
                            }
                        } catch (Exception e11) {
                            AdLogUtil.Log().e("ConfigContentProvider", "insert e " + Log.getStackTraceString(e11));
                            sQLiteDatabase = this.f41909c;
                            if (sQLiteDatabase != null) {
                            }
                        }
                    }
                } catch (Throwable th2) {
                    SQLiteDatabase sQLiteDatabase3 = this.f41909c;
                    if (sQLiteDatabase3 != null) {
                        sQLiteDatabase3.endTransaction();
                    }
                    throw th2;
                }
            }
            return Uri.parse("content://" + this.f41908b + "/" + XLogUtil.TAG + "/false");
        }
        return Uri.parse("content://" + this.f41908b + "/" + XLogUtil.TAG + "/" + z11);
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return true;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Cursor query(@NonNull Uri uri, @Nullable String[] strArr, @Nullable String str, @Nullable String[] strArr2, @Nullable String str2) {
        try {
            AdLogUtil.Log().d("ConfigContentProvider", "query " + uri);
            if (a() != null && this.f41907a.match(uri) == 200) {
                AdLogUtil.Log().d("ConfigContentProvider", "query ");
                return b(strArr);
            }
        } catch (Exception e11) {
            AdLogUtil.Log().e("ConfigContentProvider", "query error: " + Log.getStackTraceString(e11));
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:40:0x00ec A[PHI: r0 r6
  0x00ec: PHI (r0v3 int) = (r0v2 int), (r0v5 int) binds: [B:39:0x00ea, B:35:0x00c9] A[DONT_GENERATE, DONT_INLINE]
  0x00ec: PHI (r6v11 android.database.sqlite.SQLiteDatabase) = (r6v10 android.database.sqlite.SQLiteDatabase), (r6v19 android.database.sqlite.SQLiteDatabase) binds: [B:39:0x00ea, B:35:0x00c9] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // android.content.ContentProvider
    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String str, @Nullable String[] strArr) {
        SQLiteDatabase sQLiteDatabase;
        int i11 = 0;
        if (a() == null) {
            return 0;
        }
        if (this.f41907a.match(uri) == 200 && contentValues != null && contentValues.keySet() != null && !contentValues.keySet().isEmpty()) {
            try {
                try {
                    c();
                    SQLiteDatabase sQLiteDatabase2 = this.f41909c;
                    if (sQLiteDatabase2 == null) {
                        if (sQLiteDatabase2 != null) {
                            sQLiteDatabase2.endTransaction();
                        }
                        return 0;
                    }
                    Set<String> setKeySet = contentValues.keySet();
                    AdLogUtil.Log().d("ConfigContentProvider", "update id " + setKeySet);
                    ArrayList<CloudControlConfig.CodeSeat> arrayList = new ArrayList();
                    Iterator<String> it = setKeySet.iterator();
                    while (it.hasNext()) {
                        arrayList.add((CloudControlConfig.CodeSeat) GsonUtil.a((String) contentValues.get(it.next()), CloudControlConfig.CodeSeat.class));
                    }
                    this.f41909c.beginTransaction();
                    int iUpdate = 0;
                    for (CloudControlConfig.CodeSeat codeSeat : arrayList) {
                        try {
                            String strD = GsonUtil.d(codeSeat);
                            ContentValues contentValues2 = new ContentValues();
                            contentValues2.put("codeSeatId", codeSeat.getCodeSeatId());
                            contentValues2.put("json", strD);
                            iUpdate = this.f41909c.update("cloudList", contentValues2, "codeSeatId=?", new String[]{codeSeat.getCodeSeatId()});
                        } catch (Exception e11) {
                            e = e11;
                            i11 = iUpdate;
                            AdLogUtil.Log().e("ConfigContentProvider", "update e " + Log.getStackTraceString(e));
                            sQLiteDatabase = this.f41909c;
                            if (sQLiteDatabase != null) {
                            }
                            return i11;
                        }
                    }
                    this.f41909c.setTransactionSuccessful();
                    sQLiteDatabase = this.f41909c;
                    i11 = iUpdate;
                    if (sQLiteDatabase != null) {
                        sQLiteDatabase.endTransaction();
                    }
                } catch (Exception e12) {
                    e = e12;
                }
                if (sQLiteDatabase != null) {
                    sQLiteDatabase.endTransaction();
                }
            } catch (Throwable th2) {
                SQLiteDatabase sQLiteDatabase3 = this.f41909c;
                if (sQLiteDatabase3 != null) {
                    sQLiteDatabase3.endTransaction();
                }
                throw th2;
            }
            AdLogUtil.Log().e("ConfigContentProvider", "update e " + Log.getStackTraceString(e));
            sQLiteDatabase = this.f41909c;
        }
        return i11;
    }
}
