package os;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.Guideline;
import com.google.android.material.imageview.ShapeableImageView;
import com.transsion.commercialization.R$id;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class d implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final View f73379a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public final Guideline f73380b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final ShapeableImageView f73381c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f73382d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    public final Barrier f73383f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    public final Barrier f73384g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    public final Guideline f73385h;

    public d(@NonNull View view, @Nullable Guideline guideline, @NonNull ShapeableImageView shapeableImageView, @NonNull AppCompatImageView appCompatImageView, @Nullable Barrier barrier, @Nullable Barrier barrier2, @Nullable Guideline guideline2) {
        this.f73379a = view;
        this.f73380b = guideline;
        this.f73381c = shapeableImageView;
        this.f73382d = appCompatImageView;
        this.f73383f = barrier;
        this.f73384g = barrier2;
        this.f73385h = guideline2;
    }

    @NonNull
    public static d a(@NonNull View view) {
        Guideline guideline = (Guideline) n6.b.a(view, R$id.bottomGuideline);
        int i11 = R$id.f51601iv;
        ShapeableImageView shapeableImageView = (ShapeableImageView) n6.b.a(view, i11);
        if (shapeableImageView != null) {
            i11 = R$id.ivClose;
            AppCompatImageView appCompatImageView = (AppCompatImageView) n6.b.a(view, i11);
            if (appCompatImageView != null) {
                return new d(view, guideline, shapeableImageView, appCompatImageView, (Barrier) n6.b.a(view, R$id.leftBarrier), (Barrier) n6.b.a(view, R$id.rightBarrier), (Guideline) n6.b.a(view, R$id.topGuideline));
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @Override // n6.a
    @NonNull
    public View getRoot() {
        return this.f73379a;
    }
}
