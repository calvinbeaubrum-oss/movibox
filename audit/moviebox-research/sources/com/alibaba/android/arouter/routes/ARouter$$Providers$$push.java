package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IProviderGroup;
import com.transsion.push.bean.MsgStyle;
import com.transsion.push.utils.PushApiImpl;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class ARouter$$Providers$$push implements IProviderGroup {
    @Override // com.alibaba.android.arouter.facade.template.IProviderGroup
    public void loadInto(Map<String, RouteMeta> map) {
        map.put("com.transsion.pushapi.IPushServiceApi", RouteMeta.build(RouteType.PROVIDER, PushApiImpl.class, "/push/service", MsgStyle.SOURCE_PUSH, null, -1, Integer.MIN_VALUE));
    }
}
