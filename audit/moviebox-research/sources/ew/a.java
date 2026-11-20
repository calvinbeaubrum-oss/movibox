package ew;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageButton;
import com.transsion.publish.R$id;
import com.transsion.publish.R$layout;
import com.transsion.publish.view.clip.ClipImageView;
import com.transsion.publish.view.clip.ClipView;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class a implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final RelativeLayout f64359a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final AppCompatImageButton f64360b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final RelativeLayout f64361c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final ProgressBar f64362d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final ClipView f64363f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final ClipImageView f64364g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NonNull
    public final TextView f64365h;

    public a(@NonNull RelativeLayout relativeLayout, @NonNull AppCompatImageButton appCompatImageButton, @NonNull RelativeLayout relativeLayout2, @NonNull ProgressBar progressBar, @NonNull ClipView clipView, @NonNull ClipImageView clipImageView, @NonNull TextView textView) {
        this.f64359a = relativeLayout;
        this.f64360b = appCompatImageButton;
        this.f64361c = relativeLayout2;
        this.f64362d = progressBar;
        this.f64363f = clipView;
        this.f64364g = clipImageView;
        this.f64365h = textView;
    }

    @NonNull
    public static a a(@NonNull View view) {
        int i11 = R$id.btn_back;
        AppCompatImageButton appCompatImageButton = (AppCompatImageButton) n6.b.a(view, i11);
        if (appCompatImageButton != null) {
            i11 = R$id.clTitle;
            RelativeLayout relativeLayout = (RelativeLayout) n6.b.a(view, i11);
            if (relativeLayout != null) {
                i11 = R$id.clip_loading;
                ProgressBar progressBar = (ProgressBar) n6.b.a(view, i11);
                if (progressBar != null) {
                    i11 = R$id.clipview;
                    ClipView clipView = (ClipView) n6.b.a(view, i11);
                    if (clipView != null) {
                        i11 = R$id.src_pic;
                        ClipImageView clipImageView = (ClipImageView) n6.b.a(view, i11);
                        if (clipImageView != null) {
                            i11 = R$id.tvDone;
                            TextView textView = (TextView) n6.b.a(view, i11);
                            if (textView != null) {
                                return new a((RelativeLayout) view, appCompatImageButton, relativeLayout, progressBar, clipView, clipImageView, textView);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static a c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static a d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View viewInflate = layoutInflater.inflate(R$layout.activity_clip_image, viewGroup, false);
        if (z11) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // n6.a
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public RelativeLayout getRoot() {
        return this.f64359a;
    }
}
