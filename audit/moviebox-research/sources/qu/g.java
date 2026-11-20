package qu;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.member.R$id;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class g implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f74936a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextView f74937b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f74938c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f74939d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f74940f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final TextView f74941g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NonNull
    public final TextView f74942h;

    public g(@NonNull ConstraintLayout constraintLayout, @NonNull TextView textView, @NonNull ConstraintLayout constraintLayout2, @NonNull AppCompatImageView appCompatImageView, @NonNull AppCompatImageView appCompatImageView2, @NonNull TextView textView2, @NonNull TextView textView3) {
        this.f74936a = constraintLayout;
        this.f74937b = textView;
        this.f74938c = constraintLayout2;
        this.f74939d = appCompatImageView;
        this.f74940f = appCompatImageView2;
        this.f74941g = textView2;
        this.f74942h = textView3;
    }

    @NonNull
    public static g a(@NonNull View view) {
        int i11 = R$id.btnClaim;
        TextView textView = (TextView) n6.b.a(view, i11);
        if (textView != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) view;
            i11 = R$id.ivClose;
            AppCompatImageView appCompatImageView = (AppCompatImageView) n6.b.a(view, i11);
            if (appCompatImageView != null) {
                i11 = R$id.ivIcon;
                AppCompatImageView appCompatImageView2 = (AppCompatImageView) n6.b.a(view, i11);
                if (appCompatImageView2 != null) {
                    i11 = R$id.tvSubTitle;
                    TextView textView2 = (TextView) n6.b.a(view, i11);
                    if (textView2 != null) {
                        i11 = R$id.tvTitle;
                        TextView textView3 = (TextView) n6.b.a(view, i11);
                        if (textView3 != null) {
                            return new g(constraintLayout, textView, constraintLayout, appCompatImageView, appCompatImageView2, textView2, textView3);
                        }
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
        return this.f74936a;
    }
}
