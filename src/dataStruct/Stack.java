package dataStruct;

public class Stack {

    private Object[] objects;
    private int maxsize;
    private int bottomIndex;

    public Stack() {
        maxsize = 1;
        bottomIndex = 0;
        objects = new Object[maxsize];
    }

    public void push(Object o) {
        grow();
        objects[bottomIndex] = o;
        bottomIndex++;
    }

    private void grow() {
        if (bottomIndex == maxsize - 1) {
            maxsize = maxsize << 1;
            Object[] oldObjects = objects;
            objects = new Object[maxsize];
            System.arraycopy(oldObjects, 0, objects, 0, oldObjects.length);
        }
    }

    public Object pop() {
        if (isEmpty()) {
            throw new RuntimeException("stack是空的");
        }
        Object object = objects[bottomIndex-1];
        objects[bottomIndex-1] = null;
        bottomIndex--;
        return object;
    }
    public Object peek(){
        if (isEmpty()){
            throw new RuntimeException("stack是空的");
        }
        return objects[bottomIndex-1];
    }
    public boolean isEmpty(){
        return bottomIndex<=0;
    }
}
