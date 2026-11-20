package athena;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteFullException;
import android.text.TextUtils;
import android.util.Log;
import android.util.LongSparseArray;
import android.util.Pair;
import android.util.SparseArray;
import androidx.core.app.NotificationCompat;
import com.cloud.config.utils.CommonUtils;
import com.transsion.api.gateway.utils.SafeStringUtils;
import com.transsion.athena.data.AppIdData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class k {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static k f13709c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public h0 f13710a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Context f13711b;

    /* JADX WARN: $VALUES field not found */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f13712a = new a("EVENTS", 0, "events");

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f13713b = new a("COUNTER", 1, "counter");

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f13714c = new a("TID_CONFIG", 2, "tidconfig");

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final a f13715d = new a("APPID_CONFIG", 3, "appidconfig");

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final String f13716e;

        private a(String str, int i11, String str2) {
            super(str, i11);
            this.f13716e = str2;
        }

        public String a() {
            return this.f13716e;
        }
    }

    public k(Context context) {
        try {
            this.f13711b = context;
            h0 h0Var = new h0(context, "athena.db");
            this.f13710a = h0Var;
            h0Var.setWriteAheadLoggingEnabled(true);
        } catch (Exception e11) {
            a0.c(e11.getMessage());
        }
    }

    public static synchronized k c(Context context) {
        try {
            if (f13709c == null) {
                f13709c = new k(context);
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return f13709c;
    }

    /* JADX WARN: Code duplicated, block: B:33:0x00cc  */
    public int a(a aVar, int i11, l0<String> l0Var) throws com.transsion.ga.e {
        String strA = aVar.a();
        LongSparseArray longSparseArray = new LongSparseArray();
        Cursor cursor = null;
        try {
            try {
                SQLiteDatabase sQLiteDatabaseS = s();
                if (sQLiteDatabaseS == null) {
                    return 0;
                }
                Cursor cursorRawQuery = sQLiteDatabaseS.rawQuery("SELECT _id,tid FROM " + strA + " ORDER BY _id LIMIT " + i11, null);
                long j11 = 0;
                while (cursorRawQuery != null && cursorRawQuery.moveToNext()) {
                    long j12 = cursorRawQuery.getLong(cursorRawQuery.getColumnIndex("tid"));
                    longSparseArray.put(j12, Integer.valueOf(((Integer) longSparseArray.get(j12, 0)).intValue() + 1));
                    j11 = cursorRawQuery.getLong(cursorRawQuery.getColumnIndex("_id"));
                }
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
                int iDelete = sQLiteDatabaseS.delete(strA, "_id<=" + j11 + " AND CAST(tid AS TEXT) NOT LIKE ?", new String[]{"9999%"});
                if (l0Var != null && longSparseArray.size() > 0) {
                    l0Var.a(longSparseArray.toString());
                }
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
                return iDelete;
            } catch (SQLiteException e11) {
                a0.c(Log.getStackTraceString(e11));
                if (0 != 0) {
                    cursor.close();
                }
                g(e11);
                throw new com.transsion.ga.e("cleanupEvents_oom_sql", e11);
            }
        } catch (Throwable th2) {
            if (0 != 0) {
                cursor.close();
            }
            throw th2;
        }
        if (0 != 0) {
            cursor.close();
        }
        throw th2;
    }

    /* JADX WARN: Code duplicated, block: B:101:0x01d6 A[Catch: all -> 0x0108, Exception -> 0x01ca, SQLiteException -> 0x01d0, TryCatch #20 {all -> 0x0108, blocks: (B:49:0x00f2, B:51:0x00f9, B:60:0x0123, B:64:0x0133, B:67:0x013f, B:69:0x0145, B:71:0x014e, B:73:0x0154, B:80:0x0178, B:87:0x019a, B:90:0x01ae, B:91:0x01b3, B:94:0x01c1, B:103:0x01dc, B:122:0x0283, B:101:0x01d6, B:106:0x01fe), top: B:211:0x00f2 }] */
    /* JADX WARN: Code duplicated, block: B:103:0x01dc A[Catch: all -> 0x0108, Exception -> 0x01ca, SQLiteException -> 0x01d0, TryCatch #20 {all -> 0x0108, blocks: (B:49:0x00f2, B:51:0x00f9, B:60:0x0123, B:64:0x0133, B:67:0x013f, B:69:0x0145, B:71:0x014e, B:73:0x0154, B:80:0x0178, B:87:0x019a, B:90:0x01ae, B:91:0x01b3, B:94:0x01c1, B:103:0x01dc, B:122:0x0283, B:101:0x01d6, B:106:0x01fe), top: B:211:0x00f2 }] */
    /* JADX WARN: Code duplicated, block: B:107:0x0221  */
    /* JADX WARN: Code duplicated, block: B:122:0x0283 A[Catch: all -> 0x0108, Exception -> 0x01ca, SQLiteException -> 0x01d0, TRY_LEAVE, TryCatch #20 {all -> 0x0108, blocks: (B:49:0x00f2, B:51:0x00f9, B:60:0x0123, B:64:0x0133, B:67:0x013f, B:69:0x0145, B:71:0x014e, B:73:0x0154, B:80:0x0178, B:87:0x019a, B:90:0x01ae, B:91:0x01b3, B:94:0x01c1, B:103:0x01dc, B:122:0x0283, B:101:0x01d6, B:106:0x01fe), top: B:211:0x00f2 }] */
    /* JADX WARN: Code duplicated, block: B:161:0x0375 A[Catch: all -> 0x037b, Exception -> 0x037e, SQLiteException -> 0x0381, TRY_LEAVE, TryCatch #20 {SQLiteException -> 0x0381, Exception -> 0x037e, all -> 0x037b, blocks: (B:159:0x036f, B:161:0x0375), top: B:229:0x036f }] */
    /* JADX WARN: Code duplicated, block: B:169:0x0384  */
    /* JADX WARN: Code duplicated, block: B:171:0x0387  */
    /* JADX WARN: Code duplicated, block: B:174:0x0394  */
    /* JADX WARN: Code duplicated, block: B:188:0x03c5 A[Catch: all -> 0x03b4, TryCatch #8 {all -> 0x03b4, blocks: (B:180:0x03a5, B:181:0x03b3, B:186:0x03bc, B:188:0x03c5, B:189:0x03c8, B:190:0x03d2), top: B:204:0x001c }] */
    /* JADX WARN: Code duplicated, block: B:192:0x03d5  */
    /* JADX WARN: Code duplicated, block: B:195:0x03e0  */
    /* JADX WARN: Code duplicated, block: B:224:0x019a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:229:0x036f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:236:0x01fe A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:240:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:32:0x00b7 A[Catch: all -> 0x00a3, Exception -> 0x00a9, SQLiteException -> 0x00af, TryCatch #26 {SQLiteException -> 0x00af, Exception -> 0x00a9, all -> 0x00a3, blocks: (B:21:0x0098, B:32:0x00b7, B:34:0x00c0, B:33:0x00ba), top: B:220:0x0098 }] */
    /* JADX WARN: Code duplicated, block: B:33:0x00ba A[Catch: all -> 0x00a3, Exception -> 0x00a9, SQLiteException -> 0x00af, TryCatch #26 {SQLiteException -> 0x00af, Exception -> 0x00a9, all -> 0x00a3, blocks: (B:21:0x0098, B:32:0x00b7, B:34:0x00c0, B:33:0x00ba), top: B:220:0x0098 }] */
    /* JADX WARN: Code duplicated, block: B:90:0x01ae A[Catch: all -> 0x0108, Exception -> 0x01ca, SQLiteException -> 0x01d0, TRY_ENTER, TRY_LEAVE, TryCatch #20 {all -> 0x0108, blocks: (B:49:0x00f2, B:51:0x00f9, B:60:0x0123, B:64:0x0133, B:67:0x013f, B:69:0x0145, B:71:0x014e, B:73:0x0154, B:80:0x0178, B:87:0x019a, B:90:0x01ae, B:91:0x01b3, B:94:0x01c1, B:103:0x01dc, B:122:0x0283, B:101:0x01d6, B:106:0x01fe), top: B:211:0x00f2 }] */
    /* JADX WARN: Code duplicated, block: B:94:0x01c1 A[Catch: all -> 0x0108, Exception -> 0x01ca, SQLiteException -> 0x01d0, TRY_ENTER, TryCatch #20 {all -> 0x0108, blocks: (B:49:0x00f2, B:51:0x00f9, B:60:0x0123, B:64:0x0133, B:67:0x013f, B:69:0x0145, B:71:0x014e, B:73:0x0154, B:80:0x0178, B:87:0x019a, B:90:0x01ae, B:91:0x01b3, B:94:0x01c1, B:103:0x01dc, B:122:0x0283, B:101:0x01d6, B:106:0x01fe), top: B:211:0x00f2 }] */
    /* JADX WARN: Instruction removed from duplicated block: B:103:0x01dc, please report this as an issue */
    public int b(a aVar, cr.a aVar2, int i11) throws Throwable {
        Cursor cursorRawQuery;
        Cursor cursorRawQuery2;
        String str;
        String str2;
        String str3;
        JSONObject jSONObject;
        boolean z11;
        Cursor cursor;
        boolean z12;
        String str4;
        String str5;
        long j11;
        JSONObject jSONObject2;
        String string;
        String strC;
        byte[] bArr;
        byte[] bArr2;
        String str6;
        int i12;
        this = this;
        String str7 = "There is not enough space left";
        String strA = aVar.a();
        long jE = aVar2.e();
        JSONObject jSONObjectC = aVar2.c();
        List<byte[]> listO = ar.b.a().o();
        try {
            try {
                SQLiteDatabase sQLiteDatabaseS = s();
                if (sQLiteDatabaseS == null) {
                    if (!this.f13710a.a()) {
                        a0.c("There is not enough space left");
                    }
                    return -1;
                }
                String str8 = "pi";
                String str9 = " WHERE ";
                String str10 = "=";
                String str11 = "tid";
                String str12 = "_eid";
                if (i11 == 1) {
                    try {
                        StringBuilder sb2 = new StringBuilder();
                        JSONObject jSONObject3 = jSONObjectC;
                        sb2.append("SELECT * FROM ");
                        sb2.append(strA);
                        sb2.append(" WHERE ");
                        sb2.append("tid");
                        sb2.append("=");
                        sb2.append(jE);
                        sb2.append(" AND ");
                        sb2.append("et");
                        sb2.append("=");
                        sb2.append(i11);
                        cursorRawQuery = sQLiteDatabaseS.rawQuery(sb2.toString(), null);
                        byte[] bArr3 = null;
                        String str13 = null;
                        String str14 = null;
                        while (true) {
                            if (cursorRawQuery != null) {
                                try {
                                    if (cursorRawQuery.moveToNext()) {
                                        int i13 = cursorRawQuery.getInt(cursorRawQuery.getColumnIndex(str8));
                                        byte[] bArr4 = bArr3;
                                        String string2 = cursorRawQuery.getString(cursorRawQuery.getColumnIndex(NotificationCompat.CATEGORY_EVENT));
                                        str10 = str10;
                                        if (i13 != -1) {
                                            if (i13 != 0) {
                                                try {
                                                    if (br.d.i(listO)) {
                                                        if (i13 == 0) {
                                                            bArr2 = br.g.f14361n;
                                                        } else {
                                                            bArr2 = listO.get(i13);
                                                        }
                                                        byte[] bArr5 = bArr2;
                                                        strC = p0.c(string2, bArr2, i13);
                                                        bArr = bArr5;
                                                    } else {
                                                        strC = string2;
                                                        bArr = bArr4;
                                                    }
                                                } catch (SQLiteException e11) {
                                                    e = e11;
                                                    cursorRawQuery2 = cursorRawQuery;
                                                } catch (Exception e12) {
                                                    e = e12;
                                                    a0.c(Log.getStackTraceString(e));
                                                    throw new com.transsion.ga.e("addJSON", e);
                                                } catch (Throwable th2) {
                                                    th = th2;
                                                    cursorRawQuery2 = cursorRawQuery;
                                                    str7 = str7;
                                                    if (cursorRawQuery2 != null) {
                                                        cursorRawQuery2.close();
                                                    }
                                                    if (!this.f13710a.a()) {
                                                        a0.c(str7);
                                                    }
                                                    throw th;
                                                }
                                            } else {
                                                if (i13 == 0) {
                                                    bArr2 = br.g.f14361n;
                                                } else {
                                                    bArr2 = listO.get(i13);
                                                }
                                                byte[] bArr6 = bArr2;
                                                strC = p0.c(string2, bArr2, i13);
                                                bArr = bArr6;
                                            }
                                            if (bArr == null || strC == null) {
                                                cursorRawQuery.close();
                                                if (this.f13710a.a()) {
                                                    return -1;
                                                }
                                                a0.c(str7);
                                                return -1;
                                            }
                                            String str15 = strC;
                                            bArr3 = bArr;
                                            string2 = str15;
                                        } else {
                                            bArr3 = bArr4;
                                        }
                                        str7 = str7;
                                        if (str13 == null) {
                                            jSONObject = jSONObject3;
                                            try {
                                                try {
                                                    str3 = str9;
                                                    try {
                                                        str13 = String.format("\"%s\":\"%s\"", NotificationCompat.CATEGORY_EVENT, jSONObject.getString(NotificationCompat.CATEGORY_EVENT));
                                                    } catch (Exception unused) {
                                                        jE = jE;
                                                        str2 = str8;
                                                        str4 = str12;
                                                        str = str11;
                                                        jSONObject3 = jSONObject;
                                                        str11 = str;
                                                        str8 = str2;
                                                        jE = jE;
                                                        str12 = str4;
                                                        str9 = str3;
                                                    }
                                                } catch (Exception unused2) {
                                                    str3 = str9;
                                                }
                                            } catch (Throwable th3) {
                                                th = th3;
                                                this = this;
                                                cursorRawQuery2 = cursorRawQuery;
                                                if (cursorRawQuery2 != null) {
                                                    cursorRawQuery2.close();
                                                }
                                                if (!this.f13710a.a()) {
                                                    a0.c(str7);
                                                }
                                                throw th;
                                            }
                                        } else {
                                            str3 = str9;
                                            jSONObject = jSONObject3;
                                        }
                                        String str16 = str13;
                                        try {
                                            boolean zContains = string2.contains(str16);
                                            str5 = str16;
                                            if (zContains) {
                                                str2 = str8;
                                                try {
                                                    if ("ev_athena".equals(aVar2.b())) {
                                                        if (str14 == null) {
                                                            str4 = str12;
                                                            try {
                                                                String strOptString = jSONObject.getJSONObject("_eparam").optString(str4);
                                                                jE = jE;
                                                                str = str11;
                                                                try {
                                                                    Object[] objArr = new Object[2];
                                                                    objArr[0] = str4;
                                                                    try {
                                                                        objArr[1] = strOptString;
                                                                        str14 = String.format("\"%s\":\"%s\"", objArr);
                                                                    } catch (Exception unused3) {
                                                                        str13 = str5;
                                                                        jSONObject3 = jSONObject;
                                                                        str11 = str;
                                                                        str8 = str2;
                                                                        jE = jE;
                                                                        str12 = str4;
                                                                        str9 = str3;
                                                                    }
                                                                } catch (Exception unused4) {
                                                                    str13 = str5;
                                                                    jSONObject3 = jSONObject;
                                                                    str11 = str;
                                                                    str8 = str2;
                                                                    jE = jE;
                                                                    str12 = str4;
                                                                    str9 = str3;
                                                                }
                                                            } catch (Exception unused5) {
                                                                jE = jE;
                                                                str = str11;
                                                            }
                                                        } else {
                                                            jE = jE;
                                                            str4 = str12;
                                                            str = str11;
                                                        }
                                                        String str17 = str14;
                                                        try {
                                                            str14 = str17;
                                                            zContains = string2.contains(str17);
                                                        } catch (Exception unused6) {
                                                            str14 = str17;
                                                            str13 = str5;
                                                            jSONObject3 = jSONObject;
                                                            str11 = str;
                                                            str8 = str2;
                                                            jE = jE;
                                                            str12 = str4;
                                                        }
                                                    }
                                                    if (zContains) {
                                                        try {
                                                            j11 = cursorRawQuery.getLong(cursorRawQuery.getColumnIndex("_id"));
                                                            if (string2.length() < 131072) {
                                                                jSONObject2 = new JSONObject(string2);
                                                                try {
                                                                    br.d.h(jSONObject.getJSONObject("_eparam"), jSONObject2.getJSONObject("_eparam"));
                                                                    if (i13 != -1) {
                                                                        string = p0.b(jSONObject2.toString(), bArr3);
                                                                    } else {
                                                                        string = jSONObject2.toString();
                                                                    }
                                                                    if (string != null) {
                                                                        ContentValues contentValues = new ContentValues();
                                                                        contentValues.put(NotificationCompat.CATEGORY_EVENT, string);
                                                                        sQLiteDatabaseS.update(strA, contentValues, "_id=" + j11, null);
                                                                    }
                                                                    z11 = false;
                                                                } catch (JSONException unused7) {
                                                                    str11 = str;
                                                                    str13 = str5;
                                                                    str8 = str2;
                                                                    jE = jE;
                                                                    jSONObject3 = jSONObject;
                                                                    str12 = str4;
                                                                    str9 = str3;
                                                                }
                                                            } else {
                                                                ContentValues contentValues2 = new ContentValues();
                                                                contentValues2.put("et", (Integer) 2);
                                                                sQLiteDatabaseS.update(strA, contentValues2, "_id=" + j11, null);
                                                                z11 = true;
                                                            }
                                                            if (cursorRawQuery != null) {
                                                                cursorRawQuery.close();
                                                            }
                                                            cursor = cursorRawQuery;
                                                            z12 = z11;
                                                        } catch (SQLiteException e13) {
                                                            e = e13;
                                                            this = this;
                                                            cursorRawQuery2 = cursorRawQuery;
                                                        } catch (Exception e14) {
                                                            e = e14;
                                                            a0.c(Log.getStackTraceString(e));
                                                            throw new com.transsion.ga.e("addJSON", e);
                                                        }
                                                    }
                                                    str11 = str;
                                                    str13 = str5;
                                                    str8 = str2;
                                                    jE = jE;
                                                    jSONObject3 = jSONObject;
                                                    str12 = str4;
                                                } catch (Exception unused8) {
                                                    jE = jE;
                                                    str4 = str12;
                                                    str = str11;
                                                }
                                                str9 = str3;
                                            } else {
                                                str2 = str8;
                                            }
                                            str4 = str12;
                                            str = str11;
                                            if (zContains) {
                                                j11 = cursorRawQuery.getLong(cursorRawQuery.getColumnIndex("_id"));
                                                if (string2.length() < 131072) {
                                                    jSONObject2 = new JSONObject(string2);
                                                    br.d.h(jSONObject.getJSONObject("_eparam"), jSONObject2.getJSONObject("_eparam"));
                                                    if (i13 != -1) {
                                                        string = p0.b(jSONObject2.toString(), bArr3);
                                                    } else {
                                                        string = jSONObject2.toString();
                                                    }
                                                    if (string != null) {
                                                        ContentValues contentValues3 = new ContentValues();
                                                        contentValues3.put(NotificationCompat.CATEGORY_EVENT, string);
                                                        sQLiteDatabaseS.update(strA, contentValues3, "_id=" + j11, null);
                                                    }
                                                    z11 = false;
                                                } else {
                                                    ContentValues contentValues4 = new ContentValues();
                                                    contentValues4.put("et", (Integer) 2);
                                                    sQLiteDatabaseS.update(strA, contentValues4, "_id=" + j11, null);
                                                    z11 = true;
                                                }
                                                if (cursorRawQuery != null) {
                                                    cursorRawQuery.close();
                                                }
                                                cursor = cursorRawQuery;
                                                z12 = z11;
                                            }
                                            str11 = str;
                                            str13 = str5;
                                            str8 = str2;
                                            jE = jE;
                                            jSONObject3 = jSONObject;
                                            str12 = str4;
                                        } catch (Exception unused9) {
                                            str5 = str16;
                                            jE = jE;
                                            str2 = str8;
                                            str4 = str12;
                                            str = str11;
                                        }
                                        str9 = str3;
                                    }
                                } catch (SQLiteException e15) {
                                    e = e15;
                                    this = this;
                                    cursorRawQuery2 = cursorRawQuery;
                                } catch (Exception e16) {
                                    e = e16;
                                    a0.c(Log.getStackTraceString(e));
                                    throw new com.transsion.ga.e("addJSON", e);
                                } catch (Throwable th4) {
                                    th = th4;
                                    str7 = str7;
                                    this = this;
                                    cursorRawQuery2 = cursorRawQuery;
                                    if (cursorRawQuery2 != null) {
                                        cursorRawQuery2.close();
                                    }
                                    if (!this.f13710a.a()) {
                                        a0.c(str7);
                                    }
                                    throw th;
                                }
                                a0.c(Log.getStackTraceString(e));
                                if (cursorRawQuery2 != null) {
                                    cursorRawQuery2.close();
                                }
                                this.g(e);
                                throw new com.transsion.ga.e("addJSON_sql", e);
                            }
                            str7 = str7;
                            jE = jE;
                            str = str11;
                            str2 = str8;
                            str3 = str9;
                            str10 = str10;
                            jSONObject = jSONObject3;
                            z11 = true;
                            if (cursorRawQuery != null) {
                                cursorRawQuery.close();
                            }
                            cursor = cursorRawQuery;
                            z12 = z11;
                        }
                    } catch (SQLiteException e17) {
                        e = e17;
                        cursorRawQuery2 = null;
                        this = this;
                        a0.c(Log.getStackTraceString(e));
                        if (cursorRawQuery2 != null) {
                            cursorRawQuery2.close();
                        }
                        this.g(e);
                        throw new com.transsion.ga.e("addJSON_sql", e);
                    } catch (Exception e18) {
                        e = e18;
                        a0.c(Log.getStackTraceString(e));
                        throw new com.transsion.ga.e("addJSON", e);
                    } catch (Throwable th5) {
                        th = th5;
                        str7 = "There is not enough space left";
                        cursorRawQuery2 = null;
                        this = this;
                        if (cursorRawQuery2 != null) {
                            cursorRawQuery2.close();
                        }
                        if (!this.f13710a.a()) {
                            a0.c(str7);
                        }
                        throw th;
                    }
                } else {
                    str7 = "There is not enough space left";
                    jE = jE;
                    jSONObject = jSONObjectC;
                    str = "tid";
                    str2 = "pi";
                    str3 = " WHERE ";
                    str10 = "=";
                    z12 = true;
                    cursor = null;
                }
                if (z12) {
                    try {
                        Pair<Integer, byte[]> pairT = ar.b.a().t();
                        int iIntValue = ((Integer) pairT.first).intValue();
                        String strB = p0.b(jSONObject.toString(), (byte[]) pairT.second);
                        if (strB != null) {
                            ContentValues contentValues5 = new ContentValues();
                            str6 = str;
                            contentValues5.put(str6, Long.valueOf(jE));
                            contentValues5.put(NotificationCompat.CATEGORY_EVENT, strB);
                            contentValues5.put("et", Integer.valueOf(i11));
                            contentValues5.put(str2, Integer.valueOf(iIntValue));
                            contentValues5.put("created_at", Long.valueOf(aVar2.i()));
                            if (j0.l(jE)) {
                                contentValues5.put("ext", aVar2.b());
                            }
                            if (aVar2.a() != null) {
                                contentValues5.put("er_ts", Long.valueOf(aVar2.g()));
                                contentValues5.put("boot_id", aVar2.a());
                            }
                            sQLiteDatabaseS.insert(strA, null, contentValues5);
                        }
                        cursorRawQuery2 = sQLiteDatabaseS.rawQuery("SELECT COUNT(*) FROM " + strA + str3 + str6 + str10 + jE, null);
                        if (cursorRawQuery2 == null) {
                            try {
                                if (cursorRawQuery2.moveToNext()) {
                                    i12 = cursorRawQuery2.getInt(0);
                                } else {
                                    i12 = -1;
                                }
                            } catch (SQLiteException e19) {
                                e = e19;
                                this = this;
                                a0.c(Log.getStackTraceString(e));
                                if (cursorRawQuery2 != null) {
                                    cursorRawQuery2.close();
                                }
                                this.g(e);
                                throw new com.transsion.ga.e("addJSON_sql", e);
                            } catch (Exception e21) {
                                e = e21;
                                a0.c(Log.getStackTraceString(e));
                                throw new com.transsion.ga.e("addJSON", e);
                            } catch (Throwable th6) {
                                th = th6;
                                this = this;
                                if (cursorRawQuery2 != null) {
                                    cursorRawQuery2.close();
                                }
                                if (!this.f13710a.a()) {
                                    a0.c(str7);
                                }
                                throw th;
                            }
                        } else {
                            i12 = -1;
                        }
                        if (cursorRawQuery2 != null) {
                            cursorRawQuery2.close();
                        }
                        if (!this.f13710a.a()) {
                            return i12;
                        }
                        a0.c(str7);
                        return -2;
                    } catch (SQLiteException e22) {
                        e = e22;
                        this = this;
                        cursorRawQuery2 = cursor;
                    } catch (Exception e23) {
                        e = e23;
                        a0.c(Log.getStackTraceString(e));
                        throw new com.transsion.ga.e("addJSON", e);
                    } catch (Throwable th7) {
                        th = th7;
                        this = this;
                        cursorRawQuery2 = cursor;
                        if (cursorRawQuery2 != null) {
                            cursorRawQuery2.close();
                        }
                        if (!this.f13710a.a()) {
                            a0.c(str7);
                        }
                        throw th;
                    }
                }
                str6 = str;
                cursorRawQuery2 = sQLiteDatabaseS.rawQuery("SELECT COUNT(*) FROM " + strA + str3 + str6 + str10 + jE, null);
                if (cursorRawQuery2 == null) {
                    i12 = -1;
                } else if (cursorRawQuery2.moveToNext()) {
                    i12 = cursorRawQuery2.getInt(0);
                } else {
                    i12 = -1;
                }
                if (cursorRawQuery2 != null) {
                    cursorRawQuery2.close();
                }
                if (!this.f13710a.a()) {
                    return i12;
                }
                a0.c(str7);
                return -2;
            } catch (Throwable th8) {
                th = th8;
            }
        } catch (SQLiteException e24) {
            e = e24;
            cursorRawQuery = null;
        } catch (Exception e25) {
            e = e25;
            cursorRawQuery = null;
        } catch (Throwable th9) {
            th = th9;
            str7 = "There is not enough space left";
            cursorRawQuery = null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:145:0x02c7  */
    public cr.d d(a aVar, long j11, long j12, String str, int i11, int i12) throws Throwable {
        String str2;
        long j13;
        int i13;
        int i14;
        String str3;
        int iIntValue;
        String str4 = "net";
        String str5 = NotificationCompat.CATEGORY_EVENT;
        List<byte[]> listO = ar.b.a().o();
        Cursor cursor = null;
        if (br.d.m(listO)) {
            return null;
        }
        String strA = aVar.a();
        try {
            try {
                SQLiteDatabase sQLiteDatabaseS = s();
                if (sQLiteDatabaseS == null) {
                    return null;
                }
                String str6 = "_eparam";
                if (TextUtils.isEmpty(str)) {
                    try {
                        str2 = "SELECT * FROM " + strA + " WHERE tid=" + j11 + " AND created_at<=" + j12 + " ORDER BY _id LIMIT " + i12;
                    } catch (SQLiteException e11) {
                        e = e11;
                        cursor = null;
                    } catch (Exception e12) {
                        e = e12;
                        a0.c(Log.getStackTraceString(e));
                        throw new com.transsion.ga.e("queryEventList", e);
                    } catch (Throwable th2) {
                        th = th2;
                        cursor = null;
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw th;
                    }
                } else {
                    try {
                        str2 = "SELECT * FROM " + strA + " WHERE tid=" + j11 + " AND " + CommonUtils.PARAM_UID + "='" + str + "' ORDER BY _id";
                    } catch (SQLiteException e13) {
                        e = e13;
                        cursor = null;
                    } catch (Exception e14) {
                        e = e14;
                        a0.c(Log.getStackTraceString(e));
                        throw new com.transsion.ga.e("queryEventList", e);
                    } catch (Throwable th3) {
                        th = th3;
                        cursor = null;
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw th;
                    }
                }
                cursor = null;
                Cursor cursorRawQuery = sQLiteDatabaseS.rawQuery(str2, null);
                if (cursorRawQuery != null) {
                    try {
                        try {
                            if (cursorRawQuery.getCount() != 0) {
                                int count = cursorRawQuery.getCount();
                                ArrayList arrayList = new ArrayList();
                                String str7 = "";
                                long j14 = 0;
                                int i15 = 0;
                                int i16 = 0;
                                int i17 = 0;
                                long j15 = 0;
                                while (true) {
                                    if (!cursorRawQuery.moveToNext()) {
                                        j13 = j14;
                                        i13 = i16;
                                        i14 = i17;
                                        str3 = str7;
                                        break;
                                    }
                                    String string = cursorRawQuery.getString(cursorRawQuery.getColumnIndex(str5));
                                    long j16 = cursorRawQuery.getLong(cursorRawQuery.getColumnIndex("created_at"));
                                    int i18 = cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("pi"));
                                    int i19 = cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("et"));
                                    if (i18 != -1) {
                                        string = p0.c(string, listO.get(i18), i18);
                                    }
                                    if (j14 == 0) {
                                        j14 = cursorRawQuery.getLong(cursorRawQuery.getColumnIndex("_id"));
                                    }
                                    if (string != null) {
                                        if (i19 != 0) {
                                            string = string.replace("&add", "").replace("&append", "");
                                        }
                                        try {
                                            JSONObject jSONObject = new JSONObject(string);
                                            String str8 = (String) jSONObject.remove(str5);
                                            try {
                                                if (jSONObject.has(str4)) {
                                                    try {
                                                        iIntValue = ((Integer) jSONObject.remove(str4)).intValue();
                                                    } catch (Exception e15) {
                                                        e = e15;
                                                        str7 = str8;
                                                        str6 = str6;
                                                        str4 = str4;
                                                        e.printStackTrace();
                                                        i15++;
                                                    }
                                                } else {
                                                    iIntValue = 0;
                                                }
                                                try {
                                                    Object objRemove = jSONObject.has(str6) ? jSONObject.remove(str6) : new JSONObject();
                                                    if (objRemove instanceof JSONObject) {
                                                        try {
                                                            if (jSONObject.length() > 0) {
                                                                Iterator<String> itKeys = jSONObject.keys();
                                                                while (itKeys.hasNext()) {
                                                                    itKeys = itKeys;
                                                                    String next = itKeys.next();
                                                                    str4 = str4;
                                                                    try {
                                                                        if (next.startsWith("_")) {
                                                                            str5 = str5;
                                                                            try {
                                                                                ((JSONObject) objRemove).put(next, jSONObject.get(next));
                                                                                str5 = str5;
                                                                            } catch (Exception e16) {
                                                                                e = e16;
                                                                                str7 = str8;
                                                                                e.printStackTrace();
                                                                                i15++;
                                                                                j15 = cursorRawQuery.getLong(cursorRawQuery.getColumnIndex("_id"));
                                                                                str4 = str4;
                                                                                str5 = str5;
                                                                                str6 = str6;
                                                                            }
                                                                        }
                                                                    } catch (Exception e17) {
                                                                        e = e17;
                                                                        str5 = str5;
                                                                        str7 = str8;
                                                                        e.printStackTrace();
                                                                        i15++;
                                                                        j15 = cursorRawQuery.getLong(cursorRawQuery.getColumnIndex("_id"));
                                                                        str4 = str4;
                                                                        str5 = str5;
                                                                        str6 = str6;
                                                                    }
                                                                }
                                                            }
                                                        } catch (Exception e18) {
                                                            e = e18;
                                                            str4 = str4;
                                                        }
                                                    }
                                                    str4 = str4;
                                                    str5 = str5;
                                                    arrayList.add(new cr.d.a(str8, j16, iIntValue, objRemove.toString()));
                                                    i16++;
                                                    int length = i17 + string.length();
                                                    if (length >= i11) {
                                                        try {
                                                            i14 = length;
                                                            j15 = cursorRawQuery.getLong(cursorRawQuery.getColumnIndex("_id"));
                                                            str3 = str8;
                                                            j13 = j14;
                                                            i13 = i16;
                                                            break;
                                                        } catch (Exception e19) {
                                                            e = e19;
                                                            i17 = length;
                                                            str7 = str8;
                                                            e.printStackTrace();
                                                            i15++;
                                                            j15 = cursorRawQuery.getLong(cursorRawQuery.getColumnIndex("_id"));
                                                            str4 = str4;
                                                            str5 = str5;
                                                            str6 = str6;
                                                        }
                                                    } else {
                                                        i17 = length;
                                                        str7 = str8;
                                                        j15 = cursorRawQuery.getLong(cursorRawQuery.getColumnIndex("_id"));
                                                        str4 = str4;
                                                        str5 = str5;
                                                        str6 = str6;
                                                    }
                                                } catch (Exception e21) {
                                                    e = e21;
                                                    str4 = str4;
                                                    str5 = str5;
                                                }
                                            } catch (Exception e22) {
                                                e = e22;
                                                str5 = str5;
                                                str6 = str6;
                                                str4 = str4;
                                            }
                                        } catch (Exception e23) {
                                            e = e23;
                                        }
                                    } else {
                                        str5 = str5;
                                        str6 = str6;
                                        str4 = str4;
                                    }
                                    i15++;
                                    j15 = cursorRawQuery.getLong(cursorRawQuery.getColumnIndex("_id"));
                                    str4 = str4;
                                    str5 = str5;
                                    str6 = str6;
                                }
                                cursorRawQuery.close();
                                if (i13 <= 0) {
                                    cursorRawQuery.close();
                                    return null;
                                }
                                int i21 = i13 + i15;
                                cr.d dVar = new cr.d(j11, str3, arrayList, j13, j15, i13, i14, count <= i21 && !(count == i12 && count == i21));
                                cursorRawQuery.close();
                                return dVar;
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            cursor = cursorRawQuery;
                            if (cursor != null) {
                                cursor.close();
                            }
                            throw th;
                        }
                    } catch (SQLiteException e24) {
                        e = e24;
                        cursor = cursorRawQuery;
                    } catch (Exception e25) {
                        e = e25;
                        a0.c(Log.getStackTraceString(e));
                        throw new com.transsion.ga.e("queryEventList", e);
                    }
                }
                if (cursorRawQuery == null) {
                    return null;
                }
                cursorRawQuery.close();
                return null;
            } catch (Throwable th5) {
                th = th5;
            }
        } catch (SQLiteException e26) {
            e = e26;
        } catch (Exception e27) {
            e = e27;
        } catch (Throwable th6) {
            th = th6;
        }
        a0.c(Log.getStackTraceString(e));
        if (cursor != null) {
            cursor.close();
        }
        try {
            g(e);
            throw new com.transsion.ga.e("queryEventList_sql", e);
        } catch (Throwable th7) {
            th = th7;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    /* JADX WARN: Code duplicated, block: B:25:0x008a  */
    public List<AppIdData> e(a aVar) throws com.transsion.ga.e {
        String strA = aVar.a();
        ArrayList arrayList = new ArrayList();
        Cursor cursorRawQuery = null;
        try {
            try {
                SQLiteDatabase sQLiteDatabaseS = s();
                if (sQLiteDatabaseS == null) {
                    return arrayList;
                }
                cursorRawQuery = sQLiteDatabaseS.rawQuery("SELECT * FROM " + strA, null);
                while (cursorRawQuery != null && cursorRawQuery.moveToNext()) {
                    AppIdData appIdData = new AppIdData();
                    appIdData.f50747a = cursorRawQuery.getInt(cursorRawQuery.getColumnIndex(SafeStringUtils.SP_APPID));
                    appIdData.f50748b = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("base"));
                    appIdData.f50749c = cursorRawQuery.getString(cursorRawQuery.getColumnIndex(CommonUtils.PARAM_UID));
                    appIdData.f50750d = cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("try"));
                    arrayList.add(appIdData);
                }
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
                return arrayList;
            } catch (SQLiteException e11) {
                a0.c(Log.getStackTraceString(e11));
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
                g(e11);
                throw new com.transsion.ga.e("getAppIdList_sql", e11);
            }
        } catch (Throwable th2) {
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
            throw th2;
        }
        if (cursorRawQuery != null) {
            cursorRawQuery.close();
        }
        throw th2;
    }

    public void f() {
        a0.a("deleteDB");
        try {
            this.f13710a.b();
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public final void g(SQLiteException sQLiteException) {
        try {
            if (sQLiteException instanceof SQLiteFullException) {
                this.f13710a.close();
            } else {
                this.f13710a.close();
                this.f13710a.b();
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    /* JADX WARN: Code duplicated, block: B:68:0x01a0  */
    /* JADX WARN: Code duplicated, block: B:70:0x01a5  */
    public void h(a aVar, br.b bVar, boolean z11) throws Throwable {
        SQLiteDatabase sQLiteDatabaseS;
        Cursor cursor;
        Cursor cursorRawQuery;
        String strA = aVar.a();
        Cursor cursor2 = null;
        cursor2 = null;
        SQLiteDatabase sQLiteDatabase = null;
        try {
            sQLiteDatabaseS = s();
            if (sQLiteDatabaseS == null) {
                if (sQLiteDatabaseS != null) {
                    sQLiteDatabaseS.endTransaction();
                    return;
                }
                return;
            }
            try {
                sQLiteDatabaseS.beginTransaction();
                ContentValues contentValues = new ContentValues();
                contentValues.put("cfg", bVar.z());
                sQLiteDatabaseS.update(strA, contentValues, "appid=" + bVar.a(), null);
                if (z11) {
                    sQLiteDatabaseS.delete(a.f13714c.a(), "CAST(tid AS TEXT) LIKE ?", new String[]{bVar.a() + "%"});
                    List<br.a> listW = bVar.w();
                    HashMap map = new HashMap();
                    for (br.a aVar2 : listW) {
                        br.h hVarE = aVar2.e();
                        contentValues.clear();
                        contentValues.put("tid", Long.valueOf(aVar2.d()));
                        contentValues.put("ev", aVar2.c());
                        contentValues.put("pt", Long.valueOf(hVarE.v()));
                        contentValues.put("cf", hVarE.y());
                        sQLiteDatabaseS.insert(a.f13714c.a(), null, contentValues);
                        if (aVar2.c() != null) {
                            map.put(aVar2.c(), Long.valueOf(aVar2.d()));
                        }
                    }
                    cursorRawQuery = sQLiteDatabaseS.rawQuery("SELECT DISTINCT ext FROM " + a.f13712a.a() + " WHERE tid=" + bVar.a(), null);
                    while (cursorRawQuery != null) {
                        try {
                            if (!cursorRawQuery.moveToNext()) {
                                break;
                            }
                            String string = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("ext"));
                            if (map.containsKey(string)) {
                                contentValues.clear();
                                contentValues.put("tid", (Long) map.get(string));
                                sQLiteDatabaseS.update(a.f13712a.a(), contentValues, "tid=" + bVar.a() + " AND ext=?", new String[]{string});
                            }
                        } catch (SQLiteException e11) {
                            cursor = cursorRawQuery;
                            e = e11;
                            try {
                                a0.c(Log.getStackTraceString(e));
                                if (cursor != null) {
                                    cursor.close();
                                }
                                if (sQLiteDatabaseS != null) {
                                    sQLiteDatabaseS.endTransaction();
                                } else {
                                    sQLiteDatabase = sQLiteDatabaseS;
                                }
                                try {
                                    g(e);
                                    throw new com.transsion.ga.e("updateAppConfig_sql", e);
                                } catch (Throwable th2) {
                                    th = th2;
                                    sQLiteDatabaseS = sQLiteDatabase;
                                    cursor2 = cursor;
                                    if (cursor2 != null) {
                                        cursor2.close();
                                    }
                                    if (sQLiteDatabaseS != null) {
                                        sQLiteDatabaseS.endTransaction();
                                    }
                                    throw th;
                                }
                            } catch (Throwable th3) {
                                th = th3;
                            }
                        } catch (Throwable th4) {
                            cursor2 = cursorRawQuery;
                            th = th4;
                            if (cursor2 != null) {
                                cursor2.close();
                            }
                            if (sQLiteDatabaseS != null) {
                                sQLiteDatabaseS.endTransaction();
                            }
                            throw th;
                        }
                    }
                    if (cursorRawQuery != null) {
                        cursorRawQuery.close();
                    }
                } else {
                    cursorRawQuery = null;
                }
                sQLiteDatabaseS.setTransactionSuccessful();
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
                sQLiteDatabaseS.endTransaction();
            } catch (SQLiteException e12) {
                e = e12;
                cursor = null;
            } catch (Throwable th5) {
                th = th5;
            }
        } catch (SQLiteException e13) {
            e = e13;
            cursor = null;
            sQLiteDatabaseS = null;
        } catch (Throwable th6) {
            th = th6;
            sQLiteDatabaseS = null;
        }
    }

    public void i(a aVar, AppIdData appIdData) throws com.transsion.ga.e {
        String strA = aVar.a();
        try {
            SQLiteDatabase sQLiteDatabaseS = s();
            if (sQLiteDatabaseS == null) {
                return;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put(SafeStringUtils.SP_APPID, Integer.valueOf(appIdData.f50747a));
            contentValues.put("base", appIdData.f50748b);
            if (sQLiteDatabaseS.update(strA, contentValues, "appid=" + appIdData.f50747a, null) != 1) {
                sQLiteDatabaseS.insert(strA, null, contentValues);
            }
        } catch (SQLiteException e11) {
            a0.c(Log.getStackTraceString(e11));
            g(e11);
            throw new com.transsion.ga.e("addAppId_sql", e11);
        }
    }

    public void j(a aVar, String str, long j11) throws com.transsion.ga.e {
        String strA = aVar.a();
        try {
            SQLiteDatabase sQLiteDatabaseS = s();
            if (sQLiteDatabaseS == null) {
                return;
            }
            sQLiteDatabaseS.execSQL("UPDATE " + strA + " SET created_at = er_ts + " + j11 + ", boot_id = '' WHERE boot_id = '" + str + "'");
        } catch (SQLiteException e11) {
            a0.c(Log.getStackTraceString(e11));
            g(e11);
            throw new com.transsion.ga.e("updateEvents_sql", e11);
        }
    }

    /* JADX WARN: Not initialized variable reg: 2, insn: 0x0069: MOVE (r1 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:16:0x0069 */
    public void k(a aVar, List<AppIdData> list) throws Throwable {
        SQLiteDatabase sQLiteDatabaseS;
        SQLiteDatabase sQLiteDatabase;
        String strA = aVar.a();
        StringBuilder sb2 = new StringBuilder();
        SQLiteDatabase sQLiteDatabase2 = null;
        try {
            try {
                try {
                    sQLiteDatabaseS = s();
                    if (sQLiteDatabaseS == null) {
                        if (sQLiteDatabaseS != null) {
                            sQLiteDatabaseS.endTransaction();
                            return;
                        }
                        return;
                    }
                    try {
                        sQLiteDatabaseS.beginTransaction();
                        ContentValues contentValues = new ContentValues();
                        contentValues.put(CommonUtils.PARAM_UID, "");
                        for (AppIdData appIdData : list) {
                            sQLiteDatabaseS.update(a.f13712a.a(), contentValues, "CAST(tid AS TEXT) LIKE ? AND uid=?", new String[]{appIdData.f50747a + "%", appIdData.f50749c});
                            br.d.g(sb2, Integer.valueOf(appIdData.f50747a));
                        }
                        contentValues.put("try", (Integer) 0);
                        sQLiteDatabaseS.update(strA, contentValues, "appid IN (" + sb2.toString() + ")", null);
                        sQLiteDatabaseS.setTransactionSuccessful();
                        sQLiteDatabaseS.endTransaction();
                    } catch (SQLiteException e11) {
                        e = e11;
                        a0.c(Log.getStackTraceString(e));
                        if (sQLiteDatabaseS != null) {
                            sQLiteDatabaseS.endTransaction();
                        }
                        g(e);
                        throw new com.transsion.ga.e("updateAppIdList_sql", e);
                    }
                } catch (Throwable th2) {
                    th = th2;
                    sQLiteDatabase2 = sQLiteDatabase;
                    if (sQLiteDatabase2 != null) {
                        sQLiteDatabase2.endTransaction();
                    }
                    throw th;
                }
            } catch (SQLiteException e12) {
                e = e12;
                sQLiteDatabaseS = null;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public void l(a aVar, List<AppIdData> list, int i11) throws com.transsion.ga.e {
        String strA = aVar.a();
        StringBuilder sb2 = new StringBuilder();
        try {
            for (AppIdData appIdData : list) {
                br.d.g(sb2, Integer.valueOf(appIdData.f50747a));
                appIdData.f50750d = i11;
            }
            SQLiteDatabase sQLiteDatabaseS = s();
            if (sQLiteDatabaseS == null) {
                return;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("try", Integer.valueOf(i11));
            sQLiteDatabaseS.update(strA, contentValues, "appid IN (" + sb2.toString() + ")", null);
        } catch (SQLiteException e11) {
            a0.c(Log.getStackTraceString(e11));
            g(e11);
            throw new com.transsion.ga.e("updateEvents_sql", e11);
        }
    }

    /* JADX WARN: Code duplicated, block: B:115:0x0276 A[Catch: all -> 0x00c6, TryCatch #2 {all -> 0x00c6, blocks: (B:20:0x0088, B:22:0x008e, B:29:0x00a3, B:31:0x00c1, B:42:0x00d7, B:38:0x00ce, B:44:0x00e2, B:113:0x026d, B:115:0x0276, B:117:0x027b), top: B:131:0x001b }] */
    /* JADX WARN: Code duplicated, block: B:117:0x027b A[Catch: all -> 0x00c6, TRY_LEAVE, TryCatch #2 {all -> 0x00c6, blocks: (B:20:0x0088, B:22:0x008e, B:29:0x00a3, B:31:0x00c1, B:42:0x00d7, B:38:0x00ce, B:44:0x00e2, B:113:0x026d, B:115:0x0276, B:117:0x027b), top: B:131:0x001b }] */
    /* JADX WARN: Code duplicated, block: B:119:0x0282  */
    /* JADX WARN: Code duplicated, block: B:125:0x0296  */
    /* JADX WARN: Code duplicated, block: B:127:0x029b  */
    public void m(a aVar, List<AppIdData> list, long j11, String str, l0<SparseArray<cr.e>> l0Var) throws Throwable {
        Cursor cursor;
        SQLiteDatabase sQLiteDatabaseS;
        Cursor cursorRawQuery;
        SQLiteDatabase sQLiteDatabase;
        String str2;
        Cursor cursor2;
        String str3;
        int i11;
        String str4 = "_id";
        String str5 = " AND ";
        String strA = aVar.a();
        StringBuilder sb2 = new StringBuilder();
        SparseArray<cr.e> sparseArray = new SparseArray<>();
        Cursor cursor3 = null;
        try {
            try {
                Iterator<AppIdData> it = list.iterator();
                while (it.hasNext()) {
                    try {
                        br.d.g(sb2, Integer.valueOf(it.next().f50747a));
                    } catch (SQLiteException e11) {
                        e = e11;
                        sQLiteDatabaseS = null;
                        cursorRawQuery = null;
                        cursor = null;
                        a0.c(Log.getStackTraceString(e));
                        if (cursorRawQuery != null) {
                            cursorRawQuery.close();
                        }
                        if (sQLiteDatabaseS != null) {
                            sQLiteDatabaseS.endTransaction();
                            sQLiteDatabase = cursor;
                        } else {
                            sQLiteDatabase = sQLiteDatabaseS;
                        }
                        try {
                            g(e);
                            throw new com.transsion.ga.e("cleanupEvents_sql", e);
                        } catch (Throwable th2) {
                            th = th2;
                            sQLiteDatabaseS = sQLiteDatabase;
                            cursor3 = cursorRawQuery;
                            if (cursor3 != null) {
                                cursor3.close();
                            }
                            if (sQLiteDatabaseS != null) {
                                sQLiteDatabaseS.endTransaction();
                            }
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        sQLiteDatabaseS = null;
                        if (cursor3 != null) {
                            cursor3.close();
                        }
                        if (sQLiteDatabaseS != null) {
                            sQLiteDatabaseS.endTransaction();
                        }
                        throw th;
                    }
                }
                sQLiteDatabaseS = s();
                if (sQLiteDatabaseS == null) {
                    if (sQLiteDatabaseS != null) {
                        sQLiteDatabaseS.endTransaction();
                        return;
                    }
                    return;
                }
                try {
                    sQLiteDatabaseS.beginTransaction();
                    cursorRawQuery = sQLiteDatabaseS.rawQuery("SELECT * FROM " + a.f13715d.a() + " WHERE " + SafeStringUtils.SP_APPID + " IN (" + ((Object) sb2) + ")", null);
                    while (true) {
                        str2 = "ext";
                        if (cursorRawQuery == null) {
                            break;
                        }
                        try {
                            if (!cursorRawQuery.moveToNext()) {
                                break;
                            }
                            int i12 = cursorRawQuery.getInt(cursorRawQuery.getColumnIndex(SafeStringUtils.SP_APPID));
                            if (i12 != 9999 && i12 != 1031 && i12 != 1041) {
                                int i13 = cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("cnt"));
                                String string = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("date"));
                                String string2 = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("ext"));
                                if (TextUtils.isEmpty(string2)) {
                                    i11 = 0;
                                } else {
                                    try {
                                        i11 = Integer.parseInt(string2);
                                    } catch (Exception e12) {
                                        e12.printStackTrace();
                                        i11 = 0;
                                    }
                                }
                                sparseArray.put(i12, new cr.e(i12, string, i13, i11));
                            }
                        } catch (SQLiteException e13) {
                            e = e13;
                            cursor = null;
                            a0.c(Log.getStackTraceString(e));
                            if (cursorRawQuery != null) {
                                cursorRawQuery.close();
                            }
                            if (sQLiteDatabaseS != null) {
                                sQLiteDatabaseS.endTransaction();
                                sQLiteDatabase = cursor;
                            } else {
                                sQLiteDatabase = sQLiteDatabaseS;
                            }
                            g(e);
                            throw new com.transsion.ga.e("cleanupEvents_sql", e);
                        }
                    }
                    if (cursorRawQuery != null) {
                        cursorRawQuery.close();
                    }
                    try {
                        try {
                            Iterator<AppIdData> it2 = list.iterator();
                            while (it2.hasNext()) {
                                AppIdData next = it2.next();
                                int i14 = 0;
                                for (cr.d dVar : next.f50751e) {
                                    try {
                                        Iterator<AppIdData> it3 = it2;
                                        StringBuilder sb3 = new StringBuilder();
                                        sb3.append("tid=");
                                        cursor2 = cursorRawQuery;
                                        String str6 = str2;
                                        try {
                                            try {
                                                sb3.append(dVar.f62792a);
                                                sb3.append(str5);
                                                sb3.append(str4);
                                                sb3.append(">=");
                                                sb3.append(dVar.f62795d);
                                                sb3.append(str5);
                                                sb3.append(str4);
                                                sb3.append("<=");
                                                sb3.append(dVar.f62796e);
                                                sQLiteDatabaseS.delete(strA, sb3.toString(), null);
                                                if (dVar.f62799h) {
                                                    ContentValues contentValues = new ContentValues();
                                                    contentValues.put("pt", Long.valueOf(j11));
                                                    sQLiteDatabaseS.update(a.f13714c.a(), contentValues, "tid=" + dVar.f62792a, null);
                                                }
                                                i14 += dVar.f62797f;
                                                it2 = it3;
                                                cursorRawQuery = cursor2;
                                                str2 = str6;
                                                str4 = str4;
                                                str5 = str5;
                                                cursor3 = null;
                                            } catch (SQLiteException e14) {
                                                e = e14;
                                                cursorRawQuery = cursor2;
                                                cursor = null;
                                                a0.c(Log.getStackTraceString(e));
                                                if (cursorRawQuery != null) {
                                                    cursorRawQuery.close();
                                                }
                                                if (sQLiteDatabaseS != null) {
                                                    sQLiteDatabaseS.endTransaction();
                                                    sQLiteDatabase = cursor;
                                                } else {
                                                    sQLiteDatabase = sQLiteDatabaseS;
                                                }
                                                g(e);
                                                throw new com.transsion.ga.e("cleanupEvents_sql", e);
                                            }
                                        } catch (Throwable th4) {
                                            th = th4;
                                            cursor3 = cursor2;
                                            if (cursor3 != null) {
                                                cursor3.close();
                                            }
                                            if (sQLiteDatabaseS != null) {
                                                sQLiteDatabaseS.endTransaction();
                                            }
                                            throw th;
                                        }
                                    } catch (SQLiteException e15) {
                                        e = e15;
                                    }
                                }
                                String str7 = str4;
                                String str8 = str5;
                                Iterator<AppIdData> it4 = it2;
                                cursor2 = cursorRawQuery;
                                String str9 = str2;
                                try {
                                    ContentValues contentValues2 = new ContentValues();
                                    cr.e eVar = sparseArray.get(next.f50747a);
                                    if (eVar != null) {
                                        String str10 = eVar.f62805b;
                                        if (str10 == null || str10.equals(str)) {
                                            sparseArray.remove(next.f50747a);
                                        }
                                        String str11 = eVar.f62805b;
                                        if (str11 == null || !str11.equals(str)) {
                                            str3 = str9;
                                            contentValues2.put("date", str);
                                            contentValues2.put("cnt", Integer.valueOf(i14));
                                            contentValues2.put(str3, "1");
                                        } else {
                                            contentValues2.put("cnt", Integer.valueOf(eVar.f62806c + i14));
                                            str3 = str9;
                                            contentValues2.put(str3, String.valueOf(eVar.f62807d + 1));
                                        }
                                    } else {
                                        str3 = str9;
                                    }
                                    contentValues2.put(CommonUtils.PARAM_UID, "");
                                    contentValues2.put("try", (Integer) 0);
                                    cursor = null;
                                    try {
                                        sQLiteDatabaseS.update(a.f13715d.a(), contentValues2, "appid=" + next.f50747a, null);
                                        cursor3 = null;
                                        cursorRawQuery = cursor2;
                                        str4 = str7;
                                        str5 = str8;
                                        str2 = str3;
                                        it2 = it4;
                                    } catch (SQLiteException e16) {
                                        e = e16;
                                        cursorRawQuery = cursor2;
                                        a0.c(Log.getStackTraceString(e));
                                        if (cursorRawQuery != null) {
                                            cursorRawQuery.close();
                                        }
                                        if (sQLiteDatabaseS != null) {
                                            sQLiteDatabaseS.endTransaction();
                                            sQLiteDatabase = cursor;
                                        } else {
                                            sQLiteDatabase = sQLiteDatabaseS;
                                        }
                                        g(e);
                                        throw new com.transsion.ga.e("cleanupEvents_sql", e);
                                    }
                                } catch (SQLiteException e17) {
                                    e = e17;
                                    cursor = null;
                                    cursorRawQuery = cursor2;
                                    a0.c(Log.getStackTraceString(e));
                                    if (cursorRawQuery != null) {
                                        cursorRawQuery.close();
                                    }
                                    if (sQLiteDatabaseS != null) {
                                        sQLiteDatabaseS.endTransaction();
                                        sQLiteDatabase = cursor;
                                    } else {
                                        sQLiteDatabase = sQLiteDatabaseS;
                                    }
                                    g(e);
                                    throw new com.transsion.ga.e("cleanupEvents_sql", e);
                                }
                            }
                            cursor = cursor3;
                            cursor2 = cursorRawQuery;
                            sQLiteDatabaseS.setTransactionSuccessful();
                            if (l0Var != null) {
                                l0Var.a(sparseArray);
                            }
                            if (cursor2 != null) {
                                cursor2.close();
                            }
                            sQLiteDatabaseS.endTransaction();
                        } catch (SQLiteException e18) {
                            e = e18;
                            cursor = cursor3;
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        cursor2 = cursorRawQuery;
                    }
                } catch (SQLiteException e19) {
                    e = e19;
                    cursor = null;
                    cursorRawQuery = null;
                } catch (Throwable th6) {
                    th = th6;
                }
            } catch (Throwable th7) {
                th = th7;
                cursor3 = cursorRawQuery;
                if (cursor3 != null) {
                    cursor3.close();
                }
                if (sQLiteDatabaseS != null) {
                    sQLiteDatabaseS.endTransaction();
                }
                throw th;
            }
        } catch (SQLiteException e21) {
            e = e21;
            cursor = null;
            sQLiteDatabaseS = null;
            cursorRawQuery = null;
        } catch (Throwable th8) {
            th = th8;
        }
    }

    public void n(a aVar, List<Long> list, l0<String> l0Var) throws Throwable {
        String strA = aVar.a();
        String strD = br.d.d(list, ",");
        Cursor cursor = null;
        try {
            try {
                SQLiteDatabase sQLiteDatabaseS = s();
                if (sQLiteDatabaseS == null) {
                    return;
                }
                LongSparseArray longSparseArray = new LongSparseArray();
                Cursor cursorRawQuery = sQLiteDatabaseS.rawQuery("SELECT tid FROM " + strA + " WHERE tid IN (" + strD + ")", null);
                while (cursorRawQuery != null) {
                    try {
                        if (!cursorRawQuery.moveToNext()) {
                            break;
                        }
                        long j11 = cursorRawQuery.getLong(0);
                        longSparseArray.put(j11, Integer.valueOf(((Integer) longSparseArray.get(j11, 0)).intValue() + 1));
                    } catch (SQLiteException e11) {
                        e = e11;
                        cursor = cursorRawQuery;
                    } catch (Throwable th2) {
                        th = th2;
                        cursor = cursorRawQuery;
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw th;
                    }
                }
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
                sQLiteDatabaseS.delete(strA, "tid IN (" + strD + ")", null);
                if (l0Var != null && longSparseArray.size() > 0) {
                    l0Var.a(longSparseArray.toString());
                }
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                    return;
                }
                return;
            } catch (SQLiteException e12) {
                e = e12;
            }
        } catch (Throwable th3) {
            th = th3;
        }
        a0.c(Log.getStackTraceString(e));
        if (cursor != null) {
            cursor.close();
        }
        g(e);
        throw new com.transsion.ga.e("cleanupEvents_off_sql", e);
    }

    /* JADX WARN: Not initialized variable reg: 4, insn: 0x0081: MOVE (r3 I:??[OBJECT, ARRAY]) = (r4 I:??[OBJECT, ARRAY]), block:B:16:0x0081 */
    public void o(a aVar, List<AppIdData> list, String str) throws Throwable {
        SQLiteDatabase sQLiteDatabaseS;
        SQLiteDatabase sQLiteDatabase;
        String strA = aVar.a();
        StringBuilder sb2 = new StringBuilder();
        SQLiteDatabase sQLiteDatabase2 = null;
        try {
            try {
                try {
                    sQLiteDatabaseS = s();
                    if (sQLiteDatabaseS == null) {
                        if (sQLiteDatabaseS != null) {
                            sQLiteDatabaseS.endTransaction();
                            return;
                        }
                        return;
                    }
                    try {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put(CommonUtils.PARAM_UID, str);
                        sQLiteDatabaseS.beginTransaction();
                        for (AppIdData appIdData : list) {
                            for (cr.d dVar : appIdData.f50751e) {
                                sQLiteDatabaseS.update(strA, contentValues, "tid=" + dVar.f62792a + " AND _id>=" + dVar.f62795d + " AND _id<=" + dVar.f62796e, null);
                            }
                            br.d.g(sb2, Integer.valueOf(appIdData.f50747a));
                        }
                        contentValues.put("try", (Integer) 0);
                        sQLiteDatabaseS.update(a.f13715d.a(), contentValues, "appid IN (" + sb2.toString() + ")", null);
                        sQLiteDatabaseS.setTransactionSuccessful();
                        sQLiteDatabaseS.endTransaction();
                    } catch (SQLiteException e11) {
                        e = e11;
                        a0.c(Log.getStackTraceString(e));
                        if (sQLiteDatabaseS != null) {
                            sQLiteDatabaseS.endTransaction();
                        }
                        g(e);
                        throw new com.transsion.ga.e("updateEvents_sql", e);
                    }
                } catch (Throwable th2) {
                    th = th2;
                    sQLiteDatabase2 = sQLiteDatabase;
                    if (sQLiteDatabase2 != null) {
                        sQLiteDatabase2.endTransaction();
                    }
                    throw th;
                }
            } catch (SQLiteException e12) {
                e = e12;
                sQLiteDatabaseS = null;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public void p(l0<SparseArray<br.b>> l0Var) throws Throwable {
        br.b bVarC;
        SparseArray<br.b> sparseArray = new SparseArray<>();
        Cursor cursorRawQuery = null;
        try {
            try {
                SQLiteDatabase sQLiteDatabaseS = s();
                if (sQLiteDatabaseS == null) {
                    return;
                }
                Cursor cursorRawQuery2 = sQLiteDatabaseS.rawQuery("SELECT * FROM " + a.f13715d.a(), null);
                while (cursorRawQuery2 != null) {
                    try {
                        if (!cursorRawQuery2.moveToNext()) {
                            break;
                        }
                        String string = cursorRawQuery2.getString(cursorRawQuery2.getColumnIndex("cfg"));
                        if (!TextUtils.isEmpty(string) && (bVarC = br.b.c(string)) != null) {
                            bVarC.d(cursorRawQuery2.getInt(cursorRawQuery2.getColumnIndex(SafeStringUtils.SP_APPID)));
                            sparseArray.put(bVarC.a(), bVarC);
                        }
                    } catch (SQLiteException e11) {
                        e = e11;
                        cursorRawQuery = cursorRawQuery2;
                    } catch (Throwable th2) {
                        th = th2;
                        cursorRawQuery = cursorRawQuery2;
                        if (cursorRawQuery != null) {
                            cursorRawQuery.close();
                        }
                        throw th;
                    }
                }
                if (cursorRawQuery2 != null) {
                    cursorRawQuery2.close();
                }
                cursorRawQuery = sQLiteDatabaseS.rawQuery("SELECT * FROM " + a.f13714c.a(), null);
                while (cursorRawQuery != null && cursorRawQuery.moveToNext()) {
                    long j11 = cursorRawQuery.getLong(cursorRawQuery.getColumnIndex("tid"));
                    String string2 = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("ev"));
                    br.h hVar = new br.h();
                    hVar.j(cursorRawQuery.getLong(cursorRawQuery.getColumnIndex("pt")));
                    hVar.d(cursorRawQuery.getString(cursorRawQuery.getColumnIndex("cf")));
                    br.b bVar = sparseArray.get(j0.a(j11));
                    if (bVar != null) {
                        bVar.e(new br.a(j11, string2, hVar));
                    }
                }
                if (l0Var != null) {
                    l0Var.a(sparseArray);
                }
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                    return;
                }
                return;
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (SQLiteException e12) {
            e = e12;
        }
        a0.c(Log.getStackTraceString(e));
        if (cursorRawQuery != null) {
            cursorRawQuery.close();
        }
        g(e);
        throw new com.transsion.ga.e("getAPPIDApp_sql", e);
    }

    public boolean q(a aVar, int i11) throws com.transsion.ga.e {
        String strA = aVar.a();
        try {
            SQLiteDatabase sQLiteDatabaseS = s();
            if (sQLiteDatabaseS == null) {
                return false;
            }
            sQLiteDatabaseS.delete(strA, "CAST(tid AS TEXT) LIKE ?", new String[]{i11 + "%"});
            return true;
        } catch (SQLiteException e11) {
            a0.c(Log.getStackTraceString(e11));
            g(e11);
            throw new com.transsion.ga.e("cleanupEvents_del_sql", e11);
        }
    }

    /* JADX WARN: Code duplicated, block: B:86:0x0197  */
    /* JADX WARN: Code duplicated, block: B:88:0x019c  */
    /* JADX WARN: Code duplicated, block: B:91:0x01a7  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v21 */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v7, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r6v0, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v5, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARN: Type inference failed for: r6v6 */
    /* JADX WARN: Type inference failed for: r6v8, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARN: Type inference failed for: r6v9 */
    /* JADX WARN: Type inference failed for: r9v1, types: [java.lang.StringBuilder] */
    public int r(a aVar, List<cr.a> list, l0<LongSparseArray<Integer>> l0Var) throws Throwable {
        ?? r11;
        ?? r12;
        Cursor cursorRawQuery;
        ?? A = aVar.a();
        HashSet hashSet = new HashSet();
        ?? r13 = 0;
        ?? r14 = 0;
        r13 = 0;
        try {
            try {
                try {
                    ?? S = s();
                    int i11 = 0;
                    if (S == 0) {
                        if (S != 0) {
                            S.endTransaction();
                        }
                        if (!this.f13710a.a()) {
                            a0.c("There is not enough space left");
                        }
                        return 0;
                    }
                    try {
                        S.beginTransaction();
                        ContentValues contentValues = new ContentValues();
                        for (cr.a aVar2 : list) {
                            JSONObject jSONObjectC = aVar2.c();
                            Pair<Integer, byte[]> pairT = ar.b.a().t();
                            int iIntValue = ((Integer) pairT.first).intValue();
                            String strB = p0.b(jSONObjectC.toString(), (byte[]) pairT.second);
                            if (strB != null) {
                                contentValues.clear();
                                contentValues.put("tid", Long.valueOf(aVar2.e()));
                                contentValues.put(NotificationCompat.CATEGORY_EVENT, strB);
                                contentValues.put("et", (Integer) 0);
                                contentValues.put("pi", Integer.valueOf(iIntValue));
                                contentValues.put("created_at", Long.valueOf(aVar2.i()));
                                if (aVar2.a() != null) {
                                    contentValues.put("er_ts", Long.valueOf(aVar2.g()));
                                    contentValues.put("boot_id", aVar2.a());
                                }
                                if (S.insert(A, null, contentValues) > 0) {
                                    hashSet.add(Long.valueOf(aVar2.e()));
                                }
                            }
                        }
                        if (hashSet.size() > 0) {
                            LongSparseArray<Integer> longSparseArray = new LongSparseArray<>();
                            cursorRawQuery = S.rawQuery("SELECT tid,COUNT(*) FROM " + A + " WHERE tid IN (" + br.d.d(hashSet, ",") + ") GROUP BY tid", null);
                            int i12 = 0;
                            while (cursorRawQuery != null) {
                                try {
                                    if (!cursorRawQuery.moveToNext()) {
                                        break;
                                    }
                                    longSparseArray.put(cursorRawQuery.getLong(0), Integer.valueOf(cursorRawQuery.getInt(1)));
                                    i12++;
                                } catch (SQLiteException e11) {
                                    e = e11;
                                    A = cursorRawQuery;
                                    r12 = S;
                                    a0.c(Log.getStackTraceString(e));
                                    if (A != 0) {
                                        A.close();
                                    }
                                    if (r12 != 0) {
                                        r12.endTransaction();
                                    } else {
                                        r14 = r12;
                                    }
                                    try {
                                        g(e);
                                        throw new com.transsion.ga.e("addJSON_sql", e);
                                    } catch (Throwable th2) {
                                        th = th2;
                                        r11 = r14;
                                        r13 = A;
                                        if (r13 != 0) {
                                            r13.close();
                                        }
                                        if (r11 != 0) {
                                            r11.endTransaction();
                                        }
                                        if (!this.f13710a.a()) {
                                            a0.c("There is not enough space left");
                                        }
                                        throw th;
                                    }
                                } catch (Exception e12) {
                                    e = e12;
                                    a0.c(Log.getStackTraceString(e));
                                    throw new com.transsion.ga.e("addJSON", e);
                                }
                            }
                            if (l0Var != null && longSparseArray.size() > 0) {
                                l0Var.a(longSparseArray);
                            }
                            i11 = i12;
                            cursorRawQuery = cursorRawQuery;
                        } else {
                            cursorRawQuery = null;
                        }
                        S.setTransactionSuccessful();
                        if (cursorRawQuery != null) {
                            cursorRawQuery.close();
                        }
                        S.endTransaction();
                        if (this.f13710a.a()) {
                            return i11;
                        }
                        a0.c("There is not enough space left");
                        return -2;
                    } catch (SQLiteException e13) {
                        e = e13;
                        A = 0;
                        r12 = S;
                    } catch (Exception e14) {
                        e = e14;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    if (r13 != 0) {
                        r13.close();
                    }
                    if (r11 != 0) {
                        r11.endTransaction();
                    }
                    if (!this.f13710a.a()) {
                        a0.c("There is not enough space left");
                    }
                    throw th;
                }
            } catch (SQLiteException e15) {
                e = e15;
                A = 0;
                r12 = 0;
            } catch (Exception e16) {
                e = e16;
            } catch (Throwable th4) {
                th = th4;
                r11 = 0;
                if (r13 != 0) {
                    r13.close();
                }
                if (r11 != 0) {
                    r11.endTransaction();
                }
                if (!this.f13710a.a()) {
                    a0.c("There is not enough space left");
                }
                throw th;
            }
        } catch (Throwable th5) {
            th = th5;
        }
    }

    public final SQLiteDatabase s() {
        try {
            if (!this.f13711b.getDatabasePath("athena.db").exists()) {
                this.f13710a.close();
            }
            return this.f13710a.getWritableDatabase();
        } catch (SQLiteException e11) {
            a0.c(Log.getStackTraceString(e11));
            return null;
        }
    }
}
