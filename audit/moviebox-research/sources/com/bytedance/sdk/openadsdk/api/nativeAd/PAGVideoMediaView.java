package com.bytedance.sdk.openadsdk.api.nativeAd;

import android.content.Context;
import android.view.View;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.core.Ql.pFF.TRI;
import com.bytedance.sdk.openadsdk.core.model.Sfl;
import com.bytedance.sdk.openadsdk.core.pFF.sc;
import com.bytedance.sdk.openadsdk.utils.zY;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class PAGVideoMediaView extends PAGMediaView implements sc.InterfaceC0305sc {
    private Sfl We;
    private TRI pFF;
    private final com.bytedance.sdk.openadsdk.sc.pFF.sc zY;

    public PAGVideoMediaView(Context context, @Nullable View view, @Nullable com.bytedance.sdk.openadsdk.sc.pFF.sc scVar) {
        super(context);
        sc(view);
        this.zY = scVar;
    }

    private boolean pFF() {
        TRI tri = this.pFF;
        if (tri != null) {
            return tri.Tf();
        }
        return false;
    }

    private void sc() {
        TRI tri = this.pFF;
        if (tri != null) {
            tri.SR();
        }
    }

    private void sc(View view) {
        if (view instanceof TRI) {
            TRI tri = (TRI) view;
            this.pFF = tri;
            addView(tri, -1, -1);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.api.nativeAd.PAGMediaView
    public void close() {
        TRI tri = this.pFF;
        if (tri != null) {
            tri.BT();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.pFF.sc.InterfaceC0305sc
    public long getVideoProgress() {
        TRI tri = this.pFF;
        if (tri == null || tri.getNativeVideoController() == null) {
            return 0L;
        }
        return this.pFF.getNativeVideoController().ExN();
    }

    public void handleInterruptVideo() {
        if (pFF()) {
            return;
        }
        sc();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        zY.sc(this, this.We);
    }

    public void setMaterialMeta(Sfl sfl) {
        this.We = sfl;
    }

    @Override // android.view.View
    public void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
        super.setOnClickListener(onClickListener);
        if (onClickListener instanceof sc) {
            ((sc) onClickListener).sc((sc.InterfaceC0305sc) this);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.api.nativeAd.PAGMediaView
    public void setVideoAdListener(final PAGVideoAdListener pAGVideoAdListener) {
        com.bytedance.sdk.openadsdk.sc.pFF.sc scVar = this.zY;
        if (scVar == null) {
            return;
        }
        scVar.sc(new PAGVideoAdListener() { // from class: com.bytedance.sdk.openadsdk.api.nativeAd.PAGVideoMediaView.1
            @Override // com.bytedance.sdk.openadsdk.api.nativeAd.PAGVideoAdListener
            public void onVideoAdComplete() {
                PAGVideoAdListener pAGVideoAdListener2 = pAGVideoAdListener;
                if (pAGVideoAdListener2 != null) {
                    pAGVideoAdListener2.onVideoAdComplete();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.api.nativeAd.PAGVideoAdListener
            public void onVideoAdPaused() {
                PAGVideoAdListener pAGVideoAdListener2 = pAGVideoAdListener;
                if (pAGVideoAdListener2 != null) {
                    pAGVideoAdListener2.onVideoAdPaused();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.api.nativeAd.PAGVideoAdListener
            public void onVideoAdPlay() {
                PAGVideoAdListener pAGVideoAdListener2 = pAGVideoAdListener;
                if (pAGVideoAdListener2 != null) {
                    pAGVideoAdListener2.onVideoAdPlay();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.api.nativeAd.PAGVideoAdListener
            public void onVideoError() {
                PAGVideoAdListener pAGVideoAdListener2 = pAGVideoAdListener;
                if (pAGVideoAdListener2 != null) {
                    pAGVideoAdListener2.onVideoError();
                }
            }
        });
    }
}
