package id;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public interface a {

    /* JADX INFO: renamed from: id.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static final class C0709a {
        public static Activity a(a aVar) {
            Context context = aVar.getContext();
            while (!(context instanceof Activity)) {
                if (!(context instanceof ContextWrapper) || (context = ((ContextWrapper) context).getBaseContext()) == null) {
                    return null;
                }
            }
            return (Activity) context;
        }
    }

    Context getContext();
}
