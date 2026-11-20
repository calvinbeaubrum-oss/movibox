package com.applovin.impl;

import android.text.Html;
import android.text.Spanned;
import android.text.TextUtils;
import com.mbridge.msdk.playercommon.exoplayer2.source.chunk.ChunkedTrackBlacklistUtil;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class jl extends ek {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final Pattern f19987q = Pattern.compile("\\s*((?:(\\d+):)?(\\d+):(\\d+)(?:,(\\d+))?)\\s*-->\\s*((?:(\\d+):)?(\\d+):(\\d+)(?:,(\\d+))?)\\s*");

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final Pattern f19988r = Pattern.compile("\\{\\\\.*?\\}");

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final StringBuilder f19989o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final ArrayList f19990p;

    public jl() {
        super("SubripDecoder");
        this.f19989o = new StringBuilder();
        this.f19990p = new ArrayList();
    }

    private static long a(Matcher matcher, int i11) {
        String strGroup = matcher.group(i11 + 1);
        long j11 = (strGroup != null ? Long.parseLong(strGroup) * 3600000 : 0L) + (Long.parseLong((String) b1.a((Object) matcher.group(i11 + 2))) * ChunkedTrackBlacklistUtil.DEFAULT_TRACK_BLACKLIST_MS) + (Long.parseLong((String) b1.a((Object) matcher.group(i11 + 3))) * 1000);
        String strGroup2 = matcher.group(i11 + 4);
        if (strGroup2 != null) {
            j11 += Long.parseLong(strGroup2);
        }
        return j11 * 1000;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:36:0x007b  */
    /* JADX WARN: Code duplicated, block: B:77:0x00e6  */
    private b5 a(Spanned spanned, String str) {
        byte b11;
        byte b12;
        b5.b bVarA = new b5.b().a(spanned);
        if (str == null) {
            return bVarA.a();
        }
        switch (str) {
            case "{\an1}":
                b11 = 0;
                break;
            case "{\an2}":
                b11 = 6;
                break;
            case "{\an3}":
                b11 = 3;
                break;
            case "{\an4}":
                b11 = 1;
                break;
            case "{\an5}":
                b11 = 7;
                break;
            case "{\an6}":
                b11 = 4;
                break;
            case "{\an7}":
                b11 = 2;
                break;
            case "{\an8}":
                b11 = 8;
                break;
            case "{\an9}":
                b11 = 5;
                break;
            default:
                b11 = -1;
                break;
        }
        if (b11 == 0 || b11 == 1 || b11 == 2) {
            bVarA.b(0);
        } else if (b11 == 3 || b11 == 4 || b11 == 5) {
            bVarA.b(2);
        } else {
            bVarA.b(1);
        }
        switch (str) {
            case "{\an1}":
                b12 = 0;
                break;
            case "{\an2}":
                b12 = 1;
                break;
            case "{\an3}":
                b12 = 2;
                break;
            case "{\an4}":
                b12 = 6;
                break;
            case "{\an5}":
                b12 = 7;
                break;
            case "{\an6}":
                b12 = 8;
                break;
            case "{\an7}":
                b12 = 3;
                break;
            case "{\an8}":
                b12 = 4;
                break;
            case "{\an9}":
                b12 = 5;
                break;
            default:
                b12 = -1;
                break;
        }
        if (b12 == 0 || b12 == 1 || b12 == 2) {
            bVarA.a(2);
        } else if (b12 == 3 || b12 == 4 || b12 == 5) {
            bVarA.a(0);
        } else {
            bVarA.a(1);
        }
        return bVarA.b(b(bVarA.d())).a(b(bVarA.c()), 0).a();
    }

    private String a(String str, ArrayList arrayList) {
        String strTrim = str.trim();
        StringBuilder sb2 = new StringBuilder(strTrim);
        Matcher matcher = f19988r.matcher(strTrim);
        int i11 = 0;
        while (matcher.find()) {
            String strGroup = matcher.group();
            arrayList.add(strGroup);
            int iStart = matcher.start() - i11;
            int length = strGroup.length();
            sb2.replace(iStart, iStart + length, "");
            i11 += length;
        }
        return sb2.toString();
    }

    public static float b(int i11) {
        if (i11 == 0) {
            return 0.08f;
        }
        if (i11 == 1) {
            return 0.5f;
        }
        if (i11 == 2) {
            return 0.92f;
        }
        throw new IllegalArgumentException();
    }

    @Override // com.applovin.impl.ek
    public nl a(byte[] bArr, int i11, boolean z11) {
        String str;
        ArrayList arrayList = new ArrayList();
        rc rcVar = new rc();
        bh bhVar = new bh(bArr, i11);
        while (true) {
            String strL = bhVar.l();
            int i12 = 0;
            if (strL == null) {
                break;
            }
            if (strL.length() != 0) {
                try {
                    Integer.parseInt(strL);
                    String strL2 = bhVar.l();
                    if (strL2 == null) {
                        pc.d("SubripDecoder", "Unexpected end");
                        break;
                    }
                    Matcher matcher = f19987q.matcher(strL2);
                    if (matcher.matches()) {
                        rcVar.a(a(matcher, 1));
                        rcVar.a(a(matcher, 6));
                        this.f19989o.setLength(0);
                        this.f19990p.clear();
                        for (String strL3 = bhVar.l(); !TextUtils.isEmpty(strL3); strL3 = bhVar.l()) {
                            if (this.f19989o.length() > 0) {
                                this.f19989o.append("<br>");
                            }
                            this.f19989o.append(a(strL3, this.f19990p));
                        }
                        Spanned spannedFromHtml = Html.fromHtml(this.f19989o.toString());
                        while (true) {
                            if (i12 >= this.f19990p.size()) {
                                str = null;
                                break;
                            }
                            str = (String) this.f19990p.get(i12);
                            if (str.matches("\\{\\\\an[1-9]\\}")) {
                                break;
                            }
                            i12++;
                        }
                        arrayList.add(a(spannedFromHtml, str));
                        arrayList.add(b5.f17830s);
                    } else {
                        pc.d("SubripDecoder", "Skipping invalid timing: " + strL2);
                    }
                } catch (NumberFormatException unused) {
                    pc.d("SubripDecoder", "Skipping invalid index: " + strL);
                }
            }
        }
        return new kl((b5[]) arrayList.toArray(new b5[0]), rcVar.b());
    }
}
