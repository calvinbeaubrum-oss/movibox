package ky;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.noober.background.view.BLTextView;
import com.transsion.transfer.R$id;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class f implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f69690a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f69691b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final BLTextView f69692c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f69693d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f69694f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final View f69695g;

    public f(@NonNull ConstraintLayout constraintLayout, @NonNull AppCompatTextView appCompatTextView, @NonNull BLTextView bLTextView, @NonNull AppCompatTextView appCompatTextView2, @NonNull AppCompatTextView appCompatTextView3, @NonNull View view) {
        this.f69690a = constraintLayout;
        this.f69691b = appCompatTextView;
        this.f69692c = bLTextView;
        this.f69693d = appCompatTextView2;
        this.f69694f = appCompatTextView3;
        this.f69695g = view;
    }

    @NonNull
    public static f a(@NonNull View view) {
        View viewA;
        int i11 = R$id.btn_no;
        AppCompatTextView appCompatTextView = (AppCompatTextView) n6.b.a(view, i11);
        if (appCompatTextView != null) {
            i11 = R$id.btn_yes;
            BLTextView bLTextView = (BLTextView) n6.b.a(view, i11);
            if (bLTextView != null) {
                i11 = R$id.tv_tips;
                AppCompatTextView appCompatTextView2 = (AppCompatTextView) n6.b.a(view, i11);
                if (appCompatTextView2 != null) {
                    i11 = R$id.tv_title;
                    AppCompatTextView appCompatTextView3 = (AppCompatTextView) n6.b.a(view, i11);
                    if (appCompatTextView3 != null && (viewA = n6.b.a(view, (i11 = R$id.v_ling_1))) != null) {
                        return new f((ConstraintLayout) view, appCompatTextView, bLTextView, appCompatTextView2, appCompatTextView3, viewA);
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
        return this.f69690a;
    }
}
