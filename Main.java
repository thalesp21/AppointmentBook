public class Main {
    public static void main(String args[]) {
        boolean[][] book = new boolean[8][60];
        for(int i=0;i<8;i++) {
            for (int j=0;j<60;j++) {
                book[i][j] = true;
            }
        }
        AppointmentBook sched = new AppointmentBook(book);
        // System.out.println(sched.isMinuteFree(1,0));
        // sched.reserveBlock(1,0,10);
        // sched.reserveBlock(2,5,40);
        // sched.reserveBlock(3,0,2);
        // System.out.println(sched);
        // //System.out.println(sched.findFreeBlock(1,1));
        // //System.out.println(sched.findFreeBlock(1,51));
        // //System.out.println(sched.findFreeBlock(2,5));
        // System.out.println(sched.makeAppointment(1, 8, 10));
        // System.out.println(sched.makeAppointment(2, 8, 20));
        // System.out.println(sched.makeAppointment(1, 8, 59));
        // System.out.println(sched);
        // sched.reserveBlock(2, 0, 10);
        // sched.reserveBlock(2, 10, 5);
        // sched.reserveBlock(2, 15, 15);
        // sched.reserveBlock(2, 30, 15);
        // sched.reserveBlock(2, 45, 5);
        // sched.reserveBlock(2, 50, 10);

        sched.reserveBlock(2,0,25);
        sched.reserveBlock(2,30,30);
        sched.reserveBlock(3,15,26);
        sched.reserveBlock(4,0,5);
        sched.reserveBlock(4,30,14);
        System.out.println("Initial schedule:");
        System.out.println(sched+"\n");
        System.out.println("2,4,22: ");
        System.out.println("Successful? "+sched.makeAppointment(2, 4, 22));
        System.out.println("3,4,3: ");
        System.out.println("Successful? "+sched.makeAppointment(3,4,3));
        System.out.println("2,4,30: ");
        System.out.println("Successful? "+sched.makeAppointment(2, 4, 30)+"\n");
        System.out.println("Final schedule:");
        System.out.println(sched);

    }
}