package com.transsion.home.activity;

import com.alibaba.android.arouter.facade.service.SerializationService;
import com.alibaba.android.arouter.facade.template.ISyringe;
import com.alibaba.android.arouter.launcher.a;
import com.mbridge.msdk.foundation.entity.CampaignEx;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class OperateActivity$$ARouter$$Autowired implements ISyringe {
    private SerializationService serializationService;

    @Override // com.alibaba.android.arouter.facade.template.ISyringe
    public void inject(Object obj) {
        this.serializationService = (SerializationService) a.d().h(SerializationService.class);
        OperateActivity operateActivity = (OperateActivity) obj;
        operateActivity.f51994a = operateActivity.getIntent().getIntExtra("tabId", operateActivity.f51994a);
        operateActivity.f51995b = operateActivity.getIntent().getExtras() == null ? operateActivity.f51995b : operateActivity.getIntent().getExtras().getString("tabCode", operateActivity.f51995b);
        operateActivity.f51996c = operateActivity.getIntent().getExtras() == null ? operateActivity.f51996c : operateActivity.getIntent().getExtras().getString(CampaignEx.JSON_KEY_TITLE, operateActivity.f51996c);
    }
}
