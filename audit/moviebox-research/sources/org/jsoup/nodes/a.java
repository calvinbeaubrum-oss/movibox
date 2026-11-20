package org.jsoup.nodes;

import com.cloud.tmc.integration.core.TmcEngineFactory;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import org.jsoup.SerializationException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class a implements Map.Entry<String, String>, Cloneable {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String[] f73092d = {"allowfullscreen", "async", "autofocus", "checked", "compact", "declare", TmcEngineFactory.ENGINE_TYPE_DEFAULT, "defer", "disabled", "formnovalidate", "hidden", "inert", "ismap", "itemscope", "multiple", "muted", "nohref", "noresize", "noshade", "novalidate", "nowrap", "open", "readonly", "required", "reversed", "seamless", "selected", "sortable", "truespeed", "typemustmatch"};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f73093a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f73094b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public b f73095c;

    public a(String str, String str2) {
        this(str, str2, null);
    }

    public a(String str, String str2, b bVar) {
        d30.d.j(str);
        this.f73093a = str.trim();
        d30.d.h(str);
        this.f73094b = str2;
        this.f73095c = bVar;
    }

    public static void g(String str, String str2, Appendable appendable, Document.OutputSettings outputSettings) throws IOException {
        appendable.append(str);
        if (k(str, str2, outputSettings)) {
            return;
        }
        appendable.append("=\"");
        Entities.e(appendable, b.r(str2), outputSettings, true, false, false);
        appendable.append('\"');
    }

    public static boolean h(String str) {
        return Arrays.binarySearch(f73092d, str) >= 0;
    }

    public static boolean k(String str, String str2, Document.OutputSettings outputSettings) {
        return outputSettings.m() == Document.OutputSettings.Syntax.html && (str2 == null || (("".equals(str2) || str2.equalsIgnoreCase(str)) && h(str)));
    }

    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public a clone() {
        try {
            return (a) super.clone();
        } catch (CloneNotSupportedException e11) {
            throw new RuntimeException(e11);
        }
    }

    @Override // java.util.Map.Entry
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public String getKey() {
        return this.f73093a;
    }

    @Override // java.util.Map.Entry
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public String getValue() {
        return this.f73094b;
    }

    public String d() {
        StringBuilder sb2 = new StringBuilder();
        try {
            f(sb2, new Document("").j1());
            return sb2.toString();
        } catch (IOException e11) {
            throw new SerializationException(e11);
        }
    }

    @Override // java.util.Map.Entry
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        a aVar = (a) obj;
        String str = this.f73093a;
        if (str == null ? aVar.f73093a != null : !str.equals(aVar.f73093a)) {
            return false;
        }
        String str2 = this.f73094b;
        String str3 = aVar.f73094b;
        if (str2 != null) {
            return str2.equals(str3);
        }
        return str3 == null;
    }

    public void f(Appendable appendable, Document.OutputSettings outputSettings) throws IOException {
        g(this.f73093a, this.f73094b, appendable, outputSettings);
    }

    @Override // java.util.Map.Entry
    public int hashCode() {
        String str = this.f73093a;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f73094b;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    @Override // java.util.Map.Entry
    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public String setValue(String str) {
        int iD;
        String strX = this.f73095c.x(this.f73093a);
        b bVar = this.f73095c;
        if (bVar != null && (iD = bVar.D(this.f73093a)) != -1) {
            this.f73095c.f73099c[iD] = str;
        }
        this.f73094b = str;
        return strX;
    }

    public String toString() {
        return d();
    }
}
