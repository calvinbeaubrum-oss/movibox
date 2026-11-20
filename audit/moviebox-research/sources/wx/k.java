package wx;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.noober.background.view.BLImageView;
import com.transsion.subtitle.R$id;
import com.transsion.subtitle.R$layout;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class k implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f79746a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final AppCompatEditText f79747b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final BLImageView f79748c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final BLImageView f79749d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f79750f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f79751g;

    public k(@NonNull ConstraintLayout constraintLayout, @NonNull AppCompatEditText appCompatEditText, @NonNull BLImageView bLImageView, @NonNull BLImageView bLImageView2, @NonNull ConstraintLayout constraintLayout2, @NonNull AppCompatTextView appCompatTextView) {
        this.f79746a = constraintLayout;
        this.f79747b = appCompatEditText;
        this.f79748c = bLImageView;
        this.f79749d = bLImageView2;
        this.f79750f = constraintLayout2;
        this.f79751g = appCompatTextView;
    }

    @NonNull
    public static k a(@NonNull View view) {
        int i11 = R$id.et_sync_adjust;
        AppCompatEditText appCompatEditText = (AppCompatEditText) n6.b.a(view, i11);
        if (appCompatEditText != null) {
            i11 = R$id.iv_sync_adjust_minus;
            BLImageView bLImageView = (BLImageView) n6.b.a(view, i11);
            if (bLImageView != null) {
                i11 = R$id.iv_sync_adjust_plus;
                BLImageView bLImageView2 = (BLImageView) n6.b.a(view, i11);
                if (bLImageView2 != null) {
                    ConstraintLayout constraintLayout = (ConstraintLayout) view;
                    i11 = R$id.tvTitle;
                    AppCompatTextView appCompatTextView = (AppCompatTextView) n6.b.a(view, i11);
                    if (appCompatTextView != null) {
                        return new k(constraintLayout, appCompatEditText, bLImageView, bLImageView2, constraintLayout, appCompatTextView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static k c(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View viewInflate = layoutInflater.inflate(R$layout.view_subtitle_sync_adjust_layout, viewGroup, false);
        if (z11) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // n6.a
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f79746a;
    }
}
