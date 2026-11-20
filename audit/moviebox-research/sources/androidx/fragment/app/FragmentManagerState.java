package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@SuppressLint({"BanParcelableUsage"})
final class FragmentManagerState implements Parcelable {
    public static final Parcelable.Creator<FragmentManagerState> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ArrayList<String> f8501a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ArrayList<String> f8502b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public BackStackRecordState[] f8503c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f8504d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f8505f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ArrayList<String> f8506g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ArrayList<BackStackState> f8507h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ArrayList<FragmentManager.LaunchedFragmentInfo> f8508i;

    /* JADX INFO: compiled from: source.java */
    public class a implements Parcelable.Creator<FragmentManagerState> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public FragmentManagerState createFromParcel(Parcel parcel) {
            return new FragmentManagerState(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public FragmentManagerState[] newArray(int i11) {
            return new FragmentManagerState[i11];
        }
    }

    public FragmentManagerState() {
        this.f8505f = null;
        this.f8506g = new ArrayList<>();
        this.f8507h = new ArrayList<>();
    }

    public FragmentManagerState(Parcel parcel) {
        this.f8505f = null;
        this.f8506g = new ArrayList<>();
        this.f8507h = new ArrayList<>();
        this.f8501a = parcel.createStringArrayList();
        this.f8502b = parcel.createStringArrayList();
        this.f8503c = (BackStackRecordState[]) parcel.createTypedArray(BackStackRecordState.CREATOR);
        this.f8504d = parcel.readInt();
        this.f8505f = parcel.readString();
        this.f8506g = parcel.createStringArrayList();
        this.f8507h = parcel.createTypedArrayList(BackStackState.CREATOR);
        this.f8508i = parcel.createTypedArrayList(FragmentManager.LaunchedFragmentInfo.CREATOR);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeStringList(this.f8501a);
        parcel.writeStringList(this.f8502b);
        parcel.writeTypedArray(this.f8503c, i11);
        parcel.writeInt(this.f8504d);
        parcel.writeString(this.f8505f);
        parcel.writeStringList(this.f8506g);
        parcel.writeTypedList(this.f8507h);
        parcel.writeTypedList(this.f8508i);
    }
}
