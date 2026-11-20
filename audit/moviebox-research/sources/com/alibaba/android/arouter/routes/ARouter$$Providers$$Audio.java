package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IProviderGroup;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import com.transsion.audio.AudioApiImpl;
import com.transsion.audio.FloatingApiImpl;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class ARouter$$Providers$$Audio implements IProviderGroup {
    @Override // com.alibaba.android.arouter.facade.template.IProviderGroup
    public void loadInto(Map<String, RouteMeta> map) {
        RouteType routeType = RouteType.PROVIDER;
        map.put("com.transsion.room.api.IAudioApi", RouteMeta.build(routeType, AudioApiImpl.class, "/audio/api", MimeTypes.BASE_TYPE_AUDIO, null, -1, Integer.MIN_VALUE));
        map.put("com.transsion.room.api.IFloatingApi", RouteMeta.build(routeType, FloatingApiImpl.class, "/audio/float", MimeTypes.BASE_TYPE_AUDIO, null, -1, Integer.MIN_VALUE));
    }
}
