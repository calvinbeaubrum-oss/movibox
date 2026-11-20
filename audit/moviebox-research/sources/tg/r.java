package tg;

import android.net.Uri;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public interface r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final r f77075a = new r() { // from class: tg.p
        @Override // tg.r
        public /* synthetic */ l[] b(Uri uri, Map map) {
            return q.a(this, uri, map);
        }

        @Override // tg.r
        public final l[] createExtractors() {
            return q.b();
        }
    };

    l[] b(Uri uri, Map<String, List<String>> map);

    l[] createExtractors();
}
