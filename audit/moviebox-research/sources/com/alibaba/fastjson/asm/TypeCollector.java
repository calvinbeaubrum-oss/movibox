package com.alibaba.fastjson.asm;

import com.alibaba.fastjson.util.b;
import j7.d;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;
import k7.g;
import k7.j;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class TypeCollector {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static String f15469e = b.b(d.class);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Map<String, String> f15470f = new HashMap<String, String>() { // from class: com.alibaba.fastjson.asm.TypeCollector.1
        {
            put("int", "I");
            put("boolean", "Z");
            put("byte", "B");
            put("char", "C");
            put("short", "S");
            put("float", "F");
            put("long", "J");
            put("double", "D");
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f15471a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Class<?>[] f15472b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public g f15473c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f15474d;

    public TypeCollector(String str, Class<?>[] clsArr) {
        this.f15471a = str;
        this.f15472b = clsArr;
    }

    public final boolean a(j jVar, String str) {
        String strC = jVar.c();
        StringBuilder sb2 = new StringBuilder();
        while (strC.endsWith(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI)) {
            sb2.append('[');
            strC = strC.substring(0, strC.length() - 2);
        }
        if (sb2.length() != 0) {
            Map<String, String> map = f15470f;
            if (map.containsKey(strC)) {
                sb2.append(map.get(strC));
                strC = sb2.toString();
            } else {
                sb2.append('L');
                sb2.append(strC);
                sb2.append(';');
                strC = sb2.toString();
            }
        }
        return strC.equals(str);
    }

    public String[] b() {
        g gVar = this.f15473c;
        return (gVar == null || !gVar.f68474e) ? new String[0] : gVar.a().split(",");
    }

    public boolean c() {
        return this.f15474d;
    }

    public void d(String str) {
        if (f15469e.equals(str)) {
            this.f15474d = true;
        }
    }

    public g e(int i11, String str, String str2) {
        if (this.f15473c != null || !str.equals(this.f15471a)) {
            return null;
        }
        j[] jVarArrA = j.a(str2);
        int i12 = 0;
        for (j jVar : jVarArrA) {
            String strC = jVar.c();
            if (strC.equals("long") || strC.equals("double")) {
                i12++;
            }
        }
        if (jVarArrA.length != this.f15472b.length) {
            return null;
        }
        for (int i13 = 0; i13 < jVarArrA.length; i13++) {
            if (!a(jVarArrA[i13], this.f15472b[i13].getName())) {
                return null;
            }
        }
        g gVar = new g(!Modifier.isStatic(i11) ? 1 : 0, jVarArrA.length + i12);
        this.f15473c = gVar;
        return gVar;
    }
}
