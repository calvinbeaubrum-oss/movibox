package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@SuppressLint({"BanParcelableUsage"})
final class BackStackRecordState implements Parcelable {
    public static final Parcelable.Creator<BackStackRecordState> CREATOR = new a();
    private static final String TAG = "FragmentManager";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int[] f8382a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList<String> f8383b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int[] f8384c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int[] f8385d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f8386f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f8387g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f8388h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f8389i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final CharSequence f8390j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f8391k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final CharSequence f8392l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final ArrayList<String> f8393m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final ArrayList<String> f8394n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f8395o;

    /* JADX INFO: compiled from: source.java */
    public class a implements Parcelable.Creator<BackStackRecordState> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public BackStackRecordState createFromParcel(Parcel parcel) {
            return new BackStackRecordState(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public BackStackRecordState[] newArray(int i11) {
            return new BackStackRecordState[i11];
        }
    }

    public BackStackRecordState(Parcel parcel) {
        this.f8382a = parcel.createIntArray();
        this.f8383b = parcel.createStringArrayList();
        this.f8384c = parcel.createIntArray();
        this.f8385d = parcel.createIntArray();
        this.f8386f = parcel.readInt();
        this.f8387g = parcel.readString();
        this.f8388h = parcel.readInt();
        this.f8389i = parcel.readInt();
        Parcelable.Creator creator = TextUtils.CHAR_SEQUENCE_CREATOR;
        this.f8390j = (CharSequence) creator.createFromParcel(parcel);
        this.f8391k = parcel.readInt();
        this.f8392l = (CharSequence) creator.createFromParcel(parcel);
        this.f8393m = parcel.createStringArrayList();
        this.f8394n = parcel.createStringArrayList();
        this.f8395o = parcel.readInt() != 0;
    }

    public BackStackRecordState(androidx.fragment.app.a aVar) {
        int size = aVar.mOps.size();
        this.f8382a = new int[size * 6];
        if (!aVar.mAddToBackStack) {
            throw new IllegalStateException("Not on back stack");
        }
        this.f8383b = new ArrayList<>(size);
        this.f8384c = new int[size];
        this.f8385d = new int[size];
        int i11 = 0;
        for (int i12 = 0; i12 < size; i12++) {
            FragmentTransaction.a aVar2 = aVar.mOps.get(i12);
            int i13 = i11 + 1;
            this.f8382a[i11] = aVar2.f8536a;
            ArrayList<String> arrayList = this.f8383b;
            Fragment fragment = aVar2.f8537b;
            arrayList.add(fragment != null ? fragment.mWho : null);
            int[] iArr = this.f8382a;
            iArr[i13] = aVar2.f8538c ? 1 : 0;
            iArr[i11 + 2] = aVar2.f8539d;
            iArr[i11 + 3] = aVar2.f8540e;
            int i14 = i11 + 5;
            iArr[i11 + 4] = aVar2.f8541f;
            i11 += 6;
            iArr[i14] = aVar2.f8542g;
            this.f8384c[i12] = aVar2.f8543h.ordinal();
            this.f8385d[i12] = aVar2.f8544i.ordinal();
        }
        this.f8386f = aVar.mTransition;
        this.f8387g = aVar.mName;
        this.f8388h = aVar.f8575c;
        this.f8389i = aVar.mBreadCrumbTitleRes;
        this.f8390j = aVar.mBreadCrumbTitleText;
        this.f8391k = aVar.mBreadCrumbShortTitleRes;
        this.f8392l = aVar.mBreadCrumbShortTitleText;
        this.f8393m = aVar.mSharedElementSourceNames;
        this.f8394n = aVar.mSharedElementTargetNames;
        this.f8395o = aVar.mReorderingAllowed;
    }

    public final void a(@NonNull androidx.fragment.app.a aVar) {
        int i11 = 0;
        int i12 = 0;
        while (true) {
            boolean z11 = true;
            if (i11 >= this.f8382a.length) {
                aVar.mTransition = this.f8386f;
                aVar.mName = this.f8387g;
                aVar.mAddToBackStack = true;
                aVar.mBreadCrumbTitleRes = this.f8389i;
                aVar.mBreadCrumbTitleText = this.f8390j;
                aVar.mBreadCrumbShortTitleRes = this.f8391k;
                aVar.mBreadCrumbShortTitleText = this.f8392l;
                aVar.mSharedElementSourceNames = this.f8393m;
                aVar.mSharedElementTargetNames = this.f8394n;
                aVar.mReorderingAllowed = this.f8395o;
                return;
            }
            FragmentTransaction.a aVar2 = new FragmentTransaction.a();
            int i13 = i11 + 1;
            aVar2.f8536a = this.f8382a[i11];
            if (FragmentManager.isLoggingEnabled(2)) {
                Log.v("FragmentManager", "Instantiate " + aVar + " op #" + i12 + " base fragment #" + this.f8382a[i13]);
            }
            aVar2.f8543h = Lifecycle.State.values()[this.f8384c[i12]];
            aVar2.f8544i = Lifecycle.State.values()[this.f8385d[i12]];
            int[] iArr = this.f8382a;
            int i14 = i11 + 2;
            if (iArr[i13] == 0) {
                z11 = false;
            }
            aVar2.f8538c = z11;
            int i15 = iArr[i14];
            aVar2.f8539d = i15;
            int i16 = iArr[i11 + 3];
            aVar2.f8540e = i16;
            int i17 = i11 + 5;
            int i18 = iArr[i11 + 4];
            aVar2.f8541f = i18;
            i11 += 6;
            int i19 = iArr[i17];
            aVar2.f8542g = i19;
            aVar.mEnterAnim = i15;
            aVar.mExitAnim = i16;
            aVar.mPopEnterAnim = i18;
            aVar.mPopExitAnim = i19;
            aVar.addOp(aVar2);
            i12++;
        }
    }

    @NonNull
    public androidx.fragment.app.a b(@NonNull FragmentManager fragmentManager) {
        androidx.fragment.app.a aVar = new androidx.fragment.app.a(fragmentManager);
        a(aVar);
        aVar.f8575c = this.f8388h;
        for (int i11 = 0; i11 < this.f8383b.size(); i11++) {
            String str = this.f8383b.get(i11);
            if (str != null) {
                aVar.mOps.get(i11).f8537b = fragmentManager.findActiveFragment(str);
            }
        }
        aVar.b(1);
        return aVar;
    }

    @NonNull
    public androidx.fragment.app.a c(@NonNull FragmentManager fragmentManager, @NonNull Map<String, Fragment> map) {
        androidx.fragment.app.a aVar = new androidx.fragment.app.a(fragmentManager);
        a(aVar);
        for (int i11 = 0; i11 < this.f8383b.size(); i11++) {
            String str = this.f8383b.get(i11);
            if (str != null) {
                Fragment fragment = map.get(str);
                if (fragment == null) {
                    throw new IllegalStateException("Restoring FragmentTransaction " + this.f8387g + " failed due to missing saved state for Fragment (" + str + ")");
                }
                aVar.mOps.get(i11).f8537b = fragment;
            }
        }
        return aVar;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeIntArray(this.f8382a);
        parcel.writeStringList(this.f8383b);
        parcel.writeIntArray(this.f8384c);
        parcel.writeIntArray(this.f8385d);
        parcel.writeInt(this.f8386f);
        parcel.writeString(this.f8387g);
        parcel.writeInt(this.f8388h);
        parcel.writeInt(this.f8389i);
        TextUtils.writeToParcel(this.f8390j, parcel, 0);
        parcel.writeInt(this.f8391k);
        TextUtils.writeToParcel(this.f8392l, parcel, 0);
        parcel.writeStringList(this.f8393m);
        parcel.writeStringList(this.f8394n);
        parcel.writeInt(this.f8395o ? 1 : 0);
    }
}
