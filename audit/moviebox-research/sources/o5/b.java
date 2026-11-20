package o5;

import android.os.Bundle;
import android.os.Parcel;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import java.util.ArrayList;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b {
    public e a(long j11, byte[] bArr, int i11, int i12) {
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.unmarshall(bArr, i11, i12);
        parcelObtain.setDataPosition(0);
        Bundle bundle = parcelObtain.readBundle(Bundle.class.getClassLoader());
        parcelObtain.recycle();
        return new e(z3.c.b(new com.google.common.base.f() { // from class: o5.a
            @Override // com.google.common.base.f
            public final Object apply(Object obj) {
                return y3.a.b((Bundle) obj);
            }
        }, (ArrayList) z3.a.e(bundle.getParcelableArrayList("c"))), j11, bundle.getLong(DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_D));
    }
}
