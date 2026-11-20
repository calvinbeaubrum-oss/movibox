package rz;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.transsion.videodetail.R$id;
import com.transsion.videodetail.R$layout;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class k implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final LinearLayoutCompat f75882a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f75883b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f75884c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f75885d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f75886f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f75887g;

    public k(@NonNull LinearLayoutCompat linearLayoutCompat, @NonNull AppCompatImageView appCompatImageView, @NonNull AppCompatImageView appCompatImageView2, @NonNull AppCompatImageView appCompatImageView3, @NonNull AppCompatImageView appCompatImageView4, @NonNull AppCompatTextView appCompatTextView) {
        this.f75882a = linearLayoutCompat;
        this.f75883b = appCompatImageView;
        this.f75884c = appCompatImageView2;
        this.f75885d = appCompatImageView3;
        this.f75886f = appCompatImageView4;
        this.f75887g = appCompatTextView;
    }

    @NonNull
    public static k a(@NonNull View view) {
        int i11 = R$id.ivClose;
        AppCompatImageView appCompatImageView = (AppCompatImageView) n6.b.a(view, i11);
        if (appCompatImageView != null) {
            i11 = R$id.ivDance;
            AppCompatImageView appCompatImageView2 = (AppCompatImageView) n6.b.a(view, i11);
            if (appCompatImageView2 != null) {
                i11 = R$id.ivLoop;
                AppCompatImageView appCompatImageView3 = (AppCompatImageView) n6.b.a(view, i11);
                if (appCompatImageView3 != null) {
                    i11 = R$id.ivShuffle;
                    AppCompatImageView appCompatImageView4 = (AppCompatImageView) n6.b.a(view, i11);
                    if (appCompatImageView4 != null) {
                        i11 = R$id.tvTitle;
                        AppCompatTextView appCompatTextView = (AppCompatTextView) n6.b.a(view, i11);
                        if (appCompatTextView != null) {
                            return new k((LinearLayoutCompat) view, appCompatImageView, appCompatImageView2, appCompatImageView3, appCompatImageView4, appCompatTextView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static k c(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View viewInflate = layoutInflater.inflate(R$layout.view_music_detail_list_operate_layout, viewGroup, false);
        if (z11) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // n6.a
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayoutCompat getRoot() {
        return this.f75882a;
    }
}
