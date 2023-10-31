import java.util.*;

public class Main {
    public static void main(String[] args) {
        Businessman first_b = new Businessman("Николай", 48);

        Organization cafe = new Organization("Кафе Густо");
        Organization stroy_comp = new Organization("Строительная компания Пик");
        Organization billyard = new Organization("Бильярдная у Саши");

        System.out.print("Бизнесмен " + first_b.getName() + " обладает организациями: \n");
        first_b.pushOrgToBus(cafe); first_b.pushOrgToBus(stroy_comp); first_b.pushOrgToBus(billyard); first_b.getOrg();
        System.out.println("");

        cafe.getVakansi(); stroy_comp.getVakansi(); billyard.getVakansi();
        System.out.println("");

        Employee first_e = new Employee("Стив Джунмурбаев", 18, 1,10000);
        Employee second_e = new Employee("Михаил Прологов", 23, 2,6000);

        first_b.sobes(first_e, cafe, stroy_comp, billyard);
        first_b.sobes(second_e, cafe, stroy_comp, billyard);


    }
}
abstract class Person {
    private String name;
    private int age;

    Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    public int getAge() { return age; }

    public String getName() { return name; }
}

class Employee extends Person {
    public int xp, zp;

    Employee (String name, int age, int xp, int zp) {
        super(name, age);
        this.xp = xp;
        this.zp = zp;
    }

}

class Businessman extends Person {

    Businessman(String name, int age) {
        super(name, age);
    }

    List <String> org = new ArrayList<>();

    public void pushOrgToBus(Organization n) {
        org.add(n.getName());
    }

    public void getOrg() {
        for (String el: org){
            System.out.println(el);
        }
    }

    public void sobes(Employee n, Organization a, Organization b, Organization c) {
        boolean flag = false;

        for (int i = 1; i < a.vakansis.size(); i++) {
            if (n.xp >= a.vakansis.get(i).getExp() && n.zp <= a.vakansis.get(i).getPr_zp()) {
                System.out.println(n.getName() + ", Вы подходите на вакансию: " + a.vakansis.get(i).getVakansi()
                        + ". В организации '" + a.getName() +"'");
                flag = true;
            }
        }
        for (int i = 1; i < b.vakansis.size(); i++) {
            if (n.xp >= b.vakansis.get(i).getExp() && n.zp <= b.vakansis.get(i).getPr_zp()) {
                System.out.println(n.getName() + ", Вы подходите на вакансию: " + b.vakansis.get(i).getVakansi()
                        + ". В организации '" + b.getName() +"'");
                flag = true;
            }
        }
        for (int i = 1; i < c.vakansis.size(); i++) {
            if (n.xp >= c.vakansis.get(i).getExp() && n.zp <= c.vakansis.get(i).getPr_zp()) {
                System.out.println(n.getName() + ", Вы подходите на вакансию: " + c.vakansis.get(i).getVakansi()
                        + ". В организации '" + c.getName() +"'");
                flag = true;
            }
        }

        if (flag == false) System.out.println("К сожалению, " + n.getName() + ", вы нам не подходите. Успехов!");
    }
}

class Organization {

    private String name;
    private static int nextId = 1;
    private int id;

    Organization(String name) {
        this.name = name;
        this.id = nextId++;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Vakansii> vakansis = new ArrayList<Vakansii>();
    public void getVakansi() {

        switch (id) {
            case 1:
                System.out.println(" Вакансии в '" + name + "':");
                vakansis.add(new Vakansii("Уборщик", 0, 12000));
                vakansis.add(new Vakansii("Официант", 2, 25000));
                vakansis.add(new Vakansii("Бармен", 4, 30000));
                System.out.println("");
                break;
            case 2:
                System.out.println("\n Вакансии в '" + name + "':");
                vakansis.add(new Vakansii("Инженер", 6, 65000));
                vakansis.add(new Vakansii("Архитектор", 5, 55000));
                System.out.println("");
                break;
            case 3:
                System.out.println("\n Вакансии в '" + name + "':");
                vakansis.add(new Vakansii("Администратор", 3, 48000));
                vakansis.add(new Vakansii("Официант", 2, 27000));
                System.out.println("");
                break;
        }


        for (int i = 0; i < vakansis.size(); i++) {
            System.out.println("Вакансия - " + vakansis.get(i).getVakansi() + ": требуемый опыт работы (в годах) - " +
                    vakansis.get(i).getExp() + ", предлагаемая з/п (в рублях) = " + vakansis.get(i).getPr_zp());
        }
    }

}
class Vakansii {

    private String vakansi;
    private int exp;
    private int pr_zp;
    private static int nextId = 1;
    private int id;
    public Vakansii(String vakansi, int exp, int pr_zp) {
        this.vakansi = vakansi;
        this.exp = exp;
        this.pr_zp = pr_zp;
        this.id = nextId++;
    }

    public int getExp() {
        return exp;
    }

    public int getPr_zp() {
        return pr_zp;
    }

    public String getVakansi() {
        return vakansi;
    }

    public int getIdofVak() {
        return id;
    }
}
