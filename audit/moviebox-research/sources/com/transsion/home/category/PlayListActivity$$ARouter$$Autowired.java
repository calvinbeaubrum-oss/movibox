package com.transsion.home.category;

import com.alibaba.android.arouter.facade.service.SerializationService;
import com.alibaba.android.arouter.facade.template.ISyringe;
import com.alibaba.android.arouter.launcher.a;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class PlayListActivity$$ARouter$$Autowired implements ISyringe {
    private SerializationService serializationService;

    @Override // com.alibaba.android.arouter.facade.template.ISyringe
    public void inject(Object obj) {
        this.serializationService = (SerializationService) a.d().h(SerializationService.class);
        PlayListActivity playListActivity = (PlayListActivity) obj;
        playListActivity.f52336a = playListActivity.getIntent().getExtras() == null ? playListActivity.f52336a : playListActivity.getIntent().getExtras().getString("category", playListActivity.f52336a);
        playListActivity.f52337b = playListActivity.getIntent().getExtras() == null ? playListActivity.f52337b : playListActivity.getIntent().getExtras().getString("label", playListActivity.f52337b);
        playListActivity.f52338c = playListActivity.getIntent().getExtras() == null ? playListActivity.f52338c : playListActivity.getIntent().getExtras().getString("recType", playListActivity.f52338c);
    }
}
