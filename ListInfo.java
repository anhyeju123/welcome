package Join;

import java.util.*;

public class ListInfo {
	Scanner sc = new Scanner(System.in);
		
		public void Join() {
			ArrayList<Info> jlist = new ArrayList<Info>();
			
	        System.out.println("������ �Է��ϼ���");
	        
	        Info IF = new Info();
	        
	        System.out.print("�̸� : ");
	        IF.setName(sc.next());
	        System.out.print("����������(M/F) : ");
	        IF.setGender(sc.next().charAt(0));
	        System.out.print("���� : ");
	        IF.setBreed(sc.next());
	                  
	        IF.getAge();
	        
	        
	        
	        
	    }
		   
	    
	

}
