package lt;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.transsion.home.R$id;
import com.transsion.home.R$layout;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class p implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final LinearLayout f70492a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final View f70493b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final LinearLayout f70494c;

    public p(@NonNull LinearLayout linearLayout, @NonNull View view, @NonNull LinearLayout linearLayout2) {
        this.f70492a = linearLayout;
        this.f70493b = view;
        this.f70494c = linearLayout2;
    }

    @NonNull
    public static p a(@NonNull View view) {
        int i11 = R$id.sub_room_header_bg;
        View viewA = n6.b.a(view, i11);
        if (viewA != null) {
            i11 = R$id.sub_room_title_layout;
            LinearLayout linearLayout = (LinearLayout) n6.b.a(view, i11);
            if (linearLayout != null) {
                return new p((LinearLayout) view, viewA, linearLayout);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static p c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static p d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View viewInflate = layoutInflater.inflate(R$layout.fragment_room, viewGroup, false);
        if (z11) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // n6.a
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f70492a;
    }
}
