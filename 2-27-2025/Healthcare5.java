class MedicalSimulation implements Runnable {
    
    public void processData() {
        System.out.println("Patient Records");
    }
    
    public void simulateScenario() {
        System.out.println("Doctor Details");
    }
    
    @Override
    public void run() {
        for (int i = 0; i < 2; i++) {
            processData();
            simulateScenario();
        }
    }
}

public class Healthcare5 {
    
    public static void main(String[] args) {
        MedicalSimulation simulation = new MedicalSimulation();
        
        Thread thread1 = new Thread(simulation);
        Thread thread2 = new Thread(simulation);
        Thread thread3 = new Thread(simulation);
        
        thread1.start();
        thread2.start();
        thread3.start();
    }
} 