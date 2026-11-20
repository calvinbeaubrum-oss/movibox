package com.cloud.hisavana.sdk;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.Toast;
import com.cloud.hisavana.sdk.api.view.AdCloseView;
import com.cloud.hisavana.sdk.common.activity.AdvertiserLinkActivity;
import com.cloud.hisavana.sdk.common.activity.PersonalCloseAdActivity;
import com.cloud.hisavana.sdk.common.activity.TAdInterstitialActivity;
import com.cloud.hisavana.sdk.common.bean.TaNativeInfo;
import com.cloud.hisavana.sdk.common.constant.Constants;
import com.cloud.hisavana.sdk.common.widget.expandmenu.AdExpandMenuContentView;
import com.cloud.hisavana.sdk.common.widget.expandmenu.AdExpandMenuItemView;
import com.cloud.hisavana.sdk.data.bean.response.AdsDTO;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.AdaptiveTrackSelection;
import java.lang.ref.WeakReference;
import org.mvel2.ast.ASTNode;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f29729a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public WeakReference<Object> f29730b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public WeakReference<TaNativeInfo> f29731c;

    /* JADX INFO: compiled from: source.java */
    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Object f29732a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AdsDTO f29733b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f29734c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Context f29735d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ AdCloseView f29736f;

        public a(Object obj, AdsDTO adsDTO, boolean z11, Context context, AdCloseView adCloseView) {
            this.f29732a = obj;
            this.f29733b = adsDTO;
            this.f29734c = z11;
            this.f29735d = context;
            this.f29736f = adCloseView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            z.a().d("ssp", "registerCloseAd ---- >  " + this.f29732a);
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (jCurrentTimeMillis - h.this.f29729a < AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS) {
                z.a().d("ssp", "registerCloseAd ---- > interval time not reached");
                return;
            }
            h.this.f29729a = jCurrentTimeMillis;
            if (this.f29732a == null) {
                return;
            }
            if (this.f29733b.getSource() == 4 || this.f29734c) {
                h.this.m(this.f29732a);
                return;
            }
            if (h.this.o(this.f29735d, this.f29732a, this.f29733b, this.f29736f)) {
                h.this.q(this.f29732a);
                if (!(this.f29732a instanceof u1) || this.f29733b.getDisplayRule() == Constants.AdDisplayRule.RU) {
                    return;
                }
                ((u1) this.f29732a).l().a();
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f29738a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f29739b;

        static {
            int[] iArr = new int[AdExpandMenuItemView.Type.values().length];
            f29739b = iArr;
            try {
                iArr[AdExpandMenuItemView.Type.PERSONALISE_CLOSE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f29739b[AdExpandMenuItemView.Type.ADVERTISER_INFO.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f29739b[AdExpandMenuItemView.Type.COPY_LINK.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[Constants.AdDisplayRule.values().length];
            f29738a = iArr2;
            try {
                iArr2[Constants.AdDisplayRule.RU.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f29738a[Constants.AdDisplayRule.UNIVERSAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final h f29740a = new h();
    }

    public static h p() {
        return c.f29740a;
    }

    public void d() {
        Object obj;
        WeakReference<Object> weakReference = this.f29730b;
        if (weakReference == null || (obj = weakReference.get()) == null) {
            return;
        }
        m(obj);
    }

    public void e(int i11) {
        Object obj;
        WeakReference<Object> weakReference = this.f29730b;
        if (weakReference == null || (obj = weakReference.get()) == null || obj.hashCode() != i11) {
            return;
        }
        m(obj);
    }

    public void f(Context context, AdCloseView adCloseView, Object obj, AdsDTO adsDTO) {
        g(context, adCloseView, obj, adsDTO, false);
    }

    public void g(Context context, AdCloseView adCloseView, Object obj, AdsDTO adsDTO, boolean z11) {
        if (adCloseView == null || adsDTO == null) {
            return;
        }
        z.a().d("ssp", "AdCloseManager -------> registerCloseAd ---- >");
        adCloseView.setVisibility(0);
        adCloseView.setOnClickListener(new a(obj, adsDTO, z11, context, adCloseView));
    }

    public final void i(Context context, Object obj, AdsDTO adsDTO) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("tag_ad_bean", adsDTO);
        bundle.putInt("close_hash_code", obj == null ? 0 : obj.hashCode());
        Intent intent = new Intent(context, (Class<?>) PersonalCloseAdActivity.class);
        intent.putExtras(bundle);
        if (!(context instanceof Activity)) {
            intent.setFlags(ASTNode.DEOP);
        }
        context.startActivity(intent);
    }

    public final void j(Context context, String str) {
        Intent intent = new Intent(context, (Class<?>) AdvertiserLinkActivity.class);
        intent.putExtra("url", str);
        if (!(context instanceof Activity)) {
            intent.setFlags(ASTNode.DEOP);
        }
        context.startActivity(intent);
    }

    /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
    public final void h(AdExpandMenuItemView.Type type, Context context, AdsDTO adsDTO, Object obj) {
        if (context == null || adsDTO == null || obj == null) {
            return;
        }
        int i11 = b.f29739b[type.ordinal()];
        if (i11 == 1) {
            i(context, obj, adsDTO);
            if (!(obj instanceof u1)) {
                return;
            }
        } else {
            if (i11 != 2) {
                if (i11 != 3) {
                    return;
                }
                try {
                    Object systemService = context.getSystemService("clipboard");
                    if (systemService instanceof ClipboardManager) {
                        ClipboardManager clipboardManager = (ClipboardManager) systemService;
                        ClipData clipDataNewPlainText = ClipData.newPlainText(context.getString(R$string.copy_link), w9.v.d(adsDTO));
                        if (clipDataNewPlainText != null) {
                            clipboardManager.setPrimaryClip(clipDataNewPlainText);
                            Toast.makeText(context, context.getString(R$string.copy_successfully), 0).show();
                            return;
                        }
                        return;
                    }
                    return;
                } catch (Exception e11) {
                    z.a().e("ssp", Log.getStackTraceString(e11));
                    return;
                }
            }
            j(context, w9.v.b(adsDTO));
            if (!(obj instanceof u1)) {
                return;
            }
        }
        ((u1) obj).l().a();
    }

    public final void m(Object obj) {
        TaNativeInfo taNativeInfo;
        if (obj == null) {
            return;
        }
        if (obj instanceof u1) {
            ((u1) obj).L0();
            return;
        }
        if (obj instanceof j2) {
            ((j2) obj).F0();
            return;
        }
        if (!(obj instanceof n2)) {
            if (obj instanceof TAdInterstitialActivity) {
                ((TAdInterstitialActivity) obj).l0();
            }
        } else {
            WeakReference<TaNativeInfo> weakReference = this.f29731c;
            if (weakReference == null || (taNativeInfo = weakReference.get()) == null) {
                return;
            }
            ((n2) obj).V0(taNativeInfo);
        }
    }

    public void n(Object obj, TaNativeInfo taNativeInfo) {
        this.f29730b = new WeakReference<>(obj);
        this.f29731c = new WeakReference<>(taNativeInfo);
    }

    public boolean o(final Context context, final Object obj, final AdsDTO adsDTO, AdCloseView adCloseView) {
        if (context != null && adsDTO != null) {
            int i11 = b.f29738a[adsDTO.getDisplayRule().ordinal()];
            if (i11 != 1) {
                if (i11 == 2) {
                    i(context, obj, adsDTO);
                }
            } else if (obj != null && adCloseView != null) {
                PopupWindow popupWindowI = com.cloud.hisavana.sdk.common.widget.expandmenu.a.i(adCloseView, w9.v.a(adsDTO), new AdExpandMenuContentView.d() { // from class: com.cloud.hisavana.sdk.g
                    @Override // com.cloud.hisavana.sdk.common.widget.expandmenu.AdExpandMenuContentView.d
                    public final void a(AdExpandMenuItemView.Type type) {
                        this.f29712a.h(context, adsDTO, obj, type);
                    }
                });
                if (obj instanceof u1) {
                    ((u1) obj).i1(popupWindowI);
                }
            }
            return true;
        }
        return false;
    }

    public void q(Object obj) {
        this.f29730b = new WeakReference<>(obj);
    }

    public long r() {
        return this.f29729a;
    }
}
