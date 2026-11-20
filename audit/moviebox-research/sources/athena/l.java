package athena;

import android.content.Context;
import android.os.Message;
import com.transsion.athena.data.TrackData;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class l {
    public static l a(Context context, int i11) {
        if (i11 != 1) {
            if (i11 == 2) {
                return n.i(context);
            }
            if (i11 != 3) {
                return null;
            }
        }
        return h.C0133h.f13674a;
    }

    public void b() {
    }

    public void c(int i11) {
    }

    public abstract void d(Message message, long j11);

    public abstract void e(Runnable runnable);

    public abstract void f(String str, TrackData trackData, long j11);

    public void g() {
    }

    public void h() {
    }
}
