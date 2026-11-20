package hn;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import com.cloud.sdk.commonutil.gsonutil.GsonUtil;
import com.hisavana.common.utils.AdLogUtil;
import com.hisavana.mediation.bean.CloudControlConfig;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class e implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SQLiteDatabase f66584a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicInteger f66585b;

    /* JADX INFO: compiled from: source.java */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f66586a = new e();
    }

    public e() {
        this.f66585b = new AtomicInteger();
    }

    public static e d() {
        return b.f66586a;
    }

    @Override // hn.j
    public void a() {
        try {
            e();
            this.f66584a.delete("cloudList", null, null);
        } catch (Exception e11) {
            AdLogUtil.Log().e("CloudControlDatabaseManager", Log.getStackTraceString(e11));
        }
    }

    @Override // hn.j
    public void a(CloudControlConfig.CodeSeat codeSeat) {
        SQLiteDatabase sQLiteDatabase;
        try {
            try {
                e();
                SQLiteDatabase sQLiteDatabase2 = this.f66584a;
                if (sQLiteDatabase2 == null) {
                    if (sQLiteDatabase2 != null) {
                        sQLiteDatabase2.endTransaction();
                        return;
                    }
                    return;
                }
                sQLiteDatabase2.beginTransaction();
                String strD = GsonUtil.d(codeSeat);
                ContentValues contentValues = new ContentValues();
                contentValues.put("codeSeatId", codeSeat.getCodeSeatId());
                contentValues.put("json", strD);
                this.f66584a.update("cloudList", contentValues, "codeSeatId=?", new String[]{codeSeat.getCodeSeatId()});
                this.f66584a.setTransactionSuccessful();
                sQLiteDatabase = this.f66584a;
                if (sQLiteDatabase != null) {
                    sQLiteDatabase.endTransaction();
                }
            } catch (Exception e11) {
                AdLogUtil.Log().e("CloudControlDatabaseManager", "update e " + Log.getStackTraceString(e11));
                sQLiteDatabase = this.f66584a;
                if (sQLiteDatabase != null) {
                }
            }
        } catch (Throwable th2) {
            SQLiteDatabase sQLiteDatabase3 = this.f66584a;
            if (sQLiteDatabase3 != null) {
                sQLiteDatabase3.endTransaction();
            }
            throw th2;
        }
    }

    @Override // hn.j
    public boolean a(List<CloudControlConfig.CodeSeat> list) {
        if (list != null) {
            try {
                if (list.size() >= 1) {
                    try {
                        e();
                        SQLiteDatabase sQLiteDatabase = this.f66584a;
                        if (sQLiteDatabase == null) {
                            if (sQLiteDatabase != null) {
                                sQLiteDatabase.endTransaction();
                            }
                            return false;
                        }
                        sQLiteDatabase.beginTransaction();
                        this.f66584a.delete("cloudList", null, null);
                        for (CloudControlConfig.CodeSeat codeSeat : list) {
                            if (codeSeat != null) {
                                String strD = GsonUtil.d(codeSeat);
                                ContentValues contentValues = new ContentValues();
                                contentValues.put("codeSeatId", codeSeat.getCodeSeatId());
                                contentValues.put("json", strD);
                                this.f66584a.insert("cloudList", null, contentValues);
                            }
                        }
                        this.f66584a.setTransactionSuccessful();
                        SQLiteDatabase sQLiteDatabase2 = this.f66584a;
                        if (sQLiteDatabase2 != null) {
                            sQLiteDatabase2.endTransaction();
                        }
                        return true;
                    } catch (Exception e11) {
                        AdLogUtil.Log().e("CloudControlDatabaseManager", "insert cloud data 2 db failed in work thread " + Log.getStackTraceString(e11));
                        SQLiteDatabase sQLiteDatabase3 = this.f66584a;
                        if (sQLiteDatabase3 != null) {
                            sQLiteDatabase3.endTransaction();
                        }
                        return false;
                    }
                }
            } catch (Throwable th2) {
                SQLiteDatabase sQLiteDatabase4 = this.f66584a;
                if (sQLiteDatabase4 != null) {
                    sQLiteDatabase4.endTransaction();
                }
                throw th2;
            }
        }
        return false;
    }

    @Override // hn.j
    public List<CloudControlConfig.CodeSeat> b() {
        ArrayList arrayList = new ArrayList();
        Cursor cursorRawQuery = null;
        try {
            try {
                e();
                cursorRawQuery = this.f66584a.rawQuery("select * from cloudList", null);
                while (cursorRawQuery.moveToNext()) {
                    arrayList.add((CloudControlConfig.CodeSeat) GsonUtil.a(cursorRawQuery.getString(cursorRawQuery.getColumnIndex("json")), CloudControlConfig.CodeSeat.class));
                }
            } catch (Exception e11) {
                AdLogUtil.Log().e("CloudControlDatabaseManager", Log.getStackTraceString(e11));
                if (cursorRawQuery != null) {
                }
                return arrayList;
            }
            cursorRawQuery.close();
            return arrayList;
        } catch (Throwable th2) {
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
            throw th2;
        }
    }

    @Override // hn.j
    public long c() {
        Cursor cursorRawQuery = null;
        try {
            try {
                e();
                cursorRawQuery = this.f66584a.rawQuery("select count(*) from cloudList", null);
                cursorRawQuery.moveToFirst();
                long j11 = cursorRawQuery.getLong(0);
                cursorRawQuery.close();
                return j11;
            } catch (Exception e11) {
                AdLogUtil.Log().e("CloudControlDatabaseManager", Log.getStackTraceString(e11));
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
                return 0L;
            }
        } catch (Throwable th2) {
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
            throw th2;
        }
    }

    public final synchronized SQLiteDatabase e() {
        if (this.f66585b.incrementAndGet() == 1 || this.f66584a == null) {
            try {
                this.f66584a = new d(com.cloud.sdk.commonutil.util.f.a()).getWritableDatabase();
            } catch (Exception e11) {
                AdLogUtil.Log().e("CloudControlDatabaseManager", Log.getStackTraceString(e11));
            }
        }
        return this.f66584a;
    }
}
