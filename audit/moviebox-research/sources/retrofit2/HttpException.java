package retrofit2;

import java.util.Objects;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class HttpException extends RuntimeException {
    private final int code;
    private final String message;
    private final transient b0<?> response;

    public HttpException(b0<?> b0Var) {
        super(getMessage(b0Var));
        this.code = b0Var.b();
        this.message = b0Var.f();
        this.response = b0Var;
    }

    private static String getMessage(b0<?> b0Var) {
        Objects.requireNonNull(b0Var, "response == null");
        return "HTTP " + b0Var.b() + " " + b0Var.f();
    }

    public int code() {
        return this.code;
    }

    public String message() {
        return this.message;
    }

    public b0<?> response() {
        return this.response;
    }
}
