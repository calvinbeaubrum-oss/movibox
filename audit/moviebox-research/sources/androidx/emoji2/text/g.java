package androidx.emoji2.text;

import android.annotation.SuppressLint;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class g {

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(34)
    public static class a {
        @NonNull
        public static Set<int[]> a() {
            return b.a();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class b {
        @NonNull
        @SuppressLint({"BanUncheckedReflection"})
        public static Set<int[]> a() {
            try {
                Object objInvoke = Class.forName("android.text.EmojiConsistency").getMethod("getEmojiConsistencySet", new Class[0]).invoke(null, new Object[0]);
                if (objInvoke == null) {
                    return Collections.emptySet();
                }
                Set<int[]> set = (Set) objInvoke;
                Iterator<int[]> it = set.iterator();
                while (it.hasNext()) {
                    if (!(it.next() instanceof int[])) {
                        return Collections.emptySet();
                    }
                }
                return set;
            } catch (Throwable unused) {
                return Collections.emptySet();
            }
        }
    }

    @NonNull
    public static Set<int[]> a() {
        return Build.VERSION.SDK_INT >= 34 ? a.a() : b.a();
    }
}
