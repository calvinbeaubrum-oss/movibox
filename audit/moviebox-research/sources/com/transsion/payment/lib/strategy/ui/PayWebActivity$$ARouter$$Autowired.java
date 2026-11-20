package com.transsion.payment.lib.strategy.ui;

import com.alibaba.android.arouter.facade.service.SerializationService;
import com.alibaba.android.arouter.facade.template.ISyringe;
import com.alibaba.android.arouter.launcher.a;
import com.transsion.web.api.WebConstants;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class PayWebActivity$$ARouter$$Autowired implements ISyringe {
    private SerializationService serializationService;

    @Override // com.alibaba.android.arouter.facade.template.ISyringe
    public void inject(Object obj) {
        this.serializationService = (SerializationService) a.d().h(SerializationService.class);
        PayWebActivity payWebActivity = (PayWebActivity) obj;
        payWebActivity.f54085a = payWebActivity.getIntent().getExtras() == null ? payWebActivity.f54085a : payWebActivity.getIntent().getExtras().getString("url", payWebActivity.f54085a);
        payWebActivity.f54086b = payWebActivity.getIntent().getExtras() == null ? payWebActivity.f54086b : payWebActivity.getIntent().getExtras().getString(WebConstants.PAGE_FROM, payWebActivity.f54086b);
    }
}
