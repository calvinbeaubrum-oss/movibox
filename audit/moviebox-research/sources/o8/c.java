package o8;

import android.content.Context;
import android.os.Build;
import com.bykv.vk.openvk.sc.sc.sc.zY.zY;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<String, a> f72391a = new ConcurrentHashMap<>();

    public static synchronized void a(Context context, zY zYVar, r8.b.a aVar) {
        if (zYVar == null) {
            return;
        }
        try {
            if (Build.VERSION.SDK_INT >= 23) {
                ConcurrentHashMap<String, a> concurrentHashMap = f72391a;
                a aVar2 = concurrentHashMap.get(zYVar.SR());
                if (aVar2 == null) {
                    aVar2 = new a(context, zYVar);
                    concurrentHashMap.put(zYVar.SR(), aVar2);
                    zYVar.zY();
                    zYVar.SR();
                }
                aVar2.q(aVar);
            }
            zYVar.zY();
            zYVar.SR();
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public static synchronized void b(zY zYVar) {
        try {
            if (Build.VERSION.SDK_INT >= 23) {
                a aVarRemove = f72391a.remove(zYVar.SR());
                if (aVarRemove != null) {
                    aVarRemove.r(true);
                }
                zYVar.zY();
                zYVar.SR();
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }
}
