package com.applovin.impl;

import android.net.Uri;
import com.applovin.impl.mediation.MaxErrorImpl;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.mediation.MaxError;
import com.applovin.mediation.adapter.MaxAdapterError;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class rm extends yl {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final String f22146h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final List f22147i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final pe f22148j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final Map f22149k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final Map f22150l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final Map f22151m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final MaxError f22152n;

    public rm(String str, List list, Map map, Map map2, MaxError maxError, pe peVar, com.applovin.impl.sdk.j jVar, boolean z11) {
        super("TaskFireMediationPostbacks", jVar);
        this.f22146h = str + "_urls";
        this.f22147i = list;
        this.f22149k = yp.a(map, jVar);
        this.f22150l = map2 == null ? new HashMap() : map2;
        this.f22152n = maxError != null ? maxError : new MaxErrorImpl(-1);
        this.f22148j = peVar;
        HashMap map3 = new HashMap(7);
        map3.put("AppLovin-Event-Type", str);
        if (z11 && peVar != null) {
            map3.put("AppLovin-Ad-Network-Name", peVar.c());
        }
        if (peVar instanceof ge) {
            ge geVar = (ge) peVar;
            map3.put("AppLovin-Ad-Unit-Id", geVar.getAdUnitId());
            map3.put("AppLovin-Ad-Format", geVar.getFormat().getLabel());
            if (z11) {
                map3.put("AppLovin-Third-Party-Ad-Placement-Id", geVar.V());
            }
        }
        if (maxError != null) {
            map3.put("AppLovin-Error-Code", String.valueOf(maxError.getCode()));
            map3.put("AppLovin-Error-Message", maxError.getMessage());
        }
        this.f22151m = map3;
    }

    private String a(String str, MaxError maxError) {
        int mediatedNetworkErrorCode;
        String mediatedNetworkErrorMessage;
        if (maxError instanceof MaxAdapterError) {
            MaxAdapterError maxAdapterError = (MaxAdapterError) maxError;
            mediatedNetworkErrorCode = maxAdapterError.getMediatedNetworkErrorCode();
            mediatedNetworkErrorMessage = maxAdapterError.getMediatedNetworkErrorMessage();
        } else {
            mediatedNetworkErrorCode = 0;
            mediatedNetworkErrorMessage = "";
        }
        return str.replace("{ERROR_CODE}", String.valueOf(maxError.getCode())).replace("{ERROR_MESSAGE}", StringUtils.encodeUriString(maxError.getMessage())).replace("{THIRD_PARTY_SDK_ERROR_CODE}", String.valueOf(mediatedNetworkErrorCode)).replace("{THIRD_PARTY_SDK_ERROR_MESSAGE}", StringUtils.encodeUriString(mediatedNetworkErrorMessage));
    }

    private void a(String str, Map map) {
        b().X().e(com.applovin.impl.sdk.network.d.b().d(str).c("POST").a(this.f22151m).a(false).c(map).c(((Boolean) this.f24689a.a(ve.T7)).booleanValue()).a());
    }

    private String b(String str, Map map) {
        for (String str2 : map.keySet()) {
            str = str.replace(str2, StringUtils.emptyIfNull((String) map.get(str2)));
        }
        return str;
    }

    private Map e() {
        try {
            return JsonUtils.toStringMap(new JSONObject((String) this.f24689a.a(ve.O6)));
        } catch (JSONException unused) {
            return Collections.EMPTY_MAP;
        }
    }

    private List f() {
        List list = this.f22147i;
        if (list != null) {
            return list;
        }
        pe peVar = this.f22148j;
        if (peVar != null) {
            return peVar.b(this.f22146h);
        }
        return null;
    }

    @Override // java.lang.Runnable
    public void run() {
        List listF = f();
        if (CollectionUtils.isEmpty(listF)) {
            return;
        }
        Map mapE = e();
        Iterator it = listF.iterator();
        while (it.hasNext()) {
            Uri uri = Uri.parse(a(b((String) it.next(), this.f22149k), this.f22152n));
            Uri.Builder builderClearQuery = uri.buildUpon().clearQuery();
            HashMap map = new HashMap(this.f22150l);
            for (String str : uri.getQueryParameterNames()) {
                String queryParameter = uri.getQueryParameter(str);
                if (mapE.containsKey(queryParameter)) {
                    pe peVar = this.f22148j;
                    if (peVar != null) {
                        map.put(str, peVar.a((String) mapE.get(queryParameter)));
                    }
                } else {
                    builderClearQuery.appendQueryParameter(str, queryParameter);
                }
            }
            map.putAll(this.f24689a.y().e());
            a(builderClearQuery.build().toString(), map);
        }
    }
}
