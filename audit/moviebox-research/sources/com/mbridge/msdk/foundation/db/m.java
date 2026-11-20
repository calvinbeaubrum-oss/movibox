package com.mbridge.msdk.foundation.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.tools.ad;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class m extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f44197a = "ReplaceTempDao";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static m f44198b;

    private m(g gVar) {
        super(gVar);
    }

    public static m a(g gVar) {
        if (f44198b == null) {
            synchronized (f.class) {
                try {
                    if (f44198b == null) {
                        f44198b = new m(gVar);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return f44198b;
    }

    private boolean b(String str) {
        Cursor cursorRawQuery = getReadableDatabase().rawQuery("SELECT d_value FROM c_replace_temp WHERE d_key='" + str + "'", null);
        if (cursorRawQuery != null && cursorRawQuery.getCount() > 0) {
            try {
                cursorRawQuery.close();
                return true;
            } catch (Exception unused) {
                return true;
            }
        }
        if (cursorRawQuery == null) {
            return false;
        }
        try {
            cursorRawQuery.close();
            return false;
        } catch (Exception unused2) {
            return false;
        }
    }

    /* JADX WARN: Code duplicated, block: B:24:0x006e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:25:0x0070 A[Catch: all -> 0x0069, TRY_ENTER, TRY_LEAVE, TryCatch #5 {all -> 0x0069, blocks: (B:12:0x0037, B:14:0x003d, B:25:0x0070), top: B:52:0x0037 }] */
    public final JSONObject a() {
        JSONObject jSONObject;
        long jCurrentTimeMillis = System.currentTimeMillis() - ((long) 604800000);
        try {
            if (getWritableDatabase() != null) {
                getWritableDatabase().delete("c_replace_temp", "time<?", new String[]{String.valueOf(jCurrentTimeMillis)});
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        JSONObject jSONObject2 = null;
        Cursor cursorRawQuery = getReadableDatabase().rawQuery("SELECT * FROM c_replace_temp", null);
        if (cursorRawQuery != null) {
            try {
                if (cursorRawQuery.getCount() > 0) {
                    jSONObject = new JSONObject();
                    while (cursorRawQuery.moveToNext()) {
                        try {
                            jSONObject.put(cursorRawQuery.getString(cursorRawQuery.getColumnIndex("d_key")), new JSONObject(cursorRawQuery.getString(cursorRawQuery.getColumnIndex("d_value"))));
                        } catch (Throwable th2) {
                            th = th2;
                            try {
                                ad.b(f44197a, th.getMessage());
                                if (cursorRawQuery == null) {
                                    return jSONObject;
                                }
                                try {
                                    return jSONObject;
                                } catch (Exception unused) {
                                    return jSONObject;
                                }
                            } finally {
                                if (cursorRawQuery != null) {
                                    try {
                                        cursorRawQuery.close();
                                    } catch (Exception unused2) {
                                    }
                                }
                            }
                        }
                    }
                    jSONObject2 = jSONObject;
                } else if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
            } catch (Throwable th3) {
                JSONObject jSONObject3 = jSONObject2;
                th = th3;
                jSONObject = jSONObject3;
            }
        } else if (cursorRawQuery != null) {
            cursorRawQuery.close();
        }
        if (cursorRawQuery != null) {
            try {
                cursorRawQuery.close();
            } catch (Exception unused3) {
            }
        }
        return jSONObject2;
    }

    /* JADX WARN: Code duplicated, block: B:16:0x004d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:35:0x005e A[DONT_GENERATE, EXC_TOP_SPLITTER, PHI: r1
  0x005e: PHI (r1v4 org.json.JSONObject) = (r1v0 org.json.JSONObject), (r1v6 org.json.JSONObject) binds: [B:20:0x005c, B:28:0x006a] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:37:0x004f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public final JSONObject a(String str) {
        JSONObject jSONObject = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Cursor cursorRawQuery = getReadableDatabase().rawQuery("SELECT * FROM c_replace_temp WHERE d_key = '" + str + "'", null);
        if (cursorRawQuery != null) {
            try {
                if (cursorRawQuery.getCount() > 0) {
                    jSONObject = new JSONObject();
                    while (cursorRawQuery.moveToNext()) {
                        jSONObject = new JSONObject(cursorRawQuery.getString(cursorRawQuery.getColumnIndex("d_value")));
                    }
                } else if (cursorRawQuery != null) {
                    try {
                        cursorRawQuery.close();
                    } catch (Exception unused) {
                    }
                }
                if (cursorRawQuery != null) {
                }
            } catch (Throwable th2) {
                try {
                    ad.b(f44197a, th2.getMessage());
                } finally {
                    if (cursorRawQuery != null) {
                        try {
                            cursorRawQuery.close();
                        } catch (Exception unused2) {
                        }
                    }
                }
            }
        } else {
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
            if (cursorRawQuery != null) {
            }
        }
        return jSONObject;
    }

    public final void a(String str, JSONObject jSONObject) {
        try {
            if (getWritableDatabase() == null) {
                return;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("d_key", str);
            contentValues.put("d_value", jSONObject.toString());
            contentValues.put("time", Long.valueOf(System.currentTimeMillis()));
            if (b(str)) {
                getWritableDatabase().update("c_replace_temp", contentValues, "d_key = '" + str + "'", null);
            } else {
                getWritableDatabase().insert("c_replace_temp", null, contentValues);
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }
}
