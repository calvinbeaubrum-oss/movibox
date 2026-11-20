package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class Month implements Comparable<Month>, Parcelable {
    public static final Parcelable.Creator<Month> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f36711a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f36712b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f36713c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f36714d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f36715f;

    @NonNull
    private final Calendar firstOfMonth;

    @Nullable
    private String longName;

    /* JADX INFO: compiled from: source.java */
    public class a implements Parcelable.Creator<Month> {
        @Override // android.os.Parcelable.Creator
        @NonNull
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Month createFromParcel(@NonNull Parcel parcel) {
            return Month.b(parcel.readInt(), parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        @NonNull
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Month[] newArray(int i11) {
            return new Month[i11];
        }
    }

    public Month(@NonNull Calendar calendar) {
        calendar.set(5, 1);
        Calendar calendarF = y.f(calendar);
        this.firstOfMonth = calendarF;
        this.f36711a = calendarF.get(2);
        this.f36712b = calendarF.get(1);
        this.f36713c = calendarF.getMaximum(7);
        this.f36714d = calendarF.getActualMaximum(5);
        this.f36715f = calendarF.getTimeInMillis();
    }

    @NonNull
    public static Month b(int i11, int i12) {
        Calendar calendarS = y.s();
        calendarS.set(1, i11);
        calendarS.set(2, i12);
        return new Month(calendarS);
    }

    @NonNull
    public static Month c(long j11) {
        Calendar calendarS = y.s();
        calendarS.setTimeInMillis(j11);
        return new Month(calendarS);
    }

    @NonNull
    public static Month d() {
        return new Month(y.q());
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(@NonNull Month month) {
        return this.firstOfMonth.compareTo(month.firstOfMonth);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int e(int i11) {
        int i12 = this.firstOfMonth.get(7);
        if (i11 <= 0) {
            i11 = this.firstOfMonth.getFirstDayOfWeek();
        }
        int i13 = i12 - i11;
        return i13 < 0 ? i13 + this.f36713c : i13;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Month)) {
            return false;
        }
        Month month = (Month) obj;
        return this.f36711a == month.f36711a && this.f36712b == month.f36712b;
    }

    public long h(int i11) {
        Calendar calendarF = y.f(this.firstOfMonth);
        calendarF.set(5, i11);
        return calendarF.getTimeInMillis();
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f36711a), Integer.valueOf(this.f36712b)});
    }

    public int i(long j11) {
        Calendar calendarF = y.f(this.firstOfMonth);
        calendarF.setTimeInMillis(j11);
        return calendarF.get(5);
    }

    @NonNull
    public String j() {
        if (this.longName == null) {
            this.longName = j.l(this.firstOfMonth.getTimeInMillis());
        }
        return this.longName;
    }

    public long k() {
        return this.firstOfMonth.getTimeInMillis();
    }

    @NonNull
    public Month l(int i11) {
        Calendar calendarF = y.f(this.firstOfMonth);
        calendarF.add(2, i11);
        return new Month(calendarF);
    }

    public int m(@NonNull Month month) {
        if (this.firstOfMonth instanceof GregorianCalendar) {
            return ((month.f36712b - this.f36712b) * 12) + (month.f36711a - this.f36711a);
        }
        throw new IllegalArgumentException("Only Gregorian calendars are supported.");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i11) {
        parcel.writeInt(this.f36712b);
        parcel.writeInt(this.f36711a);
    }
}
