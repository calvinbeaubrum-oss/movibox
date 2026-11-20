package com.transsion.home.adapter.suboperate.adapter;

import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.CalendarContract;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.FragmentActivity;
import com.alibaba.android.arouter.facade.Postcard;
import com.blankj.utilcode.util.Utils;
import com.blankj.utilcode.util.z;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.hisavana.common.tracking.TrackingKey;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.tencent.mmkv.MMKV;
import com.transsion.baseui.image.ImageHelper;
import com.transsion.home.R$id;
import com.transsion.home.R$layout;
import com.transsion.home.R$string;
import com.transsion.home.fragment.tab.SubTabFragment;
import com.transsion.moviedetailapi.SubjectType;
import com.transsion.moviedetailapi.bean.AppointSubject;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.OperateItem;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsnet.downloader.DownloadManagerApi;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class SubAppointmentAdapter extends BaseQuickAdapter<AppointSubject, BaseViewHolder> {
    public final Function1<Function1<? super Boolean, Unit>, Unit> H;
    public final int I;
    public final OperateItem J;
    public final MMKV K;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public SubAppointmentAdapter(int i11, Function1<? super Function1<? super Boolean, Unit>, Unit> onAppointmentCLick, int i12, OperateItem operateItem) {
        super(i11, null, 2, null);
        Intrinsics.g(onAppointmentCLick, "onAppointmentCLick");
        Intrinsics.g(operateItem, "operateItem");
        this.H = onAppointmentCLick;
        this.I = i12;
        this.J = operateItem;
        MMKV mmkvZ = MMKV.z("kv_app_home_appointment");
        Intrinsics.f(mmkvZ, "mmkvWithID(\"kv_app_home_appointment\")");
        this.K = mmkvZ;
    }

    public /* synthetic */ SubAppointmentAdapter(int i11, Function1 function1, int i12, OperateItem operateItem, int i13, DefaultConstructorMarker defaultConstructorMarker) {
        this((i13 & 1) != 0 ? R$layout.item_sub_operation_appointment_item : i11, function1, i12, operateItem);
    }

    public static final void P0(SubAppointmentAdapter this$0, AppointSubject item, int i11, boolean z11, View view) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(item, "$item");
        this$0.W0(item);
        this$0.b1(false, item, i11, "click_appointment_poster", z11);
    }

    private final void W0(Subject subject) {
        Integer subjectType = subject.getSubjectType();
        int value = SubjectType.SHORT_TV.getValue();
        if (subjectType == null || subjectType.intValue() != value) {
            Postcard postcardB = com.alibaba.android.arouter.launcher.a.d().b("/movie/detail");
            Integer subjectType2 = subject.getSubjectType();
            postcardB.withInt("subject_type", subjectType2 != null ? subjectType2.intValue() : SubjectType.MOVIE.getValue()).withString("id", subject.getSubjectId()).withString("module_name", "opt_sub_appointment").withString("ops", subject.getOps()).navigation();
        } else {
            DownloadManagerApi downloadManagerApiA = DownloadManagerApi.f60274j.a();
            Context context = getContext();
            Intrinsics.e(context, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
            downloadManagerApiA.a2((FragmentActivity) context, SubTabFragment.f52541r.a(this.I), (384 & 4) != 0 ? "" : "", subject.getOps(), (384 & 16) != 0 ? null : "opt_sub_appointment", (384 & 32) != 0 ? false : false, (384 & 64) != 0 ? null : subject, (384 & 128) != 0 ? null : null, (384 & 256) != 0 ? Boolean.FALSE : null);
        }
    }

    public static final void Y0(int i11, SubAppointmentAdapter this$0, BaseViewHolder holder, AppointSubject item, int i12, boolean z11, View view) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(holder, "$holder");
        Intrinsics.g(item, "$item");
        if (com.transsion.baseui.util.c.f51452a.a(i11, AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS)) {
            return;
        }
        this$0.a1(holder, item, false);
        this$0.b1(false, item, i12, "click_appointment_cancel", z11);
    }

    public static final void Z0(int i11, SubAppointmentAdapter this$0, BaseViewHolder holder, AppointSubject item, int i12, boolean z11, View view) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(holder, "$holder");
        Intrinsics.g(item, "$item");
        if (com.transsion.baseui.util.c.f51452a.a(i11, AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS)) {
            return;
        }
        this$0.a1(holder, item, true);
        this$0.b1(false, item, i12, "click_appointment_add", z11);
    }

    public final void M0(AppointSubject appointSubject, BaseViewHolder baseViewHolder) {
        Date date;
        String lastPathSegment;
        String lastPathSegment2;
        Uri uriInsert = null;
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
            String appointmentDate = appointSubject.getAppointmentDate();
            if (appointmentDate == null) {
                appointmentDate = "";
            }
            date = simpleDateFormat.parse(appointmentDate);
        } catch (Exception e11) {
            e11.printStackTrace();
            date = null;
        }
        if (date == null) {
            return;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(11, 18);
        long timeInMillis = calendar.getTimeInMillis();
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(date);
        calendar2.set(11, 19);
        long timeInMillis2 = calendar2.getTimeInMillis();
        Long lU0 = U0();
        ContentValues contentValues = new ContentValues();
        contentValues.put("dtstart", Long.valueOf(timeInMillis));
        contentValues.put("dtend", Long.valueOf(timeInMillis2));
        contentValues.put(CampaignEx.JSON_KEY_TITLE, T0(appointSubject));
        contentValues.put(TrackingKey.DESCRIPTION, S0(appointSubject));
        contentValues.put("calendar_id", lU0);
        contentValues.put("eventTimezone", TimeZone.getDefault().getID());
        contentValues.put("hasAlarm", (Integer) 1);
        try {
            uriInsert = getContext().getContentResolver().insert(CalendarContract.Events.CONTENT_URI, contentValues);
        } catch (Throwable unused) {
        }
        if (uriInsert != null && (lastPathSegment2 = uriInsert.getLastPathSegment()) != null) {
            ContentValues contentValues2 = new ContentValues();
            contentValues2.put("minutes", (Integer) 0);
            contentValues2.put("event_id", lastPathSegment2);
            contentValues2.put("method", (Integer) 1);
            try {
                getContext().getContentResolver().insert(CalendarContract.Reminders.CONTENT_URI, contentValues2);
            } catch (Throwable unused2) {
                Unit unit = Unit.f68710a;
            }
        }
        this.K.putLong(appointSubject.getSubjectId(), (uriInsert == null || (lastPathSegment = uriInsert.getLastPathSegment()) == null) ? -1L : Long.parseLong(lastPathSegment));
        N0(true, baseViewHolder);
        c1(R$string.appointment_add_success);
        b1(false, appointSubject, com.transsion.baselib.utils.i.b(D(), appointSubject), "click_appointment_alert_success", true);
    }

    public final void N0(boolean z11, BaseViewHolder baseViewHolder) {
        View view = baseViewHolder.getView(R$id.sub_operation_appointment_unchecked);
        View view2 = baseViewHolder.getView(R$id.sub_operation_appointment_checked);
        if (z11) {
            so.c.h(view);
            so.c.k(view2);
        } else {
            so.c.k(view);
            so.c.h(view2);
        }
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* JADX INFO: renamed from: O0, reason: merged with bridge method [inline-methods] */
    public void x(BaseViewHolder holder, final AppointSubject item) {
        String thumbnail;
        String url;
        Intrinsics.g(holder, "holder");
        Intrinsics.g(item, "item");
        TextView textView = (TextView) holder.getView(R$id.sub_operation_appointment_corner);
        ImageView imageView = (ImageView) holder.getView(R$id.sub_operation_appointment_image);
        TextView textView2 = (TextView) holder.getView(R$id.sub_operation_appointment_item_title);
        TextView textView3 = (TextView) holder.getView(R$id.sub_operation_appointment_booked);
        View view = holder.getView(R$id.sub_operation_appointment_booked_layout);
        View view2 = holder.getView(R$id.sub_operation_appointment_booked_hot);
        Q0(textView, item);
        ImageHelper.Companion companion = ImageHelper.f51371a;
        Context context = getContext();
        Cover cover = item.getCover();
        String str = (cover == null || (url = cover.getUrl()) == null) ? "" : url;
        Cover cover2 = item.getCover();
        companion.q(context, imageView, str, (8120 & 8) != 0 ? companion.d() : 0, (8120 & 16) != 0 ? companion.c() : 0, (8120 & 32) != 0, (8120 & 64) != 0 ? "" : (cover2 == null || (thumbnail = cover2.getThumbnail()) == null) ? "" : thumbnail, (8120 & 128) != 0, (8120 & 256) != 0, (8120 & 512) != 0 ? false : false, (8120 & 1024) != 0 ? false : false, (8120 & 2048) != 0 ? false : false, (8120 & 4096) != 0 ? 25 : 0);
        textView2.setText(item.getTitle());
        Long appointmentCnt = item.getAppointmentCnt();
        if ((appointmentCnt != null ? appointmentCnt.longValue() : 0L) > 0) {
            NumberFormat numberInstance = NumberFormat.getNumberInstance(Locale.US);
            Long appointmentCnt2 = item.getAppointmentCnt();
            String str2 = numberInstance.format(appointmentCnt2 != null ? appointmentCnt2.longValue() : 0L) + " booked";
            so.c.k(view);
            textView3.setText(str2);
            Long appointmentCnt3 = item.getAppointmentCnt();
            if ((appointmentCnt3 != null ? appointmentCnt3.longValue() : 0L) > 10000) {
                so.c.k(view2);
            } else {
                so.c.g(view2);
            }
        } else {
            so.c.h(view);
        }
        final boolean z11 = this.K.getLong(item.getSubjectId(), -1L) > -1;
        final int iB = com.transsion.baselib.utils.i.b(D(), item);
        X0(z11, holder, item, iB);
        b1(true, item, iB, "browse_appointment", z11);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.home.adapter.suboperate.adapter.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                SubAppointmentAdapter.P0(this.f52059a, item, iB, z11, view3);
            }
        });
    }

    public final void Q0(TextView textView, AppointSubject appointSubject) {
        try {
            Locale locale = Locale.ENGLISH;
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", locale);
            SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("MMM d", locale);
            String appointmentDate = appointSubject.getAppointmentDate();
            if (appointmentDate == null || appointmentDate.length() == 0) {
                so.c.h(textView);
            } else {
                Date date = simpleDateFormat.parse(appointmentDate);
                Intrinsics.d(date);
                textView.setText(simpleDateFormat2.format(date));
            }
        } catch (Exception e11) {
            e11.printStackTrace();
            so.c.h(textView);
        }
    }

    public final void R0(AppointSubject appointSubject, BaseViewHolder baseViewHolder) {
        Uri uriWithAppendedId = ContentUris.withAppendedId(CalendarContract.Events.CONTENT_URI, this.K.getLong(appointSubject.getSubjectId(), -1L));
        Intrinsics.f(uriWithAppendedId, "withAppendedId(CalendarC…nts.CONTENT_URI, eventId)");
        try {
            Result.Companion companion = Result.Companion;
            Result.m163constructorimpl(Integer.valueOf(getContext().getContentResolver().delete(uriWithAppendedId, null, null)));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.m163constructorimpl(ResultKt.a(th2));
        }
        this.K.remove(appointSubject.getSubjectId());
        N0(false, baseViewHolder);
        c1(R$string.appointment_delete_success);
    }

    public final String S0(AppointSubject appointSubject) {
        Integer subjectType = appointSubject.getSubjectType();
        int value = SubjectType.MOVIE.getValue();
        if (subjectType != null && subjectType.intValue() == value) {
            String string = Utils.a().getString(R$string.appointment_movie_alert_description, appointSubject.getTitle());
            Intrinsics.f(string, "{\n            Utils.getA…on, item.title)\n        }");
            return string;
        }
        String string2 = Utils.a().getString(R$string.appointment_series_alert_description, appointSubject.getTitle());
        Intrinsics.f(string2, "{\n            Utils.getA…on, item.title)\n        }");
        return string2;
    }

    public final String T0(AppointSubject appointSubject) {
        Integer subjectType = appointSubject.getSubjectType();
        int value = SubjectType.MOVIE.getValue();
        if (subjectType != null && subjectType.intValue() == value) {
            String string = Utils.a().getString(R$string.appointment_movie_alert_title, appointSubject.getTitle());
            Intrinsics.f(string, "{\n            Utils.getA…le, item.title)\n        }");
            return string;
        }
        String string2 = Utils.a().getString(R$string.appointment_episode_alert_title, appointSubject.getTitle());
        Intrinsics.f(string2, "{\n            Utils.getA…le, item.title)\n        }");
        return string2;
    }

    public final Long U0() {
        try {
            Cursor cursorQuery = getContext().getContentResolver().query(CalendarContract.Calendars.CONTENT_URI, new String[]{"_id", "calendar_displayName"}, "visible = 1 AND sync_events = 1", null, null);
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
        } catch (Throwable unused) {
        }
        return null;
    }

    public final HashMap<String, String> V0(AppointSubject appointSubject, int i11, String str, boolean z11) {
        String string;
        HashMap<String, String> map = new HashMap<>();
        map.put("event_type", str);
        String subjectId = appointSubject.getSubjectId();
        if (subjectId == null) {
            subjectId = "";
        }
        map.put("subject_id", subjectId);
        Integer subjectType = appointSubject.getSubjectType();
        if (subjectType == null || (string = subjectType.toString()) == null) {
            string = "";
        }
        map.put("subject_type", string);
        map.put("sequence", String.valueOf(i11));
        String appointmentDate = appointSubject.getAppointmentDate();
        if (appointmentDate == null) {
            appointmentDate = "";
        }
        map.put("appointment_date", appointmentDate);
        String ops = appointSubject.getOps();
        map.put("ops", ops != null ? ops : "");
        map.put("tabId", String.valueOf(this.I));
        map.put("added", String.valueOf(z11));
        ot.b.c(appointSubject, map);
        ot.b.a(this.J, map);
        return map;
    }

    public final void X0(final boolean z11, final BaseViewHolder baseViewHolder, final AppointSubject appointSubject, final int i11) {
        String subjectId = appointSubject.getSubjectId();
        if (subjectId == null || subjectId.length() == 0) {
            return;
        }
        N0(z11, baseViewHolder);
        int i12 = R$id.sub_operation_appointment_checked;
        final int i13 = i12 + i11;
        baseViewHolder.getView(i12).setOnClickListener(new View.OnClickListener() { // from class: com.transsion.home.adapter.suboperate.adapter.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SubAppointmentAdapter.Y0(i13, this, baseViewHolder, appointSubject, i11, z11, view);
            }
        });
        baseViewHolder.getView(R$id.sub_operation_appointment_unchecked).setOnClickListener(new View.OnClickListener() { // from class: com.transsion.home.adapter.suboperate.adapter.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SubAppointmentAdapter.Z0(i13, this, baseViewHolder, appointSubject, i11, z11, view);
            }
        });
    }

    public final void a1(final BaseViewHolder baseViewHolder, final AppointSubject appointSubject, final boolean z11) {
        this.H.invoke(new Function1<Boolean, Unit>() { // from class: com.transsion.home.adapter.suboperate.adapter.SubAppointmentAdapter$onAppointmentClick$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.f68710a;
            }

            public final void invoke(boolean z12) {
                if (!z12) {
                    this.c1(R$string.no_calender_permission);
                } else if (z11) {
                    this.M0(appointSubject, baseViewHolder);
                } else {
                    this.R0(appointSubject, baseViewHolder);
                }
            }
        });
    }

    public final void b1(boolean z11, AppointSubject appointSubject, int i11, String str, boolean z12) {
        HashMap<String, String> mapV0 = V0(appointSubject, i11, str, z12);
        if (z11) {
            com.transsion.baselib.helper.a.f51183a.d(SubTabFragment.f52541r.a(this.I), mapV0);
        } else {
            com.transsion.baselib.helper.a.f51183a.e(SubTabFragment.f52541r.a(this.I), mapV0);
        }
    }

    public final void c1(int i11) {
        Toast.makeText(getContext(), getContext().getString(i11), 0).show();
    }
}
