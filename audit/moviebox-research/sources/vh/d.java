package vh;

import android.os.Bundle;
import android.os.Parcel;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class d {
    public byte[] a(List<b> list) {
        ArrayList<Bundle> arrayListD = com.google.android.exoplayer2.util.d.d(list);
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("c", arrayListD);
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeBundle(bundle);
        byte[] bArrMarshall = parcelObtain.marshall();
        parcelObtain.recycle();
        return bArrMarshall;
    }
}
