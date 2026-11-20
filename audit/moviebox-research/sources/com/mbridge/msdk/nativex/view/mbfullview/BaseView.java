package com.mbridge.msdk.nativex.view.mbfullview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.mbridge.msdk.foundation.tools.v;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class BaseView extends RelativeLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected RelativeLayout f45932a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected RelativeLayout f45933b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected RelativeLayout f45934c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected ImageView f45935d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected TextView f45936e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected ProgressBar f45937f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected FrameLayout f45938g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    protected LinearLayout f45939h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    protected RelativeLayout f45940i;
    public a style;

    /* JADX INFO: compiled from: source.java */
    public enum a {
        FULL_TOP_VIEW,
        FULL_MIDDLE_VIEW
    }

    public BaseView(Context context) {
        super(context);
        View viewInflate = LayoutInflater.from(getContext()).inflate(v.a(getContext(), "mbridge_nativex_fullbasescreen", TtmlNode.TAG_LAYOUT), this);
        this.f45940i = (RelativeLayout) viewInflate;
        if (viewInflate != null) {
            this.f45932a = (RelativeLayout) viewInflate.findViewById(v.a(getContext(), "mbridge_full_rl_playcontainer", "id"));
            this.f45933b = (RelativeLayout) viewInflate.findViewById(v.a(getContext(), "mbridge_full_player_parent", "id"));
            this.f45934c = (RelativeLayout) viewInflate.findViewById(v.a(getContext(), "mbridge_full_rl_close", "id"));
            this.f45935d = (ImageView) viewInflate.findViewById(v.a(getContext(), "mbridge_full_iv_close", "id"));
            this.f45936e = (TextView) viewInflate.findViewById(v.a(getContext(), "mbridge_full_tv_install", "id"));
            this.f45937f = (ProgressBar) viewInflate.findViewById(v.a(getContext(), "mbridge_full_pb_loading", "id"));
            this.f45938g = (FrameLayout) viewInflate.findViewById(v.a(getContext(), "mbridge_full_animation_content", "id"));
            this.f45939h = (LinearLayout) viewInflate.findViewById(v.a(getContext(), "mbridge_full_animation_player", "id"));
            viewInflate.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        }
    }

    public RelativeLayout getMBridgeFullClose() {
        return this.f45934c;
    }

    public ImageView getMBridgeFullIvClose() {
        return this.f45935d;
    }

    public ProgressBar getMBridgeFullPb() {
        return this.f45937f;
    }

    public RelativeLayout getMBridgeFullPlayContainer() {
        return this.f45932a;
    }

    public RelativeLayout getMBridgeFullPlayerParent() {
        return this.f45933b;
    }

    public TextView getMBridgeFullTvInstall() {
        return this.f45936e;
    }

    public a getStytle() {
        return this.style;
    }

    public FrameLayout getmAnimationContent() {
        return this.f45938g;
    }

    public LinearLayout getmAnimationPlayer() {
        return this.f45939h;
    }

    public void setStytle(a aVar) {
        this.style = aVar;
    }
}
