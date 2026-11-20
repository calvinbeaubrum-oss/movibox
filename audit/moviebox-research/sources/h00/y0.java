package h00;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.baseui.widget.GradientTextView;
import com.transsnet.downloader.R$id;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class y0 implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f66100a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f66101b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final GradientTextView f66102c;

    public y0(@NonNull ConstraintLayout constraintLayout, @NonNull AppCompatTextView appCompatTextView, @NonNull GradientTextView gradientTextView) {
        this.f66100a = constraintLayout;
        this.f66101b = appCompatTextView;
        this.f66102c = gradientTextView;
    }

    @NonNull
    public static y0 a(@NonNull View view) {
        int i11 = R$id.tv_title;
        AppCompatTextView appCompatTextView = (AppCompatTextView) n6.b.a(view, i11);
        if (appCompatTextView != null) {
            i11 = R$id.tv_transfer;
            GradientTextView gradientTextView = (GradientTextView) n6.b.a(view, i11);
            if (gradientTextView != null) {
                return new y0((ConstraintLayout) view, appCompatTextView, gradientTextView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @Override // n6.a
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f66100a;
    }
}
