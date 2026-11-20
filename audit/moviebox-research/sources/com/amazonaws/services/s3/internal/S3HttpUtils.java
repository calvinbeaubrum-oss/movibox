package com.amazonaws.services.s3.internal;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class S3HttpUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Pattern f15973a = Pattern.compile(Pattern.quote("+") + "|" + Pattern.quote("*") + "|" + Pattern.quote("%7E") + "|" + Pattern.quote("%2F") + "|" + Pattern.quote("%3A") + "|" + Pattern.quote("%27") + "|" + Pattern.quote("%28") + "|" + Pattern.quote("%29") + "|" + Pattern.quote("%21") + "|" + Pattern.quote("%5B") + "|" + Pattern.quote("%5D") + "|" + Pattern.quote("%24"));

    public static String a(String str) {
        if (str == null) {
            return null;
        }
        try {
            return URLDecoder.decode(str, "UTF-8");
        } catch (UnsupportedEncodingException e11) {
            throw new RuntimeException(e11);
        }
    }

    public static String b(String str, boolean z11) {
        if (str == null) {
            return "";
        }
        try {
            String strEncode = URLEncoder.encode(str, "UTF-8");
            Matcher matcher = f15973a.matcher(strEncode);
            StringBuffer stringBuffer = new StringBuffer(strEncode.length());
            while (matcher.find()) {
                String strGroup = matcher.group(0);
                if ("+".equals(strGroup)) {
                    strGroup = " ";
                } else if ("*".equals(strGroup)) {
                    strGroup = "%2A";
                } else if ("%7E".equals(strGroup)) {
                    strGroup = "~";
                } else if (z11 && "%2F".equals(strGroup)) {
                    strGroup = "/";
                } else if (z11 && "%3A".equals(strGroup)) {
                    strGroup = ":";
                } else if (z11 && "%27".equals(strGroup)) {
                    strGroup = "'";
                } else if (z11 && "%28".equals(strGroup)) {
                    strGroup = "(";
                } else if (z11 && "%29".equals(strGroup)) {
                    strGroup = ")";
                } else if (z11 && "%21".equals(strGroup)) {
                    strGroup = "!";
                } else if (z11 && "%5B".equals(strGroup)) {
                    strGroup = "[";
                } else if (z11 && "%5D".equals(strGroup)) {
                    strGroup = "]";
                }
                matcher.appendReplacement(stringBuffer, strGroup);
            }
            matcher.appendTail(stringBuffer);
            return stringBuffer.toString();
        } catch (UnsupportedEncodingException e11) {
            throw new RuntimeException(e11);
        }
    }
}
