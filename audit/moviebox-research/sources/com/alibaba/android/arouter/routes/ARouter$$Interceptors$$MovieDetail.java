package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.template.IInterceptor;
import com.alibaba.android.arouter.facade.template.IInterceptorGroup;
import com.transsion.moviedetail.preload.PreloaderInterceptor;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class ARouter$$Interceptors$$MovieDetail implements IInterceptorGroup {
    @Override // com.alibaba.android.arouter.facade.template.IInterceptorGroup
    public void loadInto(Map<Integer, Class<? extends IInterceptor>> map) {
        map.put(3, PreloaderInterceptor.class);
    }
}
