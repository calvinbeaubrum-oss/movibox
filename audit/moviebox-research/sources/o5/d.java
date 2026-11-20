package o5;

import android.os.Bundle;
import android.os.Parcel;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class d {
    public byte[] a(List<y3.a> list, long j11) {
        ArrayList<Bundle> arrayListC = z3.c.c(list, new com.google.common.base.f() { // from class: o5.c
            @Override // com.google.common.base.f
            public final Object apply(Object obj) {
                return ((y3.a) obj).d();
            }
        });
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("c", arrayListC);
        bundle.putLong(DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_D, j11);
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeBundle(bundle);
        byte[] bArrMarshall = parcelObtain.marshall();
        parcelObtain.recycle();
        return bArrMarshall;
    }
}
