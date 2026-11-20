package com.bytedance.sdk.openadsdk.zY;

import android.app.Activity;
import android.content.Context;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.core.WP;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class zY implements WP {
    private WP.sc ExN;
    private boolean We;
    private final Context pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    public Tf f28825sc;
    private We zY;

    public zY(Context context, String str, List<FilterWord> list, String str2, String str3) {
        if (!(context instanceof Activity)) {
            com.bytedance.sdk.component.utils.Tf.pFF("Dislike Initialization must use activity, please pass in TTAdManager.createAdNative(activity)");
        }
        this.pFF = context;
        sc(str, list, str2, str3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void We() {
        Context context = this.pFF;
        if ((context instanceof Activity) && (!((Activity) context).isFinishing()) && !this.f28825sc.isShowing()) {
            this.f28825sc.show();
        }
    }

    private void sc(String str, List<FilterWord> list, String str2, String str3) {
        this.zY = new We(this.pFF, str, list, str3);
        Tf tf2 = new Tf(this.pFF, this.zY.getDislikeManager());
        this.f28825sc = tf2;
        tf2.sc(str, str2);
        this.f28825sc.sc(str3);
        this.f28825sc.sc(new Tf.sc() { // from class: com.bytedance.sdk.openadsdk.zY.zY.1
            @Override // com.bytedance.sdk.openadsdk.zY.Tf.sc
            public void pFF() {
                zY.this.sc();
            }

            @Override // com.bytedance.sdk.openadsdk.zY.Tf.sc
            public void sc() {
            }

            @Override // com.bytedance.sdk.openadsdk.zY.Tf.sc
            public void sc(int i11, FilterWord filterWord, String str4) {
                zY.this.zY.onSuggestionSubmit(str4);
                zY.this.sc();
            }

            @Override // com.bytedance.sdk.openadsdk.zY.Tf.sc
            public void zY() {
                zY.this.sc();
            }
        });
        this.zY.sc(new We.sc() { // from class: com.bytedance.sdk.openadsdk.zY.zY.2
            @Override // com.bytedance.sdk.openadsdk.zY.We.sc
            public void pFF() {
                com.bytedance.sdk.component.utils.Tf.sc("TTAdDislikeImpl", "onDislikeDismiss: ");
                try {
                    if (zY.this.ExN != null) {
                        zY.this.ExN.sc();
                    }
                } catch (Throwable th2) {
                    com.bytedance.sdk.component.utils.Tf.sc("TTAdDislikeImpl", "dislike callback cancel error: ", th2);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.zY.We.sc
            public void sc() {
                zY.this.sc(true);
                if (zY.this.zY != null && zY.this.zY.isShowing()) {
                    zY.this.zY.hide();
                }
                zY.this.We();
            }

            @Override // com.bytedance.sdk.openadsdk.zY.We.sc
            public void sc(int i11, FilterWord filterWord) {
                try {
                    if (!filterWord.hasSecondOptions() && zY.this.ExN != null) {
                        zY.this.ExN.sc(i11, filterWord.getName());
                    }
                    com.bytedance.sdk.component.utils.Tf.sc("TTAdDislikeImpl", "onDislikeSelected: " + i11 + ", " + filterWord.getName());
                } catch (Throwable th2) {
                    com.bytedance.sdk.component.utils.Tf.sc("TTAdDislikeImpl", "dislike callback selected error: ", th2);
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.WP
    public void pFF() {
        We we2 = this.zY;
        if (we2 != null) {
            we2.destroy();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.WP
    public void sc() {
        Context context = this.pFF;
        if (!(context instanceof Activity) || ((Activity) context).isFinishing() || this.zY.isShowing()) {
            return;
        }
        this.zY.show();
    }

    @Override // com.bytedance.sdk.openadsdk.core.WP
    public void sc(WP.sc scVar) {
        this.ExN = scVar;
    }

    public void sc(String str) {
        We we2 = this.zY;
        if (we2 != null) {
            we2.sc(str);
        }
    }

    public void sc(boolean z11) {
        this.We = z11;
    }

    public boolean zY() {
        return this.We;
    }
}
