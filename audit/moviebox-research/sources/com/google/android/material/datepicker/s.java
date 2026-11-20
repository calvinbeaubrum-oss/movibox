package com.google.android.material.datepicker;

import androidx.annotation.Nullable;
import java.util.Calendar;
import java.util.TimeZone;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class s {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final s f36779c = new s(null, null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public final Long f36780a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public final TimeZone f36781b;

    public s(@Nullable Long l11, @Nullable TimeZone timeZone) {
        this.f36780a = l11;
        this.f36781b = timeZone;
    }

    public static s c() {
        return f36779c;
    }

    public Calendar a() {
        return b(this.f36781b);
    }

    public Calendar b(@Nullable TimeZone timeZone) {
        Calendar calendar = timeZone == null ? Calendar.getInstance() : Calendar.getInstance(timeZone);
        Long l11 = this.f36780a;
        if (l11 != null) {
            calendar.setTimeInMillis(l11.longValue());
        }
        return calendar;
    }
}
