package lt;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tn.lib.view.RoundedArrowImageView;
import com.transsion.home.R$id;
import com.transsion.home.R$layout;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class f implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f70425a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f70426b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f70427c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final RoundedArrowImageView f70428d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f70429f;

    public f(@NonNull ConstraintLayout constraintLayout, @NonNull ConstraintLayout constraintLayout2, @NonNull AppCompatImageView appCompatImageView, @NonNull RoundedArrowImageView roundedArrowImageView, @NonNull ConstraintLayout constraintLayout3) {
        this.f70425a = constraintLayout;
        this.f70426b = constraintLayout2;
        this.f70427c = appCompatImageView;
        this.f70428d = roundedArrowImageView;
        this.f70429f = constraintLayout3;
    }

    @NonNull
    public static f a(@NonNull View view) {
        int i11 = R$id.bubble_container;
        ConstraintLayout constraintLayout = (ConstraintLayout) n6.b.a(view, i11);
        if (constraintLayout != null) {
            i11 = R$id.iv_ges;
            AppCompatImageView appCompatImageView = (AppCompatImageView) n6.b.a(view, i11);
            if (appCompatImageView != null) {
                i11 = R$id.iv_rounded;
                RoundedArrowImageView roundedArrowImageView = (RoundedArrowImageView) n6.b.a(view, i11);
                if (roundedArrowImageView != null) {
                    i11 = R$id.iv_search_container;
                    ConstraintLayout constraintLayout2 = (ConstraintLayout) n6.b.a(view, i11);
                    if (constraintLayout2 != null) {
                        return new f((ConstraintLayout) view, constraintLayout, appCompatImageView, roundedArrowImageView, constraintLayout2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static f c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static f d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View viewInflate = layoutInflater.inflate(R$layout.dialog_search_guide, viewGroup, false);
        if (z11) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // n6.a
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f70425a;
    }
}
