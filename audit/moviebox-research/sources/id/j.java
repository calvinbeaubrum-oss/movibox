package id;

import android.view.LayoutInflater;
import android.widget.TextView;
import com.cloud.tmc.miniapp.R$id;
import com.cloud.tmc.miniapp.R$layout;
import com.cloud.tmc.miniapp.widget.StatusLayout;
import com.cloud.tmc.miniapp.widget.UpgradeHostAppPromptLayout;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public interface j extends i {

    /* JADX INFO: compiled from: source.java */
    public static final class a {
        public static void a(j jVar, String appId, Integer num) {
            UpgradeHostAppPromptLayout upgradeHostAppPromptLayout;
            StatusLayout statusLayout = jVar.getStatusLayout();
            if (statusLayout == null || appId == null || appId.length() == 0 || (upgradeHostAppPromptLayout = statusLayout.OooOO0O) == null) {
                return;
            }
            Intrinsics.g(appId, "appId");
            upgradeHostAppPromptLayout.OooO0O0 = appId;
            upgradeHostAppPromptLayout.setVisibility(0);
            if (upgradeHostAppPromptLayout.OooO00o == null) {
                if (num != null && num.intValue() == 2) {
                    upgradeHostAppPromptLayout.OooO00o = LayoutInflater.from(upgradeHostAppPromptLayout.getContext()).inflate(R$layout.app_layout_view_upgrade_host_app_prompt_normal_mode, upgradeHostAppPromptLayout);
                } else {
                    upgradeHostAppPromptLayout.OooO00o = LayoutInflater.from(upgradeHostAppPromptLayout.getContext()).inflate(R$layout.app_layout_view_upgrade_host_app_prompt, upgradeHostAppPromptLayout);
                }
                TextView textView = (TextView) upgradeHostAppPromptLayout.findViewById(R$id.tv_open_store);
                if (textView != null) {
                    textView.setOnClickListener(upgradeHostAppPromptLayout);
                }
            }
        }
    }
}
