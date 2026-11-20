package com.amazonaws.services.s3.internal;

import com.amazonaws.util.StringUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class XmlWriter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<String> f15983a = new ArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public StringBuilder f15984b = new StringBuilder();

    public final void a(String str, StringBuilder sb2) {
        String str2;
        if (str == null) {
            str = "";
        }
        int length = str.length();
        int i11 = 0;
        int i12 = 0;
        while (i11 < length) {
            char cCharAt = str.charAt(i11);
            if (cCharAt == '\t') {
                str2 = "&#9;";
            } else if (cCharAt == '\n') {
                str2 = "&#10;";
            } else if (cCharAt == '\r') {
                str2 = "&#13;";
            } else if (cCharAt == '\"') {
                str2 = "&quot;";
            } else if (cCharAt == '&') {
                str2 = "&amp;";
            } else if (cCharAt != '<') {
                str2 = cCharAt != '>' ? null : "&gt;";
            } else {
                str2 = "&lt;";
            }
            if (str2 != null) {
                if (i12 < i11) {
                    sb2.append((CharSequence) str, i12, i11);
                }
                this.f15984b.append(str2);
                i12 = i11 + 1;
            }
            i11++;
        }
        if (i12 < i11) {
            this.f15984b.append((CharSequence) str, i12, i11);
        }
    }

    public XmlWriter b() {
        List<String> list = this.f15983a;
        String strRemove = list.remove(list.size() - 1);
        StringBuilder sb2 = this.f15984b;
        sb2.append("</");
        sb2.append(strRemove);
        sb2.append(">");
        return this;
    }

    public byte[] c() {
        return toString().getBytes(StringUtils.f16272a);
    }

    public XmlWriter d(String str) {
        StringBuilder sb2 = this.f15984b;
        sb2.append("<");
        sb2.append(str);
        sb2.append(">");
        this.f15983a.add(str);
        return this;
    }

    public XmlWriter e(String str) {
        a(str, this.f15984b);
        return this;
    }

    public String toString() {
        return this.f15984b.toString();
    }
}
