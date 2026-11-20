package com.vungle.warren.utility;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.vungle.warren.ui.PresenterAdOpenCallback;
import java.net.URISyntaxException;
import org.mvel2.ast.ASTNode;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f62597a = "g";

    public static Intent a(String str, boolean z11) {
        Intent uri = null;
        try {
            if (!TextUtils.isEmpty(str)) {
                uri = Intent.parseUri(str, 0);
            }
            if (uri != null && z11) {
                uri.setFlags(ASTNode.DEOP);
            }
        } catch (URISyntaxException e11) {
            Log.e(f62597a, "url format is not correct " + e11.getLocalizedMessage());
        }
        return uri;
    }

    public static boolean b(@Nullable String str, @Nullable String str2, @NonNull Context context, @Nullable ActivityManager.d dVar, boolean z11, PresenterAdOpenCallback presenterAdOpenCallback) {
        if ((TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) || context == null) {
            return false;
        }
        try {
            ActivityManager.x(context, a(str, z11), a(str2, z11), dVar, presenterAdOpenCallback);
            return true;
        } catch (Exception e11) {
            Log.e(f62597a, "Error while opening url" + e11.getLocalizedMessage());
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Cannot open url ");
            sb2.append(str2);
            return false;
        }
    }
}
