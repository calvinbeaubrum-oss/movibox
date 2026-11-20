package u4;

import androidx.media3.common.Metadata;
import androidx.media3.extractor.metadata.id3.CommentFrame;
import androidx.media3.extractor.metadata.id3.InternalFrame;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class f0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Pattern f78269c = Pattern.compile("^ [0-9a-fA-F]{8} ([0-9a-fA-F]{8}) ([0-9a-fA-F]{8})");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f78270a = -1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f78271b = -1;

    public boolean a() {
        return (this.f78270a == -1 || this.f78271b == -1) ? false : true;
    }

    public final boolean b(String str) {
        Matcher matcher = f78269c.matcher(str);
        if (!matcher.find()) {
            return false;
        }
        try {
            int i11 = Integer.parseInt((String) z3.u0.i(matcher.group(1)), 16);
            int i12 = Integer.parseInt((String) z3.u0.i(matcher.group(2)), 16);
            if (i11 <= 0 && i12 <= 0) {
                return false;
            }
            this.f78270a = i11;
            this.f78271b = i12;
            return true;
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    public boolean c(Metadata metadata) {
        for (int i11 = 0; i11 < metadata.length(); i11++) {
            Metadata.Entry entry = metadata.get(i11);
            if (entry instanceof CommentFrame) {
                CommentFrame commentFrame = (CommentFrame) entry;
                if ("iTunSMPB".equals(commentFrame.description) && b(commentFrame.text)) {
                    return true;
                }
            } else if (entry instanceof InternalFrame) {
                InternalFrame internalFrame = (InternalFrame) entry;
                if ("com.apple.iTunes".equals(internalFrame.domain) && "iTunSMPB".equals(internalFrame.description) && b(internalFrame.text)) {
                    return true;
                }
            } else {
                continue;
            }
        }
        return false;
    }
}
