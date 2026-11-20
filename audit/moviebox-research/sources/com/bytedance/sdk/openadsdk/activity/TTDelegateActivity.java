package com.bytedance.sdk.openadsdk.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Window;
import android.view.WindowManager;
import androidx.annotation.Nullable;
import com.bytedance.sdk.component.utils.Tf;
import com.bytedance.sdk.openadsdk.core.Ol;
import com.bytedance.sdk.openadsdk.core.SR;
import com.bytedance.sdk.openadsdk.core.WP;
import com.bytedance.sdk.openadsdk.core.Xc;
import com.bytedance.sdk.openadsdk.core.model.Sfl;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.mvel2.ast.ASTNode;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class TTDelegateActivity extends TTBaseActivity {
    private static final Map<String, com.bytedance.sdk.openadsdk.core.zY.We.sc> zY = Collections.synchronizedMap(new HashMap());
    private WP pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private Intent f27528sc;

    private void pFF() {
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.alpha = 0.0f;
        window.setAttributes(attributes);
    }

    public static void sc(Sfl sfl, String str) {
        sc(sfl, str, null);
    }

    public static void sc(Sfl sfl, String str, com.bytedance.sdk.openadsdk.core.zY.We.sc scVar) {
        if (sfl == null) {
            return;
        }
        Intent intent = new Intent(Xc.sc(), (Class<?>) TTDelegateActivity.class);
        intent.addFlags(ASTNode.DEOP);
        intent.putExtra("type", 6);
        intent.putExtra("ext_info", sfl.mD());
        intent.putExtra("filter_words", com.bytedance.sdk.openadsdk.tool.sc.sc(sfl.IEI()));
        intent.putExtra("creative_info", sfl.JP().toString());
        intent.putExtra("closed_listener_key", str);
        if (scVar != null) {
            if (com.bytedance.sdk.openadsdk.multipro.pFF.zY()) {
                Ol.pFF().sc(str, scVar);
            } else {
                zY.put(str, scVar);
            }
        }
        com.bytedance.sdk.component.utils.pFF.sc(Xc.sc(), intent, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sc(String str) {
        Map<String, com.bytedance.sdk.openadsdk.core.zY.We.sc> map = zY;
        if (map == null || TextUtils.isEmpty(str)) {
            return;
        }
        map.remove(str);
        if (Tf.We()) {
            map.size();
        }
    }

    private void sc(String str, String str2, final String str3, String str4) {
        if (str2 != null && str != null && this.pFF == null) {
            com.bytedance.sdk.openadsdk.zY.zY zYVar = new com.bytedance.sdk.openadsdk.zY.zY(this, str, com.bytedance.sdk.openadsdk.tool.sc.sc(str2), str4, "other");
            this.pFF = zYVar;
            zYVar.sc(str3);
            this.pFF.sc(new WP.sc() { // from class: com.bytedance.sdk.openadsdk.activity.TTDelegateActivity.1
                @Override // com.bytedance.sdk.openadsdk.core.WP.sc
                public void sc() {
                    if (!((com.bytedance.sdk.openadsdk.zY.zY) TTDelegateActivity.this.pFF).zY()) {
                        TTDelegateActivity.this.sc(str3);
                        TTDelegateActivity.this.finish();
                    }
                    ((com.bytedance.sdk.openadsdk.zY.zY) TTDelegateActivity.this.pFF).sc(false);
                }

                @Override // com.bytedance.sdk.openadsdk.core.WP.sc
                public void sc(int i11, String str5) {
                    com.bytedance.sdk.openadsdk.core.zY.We.sc scVarExN;
                    if (TTDelegateActivity.zY != null && TTDelegateActivity.zY.size() > 0 && !TextUtils.isEmpty(str3) && !com.bytedance.sdk.openadsdk.multipro.pFF.zY()) {
                        com.bytedance.sdk.openadsdk.core.zY.We.sc scVar = (com.bytedance.sdk.openadsdk.core.zY.We.sc) TTDelegateActivity.zY.get(str3);
                        if (scVar != null) {
                            scVar.sc();
                        }
                    } else if (!TextUtils.isEmpty(str3) && (scVarExN = Ol.pFF().ExN(str3)) != null) {
                        scVarExN.sc();
                        Ol.pFF().TRI(str3);
                    }
                    TTDelegateActivity.this.sc(str3);
                    TTDelegateActivity.this.finish();
                }
            });
        }
        WP wp2 = this.pFF;
        if (wp2 != null) {
            wp2.sc();
        }
    }

    private void zY() {
        int intExtra = this.f27528sc.getIntExtra("type", 0);
        if (intExtra != 1) {
            if (intExtra != 6) {
                finish();
                return;
            }
            sc(this.f27528sc.getStringExtra("ext_info"), this.f27528sc.getStringExtra("filter_words"), this.f27528sc.getStringExtra("closed_listener_key"), this.f27528sc.getStringExtra("creative_info"));
        }
    }

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (!SR.ExN()) {
            finish();
            return;
        }
        pFF();
        this.f27528sc = getIntent();
        if (Xc.sc() == null) {
            Xc.pFF(this);
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        WP wp2 = this.pFF;
        if (wp2 != null) {
            wp2.pFF();
        }
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (Xc.sc() == null) {
            Xc.pFF(this);
        }
        setIntent(intent);
        this.f27528sc = intent;
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        WP wp2 = this.pFF;
        if ((wp2 == null || ((com.bytedance.sdk.openadsdk.zY.zY) wp2).f28825sc == null || !((com.bytedance.sdk.openadsdk.zY.zY) wp2).f28825sc.isShowing()) && this.f27528sc != null) {
            zY();
        }
    }
}
