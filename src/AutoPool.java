import java.util.concurrent.LinkedBlockingQueue;

public class AutoPool<T> implements Pool<Resource<T>>{
    private final LinkedBlockingQueue<T> queue=new LinkedBlockingQueue<T>();

    @Override
    public Resource<T> acquire() throws InterruptedException{
        T r=queue.take();
        return new Resource<T>(){
            @Override
            public T get(){
                return r;
            }

            @Override
            public void autorelease(){
                queue.add(r);
            }

            @SuppressWarnings("deprecated")
            @Override
            protected void finalize(){
                this.autorelease();
            }
        };
    }

    void add(T r){
        queue.add(r);
    }

    @Override
    public void release(Resource<T> r){
        r.autorelease();
    }
}
