package com.transsion.home.activity;

import com.alibaba.android.arouter.facade.service.SerializationService;
import com.alibaba.android.arouter.facade.template.ISyringe;
import com.alibaba.android.arouter.launcher.a;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class RankAllActivity$$ARouter$$Autowired implements ISyringe {
    private SerializationService serializationService;

    @Override // com.alibaba.android.arouter.facade.template.ISyringe
    public void inject(Object obj) {
        this.serializationService = (SerializationService) a.d().h(SerializationService.class);
        RankAllActivity rankAllActivity = (RankAllActivity) obj;
        rankAllActivity.f51998a = rankAllActivity.getIntent().getExtras() == null ? rankAllActivity.f51998a : rankAllActivity.getIntent().getExtras().getString("category", rankAllActivity.f51998a);
        rankAllActivity.f51999b = rankAllActivity.getIntent().getIntExtra("tabId", rankAllActivity.f51999b);
    }
}
