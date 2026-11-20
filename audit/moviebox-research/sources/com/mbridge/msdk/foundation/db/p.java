package com.mbridge.msdk.foundation.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.out.Campaign;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class p extends a<Campaign> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static p f44201a;

    private p(g gVar) {
        super(gVar);
    }

    public static synchronized p a(g gVar) {
        try {
            if (f44201a == null) {
                f44201a = new p(gVar);
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return f44201a;
    }

    private synchronized boolean b(String str, String str2) {
        String str3;
        try {
            if (TextUtils.isEmpty(str2)) {
                str3 = "SELECT id FROM video WHERE video_url = '" + str + "'";
            } else {
                str3 = "SELECT id FROM video WHERE video_url = '" + str + "' AND id = " + str2;
            }
            Cursor cursorRawQuery = getReadableDatabase().rawQuery(str3, null);
            if (cursorRawQuery != null && cursorRawQuery.getCount() > 0) {
                try {
                    cursorRawQuery.close();
                } catch (Exception e11) {
                    if (MBridgeConstans.DEBUG) {
                        ad.b("VideoDao", e11.getLocalizedMessage());
                    }
                }
                return true;
            }
            if (cursorRawQuery != null) {
                try {
                    cursorRawQuery.close();
                } catch (Exception e12) {
                    if (MBridgeConstans.DEBUG) {
                        ad.b("VideoDao", e12.getLocalizedMessage());
                    }
                }
            }
            return false;
        } catch (Throwable th2) {
            throw th2;
        }
        throw th2;
    }

    public final synchronized long a(CampaignEx campaignEx, long j11, String str, int i11) {
        if (campaignEx == null) {
            return 0L;
        }
        try {
            try {
                if (getWritableDatabase() == null) {
                    return -1L;
                }
                ContentValues contentValues = new ContentValues();
                contentValues.put("unitid", campaignEx.getCampaignUnitId());
                contentValues.put("id", campaignEx.getId());
                contentValues.put("package_name", campaignEx.getPackageName());
                contentValues.put("app_name", campaignEx.getAppName());
                contentValues.put("app_desc", campaignEx.getAppDesc());
                contentValues.put(CampaignEx.JSON_KEY_APP_SIZE, campaignEx.getSize());
                contentValues.put(CampaignEx.JSON_KEY_IMAGE_SIZE, campaignEx.getImageSize());
                contentValues.put("icon_url", campaignEx.getIconUrl());
                contentValues.put("image_url", campaignEx.getImageUrl());
                contentValues.put(CampaignEx.JSON_KEY_IMPRESSION_URL, campaignEx.getImpressionURL());
                contentValues.put(CampaignEx.JSON_KEY_NOTICE_URL, campaignEx.getNoticeUrl());
                contentValues.put("download_url", campaignEx.getClickURL());
                contentValues.put("only_impression", campaignEx.getOnlyImpressionURL());
                contentValues.put("ts", Long.valueOf(campaignEx.getTimestamp()));
                contentValues.put("template", Integer.valueOf(campaignEx.getTemplate()));
                contentValues.put(CampaignEx.JSON_KEY_CLICK_MODE, campaignEx.getClick_mode());
                contentValues.put(CampaignEx.JSON_KEY_LANDING_TYPE, campaignEx.getLandingType());
                contentValues.put(CampaignEx.JSON_KEY_LINK_TYPE, Integer.valueOf(campaignEx.getLinkType()));
                contentValues.put("star", Double.valueOf(campaignEx.getRating()));
                contentValues.put("cti", Integer.valueOf(campaignEx.getClickInterval()));
                contentValues.put("level", Integer.valueOf(campaignEx.getCacheLevel()));
                contentValues.put("adSource", Integer.valueOf(campaignEx.getType()));
                contentValues.put("ad_call", campaignEx.getAdCall());
                contentValues.put("fc_a", Integer.valueOf(campaignEx.getFca()));
                contentValues.put(CampaignEx.JSON_KEY_AD_URL_LIST, campaignEx.getAd_url_list());
                contentValues.put(CampaignEx.JSON_KEY_VIDEO_URL, campaignEx.getVideoUrlEncode());
                contentValues.put("total_size", Long.valueOf(j11));
                contentValues.put("video_state", Integer.valueOf(i11));
                contentValues.put("video_download_start", Long.valueOf(System.currentTimeMillis() / 1000));
                contentValues.put("ad_bid_token", campaignEx.getBidToken());
                if (!TextUtils.isEmpty(str)) {
                    contentValues.put("video_path", str);
                }
                if (b(campaignEx.getVideoUrlEncode(), campaignEx.getId())) {
                    return 0L;
                }
                return getWritableDatabase().insert("video", null, contentValues);
            } catch (Exception e11) {
                if (MBridgeConstans.DEBUG) {
                    ad.b("VideoDao", e11.getLocalizedMessage());
                }
                return -1L;
            }
        } catch (Throwable th2) {
            throw th2;
        }
        throw th2;
    }

    public final synchronized long a(String str, long j11, int i11) {
        int iUpdate = -1;
        try {
            if (getWritableDatabase() == null) {
                return -1;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("pregeress_size", Long.valueOf(j11));
            contentValues.put("video_state", Integer.valueOf(i11));
            if (b(str, "")) {
                String str2 = "video_url = '" + str + "'";
                synchronized (new Object()) {
                    iUpdate = getWritableDatabase().update("video", contentValues, str2, null);
                }
            }
            return iUpdate;
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                ad.b("VideoDao", e11.getLocalizedMessage());
            }
        }
    }

    public final synchronized com.mbridge.msdk.foundation.entity.m a(String str) {
        com.mbridge.msdk.foundation.entity.m mVar;
        Exception e11;
        Cursor cursorRawQuery;
        Cursor cursor = null;
        mVar = null;
        com.mbridge.msdk.foundation.entity.m mVar2 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            cursorRawQuery = getReadableDatabase().rawQuery("SELECT * FROM video WHERE video_url = '" + str + "'", null);
            if (cursorRawQuery != null) {
                try {
                    try {
                        if (cursorRawQuery.getCount() > 0) {
                            mVar = new com.mbridge.msdk.foundation.entity.m();
                            while (cursorRawQuery.moveToNext()) {
                                try {
                                    mVar.b(cursorRawQuery.getString(cursorRawQuery.getColumnIndex(CampaignEx.JSON_KEY_VIDEO_URL)));
                                    mVar.a(cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("video_state")));
                                    mVar.b(cursorRawQuery.getLong(cursorRawQuery.getColumnIndex("pregeress_size")));
                                    mVar.b(cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("total_size")));
                                    mVar.a(cursorRawQuery.getString(cursorRawQuery.getColumnIndex("video_path")));
                                    mVar.a(cursorRawQuery.getLong(cursorRawQuery.getColumnIndex("video_download_start")) * 1000);
                                } catch (Exception e12) {
                                    e11 = e12;
                                    if (MBridgeConstans.DEBUG) {
                                        ad.b("VideoDao", e11.getLocalizedMessage());
                                    }
                                    if (cursorRawQuery != null) {
                                        try {
                                            cursorRawQuery.close();
                                        } catch (Exception e13) {
                                            if (MBridgeConstans.DEBUG) {
                                                ad.b("VideoDao", e13.getLocalizedMessage());
                                            }
                                        }
                                    }
                                    mVar2 = mVar;
                                }
                            }
                            mVar2 = mVar;
                        }
                    } catch (Exception e14) {
                        e11 = e14;
                        mVar = null;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    cursor = cursorRawQuery;
                    if (cursor != null) {
                        try {
                            cursor.close();
                        } catch (Exception e15) {
                            if (MBridgeConstans.DEBUG) {
                                ad.b("VideoDao", e15.getLocalizedMessage());
                            }
                        }
                    }
                    throw th;
                }
            }
            if (cursorRawQuery != null) {
                try {
                    cursorRawQuery.close();
                } catch (Exception e16) {
                    if (MBridgeConstans.DEBUG) {
                        ad.b("VideoDao", e16.getLocalizedMessage());
                    }
                }
            }
        } catch (Exception e17) {
            mVar = null;
            e11 = e17;
            cursorRawQuery = null;
        } catch (Throwable th3) {
            th = th3;
        }
        return mVar2;
    }

    /* JADX WARN: Code duplicated, block: B:40:0x00a5 A[EXC_TOP_SPLITTER, PHI: r0
  0x00a5: PHI (r0v3 android.database.Cursor) = (r0v2 android.database.Cursor), (r0v4 android.database.Cursor) binds: [B:29:0x00b8, B:21:0x00a3] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    public final synchronized com.mbridge.msdk.foundation.entity.m a(String str, String str2) {
        Cursor cursorRawQuery = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        com.mbridge.msdk.foundation.entity.m mVar = new com.mbridge.msdk.foundation.entity.m();
        try {
            try {
                cursorRawQuery = getReadableDatabase().rawQuery("SELECT * FROM video" + (" WHERE video_url = '" + str + "'"), null);
                if (cursorRawQuery != null && cursorRawQuery.getCount() > 0) {
                    while (cursorRawQuery.moveToNext()) {
                        mVar.b(cursorRawQuery.getString(cursorRawQuery.getColumnIndex(CampaignEx.JSON_KEY_VIDEO_URL)));
                        mVar.a(cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("video_state")));
                        mVar.b(cursorRawQuery.getLong(cursorRawQuery.getColumnIndex("pregeress_size")));
                        mVar.b(cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("total_size")));
                        mVar.a(cursorRawQuery.getString(cursorRawQuery.getColumnIndex("video_path")));
                        mVar.a(cursorRawQuery.getLong(cursorRawQuery.getColumnIndex("video_download_start")) * 1000);
                    }
                }
                if (cursorRawQuery != null) {
                    try {
                        cursorRawQuery.close();
                    } catch (Exception unused) {
                    }
                }
            } catch (Exception e11) {
                if (MBridgeConstans.DEBUG) {
                    ad.b("VideoDao", e11.getLocalizedMessage());
                }
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
            }
            return mVar;
        } catch (Throwable th2) {
            if (cursorRawQuery != null) {
                try {
                    cursorRawQuery.close();
                } catch (Exception unused2) {
                }
            }
            throw th2;
        }
    }

    public final synchronized void a(String str, long j11) {
        if (j11 == 0) {
            return;
        }
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("video_download_start", Long.valueOf(j11 / 1000));
            if (b(str, "")) {
                getWritableDatabase().update("video", contentValues, "video_url = '" + str + "'", null);
            }
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                ad.b("VideoDao", e11.getLocalizedMessage());
            }
        }
    }

    public final synchronized long b(String str, long j11) {
        int iUpdate = -1;
        try {
            if (getWritableDatabase() == null) {
                return -1;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("total_size", Long.valueOf(j11));
            if (b(str, "")) {
                String str2 = "video_url = '" + str + "'";
                synchronized (new Object()) {
                    iUpdate = getWritableDatabase().update("video", contentValues, str2, null);
                }
            }
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                ad.b("VideoDao", e11.getLocalizedMessage());
            }
        }
        return iUpdate;
    }

    public final synchronized void b(String str) {
        try {
            String str2 = "video_url = '" + str + "'";
            if (getWritableDatabase() == null) {
            } else {
                getWritableDatabase().delete("video", str2, null);
            }
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                ad.b("VideoDao", e11.getLocalizedMessage());
            }
        }
    }
}
