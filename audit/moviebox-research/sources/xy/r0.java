package xy;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import com.google.android.material.imageview.ShapeableImageView;
import com.tn.lib.widget.TnTextView;
import com.transsion.usercenter.R$id;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class r0 implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f80942a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final TnTextView f80943b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f80944c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final Group f80945d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final ShapeableImageView f80946f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final ShapeableImageView f80947g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NonNull
    public final ShapeableImageView f80948h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NonNull
    public final ShapeableImageView f80949i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f80950j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @NonNull
    public final TnTextView f80951k;

    public r0(@NonNull ConstraintLayout constraintLayout, @NonNull TnTextView tnTextView, @NonNull ConstraintLayout constraintLayout2, @NonNull Group group, @NonNull ShapeableImageView shapeableImageView, @NonNull ShapeableImageView shapeableImageView2, @NonNull ShapeableImageView shapeableImageView3, @NonNull ShapeableImageView shapeableImageView4, @NonNull AppCompatTextView appCompatTextView, @NonNull TnTextView tnTextView2) {
        this.f80942a = constraintLayout;
        this.f80943b = tnTextView;
        this.f80944c = constraintLayout2;
        this.f80945d = group;
        this.f80946f = shapeableImageView;
        this.f80947g = shapeableImageView2;
        this.f80948h = shapeableImageView3;
        this.f80949i = shapeableImageView4;
        this.f80950j = appCompatTextView;
        this.f80951k = tnTextView2;
    }

    @NonNull
    public static r0 a(@NonNull View view) {
        int i11 = R$id.btnFind;
        TnTextView tnTextView = (TnTextView) n6.b.a(view, i11);
        if (tnTextView != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) view;
            i11 = R$id.groupPlaceholder;
            Group group = (Group) n6.b.a(view, i11);
            if (group != null) {
                i11 = R$id.ivPlaceholder1;
                ShapeableImageView shapeableImageView = (ShapeableImageView) n6.b.a(view, i11);
                if (shapeableImageView != null) {
                    i11 = R$id.ivPlaceholder2;
                    ShapeableImageView shapeableImageView2 = (ShapeableImageView) n6.b.a(view, i11);
                    if (shapeableImageView2 != null) {
                        i11 = R$id.ivPlaceholder3;
                        ShapeableImageView shapeableImageView3 = (ShapeableImageView) n6.b.a(view, i11);
                        if (shapeableImageView3 != null) {
                            i11 = R$id.ivPlaceholder4;
                            ShapeableImageView shapeableImageView4 = (ShapeableImageView) n6.b.a(view, i11);
                            if (shapeableImageView4 != null) {
                                i11 = R$id.tvNumber;
                                AppCompatTextView appCompatTextView = (AppCompatTextView) n6.b.a(view, i11);
                                if (appCompatTextView != null) {
                                    i11 = R$id.tvTitle;
                                    TnTextView tnTextView2 = (TnTextView) n6.b.a(view, i11);
                                    if (tnTextView2 != null) {
                                        return new r0(constraintLayout, tnTextView, constraintLayout, group, shapeableImageView, shapeableImageView2, shapeableImageView3, shapeableImageView4, appCompatTextView, tnTextView2);
                                    }
                                }
                            }
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
        return this.f80942a;
    }
}
