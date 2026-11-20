package tv;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.postdetail.R$id;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class e implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f77721a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final View f77722b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final FrameLayout f77723c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final ImageView f77724d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f77725f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final View f77726g;

    public e(@NonNull ConstraintLayout constraintLayout, @NonNull View view, @NonNull FrameLayout frameLayout, @NonNull ImageView imageView, @NonNull AppCompatTextView appCompatTextView, @NonNull View view2) {
        this.f77721a = constraintLayout;
        this.f77722b = view;
        this.f77723c = frameLayout;
        this.f77724d = imageView;
        this.f77725f = appCompatTextView;
        this.f77726g = view2;
    }

    @NonNull
    public static e a(@NonNull View view) {
        View viewA;
        int i11 = R$id.divider;
        View viewA2 = n6.b.a(view, i11);
        if (viewA2 != null) {
            i11 = R$id.fl_comment_container;
            FrameLayout frameLayout = (FrameLayout) n6.b.a(view, i11);
            if (frameLayout != null) {
                i11 = R$id.iv_close;
                ImageView imageView = (ImageView) n6.b.a(view, i11);
                if (imageView != null) {
                    i11 = R$id.tv_comment;
                    AppCompatTextView appCompatTextView = (AppCompatTextView) n6.b.a(view, i11);
                    if (appCompatTextView != null && (viewA = n6.b.a(view, (i11 = R$id.v_bottom))) != null) {
                        return new e((ConstraintLayout) view, viewA2, frameLayout, imageView, appCompatTextView, viewA);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @Override // n6.a
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f77721a;
    }
}
