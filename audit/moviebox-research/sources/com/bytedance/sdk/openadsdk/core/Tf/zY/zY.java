package com.bytedance.sdk.openadsdk.core.Tf.zY;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class zY {

    @NonNull
    private final Map<pFF, String> pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    @NonNull
    private final List<String> f28248sc;

    public zY(@NonNull List<String> list) {
        this.f28248sc = list;
        HashMap map = new HashMap();
        this.pFF = map;
        map.put(pFF.CACHEBUSTING, pFF());
    }

    @NonNull
    private String pFF() {
        return String.format(Locale.US, "%08d", Long.valueOf(Math.round(Math.random() * 1.0E8d)));
    }

    @NonNull
    private String pFF(long j11) {
        Locale locale = Locale.getDefault();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        return String.format(locale, "%02d:%02d:%02d.%03d", Long.valueOf(timeUnit.toHours(j11)), Long.valueOf(timeUnit.toMinutes(j11) % TimeUnit.HOURS.toMinutes(1L)), Long.valueOf(timeUnit.toSeconds(j11) % TimeUnit.MINUTES.toSeconds(1L)), Long.valueOf(j11 % 1000));
    }

    @NonNull
    public zY sc(@Nullable long j11) {
        if (j11 >= 0) {
            String strPFF = pFF(j11);
            if (!TextUtils.isEmpty(strPFF)) {
                this.pFF.put(pFF.CONTENTPLAYHEAD, strPFF);
            }
        }
        return this;
    }

    @NonNull
    public zY sc(@Nullable com.bytedance.sdk.openadsdk.core.Tf.sc.sc scVar) {
        if (scVar != null) {
            this.pFF.put(pFF.ERRORCODE, scVar.sc());
        }
        return this;
    }

    @NonNull
    public zY sc(@Nullable String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                str = URLEncoder.encode(str, "UTF-8");
            } catch (Throwable unused) {
            }
            this.pFF.put(pFF.ASSETURI, str);
        }
        return this;
    }

    @NonNull
    public List<String> sc() {
        ArrayList arrayList = new ArrayList();
        for (String strReplaceAll : this.f28248sc) {
            if (!TextUtils.isEmpty(strReplaceAll)) {
                for (pFF pff : pFF.values()) {
                    String str = this.pFF.get(pff);
                    if (str == null) {
                        str = "";
                    }
                    strReplaceAll = strReplaceAll.replaceAll("\\[" + pff.name() + "\\]", str);
                }
                arrayList.add(strReplaceAll);
            }
        }
        return arrayList;
    }
}
