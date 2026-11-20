package com.mbridge.msdk.foundation.db;

import android.content.ContentValues;
import android.database.Cursor;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class n extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static n f44199a;

    private n(g gVar) {
        super(gVar);
    }

    public static n a(g gVar) {
        if (f44199a == null) {
            synchronized (n.class) {
                try {
                    if (f44199a == null) {
                        f44199a = new n(gVar);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return f44199a;
    }

    private synchronized int b(int i11) {
        try {
        } catch (Exception unused) {
            return -1;
        }
        return getWritableDatabase().rawQuery("DELETE from reporterror where count >= " + i11, null).getCount();
    }

    private synchronized boolean b(String str, String str2, long j11) {
        if (str == null) {
            str = "";
        }
        try {
            try {
                if (getWritableDatabase() == null) {
                    return false;
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append("select * from reporterror where url='");
                sb2.append(str2);
                sb2.append("' and ");
                sb2.append("data");
                sb2.append("='");
                sb2.append(str);
                sb2.append("' and ");
                sb2.append("time_stamp");
                sb2.append("=");
                sb2.append(j11);
                return getReadableDatabase().rawQuery(sb2.toString(), null).getCount() > 0;
            } catch (Exception e11) {
                e11.printStackTrace();
                return false;
            }
        } catch (Throwable th2) {
            throw th2;
        }
        throw th2;
    }

    public final synchronized int a() {
        int i11;
        i11 = 0;
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = getReadableDatabase().query("reporterror", new String[]{" count(*) "}, null, null, null, null, null);
                if (cursorQuery != null && cursorQuery.moveToFirst()) {
                    i11 = cursorQuery.getInt(0);
                }
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            } catch (Exception e11) {
                e11.printStackTrace();
                if (cursorQuery != null) {
                }
            }
        } catch (Throwable th2) {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            throw th2;
        }
        return i11;
    }

    public final synchronized int a(String str) {
        try {
            String[] strArr = {str};
            if (getWritableDatabase() == null) {
                return -1;
            }
            return getWritableDatabase().delete("reporterror", "url=?", strArr);
        } catch (Exception unused) {
            return -1;
        }
    }

    public final synchronized long a(com.mbridge.msdk.foundation.entity.l lVar) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("url", lVar.f());
            contentValues.put("method", lVar.b());
            contentValues.put("data", lVar.a());
            contentValues.put(CampaignEx.JSON_KEY_CAMPAIGN_UNITID, lVar.e());
            contentValues.put("time_stamp", Long.valueOf(lVar.c()));
            if (getWritableDatabase() == null) {
                return -1L;
            }
            if (!b(lVar.a(), lVar.f(), lVar.c())) {
                contentValues.put("count", Integer.valueOf(lVar.d()));
                return getWritableDatabase().insert("reporterror", null, contentValues);
            }
            return getWritableDatabase().rawQuery("UPDATE reporterror SET count = " + lVar.d() + " where url='" + lVar.f() + "' and data='" + lVar.a() + "' and time_stamp=" + lVar.c(), null).getCount();
        } catch (Exception unused) {
            return -1L;
        }
    }

    /* JADX WARN: Code duplicated, block: B:36:0x00ae A[Catch: all -> 0x0099, TRY_ENTER, TryCatch #4 {all -> 0x0099, blocks: (B:31:0x00a6, B:21:0x0095, B:36:0x00ae, B:37:0x00b1), top: B:45:0x0003 }] */
    public final synchronized List<com.mbridge.msdk.foundation.entity.l> a(int i11) {
        ArrayList arrayList;
        Exception e11;
        Cursor cursorQuery;
        ArrayList arrayList2;
        Cursor cursor = null;
        arrayList2 = null;
        arrayList2 = null;
        try {
            try {
                b(5);
                cursorQuery = getReadableDatabase().query("reporterror", null, null, null, null, null, null, i11 + "");
                if (cursorQuery != null) {
                    try {
                        try {
                            if (cursorQuery.getCount() > 0) {
                                arrayList = new ArrayList();
                                while (cursorQuery.moveToNext()) {
                                    try {
                                        String string = cursorQuery.getString(cursorQuery.getColumnIndex("url"));
                                        String string2 = cursorQuery.getString(cursorQuery.getColumnIndex("data"));
                                        String string3 = cursorQuery.getString(cursorQuery.getColumnIndex("method"));
                                        String string4 = cursorQuery.getString(cursorQuery.getColumnIndex(CampaignEx.JSON_KEY_CAMPAIGN_UNITID));
                                        int i12 = cursorQuery.getInt(cursorQuery.getColumnIndex("count"));
                                        long j11 = cursorQuery.getLong(cursorQuery.getColumnIndex("time_stamp"));
                                        com.mbridge.msdk.foundation.entity.l lVar = new com.mbridge.msdk.foundation.entity.l(string, string3, string2, string4);
                                        lVar.a(i12 + 1);
                                        lVar.a(j11);
                                        arrayList.add(lVar);
                                    } catch (Exception e12) {
                                        e11 = e12;
                                        e11.printStackTrace();
                                        if (cursorQuery != null) {
                                            cursorQuery.close();
                                        }
                                        arrayList2 = arrayList;
                                    }
                                }
                                arrayList2 = arrayList;
                            }
                        } catch (Exception e13) {
                            e11 = e13;
                            arrayList = null;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        cursor = cursorQuery;
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw th;
                    }
                }
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            } catch (Throwable th3) {
                throw th3;
            }
        } catch (Exception e14) {
            arrayList = null;
            e11 = e14;
            cursorQuery = null;
        } catch (Throwable th4) {
            th = th4;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
        return arrayList2;
    }

    public final synchronized void a(String str, String str2, long j11) {
        if (str == null) {
            str = "";
        }
        try {
            if (getWritableDatabase() == null) {
                return;
            }
            getWritableDatabase().execSQL("DELETE from reporterror where url='" + str2 + "' and data='" + str + "' and time_stamp=" + j11 + " or count > 5 ");
        } catch (Exception unused) {
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public final synchronized int b() {
        int count;
        count = 0;
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = getReadableDatabase().query("reporterror", new String[]{" count(*) "}, null, null, null, null, null, null);
                count = cursorQuery.getCount();
            } catch (Exception e11) {
                e11.printStackTrace();
                if (cursorQuery != null) {
                }
                return count;
            }
            cursorQuery.close();
        } catch (Throwable th2) {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            throw th2;
        }
        return count;
    }
}
