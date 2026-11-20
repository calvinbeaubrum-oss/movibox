package com.applovin.impl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.tools.zip.UnixStat;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class z9 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Pattern f24823c = Pattern.compile("^ [0-9a-fA-F]{8} ([0-9a-fA-F]{8}) ([0-9a-fA-F]{8})");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f24824a = -1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f24825b = -1;

    private boolean a(String str) {
        Matcher matcher = f24823c.matcher(str);
        if (!matcher.find()) {
            return false;
        }
        try {
            int i11 = Integer.parseInt((String) xp.a((Object) matcher.group(1)), 16);
            int i12 = Integer.parseInt((String) xp.a((Object) matcher.group(2)), 16);
            if (i11 <= 0 && i12 <= 0) {
                return false;
            }
            this.f24824a = i11;
            this.f24825b = i12;
            return true;
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    public boolean a() {
        return (this.f24824a == -1 || this.f24825b == -1) ? false : true;
    }

    public boolean a(int i11) {
        int i12 = i11 >> 12;
        int i13 = i11 & UnixStat.PERM_MASK;
        if (i12 <= 0 && i13 <= 0) {
            return false;
        }
        this.f24824a = i12;
        this.f24825b = i13;
        return true;
    }

    public boolean a(bf bfVar) {
        for (int i11 = 0; i11 < bfVar.c(); i11++) {
            bf.b bVarA = bfVar.a(i11);
            if (bVarA instanceof u3) {
                u3 u3Var = (u3) bVarA;
                if ("iTunSMPB".equals(u3Var.f23510c) && a(u3Var.f23511d)) {
                    return true;
                }
            } else if (bVarA instanceof sb) {
                sb sbVar = (sb) bVarA;
                if ("com.apple.iTunes".equals(sbVar.f22321b) && "iTunSMPB".equals(sbVar.f22322c) && a(sbVar.f22323d)) {
                    return true;
                }
            } else {
                continue;
            }
        }
        return false;
    }
}
