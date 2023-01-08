public final class Tier3BackEdgeThreshold {

    public static void main(final String[] args) {
        int invocationCount = Integer.parseInt(args[0]);
        System.out.println("Loop count is: " + invocationCount);

        long dceGuard = invoke(System.nanoTime(), invocationCount);

        System.out.println(dceGuard == Long.MAX_VALUE);
    }

    private static long invoke(final long input, final int loopCount) {
        long value = input;
        for (int i = 0; i < loopCount; i++) {
            value = 17L * value;
        }
        return value;
    }
}