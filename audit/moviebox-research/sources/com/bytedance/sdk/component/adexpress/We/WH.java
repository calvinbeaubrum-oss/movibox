package com.bytedance.sdk.component.adexpress.We;

import android.net.Uri;
import android.text.TextUtils;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class WH {

    /* JADX INFO: compiled from: source.java */
    public enum sc {
        HTML("text/html"),
        CSS("text/css"),
        JS("application/x-javascript"),
        IMAGE("image/*");

        private String ExN;

        sc(String str) {
            this.ExN = str;
        }

        public String sc() {
            return this.ExN;
        }
    }

    public static boolean pFF(String str) {
        Uri uri;
        if (TextUtils.isEmpty(str) || (uri = Uri.parse(str)) == null) {
            return false;
        }
        String path = uri.getPath();
        if (TextUtils.isEmpty(path)) {
            return false;
        }
        return path.endsWith(".gif");
    }

    public static sc sc(String str) {
        sc scVar = sc.IMAGE;
        if (!TextUtils.isEmpty(str)) {
            try {
                String path = Uri.parse(str).getPath();
                if (path != null) {
                    if (path.endsWith(".css")) {
                        scVar = sc.CSS;
                    } else if (path.endsWith(".js")) {
                        scVar = sc.JS;
                    } else if (!path.endsWith(".jpg") && !path.endsWith(".gif") && !path.endsWith(".png") && !path.endsWith(".jpeg") && !path.endsWith(".webp") && !path.endsWith(".bmp") && !path.endsWith(".ico") && path.endsWith(".html")) {
                        scVar = sc.HTML;
                    }
                }
            } catch (Throwable unused) {
            }
        }
        return scVar;
    }
}
