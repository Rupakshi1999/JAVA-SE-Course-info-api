package courseinfo.cli;

public class CourseRetriever {
    public static void main (String... args){

        if(args.length == 0){
            print("Please provide an author name as first argument");
            return;
        }
        try {
            retrieveCourses(args[0]);
        } catch (Exception e) {
            print("Unexpected error");
            e.printStackTrace();
        }
    }

    private static void retrieveCourses(String authorID) {
        print("Retrieving courses for author: " + authorID);
    }

    private static void print(String s) {
        System.out.println(s);
    }
}
