package com.google.android.exoplayer2.upstream.cache;

import androidx.annotation.Nullable;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.google.android.exoplayer2.util.o0;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class s extends h {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Pattern f35372h = Pattern.compile("^(.+)\\.(\\d+)\\.(\\d+)\\.v1\\.exo$", 32);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Pattern f35373i = Pattern.compile("^(.+)\\.(\\d+)\\.(\\d+)\\.v2\\.exo$", 32);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Pattern f35374j = Pattern.compile("^(\\d+)\\.(\\d+)\\.(\\d+)\\.v3\\.exo$", 32);

    public s(String str, long j11, long j12, long j13, @Nullable File file) {
        super(str, j11, j12, j13, file);
    }

    @Nullable
    public static s e(File file, long j11, long j12, k kVar) {
        File file2;
        String strK;
        String name = file.getName();
        if (name.endsWith(".v3.exo")) {
            file2 = file;
        } else {
            File fileL = l(file, kVar);
            if (fileL == null) {
                return null;
            }
            file2 = fileL;
            name = fileL.getName();
        }
        Matcher matcher = f35374j.matcher(name);
        if (!matcher.matches() || (strK = kVar.k(Integer.parseInt((String) com.google.android.exoplayer2.util.a.e(matcher.group(1))))) == null) {
            return null;
        }
        long length = j11 == -1 ? file2.length() : j11;
        if (length == 0) {
            return null;
        }
        return new s(strK, Long.parseLong((String) com.google.android.exoplayer2.util.a.e(matcher.group(2))), length, j12 == C.TIME_UNSET ? Long.parseLong((String) com.google.android.exoplayer2.util.a.e(matcher.group(3))) : j12, file2);
    }

    @Nullable
    public static s h(File file, long j11, k kVar) {
        return e(file, j11, C.TIME_UNSET, kVar);
    }

    public static s i(String str, long j11, long j12) {
        return new s(str, j11, j12, C.TIME_UNSET, null);
    }

    public static s j(String str, long j11) {
        return new s(str, j11, -1L, C.TIME_UNSET, null);
    }

    public static File k(File file, int i11, long j11, long j12) {
        return new File(file, i11 + InstructionFileId.DOT + j11 + InstructionFileId.DOT + j12 + ".v3.exo");
    }

    @Nullable
    public static File l(File file, k kVar) {
        String strE1;
        String name = file.getName();
        Matcher matcher = f35373i.matcher(name);
        if (matcher.matches()) {
            strE1 = o0.e1((String) com.google.android.exoplayer2.util.a.e(matcher.group(1)));
        } else {
            matcher = f35372h.matcher(name);
            strE1 = matcher.matches() ? (String) com.google.android.exoplayer2.util.a.e(matcher.group(1)) : null;
        }
        if (strE1 == null) {
            return null;
        }
        File fileK = k((File) com.google.android.exoplayer2.util.a.i(file.getParentFile()), kVar.f(strE1), Long.parseLong((String) com.google.android.exoplayer2.util.a.e(matcher.group(2))), Long.parseLong((String) com.google.android.exoplayer2.util.a.e(matcher.group(3))));
        if (file.renameTo(fileK)) {
            return fileK;
        }
        return null;
    }

    public s d(File file, long j11) {
        com.google.android.exoplayer2.util.a.g(this.f35325d);
        return new s(this.f35322a, this.f35323b, this.f35324c, j11, file);
    }
}
