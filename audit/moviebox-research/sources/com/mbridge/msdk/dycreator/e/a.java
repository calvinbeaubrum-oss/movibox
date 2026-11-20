package com.mbridge.msdk.dycreator.e;

import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.google.android.gms.fido.fido2.api.common.DevicePublicKeyStringDef;
import com.mbridge.msdk.dycreator.baseview.MBHorizontalScrollView;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.foundation.tools.v;
import com.mbridge.msdk.playercommon.PlayerView;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import com.transsion.gslb.Utils;
import com.vungle.warren.error.VungleException;
import java.util.HashMap;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class a {

    /* JADX INFO: renamed from: com.mbridge.msdk.dycreator.e.a$1, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    public static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f43672a;

        static {
            int[] iArr = new int[com.mbridge.msdk.dycreator.a.c.values().length];
            f43672a = iArr;
            try {
                iArr[com.mbridge.msdk.dycreator.a.c.id.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f43672a[com.mbridge.msdk.dycreator.a.c.background.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f43672a[com.mbridge.msdk.dycreator.a.c.visibility.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f43672a[com.mbridge.msdk.dycreator.a.c.contentDescription.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f43672a[com.mbridge.msdk.dycreator.a.c.padding.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f43672a[com.mbridge.msdk.dycreator.a.c.paddingTop.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f43672a[com.mbridge.msdk.dycreator.a.c.paddingBottom.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f43672a[com.mbridge.msdk.dycreator.a.c.paddingLeft.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f43672a[com.mbridge.msdk.dycreator.a.c.paddingRight.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f43672a[com.mbridge.msdk.dycreator.a.c.paddingStart.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f43672a[com.mbridge.msdk.dycreator.a.c.paddingEnd.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f43672a[com.mbridge.msdk.dycreator.a.c.orientation.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f43672a[com.mbridge.msdk.dycreator.a.c.text.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f43672a[com.mbridge.msdk.dycreator.a.c.ellipsize.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f43672a[com.mbridge.msdk.dycreator.a.c.fadingEdge.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f43672a[com.mbridge.msdk.dycreator.a.c.scrollHorizontally.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f43672a[com.mbridge.msdk.dycreator.a.c.textColor.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                f43672a[com.mbridge.msdk.dycreator.a.c.textSize.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                f43672a[com.mbridge.msdk.dycreator.a.c.textStyle.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                f43672a[com.mbridge.msdk.dycreator.a.c.style.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                f43672a[com.mbridge.msdk.dycreator.a.c.tag.ordinal()] = 21;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                f43672a[com.mbridge.msdk.dycreator.a.c.gravity.ordinal()] = 22;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                f43672a[com.mbridge.msdk.dycreator.a.c.verticalSpacing.ordinal()] = 23;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                f43672a[com.mbridge.msdk.dycreator.a.c.numColumns.ordinal()] = 24;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                f43672a[com.mbridge.msdk.dycreator.a.c.splitMotionEvents.ordinal()] = 25;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                f43672a[com.mbridge.msdk.dycreator.a.c.cacheColorHint.ordinal()] = 26;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                f43672a[com.mbridge.msdk.dycreator.a.c.horizontalSpacing.ordinal()] = 27;
            } catch (NoSuchFieldError unused27) {
            }
            try {
                f43672a[com.mbridge.msdk.dycreator.a.c.singleLine.ordinal()] = 28;
            } catch (NoSuchFieldError unused28) {
            }
            try {
                f43672a[com.mbridge.msdk.dycreator.a.c.lines.ordinal()] = 29;
            } catch (NoSuchFieldError unused29) {
            }
            try {
                f43672a[com.mbridge.msdk.dycreator.a.c.drawableLeft.ordinal()] = 30;
            } catch (NoSuchFieldError unused30) {
            }
            try {
                f43672a[com.mbridge.msdk.dycreator.a.c.drawablePadding.ordinal()] = 31;
            } catch (NoSuchFieldError unused31) {
            }
            try {
                f43672a[com.mbridge.msdk.dycreator.a.c.src.ordinal()] = 32;
            } catch (NoSuchFieldError unused32) {
            }
            try {
                f43672a[com.mbridge.msdk.dycreator.a.c.scaleType.ordinal()] = 33;
            } catch (NoSuchFieldError unused33) {
            }
            try {
                f43672a[com.mbridge.msdk.dycreator.a.c.divider.ordinal()] = 34;
            } catch (NoSuchFieldError unused34) {
            }
            try {
                f43672a[com.mbridge.msdk.dycreator.a.c.scrollbars.ordinal()] = 35;
            } catch (NoSuchFieldError unused35) {
            }
            try {
                f43672a[com.mbridge.msdk.dycreator.a.c.listSelector.ordinal()] = 36;
            } catch (NoSuchFieldError unused36) {
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:107:0x020a  */
    /* JADX WARN: Code duplicated, block: B:109:0x0211 A[Catch: Exception -> 0x0068, TRY_LEAVE, TryCatch #14 {Exception -> 0x0068, blocks: (B:6:0x000c, B:8:0x0016, B:11:0x001e, B:13:0x0029, B:16:0x003d, B:105:0x0206, B:109:0x0211, B:112:0x0220, B:139:0x030e, B:140:0x0317, B:142:0x031b, B:197:0x049a, B:198:0x04a3, B:200:0x04a7, B:224:0x0511, B:225:0x051a, B:228:0x0520, B:257:0x05ab, B:258:0x05b4, B:260:0x05b8, B:276:0x0649, B:277:0x0652, B:279:0x0656, B:280:0x065b, B:283:0x0663, B:294:0x0689, B:295:0x0692, B:297:0x0696, B:298:0x069b, B:300:0x069f, B:314:0x06c6, B:315:0x06ce, B:317:0x06d3, B:324:0x06f4, B:325:0x06fc, B:327:0x0700, B:21:0x0058, B:24:0x006b, B:25:0x007b, B:27:0x008e, B:28:0x009e, B:29:0x00ae, B:30:0x00be, B:31:0x00ce, B:44:0x00f8, B:45:0x0101, B:57:0x012c, B:58:0x0135, B:88:0x01c2, B:89:0x01ca, B:103:0x01fd, B:229:0x0523, B:233:0x0533, B:235:0x0538, B:237:0x0542, B:240:0x0551, B:242:0x055b, B:244:0x0563, B:246:0x0569, B:248:0x056f, B:249:0x0574, B:251:0x057e, B:253:0x0586, B:254:0x058c, B:255:0x059d, B:201:0x04aa, B:206:0x04bc, B:208:0x04c6, B:210:0x04ce, B:213:0x04d7, B:215:0x04df, B:216:0x04e6, B:218:0x04ee, B:219:0x04f5, B:221:0x04fd, B:222:0x0504, B:318:0x06d6, B:321:0x06e3, B:113:0x0223, B:114:0x022b, B:116:0x022f, B:119:0x0236, B:121:0x0240, B:123:0x0254, B:124:0x0258, B:125:0x0288, B:127:0x0292, B:128:0x029b, B:130:0x02a5, B:131:0x02b3, B:132:0x02c4, B:133:0x02ce, B:134:0x02d8, B:136:0x02df, B:137:0x02fd, B:143:0x031e, B:144:0x0326, B:145:0x0329, B:147:0x032e, B:150:0x0342, B:152:0x034c, B:153:0x0352, B:155:0x0358, B:156:0x0372, B:157:0x037b, B:158:0x0385, B:159:0x0396, B:162:0x03a2, B:165:0x03b8, B:166:0x03bd, B:167:0x03e2, B:169:0x03ec, B:170:0x03f5, B:172:0x03ff, B:173:0x040d, B:174:0x041e, B:175:0x0428, B:176:0x0432, B:178:0x043c, B:180:0x0444, B:181:0x0449, B:183:0x0451, B:184:0x0456, B:186:0x045e, B:187:0x0463, B:189:0x046b, B:190:0x0472, B:192:0x047c, B:194:0x0484, B:195:0x0495, B:90:0x01d2, B:92:0x01d8, B:99:0x01ef, B:101:0x01f5, B:95:0x01e0, B:97:0x01e8, B:46:0x0107, B:48:0x010d, B:50:0x0115, B:53:0x011d, B:55:0x0125, B:261:0x05bb, B:263:0x05c5, B:265:0x05ca, B:268:0x05ea, B:269:0x05fb, B:270:0x0609, B:271:0x0613, B:272:0x0631, B:274:0x063b, B:284:0x0666, B:287:0x0672, B:289:0x067c, B:292:0x0684), top: B:361:0x000c, inners: #1, #5, #7, #8, #9, #10, #12, #13, #16 }] */
    /* JADX WARN: Code duplicated, block: B:112:0x0220 A[Catch: Exception -> 0x0068, TRY_ENTER, TRY_LEAVE, TryCatch #14 {Exception -> 0x0068, blocks: (B:6:0x000c, B:8:0x0016, B:11:0x001e, B:13:0x0029, B:16:0x003d, B:105:0x0206, B:109:0x0211, B:112:0x0220, B:139:0x030e, B:140:0x0317, B:142:0x031b, B:197:0x049a, B:198:0x04a3, B:200:0x04a7, B:224:0x0511, B:225:0x051a, B:228:0x0520, B:257:0x05ab, B:258:0x05b4, B:260:0x05b8, B:276:0x0649, B:277:0x0652, B:279:0x0656, B:280:0x065b, B:283:0x0663, B:294:0x0689, B:295:0x0692, B:297:0x0696, B:298:0x069b, B:300:0x069f, B:314:0x06c6, B:315:0x06ce, B:317:0x06d3, B:324:0x06f4, B:325:0x06fc, B:327:0x0700, B:21:0x0058, B:24:0x006b, B:25:0x007b, B:27:0x008e, B:28:0x009e, B:29:0x00ae, B:30:0x00be, B:31:0x00ce, B:44:0x00f8, B:45:0x0101, B:57:0x012c, B:58:0x0135, B:88:0x01c2, B:89:0x01ca, B:103:0x01fd, B:229:0x0523, B:233:0x0533, B:235:0x0538, B:237:0x0542, B:240:0x0551, B:242:0x055b, B:244:0x0563, B:246:0x0569, B:248:0x056f, B:249:0x0574, B:251:0x057e, B:253:0x0586, B:254:0x058c, B:255:0x059d, B:201:0x04aa, B:206:0x04bc, B:208:0x04c6, B:210:0x04ce, B:213:0x04d7, B:215:0x04df, B:216:0x04e6, B:218:0x04ee, B:219:0x04f5, B:221:0x04fd, B:222:0x0504, B:318:0x06d6, B:321:0x06e3, B:113:0x0223, B:114:0x022b, B:116:0x022f, B:119:0x0236, B:121:0x0240, B:123:0x0254, B:124:0x0258, B:125:0x0288, B:127:0x0292, B:128:0x029b, B:130:0x02a5, B:131:0x02b3, B:132:0x02c4, B:133:0x02ce, B:134:0x02d8, B:136:0x02df, B:137:0x02fd, B:143:0x031e, B:144:0x0326, B:145:0x0329, B:147:0x032e, B:150:0x0342, B:152:0x034c, B:153:0x0352, B:155:0x0358, B:156:0x0372, B:157:0x037b, B:158:0x0385, B:159:0x0396, B:162:0x03a2, B:165:0x03b8, B:166:0x03bd, B:167:0x03e2, B:169:0x03ec, B:170:0x03f5, B:172:0x03ff, B:173:0x040d, B:174:0x041e, B:175:0x0428, B:176:0x0432, B:178:0x043c, B:180:0x0444, B:181:0x0449, B:183:0x0451, B:184:0x0456, B:186:0x045e, B:187:0x0463, B:189:0x046b, B:190:0x0472, B:192:0x047c, B:194:0x0484, B:195:0x0495, B:90:0x01d2, B:92:0x01d8, B:99:0x01ef, B:101:0x01f5, B:95:0x01e0, B:97:0x01e8, B:46:0x0107, B:48:0x010d, B:50:0x0115, B:53:0x011d, B:55:0x0125, B:261:0x05bb, B:263:0x05c5, B:265:0x05ca, B:268:0x05ea, B:269:0x05fb, B:270:0x0609, B:271:0x0613, B:272:0x0631, B:274:0x063b, B:284:0x0666, B:287:0x0672, B:289:0x067c, B:292:0x0684), top: B:361:0x000c, inners: #1, #5, #7, #8, #9, #10, #12, #13, #16 }] */
    /* JADX WARN: Code duplicated, block: B:115:0x022e A[DONT_GENERATE] */
    /* JADX WARN: Code duplicated, block: B:116:0x022f A[Catch: Exception -> 0x0233, TryCatch #8 {Exception -> 0x0233, blocks: (B:113:0x0223, B:114:0x022b, B:116:0x022f, B:119:0x0236, B:121:0x0240, B:123:0x0254, B:124:0x0258, B:125:0x0288, B:127:0x0292, B:128:0x029b, B:130:0x02a5, B:131:0x02b3, B:132:0x02c4, B:133:0x02ce, B:134:0x02d8, B:136:0x02df, B:137:0x02fd), top: B:349:0x0223, outer: #14 }] */
    /* JADX WARN: Code duplicated, block: B:119:0x0236 A[Catch: Exception -> 0x0233, TryCatch #8 {Exception -> 0x0233, blocks: (B:113:0x0223, B:114:0x022b, B:116:0x022f, B:119:0x0236, B:121:0x0240, B:123:0x0254, B:124:0x0258, B:125:0x0288, B:127:0x0292, B:128:0x029b, B:130:0x02a5, B:131:0x02b3, B:132:0x02c4, B:133:0x02ce, B:134:0x02d8, B:136:0x02df, B:137:0x02fd), top: B:349:0x0223, outer: #14 }] */
    /* JADX WARN: Code duplicated, block: B:121:0x0240 A[Catch: Exception -> 0x0233, TryCatch #8 {Exception -> 0x0233, blocks: (B:113:0x0223, B:114:0x022b, B:116:0x022f, B:119:0x0236, B:121:0x0240, B:123:0x0254, B:124:0x0258, B:125:0x0288, B:127:0x0292, B:128:0x029b, B:130:0x02a5, B:131:0x02b3, B:132:0x02c4, B:133:0x02ce, B:134:0x02d8, B:136:0x02df, B:137:0x02fd), top: B:349:0x0223, outer: #14 }] */
    /* JADX WARN: Code duplicated, block: B:123:0x0254 A[Catch: Exception -> 0x0233, TryCatch #8 {Exception -> 0x0233, blocks: (B:113:0x0223, B:114:0x022b, B:116:0x022f, B:119:0x0236, B:121:0x0240, B:123:0x0254, B:124:0x0258, B:125:0x0288, B:127:0x0292, B:128:0x029b, B:130:0x02a5, B:131:0x02b3, B:132:0x02c4, B:133:0x02ce, B:134:0x02d8, B:136:0x02df, B:137:0x02fd), top: B:349:0x0223, outer: #14 }] */
    /* JADX WARN: Code duplicated, block: B:124:0x0258 A[Catch: Exception -> 0x0233, TryCatch #8 {Exception -> 0x0233, blocks: (B:113:0x0223, B:114:0x022b, B:116:0x022f, B:119:0x0236, B:121:0x0240, B:123:0x0254, B:124:0x0258, B:125:0x0288, B:127:0x0292, B:128:0x029b, B:130:0x02a5, B:131:0x02b3, B:132:0x02c4, B:133:0x02ce, B:134:0x02d8, B:136:0x02df, B:137:0x02fd), top: B:349:0x0223, outer: #14 }] */
    /* JADX WARN: Code duplicated, block: B:125:0x0288 A[Catch: Exception -> 0x0233, TryCatch #8 {Exception -> 0x0233, blocks: (B:113:0x0223, B:114:0x022b, B:116:0x022f, B:119:0x0236, B:121:0x0240, B:123:0x0254, B:124:0x0258, B:125:0x0288, B:127:0x0292, B:128:0x029b, B:130:0x02a5, B:131:0x02b3, B:132:0x02c4, B:133:0x02ce, B:134:0x02d8, B:136:0x02df, B:137:0x02fd), top: B:349:0x0223, outer: #14 }] */
    /* JADX WARN: Code duplicated, block: B:127:0x0292 A[Catch: Exception -> 0x0233, TryCatch #8 {Exception -> 0x0233, blocks: (B:113:0x0223, B:114:0x022b, B:116:0x022f, B:119:0x0236, B:121:0x0240, B:123:0x0254, B:124:0x0258, B:125:0x0288, B:127:0x0292, B:128:0x029b, B:130:0x02a5, B:131:0x02b3, B:132:0x02c4, B:133:0x02ce, B:134:0x02d8, B:136:0x02df, B:137:0x02fd), top: B:349:0x0223, outer: #14 }] */
    /* JADX WARN: Code duplicated, block: B:128:0x029b A[Catch: Exception -> 0x0233, TryCatch #8 {Exception -> 0x0233, blocks: (B:113:0x0223, B:114:0x022b, B:116:0x022f, B:119:0x0236, B:121:0x0240, B:123:0x0254, B:124:0x0258, B:125:0x0288, B:127:0x0292, B:128:0x029b, B:130:0x02a5, B:131:0x02b3, B:132:0x02c4, B:133:0x02ce, B:134:0x02d8, B:136:0x02df, B:137:0x02fd), top: B:349:0x0223, outer: #14 }] */
    /* JADX WARN: Code duplicated, block: B:130:0x02a5 A[Catch: Exception -> 0x0233, TryCatch #8 {Exception -> 0x0233, blocks: (B:113:0x0223, B:114:0x022b, B:116:0x022f, B:119:0x0236, B:121:0x0240, B:123:0x0254, B:124:0x0258, B:125:0x0288, B:127:0x0292, B:128:0x029b, B:130:0x02a5, B:131:0x02b3, B:132:0x02c4, B:133:0x02ce, B:134:0x02d8, B:136:0x02df, B:137:0x02fd), top: B:349:0x0223, outer: #14 }] */
    /* JADX WARN: Code duplicated, block: B:131:0x02b3 A[Catch: Exception -> 0x0233, TryCatch #8 {Exception -> 0x0233, blocks: (B:113:0x0223, B:114:0x022b, B:116:0x022f, B:119:0x0236, B:121:0x0240, B:123:0x0254, B:124:0x0258, B:125:0x0288, B:127:0x0292, B:128:0x029b, B:130:0x02a5, B:131:0x02b3, B:132:0x02c4, B:133:0x02ce, B:134:0x02d8, B:136:0x02df, B:137:0x02fd), top: B:349:0x0223, outer: #14 }] */
    /* JADX WARN: Code duplicated, block: B:132:0x02c4 A[Catch: Exception -> 0x0233, TryCatch #8 {Exception -> 0x0233, blocks: (B:113:0x0223, B:114:0x022b, B:116:0x022f, B:119:0x0236, B:121:0x0240, B:123:0x0254, B:124:0x0258, B:125:0x0288, B:127:0x0292, B:128:0x029b, B:130:0x02a5, B:131:0x02b3, B:132:0x02c4, B:133:0x02ce, B:134:0x02d8, B:136:0x02df, B:137:0x02fd), top: B:349:0x0223, outer: #14 }] */
    /* JADX WARN: Code duplicated, block: B:133:0x02ce A[Catch: Exception -> 0x0233, TryCatch #8 {Exception -> 0x0233, blocks: (B:113:0x0223, B:114:0x022b, B:116:0x022f, B:119:0x0236, B:121:0x0240, B:123:0x0254, B:124:0x0258, B:125:0x0288, B:127:0x0292, B:128:0x029b, B:130:0x02a5, B:131:0x02b3, B:132:0x02c4, B:133:0x02ce, B:134:0x02d8, B:136:0x02df, B:137:0x02fd), top: B:349:0x0223, outer: #14 }] */
    /* JADX WARN: Code duplicated, block: B:134:0x02d8 A[Catch: Exception -> 0x0233, TryCatch #8 {Exception -> 0x0233, blocks: (B:113:0x0223, B:114:0x022b, B:116:0x022f, B:119:0x0236, B:121:0x0240, B:123:0x0254, B:124:0x0258, B:125:0x0288, B:127:0x0292, B:128:0x029b, B:130:0x02a5, B:131:0x02b3, B:132:0x02c4, B:133:0x02ce, B:134:0x02d8, B:136:0x02df, B:137:0x02fd), top: B:349:0x0223, outer: #14 }] */
    /* JADX WARN: Code duplicated, block: B:136:0x02df A[Catch: Exception -> 0x0233, TryCatch #8 {Exception -> 0x0233, blocks: (B:113:0x0223, B:114:0x022b, B:116:0x022f, B:119:0x0236, B:121:0x0240, B:123:0x0254, B:124:0x0258, B:125:0x0288, B:127:0x0292, B:128:0x029b, B:130:0x02a5, B:131:0x02b3, B:132:0x02c4, B:133:0x02ce, B:134:0x02d8, B:136:0x02df, B:137:0x02fd), top: B:349:0x0223, outer: #14 }] */
    /* JADX WARN: Code duplicated, block: B:137:0x02fd A[Catch: Exception -> 0x0233, TRY_LEAVE, TryCatch #8 {Exception -> 0x0233, blocks: (B:113:0x0223, B:114:0x022b, B:116:0x022f, B:119:0x0236, B:121:0x0240, B:123:0x0254, B:124:0x0258, B:125:0x0288, B:127:0x0292, B:128:0x029b, B:130:0x02a5, B:131:0x02b3, B:132:0x02c4, B:133:0x02ce, B:134:0x02d8, B:136:0x02df, B:137:0x02fd), top: B:349:0x0223, outer: #14 }] */
    /* JADX WARN: Code duplicated, block: B:140:0x0317 A[Catch: Exception -> 0x0068, TryCatch #14 {Exception -> 0x0068, blocks: (B:6:0x000c, B:8:0x0016, B:11:0x001e, B:13:0x0029, B:16:0x003d, B:105:0x0206, B:109:0x0211, B:112:0x0220, B:139:0x030e, B:140:0x0317, B:142:0x031b, B:197:0x049a, B:198:0x04a3, B:200:0x04a7, B:224:0x0511, B:225:0x051a, B:228:0x0520, B:257:0x05ab, B:258:0x05b4, B:260:0x05b8, B:276:0x0649, B:277:0x0652, B:279:0x0656, B:280:0x065b, B:283:0x0663, B:294:0x0689, B:295:0x0692, B:297:0x0696, B:298:0x069b, B:300:0x069f, B:314:0x06c6, B:315:0x06ce, B:317:0x06d3, B:324:0x06f4, B:325:0x06fc, B:327:0x0700, B:21:0x0058, B:24:0x006b, B:25:0x007b, B:27:0x008e, B:28:0x009e, B:29:0x00ae, B:30:0x00be, B:31:0x00ce, B:44:0x00f8, B:45:0x0101, B:57:0x012c, B:58:0x0135, B:88:0x01c2, B:89:0x01ca, B:103:0x01fd, B:229:0x0523, B:233:0x0533, B:235:0x0538, B:237:0x0542, B:240:0x0551, B:242:0x055b, B:244:0x0563, B:246:0x0569, B:248:0x056f, B:249:0x0574, B:251:0x057e, B:253:0x0586, B:254:0x058c, B:255:0x059d, B:201:0x04aa, B:206:0x04bc, B:208:0x04c6, B:210:0x04ce, B:213:0x04d7, B:215:0x04df, B:216:0x04e6, B:218:0x04ee, B:219:0x04f5, B:221:0x04fd, B:222:0x0504, B:318:0x06d6, B:321:0x06e3, B:113:0x0223, B:114:0x022b, B:116:0x022f, B:119:0x0236, B:121:0x0240, B:123:0x0254, B:124:0x0258, B:125:0x0288, B:127:0x0292, B:128:0x029b, B:130:0x02a5, B:131:0x02b3, B:132:0x02c4, B:133:0x02ce, B:134:0x02d8, B:136:0x02df, B:137:0x02fd, B:143:0x031e, B:144:0x0326, B:145:0x0329, B:147:0x032e, B:150:0x0342, B:152:0x034c, B:153:0x0352, B:155:0x0358, B:156:0x0372, B:157:0x037b, B:158:0x0385, B:159:0x0396, B:162:0x03a2, B:165:0x03b8, B:166:0x03bd, B:167:0x03e2, B:169:0x03ec, B:170:0x03f5, B:172:0x03ff, B:173:0x040d, B:174:0x041e, B:175:0x0428, B:176:0x0432, B:178:0x043c, B:180:0x0444, B:181:0x0449, B:183:0x0451, B:184:0x0456, B:186:0x045e, B:187:0x0463, B:189:0x046b, B:190:0x0472, B:192:0x047c, B:194:0x0484, B:195:0x0495, B:90:0x01d2, B:92:0x01d8, B:99:0x01ef, B:101:0x01f5, B:95:0x01e0, B:97:0x01e8, B:46:0x0107, B:48:0x010d, B:50:0x0115, B:53:0x011d, B:55:0x0125, B:261:0x05bb, B:263:0x05c5, B:265:0x05ca, B:268:0x05ea, B:269:0x05fb, B:270:0x0609, B:271:0x0613, B:272:0x0631, B:274:0x063b, B:284:0x0666, B:287:0x0672, B:289:0x067c, B:292:0x0684), top: B:361:0x000c, inners: #1, #5, #7, #8, #9, #10, #12, #13, #16 }] */
    /* JADX WARN: Code duplicated, block: B:142:0x031b A[Catch: Exception -> 0x0068, TRY_LEAVE, TryCatch #14 {Exception -> 0x0068, blocks: (B:6:0x000c, B:8:0x0016, B:11:0x001e, B:13:0x0029, B:16:0x003d, B:105:0x0206, B:109:0x0211, B:112:0x0220, B:139:0x030e, B:140:0x0317, B:142:0x031b, B:197:0x049a, B:198:0x04a3, B:200:0x04a7, B:224:0x0511, B:225:0x051a, B:228:0x0520, B:257:0x05ab, B:258:0x05b4, B:260:0x05b8, B:276:0x0649, B:277:0x0652, B:279:0x0656, B:280:0x065b, B:283:0x0663, B:294:0x0689, B:295:0x0692, B:297:0x0696, B:298:0x069b, B:300:0x069f, B:314:0x06c6, B:315:0x06ce, B:317:0x06d3, B:324:0x06f4, B:325:0x06fc, B:327:0x0700, B:21:0x0058, B:24:0x006b, B:25:0x007b, B:27:0x008e, B:28:0x009e, B:29:0x00ae, B:30:0x00be, B:31:0x00ce, B:44:0x00f8, B:45:0x0101, B:57:0x012c, B:58:0x0135, B:88:0x01c2, B:89:0x01ca, B:103:0x01fd, B:229:0x0523, B:233:0x0533, B:235:0x0538, B:237:0x0542, B:240:0x0551, B:242:0x055b, B:244:0x0563, B:246:0x0569, B:248:0x056f, B:249:0x0574, B:251:0x057e, B:253:0x0586, B:254:0x058c, B:255:0x059d, B:201:0x04aa, B:206:0x04bc, B:208:0x04c6, B:210:0x04ce, B:213:0x04d7, B:215:0x04df, B:216:0x04e6, B:218:0x04ee, B:219:0x04f5, B:221:0x04fd, B:222:0x0504, B:318:0x06d6, B:321:0x06e3, B:113:0x0223, B:114:0x022b, B:116:0x022f, B:119:0x0236, B:121:0x0240, B:123:0x0254, B:124:0x0258, B:125:0x0288, B:127:0x0292, B:128:0x029b, B:130:0x02a5, B:131:0x02b3, B:132:0x02c4, B:133:0x02ce, B:134:0x02d8, B:136:0x02df, B:137:0x02fd, B:143:0x031e, B:144:0x0326, B:145:0x0329, B:147:0x032e, B:150:0x0342, B:152:0x034c, B:153:0x0352, B:155:0x0358, B:156:0x0372, B:157:0x037b, B:158:0x0385, B:159:0x0396, B:162:0x03a2, B:165:0x03b8, B:166:0x03bd, B:167:0x03e2, B:169:0x03ec, B:170:0x03f5, B:172:0x03ff, B:173:0x040d, B:174:0x041e, B:175:0x0428, B:176:0x0432, B:178:0x043c, B:180:0x0444, B:181:0x0449, B:183:0x0451, B:184:0x0456, B:186:0x045e, B:187:0x0463, B:189:0x046b, B:190:0x0472, B:192:0x047c, B:194:0x0484, B:195:0x0495, B:90:0x01d2, B:92:0x01d8, B:99:0x01ef, B:101:0x01f5, B:95:0x01e0, B:97:0x01e8, B:46:0x0107, B:48:0x010d, B:50:0x0115, B:53:0x011d, B:55:0x0125, B:261:0x05bb, B:263:0x05c5, B:265:0x05ca, B:268:0x05ea, B:269:0x05fb, B:270:0x0609, B:271:0x0613, B:272:0x0631, B:274:0x063b, B:284:0x0666, B:287:0x0672, B:289:0x067c, B:292:0x0684), top: B:361:0x000c, inners: #1, #5, #7, #8, #9, #10, #12, #13, #16 }] */
    /* JADX WARN: Code duplicated, block: B:145:0x0329 A[Catch: Exception -> 0x033f, TryCatch #9 {Exception -> 0x033f, blocks: (B:143:0x031e, B:144:0x0326, B:145:0x0329, B:147:0x032e, B:150:0x0342, B:152:0x034c, B:153:0x0352, B:155:0x0358, B:156:0x0372, B:157:0x037b, B:158:0x0385, B:159:0x0396, B:162:0x03a2, B:165:0x03b8, B:166:0x03bd, B:167:0x03e2, B:169:0x03ec, B:170:0x03f5, B:172:0x03ff, B:173:0x040d, B:174:0x041e, B:175:0x0428, B:176:0x0432, B:178:0x043c, B:180:0x0444, B:181:0x0449, B:183:0x0451, B:184:0x0456, B:186:0x045e, B:187:0x0463, B:189:0x046b, B:190:0x0472, B:192:0x047c, B:194:0x0484, B:195:0x0495), top: B:351:0x031e, outer: #14 }] */
    /* JADX WARN: Code duplicated, block: B:146:0x032c A[DONT_GENERATE] */
    /* JADX WARN: Code duplicated, block: B:147:0x032e A[Catch: Exception -> 0x033f, TryCatch #9 {Exception -> 0x033f, blocks: (B:143:0x031e, B:144:0x0326, B:145:0x0329, B:147:0x032e, B:150:0x0342, B:152:0x034c, B:153:0x0352, B:155:0x0358, B:156:0x0372, B:157:0x037b, B:158:0x0385, B:159:0x0396, B:162:0x03a2, B:165:0x03b8, B:166:0x03bd, B:167:0x03e2, B:169:0x03ec, B:170:0x03f5, B:172:0x03ff, B:173:0x040d, B:174:0x041e, B:175:0x0428, B:176:0x0432, B:178:0x043c, B:180:0x0444, B:181:0x0449, B:183:0x0451, B:184:0x0456, B:186:0x045e, B:187:0x0463, B:189:0x046b, B:190:0x0472, B:192:0x047c, B:194:0x0484, B:195:0x0495), top: B:351:0x031e, outer: #14 }] */
    /* JADX WARN: Code duplicated, block: B:150:0x0342 A[Catch: Exception -> 0x033f, TryCatch #9 {Exception -> 0x033f, blocks: (B:143:0x031e, B:144:0x0326, B:145:0x0329, B:147:0x032e, B:150:0x0342, B:152:0x034c, B:153:0x0352, B:155:0x0358, B:156:0x0372, B:157:0x037b, B:158:0x0385, B:159:0x0396, B:162:0x03a2, B:165:0x03b8, B:166:0x03bd, B:167:0x03e2, B:169:0x03ec, B:170:0x03f5, B:172:0x03ff, B:173:0x040d, B:174:0x041e, B:175:0x0428, B:176:0x0432, B:178:0x043c, B:180:0x0444, B:181:0x0449, B:183:0x0451, B:184:0x0456, B:186:0x045e, B:187:0x0463, B:189:0x046b, B:190:0x0472, B:192:0x047c, B:194:0x0484, B:195:0x0495), top: B:351:0x031e, outer: #14 }] */
    /* JADX WARN: Code duplicated, block: B:152:0x034c A[Catch: Exception -> 0x033f, TryCatch #9 {Exception -> 0x033f, blocks: (B:143:0x031e, B:144:0x0326, B:145:0x0329, B:147:0x032e, B:150:0x0342, B:152:0x034c, B:153:0x0352, B:155:0x0358, B:156:0x0372, B:157:0x037b, B:158:0x0385, B:159:0x0396, B:162:0x03a2, B:165:0x03b8, B:166:0x03bd, B:167:0x03e2, B:169:0x03ec, B:170:0x03f5, B:172:0x03ff, B:173:0x040d, B:174:0x041e, B:175:0x0428, B:176:0x0432, B:178:0x043c, B:180:0x0444, B:181:0x0449, B:183:0x0451, B:184:0x0456, B:186:0x045e, B:187:0x0463, B:189:0x046b, B:190:0x0472, B:192:0x047c, B:194:0x0484, B:195:0x0495), top: B:351:0x031e, outer: #14 }] */
    /* JADX WARN: Code duplicated, block: B:155:0x0358 A[Catch: Exception -> 0x033f, TryCatch #9 {Exception -> 0x033f, blocks: (B:143:0x031e, B:144:0x0326, B:145:0x0329, B:147:0x032e, B:150:0x0342, B:152:0x034c, B:153:0x0352, B:155:0x0358, B:156:0x0372, B:157:0x037b, B:158:0x0385, B:159:0x0396, B:162:0x03a2, B:165:0x03b8, B:166:0x03bd, B:167:0x03e2, B:169:0x03ec, B:170:0x03f5, B:172:0x03ff, B:173:0x040d, B:174:0x041e, B:175:0x0428, B:176:0x0432, B:178:0x043c, B:180:0x0444, B:181:0x0449, B:183:0x0451, B:184:0x0456, B:186:0x045e, B:187:0x0463, B:189:0x046b, B:190:0x0472, B:192:0x047c, B:194:0x0484, B:195:0x0495), top: B:351:0x031e, outer: #14 }] */
    /* JADX WARN: Code duplicated, block: B:156:0x0372 A[Catch: Exception -> 0x033f, TryCatch #9 {Exception -> 0x033f, blocks: (B:143:0x031e, B:144:0x0326, B:145:0x0329, B:147:0x032e, B:150:0x0342, B:152:0x034c, B:153:0x0352, B:155:0x0358, B:156:0x0372, B:157:0x037b, B:158:0x0385, B:159:0x0396, B:162:0x03a2, B:165:0x03b8, B:166:0x03bd, B:167:0x03e2, B:169:0x03ec, B:170:0x03f5, B:172:0x03ff, B:173:0x040d, B:174:0x041e, B:175:0x0428, B:176:0x0432, B:178:0x043c, B:180:0x0444, B:181:0x0449, B:183:0x0451, B:184:0x0456, B:186:0x045e, B:187:0x0463, B:189:0x046b, B:190:0x0472, B:192:0x047c, B:194:0x0484, B:195:0x0495), top: B:351:0x031e, outer: #14 }] */
    /* JADX WARN: Code duplicated, block: B:157:0x037b A[Catch: Exception -> 0x033f, TryCatch #9 {Exception -> 0x033f, blocks: (B:143:0x031e, B:144:0x0326, B:145:0x0329, B:147:0x032e, B:150:0x0342, B:152:0x034c, B:153:0x0352, B:155:0x0358, B:156:0x0372, B:157:0x037b, B:158:0x0385, B:159:0x0396, B:162:0x03a2, B:165:0x03b8, B:166:0x03bd, B:167:0x03e2, B:169:0x03ec, B:170:0x03f5, B:172:0x03ff, B:173:0x040d, B:174:0x041e, B:175:0x0428, B:176:0x0432, B:178:0x043c, B:180:0x0444, B:181:0x0449, B:183:0x0451, B:184:0x0456, B:186:0x045e, B:187:0x0463, B:189:0x046b, B:190:0x0472, B:192:0x047c, B:194:0x0484, B:195:0x0495), top: B:351:0x031e, outer: #14 }] */
    /* JADX WARN: Code duplicated, block: B:158:0x0385 A[Catch: Exception -> 0x033f, TryCatch #9 {Exception -> 0x033f, blocks: (B:143:0x031e, B:144:0x0326, B:145:0x0329, B:147:0x032e, B:150:0x0342, B:152:0x034c, B:153:0x0352, B:155:0x0358, B:156:0x0372, B:157:0x037b, B:158:0x0385, B:159:0x0396, B:162:0x03a2, B:165:0x03b8, B:166:0x03bd, B:167:0x03e2, B:169:0x03ec, B:170:0x03f5, B:172:0x03ff, B:173:0x040d, B:174:0x041e, B:175:0x0428, B:176:0x0432, B:178:0x043c, B:180:0x0444, B:181:0x0449, B:183:0x0451, B:184:0x0456, B:186:0x045e, B:187:0x0463, B:189:0x046b, B:190:0x0472, B:192:0x047c, B:194:0x0484, B:195:0x0495), top: B:351:0x031e, outer: #14 }] */
    /* JADX WARN: Code duplicated, block: B:159:0x0396 A[Catch: Exception -> 0x033f, TryCatch #9 {Exception -> 0x033f, blocks: (B:143:0x031e, B:144:0x0326, B:145:0x0329, B:147:0x032e, B:150:0x0342, B:152:0x034c, B:153:0x0352, B:155:0x0358, B:156:0x0372, B:157:0x037b, B:158:0x0385, B:159:0x0396, B:162:0x03a2, B:165:0x03b8, B:166:0x03bd, B:167:0x03e2, B:169:0x03ec, B:170:0x03f5, B:172:0x03ff, B:173:0x040d, B:174:0x041e, B:175:0x0428, B:176:0x0432, B:178:0x043c, B:180:0x0444, B:181:0x0449, B:183:0x0451, B:184:0x0456, B:186:0x045e, B:187:0x0463, B:189:0x046b, B:190:0x0472, B:192:0x047c, B:194:0x0484, B:195:0x0495), top: B:351:0x031e, outer: #14 }] */
    /* JADX WARN: Code duplicated, block: B:161:0x03a0  */
    /* JADX WARN: Code duplicated, block: B:162:0x03a2 A[Catch: Exception -> 0x033f, TryCatch #9 {Exception -> 0x033f, blocks: (B:143:0x031e, B:144:0x0326, B:145:0x0329, B:147:0x032e, B:150:0x0342, B:152:0x034c, B:153:0x0352, B:155:0x0358, B:156:0x0372, B:157:0x037b, B:158:0x0385, B:159:0x0396, B:162:0x03a2, B:165:0x03b8, B:166:0x03bd, B:167:0x03e2, B:169:0x03ec, B:170:0x03f5, B:172:0x03ff, B:173:0x040d, B:174:0x041e, B:175:0x0428, B:176:0x0432, B:178:0x043c, B:180:0x0444, B:181:0x0449, B:183:0x0451, B:184:0x0456, B:186:0x045e, B:187:0x0463, B:189:0x046b, B:190:0x0472, B:192:0x047c, B:194:0x0484, B:195:0x0495), top: B:351:0x031e, outer: #14 }] */
    /* JADX WARN: Code duplicated, block: B:164:0x03b6  */
    /* JADX WARN: Code duplicated, block: B:165:0x03b8 A[Catch: Exception -> 0x033f, TryCatch #9 {Exception -> 0x033f, blocks: (B:143:0x031e, B:144:0x0326, B:145:0x0329, B:147:0x032e, B:150:0x0342, B:152:0x034c, B:153:0x0352, B:155:0x0358, B:156:0x0372, B:157:0x037b, B:158:0x0385, B:159:0x0396, B:162:0x03a2, B:165:0x03b8, B:166:0x03bd, B:167:0x03e2, B:169:0x03ec, B:170:0x03f5, B:172:0x03ff, B:173:0x040d, B:174:0x041e, B:175:0x0428, B:176:0x0432, B:178:0x043c, B:180:0x0444, B:181:0x0449, B:183:0x0451, B:184:0x0456, B:186:0x045e, B:187:0x0463, B:189:0x046b, B:190:0x0472, B:192:0x047c, B:194:0x0484, B:195:0x0495), top: B:351:0x031e, outer: #14 }] */
    /* JADX WARN: Code duplicated, block: B:166:0x03bd A[Catch: Exception -> 0x033f, TryCatch #9 {Exception -> 0x033f, blocks: (B:143:0x031e, B:144:0x0326, B:145:0x0329, B:147:0x032e, B:150:0x0342, B:152:0x034c, B:153:0x0352, B:155:0x0358, B:156:0x0372, B:157:0x037b, B:158:0x0385, B:159:0x0396, B:162:0x03a2, B:165:0x03b8, B:166:0x03bd, B:167:0x03e2, B:169:0x03ec, B:170:0x03f5, B:172:0x03ff, B:173:0x040d, B:174:0x041e, B:175:0x0428, B:176:0x0432, B:178:0x043c, B:180:0x0444, B:181:0x0449, B:183:0x0451, B:184:0x0456, B:186:0x045e, B:187:0x0463, B:189:0x046b, B:190:0x0472, B:192:0x047c, B:194:0x0484, B:195:0x0495), top: B:351:0x031e, outer: #14 }] */
    /* JADX WARN: Code duplicated, block: B:167:0x03e2 A[Catch: Exception -> 0x033f, TryCatch #9 {Exception -> 0x033f, blocks: (B:143:0x031e, B:144:0x0326, B:145:0x0329, B:147:0x032e, B:150:0x0342, B:152:0x034c, B:153:0x0352, B:155:0x0358, B:156:0x0372, B:157:0x037b, B:158:0x0385, B:159:0x0396, B:162:0x03a2, B:165:0x03b8, B:166:0x03bd, B:167:0x03e2, B:169:0x03ec, B:170:0x03f5, B:172:0x03ff, B:173:0x040d, B:174:0x041e, B:175:0x0428, B:176:0x0432, B:178:0x043c, B:180:0x0444, B:181:0x0449, B:183:0x0451, B:184:0x0456, B:186:0x045e, B:187:0x0463, B:189:0x046b, B:190:0x0472, B:192:0x047c, B:194:0x0484, B:195:0x0495), top: B:351:0x031e, outer: #14 }] */
    /* JADX WARN: Code duplicated, block: B:169:0x03ec A[Catch: Exception -> 0x033f, TryCatch #9 {Exception -> 0x033f, blocks: (B:143:0x031e, B:144:0x0326, B:145:0x0329, B:147:0x032e, B:150:0x0342, B:152:0x034c, B:153:0x0352, B:155:0x0358, B:156:0x0372, B:157:0x037b, B:158:0x0385, B:159:0x0396, B:162:0x03a2, B:165:0x03b8, B:166:0x03bd, B:167:0x03e2, B:169:0x03ec, B:170:0x03f5, B:172:0x03ff, B:173:0x040d, B:174:0x041e, B:175:0x0428, B:176:0x0432, B:178:0x043c, B:180:0x0444, B:181:0x0449, B:183:0x0451, B:184:0x0456, B:186:0x045e, B:187:0x0463, B:189:0x046b, B:190:0x0472, B:192:0x047c, B:194:0x0484, B:195:0x0495), top: B:351:0x031e, outer: #14 }] */
    /* JADX WARN: Code duplicated, block: B:170:0x03f5 A[Catch: Exception -> 0x033f, TryCatch #9 {Exception -> 0x033f, blocks: (B:143:0x031e, B:144:0x0326, B:145:0x0329, B:147:0x032e, B:150:0x0342, B:152:0x034c, B:153:0x0352, B:155:0x0358, B:156:0x0372, B:157:0x037b, B:158:0x0385, B:159:0x0396, B:162:0x03a2, B:165:0x03b8, B:166:0x03bd, B:167:0x03e2, B:169:0x03ec, B:170:0x03f5, B:172:0x03ff, B:173:0x040d, B:174:0x041e, B:175:0x0428, B:176:0x0432, B:178:0x043c, B:180:0x0444, B:181:0x0449, B:183:0x0451, B:184:0x0456, B:186:0x045e, B:187:0x0463, B:189:0x046b, B:190:0x0472, B:192:0x047c, B:194:0x0484, B:195:0x0495), top: B:351:0x031e, outer: #14 }] */
    /* JADX WARN: Code duplicated, block: B:172:0x03ff A[Catch: Exception -> 0x033f, TryCatch #9 {Exception -> 0x033f, blocks: (B:143:0x031e, B:144:0x0326, B:145:0x0329, B:147:0x032e, B:150:0x0342, B:152:0x034c, B:153:0x0352, B:155:0x0358, B:156:0x0372, B:157:0x037b, B:158:0x0385, B:159:0x0396, B:162:0x03a2, B:165:0x03b8, B:166:0x03bd, B:167:0x03e2, B:169:0x03ec, B:170:0x03f5, B:172:0x03ff, B:173:0x040d, B:174:0x041e, B:175:0x0428, B:176:0x0432, B:178:0x043c, B:180:0x0444, B:181:0x0449, B:183:0x0451, B:184:0x0456, B:186:0x045e, B:187:0x0463, B:189:0x046b, B:190:0x0472, B:192:0x047c, B:194:0x0484, B:195:0x0495), top: B:351:0x031e, outer: #14 }] */
    /* JADX WARN: Code duplicated, block: B:173:0x040d A[Catch: Exception -> 0x033f, TryCatch #9 {Exception -> 0x033f, blocks: (B:143:0x031e, B:144:0x0326, B:145:0x0329, B:147:0x032e, B:150:0x0342, B:152:0x034c, B:153:0x0352, B:155:0x0358, B:156:0x0372, B:157:0x037b, B:158:0x0385, B:159:0x0396, B:162:0x03a2, B:165:0x03b8, B:166:0x03bd, B:167:0x03e2, B:169:0x03ec, B:170:0x03f5, B:172:0x03ff, B:173:0x040d, B:174:0x041e, B:175:0x0428, B:176:0x0432, B:178:0x043c, B:180:0x0444, B:181:0x0449, B:183:0x0451, B:184:0x0456, B:186:0x045e, B:187:0x0463, B:189:0x046b, B:190:0x0472, B:192:0x047c, B:194:0x0484, B:195:0x0495), top: B:351:0x031e, outer: #14 }] */
    /* JADX WARN: Code duplicated, block: B:174:0x041e A[Catch: Exception -> 0x033f, TryCatch #9 {Exception -> 0x033f, blocks: (B:143:0x031e, B:144:0x0326, B:145:0x0329, B:147:0x032e, B:150:0x0342, B:152:0x034c, B:153:0x0352, B:155:0x0358, B:156:0x0372, B:157:0x037b, B:158:0x0385, B:159:0x0396, B:162:0x03a2, B:165:0x03b8, B:166:0x03bd, B:167:0x03e2, B:169:0x03ec, B:170:0x03f5, B:172:0x03ff, B:173:0x040d, B:174:0x041e, B:175:0x0428, B:176:0x0432, B:178:0x043c, B:180:0x0444, B:181:0x0449, B:183:0x0451, B:184:0x0456, B:186:0x045e, B:187:0x0463, B:189:0x046b, B:190:0x0472, B:192:0x047c, B:194:0x0484, B:195:0x0495), top: B:351:0x031e, outer: #14 }] */
    /* JADX WARN: Code duplicated, block: B:175:0x0428 A[Catch: Exception -> 0x033f, TryCatch #9 {Exception -> 0x033f, blocks: (B:143:0x031e, B:144:0x0326, B:145:0x0329, B:147:0x032e, B:150:0x0342, B:152:0x034c, B:153:0x0352, B:155:0x0358, B:156:0x0372, B:157:0x037b, B:158:0x0385, B:159:0x0396, B:162:0x03a2, B:165:0x03b8, B:166:0x03bd, B:167:0x03e2, B:169:0x03ec, B:170:0x03f5, B:172:0x03ff, B:173:0x040d, B:174:0x041e, B:175:0x0428, B:176:0x0432, B:178:0x043c, B:180:0x0444, B:181:0x0449, B:183:0x0451, B:184:0x0456, B:186:0x045e, B:187:0x0463, B:189:0x046b, B:190:0x0472, B:192:0x047c, B:194:0x0484, B:195:0x0495), top: B:351:0x031e, outer: #14 }] */
    /* JADX WARN: Code duplicated, block: B:176:0x0432 A[Catch: Exception -> 0x033f, TryCatch #9 {Exception -> 0x033f, blocks: (B:143:0x031e, B:144:0x0326, B:145:0x0329, B:147:0x032e, B:150:0x0342, B:152:0x034c, B:153:0x0352, B:155:0x0358, B:156:0x0372, B:157:0x037b, B:158:0x0385, B:159:0x0396, B:162:0x03a2, B:165:0x03b8, B:166:0x03bd, B:167:0x03e2, B:169:0x03ec, B:170:0x03f5, B:172:0x03ff, B:173:0x040d, B:174:0x041e, B:175:0x0428, B:176:0x0432, B:178:0x043c, B:180:0x0444, B:181:0x0449, B:183:0x0451, B:184:0x0456, B:186:0x045e, B:187:0x0463, B:189:0x046b, B:190:0x0472, B:192:0x047c, B:194:0x0484, B:195:0x0495), top: B:351:0x031e, outer: #14 }] */
    /* JADX WARN: Code duplicated, block: B:178:0x043c A[Catch: Exception -> 0x033f, TryCatch #9 {Exception -> 0x033f, blocks: (B:143:0x031e, B:144:0x0326, B:145:0x0329, B:147:0x032e, B:150:0x0342, B:152:0x034c, B:153:0x0352, B:155:0x0358, B:156:0x0372, B:157:0x037b, B:158:0x0385, B:159:0x0396, B:162:0x03a2, B:165:0x03b8, B:166:0x03bd, B:167:0x03e2, B:169:0x03ec, B:170:0x03f5, B:172:0x03ff, B:173:0x040d, B:174:0x041e, B:175:0x0428, B:176:0x0432, B:178:0x043c, B:180:0x0444, B:181:0x0449, B:183:0x0451, B:184:0x0456, B:186:0x045e, B:187:0x0463, B:189:0x046b, B:190:0x0472, B:192:0x047c, B:194:0x0484, B:195:0x0495), top: B:351:0x031e, outer: #14 }] */
    /* JADX WARN: Code duplicated, block: B:180:0x0444 A[Catch: Exception -> 0x033f, TryCatch #9 {Exception -> 0x033f, blocks: (B:143:0x031e, B:144:0x0326, B:145:0x0329, B:147:0x032e, B:150:0x0342, B:152:0x034c, B:153:0x0352, B:155:0x0358, B:156:0x0372, B:157:0x037b, B:158:0x0385, B:159:0x0396, B:162:0x03a2, B:165:0x03b8, B:166:0x03bd, B:167:0x03e2, B:169:0x03ec, B:170:0x03f5, B:172:0x03ff, B:173:0x040d, B:174:0x041e, B:175:0x0428, B:176:0x0432, B:178:0x043c, B:180:0x0444, B:181:0x0449, B:183:0x0451, B:184:0x0456, B:186:0x045e, B:187:0x0463, B:189:0x046b, B:190:0x0472, B:192:0x047c, B:194:0x0484, B:195:0x0495), top: B:351:0x031e, outer: #14 }] */
    /* JADX WARN: Code duplicated, block: B:183:0x0451 A[Catch: Exception -> 0x033f, TryCatch #9 {Exception -> 0x033f, blocks: (B:143:0x031e, B:144:0x0326, B:145:0x0329, B:147:0x032e, B:150:0x0342, B:152:0x034c, B:153:0x0352, B:155:0x0358, B:156:0x0372, B:157:0x037b, B:158:0x0385, B:159:0x0396, B:162:0x03a2, B:165:0x03b8, B:166:0x03bd, B:167:0x03e2, B:169:0x03ec, B:170:0x03f5, B:172:0x03ff, B:173:0x040d, B:174:0x041e, B:175:0x0428, B:176:0x0432, B:178:0x043c, B:180:0x0444, B:181:0x0449, B:183:0x0451, B:184:0x0456, B:186:0x045e, B:187:0x0463, B:189:0x046b, B:190:0x0472, B:192:0x047c, B:194:0x0484, B:195:0x0495), top: B:351:0x031e, outer: #14 }] */
    /* JADX WARN: Code duplicated, block: B:186:0x045e A[Catch: Exception -> 0x033f, TryCatch #9 {Exception -> 0x033f, blocks: (B:143:0x031e, B:144:0x0326, B:145:0x0329, B:147:0x032e, B:150:0x0342, B:152:0x034c, B:153:0x0352, B:155:0x0358, B:156:0x0372, B:157:0x037b, B:158:0x0385, B:159:0x0396, B:162:0x03a2, B:165:0x03b8, B:166:0x03bd, B:167:0x03e2, B:169:0x03ec, B:170:0x03f5, B:172:0x03ff, B:173:0x040d, B:174:0x041e, B:175:0x0428, B:176:0x0432, B:178:0x043c, B:180:0x0444, B:181:0x0449, B:183:0x0451, B:184:0x0456, B:186:0x045e, B:187:0x0463, B:189:0x046b, B:190:0x0472, B:192:0x047c, B:194:0x0484, B:195:0x0495), top: B:351:0x031e, outer: #14 }] */
    /* JADX WARN: Code duplicated, block: B:189:0x046b A[Catch: Exception -> 0x033f, TryCatch #9 {Exception -> 0x033f, blocks: (B:143:0x031e, B:144:0x0326, B:145:0x0329, B:147:0x032e, B:150:0x0342, B:152:0x034c, B:153:0x0352, B:155:0x0358, B:156:0x0372, B:157:0x037b, B:158:0x0385, B:159:0x0396, B:162:0x03a2, B:165:0x03b8, B:166:0x03bd, B:167:0x03e2, B:169:0x03ec, B:170:0x03f5, B:172:0x03ff, B:173:0x040d, B:174:0x041e, B:175:0x0428, B:176:0x0432, B:178:0x043c, B:180:0x0444, B:181:0x0449, B:183:0x0451, B:184:0x0456, B:186:0x045e, B:187:0x0463, B:189:0x046b, B:190:0x0472, B:192:0x047c, B:194:0x0484, B:195:0x0495), top: B:351:0x031e, outer: #14 }] */
    /* JADX WARN: Code duplicated, block: B:190:0x0472 A[Catch: Exception -> 0x033f, TryCatch #9 {Exception -> 0x033f, blocks: (B:143:0x031e, B:144:0x0326, B:145:0x0329, B:147:0x032e, B:150:0x0342, B:152:0x034c, B:153:0x0352, B:155:0x0358, B:156:0x0372, B:157:0x037b, B:158:0x0385, B:159:0x0396, B:162:0x03a2, B:165:0x03b8, B:166:0x03bd, B:167:0x03e2, B:169:0x03ec, B:170:0x03f5, B:172:0x03ff, B:173:0x040d, B:174:0x041e, B:175:0x0428, B:176:0x0432, B:178:0x043c, B:180:0x0444, B:181:0x0449, B:183:0x0451, B:184:0x0456, B:186:0x045e, B:187:0x0463, B:189:0x046b, B:190:0x0472, B:192:0x047c, B:194:0x0484, B:195:0x0495), top: B:351:0x031e, outer: #14 }] */
    /* JADX WARN: Code duplicated, block: B:192:0x047c A[Catch: Exception -> 0x033f, TryCatch #9 {Exception -> 0x033f, blocks: (B:143:0x031e, B:144:0x0326, B:145:0x0329, B:147:0x032e, B:150:0x0342, B:152:0x034c, B:153:0x0352, B:155:0x0358, B:156:0x0372, B:157:0x037b, B:158:0x0385, B:159:0x0396, B:162:0x03a2, B:165:0x03b8, B:166:0x03bd, B:167:0x03e2, B:169:0x03ec, B:170:0x03f5, B:172:0x03ff, B:173:0x040d, B:174:0x041e, B:175:0x0428, B:176:0x0432, B:178:0x043c, B:180:0x0444, B:181:0x0449, B:183:0x0451, B:184:0x0456, B:186:0x045e, B:187:0x0463, B:189:0x046b, B:190:0x0472, B:192:0x047c, B:194:0x0484, B:195:0x0495), top: B:351:0x031e, outer: #14 }] */
    /* JADX WARN: Code duplicated, block: B:194:0x0484 A[Catch: Exception -> 0x033f, TryCatch #9 {Exception -> 0x033f, blocks: (B:143:0x031e, B:144:0x0326, B:145:0x0329, B:147:0x032e, B:150:0x0342, B:152:0x034c, B:153:0x0352, B:155:0x0358, B:156:0x0372, B:157:0x037b, B:158:0x0385, B:159:0x0396, B:162:0x03a2, B:165:0x03b8, B:166:0x03bd, B:167:0x03e2, B:169:0x03ec, B:170:0x03f5, B:172:0x03ff, B:173:0x040d, B:174:0x041e, B:175:0x0428, B:176:0x0432, B:178:0x043c, B:180:0x0444, B:181:0x0449, B:183:0x0451, B:184:0x0456, B:186:0x045e, B:187:0x0463, B:189:0x046b, B:190:0x0472, B:192:0x047c, B:194:0x0484, B:195:0x0495), top: B:351:0x031e, outer: #14 }] */
    /* JADX WARN: Code duplicated, block: B:195:0x0495 A[Catch: Exception -> 0x033f, TRY_LEAVE, TryCatch #9 {Exception -> 0x033f, blocks: (B:143:0x031e, B:144:0x0326, B:145:0x0329, B:147:0x032e, B:150:0x0342, B:152:0x034c, B:153:0x0352, B:155:0x0358, B:156:0x0372, B:157:0x037b, B:158:0x0385, B:159:0x0396, B:162:0x03a2, B:165:0x03b8, B:166:0x03bd, B:167:0x03e2, B:169:0x03ec, B:170:0x03f5, B:172:0x03ff, B:173:0x040d, B:174:0x041e, B:175:0x0428, B:176:0x0432, B:178:0x043c, B:180:0x0444, B:181:0x0449, B:183:0x0451, B:184:0x0456, B:186:0x045e, B:187:0x0463, B:189:0x046b, B:190:0x0472, B:192:0x047c, B:194:0x0484, B:195:0x0495), top: B:351:0x031e, outer: #14 }] */
    /* JADX WARN: Code duplicated, block: B:198:0x04a3 A[Catch: Exception -> 0x0068, TryCatch #14 {Exception -> 0x0068, blocks: (B:6:0x000c, B:8:0x0016, B:11:0x001e, B:13:0x0029, B:16:0x003d, B:105:0x0206, B:109:0x0211, B:112:0x0220, B:139:0x030e, B:140:0x0317, B:142:0x031b, B:197:0x049a, B:198:0x04a3, B:200:0x04a7, B:224:0x0511, B:225:0x051a, B:228:0x0520, B:257:0x05ab, B:258:0x05b4, B:260:0x05b8, B:276:0x0649, B:277:0x0652, B:279:0x0656, B:280:0x065b, B:283:0x0663, B:294:0x0689, B:295:0x0692, B:297:0x0696, B:298:0x069b, B:300:0x069f, B:314:0x06c6, B:315:0x06ce, B:317:0x06d3, B:324:0x06f4, B:325:0x06fc, B:327:0x0700, B:21:0x0058, B:24:0x006b, B:25:0x007b, B:27:0x008e, B:28:0x009e, B:29:0x00ae, B:30:0x00be, B:31:0x00ce, B:44:0x00f8, B:45:0x0101, B:57:0x012c, B:58:0x0135, B:88:0x01c2, B:89:0x01ca, B:103:0x01fd, B:229:0x0523, B:233:0x0533, B:235:0x0538, B:237:0x0542, B:240:0x0551, B:242:0x055b, B:244:0x0563, B:246:0x0569, B:248:0x056f, B:249:0x0574, B:251:0x057e, B:253:0x0586, B:254:0x058c, B:255:0x059d, B:201:0x04aa, B:206:0x04bc, B:208:0x04c6, B:210:0x04ce, B:213:0x04d7, B:215:0x04df, B:216:0x04e6, B:218:0x04ee, B:219:0x04f5, B:221:0x04fd, B:222:0x0504, B:318:0x06d6, B:321:0x06e3, B:113:0x0223, B:114:0x022b, B:116:0x022f, B:119:0x0236, B:121:0x0240, B:123:0x0254, B:124:0x0258, B:125:0x0288, B:127:0x0292, B:128:0x029b, B:130:0x02a5, B:131:0x02b3, B:132:0x02c4, B:133:0x02ce, B:134:0x02d8, B:136:0x02df, B:137:0x02fd, B:143:0x031e, B:144:0x0326, B:145:0x0329, B:147:0x032e, B:150:0x0342, B:152:0x034c, B:153:0x0352, B:155:0x0358, B:156:0x0372, B:157:0x037b, B:158:0x0385, B:159:0x0396, B:162:0x03a2, B:165:0x03b8, B:166:0x03bd, B:167:0x03e2, B:169:0x03ec, B:170:0x03f5, B:172:0x03ff, B:173:0x040d, B:174:0x041e, B:175:0x0428, B:176:0x0432, B:178:0x043c, B:180:0x0444, B:181:0x0449, B:183:0x0451, B:184:0x0456, B:186:0x045e, B:187:0x0463, B:189:0x046b, B:190:0x0472, B:192:0x047c, B:194:0x0484, B:195:0x0495, B:90:0x01d2, B:92:0x01d8, B:99:0x01ef, B:101:0x01f5, B:95:0x01e0, B:97:0x01e8, B:46:0x0107, B:48:0x010d, B:50:0x0115, B:53:0x011d, B:55:0x0125, B:261:0x05bb, B:263:0x05c5, B:265:0x05ca, B:268:0x05ea, B:269:0x05fb, B:270:0x0609, B:271:0x0613, B:272:0x0631, B:274:0x063b, B:284:0x0666, B:287:0x0672, B:289:0x067c, B:292:0x0684), top: B:361:0x000c, inners: #1, #5, #7, #8, #9, #10, #12, #13, #16 }] */
    /* JADX WARN: Code duplicated, block: B:19:0x0052  */
    /* JADX WARN: Code duplicated, block: B:200:0x04a7 A[Catch: Exception -> 0x0068, TRY_LEAVE, TryCatch #14 {Exception -> 0x0068, blocks: (B:6:0x000c, B:8:0x0016, B:11:0x001e, B:13:0x0029, B:16:0x003d, B:105:0x0206, B:109:0x0211, B:112:0x0220, B:139:0x030e, B:140:0x0317, B:142:0x031b, B:197:0x049a, B:198:0x04a3, B:200:0x04a7, B:224:0x0511, B:225:0x051a, B:228:0x0520, B:257:0x05ab, B:258:0x05b4, B:260:0x05b8, B:276:0x0649, B:277:0x0652, B:279:0x0656, B:280:0x065b, B:283:0x0663, B:294:0x0689, B:295:0x0692, B:297:0x0696, B:298:0x069b, B:300:0x069f, B:314:0x06c6, B:315:0x06ce, B:317:0x06d3, B:324:0x06f4, B:325:0x06fc, B:327:0x0700, B:21:0x0058, B:24:0x006b, B:25:0x007b, B:27:0x008e, B:28:0x009e, B:29:0x00ae, B:30:0x00be, B:31:0x00ce, B:44:0x00f8, B:45:0x0101, B:57:0x012c, B:58:0x0135, B:88:0x01c2, B:89:0x01ca, B:103:0x01fd, B:229:0x0523, B:233:0x0533, B:235:0x0538, B:237:0x0542, B:240:0x0551, B:242:0x055b, B:244:0x0563, B:246:0x0569, B:248:0x056f, B:249:0x0574, B:251:0x057e, B:253:0x0586, B:254:0x058c, B:255:0x059d, B:201:0x04aa, B:206:0x04bc, B:208:0x04c6, B:210:0x04ce, B:213:0x04d7, B:215:0x04df, B:216:0x04e6, B:218:0x04ee, B:219:0x04f5, B:221:0x04fd, B:222:0x0504, B:318:0x06d6, B:321:0x06e3, B:113:0x0223, B:114:0x022b, B:116:0x022f, B:119:0x0236, B:121:0x0240, B:123:0x0254, B:124:0x0258, B:125:0x0288, B:127:0x0292, B:128:0x029b, B:130:0x02a5, B:131:0x02b3, B:132:0x02c4, B:133:0x02ce, B:134:0x02d8, B:136:0x02df, B:137:0x02fd, B:143:0x031e, B:144:0x0326, B:145:0x0329, B:147:0x032e, B:150:0x0342, B:152:0x034c, B:153:0x0352, B:155:0x0358, B:156:0x0372, B:157:0x037b, B:158:0x0385, B:159:0x0396, B:162:0x03a2, B:165:0x03b8, B:166:0x03bd, B:167:0x03e2, B:169:0x03ec, B:170:0x03f5, B:172:0x03ff, B:173:0x040d, B:174:0x041e, B:175:0x0428, B:176:0x0432, B:178:0x043c, B:180:0x0444, B:181:0x0449, B:183:0x0451, B:184:0x0456, B:186:0x045e, B:187:0x0463, B:189:0x046b, B:190:0x0472, B:192:0x047c, B:194:0x0484, B:195:0x0495, B:90:0x01d2, B:92:0x01d8, B:99:0x01ef, B:101:0x01f5, B:95:0x01e0, B:97:0x01e8, B:46:0x0107, B:48:0x010d, B:50:0x0115, B:53:0x011d, B:55:0x0125, B:261:0x05bb, B:263:0x05c5, B:265:0x05ca, B:268:0x05ea, B:269:0x05fb, B:270:0x0609, B:271:0x0613, B:272:0x0631, B:274:0x063b, B:284:0x0666, B:287:0x0672, B:289:0x067c, B:292:0x0684), top: B:361:0x000c, inners: #1, #5, #7, #8, #9, #10, #12, #13, #16 }] */
    /* JADX WARN: Code duplicated, block: B:203:0x04b6  */
    /* JADX WARN: Code duplicated, block: B:205:0x04ba  */
    /* JADX WARN: Code duplicated, block: B:206:0x04bc A[Catch: Exception -> 0x04d5, TryCatch #5 {Exception -> 0x04d5, blocks: (B:201:0x04aa, B:206:0x04bc, B:208:0x04c6, B:210:0x04ce, B:213:0x04d7, B:215:0x04df, B:216:0x04e6, B:218:0x04ee, B:219:0x04f5, B:221:0x04fd, B:222:0x0504), top: B:343:0x04aa, outer: #14 }] */
    /* JADX WARN: Code duplicated, block: B:208:0x04c6 A[Catch: Exception -> 0x04d5, TryCatch #5 {Exception -> 0x04d5, blocks: (B:201:0x04aa, B:206:0x04bc, B:208:0x04c6, B:210:0x04ce, B:213:0x04d7, B:215:0x04df, B:216:0x04e6, B:218:0x04ee, B:219:0x04f5, B:221:0x04fd, B:222:0x0504), top: B:343:0x04aa, outer: #14 }] */
    /* JADX WARN: Code duplicated, block: B:210:0x04ce A[Catch: Exception -> 0x04d5, TryCatch #5 {Exception -> 0x04d5, blocks: (B:201:0x04aa, B:206:0x04bc, B:208:0x04c6, B:210:0x04ce, B:213:0x04d7, B:215:0x04df, B:216:0x04e6, B:218:0x04ee, B:219:0x04f5, B:221:0x04fd, B:222:0x0504), top: B:343:0x04aa, outer: #14 }] */
    /* JADX WARN: Code duplicated, block: B:213:0x04d7 A[Catch: Exception -> 0x04d5, TryCatch #5 {Exception -> 0x04d5, blocks: (B:201:0x04aa, B:206:0x04bc, B:208:0x04c6, B:210:0x04ce, B:213:0x04d7, B:215:0x04df, B:216:0x04e6, B:218:0x04ee, B:219:0x04f5, B:221:0x04fd, B:222:0x0504), top: B:343:0x04aa, outer: #14 }] */
    /* JADX WARN: Code duplicated, block: B:215:0x04df A[Catch: Exception -> 0x04d5, TryCatch #5 {Exception -> 0x04d5, blocks: (B:201:0x04aa, B:206:0x04bc, B:208:0x04c6, B:210:0x04ce, B:213:0x04d7, B:215:0x04df, B:216:0x04e6, B:218:0x04ee, B:219:0x04f5, B:221:0x04fd, B:222:0x0504), top: B:343:0x04aa, outer: #14 }] */
    /* JADX WARN: Code duplicated, block: B:216:0x04e6 A[Catch: Exception -> 0x04d5, TryCatch #5 {Exception -> 0x04d5, blocks: (B:201:0x04aa, B:206:0x04bc, B:208:0x04c6, B:210:0x04ce, B:213:0x04d7, B:215:0x04df, B:216:0x04e6, B:218:0x04ee, B:219:0x04f5, B:221:0x04fd, B:222:0x0504), top: B:343:0x04aa, outer: #14 }] */
    /* JADX WARN: Code duplicated, block: B:218:0x04ee A[Catch: Exception -> 0x04d5, TryCatch #5 {Exception -> 0x04d5, blocks: (B:201:0x04aa, B:206:0x04bc, B:208:0x04c6, B:210:0x04ce, B:213:0x04d7, B:215:0x04df, B:216:0x04e6, B:218:0x04ee, B:219:0x04f5, B:221:0x04fd, B:222:0x0504), top: B:343:0x04aa, outer: #14 }] */
    /* JADX WARN: Code duplicated, block: B:219:0x04f5 A[Catch: Exception -> 0x04d5, TryCatch #5 {Exception -> 0x04d5, blocks: (B:201:0x04aa, B:206:0x04bc, B:208:0x04c6, B:210:0x04ce, B:213:0x04d7, B:215:0x04df, B:216:0x04e6, B:218:0x04ee, B:219:0x04f5, B:221:0x04fd, B:222:0x0504), top: B:343:0x04aa, outer: #14 }] */
    /* JADX WARN: Code duplicated, block: B:221:0x04fd A[Catch: Exception -> 0x04d5, TryCatch #5 {Exception -> 0x04d5, blocks: (B:201:0x04aa, B:206:0x04bc, B:208:0x04c6, B:210:0x04ce, B:213:0x04d7, B:215:0x04df, B:216:0x04e6, B:218:0x04ee, B:219:0x04f5, B:221:0x04fd, B:222:0x0504), top: B:343:0x04aa, outer: #14 }] */
    /* JADX WARN: Code duplicated, block: B:222:0x0504 A[Catch: Exception -> 0x04d5, TRY_LEAVE, TryCatch #5 {Exception -> 0x04d5, blocks: (B:201:0x04aa, B:206:0x04bc, B:208:0x04c6, B:210:0x04ce, B:213:0x04d7, B:215:0x04df, B:216:0x04e6, B:218:0x04ee, B:219:0x04f5, B:221:0x04fd, B:222:0x0504), top: B:343:0x04aa, outer: #14 }] */
    /* JADX WARN: Code duplicated, block: B:225:0x051a A[Catch: Exception -> 0x0068, TRY_LEAVE, TryCatch #14 {Exception -> 0x0068, blocks: (B:6:0x000c, B:8:0x0016, B:11:0x001e, B:13:0x0029, B:16:0x003d, B:105:0x0206, B:109:0x0211, B:112:0x0220, B:139:0x030e, B:140:0x0317, B:142:0x031b, B:197:0x049a, B:198:0x04a3, B:200:0x04a7, B:224:0x0511, B:225:0x051a, B:228:0x0520, B:257:0x05ab, B:258:0x05b4, B:260:0x05b8, B:276:0x0649, B:277:0x0652, B:279:0x0656, B:280:0x065b, B:283:0x0663, B:294:0x0689, B:295:0x0692, B:297:0x0696, B:298:0x069b, B:300:0x069f, B:314:0x06c6, B:315:0x06ce, B:317:0x06d3, B:324:0x06f4, B:325:0x06fc, B:327:0x0700, B:21:0x0058, B:24:0x006b, B:25:0x007b, B:27:0x008e, B:28:0x009e, B:29:0x00ae, B:30:0x00be, B:31:0x00ce, B:44:0x00f8, B:45:0x0101, B:57:0x012c, B:58:0x0135, B:88:0x01c2, B:89:0x01ca, B:103:0x01fd, B:229:0x0523, B:233:0x0533, B:235:0x0538, B:237:0x0542, B:240:0x0551, B:242:0x055b, B:244:0x0563, B:246:0x0569, B:248:0x056f, B:249:0x0574, B:251:0x057e, B:253:0x0586, B:254:0x058c, B:255:0x059d, B:201:0x04aa, B:206:0x04bc, B:208:0x04c6, B:210:0x04ce, B:213:0x04d7, B:215:0x04df, B:216:0x04e6, B:218:0x04ee, B:219:0x04f5, B:221:0x04fd, B:222:0x0504, B:318:0x06d6, B:321:0x06e3, B:113:0x0223, B:114:0x022b, B:116:0x022f, B:119:0x0236, B:121:0x0240, B:123:0x0254, B:124:0x0258, B:125:0x0288, B:127:0x0292, B:128:0x029b, B:130:0x02a5, B:131:0x02b3, B:132:0x02c4, B:133:0x02ce, B:134:0x02d8, B:136:0x02df, B:137:0x02fd, B:143:0x031e, B:144:0x0326, B:145:0x0329, B:147:0x032e, B:150:0x0342, B:152:0x034c, B:153:0x0352, B:155:0x0358, B:156:0x0372, B:157:0x037b, B:158:0x0385, B:159:0x0396, B:162:0x03a2, B:165:0x03b8, B:166:0x03bd, B:167:0x03e2, B:169:0x03ec, B:170:0x03f5, B:172:0x03ff, B:173:0x040d, B:174:0x041e, B:175:0x0428, B:176:0x0432, B:178:0x043c, B:180:0x0444, B:181:0x0449, B:183:0x0451, B:184:0x0456, B:186:0x045e, B:187:0x0463, B:189:0x046b, B:190:0x0472, B:192:0x047c, B:194:0x0484, B:195:0x0495, B:90:0x01d2, B:92:0x01d8, B:99:0x01ef, B:101:0x01f5, B:95:0x01e0, B:97:0x01e8, B:46:0x0107, B:48:0x010d, B:50:0x0115, B:53:0x011d, B:55:0x0125, B:261:0x05bb, B:263:0x05c5, B:265:0x05ca, B:268:0x05ea, B:269:0x05fb, B:270:0x0609, B:271:0x0613, B:272:0x0631, B:274:0x063b, B:284:0x0666, B:287:0x0672, B:289:0x067c, B:292:0x0684), top: B:361:0x000c, inners: #1, #5, #7, #8, #9, #10, #12, #13, #16 }] */
    /* JADX WARN: Code duplicated, block: B:228:0x0520 A[Catch: Exception -> 0x0068, TRY_ENTER, TRY_LEAVE, TryCatch #14 {Exception -> 0x0068, blocks: (B:6:0x000c, B:8:0x0016, B:11:0x001e, B:13:0x0029, B:16:0x003d, B:105:0x0206, B:109:0x0211, B:112:0x0220, B:139:0x030e, B:140:0x0317, B:142:0x031b, B:197:0x049a, B:198:0x04a3, B:200:0x04a7, B:224:0x0511, B:225:0x051a, B:228:0x0520, B:257:0x05ab, B:258:0x05b4, B:260:0x05b8, B:276:0x0649, B:277:0x0652, B:279:0x0656, B:280:0x065b, B:283:0x0663, B:294:0x0689, B:295:0x0692, B:297:0x0696, B:298:0x069b, B:300:0x069f, B:314:0x06c6, B:315:0x06ce, B:317:0x06d3, B:324:0x06f4, B:325:0x06fc, B:327:0x0700, B:21:0x0058, B:24:0x006b, B:25:0x007b, B:27:0x008e, B:28:0x009e, B:29:0x00ae, B:30:0x00be, B:31:0x00ce, B:44:0x00f8, B:45:0x0101, B:57:0x012c, B:58:0x0135, B:88:0x01c2, B:89:0x01ca, B:103:0x01fd, B:229:0x0523, B:233:0x0533, B:235:0x0538, B:237:0x0542, B:240:0x0551, B:242:0x055b, B:244:0x0563, B:246:0x0569, B:248:0x056f, B:249:0x0574, B:251:0x057e, B:253:0x0586, B:254:0x058c, B:255:0x059d, B:201:0x04aa, B:206:0x04bc, B:208:0x04c6, B:210:0x04ce, B:213:0x04d7, B:215:0x04df, B:216:0x04e6, B:218:0x04ee, B:219:0x04f5, B:221:0x04fd, B:222:0x0504, B:318:0x06d6, B:321:0x06e3, B:113:0x0223, B:114:0x022b, B:116:0x022f, B:119:0x0236, B:121:0x0240, B:123:0x0254, B:124:0x0258, B:125:0x0288, B:127:0x0292, B:128:0x029b, B:130:0x02a5, B:131:0x02b3, B:132:0x02c4, B:133:0x02ce, B:134:0x02d8, B:136:0x02df, B:137:0x02fd, B:143:0x031e, B:144:0x0326, B:145:0x0329, B:147:0x032e, B:150:0x0342, B:152:0x034c, B:153:0x0352, B:155:0x0358, B:156:0x0372, B:157:0x037b, B:158:0x0385, B:159:0x0396, B:162:0x03a2, B:165:0x03b8, B:166:0x03bd, B:167:0x03e2, B:169:0x03ec, B:170:0x03f5, B:172:0x03ff, B:173:0x040d, B:174:0x041e, B:175:0x0428, B:176:0x0432, B:178:0x043c, B:180:0x0444, B:181:0x0449, B:183:0x0451, B:184:0x0456, B:186:0x045e, B:187:0x0463, B:189:0x046b, B:190:0x0472, B:192:0x047c, B:194:0x0484, B:195:0x0495, B:90:0x01d2, B:92:0x01d8, B:99:0x01ef, B:101:0x01f5, B:95:0x01e0, B:97:0x01e8, B:46:0x0107, B:48:0x010d, B:50:0x0115, B:53:0x011d, B:55:0x0125, B:261:0x05bb, B:263:0x05c5, B:265:0x05ca, B:268:0x05ea, B:269:0x05fb, B:270:0x0609, B:271:0x0613, B:272:0x0631, B:274:0x063b, B:284:0x0666, B:287:0x0672, B:289:0x067c, B:292:0x0684), top: B:361:0x000c, inners: #1, #5, #7, #8, #9, #10, #12, #13, #16 }] */
    /* JADX WARN: Code duplicated, block: B:231:0x052f  */
    /* JADX WARN: Code duplicated, block: B:233:0x0533 A[Catch: Exception -> 0x054f, TryCatch #1 {Exception -> 0x054f, blocks: (B:229:0x0523, B:233:0x0533, B:235:0x0538, B:237:0x0542, B:240:0x0551, B:242:0x055b, B:244:0x0563, B:246:0x0569, B:248:0x056f, B:249:0x0574, B:251:0x057e, B:253:0x0586, B:254:0x058c, B:255:0x059d), top: B:335:0x0523, outer: #14 }] */
    /* JADX WARN: Code duplicated, block: B:234:0x0536 A[DONT_GENERATE] */
    /* JADX WARN: Code duplicated, block: B:235:0x0538 A[Catch: Exception -> 0x054f, TryCatch #1 {Exception -> 0x054f, blocks: (B:229:0x0523, B:233:0x0533, B:235:0x0538, B:237:0x0542, B:240:0x0551, B:242:0x055b, B:244:0x0563, B:246:0x0569, B:248:0x056f, B:249:0x0574, B:251:0x057e, B:253:0x0586, B:254:0x058c, B:255:0x059d), top: B:335:0x0523, outer: #14 }] */
    /* JADX WARN: Code duplicated, block: B:237:0x0542 A[Catch: Exception -> 0x054f, TryCatch #1 {Exception -> 0x054f, blocks: (B:229:0x0523, B:233:0x0533, B:235:0x0538, B:237:0x0542, B:240:0x0551, B:242:0x055b, B:244:0x0563, B:246:0x0569, B:248:0x056f, B:249:0x0574, B:251:0x057e, B:253:0x0586, B:254:0x058c, B:255:0x059d), top: B:335:0x0523, outer: #14 }] */
    /* JADX WARN: Code duplicated, block: B:240:0x0551 A[Catch: Exception -> 0x054f, TryCatch #1 {Exception -> 0x054f, blocks: (B:229:0x0523, B:233:0x0533, B:235:0x0538, B:237:0x0542, B:240:0x0551, B:242:0x055b, B:244:0x0563, B:246:0x0569, B:248:0x056f, B:249:0x0574, B:251:0x057e, B:253:0x0586, B:254:0x058c, B:255:0x059d), top: B:335:0x0523, outer: #14 }] */
    /* JADX WARN: Code duplicated, block: B:242:0x055b A[Catch: Exception -> 0x054f, TryCatch #1 {Exception -> 0x054f, blocks: (B:229:0x0523, B:233:0x0533, B:235:0x0538, B:237:0x0542, B:240:0x0551, B:242:0x055b, B:244:0x0563, B:246:0x0569, B:248:0x056f, B:249:0x0574, B:251:0x057e, B:253:0x0586, B:254:0x058c, B:255:0x059d), top: B:335:0x0523, outer: #14 }] */
    /* JADX WARN: Code duplicated, block: B:244:0x0563 A[Catch: Exception -> 0x054f, TryCatch #1 {Exception -> 0x054f, blocks: (B:229:0x0523, B:233:0x0533, B:235:0x0538, B:237:0x0542, B:240:0x0551, B:242:0x055b, B:244:0x0563, B:246:0x0569, B:248:0x056f, B:249:0x0574, B:251:0x057e, B:253:0x0586, B:254:0x058c, B:255:0x059d), top: B:335:0x0523, outer: #14 }] */
    /* JADX WARN: Code duplicated, block: B:245:0x0568  */
    /* JADX WARN: Code duplicated, block: B:248:0x056f A[Catch: Exception -> 0x054f, TryCatch #1 {Exception -> 0x054f, blocks: (B:229:0x0523, B:233:0x0533, B:235:0x0538, B:237:0x0542, B:240:0x0551, B:242:0x055b, B:244:0x0563, B:246:0x0569, B:248:0x056f, B:249:0x0574, B:251:0x057e, B:253:0x0586, B:254:0x058c, B:255:0x059d), top: B:335:0x0523, outer: #14 }] */
    /* JADX WARN: Code duplicated, block: B:249:0x0574 A[Catch: Exception -> 0x054f, TryCatch #1 {Exception -> 0x054f, blocks: (B:229:0x0523, B:233:0x0533, B:235:0x0538, B:237:0x0542, B:240:0x0551, B:242:0x055b, B:244:0x0563, B:246:0x0569, B:248:0x056f, B:249:0x0574, B:251:0x057e, B:253:0x0586, B:254:0x058c, B:255:0x059d), top: B:335:0x0523, outer: #14 }] */
    /* JADX WARN: Code duplicated, block: B:251:0x057e A[Catch: Exception -> 0x054f, TryCatch #1 {Exception -> 0x054f, blocks: (B:229:0x0523, B:233:0x0533, B:235:0x0538, B:237:0x0542, B:240:0x0551, B:242:0x055b, B:244:0x0563, B:246:0x0569, B:248:0x056f, B:249:0x0574, B:251:0x057e, B:253:0x0586, B:254:0x058c, B:255:0x059d), top: B:335:0x0523, outer: #14 }] */
    /* JADX WARN: Code duplicated, block: B:254:0x058c A[Catch: Exception -> 0x054f, TryCatch #1 {Exception -> 0x054f, blocks: (B:229:0x0523, B:233:0x0533, B:235:0x0538, B:237:0x0542, B:240:0x0551, B:242:0x055b, B:244:0x0563, B:246:0x0569, B:248:0x056f, B:249:0x0574, B:251:0x057e, B:253:0x0586, B:254:0x058c, B:255:0x059d), top: B:335:0x0523, outer: #14 }] */
    /* JADX WARN: Code duplicated, block: B:255:0x059d A[Catch: Exception -> 0x054f, TRY_LEAVE, TryCatch #1 {Exception -> 0x054f, blocks: (B:229:0x0523, B:233:0x0533, B:235:0x0538, B:237:0x0542, B:240:0x0551, B:242:0x055b, B:244:0x0563, B:246:0x0569, B:248:0x056f, B:249:0x0574, B:251:0x057e, B:253:0x0586, B:254:0x058c, B:255:0x059d), top: B:335:0x0523, outer: #14 }] */
    /* JADX WARN: Code duplicated, block: B:258:0x05b4 A[Catch: Exception -> 0x0068, TryCatch #14 {Exception -> 0x0068, blocks: (B:6:0x000c, B:8:0x0016, B:11:0x001e, B:13:0x0029, B:16:0x003d, B:105:0x0206, B:109:0x0211, B:112:0x0220, B:139:0x030e, B:140:0x0317, B:142:0x031b, B:197:0x049a, B:198:0x04a3, B:200:0x04a7, B:224:0x0511, B:225:0x051a, B:228:0x0520, B:257:0x05ab, B:258:0x05b4, B:260:0x05b8, B:276:0x0649, B:277:0x0652, B:279:0x0656, B:280:0x065b, B:283:0x0663, B:294:0x0689, B:295:0x0692, B:297:0x0696, B:298:0x069b, B:300:0x069f, B:314:0x06c6, B:315:0x06ce, B:317:0x06d3, B:324:0x06f4, B:325:0x06fc, B:327:0x0700, B:21:0x0058, B:24:0x006b, B:25:0x007b, B:27:0x008e, B:28:0x009e, B:29:0x00ae, B:30:0x00be, B:31:0x00ce, B:44:0x00f8, B:45:0x0101, B:57:0x012c, B:58:0x0135, B:88:0x01c2, B:89:0x01ca, B:103:0x01fd, B:229:0x0523, B:233:0x0533, B:235:0x0538, B:237:0x0542, B:240:0x0551, B:242:0x055b, B:244:0x0563, B:246:0x0569, B:248:0x056f, B:249:0x0574, B:251:0x057e, B:253:0x0586, B:254:0x058c, B:255:0x059d, B:201:0x04aa, B:206:0x04bc, B:208:0x04c6, B:210:0x04ce, B:213:0x04d7, B:215:0x04df, B:216:0x04e6, B:218:0x04ee, B:219:0x04f5, B:221:0x04fd, B:222:0x0504, B:318:0x06d6, B:321:0x06e3, B:113:0x0223, B:114:0x022b, B:116:0x022f, B:119:0x0236, B:121:0x0240, B:123:0x0254, B:124:0x0258, B:125:0x0288, B:127:0x0292, B:128:0x029b, B:130:0x02a5, B:131:0x02b3, B:132:0x02c4, B:133:0x02ce, B:134:0x02d8, B:136:0x02df, B:137:0x02fd, B:143:0x031e, B:144:0x0326, B:145:0x0329, B:147:0x032e, B:150:0x0342, B:152:0x034c, B:153:0x0352, B:155:0x0358, B:156:0x0372, B:157:0x037b, B:158:0x0385, B:159:0x0396, B:162:0x03a2, B:165:0x03b8, B:166:0x03bd, B:167:0x03e2, B:169:0x03ec, B:170:0x03f5, B:172:0x03ff, B:173:0x040d, B:174:0x041e, B:175:0x0428, B:176:0x0432, B:178:0x043c, B:180:0x0444, B:181:0x0449, B:183:0x0451, B:184:0x0456, B:186:0x045e, B:187:0x0463, B:189:0x046b, B:190:0x0472, B:192:0x047c, B:194:0x0484, B:195:0x0495, B:90:0x01d2, B:92:0x01d8, B:99:0x01ef, B:101:0x01f5, B:95:0x01e0, B:97:0x01e8, B:46:0x0107, B:48:0x010d, B:50:0x0115, B:53:0x011d, B:55:0x0125, B:261:0x05bb, B:263:0x05c5, B:265:0x05ca, B:268:0x05ea, B:269:0x05fb, B:270:0x0609, B:271:0x0613, B:272:0x0631, B:274:0x063b, B:284:0x0666, B:287:0x0672, B:289:0x067c, B:292:0x0684), top: B:361:0x000c, inners: #1, #5, #7, #8, #9, #10, #12, #13, #16 }] */
    /* JADX WARN: Code duplicated, block: B:260:0x05b8 A[Catch: Exception -> 0x0068, TRY_LEAVE, TryCatch #14 {Exception -> 0x0068, blocks: (B:6:0x000c, B:8:0x0016, B:11:0x001e, B:13:0x0029, B:16:0x003d, B:105:0x0206, B:109:0x0211, B:112:0x0220, B:139:0x030e, B:140:0x0317, B:142:0x031b, B:197:0x049a, B:198:0x04a3, B:200:0x04a7, B:224:0x0511, B:225:0x051a, B:228:0x0520, B:257:0x05ab, B:258:0x05b4, B:260:0x05b8, B:276:0x0649, B:277:0x0652, B:279:0x0656, B:280:0x065b, B:283:0x0663, B:294:0x0689, B:295:0x0692, B:297:0x0696, B:298:0x069b, B:300:0x069f, B:314:0x06c6, B:315:0x06ce, B:317:0x06d3, B:324:0x06f4, B:325:0x06fc, B:327:0x0700, B:21:0x0058, B:24:0x006b, B:25:0x007b, B:27:0x008e, B:28:0x009e, B:29:0x00ae, B:30:0x00be, B:31:0x00ce, B:44:0x00f8, B:45:0x0101, B:57:0x012c, B:58:0x0135, B:88:0x01c2, B:89:0x01ca, B:103:0x01fd, B:229:0x0523, B:233:0x0533, B:235:0x0538, B:237:0x0542, B:240:0x0551, B:242:0x055b, B:244:0x0563, B:246:0x0569, B:248:0x056f, B:249:0x0574, B:251:0x057e, B:253:0x0586, B:254:0x058c, B:255:0x059d, B:201:0x04aa, B:206:0x04bc, B:208:0x04c6, B:210:0x04ce, B:213:0x04d7, B:215:0x04df, B:216:0x04e6, B:218:0x04ee, B:219:0x04f5, B:221:0x04fd, B:222:0x0504, B:318:0x06d6, B:321:0x06e3, B:113:0x0223, B:114:0x022b, B:116:0x022f, B:119:0x0236, B:121:0x0240, B:123:0x0254, B:124:0x0258, B:125:0x0288, B:127:0x0292, B:128:0x029b, B:130:0x02a5, B:131:0x02b3, B:132:0x02c4, B:133:0x02ce, B:134:0x02d8, B:136:0x02df, B:137:0x02fd, B:143:0x031e, B:144:0x0326, B:145:0x0329, B:147:0x032e, B:150:0x0342, B:152:0x034c, B:153:0x0352, B:155:0x0358, B:156:0x0372, B:157:0x037b, B:158:0x0385, B:159:0x0396, B:162:0x03a2, B:165:0x03b8, B:166:0x03bd, B:167:0x03e2, B:169:0x03ec, B:170:0x03f5, B:172:0x03ff, B:173:0x040d, B:174:0x041e, B:175:0x0428, B:176:0x0432, B:178:0x043c, B:180:0x0444, B:181:0x0449, B:183:0x0451, B:184:0x0456, B:186:0x045e, B:187:0x0463, B:189:0x046b, B:190:0x0472, B:192:0x047c, B:194:0x0484, B:195:0x0495, B:90:0x01d2, B:92:0x01d8, B:99:0x01ef, B:101:0x01f5, B:95:0x01e0, B:97:0x01e8, B:46:0x0107, B:48:0x010d, B:50:0x0115, B:53:0x011d, B:55:0x0125, B:261:0x05bb, B:263:0x05c5, B:265:0x05ca, B:268:0x05ea, B:269:0x05fb, B:270:0x0609, B:271:0x0613, B:272:0x0631, B:274:0x063b, B:284:0x0666, B:287:0x0672, B:289:0x067c, B:292:0x0684), top: B:361:0x000c, inners: #1, #5, #7, #8, #9, #10, #12, #13, #16 }] */
    /* JADX WARN: Code duplicated, block: B:263:0x05c5 A[Catch: Exception -> 0x05e8, TryCatch #13 {Exception -> 0x05e8, blocks: (B:261:0x05bb, B:263:0x05c5, B:265:0x05ca, B:268:0x05ea, B:269:0x05fb, B:270:0x0609, B:271:0x0613, B:272:0x0631, B:274:0x063b), top: B:359:0x05bb, outer: #14 }] */
    /* JADX WARN: Code duplicated, block: B:264:0x05c8 A[DONT_GENERATE] */
    /* JADX WARN: Code duplicated, block: B:265:0x05ca A[Catch: Exception -> 0x05e8, TryCatch #13 {Exception -> 0x05e8, blocks: (B:261:0x05bb, B:263:0x05c5, B:265:0x05ca, B:268:0x05ea, B:269:0x05fb, B:270:0x0609, B:271:0x0613, B:272:0x0631, B:274:0x063b), top: B:359:0x05bb, outer: #14 }] */
    /* JADX WARN: Code duplicated, block: B:268:0x05ea A[Catch: Exception -> 0x05e8, TryCatch #13 {Exception -> 0x05e8, blocks: (B:261:0x05bb, B:263:0x05c5, B:265:0x05ca, B:268:0x05ea, B:269:0x05fb, B:270:0x0609, B:271:0x0613, B:272:0x0631, B:274:0x063b), top: B:359:0x05bb, outer: #14 }] */
    /* JADX WARN: Code duplicated, block: B:269:0x05fb A[Catch: Exception -> 0x05e8, TryCatch #13 {Exception -> 0x05e8, blocks: (B:261:0x05bb, B:263:0x05c5, B:265:0x05ca, B:268:0x05ea, B:269:0x05fb, B:270:0x0609, B:271:0x0613, B:272:0x0631, B:274:0x063b), top: B:359:0x05bb, outer: #14 }] */
    /* JADX WARN: Code duplicated, block: B:270:0x0609 A[Catch: Exception -> 0x05e8, TryCatch #13 {Exception -> 0x05e8, blocks: (B:261:0x05bb, B:263:0x05c5, B:265:0x05ca, B:268:0x05ea, B:269:0x05fb, B:270:0x0609, B:271:0x0613, B:272:0x0631, B:274:0x063b), top: B:359:0x05bb, outer: #14 }] */
    /* JADX WARN: Code duplicated, block: B:271:0x0613 A[Catch: Exception -> 0x05e8, TryCatch #13 {Exception -> 0x05e8, blocks: (B:261:0x05bb, B:263:0x05c5, B:265:0x05ca, B:268:0x05ea, B:269:0x05fb, B:270:0x0609, B:271:0x0613, B:272:0x0631, B:274:0x063b), top: B:359:0x05bb, outer: #14 }] */
    /* JADX WARN: Code duplicated, block: B:272:0x0631 A[Catch: Exception -> 0x05e8, TryCatch #13 {Exception -> 0x05e8, blocks: (B:261:0x05bb, B:263:0x05c5, B:265:0x05ca, B:268:0x05ea, B:269:0x05fb, B:270:0x0609, B:271:0x0613, B:272:0x0631, B:274:0x063b), top: B:359:0x05bb, outer: #14 }] */
    /* JADX WARN: Code duplicated, block: B:274:0x063b A[Catch: Exception -> 0x05e8, TRY_LEAVE, TryCatch #13 {Exception -> 0x05e8, blocks: (B:261:0x05bb, B:263:0x05c5, B:265:0x05ca, B:268:0x05ea, B:269:0x05fb, B:270:0x0609, B:271:0x0613, B:272:0x0631, B:274:0x063b), top: B:359:0x05bb, outer: #14 }] */
    /* JADX WARN: Code duplicated, block: B:277:0x0652 A[Catch: Exception -> 0x0068, TryCatch #14 {Exception -> 0x0068, blocks: (B:6:0x000c, B:8:0x0016, B:11:0x001e, B:13:0x0029, B:16:0x003d, B:105:0x0206, B:109:0x0211, B:112:0x0220, B:139:0x030e, B:140:0x0317, B:142:0x031b, B:197:0x049a, B:198:0x04a3, B:200:0x04a7, B:224:0x0511, B:225:0x051a, B:228:0x0520, B:257:0x05ab, B:258:0x05b4, B:260:0x05b8, B:276:0x0649, B:277:0x0652, B:279:0x0656, B:280:0x065b, B:283:0x0663, B:294:0x0689, B:295:0x0692, B:297:0x0696, B:298:0x069b, B:300:0x069f, B:314:0x06c6, B:315:0x06ce, B:317:0x06d3, B:324:0x06f4, B:325:0x06fc, B:327:0x0700, B:21:0x0058, B:24:0x006b, B:25:0x007b, B:27:0x008e, B:28:0x009e, B:29:0x00ae, B:30:0x00be, B:31:0x00ce, B:44:0x00f8, B:45:0x0101, B:57:0x012c, B:58:0x0135, B:88:0x01c2, B:89:0x01ca, B:103:0x01fd, B:229:0x0523, B:233:0x0533, B:235:0x0538, B:237:0x0542, B:240:0x0551, B:242:0x055b, B:244:0x0563, B:246:0x0569, B:248:0x056f, B:249:0x0574, B:251:0x057e, B:253:0x0586, B:254:0x058c, B:255:0x059d, B:201:0x04aa, B:206:0x04bc, B:208:0x04c6, B:210:0x04ce, B:213:0x04d7, B:215:0x04df, B:216:0x04e6, B:218:0x04ee, B:219:0x04f5, B:221:0x04fd, B:222:0x0504, B:318:0x06d6, B:321:0x06e3, B:113:0x0223, B:114:0x022b, B:116:0x022f, B:119:0x0236, B:121:0x0240, B:123:0x0254, B:124:0x0258, B:125:0x0288, B:127:0x0292, B:128:0x029b, B:130:0x02a5, B:131:0x02b3, B:132:0x02c4, B:133:0x02ce, B:134:0x02d8, B:136:0x02df, B:137:0x02fd, B:143:0x031e, B:144:0x0326, B:145:0x0329, B:147:0x032e, B:150:0x0342, B:152:0x034c, B:153:0x0352, B:155:0x0358, B:156:0x0372, B:157:0x037b, B:158:0x0385, B:159:0x0396, B:162:0x03a2, B:165:0x03b8, B:166:0x03bd, B:167:0x03e2, B:169:0x03ec, B:170:0x03f5, B:172:0x03ff, B:173:0x040d, B:174:0x041e, B:175:0x0428, B:176:0x0432, B:178:0x043c, B:180:0x0444, B:181:0x0449, B:183:0x0451, B:184:0x0456, B:186:0x045e, B:187:0x0463, B:189:0x046b, B:190:0x0472, B:192:0x047c, B:194:0x0484, B:195:0x0495, B:90:0x01d2, B:92:0x01d8, B:99:0x01ef, B:101:0x01f5, B:95:0x01e0, B:97:0x01e8, B:46:0x0107, B:48:0x010d, B:50:0x0115, B:53:0x011d, B:55:0x0125, B:261:0x05bb, B:263:0x05c5, B:265:0x05ca, B:268:0x05ea, B:269:0x05fb, B:270:0x0609, B:271:0x0613, B:272:0x0631, B:274:0x063b, B:284:0x0666, B:287:0x0672, B:289:0x067c, B:292:0x0684), top: B:361:0x000c, inners: #1, #5, #7, #8, #9, #10, #12, #13, #16 }] */
    /* JADX WARN: Code duplicated, block: B:279:0x0656 A[Catch: Exception -> 0x0068, TryCatch #14 {Exception -> 0x0068, blocks: (B:6:0x000c, B:8:0x0016, B:11:0x001e, B:13:0x0029, B:16:0x003d, B:105:0x0206, B:109:0x0211, B:112:0x0220, B:139:0x030e, B:140:0x0317, B:142:0x031b, B:197:0x049a, B:198:0x04a3, B:200:0x04a7, B:224:0x0511, B:225:0x051a, B:228:0x0520, B:257:0x05ab, B:258:0x05b4, B:260:0x05b8, B:276:0x0649, B:277:0x0652, B:279:0x0656, B:280:0x065b, B:283:0x0663, B:294:0x0689, B:295:0x0692, B:297:0x0696, B:298:0x069b, B:300:0x069f, B:314:0x06c6, B:315:0x06ce, B:317:0x06d3, B:324:0x06f4, B:325:0x06fc, B:327:0x0700, B:21:0x0058, B:24:0x006b, B:25:0x007b, B:27:0x008e, B:28:0x009e, B:29:0x00ae, B:30:0x00be, B:31:0x00ce, B:44:0x00f8, B:45:0x0101, B:57:0x012c, B:58:0x0135, B:88:0x01c2, B:89:0x01ca, B:103:0x01fd, B:229:0x0523, B:233:0x0533, B:235:0x0538, B:237:0x0542, B:240:0x0551, B:242:0x055b, B:244:0x0563, B:246:0x0569, B:248:0x056f, B:249:0x0574, B:251:0x057e, B:253:0x0586, B:254:0x058c, B:255:0x059d, B:201:0x04aa, B:206:0x04bc, B:208:0x04c6, B:210:0x04ce, B:213:0x04d7, B:215:0x04df, B:216:0x04e6, B:218:0x04ee, B:219:0x04f5, B:221:0x04fd, B:222:0x0504, B:318:0x06d6, B:321:0x06e3, B:113:0x0223, B:114:0x022b, B:116:0x022f, B:119:0x0236, B:121:0x0240, B:123:0x0254, B:124:0x0258, B:125:0x0288, B:127:0x0292, B:128:0x029b, B:130:0x02a5, B:131:0x02b3, B:132:0x02c4, B:133:0x02ce, B:134:0x02d8, B:136:0x02df, B:137:0x02fd, B:143:0x031e, B:144:0x0326, B:145:0x0329, B:147:0x032e, B:150:0x0342, B:152:0x034c, B:153:0x0352, B:155:0x0358, B:156:0x0372, B:157:0x037b, B:158:0x0385, B:159:0x0396, B:162:0x03a2, B:165:0x03b8, B:166:0x03bd, B:167:0x03e2, B:169:0x03ec, B:170:0x03f5, B:172:0x03ff, B:173:0x040d, B:174:0x041e, B:175:0x0428, B:176:0x0432, B:178:0x043c, B:180:0x0444, B:181:0x0449, B:183:0x0451, B:184:0x0456, B:186:0x045e, B:187:0x0463, B:189:0x046b, B:190:0x0472, B:192:0x047c, B:194:0x0484, B:195:0x0495, B:90:0x01d2, B:92:0x01d8, B:99:0x01ef, B:101:0x01f5, B:95:0x01e0, B:97:0x01e8, B:46:0x0107, B:48:0x010d, B:50:0x0115, B:53:0x011d, B:55:0x0125, B:261:0x05bb, B:263:0x05c5, B:265:0x05ca, B:268:0x05ea, B:269:0x05fb, B:270:0x0609, B:271:0x0613, B:272:0x0631, B:274:0x063b, B:284:0x0666, B:287:0x0672, B:289:0x067c, B:292:0x0684), top: B:361:0x000c, inners: #1, #5, #7, #8, #9, #10, #12, #13, #16 }] */
    /* JADX WARN: Code duplicated, block: B:280:0x065b A[Catch: Exception -> 0x0068, TRY_LEAVE, TryCatch #14 {Exception -> 0x0068, blocks: (B:6:0x000c, B:8:0x0016, B:11:0x001e, B:13:0x0029, B:16:0x003d, B:105:0x0206, B:109:0x0211, B:112:0x0220, B:139:0x030e, B:140:0x0317, B:142:0x031b, B:197:0x049a, B:198:0x04a3, B:200:0x04a7, B:224:0x0511, B:225:0x051a, B:228:0x0520, B:257:0x05ab, B:258:0x05b4, B:260:0x05b8, B:276:0x0649, B:277:0x0652, B:279:0x0656, B:280:0x065b, B:283:0x0663, B:294:0x0689, B:295:0x0692, B:297:0x0696, B:298:0x069b, B:300:0x069f, B:314:0x06c6, B:315:0x06ce, B:317:0x06d3, B:324:0x06f4, B:325:0x06fc, B:327:0x0700, B:21:0x0058, B:24:0x006b, B:25:0x007b, B:27:0x008e, B:28:0x009e, B:29:0x00ae, B:30:0x00be, B:31:0x00ce, B:44:0x00f8, B:45:0x0101, B:57:0x012c, B:58:0x0135, B:88:0x01c2, B:89:0x01ca, B:103:0x01fd, B:229:0x0523, B:233:0x0533, B:235:0x0538, B:237:0x0542, B:240:0x0551, B:242:0x055b, B:244:0x0563, B:246:0x0569, B:248:0x056f, B:249:0x0574, B:251:0x057e, B:253:0x0586, B:254:0x058c, B:255:0x059d, B:201:0x04aa, B:206:0x04bc, B:208:0x04c6, B:210:0x04ce, B:213:0x04d7, B:215:0x04df, B:216:0x04e6, B:218:0x04ee, B:219:0x04f5, B:221:0x04fd, B:222:0x0504, B:318:0x06d6, B:321:0x06e3, B:113:0x0223, B:114:0x022b, B:116:0x022f, B:119:0x0236, B:121:0x0240, B:123:0x0254, B:124:0x0258, B:125:0x0288, B:127:0x0292, B:128:0x029b, B:130:0x02a5, B:131:0x02b3, B:132:0x02c4, B:133:0x02ce, B:134:0x02d8, B:136:0x02df, B:137:0x02fd, B:143:0x031e, B:144:0x0326, B:145:0x0329, B:147:0x032e, B:150:0x0342, B:152:0x034c, B:153:0x0352, B:155:0x0358, B:156:0x0372, B:157:0x037b, B:158:0x0385, B:159:0x0396, B:162:0x03a2, B:165:0x03b8, B:166:0x03bd, B:167:0x03e2, B:169:0x03ec, B:170:0x03f5, B:172:0x03ff, B:173:0x040d, B:174:0x041e, B:175:0x0428, B:176:0x0432, B:178:0x043c, B:180:0x0444, B:181:0x0449, B:183:0x0451, B:184:0x0456, B:186:0x045e, B:187:0x0463, B:189:0x046b, B:190:0x0472, B:192:0x047c, B:194:0x0484, B:195:0x0495, B:90:0x01d2, B:92:0x01d8, B:99:0x01ef, B:101:0x01f5, B:95:0x01e0, B:97:0x01e8, B:46:0x0107, B:48:0x010d, B:50:0x0115, B:53:0x011d, B:55:0x0125, B:261:0x05bb, B:263:0x05c5, B:265:0x05ca, B:268:0x05ea, B:269:0x05fb, B:270:0x0609, B:271:0x0613, B:272:0x0631, B:274:0x063b, B:284:0x0666, B:287:0x0672, B:289:0x067c, B:292:0x0684), top: B:361:0x000c, inners: #1, #5, #7, #8, #9, #10, #12, #13, #16 }] */
    /* JADX WARN: Code duplicated, block: B:283:0x0663 A[Catch: Exception -> 0x0068, TRY_ENTER, TRY_LEAVE, TryCatch #14 {Exception -> 0x0068, blocks: (B:6:0x000c, B:8:0x0016, B:11:0x001e, B:13:0x0029, B:16:0x003d, B:105:0x0206, B:109:0x0211, B:112:0x0220, B:139:0x030e, B:140:0x0317, B:142:0x031b, B:197:0x049a, B:198:0x04a3, B:200:0x04a7, B:224:0x0511, B:225:0x051a, B:228:0x0520, B:257:0x05ab, B:258:0x05b4, B:260:0x05b8, B:276:0x0649, B:277:0x0652, B:279:0x0656, B:280:0x065b, B:283:0x0663, B:294:0x0689, B:295:0x0692, B:297:0x0696, B:298:0x069b, B:300:0x069f, B:314:0x06c6, B:315:0x06ce, B:317:0x06d3, B:324:0x06f4, B:325:0x06fc, B:327:0x0700, B:21:0x0058, B:24:0x006b, B:25:0x007b, B:27:0x008e, B:28:0x009e, B:29:0x00ae, B:30:0x00be, B:31:0x00ce, B:44:0x00f8, B:45:0x0101, B:57:0x012c, B:58:0x0135, B:88:0x01c2, B:89:0x01ca, B:103:0x01fd, B:229:0x0523, B:233:0x0533, B:235:0x0538, B:237:0x0542, B:240:0x0551, B:242:0x055b, B:244:0x0563, B:246:0x0569, B:248:0x056f, B:249:0x0574, B:251:0x057e, B:253:0x0586, B:254:0x058c, B:255:0x059d, B:201:0x04aa, B:206:0x04bc, B:208:0x04c6, B:210:0x04ce, B:213:0x04d7, B:215:0x04df, B:216:0x04e6, B:218:0x04ee, B:219:0x04f5, B:221:0x04fd, B:222:0x0504, B:318:0x06d6, B:321:0x06e3, B:113:0x0223, B:114:0x022b, B:116:0x022f, B:119:0x0236, B:121:0x0240, B:123:0x0254, B:124:0x0258, B:125:0x0288, B:127:0x0292, B:128:0x029b, B:130:0x02a5, B:131:0x02b3, B:132:0x02c4, B:133:0x02ce, B:134:0x02d8, B:136:0x02df, B:137:0x02fd, B:143:0x031e, B:144:0x0326, B:145:0x0329, B:147:0x032e, B:150:0x0342, B:152:0x034c, B:153:0x0352, B:155:0x0358, B:156:0x0372, B:157:0x037b, B:158:0x0385, B:159:0x0396, B:162:0x03a2, B:165:0x03b8, B:166:0x03bd, B:167:0x03e2, B:169:0x03ec, B:170:0x03f5, B:172:0x03ff, B:173:0x040d, B:174:0x041e, B:175:0x0428, B:176:0x0432, B:178:0x043c, B:180:0x0444, B:181:0x0449, B:183:0x0451, B:184:0x0456, B:186:0x045e, B:187:0x0463, B:189:0x046b, B:190:0x0472, B:192:0x047c, B:194:0x0484, B:195:0x0495, B:90:0x01d2, B:92:0x01d8, B:99:0x01ef, B:101:0x01f5, B:95:0x01e0, B:97:0x01e8, B:46:0x0107, B:48:0x010d, B:50:0x0115, B:53:0x011d, B:55:0x0125, B:261:0x05bb, B:263:0x05c5, B:265:0x05ca, B:268:0x05ea, B:269:0x05fb, B:270:0x0609, B:271:0x0613, B:272:0x0631, B:274:0x063b, B:284:0x0666, B:287:0x0672, B:289:0x067c, B:292:0x0684), top: B:361:0x000c, inners: #1, #5, #7, #8, #9, #10, #12, #13, #16 }] */
    /* JADX WARN: Code duplicated, block: B:286:0x0670  */
    /* JADX WARN: Code duplicated, block: B:287:0x0672 A[Catch: Exception -> 0x0682, TryCatch #16 {Exception -> 0x0682, blocks: (B:284:0x0666, B:287:0x0672, B:289:0x067c, B:292:0x0684), top: B:365:0x0666, outer: #14 }] */
    /* JADX WARN: Code duplicated, block: B:289:0x067c A[Catch: Exception -> 0x0682, TryCatch #16 {Exception -> 0x0682, blocks: (B:284:0x0666, B:287:0x0672, B:289:0x067c, B:292:0x0684), top: B:365:0x0666, outer: #14 }] */
    /* JADX WARN: Code duplicated, block: B:292:0x0684 A[Catch: Exception -> 0x0682, TRY_LEAVE, TryCatch #16 {Exception -> 0x0682, blocks: (B:284:0x0666, B:287:0x0672, B:289:0x067c, B:292:0x0684), top: B:365:0x0666, outer: #14 }] */
    /* JADX WARN: Code duplicated, block: B:295:0x0692 A[Catch: Exception -> 0x0068, TryCatch #14 {Exception -> 0x0068, blocks: (B:6:0x000c, B:8:0x0016, B:11:0x001e, B:13:0x0029, B:16:0x003d, B:105:0x0206, B:109:0x0211, B:112:0x0220, B:139:0x030e, B:140:0x0317, B:142:0x031b, B:197:0x049a, B:198:0x04a3, B:200:0x04a7, B:224:0x0511, B:225:0x051a, B:228:0x0520, B:257:0x05ab, B:258:0x05b4, B:260:0x05b8, B:276:0x0649, B:277:0x0652, B:279:0x0656, B:280:0x065b, B:283:0x0663, B:294:0x0689, B:295:0x0692, B:297:0x0696, B:298:0x069b, B:300:0x069f, B:314:0x06c6, B:315:0x06ce, B:317:0x06d3, B:324:0x06f4, B:325:0x06fc, B:327:0x0700, B:21:0x0058, B:24:0x006b, B:25:0x007b, B:27:0x008e, B:28:0x009e, B:29:0x00ae, B:30:0x00be, B:31:0x00ce, B:44:0x00f8, B:45:0x0101, B:57:0x012c, B:58:0x0135, B:88:0x01c2, B:89:0x01ca, B:103:0x01fd, B:229:0x0523, B:233:0x0533, B:235:0x0538, B:237:0x0542, B:240:0x0551, B:242:0x055b, B:244:0x0563, B:246:0x0569, B:248:0x056f, B:249:0x0574, B:251:0x057e, B:253:0x0586, B:254:0x058c, B:255:0x059d, B:201:0x04aa, B:206:0x04bc, B:208:0x04c6, B:210:0x04ce, B:213:0x04d7, B:215:0x04df, B:216:0x04e6, B:218:0x04ee, B:219:0x04f5, B:221:0x04fd, B:222:0x0504, B:318:0x06d6, B:321:0x06e3, B:113:0x0223, B:114:0x022b, B:116:0x022f, B:119:0x0236, B:121:0x0240, B:123:0x0254, B:124:0x0258, B:125:0x0288, B:127:0x0292, B:128:0x029b, B:130:0x02a5, B:131:0x02b3, B:132:0x02c4, B:133:0x02ce, B:134:0x02d8, B:136:0x02df, B:137:0x02fd, B:143:0x031e, B:144:0x0326, B:145:0x0329, B:147:0x032e, B:150:0x0342, B:152:0x034c, B:153:0x0352, B:155:0x0358, B:156:0x0372, B:157:0x037b, B:158:0x0385, B:159:0x0396, B:162:0x03a2, B:165:0x03b8, B:166:0x03bd, B:167:0x03e2, B:169:0x03ec, B:170:0x03f5, B:172:0x03ff, B:173:0x040d, B:174:0x041e, B:175:0x0428, B:176:0x0432, B:178:0x043c, B:180:0x0444, B:181:0x0449, B:183:0x0451, B:184:0x0456, B:186:0x045e, B:187:0x0463, B:189:0x046b, B:190:0x0472, B:192:0x047c, B:194:0x0484, B:195:0x0495, B:90:0x01d2, B:92:0x01d8, B:99:0x01ef, B:101:0x01f5, B:95:0x01e0, B:97:0x01e8, B:46:0x0107, B:48:0x010d, B:50:0x0115, B:53:0x011d, B:55:0x0125, B:261:0x05bb, B:263:0x05c5, B:265:0x05ca, B:268:0x05ea, B:269:0x05fb, B:270:0x0609, B:271:0x0613, B:272:0x0631, B:274:0x063b, B:284:0x0666, B:287:0x0672, B:289:0x067c, B:292:0x0684), top: B:361:0x000c, inners: #1, #5, #7, #8, #9, #10, #12, #13, #16 }] */
    /* JADX WARN: Code duplicated, block: B:297:0x0696 A[Catch: Exception -> 0x0068, TryCatch #14 {Exception -> 0x0068, blocks: (B:6:0x000c, B:8:0x0016, B:11:0x001e, B:13:0x0029, B:16:0x003d, B:105:0x0206, B:109:0x0211, B:112:0x0220, B:139:0x030e, B:140:0x0317, B:142:0x031b, B:197:0x049a, B:198:0x04a3, B:200:0x04a7, B:224:0x0511, B:225:0x051a, B:228:0x0520, B:257:0x05ab, B:258:0x05b4, B:260:0x05b8, B:276:0x0649, B:277:0x0652, B:279:0x0656, B:280:0x065b, B:283:0x0663, B:294:0x0689, B:295:0x0692, B:297:0x0696, B:298:0x069b, B:300:0x069f, B:314:0x06c6, B:315:0x06ce, B:317:0x06d3, B:324:0x06f4, B:325:0x06fc, B:327:0x0700, B:21:0x0058, B:24:0x006b, B:25:0x007b, B:27:0x008e, B:28:0x009e, B:29:0x00ae, B:30:0x00be, B:31:0x00ce, B:44:0x00f8, B:45:0x0101, B:57:0x012c, B:58:0x0135, B:88:0x01c2, B:89:0x01ca, B:103:0x01fd, B:229:0x0523, B:233:0x0533, B:235:0x0538, B:237:0x0542, B:240:0x0551, B:242:0x055b, B:244:0x0563, B:246:0x0569, B:248:0x056f, B:249:0x0574, B:251:0x057e, B:253:0x0586, B:254:0x058c, B:255:0x059d, B:201:0x04aa, B:206:0x04bc, B:208:0x04c6, B:210:0x04ce, B:213:0x04d7, B:215:0x04df, B:216:0x04e6, B:218:0x04ee, B:219:0x04f5, B:221:0x04fd, B:222:0x0504, B:318:0x06d6, B:321:0x06e3, B:113:0x0223, B:114:0x022b, B:116:0x022f, B:119:0x0236, B:121:0x0240, B:123:0x0254, B:124:0x0258, B:125:0x0288, B:127:0x0292, B:128:0x029b, B:130:0x02a5, B:131:0x02b3, B:132:0x02c4, B:133:0x02ce, B:134:0x02d8, B:136:0x02df, B:137:0x02fd, B:143:0x031e, B:144:0x0326, B:145:0x0329, B:147:0x032e, B:150:0x0342, B:152:0x034c, B:153:0x0352, B:155:0x0358, B:156:0x0372, B:157:0x037b, B:158:0x0385, B:159:0x0396, B:162:0x03a2, B:165:0x03b8, B:166:0x03bd, B:167:0x03e2, B:169:0x03ec, B:170:0x03f5, B:172:0x03ff, B:173:0x040d, B:174:0x041e, B:175:0x0428, B:176:0x0432, B:178:0x043c, B:180:0x0444, B:181:0x0449, B:183:0x0451, B:184:0x0456, B:186:0x045e, B:187:0x0463, B:189:0x046b, B:190:0x0472, B:192:0x047c, B:194:0x0484, B:195:0x0495, B:90:0x01d2, B:92:0x01d8, B:99:0x01ef, B:101:0x01f5, B:95:0x01e0, B:97:0x01e8, B:46:0x0107, B:48:0x010d, B:50:0x0115, B:53:0x011d, B:55:0x0125, B:261:0x05bb, B:263:0x05c5, B:265:0x05ca, B:268:0x05ea, B:269:0x05fb, B:270:0x0609, B:271:0x0613, B:272:0x0631, B:274:0x063b, B:284:0x0666, B:287:0x0672, B:289:0x067c, B:292:0x0684), top: B:361:0x000c, inners: #1, #5, #7, #8, #9, #10, #12, #13, #16 }] */
    /* JADX WARN: Code duplicated, block: B:298:0x069b A[Catch: Exception -> 0x0068, TryCatch #14 {Exception -> 0x0068, blocks: (B:6:0x000c, B:8:0x0016, B:11:0x001e, B:13:0x0029, B:16:0x003d, B:105:0x0206, B:109:0x0211, B:112:0x0220, B:139:0x030e, B:140:0x0317, B:142:0x031b, B:197:0x049a, B:198:0x04a3, B:200:0x04a7, B:224:0x0511, B:225:0x051a, B:228:0x0520, B:257:0x05ab, B:258:0x05b4, B:260:0x05b8, B:276:0x0649, B:277:0x0652, B:279:0x0656, B:280:0x065b, B:283:0x0663, B:294:0x0689, B:295:0x0692, B:297:0x0696, B:298:0x069b, B:300:0x069f, B:314:0x06c6, B:315:0x06ce, B:317:0x06d3, B:324:0x06f4, B:325:0x06fc, B:327:0x0700, B:21:0x0058, B:24:0x006b, B:25:0x007b, B:27:0x008e, B:28:0x009e, B:29:0x00ae, B:30:0x00be, B:31:0x00ce, B:44:0x00f8, B:45:0x0101, B:57:0x012c, B:58:0x0135, B:88:0x01c2, B:89:0x01ca, B:103:0x01fd, B:229:0x0523, B:233:0x0533, B:235:0x0538, B:237:0x0542, B:240:0x0551, B:242:0x055b, B:244:0x0563, B:246:0x0569, B:248:0x056f, B:249:0x0574, B:251:0x057e, B:253:0x0586, B:254:0x058c, B:255:0x059d, B:201:0x04aa, B:206:0x04bc, B:208:0x04c6, B:210:0x04ce, B:213:0x04d7, B:215:0x04df, B:216:0x04e6, B:218:0x04ee, B:219:0x04f5, B:221:0x04fd, B:222:0x0504, B:318:0x06d6, B:321:0x06e3, B:113:0x0223, B:114:0x022b, B:116:0x022f, B:119:0x0236, B:121:0x0240, B:123:0x0254, B:124:0x0258, B:125:0x0288, B:127:0x0292, B:128:0x029b, B:130:0x02a5, B:131:0x02b3, B:132:0x02c4, B:133:0x02ce, B:134:0x02d8, B:136:0x02df, B:137:0x02fd, B:143:0x031e, B:144:0x0326, B:145:0x0329, B:147:0x032e, B:150:0x0342, B:152:0x034c, B:153:0x0352, B:155:0x0358, B:156:0x0372, B:157:0x037b, B:158:0x0385, B:159:0x0396, B:162:0x03a2, B:165:0x03b8, B:166:0x03bd, B:167:0x03e2, B:169:0x03ec, B:170:0x03f5, B:172:0x03ff, B:173:0x040d, B:174:0x041e, B:175:0x0428, B:176:0x0432, B:178:0x043c, B:180:0x0444, B:181:0x0449, B:183:0x0451, B:184:0x0456, B:186:0x045e, B:187:0x0463, B:189:0x046b, B:190:0x0472, B:192:0x047c, B:194:0x0484, B:195:0x0495, B:90:0x01d2, B:92:0x01d8, B:99:0x01ef, B:101:0x01f5, B:95:0x01e0, B:97:0x01e8, B:46:0x0107, B:48:0x010d, B:50:0x0115, B:53:0x011d, B:55:0x0125, B:261:0x05bb, B:263:0x05c5, B:265:0x05ca, B:268:0x05ea, B:269:0x05fb, B:270:0x0609, B:271:0x0613, B:272:0x0631, B:274:0x063b, B:284:0x0666, B:287:0x0672, B:289:0x067c, B:292:0x0684), top: B:361:0x000c, inners: #1, #5, #7, #8, #9, #10, #12, #13, #16 }] */
    /* JADX WARN: Code duplicated, block: B:300:0x069f A[Catch: Exception -> 0x0068, TRY_LEAVE, TryCatch #14 {Exception -> 0x0068, blocks: (B:6:0x000c, B:8:0x0016, B:11:0x001e, B:13:0x0029, B:16:0x003d, B:105:0x0206, B:109:0x0211, B:112:0x0220, B:139:0x030e, B:140:0x0317, B:142:0x031b, B:197:0x049a, B:198:0x04a3, B:200:0x04a7, B:224:0x0511, B:225:0x051a, B:228:0x0520, B:257:0x05ab, B:258:0x05b4, B:260:0x05b8, B:276:0x0649, B:277:0x0652, B:279:0x0656, B:280:0x065b, B:283:0x0663, B:294:0x0689, B:295:0x0692, B:297:0x0696, B:298:0x069b, B:300:0x069f, B:314:0x06c6, B:315:0x06ce, B:317:0x06d3, B:324:0x06f4, B:325:0x06fc, B:327:0x0700, B:21:0x0058, B:24:0x006b, B:25:0x007b, B:27:0x008e, B:28:0x009e, B:29:0x00ae, B:30:0x00be, B:31:0x00ce, B:44:0x00f8, B:45:0x0101, B:57:0x012c, B:58:0x0135, B:88:0x01c2, B:89:0x01ca, B:103:0x01fd, B:229:0x0523, B:233:0x0533, B:235:0x0538, B:237:0x0542, B:240:0x0551, B:242:0x055b, B:244:0x0563, B:246:0x0569, B:248:0x056f, B:249:0x0574, B:251:0x057e, B:253:0x0586, B:254:0x058c, B:255:0x059d, B:201:0x04aa, B:206:0x04bc, B:208:0x04c6, B:210:0x04ce, B:213:0x04d7, B:215:0x04df, B:216:0x04e6, B:218:0x04ee, B:219:0x04f5, B:221:0x04fd, B:222:0x0504, B:318:0x06d6, B:321:0x06e3, B:113:0x0223, B:114:0x022b, B:116:0x022f, B:119:0x0236, B:121:0x0240, B:123:0x0254, B:124:0x0258, B:125:0x0288, B:127:0x0292, B:128:0x029b, B:130:0x02a5, B:131:0x02b3, B:132:0x02c4, B:133:0x02ce, B:134:0x02d8, B:136:0x02df, B:137:0x02fd, B:143:0x031e, B:144:0x0326, B:145:0x0329, B:147:0x032e, B:150:0x0342, B:152:0x034c, B:153:0x0352, B:155:0x0358, B:156:0x0372, B:157:0x037b, B:158:0x0385, B:159:0x0396, B:162:0x03a2, B:165:0x03b8, B:166:0x03bd, B:167:0x03e2, B:169:0x03ec, B:170:0x03f5, B:172:0x03ff, B:173:0x040d, B:174:0x041e, B:175:0x0428, B:176:0x0432, B:178:0x043c, B:180:0x0444, B:181:0x0449, B:183:0x0451, B:184:0x0456, B:186:0x045e, B:187:0x0463, B:189:0x046b, B:190:0x0472, B:192:0x047c, B:194:0x0484, B:195:0x0495, B:90:0x01d2, B:92:0x01d8, B:99:0x01ef, B:101:0x01f5, B:95:0x01e0, B:97:0x01e8, B:46:0x0107, B:48:0x010d, B:50:0x0115, B:53:0x011d, B:55:0x0125, B:261:0x05bb, B:263:0x05c5, B:265:0x05ca, B:268:0x05ea, B:269:0x05fb, B:270:0x0609, B:271:0x0613, B:272:0x0631, B:274:0x063b, B:284:0x0666, B:287:0x0672, B:289:0x067c, B:292:0x0684), top: B:361:0x000c, inners: #1, #5, #7, #8, #9, #10, #12, #13, #16 }] */
    /* JADX WARN: Code duplicated, block: B:303:0x06ac  */
    /* JADX WARN: Code duplicated, block: B:304:0x06ae A[Catch: Exception -> 0x06c4, TRY_LEAVE, TryCatch #15 {Exception -> 0x06c4, blocks: (B:301:0x06a2, B:304:0x06ae), top: B:363:0x06a2 }] */
    /* JADX WARN: Code duplicated, block: B:306:0x06b8  */
    /* JADX WARN: Code duplicated, block: B:310:0x06bf A[Catch: Exception -> 0x06bd, TRY_LEAVE, TryCatch #11 {Exception -> 0x06bd, blocks: (B:307:0x06b9, B:310:0x06bf), top: B:355:0x06b9 }] */
    /* JADX WARN: Code duplicated, block: B:315:0x06ce A[Catch: Exception -> 0x0068, TryCatch #14 {Exception -> 0x0068, blocks: (B:6:0x000c, B:8:0x0016, B:11:0x001e, B:13:0x0029, B:16:0x003d, B:105:0x0206, B:109:0x0211, B:112:0x0220, B:139:0x030e, B:140:0x0317, B:142:0x031b, B:197:0x049a, B:198:0x04a3, B:200:0x04a7, B:224:0x0511, B:225:0x051a, B:228:0x0520, B:257:0x05ab, B:258:0x05b4, B:260:0x05b8, B:276:0x0649, B:277:0x0652, B:279:0x0656, B:280:0x065b, B:283:0x0663, B:294:0x0689, B:295:0x0692, B:297:0x0696, B:298:0x069b, B:300:0x069f, B:314:0x06c6, B:315:0x06ce, B:317:0x06d3, B:324:0x06f4, B:325:0x06fc, B:327:0x0700, B:21:0x0058, B:24:0x006b, B:25:0x007b, B:27:0x008e, B:28:0x009e, B:29:0x00ae, B:30:0x00be, B:31:0x00ce, B:44:0x00f8, B:45:0x0101, B:57:0x012c, B:58:0x0135, B:88:0x01c2, B:89:0x01ca, B:103:0x01fd, B:229:0x0523, B:233:0x0533, B:235:0x0538, B:237:0x0542, B:240:0x0551, B:242:0x055b, B:244:0x0563, B:246:0x0569, B:248:0x056f, B:249:0x0574, B:251:0x057e, B:253:0x0586, B:254:0x058c, B:255:0x059d, B:201:0x04aa, B:206:0x04bc, B:208:0x04c6, B:210:0x04ce, B:213:0x04d7, B:215:0x04df, B:216:0x04e6, B:218:0x04ee, B:219:0x04f5, B:221:0x04fd, B:222:0x0504, B:318:0x06d6, B:321:0x06e3, B:113:0x0223, B:114:0x022b, B:116:0x022f, B:119:0x0236, B:121:0x0240, B:123:0x0254, B:124:0x0258, B:125:0x0288, B:127:0x0292, B:128:0x029b, B:130:0x02a5, B:131:0x02b3, B:132:0x02c4, B:133:0x02ce, B:134:0x02d8, B:136:0x02df, B:137:0x02fd, B:143:0x031e, B:144:0x0326, B:145:0x0329, B:147:0x032e, B:150:0x0342, B:152:0x034c, B:153:0x0352, B:155:0x0358, B:156:0x0372, B:157:0x037b, B:158:0x0385, B:159:0x0396, B:162:0x03a2, B:165:0x03b8, B:166:0x03bd, B:167:0x03e2, B:169:0x03ec, B:170:0x03f5, B:172:0x03ff, B:173:0x040d, B:174:0x041e, B:175:0x0428, B:176:0x0432, B:178:0x043c, B:180:0x0444, B:181:0x0449, B:183:0x0451, B:184:0x0456, B:186:0x045e, B:187:0x0463, B:189:0x046b, B:190:0x0472, B:192:0x047c, B:194:0x0484, B:195:0x0495, B:90:0x01d2, B:92:0x01d8, B:99:0x01ef, B:101:0x01f5, B:95:0x01e0, B:97:0x01e8, B:46:0x0107, B:48:0x010d, B:50:0x0115, B:53:0x011d, B:55:0x0125, B:261:0x05bb, B:263:0x05c5, B:265:0x05ca, B:268:0x05ea, B:269:0x05fb, B:270:0x0609, B:271:0x0613, B:272:0x0631, B:274:0x063b, B:284:0x0666, B:287:0x0672, B:289:0x067c, B:292:0x0684), top: B:361:0x000c, inners: #1, #5, #7, #8, #9, #10, #12, #13, #16 }] */
    /* JADX WARN: Code duplicated, block: B:317:0x06d3 A[Catch: Exception -> 0x0068, TRY_LEAVE, TryCatch #14 {Exception -> 0x0068, blocks: (B:6:0x000c, B:8:0x0016, B:11:0x001e, B:13:0x0029, B:16:0x003d, B:105:0x0206, B:109:0x0211, B:112:0x0220, B:139:0x030e, B:140:0x0317, B:142:0x031b, B:197:0x049a, B:198:0x04a3, B:200:0x04a7, B:224:0x0511, B:225:0x051a, B:228:0x0520, B:257:0x05ab, B:258:0x05b4, B:260:0x05b8, B:276:0x0649, B:277:0x0652, B:279:0x0656, B:280:0x065b, B:283:0x0663, B:294:0x0689, B:295:0x0692, B:297:0x0696, B:298:0x069b, B:300:0x069f, B:314:0x06c6, B:315:0x06ce, B:317:0x06d3, B:324:0x06f4, B:325:0x06fc, B:327:0x0700, B:21:0x0058, B:24:0x006b, B:25:0x007b, B:27:0x008e, B:28:0x009e, B:29:0x00ae, B:30:0x00be, B:31:0x00ce, B:44:0x00f8, B:45:0x0101, B:57:0x012c, B:58:0x0135, B:88:0x01c2, B:89:0x01ca, B:103:0x01fd, B:229:0x0523, B:233:0x0533, B:235:0x0538, B:237:0x0542, B:240:0x0551, B:242:0x055b, B:244:0x0563, B:246:0x0569, B:248:0x056f, B:249:0x0574, B:251:0x057e, B:253:0x0586, B:254:0x058c, B:255:0x059d, B:201:0x04aa, B:206:0x04bc, B:208:0x04c6, B:210:0x04ce, B:213:0x04d7, B:215:0x04df, B:216:0x04e6, B:218:0x04ee, B:219:0x04f5, B:221:0x04fd, B:222:0x0504, B:318:0x06d6, B:321:0x06e3, B:113:0x0223, B:114:0x022b, B:116:0x022f, B:119:0x0236, B:121:0x0240, B:123:0x0254, B:124:0x0258, B:125:0x0288, B:127:0x0292, B:128:0x029b, B:130:0x02a5, B:131:0x02b3, B:132:0x02c4, B:133:0x02ce, B:134:0x02d8, B:136:0x02df, B:137:0x02fd, B:143:0x031e, B:144:0x0326, B:145:0x0329, B:147:0x032e, B:150:0x0342, B:152:0x034c, B:153:0x0352, B:155:0x0358, B:156:0x0372, B:157:0x037b, B:158:0x0385, B:159:0x0396, B:162:0x03a2, B:165:0x03b8, B:166:0x03bd, B:167:0x03e2, B:169:0x03ec, B:170:0x03f5, B:172:0x03ff, B:173:0x040d, B:174:0x041e, B:175:0x0428, B:176:0x0432, B:178:0x043c, B:180:0x0444, B:181:0x0449, B:183:0x0451, B:184:0x0456, B:186:0x045e, B:187:0x0463, B:189:0x046b, B:190:0x0472, B:192:0x047c, B:194:0x0484, B:195:0x0495, B:90:0x01d2, B:92:0x01d8, B:99:0x01ef, B:101:0x01f5, B:95:0x01e0, B:97:0x01e8, B:46:0x0107, B:48:0x010d, B:50:0x0115, B:53:0x011d, B:55:0x0125, B:261:0x05bb, B:263:0x05c5, B:265:0x05ca, B:268:0x05ea, B:269:0x05fb, B:270:0x0609, B:271:0x0613, B:272:0x0631, B:274:0x063b, B:284:0x0666, B:287:0x0672, B:289:0x067c, B:292:0x0684), top: B:361:0x000c, inners: #1, #5, #7, #8, #9, #10, #12, #13, #16 }] */
    /* JADX WARN: Code duplicated, block: B:320:0x06e2  */
    /* JADX WARN: Code duplicated, block: B:321:0x06e3 A[Catch: Exception -> 0x06f3, TRY_LEAVE, TryCatch #7 {Exception -> 0x06f3, blocks: (B:318:0x06d6, B:321:0x06e3), top: B:347:0x06d6, outer: #14 }] */
    /* JADX WARN: Code duplicated, block: B:325:0x06fc A[Catch: Exception -> 0x0068, TryCatch #14 {Exception -> 0x0068, blocks: (B:6:0x000c, B:8:0x0016, B:11:0x001e, B:13:0x0029, B:16:0x003d, B:105:0x0206, B:109:0x0211, B:112:0x0220, B:139:0x030e, B:140:0x0317, B:142:0x031b, B:197:0x049a, B:198:0x04a3, B:200:0x04a7, B:224:0x0511, B:225:0x051a, B:228:0x0520, B:257:0x05ab, B:258:0x05b4, B:260:0x05b8, B:276:0x0649, B:277:0x0652, B:279:0x0656, B:280:0x065b, B:283:0x0663, B:294:0x0689, B:295:0x0692, B:297:0x0696, B:298:0x069b, B:300:0x069f, B:314:0x06c6, B:315:0x06ce, B:317:0x06d3, B:324:0x06f4, B:325:0x06fc, B:327:0x0700, B:21:0x0058, B:24:0x006b, B:25:0x007b, B:27:0x008e, B:28:0x009e, B:29:0x00ae, B:30:0x00be, B:31:0x00ce, B:44:0x00f8, B:45:0x0101, B:57:0x012c, B:58:0x0135, B:88:0x01c2, B:89:0x01ca, B:103:0x01fd, B:229:0x0523, B:233:0x0533, B:235:0x0538, B:237:0x0542, B:240:0x0551, B:242:0x055b, B:244:0x0563, B:246:0x0569, B:248:0x056f, B:249:0x0574, B:251:0x057e, B:253:0x0586, B:254:0x058c, B:255:0x059d, B:201:0x04aa, B:206:0x04bc, B:208:0x04c6, B:210:0x04ce, B:213:0x04d7, B:215:0x04df, B:216:0x04e6, B:218:0x04ee, B:219:0x04f5, B:221:0x04fd, B:222:0x0504, B:318:0x06d6, B:321:0x06e3, B:113:0x0223, B:114:0x022b, B:116:0x022f, B:119:0x0236, B:121:0x0240, B:123:0x0254, B:124:0x0258, B:125:0x0288, B:127:0x0292, B:128:0x029b, B:130:0x02a5, B:131:0x02b3, B:132:0x02c4, B:133:0x02ce, B:134:0x02d8, B:136:0x02df, B:137:0x02fd, B:143:0x031e, B:144:0x0326, B:145:0x0329, B:147:0x032e, B:150:0x0342, B:152:0x034c, B:153:0x0352, B:155:0x0358, B:156:0x0372, B:157:0x037b, B:158:0x0385, B:159:0x0396, B:162:0x03a2, B:165:0x03b8, B:166:0x03bd, B:167:0x03e2, B:169:0x03ec, B:170:0x03f5, B:172:0x03ff, B:173:0x040d, B:174:0x041e, B:175:0x0428, B:176:0x0432, B:178:0x043c, B:180:0x0444, B:181:0x0449, B:183:0x0451, B:184:0x0456, B:186:0x045e, B:187:0x0463, B:189:0x046b, B:190:0x0472, B:192:0x047c, B:194:0x0484, B:195:0x0495, B:90:0x01d2, B:92:0x01d8, B:99:0x01ef, B:101:0x01f5, B:95:0x01e0, B:97:0x01e8, B:46:0x0107, B:48:0x010d, B:50:0x0115, B:53:0x011d, B:55:0x0125, B:261:0x05bb, B:263:0x05c5, B:265:0x05ca, B:268:0x05ea, B:269:0x05fb, B:270:0x0609, B:271:0x0613, B:272:0x0631, B:274:0x063b, B:284:0x0666, B:287:0x0672, B:289:0x067c, B:292:0x0684), top: B:361:0x000c, inners: #1, #5, #7, #8, #9, #10, #12, #13, #16 }] */
    /* JADX WARN: Code duplicated, block: B:327:0x0700 A[Catch: Exception -> 0x0068, TRY_LEAVE, TryCatch #14 {Exception -> 0x0068, blocks: (B:6:0x000c, B:8:0x0016, B:11:0x001e, B:13:0x0029, B:16:0x003d, B:105:0x0206, B:109:0x0211, B:112:0x0220, B:139:0x030e, B:140:0x0317, B:142:0x031b, B:197:0x049a, B:198:0x04a3, B:200:0x04a7, B:224:0x0511, B:225:0x051a, B:228:0x0520, B:257:0x05ab, B:258:0x05b4, B:260:0x05b8, B:276:0x0649, B:277:0x0652, B:279:0x0656, B:280:0x065b, B:283:0x0663, B:294:0x0689, B:295:0x0692, B:297:0x0696, B:298:0x069b, B:300:0x069f, B:314:0x06c6, B:315:0x06ce, B:317:0x06d3, B:324:0x06f4, B:325:0x06fc, B:327:0x0700, B:21:0x0058, B:24:0x006b, B:25:0x007b, B:27:0x008e, B:28:0x009e, B:29:0x00ae, B:30:0x00be, B:31:0x00ce, B:44:0x00f8, B:45:0x0101, B:57:0x012c, B:58:0x0135, B:88:0x01c2, B:89:0x01ca, B:103:0x01fd, B:229:0x0523, B:233:0x0533, B:235:0x0538, B:237:0x0542, B:240:0x0551, B:242:0x055b, B:244:0x0563, B:246:0x0569, B:248:0x056f, B:249:0x0574, B:251:0x057e, B:253:0x0586, B:254:0x058c, B:255:0x059d, B:201:0x04aa, B:206:0x04bc, B:208:0x04c6, B:210:0x04ce, B:213:0x04d7, B:215:0x04df, B:216:0x04e6, B:218:0x04ee, B:219:0x04f5, B:221:0x04fd, B:222:0x0504, B:318:0x06d6, B:321:0x06e3, B:113:0x0223, B:114:0x022b, B:116:0x022f, B:119:0x0236, B:121:0x0240, B:123:0x0254, B:124:0x0258, B:125:0x0288, B:127:0x0292, B:128:0x029b, B:130:0x02a5, B:131:0x02b3, B:132:0x02c4, B:133:0x02ce, B:134:0x02d8, B:136:0x02df, B:137:0x02fd, B:143:0x031e, B:144:0x0326, B:145:0x0329, B:147:0x032e, B:150:0x0342, B:152:0x034c, B:153:0x0352, B:155:0x0358, B:156:0x0372, B:157:0x037b, B:158:0x0385, B:159:0x0396, B:162:0x03a2, B:165:0x03b8, B:166:0x03bd, B:167:0x03e2, B:169:0x03ec, B:170:0x03f5, B:172:0x03ff, B:173:0x040d, B:174:0x041e, B:175:0x0428, B:176:0x0432, B:178:0x043c, B:180:0x0444, B:181:0x0449, B:183:0x0451, B:184:0x0456, B:186:0x045e, B:187:0x0463, B:189:0x046b, B:190:0x0472, B:192:0x047c, B:194:0x0484, B:195:0x0495, B:90:0x01d2, B:92:0x01d8, B:99:0x01ef, B:101:0x01f5, B:95:0x01e0, B:97:0x01e8, B:46:0x0107, B:48:0x010d, B:50:0x0115, B:53:0x011d, B:55:0x0125, B:261:0x05bb, B:263:0x05c5, B:265:0x05ca, B:268:0x05ea, B:269:0x05fb, B:270:0x0609, B:271:0x0613, B:272:0x0631, B:274:0x063b, B:284:0x0666, B:287:0x0672, B:289:0x067c, B:292:0x0684), top: B:361:0x000c, inners: #1, #5, #7, #8, #9, #10, #12, #13, #16 }] */
    /* JADX WARN: Code duplicated, block: B:80:0x0172 A[Catch: Exception -> 0x0170, PHI: r19
  0x0172: PHI (r19v4 int) = (r19v5 int), (r19v6 int) binds: [B:76:0x0169, B:67:0x0152] A[DONT_GENERATE, DONT_INLINE], TryCatch #0 {Exception -> 0x0170, blocks: (B:73:0x015d, B:75:0x0161, B:77:0x016b, B:80:0x0172, B:81:0x017f, B:83:0x0189, B:84:0x0196, B:86:0x019c), top: B:333:0x015d }] */
    /* JADX WARN: Instruction removed from duplicated block: B:124:0x0258, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:166:0x03bd, please report this as an issue */
    public static void a(View view, AttributeSet attributeSet) {
        int i11;
        int i12;
        String[] strArrSplit;
        int i13;
        int i14;
        RelativeLayout relativeLayout;
        LinearLayout linearLayout;
        PlayerView playerView;
        GridView gridView;
        int i15;
        String attributeValue;
        ListView listView;
        int i16;
        String attributeValue2;
        String attributeValue3;
        boolean z11;
        String attributeValue4;
        ImageView imageView;
        int i17;
        String attributeValue5;
        TextView textView;
        int i18;
        String attributeValue6;
        String attributeValue7;
        String attributeValue8;
        String attributeValue9;
        String str;
        String strSubstring;
        Button button;
        String attributeValue10;
        String attributeValue11;
        String str2;
        if (view == null || attributeSet == null) {
            return;
        }
        try {
            HashMap<String, com.mbridge.msdk.dycreator.a.c> mapC = com.mbridge.msdk.dycreator.a.b.a().c();
            if (mapC != null && !mapC.isEmpty()) {
                int i19 = 0;
                int iB = 0;
                int iB2 = 0;
                int iB3 = 0;
                int iB4 = 0;
                for (int attributeCount = attributeSet.getAttributeCount(); i19 < attributeCount; attributeCount = i11) {
                    com.mbridge.msdk.dycreator.a.c cVar = mapC.get(attributeSet.getAttributeName(i19));
                    if (cVar != null) {
                        switch (AnonymousClass1.f43672a[cVar.ordinal()]) {
                            case 1:
                                i11 = attributeCount;
                                i12 = iB;
                                String attributeValue12 = attributeSet.getAttributeValue(i19);
                                try {
                                    String strSubstring2 = attributeValue12.startsWith("@+id/") ? attributeValue12.substring(5) : attributeValue12.startsWith("@id/") ? attributeValue12.substring(4) : "";
                                    if (!TextUtils.isEmpty(strSubstring2)) {
                                        view.setId(strSubstring2.hashCode());
                                    }
                                } catch (Exception e11) {
                                    ad.b("AttributeUtil", e11.getMessage());
                                }
                                iB = i12;
                                if (view instanceof EditText) {
                                    i13 = iB;
                                    i14 = iB2;
                                    if (view instanceof Button) {
                                        if (view instanceof TextView) {
                                            if (view instanceof ImageView) {
                                                if (view instanceof ListView) {
                                                    if (view instanceof GridView) {
                                                        if (view instanceof ScrollView) {
                                                            if (view instanceof PlayerView) {
                                                                if (view instanceof MBHorizontalScrollView) {
                                                                    if (view instanceof LinearLayout) {
                                                                        linearLayout = (LinearLayout) view;
                                                                        try {
                                                                            if (AnonymousClass1.f43672a[cVar.ordinal()] != 12) {
                                                                                if ("horizontal".equalsIgnoreCase(attributeSet.getAttributeValue(i19))) {
                                                                                    try {
                                                                                        linearLayout.setOrientation(0);
                                                                                    } catch (Exception e12) {
                                                                                        e = e12;
                                                                                        ad.b("AttributeUtil", e.getMessage());
                                                                                    }
                                                                                } else {
                                                                                    linearLayout.setOrientation(1);
                                                                                }
                                                                                break;
                                                                            }
                                                                        } catch (Exception e13) {
                                                                            e = e13;
                                                                        }
                                                                    } else if (view instanceof RelativeLayout) {
                                                                        relativeLayout = (RelativeLayout) view;
                                                                        try {
                                                                            if (AnonymousClass1.f43672a[cVar.ordinal()] != 22) {
                                                                                relativeLayout.setGravity(com.mbridge.msdk.dycreator.a.b.a().c(attributeSet.getAttributeValue(i19)));
                                                                                break;
                                                                            }
                                                                        } catch (Exception e14) {
                                                                            ad.b("AttributeUtil", e14.getMessage());
                                                                        }
                                                                    } else if (view instanceof FrameLayout) {
                                                                    }
                                                                    iB = i13;
                                                                    iB2 = i14;
                                                                }
                                                                break;
                                                            } else {
                                                                playerView = (PlayerView) view;
                                                                try {
                                                                    if (AnonymousClass1.f43672a[cVar.ordinal()] == 12) {
                                                                        if ("horizontal".equalsIgnoreCase(attributeSet.getAttributeValue(i19))) {
                                                                            playerView.setOrientation(0);
                                                                        } else {
                                                                            playerView.setOrientation(1);
                                                                        }
                                                                    }
                                                                } catch (Exception e15) {
                                                                    ad.b("AttributeUtil", e15.getMessage());
                                                                }
                                                            }
                                                        }
                                                    } else {
                                                        gridView = (GridView) view;
                                                        try {
                                                            i15 = AnonymousClass1.f43672a[cVar.ordinal()];
                                                            if (i15 != 1) {
                                                                switch (i15) {
                                                                    case 23:
                                                                        gridView.setVerticalSpacing(e.a(com.mbridge.msdk.foundation.controller.c.m().c(), com.mbridge.msdk.dycreator.a.b.a().b(attributeSet.getAttributeValue(i19))));
                                                                        break;
                                                                    case 24:
                                                                        gridView.setNumColumns(attributeSet.getAttributeIntValue(i19, 2));
                                                                        break;
                                                                    case 25:
                                                                        gridView.setMotionEventSplittingEnabled(!attributeSet.getAttributeValue(i19).equals("false"));
                                                                        break;
                                                                    case 26:
                                                                        gridView.setCacheColorHint(com.mbridge.msdk.dycreator.a.b.a().a(attributeSet.getAttributeValue(i19)));
                                                                        break;
                                                                    case 27:
                                                                        gridView.setHorizontalSpacing(e.a(com.mbridge.msdk.foundation.controller.c.m().c(), com.mbridge.msdk.dycreator.a.b.a().b(attributeSet.getAttributeValue(i19))));
                                                                        break;
                                                                }
                                                            } else {
                                                                attributeValue = attributeSet.getAttributeValue(i19);
                                                                if (attributeValue.startsWith("@+id/")) {
                                                                    gridView.setId(attributeValue.substring(5).hashCode());
                                                                }
                                                            }
                                                        } catch (Exception e16) {
                                                            ad.b("AttributeUtil", e16.getMessage());
                                                        }
                                                    }
                                                } else {
                                                    listView = (ListView) view;
                                                    try {
                                                        i16 = AnonymousClass1.f43672a[cVar.ordinal()];
                                                        if (i16 != 25) {
                                                            listView.setMotionEventSplittingEnabled(!attributeSet.getAttributeValue(i19).equals("false"));
                                                        } else if (i16 != 26) {
                                                            switch (i16) {
                                                                case 34:
                                                                    attributeValue2 = attributeSet.getAttributeValue(i19);
                                                                    if (!TextUtils.isEmpty(attributeValue2) && attributeValue2.startsWith("@null")) {
                                                                        listView.setDivider(null);
                                                                    }
                                                                    break;
                                                                case 35:
                                                                    attributeValue3 = attributeSet.getAttributeValue(i19);
                                                                    if (!TextUtils.isEmpty(attributeValue3)) {
                                                                        if (attributeValue3.equals(DevicePublicKeyStringDef.NONE)) {
                                                                            z11 = false;
                                                                            listView.setVerticalScrollBarEnabled(false);
                                                                        } else {
                                                                            z11 = false;
                                                                        }
                                                                        if (attributeValue3.equals("false")) {
                                                                            listView.setScrollbarFadingEnabled(z11);
                                                                        }
                                                                    }
                                                                    break;
                                                                case 36:
                                                                    attributeValue4 = attributeSet.getAttributeValue(i19);
                                                                    if (!TextUtils.isEmpty(attributeValue4)) {
                                                                        listView.setSelector(com.mbridge.msdk.dycreator.a.b.a().a(attributeValue4));
                                                                    }
                                                                    break;
                                                            }
                                                        } else {
                                                            listView.setCacheColorHint(com.mbridge.msdk.dycreator.a.b.a().a(attributeSet.getAttributeValue(i19)));
                                                        }
                                                    } catch (Exception e17) {
                                                        ad.b("AttributeUtil", e17.getMessage());
                                                    }
                                                }
                                            } else {
                                                imageView = (ImageView) view;
                                                try {
                                                    i17 = AnonymousClass1.f43672a[cVar.ordinal()];
                                                    if (i17 != 32) {
                                                        com.mbridge.msdk.dycreator.a.b.a().a(attributeSet.getAttributeValue(i19), imageView);
                                                    } else if (i17 != 33) {
                                                        attributeValue5 = attributeSet.getAttributeValue(i19);
                                                        if (!TextUtils.isEmpty(attributeValue5)) {
                                                            if (attributeValue5.equals("fitXY")) {
                                                                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                                                            } else if (attributeValue5.equals("centerInside")) {
                                                                imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                                                            } else if (attributeValue5.equals("centerCrop")) {
                                                                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                                                            } else if (attributeValue5.equals("fitStart")) {
                                                                imageView.setScaleType(ImageView.ScaleType.FIT_START);
                                                            }
                                                        }
                                                    }
                                                } catch (Exception e18) {
                                                    ad.b("AttributeUtil", e18.getMessage());
                                                }
                                            }
                                        } else {
                                            textView = (TextView) view;
                                            try {
                                                i18 = AnonymousClass1.f43672a[cVar.ordinal()];
                                                switch (i18) {
                                                    case 13:
                                                        attributeValue6 = attributeSet.getAttributeValue(i19);
                                                        if (!TextUtils.isEmpty(attributeValue6)) {
                                                            if (attributeValue6.startsWith("@string/")) {
                                                                textView.setText(com.mbridge.msdk.dycreator.a.b.a().e(attributeSet.getAttributeValue(i19)));
                                                            } else {
                                                                textView.setText(attributeValue6);
                                                            }
                                                        }
                                                        break;
                                                    case 14:
                                                        attributeValue7 = attributeSet.getAttributeValue(i19);
                                                        if (!TextUtils.isEmpty(attributeValue7)) {
                                                            if (attributeValue7.equals(TtmlNode.END)) {
                                                                textView.setEllipsize(TextUtils.TruncateAt.END);
                                                            }
                                                            if (attributeValue7.equals("start")) {
                                                                textView.setEllipsize(TextUtils.TruncateAt.START);
                                                            }
                                                            if (attributeValue7.equals("middle")) {
                                                                textView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
                                                            }
                                                            if (attributeValue7.equals("marquee")) {
                                                                textView.setEllipsize(TextUtils.TruncateAt.MARQUEE);
                                                            }
                                                        }
                                                        break;
                                                    case 15:
                                                        textView.setHorizontalFadingEdgeEnabled(attributeSet.getAttributeBooleanValue(i19, false));
                                                        break;
                                                    case 16:
                                                        textView.setHorizontallyScrolling(attributeSet.getAttributeBooleanValue(i19, false));
                                                        break;
                                                    case 17:
                                                        textView.setTextColor(com.mbridge.msdk.dycreator.a.b.a().a(attributeSet.getAttributeValue(i19)));
                                                        break;
                                                    case 18:
                                                        attributeValue8 = attributeSet.getAttributeValue(i19);
                                                        if (!TextUtils.isEmpty(attributeValue8)) {
                                                            textView.setTextSize(com.mbridge.msdk.dycreator.a.b.a().b(attributeValue8));
                                                        }
                                                        break;
                                                    case 19:
                                                        if (TtmlNode.BOLD.equalsIgnoreCase(attributeSet.getAttributeValue(i19))) {
                                                            textView.setTypeface(Typeface.defaultFromStyle(1));
                                                        }
                                                        break;
                                                    case 20:
                                                        String attributeValue13 = attributeSet.getAttributeValue(i19);
                                                        com.mbridge.msdk.dycreator.a.b.a().d("R.style." + attributeValue13.substring(attributeValue13.indexOf("/") + 1));
                                                        break;
                                                    case 21:
                                                        attributeValue9 = attributeSet.getAttributeValue(i19);
                                                        if (TextUtils.isEmpty(attributeValue9)) {
                                                            str = b.f43673a.get(attributeValue9.substring(8));
                                                            if (TextUtils.isEmpty(str)) {
                                                                textView.setTag(str);
                                                            }
                                                        }
                                                        break;
                                                    case 22:
                                                        textView.setGravity(com.mbridge.msdk.dycreator.a.b.a().c(attributeSet.getAttributeValue(i19)));
                                                        break;
                                                    default:
                                                        switch (i18) {
                                                            case 28:
                                                                textView.setSingleLine(attributeSet.getAttributeBooleanValue(i19, false));
                                                                break;
                                                            case VungleException.INCORRECT_DEFAULT_API_USAGE /* 29 */:
                                                                textView.setLines(attributeSet.getAttributeIntValue(i19, 1));
                                                                break;
                                                            case 30:
                                                                String attributeValue14 = attributeSet.getAttributeValue(i19);
                                                                strSubstring = attributeValue14.startsWith("@drawable/") ? attributeValue14.substring(10) : "";
                                                                if (!TextUtils.isEmpty(strSubstring)) {
                                                                    textView.setCompoundDrawables(textView.getResources().getDrawable(v.a(com.mbridge.msdk.foundation.controller.c.m().c(), strSubstring, "drawable")), null, null, null);
                                                                }
                                                                break;
                                                            case VungleException.WEB_CRASH /* 31 */:
                                                                textView.setCompoundDrawablePadding(com.mbridge.msdk.dycreator.a.b.a().b(attributeSet.getAttributeValue(i19)));
                                                                break;
                                                        }
                                                        break;
                                                }
                                            } catch (Exception e19) {
                                                ad.b("AttributeUtil", e19.getMessage());
                                            }
                                        }
                                    } else {
                                        button = (Button) view;
                                        try {
                                            switch (AnonymousClass1.f43672a[cVar.ordinal()]) {
                                                case 13:
                                                    button.setText(com.mbridge.msdk.dycreator.a.b.a().e(attributeSet.getAttributeValue(i19)));
                                                    break;
                                                case 14:
                                                    if (attributeSet.getAttributeBooleanValue(i19, false)) {
                                                        button.setFocusable(true);
                                                        button.setFocusableInTouchMode(true);
                                                        button.setSingleLine(true);
                                                        button.setEllipsize(TextUtils.TruncateAt.MARQUEE);
                                                        button.setMarqueeRepeatLimit(1000);
                                                        button.setSingleLine();
                                                        button.setHorizontallyScrolling(true);
                                                        button.requestFocus();
                                                    }
                                                    break;
                                                case 15:
                                                    button.setHorizontalFadingEdgeEnabled(attributeSet.getAttributeBooleanValue(i19, false));
                                                    break;
                                                case 16:
                                                    button.setHorizontallyScrolling(attributeSet.getAttributeBooleanValue(i19, false));
                                                    break;
                                                case 17:
                                                    button.setTextColor(com.mbridge.msdk.dycreator.a.b.a().a(attributeSet.getAttributeValue(i19)));
                                                    break;
                                                case 18:
                                                    attributeValue10 = attributeSet.getAttributeValue(i19);
                                                    if (!TextUtils.isEmpty(attributeValue10)) {
                                                        button.setTextSize(com.mbridge.msdk.dycreator.a.b.a().b(attributeValue10));
                                                    }
                                                    break;
                                                case 19:
                                                    if (TtmlNode.BOLD.equalsIgnoreCase(attributeSet.getAttributeValue(i19))) {
                                                        button.setTypeface(Typeface.defaultFromStyle(1));
                                                    }
                                                    break;
                                                case 20:
                                                    String attributeValue15 = attributeSet.getAttributeValue(i19);
                                                    button.setTextAppearance(com.mbridge.msdk.foundation.controller.c.m().c(), com.mbridge.msdk.dycreator.a.b.a().d("R.style." + attributeValue15.substring(attributeValue15.indexOf("/") + 1)));
                                                    break;
                                                case 21:
                                                    attributeValue11 = attributeSet.getAttributeValue(i19);
                                                    if (!TextUtils.isEmpty(attributeValue11)) {
                                                        str2 = b.f43673a.get(attributeValue11.substring(8));
                                                        if (!TextUtils.isEmpty(str2)) {
                                                            button.setTag(str2);
                                                        }
                                                    }
                                                    break;
                                                case 22:
                                                    button.setGravity(1);
                                                    break;
                                            }
                                        } catch (Exception e21) {
                                            ad.b("AttributeUtil", e21.getMessage());
                                        }
                                    }
                                } else {
                                    i13 = iB;
                                    i14 = iB2;
                                }
                                iB = i13;
                                iB2 = i14;
                                break;
                            case 2:
                                i11 = attributeCount;
                                String attributeValue16 = attributeSet.getAttributeValue(i19);
                                try {
                                    if (attributeValue16.startsWith(Utils.SEPARATOR)) {
                                        try {
                                            strArrSplit = attributeValue16.split("-");
                                        } catch (Exception unused) {
                                            strArrSplit = null;
                                        }
                                        if (strArrSplit != null) {
                                            i12 = iB;
                                            if (strArrSplit.length <= 2) {
                                                view.setBackgroundColor(com.mbridge.msdk.dycreator.a.b.a().a(attributeValue16));
                                            }
                                        } else {
                                            i12 = iB;
                                        }
                                        if (strArrSplit != null) {
                                            try {
                                                if (strArrSplit.length == 3) {
                                                    GradientDrawable gradientDrawableA = com.mbridge.msdk.dycreator.a.b.a().a(strArrSplit);
                                                    if (gradientDrawableA != null) {
                                                        view.setBackground(gradientDrawableA);
                                                    } else {
                                                        view.setBackgroundColor(com.mbridge.msdk.dycreator.a.b.a().a(attributeValue16));
                                                    }
                                                }
                                            } catch (Exception e22) {
                                                e = e22;
                                                ad.b("AttributeUtil", e.getMessage());
                                            }
                                        }
                                        break;
                                    } else {
                                        i12 = iB;
                                        if (attributeValue16.startsWith("@color/")) {
                                            view.setBackgroundColor(com.mbridge.msdk.dycreator.a.b.a().a(attributeValue16));
                                        } else if (attributeValue16.startsWith("@drawable/")) {
                                            view.setBackgroundResource(com.mbridge.msdk.foundation.controller.c.m().c().getResources().getIdentifier(attributeValue16.substring(10), "drawable", com.mbridge.msdk.foundation.controller.c.m().c().getPackageName()));
                                        }
                                    }
                                } catch (Exception e23) {
                                    e = e23;
                                    i12 = iB;
                                }
                                iB = i12;
                                if (view instanceof EditText) {
                                    i13 = iB;
                                    i14 = iB2;
                                    if (view instanceof Button) {
                                        if (view instanceof TextView) {
                                            if (view instanceof ImageView) {
                                                if (view instanceof ListView) {
                                                    if (view instanceof GridView) {
                                                        if (view instanceof ScrollView) {
                                                            if (view instanceof PlayerView) {
                                                                if (view instanceof MBHorizontalScrollView) {
                                                                    if (view instanceof LinearLayout) {
                                                                        linearLayout = (LinearLayout) view;
                                                                        if (AnonymousClass1.f43672a[cVar.ordinal()] != 12) {
                                                                            if ("horizontal".equalsIgnoreCase(attributeSet.getAttributeValue(i19))) {
                                                                                linearLayout.setOrientation(0);
                                                                            } else {
                                                                                linearLayout.setOrientation(1);
                                                                            }
                                                                            break;
                                                                        }
                                                                    } else if (view instanceof RelativeLayout) {
                                                                        relativeLayout = (RelativeLayout) view;
                                                                        if (AnonymousClass1.f43672a[cVar.ordinal()] != 22) {
                                                                            relativeLayout.setGravity(com.mbridge.msdk.dycreator.a.b.a().c(attributeSet.getAttributeValue(i19)));
                                                                            break;
                                                                        }
                                                                    } else if (view instanceof FrameLayout) {
                                                                    }
                                                                    iB = i13;
                                                                    iB2 = i14;
                                                                }
                                                                break;
                                                            } else {
                                                                playerView = (PlayerView) view;
                                                                if (AnonymousClass1.f43672a[cVar.ordinal()] == 12) {
                                                                    if ("horizontal".equalsIgnoreCase(attributeSet.getAttributeValue(i19))) {
                                                                        playerView.setOrientation(0);
                                                                    } else {
                                                                        playerView.setOrientation(1);
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    } else {
                                                        gridView = (GridView) view;
                                                        i15 = AnonymousClass1.f43672a[cVar.ordinal()];
                                                        if (i15 != 1) {
                                                            switch (i15) {
                                                                case 23:
                                                                    gridView.setVerticalSpacing(e.a(com.mbridge.msdk.foundation.controller.c.m().c(), com.mbridge.msdk.dycreator.a.b.a().b(attributeSet.getAttributeValue(i19))));
                                                                    break;
                                                                case 24:
                                                                    gridView.setNumColumns(attributeSet.getAttributeIntValue(i19, 2));
                                                                    break;
                                                                case 25:
                                                                    gridView.setMotionEventSplittingEnabled(!attributeSet.getAttributeValue(i19).equals("false"));
                                                                    break;
                                                                case 26:
                                                                    gridView.setCacheColorHint(com.mbridge.msdk.dycreator.a.b.a().a(attributeSet.getAttributeValue(i19)));
                                                                    break;
                                                                case 27:
                                                                    gridView.setHorizontalSpacing(e.a(com.mbridge.msdk.foundation.controller.c.m().c(), com.mbridge.msdk.dycreator.a.b.a().b(attributeSet.getAttributeValue(i19))));
                                                                    break;
                                                            }
                                                        } else {
                                                            attributeValue = attributeSet.getAttributeValue(i19);
                                                            if (attributeValue.startsWith("@+id/")) {
                                                                gridView.setId(attributeValue.substring(5).hashCode());
                                                            }
                                                        }
                                                    }
                                                } else {
                                                    listView = (ListView) view;
                                                    i16 = AnonymousClass1.f43672a[cVar.ordinal()];
                                                    if (i16 != 25) {
                                                        listView.setMotionEventSplittingEnabled(!attributeSet.getAttributeValue(i19).equals("false"));
                                                    } else if (i16 != 26) {
                                                        switch (i16) {
                                                            case 34:
                                                                attributeValue2 = attributeSet.getAttributeValue(i19);
                                                                if (!TextUtils.isEmpty(attributeValue2)) {
                                                                    listView.setDivider(null);
                                                                }
                                                                break;
                                                            case 35:
                                                                attributeValue3 = attributeSet.getAttributeValue(i19);
                                                                if (!TextUtils.isEmpty(attributeValue3)) {
                                                                    if (attributeValue3.equals(DevicePublicKeyStringDef.NONE)) {
                                                                        z11 = false;
                                                                        listView.setVerticalScrollBarEnabled(false);
                                                                    } else {
                                                                        z11 = false;
                                                                    }
                                                                    if (attributeValue3.equals("false")) {
                                                                        listView.setScrollbarFadingEnabled(z11);
                                                                    }
                                                                }
                                                                break;
                                                            case 36:
                                                                attributeValue4 = attributeSet.getAttributeValue(i19);
                                                                if (!TextUtils.isEmpty(attributeValue4)) {
                                                                    listView.setSelector(com.mbridge.msdk.dycreator.a.b.a().a(attributeValue4));
                                                                }
                                                                break;
                                                        }
                                                    } else {
                                                        listView.setCacheColorHint(com.mbridge.msdk.dycreator.a.b.a().a(attributeSet.getAttributeValue(i19)));
                                                    }
                                                }
                                            } else {
                                                imageView = (ImageView) view;
                                                i17 = AnonymousClass1.f43672a[cVar.ordinal()];
                                                if (i17 != 32) {
                                                    com.mbridge.msdk.dycreator.a.b.a().a(attributeSet.getAttributeValue(i19), imageView);
                                                } else if (i17 != 33) {
                                                    attributeValue5 = attributeSet.getAttributeValue(i19);
                                                    if (!TextUtils.isEmpty(attributeValue5)) {
                                                        if (attributeValue5.equals("fitXY")) {
                                                            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                                                        } else if (attributeValue5.equals("centerInside")) {
                                                            imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                                                        } else if (attributeValue5.equals("centerCrop")) {
                                                            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                                                        } else if (attributeValue5.equals("fitStart")) {
                                                            imageView.setScaleType(ImageView.ScaleType.FIT_START);
                                                        }
                                                    }
                                                }
                                            }
                                        } else {
                                            textView = (TextView) view;
                                            i18 = AnonymousClass1.f43672a[cVar.ordinal()];
                                            switch (i18) {
                                                case 13:
                                                    attributeValue6 = attributeSet.getAttributeValue(i19);
                                                    if (!TextUtils.isEmpty(attributeValue6)) {
                                                        if (attributeValue6.startsWith("@string/")) {
                                                            textView.setText(com.mbridge.msdk.dycreator.a.b.a().e(attributeSet.getAttributeValue(i19)));
                                                        } else {
                                                            textView.setText(attributeValue6);
                                                        }
                                                    }
                                                    break;
                                                case 14:
                                                    attributeValue7 = attributeSet.getAttributeValue(i19);
                                                    if (!TextUtils.isEmpty(attributeValue7)) {
                                                        if (attributeValue7.equals(TtmlNode.END)) {
                                                            textView.setEllipsize(TextUtils.TruncateAt.END);
                                                        }
                                                        if (attributeValue7.equals("start")) {
                                                            textView.setEllipsize(TextUtils.TruncateAt.START);
                                                        }
                                                        if (attributeValue7.equals("middle")) {
                                                            textView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
                                                        }
                                                        if (attributeValue7.equals("marquee")) {
                                                            textView.setEllipsize(TextUtils.TruncateAt.MARQUEE);
                                                        }
                                                    }
                                                    break;
                                                case 15:
                                                    textView.setHorizontalFadingEdgeEnabled(attributeSet.getAttributeBooleanValue(i19, false));
                                                    break;
                                                case 16:
                                                    textView.setHorizontallyScrolling(attributeSet.getAttributeBooleanValue(i19, false));
                                                    break;
                                                case 17:
                                                    textView.setTextColor(com.mbridge.msdk.dycreator.a.b.a().a(attributeSet.getAttributeValue(i19)));
                                                    break;
                                                case 18:
                                                    attributeValue8 = attributeSet.getAttributeValue(i19);
                                                    if (!TextUtils.isEmpty(attributeValue8)) {
                                                        textView.setTextSize(com.mbridge.msdk.dycreator.a.b.a().b(attributeValue8));
                                                    }
                                                    break;
                                                case 19:
                                                    if (TtmlNode.BOLD.equalsIgnoreCase(attributeSet.getAttributeValue(i19))) {
                                                        textView.setTypeface(Typeface.defaultFromStyle(1));
                                                    }
                                                    break;
                                                case 20:
                                                    String attributeValue17 = attributeSet.getAttributeValue(i19);
                                                    com.mbridge.msdk.dycreator.a.b.a().d("R.style." + attributeValue17.substring(attributeValue17.indexOf("/") + 1));
                                                    break;
                                                case 21:
                                                    attributeValue9 = attributeSet.getAttributeValue(i19);
                                                    if (TextUtils.isEmpty(attributeValue9)) {
                                                        str = b.f43673a.get(attributeValue9.substring(8));
                                                        if (TextUtils.isEmpty(str)) {
                                                            textView.setTag(str);
                                                        }
                                                    }
                                                    break;
                                                case 22:
                                                    textView.setGravity(com.mbridge.msdk.dycreator.a.b.a().c(attributeSet.getAttributeValue(i19)));
                                                    break;
                                                default:
                                                    switch (i18) {
                                                        case 28:
                                                            textView.setSingleLine(attributeSet.getAttributeBooleanValue(i19, false));
                                                            break;
                                                        case VungleException.INCORRECT_DEFAULT_API_USAGE /* 29 */:
                                                            textView.setLines(attributeSet.getAttributeIntValue(i19, 1));
                                                            break;
                                                        case 30:
                                                            String attributeValue18 = attributeSet.getAttributeValue(i19);
                                                            if (attributeValue18.startsWith("@drawable/")) {
                                                            }
                                                            if (!TextUtils.isEmpty(strSubstring)) {
                                                                textView.setCompoundDrawables(textView.getResources().getDrawable(v.a(com.mbridge.msdk.foundation.controller.c.m().c(), strSubstring, "drawable")), null, null, null);
                                                            }
                                                            break;
                                                        case VungleException.WEB_CRASH /* 31 */:
                                                            textView.setCompoundDrawablePadding(com.mbridge.msdk.dycreator.a.b.a().b(attributeSet.getAttributeValue(i19)));
                                                            break;
                                                    }
                                                    break;
                                            }
                                        }
                                    } else {
                                        button = (Button) view;
                                        switch (AnonymousClass1.f43672a[cVar.ordinal()]) {
                                            case 13:
                                                button.setText(com.mbridge.msdk.dycreator.a.b.a().e(attributeSet.getAttributeValue(i19)));
                                                break;
                                            case 14:
                                                if (attributeSet.getAttributeBooleanValue(i19, false)) {
                                                    button.setFocusable(true);
                                                    button.setFocusableInTouchMode(true);
                                                    button.setSingleLine(true);
                                                    button.setEllipsize(TextUtils.TruncateAt.MARQUEE);
                                                    button.setMarqueeRepeatLimit(1000);
                                                    button.setSingleLine();
                                                    button.setHorizontallyScrolling(true);
                                                    button.requestFocus();
                                                }
                                                break;
                                            case 15:
                                                button.setHorizontalFadingEdgeEnabled(attributeSet.getAttributeBooleanValue(i19, false));
                                                break;
                                            case 16:
                                                button.setHorizontallyScrolling(attributeSet.getAttributeBooleanValue(i19, false));
                                                break;
                                            case 17:
                                                button.setTextColor(com.mbridge.msdk.dycreator.a.b.a().a(attributeSet.getAttributeValue(i19)));
                                                break;
                                            case 18:
                                                attributeValue10 = attributeSet.getAttributeValue(i19);
                                                if (!TextUtils.isEmpty(attributeValue10)) {
                                                    button.setTextSize(com.mbridge.msdk.dycreator.a.b.a().b(attributeValue10));
                                                }
                                                break;
                                            case 19:
                                                if (TtmlNode.BOLD.equalsIgnoreCase(attributeSet.getAttributeValue(i19))) {
                                                    button.setTypeface(Typeface.defaultFromStyle(1));
                                                }
                                                break;
                                            case 20:
                                                String attributeValue19 = attributeSet.getAttributeValue(i19);
                                                button.setTextAppearance(com.mbridge.msdk.foundation.controller.c.m().c(), com.mbridge.msdk.dycreator.a.b.a().d("R.style." + attributeValue19.substring(attributeValue19.indexOf("/") + 1)));
                                                break;
                                            case 21:
                                                attributeValue11 = attributeSet.getAttributeValue(i19);
                                                if (!TextUtils.isEmpty(attributeValue11)) {
                                                    str2 = b.f43673a.get(attributeValue11.substring(8));
                                                    if (!TextUtils.isEmpty(str2)) {
                                                        button.setTag(str2);
                                                    }
                                                }
                                                break;
                                            case 22:
                                                button.setGravity(1);
                                                break;
                                        }
                                    }
                                } else {
                                    i13 = iB;
                                    i14 = iB2;
                                }
                                iB = i13;
                                iB2 = i14;
                                break;
                            case 3:
                                i11 = attributeCount;
                                String attributeValue20 = attributeSet.getAttributeValue(i19);
                                try {
                                    if (!TextUtils.isEmpty(attributeValue20)) {
                                        if (attributeValue20.equals("invisible")) {
                                            view.setVisibility(4);
                                        } else if (attributeValue20.equalsIgnoreCase("gone")) {
                                            view.setVisibility(8);
                                        }
                                    }
                                } catch (Exception e24) {
                                    ad.b("AttributeUtil", e24.getMessage());
                                }
                                i12 = iB;
                                iB = i12;
                                if (view instanceof EditText) {
                                    i13 = iB;
                                    i14 = iB2;
                                    if (view instanceof Button) {
                                        if (view instanceof TextView) {
                                            if (view instanceof ImageView) {
                                                if (view instanceof ListView) {
                                                    if (view instanceof GridView) {
                                                        if (view instanceof ScrollView) {
                                                            if (view instanceof PlayerView) {
                                                                if (view instanceof MBHorizontalScrollView) {
                                                                    if (view instanceof LinearLayout) {
                                                                        linearLayout = (LinearLayout) view;
                                                                        if (AnonymousClass1.f43672a[cVar.ordinal()] != 12) {
                                                                            if ("horizontal".equalsIgnoreCase(attributeSet.getAttributeValue(i19))) {
                                                                                linearLayout.setOrientation(0);
                                                                            } else {
                                                                                linearLayout.setOrientation(1);
                                                                            }
                                                                            break;
                                                                        }
                                                                    } else if (view instanceof RelativeLayout) {
                                                                        relativeLayout = (RelativeLayout) view;
                                                                        if (AnonymousClass1.f43672a[cVar.ordinal()] != 22) {
                                                                            relativeLayout.setGravity(com.mbridge.msdk.dycreator.a.b.a().c(attributeSet.getAttributeValue(i19)));
                                                                            break;
                                                                        }
                                                                    } else if (view instanceof FrameLayout) {
                                                                    }
                                                                    iB = i13;
                                                                    iB2 = i14;
                                                                }
                                                                break;
                                                            } else {
                                                                playerView = (PlayerView) view;
                                                                if (AnonymousClass1.f43672a[cVar.ordinal()] == 12) {
                                                                    if ("horizontal".equalsIgnoreCase(attributeSet.getAttributeValue(i19))) {
                                                                        playerView.setOrientation(0);
                                                                    } else {
                                                                        playerView.setOrientation(1);
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    } else {
                                                        gridView = (GridView) view;
                                                        i15 = AnonymousClass1.f43672a[cVar.ordinal()];
                                                        if (i15 != 1) {
                                                            switch (i15) {
                                                                case 23:
                                                                    gridView.setVerticalSpacing(e.a(com.mbridge.msdk.foundation.controller.c.m().c(), com.mbridge.msdk.dycreator.a.b.a().b(attributeSet.getAttributeValue(i19))));
                                                                    break;
                                                                case 24:
                                                                    gridView.setNumColumns(attributeSet.getAttributeIntValue(i19, 2));
                                                                    break;
                                                                case 25:
                                                                    gridView.setMotionEventSplittingEnabled(!attributeSet.getAttributeValue(i19).equals("false"));
                                                                    break;
                                                                case 26:
                                                                    gridView.setCacheColorHint(com.mbridge.msdk.dycreator.a.b.a().a(attributeSet.getAttributeValue(i19)));
                                                                    break;
                                                                case 27:
                                                                    gridView.setHorizontalSpacing(e.a(com.mbridge.msdk.foundation.controller.c.m().c(), com.mbridge.msdk.dycreator.a.b.a().b(attributeSet.getAttributeValue(i19))));
                                                                    break;
                                                            }
                                                        } else {
                                                            attributeValue = attributeSet.getAttributeValue(i19);
                                                            if (attributeValue.startsWith("@+id/")) {
                                                                gridView.setId(attributeValue.substring(5).hashCode());
                                                            }
                                                        }
                                                    }
                                                } else {
                                                    listView = (ListView) view;
                                                    i16 = AnonymousClass1.f43672a[cVar.ordinal()];
                                                    if (i16 != 25) {
                                                        listView.setMotionEventSplittingEnabled(!attributeSet.getAttributeValue(i19).equals("false"));
                                                    } else if (i16 != 26) {
                                                        switch (i16) {
                                                            case 34:
                                                                attributeValue2 = attributeSet.getAttributeValue(i19);
                                                                if (!TextUtils.isEmpty(attributeValue2)) {
                                                                    listView.setDivider(null);
                                                                }
                                                                break;
                                                            case 35:
                                                                attributeValue3 = attributeSet.getAttributeValue(i19);
                                                                if (!TextUtils.isEmpty(attributeValue3)) {
                                                                    if (attributeValue3.equals(DevicePublicKeyStringDef.NONE)) {
                                                                        z11 = false;
                                                                        listView.setVerticalScrollBarEnabled(false);
                                                                    } else {
                                                                        z11 = false;
                                                                    }
                                                                    if (attributeValue3.equals("false")) {
                                                                        listView.setScrollbarFadingEnabled(z11);
                                                                    }
                                                                }
                                                                break;
                                                            case 36:
                                                                attributeValue4 = attributeSet.getAttributeValue(i19);
                                                                if (!TextUtils.isEmpty(attributeValue4)) {
                                                                    listView.setSelector(com.mbridge.msdk.dycreator.a.b.a().a(attributeValue4));
                                                                }
                                                                break;
                                                        }
                                                    } else {
                                                        listView.setCacheColorHint(com.mbridge.msdk.dycreator.a.b.a().a(attributeSet.getAttributeValue(i19)));
                                                    }
                                                }
                                            } else {
                                                imageView = (ImageView) view;
                                                i17 = AnonymousClass1.f43672a[cVar.ordinal()];
                                                if (i17 != 32) {
                                                    com.mbridge.msdk.dycreator.a.b.a().a(attributeSet.getAttributeValue(i19), imageView);
                                                } else if (i17 != 33) {
                                                    attributeValue5 = attributeSet.getAttributeValue(i19);
                                                    if (!TextUtils.isEmpty(attributeValue5)) {
                                                        if (attributeValue5.equals("fitXY")) {
                                                            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                                                        } else if (attributeValue5.equals("centerInside")) {
                                                            imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                                                        } else if (attributeValue5.equals("centerCrop")) {
                                                            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                                                        } else if (attributeValue5.equals("fitStart")) {
                                                            imageView.setScaleType(ImageView.ScaleType.FIT_START);
                                                        }
                                                    }
                                                }
                                            }
                                        } else {
                                            textView = (TextView) view;
                                            i18 = AnonymousClass1.f43672a[cVar.ordinal()];
                                            switch (i18) {
                                                case 13:
                                                    attributeValue6 = attributeSet.getAttributeValue(i19);
                                                    if (!TextUtils.isEmpty(attributeValue6)) {
                                                        if (attributeValue6.startsWith("@string/")) {
                                                            textView.setText(com.mbridge.msdk.dycreator.a.b.a().e(attributeSet.getAttributeValue(i19)));
                                                        } else {
                                                            textView.setText(attributeValue6);
                                                        }
                                                    }
                                                    break;
                                                case 14:
                                                    attributeValue7 = attributeSet.getAttributeValue(i19);
                                                    if (!TextUtils.isEmpty(attributeValue7)) {
                                                        if (attributeValue7.equals(TtmlNode.END)) {
                                                            textView.setEllipsize(TextUtils.TruncateAt.END);
                                                        }
                                                        if (attributeValue7.equals("start")) {
                                                            textView.setEllipsize(TextUtils.TruncateAt.START);
                                                        }
                                                        if (attributeValue7.equals("middle")) {
                                                            textView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
                                                        }
                                                        if (attributeValue7.equals("marquee")) {
                                                            textView.setEllipsize(TextUtils.TruncateAt.MARQUEE);
                                                        }
                                                    }
                                                    break;
                                                case 15:
                                                    textView.setHorizontalFadingEdgeEnabled(attributeSet.getAttributeBooleanValue(i19, false));
                                                    break;
                                                case 16:
                                                    textView.setHorizontallyScrolling(attributeSet.getAttributeBooleanValue(i19, false));
                                                    break;
                                                case 17:
                                                    textView.setTextColor(com.mbridge.msdk.dycreator.a.b.a().a(attributeSet.getAttributeValue(i19)));
                                                    break;
                                                case 18:
                                                    attributeValue8 = attributeSet.getAttributeValue(i19);
                                                    if (!TextUtils.isEmpty(attributeValue8)) {
                                                        textView.setTextSize(com.mbridge.msdk.dycreator.a.b.a().b(attributeValue8));
                                                    }
                                                    break;
                                                case 19:
                                                    if (TtmlNode.BOLD.equalsIgnoreCase(attributeSet.getAttributeValue(i19))) {
                                                        textView.setTypeface(Typeface.defaultFromStyle(1));
                                                    }
                                                    break;
                                                case 20:
                                                    String attributeValue110 = attributeSet.getAttributeValue(i19);
                                                    com.mbridge.msdk.dycreator.a.b.a().d("R.style." + attributeValue110.substring(attributeValue110.indexOf("/") + 1));
                                                    break;
                                                case 21:
                                                    attributeValue9 = attributeSet.getAttributeValue(i19);
                                                    if (TextUtils.isEmpty(attributeValue9)) {
                                                        str = b.f43673a.get(attributeValue9.substring(8));
                                                        if (TextUtils.isEmpty(str)) {
                                                            textView.setTag(str);
                                                        }
                                                    }
                                                    break;
                                                case 22:
                                                    textView.setGravity(com.mbridge.msdk.dycreator.a.b.a().c(attributeSet.getAttributeValue(i19)));
                                                    break;
                                                default:
                                                    switch (i18) {
                                                        case 28:
                                                            textView.setSingleLine(attributeSet.getAttributeBooleanValue(i19, false));
                                                            break;
                                                        case VungleException.INCORRECT_DEFAULT_API_USAGE /* 29 */:
                                                            textView.setLines(attributeSet.getAttributeIntValue(i19, 1));
                                                            break;
                                                        case 30:
                                                            String attributeValue111 = attributeSet.getAttributeValue(i19);
                                                            if (attributeValue111.startsWith("@drawable/")) {
                                                            }
                                                            if (!TextUtils.isEmpty(strSubstring)) {
                                                                textView.setCompoundDrawables(textView.getResources().getDrawable(v.a(com.mbridge.msdk.foundation.controller.c.m().c(), strSubstring, "drawable")), null, null, null);
                                                            }
                                                            break;
                                                        case VungleException.WEB_CRASH /* 31 */:
                                                            textView.setCompoundDrawablePadding(com.mbridge.msdk.dycreator.a.b.a().b(attributeSet.getAttributeValue(i19)));
                                                            break;
                                                    }
                                                    break;
                                            }
                                        }
                                    } else {
                                        button = (Button) view;
                                        switch (AnonymousClass1.f43672a[cVar.ordinal()]) {
                                            case 13:
                                                button.setText(com.mbridge.msdk.dycreator.a.b.a().e(attributeSet.getAttributeValue(i19)));
                                                break;
                                            case 14:
                                                if (attributeSet.getAttributeBooleanValue(i19, false)) {
                                                    button.setFocusable(true);
                                                    button.setFocusableInTouchMode(true);
                                                    button.setSingleLine(true);
                                                    button.setEllipsize(TextUtils.TruncateAt.MARQUEE);
                                                    button.setMarqueeRepeatLimit(1000);
                                                    button.setSingleLine();
                                                    button.setHorizontallyScrolling(true);
                                                    button.requestFocus();
                                                }
                                                break;
                                            case 15:
                                                button.setHorizontalFadingEdgeEnabled(attributeSet.getAttributeBooleanValue(i19, false));
                                                break;
                                            case 16:
                                                button.setHorizontallyScrolling(attributeSet.getAttributeBooleanValue(i19, false));
                                                break;
                                            case 17:
                                                button.setTextColor(com.mbridge.msdk.dycreator.a.b.a().a(attributeSet.getAttributeValue(i19)));
                                                break;
                                            case 18:
                                                attributeValue10 = attributeSet.getAttributeValue(i19);
                                                if (!TextUtils.isEmpty(attributeValue10)) {
                                                    button.setTextSize(com.mbridge.msdk.dycreator.a.b.a().b(attributeValue10));
                                                }
                                                break;
                                            case 19:
                                                if (TtmlNode.BOLD.equalsIgnoreCase(attributeSet.getAttributeValue(i19))) {
                                                    button.setTypeface(Typeface.defaultFromStyle(1));
                                                }
                                                break;
                                            case 20:
                                                String attributeValue112 = attributeSet.getAttributeValue(i19);
                                                button.setTextAppearance(com.mbridge.msdk.foundation.controller.c.m().c(), com.mbridge.msdk.dycreator.a.b.a().d("R.style." + attributeValue112.substring(attributeValue112.indexOf("/") + 1)));
                                                break;
                                            case 21:
                                                attributeValue11 = attributeSet.getAttributeValue(i19);
                                                if (!TextUtils.isEmpty(attributeValue11)) {
                                                    str2 = b.f43673a.get(attributeValue11.substring(8));
                                                    if (!TextUtils.isEmpty(str2)) {
                                                        button.setTag(str2);
                                                    }
                                                }
                                                break;
                                            case 22:
                                                button.setGravity(1);
                                                break;
                                        }
                                    }
                                } else {
                                    i13 = iB;
                                    i14 = iB2;
                                }
                                iB = i13;
                                iB2 = i14;
                                break;
                            case 4:
                                String attributeValue21 = attributeSet.getAttributeValue(i19);
                                try {
                                    if (TextUtils.isEmpty(attributeValue21)) {
                                        i11 = attributeCount;
                                    } else {
                                        i11 = attributeCount;
                                        try {
                                            String str3 = b.f43673a.get(attributeValue21.substring(8));
                                            if (!TextUtils.isEmpty(str3)) {
                                                view.setContentDescription(str3);
                                            }
                                        } catch (Exception e25) {
                                            e = e25;
                                            ad.b("AttributeUtil", e.getMessage());
                                        }
                                    }
                                } catch (Exception e26) {
                                    e = e26;
                                    i11 = attributeCount;
                                }
                                i12 = iB;
                                iB = i12;
                                if (view instanceof EditText) {
                                    i13 = iB;
                                    i14 = iB2;
                                    if (view instanceof Button) {
                                        if (view instanceof TextView) {
                                            if (view instanceof ImageView) {
                                                if (view instanceof ListView) {
                                                    if (view instanceof GridView) {
                                                        if (view instanceof ScrollView) {
                                                            if (view instanceof PlayerView) {
                                                                if (view instanceof MBHorizontalScrollView) {
                                                                    if (view instanceof LinearLayout) {
                                                                        linearLayout = (LinearLayout) view;
                                                                        if (AnonymousClass1.f43672a[cVar.ordinal()] != 12) {
                                                                            if ("horizontal".equalsIgnoreCase(attributeSet.getAttributeValue(i19))) {
                                                                                linearLayout.setOrientation(0);
                                                                            } else {
                                                                                linearLayout.setOrientation(1);
                                                                            }
                                                                            break;
                                                                        }
                                                                    } else if (view instanceof RelativeLayout) {
                                                                        relativeLayout = (RelativeLayout) view;
                                                                        if (AnonymousClass1.f43672a[cVar.ordinal()] != 22) {
                                                                            relativeLayout.setGravity(com.mbridge.msdk.dycreator.a.b.a().c(attributeSet.getAttributeValue(i19)));
                                                                            break;
                                                                        }
                                                                    } else if (view instanceof FrameLayout) {
                                                                    }
                                                                    iB = i13;
                                                                    iB2 = i14;
                                                                }
                                                                break;
                                                            } else {
                                                                playerView = (PlayerView) view;
                                                                if (AnonymousClass1.f43672a[cVar.ordinal()] == 12) {
                                                                    if ("horizontal".equalsIgnoreCase(attributeSet.getAttributeValue(i19))) {
                                                                        playerView.setOrientation(0);
                                                                    } else {
                                                                        playerView.setOrientation(1);
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    } else {
                                                        gridView = (GridView) view;
                                                        i15 = AnonymousClass1.f43672a[cVar.ordinal()];
                                                        if (i15 != 1) {
                                                            switch (i15) {
                                                                case 23:
                                                                    gridView.setVerticalSpacing(e.a(com.mbridge.msdk.foundation.controller.c.m().c(), com.mbridge.msdk.dycreator.a.b.a().b(attributeSet.getAttributeValue(i19))));
                                                                    break;
                                                                case 24:
                                                                    gridView.setNumColumns(attributeSet.getAttributeIntValue(i19, 2));
                                                                    break;
                                                                case 25:
                                                                    gridView.setMotionEventSplittingEnabled(!attributeSet.getAttributeValue(i19).equals("false"));
                                                                    break;
                                                                case 26:
                                                                    gridView.setCacheColorHint(com.mbridge.msdk.dycreator.a.b.a().a(attributeSet.getAttributeValue(i19)));
                                                                    break;
                                                                case 27:
                                                                    gridView.setHorizontalSpacing(e.a(com.mbridge.msdk.foundation.controller.c.m().c(), com.mbridge.msdk.dycreator.a.b.a().b(attributeSet.getAttributeValue(i19))));
                                                                    break;
                                                            }
                                                        } else {
                                                            attributeValue = attributeSet.getAttributeValue(i19);
                                                            if (attributeValue.startsWith("@+id/")) {
                                                                gridView.setId(attributeValue.substring(5).hashCode());
                                                            }
                                                        }
                                                    }
                                                } else {
                                                    listView = (ListView) view;
                                                    i16 = AnonymousClass1.f43672a[cVar.ordinal()];
                                                    if (i16 != 25) {
                                                        listView.setMotionEventSplittingEnabled(!attributeSet.getAttributeValue(i19).equals("false"));
                                                    } else if (i16 != 26) {
                                                        switch (i16) {
                                                            case 34:
                                                                attributeValue2 = attributeSet.getAttributeValue(i19);
                                                                if (!TextUtils.isEmpty(attributeValue2)) {
                                                                    listView.setDivider(null);
                                                                }
                                                                break;
                                                            case 35:
                                                                attributeValue3 = attributeSet.getAttributeValue(i19);
                                                                if (!TextUtils.isEmpty(attributeValue3)) {
                                                                    if (attributeValue3.equals(DevicePublicKeyStringDef.NONE)) {
                                                                        z11 = false;
                                                                        listView.setVerticalScrollBarEnabled(false);
                                                                    } else {
                                                                        z11 = false;
                                                                    }
                                                                    if (attributeValue3.equals("false")) {
                                                                        listView.setScrollbarFadingEnabled(z11);
                                                                    }
                                                                }
                                                                break;
                                                            case 36:
                                                                attributeValue4 = attributeSet.getAttributeValue(i19);
                                                                if (!TextUtils.isEmpty(attributeValue4)) {
                                                                    listView.setSelector(com.mbridge.msdk.dycreator.a.b.a().a(attributeValue4));
                                                                }
                                                                break;
                                                        }
                                                    } else {
                                                        listView.setCacheColorHint(com.mbridge.msdk.dycreator.a.b.a().a(attributeSet.getAttributeValue(i19)));
                                                    }
                                                }
                                            } else {
                                                imageView = (ImageView) view;
                                                i17 = AnonymousClass1.f43672a[cVar.ordinal()];
                                                if (i17 != 32) {
                                                    com.mbridge.msdk.dycreator.a.b.a().a(attributeSet.getAttributeValue(i19), imageView);
                                                } else if (i17 != 33) {
                                                    attributeValue5 = attributeSet.getAttributeValue(i19);
                                                    if (!TextUtils.isEmpty(attributeValue5)) {
                                                        if (attributeValue5.equals("fitXY")) {
                                                            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                                                        } else if (attributeValue5.equals("centerInside")) {
                                                            imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                                                        } else if (attributeValue5.equals("centerCrop")) {
                                                            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                                                        } else if (attributeValue5.equals("fitStart")) {
                                                            imageView.setScaleType(ImageView.ScaleType.FIT_START);
                                                        }
                                                    }
                                                }
                                            }
                                        } else {
                                            textView = (TextView) view;
                                            i18 = AnonymousClass1.f43672a[cVar.ordinal()];
                                            switch (i18) {
                                                case 13:
                                                    attributeValue6 = attributeSet.getAttributeValue(i19);
                                                    if (!TextUtils.isEmpty(attributeValue6)) {
                                                        if (attributeValue6.startsWith("@string/")) {
                                                            textView.setText(com.mbridge.msdk.dycreator.a.b.a().e(attributeSet.getAttributeValue(i19)));
                                                        } else {
                                                            textView.setText(attributeValue6);
                                                        }
                                                    }
                                                    break;
                                                case 14:
                                                    attributeValue7 = attributeSet.getAttributeValue(i19);
                                                    if (!TextUtils.isEmpty(attributeValue7)) {
                                                        if (attributeValue7.equals(TtmlNode.END)) {
                                                            textView.setEllipsize(TextUtils.TruncateAt.END);
                                                        }
                                                        if (attributeValue7.equals("start")) {
                                                            textView.setEllipsize(TextUtils.TruncateAt.START);
                                                        }
                                                        if (attributeValue7.equals("middle")) {
                                                            textView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
                                                        }
                                                        if (attributeValue7.equals("marquee")) {
                                                            textView.setEllipsize(TextUtils.TruncateAt.MARQUEE);
                                                        }
                                                    }
                                                    break;
                                                case 15:
                                                    textView.setHorizontalFadingEdgeEnabled(attributeSet.getAttributeBooleanValue(i19, false));
                                                    break;
                                                case 16:
                                                    textView.setHorizontallyScrolling(attributeSet.getAttributeBooleanValue(i19, false));
                                                    break;
                                                case 17:
                                                    textView.setTextColor(com.mbridge.msdk.dycreator.a.b.a().a(attributeSet.getAttributeValue(i19)));
                                                    break;
                                                case 18:
                                                    attributeValue8 = attributeSet.getAttributeValue(i19);
                                                    if (!TextUtils.isEmpty(attributeValue8)) {
                                                        textView.setTextSize(com.mbridge.msdk.dycreator.a.b.a().b(attributeValue8));
                                                    }
                                                    break;
                                                case 19:
                                                    if (TtmlNode.BOLD.equalsIgnoreCase(attributeSet.getAttributeValue(i19))) {
                                                        textView.setTypeface(Typeface.defaultFromStyle(1));
                                                    }
                                                    break;
                                                case 20:
                                                    String attributeValue113 = attributeSet.getAttributeValue(i19);
                                                    com.mbridge.msdk.dycreator.a.b.a().d("R.style." + attributeValue113.substring(attributeValue113.indexOf("/") + 1));
                                                    break;
                                                case 21:
                                                    attributeValue9 = attributeSet.getAttributeValue(i19);
                                                    if (TextUtils.isEmpty(attributeValue9)) {
                                                        str = b.f43673a.get(attributeValue9.substring(8));
                                                        if (TextUtils.isEmpty(str)) {
                                                            textView.setTag(str);
                                                        }
                                                    }
                                                    break;
                                                case 22:
                                                    textView.setGravity(com.mbridge.msdk.dycreator.a.b.a().c(attributeSet.getAttributeValue(i19)));
                                                    break;
                                                default:
                                                    switch (i18) {
                                                        case 28:
                                                            textView.setSingleLine(attributeSet.getAttributeBooleanValue(i19, false));
                                                            break;
                                                        case VungleException.INCORRECT_DEFAULT_API_USAGE /* 29 */:
                                                            textView.setLines(attributeSet.getAttributeIntValue(i19, 1));
                                                            break;
                                                        case 30:
                                                            String attributeValue114 = attributeSet.getAttributeValue(i19);
                                                            if (attributeValue114.startsWith("@drawable/")) {
                                                            }
                                                            if (!TextUtils.isEmpty(strSubstring)) {
                                                                textView.setCompoundDrawables(textView.getResources().getDrawable(v.a(com.mbridge.msdk.foundation.controller.c.m().c(), strSubstring, "drawable")), null, null, null);
                                                            }
                                                            break;
                                                        case VungleException.WEB_CRASH /* 31 */:
                                                            textView.setCompoundDrawablePadding(com.mbridge.msdk.dycreator.a.b.a().b(attributeSet.getAttributeValue(i19)));
                                                            break;
                                                    }
                                                    break;
                                            }
                                        }
                                    } else {
                                        button = (Button) view;
                                        switch (AnonymousClass1.f43672a[cVar.ordinal()]) {
                                            case 13:
                                                button.setText(com.mbridge.msdk.dycreator.a.b.a().e(attributeSet.getAttributeValue(i19)));
                                                break;
                                            case 14:
                                                if (attributeSet.getAttributeBooleanValue(i19, false)) {
                                                    button.setFocusable(true);
                                                    button.setFocusableInTouchMode(true);
                                                    button.setSingleLine(true);
                                                    button.setEllipsize(TextUtils.TruncateAt.MARQUEE);
                                                    button.setMarqueeRepeatLimit(1000);
                                                    button.setSingleLine();
                                                    button.setHorizontallyScrolling(true);
                                                    button.requestFocus();
                                                }
                                                break;
                                            case 15:
                                                button.setHorizontalFadingEdgeEnabled(attributeSet.getAttributeBooleanValue(i19, false));
                                                break;
                                            case 16:
                                                button.setHorizontallyScrolling(attributeSet.getAttributeBooleanValue(i19, false));
                                                break;
                                            case 17:
                                                button.setTextColor(com.mbridge.msdk.dycreator.a.b.a().a(attributeSet.getAttributeValue(i19)));
                                                break;
                                            case 18:
                                                attributeValue10 = attributeSet.getAttributeValue(i19);
                                                if (!TextUtils.isEmpty(attributeValue10)) {
                                                    button.setTextSize(com.mbridge.msdk.dycreator.a.b.a().b(attributeValue10));
                                                }
                                                break;
                                            case 19:
                                                if (TtmlNode.BOLD.equalsIgnoreCase(attributeSet.getAttributeValue(i19))) {
                                                    button.setTypeface(Typeface.defaultFromStyle(1));
                                                }
                                                break;
                                            case 20:
                                                String attributeValue115 = attributeSet.getAttributeValue(i19);
                                                button.setTextAppearance(com.mbridge.msdk.foundation.controller.c.m().c(), com.mbridge.msdk.dycreator.a.b.a().d("R.style." + attributeValue115.substring(attributeValue115.indexOf("/") + 1)));
                                                break;
                                            case 21:
                                                attributeValue11 = attributeSet.getAttributeValue(i19);
                                                if (!TextUtils.isEmpty(attributeValue11)) {
                                                    str2 = b.f43673a.get(attributeValue11.substring(8));
                                                    if (!TextUtils.isEmpty(str2)) {
                                                        button.setTag(str2);
                                                    }
                                                }
                                                break;
                                            case 22:
                                                button.setGravity(1);
                                                break;
                                        }
                                    }
                                } else {
                                    i13 = iB;
                                    i14 = iB2;
                                }
                                iB = i13;
                                iB2 = i14;
                                break;
                            case 5:
                                int iB5 = com.mbridge.msdk.dycreator.a.b.a().b(attributeSet.getAttributeValue(i19));
                                view.setPadding(iB5, iB5, iB5, iB5);
                                i11 = attributeCount;
                                i12 = iB;
                                iB = i12;
                                if (view instanceof EditText) {
                                    i13 = iB;
                                    i14 = iB2;
                                    if (view instanceof Button) {
                                        if (view instanceof TextView) {
                                            if (view instanceof ImageView) {
                                                if (view instanceof ListView) {
                                                    if (view instanceof GridView) {
                                                        if (view instanceof ScrollView) {
                                                            if (view instanceof PlayerView) {
                                                                if (view instanceof MBHorizontalScrollView) {
                                                                    if (view instanceof LinearLayout) {
                                                                        linearLayout = (LinearLayout) view;
                                                                        if (AnonymousClass1.f43672a[cVar.ordinal()] != 12) {
                                                                            if ("horizontal".equalsIgnoreCase(attributeSet.getAttributeValue(i19))) {
                                                                                linearLayout.setOrientation(0);
                                                                            } else {
                                                                                linearLayout.setOrientation(1);
                                                                            }
                                                                            break;
                                                                        }
                                                                    } else if (view instanceof RelativeLayout) {
                                                                        relativeLayout = (RelativeLayout) view;
                                                                        if (AnonymousClass1.f43672a[cVar.ordinal()] != 22) {
                                                                            relativeLayout.setGravity(com.mbridge.msdk.dycreator.a.b.a().c(attributeSet.getAttributeValue(i19)));
                                                                            break;
                                                                        }
                                                                    } else if (view instanceof FrameLayout) {
                                                                    }
                                                                    iB = i13;
                                                                    iB2 = i14;
                                                                }
                                                                break;
                                                            } else {
                                                                playerView = (PlayerView) view;
                                                                if (AnonymousClass1.f43672a[cVar.ordinal()] == 12) {
                                                                    if ("horizontal".equalsIgnoreCase(attributeSet.getAttributeValue(i19))) {
                                                                        playerView.setOrientation(0);
                                                                    } else {
                                                                        playerView.setOrientation(1);
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    } else {
                                                        gridView = (GridView) view;
                                                        i15 = AnonymousClass1.f43672a[cVar.ordinal()];
                                                        if (i15 != 1) {
                                                            switch (i15) {
                                                                case 23:
                                                                    gridView.setVerticalSpacing(e.a(com.mbridge.msdk.foundation.controller.c.m().c(), com.mbridge.msdk.dycreator.a.b.a().b(attributeSet.getAttributeValue(i19))));
                                                                    break;
                                                                case 24:
                                                                    gridView.setNumColumns(attributeSet.getAttributeIntValue(i19, 2));
                                                                    break;
                                                                case 25:
                                                                    gridView.setMotionEventSplittingEnabled(!attributeSet.getAttributeValue(i19).equals("false"));
                                                                    break;
                                                                case 26:
                                                                    gridView.setCacheColorHint(com.mbridge.msdk.dycreator.a.b.a().a(attributeSet.getAttributeValue(i19)));
                                                                    break;
                                                                case 27:
                                                                    gridView.setHorizontalSpacing(e.a(com.mbridge.msdk.foundation.controller.c.m().c(), com.mbridge.msdk.dycreator.a.b.a().b(attributeSet.getAttributeValue(i19))));
                                                                    break;
                                                            }
                                                        } else {
                                                            attributeValue = attributeSet.getAttributeValue(i19);
                                                            if (attributeValue.startsWith("@+id/")) {
                                                                gridView.setId(attributeValue.substring(5).hashCode());
                                                            }
                                                        }
                                                    }
                                                } else {
                                                    listView = (ListView) view;
                                                    i16 = AnonymousClass1.f43672a[cVar.ordinal()];
                                                    if (i16 != 25) {
                                                        listView.setMotionEventSplittingEnabled(!attributeSet.getAttributeValue(i19).equals("false"));
                                                    } else if (i16 != 26) {
                                                        switch (i16) {
                                                            case 34:
                                                                attributeValue2 = attributeSet.getAttributeValue(i19);
                                                                if (!TextUtils.isEmpty(attributeValue2)) {
                                                                    listView.setDivider(null);
                                                                }
                                                                break;
                                                            case 35:
                                                                attributeValue3 = attributeSet.getAttributeValue(i19);
                                                                if (!TextUtils.isEmpty(attributeValue3)) {
                                                                    if (attributeValue3.equals(DevicePublicKeyStringDef.NONE)) {
                                                                        z11 = false;
                                                                        listView.setVerticalScrollBarEnabled(false);
                                                                    } else {
                                                                        z11 = false;
                                                                    }
                                                                    if (attributeValue3.equals("false")) {
                                                                        listView.setScrollbarFadingEnabled(z11);
                                                                    }
                                                                }
                                                                break;
                                                            case 36:
                                                                attributeValue4 = attributeSet.getAttributeValue(i19);
                                                                if (!TextUtils.isEmpty(attributeValue4)) {
                                                                    listView.setSelector(com.mbridge.msdk.dycreator.a.b.a().a(attributeValue4));
                                                                }
                                                                break;
                                                        }
                                                    } else {
                                                        listView.setCacheColorHint(com.mbridge.msdk.dycreator.a.b.a().a(attributeSet.getAttributeValue(i19)));
                                                    }
                                                }
                                            } else {
                                                imageView = (ImageView) view;
                                                i17 = AnonymousClass1.f43672a[cVar.ordinal()];
                                                if (i17 != 32) {
                                                    com.mbridge.msdk.dycreator.a.b.a().a(attributeSet.getAttributeValue(i19), imageView);
                                                } else if (i17 != 33) {
                                                    attributeValue5 = attributeSet.getAttributeValue(i19);
                                                    if (!TextUtils.isEmpty(attributeValue5)) {
                                                        if (attributeValue5.equals("fitXY")) {
                                                            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                                                        } else if (attributeValue5.equals("centerInside")) {
                                                            imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                                                        } else if (attributeValue5.equals("centerCrop")) {
                                                            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                                                        } else if (attributeValue5.equals("fitStart")) {
                                                            imageView.setScaleType(ImageView.ScaleType.FIT_START);
                                                        }
                                                    }
                                                }
                                            }
                                        } else {
                                            textView = (TextView) view;
                                            i18 = AnonymousClass1.f43672a[cVar.ordinal()];
                                            switch (i18) {
                                                case 13:
                                                    attributeValue6 = attributeSet.getAttributeValue(i19);
                                                    if (!TextUtils.isEmpty(attributeValue6)) {
                                                        if (attributeValue6.startsWith("@string/")) {
                                                            textView.setText(com.mbridge.msdk.dycreator.a.b.a().e(attributeSet.getAttributeValue(i19)));
                                                        } else {
                                                            textView.setText(attributeValue6);
                                                        }
                                                    }
                                                    break;
                                                case 14:
                                                    attributeValue7 = attributeSet.getAttributeValue(i19);
                                                    if (!TextUtils.isEmpty(attributeValue7)) {
                                                        if (attributeValue7.equals(TtmlNode.END)) {
                                                            textView.setEllipsize(TextUtils.TruncateAt.END);
                                                        }
                                                        if (attributeValue7.equals("start")) {
                                                            textView.setEllipsize(TextUtils.TruncateAt.START);
                                                        }
                                                        if (attributeValue7.equals("middle")) {
                                                            textView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
                                                        }
                                                        if (attributeValue7.equals("marquee")) {
                                                            textView.setEllipsize(TextUtils.TruncateAt.MARQUEE);
                                                        }
                                                    }
                                                    break;
                                                case 15:
                                                    textView.setHorizontalFadingEdgeEnabled(attributeSet.getAttributeBooleanValue(i19, false));
                                                    break;
                                                case 16:
                                                    textView.setHorizontallyScrolling(attributeSet.getAttributeBooleanValue(i19, false));
                                                    break;
                                                case 17:
                                                    textView.setTextColor(com.mbridge.msdk.dycreator.a.b.a().a(attributeSet.getAttributeValue(i19)));
                                                    break;
                                                case 18:
                                                    attributeValue8 = attributeSet.getAttributeValue(i19);
                                                    if (!TextUtils.isEmpty(attributeValue8)) {
                                                        textView.setTextSize(com.mbridge.msdk.dycreator.a.b.a().b(attributeValue8));
                                                    }
                                                    break;
                                                case 19:
                                                    if (TtmlNode.BOLD.equalsIgnoreCase(attributeSet.getAttributeValue(i19))) {
                                                        textView.setTypeface(Typeface.defaultFromStyle(1));
                                                    }
                                                    break;
                                                case 20:
                                                    String attributeValue116 = attributeSet.getAttributeValue(i19);
                                                    com.mbridge.msdk.dycreator.a.b.a().d("R.style." + attributeValue116.substring(attributeValue116.indexOf("/") + 1));
                                                    break;
                                                case 21:
                                                    attributeValue9 = attributeSet.getAttributeValue(i19);
                                                    if (TextUtils.isEmpty(attributeValue9)) {
                                                        str = b.f43673a.get(attributeValue9.substring(8));
                                                        if (TextUtils.isEmpty(str)) {
                                                            textView.setTag(str);
                                                        }
                                                    }
                                                    break;
                                                case 22:
                                                    textView.setGravity(com.mbridge.msdk.dycreator.a.b.a().c(attributeSet.getAttributeValue(i19)));
                                                    break;
                                                default:
                                                    switch (i18) {
                                                        case 28:
                                                            textView.setSingleLine(attributeSet.getAttributeBooleanValue(i19, false));
                                                            break;
                                                        case VungleException.INCORRECT_DEFAULT_API_USAGE /* 29 */:
                                                            textView.setLines(attributeSet.getAttributeIntValue(i19, 1));
                                                            break;
                                                        case 30:
                                                            String attributeValue117 = attributeSet.getAttributeValue(i19);
                                                            if (attributeValue117.startsWith("@drawable/")) {
                                                            }
                                                            if (!TextUtils.isEmpty(strSubstring)) {
                                                                textView.setCompoundDrawables(textView.getResources().getDrawable(v.a(com.mbridge.msdk.foundation.controller.c.m().c(), strSubstring, "drawable")), null, null, null);
                                                            }
                                                            break;
                                                        case VungleException.WEB_CRASH /* 31 */:
                                                            textView.setCompoundDrawablePadding(com.mbridge.msdk.dycreator.a.b.a().b(attributeSet.getAttributeValue(i19)));
                                                            break;
                                                    }
                                                    break;
                                            }
                                        }
                                    } else {
                                        button = (Button) view;
                                        switch (AnonymousClass1.f43672a[cVar.ordinal()]) {
                                            case 13:
                                                button.setText(com.mbridge.msdk.dycreator.a.b.a().e(attributeSet.getAttributeValue(i19)));
                                                break;
                                            case 14:
                                                if (attributeSet.getAttributeBooleanValue(i19, false)) {
                                                    button.setFocusable(true);
                                                    button.setFocusableInTouchMode(true);
                                                    button.setSingleLine(true);
                                                    button.setEllipsize(TextUtils.TruncateAt.MARQUEE);
                                                    button.setMarqueeRepeatLimit(1000);
                                                    button.setSingleLine();
                                                    button.setHorizontallyScrolling(true);
                                                    button.requestFocus();
                                                }
                                                break;
                                            case 15:
                                                button.setHorizontalFadingEdgeEnabled(attributeSet.getAttributeBooleanValue(i19, false));
                                                break;
                                            case 16:
                                                button.setHorizontallyScrolling(attributeSet.getAttributeBooleanValue(i19, false));
                                                break;
                                            case 17:
                                                button.setTextColor(com.mbridge.msdk.dycreator.a.b.a().a(attributeSet.getAttributeValue(i19)));
                                                break;
                                            case 18:
                                                attributeValue10 = attributeSet.getAttributeValue(i19);
                                                if (!TextUtils.isEmpty(attributeValue10)) {
                                                    button.setTextSize(com.mbridge.msdk.dycreator.a.b.a().b(attributeValue10));
                                                }
                                                break;
                                            case 19:
                                                if (TtmlNode.BOLD.equalsIgnoreCase(attributeSet.getAttributeValue(i19))) {
                                                    button.setTypeface(Typeface.defaultFromStyle(1));
                                                }
                                                break;
                                            case 20:
                                                String attributeValue118 = attributeSet.getAttributeValue(i19);
                                                button.setTextAppearance(com.mbridge.msdk.foundation.controller.c.m().c(), com.mbridge.msdk.dycreator.a.b.a().d("R.style." + attributeValue118.substring(attributeValue118.indexOf("/") + 1)));
                                                break;
                                            case 21:
                                                attributeValue11 = attributeSet.getAttributeValue(i19);
                                                if (!TextUtils.isEmpty(attributeValue11)) {
                                                    str2 = b.f43673a.get(attributeValue11.substring(8));
                                                    if (!TextUtils.isEmpty(str2)) {
                                                        button.setTag(str2);
                                                    }
                                                }
                                                break;
                                            case 22:
                                                button.setGravity(1);
                                                break;
                                        }
                                    }
                                } else {
                                    i13 = iB;
                                    i14 = iB2;
                                }
                                iB = i13;
                                iB2 = i14;
                                break;
                            case 6:
                                iB4 = com.mbridge.msdk.dycreator.a.b.a().b(attributeSet.getAttributeValue(i19));
                                view.setPadding(iB, iB4, iB2, iB3);
                                i11 = attributeCount;
                                if (view instanceof EditText) {
                                    i13 = iB;
                                    i14 = iB2;
                                    if (view instanceof Button) {
                                        if (view instanceof TextView) {
                                            if (view instanceof ImageView) {
                                                if (view instanceof ListView) {
                                                    if (view instanceof GridView) {
                                                        if (view instanceof ScrollView) {
                                                            if (view instanceof PlayerView) {
                                                                if (view instanceof MBHorizontalScrollView) {
                                                                    if (view instanceof LinearLayout) {
                                                                        linearLayout = (LinearLayout) view;
                                                                        if (AnonymousClass1.f43672a[cVar.ordinal()] != 12) {
                                                                            if ("horizontal".equalsIgnoreCase(attributeSet.getAttributeValue(i19))) {
                                                                                linearLayout.setOrientation(0);
                                                                            } else {
                                                                                linearLayout.setOrientation(1);
                                                                            }
                                                                            break;
                                                                        }
                                                                    } else if (view instanceof RelativeLayout) {
                                                                        relativeLayout = (RelativeLayout) view;
                                                                        if (AnonymousClass1.f43672a[cVar.ordinal()] != 22) {
                                                                            relativeLayout.setGravity(com.mbridge.msdk.dycreator.a.b.a().c(attributeSet.getAttributeValue(i19)));
                                                                            break;
                                                                        }
                                                                    } else if (view instanceof FrameLayout) {
                                                                    }
                                                                    iB = i13;
                                                                    iB2 = i14;
                                                                }
                                                                break;
                                                            } else {
                                                                playerView = (PlayerView) view;
                                                                if (AnonymousClass1.f43672a[cVar.ordinal()] == 12) {
                                                                    if ("horizontal".equalsIgnoreCase(attributeSet.getAttributeValue(i19))) {
                                                                        playerView.setOrientation(0);
                                                                    } else {
                                                                        playerView.setOrientation(1);
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    } else {
                                                        gridView = (GridView) view;
                                                        i15 = AnonymousClass1.f43672a[cVar.ordinal()];
                                                        if (i15 != 1) {
                                                            switch (i15) {
                                                                case 23:
                                                                    gridView.setVerticalSpacing(e.a(com.mbridge.msdk.foundation.controller.c.m().c(), com.mbridge.msdk.dycreator.a.b.a().b(attributeSet.getAttributeValue(i19))));
                                                                    break;
                                                                case 24:
                                                                    gridView.setNumColumns(attributeSet.getAttributeIntValue(i19, 2));
                                                                    break;
                                                                case 25:
                                                                    gridView.setMotionEventSplittingEnabled(!attributeSet.getAttributeValue(i19).equals("false"));
                                                                    break;
                                                                case 26:
                                                                    gridView.setCacheColorHint(com.mbridge.msdk.dycreator.a.b.a().a(attributeSet.getAttributeValue(i19)));
                                                                    break;
                                                                case 27:
                                                                    gridView.setHorizontalSpacing(e.a(com.mbridge.msdk.foundation.controller.c.m().c(), com.mbridge.msdk.dycreator.a.b.a().b(attributeSet.getAttributeValue(i19))));
                                                                    break;
                                                            }
                                                        } else {
                                                            attributeValue = attributeSet.getAttributeValue(i19);
                                                            if (attributeValue.startsWith("@+id/")) {
                                                                gridView.setId(attributeValue.substring(5).hashCode());
                                                            }
                                                        }
                                                    }
                                                } else {
                                                    listView = (ListView) view;
                                                    i16 = AnonymousClass1.f43672a[cVar.ordinal()];
                                                    if (i16 != 25) {
                                                        listView.setMotionEventSplittingEnabled(!attributeSet.getAttributeValue(i19).equals("false"));
                                                    } else if (i16 != 26) {
                                                        switch (i16) {
                                                            case 34:
                                                                attributeValue2 = attributeSet.getAttributeValue(i19);
                                                                if (!TextUtils.isEmpty(attributeValue2)) {
                                                                    listView.setDivider(null);
                                                                }
                                                                break;
                                                            case 35:
                                                                attributeValue3 = attributeSet.getAttributeValue(i19);
                                                                if (!TextUtils.isEmpty(attributeValue3)) {
                                                                    if (attributeValue3.equals(DevicePublicKeyStringDef.NONE)) {
                                                                        z11 = false;
                                                                        listView.setVerticalScrollBarEnabled(false);
                                                                    } else {
                                                                        z11 = false;
                                                                    }
                                                                    if (attributeValue3.equals("false")) {
                                                                        listView.setScrollbarFadingEnabled(z11);
                                                                    }
                                                                }
                                                                break;
                                                            case 36:
                                                                attributeValue4 = attributeSet.getAttributeValue(i19);
                                                                if (!TextUtils.isEmpty(attributeValue4)) {
                                                                    listView.setSelector(com.mbridge.msdk.dycreator.a.b.a().a(attributeValue4));
                                                                }
                                                                break;
                                                        }
                                                    } else {
                                                        listView.setCacheColorHint(com.mbridge.msdk.dycreator.a.b.a().a(attributeSet.getAttributeValue(i19)));
                                                    }
                                                }
                                            } else {
                                                imageView = (ImageView) view;
                                                i17 = AnonymousClass1.f43672a[cVar.ordinal()];
                                                if (i17 != 32) {
                                                    com.mbridge.msdk.dycreator.a.b.a().a(attributeSet.getAttributeValue(i19), imageView);
                                                } else if (i17 != 33) {
                                                    attributeValue5 = attributeSet.getAttributeValue(i19);
                                                    if (!TextUtils.isEmpty(attributeValue5)) {
                                                        if (attributeValue5.equals("fitXY")) {
                                                            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                                                        } else if (attributeValue5.equals("centerInside")) {
                                                            imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                                                        } else if (attributeValue5.equals("centerCrop")) {
                                                            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                                                        } else if (attributeValue5.equals("fitStart")) {
                                                            imageView.setScaleType(ImageView.ScaleType.FIT_START);
                                                        }
                                                    }
                                                }
                                            }
                                        } else {
                                            textView = (TextView) view;
                                            i18 = AnonymousClass1.f43672a[cVar.ordinal()];
                                            switch (i18) {
                                                case 13:
                                                    attributeValue6 = attributeSet.getAttributeValue(i19);
                                                    if (!TextUtils.isEmpty(attributeValue6)) {
                                                        if (attributeValue6.startsWith("@string/")) {
                                                            textView.setText(com.mbridge.msdk.dycreator.a.b.a().e(attributeSet.getAttributeValue(i19)));
                                                        } else {
                                                            textView.setText(attributeValue6);
                                                        }
                                                    }
                                                    break;
                                                case 14:
                                                    attributeValue7 = attributeSet.getAttributeValue(i19);
                                                    if (!TextUtils.isEmpty(attributeValue7)) {
                                                        if (attributeValue7.equals(TtmlNode.END)) {
                                                            textView.setEllipsize(TextUtils.TruncateAt.END);
                                                        }
                                                        if (attributeValue7.equals("start")) {
                                                            textView.setEllipsize(TextUtils.TruncateAt.START);
                                                        }
                                                        if (attributeValue7.equals("middle")) {
                                                            textView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
                                                        }
                                                        if (attributeValue7.equals("marquee")) {
                                                            textView.setEllipsize(TextUtils.TruncateAt.MARQUEE);
                                                        }
                                                    }
                                                    break;
                                                case 15:
                                                    textView.setHorizontalFadingEdgeEnabled(attributeSet.getAttributeBooleanValue(i19, false));
                                                    break;
                                                case 16:
                                                    textView.setHorizontallyScrolling(attributeSet.getAttributeBooleanValue(i19, false));
                                                    break;
                                                case 17:
                                                    textView.setTextColor(com.mbridge.msdk.dycreator.a.b.a().a(attributeSet.getAttributeValue(i19)));
                                                    break;
                                                case 18:
                                                    attributeValue8 = attributeSet.getAttributeValue(i19);
                                                    if (!TextUtils.isEmpty(attributeValue8)) {
                                                        textView.setTextSize(com.mbridge.msdk.dycreator.a.b.a().b(attributeValue8));
                                                    }
                                                    break;
                                                case 19:
                                                    if (TtmlNode.BOLD.equalsIgnoreCase(attributeSet.getAttributeValue(i19))) {
                                                        textView.setTypeface(Typeface.defaultFromStyle(1));
                                                    }
                                                    break;
                                                case 20:
                                                    String attributeValue119 = attributeSet.getAttributeValue(i19);
                                                    com.mbridge.msdk.dycreator.a.b.a().d("R.style." + attributeValue119.substring(attributeValue119.indexOf("/") + 1));
                                                    break;
                                                case 21:
                                                    attributeValue9 = attributeSet.getAttributeValue(i19);
                                                    if (TextUtils.isEmpty(attributeValue9)) {
                                                        str = b.f43673a.get(attributeValue9.substring(8));
                                                        if (TextUtils.isEmpty(str)) {
                                                            textView.setTag(str);
                                                        }
                                                    }
                                                    break;
                                                case 22:
                                                    textView.setGravity(com.mbridge.msdk.dycreator.a.b.a().c(attributeSet.getAttributeValue(i19)));
                                                    break;
                                                default:
                                                    switch (i18) {
                                                        case 28:
                                                            textView.setSingleLine(attributeSet.getAttributeBooleanValue(i19, false));
                                                            break;
                                                        case VungleException.INCORRECT_DEFAULT_API_USAGE /* 29 */:
                                                            textView.setLines(attributeSet.getAttributeIntValue(i19, 1));
                                                            break;
                                                        case 30:
                                                            String attributeValue1110 = attributeSet.getAttributeValue(i19);
                                                            if (attributeValue1110.startsWith("@drawable/")) {
                                                            }
                                                            if (!TextUtils.isEmpty(strSubstring)) {
                                                                textView.setCompoundDrawables(textView.getResources().getDrawable(v.a(com.mbridge.msdk.foundation.controller.c.m().c(), strSubstring, "drawable")), null, null, null);
                                                            }
                                                            break;
                                                        case VungleException.WEB_CRASH /* 31 */:
                                                            textView.setCompoundDrawablePadding(com.mbridge.msdk.dycreator.a.b.a().b(attributeSet.getAttributeValue(i19)));
                                                            break;
                                                    }
                                                    break;
                                            }
                                        }
                                    } else {
                                        button = (Button) view;
                                        switch (AnonymousClass1.f43672a[cVar.ordinal()]) {
                                            case 13:
                                                button.setText(com.mbridge.msdk.dycreator.a.b.a().e(attributeSet.getAttributeValue(i19)));
                                                break;
                                            case 14:
                                                if (attributeSet.getAttributeBooleanValue(i19, false)) {
                                                    button.setFocusable(true);
                                                    button.setFocusableInTouchMode(true);
                                                    button.setSingleLine(true);
                                                    button.setEllipsize(TextUtils.TruncateAt.MARQUEE);
                                                    button.setMarqueeRepeatLimit(1000);
                                                    button.setSingleLine();
                                                    button.setHorizontallyScrolling(true);
                                                    button.requestFocus();
                                                }
                                                break;
                                            case 15:
                                                button.setHorizontalFadingEdgeEnabled(attributeSet.getAttributeBooleanValue(i19, false));
                                                break;
                                            case 16:
                                                button.setHorizontallyScrolling(attributeSet.getAttributeBooleanValue(i19, false));
                                                break;
                                            case 17:
                                                button.setTextColor(com.mbridge.msdk.dycreator.a.b.a().a(attributeSet.getAttributeValue(i19)));
                                                break;
                                            case 18:
                                                attributeValue10 = attributeSet.getAttributeValue(i19);
                                                if (!TextUtils.isEmpty(attributeValue10)) {
                                                    button.setTextSize(com.mbridge.msdk.dycreator.a.b.a().b(attributeValue10));
                                                }
                                                break;
                                            case 19:
                                                if (TtmlNode.BOLD.equalsIgnoreCase(attributeSet.getAttributeValue(i19))) {
                                                    button.setTypeface(Typeface.defaultFromStyle(1));
                                                }
                                                break;
                                            case 20:
                                                String attributeValue1111 = attributeSet.getAttributeValue(i19);
                                                button.setTextAppearance(com.mbridge.msdk.foundation.controller.c.m().c(), com.mbridge.msdk.dycreator.a.b.a().d("R.style." + attributeValue1111.substring(attributeValue1111.indexOf("/") + 1)));
                                                break;
                                            case 21:
                                                attributeValue11 = attributeSet.getAttributeValue(i19);
                                                if (!TextUtils.isEmpty(attributeValue11)) {
                                                    str2 = b.f43673a.get(attributeValue11.substring(8));
                                                    if (!TextUtils.isEmpty(str2)) {
                                                        button.setTag(str2);
                                                    }
                                                }
                                                break;
                                            case 22:
                                                button.setGravity(1);
                                                break;
                                        }
                                    }
                                } else {
                                    i13 = iB;
                                    i14 = iB2;
                                }
                                iB = i13;
                                iB2 = i14;
                                break;
                            case 7:
                                iB3 = com.mbridge.msdk.dycreator.a.b.a().b(attributeSet.getAttributeValue(i19));
                                view.setPadding(iB, iB4, iB2, iB3);
                                i11 = attributeCount;
                                if (view instanceof EditText) {
                                    i13 = iB;
                                    i14 = iB2;
                                    if (view instanceof Button) {
                                        if (view instanceof TextView) {
                                            if (view instanceof ImageView) {
                                                if (view instanceof ListView) {
                                                    if (view instanceof GridView) {
                                                        if (view instanceof ScrollView) {
                                                            if (view instanceof PlayerView) {
                                                                if (view instanceof MBHorizontalScrollView) {
                                                                    if (view instanceof LinearLayout) {
                                                                        linearLayout = (LinearLayout) view;
                                                                        if (AnonymousClass1.f43672a[cVar.ordinal()] != 12) {
                                                                            if ("horizontal".equalsIgnoreCase(attributeSet.getAttributeValue(i19))) {
                                                                                linearLayout.setOrientation(0);
                                                                            } else {
                                                                                linearLayout.setOrientation(1);
                                                                            }
                                                                            break;
                                                                        }
                                                                    } else if (view instanceof RelativeLayout) {
                                                                        relativeLayout = (RelativeLayout) view;
                                                                        if (AnonymousClass1.f43672a[cVar.ordinal()] != 22) {
                                                                            relativeLayout.setGravity(com.mbridge.msdk.dycreator.a.b.a().c(attributeSet.getAttributeValue(i19)));
                                                                            break;
                                                                        }
                                                                    } else if (view instanceof FrameLayout) {
                                                                    }
                                                                    iB = i13;
                                                                    iB2 = i14;
                                                                }
                                                                break;
                                                            } else {
                                                                playerView = (PlayerView) view;
                                                                if (AnonymousClass1.f43672a[cVar.ordinal()] == 12) {
                                                                    if ("horizontal".equalsIgnoreCase(attributeSet.getAttributeValue(i19))) {
                                                                        playerView.setOrientation(0);
                                                                    } else {
                                                                        playerView.setOrientation(1);
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    } else {
                                                        gridView = (GridView) view;
                                                        i15 = AnonymousClass1.f43672a[cVar.ordinal()];
                                                        if (i15 != 1) {
                                                            switch (i15) {
                                                                case 23:
                                                                    gridView.setVerticalSpacing(e.a(com.mbridge.msdk.foundation.controller.c.m().c(), com.mbridge.msdk.dycreator.a.b.a().b(attributeSet.getAttributeValue(i19))));
                                                                    break;
                                                                case 24:
                                                                    gridView.setNumColumns(attributeSet.getAttributeIntValue(i19, 2));
                                                                    break;
                                                                case 25:
                                                                    gridView.setMotionEventSplittingEnabled(!attributeSet.getAttributeValue(i19).equals("false"));
                                                                    break;
                                                                case 26:
                                                                    gridView.setCacheColorHint(com.mbridge.msdk.dycreator.a.b.a().a(attributeSet.getAttributeValue(i19)));
                                                                    break;
                                                                case 27:
                                                                    gridView.setHorizontalSpacing(e.a(com.mbridge.msdk.foundation.controller.c.m().c(), com.mbridge.msdk.dycreator.a.b.a().b(attributeSet.getAttributeValue(i19))));
                                                                    break;
                                                            }
                                                        } else {
                                                            attributeValue = attributeSet.getAttributeValue(i19);
                                                            if (attributeValue.startsWith("@+id/")) {
                                                                gridView.setId(attributeValue.substring(5).hashCode());
                                                            }
                                                        }
                                                    }
                                                } else {
                                                    listView = (ListView) view;
                                                    i16 = AnonymousClass1.f43672a[cVar.ordinal()];
                                                    if (i16 != 25) {
                                                        listView.setMotionEventSplittingEnabled(!attributeSet.getAttributeValue(i19).equals("false"));
                                                    } else if (i16 != 26) {
                                                        switch (i16) {
                                                            case 34:
                                                                attributeValue2 = attributeSet.getAttributeValue(i19);
                                                                if (!TextUtils.isEmpty(attributeValue2)) {
                                                                    listView.setDivider(null);
                                                                }
                                                                break;
                                                            case 35:
                                                                attributeValue3 = attributeSet.getAttributeValue(i19);
                                                                if (!TextUtils.isEmpty(attributeValue3)) {
                                                                    if (attributeValue3.equals(DevicePublicKeyStringDef.NONE)) {
                                                                        z11 = false;
                                                                        listView.setVerticalScrollBarEnabled(false);
                                                                    } else {
                                                                        z11 = false;
                                                                    }
                                                                    if (attributeValue3.equals("false")) {
                                                                        listView.setScrollbarFadingEnabled(z11);
                                                                    }
                                                                }
                                                                break;
                                                            case 36:
                                                                attributeValue4 = attributeSet.getAttributeValue(i19);
                                                                if (!TextUtils.isEmpty(attributeValue4)) {
                                                                    listView.setSelector(com.mbridge.msdk.dycreator.a.b.a().a(attributeValue4));
                                                                }
                                                                break;
                                                        }
                                                    } else {
                                                        listView.setCacheColorHint(com.mbridge.msdk.dycreator.a.b.a().a(attributeSet.getAttributeValue(i19)));
                                                    }
                                                }
                                            } else {
                                                imageView = (ImageView) view;
                                                i17 = AnonymousClass1.f43672a[cVar.ordinal()];
                                                if (i17 != 32) {
                                                    com.mbridge.msdk.dycreator.a.b.a().a(attributeSet.getAttributeValue(i19), imageView);
                                                } else if (i17 != 33) {
                                                    attributeValue5 = attributeSet.getAttributeValue(i19);
                                                    if (!TextUtils.isEmpty(attributeValue5)) {
                                                        if (attributeValue5.equals("fitXY")) {
                                                            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                                                        } else if (attributeValue5.equals("centerInside")) {
                                                            imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                                                        } else if (attributeValue5.equals("centerCrop")) {
                                                            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                                                        } else if (attributeValue5.equals("fitStart")) {
                                                            imageView.setScaleType(ImageView.ScaleType.FIT_START);
                                                        }
                                                    }
                                                }
                                            }
                                        } else {
                                            textView = (TextView) view;
                                            i18 = AnonymousClass1.f43672a[cVar.ordinal()];
                                            switch (i18) {
                                                case 13:
                                                    attributeValue6 = attributeSet.getAttributeValue(i19);
                                                    if (!TextUtils.isEmpty(attributeValue6)) {
                                                        if (attributeValue6.startsWith("@string/")) {
                                                            textView.setText(com.mbridge.msdk.dycreator.a.b.a().e(attributeSet.getAttributeValue(i19)));
                                                        } else {
                                                            textView.setText(attributeValue6);
                                                        }
                                                    }
                                                    break;
                                                case 14:
                                                    attributeValue7 = attributeSet.getAttributeValue(i19);
                                                    if (!TextUtils.isEmpty(attributeValue7)) {
                                                        if (attributeValue7.equals(TtmlNode.END)) {
                                                            textView.setEllipsize(TextUtils.TruncateAt.END);
                                                        }
                                                        if (attributeValue7.equals("start")) {
                                                            textView.setEllipsize(TextUtils.TruncateAt.START);
                                                        }
                                                        if (attributeValue7.equals("middle")) {
                                                            textView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
                                                        }
                                                        if (attributeValue7.equals("marquee")) {
                                                            textView.setEllipsize(TextUtils.TruncateAt.MARQUEE);
                                                        }
                                                    }
                                                    break;
                                                case 15:
                                                    textView.setHorizontalFadingEdgeEnabled(attributeSet.getAttributeBooleanValue(i19, false));
                                                    break;
                                                case 16:
                                                    textView.setHorizontallyScrolling(attributeSet.getAttributeBooleanValue(i19, false));
                                                    break;
                                                case 17:
                                                    textView.setTextColor(com.mbridge.msdk.dycreator.a.b.a().a(attributeSet.getAttributeValue(i19)));
                                                    break;
                                                case 18:
                                                    attributeValue8 = attributeSet.getAttributeValue(i19);
                                                    if (!TextUtils.isEmpty(attributeValue8)) {
                                                        textView.setTextSize(com.mbridge.msdk.dycreator.a.b.a().b(attributeValue8));
                                                    }
                                                    break;
                                                case 19:
                                                    if (TtmlNode.BOLD.equalsIgnoreCase(attributeSet.getAttributeValue(i19))) {
                                                        textView.setTypeface(Typeface.defaultFromStyle(1));
                                                    }
                                                    break;
                                                case 20:
                                                    String attributeValue1112 = attributeSet.getAttributeValue(i19);
                                                    com.mbridge.msdk.dycreator.a.b.a().d("R.style." + attributeValue1112.substring(attributeValue1112.indexOf("/") + 1));
                                                    break;
                                                case 21:
                                                    attributeValue9 = attributeSet.getAttributeValue(i19);
                                                    if (TextUtils.isEmpty(attributeValue9)) {
                                                        str = b.f43673a.get(attributeValue9.substring(8));
                                                        if (TextUtils.isEmpty(str)) {
                                                            textView.setTag(str);
                                                        }
                                                    }
                                                    break;
                                                case 22:
                                                    textView.setGravity(com.mbridge.msdk.dycreator.a.b.a().c(attributeSet.getAttributeValue(i19)));
                                                    break;
                                                default:
                                                    switch (i18) {
                                                        case 28:
                                                            textView.setSingleLine(attributeSet.getAttributeBooleanValue(i19, false));
                                                            break;
                                                        case VungleException.INCORRECT_DEFAULT_API_USAGE /* 29 */:
                                                            textView.setLines(attributeSet.getAttributeIntValue(i19, 1));
                                                            break;
                                                        case 30:
                                                            String attributeValue1113 = attributeSet.getAttributeValue(i19);
                                                            if (attributeValue1113.startsWith("@drawable/")) {
                                                            }
                                                            if (!TextUtils.isEmpty(strSubstring)) {
                                                                textView.setCompoundDrawables(textView.getResources().getDrawable(v.a(com.mbridge.msdk.foundation.controller.c.m().c(), strSubstring, "drawable")), null, null, null);
                                                            }
                                                            break;
                                                        case VungleException.WEB_CRASH /* 31 */:
                                                            textView.setCompoundDrawablePadding(com.mbridge.msdk.dycreator.a.b.a().b(attributeSet.getAttributeValue(i19)));
                                                            break;
                                                    }
                                                    break;
                                            }
                                        }
                                    } else {
                                        button = (Button) view;
                                        switch (AnonymousClass1.f43672a[cVar.ordinal()]) {
                                            case 13:
                                                button.setText(com.mbridge.msdk.dycreator.a.b.a().e(attributeSet.getAttributeValue(i19)));
                                                break;
                                            case 14:
                                                if (attributeSet.getAttributeBooleanValue(i19, false)) {
                                                    button.setFocusable(true);
                                                    button.setFocusableInTouchMode(true);
                                                    button.setSingleLine(true);
                                                    button.setEllipsize(TextUtils.TruncateAt.MARQUEE);
                                                    button.setMarqueeRepeatLimit(1000);
                                                    button.setSingleLine();
                                                    button.setHorizontallyScrolling(true);
                                                    button.requestFocus();
                                                }
                                                break;
                                            case 15:
                                                button.setHorizontalFadingEdgeEnabled(attributeSet.getAttributeBooleanValue(i19, false));
                                                break;
                                            case 16:
                                                button.setHorizontallyScrolling(attributeSet.getAttributeBooleanValue(i19, false));
                                                break;
                                            case 17:
                                                button.setTextColor(com.mbridge.msdk.dycreator.a.b.a().a(attributeSet.getAttributeValue(i19)));
                                                break;
                                            case 18:
                                                attributeValue10 = attributeSet.getAttributeValue(i19);
                                                if (!TextUtils.isEmpty(attributeValue10)) {
                                                    button.setTextSize(com.mbridge.msdk.dycreator.a.b.a().b(attributeValue10));
                                                }
                                                break;
                                            case 19:
                                                if (TtmlNode.BOLD.equalsIgnoreCase(attributeSet.getAttributeValue(i19))) {
                                                    button.setTypeface(Typeface.defaultFromStyle(1));
                                                }
                                                break;
                                            case 20:
                                                String attributeValue1114 = attributeSet.getAttributeValue(i19);
                                                button.setTextAppearance(com.mbridge.msdk.foundation.controller.c.m().c(), com.mbridge.msdk.dycreator.a.b.a().d("R.style." + attributeValue1114.substring(attributeValue1114.indexOf("/") + 1)));
                                                break;
                                            case 21:
                                                attributeValue11 = attributeSet.getAttributeValue(i19);
                                                if (!TextUtils.isEmpty(attributeValue11)) {
                                                    str2 = b.f43673a.get(attributeValue11.substring(8));
                                                    if (!TextUtils.isEmpty(str2)) {
                                                        button.setTag(str2);
                                                    }
                                                }
                                                break;
                                            case 22:
                                                button.setGravity(1);
                                                break;
                                        }
                                    }
                                } else {
                                    i13 = iB;
                                    i14 = iB2;
                                }
                                iB = i13;
                                iB2 = i14;
                                break;
                            case 8:
                                iB = com.mbridge.msdk.dycreator.a.b.a().b(attributeSet.getAttributeValue(i19));
                                view.setPadding(iB, iB4, iB2, iB3);
                                i11 = attributeCount;
                                if (view instanceof EditText) {
                                    i13 = iB;
                                    i14 = iB2;
                                    if (view instanceof Button) {
                                        if (view instanceof TextView) {
                                            if (view instanceof ImageView) {
                                                if (view instanceof ListView) {
                                                    if (view instanceof GridView) {
                                                        if (view instanceof ScrollView) {
                                                            if (view instanceof PlayerView) {
                                                                if (view instanceof MBHorizontalScrollView) {
                                                                    if (view instanceof LinearLayout) {
                                                                        linearLayout = (LinearLayout) view;
                                                                        if (AnonymousClass1.f43672a[cVar.ordinal()] != 12) {
                                                                            if ("horizontal".equalsIgnoreCase(attributeSet.getAttributeValue(i19))) {
                                                                                linearLayout.setOrientation(0);
                                                                            } else {
                                                                                linearLayout.setOrientation(1);
                                                                            }
                                                                            break;
                                                                        }
                                                                    } else if (view instanceof RelativeLayout) {
                                                                        relativeLayout = (RelativeLayout) view;
                                                                        if (AnonymousClass1.f43672a[cVar.ordinal()] != 22) {
                                                                            relativeLayout.setGravity(com.mbridge.msdk.dycreator.a.b.a().c(attributeSet.getAttributeValue(i19)));
                                                                            break;
                                                                        }
                                                                    } else if (view instanceof FrameLayout) {
                                                                    }
                                                                    iB = i13;
                                                                    iB2 = i14;
                                                                }
                                                                break;
                                                            } else {
                                                                playerView = (PlayerView) view;
                                                                if (AnonymousClass1.f43672a[cVar.ordinal()] == 12) {
                                                                    if ("horizontal".equalsIgnoreCase(attributeSet.getAttributeValue(i19))) {
                                                                        playerView.setOrientation(0);
                                                                    } else {
                                                                        playerView.setOrientation(1);
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    } else {
                                                        gridView = (GridView) view;
                                                        i15 = AnonymousClass1.f43672a[cVar.ordinal()];
                                                        if (i15 != 1) {
                                                            switch (i15) {
                                                                case 23:
                                                                    gridView.setVerticalSpacing(e.a(com.mbridge.msdk.foundation.controller.c.m().c(), com.mbridge.msdk.dycreator.a.b.a().b(attributeSet.getAttributeValue(i19))));
                                                                    break;
                                                                case 24:
                                                                    gridView.setNumColumns(attributeSet.getAttributeIntValue(i19, 2));
                                                                    break;
                                                                case 25:
                                                                    gridView.setMotionEventSplittingEnabled(!attributeSet.getAttributeValue(i19).equals("false"));
                                                                    break;
                                                                case 26:
                                                                    gridView.setCacheColorHint(com.mbridge.msdk.dycreator.a.b.a().a(attributeSet.getAttributeValue(i19)));
                                                                    break;
                                                                case 27:
                                                                    gridView.setHorizontalSpacing(e.a(com.mbridge.msdk.foundation.controller.c.m().c(), com.mbridge.msdk.dycreator.a.b.a().b(attributeSet.getAttributeValue(i19))));
                                                                    break;
                                                            }
                                                        } else {
                                                            attributeValue = attributeSet.getAttributeValue(i19);
                                                            if (attributeValue.startsWith("@+id/")) {
                                                                gridView.setId(attributeValue.substring(5).hashCode());
                                                            }
                                                        }
                                                    }
                                                } else {
                                                    listView = (ListView) view;
                                                    i16 = AnonymousClass1.f43672a[cVar.ordinal()];
                                                    if (i16 != 25) {
                                                        listView.setMotionEventSplittingEnabled(!attributeSet.getAttributeValue(i19).equals("false"));
                                                    } else if (i16 != 26) {
                                                        switch (i16) {
                                                            case 34:
                                                                attributeValue2 = attributeSet.getAttributeValue(i19);
                                                                if (!TextUtils.isEmpty(attributeValue2)) {
                                                                    listView.setDivider(null);
                                                                }
                                                                break;
                                                            case 35:
                                                                attributeValue3 = attributeSet.getAttributeValue(i19);
                                                                if (!TextUtils.isEmpty(attributeValue3)) {
                                                                    if (attributeValue3.equals(DevicePublicKeyStringDef.NONE)) {
                                                                        z11 = false;
                                                                        listView.setVerticalScrollBarEnabled(false);
                                                                    } else {
                                                                        z11 = false;
                                                                    }
                                                                    if (attributeValue3.equals("false")) {
                                                                        listView.setScrollbarFadingEnabled(z11);
                                                                    }
                                                                }
                                                                break;
                                                            case 36:
                                                                attributeValue4 = attributeSet.getAttributeValue(i19);
                                                                if (!TextUtils.isEmpty(attributeValue4)) {
                                                                    listView.setSelector(com.mbridge.msdk.dycreator.a.b.a().a(attributeValue4));
                                                                }
                                                                break;
                                                        }
                                                    } else {
                                                        listView.setCacheColorHint(com.mbridge.msdk.dycreator.a.b.a().a(attributeSet.getAttributeValue(i19)));
                                                    }
                                                }
                                            } else {
                                                imageView = (ImageView) view;
                                                i17 = AnonymousClass1.f43672a[cVar.ordinal()];
                                                if (i17 != 32) {
                                                    com.mbridge.msdk.dycreator.a.b.a().a(attributeSet.getAttributeValue(i19), imageView);
                                                } else if (i17 != 33) {
                                                    attributeValue5 = attributeSet.getAttributeValue(i19);
                                                    if (!TextUtils.isEmpty(attributeValue5)) {
                                                        if (attributeValue5.equals("fitXY")) {
                                                            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                                                        } else if (attributeValue5.equals("centerInside")) {
                                                            imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                                                        } else if (attributeValue5.equals("centerCrop")) {
                                                            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                                                        } else if (attributeValue5.equals("fitStart")) {
                                                            imageView.setScaleType(ImageView.ScaleType.FIT_START);
                                                        }
                                                    }
                                                }
                                            }
                                        } else {
                                            textView = (TextView) view;
                                            i18 = AnonymousClass1.f43672a[cVar.ordinal()];
                                            switch (i18) {
                                                case 13:
                                                    attributeValue6 = attributeSet.getAttributeValue(i19);
                                                    if (!TextUtils.isEmpty(attributeValue6)) {
                                                        if (attributeValue6.startsWith("@string/")) {
                                                            textView.setText(com.mbridge.msdk.dycreator.a.b.a().e(attributeSet.getAttributeValue(i19)));
                                                        } else {
                                                            textView.setText(attributeValue6);
                                                        }
                                                    }
                                                    break;
                                                case 14:
                                                    attributeValue7 = attributeSet.getAttributeValue(i19);
                                                    if (!TextUtils.isEmpty(attributeValue7)) {
                                                        if (attributeValue7.equals(TtmlNode.END)) {
                                                            textView.setEllipsize(TextUtils.TruncateAt.END);
                                                        }
                                                        if (attributeValue7.equals("start")) {
                                                            textView.setEllipsize(TextUtils.TruncateAt.START);
                                                        }
                                                        if (attributeValue7.equals("middle")) {
                                                            textView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
                                                        }
                                                        if (attributeValue7.equals("marquee")) {
                                                            textView.setEllipsize(TextUtils.TruncateAt.MARQUEE);
                                                        }
                                                    }
                                                    break;
                                                case 15:
                                                    textView.setHorizontalFadingEdgeEnabled(attributeSet.getAttributeBooleanValue(i19, false));
                                                    break;
                                                case 16:
                                                    textView.setHorizontallyScrolling(attributeSet.getAttributeBooleanValue(i19, false));
                                                    break;
                                                case 17:
                                                    textView.setTextColor(com.mbridge.msdk.dycreator.a.b.a().a(attributeSet.getAttributeValue(i19)));
                                                    break;
                                                case 18:
                                                    attributeValue8 = attributeSet.getAttributeValue(i19);
                                                    if (!TextUtils.isEmpty(attributeValue8)) {
                                                        textView.setTextSize(com.mbridge.msdk.dycreator.a.b.a().b(attributeValue8));
                                                    }
                                                    break;
                                                case 19:
                                                    if (TtmlNode.BOLD.equalsIgnoreCase(attributeSet.getAttributeValue(i19))) {
                                                        textView.setTypeface(Typeface.defaultFromStyle(1));
                                                    }
                                                    break;
                                                case 20:
                                                    String attributeValue1115 = attributeSet.getAttributeValue(i19);
                                                    com.mbridge.msdk.dycreator.a.b.a().d("R.style." + attributeValue1115.substring(attributeValue1115.indexOf("/") + 1));
                                                    break;
                                                case 21:
                                                    attributeValue9 = attributeSet.getAttributeValue(i19);
                                                    if (TextUtils.isEmpty(attributeValue9)) {
                                                        str = b.f43673a.get(attributeValue9.substring(8));
                                                        if (TextUtils.isEmpty(str)) {
                                                            textView.setTag(str);
                                                        }
                                                    }
                                                    break;
                                                case 22:
                                                    textView.setGravity(com.mbridge.msdk.dycreator.a.b.a().c(attributeSet.getAttributeValue(i19)));
                                                    break;
                                                default:
                                                    switch (i18) {
                                                        case 28:
                                                            textView.setSingleLine(attributeSet.getAttributeBooleanValue(i19, false));
                                                            break;
                                                        case VungleException.INCORRECT_DEFAULT_API_USAGE /* 29 */:
                                                            textView.setLines(attributeSet.getAttributeIntValue(i19, 1));
                                                            break;
                                                        case 30:
                                                            String attributeValue1116 = attributeSet.getAttributeValue(i19);
                                                            if (attributeValue1116.startsWith("@drawable/")) {
                                                            }
                                                            if (!TextUtils.isEmpty(strSubstring)) {
                                                                textView.setCompoundDrawables(textView.getResources().getDrawable(v.a(com.mbridge.msdk.foundation.controller.c.m().c(), strSubstring, "drawable")), null, null, null);
                                                            }
                                                            break;
                                                        case VungleException.WEB_CRASH /* 31 */:
                                                            textView.setCompoundDrawablePadding(com.mbridge.msdk.dycreator.a.b.a().b(attributeSet.getAttributeValue(i19)));
                                                            break;
                                                    }
                                                    break;
                                            }
                                        }
                                    } else {
                                        button = (Button) view;
                                        switch (AnonymousClass1.f43672a[cVar.ordinal()]) {
                                            case 13:
                                                button.setText(com.mbridge.msdk.dycreator.a.b.a().e(attributeSet.getAttributeValue(i19)));
                                                break;
                                            case 14:
                                                if (attributeSet.getAttributeBooleanValue(i19, false)) {
                                                    button.setFocusable(true);
                                                    button.setFocusableInTouchMode(true);
                                                    button.setSingleLine(true);
                                                    button.setEllipsize(TextUtils.TruncateAt.MARQUEE);
                                                    button.setMarqueeRepeatLimit(1000);
                                                    button.setSingleLine();
                                                    button.setHorizontallyScrolling(true);
                                                    button.requestFocus();
                                                }
                                                break;
                                            case 15:
                                                button.setHorizontalFadingEdgeEnabled(attributeSet.getAttributeBooleanValue(i19, false));
                                                break;
                                            case 16:
                                                button.setHorizontallyScrolling(attributeSet.getAttributeBooleanValue(i19, false));
                                                break;
                                            case 17:
                                                button.setTextColor(com.mbridge.msdk.dycreator.a.b.a().a(attributeSet.getAttributeValue(i19)));
                                                break;
                                            case 18:
                                                attributeValue10 = attributeSet.getAttributeValue(i19);
                                                if (!TextUtils.isEmpty(attributeValue10)) {
                                                    button.setTextSize(com.mbridge.msdk.dycreator.a.b.a().b(attributeValue10));
                                                }
                                                break;
                                            case 19:
                                                if (TtmlNode.BOLD.equalsIgnoreCase(attributeSet.getAttributeValue(i19))) {
                                                    button.setTypeface(Typeface.defaultFromStyle(1));
                                                }
                                                break;
                                            case 20:
                                                String attributeValue1117 = attributeSet.getAttributeValue(i19);
                                                button.setTextAppearance(com.mbridge.msdk.foundation.controller.c.m().c(), com.mbridge.msdk.dycreator.a.b.a().d("R.style." + attributeValue1117.substring(attributeValue1117.indexOf("/") + 1)));
                                                break;
                                            case 21:
                                                attributeValue11 = attributeSet.getAttributeValue(i19);
                                                if (!TextUtils.isEmpty(attributeValue11)) {
                                                    str2 = b.f43673a.get(attributeValue11.substring(8));
                                                    if (!TextUtils.isEmpty(str2)) {
                                                        button.setTag(str2);
                                                    }
                                                }
                                                break;
                                            case 22:
                                                button.setGravity(1);
                                                break;
                                        }
                                    }
                                } else {
                                    i13 = iB;
                                    i14 = iB2;
                                }
                                iB = i13;
                                iB2 = i14;
                                break;
                            case 9:
                                iB2 = com.mbridge.msdk.dycreator.a.b.a().b(attributeSet.getAttributeValue(i19));
                                view.setPadding(iB, iB4, iB2, iB3);
                                i11 = attributeCount;
                                if (view instanceof EditText) {
                                    i13 = iB;
                                    i14 = iB2;
                                    if (view instanceof Button) {
                                        if (view instanceof TextView) {
                                            if (view instanceof ImageView) {
                                                if (view instanceof ListView) {
                                                    if (view instanceof GridView) {
                                                        if (view instanceof ScrollView) {
                                                            if (view instanceof PlayerView) {
                                                                if (view instanceof MBHorizontalScrollView) {
                                                                    if (view instanceof LinearLayout) {
                                                                        linearLayout = (LinearLayout) view;
                                                                        if (AnonymousClass1.f43672a[cVar.ordinal()] != 12) {
                                                                            if ("horizontal".equalsIgnoreCase(attributeSet.getAttributeValue(i19))) {
                                                                                linearLayout.setOrientation(0);
                                                                            } else {
                                                                                linearLayout.setOrientation(1);
                                                                            }
                                                                            break;
                                                                        }
                                                                    } else if (view instanceof RelativeLayout) {
                                                                        relativeLayout = (RelativeLayout) view;
                                                                        if (AnonymousClass1.f43672a[cVar.ordinal()] != 22) {
                                                                            relativeLayout.setGravity(com.mbridge.msdk.dycreator.a.b.a().c(attributeSet.getAttributeValue(i19)));
                                                                            break;
                                                                        }
                                                                    } else if (view instanceof FrameLayout) {
                                                                    }
                                                                    iB = i13;
                                                                    iB2 = i14;
                                                                }
                                                                break;
                                                            } else {
                                                                playerView = (PlayerView) view;
                                                                if (AnonymousClass1.f43672a[cVar.ordinal()] == 12) {
                                                                    if ("horizontal".equalsIgnoreCase(attributeSet.getAttributeValue(i19))) {
                                                                        playerView.setOrientation(0);
                                                                    } else {
                                                                        playerView.setOrientation(1);
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    } else {
                                                        gridView = (GridView) view;
                                                        i15 = AnonymousClass1.f43672a[cVar.ordinal()];
                                                        if (i15 != 1) {
                                                            switch (i15) {
                                                                case 23:
                                                                    gridView.setVerticalSpacing(e.a(com.mbridge.msdk.foundation.controller.c.m().c(), com.mbridge.msdk.dycreator.a.b.a().b(attributeSet.getAttributeValue(i19))));
                                                                    break;
                                                                case 24:
                                                                    gridView.setNumColumns(attributeSet.getAttributeIntValue(i19, 2));
                                                                    break;
                                                                case 25:
                                                                    gridView.setMotionEventSplittingEnabled(!attributeSet.getAttributeValue(i19).equals("false"));
                                                                    break;
                                                                case 26:
                                                                    gridView.setCacheColorHint(com.mbridge.msdk.dycreator.a.b.a().a(attributeSet.getAttributeValue(i19)));
                                                                    break;
                                                                case 27:
                                                                    gridView.setHorizontalSpacing(e.a(com.mbridge.msdk.foundation.controller.c.m().c(), com.mbridge.msdk.dycreator.a.b.a().b(attributeSet.getAttributeValue(i19))));
                                                                    break;
                                                            }
                                                        } else {
                                                            attributeValue = attributeSet.getAttributeValue(i19);
                                                            if (attributeValue.startsWith("@+id/")) {
                                                                gridView.setId(attributeValue.substring(5).hashCode());
                                                            }
                                                        }
                                                    }
                                                } else {
                                                    listView = (ListView) view;
                                                    i16 = AnonymousClass1.f43672a[cVar.ordinal()];
                                                    if (i16 != 25) {
                                                        listView.setMotionEventSplittingEnabled(!attributeSet.getAttributeValue(i19).equals("false"));
                                                    } else if (i16 != 26) {
                                                        switch (i16) {
                                                            case 34:
                                                                attributeValue2 = attributeSet.getAttributeValue(i19);
                                                                if (!TextUtils.isEmpty(attributeValue2)) {
                                                                    listView.setDivider(null);
                                                                }
                                                                break;
                                                            case 35:
                                                                attributeValue3 = attributeSet.getAttributeValue(i19);
                                                                if (!TextUtils.isEmpty(attributeValue3)) {
                                                                    if (attributeValue3.equals(DevicePublicKeyStringDef.NONE)) {
                                                                        z11 = false;
                                                                        listView.setVerticalScrollBarEnabled(false);
                                                                    } else {
                                                                        z11 = false;
                                                                    }
                                                                    if (attributeValue3.equals("false")) {
                                                                        listView.setScrollbarFadingEnabled(z11);
                                                                    }
                                                                }
                                                                break;
                                                            case 36:
                                                                attributeValue4 = attributeSet.getAttributeValue(i19);
                                                                if (!TextUtils.isEmpty(attributeValue4)) {
                                                                    listView.setSelector(com.mbridge.msdk.dycreator.a.b.a().a(attributeValue4));
                                                                }
                                                                break;
                                                        }
                                                    } else {
                                                        listView.setCacheColorHint(com.mbridge.msdk.dycreator.a.b.a().a(attributeSet.getAttributeValue(i19)));
                                                    }
                                                }
                                            } else {
                                                imageView = (ImageView) view;
                                                i17 = AnonymousClass1.f43672a[cVar.ordinal()];
                                                if (i17 != 32) {
                                                    com.mbridge.msdk.dycreator.a.b.a().a(attributeSet.getAttributeValue(i19), imageView);
                                                } else if (i17 != 33) {
                                                    attributeValue5 = attributeSet.getAttributeValue(i19);
                                                    if (!TextUtils.isEmpty(attributeValue5)) {
                                                        if (attributeValue5.equals("fitXY")) {
                                                            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                                                        } else if (attributeValue5.equals("centerInside")) {
                                                            imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                                                        } else if (attributeValue5.equals("centerCrop")) {
                                                            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                                                        } else if (attributeValue5.equals("fitStart")) {
                                                            imageView.setScaleType(ImageView.ScaleType.FIT_START);
                                                        }
                                                    }
                                                }
                                            }
                                        } else {
                                            textView = (TextView) view;
                                            i18 = AnonymousClass1.f43672a[cVar.ordinal()];
                                            switch (i18) {
                                                case 13:
                                                    attributeValue6 = attributeSet.getAttributeValue(i19);
                                                    if (!TextUtils.isEmpty(attributeValue6)) {
                                                        if (attributeValue6.startsWith("@string/")) {
                                                            textView.setText(com.mbridge.msdk.dycreator.a.b.a().e(attributeSet.getAttributeValue(i19)));
                                                        } else {
                                                            textView.setText(attributeValue6);
                                                        }
                                                    }
                                                    break;
                                                case 14:
                                                    attributeValue7 = attributeSet.getAttributeValue(i19);
                                                    if (!TextUtils.isEmpty(attributeValue7)) {
                                                        if (attributeValue7.equals(TtmlNode.END)) {
                                                            textView.setEllipsize(TextUtils.TruncateAt.END);
                                                        }
                                                        if (attributeValue7.equals("start")) {
                                                            textView.setEllipsize(TextUtils.TruncateAt.START);
                                                        }
                                                        if (attributeValue7.equals("middle")) {
                                                            textView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
                                                        }
                                                        if (attributeValue7.equals("marquee")) {
                                                            textView.setEllipsize(TextUtils.TruncateAt.MARQUEE);
                                                        }
                                                    }
                                                    break;
                                                case 15:
                                                    textView.setHorizontalFadingEdgeEnabled(attributeSet.getAttributeBooleanValue(i19, false));
                                                    break;
                                                case 16:
                                                    textView.setHorizontallyScrolling(attributeSet.getAttributeBooleanValue(i19, false));
                                                    break;
                                                case 17:
                                                    textView.setTextColor(com.mbridge.msdk.dycreator.a.b.a().a(attributeSet.getAttributeValue(i19)));
                                                    break;
                                                case 18:
                                                    attributeValue8 = attributeSet.getAttributeValue(i19);
                                                    if (!TextUtils.isEmpty(attributeValue8)) {
                                                        textView.setTextSize(com.mbridge.msdk.dycreator.a.b.a().b(attributeValue8));
                                                    }
                                                    break;
                                                case 19:
                                                    if (TtmlNode.BOLD.equalsIgnoreCase(attributeSet.getAttributeValue(i19))) {
                                                        textView.setTypeface(Typeface.defaultFromStyle(1));
                                                    }
                                                    break;
                                                case 20:
                                                    String attributeValue1118 = attributeSet.getAttributeValue(i19);
                                                    com.mbridge.msdk.dycreator.a.b.a().d("R.style." + attributeValue1118.substring(attributeValue1118.indexOf("/") + 1));
                                                    break;
                                                case 21:
                                                    attributeValue9 = attributeSet.getAttributeValue(i19);
                                                    if (TextUtils.isEmpty(attributeValue9)) {
                                                        str = b.f43673a.get(attributeValue9.substring(8));
                                                        if (TextUtils.isEmpty(str)) {
                                                            textView.setTag(str);
                                                        }
                                                    }
                                                    break;
                                                case 22:
                                                    textView.setGravity(com.mbridge.msdk.dycreator.a.b.a().c(attributeSet.getAttributeValue(i19)));
                                                    break;
                                                default:
                                                    switch (i18) {
                                                        case 28:
                                                            textView.setSingleLine(attributeSet.getAttributeBooleanValue(i19, false));
                                                            break;
                                                        case VungleException.INCORRECT_DEFAULT_API_USAGE /* 29 */:
                                                            textView.setLines(attributeSet.getAttributeIntValue(i19, 1));
                                                            break;
                                                        case 30:
                                                            String attributeValue1119 = attributeSet.getAttributeValue(i19);
                                                            if (attributeValue1119.startsWith("@drawable/")) {
                                                            }
                                                            if (!TextUtils.isEmpty(strSubstring)) {
                                                                textView.setCompoundDrawables(textView.getResources().getDrawable(v.a(com.mbridge.msdk.foundation.controller.c.m().c(), strSubstring, "drawable")), null, null, null);
                                                            }
                                                            break;
                                                        case VungleException.WEB_CRASH /* 31 */:
                                                            textView.setCompoundDrawablePadding(com.mbridge.msdk.dycreator.a.b.a().b(attributeSet.getAttributeValue(i19)));
                                                            break;
                                                    }
                                                    break;
                                            }
                                        }
                                    } else {
                                        button = (Button) view;
                                        switch (AnonymousClass1.f43672a[cVar.ordinal()]) {
                                            case 13:
                                                button.setText(com.mbridge.msdk.dycreator.a.b.a().e(attributeSet.getAttributeValue(i19)));
                                                break;
                                            case 14:
                                                if (attributeSet.getAttributeBooleanValue(i19, false)) {
                                                    button.setFocusable(true);
                                                    button.setFocusableInTouchMode(true);
                                                    button.setSingleLine(true);
                                                    button.setEllipsize(TextUtils.TruncateAt.MARQUEE);
                                                    button.setMarqueeRepeatLimit(1000);
                                                    button.setSingleLine();
                                                    button.setHorizontallyScrolling(true);
                                                    button.requestFocus();
                                                }
                                                break;
                                            case 15:
                                                button.setHorizontalFadingEdgeEnabled(attributeSet.getAttributeBooleanValue(i19, false));
                                                break;
                                            case 16:
                                                button.setHorizontallyScrolling(attributeSet.getAttributeBooleanValue(i19, false));
                                                break;
                                            case 17:
                                                button.setTextColor(com.mbridge.msdk.dycreator.a.b.a().a(attributeSet.getAttributeValue(i19)));
                                                break;
                                            case 18:
                                                attributeValue10 = attributeSet.getAttributeValue(i19);
                                                if (!TextUtils.isEmpty(attributeValue10)) {
                                                    button.setTextSize(com.mbridge.msdk.dycreator.a.b.a().b(attributeValue10));
                                                }
                                                break;
                                            case 19:
                                                if (TtmlNode.BOLD.equalsIgnoreCase(attributeSet.getAttributeValue(i19))) {
                                                    button.setTypeface(Typeface.defaultFromStyle(1));
                                                }
                                                break;
                                            case 20:
                                                String attributeValue11110 = attributeSet.getAttributeValue(i19);
                                                button.setTextAppearance(com.mbridge.msdk.foundation.controller.c.m().c(), com.mbridge.msdk.dycreator.a.b.a().d("R.style." + attributeValue11110.substring(attributeValue11110.indexOf("/") + 1)));
                                                break;
                                            case 21:
                                                attributeValue11 = attributeSet.getAttributeValue(i19);
                                                if (!TextUtils.isEmpty(attributeValue11)) {
                                                    str2 = b.f43673a.get(attributeValue11.substring(8));
                                                    if (!TextUtils.isEmpty(str2)) {
                                                        button.setTag(str2);
                                                    }
                                                }
                                                break;
                                            case 22:
                                                button.setGravity(1);
                                                break;
                                        }
                                    }
                                } else {
                                    i13 = iB;
                                    i14 = iB2;
                                }
                                iB = i13;
                                iB2 = i14;
                                break;
                            case 10:
                                view.setPadding(com.mbridge.msdk.dycreator.a.b.a().b(attributeSet.getAttributeValue(i19)), iB4, iB2, iB3);
                                i11 = attributeCount;
                                i12 = iB;
                                iB = i12;
                                if (view instanceof EditText) {
                                    i13 = iB;
                                    i14 = iB2;
                                    if (view instanceof Button) {
                                        if (view instanceof TextView) {
                                            if (view instanceof ImageView) {
                                                if (view instanceof ListView) {
                                                    if (view instanceof GridView) {
                                                        if (view instanceof ScrollView) {
                                                            if (view instanceof PlayerView) {
                                                                if (view instanceof MBHorizontalScrollView) {
                                                                    if (view instanceof LinearLayout) {
                                                                        linearLayout = (LinearLayout) view;
                                                                        if (AnonymousClass1.f43672a[cVar.ordinal()] != 12) {
                                                                            if ("horizontal".equalsIgnoreCase(attributeSet.getAttributeValue(i19))) {
                                                                                linearLayout.setOrientation(0);
                                                                            } else {
                                                                                linearLayout.setOrientation(1);
                                                                            }
                                                                            break;
                                                                        }
                                                                    } else if (view instanceof RelativeLayout) {
                                                                        relativeLayout = (RelativeLayout) view;
                                                                        if (AnonymousClass1.f43672a[cVar.ordinal()] != 22) {
                                                                            relativeLayout.setGravity(com.mbridge.msdk.dycreator.a.b.a().c(attributeSet.getAttributeValue(i19)));
                                                                            break;
                                                                        }
                                                                    } else if (view instanceof FrameLayout) {
                                                                    }
                                                                    iB = i13;
                                                                    iB2 = i14;
                                                                }
                                                                break;
                                                            } else {
                                                                playerView = (PlayerView) view;
                                                                if (AnonymousClass1.f43672a[cVar.ordinal()] == 12) {
                                                                    if ("horizontal".equalsIgnoreCase(attributeSet.getAttributeValue(i19))) {
                                                                        playerView.setOrientation(0);
                                                                    } else {
                                                                        playerView.setOrientation(1);
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    } else {
                                                        gridView = (GridView) view;
                                                        i15 = AnonymousClass1.f43672a[cVar.ordinal()];
                                                        if (i15 != 1) {
                                                            switch (i15) {
                                                                case 23:
                                                                    gridView.setVerticalSpacing(e.a(com.mbridge.msdk.foundation.controller.c.m().c(), com.mbridge.msdk.dycreator.a.b.a().b(attributeSet.getAttributeValue(i19))));
                                                                    break;
                                                                case 24:
                                                                    gridView.setNumColumns(attributeSet.getAttributeIntValue(i19, 2));
                                                                    break;
                                                                case 25:
                                                                    gridView.setMotionEventSplittingEnabled(!attributeSet.getAttributeValue(i19).equals("false"));
                                                                    break;
                                                                case 26:
                                                                    gridView.setCacheColorHint(com.mbridge.msdk.dycreator.a.b.a().a(attributeSet.getAttributeValue(i19)));
                                                                    break;
                                                                case 27:
                                                                    gridView.setHorizontalSpacing(e.a(com.mbridge.msdk.foundation.controller.c.m().c(), com.mbridge.msdk.dycreator.a.b.a().b(attributeSet.getAttributeValue(i19))));
                                                                    break;
                                                            }
                                                        } else {
                                                            attributeValue = attributeSet.getAttributeValue(i19);
                                                            if (attributeValue.startsWith("@+id/")) {
                                                                gridView.setId(attributeValue.substring(5).hashCode());
                                                            }
                                                        }
                                                    }
                                                } else {
                                                    listView = (ListView) view;
                                                    i16 = AnonymousClass1.f43672a[cVar.ordinal()];
                                                    if (i16 != 25) {
                                                        listView.setMotionEventSplittingEnabled(!attributeSet.getAttributeValue(i19).equals("false"));
                                                    } else if (i16 != 26) {
                                                        switch (i16) {
                                                            case 34:
                                                                attributeValue2 = attributeSet.getAttributeValue(i19);
                                                                if (!TextUtils.isEmpty(attributeValue2)) {
                                                                    listView.setDivider(null);
                                                                }
                                                                break;
                                                            case 35:
                                                                attributeValue3 = attributeSet.getAttributeValue(i19);
                                                                if (!TextUtils.isEmpty(attributeValue3)) {
                                                                    if (attributeValue3.equals(DevicePublicKeyStringDef.NONE)) {
                                                                        z11 = false;
                                                                        listView.setVerticalScrollBarEnabled(false);
                                                                    } else {
                                                                        z11 = false;
                                                                    }
                                                                    if (attributeValue3.equals("false")) {
                                                                        listView.setScrollbarFadingEnabled(z11);
                                                                    }
                                                                }
                                                                break;
                                                            case 36:
                                                                attributeValue4 = attributeSet.getAttributeValue(i19);
                                                                if (!TextUtils.isEmpty(attributeValue4)) {
                                                                    listView.setSelector(com.mbridge.msdk.dycreator.a.b.a().a(attributeValue4));
                                                                }
                                                                break;
                                                        }
                                                    } else {
                                                        listView.setCacheColorHint(com.mbridge.msdk.dycreator.a.b.a().a(attributeSet.getAttributeValue(i19)));
                                                    }
                                                }
                                            } else {
                                                imageView = (ImageView) view;
                                                i17 = AnonymousClass1.f43672a[cVar.ordinal()];
                                                if (i17 != 32) {
                                                    com.mbridge.msdk.dycreator.a.b.a().a(attributeSet.getAttributeValue(i19), imageView);
                                                } else if (i17 != 33) {
                                                    attributeValue5 = attributeSet.getAttributeValue(i19);
                                                    if (!TextUtils.isEmpty(attributeValue5)) {
                                                        if (attributeValue5.equals("fitXY")) {
                                                            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                                                        } else if (attributeValue5.equals("centerInside")) {
                                                            imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                                                        } else if (attributeValue5.equals("centerCrop")) {
                                                            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                                                        } else if (attributeValue5.equals("fitStart")) {
                                                            imageView.setScaleType(ImageView.ScaleType.FIT_START);
                                                        }
                                                    }
                                                }
                                            }
                                        } else {
                                            textView = (TextView) view;
                                            i18 = AnonymousClass1.f43672a[cVar.ordinal()];
                                            switch (i18) {
                                                case 13:
                                                    attributeValue6 = attributeSet.getAttributeValue(i19);
                                                    if (!TextUtils.isEmpty(attributeValue6)) {
                                                        if (attributeValue6.startsWith("@string/")) {
                                                            textView.setText(com.mbridge.msdk.dycreator.a.b.a().e(attributeSet.getAttributeValue(i19)));
                                                        } else {
                                                            textView.setText(attributeValue6);
                                                        }
                                                    }
                                                    break;
                                                case 14:
                                                    attributeValue7 = attributeSet.getAttributeValue(i19);
                                                    if (!TextUtils.isEmpty(attributeValue7)) {
                                                        if (attributeValue7.equals(TtmlNode.END)) {
                                                            textView.setEllipsize(TextUtils.TruncateAt.END);
                                                        }
                                                        if (attributeValue7.equals("start")) {
                                                            textView.setEllipsize(TextUtils.TruncateAt.START);
                                                        }
                                                        if (attributeValue7.equals("middle")) {
                                                            textView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
                                                        }
                                                        if (attributeValue7.equals("marquee")) {
                                                            textView.setEllipsize(TextUtils.TruncateAt.MARQUEE);
                                                        }
                                                    }
                                                    break;
                                                case 15:
                                                    textView.setHorizontalFadingEdgeEnabled(attributeSet.getAttributeBooleanValue(i19, false));
                                                    break;
                                                case 16:
                                                    textView.setHorizontallyScrolling(attributeSet.getAttributeBooleanValue(i19, false));
                                                    break;
                                                case 17:
                                                    textView.setTextColor(com.mbridge.msdk.dycreator.a.b.a().a(attributeSet.getAttributeValue(i19)));
                                                    break;
                                                case 18:
                                                    attributeValue8 = attributeSet.getAttributeValue(i19);
                                                    if (!TextUtils.isEmpty(attributeValue8)) {
                                                        textView.setTextSize(com.mbridge.msdk.dycreator.a.b.a().b(attributeValue8));
                                                    }
                                                    break;
                                                case 19:
                                                    if (TtmlNode.BOLD.equalsIgnoreCase(attributeSet.getAttributeValue(i19))) {
                                                        textView.setTypeface(Typeface.defaultFromStyle(1));
                                                    }
                                                    break;
                                                case 20:
                                                    String attributeValue11111 = attributeSet.getAttributeValue(i19);
                                                    com.mbridge.msdk.dycreator.a.b.a().d("R.style." + attributeValue11111.substring(attributeValue11111.indexOf("/") + 1));
                                                    break;
                                                case 21:
                                                    attributeValue9 = attributeSet.getAttributeValue(i19);
                                                    if (TextUtils.isEmpty(attributeValue9)) {
                                                        str = b.f43673a.get(attributeValue9.substring(8));
                                                        if (TextUtils.isEmpty(str)) {
                                                            textView.setTag(str);
                                                        }
                                                    }
                                                    break;
                                                case 22:
                                                    textView.setGravity(com.mbridge.msdk.dycreator.a.b.a().c(attributeSet.getAttributeValue(i19)));
                                                    break;
                                                default:
                                                    switch (i18) {
                                                        case 28:
                                                            textView.setSingleLine(attributeSet.getAttributeBooleanValue(i19, false));
                                                            break;
                                                        case VungleException.INCORRECT_DEFAULT_API_USAGE /* 29 */:
                                                            textView.setLines(attributeSet.getAttributeIntValue(i19, 1));
                                                            break;
                                                        case 30:
                                                            String attributeValue11112 = attributeSet.getAttributeValue(i19);
                                                            if (attributeValue11112.startsWith("@drawable/")) {
                                                            }
                                                            if (!TextUtils.isEmpty(strSubstring)) {
                                                                textView.setCompoundDrawables(textView.getResources().getDrawable(v.a(com.mbridge.msdk.foundation.controller.c.m().c(), strSubstring, "drawable")), null, null, null);
                                                            }
                                                            break;
                                                        case VungleException.WEB_CRASH /* 31 */:
                                                            textView.setCompoundDrawablePadding(com.mbridge.msdk.dycreator.a.b.a().b(attributeSet.getAttributeValue(i19)));
                                                            break;
                                                    }
                                                    break;
                                            }
                                        }
                                    } else {
                                        button = (Button) view;
                                        switch (AnonymousClass1.f43672a[cVar.ordinal()]) {
                                            case 13:
                                                button.setText(com.mbridge.msdk.dycreator.a.b.a().e(attributeSet.getAttributeValue(i19)));
                                                break;
                                            case 14:
                                                if (attributeSet.getAttributeBooleanValue(i19, false)) {
                                                    button.setFocusable(true);
                                                    button.setFocusableInTouchMode(true);
                                                    button.setSingleLine(true);
                                                    button.setEllipsize(TextUtils.TruncateAt.MARQUEE);
                                                    button.setMarqueeRepeatLimit(1000);
                                                    button.setSingleLine();
                                                    button.setHorizontallyScrolling(true);
                                                    button.requestFocus();
                                                }
                                                break;
                                            case 15:
                                                button.setHorizontalFadingEdgeEnabled(attributeSet.getAttributeBooleanValue(i19, false));
                                                break;
                                            case 16:
                                                button.setHorizontallyScrolling(attributeSet.getAttributeBooleanValue(i19, false));
                                                break;
                                            case 17:
                                                button.setTextColor(com.mbridge.msdk.dycreator.a.b.a().a(attributeSet.getAttributeValue(i19)));
                                                break;
                                            case 18:
                                                attributeValue10 = attributeSet.getAttributeValue(i19);
                                                if (!TextUtils.isEmpty(attributeValue10)) {
                                                    button.setTextSize(com.mbridge.msdk.dycreator.a.b.a().b(attributeValue10));
                                                }
                                                break;
                                            case 19:
                                                if (TtmlNode.BOLD.equalsIgnoreCase(attributeSet.getAttributeValue(i19))) {
                                                    button.setTypeface(Typeface.defaultFromStyle(1));
                                                }
                                                break;
                                            case 20:
                                                String attributeValue11113 = attributeSet.getAttributeValue(i19);
                                                button.setTextAppearance(com.mbridge.msdk.foundation.controller.c.m().c(), com.mbridge.msdk.dycreator.a.b.a().d("R.style." + attributeValue11113.substring(attributeValue11113.indexOf("/") + 1)));
                                                break;
                                            case 21:
                                                attributeValue11 = attributeSet.getAttributeValue(i19);
                                                if (!TextUtils.isEmpty(attributeValue11)) {
                                                    str2 = b.f43673a.get(attributeValue11.substring(8));
                                                    if (!TextUtils.isEmpty(str2)) {
                                                        button.setTag(str2);
                                                    }
                                                }
                                                break;
                                            case 22:
                                                button.setGravity(1);
                                                break;
                                        }
                                    }
                                } else {
                                    i13 = iB;
                                    i14 = iB2;
                                }
                                iB = i13;
                                iB2 = i14;
                                break;
                            case 11:
                                view.setPadding(iB, iB4, com.mbridge.msdk.dycreator.a.b.a().b(attributeSet.getAttributeValue(i19)), iB3);
                                i11 = attributeCount;
                                i12 = iB;
                                iB = i12;
                                if (view instanceof EditText) {
                                    i13 = iB;
                                    i14 = iB2;
                                    if (view instanceof Button) {
                                        if (view instanceof TextView) {
                                            if (view instanceof ImageView) {
                                                if (view instanceof ListView) {
                                                    if (view instanceof GridView) {
                                                        if (view instanceof ScrollView) {
                                                            if (view instanceof PlayerView) {
                                                                if (view instanceof MBHorizontalScrollView) {
                                                                    if (view instanceof LinearLayout) {
                                                                        linearLayout = (LinearLayout) view;
                                                                        if (AnonymousClass1.f43672a[cVar.ordinal()] != 12) {
                                                                            if ("horizontal".equalsIgnoreCase(attributeSet.getAttributeValue(i19))) {
                                                                                linearLayout.setOrientation(0);
                                                                            } else {
                                                                                linearLayout.setOrientation(1);
                                                                            }
                                                                            break;
                                                                        }
                                                                    } else if (view instanceof RelativeLayout) {
                                                                        relativeLayout = (RelativeLayout) view;
                                                                        if (AnonymousClass1.f43672a[cVar.ordinal()] != 22) {
                                                                            relativeLayout.setGravity(com.mbridge.msdk.dycreator.a.b.a().c(attributeSet.getAttributeValue(i19)));
                                                                            break;
                                                                        }
                                                                    } else if (view instanceof FrameLayout) {
                                                                    }
                                                                    iB = i13;
                                                                    iB2 = i14;
                                                                }
                                                                break;
                                                            } else {
                                                                playerView = (PlayerView) view;
                                                                if (AnonymousClass1.f43672a[cVar.ordinal()] == 12) {
                                                                    if ("horizontal".equalsIgnoreCase(attributeSet.getAttributeValue(i19))) {
                                                                        playerView.setOrientation(0);
                                                                    } else {
                                                                        playerView.setOrientation(1);
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    } else {
                                                        gridView = (GridView) view;
                                                        i15 = AnonymousClass1.f43672a[cVar.ordinal()];
                                                        if (i15 != 1) {
                                                            switch (i15) {
                                                                case 23:
                                                                    gridView.setVerticalSpacing(e.a(com.mbridge.msdk.foundation.controller.c.m().c(), com.mbridge.msdk.dycreator.a.b.a().b(attributeSet.getAttributeValue(i19))));
                                                                    break;
                                                                case 24:
                                                                    gridView.setNumColumns(attributeSet.getAttributeIntValue(i19, 2));
                                                                    break;
                                                                case 25:
                                                                    gridView.setMotionEventSplittingEnabled(!attributeSet.getAttributeValue(i19).equals("false"));
                                                                    break;
                                                                case 26:
                                                                    gridView.setCacheColorHint(com.mbridge.msdk.dycreator.a.b.a().a(attributeSet.getAttributeValue(i19)));
                                                                    break;
                                                                case 27:
                                                                    gridView.setHorizontalSpacing(e.a(com.mbridge.msdk.foundation.controller.c.m().c(), com.mbridge.msdk.dycreator.a.b.a().b(attributeSet.getAttributeValue(i19))));
                                                                    break;
                                                            }
                                                        } else {
                                                            attributeValue = attributeSet.getAttributeValue(i19);
                                                            if (attributeValue.startsWith("@+id/")) {
                                                                gridView.setId(attributeValue.substring(5).hashCode());
                                                            }
                                                        }
                                                    }
                                                } else {
                                                    listView = (ListView) view;
                                                    i16 = AnonymousClass1.f43672a[cVar.ordinal()];
                                                    if (i16 != 25) {
                                                        listView.setMotionEventSplittingEnabled(!attributeSet.getAttributeValue(i19).equals("false"));
                                                    } else if (i16 != 26) {
                                                        switch (i16) {
                                                            case 34:
                                                                attributeValue2 = attributeSet.getAttributeValue(i19);
                                                                if (!TextUtils.isEmpty(attributeValue2)) {
                                                                    listView.setDivider(null);
                                                                }
                                                                break;
                                                            case 35:
                                                                attributeValue3 = attributeSet.getAttributeValue(i19);
                                                                if (!TextUtils.isEmpty(attributeValue3)) {
                                                                    if (attributeValue3.equals(DevicePublicKeyStringDef.NONE)) {
                                                                        z11 = false;
                                                                        listView.setVerticalScrollBarEnabled(false);
                                                                    } else {
                                                                        z11 = false;
                                                                    }
                                                                    if (attributeValue3.equals("false")) {
                                                                        listView.setScrollbarFadingEnabled(z11);
                                                                    }
                                                                }
                                                                break;
                                                            case 36:
                                                                attributeValue4 = attributeSet.getAttributeValue(i19);
                                                                if (!TextUtils.isEmpty(attributeValue4)) {
                                                                    listView.setSelector(com.mbridge.msdk.dycreator.a.b.a().a(attributeValue4));
                                                                }
                                                                break;
                                                        }
                                                    } else {
                                                        listView.setCacheColorHint(com.mbridge.msdk.dycreator.a.b.a().a(attributeSet.getAttributeValue(i19)));
                                                    }
                                                }
                                            } else {
                                                imageView = (ImageView) view;
                                                i17 = AnonymousClass1.f43672a[cVar.ordinal()];
                                                if (i17 != 32) {
                                                    com.mbridge.msdk.dycreator.a.b.a().a(attributeSet.getAttributeValue(i19), imageView);
                                                } else if (i17 != 33) {
                                                    attributeValue5 = attributeSet.getAttributeValue(i19);
                                                    if (!TextUtils.isEmpty(attributeValue5)) {
                                                        if (attributeValue5.equals("fitXY")) {
                                                            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                                                        } else if (attributeValue5.equals("centerInside")) {
                                                            imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                                                        } else if (attributeValue5.equals("centerCrop")) {
                                                            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                                                        } else if (attributeValue5.equals("fitStart")) {
                                                            imageView.setScaleType(ImageView.ScaleType.FIT_START);
                                                        }
                                                    }
                                                }
                                            }
                                        } else {
                                            textView = (TextView) view;
                                            i18 = AnonymousClass1.f43672a[cVar.ordinal()];
                                            switch (i18) {
                                                case 13:
                                                    attributeValue6 = attributeSet.getAttributeValue(i19);
                                                    if (!TextUtils.isEmpty(attributeValue6)) {
                                                        if (attributeValue6.startsWith("@string/")) {
                                                            textView.setText(com.mbridge.msdk.dycreator.a.b.a().e(attributeSet.getAttributeValue(i19)));
                                                        } else {
                                                            textView.setText(attributeValue6);
                                                        }
                                                    }
                                                    break;
                                                case 14:
                                                    attributeValue7 = attributeSet.getAttributeValue(i19);
                                                    if (!TextUtils.isEmpty(attributeValue7)) {
                                                        if (attributeValue7.equals(TtmlNode.END)) {
                                                            textView.setEllipsize(TextUtils.TruncateAt.END);
                                                        }
                                                        if (attributeValue7.equals("start")) {
                                                            textView.setEllipsize(TextUtils.TruncateAt.START);
                                                        }
                                                        if (attributeValue7.equals("middle")) {
                                                            textView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
                                                        }
                                                        if (attributeValue7.equals("marquee")) {
                                                            textView.setEllipsize(TextUtils.TruncateAt.MARQUEE);
                                                        }
                                                    }
                                                    break;
                                                case 15:
                                                    textView.setHorizontalFadingEdgeEnabled(attributeSet.getAttributeBooleanValue(i19, false));
                                                    break;
                                                case 16:
                                                    textView.setHorizontallyScrolling(attributeSet.getAttributeBooleanValue(i19, false));
                                                    break;
                                                case 17:
                                                    textView.setTextColor(com.mbridge.msdk.dycreator.a.b.a().a(attributeSet.getAttributeValue(i19)));
                                                    break;
                                                case 18:
                                                    attributeValue8 = attributeSet.getAttributeValue(i19);
                                                    if (!TextUtils.isEmpty(attributeValue8)) {
                                                        textView.setTextSize(com.mbridge.msdk.dycreator.a.b.a().b(attributeValue8));
                                                    }
                                                    break;
                                                case 19:
                                                    if (TtmlNode.BOLD.equalsIgnoreCase(attributeSet.getAttributeValue(i19))) {
                                                        textView.setTypeface(Typeface.defaultFromStyle(1));
                                                    }
                                                    break;
                                                case 20:
                                                    String attributeValue11114 = attributeSet.getAttributeValue(i19);
                                                    com.mbridge.msdk.dycreator.a.b.a().d("R.style." + attributeValue11114.substring(attributeValue11114.indexOf("/") + 1));
                                                    break;
                                                case 21:
                                                    attributeValue9 = attributeSet.getAttributeValue(i19);
                                                    if (TextUtils.isEmpty(attributeValue9)) {
                                                        str = b.f43673a.get(attributeValue9.substring(8));
                                                        if (TextUtils.isEmpty(str)) {
                                                            textView.setTag(str);
                                                        }
                                                    }
                                                    break;
                                                case 22:
                                                    textView.setGravity(com.mbridge.msdk.dycreator.a.b.a().c(attributeSet.getAttributeValue(i19)));
                                                    break;
                                                default:
                                                    switch (i18) {
                                                        case 28:
                                                            textView.setSingleLine(attributeSet.getAttributeBooleanValue(i19, false));
                                                            break;
                                                        case VungleException.INCORRECT_DEFAULT_API_USAGE /* 29 */:
                                                            textView.setLines(attributeSet.getAttributeIntValue(i19, 1));
                                                            break;
                                                        case 30:
                                                            String attributeValue11115 = attributeSet.getAttributeValue(i19);
                                                            if (attributeValue11115.startsWith("@drawable/")) {
                                                            }
                                                            if (!TextUtils.isEmpty(strSubstring)) {
                                                                textView.setCompoundDrawables(textView.getResources().getDrawable(v.a(com.mbridge.msdk.foundation.controller.c.m().c(), strSubstring, "drawable")), null, null, null);
                                                            }
                                                            break;
                                                        case VungleException.WEB_CRASH /* 31 */:
                                                            textView.setCompoundDrawablePadding(com.mbridge.msdk.dycreator.a.b.a().b(attributeSet.getAttributeValue(i19)));
                                                            break;
                                                    }
                                                    break;
                                            }
                                        }
                                    } else {
                                        button = (Button) view;
                                        switch (AnonymousClass1.f43672a[cVar.ordinal()]) {
                                            case 13:
                                                button.setText(com.mbridge.msdk.dycreator.a.b.a().e(attributeSet.getAttributeValue(i19)));
                                                break;
                                            case 14:
                                                if (attributeSet.getAttributeBooleanValue(i19, false)) {
                                                    button.setFocusable(true);
                                                    button.setFocusableInTouchMode(true);
                                                    button.setSingleLine(true);
                                                    button.setEllipsize(TextUtils.TruncateAt.MARQUEE);
                                                    button.setMarqueeRepeatLimit(1000);
                                                    button.setSingleLine();
                                                    button.setHorizontallyScrolling(true);
                                                    button.requestFocus();
                                                }
                                                break;
                                            case 15:
                                                button.setHorizontalFadingEdgeEnabled(attributeSet.getAttributeBooleanValue(i19, false));
                                                break;
                                            case 16:
                                                button.setHorizontallyScrolling(attributeSet.getAttributeBooleanValue(i19, false));
                                                break;
                                            case 17:
                                                button.setTextColor(com.mbridge.msdk.dycreator.a.b.a().a(attributeSet.getAttributeValue(i19)));
                                                break;
                                            case 18:
                                                attributeValue10 = attributeSet.getAttributeValue(i19);
                                                if (!TextUtils.isEmpty(attributeValue10)) {
                                                    button.setTextSize(com.mbridge.msdk.dycreator.a.b.a().b(attributeValue10));
                                                }
                                                break;
                                            case 19:
                                                if (TtmlNode.BOLD.equalsIgnoreCase(attributeSet.getAttributeValue(i19))) {
                                                    button.setTypeface(Typeface.defaultFromStyle(1));
                                                }
                                                break;
                                            case 20:
                                                String attributeValue11116 = attributeSet.getAttributeValue(i19);
                                                button.setTextAppearance(com.mbridge.msdk.foundation.controller.c.m().c(), com.mbridge.msdk.dycreator.a.b.a().d("R.style." + attributeValue11116.substring(attributeValue11116.indexOf("/") + 1)));
                                                break;
                                            case 21:
                                                attributeValue11 = attributeSet.getAttributeValue(i19);
                                                if (!TextUtils.isEmpty(attributeValue11)) {
                                                    str2 = b.f43673a.get(attributeValue11.substring(8));
                                                    if (!TextUtils.isEmpty(str2)) {
                                                        button.setTag(str2);
                                                    }
                                                }
                                                break;
                                            case 22:
                                                button.setGravity(1);
                                                break;
                                        }
                                    }
                                } else {
                                    i13 = iB;
                                    i14 = iB2;
                                }
                                iB = i13;
                                iB2 = i14;
                                break;
                            default:
                                i11 = attributeCount;
                                i12 = iB;
                                iB = i12;
                                if (view instanceof EditText) {
                                    i13 = iB;
                                    i14 = iB2;
                                    if (view instanceof Button) {
                                        if (view instanceof TextView) {
                                            if (view instanceof ImageView) {
                                                if (view instanceof ListView) {
                                                    if (view instanceof GridView) {
                                                        if (view instanceof ScrollView) {
                                                            if (view instanceof PlayerView) {
                                                                if (view instanceof MBHorizontalScrollView) {
                                                                    if (view instanceof LinearLayout) {
                                                                        linearLayout = (LinearLayout) view;
                                                                        if (AnonymousClass1.f43672a[cVar.ordinal()] != 12) {
                                                                            if ("horizontal".equalsIgnoreCase(attributeSet.getAttributeValue(i19))) {
                                                                                linearLayout.setOrientation(0);
                                                                            } else {
                                                                                linearLayout.setOrientation(1);
                                                                            }
                                                                            break;
                                                                        }
                                                                    } else if (view instanceof RelativeLayout) {
                                                                        relativeLayout = (RelativeLayout) view;
                                                                        if (AnonymousClass1.f43672a[cVar.ordinal()] != 22) {
                                                                            relativeLayout.setGravity(com.mbridge.msdk.dycreator.a.b.a().c(attributeSet.getAttributeValue(i19)));
                                                                            break;
                                                                        }
                                                                    } else if (view instanceof FrameLayout) {
                                                                    }
                                                                    iB = i13;
                                                                    iB2 = i14;
                                                                }
                                                                break;
                                                            } else {
                                                                playerView = (PlayerView) view;
                                                                if (AnonymousClass1.f43672a[cVar.ordinal()] == 12) {
                                                                    if ("horizontal".equalsIgnoreCase(attributeSet.getAttributeValue(i19))) {
                                                                        playerView.setOrientation(0);
                                                                    } else {
                                                                        playerView.setOrientation(1);
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    } else {
                                                        gridView = (GridView) view;
                                                        i15 = AnonymousClass1.f43672a[cVar.ordinal()];
                                                        if (i15 != 1) {
                                                            switch (i15) {
                                                                case 23:
                                                                    gridView.setVerticalSpacing(e.a(com.mbridge.msdk.foundation.controller.c.m().c(), com.mbridge.msdk.dycreator.a.b.a().b(attributeSet.getAttributeValue(i19))));
                                                                    break;
                                                                case 24:
                                                                    gridView.setNumColumns(attributeSet.getAttributeIntValue(i19, 2));
                                                                    break;
                                                                case 25:
                                                                    gridView.setMotionEventSplittingEnabled(!attributeSet.getAttributeValue(i19).equals("false"));
                                                                    break;
                                                                case 26:
                                                                    gridView.setCacheColorHint(com.mbridge.msdk.dycreator.a.b.a().a(attributeSet.getAttributeValue(i19)));
                                                                    break;
                                                                case 27:
                                                                    gridView.setHorizontalSpacing(e.a(com.mbridge.msdk.foundation.controller.c.m().c(), com.mbridge.msdk.dycreator.a.b.a().b(attributeSet.getAttributeValue(i19))));
                                                                    break;
                                                            }
                                                        } else {
                                                            attributeValue = attributeSet.getAttributeValue(i19);
                                                            if (attributeValue.startsWith("@+id/")) {
                                                                gridView.setId(attributeValue.substring(5).hashCode());
                                                            }
                                                        }
                                                    }
                                                } else {
                                                    listView = (ListView) view;
                                                    i16 = AnonymousClass1.f43672a[cVar.ordinal()];
                                                    if (i16 != 25) {
                                                        listView.setMotionEventSplittingEnabled(!attributeSet.getAttributeValue(i19).equals("false"));
                                                    } else if (i16 != 26) {
                                                        switch (i16) {
                                                            case 34:
                                                                attributeValue2 = attributeSet.getAttributeValue(i19);
                                                                if (!TextUtils.isEmpty(attributeValue2)) {
                                                                    listView.setDivider(null);
                                                                }
                                                                break;
                                                            case 35:
                                                                attributeValue3 = attributeSet.getAttributeValue(i19);
                                                                if (!TextUtils.isEmpty(attributeValue3)) {
                                                                    if (attributeValue3.equals(DevicePublicKeyStringDef.NONE)) {
                                                                        z11 = false;
                                                                        listView.setVerticalScrollBarEnabled(false);
                                                                    } else {
                                                                        z11 = false;
                                                                    }
                                                                    if (attributeValue3.equals("false")) {
                                                                        listView.setScrollbarFadingEnabled(z11);
                                                                    }
                                                                }
                                                                break;
                                                            case 36:
                                                                attributeValue4 = attributeSet.getAttributeValue(i19);
                                                                if (!TextUtils.isEmpty(attributeValue4)) {
                                                                    listView.setSelector(com.mbridge.msdk.dycreator.a.b.a().a(attributeValue4));
                                                                }
                                                                break;
                                                        }
                                                    } else {
                                                        listView.setCacheColorHint(com.mbridge.msdk.dycreator.a.b.a().a(attributeSet.getAttributeValue(i19)));
                                                    }
                                                }
                                            } else {
                                                imageView = (ImageView) view;
                                                i17 = AnonymousClass1.f43672a[cVar.ordinal()];
                                                if (i17 != 32) {
                                                    com.mbridge.msdk.dycreator.a.b.a().a(attributeSet.getAttributeValue(i19), imageView);
                                                } else if (i17 != 33) {
                                                    attributeValue5 = attributeSet.getAttributeValue(i19);
                                                    if (!TextUtils.isEmpty(attributeValue5)) {
                                                        if (attributeValue5.equals("fitXY")) {
                                                            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                                                        } else if (attributeValue5.equals("centerInside")) {
                                                            imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                                                        } else if (attributeValue5.equals("centerCrop")) {
                                                            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                                                        } else if (attributeValue5.equals("fitStart")) {
                                                            imageView.setScaleType(ImageView.ScaleType.FIT_START);
                                                        }
                                                    }
                                                }
                                            }
                                        } else {
                                            textView = (TextView) view;
                                            i18 = AnonymousClass1.f43672a[cVar.ordinal()];
                                            switch (i18) {
                                                case 13:
                                                    attributeValue6 = attributeSet.getAttributeValue(i19);
                                                    if (!TextUtils.isEmpty(attributeValue6)) {
                                                        if (attributeValue6.startsWith("@string/")) {
                                                            textView.setText(com.mbridge.msdk.dycreator.a.b.a().e(attributeSet.getAttributeValue(i19)));
                                                        } else {
                                                            textView.setText(attributeValue6);
                                                        }
                                                    }
                                                    break;
                                                case 14:
                                                    attributeValue7 = attributeSet.getAttributeValue(i19);
                                                    if (!TextUtils.isEmpty(attributeValue7)) {
                                                        if (attributeValue7.equals(TtmlNode.END)) {
                                                            textView.setEllipsize(TextUtils.TruncateAt.END);
                                                        }
                                                        if (attributeValue7.equals("start")) {
                                                            textView.setEllipsize(TextUtils.TruncateAt.START);
                                                        }
                                                        if (attributeValue7.equals("middle")) {
                                                            textView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
                                                        }
                                                        if (attributeValue7.equals("marquee")) {
                                                            textView.setEllipsize(TextUtils.TruncateAt.MARQUEE);
                                                        }
                                                    }
                                                    break;
                                                case 15:
                                                    textView.setHorizontalFadingEdgeEnabled(attributeSet.getAttributeBooleanValue(i19, false));
                                                    break;
                                                case 16:
                                                    textView.setHorizontallyScrolling(attributeSet.getAttributeBooleanValue(i19, false));
                                                    break;
                                                case 17:
                                                    textView.setTextColor(com.mbridge.msdk.dycreator.a.b.a().a(attributeSet.getAttributeValue(i19)));
                                                    break;
                                                case 18:
                                                    attributeValue8 = attributeSet.getAttributeValue(i19);
                                                    if (!TextUtils.isEmpty(attributeValue8)) {
                                                        textView.setTextSize(com.mbridge.msdk.dycreator.a.b.a().b(attributeValue8));
                                                    }
                                                    break;
                                                case 19:
                                                    if (TtmlNode.BOLD.equalsIgnoreCase(attributeSet.getAttributeValue(i19))) {
                                                        textView.setTypeface(Typeface.defaultFromStyle(1));
                                                    }
                                                    break;
                                                case 20:
                                                    String attributeValue11117 = attributeSet.getAttributeValue(i19);
                                                    com.mbridge.msdk.dycreator.a.b.a().d("R.style." + attributeValue11117.substring(attributeValue11117.indexOf("/") + 1));
                                                    break;
                                                case 21:
                                                    attributeValue9 = attributeSet.getAttributeValue(i19);
                                                    if (TextUtils.isEmpty(attributeValue9)) {
                                                        str = b.f43673a.get(attributeValue9.substring(8));
                                                        if (TextUtils.isEmpty(str)) {
                                                            textView.setTag(str);
                                                        }
                                                    }
                                                    break;
                                                case 22:
                                                    textView.setGravity(com.mbridge.msdk.dycreator.a.b.a().c(attributeSet.getAttributeValue(i19)));
                                                    break;
                                                default:
                                                    switch (i18) {
                                                        case 28:
                                                            textView.setSingleLine(attributeSet.getAttributeBooleanValue(i19, false));
                                                            break;
                                                        case VungleException.INCORRECT_DEFAULT_API_USAGE /* 29 */:
                                                            textView.setLines(attributeSet.getAttributeIntValue(i19, 1));
                                                            break;
                                                        case 30:
                                                            String attributeValue11118 = attributeSet.getAttributeValue(i19);
                                                            if (attributeValue11118.startsWith("@drawable/")) {
                                                            }
                                                            if (!TextUtils.isEmpty(strSubstring)) {
                                                                textView.setCompoundDrawables(textView.getResources().getDrawable(v.a(com.mbridge.msdk.foundation.controller.c.m().c(), strSubstring, "drawable")), null, null, null);
                                                            }
                                                            break;
                                                        case VungleException.WEB_CRASH /* 31 */:
                                                            textView.setCompoundDrawablePadding(com.mbridge.msdk.dycreator.a.b.a().b(attributeSet.getAttributeValue(i19)));
                                                            break;
                                                    }
                                                    break;
                                            }
                                        }
                                    } else {
                                        button = (Button) view;
                                        switch (AnonymousClass1.f43672a[cVar.ordinal()]) {
                                            case 13:
                                                button.setText(com.mbridge.msdk.dycreator.a.b.a().e(attributeSet.getAttributeValue(i19)));
                                                break;
                                            case 14:
                                                if (attributeSet.getAttributeBooleanValue(i19, false)) {
                                                    button.setFocusable(true);
                                                    button.setFocusableInTouchMode(true);
                                                    button.setSingleLine(true);
                                                    button.setEllipsize(TextUtils.TruncateAt.MARQUEE);
                                                    button.setMarqueeRepeatLimit(1000);
                                                    button.setSingleLine();
                                                    button.setHorizontallyScrolling(true);
                                                    button.requestFocus();
                                                }
                                                break;
                                            case 15:
                                                button.setHorizontalFadingEdgeEnabled(attributeSet.getAttributeBooleanValue(i19, false));
                                                break;
                                            case 16:
                                                button.setHorizontallyScrolling(attributeSet.getAttributeBooleanValue(i19, false));
                                                break;
                                            case 17:
                                                button.setTextColor(com.mbridge.msdk.dycreator.a.b.a().a(attributeSet.getAttributeValue(i19)));
                                                break;
                                            case 18:
                                                attributeValue10 = attributeSet.getAttributeValue(i19);
                                                if (!TextUtils.isEmpty(attributeValue10)) {
                                                    button.setTextSize(com.mbridge.msdk.dycreator.a.b.a().b(attributeValue10));
                                                }
                                                break;
                                            case 19:
                                                if (TtmlNode.BOLD.equalsIgnoreCase(attributeSet.getAttributeValue(i19))) {
                                                    button.setTypeface(Typeface.defaultFromStyle(1));
                                                }
                                                break;
                                            case 20:
                                                String attributeValue11119 = attributeSet.getAttributeValue(i19);
                                                button.setTextAppearance(com.mbridge.msdk.foundation.controller.c.m().c(), com.mbridge.msdk.dycreator.a.b.a().d("R.style." + attributeValue11119.substring(attributeValue11119.indexOf("/") + 1)));
                                                break;
                                            case 21:
                                                attributeValue11 = attributeSet.getAttributeValue(i19);
                                                if (!TextUtils.isEmpty(attributeValue11)) {
                                                    str2 = b.f43673a.get(attributeValue11.substring(8));
                                                    if (!TextUtils.isEmpty(str2)) {
                                                        button.setTag(str2);
                                                    }
                                                }
                                                break;
                                            case 22:
                                                button.setGravity(1);
                                                break;
                                        }
                                    }
                                } else {
                                    i13 = iB;
                                    i14 = iB2;
                                }
                                iB = i13;
                                iB2 = i14;
                                break;
                        }
                        return;
                    }
                    i11 = attributeCount;
                    i19++;
                    mapC = mapC;
                }
            }
        } catch (Exception e27) {
            ad.b("AttributeUtil", e27.getMessage());
        }
    }
}
