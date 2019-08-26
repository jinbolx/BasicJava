package proxy;

public class TaskImpl implements TaskInterface {

    @Override
    public void dealTask(String tasks) {
        try {
            Thread.sleep(500);
            System.out.println("doRealTasks: "+tasks);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
