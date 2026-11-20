package com.noober.background.common;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import com.transsion.gslb.Utils;
import z2.a;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class ResourceUtils {
    public static int getColor(Context context, String str) {
        Resources resources = context.getResources();
        if (str.startsWith(Utils.SEPARATOR)) {
            return Color.parseColor(str);
        }
        int identifier = resources.getIdentifier(str, TtmlNode.ATTR_TTS_COLOR, context.getPackageName());
        if (identifier == 0) {
            return -1;
        }
        return a.getColor(context, identifier);
    }

    @Nullable
    public static Drawable getDrawable(Context context, String str) {
        Resources resources = context.getResources();
        if (str.startsWith(Utils.SEPARATOR)) {
            return new ColorDrawable(Color.parseColor(str));
        }
        int identifier = resources.getIdentifier(str, "drawable", context.getPackageName());
        if (identifier == 0) {
            identifier = resources.getIdentifier(str, "mipmap", context.getPackageName());
        }
        if (identifier == 0) {
            identifier = resources.getIdentifier(str, TtmlNode.ATTR_TTS_COLOR, context.getPackageName());
        }
        if (identifier == 0) {
            return null;
        }
        return a.getDrawable(context, identifier);
    }
}
