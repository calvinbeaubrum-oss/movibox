package androidx.databinding;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class ObservableBoolean extends b implements Parcelable, Serializable {
    public static final Parcelable.Creator<ObservableBoolean> CREATOR = new a();
    static final long serialVersionUID = 1;
    private boolean mValue;

    /* JADX INFO: compiled from: source.java */
    public class a implements Parcelable.Creator<ObservableBoolean> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ObservableBoolean createFromParcel(Parcel parcel) {
            return new ObservableBoolean(parcel.readInt() == 1);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public ObservableBoolean[] newArray(int i11) {
            return new ObservableBoolean[i11];
        }
    }

    public ObservableBoolean() {
    }

    public ObservableBoolean(boolean z11) {
        this.mValue = z11;
    }

    public ObservableBoolean(i... iVarArr) {
        super(iVarArr);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean get() {
        return this.mValue;
    }

    public void set(boolean z11) {
        if (z11 != this.mValue) {
            this.mValue = z11;
            notifyChange();
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeInt(this.mValue ? 1 : 0);
    }
}
