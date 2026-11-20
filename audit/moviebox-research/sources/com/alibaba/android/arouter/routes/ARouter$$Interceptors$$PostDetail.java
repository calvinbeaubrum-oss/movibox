package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.template.IInterceptor;
import com.alibaba.android.arouter.facade.template.IInterceptorGroup;
import com.transsion.postdetail.shorttv.MovieDetailShortTVInterceptor;
import com.transsion.postdetail.ui.interceptor.LocalVideoDetailInterceptor;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class ARouter$$Interceptors$$PostDetail implements IInterceptorGroup {
    @Override // com.alibaba.android.arouter.facade.template.IInterceptorGroup
    public void loadInto(Map<Integer, Class<? extends IInterceptor>> map) {
        map.put(1, LocalVideoDetailInterceptor.class);
        map.put(2, MovieDetailShortTVInterceptor.class);
    }
}
