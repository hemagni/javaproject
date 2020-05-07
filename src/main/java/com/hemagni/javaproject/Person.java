package com.hemagni.javaproject;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Person {

    public enum Sex {
        
        MALE,
        FEMALE
    }
    
    private static List<Person> persons = new ArrayList<Person>();
    String name,emailAddress;
    LocalDate birthday;
    Sex gender;
    public static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    
    public Person(String newName, String newBirthday, Sex newGender, String newEmailAddress) {
        
        name = newName;
        try {
            birthday = LocalDate.parse(newBirthday, Person.FORMATTER);
        }catch(DateTimeParseException ex) {
            System.out.println("Error: "+"Date not parsable "+ex);
        }
        
        gender = newGender;
        emailAddress = newEmailAddress;        
        persons.add(this);
    }
    
    public Person() {
        
    }
            
    public int getAge() {
        
        Period period = Period.between(birthday, LocalDate.now());
        return period.getYears();
    }
    
    public String getEmailAddrss() {
    
        return this.emailAddress;
    }
    
    public Calendar getBirthday() {
        Calendar cal = Calendar.getInstance();
        cal.set(birthday.getYear(), birthday.getMonthValue(), birthday.getDayOfMonth());
        return  cal;
    }
    public static int compareByAge(Person a, Person b) {
        
        return a.birthday.compareTo(b.birthday);
    }
    
    public void printPerson() {
        
        System.out.format("Name: %-20s Birthday: %10s (%2d years) Gender: %-6s "
                + " Email Address %s %n",name,birthday.format(Person.FORMATTER),getAge(),gender,emailAddress);
    }
    
    public static void printAllPersons(List<Person>persons) {
        
        for(Person p: persons) {
            System.out.format("Name: %-20s Birthday: %10s (%2d years) Gender: %-6s "
                + " Email Address %s %n",p.name,p.birthday.format(Person.FORMATTER),p.getAge(),p.gender,p.emailAddress);
        }
        System.out.format("------------------------------------------------------------------------%n");
    }
    
    //Approach 1
    public static void printPeronsOlderThen(List<Person>persons, int age) {
    
        for(Person p : persons) {
            if(p.getAge()>age) {
                p.printPerson();
            }
        }
    }
    
    // Approach 2 make method  more generalise 
    public static void printPersonsWithinAgeRange(List<Person>persons, int low, int high) {
        
        for(Person p : persons) {
            if(p.getAge()>=low && p.getAge() <= high) {
                p.printPerson();
            }
        }
    }
    
    // Approach 3 usage of local class
    interface CheckPerson {
        boolean test(Person p);
    }
    
    public static void Approach3() {
        
        class CheckPersonForSelectiveService implements CheckPerson {
        
            @Override
            public boolean test(Person p) {
                
                return p.gender == Person.Sex.MALE && (p.getAge()>18 && p.getAge()<40);
            }
        }
        Person.printPersons(persons, new CheckPersonForSelectiveService());
    }
    
    public static void printPersons(List<Person>persons, CheckPerson tester) {
        
        for(Person p : persons) {
            if(tester.test(p)) {
                p.printPerson();
            }
        }
    }
            
    // Approach 4
    public static void approach4() {
        
        printPersons4(persons, new CheckPerson() {
            
            @Override
            public boolean test(Person p) {
                return p.gender == Person.Sex.MALE 
                        && p.getAge() >= 18
                        && p.getAge() <= 38;
            }
        });
    }

    public static void printPersons4(List<Person>persons, CheckPerson tester) {
        
        for(Person p : persons) {
            if(tester.test(p)) {
                p.printPerson();
            }
        }
    }
    
    // Approach 6 Use standard functional interfaces with Lambda Expressions
    public static void printPersonsWithPredicate(List<Person>persons, Predicate<Person> tester) {
    
        for(Person p : persons) {
            if(tester.test(p)) {
                p.printPerson();    
            }
        }
    }
    
    // Approach 7 use Lambda Expressions throughout your application
    
    public static void processPersons(List<Person>roster, Predicate<Person> tester, Consumer<Person> block) {
        
        for(Person p : roster) {
            
            if(tester.test(p)) {
            
                block.accept(p);
            }
        }
    }
    
    // Approach 8 Use Lambda expressions more extensivly
    public static <X , Y>void processElements(Iterable<X> source, Predicate<X> tester, Function<X, Y> mapper,
            Consumer<Y> block) {
        
        for(X p: source) {
            if(tester.test(p)) {
                Y data = mapper.apply(p);
                block.accept(data);
            }
        }    
    }
    
    class PersonAgeComparator implements Comparator<Person> {
        
        @Override
        public int compare(Person a, Person b) {
            
            return a.getBirthday().compareTo(b.getBirthday());
        }
    }
    
    class CompareProvider {
        
        public int compareByName(Person a, Person b) {
            
            return a.name.compareTo(b.name);
        }
        
        public int compareByAge(Person a, Person b) {
            
            return a.getBirthday().compareTo(b.getBirthday());
        }
    }
    
    public static void main(String[] args) {
        
        Person p1 = new Person("Vijay Kumar","20-10-1981",Sex.MALE,"vijay.rajasthan@gmail.com");
        Person p2 = new Person("Renu Das","13-10-1983",Sex.FEMALE,"renudas.ica@gmail.com");
        Person p3 = new Person("Hemagni Chack","08-06-2016",Sex.FEMALE,"hemagni@gmail.com");
        Person p4 = new Person("Shiv","21-10-1981",Sex.MALE,"shiv@gmail.com");
        Person p5 = new Person("Mahadev","22-10-1981",Sex.MALE,"mahadev@gmail.com");
        Person.printAllPersons(persons);
        //Person.printPeronsOlderThen(persons, 37);
        //Approach 2
        //Person.printPersonsWithinAgeRange(persons, 3, 37);
        //Approach 3
        //Person.Approach3();
        //Approach 4
        //Person.approach4();
        //Approach 5 Lambda Expression
        //Person.printPersons(persons, (Person p) -> p.gender == Person.Sex.MALE && p.getAge()>=18 && p.getAge()<=38);
        // Approach 6 Use Standard functions interface with Lambda expressions
        //Person.printPersonsWithPredicate(persons, p->p.gender == Person.Sex.MALE && p.getAge()>=18 && p.getAge()<=38);
        // Approach 7 use lambda expression throughout your application
        //Person.processPersons(persons, p->p.gender==Person.Sex.MALE && p.getAge() >= 25 && p.getAge() <=38,
        //        p->p.printPerson());
        // Approach 8 Use genrics more extensivly 
        //Person.processElements(persons, (Person p) -> p.gender==Person.Sex.MALE && p.getAge()>=18 && p.getAge()<=38,
        //        (Person p) -> p.getEmailAddrss(), email -> System.out.println(email));
        // Approach 9: User aggregate operations that accept lambda expressions as parameters
        //persons.stream().filter(p->p.gender==Person.Sex.MALE && p.getAge()>=18 && p.getAge()<=38)
        //        .map(p->p.getEmailAddrss()).forEach(email->System.out.println(email));
        // Method reference
        Person[] rosterAsArray = persons.toArray(new Person[persons.size()]);
        Person p10 = new Person();
        
        /*Arrays.sort(rosterAsArray, p10.new PersonAgeComparator());
        for(Person p : rosterAsArray) {
            p.printPerson();
        }
        Arrays.sort(rosterAsArray,
                (Person a, Person b)-> {
            return a.getBirthday().compareTo(b.getBirthday());
        });
        
        Arrays.sort(rosterAsArray,(Person a, Person b)->{
            return Person.compareByAge(a, b);
                }); 
        Arrays.sort(rosterAsArray, Person::compareByAge);
        */
        
        Person p11 = new Person();  
        Person.CompareProvider cp = p11.new CompareProvider();
        Arrays.sort(rosterAsArray,(Person a, Person b)->{
            return cp.compareByName(a, b);
        });
        //Arrays.sort(rosterAsArray, p11.new CompareProvider()::compareByName);
        
        for(Person p : rosterAsArray) {
            //p::printPerson;
            p.printPerson();
        }
    }
}
