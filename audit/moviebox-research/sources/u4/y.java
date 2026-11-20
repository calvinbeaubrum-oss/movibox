package u4;

import android.net.Uri;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public interface y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final y f78413a = new y() { // from class: u4.w
        @Override // u4.y
        public /* synthetic */ y a(o5.s.a aVar) {
            return x.c(this, aVar);
        }

        @Override // u4.y
        public /* synthetic */ s[] b(Uri uri, Map map) {
            return x.a(this, uri, map);
        }

        @Override // u4.y
        public /* synthetic */ y c(boolean z11) {
            return x.b(this, z11);
        }

        @Override // u4.y
        public final s[] createExtractors() {
            return x.d();
        }
    };

    y a(o5.s.a aVar);

    s[] b(Uri uri, Map<String, List<String>> map);

    y c(boolean z11);

    s[] createExtractors();
}
