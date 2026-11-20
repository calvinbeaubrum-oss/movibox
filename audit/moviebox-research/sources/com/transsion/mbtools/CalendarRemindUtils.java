package com.transsion.mbtools;

import android.app.Application;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.provider.CalendarContract;
import com.blankj.utilcode.util.PermissionUtils;
import com.blankj.utilcode.util.Utils;
import com.blankj.utilcode.util.z;
import com.google.gson.Gson;
import com.hisavana.common.tracking.TrackingKey;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.tencent.mmkv.MMKV;
import java.security.NoSuchAlgorithmException;
import java.util.HashSet;
import java.util.TimeZone;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.j;
import kotlinx.coroutines.j1;
import kotlinx.coroutines.w0;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class CalendarRemindUtils {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static HashSet<String> f53116b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CalendarRemindUtils f53115a = new CalendarRemindUtils();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f53117c = LazyKt__LazyJVMKt.b(new Function0<MMKV>() { // from class: com.transsion.mbtools.CalendarRemindUtils$mmkv$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final MMKV invoke() {
            return MMKV.z("kv_calendar");
        }
    });

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f53118d = LazyKt__LazyJVMKt.b(new Function0<String>() { // from class: com.transsion.mbtools.CalendarRemindUtils$md5Json$2
        @Override // kotlin.jvm.functions.Function0
        public final String invoke() {
            return CalendarRemindUtils.f53115a.h().getString("calendar_md5_list", "");
        }
    });

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements PermissionUtils.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0<Unit> f53119a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function0<Unit> f53120b;

        public a(Function0<Unit> function0, Function0<Unit> function1) {
            this.f53119a = function0;
            this.f53120b = function1;
        }

        @Override // com.blankj.utilcode.util.PermissionUtils.b
        public void a() {
            this.f53120b.invoke();
        }

        @Override // com.blankj.utilcode.util.PermissionUtils.b
        public void onGranted() {
            this.f53119a.invoke();
        }
    }

    public final void d(final CalendarBean bean, final Function0<Unit> success, final Function1<? super String, Unit> error) {
        String title;
        Intrinsics.g(bean, "bean");
        Intrinsics.g(success, "success");
        Intrinsics.g(error, "error");
        if (i(bean)) {
            error.invoke("Appointment has added");
            return;
        }
        if (bean.getStartTime() != null && bean.getEndTime() != null && (title = bean.getTitle()) != null && title.length() != 0) {
            e(new Function0<Unit>() { // from class: com.transsion.mbtools.CalendarRemindUtils$addAppointment$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() throws NoSuchAlgorithmException {
                    invoke2();
                    return Unit.f68710a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() throws NoSuchAlgorithmException {
                    String lastPathSegment;
                    CalendarRemindUtils calendarRemindUtils = CalendarRemindUtils.f53115a;
                    Long lF = calendarRemindUtils.f();
                    ContentValues contentValues = new ContentValues();
                    CalendarBean calendarBean = bean;
                    String id2 = TimeZone.getDefault().getID();
                    contentValues.put("dtstart", calendarBean.getStartTime());
                    contentValues.put("dtend", calendarBean.getEndTime());
                    contentValues.put(CampaignEx.JSON_KEY_TITLE, calendarBean.getTitle());
                    contentValues.put(TrackingKey.DESCRIPTION, calendarBean.getDes());
                    contentValues.put("eventLocation", calendarBean.getLocation());
                    contentValues.put("calendar_id", lF);
                    String timeZone = calendarBean.getTimeZone();
                    if (timeZone == null) {
                        timeZone = id2;
                    }
                    contentValues.put("eventTimezone", timeZone);
                    String endTimeZone = calendarBean.getEndTimeZone();
                    if (endTimeZone != null) {
                        id2 = endTimeZone;
                    }
                    contentValues.put("eventEndTimezone", id2);
                    contentValues.put("hasAlarm", (Integer) 1);
                    Application applicationA = Utils.a();
                    Uri uriInsert = applicationA.getContentResolver().insert(CalendarContract.Events.CONTENT_URI, contentValues);
                    if (uriInsert != null && (lastPathSegment = uriInsert.getLastPathSegment()) != null) {
                        CalendarBean calendarBean2 = bean;
                        ContentValues contentValues2 = new ContentValues();
                        Integer remindTime = calendarBean2.getRemindTime();
                        contentValues2.put("minutes", Integer.valueOf(remindTime != null ? remindTime.intValue() : 0));
                        contentValues2.put("event_id", lastPathSegment);
                        contentValues2.put("method", (Integer) 1);
                        applicationA.getContentResolver().insert(CalendarContract.Reminders.CONTENT_URI, contentValues2);
                    }
                    String strA = MD5HashProvider.f53123a.a(bean.toString());
                    success.invoke();
                    HashSet hashSet = CalendarRemindUtils.f53116b;
                    if (hashSet != null) {
                        hashSet.add(strA);
                    }
                    calendarRemindUtils.k();
                }
            }, new Function0<Unit>() { // from class: com.transsion.mbtools.CalendarRemindUtils$addAppointment$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.f68710a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    error.invoke("checkPermission-onDenied");
                }
            });
            return;
        }
        error.invoke("bean is null, startTime:" + bean.getStartTime() + ",endTime:" + bean.getEndTime() + ", title:" + bean.getTitle());
    }

    public final void e(Function0<Unit> function0, Function0<Unit> function1) {
        if (PermissionUtils.s("android.permission.WRITE_CALENDAR", "android.permission.READ_CALENDAR")) {
            function0.invoke();
        } else {
            PermissionUtils.x("android.permission.WRITE_CALENDAR", "android.permission.READ_CALENDAR").m(new a(function0, function1)).y();
        }
    }

    public final Long f() {
        Cursor cursorQuery = Utils.a().getContentResolver().query(CalendarContract.Calendars.CONTENT_URI, new String[]{"_id", "calendar_displayName"}, "visible = 1 AND sync_events = 1", null, null);
        if (cursorQuery != null) {
            long j11 = -1;
            while (cursorQuery.moveToNext()) {
                try {
                    long j12 = cursorQuery.getLong(0);
                    if (z.b(cursorQuery.getString(1))) {
                        j11 = j12;
                    }
                } catch (Throwable th2) {
                    try {
                        throw th2;
                    } catch (Throwable th3) {
                        CloseableKt.a(cursorQuery, th2);
                        throw th3;
                    }
                }
            }
            if (j11 > 0) {
                Long lValueOf = Long.valueOf(j11);
                CloseableKt.a(cursorQuery, null);
                return lValueOf;
            }
            if (cursorQuery.moveToFirst()) {
                Long lValueOf2 = Long.valueOf(cursorQuery.getLong(0));
                CloseableKt.a(cursorQuery, null);
                return lValueOf2;
            }
            Unit unit = Unit.f68710a;
            CloseableKt.a(cursorQuery, null);
        }
        return null;
    }

    public final String g() {
        return (String) f53118d.getValue();
    }

    public final MMKV h() {
        Object value = f53117c.getValue();
        Intrinsics.f(value, "<get-mmkv>(...)");
        return (MMKV) value;
    }

    public final boolean i(CalendarBean bean) throws NoSuchAlgorithmException {
        Intrinsics.g(bean, "bean");
        j();
        String strA = MD5HashProvider.f53123a.a(bean.toString());
        HashSet<String> hashSet = f53116b;
        return hashSet != null && hashSet.contains(strA);
    }

    public final void j() {
        Object objM163constructorimpl;
        if (f53116b == null) {
            try {
                Result.Companion companion = Result.Companion;
                objM163constructorimpl = Result.m163constructorimpl((HashSet) new Gson().fromJson(f53115a.g(), HashSet.class));
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                objM163constructorimpl = Result.m163constructorimpl(ResultKt.a(th2));
            }
            if (Result.m169isFailureimpl(objM163constructorimpl)) {
                objM163constructorimpl = null;
            }
            HashSet<String> hashSet = (HashSet) objM163constructorimpl;
            if (hashSet == null) {
                hashSet = new HashSet<>();
            }
            f53116b = hashSet;
            String strG = g();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("md5Json：");
            sb2.append(strG);
        }
    }

    public final void k() {
        j.d(j1.f69500a, w0.b(), null, new CalendarRemindUtils$saveMd5$1(null), 2, null);
    }
}
