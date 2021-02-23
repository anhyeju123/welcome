package Join;

import java.util.*;

public class ListInfo {
	Scanner sc = new Scanner(System.in);
		
		public void Join() {
			ArrayList<Info> jlist = new ArrayList<Info>();
			
	        System.out.println("정보를 입력하세요");
	        
	        Info IF = new Info();
	        
	        System.out.print("이름 : ");
	        IF.setName(sc.next());
	        System.out.print("강아지성별(M/F) : ");
	        IF.setGender(sc.next().charAt(0));
	        System.out.print("견종 : ");
	        IF.setBreed(sc.next());
	                  
	        IF.getAge();
	        
	        
	        
	        
	    }
		   
	    
	

}
