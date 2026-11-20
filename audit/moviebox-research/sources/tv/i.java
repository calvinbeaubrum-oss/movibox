package tv;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.transsion.postdetail.R$id;
import com.transsion.postdetail.R$layout;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class i implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final LinearLayoutCompat f77761a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final View f77762b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final RecyclerView f77763c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final LinearLayout f77764d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f77765f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f77766g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NonNull
    public final ProgressBar f77767h;

    public i(@NonNull LinearLayoutCompat linearLayoutCompat, @NonNull View view, @NonNull RecyclerView recyclerView, @NonNull LinearLayout linearLayout, @NonNull AppCompatTextView appCompatTextView, @NonNull AppCompatTextView appCompatTextView2, @NonNull ProgressBar progressBar) {
        this.f77761a = linearLayoutCompat;
        this.f77762b = view;
        this.f77763c = recyclerView;
        this.f77764d = linearLayout;
        this.f77765f = appCompatTextView;
        this.f77766g = appCompatTextView2;
        this.f77767h = progressBar;
    }

    @NonNull
    public static i a(@NonNull View view) {
        int i11 = R$id.comment_input_bg;
        View viewA = n6.b.a(view, i11);
        if (viewA != null) {
            i11 = R$id.comment_list;
            RecyclerView recyclerView = (RecyclerView) n6.b.a(view, i11);
            if (recyclerView != null) {
                i11 = R$id.ll_loading;
                LinearLayout linearLayout = (LinearLayout) n6.b.a(view, i11);
                if (linearLayout != null) {
                    i11 = R$id.tv_comment;
                    AppCompatTextView appCompatTextView = (AppCompatTextView) n6.b.a(view, i11);
                    if (appCompatTextView != null) {
                        i11 = R$id.tv_loading;
                        AppCompatTextView appCompatTextView2 = (AppCompatTextView) n6.b.a(view, i11);
                        if (appCompatTextView2 != null) {
                            i11 = R$id.view_load;
                            ProgressBar progressBar = (ProgressBar) n6.b.a(view, i11);
                            if (progressBar != null) {
                                return new i((LinearLayoutCompat) view, viewA, recyclerView, linearLayout, appCompatTextView, appCompatTextView2, progressBar);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static i c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static i d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View viewInflate = layoutInflater.inflate(R$layout.fragment_comment, viewGroup, false);
        if (z11) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // n6.a
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayoutCompat getRoot() {
        return this.f77761a;
    }
}
