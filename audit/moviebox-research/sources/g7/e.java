package g7;

import android.util.Log;
import com.airbnb.lottie.n0;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class e implements n0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Set<String> f65433a = new HashSet();

    @Override // com.airbnb.lottie.n0
    public void a(String str) {
        d(str, null);
    }

    @Override // com.airbnb.lottie.n0
    public void b(String str, Throwable th2) {
        boolean z11 = com.airbnb.lottie.d.f15078a;
    }

    @Override // com.airbnb.lottie.n0
    public void c(String str) {
        e(str, null);
    }

    @Override // com.airbnb.lottie.n0
    public void d(String str, Throwable th2) {
        Set<String> set = f65433a;
        if (set.contains(str)) {
            return;
        }
        Log.w("LOTTIE", str, th2);
        set.add(str);
    }

    public void e(String str, Throwable th2) {
        boolean z11 = com.airbnb.lottie.d.f15078a;
    }
}
