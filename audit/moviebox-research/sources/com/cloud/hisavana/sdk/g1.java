package com.cloud.hisavana.sdk;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import android.util.Log;
import com.cloud.hisavana.sdk.common.bean.DiskTrackingBean;
import com.cloud.sdk.commonutil.gsonutil.GsonUtil;
import com.google.gson.reflect.TypeToken;
import com.google.logging.type.LogSeverity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

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
@SourceDebugExtension
public final class g1 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f29717e = new a(null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final g1 f29718f = new g1();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f29719a = 172800000;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f29720b = LogSeverity.WARNING_VALUE;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f29721c = 500;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f29722d = "RetryTrackingDbManager";

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final g1 a() {
            return g1.f29718f;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b extends TypeToken<List<? extends DiskTrackingBean>> {
    }

    public static final void d(DiskTrackingBean diskTrackingBean, g1 this$0) {
        Intrinsics.g(this$0, "this$0");
        if (diskTrackingBean != null) {
            try {
                SQLiteDatabase sQLiteDatabaseA = y.f30223a.a();
                if (sQLiteDatabaseA != null) {
                    sQLiteDatabaseA.update("retry_tracking_table", this$0.b(diskTrackingBean), "uuid=?", new String[]{diskTrackingBean.getUuid()});
                }
            } catch (Exception e11) {
                z.a().e(this$0.f29722d, "updateTrackingBean " + Log.getStackTraceString(e11));
            }
        }
    }

    public final ContentValues b(DiskTrackingBean diskTrackingBean) {
        ContentValues contentValues = new ContentValues();
        String strD = GsonUtil.d(diskTrackingBean);
        contentValues.put("uuid", diskTrackingBean.getUuid());
        contentValues.put("tracking_data", strD);
        contentValues.put("create_time", Long.valueOf(diskTrackingBean.getCreateTime()));
        contentValues.put("retry_times", Integer.valueOf(diskTrackingBean.getRetryTimes().get()));
        contentValues.put("md5", diskTrackingBean.getMd5());
        return contentValues;
    }

    public final void e(String uuid) {
        Intrinsics.g(uuid, "uuid");
        try {
            SQLiteDatabase sQLiteDatabaseA = y.f30223a.a();
            if (sQLiteDatabaseA != null) {
                sQLiteDatabaseA.delete("retry_tracking_table", "uuid = ?", new String[]{uuid});
            }
        } catch (Exception e11) {
            z.a().e(this.f29722d, "deleteByUUID " + Log.getStackTraceString(e11));
        }
    }

    public final void f(List<String> list) {
        StringBuilder sb2 = new StringBuilder();
        if (list != null) {
            int i11 = 0;
            for (Object obj : list) {
                int i12 = i11 + 1;
                if (i11 < 0) {
                    kotlin.collections.g.u();
                }
                sb2.append("'");
                sb2.append((String) obj);
                sb2.append("'");
                if (i11 != kotlin.collections.g.n(list)) {
                    sb2.append(",");
                }
                i11 = i12;
            }
        }
        if (TextUtils.isEmpty(sb2)) {
            return;
        }
        String str = "DELETE FROM retry_tracking_table WHERE uuid in (" + ((Object) sb2) + ')';
        SQLiteDatabase sQLiteDatabaseA = y.f30223a.a();
        if (sQLiteDatabaseA != null) {
            sQLiteDatabaseA.execSQL(str);
        }
        z.a().d(this.f29722d, "deleteByUUIDs ," + ((Object) sb2) + ' ');
    }

    /* JADX WARN: Code duplicated, block: B:45:0x009a  */
    public final DiskTrackingBean g(String uuid) throws Throwable {
        Cursor cursor;
        Intrinsics.g(uuid, "uuid");
        Cursor cursor2 = null;
        try {
            SQLiteDatabase sQLiteDatabaseA = y.f30223a.a();
            Cursor cursorQuery = sQLiteDatabaseA != null ? sQLiteDatabaseA.query("retry_tracking_table", new String[]{"tracking_data"}, "uuid = ?", new String[]{uuid}, null, null, null, null) : null;
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.moveToNext()) {
                        if (cursorQuery.getColumnCount() <= 0) {
                            cursorQuery.close();
                            return null;
                        }
                        int columnIndex = cursorQuery.getColumnIndex("tracking_data");
                        if (columnIndex < 0) {
                            cursorQuery.close();
                            return null;
                        }
                        String string = cursorQuery.getString(columnIndex);
                        if (TextUtils.isEmpty(string)) {
                            cursorQuery.close();
                            return null;
                        }
                        DiskTrackingBean diskTrackingBean = (DiskTrackingBean) GsonUtil.a(string, DiskTrackingBean.class);
                        cursorQuery.close();
                        return diskTrackingBean;
                    }
                } catch (Exception e11) {
                    cursor = cursorQuery;
                    e = e11;
                    try {
                        z.a().e(this.f29722d, "queryByMd5 " + Log.getStackTraceString(e));
                        if (cursor != null) {
                            cursorQuery = cursor;
                            cursorQuery.close();
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        cursor2 = cursor;
                        if (cursor2 != null) {
                            cursor2.close();
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    cursor2 = cursorQuery;
                    th = th3;
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    throw th;
                }
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        } catch (Exception e12) {
            e = e12;
            cursor = null;
        } catch (Throwable th4) {
            th = th4;
        }
        return null;
    }

    public final void h() {
        SQLiteDatabase sQLiteDatabaseA = y.f30223a.a();
        if (sQLiteDatabaseA != null) {
            sQLiteDatabaseA.delete("retry_tracking_table", "create_time <? ", new String[]{String.valueOf(System.currentTimeMillis() - this.f29719a)});
        }
    }

    public final void i(DiskTrackingBean diskTrackingBean) {
        if (diskTrackingBean != null) {
            try {
                SQLiteDatabase sQLiteDatabaseA = y.f30223a.a();
                if (sQLiteDatabaseA != null) {
                    sQLiteDatabaseA.insert("retry_tracking_table", null, b(diskTrackingBean));
                }
            } catch (Exception e11) {
                z.a().e(this.f29722d, "saveTrackingBean " + Log.getStackTraceString(e11));
            }
        }
    }

    public final List<DiskTrackingBean> j(String str) throws GsonUtil.GsonParseException {
        SQLiteDatabase sQLiteDatabaseA = y.f30223a.a();
        Cursor cursorQuery = sQLiteDatabaseA != null ? sQLiteDatabaseA.query("retry_tracking_table", new String[]{"tracking_data"}, null, null, null, null, null, str) : null;
        ArrayList arrayList = new ArrayList();
        while (cursorQuery != null && cursorQuery.moveToNext()) {
            String json = cursorQuery.getString(0);
            Intrinsics.f(json, "json");
            arrayList.add(json);
        }
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        if (!(!arrayList.isEmpty())) {
            return new ArrayList();
        }
        Object objB = GsonUtil.b(arrayList.toString(), new b().getType());
        Intrinsics.f(objB, "fromJson(jsonList.toString(), type)");
        return (List) objB;
    }

    public final void k() {
        try {
            SQLiteDatabase sQLiteDatabaseA = y.f30223a.a();
            int count = 0;
            Cursor cursorQuery = sQLiteDatabaseA != null ? sQLiteDatabaseA.query("retry_tracking_table", new String[]{"tracking_data"}, null, null, null, null, null) : null;
            if ((cursorQuery != null ? cursorQuery.getCount() : 0) >= this.f29721c && cursorQuery != null) {
                count = cursorQuery.getCount() - this.f29720b;
            }
            z zVarA = z.a();
            String str = this.f29722d;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("deleteTrackingBeanToSafeSpace count : ");
            sb2.append(count);
            sb2.append(",query?.count : ");
            sb2.append(cursorQuery != null ? Integer.valueOf(cursorQuery.getCount()) : null);
            sb2.append(' ');
            zVarA.e(str, sb2.toString());
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            if (count > 0) {
                List<DiskTrackingBean> listJ = j(String.valueOf(count));
                ArrayList arrayList = new ArrayList();
                Iterator<T> it = listJ.iterator();
                while (it.hasNext()) {
                    arrayList.add(((DiskTrackingBean) it.next()).getUuid());
                }
                f(arrayList);
            }
        } catch (Exception e11) {
            z.a().e(this.f29722d, "deleteTrackingBeanToSafeSpace " + Log.getStackTraceString(e11));
        }
    }

    public final void l(final DiskTrackingBean diskTrackingBean) {
        com.cloud.sdk.commonutil.util.i.f30292a.b(new Runnable() { // from class: com.cloud.hisavana.sdk.p0
            @Override // java.lang.Runnable
            public final void run() {
                g1.d(diskTrackingBean, this);
            }
        });
    }

    public final List<DiskTrackingBean> m() {
        try {
            h();
            return n();
        } catch (Exception e11) {
            z.a().e(this.f29722d, "getAllTrackingBeans " + Log.getStackTraceString(e11));
            return new ArrayList();
        }
    }

    public final List<DiskTrackingBean> n() {
        return j(null);
    }
}
