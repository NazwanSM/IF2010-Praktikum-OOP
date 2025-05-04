public class Robot {
    int x;
    int y;

    public Robot() {
        this.x = 0;
        this.y = 0;
    }

    public void walk(int x, int y) throws Exception {
        
        int xTemp = this.x + x;
        int yTemp = this.y + y;

        if (xTemp > 5 ||  yTemp > 5){
            throw new Exception("Malas berjalan");
        }
        else {
            this.x = xTemp;
            this.y = yTemp;
    
            System.out.println("Yawes Otw aing (" + this.x + ", " + this.y + ")");
        }
    }

    public void talk(String language) throws Exception {
        if (!language.equals("Indonesia") && !language.equals("Inggris")){
            throw new Exception("Minimal belajar " + language + " dulu daripada nyuruh aing doang");
        }
        else {
            System.out.println("Jago aing bisa " + language);
        }
    }

    public void receiveCommand(String command) throws Exception {
        if (!command.equals("walk") && !command.equals("talk")) {
            throw new Exception("Nyuruh-nyuruh aing mulu ih. " + command + " tidak dikenal");
        }
    }
}