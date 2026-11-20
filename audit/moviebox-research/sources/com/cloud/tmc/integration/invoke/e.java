package com.cloud.tmc.integration.invoke;

import android.app.Activity;
import androidx.core.app.ActivityCompat;
import com.cloud.tmc.integration.permission.IPermissionRequestCallback;
import com.cloud.tmc.integration.permission.TmcNativePermissionRequestProxy;
import com.cloud.tmc.integration.structure.Page;
import com.cloud.tmc.kernel.node.Node;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class e extends d {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public mc.a f30802g;

    /* JADX INFO: compiled from: source.java */
    public class a implements IPermissionRequestCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ArrayList f30803a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Object f30804b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Method f30805c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Object[] f30806d;

        public a(ArrayList arrayList, Object obj, Method method, Object[] objArr) {
            this.f30803a = arrayList;
            this.f30804b = obj;
            this.f30805c = method;
            this.f30806d = objArr;
        }

        @Override // com.cloud.tmc.integration.permission.IPermissionRequestCallback
        public void onRequestPermissionResult(int i11, String[] strArr, int[] iArr) {
            if (strArr == null || iArr == null || strArr.length != iArr.length || this.f30803a.size() != strArr.length) {
                return;
            }
            for (int i12 = 0; i12 < strArr.length; i12++) {
                if (iArr[i12] != 0) {
                    e.this.f30802g.m();
                    return;
                }
            }
            e eVar = e.this;
            eVar.f(eVar.f30798d, this.f30804b, this.f30805c, this.f30806d);
        }
    }

    public e(mc.a aVar, d dVar) {
        super(dVar);
        this.f30802g = aVar;
    }

    @Override // com.cloud.tmc.integration.invoke.d
    public d.b d(Object obj, Method method, Object[] objArr) throws Throwable {
        zb.d dVar;
        Node node = this.f30795a;
        if (!(node instanceof Page)) {
            return d.b.f();
        }
        Page page = (Page) node;
        if (page.getRender() == null || page.getRender().getActivity() == null) {
            return d.b.f();
        }
        Activity activity = page.getRender().getActivity();
        ArrayList arrayList = new ArrayList();
        Iterator it = this.f30798d.iterator();
        while (it.hasNext()) {
            Method method2 = ((com.cloud.tmc.kernel.extension.c) it.next()).getClass().getMethod(method.getName(), method.getParameterTypes());
            if (method2 != null && (dVar = (zb.d) method2.getAnnotation(zb.d.class)) != null && dVar.value() != null && dVar.value().length > 0) {
                for (String str : dVar.value()) {
                    if (z2.a.checkSelfPermission(activity, str) != 0) {
                        arrayList.add(str);
                    }
                }
            }
        }
        if (arrayList.isEmpty()) {
            return d.b.f();
        }
        int requestCode = ((TmcNativePermissionRequestProxy) tc.a.a(TmcNativePermissionRequestProxy.class)).getRequestCode();
        ((TmcNativePermissionRequestProxy) tc.a.a(TmcNativePermissionRequestProxy.class)).addPermRequestCallback(requestCode, new a(arrayList, obj, method, objArr));
        ActivityCompat.g(activity, (String[]) arrayList.toArray(new String[arrayList.size()]), requestCode);
        return d.b.e();
    }
}
