package y00;

import android.os.Bundle;
import androidx.annotation.NonNull;
import com.transsion.push.PushConstants;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class i implements e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f81049b = "y00.i";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f81050a;

    /* JADX INFO: compiled from: source.java */
    public interface a {
        void a();
    }

    public i(@NonNull a aVar) {
        this.f81050a = aVar;
    }

    public static g b(String str) {
        Bundle bundle = new Bundle();
        bundle.putString(PushConstants.PROVIDER_FIELD_APP_ID, str);
        return new g(f81049b).l(bundle).p(true).m(4);
    }

    @Override // y00.e
    public int a(Bundle bundle, h hVar) {
        if (bundle.getString(PushConstants.PROVIDER_FIELD_APP_ID, null) == null) {
            return 1;
        }
        this.f81050a.a();
        return 0;
    }
}
