package com.bytedance.sdk.component.Ol;

import com.bytedance.sdk.component.utils.Tf;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class pFF {
    public static boolean sc(List<String> list, String str) {
        if (list != null && !list.isEmpty()) {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                try {
                    if (Pattern.matches(it.next(), str)) {
                        return true;
                    }
                } catch (Throwable th2) {
                    Tf.pFF(th2.toString());
                }
            }
        }
        return false;
    }
}
