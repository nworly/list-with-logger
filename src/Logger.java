import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {
    private static Logger logger = null;

    private final DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
    private Date date;

    private long start;
    private int count = 1;

    private Logger() {
        this.start = System.currentTimeMillis();
    }

    public static Logger getInstance() {
        if (logger == null) logger = new Logger();
        return logger;
    }

    public void log(String msg) {
        date = new Date();
        System.out.printf("[%s %d] %s%n", dateFormat.format(date), count, msg);
        count++;
    }
}
