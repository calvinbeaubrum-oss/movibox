package com.cloud.hisavana.sdk.database;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.cloud.config.utils.XLogUtil;
import com.cloud.hisavana.sdk.data.bean.response.AdsDTO;
import com.cloud.hisavana.sdk.data.bean.response.ConfigCodeSeatDTO;
import com.cloud.hisavana.sdk.z;
import com.cloud.sdk.commonutil.gsonutil.GsonUtil;
import com.cloud.sdk.commonutil.util.f;
import com.google.gson.reflect.TypeToken;
import com.hisavana.common.tracking.TrackingKey;
import com.mbridge.msdk.mbbid.out.BidResponsed;
import java.util.ArrayList;
import java.util.List;
import w9.y;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class HisavanaContentProvider extends ContentProvider {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f29641b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static UriMatcher f29642c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SQLiteDatabase f29643a;

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes4.dex */
    public class a extends TypeToken<List<ConfigCodeSeatDTO>> {
        public a() {
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes4.dex */
    public class b extends TypeToken<List<AdsDTO>> {
        public b() {
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes4.dex */
    public class c extends TypeToken<List<ConfigCodeSeatDTO>> {
        public c() {
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes4.dex */
    public class d extends TypeToken<List<AdsDTO>> {
        public d() {
        }
    }

    public static void f() {
        if (f29642c == null) {
            f29641b = f.a().getPackageName() + ".HisavanaContentProvider";
            UriMatcher uriMatcher = new UriMatcher(-1);
            f29642c = uriMatcher;
            uriMatcher.addURI(f29641b, XLogUtil.TAG, 100);
            f29642c.addURI(f29641b, "ad_data", 200);
        }
    }

    public final int a(String str) {
        z.a().d("HisavanaContentProvider", "deleteAds selection " + str);
        try {
            h();
            SQLiteDatabase sQLiteDatabase = this.f29643a;
            if (sQLiteDatabase == null) {
                return -1;
            }
            sQLiteDatabase.execSQL(str);
            return 0;
        } catch (Exception e11) {
            z.a().e("HisavanaContentProvider", "deleteAds " + Log.getStackTraceString(e11));
            return 0;
        }
    }

    public final Cursor b(String[] strArr) {
        String str;
        if (strArr == null || strArr.length == 0) {
            str = "SELECT * FROM adList";
        } else {
            StringBuilder sb2 = new StringBuilder("(");
            for (int i11 = 0; i11 < strArr.length; i11++) {
                int length = strArr.length - 1;
                sb2.append("'");
                if (i11 == length) {
                    sb2.append(strArr[i11]);
                    sb2.append("'");
                } else {
                    sb2.append(strArr[i11]);
                    sb2.append("',");
                }
            }
            sb2.append(")");
            str = "select * from adList where ad_creative_id IN " + ((Object) sb2);
        }
        try {
            h();
            if (this.f29643a == null) {
                return null;
            }
            z.a().d("HisavanaContentProvider", "getCursorForProvider sql " + str);
            return this.f29643a.rawQuery(str, null);
        } catch (Exception e11) {
            z.a().e("HisavanaContentProvider", "getCursorForProvider e " + Log.getStackTraceString(e11));
            return null;
        }
    }

    public final void c() {
        SQLiteDatabase sQLiteDatabase = this.f29643a;
        if (sQLiteDatabase != null) {
            sQLiteDatabase.endTransaction();
        }
    }

    public final boolean d(AdsDTO adsDTO, AdsDTO adsDTO2) {
        return adsDTO2 != null && adsDTO != null && adsDTO.getAdCreativeId().equals(adsDTO2.getAdCreativeId()) && TextUtils.equals(adsDTO.getCodeSeatId(), adsDTO2.getCodeSeatId()) && adsDTO.isOfflineAd() == adsDTO2.isOfflineAd();
    }

    @Override // android.content.ContentProvider
    public int delete(@NonNull Uri uri, @Nullable String str, @Nullable String[] strArr) {
        z.a().d("HisavanaContentProvider", "delete ");
        try {
            UriMatcher uriMatcher = f29642c;
            if (uriMatcher != null && uriMatcher.match(uri) == 200) {
                if (str != null) {
                    return a(str);
                }
                if (strArr != null && strArr.length > 0) {
                    StringBuilder sb2 = new StringBuilder("(");
                    for (int i11 = 0; i11 < strArr.length; i11++) {
                        String str2 = "'";
                        if (i11 == strArr.length - 1) {
                            sb2.append("'");
                            sb2.append(strArr[i11]);
                        } else {
                            sb2.append("'");
                            sb2.append(strArr[i11]);
                            str2 = "',";
                        }
                        sb2.append(str2);
                    }
                    sb2.append(")");
                    String str3 = "DELETE FROM adList WHERE _id in " + ((Object) sb2);
                    h();
                    SQLiteDatabase sQLiteDatabase = this.f29643a;
                    if (sQLiteDatabase == null) {
                        return -1;
                    }
                    sQLiteDatabase.execSQL(str3);
                }
            }
        } catch (Exception e11) {
            z.a().e("HisavanaContentProvider", "delete " + Log.getStackTraceString(e11));
        }
        return 0;
    }

    public final boolean e(List<ConfigCodeSeatDTO> list) {
        z.a().d("HisavanaContentProvider", "insertOrUpdateConfig " + list);
        h();
        SQLiteDatabase sQLiteDatabase = this.f29643a;
        if (sQLiteDatabase == null) {
            return false;
        }
        sQLiteDatabase.execSQL("delete from cloudList where 1=1");
        return i(list);
    }

    public final boolean g(List<AdsDTO> list) {
        if (list == null || list.isEmpty()) {
            z.a().e("HisavanaContentProvider", "insertAdsList adList is null or empty");
            return false;
        }
        h();
        SQLiteDatabase sQLiteDatabase = this.f29643a;
        if (sQLiteDatabase == null) {
            return false;
        }
        try {
            sQLiteDatabase.beginTransaction();
            long jC = y.c(System.currentTimeMillis());
            for (AdsDTO adsDTO : list) {
                adsDTO.setShowDate(jC);
                String strD = GsonUtil.d(adsDTO);
                ContentValues contentValues = new ContentValues();
                contentValues.put("ad_creative_id", adsDTO.getAdCreativeId());
                contentValues.put("codeSeatId", adsDTO.getCodeSeatId());
                contentValues.put("file_path", adsDTO.getFilePath());
                contentValues.put(BidResponsed.KEY_PRICE, adsDTO.getFirstPrice());
                contentValues.put(TrackingKey.IS_OFFLINE_AD, Integer.valueOf(adsDTO.isOfflineAd() ? 1 : 0));
                contentValues.put("ad_request_ver", Integer.valueOf(adsDTO.getAdRequestVer()));
                contentValues.put("ad_bean", strD);
                this.f29643a.insert("adList", null, contentValues);
            }
            this.f29643a.setTransactionSuccessful();
            return true;
        } catch (Exception e11) {
            z.a().e("HisavanaContentProvider", "insert Config fail " + Log.getStackTraceString(e11));
            return false;
        } finally {
            c();
        }
    }

    @Override // android.content.ContentProvider
    @Nullable
    public String getType(@NonNull Uri uri) {
        return null;
    }

    public final SQLiteDatabase h() {
        if (this.f29643a == null) {
            this.f29643a = com.cloud.hisavana.sdk.y.f30223a.a();
        }
        return this.f29643a;
    }

    public final boolean i(List<ConfigCodeSeatDTO> list) {
        if (list == null || list.isEmpty()) {
            return false;
        }
        h();
        SQLiteDatabase sQLiteDatabase = this.f29643a;
        try {
            if (sQLiteDatabase == null) {
                return false;
            }
            sQLiteDatabase.beginTransaction();
            for (ConfigCodeSeatDTO configCodeSeatDTO : list) {
                String strD = GsonUtil.d(configCodeSeatDTO);
                ContentValues contentValues = new ContentValues();
                contentValues.put("codeSeatId", configCodeSeatDTO.getCodeSeatId());
                contentValues.put("code_seat_bean", strD);
                this.f29643a.insert("cloudList", null, contentValues);
            }
            this.f29643a.setTransactionSuccessful();
            return true;
        } catch (Exception e11) {
            z.a().e("HisavanaContentProvider", "insert Config fail " + Log.getStackTraceString(e11));
            return false;
        } finally {
            c();
        }
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) throws Throwable {
        boolean zJ;
        z zVarA = z.a();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("insert ");
        sb2.append(uri);
        sb2.append(" ");
        UriMatcher uriMatcher = f29642c;
        String str = "";
        sb2.append(uriMatcher != null ? Integer.valueOf(uriMatcher.match(uri)) : "");
        zVarA.d("HisavanaContentProvider", sb2.toString());
        boolean z11 = false;
        try {
            h();
            UriMatcher uriMatcher2 = f29642c;
            if (uriMatcher2 == null || uriMatcher2.match(uri) != 100) {
                UriMatcher uriMatcher3 = f29642c;
                if (uriMatcher3 == null || uriMatcher3.match(uri) != 200) {
                    z.a().d("HisavanaContentProvider", "insert,uri is wrong");
                } else {
                    str = "ad_data";
                    if (contentValues != null) {
                        String asString = contentValues.getAsString("AdsData");
                        if (!TextUtils.isEmpty(asString)) {
                            zJ = j((List) GsonUtil.b(asString, new b().getType()));
                            z11 = zJ;
                        }
                    }
                }
            } else {
                str = XLogUtil.TAG;
                if (contentValues != null) {
                    String asString2 = contentValues.getAsString("CloudConfig");
                    if (!TextUtils.isEmpty(asString2)) {
                        zJ = e((List) GsonUtil.b(asString2, new a().getType()));
                        z11 = zJ;
                    }
                }
            }
        } catch (Exception e11) {
            z.a().e("HisavanaContentProvider", Log.getStackTraceString(e11));
        }
        return Uri.parse("content://" + f29641b + "/" + str + "/" + z11);
    }

    public final boolean j(List<AdsDTO> list) throws Throwable {
        boolean zK;
        AdsDTO adsDTO;
        GsonUtil.GsonParseException e11;
        boolean z11 = false;
        if (list == null || list.isEmpty()) {
            z.a().d("HisavanaContentProvider", "insertOrUpdateAds list is null or empty");
            return false;
        }
        int size = list.size();
        String[] strArr = new String[size];
        for (int i11 = 0; i11 < size; i11++) {
            AdsDTO adsDTO2 = list.get(i11);
            if (adsDTO2 != null) {
                strArr[i11] = adsDTO2.getAdCreativeId();
            }
        }
        Cursor cursor = null;
        AdsDTO adsDTO3 = null;
        cursor = null;
        try {
            try {
                Cursor cursorB = b(strArr);
                try {
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    while (cursorB != null && cursorB.moveToNext()) {
                        int columnIndex = cursorB.getColumnIndex("ad_bean");
                        int columnIndex2 = cursorB.getColumnIndex("_id");
                        if (columnIndex >= 0) {
                            String string = cursorB.getString(columnIndex);
                            if (!TextUtils.isEmpty(string)) {
                                try {
                                    adsDTO = (AdsDTO) GsonUtil.a(string, AdsDTO.class);
                                    try {
                                        arrayList.add(adsDTO);
                                    } catch (GsonUtil.GsonParseException e12) {
                                        e11 = e12;
                                        z.a().e(Log.getStackTraceString(e11));
                                    }
                                } catch (GsonUtil.GsonParseException e13) {
                                    adsDTO = adsDTO3;
                                    e11 = e13;
                                }
                                adsDTO3 = adsDTO;
                            }
                        }
                        if (columnIndex2 >= 0) {
                            int i12 = cursorB.getInt(columnIndex2);
                            if (adsDTO3 != null) {
                                adsDTO3.setTableId(i12);
                            }
                        }
                    }
                    if (arrayList.isEmpty()) {
                        zK = true;
                    } else {
                        for (int i13 = size - 1; i13 >= 0; i13--) {
                            AdsDTO adsDTO4 = list.get(i13);
                            for (int i14 = 0; i14 < arrayList.size(); i14++) {
                                AdsDTO adsDTO5 = (AdsDTO) arrayList.get(i14);
                                if (d(adsDTO4, adsDTO5)) {
                                    adsDTO4.setShowDate(adsDTO5.getShowDate());
                                    adsDTO4.setShowNum(adsDTO5.getShowNum());
                                    adsDTO4.setTableId(adsDTO5.getTableId());
                                    list.remove(adsDTO4);
                                    arrayList2.add(adsDTO4);
                                    break;
                                }
                            }
                        }
                        zK = k(arrayList2);
                    }
                    if (g(list) && zK) {
                        z11 = true;
                    }
                    if (cursorB != null) {
                        cursorB.close();
                    }
                    return z11;
                } catch (Exception e14) {
                    e = e14;
                    cursor = cursorB;
                    z.a().e("HisavanaContentProvider", "getAdsListFromDB: " + e.getMessage());
                    if (cursor != null) {
                        cursor.close();
                    }
                    return false;
                } catch (Throwable th2) {
                    th = th2;
                    cursor = cursorB;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Exception e15) {
            e = e15;
        }
    }

    public final boolean k(List<AdsDTO> list) {
        if (list == null || list.isEmpty()) {
            z.a().d("HisavanaContentProvider", "updateAdsList list is empty ");
            return false;
        }
        z.a().d("HisavanaContentProvider", "updateAdsList size " + list.size());
        h();
        SQLiteDatabase sQLiteDatabase = this.f29643a;
        if (sQLiteDatabase == null) {
            return false;
        }
        try {
            sQLiteDatabase.beginTransaction();
            for (AdsDTO adsDTO : list) {
                String strD = GsonUtil.d(adsDTO);
                ContentValues contentValues = new ContentValues();
                contentValues.put("ad_bean", strD);
                contentValues.put("ad_request_ver", Integer.valueOf(adsDTO.getAdRequestVer()));
                int iUpdate = this.f29643a.update("adList", contentValues, "_id =?", new String[]{String.valueOf(adsDTO.getTableId())});
                z.a().d("HisavanaContentProvider", "updateAdsList result " + iUpdate);
            }
            this.f29643a.setTransactionSuccessful();
            return true;
        } catch (Exception e11) {
            z.a().e("HisavanaContentProvider", "insert Config fail " + Log.getStackTraceString(e11));
            return false;
        } finally {
            c();
        }
    }

    public final boolean l(List<ConfigCodeSeatDTO> list) {
        if (list == null || list.isEmpty()) {
            return false;
        }
        try {
            h();
            SQLiteDatabase sQLiteDatabase = this.f29643a;
            if (sQLiteDatabase == null) {
                return false;
            }
            sQLiteDatabase.beginTransaction();
            for (ConfigCodeSeatDTO configCodeSeatDTO : list) {
                String strD = GsonUtil.d(configCodeSeatDTO);
                ContentValues contentValues = new ContentValues();
                contentValues.put("codeSeatId", configCodeSeatDTO.getCodeSeatId());
                contentValues.put("code_seat_bean", strD);
                int iUpdate = this.f29643a.update("cloudList", contentValues, "codeSeatId=?", new String[]{configCodeSeatDTO.getCodeSeatId()});
                z.a().d("HisavanaContentProvider", "updateConfig result " + iUpdate);
            }
            this.f29643a.setTransactionSuccessful();
            return true;
        } catch (Exception e11) {
            z.a().e("HisavanaContentProvider", "update config fail" + Log.getStackTraceString(e11));
            return false;
        } finally {
            c();
        }
        c();
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        f.h(getContext());
        return false;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Cursor query(@NonNull Uri uri, @Nullable String[] strArr, @Nullable String str, @Nullable String[] strArr2, @Nullable String str2) {
        h();
        SQLiteDatabase sQLiteDatabase = this.f29643a;
        if (sQLiteDatabase == null) {
            return null;
        }
        try {
            return sQLiteDatabase.rawQuery(str, null);
        } catch (Exception e11) {
            z.a().e("HisavanaContentProvider", Log.getStackTraceString(e11));
            return null;
        }
    }

    @Override // android.content.ContentProvider
    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String str, @Nullable String[] strArr) {
        String asString;
        List<AdsDTO> list;
        List<ConfigCodeSeatDTO> list2;
        z.a().d("HisavanaContentProvider", "update " + contentValues);
        try {
            UriMatcher uriMatcher = f29642c;
            if (uriMatcher != null && uriMatcher.match(uri) == 100) {
                asString = contentValues != null ? contentValues.getAsString("CloudConfig") : null;
                if (TextUtils.isEmpty(asString) || (list2 = (List) GsonUtil.b(asString, new c().getType())) == null || list2.isEmpty()) {
                    return 0;
                }
                return l(list2) ? 1 : 0;
            }
            UriMatcher uriMatcher2 = f29642c;
            if (uriMatcher2 == null || uriMatcher2.match(uri) != 200) {
                return 0;
            }
            asString = contentValues != null ? contentValues.getAsString("AdsData") : null;
            if (TextUtils.isEmpty(asString) || (list = (List) GsonUtil.b(asString, new d().getType())) == null) {
                return 0;
            }
            return k(list) ? 1 : 0;
        } catch (Exception e11) {
            z.a().e("HisavanaContentProvider", "update " + Log.getStackTraceString(e11));
            return 0;
        }
    }
}
