package com.cloud.tmc.integration.proxy;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import bc.a;
import com.google.gson.JsonArray;
import ua.b;
import zb.c;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
@c("com.cloud.tmc.miniapp.defaultimpl.ToastImp")
public interface ToastProxy {
    void showActionSheet(JsonArray jsonArray, String str, String str2, String str3, String str4, boolean z11, String str5, String str6, Context context, String str7, a aVar);

    void showAddHomeSuccessfulToast();

    void showCommonDialog(String str, String str2, int i11, Boolean bool, String str3, String str4, String str5, String str6, Context context, ua.a aVar);

    b showCommonDialogWithOperate(String str, String str2, int i11, Boolean bool, String str3, String str4, String str5, String str6, Context context, ua.a aVar);

    void showModal(String str, String str2, boolean z11, boolean z12, String str3, String str4, String str5, String str6, String str7, @NonNull Context context, a aVar);

    void toast(@StringRes int i11);

    void toast(String str);

    void toast(String str, int i11);
}
