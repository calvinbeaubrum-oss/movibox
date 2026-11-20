package com.transsnet.downloader.activity;

import com.alibaba.android.arouter.facade.service.SerializationService;
import com.alibaba.android.arouter.facade.template.ISyringe;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class DownloadPanelActivity$$ARouter$$Autowired implements ISyringe {
    private SerializationService serializationService;

    @Override // com.alibaba.android.arouter.facade.template.ISyringe
    public void inject(Object obj) {
        this.serializationService = (SerializationService) com.alibaba.android.arouter.launcher.a.d().h(SerializationService.class);
        DownloadPanelActivity downloadPanelActivity = (DownloadPanelActivity) obj;
        downloadPanelActivity.f60293c = downloadPanelActivity.getIntent().getIntExtra("extra_page_index", downloadPanelActivity.f60293c);
    }
}
