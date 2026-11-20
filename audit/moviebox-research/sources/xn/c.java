package xn;

import android.graphics.Bitmap;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.ResultMetadataType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.google.zxing.j f80604a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public u f80605b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f80606c = 2;

    public c(com.google.zxing.j jVar, u uVar) {
        this.f80604a = jVar;
        this.f80605b = uVar;
    }

    public static List<com.google.zxing.k> f(List<com.google.zxing.k> list, u uVar) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<com.google.zxing.k> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(uVar.f(it.next()));
        }
        return arrayList;
    }

    public BarcodeFormat a() {
        return this.f80604a.b();
    }

    public Bitmap b() {
        return this.f80605b.b(null, 2);
    }

    public byte[] c() {
        return this.f80604a.c();
    }

    public Map<ResultMetadataType, Object> d() {
        return this.f80604a.d();
    }

    public String e() {
        return this.f80604a.f();
    }

    public String toString() {
        return this.f80604a.f();
    }
}
