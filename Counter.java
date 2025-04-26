public class Counter implements AutoCloseable {
    private int count;
    private boolean isClosed;

    public Counter() {
        this.count = 0;
        this.isClosed = false;
    }

    public void add() {
        if (isClosed) {
            throw new IllegalStateException("Счетчик закрыт");
        }
        count++;
    }

    public int getCount() {
        if (isClosed) {
            throw new IllegalStateException("Счетчик закрыт");
        }
        return count;
    }

    @Override
    public void close() {
        isClosed = true;
    }

    public boolean isClosed() {
        return isClosed;
    }
} 