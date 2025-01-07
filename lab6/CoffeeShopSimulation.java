// Custom exception for empty counter
class CounterEmptyException extends Exception {
    public CounterEmptyException(String message) {
        super(message);
    }
}

// CoffeeCounter to manage coffee cups
class CoffeeCounter {
    private int coffeeCount = 0;
    private final int MAX_COFFEE = 3;

    // Synchronized method for baristas to produce coffee
    public synchronized void produceCoffee(String baristaName) throws InterruptedException {
        while (coffeeCount >= MAX_COFFEE) {
            System.out.println(baristaName + " is waiting. Counter is full.");
            wait();
        }
        coffeeCount++;
        System.out.println(baristaName + " prepared coffee. Counter: " + coffeeCount);
        notify();  // Notify customers and reviewer
    }

    // Synchronized method for customers to consume coffee
    public synchronized void consumeCoffee(String customerName) throws InterruptedException, CounterEmptyException {
        while (coffeeCount == 0) {
            wait();
        }
        if (coffeeCount == 0) throw new CounterEmptyException("Counter is empty. No coffee to consume.");
        coffeeCount--;
        System.out.println(customerName + " picked up coffee. Counter: " + coffeeCount);
        notify();  // Notify baristas and reviewer
    }

    // Synchronized method for reviewer to sample coffee
    public synchronized void reviewCoffee() throws InterruptedException, CounterEmptyException {
        while (coffeeCount == 0) {
            wait();
        }
        if (coffeeCount == 0) throw new CounterEmptyException("Counter is empty. No coffee to review.");
        coffeeCount--;
        System.out.println("Coffee Reviewer sampled coffee. Counter: " + coffeeCount);
        notify();  // Notify baristas and customers
    }
}

// Barista class (producer)
class Barista extends Thread {
    private CoffeeCounter counter;

    public Barista(CoffeeCounter counter, String name) {
        super(name);
        this.counter = counter;
    }

    @Override
    public void run() {
        try {
            while (true) {
                counter.produceCoffee(getName());
                Thread.sleep(1000);  // Simulate time to make coffee
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

// Customer class (consumer)
class Customer extends Thread {
    private CoffeeCounter counter;

    public Customer(CoffeeCounter counter, String name) {
        super(name);
        this.counter = counter;
    }

    @Override
    public void run() {
        try {
            while (true) {
                counter.consumeCoffee(getName());
                Thread.sleep(2000);  // Simulate time to drink coffee
            }
        } catch (InterruptedException | CounterEmptyException e) {
            e.printStackTrace();
        }
    }
}

// Reviewer class (observer)
class Reviewer extends Thread {
    private CoffeeCounter counter;

    public Reviewer(CoffeeCounter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        try {
            while (true) {
                counter.reviewCoffee();
                Thread.sleep(3000);  // Simulate time to review coffee
            }
        } catch (InterruptedException | CounterEmptyException e) {
            e.printStackTrace();
        }
    }
}

// Main class to run the simulation
public class CoffeeShopSimulation {
    public static void main(String[] args) {
        CoffeeCounter counter = new CoffeeCounter();

        // Start 2 baristas
        Barista barista1 = new Barista(counter, "Barista 1");
        Barista barista2 = new Barista(counter, "Barista 2");
        barista1.start();
        barista2.start();

        // Start 3 customers
        Customer customer1 = new Customer(counter, "Customer 1");
        Customer customer2 = new Customer(counter, "Customer 2");
        Customer customer3 = new Customer(counter, "Customer 3");
        customer1.start();
        customer2.start();
        customer3.start();

        // Start 1 reviewer
        Reviewer reviewer = new Reviewer(counter);
        reviewer.start();
    }
}
