package com.transsion.search.activity;

import com.alibaba.android.arouter.facade.service.SerializationService;
import com.alibaba.android.arouter.facade.template.ISyringe;
import com.alibaba.android.arouter.launcher.a;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class SearchManagerActivity$$ARouter$$Autowired implements ISyringe {
    private SerializationService serializationService;

    @Override // com.alibaba.android.arouter.facade.template.ISyringe
    public void inject(Object obj) {
        this.serializationService = (SerializationService) a.d().h(SerializationService.class);
        SearchManagerActivity searchManagerActivity = (SearchManagerActivity) obj;
        searchManagerActivity.f57434j = searchManagerActivity.getIntent().getExtras() == null ? searchManagerActivity.f57434j : searchManagerActivity.getIntent().getExtras().getString("keyword", searchManagerActivity.f57434j);
        searchManagerActivity.f57435k = searchManagerActivity.getIntent().getIntExtra("type", searchManagerActivity.f57435k);
        searchManagerActivity.f57436l = searchManagerActivity.getIntent().getBooleanExtra("back_exit", searchManagerActivity.f57436l);
    }
}
