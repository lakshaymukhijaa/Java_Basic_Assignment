//Q13. Create Java classes having suitable attributes for Library management system.Use OOPs concepts in your design.Also try to use interfaces and abstract classes.
package q_13;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.time.LocalDate;
import java.util.Date;
import java.time.Period;
abstract class Librarian                 /*Use of Abstraction*/
{
    public abstract void removeBook();
}
class Book extends Librarian
{
    private int id;
    private String bname;
    public void addBook(int id, String bname)
    {
        this.id=id;
        this.bname=bname;
    }
    @Override public void removeBook()
    {
        System.out.println("Book is removed");
    }
    public void showNew()
    {
        System.out.println("New Book added is: "+ bname + "With Id number" + id);
    }
}
class Student
{
    private String course; /*Encapsulation*/
    private String year;
    private String Name;
    //Starting of set Function
    public void setName(String Name){
        this.Name = Name;
    }

    public void setCourse(String course)
    {

        this.course=course;
    }
    public void setYear(String year)
    {
        this.year=year;
    }
    //starting of get Function

    public String getName(){
        return Name;
    }

    public String getCourse()
    {
        return course;
    }

    public String getYear()
    {
        return year;
    }

}
class Borrow extends Book   /*Inheritance*/
{
    private int id;
    public String title;
    private String issuedate;
    public String duedate;
    LocalDate date;
    LocalDate date2;
    int days;
    Book bookobj= new Book();
    public void setBorrow(int id,String title,String issuedate) throws Exception
    {
        this.id=id;
        this.title=title;
        this.issuedate=issuedate;

        Date dateinput=new SimpleDateFormat("dd/MM/yyyy").parse(issuedate);
        date = new java.sql.Date(dateinput.getTime()).toLocalDate();
        // date = LocalDate.parse(issuedate);
        date2 = date.plusDays(7);
        System.out.println("Your Due Date of Book is:" + date2);
    }
    public void getStatus()
    {
        if(id<10 || issuedate==null)
            System.out.println("This Book is availiable");
        else
            System.out.println("This Book Already issued");
    }

    public void getNameOfIssuedBook(int id ,String title){
        System.out.println("Book issued by Student is : " + title + " With id Number " + id);
    }
    public void removeBook(int days) /*polymorphism*/
    {
        if(days<720)
        {
            System.out.println("Book Cant be removed");
        }
        else
        {
            bookobj.removeBook();
        }
    }
    public void ban(){

        System.out.println("You are banned to borrow any books for 7 days");
    }
}

class Penalty extends Borrow
{
    Borrow borrow = new Borrow();
    public void toCheckPenalty(String title,String issueDate, String subdate) throws Exception
    {
        int p=10;
        if(subdate == ""){
            System.out.println("Please Provide a Submitted Date");
            return;
        }
        //to calculate penulty with help of issue date and submitted date
        Date dateinput1=new SimpleDateFormat("dd/MM/yyyy").parse(issueDate);
        Date dateinput2=new SimpleDateFormat("dd/MM/yyyy").parse(subdate);

        LocalDate date3 = new java.sql.Date(dateinput1.getTime()).toLocalDate();

        LocalDate subD = new java.sql.Date(dateinput2.getTime()).toLocalDate();
        LocalDate date4 = date3.plusDays(7);
        if(!subD.equals(date4)){
            Period period = Period.between(date4, subD);
            //only for days not for year or month gap
            int panultyDays = period.getDays();
            if(panultyDays>0){
                System.out.println("you submit book After Due Date And penalty is rupees:"+ panultyDays*p);
                borrow.ban();
            }
            else
                System.out.println("No Penalties!!");
        }
        else
        {
            System.out.println("No Penalties!!");
        }
    }
}
public class LibraryManagementSystem {
    public static void main(String[] args) throws Exception
    {
        int id;String title;String issuedate;
        Student student = new Student();
        Borrow borrowobj= new Borrow();
        Penalty check = new Penalty();
        System.out.println("Enter \nBook Id \nBook Name \nIssue Date(year/month/day)");
        Scanner ic = new Scanner(System.in);
        try{
            id = ic.nextInt();
            ic.nextLine();
            title = ic.nextLine();
            issuedate = ic.next();
        }
        finally{
            ic.close();
        }
        student.setName("Person");
        student.setCourse("Btech");
        student.setYear("2021");
        // 1,"Da vinci code",null
        borrowobj.getNameOfIssuedBook(id,title);
        borrowobj.setBorrow(id, title ,issuedate);

        // Taking Default Name, course and Year of the Student:


        System.out.println(student.getName() + " " + student.getCourse()+ " " +student.getYear());
        borrowobj.getStatus();
        borrowobj.removeBook(710);
        //lets check panulty method in case of penalty:
        check.toCheckPenalty("book", issuedate, "23/12/2021");
    }
}