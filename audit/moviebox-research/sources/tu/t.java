package tu;

import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import com.google.android.material.imageview.ShapeableImageView;
import com.tn.lib.view.SecondariesSeekBar;
import com.transsion.moviedetail.R$id;
import com.transsion.moviedetail.R$layout;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class t implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f77616a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final Group f77617b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final Group f77618c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final ShapeableImageView f77619d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final ShapeableImageView f77620f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f77621g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NonNull
    public final ProgressBar f77622h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NonNull
    public final TextureView f77623i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NonNull
    public final TextView f77624j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @NonNull
    public final View f77625k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f77626l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @NonNull
    public final SecondariesSeekBar f77627m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @NonNull
    public final TextView f77628n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @NonNull
    public final ViewStub f77629o;

    public t(@NonNull ConstraintLayout constraintLayout, @NonNull Group group, @NonNull Group group2, @NonNull ShapeableImageView shapeableImageView, @NonNull ShapeableImageView shapeableImageView2, @NonNull AppCompatImageView appCompatImageView, @NonNull ProgressBar progressBar, @NonNull TextureView textureView, @NonNull TextView textView, @NonNull View view, @NonNull AppCompatImageView appCompatImageView2, @NonNull SecondariesSeekBar secondariesSeekBar, @NonNull TextView textView2, @NonNull ViewStub viewStub) {
        this.f77616a = constraintLayout;
        this.f77617b = group;
        this.f77618c = group2;
        this.f77619d = shapeableImageView;
        this.f77620f = shapeableImageView2;
        this.f77621g = appCompatImageView;
        this.f77622h = progressBar;
        this.f77623i = textureView;
        this.f77624j = textView;
        this.f77625k = view;
        this.f77626l = appCompatImageView2;
        this.f77627m = secondariesSeekBar;
        this.f77628n = textView2;
        this.f77629o = viewStub;
    }

    @NonNull
    public static t a(@NonNull View view) {
        View viewA;
        int i11 = R$id.group_loading;
        Group group = (Group) n6.b.a(view, i11);
        if (group != null) {
            i11 = R$id.group_progress;
            Group group2 = (Group) n6.b.a(view, i11);
            if (group2 != null) {
                i11 = R$id.ivMovieBlurCover;
                ShapeableImageView shapeableImageView = (ShapeableImageView) n6.b.a(view, i11);
                if (shapeableImageView != null) {
                    i11 = R$id.ivMovieCover;
                    ShapeableImageView shapeableImageView2 = (ShapeableImageView) n6.b.a(view, i11);
                    if (shapeableImageView2 != null) {
                        i11 = R$id.iv_play;
                        AppCompatImageView appCompatImageView = (AppCompatImageView) n6.b.a(view, i11);
                        if (appCompatImageView != null) {
                            i11 = R$id.progress;
                            ProgressBar progressBar = (ProgressBar) n6.b.a(view, i11);
                            if (progressBar != null) {
                                i11 = R$id.textureView;
                                TextureView textureView = (TextureView) n6.b.a(view, i11);
                                if (textureView != null) {
                                    i11 = R$id.tv_loading;
                                    TextView textView = (TextView) n6.b.a(view, i11);
                                    if (textView != null && (viewA = n6.b.a(view, (i11 = R$id.v_tap))) != null) {
                                        i11 = R$id.vd_pause;
                                        AppCompatImageView appCompatImageView2 = (AppCompatImageView) n6.b.a(view, i11);
                                        if (appCompatImageView2 != null) {
                                            i11 = R$id.vd_seekbar;
                                            SecondariesSeekBar secondariesSeekBar = (SecondariesSeekBar) n6.b.a(view, i11);
                                            if (secondariesSeekBar != null) {
                                                i11 = R$id.vd_video_time;
                                                TextView textView2 = (TextView) n6.b.a(view, i11);
                                                if (textView2 != null) {
                                                    i11 = R$id.vs_load_failed;
                                                    ViewStub viewStub = (ViewStub) n6.b.a(view, i11);
                                                    if (viewStub != null) {
                                                        return new t((ConstraintLayout) view, group, group2, shapeableImageView, shapeableImageView2, appCompatImageView, progressBar, textureView, textView, viewA, appCompatImageView2, secondariesSeekBar, textView2, viewStub);
                                                    }
                                                }
                                            }
                                        }
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

    @NonNull
    public static t c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static t d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View viewInflate = layoutInflater.inflate(R$layout.fragment_trailer, viewGroup, false);
        if (z11) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // n6.a
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f77616a;
    }
}
