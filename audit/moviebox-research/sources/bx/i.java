package bx;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.search.R$id;
import com.transsion.search.R$layout;
import com.transsion.search.speech.SpeechRecognizerView;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class i implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f14492a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final EditText f14493b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final ImageView f14494c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f14495d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final LinearLayout f14496f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final SpeechRecognizerView f14497g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NonNull
    public final ImageView f14498h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NonNull
    public final FrameLayout f14499i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NonNull
    public final View f14500j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @NonNull
    public final TextView f14501k;

    public i(@NonNull ConstraintLayout constraintLayout, @NonNull EditText editText, @NonNull ImageView imageView, @NonNull AppCompatImageView appCompatImageView, @NonNull LinearLayout linearLayout, @NonNull SpeechRecognizerView speechRecognizerView, @NonNull ImageView imageView2, @NonNull FrameLayout frameLayout, @NonNull View view, @NonNull TextView textView) {
        this.f14492a = constraintLayout;
        this.f14493b = editText;
        this.f14494c = imageView;
        this.f14495d = appCompatImageView;
        this.f14496f = linearLayout;
        this.f14497g = speechRecognizerView;
        this.f14498h = imageView2;
        this.f14499i = frameLayout;
        this.f14500j = view;
        this.f14501k = textView;
    }

    @NonNull
    public static i a(@NonNull View view) {
        View viewA;
        int i11 = R$id.comment_input_edit_text;
        EditText editText = (EditText) n6.b.a(view, i11);
        if (editText != null) {
            i11 = R$id.comment_input_search_icon;
            ImageView imageView = (ImageView) n6.b.a(view, i11);
            if (imageView != null) {
                i11 = R$id.iv_cancel;
                AppCompatImageView appCompatImageView = (AppCompatImageView) n6.b.a(view, i11);
                if (appCompatImageView != null) {
                    i11 = R$id.ll_top;
                    LinearLayout linearLayout = (LinearLayout) n6.b.a(view, i11);
                    if (linearLayout != null) {
                        i11 = R$id.sRView;
                        SpeechRecognizerView speechRecognizerView = (SpeechRecognizerView) n6.b.a(view, i11);
                        if (speechRecognizerView != null) {
                            i11 = R$id.search_edit_clear;
                            ImageView imageView2 = (ImageView) n6.b.a(view, i11);
                            if (imageView2 != null) {
                                i11 = R$id.search_fragment_container;
                                FrameLayout frameLayout = (FrameLayout) n6.b.a(view, i11);
                                if (frameLayout != null && (viewA = n6.b.a(view, (i11 = R$id.top_line))) != null) {
                                    i11 = R$id.tv_search;
                                    TextView textView = (TextView) n6.b.a(view, i11);
                                    if (textView != null) {
                                        return new i((ConstraintLayout) view, editText, imageView, appCompatImageView, linearLayout, speechRecognizerView, imageView2, frameLayout, viewA, textView);
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
    public static i c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static i d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View viewInflate = layoutInflater.inflate(R$layout.fragment_search_subject, viewGroup, false);
        if (z11) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // n6.a
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f14492a;
    }
}
