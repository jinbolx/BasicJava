package proxy;

import java.util.Optional;

public class TaskProxy implements TaskInterface {

    private TaskInterface delegate;

    @Override
    public void dealTask(String tasks) {
        System.out.println("TaskProxy: before: "+tasks);
        Optional.ofNullable(delegate)
                .ifPresent(t -> t.dealTask(tasks));
        System.out.println("TaskProxy: after: "+tasks);

    }

    public TaskProxy(TaskInterface delegate) {
        this.delegate = delegate;
    }
}
