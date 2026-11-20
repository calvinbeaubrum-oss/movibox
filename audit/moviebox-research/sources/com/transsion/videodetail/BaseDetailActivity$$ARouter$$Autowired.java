package com.transsion.videodetail;

import com.alibaba.android.arouter.facade.service.SerializationService;
import com.alibaba.android.arouter.facade.template.ISyringe;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class BaseDetailActivity$$ARouter$$Autowired implements ISyringe {
    private SerializationService serializationService;

    @Override // com.alibaba.android.arouter.facade.template.ISyringe
    public void inject(Object obj) {
        this.serializationService = (SerializationService) com.alibaba.android.arouter.launcher.a.d().h(SerializationService.class);
        BaseDetailActivity baseDetailActivity = (BaseDetailActivity) obj;
        baseDetailActivity.f59780i = baseDetailActivity.getIntent().getExtras() == null ? baseDetailActivity.f59780i : baseDetailActivity.getIntent().getExtras().getString("id", baseDetailActivity.f59780i);
        baseDetailActivity.f59781j = baseDetailActivity.getIntent().getExtras() == null ? baseDetailActivity.f59781j : baseDetailActivity.getIntent().getExtras().getString("ops", baseDetailActivity.f59781j);
        baseDetailActivity.f59782k = baseDetailActivity.getIntent().getBooleanExtra("autoDownload", baseDetailActivity.f59782k);
        baseDetailActivity.f59783l = baseDetailActivity.getIntent().getBooleanExtra("autoPlay", baseDetailActivity.f59783l);
        baseDetailActivity.f59784m = baseDetailActivity.getIntent().getExtras() == null ? baseDetailActivity.f59784m : baseDetailActivity.getIntent().getExtras().getString("resourceId", baseDetailActivity.f59784m);
        baseDetailActivity.f59785n = baseDetailActivity.getIntent().getExtras() == null ? baseDetailActivity.f59785n : baseDetailActivity.getIntent().getExtras().getString("module_name", baseDetailActivity.f59785n);
        baseDetailActivity.f59786o = baseDetailActivity.getIntent().getIntExtra("yy_preload_id", baseDetailActivity.f59786o);
        baseDetailActivity.f59787p = baseDetailActivity.getIntent().getIntExtra("season", baseDetailActivity.f59787p);
        baseDetailActivity.f59788q = baseDetailActivity.getIntent().getIntExtra("episode", baseDetailActivity.f59788q);
        baseDetailActivity.f59789r = baseDetailActivity.getIntent().getBooleanExtra("is_music_liked_fragment", baseDetailActivity.f59789r);
        baseDetailActivity.f59790s = baseDetailActivity.getIntent().getBooleanExtra("isMusicFloatViewClick", baseDetailActivity.f59790s);
    }
}
