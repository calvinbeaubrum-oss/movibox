package rz;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.transsion.videodetail.R$id;
import com.transsion.videodetail.R$layout;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class c implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f75783a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final View f75784b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f75785c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final ProgressBar f75786d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final RecyclerView f75787f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f75788g;

    public c(@NonNull ConstraintLayout constraintLayout, @NonNull View view, @NonNull AppCompatImageView appCompatImageView, @NonNull ProgressBar progressBar, @NonNull RecyclerView recyclerView, @NonNull AppCompatTextView appCompatTextView) {
        this.f75783a = constraintLayout;
        this.f75784b = view;
        this.f75785c = appCompatImageView;
        this.f75786d = progressBar;
        this.f75787f = recyclerView;
        this.f75788g = appCompatTextView;
    }

    @NonNull
    public static c a(@NonNull View view) {
        int i11 = R$id.divider;
        View viewA = n6.b.a(view, i11);
        if (viewA != null) {
            i11 = R$id.iv_close;
            AppCompatImageView appCompatImageView = (AppCompatImageView) n6.b.a(view, i11);
            if (appCompatImageView != null) {
                i11 = R$id.pb_loading;
                ProgressBar progressBar = (ProgressBar) n6.b.a(view, i11);
                if (progressBar != null) {
                    i11 = R$id.f59795rv;
                    RecyclerView recyclerView = (RecyclerView) n6.b.a(view, i11);
                    if (recyclerView != null) {
                        i11 = R$id.tv_title;
                        AppCompatTextView appCompatTextView = (AppCompatTextView) n6.b.a(view, i11);
                        if (appCompatTextView != null) {
                            return new c((ConstraintLayout) view, viewA, appCompatImageView, progressBar, recyclerView, appCompatTextView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static c c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static c d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View viewInflate = layoutInflater.inflate(R$layout.fragment_audio_track, viewGroup, false);
        if (z11) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // n6.a
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f75783a;
    }
}
