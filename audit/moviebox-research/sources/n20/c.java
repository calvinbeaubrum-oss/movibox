package n20;

import java.io.File;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.OpenOption;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class c extends b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final File f71493b;

    public c() throws IOException {
        File fileCreateTempFile = File.createTempFile("commons-compress", "packtemp");
        this.f71493b = fileCreateTempFile;
        fileCreateTempFile.deleteOnExit();
        ((FilterOutputStream) this).out = Files.newOutputStream(fileCreateTempFile.toPath(), new OpenOption[0]);
    }
}
