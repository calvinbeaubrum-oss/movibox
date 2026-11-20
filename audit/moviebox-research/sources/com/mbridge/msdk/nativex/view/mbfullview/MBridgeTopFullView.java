package com.mbridge.msdk.nativex.view.mbfullview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.mbridge.msdk.foundation.tools.v;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class MBridgeTopFullView extends BaseView {
    public static final String INTERFACE_RESULT = MBridgeTopFullView.class.getName() + "WithResault";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    protected ImageView f45944j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    protected TextView f45945k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    protected TextView f45946l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    protected StarLevelLayoutView f45947m;

    public MBridgeTopFullView(Context context) {
        super(context);
        View viewInflate = LayoutInflater.from(getContext()).inflate(v.a(getContext(), "mbridge_nativex_fullscreen_top", TtmlNode.TAG_LAYOUT), this.f45940i);
        if (viewInflate != null) {
            this.f45944j = (ImageView) viewInflate.findViewById(v.a(getContext(), "mbridge_full_tv_display_icon", "id"));
            this.f45945k = (TextView) viewInflate.findViewById(v.a(getContext(), "mbridge_full_tv_display_title", "id"));
            this.f45946l = (TextView) viewInflate.findViewById(v.a(getContext(), "mbridge_full_tv_display_description", "id"));
            this.f45947m = (StarLevelLayoutView) viewInflate.findViewById(v.a(getContext(), "mbridge_full_tv_feeds_star", "id"));
            this.f45946l.setTextColor(-7829368);
            viewInflate.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            updateLayoutParams();
        }
    }

    public TextView getMBridgeFullViewDisplayDscription() {
        return this.f45946l;
    }

    public ImageView getMBridgeFullViewDisplayIcon() {
        return this.f45944j;
    }

    public TextView getMBridgeFullViewDisplayTitle() {
        return this.f45945k;
    }

    public StarLevelLayoutView getStarLevelLayoutView() {
        return this.f45947m;
    }

    public void updateLayoutParams() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(10);
        this.f45932a.setLayoutParams(layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.addRule(10);
        this.f45933b.setLayoutParams(layoutParams2);
    }
}
