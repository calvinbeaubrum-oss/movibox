package d;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.transsion.http.impl.BitmapCallback;
import com.transsion.push.utils.PushLogUtils;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class h {

    /* JADX INFO: compiled from: source.java */
    public class a implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ HashMap f62844a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AtomicInteger f62845b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ d f62846c;

        public a(HashMap map, AtomicInteger atomicInteger, d dVar) {
            this.f62844a = map;
            this.f62845b = atomicInteger;
            this.f62846c = dVar;
        }

        @Override // d.h.c
        public void a(String str, Bitmap bitmap) {
            this.f62844a.put(str, bitmap);
            if (this.f62845b.decrementAndGet() == 0) {
                this.f62846c.a(this.f62844a);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b extends BitmapCallback {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f62847e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ c f62848f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ int f62849g;

        public b(String str, c cVar, int i11) {
            this.f62847e = str;
            this.f62848f = cVar;
            this.f62849g = i11;
        }

        @Override // com.transsion.http.impl.BitmapCallback
        public void E(int i11, Bitmap bitmap, Throwable th2) {
            PushLogUtils.LOG.i("image download fail, url:" + this.f62847e);
            c cVar = this.f62848f;
            if (cVar != null) {
                cVar.a(this.f62847e, null);
            }
        }

        @Override // com.transsion.http.impl.BitmapCallback
        public void F(int i11, Bitmap bitmap) {
            PushLogUtils.LOG.g("image download complete, url:" + this.f62847e);
            c cVar = this.f62848f;
            if (cVar != null) {
                if (this.f62849g != 3) {
                    cVar.a(this.f62847e, bitmap);
                    return;
                }
                try {
                    this.f62848f.a(this.f62847e, d.b.b(ws.a.a(), bitmap));
                } catch (Exception unused) {
                    this.f62848f.a(this.f62847e, null);
                }
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface c {
        void a(String str, Bitmap bitmap);
    }

    /* JADX INFO: compiled from: source.java */
    public interface d {
        void a(HashMap<String, Bitmap> map);
    }

    public static void a(int i11, String str, c cVar) {
        try {
            vt.a.a(ws.a.a()).h(true).c(ws.a.c()).b(10000).d(10000).f(str).g().a(new b(str, cVar, i11));
        } catch (Exception unused) {
            if (cVar != null) {
                cVar.a(str, null);
            }
        }
    }

    public static void b(int i11, List<String> list, d dVar) {
        HashMap map = new HashMap();
        AtomicInteger atomicInteger = new AtomicInteger(list.size());
        for (String str : list) {
            if (!TextUtils.isEmpty(str)) {
                a(i11, str, new a(map, atomicInteger, dVar));
            }
        }
    }
}
