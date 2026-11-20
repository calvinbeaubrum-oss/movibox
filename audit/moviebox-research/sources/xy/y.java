package xy;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.usercenter.R$id;
import com.transsion.usercenter.R$layout;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class y implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f80987a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final View f80988b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final View f80989c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final AppCompatCheckBox f80990d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f80991f;

    public y(@NonNull ConstraintLayout constraintLayout, @NonNull View view, @NonNull View view2, @NonNull AppCompatCheckBox appCompatCheckBox, @NonNull AppCompatTextView appCompatTextView) {
        this.f80987a = constraintLayout;
        this.f80988b = view;
        this.f80989c = view2;
        this.f80990d = appCompatCheckBox;
        this.f80991f = appCompatTextView;
    }

    @NonNull
    public static y a(@NonNull View view) {
        View viewA;
        int i11 = R$id.bgView;
        View viewA2 = n6.b.a(view, i11);
        if (viewA2 != null && (viewA = n6.b.a(view, (i11 = R$id.divider))) != null) {
            i11 = R$id.radioButton;
            AppCompatCheckBox appCompatCheckBox = (AppCompatCheckBox) n6.b.a(view, i11);
            if (appCompatCheckBox != null) {
                i11 = R$id.textView;
                AppCompatTextView appCompatTextView = (AppCompatTextView) n6.b.a(view, i11);
                if (appCompatTextView != null) {
                    return new y((ConstraintLayout) view, viewA2, viewA, appCompatCheckBox, appCompatTextView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static y c(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View viewInflate = layoutInflater.inflate(R$layout.feedback_option_list_cell, viewGroup, false);
        if (z11) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // n6.a
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f80987a;
    }
}
