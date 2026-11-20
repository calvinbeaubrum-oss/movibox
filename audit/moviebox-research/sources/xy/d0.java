package xy;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.imageview.ShapeableImageView;
import com.transsion.usercenter.R$id;
import com.transsion.usercenter.R$layout;
import com.transsion.usercenter.edit.widget.ProfileEditBar;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class d0 implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final RelativeLayout f80761a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final ProfileEditBar f80762b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final FrameLayout f80763c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final ProfileEditBar f80764d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final ImageView f80765f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final ProgressBar f80766g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NonNull
    public final RelativeLayout f80767h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NonNull
    public final RelativeLayout f80768i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NonNull
    public final RelativeLayout f80769j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @NonNull
    public final TextView f80770k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @NonNull
    public final ShapeableImageView f80771l;

    public d0(@NonNull RelativeLayout relativeLayout, @NonNull ProfileEditBar profileEditBar, @NonNull FrameLayout frameLayout, @NonNull ProfileEditBar profileEditBar2, @NonNull ImageView imageView, @NonNull ProgressBar progressBar, @NonNull RelativeLayout relativeLayout2, @NonNull RelativeLayout relativeLayout3, @NonNull RelativeLayout relativeLayout4, @NonNull TextView textView, @NonNull ShapeableImageView shapeableImageView) {
        this.f80761a = relativeLayout;
        this.f80762b = profileEditBar;
        this.f80763c = frameLayout;
        this.f80764d = profileEditBar2;
        this.f80765f = imageView;
        this.f80766g = progressBar;
        this.f80767h = relativeLayout2;
        this.f80768i = relativeLayout3;
        this.f80769j = relativeLayout4;
        this.f80770k = textView;
        this.f80771l = shapeableImageView;
    }

    @NonNull
    public static d0 a(@NonNull View view) {
        int i11 = R$id.birth_profilebar;
        ProfileEditBar profileEditBar = (ProfileEditBar) n6.b.a(view, i11);
        if (profileEditBar != null) {
            i11 = R$id.fl_edit;
            FrameLayout frameLayout = (FrameLayout) n6.b.a(view, i11);
            if (frameLayout != null) {
                i11 = R$id.gender_profilebar;
                ProfileEditBar profileEditBar2 = (ProfileEditBar) n6.b.a(view, i11);
                if (profileEditBar2 != null) {
                    i11 = R$id.iv_edit;
                    ImageView imageView = (ImageView) n6.b.a(view, i11);
                    if (imageView != null) {
                        i11 = R$id.load_view;
                        ProgressBar progressBar = (ProgressBar) n6.b.a(view, i11);
                        if (progressBar != null) {
                            i11 = R$id.rl_head;
                            RelativeLayout relativeLayout = (RelativeLayout) n6.b.a(view, i11);
                            if (relativeLayout != null) {
                                i11 = R$id.rl_nickname;
                                RelativeLayout relativeLayout2 = (RelativeLayout) n6.b.a(view, i11);
                                if (relativeLayout2 != null) {
                                    RelativeLayout relativeLayout3 = (RelativeLayout) view;
                                    i11 = R$id.tv_nickname;
                                    TextView textView = (TextView) n6.b.a(view, i11);
                                    if (textView != null) {
                                        i11 = R$id.user_head;
                                        ShapeableImageView shapeableImageView = (ShapeableImageView) n6.b.a(view, i11);
                                        if (shapeableImageView != null) {
                                            return new d0(relativeLayout3, profileEditBar, frameLayout, profileEditBar2, imageView, progressBar, relativeLayout, relativeLayout2, relativeLayout3, textView, shapeableImageView);
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
    public static d0 c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static d0 d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View viewInflate = layoutInflater.inflate(R$layout.fragment_profile_edit_centerlayout, viewGroup, false);
        if (z11) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // n6.a
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public RelativeLayout getRoot() {
        return this.f80761a;
    }
}
