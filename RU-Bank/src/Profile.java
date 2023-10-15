public class Profile implements Comparable<Profile>{
    private String fname;
    private String lname;
    private Date dob;
    public Profile(String fname, String lname, Date dob){
        this.fname = fname;
        this.lname = lname;
        this.dob = dob;

    }
    public static Profile makeProfile(String [] input){
        try {
            Date dob = Date.makeDate(input[4]);
            return new Profile(input[2], input[3], dob);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Not enough data");
            return null;
        }
    }
    public String getFname(){
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public Date getDob() {
        return dob;
    }

    @Override
    public int compareTo(Profile profile) {
        return 0;
    }
    public String toString(){
        return fname + " " + lname + " " + dob;
    }
}