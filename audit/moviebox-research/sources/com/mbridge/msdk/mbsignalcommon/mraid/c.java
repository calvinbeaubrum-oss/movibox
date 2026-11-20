package com.mbridge.msdk.mbsignalcommon.mraid;

import android.net.Uri;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.x;
import com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile ConcurrentHashMap<String, String> f45739a = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static ArrayList<String> f45740b = new ArrayList<>();

    public static com.mbridge.msdk.mbsignalcommon.windvane.a a(WindVaneWebView windVaneWebView, String str) {
        Set<String> setUnmodifiableSet;
        Uri uri = Uri.parse(str);
        String scheme = uri.getScheme();
        if (TextUtils.isEmpty(scheme) || !scheme.contains(CampaignEx.JSON_KEY_MRAID)) {
            return null;
        }
        com.mbridge.msdk.mbsignalcommon.windvane.a aVar = new com.mbridge.msdk.mbsignalcommon.windvane.a();
        aVar.f45776d = x.a("n+ztLkxpVTzBLkxgHN==");
        aVar.f45777e = uri.getHost();
        int i11 = 0;
        if (f45740b.size() == 0) {
            for (Method method : b.class.getDeclaredMethods()) {
                f45740b.add(method.getName());
            }
        }
        if (!f45740b.contains(aVar.f45777e) && windVaneWebView != null) {
            String campaignId = windVaneWebView.getCampaignId();
            String str2 = aVar.f45777e;
            if (!TextUtils.isEmpty(campaignId)) {
                if (f45739a.containsKey(campaignId)) {
                    String strConcat = f45739a.get(campaignId);
                    if (!TextUtils.isEmpty(str2) && !strConcat.contains(str2)) {
                        if (strConcat.length() > 0) {
                            strConcat = strConcat.concat(",");
                        }
                        f45739a.put(campaignId, strConcat.concat(str2));
                    }
                } else {
                    f45739a.put(campaignId, str2);
                }
            }
            a.C0501a.f45738a.a(windVaneWebView, aVar.f45777e);
            a.C0501a.f45738a.a(windVaneWebView, aVar.f45777e, "Specified command is not implemented");
            return null;
        }
        String encodedQuery = uri.getEncodedQuery();
        if (encodedQuery == null) {
            setUnmodifiableSet = Collections.emptySet();
        } else {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            do {
                int iIndexOf = encodedQuery.indexOf(38, i11);
                if (iIndexOf == -1) {
                    iIndexOf = encodedQuery.length();
                }
                int iIndexOf2 = encodedQuery.indexOf(61, i11);
                if (iIndexOf2 > iIndexOf || iIndexOf2 == -1) {
                    iIndexOf2 = iIndexOf;
                }
                linkedHashSet.add(Uri.decode(encodedQuery.substring(i11, iIndexOf2)));
                i11 = iIndexOf + 1;
            } while (i11 < encodedQuery.length());
            setUnmodifiableSet = Collections.unmodifiableSet(linkedHashSet);
        }
        try {
            JSONObject jSONObject = new JSONObject();
            for (String str3 : setUnmodifiableSet) {
                jSONObject.put(str3, uri.getQueryParameter(str3));
            }
            aVar.f45778f = jSONObject.toString();
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        return aVar;
    }

    public static String a(String str) {
        if (f45739a.containsKey(str)) {
            return f45739a.get(str);
        }
        return null;
    }

    public static void b(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        f45739a.remove(str);
    }
}
