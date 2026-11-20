package o0;

import android.R;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public interface e {

    /* JADX INFO: compiled from: source.java */
    public static final class a {
        public static ImageView a(View view) {
            View viewFindViewById = view != null ? view.findViewById(R.id.icon) : null;
            if (viewFindViewById instanceof ImageView) {
                return (ImageView) viewFindViewById;
            }
            return null;
        }

        public static TextView b(View view) {
            Intrinsics.g(view, "view");
            if (!(view instanceof TextView)) {
                View viewFindViewById = view.findViewById(R.id.message);
                if (viewFindViewById instanceof TextView) {
                    return (TextView) viewFindViewById;
                }
                throw new IllegalArgumentException("You must include a TextView with an ID value of android.R.id.message");
            }
            if (view.getId() == -1) {
                view.setId(R.id.message);
            } else if (view.getId() != 16908299) {
                throw new IllegalArgumentException("You must set the ID value of TextView to android.R.id.message".toString());
            }
            return (TextView) view;
        }
    }

    ImageView a(View view);

    void cancel();

    View getView();

    void setDuration(int i11);

    void setGravity(int i11, int i12, int i13);

    void setMargin(float f11, float f12);

    void setText(CharSequence charSequence);

    void setView(View view);

    void show();
}
