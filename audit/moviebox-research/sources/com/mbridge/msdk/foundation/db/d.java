package com.mbridge.msdk.foundation.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.click.entity.JumpLoaderResult;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.foundation.tools.aj;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class d extends a<JumpLoaderResult> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f44164a = "d";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static d f44165b;

    private d(g gVar) {
        super(gVar);
    }

    public static synchronized d a(g gVar) {
        try {
            if (f44165b == null) {
                f44165b = new d(gVar);
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return f44165b;
    }

    private synchronized boolean c(String str, String str2) {
        Cursor cursorRawQuery = getReadableDatabase().rawQuery("SELECT id FROM campaignclick WHERE id='" + str + "' AND unitid= '" + str2 + "'", null);
        if (cursorRawQuery != null && cursorRawQuery.getCount() > 0) {
            cursorRawQuery.close();
            return true;
        }
        if (cursorRawQuery != null) {
            cursorRawQuery.close();
        }
        return false;
    }

    public final synchronized long a(CampaignEx campaignEx, String str) {
        if (campaignEx == null) {
            return 0L;
        }
        try {
            try {
                String strA = aj.a(campaignEx.getJumpResult());
                ContentValues contentValues = new ContentValues();
                contentValues.put("id", campaignEx.getId());
                contentValues.put("unitid", str);
                contentValues.put("result", strA);
                contentValues.put("cti", Integer.valueOf(campaignEx.getClickInterval() * 1000));
                contentValues.put("package_name", campaignEx.getPackageName());
                com.mbridge.msdk.c.g gVarB = com.mbridge.msdk.c.h.a().b(com.mbridge.msdk.foundation.controller.c.m().k());
                contentValues.put("ts", Long.valueOf(System.currentTimeMillis()));
                if (gVarB != null && gVarB.Z() > 0) {
                    contentValues.put("cpei", Integer.valueOf(gVarB.Z() * 1000));
                }
                if (gVarB != null && gVarB.aa() > 0) {
                    contentValues.put("cpoci", Integer.valueOf(gVarB.aa() * 1000));
                }
                if (!c(campaignEx.getId(), str)) {
                    return getWritableDatabase().insert("campaignclick", null, contentValues);
                }
                String str2 = "id = " + campaignEx.getId() + " AND unitid = " + str;
                if (getWritableDatabase() == null) {
                    return -1L;
                }
                return getWritableDatabase().update("campaignclick", contentValues, str2, null);
            } catch (Exception e11) {
                if (MBridgeConstans.DEBUG) {
                    ad.b(f44164a, e11.getMessage());
                }
                return -1L;
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public final synchronized void a() {
        try {
            getWritableDatabase().delete("campaignclick", " ( " + System.currentTimeMillis() + " - ts) > cti", null);
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                ad.b(f44164a, e11.getMessage());
            }
        }
    }

    public final synchronized boolean a(String str, String str2) {
        try {
            Cursor cursorRawQuery = getReadableDatabase().rawQuery("SELECT id FROM campaignclick WHERE id='" + str + "' AND unitid='" + str2 + "' AND cti + ts > " + System.currentTimeMillis(), null);
            if (cursorRawQuery != null && cursorRawQuery.getCount() > 0) {
                cursorRawQuery.close();
                return true;
            }
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
            return false;
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                ad.b(f44164a, e11.getMessage());
            }
            return false;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v2, types: [android.database.Cursor] */
    public final synchronized JumpLoaderResult b(String str, String str2) {
        Cursor cursorQuery;
        ?? r11 = 0;
        try {
            try {
                try {
                    cursorQuery = getReadableDatabase().query("campaignclick", null, "id=? AND unitid=?", new String[]{str, str2}, null, null, null, null);
                    if (cursorQuery != null) {
                        try {
                            if (cursorQuery.getCount() > 0 && cursorQuery.moveToFirst()) {
                                String string = cursorQuery.getString(cursorQuery.getColumnIndex("result"));
                                if (!TextUtils.isEmpty(string)) {
                                    JumpLoaderResult jumpLoaderResult = (JumpLoaderResult) aj.a(string);
                                    cursorQuery.close();
                                    return jumpLoaderResult;
                                }
                            }
                        } catch (Exception e11) {
                            e = e11;
                            if (MBridgeConstans.DEBUG) {
                                ad.b(f44164a, e.getMessage());
                            }
                            if (cursorQuery != null) {
                            }
                            return null;
                        }
                    }
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            } catch (Exception e12) {
                e = e12;
                cursorQuery = null;
            } catch (Throwable th3) {
                th = th3;
                if (r11 != 0) {
                    r11.close();
                }
                throw th;
            }
            return null;
        } catch (Throwable th4) {
            th = th4;
            r11 = str;
        }
    }
}
