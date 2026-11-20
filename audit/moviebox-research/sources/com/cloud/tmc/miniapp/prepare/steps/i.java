package com.cloud.tmc.miniapp.prepare.steps;

import com.cloud.tmc.miniapp.prepare.controller.PrepareController;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class i {
    public static void a(String str, String str2, PrepareController prepareController) {
        prepareController.moveToError(new PrepareException(str, str2));
    }
}
