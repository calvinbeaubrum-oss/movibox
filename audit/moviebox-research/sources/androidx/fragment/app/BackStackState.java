package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@SuppressLint({"BanParcelableUsage"})
class BackStackState implements Parcelable {
    public static final Parcelable.Creator<BackStackState> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<String> f8396a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<BackStackRecordState> f8397b;

    /* JADX INFO: compiled from: source.java */
    public class a implements Parcelable.Creator<BackStackState> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public BackStackState createFromParcel(Parcel parcel) {
            return new BackStackState(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public BackStackState[] newArray(int i11) {
            return new BackStackState[i11];
        }
    }

    public BackStackState(@NonNull Parcel parcel) {
        this.f8396a = parcel.createStringArrayList();
        this.f8397b = parcel.createTypedArrayList(BackStackRecordState.CREATOR);
    }

    public BackStackState(List<String> list, List<BackStackRecordState> list2) {
        this.f8396a = list;
        this.f8397b = list2;
    }

    @NonNull
    public List<androidx.fragment.app.a> a(@NonNull FragmentManager fragmentManager, Map<String, Fragment> map) {
        HashMap map2 = new HashMap(this.f8396a.size());
        for (String str : this.f8396a) {
            Fragment fragment = map.get(str);
            if (fragment != null) {
                map2.put(fragment.mWho, fragment);
            } else {
                FragmentState fragmentStateC = fragmentManager.getFragmentStore().C(str, null);
                if (fragmentStateC != null) {
                    Fragment fragmentA = fragmentStateC.a(fragmentManager.getFragmentFactory(), fragmentManager.getHost().f().getClassLoader());
                    map2.put(fragmentA.mWho, fragmentA);
                }
            }
        }
        ArrayList arrayList = new ArrayList();
        Iterator<BackStackRecordState> it = this.f8397b.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().c(fragmentManager, map2));
        }
        return arrayList;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i11) {
        parcel.writeStringList(this.f8396a);
        parcel.writeTypedList(this.f8397b);
    }
}
