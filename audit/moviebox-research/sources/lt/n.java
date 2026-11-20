package lt;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.compose.ui.platform.ComposeView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tn.lib.view.TitleLayout;
import com.transsion.home.R$id;
import com.transsion.home.R$layout;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class n implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f70484a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final ComposeView f70485b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final FrameLayout f70486c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f70487d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final TitleLayout f70488f;

    public n(@NonNull ConstraintLayout constraintLayout, @NonNull ComposeView composeView, @NonNull FrameLayout frameLayout, @NonNull ConstraintLayout constraintLayout2, @NonNull TitleLayout titleLayout) {
        this.f70484a = constraintLayout;
        this.f70485b = composeView;
        this.f70486c = frameLayout;
        this.f70487d = constraintLayout2;
        this.f70488f = titleLayout;
    }

    @NonNull
    public static n a(@NonNull View view) {
        int i11 = R$id.rank_all_category_container;
        ComposeView composeView = (ComposeView) n6.b.a(view, i11);
        if (composeView != null) {
            i11 = R$id.rank_all_error;
            FrameLayout frameLayout = (FrameLayout) n6.b.a(view, i11);
            if (frameLayout != null) {
                i11 = R$id.rank_all_loading_frame;
                ConstraintLayout constraintLayout = (ConstraintLayout) n6.b.a(view, i11);
                if (constraintLayout != null) {
                    i11 = R$id.rank_all_title;
                    TitleLayout titleLayout = (TitleLayout) n6.b.a(view, i11);
                    if (titleLayout != null) {
                        return new n((ConstraintLayout) view, composeView, frameLayout, constraintLayout, titleLayout);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static n c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static n d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View viewInflate = layoutInflater.inflate(R$layout.fragment_rank_all, viewGroup, false);
        if (z11) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // n6.a
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f70484a;
    }
}
