package bx;

import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import com.transsion.search.R$id;
import com.transsion.search.speech.SpeechRecognizerVolumeCircleView;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class b implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final FrameLayout f14437a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f14438b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final FrameLayout f14439c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f14440d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f14441f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final View f14442g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NonNull
    public final SpeechRecognizerVolumeCircleView f14443h;

    public b(@NonNull FrameLayout frameLayout, @NonNull AppCompatImageView appCompatImageView, @NonNull FrameLayout frameLayout2, @NonNull AppCompatTextView appCompatTextView, @NonNull AppCompatTextView appCompatTextView2, @NonNull View view, @NonNull SpeechRecognizerVolumeCircleView speechRecognizerVolumeCircleView) {
        this.f14437a = frameLayout;
        this.f14438b = appCompatImageView;
        this.f14439c = frameLayout2;
        this.f14440d = appCompatTextView;
        this.f14441f = appCompatTextView2;
        this.f14442g = view;
        this.f14443h = speechRecognizerVolumeCircleView;
    }

    @NonNull
    public static b a(@NonNull View view) {
        View viewA;
        int i11 = R$id.ivClose;
        AppCompatImageView appCompatImageView = (AppCompatImageView) n6.b.a(view, i11);
        if (appCompatImageView != null) {
            i11 = R$id.llTop;
            FrameLayout frameLayout = (FrameLayout) n6.b.a(view, i11);
            if (frameLayout != null) {
                i11 = R$id.tvResult;
                AppCompatTextView appCompatTextView = (AppCompatTextView) n6.b.a(view, i11);
                if (appCompatTextView != null) {
                    i11 = R$id.tvTip;
                    AppCompatTextView appCompatTextView2 = (AppCompatTextView) n6.b.a(view, i11);
                    if (appCompatTextView2 != null && (viewA = n6.b.a(view, (i11 = R$id.viewBg))) != null) {
                        i11 = R$id.volumeCircleView;
                        SpeechRecognizerVolumeCircleView speechRecognizerVolumeCircleView = (SpeechRecognizerVolumeCircleView) n6.b.a(view, i11);
                        if (speechRecognizerVolumeCircleView != null) {
                            return new b((FrameLayout) view, appCompatImageView, frameLayout, appCompatTextView, appCompatTextView2, viewA, speechRecognizerVolumeCircleView);
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
    public FrameLayout getRoot() {
        return this.f14437a;
    }
}
