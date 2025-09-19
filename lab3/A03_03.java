package lab3;

class ConnectionManager {
    private Connection[] pool;
    private int index = 0;

    private class Connection {
        private Connection() {}
    }

    public ConnectionManager(int size) {
        pool = new Connection[size];
        for (int i = 0; i < size; i++) {
            pool[i] = new Connection();
        }
    }

    public Connection getConnection() {
        if (index >= pool.length) {
            throw new RuntimeException("No more connections available");
        }
        return pool[index++];
    }
}

public class A03_03 {
    public static void main(String[] args) {
        ConnectionManager manager = new ConnectionManager(3);
        Object c1 = manager.getConnection();
        Object c2 = manager.getConnection();
        Object c3 = manager.getConnection();
        Object c4 = manager.getConnection(); 
    }
}
