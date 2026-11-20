package com.cloud.tmc.miniapp.base;

import com.cloud.tmc.integration.utils.e0;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class MiniAppBaseActivity extends BaseActivity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f31387a = LazyKt__LazyJVMKt.b(new Function0<String>() { // from class: com.cloud.tmc.miniapp.base.MiniAppBaseActivity$taskTag$2
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final String invoke() {
            String stringExtra = this.this$0.getIntent().getStringExtra("miniAppId");
            return stringExtra == null ? "" : stringExtra;
        }
    });

    @Override // com.cloud.tmc.miniapp.base.BaseActivity
    public void initLayout() {
        super.initLayout();
        if (getLayoutId() > 0) {
            e0.d(this);
        }
    }
}
