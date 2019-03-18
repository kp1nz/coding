/**
 * 死锁Demo
 * @author kp1nz
 * @create 2019-03-12 20:30
 */
public class DeadLock extends Thread {
    public static class Lock{
        public static final Object obj1 = new Object();
        public static final Object obj2 = new Object();
    }

    private boolean flag;

    public DeadLock(boolean flag){
        this.flag = flag;
    }

    @Override
    public void run() {
        if (flag){
            synchronized (Lock.obj1){
                System.out.println("obj1......");
                synchronized (Lock.obj2){
                    System.out.println("obj2.......");
                }
            }
        }else {
            synchronized (Lock.obj2){
                System.out.println("obj2.......");
                synchronized (Lock.obj1){
                    System.out.println("obj1........");
                }
            }
        }
    }

    public static void main(String[] args) {
        DeadLock deadLock1 = new DeadLock(true);
        DeadLock deadLock2 = new DeadLock(false);
        deadLock1.start();
        deadLock2.start();

    }

}
