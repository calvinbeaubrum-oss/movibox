package com.bytedance.sdk.openadsdk.sc.pFF;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.sdk.component.utils.Tf;
import com.bytedance.sdk.openadsdk.activity.TTDelegateActivity;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGMediaView;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAd;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAdData;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAdInteractionCallback;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAdInteractionListener;
import com.bytedance.sdk.openadsdk.core.Ol;
import com.bytedance.sdk.openadsdk.core.Xc;
import com.bytedance.sdk.openadsdk.core.dE;
import com.bytedance.sdk.openadsdk.core.model.Sfl;
import com.bytedance.sdk.openadsdk.utils.JPJ;
import com.bytedance.sdk.openadsdk.utils.McK;
import com.bytedance.sdk.openadsdk.utils.cJ;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class Qj extends PAGNativeAd {
    protected int ExN;
    private boolean Ol;
    private boolean Qj;
    protected int TRI;
    protected sc We;
    protected final Sfl pFF;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    protected String f28676qr;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    protected dE f28677sc;
    protected final Context zY;

    public Qj(@NonNull Context context, @NonNull Sfl sfl, int i11, boolean z11) {
        if (sfl == null) {
            Tf.pFF("materialMeta can't been null");
        }
        this.pFF = sfl;
        this.zY = context;
        this.ExN = i11;
        this.TRI = sfl.QT();
        String strZY = cJ.zY(i11);
        this.f28676qr = strZY;
        if (z11) {
            this.We = new sc(context, sfl, strZY);
            this.f28677sc = new dE(context, this, sfl, sc(i11), this.We);
        }
    }

    private String sc(int i11) {
        if (i11 != 1) {
            return i11 != 2 ? "embeded_ad" : "interaction";
        }
        return "banner_ad";
    }

    private List<View> sc(List<View> list, List<View> list2) {
        LinkedList linkedList = new LinkedList();
        if (list != null && !list.isEmpty()) {
            int size = list.size();
            for (int i11 = 0; i11 < size; i11++) {
                linkedList.add(list.get(i11));
            }
        }
        if (list2 != null && !list2.isEmpty()) {
            int size2 = list2.size();
            for (int i12 = 0; i12 < size2; i12++) {
                linkedList.add(list2.get(i12));
            }
        }
        return linkedList;
    }

    public sc Qj() {
        return this.We;
    }

    @Override // com.bytedance.sdk.openadsdk.api.PangleAd
    public Object getExtraInfo(String str) {
        Sfl sfl = this.pFF;
        if (sfl == null || sfl.eoh() == null) {
            return null;
        }
        try {
            return this.pFF.eoh().get(str);
        } catch (Throwable th2) {
            Tf.sc("TTNativeAdImpl", th2.getMessage());
            return null;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.api.PangleAd
    public Map<String, Object> getMediaExtraInfo() {
        Sfl sfl = this.pFF;
        if (sfl != null) {
            return sfl.eoh();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAd
    public PAGNativeAdData getNativeAdData() {
        return new We(Qj());
    }

    @Override // com.bytedance.sdk.openadsdk.api.PAGClientBidding
    public void loss(Double d11, String str, String str2) {
        if (this.Ol) {
            return;
        }
        McK.sc(this.pFF, d11, str, str2);
        this.Ol = true;
    }

    public boolean qr() {
        Sfl sfl = this.pFF;
        return (sfl == null || sfl.QLv() == 5 || Xc.We().zY(this.TRI) != 1) ? false : true;
    }

    @Override // com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAd
    public void registerViewForInteraction(@NonNull ViewGroup viewGroup, @NonNull List<View> list, @Nullable List<View> list2, @Nullable View view, PAGNativeAdInteractionCallback pAGNativeAdInteractionCallback) {
        registerViewForInteraction(viewGroup, list, list2, view, (PAGNativeAdInteractionListener) pAGNativeAdInteractionCallback);
    }

    @Override // com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAd
    public void registerViewForInteraction(@NonNull ViewGroup viewGroup, @NonNull List<View> list, @Nullable List<View> list2, @Nullable View view, PAGNativeAdInteractionListener pAGNativeAdInteractionListener) {
        if (viewGroup == null) {
            Tf.pFF("container can't been null");
            return;
        }
        if (list == null) {
            Tf.pFF("clickView can't been null");
        } else if (list.size() <= 0) {
            Tf.pFF("clickViews size must been more than 1");
        } else {
            sc(viewGroup, null, list, list2, view, new qr(pAGNativeAdInteractionListener));
        }
    }

    public void sc(@NonNull ViewGroup viewGroup, @NonNull List<View> list, @NonNull List<View> list2, @Nullable List<View> list3, @Nullable View view, final TRI tri) {
        if (viewGroup == null) {
            Tf.pFF("container can't been null");
            return;
        }
        if (list2 == null) {
            Tf.pFF("clickView can't been null");
            return;
        }
        if (list2.size() <= 0) {
            Tf.pFF("clickViews size must been more than 1");
            return;
        }
        if (qr()) {
            list3 = sc(list2, list3);
        }
        List<View> list4 = list3;
        if (view != null && tri != null && tri.pFF()) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.sc.pFF.Qj.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    final String strSc = JPJ.sc();
                    TTDelegateActivity.sc(Qj.this.pFF, strSc, new com.bytedance.sdk.openadsdk.core.zY.We.sc() { // from class: com.bytedance.sdk.openadsdk.sc.pFF.Qj.1.1
                        @Override // com.bytedance.sdk.openadsdk.core.zY.We.sc
                        public void sc() {
                            tri.sc();
                            Ol.pFF().TRI(strSc);
                            PAGMediaView pAGMediaViewSc = Qj.this.Qj().sc();
                            if (pAGMediaViewSc != null) {
                                pAGMediaViewSc.close();
                            }
                        }
                    });
                }
            });
        }
        this.f28677sc.sc(viewGroup, list, list2, list4, view, tri);
        Sfl sfl = this.pFF;
        com.bytedance.sdk.openadsdk.JPJ.pFF.ExN.sc(viewGroup, this.pFF, (sfl == null || sfl.JPJ() != 2) ? null : new com.bytedance.sdk.openadsdk.JPJ.pFF.ExN.sc(this.pFF.cvk()));
    }

    public void sc(String str) {
        this.f28676qr = str;
    }

    @Override // com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAd
    public void showPrivacyActivity() {
    }

    @Override // com.bytedance.sdk.openadsdk.api.PAGClientBidding
    public void win(Double d11) {
        if (this.Qj) {
            return;
        }
        McK.sc(this.pFF, d11);
        this.Qj = true;
    }
}
