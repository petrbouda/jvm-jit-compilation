public class Tier3CompileThreshold {

    public static void main(final String[] args) {
        int invocationCount = Integer.parseInt(args[0]);
        System.out.println("Loop count is: " + invocationCount);

        long dceGuard = wrapper(System.nanoTime(), invocationCount);

        System.out.println(dceGuard == Long.MAX_VALUE);
    }

    private static long wrapper(final long input, final int loopCount) {
        long value = input;
        for (int i = 0; i < loopCount; i++) {
            value = invoke(input);
        }
        return value;
    }

    private static long invoke(final long input) {
        long value = input;
        for (int i = 0; i < 20; i++) {
            value = 17L * value;
        }
        return value;
    }
}
