package com.alibaba.android.arouter.core;

import android.content.Context;
import android.util.LruCache;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.facade.service.AutowiredService;
import com.alibaba.android.arouter.facade.template.ISyringe;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
@Route(path = "/arouter/service/autowired")
public class AutowiredServiceImpl implements AutowiredService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LruCache<String, ISyringe> f15341a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List<String> f15342b;

    public final ISyringe A1(Class<?> cls) {
        String name = cls.getName();
        try {
            if (this.f15342b.contains(name)) {
                return null;
            }
            ISyringe iSyringe = this.f15341a.get(name);
            if (iSyringe == null) {
                iSyringe = (ISyringe) Class.forName(cls.getName() + "$$ARouter$$Autowired").getConstructor(new Class[0]).newInstance(new Object[0]);
            }
            this.f15341a.put(name, iSyringe);
            return iSyringe;
        } catch (Exception unused) {
            this.f15342b.add(name);
            return null;
        }
    }

    @Override // com.alibaba.android.arouter.facade.service.AutowiredService
    public void autowire(Object obj) {
        z1(obj, null);
    }

    @Override // com.alibaba.android.arouter.facade.template.IProvider
    public void init(Context context) {
        this.f15341a = new LruCache<>(50);
        this.f15342b = new ArrayList();
    }

    public final void z1(Object obj, Class<?> cls) {
        if (cls == null) {
            cls = obj.getClass();
        }
        ISyringe iSyringeA1 = A1(cls);
        if (iSyringeA1 != null) {
            iSyringeA1.inject(obj);
        }
        Class<? super Object> superclass = cls.getSuperclass();
        if (superclass == null || superclass.getName().startsWith("android")) {
            return;
        }
        z1(obj, superclass);
    }
}
