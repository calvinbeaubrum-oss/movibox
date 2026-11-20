package com.google.android.material.timepicker;

import android.content.res.Resources;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import com.google.android.material.R$string;
import java.util.Arrays;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
class TimeModel implements Parcelable {
    public static final Parcelable.Creator<TimeModel> CREATOR = new a();
    public static final String NUMBER_FORMAT = "%d";
    public static final String ZERO_LEADING_NUMBER_FORMAT = "%02d";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f37927a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f37928b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f37929c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f37930d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f37931f;
    private final e hourInputValidator;
    private final e minuteInputValidator;

    /* JADX INFO: compiled from: source.java */
    public class a implements Parcelable.Creator<TimeModel> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public TimeModel createFromParcel(Parcel parcel) {
            return new TimeModel(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public TimeModel[] newArray(int i11) {
            return new TimeModel[i11];
        }
    }

    public TimeModel() {
        this(0);
    }

    public TimeModel(int i11) {
        this(0, 0, 10, i11);
    }

    public TimeModel(int i11, int i12, int i13, int i14) {
        this.f37928b = i11;
        this.f37929c = i12;
        this.f37930d = i13;
        this.f37927a = i14;
        this.f37931f = g(i11);
        this.minuteInputValidator = new e(59);
        this.hourInputValidator = new e(i14 == 1 ? 23 : 12);
    }

    public TimeModel(Parcel parcel) {
        this(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt());
    }

    @Nullable
    public static String a(Resources resources, CharSequence charSequence) {
        return b(resources, charSequence, ZERO_LEADING_NUMBER_FORMAT);
    }

    @Nullable
    public static String b(Resources resources, CharSequence charSequence, String str) {
        try {
            return String.format(resources.getConfiguration().locale, str, Integer.valueOf(Integer.parseInt(String.valueOf(charSequence))));
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    public static int g(int i11) {
        return i11 >= 12 ? 1 : 0;
    }

    @StringRes
    public int c() {
        return this.f37927a == 1 ? R$string.material_hour_24h_suffix : R$string.material_hour_suffix;
    }

    public int d() {
        if (this.f37927a == 1) {
            return this.f37928b % 24;
        }
        int i11 = this.f37928b;
        if (i11 % 12 == 0) {
            return 12;
        }
        return this.f37931f == 1 ? i11 - 12 : i11;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public e e() {
        return this.hourInputValidator;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TimeModel)) {
            return false;
        }
        TimeModel timeModel = (TimeModel) obj;
        return this.f37928b == timeModel.f37928b && this.f37929c == timeModel.f37929c && this.f37927a == timeModel.f37927a && this.f37930d == timeModel.f37930d;
    }

    public e f() {
        return this.minuteInputValidator;
    }

    public void h(int i11) {
        if (this.f37927a == 1) {
            this.f37928b = i11;
        } else {
            this.f37928b = (i11 % 12) + (this.f37931f != 1 ? 0 : 12);
        }
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f37927a), Integer.valueOf(this.f37928b), Integer.valueOf(this.f37929c), Integer.valueOf(this.f37930d)});
    }

    public void i(int i11) {
        this.f37929c = i11 % 60;
    }

    public void j(int i11) {
        if (i11 != this.f37931f) {
            this.f37931f = i11;
            int i12 = this.f37928b;
            if (i12 < 12 && i11 == 1) {
                this.f37928b = i12 + 12;
            } else {
                if (i12 < 12 || i11 != 0) {
                    return;
                }
                this.f37928b = i12 - 12;
            }
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeInt(this.f37928b);
        parcel.writeInt(this.f37929c);
        parcel.writeInt(this.f37930d);
        parcel.writeInt(this.f37927a);
    }
}
