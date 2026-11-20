package h00;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tn.lib.widget.TnTextView;
import com.transsion.baseui.widget.GradientTextView;
import com.transsnet.downloader.R$id;
import com.transsnet.downloader.R$layout;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class x implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f66085a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f66086b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final FrameLayout f66087c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f66088d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final TnTextView f66089f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final GradientTextView f66090g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NonNull
    public final View f66091h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NonNull
    public final ImageView f66092i;

    public x(@NonNull ConstraintLayout constraintLayout, @NonNull ConstraintLayout constraintLayout2, @NonNull FrameLayout frameLayout, @NonNull AppCompatImageView appCompatImageView, @NonNull TnTextView tnTextView, @NonNull GradientTextView gradientTextView, @NonNull View view, @NonNull ImageView imageView) {
        this.f66085a = constraintLayout;
        this.f66086b = constraintLayout2;
        this.f66087c = frameLayout;
        this.f66088d = appCompatImageView;
        this.f66089f = tnTextView;
        this.f66090g = gradientTextView;
        this.f66091h = view;
        this.f66092i = imageView;
    }

    @NonNull
    public static x a(@NonNull View view) {
        View viewA;
        ConstraintLayout constraintLayout = (ConstraintLayout) view;
        int i11 = R$id.fl_container;
        FrameLayout frameLayout = (FrameLayout) n6.b.a(view, i11);
        if (frameLayout != null) {
            i11 = R$id.iv_back;
            AppCompatImageView appCompatImageView = (AppCompatImageView) n6.b.a(view, i11);
            if (appCompatImageView != null) {
                i11 = R$id.tv_title;
                TnTextView tnTextView = (TnTextView) n6.b.a(view, i11);
                if (tnTextView != null) {
                    i11 = R$id.tv_transfer;
                    GradientTextView gradientTextView = (GradientTextView) n6.b.a(view, i11);
                    if (gradientTextView != null && (viewA = n6.b.a(view, (i11 = R$id.v_line))) != null) {
                        i11 = R$id.v_top_bg;
                        ImageView imageView = (ImageView) n6.b.a(view, i11);
                        if (imageView != null) {
                            return new x(constraintLayout, constraintLayout, frameLayout, appCompatImageView, tnTextView, gradientTextView, viewA, imageView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static x c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static x d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View viewInflate = layoutInflater.inflate(R$layout.fragment_download_main, viewGroup, false);
        if (z11) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // n6.a
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f66085a;
    }
}
