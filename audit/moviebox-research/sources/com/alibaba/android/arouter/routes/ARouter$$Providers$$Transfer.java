package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IProviderGroup;
import com.transsion.transfer.TransferProvider;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class ARouter$$Providers$$Transfer implements IProviderGroup {
    @Override // com.alibaba.android.arouter.facade.template.IProviderGroup
    public void loadInto(Map<String, RouteMeta> map) {
        map.put("com.transsion.transfer.itransfer.ITransferApi", RouteMeta.build(RouteType.PROVIDER, TransferProvider.class, "/transfer/transfer_provider", "transfer", null, -1, Integer.MIN_VALUE));
    }
}
