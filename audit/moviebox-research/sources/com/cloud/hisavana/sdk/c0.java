package com.cloud.hisavana.sdk;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.cloud.hisavana.sdk.api.config.AdManager;
import com.cloud.hisavana.sdk.data.bean.inapp.DefaultAdDTO;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c0 f29205a = new c0();

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a extends Lambda implements Function1<String, CharSequence> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f29206a = new a();

        public a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final CharSequence invoke(String it) {
            Intrinsics.g(it, "it");
            return '\'' + it + '\'';
        }
    }

    public static final void i(int i11, String displayedDate, String adCreativeId, String codeSeatId) {
        Intrinsics.g(displayedDate, "$displayedDate");
        Intrinsics.g(adCreativeId, "$adCreativeId");
        Intrinsics.g(codeSeatId, "$codeSeatId");
        try {
            String str = "UPDATE default_ad SET displayed_times = " + i11 + " , displayed_date = '" + displayedDate + "'  WHERE ad_creative_id = " + adCreativeId + " AND codeSeatId = '" + codeSeatId + '\'';
            SQLiteDatabase sQLiteDatabaseA = y.f30223a.a();
            if (sQLiteDatabaseA != null) {
                sQLiteDatabaseA.execSQL(str);
            }
        } catch (Exception e11) {
            z.a().w("DefaultDBManager", "update display times error: id is " + adCreativeId + ", error msg is " + e11.getMessage());
        }
    }

    public static final void q(int i11) {
        try {
            String str = "DELETE FROM default_ad WHERE  ad_request_ver < " + i11;
            SQLiteDatabase sQLiteDatabaseA = y.f30223a.a();
            if (sQLiteDatabaseA != null) {
                sQLiteDatabaseA.execSQL(str);
            }
        } catch (Exception unused) {
            z.a().w("DefaultDBManager", "delete old data by ad version failed ");
        }
    }

    public static final void r(DefaultAdDTO ad2) {
        Intrinsics.g(ad2, "$ad");
        try {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("INSERT OR REPLACE INTO default_ad (ad_creative_id,codeSeatId, ad_type, price, ad_request_ver, start_date, end_date, display_max_times, file_path, default_country_white, default_country_black, default_brand_white, default_brand_black, ad_bean) VALUES (");
            sb2.append(ad2.getAdCreativeId());
            sb2.append(", '");
            String codeSeatId = ad2.getCodeSeatId();
            String str = "";
            if (codeSeatId == null) {
                codeSeatId = "";
            }
            sb2.append(codeSeatId);
            sb2.append("', ");
            sb2.append(ad2.getAdType());
            sb2.append(", ");
            sb2.append(ad2.getFirstPrice());
            sb2.append(", ");
            sb2.append(ad2.getAdRequestVersion());
            sb2.append(", '");
            String startDate = ad2.getStartDate();
            if (startDate == null) {
                startDate = "";
            }
            sb2.append(startDate);
            sb2.append("', '");
            String endDate = ad2.getEndDate();
            if (endDate == null) {
                endDate = "";
            }
            sb2.append(endDate);
            sb2.append("', ");
            sb2.append(ad2.getShowMaxOfDay());
            sb2.append(", '");
            sb2.append(ad2.getFilePath());
            sb2.append("', '");
            String countryWhite = ad2.getCountryWhite();
            if (countryWhite == null) {
                countryWhite = "";
            }
            sb2.append(countryWhite);
            sb2.append("', '");
            String countryBlack = ad2.getCountryBlack();
            if (countryBlack == null) {
                countryBlack = "";
            }
            sb2.append(countryBlack);
            sb2.append("', '");
            String brandWhite = ad2.getBrandWhite();
            if (brandWhite == null) {
                brandWhite = "";
            }
            sb2.append(brandWhite);
            sb2.append("', '");
            String brandBlack = ad2.getBrandBlack();
            if (brandBlack == null) {
                brandBlack = "";
            }
            sb2.append(brandBlack);
            sb2.append("', '");
            String adBeanJson = ad2.getAdBeanJson();
            if (adBeanJson != null) {
                str = adBeanJson;
            }
            sb2.append(str);
            sb2.append("');");
            String string = sb2.toString();
            if (AdManager.h()) {
                z.a().d("DefaultDBManager", string);
            }
            SQLiteDatabase sQLiteDatabaseA = y.f30223a.a();
            if (sQLiteDatabaseA != null) {
                sQLiteDatabaseA.execSQL(string);
            }
        } catch (Throwable th2) {
            z.a().w("DefaultDBManager", "save or update default ad error: id is " + ad2.getAdCreativeId() + ", error msg is " + th2.getMessage() + ' ');
        }
    }

    public static final void s(String codeSeatId) {
        Intrinsics.g(codeSeatId, "$codeSeatId");
        z.a().d("DefaultDBManager", "delete old data by code seat id");
        try {
            String str = "DELETE FROM default_ad WHERE codeSeatId = '" + codeSeatId + "' AND ad_request_ver <  (SELECT MAX(ad_request_ver)  FROM default_ad  WHERE codeSeatId = '" + codeSeatId + "'); ";
            SQLiteDatabase sQLiteDatabaseA = y.f30223a.a();
            if (sQLiteDatabaseA != null) {
                sQLiteDatabaseA.execSQL(str);
            }
        } catch (Throwable th2) {
            z.a().w("DefaultDBManager", "delete old ad : error msg is " + th2.getMessage());
        }
    }

    public static final void t(String filepath, String adCreativeId, String codeSeatId) {
        Intrinsics.g(filepath, "$filepath");
        Intrinsics.g(adCreativeId, "$adCreativeId");
        Intrinsics.g(codeSeatId, "$codeSeatId");
        try {
            String str = "UPDATE default_ad SET file_path = '" + filepath + "'  WHERE ad_creative_id = " + adCreativeId + " AND codeSeatId = '" + codeSeatId + "';";
            SQLiteDatabase sQLiteDatabaseA = y.f30223a.a();
            if (sQLiteDatabaseA != null) {
                sQLiteDatabaseA.execSQL(str);
            }
        } catch (Exception e11) {
            z.a().w("DefaultDBManager", "update ad material file path error: " + e11.getMessage());
        }
    }

    public static final void u(Function2 queryComplete) {
        Cursor cursorRawQuery;
        Intrinsics.g(queryComplete, "$queryComplete");
        try {
            SQLiteDatabase sQLiteDatabaseA = y.f30223a.a();
            if (sQLiteDatabaseA == null || (cursorRawQuery = sQLiteDatabaseA.rawQuery("SELECT * FROM default_ad;", null)) == null) {
                return;
            }
            try {
                queryComplete.invoke(cursorRawQuery, Boolean.TRUE);
                Unit unit = Unit.f68710a;
                CloseableKt.a(cursorRawQuery, null);
            } catch (Throwable th2) {
                try {
                    throw th2;
                } catch (Throwable th3) {
                    CloseableKt.a(cursorRawQuery, th2);
                    throw th3;
                }
            }
        } catch (Exception e11) {
            z.a().w("DefaultDBManager", "query default data failed :" + e11.getMessage());
            queryComplete.invoke(null, Boolean.FALSE);
        }
    }

    public static final void w(String filePath) {
        Intrinsics.g(filePath, "$filePath");
        try {
            String str = "UPDATE default_ad SET file_path = '' WHERE file_path LIKE '%" + filePath + ".0'; ";
            SQLiteDatabase sQLiteDatabaseA = y.f30223a.a();
            if (sQLiteDatabaseA != null) {
                sQLiteDatabaseA.execSQL(str);
            }
        } catch (Throwable th2) {
            z.a().w("DefaultDBManager", "update material  error: error msg is " + th2.getMessage());
        }
    }

    public final void h(final int i11) {
        com.cloud.sdk.commonutil.util.i.f30292a.b(new Runnable() { // from class: com.cloud.hisavana.sdk.l
            @Override // java.lang.Runnable
            public final void run() {
                c0.q(i11);
            }
        });
    }

    public final void j(final DefaultAdDTO ad2) {
        Intrinsics.g(ad2, "ad");
        com.cloud.sdk.commonutil.util.i.f30292a.b(new Runnable() { // from class: com.cloud.hisavana.sdk.m
            @Override // java.lang.Runnable
            public final void run() {
                c0.r(ad2);
            }
        });
    }

    public final void k(final String codeSeatId) {
        Intrinsics.g(codeSeatId, "codeSeatId");
        com.cloud.sdk.commonutil.util.i.f30292a.b(new Runnable() { // from class: com.cloud.hisavana.sdk.p
            @Override // java.lang.Runnable
            public final void run() {
                c0.s(codeSeatId);
            }
        });
    }

    public final void l(String creativeId, String str) {
        Intrinsics.g(creativeId, "creativeId");
        try {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("DELETE FROM default_ad WHERE (ad_creative_id = ");
            sb2.append(creativeId);
            sb2.append(" AND codeSeatId = '");
            if (str == null) {
                str = "";
            }
            sb2.append(str);
            sb2.append("')");
            String string = sb2.toString();
            z.a().d("DefaultDBManager", "deleteAdByFiltered----> " + string);
            SQLiteDatabase sQLiteDatabaseA = y.f30223a.a();
            if (sQLiteDatabaseA != null) {
                sQLiteDatabaseA.execSQL(string);
            }
        } catch (Exception e11) {
            z.a().w("DefaultDBManager", "delete ad by filtered error: id is " + creativeId + ", error msg is " + e11.getMessage());
        }
    }

    public final void m(final String adCreativeId, final String codeSeatId, final int i11, final String displayedDate) {
        Intrinsics.g(adCreativeId, "adCreativeId");
        Intrinsics.g(codeSeatId, "codeSeatId");
        Intrinsics.g(displayedDate, "displayedDate");
        com.cloud.sdk.commonutil.util.i.f30292a.b(new Runnable() { // from class: com.cloud.hisavana.sdk.k
            @Override // java.lang.Runnable
            public final void run() {
                c0.i(i11, displayedDate, adCreativeId, codeSeatId);
            }
        });
    }

    public final void n(final String adCreativeId, final String codeSeatId, final String filepath) {
        Intrinsics.g(adCreativeId, "adCreativeId");
        Intrinsics.g(codeSeatId, "codeSeatId");
        Intrinsics.g(filepath, "filepath");
        com.cloud.sdk.commonutil.util.i.f30292a.b(new Runnable() { // from class: com.cloud.hisavana.sdk.o
            @Override // java.lang.Runnable
            public final void run() {
                c0.t(filepath, adCreativeId, codeSeatId);
            }
        });
    }

    public final void o(List<String> codeSeatIds) {
        Intrinsics.g(codeSeatIds, "codeSeatIds");
        try {
            String str = "DELETE FROM default_ad WHERE codeSeatId NOT IN (" + CollectionsKt___CollectionsKt.o0(codeSeatIds, ", ", null, null, 0, null, a.f29206a, 30, null) + ");";
            SQLiteDatabase sQLiteDatabaseA = y.f30223a.a();
            if (sQLiteDatabaseA != null) {
                sQLiteDatabaseA.execSQL(str);
            }
        } catch (Throwable th2) {
            z.a().w("DefaultDBManager", "delete invalid ad error: error msg is " + th2.getMessage());
        }
    }

    public final void p(final Function2<? super Cursor, ? super Boolean, Unit> queryComplete) {
        Intrinsics.g(queryComplete, "queryComplete");
        com.cloud.sdk.commonutil.util.i.f30292a.b(new Runnable() { // from class: com.cloud.hisavana.sdk.r
            @Override // java.lang.Runnable
            public final void run() {
                c0.u(queryComplete);
            }
        });
    }

    public final void v(final String filePath) {
        Intrinsics.g(filePath, "filePath");
        com.cloud.sdk.commonutil.util.i.f30292a.b(new Runnable() { // from class: com.cloud.hisavana.sdk.q
            @Override // java.lang.Runnable
            public final void run() {
                c0.w(filePath);
            }
        });
    }
}
