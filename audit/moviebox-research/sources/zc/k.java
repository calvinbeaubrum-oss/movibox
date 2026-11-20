package zc;

import androidx.annotation.NonNull;
import com.cloud.tmc.kernel.node.Node;
import java.util.HashMap;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public interface k {
    void create();

    void destroy();

    int getMiniAppType();

    ac.a getRenderBridge();

    void goBack();

    void load(String str);

    void load(String str, HashMap<String, String> map);

    void loadData(String str, @NonNull String str2, String str3, String str4, String str5);

    void onPause();

    void onResume();

    void registerCustomViewVisiableCallback(a aVar);

    void registerMessageChannel();

    void registerPageCallback(o oVar);

    void registerPageEventCallback(p pVar);

    void reload();

    void setAppId(String str);

    void setBgColor(String str);

    void setMiniAppType(int i11);

    void setNode(Node node);

    void setSupportFullScreen(boolean z11);
}
