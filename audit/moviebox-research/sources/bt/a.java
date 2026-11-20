package bt;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import com.tn.lib.view.FlowLayout;
import com.transsion.edcation.R$id;
import com.transsion.edcation.R$layout;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class a implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final LinearLayout f14392a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final FlowLayout f14393b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final ProgressBar f14394c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f14395d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f14396f;

    public a(@NonNull LinearLayout linearLayout, @NonNull FlowLayout flowLayout, @NonNull ProgressBar progressBar, @NonNull AppCompatTextView appCompatTextView, @NonNull AppCompatTextView appCompatTextView2) {
        this.f14392a = linearLayout;
        this.f14393b = flowLayout;
        this.f14394c = progressBar;
        this.f14395d = appCompatTextView;
        this.f14396f = appCompatTextView2;
    }

    @NonNull
    public static a a(@NonNull View view) {
        int i11 = R$id.interestLayout;
        FlowLayout flowLayout = (FlowLayout) n6.b.a(view, i11);
        if (flowLayout != null) {
            i11 = R$id.loadView;
            ProgressBar progressBar = (ProgressBar) n6.b.a(view, i11);
            if (progressBar != null) {
                i11 = R$id.tvConfirm;
                AppCompatTextView appCompatTextView = (AppCompatTextView) n6.b.a(view, i11);
                if (appCompatTextView != null) {
                    i11 = R$id.tvSkip;
                    AppCompatTextView appCompatTextView2 = (AppCompatTextView) n6.b.a(view, i11);
                    if (appCompatTextView2 != null) {
                        return new a((LinearLayout) view, flowLayout, progressBar, appCompatTextView, appCompatTextView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static a c(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View viewInflate = layoutInflater.inflate(R$layout.dialog_interest_select, viewGroup, false);
        if (z11) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // n6.a
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f14392a;
    }
}
