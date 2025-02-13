public class AppointmentBook {
    boolean[][] book = new boolean[8][60];

    public AppointmentBook(boolean[][] bookt) {
        book = bookt;
    }

    public String toString() {
        String str = "  00 01 02 03 04 05 06 07 08 09";
        for (int h=10;h<60;h++) str += " "+h;
        for (int i=1;i<9;i++) {
            str += "\n"+i;
            for (int j=0;j<60;j++) {
                String result = "";
                if (isMinuteFree(i,j)) result = "[]";
                else result = "XX";
                str += " "+result;
            }
        }
        return str;
    }
    
    /**
     * Returns true if minute in period is available for an appointment and returns
     * false otherwise
     * Preconditions: 1 <= period <= 8; 0 <= minute <= 59
     */
    boolean isMinuteFree(int period, int minute) {
        return book[period-1][minute];
    }

    /**
     * Marks the block of minutes that starts at startMinute in period and
     * is duration minutes long as reserved for an appointment
     * Preconditions: 1 <= period <= 8; 0 <= startMinute <= 59;
     * 1 <= duration <= 60
     */
    void reserveBlock(int period, int startMinute, int duration) {
        if (startMinute+duration<=60) {
            boolean open = true;
            for (int i=0;i<duration;i++) {
                if (book[period-1][startMinute+i]==false) {  //index period = argument period-1
                    open = false;
                }
            }
            if (open) {
                System.out.println("Reserving within period "+(period)+", from minute "+startMinute+" to "+(startMinute+duration-1)+" inclusive");
                for (int i=0;i<duration;i++) {
                    book[period-1][startMinute+i] = false;  //index period = argument period-1
                    //System.out.println("Period "+(period)+", minute "+(startMinute+i)+" has been reserved.");
                }
            }
            //System.out.println();
        }
    }

    /**
     * Searches for the first block of duration free minutes during period, as
     * described in
     * part (a). Returns the first minute in the block if such a block is found or
     * returns -1 if no
     * such block is found.
     * Preconditions: 1 <= period <= 8; 1 <= duration <= 60
     */
    public int findFreeBlock(int period, int duration) {
        for (int i=0;i<60;i++) {
            if (book[period-1][i]) { //index period = argument period-1
                boolean open = true;
                for (int j=0;j<duration;j++) {
                    if (i+j>59 || !book[period-1][i+j]) {/*System.out.print("p"+period+"m"+i+"bad ");*/ open = false;}  //index period = argument period-1
                    //else System.out.print("p"+period+"m"+i+"good ");
                }
                if (open) {/*System.out.println()*/;return i;}
            }
        }
        //System.out.println();
        return -1;
    }

    /**
     * Searches periods from startPeriod to endPeriod, inclusive, for a block
     * of duration free minutes, as described in part (b). If such a block is found,
     * calls reserveBlock to reserve the block of minutes and returns true;
     * otherwise
     * returns false.
     * Preconditions: 1 <= startPeriod <= endPeriod <= 8; 1 <= duration <= 60
     */
    public boolean makeAppointment(int startPeriod, int endPeriod, int duration) {
        for (int pd=startPeriod;pd<=endPeriod;pd++) { //inclusive
            System.out.println("Checking for availability: period "+pd);
            int block = findFreeBlock(pd, duration);
            if (block!=-1) {
                reserveBlock(pd, block, duration);
                return true;
            }
            else System.out.println("Failed attempt: period "+pd);
        }
        return false;
    }

    // There may be instance variables, constructors, and methods that are not shown.

}
