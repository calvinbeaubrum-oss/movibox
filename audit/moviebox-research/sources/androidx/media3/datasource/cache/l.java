package androidx.media3.datasource.cache;

import android.net.Uri;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class l {
    public static long a(m mVar) {
        return mVar.get("exo_len", -1L);
    }

    @Nullable
    public static Uri b(m mVar) {
        String str = mVar.get("exo_redir", (String) null);
        if (str == null) {
            return null;
        }
        return Uri.parse(str);
    }
}
