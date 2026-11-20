package b10;

import android.content.DialogInterface;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import b10.b;
import com.vungle.warren.ui.PresenterAdOpenCallback;
import com.vungle.warren.utility.ActivityManager;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public interface a<T extends b> {
    void close();

    void destroyAdView(long j11);

    String getWebsiteUrl();

    boolean hasWebView();

    void open(String str, @NonNull String str2, ActivityManager.d dVar, PresenterAdOpenCallback presenterAdOpenCallback);

    void pauseWeb();

    void refreshDialogIfVisible();

    void removeWebView();

    void resumeWeb();

    void setImmersiveMode();

    void setOrientation(int i11);

    void setPresenter(@NonNull T t11);

    void showCloseButton();

    void showDialog(@Nullable String str, @Nullable String str2, @NonNull String str3, @NonNull String str4, @Nullable DialogInterface.OnClickListener onClickListener);

    void showWebsite(@NonNull String str);
}
