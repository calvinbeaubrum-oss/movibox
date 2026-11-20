package com.bytedance.sdk.component.sc;

import android.net.Uri;
import com.amazonaws.services.s3.model.InstructionFileId;
import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
class YIK {
    private UFX.sc ExN;
    private final Dl We;
    private final Set<String> pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private final Set<String> f27005sc;
    private final uEA zY = Xc.f27004sc;

    public YIK(Dl dl2, Set<String> set, Set<String> set2) {
        this.We = dl2;
        if (set == null || set.isEmpty()) {
            this.f27005sc = new LinkedHashSet();
        } else {
            this.f27005sc = new LinkedHashSet(set);
        }
        if (set2 == null || set2.isEmpty()) {
            this.pFF = new LinkedHashSet();
        } else {
            this.pFF = new LinkedHashSet(set2);
        }
    }

    private JPJ sc(String str, pFF pff, boolean z11) {
        if (!z11 || this.We == null) {
            return null;
        }
        throw null;
    }

    public final synchronized JPJ pFF(String str, pFF pff) {
        return sc(str, pff, false);
    }

    public void pFF(uEA.sc scVar) {
        if (this.zY != null) {
            throw null;
        }
    }

    public final synchronized JPJ sc(String str, pFF pff) throws Dl.sc {
        return sc(str, pff, true);
    }

    public final synchronized JPJ sc(boolean z11, String str, pFF pff) throws Dl.sc {
        UFX.sc scVar;
        try {
            Uri uri = Uri.parse(str);
            String host = uri.getHost();
            if (host == null) {
                return null;
            }
            JPJ jpj = this.pFF.contains(pff.sc()) ? JPJ.PUBLIC : null;
            for (String str2 : this.f27005sc) {
                if (uri.getHost().equals(str2) || host.endsWith(InstructionFileId.DOT.concat(String.valueOf(str2)))) {
                    jpj = JPJ.PRIVATE;
                    break;
                }
            }
            if (jpj == null && (scVar = this.ExN) != null && scVar.sc(str)) {
                if (this.ExN.sc(str, pff.sc())) {
                    return null;
                }
                jpj = JPJ.PRIVATE;
            }
            JPJ jpjSc = z11 ? sc(str, pff) : pFF(str, pff);
            return jpjSc != null ? jpjSc : jpj;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public void sc(UFX.sc scVar) {
        this.ExN = scVar;
    }

    public void sc(uEA.sc scVar) {
        if (this.zY != null) {
            throw null;
        }
    }
}
