public class Start {
    public static void main(String[] args) {
        try {
            IntVector test = new IntVector(-1);
    
            System.out.println("Size: " + test.size());
            
            for (int i = 0; i < test.size(); i++) {
    
            }
        } catch(IllegalArgumentException ex) {
            System.out.println("That's illegal!");
        }
        
    }
}