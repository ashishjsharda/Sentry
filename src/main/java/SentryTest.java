import io.sentry.Sentry;

public class SentryTest {
    public static void main(String[] args) {
        Sentry.init(options -> {
            options.setDsn("https://5cf22c9aade54fcc8577cb8677d1a45f@o967537.ingest.sentry.io/5918747");
            // Set traces_sample_rate to 1.0 to capture 100% of transactions for performance monitoring.
            // We recommend adjusting this value in production.
            options.setTracesSampleRate(1.0);
            // When first trying Sentry it's good to see what the SDK is doing:
            options.setDebug(true);
        });
        try {
            throw new Exception("This is a test.");
        } catch (Exception e) {
            Sentry.captureException(e);
        }
    }
}
