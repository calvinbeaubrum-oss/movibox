package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@SuppressLint({"BanParcelableUsage"})
final class FragmentState implements Parcelable {
    public static final Parcelable.Creator<FragmentState> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f8509a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f8510b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f8511c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f8512d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f8513f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f8514g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f8515h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f8516i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f8517j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Bundle f8518k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f8519l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f8520m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Bundle f8521n;

    /* JADX INFO: compiled from: source.java */
    public class a implements Parcelable.Creator<FragmentState> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public FragmentState createFromParcel(Parcel parcel) {
            return new FragmentState(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public FragmentState[] newArray(int i11) {
            return new FragmentState[i11];
        }
    }

    public FragmentState(Parcel parcel) {
        this.f8509a = parcel.readString();
        this.f8510b = parcel.readString();
        this.f8511c = parcel.readInt() != 0;
        this.f8512d = parcel.readInt();
        this.f8513f = parcel.readInt();
        this.f8514g = parcel.readString();
        this.f8515h = parcel.readInt() != 0;
        this.f8516i = parcel.readInt() != 0;
        this.f8517j = parcel.readInt() != 0;
        this.f8518k = parcel.readBundle();
        this.f8519l = parcel.readInt() != 0;
        this.f8521n = parcel.readBundle();
        this.f8520m = parcel.readInt();
    }

    public FragmentState(Fragment fragment) {
        this.f8509a = fragment.getClass().getName();
        this.f8510b = fragment.mWho;
        this.f8511c = fragment.mFromLayout;
        this.f8512d = fragment.mFragmentId;
        this.f8513f = fragment.mContainerId;
        this.f8514g = fragment.mTag;
        this.f8515h = fragment.mRetainInstance;
        this.f8516i = fragment.mRemoving;
        this.f8517j = fragment.mDetached;
        this.f8518k = fragment.mArguments;
        this.f8519l = fragment.mHidden;
        this.f8520m = fragment.mMaxState.ordinal();
    }

    @NonNull
    public Fragment a(@NonNull h hVar, @NonNull ClassLoader classLoader) {
        Fragment fragmentInstantiate = hVar.instantiate(classLoader, this.f8509a);
        Bundle bundle = this.f8518k;
        if (bundle != null) {
            bundle.setClassLoader(classLoader);
        }
        fragmentInstantiate.setArguments(this.f8518k);
        fragmentInstantiate.mWho = this.f8510b;
        fragmentInstantiate.mFromLayout = this.f8511c;
        fragmentInstantiate.mRestored = true;
        fragmentInstantiate.mFragmentId = this.f8512d;
        fragmentInstantiate.mContainerId = this.f8513f;
        fragmentInstantiate.mTag = this.f8514g;
        fragmentInstantiate.mRetainInstance = this.f8515h;
        fragmentInstantiate.mRemoving = this.f8516i;
        fragmentInstantiate.mDetached = this.f8517j;
        fragmentInstantiate.mHidden = this.f8519l;
        fragmentInstantiate.mMaxState = Lifecycle.State.values()[this.f8520m];
        Bundle bundle2 = this.f8521n;
        if (bundle2 != null) {
            fragmentInstantiate.mSavedFragmentState = bundle2;
        } else {
            fragmentInstantiate.mSavedFragmentState = new Bundle();
        }
        return fragmentInstantiate;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NonNull
    public String toString() {
        StringBuilder sb2 = new StringBuilder(128);
        sb2.append("FragmentState{");
        sb2.append(this.f8509a);
        sb2.append(" (");
        sb2.append(this.f8510b);
        sb2.append(")}:");
        if (this.f8511c) {
            sb2.append(" fromLayout");
        }
        if (this.f8513f != 0) {
            sb2.append(" id=0x");
            sb2.append(Integer.toHexString(this.f8513f));
        }
        String str = this.f8514g;
        if (str != null && !str.isEmpty()) {
            sb2.append(" tag=");
            sb2.append(this.f8514g);
        }
        if (this.f8515h) {
            sb2.append(" retainInstance");
        }
        if (this.f8516i) {
            sb2.append(" removing");
        }
        if (this.f8517j) {
            sb2.append(" detached");
        }
        if (this.f8519l) {
            sb2.append(" hidden");
        }
        return sb2.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeString(this.f8509a);
        parcel.writeString(this.f8510b);
        parcel.writeInt(this.f8511c ? 1 : 0);
        parcel.writeInt(this.f8512d);
        parcel.writeInt(this.f8513f);
        parcel.writeString(this.f8514g);
        parcel.writeInt(this.f8515h ? 1 : 0);
        parcel.writeInt(this.f8516i ? 1 : 0);
        parcel.writeInt(this.f8517j ? 1 : 0);
        parcel.writeBundle(this.f8518k);
        parcel.writeInt(this.f8519l ? 1 : 0);
        parcel.writeBundle(this.f8521n);
        parcel.writeInt(this.f8520m);
    }
}
