package com.transsnet.downloader.activity;

import com.alibaba.android.arouter.facade.service.SerializationService;
import com.alibaba.android.arouter.facade.template.ISyringe;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class DownloadSeriesListActivity$$ARouter$$Autowired implements ISyringe {
    private SerializationService serializationService;

    @Override // com.alibaba.android.arouter.facade.template.ISyringe
    public void inject(Object obj) {
        this.serializationService = (SerializationService) com.alibaba.android.arouter.launcher.a.d().h(SerializationService.class);
        DownloadSeriesListActivity downloadSeriesListActivity = (DownloadSeriesListActivity) obj;
        downloadSeriesListActivity.f60294a = downloadSeriesListActivity.getIntent().getExtras() == null ? downloadSeriesListActivity.f60294a : downloadSeriesListActivity.getIntent().getExtras().getString("extra_name", downloadSeriesListActivity.f60294a);
        downloadSeriesListActivity.f60295b = downloadSeriesListActivity.getIntent().getExtras() == null ? downloadSeriesListActivity.f60295b : downloadSeriesListActivity.getIntent().getExtras().getString("extra_subject_id", downloadSeriesListActivity.f60295b);
        downloadSeriesListActivity.f60296c = downloadSeriesListActivity.getIntent().getIntExtra("extra_parent_position", downloadSeriesListActivity.f60296c);
    }
}
