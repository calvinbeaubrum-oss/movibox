package com.google.android.material.datepicker;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.facebook.ads.AdError;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class CalendarConstraints implements Parcelable {
    public static final Parcelable.Creator<CalendarConstraints> CREATOR = new a();

    @NonNull
    private final Month end;
    private final int firstDayOfWeek;
    private final int monthSpan;

    @Nullable
    private Month openAt;

    @NonNull
    private final Month start;

    @NonNull
    private final DateValidator validator;
    private final int yearSpan;

    /* JADX INFO: compiled from: source.java */
    public interface DateValidator extends Parcelable {
        boolean isValid(long j11);
    }

    /* JADX INFO: compiled from: source.java */
    public class a implements Parcelable.Creator<CalendarConstraints> {
        @Override // android.os.Parcelable.Creator
        @NonNull
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public CalendarConstraints createFromParcel(@NonNull Parcel parcel) {
            return new CalendarConstraints((Month) parcel.readParcelable(Month.class.getClassLoader()), (Month) parcel.readParcelable(Month.class.getClassLoader()), (DateValidator) parcel.readParcelable(DateValidator.class.getClassLoader()), (Month) parcel.readParcelable(Month.class.getClassLoader()), parcel.readInt(), null);
        }

        @Override // android.os.Parcelable.Creator
        @NonNull
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public CalendarConstraints[] newArray(int i11) {
            return new CalendarConstraints[i11];
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final long f36631f = y.a(Month.b(1900, 0).f36715f);

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final long f36632g = y.a(Month.b(AdError.BROKEN_MEDIA_ERROR_CODE, 11).f36715f);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f36633a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f36634b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Long f36635c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f36636d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public DateValidator f36637e;

        public b(@NonNull CalendarConstraints calendarConstraints) {
            this.f36633a = f36631f;
            this.f36634b = f36632g;
            this.f36637e = DateValidatorPointForward.from(Long.MIN_VALUE);
            this.f36633a = calendarConstraints.start.f36715f;
            this.f36634b = calendarConstraints.end.f36715f;
            this.f36635c = Long.valueOf(calendarConstraints.openAt.f36715f);
            this.f36636d = calendarConstraints.firstDayOfWeek;
            this.f36637e = calendarConstraints.validator;
        }

        @NonNull
        public CalendarConstraints a() {
            Bundle bundle = new Bundle();
            bundle.putParcelable("DEEP_COPY_VALIDATOR_KEY", this.f36637e);
            Month monthC = Month.c(this.f36633a);
            Month monthC2 = Month.c(this.f36634b);
            DateValidator dateValidator = (DateValidator) bundle.getParcelable("DEEP_COPY_VALIDATOR_KEY");
            Long l11 = this.f36635c;
            return new CalendarConstraints(monthC, monthC2, dateValidator, l11 == null ? null : Month.c(l11.longValue()), this.f36636d, null);
        }

        @NonNull
        public b b(long j11) {
            this.f36635c = Long.valueOf(j11);
            return this;
        }
    }

    private CalendarConstraints(@NonNull Month month, @NonNull Month month2, @NonNull DateValidator dateValidator, @Nullable Month month3, int i11) {
        Objects.requireNonNull(month, "start cannot be null");
        Objects.requireNonNull(month2, "end cannot be null");
        Objects.requireNonNull(dateValidator, "validator cannot be null");
        this.start = month;
        this.end = month2;
        this.openAt = month3;
        this.firstDayOfWeek = i11;
        this.validator = dateValidator;
        if (month3 != null && month.compareTo(month3) > 0) {
            throw new IllegalArgumentException("start Month cannot be after current Month");
        }
        if (month3 != null && month3.compareTo(month2) > 0) {
            throw new IllegalArgumentException("current Month cannot be after end Month");
        }
        if (i11 < 0 || i11 > y.s().getMaximum(7)) {
            throw new IllegalArgumentException("firstDayOfWeek is not valid");
        }
        this.monthSpan = month.m(month2) + 1;
        this.yearSpan = (month2.f36712b - month.f36712b) + 1;
    }

    public /* synthetic */ CalendarConstraints(Month month, Month month2, DateValidator dateValidator, Month month3, int i11, a aVar) {
        this(month, month2, dateValidator, month3, i11);
    }

    public Month clamp(Month month) {
        if (month.compareTo(this.start) < 0) {
            return this.start;
        }
        return month.compareTo(this.end) > 0 ? this.end : month;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CalendarConstraints)) {
            return false;
        }
        CalendarConstraints calendarConstraints = (CalendarConstraints) obj;
        return this.start.equals(calendarConstraints.start) && this.end.equals(calendarConstraints.end) && androidx.core.util.d.a(this.openAt, calendarConstraints.openAt) && this.firstDayOfWeek == calendarConstraints.firstDayOfWeek && this.validator.equals(calendarConstraints.validator);
    }

    public DateValidator getDateValidator() {
        return this.validator;
    }

    @NonNull
    public Month getEnd() {
        return this.end;
    }

    public long getEndMs() {
        return this.end.f36715f;
    }

    public int getFirstDayOfWeek() {
        return this.firstDayOfWeek;
    }

    public int getMonthSpan() {
        return this.monthSpan;
    }

    @Nullable
    public Month getOpenAt() {
        return this.openAt;
    }

    @Nullable
    public Long getOpenAtMs() {
        Month month = this.openAt;
        if (month == null) {
            return null;
        }
        return Long.valueOf(month.f36715f);
    }

    @NonNull
    public Month getStart() {
        return this.start;
    }

    public long getStartMs() {
        return this.start.f36715f;
    }

    public int getYearSpan() {
        return this.yearSpan;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.start, this.end, this.openAt, Integer.valueOf(this.firstDayOfWeek), this.validator});
    }

    public boolean isWithinBounds(long j11) {
        if (this.start.h(1) <= j11) {
            Month month = this.end;
            if (j11 <= month.h(month.f36714d)) {
                return true;
            }
        }
        return false;
    }

    public void setOpenAt(@Nullable Month month) {
        this.openAt = month;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeParcelable(this.start, 0);
        parcel.writeParcelable(this.end, 0);
        parcel.writeParcelable(this.openAt, 0);
        parcel.writeParcelable(this.validator, 0);
        parcel.writeInt(this.firstDayOfWeek);
    }
}
