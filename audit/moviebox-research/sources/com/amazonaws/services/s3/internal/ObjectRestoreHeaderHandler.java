package com.amazonaws.services.s3.internal;

import com.amazonaws.http.HttpResponse;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.services.s3.internal.ObjectRestoreResult;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class ObjectRestoreHeaderHandler<T extends ObjectRestoreResult> implements HeaderHandler<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Pattern f15961a = Pattern.compile("expiry-date=\"(.*?)\"");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Pattern f15962b = Pattern.compile("ongoing-request=\"(.*?)\"");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Log f15963c = LogFactory.b(ObjectRestoreHeaderHandler.class);

    private Date d(String str) {
        Matcher matcher = f15961a.matcher(str);
        if (!matcher.find()) {
            return null;
        }
        try {
            return ServiceUtils.e(matcher.group(1));
        } catch (Exception e11) {
            f15963c.i("Error parsing expiry-date from x-amz-restore header.", e11);
            return null;
        }
    }

    @Override // com.amazonaws.services.s3.internal.HeaderHandler
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void a(T t11, HttpResponse httpResponse) {
        String str = httpResponse.c().get("x-amz-restore");
        if (str != null) {
            t11.setRestoreExpirationTime(d(str));
            Boolean boolC = c(str);
            if (boolC != null) {
                t11.setOngoingRestore(boolC.booleanValue());
            }
        }
    }

    public final Boolean c(String str) {
        Matcher matcher = f15962b.matcher(str);
        if (matcher.find()) {
            return Boolean.valueOf(Boolean.parseBoolean(matcher.group(1)));
        }
        return null;
    }
}
