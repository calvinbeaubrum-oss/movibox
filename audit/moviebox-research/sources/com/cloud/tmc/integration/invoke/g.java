package com.cloud.tmc.integration.invoke;

import android.text.TextUtils;
import com.cloud.tmc.kernel.extension.BridgeExtension;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class g extends d {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public dd.b f30812g;

    /* JADX INFO: compiled from: source.java */
    public class a implements dd.b.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Method f30813a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f30814b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Object f30815c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Object[] f30816d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ List f30817e;

        public a(Method method, long j11, Object obj, Object[] objArr, List list) {
            this.f30813a = method;
            this.f30814b = j11;
            this.f30815c = obj;
            this.f30816d = objArr;
            this.f30817e = list;
        }
    }

    public g(dd.b bVar, d dVar) {
        super(dVar);
        this.f30812g = bVar;
    }

    @Override // com.cloud.tmc.integration.invoke.d
    public d.b d(Object obj, Method method, Object[] objArr) throws Throwable {
        long jCurrentTimeMillis = System.currentTimeMillis();
        ArrayList arrayList = new ArrayList();
        for (com.cloud.tmc.kernel.extension.c cVar : this.f30798d) {
            if (cVar instanceof dd.e) {
                arrayList.add((dd.e) cVar);
            }
            Method method2 = cVar.getClass().getMethod(method.getName(), method.getParameterTypes());
            if (method2 != null) {
                zb.f fVar = (zb.f) method2.getAnnotation(zb.f.class);
                if (fVar != null && fVar.value() != null && fVar.value().length() > 0) {
                    arrayList.add(new kc.a(new kc.b(fVar.value(), fVar.desc())));
                } else if ((cVar instanceof BridgeExtension) && method2.getAnnotation(zb.a.class) != null) {
                    zb.a aVar = (zb.a) method2.getAnnotation(zb.a.class);
                    String name = (aVar == null || TextUtils.isEmpty(aVar.value())) ? method2.getName() : aVar.value();
                    arrayList.add(new kc.a(new kc.b(name, name)));
                }
            }
        }
        a aVar2 = new a(method, jCurrentTimeMillis, obj, objArr, arrayList);
        dd.b bVar = this.f30812g;
        return (bVar == null || !bVar.b(this.f30795a, arrayList, aVar2)) ? d.b.f() : d.b.e();
    }
}
