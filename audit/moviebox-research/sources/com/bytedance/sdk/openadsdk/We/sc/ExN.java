package com.bytedance.sdk.openadsdk.We.sc;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class ExN implements com.bytedance.sdk.openadsdk.multipro.sc {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private final com.bytedance.sdk.component.TRI.sc.pFF.pFF.pFF f27382sc;

    public ExN(com.bytedance.sdk.component.TRI.sc.pFF.pFF.pFF pff) {
        this.f27382sc = pff;
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.sc
    public int sc(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        com.bytedance.sdk.component.TRI.sc.pFF.pFF.pFF pff = this.f27382sc;
        if (pff != null) {
            return pff.sc(uri, contentValues, str, strArr);
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.sc
    public int sc(Uri uri, String str, String[] strArr) {
        com.bytedance.sdk.component.TRI.sc.pFF.pFF.pFF pff = this.f27382sc;
        if (pff != null) {
            return pff.sc(uri, str, strArr);
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.sc
    public Cursor sc(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        com.bytedance.sdk.component.TRI.sc.pFF.pFF.pFF pff = this.f27382sc;
        if (pff != null) {
            return pff.sc(uri, strArr, str, strArr2, str2);
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.sc
    public Uri sc(Uri uri, ContentValues contentValues) {
        com.bytedance.sdk.component.TRI.sc.pFF.pFF.pFF pff = this.f27382sc;
        if (pff != null) {
            return pff.sc(uri, contentValues);
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.sc
    public String sc() {
        com.bytedance.sdk.component.TRI.sc.pFF.pFF.pFF pff = this.f27382sc;
        if (pff != null) {
            return pff.zY();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.sc
    public String sc(Uri uri) {
        com.bytedance.sdk.component.TRI.sc.pFF.pFF.pFF pff = this.f27382sc;
        if (pff != null) {
            return pff.sc(uri);
        }
        return null;
    }
}
