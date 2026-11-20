package h00;

import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.cardview.widget.CardView;
import com.transsnet.downloader.R$id;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class s0 implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final CardView f66019a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f66020b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f66021c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f66022d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final c1 f66023f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final ProgressBar f66024g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NonNull
    public final TextView f66025h;

    public s0(@NonNull CardView cardView, @NonNull AppCompatImageView appCompatImageView, @NonNull AppCompatImageView appCompatImageView2, @NonNull AppCompatImageView appCompatImageView3, @NonNull c1 c1Var, @NonNull ProgressBar progressBar, @NonNull TextView textView) {
        this.f66019a = cardView;
        this.f66020b = appCompatImageView;
        this.f66021c = appCompatImageView2;
        this.f66022d = appCompatImageView3;
        this.f66023f = c1Var;
        this.f66024g = progressBar;
        this.f66025h = textView;
    }

    @NonNull
    public static s0 a(@NonNull View view) {
        View viewA;
        int i11 = R$id.iv_cover;
        AppCompatImageView appCompatImageView = (AppCompatImageView) n6.b.a(view, i11);
        if (appCompatImageView != null) {
            i11 = R$id.iv_play;
            AppCompatImageView appCompatImageView2 = (AppCompatImageView) n6.b.a(view, i11);
            if (appCompatImageView2 != null) {
                i11 = R$id.iv_type;
                AppCompatImageView appCompatImageView3 = (AppCompatImageView) n6.b.a(view, i11);
                if (appCompatImageView3 != null && (viewA = n6.b.a(view, (i11 = R$id.layout_no_file_tips))) != null) {
                    c1 c1VarA = c1.a(viewA);
                    i11 = R$id.progress_bar;
                    ProgressBar progressBar = (ProgressBar) n6.b.a(view, i11);
                    if (progressBar != null) {
                        i11 = R$id.textView2;
                        TextView textView = (TextView) n6.b.a(view, i11);
                        if (textView != null) {
                            return new s0((CardView) view, appCompatImageView, appCompatImageView2, appCompatImageView3, c1VarA, progressBar, textView);
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
    public CardView getRoot() {
        return this.f66019a;
    }
}
