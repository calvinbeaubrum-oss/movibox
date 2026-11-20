package com.mbridge.msdk.video.module;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.mbridge.msdk.video.signal.factory.b;
import com.mbridge.msdk.widget.a;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class MBridgeVastEndCardView extends MBridgeBaseView {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private ViewGroup f47906n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private View f47907o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private View f47908p;

    public MBridgeVastEndCardView(Context context) {
        super(context);
    }

    public MBridgeVastEndCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.mbridge.msdk.video.module.MBridgeBaseView
    public final void c() {
        super.c();
        if (this.f47795f) {
            this.f47907o.setOnClickListener(new View.OnClickListener() { // from class: com.mbridge.msdk.video.module.MBridgeVastEndCardView.1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MBridgeVastEndCardView.this.f47794e.a(104, "");
                }
            });
            this.f47908p.setOnClickListener(new a() { // from class: com.mbridge.msdk.video.module.MBridgeVastEndCardView.2
                @Override // com.mbridge.msdk.widget.a
                public final void a(View view) {
                    MBridgeVastEndCardView mBridgeVastEndCardView = MBridgeVastEndCardView.this;
                    mBridgeVastEndCardView.f47794e.a(108, mBridgeVastEndCardView.d());
                }
            });
        }
    }

    @Override // com.mbridge.msdk.video.module.MBridgeBaseView
    public void init(Context context) {
        int iFindLayout = findLayout("mbridge_reward_endcard_vast");
        if (iFindLayout >= 0) {
            this.f47792c.inflate(iFindLayout, this);
            this.f47906n = (ViewGroup) findViewById(findID("mbridge_rl_content"));
            this.f47907o = findViewById(findID("mbridge_iv_vastclose"));
            View viewFindViewById = findViewById(findID("mbridge_iv_vastok"));
            this.f47908p = viewFindViewById;
            this.f47795f = isNotNULL(this.f47906n, this.f47907o, viewFindViewById);
            c();
            if (this.f47795f) {
                setMatchParent();
                setBackgroundResource(findColor("mbridge_reward_endcard_vast_bg"));
                setClickable(true);
                ((RelativeLayout.LayoutParams) this.f47906n.getLayoutParams()).addRule(13, -1);
            }
        }
    }

    public void notifyShowListener() {
        this.f47794e.a(111, "");
    }

    public void preLoadData(b bVar) {
    }
}
