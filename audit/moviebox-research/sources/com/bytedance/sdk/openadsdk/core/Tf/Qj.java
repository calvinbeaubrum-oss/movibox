package com.bytedance.sdk.openadsdk.core.Tf;

import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import com.bytedance.sdk.component.utils.Tf;
import com.iab.omid.library.bytedance2.adsession.AdEvents;
import com.iab.omid.library.bytedance2.adsession.AdSession;
import com.iab.omid.library.bytedance2.adsession.AdSessionConfiguration;
import com.iab.omid.library.bytedance2.adsession.AdSessionContext;
import com.iab.omid.library.bytedance2.adsession.CreativeType;
import com.iab.omid.library.bytedance2.adsession.ImpressionType;
import com.iab.omid.library.bytedance2.adsession.Owner;
import com.iab.omid.library.bytedance2.adsession.Partner;
import com.iab.omid.library.bytedance2.adsession.VerificationScriptResource;
import com.iab.omid.library.bytedance2.adsession.media.MediaEvents;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class Qj {
    @NonNull
    public static qr sc(@NonNull View view, @NonNull Set<WH> set) {
        AdSession adSessionSc = sc(CreativeType.VIDEO, set, Owner.NATIVE);
        return new Ol(adSessionSc, AdEvents.createAdEvents(adSessionSc), view, MediaEvents.createMediaEvents(adSessionSc));
    }

    public static qr sc(WebView webView) {
        Partner partnerSc = ExN.sc();
        if (partnerSc == null) {
            throw new IllegalArgumentException("Parameter 'partner' may not be null.");
        }
        AdSession adSessionCreateAdSession = AdSession.createAdSession(AdSessionConfiguration.createAdSessionConfiguration(CreativeType.HTML_DISPLAY, ImpressionType.BEGIN_TO_RENDER, Owner.NATIVE, Owner.NONE, false), AdSessionContext.createHtmlAdSessionContext(partnerSc, webView, "", ""));
        return new qr(adSessionCreateAdSession, AdEvents.createAdEvents(adSessionCreateAdSession), webView);
    }

    private static AdSession sc(CreativeType creativeType, Set<WH> set, Owner owner) {
        List<VerificationScriptResource> listSc = sc(set);
        if (listSc.isEmpty()) {
            Tf.pFF("verificationScriptResources is empty");
        }
        Partner partnerSc = ExN.sc();
        if (partnerSc == null) {
            return null;
        }
        return AdSession.createAdSession(AdSessionConfiguration.createAdSessionConfiguration(creativeType, ImpressionType.BEGIN_TO_RENDER, Owner.NATIVE, owner, false), AdSessionContext.createNativeAdSessionContext(partnerSc, ExN.pFF(), listSc, "", ""));
    }

    private static List<VerificationScriptResource> sc(Set<WH> set) {
        ArrayList arrayList = new ArrayList();
        for (WH wh2 : set) {
            try {
                if (TextUtils.isEmpty(wh2.sc()) || TextUtils.isEmpty(wh2.pFF())) {
                    arrayList.add(VerificationScriptResource.createVerificationScriptResourceWithoutParameters(wh2.zY()));
                } else {
                    arrayList.add(VerificationScriptResource.createVerificationScriptResourceWithParameters(wh2.sc(), wh2.zY(), wh2.pFF()));
                }
            } catch (Throwable unused) {
            }
        }
        return arrayList;
    }
}
