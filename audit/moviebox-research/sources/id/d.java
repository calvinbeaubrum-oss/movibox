package id;

import android.view.View;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public interface d extends View.OnClickListener {

    /* JADX INFO: compiled from: source.java */
    public static final class a {
        public static void a(d dVar, View view) {
            Intrinsics.g(view, "view");
        }

        public static void b(d dVar, View.OnClickListener onClickListener, int... ids) {
            Intrinsics.g(ids, "ids");
            for (int i11 : ids) {
                View viewFindViewById = dVar.findViewById(i11);
                if (viewFindViewById != null) {
                    viewFindViewById.setOnClickListener(onClickListener);
                }
            }
        }

        public static void c(d dVar, View.OnClickListener onClickListener, View... views) {
            Intrinsics.g(views, "views");
            for (View view : views) {
                if (view != null) {
                    view.setOnClickListener(onClickListener);
                }
            }
        }

        public static void d(d dVar, int... ids) {
            Intrinsics.g(ids, "ids");
            dVar.setOnClickListener(dVar, Arrays.copyOf(ids, ids.length));
        }

        public static void e(d dVar, View... views) {
            Intrinsics.g(views, "views");
            dVar.setOnClickListener(dVar, (View[]) Arrays.copyOf(views, views.length));
        }
    }

    <V extends View> V findViewById(int i11);

    void setOnClickListener(View.OnClickListener onClickListener, int... iArr);

    void setOnClickListener(View.OnClickListener onClickListener, View... viewArr);
}
