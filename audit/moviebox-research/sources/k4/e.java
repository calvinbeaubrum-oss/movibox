package k4;

import androidx.media3.exoplayer.offline.q;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class e implements q<e> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f68239a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<String> f68240b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f68241c;

    public e(String str, List<String> list, boolean z11) {
        this.f68239a = str;
        this.f68240b = Collections.unmodifiableList(list);
        this.f68241c = z11;
    }
}
