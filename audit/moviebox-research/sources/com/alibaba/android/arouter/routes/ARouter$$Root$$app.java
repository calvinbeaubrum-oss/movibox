package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.template.IRouteGroup;
import com.alibaba.android.arouter.facade.template.IRouteRoot;
import com.mbridge.msdk.MBridgeConstans;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class ARouter$$Root$$app implements IRouteRoot {
    @Override // com.alibaba.android.arouter.facade.template.IRouteRoot
    public void loadInto(Map<String, Class<? extends IRouteGroup>> map) {
        map.put("Log", ARouter$$Group$$Log.class);
        map.put(MBridgeConstans.DYNAMIC_VIEW_WX_APP, ARouter$$Group$$app.class);
        map.put("main", ARouter$$Group$$main.class);
    }
}
