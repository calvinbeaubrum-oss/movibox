package h00;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.noober.background.view.BLTextView;
import com.transsnet.downloader.R$id;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class n implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f65957a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final BLTextView f65958b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final View f65959c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f65960d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f65961f;

    public n(@NonNull ConstraintLayout constraintLayout, @NonNull BLTextView bLTextView, @NonNull View view, @NonNull AppCompatImageView appCompatImageView, @NonNull AppCompatTextView appCompatTextView) {
        this.f65957a = constraintLayout;
        this.f65958b = bLTextView;
        this.f65959c = view;
        this.f65960d = appCompatImageView;
        this.f65961f = appCompatTextView;
    }

    @NonNull
    public static n a(@NonNull View view) {
        View viewA;
        int i11 = R$id.btn_bottom;
        BLTextView bLTextView = (BLTextView) n6.b.a(view, i11);
        if (bLTextView != null && (viewA = n6.b.a(view, (i11 = R$id.btn_top))) != null) {
            i11 = R$id.iv_close;
            AppCompatImageView appCompatImageView = (AppCompatImageView) n6.b.a(view, i11);
            if (appCompatImageView != null) {
                i11 = R$id.tv_tips;
                AppCompatTextView appCompatTextView = (AppCompatTextView) n6.b.a(view, i11);
                if (appCompatTextView != null) {
                    return new n((ConstraintLayout) view, bLTextView, viewA, appCompatImageView, appCompatTextView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @Override // n6.a
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f65957a;
    }
}
