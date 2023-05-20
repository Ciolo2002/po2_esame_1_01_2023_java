import java.util.concurrent.LinkedBlockingQueue;

public class SimplePool<R> implements Pool<R>{
    private final LinkedBlockingQueue<R> queue= new LinkedBlockingQueue<R>();

    @Override
    public R acquire() throws InterruptedException {
        return queue.take();
    }

    @Override
    public void release(R r){
        queue.add(r);
    }


}
