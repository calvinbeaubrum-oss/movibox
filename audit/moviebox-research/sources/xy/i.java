package xy;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tn.lib.view.TitleLayout;
import com.transsion.usercenter.ProfileSettingTitleLayout;
import com.transsion.usercenter.R$id;
import com.transsion.usercenter.R$layout;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class i implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f80816a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final ImageView f80817b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final ImageView f80818c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final ProfileSettingTitleLayout f80819d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final ProfileSettingTitleLayout f80820f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final TitleLayout f80821g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NonNull
    public final ProfileSettingTitleLayout f80822h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NonNull
    public final TextView f80823i;

    public i(@NonNull ConstraintLayout constraintLayout, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull ProfileSettingTitleLayout profileSettingTitleLayout, @NonNull ProfileSettingTitleLayout profileSettingTitleLayout2, @NonNull TitleLayout titleLayout, @NonNull ProfileSettingTitleLayout profileSettingTitleLayout3, @NonNull TextView textView) {
        this.f80816a = constraintLayout;
        this.f80817b = imageView;
        this.f80818c = imageView2;
        this.f80819d = profileSettingTitleLayout;
        this.f80820f = profileSettingTitleLayout2;
        this.f80821g = titleLayout;
        this.f80822h = profileSettingTitleLayout3;
        this.f80823i = textView;
    }

    @NonNull
    public static i a(@NonNull View view) {
        int i11 = R$id.ivAvatar;
        ImageView imageView = (ImageView) n6.b.a(view, i11);
        if (imageView != null) {
            i11 = R$id.ivRight;
            ImageView imageView2 = (ImageView) n6.b.a(view, i11);
            if (imageView2 != null) {
                i11 = R$id.titleBirth;
                ProfileSettingTitleLayout profileSettingTitleLayout = (ProfileSettingTitleLayout) n6.b.a(view, i11);
                if (profileSettingTitleLayout != null) {
                    i11 = R$id.titleGender;
                    ProfileSettingTitleLayout profileSettingTitleLayout2 = (ProfileSettingTitleLayout) n6.b.a(view, i11);
                    if (profileSettingTitleLayout2 != null) {
                        i11 = R$id.titleLayout;
                        TitleLayout titleLayout = (TitleLayout) n6.b.a(view, i11);
                        if (titleLayout != null) {
                            i11 = R$id.titleRegion;
                            ProfileSettingTitleLayout profileSettingTitleLayout3 = (ProfileSettingTitleLayout) n6.b.a(view, i11);
                            if (profileSettingTitleLayout3 != null) {
                                i11 = R$id.tvNickName;
                                TextView textView = (TextView) n6.b.a(view, i11);
                                if (textView != null) {
                                    return new i((ConstraintLayout) view, imageView, imageView2, profileSettingTitleLayout, profileSettingTitleLayout2, titleLayout, profileSettingTitleLayout3, textView);
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
        View viewInflate = layoutInflater.inflate(R$layout.activity_profile_edit, viewGroup, false);
        if (z11) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // n6.a
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f80816a;
    }
}
