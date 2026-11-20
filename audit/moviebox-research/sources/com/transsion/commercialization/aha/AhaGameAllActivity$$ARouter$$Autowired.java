package com.transsion.commercialization.aha;

import com.alibaba.android.arouter.facade.service.SerializationService;
import com.alibaba.android.arouter.facade.template.ISyringe;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class AhaGameAllActivity$$ARouter$$Autowired implements ISyringe {
    private SerializationService serializationService;

    @Override // com.alibaba.android.arouter.facade.template.ISyringe
    public void inject(Object obj) {
        this.serializationService = (SerializationService) com.alibaba.android.arouter.launcher.a.d().h(SerializationService.class);
        AhaGameAllActivity ahaGameAllActivity = (AhaGameAllActivity) obj;
        ahaGameAllActivity.f51604i = ahaGameAllActivity.getIntent().getBooleanExtra("fromTask", ahaGameAllActivity.f51604i);
    }
}
