package sw;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.noober.background.view.BLFrameLayout;
import com.noober.background.view.BLTextView;
import com.transsion.room.R$id;
import com.transsion.room.R$layout;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class r implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final BLFrameLayout f76598a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final BLFrameLayout f76599b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final BLTextView f76600c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final View f76601d;

    public r(@NonNull BLFrameLayout bLFrameLayout, @NonNull BLFrameLayout bLFrameLayout2, @NonNull BLTextView bLTextView, @NonNull View view) {
        this.f76598a = bLFrameLayout;
        this.f76599b = bLFrameLayout2;
        this.f76600c = bLTextView;
        this.f76601d = view;
    }

    @NonNull
    public static r a(@NonNull View view) {
        View viewA;
        BLFrameLayout bLFrameLayout = (BLFrameLayout) view;
        int i11 = R$id.tv_title;
        BLTextView bLTextView = (BLTextView) n6.b.a(view, i11);
        if (bLTextView == null || (viewA = n6.b.a(view, (i11 = R$id.v_selected))) == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
        }
        return new r(bLFrameLayout, bLFrameLayout, bLTextView, viewA);
    }

    @NonNull
    public static r c(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View viewInflate = layoutInflater.inflate(R$layout.item_room_list_tab, viewGroup, false);
        if (z11) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // n6.a
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public BLFrameLayout getRoot() {
        return this.f76598a;
    }
}
