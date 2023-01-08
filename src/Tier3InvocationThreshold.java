public class Tier3InvocationThreshold {

    public static void main(final String[] args) {
        int invocationCount = Integer.parseInt(args[0]);
        System.out.println("Loop count is: " + invocationCount);

        long dceGuard = wrapper(System.nanoTime(), invocationCount);

        System.out.println(dceGuard == Long.MAX_VALUE);
    }

    private static long wrapper(final long input, final int loopCount) {
        long accumulator = 0L;
        for (int i = 0; i < loopCount; i++) {
            accumulator += invoke(input);
        }
        return accumulator;
    }

    private static long invoke(final long input) {
        return 17L * input;
    }
}
