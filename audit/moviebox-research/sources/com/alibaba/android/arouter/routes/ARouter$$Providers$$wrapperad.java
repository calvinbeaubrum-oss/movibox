package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IProviderGroup;
import com.transsion.wrapperad.WrapperAdProvider;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class ARouter$$Providers$$wrapperad implements IProviderGroup {
    @Override // com.alibaba.android.arouter.facade.template.IProviderGroup
    public void loadInto(Map<String, RouteMeta> map) {
        map.put("com.transsion.wrapperadapi.IWrapperAdApi", RouteMeta.build(RouteType.PROVIDER, WrapperAdProvider.class, "/wrapperAd/WrapperAdProvider", "wrapperAd", null, -1, Integer.MIN_VALUE));
    }
}
