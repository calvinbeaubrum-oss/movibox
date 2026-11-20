package com.alibaba.android.arouter.facade.template;

import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public interface IInterceptorGroup {
    void loadInto(Map<Integer, Class<? extends IInterceptor>> map);
}
