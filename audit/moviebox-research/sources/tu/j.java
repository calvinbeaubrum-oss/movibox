package tu;

import android.view.LayoutInflater;
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
public final class j implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f77509a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final Group f77510b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final Group f77511c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final ShapeableImageView f77512d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final ShapeableImageView f77513f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f77514g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NonNull
    public final ProgressBar f77515h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NonNull
    public final TextView f77516i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NonNull
    public final View f77517j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f77518k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @NonNull
    public final SecondariesSeekBar f77519l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @NonNull
    public final TextView f77520m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @NonNull
    public final ViewStub f77521n;

    public j(@NonNull ConstraintLayout constraintLayout, @NonNull Group group, @NonNull Group group2, @NonNull ShapeableImageView shapeableImageView, @NonNull ShapeableImageView shapeableImageView2, @NonNull AppCompatImageView appCompatImageView, @NonNull ProgressBar progressBar, @NonNull TextView textView, @NonNull View view, @NonNull AppCompatImageView appCompatImageView2, @NonNull SecondariesSeekBar secondariesSeekBar, @NonNull TextView textView2, @NonNull ViewStub viewStub) {
        this.f77509a = constraintLayout;
        this.f77510b = group;
        this.f77511c = group2;
        this.f77512d = shapeableImageView;
        this.f77513f = shapeableImageView2;
        this.f77514g = appCompatImageView;
        this.f77515h = progressBar;
        this.f77516i = textView;
        this.f77517j = view;
        this.f77518k = appCompatImageView2;
        this.f77519l = secondariesSeekBar;
        this.f77520m = textView2;
        this.f77521n = viewStub;
    }

    @NonNull
    public static j a(@NonNull View view) {
        View viewA;
        int i11 = R$id.groupLoading;
        Group group = (Group) n6.b.a(view, i11);
        if (group != null) {
            i11 = R$id.groupProgress;
            Group group2 = (Group) n6.b.a(view, i11);
            if (group2 != null) {
                i11 = R$id.ivMovieBlurCover;
                ShapeableImageView shapeableImageView = (ShapeableImageView) n6.b.a(view, i11);
                if (shapeableImageView != null) {
                    i11 = R$id.ivMovieCover;
                    ShapeableImageView shapeableImageView2 = (ShapeableImageView) n6.b.a(view, i11);
                    if (shapeableImageView2 != null) {
                        i11 = R$id.ivPlay;
                        AppCompatImageView appCompatImageView = (AppCompatImageView) n6.b.a(view, i11);
                        if (appCompatImageView != null) {
                            i11 = R$id.progress;
                            ProgressBar progressBar = (ProgressBar) n6.b.a(view, i11);
                            if (progressBar != null) {
                                i11 = R$id.tvLoading;
                                TextView textView = (TextView) n6.b.a(view, i11);
                                if (textView != null && (viewA = n6.b.a(view, (i11 = R$id.vTap))) != null) {
                                    i11 = R$id.vdPause;
                                    AppCompatImageView appCompatImageView2 = (AppCompatImageView) n6.b.a(view, i11);
                                    if (appCompatImageView2 != null) {
                                        i11 = R$id.vdSeekbar;
                                        SecondariesSeekBar secondariesSeekBar = (SecondariesSeekBar) n6.b.a(view, i11);
                                        if (secondariesSeekBar != null) {
                                            i11 = R$id.vdVideoTime;
                                            TextView textView2 = (TextView) n6.b.a(view, i11);
                                            if (textView2 != null) {
                                                i11 = R$id.vsLoadFailed;
                                                ViewStub viewStub = (ViewStub) n6.b.a(view, i11);
                                                if (viewStub != null) {
                                                    return new j((ConstraintLayout) view, group, group2, shapeableImageView, shapeableImageView2, appCompatImageView, progressBar, textView, viewA, appCompatImageView2, secondariesSeekBar, textView2, viewStub);
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
    public static j c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static j d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View viewInflate = layoutInflater.inflate(R$layout.fragment_music_trailer_layout, viewGroup, false);
        if (z11) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // n6.a
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f77509a;
    }
}
