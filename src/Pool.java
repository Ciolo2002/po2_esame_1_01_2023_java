public interface Pool<R> {
    R acquire() throws InterruptedException; // acquisisce una risorsa
    void release(R x); // rilascia una risorsa e la rimette nella pool
}
