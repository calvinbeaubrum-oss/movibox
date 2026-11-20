package com.amazonaws.services.s3.internal;

import com.amazonaws.http.HttpResponse;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.services.s3.internal.ObjectExpirationResult;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class ObjectExpirationHeaderHandler<T extends ObjectExpirationResult> implements HeaderHandler<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Pattern f15958a = Pattern.compile("expiry-date=\"(.*?)\"");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Pattern f15959b = Pattern.compile("rule-id=\"(.*?)\"");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Log f15960c = LogFactory.b(ObjectExpirationHeaderHandler.class);

    @Override // com.amazonaws.services.s3.internal.HeaderHandler
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void a(T t11, HttpResponse httpResponse) {
        String str = httpResponse.c().get("x-amz-expiration");
        if (str != null) {
            t11.setExpirationTime(c(str));
            t11.setExpirationTimeRuleId(d(str));
        }
    }

    public final Date c(String str) {
        Matcher matcher = f15958a.matcher(str);
        if (!matcher.find()) {
            return null;
        }
        try {
            return ServiceUtils.e(matcher.group(1));
        } catch (Exception e11) {
            f15960c.i("Error parsing expiry-date from x-amz-expiration header.", e11);
            return null;
        }
    }

    public final String d(String str) {
        Matcher matcher = f15959b.matcher(str);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return null;
    }
}
