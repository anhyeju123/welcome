package Join;

import java.util.Scanner;

public class Info {
	
	//�̸�(���ڿ�) ����(F/M) ����(�ܾ�) �������(�Ʊ�(����),û�ҳ�+�,�ôϾ�), ������(��,��,��)(���ڿ�) �˷�������(�ܾ�) �߼�ȭ����(Y/N) �Է�
    private String Name;
    private char gender;
    private String Breed;
    private String age;
    private String kg;
    private String allergy;
    private char neuter;
    
    
    public Info() {
		super();
	}
	public Info(String name, char gender, String breed, String age, String kg, String allergy, char neuter) {
		super();
		Name = name;
		this.gender = gender;
		Breed = breed;
		this.age = age;
		this.kg = kg;
		this.allergy = allergy;
		this.neuter = neuter;
	}
	
	public static String A() {
		System.out.print("���̸� �Է����ּ��� : ");
		Scanner sc = new Scanner(System.in);
		int a = 0;        
        a = sc.nextInt();
        
        if(a < 1) {
            System.out.println("����");
        }else if(1 <= a && a < 4) {
        	System.out.println("û�ҳ�");
        }else if(4 <= a && a < 8) {
        	System.out.println("���Ʈ");
        }else if(8 <= a && a < 30 ) {
        	System.out.println("�ôϾ�");
        }
		return "1~30������ ���ڸ� �Է��� �ּ���";
		
	}
	
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public String getBreed() {
		return Breed;
	}
	public void setBreed(String breed) {
		Breed = breed;
	}
	public String getAge() {
		return A();
	}
	public void setAge(String age) {
		this.age = A();
	}
	public String getKg() {
		return kg;
	}
	public void setKg(String kg) {
		this.kg = kg;
	}
	public String getAllergy() {
		return allergy;
	}
	public void setAllergy(String allergy) {
		this.allergy = allergy;
	}
	public char getNeuter() {
		return neuter;
	}
	public void setNeuter(char neuter) {
		this.neuter = neuter;
	}
	@Override
	public String toString() {
		return "Name : " + Name + " gender : " + gender + " Breed : " + Breed + " age : " + age + " kg : " + kg
				+ " allergy : " + allergy + " neuter : " + neuter;
	}

}
