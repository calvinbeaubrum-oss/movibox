package com.alibaba.fastjson;

import com.alibaba.fastjson.serializer.SerializerFeature;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import n7.j1;
import n7.m0;
import n7.o0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class c implements m0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f15475c = "/**/";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f15476a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<Object> f15477b = new ArrayList();

    public c() {
    }

    public c(String str) {
        this.f15476a = str;
    }

    @Override // n7.m0
    public void a(o0 o0Var, Object obj, Type type, int i11) throws IOException {
        j1 j1Var = o0Var.f71701k;
        int i12 = SerializerFeature.BrowserSecure.mask;
        if ((i11 & i12) != 0 || j1Var.j(i12)) {
            j1Var.write(f15475c);
        }
        j1Var.write(this.f15476a);
        j1Var.write(40);
        for (int i13 = 0; i13 < this.f15477b.size(); i13++) {
            if (i13 != 0) {
                j1Var.write(44);
            }
            o0Var.H(this.f15477b.get(i13));
        }
        j1Var.write(41);
    }

    public void b(Object obj) {
        this.f15477b.add(obj);
    }

    public String toString() {
        return a.toJSONString(this);
    }
}
