package bx;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.transsion.search.R$id;
import com.transsion.search.R$layout;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class e implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f14470a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f14471b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final EditText f14472c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final ImageView f14473d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final View f14474f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final ProgressBar f14475g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NonNull
    public final TextView f14476h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NonNull
    public final RecyclerView f14477i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NonNull
    public final TextView f14478j;

    public e(@NonNull ConstraintLayout constraintLayout, @NonNull AppCompatImageView appCompatImageView, @NonNull EditText editText, @NonNull ImageView imageView, @NonNull View view, @NonNull ProgressBar progressBar, @NonNull TextView textView, @NonNull RecyclerView recyclerView, @NonNull TextView textView2) {
        this.f14470a = constraintLayout;
        this.f14471b = appCompatImageView;
        this.f14472c = editText;
        this.f14473d = imageView;
        this.f14474f = view;
        this.f14475g = progressBar;
        this.f14476h = textView;
        this.f14477i = recyclerView;
        this.f14478j = textView2;
    }

    @NonNull
    public static e a(@NonNull View view) {
        View viewA;
        int i11 = R$id.clearIV;
        AppCompatImageView appCompatImageView = (AppCompatImageView) n6.b.a(view, i11);
        if (appCompatImageView != null) {
            i11 = R$id.inputET;
            EditText editText = (EditText) n6.b.a(view, i11);
            if (editText != null) {
                i11 = R$id.iv_cancel;
                ImageView imageView = (ImageView) n6.b.a(view, i11);
                if (imageView != null && (viewA = n6.b.a(view, (i11 = R$id.line))) != null) {
                    i11 = R$id.loadView;
                    ProgressBar progressBar = (ProgressBar) n6.b.a(view, i11);
                    if (progressBar != null) {
                        i11 = R$id.recentTV;
                        TextView textView = (TextView) n6.b.a(view, i11);
                        if (textView != null) {
                            i11 = R$id.f57421rv;
                            RecyclerView recyclerView = (RecyclerView) n6.b.a(view, i11);
                            if (recyclerView != null) {
                                i11 = R$id.searchTV;
                                TextView textView2 = (TextView) n6.b.a(view, i11);
                                if (textView2 != null) {
                                    return new e((ConstraintLayout) view, appCompatImageView, editText, imageView, viewA, progressBar, textView, recyclerView, textView2);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static e c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static e d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View viewInflate = layoutInflater.inflate(R$layout.fragment_publish_work, viewGroup, false);
        if (z11) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // n6.a
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f14470a;
    }
}
