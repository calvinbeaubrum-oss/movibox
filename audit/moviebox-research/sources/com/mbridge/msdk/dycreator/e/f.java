package com.mbridge.msdk.dycreator.e;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import java.io.File;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile f f43674a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.mbridge.msdk.dycreator.a.b f43675b;

    private f(Context context) {
        this.f43675b = null;
        com.mbridge.msdk.dycreator.a.b bVarA = com.mbridge.msdk.dycreator.a.b.a();
        this.f43675b = bVarA;
        bVarA.a(context, "");
    }

    public static f a(Context context) {
        if (f43674a == null) {
            synchronized (f.class) {
                try {
                    if (f43674a == null) {
                        f43674a = new f(context.getApplicationContext());
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return f43674a;
    }

    public final View a(ViewGroup viewGroup, String str) {
        if (viewGroup != null && !TextUtils.isEmpty(str)) {
            if (viewGroup.getId() == str.hashCode()) {
                return viewGroup;
            }
            int childCount = viewGroup.getChildCount();
            for (int i11 = 0; i11 < childCount; i11++) {
                View childAt = viewGroup.getChildAt(i11);
                if (childAt.getId() == str.hashCode()) {
                    return childAt;
                }
                if (childAt instanceof ViewGroup) {
                    a((ViewGroup) childAt, str);
                }
            }
        }
        return null;
    }

    public final View a(String str) {
        if (new File(str).exists()) {
            return this.f43675b.f(str);
        }
        return null;
    }
}
