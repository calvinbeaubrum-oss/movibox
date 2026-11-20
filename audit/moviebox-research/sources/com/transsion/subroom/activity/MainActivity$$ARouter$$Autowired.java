package com.transsion.subroom.activity;

import com.alibaba.android.arouter.facade.service.SerializationService;
import com.alibaba.android.arouter.facade.template.ISyringe;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class MainActivity$$ARouter$$Autowired implements ISyringe {
    private SerializationService serializationService;

    @Override // com.alibaba.android.arouter.facade.template.ISyringe
    public void inject(Object obj) {
        this.serializationService = (SerializationService) com.alibaba.android.arouter.launcher.a.d().h(SerializationService.class);
        MainActivity mainActivity = (MainActivity) obj;
        mainActivity.f57998j = mainActivity.getIntent().getExtras() == null ? mainActivity.f57998j : mainActivity.getIntent().getExtras().getString("topTab", mainActivity.f57998j);
        mainActivity.f57999k = mainActivity.getIntent().getExtras() == null ? mainActivity.f57999k : mainActivity.getIntent().getExtras().getString("bottomTab", mainActivity.f57999k);
        mainActivity.f58000l = mainActivity.getIntent().getIntExtra("tabIndex", mainActivity.f58000l);
        mainActivity.f58001m = mainActivity.getIntent().getIntExtra("secondTabIndex", mainActivity.f58001m);
    }
}
